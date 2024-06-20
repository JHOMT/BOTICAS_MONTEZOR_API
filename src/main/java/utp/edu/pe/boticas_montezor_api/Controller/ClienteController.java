package utp.edu.pe.boticas_montezor_api.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utp.edu.pe.boticas_montezor_api.Domain.Clientes.ClienteService;
import utp.edu.pe.boticas_montezor_api.Domain.Clientes.DataRegisterCliente;
import utp.edu.pe.boticas_montezor_api.Domain.Clientes.DataUpdateCliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid DataRegisterCliente data){
        if (clienteService.createCliente(data)) return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<?> list(){
        if (clienteService.getClientes().isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(clienteService.getClientes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        if (clienteService.getClienteById(id) == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(clienteService.getClienteById(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update( @RequestBody @Valid DataUpdateCliente data){
        if (clienteService.updateCliente(data) == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(clienteService.updateCliente(data), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if (!clienteService.deleteCliente(id)) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(clienteService.deleteCliente(id), HttpStatus.OK);
    }
}
