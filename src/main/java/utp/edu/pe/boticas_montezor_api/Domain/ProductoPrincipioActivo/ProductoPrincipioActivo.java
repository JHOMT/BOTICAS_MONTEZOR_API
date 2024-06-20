package utp.edu.pe.boticas_montezor_api.Domain.ProductoPrincipioActivo;

import jakarta.persistence.*;
import lombok.*;
import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.PrincipioActivo;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.Producto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productoprincipioactivo")
public class ProductoPrincipioActivo {
    @EmbeddedId
    private ProductoprincipioactivoId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productoID")
    @JoinColumn(name = "Productoid", nullable = false)
    private Producto productoID;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("principioActivoID")
    @JoinColumn(name = "PrincipioactivoID", nullable = false)
    private PrincipioActivo principioActivoID;

    public ProductoPrincipioActivo(Producto productoGuardado, PrincipioActivo principioActivo) {
        this.productoID = productoGuardado;
        this.principioActivoID = principioActivo;
        this.id = new ProductoprincipioactivoId(productoGuardado.getId(), principioActivo.getId());
    }
}