package utp.edu.pe.boticas_montezor_api.Implement;

import net.sf.jasperreports.engine.JRException;
import java.io.FileNotFoundException;

public interface ProductoInterface {
    byte[] exportPdf() throws JRException, FileNotFoundException;
    byte[] exportXls() throws JRException, FileNotFoundException;
}
