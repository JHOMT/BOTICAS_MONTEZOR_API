package utp.edu.pe.boticas_montezor_api.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.DataListProductos;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Service
public class ReportService {

    @Autowired
    private ProductosService productosService;

    public byte[] generarReporte() {
        try {
            // Obtener la lista de productos desde el servicio
            List<DataListProductos> productos = productosService.listar();

            // Verificar si la lista está vacía
            if (productos.isEmpty()) {
                throw new RuntimeException("No hay productos para mostrar en el reporte");
            }

            // Cargar el archivo JRXML desde el classpath
            Resource jrxmlResource = new ClassPathResource("/Reports/ProductoReport.jrxml");
            InputStream inputStream = jrxmlResource.getInputStream();

            // Compilar el archivo JRXML a JasperReport
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            // Crear el origen de datos con la lista de productos
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(productos);

            // Parámetros opcionales (si el reporte los requiere)
            Map<String, Object> parameters = new HashMap<>();

            // Llenar el reporte con datos y parámetros, y generar el JasperPrint
            parameters.put("inventoryData", dataSource);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters);

            // Exportar el JasperPrint a un arreglo de bytes (formato PDF)
            byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

            // Opcional: Obtener el JRXML generado
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            JasperExportManager.exportReportToXmlStream(jasperPrint, baos);
            String generatedJRXML = new String(baos.toByteArray(), "UTF-8");

            // Imprimir el JRXML generado en la consola o hacer otro manejo necesario
            System.out.println("JRXML generado:\n" + generatedJRXML);

            return pdfBytes;
        } catch (JRException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}