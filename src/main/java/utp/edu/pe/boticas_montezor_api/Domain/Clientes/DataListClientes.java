package utp.edu.pe.boticas_montezor_api.Domain.Clientes;

public record DataListClientes(
    Long id,
    String nombres,
    String dni,
    String ruc
) {
    public DataListClientes (Cliente cliente) {
        this(
            cliente.getId(),
            cliente.getNombres(),
            cliente.getNombres(),
            cliente.getRuc()
        );
    }
}
