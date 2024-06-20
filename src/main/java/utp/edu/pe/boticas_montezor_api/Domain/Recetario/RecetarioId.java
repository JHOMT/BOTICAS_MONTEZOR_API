package utp.edu.pe.boticas_montezor_api.Domain.Recetario;

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
public class RecetarioId implements Serializable {
    private static final long serialVersionUID = -8270796146013827950L;

    @NotNull
    @Column(name = "RecetaID", nullable = false)
    private Long recetaID;

    @NotNull
    @Column(name = "ProductoID", nullable = false)
    private Long productoID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecetarioId that = (RecetarioId) o;
        return Objects.equals(recetaID, that.recetaID) && Objects.equals(productoID, that.productoID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recetaID, productoID);
    }
}