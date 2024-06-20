package utp.edu.pe.boticas_montezor_api.Domain.GrupoFarmaceutico;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {
    @Autowired
    private GrupoFarmaceuticoRepository grupoRepository;

    public Boolean create(DataRegisterGrupoFarmaceutico data){
        GrupoFarmaceutico grupo = new GrupoFarmaceutico(data);
        grupoRepository.save(grupo);
        return true;
    }
    @Transactional
    public Boolean update(DataRegisterGrupoFarmaceutico data){
        GrupoFarmaceutico grupo = new GrupoFarmaceutico(data);
        grupoRepository.save(grupo);
        return true;
    }
    @Transactional
    public Boolean delete(Long id){
        grupoRepository.deleteById(id);
        return true;
    }
    public GrupoFarmaceutico get(Long id){
        return grupoRepository.findById(id).get();
    }
    public List<DataListGruposFarmaceuticos> getAll(){
        return grupoRepository.findAll().stream().map(DataListGruposFarmaceuticos::new).toList();
    }
}
