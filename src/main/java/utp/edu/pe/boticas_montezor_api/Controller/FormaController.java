package utp.edu.pe.boticas_montezor_api.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.boticas_montezor_api.Domain.FormaFarmaceutica.DataRegisterFormaFarmaceutica;
import utp.edu.pe.boticas_montezor_api.Domain.FormaFarmaceutica.DataUpdateFormaFarmaceutica;
import utp.edu.pe.boticas_montezor_api.Domain.FormaFarmaceutica.FormaService;

@RestController
@RequestMapping("/forma")
public class FormaController {
    @Autowired
    private FormaService formaService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid DataRegisterFormaFarmaceutica data){
        return ResponseEntity.ok(formaService.register(data));
    }

    @GetMapping
    public ResponseEntity<?> list(){
        return ResponseEntity.ok(formaService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        return ResponseEntity.ok(formaService.get(id));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid DataUpdateFormaFarmaceutica data){
        return ResponseEntity.ok(formaService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(formaService.delete(id));
    }
}
