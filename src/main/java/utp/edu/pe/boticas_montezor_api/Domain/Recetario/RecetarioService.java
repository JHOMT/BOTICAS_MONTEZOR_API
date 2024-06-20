package utp.edu.pe.boticas_montezor_api.Domain.Recetario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.edu.pe.boticas_montezor_api.Domain.Enfermedades.Enfermedad;
import utp.edu.pe.boticas_montezor_api.Domain.Enfermedades.EnfermedadesRepository;
import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.PrincipioActivo;
import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.PrincipioActivoRepository;
import utp.edu.pe.boticas_montezor_api.Domain.ProductoPrincipioActivo.ProductoPrincipioActivoRepository;
import utp.edu.pe.boticas_montezor_api.Domain.ProductoPrincipioActivo.ProductoPrincipioActivo;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.DataListProductos;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.Producto;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.ProductoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecetarioService {
    @Autowired
    private RecetarioRepository recetarioRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private EnfermedadesRepository enfermedadesRepository;
    @Autowired
    private ProductoPrincipioActivoRepository productoPrincipioActivoRepository;
    @Autowired
    private PrincipioActivoRepository principioActivoRepository;

    public List<DataListProductos> listarProductosPorPrincipioActivo(Long principioActivoId) {
        PrincipioActivo productoPrincipioActivo = principioActivoRepository.findById(principioActivoId)
                .orElseThrow(() -> new RuntimeException("Principio activo no encontrado"));
        List<DataListProductos> productos = new ArrayList<>();
        Producto producto = productoRepository.findById(productoPrincipioActivo.getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        productos.add(new DataListProductos(producto));
        return productos;
    }

    public ListPrincipioForEnfermedad listarProductosPorEnfermedad(String nombreEnfermedad) {
        Enfermedad enfermedad = enfermedadesRepository.findByNombre(nombreEnfermedad)
                .orElseThrow(() -> new RuntimeException("Enfermedad no encontrada"));
        List<Recetario> recetarios = recetarioRepository.findByEnfermedad(enfermedad.getId());
        List<PrincipioEnfermedad> principiosEnfermedad = new ArrayList<>();

        for (Recetario recetario : recetarios) {
            PrincipioActivo principioActivo = recetario.getPrincipioActivo();
            List<DataListProductos> productos = listarProductosPorPrincipioActivo(principioActivo.getId());
            principiosEnfermedad.add(new PrincipioEnfermedad(principioActivo.getId(), principioActivo.getNombre(), productos));
        }

        return new ListPrincipioForEnfermedad(
                enfermedad.getId(),
                enfermedad.getNombre(),
                principiosEnfermedad
        );
    }
}
