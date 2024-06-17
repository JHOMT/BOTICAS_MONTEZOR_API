package utp.edu.pe.boticas_montezor_api.Domain.Roles;

import jakarta.validation.constraints.NotNull;

public record DataUpdateRol(
    @NotNull Long id,
    String name
) {
}
