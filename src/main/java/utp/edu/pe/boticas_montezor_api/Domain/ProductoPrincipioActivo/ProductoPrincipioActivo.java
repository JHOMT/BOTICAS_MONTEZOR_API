package utp.edu.pe.boticas_montezor_api.Domain.ProductoPrincipioActivo;


import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utp.edu.pe.boticas_montezor_api.Domain.FormaFarmaceutica.FormaFarmaceutica;
import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.PrincipioActivo;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.Producto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productoprinicipioactivo")
public class ProductoPrincipioActivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productoID")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "principioActivoID")
    private PrincipioActivo principioActivo;

}
