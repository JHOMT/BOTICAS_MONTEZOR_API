package utp.edu.pe.boticas_montezor_api.Domain.DetalleFactura;

import java.math.BigDecimal;

public record DataListDetalleFactura(
        Long id,
        Long ventaId,
        Long productoId,
        int cantidad,
        BigDecimal precio,
        BigDecimal subtotal
) {
    public DataListDetalleFactura(DetalleFactura data) {
        this(
                data.getId(),
                data.getVenta().getId(),
                data.getProducto().getId(),
                data.getCantidad(),
                data.getPrecio(),
                data.getSubtotal()
        );
    }
}
