package utp.edu.pe.boticas_montezor_api.Domain.Clientes;

import jakarta.validation.constraints.NotNull;

public record DataUpdateCliente(
    @NotNull Long id,
    String nombre,
    String dni,
    String ruc
) {
}
