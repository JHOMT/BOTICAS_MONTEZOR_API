package utp.edu.pe.boticas_montezor_api.Domain.ProductoFormaFarmaceutica;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ProductoFormaFarmaceuticaId implements Serializable {
    private static final long serialVersionUID = -8270796146013827950L;

    @NotNull
    @Column(name = "ProductoId", nullable = false)
    private Long productoId;

    @NotNull
    @Column(name = "FormaFarmaceuticaId", nullable = false)
    private Long formaFarmaceuticaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoFormaFarmaceuticaId that = (ProductoFormaFarmaceuticaId) o;
        return Objects.equals(productoId, that.productoId) && Objects.equals(formaFarmaceuticaId, that.formaFarmaceuticaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoId, formaFarmaceuticaId);
    }
}