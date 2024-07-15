package utp.edu.pe.boticas_montezor_api.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    public ResponseEntity<byte[]> registrarVenta(@RequestBody @Valid DataRegisterVentaDetails data) {
        byte[] pdfBytes = ventaProductoService.registrarVenta(data);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "Factura.pdf");
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<?> listarVentas() {
        return ResponseEntity.ok(ventaProductoService.listarVentas());
    }
}
