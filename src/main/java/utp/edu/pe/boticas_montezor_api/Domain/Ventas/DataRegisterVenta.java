package utp.edu.pe.boticas_montezor_api.Domain.Ventas;

public record DataRegisterVenta(
    Long clienteID,
    Long empleadoID,
    TipoFactura tipoFactura
) {

}
