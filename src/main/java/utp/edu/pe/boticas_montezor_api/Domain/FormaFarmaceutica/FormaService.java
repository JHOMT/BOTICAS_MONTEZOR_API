package utp.edu.pe.boticas_montezor_api.Domain.FormaFarmaceutica;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormaService {
    @Autowired
    private FormaFarmaceuticaRepository formaFarmaceuticaRepository;

    @Transactional
    public Boolean register(DataRegisterFormaFarmaceutica data){
        FormaFarmaceutica formaFarmaceutica = new FormaFarmaceutica(data);
        formaFarmaceuticaRepository.save(formaFarmaceutica);
        return true;
    }

    @Transactional
    public Boolean update(DataUpdateFormaFarmaceutica data){
        FormaFarmaceutica formaFarmaceutica = formaFarmaceuticaRepository.findById(data.id())
                .orElseThrow(() -> new RuntimeException("Forma farmaceutica no encontrada"));
        formaFarmaceuticaRepository.save(new FormaFarmaceutica(data));
        return true;
    }

    @Transactional
    public Boolean delete(Long id){
        FormaFarmaceutica formaFarmaceutica = formaFarmaceuticaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Forma farmaceutica no encontrada"));
        formaFarmaceuticaRepository.delete(formaFarmaceutica);
        return true;
    }

    @Transactional
    public List<DataListFormaFarmaceutica> list() {
        List<FormaFarmaceutica> formas = formaFarmaceuticaRepository.findAll();
        return formas.stream().map(DataListFormaFarmaceutica::new).toList();
    }

    @Transactional
    public DataListFormaFarmaceutica get(Long id) {
        FormaFarmaceutica formaFarmaceutica = formaFarmaceuticaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Forma farmaceutica no encontrada"));
        return new DataListFormaFarmaceutica(formaFarmaceutica);
    }
}
