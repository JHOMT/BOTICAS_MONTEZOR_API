package utp.edu.pe.boticas_montezor_api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.boticas_montezor_api.Domain.Recetario.RecetarioService;

@RestController
@RequestMapping("/recetario")
public class RecetarioController {
    @Autowired
    private RecetarioService recetarioService;

    @GetMapping("/principio/{principioActivoId}")
    public ResponseEntity<?> listarProductosPorPrincipioActivo(@PathVariable Long principioActivoId) {
        return ResponseEntity.ok(recetarioService.listarProductosPorPrincipioActivo(principioActivoId));
    }

    @GetMapping("/enfermedad/{nombreEnfermedad}")
    public ResponseEntity<?> listarProductosPorEnfermedad(@PathVariable String nombreEnfermedad) {
        return ResponseEntity.ok(recetarioService.listarProductosPorEnfermedad(nombreEnfermedad));
    }
}
