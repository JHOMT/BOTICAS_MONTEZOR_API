package utp.edu.pe.boticas_montezor_api.Domain.Distribuidoras;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "distribuidoras")
public class Distribuidora {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "distribuidoraid")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private String correo;

    public Distribuidora(DataRegisterDistribuidora data) {
        this.nombre = data.nombre();
        this.direccion = data.direccion();
        this.telefono = data.telefono();
        this.correo = data.correo();
    }

    public Distribuidora(Long id) {
        this.id = id;
    }
}
