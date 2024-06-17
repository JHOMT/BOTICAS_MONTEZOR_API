package utp.edu.pe.boticas_montezor_api.Domain.Empleados;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utp.edu.pe.boticas_montezor_api.Domain.Roles.Rol;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empleadoid")
    private Long id;

    @Column(name = "Nombres")
    private String nombres;

    @Column(name = "correoelectronico")
    private String correo;

    @Column(name = "telefono")
    private String telefono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rolid", referencedColumnName = "RolId")
    private Rol rol;

    public Empleado(DataRegisterEmpleado data) {
        this.nombres = data.nombres();
        this.correo = data.correo();
        this.telefono = data.telefono();
        this.rol = new Rol(data.rol());
    }

    public Empleado(Long id) {
        this.id = id;
    }
}
