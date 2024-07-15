package utp.edu.pe.boticas_montezor_api.Domain.Ventas;

import jakarta.validation.constraints.NotNull;
import utp.edu.pe.boticas_montezor_api.Domain.DetalleFactura.DataRegisterDetalleFactura;

import java.util.List;

public record DataRegisterVentaDetails(
        @NotNull DataRegisterVenta venta,
        @NotNull List<DataRegisterDetalleFactura> detalle
) {

}
