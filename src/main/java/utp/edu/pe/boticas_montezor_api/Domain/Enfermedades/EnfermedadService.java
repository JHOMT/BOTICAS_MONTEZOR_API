package utp.edu.pe.boticas_montezor_api.Domain.Enfermedades;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.edu.pe.boticas_montezor_api.Controller.RecetarioController;
import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.PrincipioActivo;
import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.PrincipioActivoRepository;
import utp.edu.pe.boticas_montezor_api.Domain.Recetario.DataRegisterRecetario;
import utp.edu.pe.boticas_montezor_api.Domain.Recetario.Recetario;
import utp.edu.pe.boticas_montezor_api.Domain.Recetario.RecetarioId;
import utp.edu.pe.boticas_montezor_api.Domain.Recetario.RecetarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EnfermedadService {
    @Autowired
    private EnfermedadesRepository enfermedadRepository;
    @Autowired
    private PrincipioActivoRepository principioActivoRepository;
    @Autowired
    private RecetarioRepository recetarioRepository;

    public DataListEnfermedad getEnfermedadById(Long id) {
        Enfermedad enfermedad = enfermedadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enfermedad no encontrada"));
        return new DataListEnfermedad(enfermedad);
    }

    public DataListEnfermedad getEnfermedadByNombre(String nombre) {
        Optional<Enfermedad> enfermedad = Optional.ofNullable(enfermedadRepository.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("Enfermedad no encontrada")));
        return new DataListEnfermedad(enfermedad.get());
    }

    @Transactional
    public DataListEnfermedad createEnfermedad(DataRegisterRecetario data) {
        Enfermedad enfermedad = new Enfermedad(data.enfermedad());
        enfermedad = enfermedadRepository.save(enfermedad);
        List<Long> idsPrincipios = data.principiosActivos();
        for (Long principio : idsPrincipios) {
            PrincipioActivo principioActivo = principioActivoRepository.findById(principio)
                    .orElseThrow(() -> new RuntimeException("Principio activo no encontrado"));
            RecetarioId recetarioId = new RecetarioId(principioActivo.getId(), enfermedad.getId());
            recetarioRepository.save(new Recetario(recetarioId, principioActivo, enfermedad));
        }
        return new DataListEnfermedad(enfermedad);
    }

    public Boolean updateEnfermedad(DataUpdateEnfermedad data) {
        Optional<Enfermedad> enfermedad = Optional.ofNullable(enfermedadRepository.findById(data.id())
                .orElseThrow(() -> new RuntimeException("Enfermedad no encontrada")));
        enfermedadRepository.save(new Enfermedad());
        return true;
    }

    public Boolean deleteEnfermedad(Long id) {
        enfermedadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enfermedad no encontrada"));
        enfermedadRepository.deleteById(id);
        return true;
    }

    public List<DataListEnfermedad> getAll() {
        List<Enfermedad> enfermedades = enfermedadRepository.findAll();
        return enfermedades.stream().map(DataListEnfermedad::new).toList();
    }
}
