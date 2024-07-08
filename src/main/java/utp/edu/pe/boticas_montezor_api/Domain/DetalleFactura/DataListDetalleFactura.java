package utp.edu.pe.boticas_montezor_api.Domain.DetalleFactura;

import java.math.BigDecimal;

public record DataListDetalleFactura(
        Long id,
        Long ventaId,
        Long productoId,
        String nombreProducto,
        int cantidad,
        BigDecimal precioVenta,
        BigDecimal subtotal
) {
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
