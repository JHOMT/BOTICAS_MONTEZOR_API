package utp.edu.pe.boticas_montezor_api.Domain.DetalleFactura;

import jakarta.validation.constraints.NotNull;

public record DataRegisterDetalleFactura (
        @NotNull Long productoId,
        @NotNull int cantidad,
        @NotNull double subtotal
) {

}
