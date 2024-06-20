package utp.edu.pe.boticas_montezor_api.Implement;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.DataListProductos;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.Producto;
import utp.edu.pe.boticas_montezor_api.Domain.Productos.ProductoRepository;
import utp.edu.pe.boticas_montezor_api.Utils.ProductoReportGenerator;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportImplement implements ProductoInterface {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoReportGenerator productoReportGenerator;

    @Override
    public byte[] exportPdf(){
        List<Producto> productos = productoRepository.findAll();
        List<DataListProductos> dataListProductos = productos.stream()
                .map(DataListProductos::new)
                .collect(Collectors.toList());
        return productoReportGenerator.exportToPdf(dataListProductos);
    }

    @Override
    public byte[] exportXls() {
        List<Producto> productos = productoRepository.findAll();
        List<DataListProductos> dataListProductos = productos.stream()
                .map(DataListProductos::new)
                .collect(Collectors.toList());
        return productoReportGenerator.exportToXls(dataListProductos);
    }
}
