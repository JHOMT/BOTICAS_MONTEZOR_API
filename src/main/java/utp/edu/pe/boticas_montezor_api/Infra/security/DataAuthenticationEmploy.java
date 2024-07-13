package utp.edu.pe.boticas_montezor_api.Infra.security;

import jakarta.validation.constraints.NotNull;

public record DataAuthenticationEmploy(
        @NotNull String email,
        @NotNull String password
) {
}
