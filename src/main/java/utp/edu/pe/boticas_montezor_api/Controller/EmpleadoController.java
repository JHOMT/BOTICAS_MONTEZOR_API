package utp.edu.pe.boticas_montezor_api.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.boticas_montezor_api.Domain.Empleados.DataLoginEmpleado;
import utp.edu.pe.boticas_montezor_api.Domain.Empleados.DataRegisterEmpleado;
import utp.edu.pe.boticas_montezor_api.Domain.Empleados.EmpleadoService;


@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid DataRegisterEmpleado data) {
        if (empleadoService.registerEmployee(data) == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(empleadoService.registerEmployee(data), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> lis() {
        return ResponseEntity.ok(empleadoService.getEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        return ResponseEntity.ok(empleadoService.getEmployee(id));
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid DataLoginEmpleado data) {
        return ResponseEntity.ok(empleadoService.loginEmployee(data));
    }
}
