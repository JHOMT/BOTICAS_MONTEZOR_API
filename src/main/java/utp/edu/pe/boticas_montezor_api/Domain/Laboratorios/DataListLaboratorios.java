package utp.edu.pe.boticas_montezor_api.Domain.Laboratorios;

public record DataListLaboratorios(
        Long id,
        String nombre,
        String direccion,
        String telefono,
        String correo
) {
    public DataListLaboratorios(Laboratorio laboratorio){
        this(
                laboratorio.getId(),
                laboratorio.getNombre(),
                laboratorio.getDireccion(),
                laboratorio.getTelefono(),
                laboratorio.getCorreo()
        );
    }
}
