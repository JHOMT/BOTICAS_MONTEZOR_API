package utp.edu.pe.boticas_montezor_api.Domain.Enfermedades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enfermedades")
public class Enfermedad {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enfermedadid")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    public Enfermedad(DataRegisterEnfermedad data){
        this(
            null,
            data.nombre(),
            data.descripcion()
        );
    }
    public Enfermedad(DataUpdateEnfermedad data){
        this.id = data.id();
        if (data.nombre() != null) this.nombre= data.nombre();
        if (data.descripcion() != null) this.nombre = data.descripcion();
    }

}
