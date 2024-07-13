package utp.edu.pe.boticas_montezor_api.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import utp.edu.pe.boticas_montezor_api.Domain.Empleados.Empleado;
import utp.edu.pe.boticas_montezor_api.Domain.Empleados.EmpleadoRepository;

@Service
public class EmailService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private JavaMailSender emailSender;

    public boolean enviarCodigoOTP(String email) {
        try {
            Empleado empleado = empleadoRepository.findByEmail(email);
            int randomPIN = (int) (Math.random() * 9000) + 1000;
            empleado.setOtp(randomPIN);
            empleado.setActive(true);
            empleadoRepository.save(empleado);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("boticasmontezor2000@gmail.com");
            message.setTo(empleado.getCorreo());
            message.setSubject("Código OTP");
            message.setText("Su código OTP es: " + randomPIN);
            emailSender.send(message);
            return true;
        } catch (MailException e) {
            System.err.println("Error al enviar el correo: " + e.getMessage());
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
