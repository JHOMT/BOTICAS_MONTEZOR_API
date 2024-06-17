package utp.edu.pe.boticas_montezor_api.Domain.FormaFarmaceutica;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "formasfarmaceuticas")
public class FormaFarmaceutica {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "formasfarmaceuticasid")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    public FormaFarmaceutica(DataRegisterFormaFarmaceutica data){
        this(
                null,
                data.nombre()
        );
    }

    public FormaFarmaceutica(Long id) {
        this.id = id;
    }
}
