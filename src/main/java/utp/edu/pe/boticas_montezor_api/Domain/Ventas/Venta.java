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
@Table(name = "ventas")
public class Venta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ventaid")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clienteid")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empleadoid")
    private Empleado empleado;

    @Column(name = "fechaventa")
    private LocalDateTime fechaVenta;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipofactura")
    private TipoFactura tipoFactura;

    @Column(name = "montototal")
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
