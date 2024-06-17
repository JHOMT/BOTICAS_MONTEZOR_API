package utp.edu.pe.boticas_montezor_api.Domain.Empleados;

import jakarta.validation.constraints.NotNull;

public record DataRegisterEmpleado (
    @NotNull Long adminId,
    @NotNull String nombres,
    @NotNull String dni,
    @NotNull String correo,
    @NotNull String telefono,
    @NotNull Long rol,
    @NotNull String password
) {
}
