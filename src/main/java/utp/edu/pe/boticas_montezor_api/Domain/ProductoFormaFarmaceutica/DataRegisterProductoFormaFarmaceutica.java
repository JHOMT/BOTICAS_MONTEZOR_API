package utp.edu.pe.boticas_montezor_api.Domain.ProductoFormaFarmaceutica;

import jakarta.validation.constraints.NotNull;

public record DataRegisterProductoFormaFarmaceutica(
    @NotNull Long productoId,
    @NotNull Long formaFarmaceuticaId
) {
}
