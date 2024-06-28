package utp.edu.pe.boticas_montezor_api.Domain.Productos;

import utp.edu.pe.boticas_montezor_api.Domain.DetalleFactura.DetalleFactura;
import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.PrincipioActivo;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DataListProductos (
        Long id,
        String nombre,
        String descripcion,
        Double precioCompra,
        BigDecimal precioVenta,
        Long grupoFarmaceuticoId,
        String grupoFarmaceuticoNombre,
        Long laboratorioId,
        String laboratorioNombre,
        Long distribuidoraId,
        String distribuidoraNombre,
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
                data.getGrupoFaramaceutico().getNombre(),
                data.getLaboratorio().getId(),
                data.getLaboratorio().getNombre(),
                data.getDistribuidora().getId(),
                data.getDistribuidora().getNombre(),
                data.getFechaVencimiento(),
                data.getCantidad(),
                data.getLote(),
                data.getConcentracion()
        );
    }
}
