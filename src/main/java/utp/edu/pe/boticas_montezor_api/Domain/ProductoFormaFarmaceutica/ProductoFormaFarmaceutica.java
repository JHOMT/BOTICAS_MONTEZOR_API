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
    @EmbeddedId
    private ProductoFormaFarmaceuticaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productoId")
    @JoinColumn(name = "ProductoId", nullable = false)
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("formaFarmaceuticaId")
    @JoinColumn(name = "FormaFarmaceuticaId", nullable = false)
    private FormaFarmaceutica formaFarmaceutica;

    public ProductoFormaFarmaceutica(DataRegisterProductoFormaFarmaceutica data) {
        this(
                null,
                new Producto(data.productoId()),
                new FormaFarmaceutica(data.formaFarmaceuticaId())
        );
    }
}