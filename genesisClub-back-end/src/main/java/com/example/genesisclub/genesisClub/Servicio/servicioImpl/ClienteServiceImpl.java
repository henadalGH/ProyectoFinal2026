package com.example.genesisclub.genesisClub.Servicio.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.genesisclub.genesisClub.Modelo.DTO.ClienteDTO;
import com.example.genesisclub.genesisClub.Modelo.Entidad.ClienteEntity;
import com.example.genesisclub.genesisClub.Modelo.Entidad.UsuarioEntity;
import com.example.genesisclub.genesisClub.Repositorio.ClienteRepository;
import com.example.genesisclub.genesisClub.Servicio.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteEntity> obtenerClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteDTO obtenerClientePorId(Long id) {
        ClienteEntity cliente = clienteRepository.getReferenceById(id);

        ClienteDTO dto = new ClienteDTO();

        dto.setId(cliente.getId_cliente());

        UsuarioEntity usuario = cliente.getUsuario();
        dto.setNombre(usuario.getNombre());
        dto.setApellido(usuario.getApellido());
        dto.setEmail(usuario.getEmail());
        dto.setDireccion(cliente.getDireccion());
        dto.setContacto(usuario.getContacto());

        return dto;
    }
    
}
