package utp.edu.pe.boticas_montezor_api.Domain.Productos;

import java.time.LocalDate;

public record DataRegisterProducto(
    String nombre,
    String descripcion,
    Double precioCompra,
    Double precioVenta,
    Long grupoFarmaceuticoId,
    Long laboratorioId,
    Long distribuidoraId,
    LocalDate fechaVencimiento,
    Integer cantidad,
    String lote,
    String concentracion
) {
}
