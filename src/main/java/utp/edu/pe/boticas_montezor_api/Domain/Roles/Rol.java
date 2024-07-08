package utp.edu.pe.boticas_montezor_api.Domain.Roles;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Roles")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RolID")
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    public Rol(Long id) {
        this.id = id;
    }
    public Rol(DataRegisterRol data){
        this.nombre = data.name();
    }
    public Rol(DataUpdateRol data){
        this.id = data.id();
        if (data.name() != null) this.nombre = data.name();
    }
}
