package utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrincipioService {
    @Autowired
    private PrincipioActivoRepository principioActivoRepository;

    @Transactional
    public boolean create(DataRegisterPrincipioActivo data){
        PrincipioActivo principioActivo = new PrincipioActivo(data);
        principioActivoRepository.save(principioActivo);
        return true;
    }
    @Transactional
    public boolean update(DataUpdatePrincipioActivo data){
        PrincipioActivo principioActivo = principioActivoRepository.findById(data.id())
                .orElseThrow(() -> new RuntimeException("Principio activo no encontrado"));
        principioActivoRepository.save(new PrincipioActivo(data));
        return true;
    }
    @Transactional
    public boolean delete(Long id){
        PrincipioActivo principioActivo = principioActivoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Principio activo no encontrado"));
        principioActivoRepository.delete(principioActivo);
        return true;
    }
    @Transactional
    public DataListPrincipioActivo findId(Long id){
        PrincipioActivo principioActivo = principioActivoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Principio activo no encontrado"));
        return new DataListPrincipioActivo(principioActivo);
    }
    @Transactional
    public List<DataListPrincipioActivo> findAll(){
        List<PrincipioActivo> principiosActivos = principioActivoRepository.findAll();
        return principiosActivos.stream().map(DataListPrincipioActivo::new).collect(Collectors.toList());
    }
}
