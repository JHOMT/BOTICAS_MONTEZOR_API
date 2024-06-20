package utp.edu.pe.boticas_montezor_api.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.boticas_montezor_api.Domain.GrupoFarmaceutico.DataRegisterGrupoFarmaceutico;
import utp.edu.pe.boticas_montezor_api.Domain.GrupoFarmaceutico.GrupoService;

@RestController
@RequestMapping("/grupos")
public class GruposController {
    @Autowired
    private GrupoService grupoService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid DataRegisterGrupoFarmaceutico data){
        return ResponseEntity.ok(grupoService.create(data));
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(grupoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        return ResponseEntity.ok(grupoService.get(id));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid DataRegisterGrupoFarmaceutico data){
        return ResponseEntity.ok(grupoService.update(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(grupoService.delete(id));
    }
}
