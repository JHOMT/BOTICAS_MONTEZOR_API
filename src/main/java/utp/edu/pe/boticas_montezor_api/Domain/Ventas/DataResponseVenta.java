package utp.edu.pe.boticas_montezor_api.Domain.Ventas;

import utp.edu.pe.boticas_montezor_api.Domain.DetalleFactura.DataListDetalleFactura;

import java.util.List;

public record DataResponseVenta(
        DataListVenta venta,
        List<DataListDetalleFactura> productos
) {
}
