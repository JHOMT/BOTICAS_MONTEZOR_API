package utp.edu.pe.boticas_montezor_api.Domain.ProductoPrincipioActivo;

public record DataListProductoPrincipioActivo(
    Long productoId,
    Long principioActivoId
) {
    public DataListProductoPrincipioActivo(DataRegisterProductoPrincipioActivo data) {
        this(
            data.productoId(),
            data.principioActivoId()
        );
    }
}
