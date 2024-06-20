package utp.edu.pe.boticas_montezor_api.Domain.Distribuidoras;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Distribuidoras")
public class Distribuidora {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DistribuidoraID")
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Direccion")
    private String direccion;

    @Column(name = "Telefono")
    private String telefono;

    @Column(name = "Correo")
    private String correo;

    public Distribuidora(DataRegisterDistribuidora data) {
        this.nombre = data.nombre();
        this.direccion = data.direccion();
        this.telefono = data.telefono();
        this.correo = data.correo();
    }
    public  Distribuidora(DataUpdateDistribuidora data) {
        this.id = data.id();
        if (data.nombre() != null) this.nombre = data.nombre();
        if (data.direccion() != null) this.direccion = data.direccion();
        if (data.telefono() != null) this.telefono = data.telefono();
        if (data.correo() != null) this.correo = data.correo();
    }
    public Distribuidora(Long id) {
        this.id = id;
    }
}
