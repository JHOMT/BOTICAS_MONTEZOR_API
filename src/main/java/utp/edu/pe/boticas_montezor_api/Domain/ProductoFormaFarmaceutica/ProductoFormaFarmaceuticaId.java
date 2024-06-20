package utp.edu.pe.boticas_montezor_api.Domain.ProductoFormaFarmaceutica;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ProductoFormaFarmaceuticaId implements Serializable {
    private static final long serialVersionUID = -8270796146013827950L;

    @NotNull
    @Column(name = "Productoid", nullable = false)
    private Long productoid;

    @NotNull
    @Column(name = "Formafarmaceuticaid", nullable = false)
    private Long formafarmaceuticaid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoFormaFarmaceuticaId that = (ProductoFormaFarmaceuticaId) o;
        return Objects.equals(productoid, that.productoid) && Objects.equals(formafarmaceuticaid, that.formafarmaceuticaid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoid, formafarmaceuticaid);
    }
}