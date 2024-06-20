package utp.edu.pe.boticas_montezor_api.Domain.Enfermedades;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EnfermedadesRepository extends JpaRepository<Enfermedad, Long> {
    @Query("SELECT e FROM Enfermedad e WHERE e.nombre = ?1")
    Optional<Enfermedad> findByNombre(String nombre);
}
