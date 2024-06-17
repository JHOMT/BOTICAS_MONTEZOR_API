package utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRINCPIOSACTIVOS")
public class PrincipioActivo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRINCIPIOACTIVOID")
    private Long Id;

    @Column(name = "NOMBRE")
    private String Nombre;

    public PrincipioActivo(DataRegisterPrincipioActivo data) {
        this.Nombre = data.nombre();
    }

    public PrincipioActivo(Long id) {
        this.Id = id;
    }
}
