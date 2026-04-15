package com.example.genesisclub.genesisClub.Servicio.servicioImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.genesisclub.genesisClub.Modelo.DTO.CrearEmpleadoDTO;
import com.example.genesisclub.genesisClub.Modelo.DTO.EmpleadoDTO;
import com.example.genesisclub.genesisClub.Modelo.Entidad.CargosEntity;
import com.example.genesisclub.genesisClub.Modelo.Entidad.EmpleadoEntity;
import com.example.genesisclub.genesisClub.Modelo.Entidad.RolEntity;
import com.example.genesisclub.genesisClub.Modelo.Entidad.UsuarioEntity;
import com.example.genesisclub.genesisClub.Modelo.Enums.RolesEnum;
import com.example.genesisclub.genesisClub.Repositorio.CargoRepository;
import com.example.genesisclub.genesisClub.Repositorio.EmpleadoRepository;
import com.example.genesisclub.genesisClub.Repositorio.RolRepository;
import com.example.genesisclub.genesisClub.Repositorio.UsuarioRepository;
import com.example.genesisclub.genesisClub.Servicio.EmpleadoServicio;

@Service
public class EmpleadoSerivicioImpl implements EmpleadoServicio {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // -----------------------------------------------------------------------
    // GET /empleado  →  Lista todos los empleados cuyo usuario está activo
    // -----------------------------------------------------------------------
    @Override
    public List<EmpleadoDTO> obtenerEmpleados() {
        return empleadoRepository.findAllByUsuarioActivo(true)
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // -----------------------------------------------------------------------
    // GET /empleado/{id}  →  Busca un empleado activo por su ID
    // -----------------------------------------------------------------------
    @Override
    public EmpleadoDTO obtenerEmpleadoPorId(Long id) {
        EmpleadoEntity empleado = empleadoRepository
                .findByIdAndUsuarioActivo(id, true)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con id: " + id));
        return mapToDTO(empleado);
    }

    // -----------------------------------------------------------------------
    // POST /empleado  →  Crea usuario + empleado en una misma transacción
    // -----------------------------------------------------------------------
    @Override
    @Transactional
    public EmpleadoDTO crearEmpleado(CrearEmpleadoDTO dto) {

        // Validar email único
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Ya existe un usuario con el email: " + dto.getEmail());
        }

        // Buscar el rol EMPLEADO
        RolEntity rol = rolRepository.findByNombre(RolesEnum.EMPLEADO)
                .orElseThrow(() -> new RuntimeException("Rol EMPLEADO no configurado en la base de datos"));

        // Buscar el cargo solicitado
        CargosEntity cargo = cargoRepository.findByCargo(dto.getCargo())
                .orElseThrow(() -> new RuntimeException("Cargo no encontrado: " + dto.getCargo()));

        // Crear y guardar el usuario
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNombre(dto.getNombre());
        usuario.setApellido(dto.getApellido());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        usuario.setCodigoArea(dto.getCodigoArea());
        usuario.setNumero(dto.getNumero());
        usuario.setFechaCreacion(LocalDate.now());
        usuario.setRol(rol);
        usuario.setActivo(true);
        UsuarioEntity usuarioGuardado = usuarioRepository.save(usuario);

        // Crear y guardar el empleado vinculado al usuario
        EmpleadoEntity empleado = new EmpleadoEntity();
        empleado.setUsuario(usuarioGuardado);
        empleado.setDni(dto.getDni());
        empleado.setFechaNacimiento(dto.getFechaNacimiento());
        empleado.setFechaIngreso(dto.getFechaIngreso());
        empleado.setCargo(cargo);

        return mapToDTO(empleadoRepository.save(empleado));
    }

