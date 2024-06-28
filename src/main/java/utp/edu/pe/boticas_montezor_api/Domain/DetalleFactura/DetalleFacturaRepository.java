package utp.edu.pe.boticas_montezor_api.Domain.DetalleFactura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.DataListProductos;

import java.util.List;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Long> {
    @Query("""
            SELECT new utp.edu.pe.boticas_montezor_api.Domain.Productos.DataListProductos(
                p.id,
                p.nombre,
                p.descripcion,
                p.precioCompra,
                p.precioVenta,
                p.grupoFaramaceutico.id,
                p.grupoFaramaceutico.nombre,
                p.laboratorio.id,
                p.laboratorio.nombre,
                p.distribuidora.id,
                p.distribuidora.nombre,
                p.fechaVencimiento,
                d.cantidad,
                p.lote,
                p.concentracion
            )
            FROM DetalleFactura d
            JOIN d.producto p
            WHERE d.venta.id = :id
    """)
    List<DataListProductos> findAllByVenta(Long id);
}
