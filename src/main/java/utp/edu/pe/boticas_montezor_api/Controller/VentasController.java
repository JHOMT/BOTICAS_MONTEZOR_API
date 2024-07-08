package utp.edu.pe.boticas_montezor_api.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.boticas_montezor_api.Domain.Ventas.DataRegisterVentaDetails;
import utp.edu.pe.boticas_montezor_api.Domain.Ventas.VentaProductoService;

@RestController
@RequestMapping("/ventas")
public class VentasController {
    @Autowired
    private VentaProductoService ventaProductoService;

    @PostMapping
    public ResponseEntity<?> registrarVenta(@RequestBody @Valid DataRegisterVentaDetails data) {
        if (ventaProductoService.registrarVenta(data)) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<?> listarVentas() {
        return ResponseEntity.ok(ventaProductoService.listarVentas());
    }
}
