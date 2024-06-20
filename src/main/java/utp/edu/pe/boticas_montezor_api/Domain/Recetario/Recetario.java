package utp.edu.pe.boticas_montezor_api.Domain.Recetario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utp.edu.pe.boticas_montezor_api.Domain.Enfermedades.Enfermedad;
import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.PrincipioActivo;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Recetario")
public class Recetario {
    @EmbeddedId
    private RecetarioId id;

    @MapsId("recetaID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RecetaID", nullable = false)
    private PrincipioActivo principioActivo;

    @MapsId("productoID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ProductoID", nullable = false)
    private Enfermedad enfermedad;
}
