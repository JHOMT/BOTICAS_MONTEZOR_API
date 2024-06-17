package utp.edu.pe.boticas_montezor_api.Services;

import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.edu.pe.boticas_montezor_api.Domain.Empleados.*;
import utp.edu.pe.boticas_montezor_api.Domain.Roles.Rol;
import utp.edu.pe.boticas_montezor_api.Domain.Roles.RolRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalService {
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private RolRepository rolRepository;

    @Transactional
    public Boolean registerEmployee(@NotNull DataRegisterEmpleado data) {
        Optional<Empleado> empleado = Optional.of(empleadoRepository.findById(data.adminId()))
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        if (!empleado.get().getRol().getNombre().equals("Administrador")) {
            throw new RuntimeException("No tiene permisos para registrar empleados");
        }
        Optional<Rol> rol = Optional.ofNullable(rolRepository.findById(data.rol())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado")));

        Empleado empleadoSave = new Empleado(data);
        empleadoSave.setRol(rol.get());
        empleadoRepository.save(empleadoSave);
        return true;
    }

    public Optional<Empleado> getEmployee(Long id) {
        return empleadoRepository.findById(id);
    }

    public List<DataListEmpleado> getEmployees() {
        return empleadoRepository.findAll().stream().map(DataListEmpleado::new).toList();
    }

    public DataListEmpleado loginEmployee(DataLoginEmpleado data) {
        Optional<Empleado> empleado = Optional.ofNullable(empleadoRepository.findByUsuario(data.usuario()))
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (empleado.get().getTelefono().equals(data.telefono())) {
            return new DataListEmpleado(empleado.get());
        } else {
            throw new RuntimeException("Contraseña incorrecta");
        }

    }
}
