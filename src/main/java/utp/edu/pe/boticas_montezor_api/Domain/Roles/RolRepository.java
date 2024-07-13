package utp.edu.pe.boticas_montezor_api.Domain.Roles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RolRepository extends JpaRepository<Rol, Long> {
    @Query("SELECT r FROM Rol r WHERE r.nombre = ?1")
    Rol findByRole(String user);
}
