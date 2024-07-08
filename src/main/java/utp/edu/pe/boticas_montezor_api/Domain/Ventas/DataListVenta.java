package utp.edu.pe.boticas_montezor_api.Domain.Ventas;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record DataListVenta(
    Long id,
    Long clienteID,
    String clienteNombre,
    Long empleadoID,
    String empleadoNombre,
    LocalDateTime fechaVenta,
    String tipoFactura,
    BigDecimal total
) {
    public DataListVenta(Venta venta) {
        this(
            venta.getId(),
            venta.getCliente().getId(),
            venta.getCliente().getNombres(),
            venta.getEmpleado().getId(),
            venta.getEmpleado().getNombres(),
            venta.getFechaventa(),
            venta.getTipoFactura().name(),
            venta.getTotal()
        );
    }
}
