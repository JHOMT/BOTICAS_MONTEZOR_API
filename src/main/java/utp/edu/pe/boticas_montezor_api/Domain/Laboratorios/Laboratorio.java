package utp.edu.pe.boticas_montezor_api.Domain.Laboratorios;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "laboratorios")
public class Laboratorio {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "laboratorioid")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private String correo;

    public Laboratorio(DataRegisterLaboratorio data){
        this(
                null,
                data.nombre(),
                data.direccion(),
                data.telefono(),
                data.correo()
        );
    }
    public Laboratorio(DataUpdateLaboratorio data){
        this.id = data.id();
        if (data.nombre() != null) this.nombre = data.nombre();
        if (data.direccion() != null) this.direccion = data.direccion();
        if (data.telefono() != null) this.telefono = data.telefono();
        if (data.correo() != null) this.correo = data.correo();
    }

    public Laboratorio(Long id) {
        this.id = id;
    }
}
