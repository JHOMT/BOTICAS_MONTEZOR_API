package utp.edu.pe.boticas_montezor_api.Domain.Recetario;

public record DataListRecetario(
    Long principioActivoId,
    String principioActivo,
    Long enfermedadId,
    String enfermedad
) {
    public DataListRecetario ( Recetario recetario) {
        this(
            recetario.getPrincipioActivo().getId(),
            recetario.getPrincipioActivo().getNombre(),
            recetario.getEnfermedad().getId(),
            recetario.getEnfermedad().getNombre()
        );
    }
}
