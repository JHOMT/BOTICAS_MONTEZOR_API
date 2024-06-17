package utp.edu.pe.boticas_montezor_api.Domain.ProductoFormaFarmaceutica;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productoid")
    private Producto producto;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formafarmaceuticaid")
    private FormaFarmaceutica formaFarmaceutica;

    public ProductoFormaFarmaceutica(DataRegisterProductoFormaFarmaceutica data) {
        this(
            new Producto(data.productoId()),
            new FormaFarmaceutica(data.formaFarmaceuticaId())
        );
    }
}
