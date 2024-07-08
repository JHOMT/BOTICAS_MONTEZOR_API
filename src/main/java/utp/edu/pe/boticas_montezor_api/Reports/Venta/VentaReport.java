package utp.edu.pe.boticas_montezor_api.Reports.Venta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utp.edu.pe.boticas_montezor_api.Domain.DetalleFactura.DetalleFactura;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaReport {
    private String nombre;
    private BigDecimal precioUnitario;
    private int cantidad;

    public VentaReport(DetalleFactura detalleFactura) {
        this.nombre = detalleFactura.getProducto().getNombre();
        this.cantidad = detalleFactura.getCantidad();
    }
}
