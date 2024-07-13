package utp.edu.pe.boticas_montezor_api.Infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import utp.edu.pe.boticas_montezor_api.Domain.Empleados.EmpleadoRepository;

@Service
public class AutenticacionService implements UserDetailsService {
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return empleadoRepository.findByEmail(username);
    }
}
