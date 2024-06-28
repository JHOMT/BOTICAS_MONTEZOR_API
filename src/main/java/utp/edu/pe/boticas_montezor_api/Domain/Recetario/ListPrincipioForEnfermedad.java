package utp.edu.pe.boticas_montezor_api.Domain.Recetario;

import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.DataListPrincipioActivo;

import java.util.List;

public record ListPrincipioForEnfermedad(
    Long id,
    String enfermedad,
    String descripcion,
    List<PrincipioEnfermedad> principiosActivos
) {
}
