package utp.edu.pe.boticas_montezor_api.Domain.Productos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataListProductReport {
    private String nombre;
    private String descripcion;
    private Integer cantidad;
    private Double precioCompra;
    private BigDecimal precioVenta;

    public DataListProductReport(Producto data) {
        this.nombre = data.getNombre();
        this.descripcion = data.getDescripcion();
        this.cantidad = data.getCantidad();
        this.precioCompra = data.getPrecioCompra();
        this.precioVenta = data.getPrecioVenta();
    }
}
