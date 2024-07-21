package utp.edu.pe.boticas_montezor_api.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.boticas_montezor_api.Domain.Enfermedades.DataRegisterEnfermedad;
import utp.edu.pe.boticas_montezor_api.Domain.Enfermedades.DataUpdateEnfermedad;
import utp.edu.pe.boticas_montezor_api.Domain.Enfermedades.EnfermedadService;
import utp.edu.pe.boticas_montezor_api.Domain.Recetario.DataRegisterRecetario;

@RestController
@RequestMapping("/enfermedad")
public class EnfermedadController {
    @Autowired
    private EnfermedadService enfermedadService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid DataRegisterRecetario data){
        return ResponseEntity.ok(enfermedadService.createEnfermedad(data));
    }

    @GetMapping
    public ResponseEntity<?> getAllEnfermedades(){
        return ResponseEntity.ok(enfermedadService.getAll());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> getEnfermedadByNombre(@PathVariable String nombre){
        return ResponseEntity.ok(enfermedadService.getEnfermedadByNombre(nombre));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getEnfermedadById(@PathVariable Long id){
        return ResponseEntity.ok(enfermedadService.getEnfermedadById(id));
    }

    @PutMapping
    public ResponseEntity<?> updateEnfermedad(@RequestBody @Valid DataUpdateEnfermedad data){
        return ResponseEntity.ok(enfermedadService.updateEnfermedad(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEnfermedad(@PathVariable Long id){
        return ResponseEntity.ok(enfermedadService.deleteEnfermedad(id));
    }
}
