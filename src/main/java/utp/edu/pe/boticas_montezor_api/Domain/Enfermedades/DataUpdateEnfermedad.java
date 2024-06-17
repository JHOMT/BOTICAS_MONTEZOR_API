package utp.edu.pe.boticas_montezor_api.Domain.Enfermedades;

import jakarta.validation.constraints.NotNull;

public record DataUpdateEnfermedad(
        @NotNull Long id,
        String nombre,
        String descripcion
) {
}
