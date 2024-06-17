package utp.edu.pe.boticas_montezor_api.Domain.Empleados;

public record DataListEmpleado(
    Long id,
    String nombres,
    String correo,
    String telefono,
    String rol
) {
    public DataListEmpleado(Empleado empleado) {
        this(
            empleado.getId(),
            empleado.getNombres(),
            empleado.getCorreo(),
            empleado.getTelefono(),
            empleado.getRol().getNombre()
        );
    }
}
