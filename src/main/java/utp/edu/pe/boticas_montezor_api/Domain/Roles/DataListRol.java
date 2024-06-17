package utp.edu.pe.boticas_montezor_api.Domain.Roles;

public record DataListRol(
    Long id,
    String name
) {
    public DataListRol (Rol rol) {
        this(
            rol.getId(),
            rol.getNombre()
        );
    }
}
