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
    @Column(name = "detallerfacturaid")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ventaid")
    private Venta venta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productoid")
    private Producto producto;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "subtotal")
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

