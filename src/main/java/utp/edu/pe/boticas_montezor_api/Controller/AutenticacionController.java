package utp.edu.pe.boticas_montezor_api.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utp.edu.pe.boticas_montezor_api.Domain.Empleados.DataListEmpleado;
import utp.edu.pe.boticas_montezor_api.Domain.Empleados.Empleado;
import utp.edu.pe.boticas_montezor_api.Domain.Empleados.EmpleadoRepository;
import utp.edu.pe.boticas_montezor_api.Infra.security.*;
import utp.edu.pe.boticas_montezor_api.Mail.EmailService;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DataAuthenticationEmploy datosAutenticacionUsuario){
        String response = "El codigo fue enviado al correo electronico: "+datosAutenticacionUsuario.email();
        if (emailService.enviarCodigoOTP(datosAutenticacionUsuario.email())) return new ResponseEntity<>(response, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @PostMapping("/otpVerification")
    public ResponseEntity<?> verificarOTP(@RequestBody @Valid DataRequestValidOtp validOtp){
        Authentication authToken = new UsernamePasswordAuthenticationToken(validOtp.email(), validOtp.password());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Empleado) usuarioAutenticado.getPrincipal());
        Empleado empleado = empleadoRepository.findByEmail(validOtp.email());
        if (empleado.isActive() && empleado.getOtp() == validOtp.otp()){
            DataResponseOtp dataResponseOtp = new DataResponseOtp(new DataListEmpleado(empleado), JWTtoken);
            return new ResponseEntity<>(dataResponseOtp, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
