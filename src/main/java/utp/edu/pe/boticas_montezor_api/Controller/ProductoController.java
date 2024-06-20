package utp.edu.pe.boticas_montezor_api.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.DataRegisterProducto;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.DataUpdateProducto;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.ProductosService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductosService productosService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid DataRegisterProducto data){
        return ResponseEntity.ok(productosService.registrar(data));
    }

    @GetMapping
    public ResponseEntity<?> read(){
        return ResponseEntity.ok(productosService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id){
        return ResponseEntity.ok(productosService.listarPorLaboratorio(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> read(@PathVariable String name){
        return ResponseEntity.ok(productosService.listarPorNombre(name));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid DataUpdateProducto data){
        return ResponseEntity.ok(productosService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(productosService.delete(id));
    }
}
