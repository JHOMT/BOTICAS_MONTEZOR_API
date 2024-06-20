package utp.edu.pe.boticas_montezor_api.Domain.Recetario;

import utp.edu.pe.boticas_montezor_api.Domain.Productos.DataListProductos;

import java.util.List;

public record PrincipioEnfermedad(
        Long id,
        String nombre,
        List<DataListProductos> productos
) {
}
