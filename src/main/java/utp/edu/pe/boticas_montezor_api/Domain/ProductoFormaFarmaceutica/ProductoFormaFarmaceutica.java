package utp.edu.pe.boticas_montezor_api.Domain.ProductoFormaFarmaceutica;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utp.edu.pe.boticas_montezor_api.Domain.FormaFarmaceutica.FormaFarmaceutica;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.Producto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productoformafarmaceutica")
public class ProductoFormaFarmaceutica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productoID")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "formaFarmaceuticaID")
    private FormaFarmaceutica formaFarmaceutica;

    public ProductoFormaFarmaceutica(DataRegisterProductoFormaFarmaceutica data) {
        this(
            null,
            new Producto(data.productoId()),
            new FormaFarmaceutica(data.formaFarmaceuticaId())
        );
    }
}
