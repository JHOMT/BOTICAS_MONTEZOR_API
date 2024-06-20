package utp.edu.pe.boticas_montezor_api.Domain.Productos;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.edu.pe.boticas_montezor_api.Domain.Distribuidoras.DistribuidoraRepository;
import utp.edu.pe.boticas_montezor_api.Domain.FormaFarmaceutica.FormaFarmaceuticaRepository;
import utp.edu.pe.boticas_montezor_api.Domain.GrupoFarmaceutico.GrupoFarmaceuticoRepository;
import utp.edu.pe.boticas_montezor_api.Domain.Laboratorios.LaboratorioRepository;
import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.PrincipioActivoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductosService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private GrupoFarmaceuticoRepository grupoFarmaceuticoRepository;

    public Boolean registrar(@NotNull DataRegisterProducto producto) {
        Optional<Producto> productoOptional = productoRepository.findByNombreAndLaboratorio(producto.nombre(), producto.laboratorioId());
        Producto productoNuevo = new Producto();
        if (productoOptional.isPresent()) {
            productoNuevo= productoOptional.get();
            productoNuevo.setCantidad(productoNuevo.getCantidad() + producto.cantidad());
        }else{
            productoNuevo = new Producto(producto);
        }
        productoRepository.save(productoNuevo);
        return true;
    }
    public Boolean update(@NotNull DataUpdateProducto producto) {
        Optional<Producto> productoOptional = Optional.ofNullable(productoRepository.findById(producto.id())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado")));
        productoRepository.save(new Producto(producto));
        return true;
    }
    public Boolean delete(@NotNull Long id) {
        Optional<Producto> productoOptional = Optional.ofNullable(productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado")));
        productoRepository.delete(productoOptional.get());
        return true;
    }
    public List<DataListProductos> listar() {
        return productoRepository.findAll().stream().map(DataListProductos::new).toList();
    }
    public List<DataListProductos> listarPorNombre(@NotNull String nombre) {
        return productoRepository.findByNombre(nombre).stream().map(DataListProductos::new).toList();
    }
    public List<DataListProductos> listarPorLaboratorio(@NotNull Long laboratorioId) {
        return productoRepository.findById(laboratorioId).stream().map(DataListProductos::new).toList();
    }
}
