package utp.edu.pe.boticas_montezor_api.Domain.Enfermedades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnfermedadService {
    @Autowired
    private EnfermedadesRepository enfermedadRepository;

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

    public DataListEnfermedad createEnfermedad(DataRegisterEnfermedad data) {
        Enfermedad enfermedad = new Enfermedad(data);
        enfermedadRepository.save(enfermedad);
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
