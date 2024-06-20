package utp.edu.pe.boticas_montezor_api.Domain.ProductoPrincipioActivo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ProductoprincipioactivoId implements Serializable {
    private static final long serialVersionUID = -8270796146013827950L;

    @NotNull
    @Column(name = "Productoid", nullable = false)
    private Long productoID;

    @NotNull
    @Column(name = "PrincipioActivoID", nullable = false)
    private Long principioActivoID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductoprincipioactivoId entity = (ProductoprincipioactivoId) o;
        return Objects.equals(this.productoID, entity.productoID) &&
                Objects.equals(this.principioActivoID, entity.principioActivoID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productoID, principioActivoID);
    }
}