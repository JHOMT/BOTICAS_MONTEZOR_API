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
@Table(name = "recetario")
public class Recetario {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "principioActivoid")
    private PrincipioActivo principioActivo;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "enfermedadid")
    private Enfermedad enfermedad;
}
