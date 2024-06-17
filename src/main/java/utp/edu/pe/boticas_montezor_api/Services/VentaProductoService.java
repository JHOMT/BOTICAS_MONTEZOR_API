package utp.edu.pe.boticas_montezor_api.Services;

import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.edu.pe.boticas_montezor_api.Domain.Clientes.Cliente;
import utp.edu.pe.boticas_montezor_api.Domain.Clientes.ClienteRepository;
import utp.edu.pe.boticas_montezor_api.Domain.DetalleFactura.DataRegisterDetalleFactura;
import utp.edu.pe.boticas_montezor_api.Domain.DetalleFactura.DetalleFactura;
import utp.edu.pe.boticas_montezor_api.Domain.DetalleFactura.DetalleFacturaRepository;
import utp.edu.pe.boticas_montezor_api.Domain.Empleados.Empleado;
import utp.edu.pe.boticas_montezor_api.Domain.Empleados.EmpleadoRepository;
import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.PrincipioActivoRepository;
import utp.edu.pe.boticas_montezor_api.Domain.ProductoFormaFarmaceutica.ProductoFormaFarmaceuticaRepository;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.DataListProductos;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.Producto;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.ProductoRepository;
import utp.edu.pe.boticas_montezor_api.Domain.Ventas.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.el.lang.ELArithmetic.multiply;

@Service
public class VentaProductoService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private VentasRepository ventasRepository;
    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private PrincipioActivoRepository principioActivoRepository;
    @Autowired
    private ProductoFormaFarmaceuticaRepository productoFormaFarmaceuticaRepository;

    @Transactional
    public Venta registrarVenta(@NotNull DataRegisterVenta dataVenta, @NotNull List<DataRegisterDetalleFactura> detalles) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(dataVenta.clienteID());
        Empleado empleado = empleadoRepository.findById(dataVenta.empleadoID())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        Cliente cliente;
        if (clienteOptional.isEmpty()) {
            cliente = new Cliente();
            clienteRepository.save(cliente);
            cliente = clienteRepository.findByDniOrRuc(dataVenta.clienteID())
                    .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        } else {
            cliente = clienteOptional.get();
        }

        Venta venta = new Venta(dataVenta);
        venta = ventasRepository.save(venta);

        List<Long> productoIds = detalles.stream().map(DataRegisterDetalleFactura::productoId).collect(Collectors.toList());
        List<Producto> productos = productoRepository.findAllById(productoIds);
        Map<Long, Producto> productoMap = productos.stream().collect(Collectors.toMap(Producto::getId, producto -> producto));

        BigDecimal montoTotal = BigDecimal.ZERO;
        List<DetalleFactura> detallesFactura = new ArrayList<>();

        for (DataRegisterDetalleFactura detalleDto : detalles) {
            Producto producto = productoMap.get(detalleDto.productoId());
            if (producto == null) {
                throw new RuntimeException("Producto no encontrado: " + detalleDto.productoId());
            }

            if (producto.getCantidad() < detalleDto.cantidad()) {
                throw new RuntimeException("Cantidad insuficiente para el producto: " + producto.getNombre());
            }

            producto.setCantidad(producto.getCantidad() - detalleDto.cantidad());

            BigDecimal subtotal = producto.getPrecioVenta().multiply(BigDecimal.valueOf(detalleDto.cantidad()));
            DetalleFactura detalle = new DetalleFactura();
            detalle.setVenta(venta);
            detalle.setProducto(producto);
            detalle.setCantidad(detalleDto.cantidad());
            detalle.setPrecio(producto.getPrecioVenta());
            detalle.setSubtotal(subtotal);

            montoTotal = montoTotal.add(subtotal);
            detallesFactura.add(detalle);
        }

        if (dataVenta.tipoFactura() == TipoFactura.FACTURA) {
            BigDecimal igv = montoTotal.multiply(BigDecimal.valueOf(0.18));
            montoTotal = montoTotal.add(igv);
        }
        venta.setTotal(montoTotal);
        detalleFacturaRepository.saveAll(detallesFactura);
        ventasRepository.save(venta);
        productoRepository.saveAll(productos);

        return venta;
    }

    public List<Venta> listarVentas() {
        return ventasRepository.findAll();
    }

    public List<DataListProductos> listarVentasConDetalle(Long idVenta) {
        Venta venta = ventasRepository.findById(idVenta)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));
        List<DataListProductos> detalles = detalleFacturaRepository.findAllByVenta(venta.getId());
        return detalles;
    }
}
