package utp.edu.pe.boticas_montezor_api.Domain.Distribuidoras;

public record DataUpdateDistribuidora(
        Long id,
        String nombre,
        String direccion,
        String telefono,
        String correo
) {
}
