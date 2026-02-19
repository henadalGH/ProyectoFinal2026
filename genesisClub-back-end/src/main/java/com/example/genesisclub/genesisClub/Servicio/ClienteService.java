package com.example.genesisclub.genesisClub.Servicio;

import java.util.List;

import com.example.genesisclub.genesisClub.Modelo.DTO.ClienteDTO;
import com.example.genesisclub.genesisClub.Modelo.Entidad.ClienteEntity;


public interface ClienteService {

    public List<ClienteEntity> obtenerClientes();
    public ClienteDTO obtenerClientePorId(Long id);

}
