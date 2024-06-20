package utp.edu.pe.boticas_montezor_api.Domain.Laboratorios;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoriosService {
    @Autowired
    private LaboratorioRepository laboratoriosRepository;

    public boolean register(DataRegisterLaboratorio laboratorio) {
        laboratoriosRepository.save(new Laboratorio(laboratorio));
        return true;
    }
    @Transactional
    public boolean update(DataUpdateLaboratorio laboratorio) {
        laboratoriosRepository.save(new Laboratorio(laboratorio));
        return true;
    }
    @Transactional
    public boolean delete(Long id) {
        laboratoriosRepository.deleteById(id);
        return true;
    }
    public List<DataListLaboratorios> getAll() {
        return laboratoriosRepository.findAll().stream().map(DataListLaboratorios::new).toList();
    }
    public DataListLaboratorios getById(Long id) {
        Laboratorio laboratorio = laboratoriosRepository.findById(id).orElse(null);
        return new DataListLaboratorios(laboratorio);
    }
}
