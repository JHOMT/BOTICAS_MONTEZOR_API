package utp.edu.pe.boticas_montezor_api.Utils;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.DataListProductos;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductoReportGenerator {

    public byte[] exportToPdf(List<DataListProductos> list) {
        try {
            JasperPrint jasperPrint = getReport(list);
            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (JRException e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] exportToXls(List<DataListProductos> list) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            JasperPrint jasperPrint = getReport(list);
            JRXlsExporter exporter = new JRXlsExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(byteArrayOutputStream));
            exporter.exportReport();
        } catch (JRException e) {
            e.printStackTrace();
        } finally {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private JasperPrint getReport(List<DataListProductos> list) {
        JasperPrint jasperPrint = null;
        try {
            File file = ResourceUtils.getFile("classpath:Reports/ProductoReport.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("productoDataSet", new JRBeanCollectionDataSource(list));
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
        } catch (FileNotFoundException | JRException e) {
            e.printStackTrace();
        }
        return jasperPrint;
    }
}
