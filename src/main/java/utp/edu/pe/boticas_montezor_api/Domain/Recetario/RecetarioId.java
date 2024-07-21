package utp.edu.pe.boticas_montezor_api.Domain.Recetario;

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
public class RecetarioId implements Serializable {
    private static final long serialVersionUID = -8270796146013827950L;

    @NotNull
    @Column(name = "principioactivoId", nullable = false)
    private Long principioId;

    @NotNull
    @Column(name = "EnfermedadID", nullable = false)
    private Long enfermedadId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecetarioId that = (RecetarioId) o;
        return Objects.equals(principioId, that.principioId) && Objects.equals(enfermedadId, that.enfermedadId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(principioId, enfermedadId);
    }
}