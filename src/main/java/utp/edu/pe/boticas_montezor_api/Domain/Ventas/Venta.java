package utp.edu.pe.boticas_montezor_api.Domain.Ventas;

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

    @Column(name = "FechaVenta")
    private LocalDateTime fechaVenta;

    @Enumerated(EnumType.STRING)
    @Column(name = "TipoFactura")
    private TipoFactura tipoFactura;

    @Column(name = "MontoTotal")
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
                null
        );
    }
}
