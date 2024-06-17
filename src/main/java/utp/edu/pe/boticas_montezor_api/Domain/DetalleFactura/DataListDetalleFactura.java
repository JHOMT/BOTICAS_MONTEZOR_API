package utp.edu.pe.boticas_montezor_api.Domain.DetalleFactura;

public record DataListDetalleFactura(
        Long id,
        Long ventaId,
        Long productoId,
        int cantidad,
        double precio,
        double subtotal
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
