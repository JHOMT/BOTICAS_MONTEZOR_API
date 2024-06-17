package utp.edu.pe.boticas_montezor_api.Domain.Clientes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cclientesid")
    private Long id;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "DNI")
    private String dni;

    @Column(name = "RUC")
    private String ruc;

    public Cliente(DataRegisterCliente data){
        this.nombres = data.nombres();
        this.dni = data.dni();
        this.ruc = data.ruc();
    }

    public Cliente(Long id) {
        this.id = id;
    }
}
