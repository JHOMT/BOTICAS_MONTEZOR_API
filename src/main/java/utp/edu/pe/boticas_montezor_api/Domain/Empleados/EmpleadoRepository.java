package utp.edu.pe.boticas_montezor_api.Domain.Empleados;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    @Query("SELECT e FROM Empleado e WHERE e.correo = ?1")
    Optional<Empleado> findByUsuario(String usuario);

    @Query("SELECT e FROM Empleado e WHERE e.correo = ?1")
    Empleado findByEmail(String username);

}
