package utp.edu.pe.boticas_montezor_api.Domain.Productos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
    @Query("SELECT p FROM Producto p WHERE p.nombre = ?1 AND p.laboratorio.id = ?2")
    Optional<Producto> findByNombreAndLaboratorio(String nombre, Long laboratorioId);

    @Query("SELECT p FROM Producto p WHERE p.nombre = ?1")
    List<Producto> findByNombre(String nombre);

    @Query("SELECT p FROM Producto p WHERE MONTH(p.fechaVencimiento) = MONTH(CURRENT_DATE) AND YEAR(p.fechaVencimiento) = YEAR(CURRENT_DATE)")
    List<Producto> findVencimientoEsteMes();

    @Query("SELECT p FROM Producto p WHERE p.fechaVencimiento < CURRENT_DATE")
    List<Producto> findVencidas();
}
