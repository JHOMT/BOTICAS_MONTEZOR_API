package utp.edu.pe.boticas_montezor_api.Domain.GrupoFarmaceutico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "GRUPOSFARMACEUTICOS")
public class GrupoFarmaceutico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GrupoFarmaceuticoID")
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    public GrupoFarmaceutico(Long id) {
        this.id = id;
    }
}
