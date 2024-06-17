package utp.edu.pe.boticas_montezor_api.Domain.Clientes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c WHERE c.dni = ?1 OR c.ruc = ?1")
    Optional<Cliente> findByDniOrRuc(Long aLong);
}
