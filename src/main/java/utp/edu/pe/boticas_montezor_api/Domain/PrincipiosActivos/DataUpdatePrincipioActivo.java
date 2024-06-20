package utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos;

import jakarta.validation.constraints.NotNull;

public record DataUpdatePrincipioActivo(
        @NotNull Long id,
    String nombre
) {
}
