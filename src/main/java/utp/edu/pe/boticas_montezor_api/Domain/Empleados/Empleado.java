package utp.edu.pe.boticas_montezor_api.Domain.Empleados;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utp.edu.pe.boticas_montezor_api.Domain.Roles.Rol;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmpleadoID")
    private Long id;

    @Column(name = "Nombres")
    private String nombres;

    @Column(name = "Correoelectronico")
    private String correo;

    @Column(name = "Telefono")
    private String telefono;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rolid", referencedColumnName = "RolId")
    private Rol rol;

    @Column(name = "Contraseña")
    private String contraseña;

    public Empleado(DataRegisterEmpleado data) {
        this.nombres = data.nombres();
        this.correo = data.correo();
        this.telefono = data.telefono();
        this.rol = new Rol(data.rol());
        this.contraseña = data.password();
    }

    public Empleado(Long id) {
        this.id = id;
    }
}
