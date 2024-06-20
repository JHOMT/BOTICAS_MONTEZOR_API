package utp.edu.pe.boticas_montezor_api.Domain.Productos;

import utp.edu.pe.boticas_montezor_api.Domain.DetalleFactura.DetalleFactura;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DataListProductos (
        Long id,
        String nombre,
        String descripcion,
        Double precioCompra,
        BigDecimal precioVenta,
        Long grupoFarmaceuticoId,
        Long laboratorioId,
        Long distribuidoraId,
        LocalDate fechaVencimiento,
        Integer cantidad,
        String lote,
        String concentracion
) {
    public DataListProductos(Producto data){
        this(
                data.getId(),
                data.getNombre(),
                data.getDescripcion(),
                data.getPrecioCompra(),
                data.getPrecioVenta(),
                data.getGrupoFaramaceutico().getId(),
                data.getLaboratorio().getId(),
                data.getDistribuidora().getId(),
                data.getFechaVencimiento(),
                data.getCantidad(),
                data.getLote(),
                data.getConcentracion()
        );
    }

}
