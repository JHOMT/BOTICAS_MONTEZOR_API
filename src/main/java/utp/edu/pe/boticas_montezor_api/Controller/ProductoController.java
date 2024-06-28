package utp.edu.pe.boticas_montezor_api.Controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.DataRegisterProducto;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.DataUpdateProducto;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.ProductosService;

import java.io.InputStream;

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

    @GetMapping("/porVencer")
    public ResponseEntity<?> readVencimiento(){
        return ResponseEntity.ok(productosService.productosPorVencer());
    }

    @GetMapping("/vencidas")
    public ResponseEntity<?> readVencidas(){
        return ResponseEntity.ok(productosService.productosVencidos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(productosService.delete(id));
    }

    @GetMapping("/report/{format}")
    public ResponseEntity<byte[]> getReport(@PathVariable @NotNull String format) {
        try {
            InputStream reportPath = getClass().getResourceAsStream("/reports/ProductosReport.jrxml");
            byte[] reportBytes = productosService.exportReport(format, reportPath);

            String mimeType;
            String fileName;
            if ("pdf".equalsIgnoreCase(format)) {
                mimeType = "application/pdf";
                fileName = "ProductosReport.pdf";
            } else if ("html".equalsIgnoreCase(format)) {
                mimeType = "text/html";
                fileName = "ProductosReport.html";
            } else if ("xlsx".equalsIgnoreCase(format)) {
                mimeType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
                fileName = "ProductosReport.xlsx";
            } else {
                return ResponseEntity.badRequest().body(null);
            }

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                    .contentType(MediaType.parseMediaType(mimeType))
                    .body(reportBytes);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
