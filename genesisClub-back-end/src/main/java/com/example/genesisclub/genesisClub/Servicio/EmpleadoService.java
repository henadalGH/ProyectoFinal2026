package com.example.genesisclub.genesisClub.Servicio;

import java.util.List;

import com.example.genesisclub.genesisClub.Modelo.DTO.EmpleadoDTO;


public interface EmpleadoService {

    List<EmpleadoDTO> getAllEmpleado();
    EmpleadoDTO getEmpleadoProId(Long id);
    
    
}
