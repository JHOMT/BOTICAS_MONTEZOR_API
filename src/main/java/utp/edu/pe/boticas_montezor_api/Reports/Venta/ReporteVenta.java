package utp.edu.pe.boticas_montezor_api.Reports.Venta;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.math.BigDecimal;
import java.util.*;

public class ReporteVenta {
    public static void main(String[] args) {
        try {
            // Crear una lista de ventas
            List<VentaReport> ventas = Arrays.asList(
                    new VentaReport("Producto A", new BigDecimal("10.00"), 2),
                    new VentaReport("Producto B", new BigDecimal("15.00"), 3)
            );

            // Crear el DataSource
            VentaDataSource ventaDataSource = new VentaDataSource(ventas);

            // Compilar el reporte
            JasperReport jasperReport = JasperCompileManager.compileReport("src/main/resources/reports/VentaReport.jrxml");

            // Llenar el reporte con datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, ventaDataSource);

            // Mostrar el reporte
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
