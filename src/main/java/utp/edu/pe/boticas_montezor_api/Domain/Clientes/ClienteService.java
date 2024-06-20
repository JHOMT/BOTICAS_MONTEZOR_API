package utp.edu.pe.boticas_montezor_api.Domain.Clientes;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public DataListClientes getClienteById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return new DataListClientes(cliente.get());
    }

    public List<DataListClientes> getClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(DataListClientes::new).toList();
    }

    public Boolean createCliente(DataRegisterCliente cliente) {
        Cliente newCliente = clienteRepository.save(new Cliente(cliente));
        return true;
    }

    @Transactional
    public Boolean updateCliente(DataUpdateCliente cliente) {
        Optional<Cliente> clienteOptional = Optional.ofNullable(clienteRepository.findById(cliente.id())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado")));
        clienteRepository.save(new Cliente(cliente));
        return true;
    }

    @Transactional
    public Boolean deleteCliente(Long id) {
        clienteRepository.deleteById(id);
        return true;
    }
}
