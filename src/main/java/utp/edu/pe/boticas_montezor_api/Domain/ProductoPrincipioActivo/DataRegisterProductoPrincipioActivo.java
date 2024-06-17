package utp.edu.pe.boticas_montezor_api.Domain.ProductoPrincipioActivo;

import jakarta.validation.constraints.NotNull;

public record DataRegisterProductoPrincipioActivo(
    @NotNull Long productoId,
    @NotNull Long principioActivoId
) {
}
