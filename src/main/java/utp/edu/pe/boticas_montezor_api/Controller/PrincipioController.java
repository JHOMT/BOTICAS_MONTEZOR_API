package utp.edu.pe.boticas_montezor_api.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.DataRegisterPrincipioActivo;
import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.DataUpdatePrincipioActivo;
import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.PrincipioService;

@RestController
@RequestMapping("/principio")
public class PrincipioController {
    @Autowired
    private PrincipioService principioService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid DataRegisterPrincipioActivo data){
        return ResponseEntity.ok(principioService.create(data));
    }

    @GetMapping
    public ResponseEntity<?> list(){
        return ResponseEntity.ok(principioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable Long id){
        return ResponseEntity.ok(principioService.findId(id));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid DataUpdatePrincipioActivo data){
        return ResponseEntity.ok(principioService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(principioService.delete(id));
    }
}
