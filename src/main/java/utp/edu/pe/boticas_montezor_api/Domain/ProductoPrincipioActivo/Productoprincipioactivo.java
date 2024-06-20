package utp.edu.pe.boticas_montezor_api.Domain.ProductoPrincipioActivo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.PrincipioActivo;
import utp.edu.pe.boticas_montezor_api.Domain.ProductoPrincipioActivo.ProductoprincipioactivoId;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.Producto;

@Getter
@Setter
@Entity
@Table(name = "productoprincipioactivo")
public class Productoprincipioactivo {
    @EmbeddedId
    private ProductoprincipioactivoId id;

    @MapsId("Productoid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "Productoid", nullable = false)
    private Producto productoID;

    @MapsId("PrincipioActivoID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PrincipioActivoID", nullable = false)
    private PrincipioActivo principioActivoID;

}