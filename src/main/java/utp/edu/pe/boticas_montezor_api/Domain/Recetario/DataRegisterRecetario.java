package utp.edu.pe.boticas_montezor_api.Domain.Recetario;

import jakarta.validation.constraints.NotNull;

public record DataRegisterRecetario(
    @NotNull String principioActivo,
    @NotNull String enfermedad
) {
}
