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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("principioId")
    @JoinColumn(name = "principioactivoid", nullable = false)
    private PrincipioActivo principioActivo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("enfermedadId")
    @JoinColumn(name = "enfermedadid", nullable = false)
    private Enfermedad enfermedad;
}