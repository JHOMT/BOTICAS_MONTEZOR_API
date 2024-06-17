package utp.edu.pe.boticas_montezor_api.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.DataRegisterProducto;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.DataUpdateProducto;
import utp.edu.pe.boticas_montezor_api.Services.ProductosService;

@RestController
@RequestMapping("/productos")
public class ProductosController {
    @Autowired
    private ProductosService productosService;

    @PostMapping
    public ResponseEntity<?> registrarProducto(@RequestBody @Valid DataRegisterProducto producto) {
        return ResponseEntity.ok(productosService.registrar(producto));
    }

    @GetMapping
    public ResponseEntity<?> listarProductos() {
        return ResponseEntity.ok(productosService.listar());
    }
    @PutMapping
    public ResponseEntity<?> actualizarProducto(@RequestBody @Valid DataUpdateProducto producto) {
        return ResponseEntity.ok(productosService.actualizar(producto));
    }
}
