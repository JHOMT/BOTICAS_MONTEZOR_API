package utp.edu.pe.boticas_montezor_api.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.boticas_montezor_api.Domain.Empleados.DataLoginEmpleado;
import utp.edu.pe.boticas_montezor_api.Domain.Empleados.DataRegisterEmpleado;
import utp.edu.pe.boticas_montezor_api.Services.PersonalService;

@RestController
@RequestMapping("/personal")
public class PersonalController {
    @Autowired
    private PersonalService personalService;

    @PostMapping
    public ResponseEntity<?> newPersonal(@RequestBody @Valid DataRegisterEmpleado data) {
        return ResponseEntity.ok(personalService.registerEmployee(data));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginPersonal(@RequestBody @Valid DataLoginEmpleado data) {
        return ResponseEntity.ok(personalService.loginEmployee(data));
    }

    @GetMapping
    public ResponseEntity<?> getPersonal() {
        return ResponseEntity.ok(personalService.getEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonal(@PathVariable Long id) {
        return ResponseEntity.ok(personalService.getEmployee(id));
    }
}
