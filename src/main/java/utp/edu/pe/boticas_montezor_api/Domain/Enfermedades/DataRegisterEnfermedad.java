package utp.edu.pe.boticas_montezor_api.Domain.Enfermedades;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record DataRegisterEnfermedad(
        @NotNull String nombre,
        @NotNull String descripcion
) {
}
