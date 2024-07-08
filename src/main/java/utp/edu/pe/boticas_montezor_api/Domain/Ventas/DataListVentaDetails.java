package utp.edu.pe.boticas_montezor_api.Domain.Ventas;

import java.util.List;

public record DataListVentaDetails(
        DataListVenta venta,
        List<utp.edu.pe.boticas_montezor_api.Domain.Productos.DataListProductos> detalle
) {
}
