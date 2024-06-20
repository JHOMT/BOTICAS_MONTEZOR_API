package utp.edu.pe.boticas_montezor_api.Domain.Recetario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecetarioRepository extends JpaRepository<Recetario, RecetarioId> {
    @Query("""
            SELECT r
            FROM Recetario r
            WHERE r.enfermedad.id = :id
            """)
    List<Recetario> findByEnfermedad(Long id);
}
