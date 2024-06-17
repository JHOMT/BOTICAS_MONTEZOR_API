package utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos;

public record DataListPrincipioActivo(
    Long Id,
    String Nombre
) {
    public DataListPrincipioActivo(PrincipioActivo data) {
        this(
            data.getId(),
            data.getNombre()
        );
    }
}