    // -----------------------------------------------------------------------
    // PUT /empleado/{id}  →  Modifica datos del empleado (actualización parcial)
    // -----------------------------------------------------------------------
    @Override
    @Transactional
    public EmpleadoDTO modificarEmpleado(Long id, CrearEmpleadoDTO dto) {

        EmpleadoEntity empleado = empleadoRepository
                .findByIdAndUsuarioActivo(id, true)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con id: " + id));

        UsuarioEntity usuario = empleado.getUsuario();

        // Actualizar sólo los campos que vienen en el DTO (no nulos)
        if (dto.getNombre() != null)     usuario.setNombre(dto.getNombre());
        if (dto.getApellido() != null)   usuario.setApellido(dto.getApellido());
        if (dto.getCodigoArea() != null) usuario.setCodigoArea(dto.getCodigoArea());
        if (dto.getNumero() != null)     usuario.setNumero(dto.getNumero());

        // Cambiar email solo si es diferente y no está en uso
        if (dto.getEmail() != null && !dto.getEmail().equals(usuario.getEmail())) {
            if (usuarioRepository.existsByEmail(dto.getEmail())) {
                throw new RuntimeException("El email ya está en uso: " + dto.getEmail());
            }
            usuario.setEmail(dto.getEmail());
        }

        // Cambiar contraseña solo si se envía una nueva
        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        usuarioRepository.save(usuario);

        // Actualizar datos propios del empleado
        if (dto.getDni() != null)              empleado.setDni(dto.getDni());
        if (dto.getFechaNacimiento() != null)  empleado.setFechaNacimiento(dto.getFechaNacimiento());
        if (dto.getFechaIngreso() != null)     empleado.setFechaIngreso(dto.getFechaIngreso());

        // Cambiar cargo si se indica
        if (dto.getCargo() != null) {
            CargosEntity cargo = cargoRepository.findByCargo(dto.getCargo())
                    .orElseThrow(() -> new RuntimeException("Cargo no encontrado: " + dto.getCargo()));
            empleado.setCargo(cargo);
        }

        return mapToDTO(empleadoRepository.save(empleado));
    }

    // -----------------------------------------------------------------------
    // PATCH /empleado/{id}/baja  →  Baja lógica: desactiva el usuario
    // -----------------------------------------------------------------------
    @Override
    @Transactional
    public void darDeBajaEmpleado(Long id) {
        EmpleadoEntity empleado = empleadoRepository
                .findByIdAndUsuarioActivo(id, true)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado o ya dado de baja. Id: " + id));

        empleado.getUsuario().setActivo(false);
        usuarioRepository.save(empleado.getUsuario());
    }

    // -----------------------------------------------------------------------
    // DELETE /empleado/{id}  →  Elimina permanentemente empleado y usuario
    // -----------------------------------------------------------------------
    @Override
    @Transactional
    public void eliminarEmpleado(Long id) {
        EmpleadoEntity empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado con id: " + id));

        UsuarioEntity usuario = empleado.getUsuario();
        empleadoRepository.delete(empleado);
        usuarioRepository.delete(usuario);
    }

    // -----------------------------------------------------------------------
    // Mapper interno: EmpleadoEntity → EmpleadoDTO
    // -----------------------------------------------------------------------
    private EmpleadoDTO mapToDTO(EmpleadoEntity entity) {
        EmpleadoDTO dto = new EmpleadoDTO();
        if (entity.getUsuario() != null) {
            dto.setId(entity.getId());
            dto.setNombre(entity.getUsuario().getNombre());
            dto.setApellido(entity.getUsuario().getApellido());
            dto.setEmail(entity.getUsuario().getEmail());
            dto.setCodigoArea(entity.getUsuario().getCodigoArea());
            dto.setNumero(entity.getUsuario().getNumero());
            dto.setDni(entity.getDni());
            dto.setFechaNacimiento(entity.getFechaNacimiento());
            dto.setFechaIngreso(entity.getFechaIngreso());
            if (entity.getCargo() != null) {
                dto.setCargo(entity.getCargo().getCargo());
                dto.setSaldo(entity.getCargo().getSueldoBase());
            }
        }
        return dto;
    }
}
