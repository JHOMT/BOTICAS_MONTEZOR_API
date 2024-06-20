package utp.edu.pe.boticas_montezor_api.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.boticas_montezor_api.Domain.DetalleFactura.DataRegisterDetalleFactura;
import utp.edu.pe.boticas_montezor_api.Domain.Ventas.DataRegisterVenta;
import utp.edu.pe.boticas_montezor_api.Domain.Ventas.VentaProductoService;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentasController {
    @Autowired
    private VentaProductoService ventaProductoService;

    @PostMapping
    public ResponseEntity<?> registrarVenta(@RequestBody @Valid DataRegisterVenta venta, @RequestBody @Valid List<DataRegisterDetalleFactura> detalle) {
        return ResponseEntity.ok(ventaProductoService.registrarVenta(venta, detalle));
    }

    @GetMapping
    public ResponseEntity<?> listarVentas() {
        return ResponseEntity.ok(ventaProductoService.listarVentas());
    }
}
