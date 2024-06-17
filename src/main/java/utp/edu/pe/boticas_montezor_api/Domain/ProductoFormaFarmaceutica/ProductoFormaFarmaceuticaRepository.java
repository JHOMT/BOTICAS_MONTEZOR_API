package utp.edu.pe.boticas_montezor_api.Domain.ProductoFormaFarmaceutica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoFormaFarmaceuticaRepository extends JpaRepository<ProductoFormaFarmaceutica, Long> {
    List<ProductoFormaFarmaceutica> findByProductoId(Long productoId);
    List<ProductoFormaFarmaceutica> findByFormaFarmaceuticaId(Long formaFarmaceuticaId);
    List<ProductoFormaFarmaceutica> findByProductoIdAndFormaFarmaceuticaId(Long productoId, Long formaFarmaceuticaId);
    void deleteByProductoId(Long productoId);
    void deleteByFormaFarmaceuticaId(Long formaFarmaceuticaId);
    void deleteByProductoIdAndFormaFarmaceuticaId(Long productoId, Long formaFarmaceuticaId);
}
