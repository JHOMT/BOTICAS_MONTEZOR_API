package utp.edu.pe.boticas_montezor_api.Infra.security;

import utp.edu.pe.boticas_montezor_api.Domain.Empleados.DataListEmpleado;

public record DataResponseOtp(
        DataListEmpleado empleado,
        String token
) {
}
