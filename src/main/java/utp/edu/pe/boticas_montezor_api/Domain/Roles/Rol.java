package utp.edu.pe.boticas_montezor_api.Domain.Roles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ROLES")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLID")
    private Long id;

    @Column(name = "NOMBRE")
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
