package utp.edu.pe.boticas_montezor_api.Domain.Productos;

import jakarta.transaction.Transactional;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import utp.edu.pe.boticas_montezor_api.Domain.Distribuidoras.Distribuidora;
import utp.edu.pe.boticas_montezor_api.Domain.Distribuidoras.DistribuidoraRepository;
import utp.edu.pe.boticas_montezor_api.Domain.FormaFarmaceutica.FormaFarmaceutica;
import utp.edu.pe.boticas_montezor_api.Domain.FormaFarmaceutica.FormaFarmaceuticaRepository;
import utp.edu.pe.boticas_montezor_api.Domain.GrupoFarmaceutico.GrupoFarmaceutico;
import utp.edu.pe.boticas_montezor_api.Domain.GrupoFarmaceutico.GrupoFarmaceuticoRepository;
import utp.edu.pe.boticas_montezor_api.Domain.Laboratorios.Laboratorio;
import utp.edu.pe.boticas_montezor_api.Domain.Laboratorios.LaboratorioRepository;
import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.DataRegisterPrincipioActivo;
import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.PrincipioActivo;
import utp.edu.pe.boticas_montezor_api.Domain.PrincipiosActivos.PrincipioActivoRepository;
import utp.edu.pe.boticas_montezor_api.Domain.ProductoFormaFarmaceutica.ProductoFormaFarmaceutica;
import utp.edu.pe.boticas_montezor_api.Domain.ProductoFormaFarmaceutica.ProductoFormaFarmaceuticaRepository;
import utp.edu.pe.boticas_montezor_api.Domain.ProductoPrincipioActivo.DataRegisterProductoPrincipioActivo;
import utp.edu.pe.boticas_montezor_api.Domain.ProductoPrincipioActivo.ProductoPrincipioActivo;
import utp.edu.pe.boticas_montezor_api.Domain.ProductoPrincipioActivo.ProductoPrincipioActivoRepository;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductosService {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private GrupoFarmaceuticoRepository grupoFarmaceuticoRepository;
    @Autowired
    private LaboratorioRepository laboratorioRepository;
    @Autowired
    private FormaFarmaceuticaRepository formaFarmaceuticaRepository;
    @Autowired
    private PrincipioActivoRepository principioActivoRepository;
    @Autowired
    private DistribuidoraRepository distribuidoraRepository;
    @Autowired
    private ProductoPrincipioActivoRepository productoPrincipioActivoRepository;
    @Autowired
    private ProductoFormaFarmaceuticaRepository productoFormaFarmaceuticaRepository;

    @Transactional
    public Boolean registrar(DataRegisterProducto producto) {

        Producto productoExistente = productoRepository.findByNombreAndLaboratorio(producto.nombre(), producto.laboratorioId())
                .orElse(new Producto(producto));

        productoExistente.setCantidad(productoExistente.getCantidad() + producto.cantidad());

        GrupoFarmaceutico grupoFarmaceutico = grupoFarmaceuticoRepository.findById(producto.grupoFarmaceuticoId())
                .orElseThrow(() -> new RuntimeException("Grupo Farmaceutico no encontrado"));

        Laboratorio laboratorio = laboratorioRepository.findById(producto.laboratorioId())
                .orElseThrow(() -> new RuntimeException("Laboratorio no encontrado"));

        Distribuidora distribuidora = distribuidoraRepository.findById(producto.distribuidoraId())
                .orElseThrow(() -> new RuntimeException("Distribuidora no encontrada"));

        PrincipioActivo principioActivo = principioActivoRepository.findById(producto.principioActivoId())
                .orElseThrow(() -> new RuntimeException("Principio Activo no encontrado"));

        FormaFarmaceutica formaFarmaceutica = formaFarmaceuticaRepository.findById(producto.formaFarmaceuticaId())
                .orElseThrow(() -> new RuntimeException("Forma Farmaceutica no encontrada"));

        Producto productoGuardado = productoRepository.save(productoExistente);

        if (principioActivo != null) {
            ProductoPrincipioActivo productoPrincipioActivo = new ProductoPrincipioActivo(productoGuardado, principioActivo);
            productoPrincipioActivoRepository.save(productoPrincipioActivo);
        }

        if (formaFarmaceutica != null) {
            ProductoFormaFarmaceutica productoFormaFarmaceutica = new ProductoFormaFarmaceutica(productoGuardado, formaFarmaceutica);
            productoFormaFarmaceuticaRepository.save(productoFormaFarmaceutica);
        }

        return true;
    }

    public Boolean update(@NotNull DataUpdateProducto producto) {
        Optional<Producto> productoOptional = Optional.ofNullable(productoRepository.findById(producto.id())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado")));
        productoRepository.save(new Producto(producto));
        return true;
    }
    public Boolean delete(@NotNull Long id) {
        Optional<Producto> productoOptional = Optional.ofNullable(productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado")));
        productoRepository.delete(productoOptional.get());
        return true;
    }
    public List<DataListProductos> listar() {
        return productoRepository.findAll().stream().map(DataListProductos::new).toList();
    }
    public List<DataListProductos> listarPorNombre(@NotNull String nombre) {
        return productoRepository.findByNombre(nombre).stream().map(DataListProductos::new).toList();
    }
    public List<DataListProductos> listarPorLaboratorio(@NotNull Long laboratorioId) {
        return productoRepository.findById(laboratorioId).stream().map(DataListProductos::new).toList();
    }
    public byte[] exportReport(String format) throws Exception {
        List<DataListProductos> productos = listar();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(productos);

        InputStream reportStream = new ClassPathResource("reports/DataListProductosReport.jasper").getInputStream();
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportStream);

        Map<String, Object> parameters = new HashMap<>();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        byte[] reportBytes;
        if ("pdf".equalsIgnoreCase(format)) {
            reportBytes = JasperExportManager.exportReportToPdf(jasperPrint);
        } else if ("xls".equalsIgnoreCase(format)) {
            JRXlsxExporter exporter = new JRXlsxExporter();
            try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));
                exporter.exportReport();
                reportBytes = byteArrayOutputStream.toByteArray();
            }
        } else {
            throw new IllegalArgumentException("Unknown report format: " + format);
        }

        return reportBytes;
    }
}
