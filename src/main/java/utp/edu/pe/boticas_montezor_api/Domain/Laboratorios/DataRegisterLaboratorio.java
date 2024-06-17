package utp.edu.pe.boticas_montezor_api.Domain.Laboratorios;

import jakarta.validation.constraints.NotNull;

public record DataRegisterLaboratorio(
        @NotNull String nombre,
        @NotNull String direccion,
        @NotNull String telefono,
        @NotNull String correo
) {
}
