package utp.edu.pe.boticas_montezor_api.Domain.Distribuidoras;

public record DataListDistribuidora(
        Long id,
        String nombre,
        String direccion,
        String telefono,
        String correo
) {
    public DataListDistribuidora (Distribuidora data) {
        this(
            data.getId(),
            data.getNombre(),
            data.getDireccion(),
            data.getTelefono(),
            data.getCorreo()
        );
    }
}
