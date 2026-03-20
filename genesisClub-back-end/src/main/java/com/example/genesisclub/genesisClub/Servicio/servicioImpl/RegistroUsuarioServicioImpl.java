package com.example.genesisclub.genesisClub.Servicio.servicioImpl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.genesisclub.genesisClub.Modelo.DTO.RegistroDTO;
import com.example.genesisclub.genesisClub.Modelo.DTO.ResponceDTO;
import com.example.genesisclub.genesisClub.Modelo.Entidad.AdminEntity;
import com.example.genesisclub.genesisClub.Modelo.Entidad.CargosEntity;
import com.example.genesisclub.genesisClub.Modelo.Entidad.ClienteEntity;
import com.example.genesisclub.genesisClub.Modelo.Entidad.EmpleadoEntity;
import com.example.genesisclub.genesisClub.Modelo.Entidad.RolEntity;
import com.example.genesisclub.genesisClub.Modelo.Entidad.UsuarioEntity;
import com.example.genesisclub.genesisClub.Modelo.Enums.CargosEnum;
import com.example.genesisclub.genesisClub.Modelo.Enums.RolesEnum;
import com.example.genesisclub.genesisClub.Repositorio.AdminRepository;
import com.example.genesisclub.genesisClub.Repositorio.CargoRepository;
import com.example.genesisclub.genesisClub.Repositorio.ClienteRepository;
import com.example.genesisclub.genesisClub.Repositorio.EmpleadoRepository;
import com.example.genesisclub.genesisClub.Repositorio.RolRepository;
import com.example.genesisclub.genesisClub.Repositorio.UsuarioRepository;
import com.example.genesisclub.genesisClub.Servicio.RegistroUsuarioServicio;
 
import jakarta.transaction.Transactional;

@Service
public class RegistroUsuarioServicioImpl implements RegistroUsuarioServicio {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private CargoRepository cargoRepository; 

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private AdminRepository adminRepository;


    @Override
    @Transactional
    public ResponceDTO registrarUsuario(RegistroDTO usuarioDTO) throws Exception {

        ResponceDTO response = new ResponceDTO();

        // =========================
        // VALIDACIONES
        // =========================
        if (usuarioDTO.getEmail() == null || usuarioDTO.getEmail().isBlank())
            throw new Exception("Email obligatorio");

        if (usuarioRepository.existsByEmail(usuarioDTO.getEmail())) {
            response.setNumOfErrors(1);
            response.setMensage("El email ya existe");
            return response;
        }

        RolesEnum rolEnum = usuarioDTO.getRol();
        CargosEnum cargoEnum = usuarioDTO.getCargo();

        if (rolEnum == null)
            throw new Exception("Debe especificar un rol");


        // =========================
        // CREAR USUARIO
        // =========================
        UsuarioEntity nuevoUsuario = new UsuarioEntity();

        nuevoUsuario.setNombre(usuarioDTO.getNombre());
        nuevoUsuario.setApellido(usuarioDTO.getApellido());
        nuevoUsuario.setEmail(usuarioDTO.getEmail());
        nuevoUsuario.setCodigoArea(usuarioDTO.getCodigoArea());
        nuevoUsuario.setNumeroCel(usuarioDTO.getNumeroCel());
        nuevoUsuario.setFechaCreacion(LocalDate.now());

        // ✅ Encriptación SIMPLE (como vos querías)
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
        nuevoUsuario.setPassword(encoder.encode(usuarioDTO.getPassword()));


        // =========================
        // ASIGNAR ROL
        // =========================
        RolEntity rol = rolRepository.findByNombre(rolEnum)
                .orElseThrow(() -> new Exception("Rol no encontrado: " + rolEnum));

        nuevoUsuario.setRol(rol);

        usuarioRepository.save(nuevoUsuario);


        // =========================
        // RELACIÓN SEGÚN ROL
        // =========================
        switch (rolEnum) {

            case ADMIN -> {
                AdminEntity admin = new AdminEntity();
                admin.setUsuario(nuevoUsuario);
                adminRepository.save(admin);
            }

            case CLIENTE -> {
                ClienteEntity cliente = new ClienteEntity();
                cliente.setDireccion(usuarioDTO.getDireccion());
                cliente.setUsuario(nuevoUsuario);
                clienteRepository.save(cliente);
            }

            case EMPLEADO -> {

                if (cargoEnum == null)
                    throw new Exception("Empleado requiere cargo");

                CargosEntity cargo = cargoRepository.findByCargo(cargoEnum)
                        .orElseThrow(() -> new Exception("Cargo no encontrado: " + cargoEnum));

                EmpleadoEntity empleado = new EmpleadoEntity();
                empleado.setUsuario(nuevoUsuario);
                empleado.setFechaNacimiento(usuarioDTO.getFechaNacimiento());
                empleado.setFechaIngreso(LocalDate.now());
                empleado.setDni(usuarioDTO.getDni());
                empleado.setCargo(cargo);

                empleadoRepository.save(empleado);
            }

            default -> throw new Exception("Rol no soportado");
        }

        response.setMensage("Usuario registrado correctamente");
        return response;
    }
}
