package utp.edu.pe.boticas_montezor_api.Domain.Clientes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Clientes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Clienteid")
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
    public Cliente (DataUpdateCliente data){
        this.id = data.id();
        if (data.nombre() != null) this.nombres = data.nombre();
        if (data.ruc() != null) this.nombres = data.ruc();
        if (data.dni() != null) this.dni = data.dni();
    }
    public Cliente(Long id) {
        this.id = id;
    }
}
