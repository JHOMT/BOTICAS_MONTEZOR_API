package utp.edu.pe.boticas_montezor_api.Domain.Empleados;

import jakarta.validation.constraints.NotNull;

public record DataLoginEmpleado(
        @NotNull String usuario,
        @NotNull String password
) {
}
