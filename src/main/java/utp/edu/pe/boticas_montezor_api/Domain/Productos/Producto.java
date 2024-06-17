package utp.edu.pe.boticas_montezor_api.Domain.Productos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import utp.edu.pe.boticas_montezor_api.Domain.Distribuidoras.Distribuidora;
import utp.edu.pe.boticas_montezor_api.Domain.GrupoFarmaceutico.GrupoFarmaceutico;
import utp.edu.pe.boticas_montezor_api.Domain.Laboratorios.Laboratorio;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTOS")
public class Producto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductoID")
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "PrecioCompra")
    private double precioCompra;

    @Column(name = "PrecioVenta")
    private BigDecimal precioVenta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GrupoFarmaceuticoID")
    private GrupoFarmaceutico grupoFaramaceutico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LaboratorioID")
    private Laboratorio laboratorio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DistribuidoraID")
    private Distribuidora distribuidora;

    @Column(name = "FechaVencimiento")
    private LocalDate fechaVencimiento;

    @Column(name = "Cantidad")
    private int cantidad;

    @Column(name = "Lote")
    private String lote;

    @Column(name = "ConcentracionFarmaceutica")
    private String concentracion;

    public Producto(Long id) {
        this.id = id;
    }
    public Producto (DataRegisterProducto data){
        this(
                null,
                data.nombre(),
                data.descripcion(),
                data.precioCompra(),
                BigDecimal.valueOf(data.precioVenta()),
                new GrupoFarmaceutico(data.grupoFarmaceuticoId()),
                new Laboratorio(data.laboratorioId()),
                new Distribuidora(data.distribuidoraId()),
                data.fechaVencimiento(),
                data.cantidad(),
                data.lote(),
                data.concentracion()
        );
    }
    public Producto (DataUpdateProducto data){
        this.id = data.id();
        if (data.nombre() != null) this.nombre = data.nombre();
        if (data.descripcion() != null) this.descripcion = data.descripcion();
        if (data.precioCompra() != null) this.precioCompra = data.precioCompra();
        if (data.precioVenta() != null) this.precioVenta = BigDecimal.valueOf(data.precioVenta());
        if (data.grupoFarmaceuticoId() != null) this.grupoFaramaceutico = new GrupoFarmaceutico(data.grupoFarmaceuticoId());
        if (data.laboratorioId() != null) this.laboratorio = new Laboratorio(data.laboratorioId());
        if (data.distribuidoraId() != null) this.distribuidora = new Distribuidora(data.distribuidoraId());
        if (data.fechaVencimiento() != null) this.fechaVencimiento = data.fechaVencimiento();
        if (data.cantidad() != null) this.cantidad = data.cantidad();
        if (data.lote() != null) this.lote = data.lote();
        if (data.concentracion() != null) this.concentracion = data.concentracion();
    }
}
