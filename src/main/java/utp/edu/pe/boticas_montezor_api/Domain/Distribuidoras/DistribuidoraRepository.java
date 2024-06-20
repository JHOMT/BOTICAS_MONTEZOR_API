package utp.edu.pe.boticas_montezor_api.Domain.Distribuidoras;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DistribuidoraRepository extends JpaRepository<Distribuidora, Long> {
    @Query("SELECT d FROM Distribuidora d WHERE d.nombre = ?1")
    Distribuidora findByName(String name);
}
