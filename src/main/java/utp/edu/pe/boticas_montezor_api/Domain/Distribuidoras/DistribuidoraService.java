package utp.edu.pe.boticas_montezor_api.Domain.Distribuidoras;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistribuidoraService {
    @Autowired
    private DistribuidoraRepository distribuidoraRepository;

    public Boolean registrarDistribuidora(DataRegisterDistribuidora distribuidora) {
        Distribuidora newDistribuidora = new Distribuidora(distribuidora);
        distribuidoraRepository.save(newDistribuidora);
        return true;
    }

    public DataListDistribuidora searchDistribuidora(String name) {
        return new DataListDistribuidora(distribuidoraRepository.findByName(name));
    }

    public List<DataListDistribuidora> listDistribuidoras() {
        return distribuidoraRepository.findAll().stream().map(DataListDistribuidora::new).toList();
    }

    @Transactional
    public Boolean updateDistribuidora(DataUpdateDistribuidora data) {
        Distribuidora distribuidoraToUpdate = distribuidoraRepository.findById(data.id())
                .orElseThrow(() -> new RuntimeException("Distribuidora no encontrada"));
        distribuidoraRepository.save(new Distribuidora(data));
        return true;
    }

    @Transactional
    public Boolean deleteDistribuidora(Long id) {
        distribuidoraRepository.deleteById(id);
        return true;
    }
}
