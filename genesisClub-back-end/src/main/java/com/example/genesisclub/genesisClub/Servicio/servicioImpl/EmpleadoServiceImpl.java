package com.example.genesisclub.genesisClub.Servicio.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.genesisclub.genesisClub.Modelo.DTO.EmpleadoDTO;
import com.example.genesisclub.genesisClub.Modelo.Entidad.EmpleadoEntity;
import com.example.genesisclub.genesisClub.Repositorio.EmpleadoRepository;
import com.example.genesisclub.genesisClub.Servicio.EmpleadoService;


@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<EmpleadoDTO> getAllEmpleado() {
        return empleadoRepository.findAll()
        
        .stream()
            .map(emp -> new EmpleadoDTO(
                    emp.getUsuario().getNombre(),
                    emp.getUsuario().getApellido(),
                    emp.getUsuario().getEmail(),
                    emp.getUsuario().getCodigoArea(),
                    emp.getUsuario().getNumeroCel(),
                    emp.getDni(),
                    emp.getFechaIngreso(),
                    emp.getFechaNacimiento(),
                    emp.getCargo().getCargo(),
                    emp.getCargo().getSueldoBase()
            ))
            .toList();
    }

    @Override
    public EmpleadoDTO getEmpleadoProId(Long id) {

        try {
            EmpleadoEntity empleado = empleadoRepository.getReferenceById(id);

            // acá recién puede explotar si no existe
            empleado.getId(); // fuerza la carga

            EmpleadoDTO empleados = new EmpleadoDTO();
            empleados.setNombre(empleado.getUsuario().getNombre());
            empleados.setApellido(empleado.getUsuario().getApellido());
            empleados.setEmail(empleado.getUsuario().getEmail());
            empleados.setDni(empleado.getDni());
            empleados.setCodigoArea(empleado.getUsuario().getCodigoArea());
            empleados.setNumeroCel(empleado.getUsuario().getNumeroCel());
            empleados.setFechaIngreso(empleado.getFechaIngreso());
            empleados.setFechaNacimiento(empleado.getFechaNacimiento());
            empleados.setCargo(empleado.getCargo().getCargo());
            empleados.setSueldo(empleado.getCargo().getSueldoBase());

            return empleados;

        } catch (jakarta.persistence.EntityNotFoundException e) {
            throw new RuntimeException("Empleado no encontrado con id: " + id);

        } catch (Exception e) {
            throw new RuntimeException("Error al obtener empleado", e);
        }
    }

}
