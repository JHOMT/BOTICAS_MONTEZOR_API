package utp.edu.pe.boticas_montezor_api.Domain.FormaFarmaceutica;

import jakarta.validation.constraints.NotNull;

public record DataRegisterFormaFarmaceutica(
        @NotNull String nombre
) {
}
