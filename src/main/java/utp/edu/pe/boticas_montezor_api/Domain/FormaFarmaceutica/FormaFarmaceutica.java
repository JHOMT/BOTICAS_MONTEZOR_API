package utp.edu.pe.boticas_montezor_api.Domain.FormaFarmaceutica;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utp.edu.pe.boticas_montezor_api.Domain.ProductoFormaFarmaceutica.ProductoFormaFarmaceutica;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Formasfarmaceuticas")
public class FormaFarmaceutica {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FormafarmaceuticaID")
    private Long id;

    @Column(name = "Nombre")
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

    public FormaFarmaceutica(DataUpdateFormaFarmaceutica data) {
        this.id = data.id();
        if (data.nombre() != null) this.nombre = data.nombre();
    }
}
