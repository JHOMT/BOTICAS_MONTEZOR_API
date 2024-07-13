package utp.edu.pe.boticas_montezor_api.Domain.Empleados;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import utp.edu.pe.boticas_montezor_api.Domain.Roles.Rol;

import java.util.Collection;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Empleados")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@EqualsAndHashCode(of = "id")
public class Empleado implements UserDetails {

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

    @Column(name = "active")
    private boolean active;

    @Column(name = "otp")
    private Integer otp;

    public Empleado(DataRegisterEmpleado data) {
        this.nombres = data.nombres();
        this.correo = data.correo();
        this.telefono = data.telefono();
        this.rol = new Rol(data.rol()); // Aquí deberías asignar el Rol existente, no crear uno nuevo
        this.contraseña = data.password();
        this.active = false;
    }

    public Empleado(Long id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE-USER"));
    }

    @Override
    public String getPassword() {
        return contraseña; // Corregido para devolver la contraseña almacenada
    }

    @Override
    public String getUsername() {
        return correo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
