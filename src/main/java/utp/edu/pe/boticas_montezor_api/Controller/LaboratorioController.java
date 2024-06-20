package utp.edu.pe.boticas_montezor_api.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.boticas_montezor_api.Domain.Laboratorios.DataRegisterLaboratorio;
import utp.edu.pe.boticas_montezor_api.Domain.Laboratorios.DataUpdateLaboratorio;
import utp.edu.pe.boticas_montezor_api.Domain.Laboratorios.LaboratoriosService;

@RestController
@RequestMapping("/laboratorio")
public class LaboratorioController {
    @Autowired
    private LaboratoriosService laboratoriosService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid DataRegisterLaboratorio laboratorio) {
        return new ResponseEntity<>(laboratoriosService.register(laboratorio), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getLaboratoriosService() {
        return new ResponseEntity<>(laboratoriosService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLaboratoriosServiceById(@PathVariable Long id) {
        return new ResponseEntity<>(laboratoriosService.getById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid DataUpdateLaboratorio laboratorio) {
        return new ResponseEntity<>(laboratoriosService.update(laboratorio), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return new ResponseEntity<>(laboratoriosService.delete(id), HttpStatus.OK);
    }
}
