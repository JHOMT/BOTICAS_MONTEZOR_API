package utp.edu.pe.boticas_montezor_api.Domain.Laboratorios;

import jakarta.validation.constraints.NotNull;

public record DataUpdateLaboratorio (
        @NotNull Long id,
        String nombre,
        String direccion,
        String telefono,
        String correo
) {
}
