package utp.edu.pe.boticas_montezor_api.Domain.DetalleFactura;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataListDetalleFactura {
    private Long id;
    private Long ventaId;
    private Long productoId;
    private String nombreProducto;
    private int cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal subtotal;

    public DataListDetalleFactura(DetalleFactura data) {
        this(
                data.getId(),
                data.getVenta().getId(),
                data.getProducto().getId(),
                data.getProducto().getNombre(),
                data.getCantidad(),
                data.getProducto().getPrecioVenta(),
                data.getSubtotal()
        );
    }
}
