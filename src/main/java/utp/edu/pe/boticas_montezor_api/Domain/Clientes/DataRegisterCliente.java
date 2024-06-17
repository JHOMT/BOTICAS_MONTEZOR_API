package utp.edu.pe.boticas_montezor_api.Domain.Clientes;

import jakarta.validation.constraints.NotNull;

public record DataRegisterCliente(
    @NotNull String nombres,
    String dni,
    String ruc
) {
}
