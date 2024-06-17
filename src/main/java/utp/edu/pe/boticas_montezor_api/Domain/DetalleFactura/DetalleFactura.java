package utp.edu.pe.boticas_montezor_api.Domain.DetalleFactura;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.Producto;
import utp.edu.pe.boticas_montezor_api.Domain.Ventas.Venta;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "detallefactura")
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DetalleFacturaID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VentaID")
    private Venta venta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductoID")
    private Producto producto;

    @Column(name = "Cantidad")
    private int cantidad;

    @Column(name = "Precio")
    private BigDecimal precio;

    @Column(name = "Subtotal")
    private BigDecimal subtotal;

    public DetalleFactura(DataRegisterDetalleFactura data) {
        this(
                null,
                null,
                new Producto(data.productoId()),
                data.cantidad(),
                new BigDecimal(0),
                BigDecimal.valueOf(data.subtotal())
        );
    }

}

