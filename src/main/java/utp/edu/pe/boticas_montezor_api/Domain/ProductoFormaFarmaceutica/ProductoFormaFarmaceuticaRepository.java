package utp.edu.pe.boticas_montezor_api.Domain.ProductoFormaFarmaceutica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoFormaFarmaceuticaRepository extends JpaRepository<ProductoFormaFarmaceutica, ProductoFormaFarmaceuticaId> {

}
