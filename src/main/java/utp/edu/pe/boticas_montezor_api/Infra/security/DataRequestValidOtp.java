package utp.edu.pe.boticas_montezor_api.Infra.security;

public record DataRequestValidOtp(
        String email,
        String password,
        int otp
) {
}
