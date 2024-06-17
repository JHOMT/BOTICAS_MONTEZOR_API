package utp.edu.pe.boticas_montezor_api.Domain.ProductoFormaFarmaceutica;

public record DataListProductoFormaFarmaceutica (
    Long productoId,
    Long formaFarmaceuticaId
) {
    public DataListProductoFormaFarmaceutica (ProductoFormaFarmaceutica data) {
        this(
            data.getProducto().getId(),
            data.getFormaFarmaceutica().getId()
        );
    }
}
