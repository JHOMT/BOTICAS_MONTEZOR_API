package utp.edu.pe.boticas_montezor_api.Reports.Venta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import java.util.Iterator;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDataSource implements JRDataSource {
    private Iterator<VentaReport> ventaIterator;
    private VentaReport currentVenta;

    public VentaDataSource(List<VentaReport> ventas) {
        this.ventaIterator = ventas.iterator();
    }

    @Override
    public boolean next() throws JRException {
        if (ventaIterator.hasNext()) {
            currentVenta = ventaIterator.next();
            return true;
        }
        return false;
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {
        String fieldName = jrField.getName();
        switch (fieldName) {
            case "nombre":
                return currentVenta.getNombre();
            case "precioUnitario":
                return currentVenta.getPrecioUnitario();
            case "cantidad":
                return currentVenta.getCantidad();
            default:
                return null;
        }
    }
}
