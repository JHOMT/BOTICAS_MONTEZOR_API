package utp.edu.pe.boticas_montezor_api.Domain.GrupoFarmaceutico;

import jakarta.validation.constraints.NotNull;

public record DataRegisterGrupoFarmaceutico(
        @NotNull String nombre
) {
}
