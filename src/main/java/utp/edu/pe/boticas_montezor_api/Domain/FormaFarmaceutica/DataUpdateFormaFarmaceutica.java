package utp.edu.pe.boticas_montezor_api.Domain.FormaFarmaceutica;

import jakarta.validation.constraints.NotNull;

public record DataUpdateFormaFarmaceutica(
    @NotNull Long id,
    String nombre
) {
}
