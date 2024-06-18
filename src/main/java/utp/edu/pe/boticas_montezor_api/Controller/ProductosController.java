package utp.edu.pe.boticas_montezor_api.Controller;

import jakarta.validation.Valid;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.DataRegisterProducto;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.DataUpdateProducto;
import utp.edu.pe.boticas_montezor_api.Implement.ProductoInterface;
import utp.edu.pe.boticas_montezor_api.Services.ProductosService;
import utp.edu.pe.boticas_montezor_api.Utils.ProductoReportGenerator;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/productos")
public class ProductosController {
    @Autowired
    private ProductosService productosService;
    @Autowired
    private ProductoInterface productoInterface;

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

    @GetMapping("/grupos")
    public ResponseEntity<?> grupos(){
        return new ResponseEntity<>(productosService.listarGruposFarmaceuticos(), HttpStatus.OK);
    }

    @GetMapping("/forma")
    public ResponseEntity<?> forma() {
        return new ResponseEntity<>(productosService.listarFormaFarmaceutica(), HttpStatus.OK);
    }

    @GetMapping("/export-pdf")
    public ResponseEntity<byte[]> exportPdf() throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("productsReport", "productsReport.pdf");
        return ResponseEntity.ok().headers(headers).body(productoInterface.exportPdf());
    }

    @GetMapping("/export-xls")
    public ResponseEntity<byte[]> exportXls() throws JRException, FileNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=UTF-8");
        var contentDisposition = ContentDisposition.builder("attachment")
                .filename("productsReport.xls").build();
        headers.setContentDisposition(contentDisposition);
        return ResponseEntity.ok().headers(headers).body(productoInterface.exportXls());
    }

}
