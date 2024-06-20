package utp.edu.pe.boticas_montezor_api.Domain.ProductoPrincipioActivo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.PrincipioActivo;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.Producto;

@Getter
@Setter
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
    @JoinColumn(name = "PrincipioActivoID", nullable = false)
    private PrincipioActivo principioActivoID;
}