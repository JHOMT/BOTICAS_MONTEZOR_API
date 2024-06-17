package utp.edu.pe.boticas_montezor_api.Domain.ProductoPrincipioActivo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.PrincipioActivo;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.Producto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTOPRINCIPIOACTIVO")
public class ProductoPrincipioActivo {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCTOID")
    private Producto producto;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRINCIPIOACTIVOID")
    private PrincipioActivo principioActivo;

    public ProductoPrincipioActivo(DataRegisterProductoPrincipioActivo data) {
        this(
            new Producto(data.productoId()),
            new PrincipioActivo(data.principioActivoId())
        );
    }
}
