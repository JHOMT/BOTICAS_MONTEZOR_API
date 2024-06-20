package utp.edu.pe.boticas_montezor_api.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.boticas_montezor_api.Domain.Distribuidoras.DataRegisterDistribuidora;
import utp.edu.pe.boticas_montezor_api.Domain.Distribuidoras.DataUpdateDistribuidora;
import utp.edu.pe.boticas_montezor_api.Domain.Distribuidoras.DistribuidoraService;

@RestController
@RequestMapping("/distribuidora")
public class DistribuidoraController {
    @Autowired
    private DistribuidoraService distribuidoraService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid DataRegisterDistribuidora distribuidora) {
        return new ResponseEntity<>(distribuidoraService.registrarDistribuidora(distribuidora), HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> search(@PathVariable String name) {
        return new ResponseEntity<>(distribuidoraService.searchDistribuidora(name), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> list() {
        if (distribuidoraService.listDistribuidoras().isEmpty()) return ResponseEntity.noContent().build();
        return new ResponseEntity<>(distribuidoraService.listDistribuidoras(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid DataUpdateDistribuidora data) {
        if (!distribuidoraService.updateDistribuidora(data)) return ResponseEntity.notFound().build();
        return new ResponseEntity<>(distribuidoraService.updateDistribuidora(data), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam Long id) {
        if (!distribuidoraService.deleteDistribuidora(id)) return ResponseEntity.notFound().build();
        return new ResponseEntity<>(distribuidoraService.deleteDistribuidora(id), HttpStatus.OK);
    }
}
