package utp.edu.pe.boticas_montezor_api.Domain.Recetario;

import jakarta.validation.constraints.NotNull;
import utp.edu.pe.boticas_montezor_api.Domain.Enfermedades.DataRegisterEnfermedad;

import java.util.List;

public record DataRegisterRecetario(
    @NotNull DataRegisterEnfermedad enfermedad,
    @NotNull List<Long> principiosActivos
) {
}
