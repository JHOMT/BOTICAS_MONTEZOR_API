package utp.edu.pe.boticas_montezor_api.Domain.Ventas;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utp.edu.pe.boticas_montezor_api.Domain.Clientes.Cliente;
import utp.edu.pe.boticas_montezor_api.Domain.Empleados.Empleado;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Ventas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Venta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VentaID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ClienteID")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmpleadoID")
    private Empleado empleado;

    @Column(name = "Fechaventa")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaventa;

    @Enumerated(EnumType.STRING)
    @Column(name = "Tipofactura")
    private TipoFactura tipoFactura;

    @Column(name = "fechafactura")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fechaFactura;

    @Column(name = "Montototal")
    private BigDecimal total;

    public Venta(Long id) {
        this.id = id;
    }

    public Venta(DataRegisterVenta data) {
        this(
                null,
                new Cliente(data.clienteID()),
                new Empleado(data.empleadoID()),
                LocalDateTime.now(),
                data.tipoFactura(),
                LocalDateTime.now(),
                null
        );
    }

    public Venta(Venta venta) {
        this(
                venta.id,
                venta.cliente,
                venta.empleado,
                venta.fechaventa,
                venta.tipoFactura,
                venta.fechaFactura,
                venta.total
        );
    }
}
