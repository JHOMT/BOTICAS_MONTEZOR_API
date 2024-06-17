package utp.edu.pe.boticas_montezor_api.Domain.Roles;

import jakarta.validation.constraints.NotNull;

public record DataRegisterRol(
    @NotNull String name,
    @NotNull String description
) {
}
