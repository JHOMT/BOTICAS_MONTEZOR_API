package utp.edu.pe.boticas_montezor_api.Domain.Enfermedades;

public record DataListEnfermedad(
    Long id,
    String nombre,
    String descripcion
) {
    public DataListEnfermedad (Enfermedad enfermedad){
        this(
            enfermedad.getId(),
            enfermedad.getNombre(),
            enfermedad.getDescripcion()
        );
    }
}
