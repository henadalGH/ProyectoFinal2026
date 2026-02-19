package com.example.genesisclub.genesisClub.Servicio;

import java.util.List;

import com.example.genesisclub.genesisClub.Modelo.DTO.EmpleadoDTO;
import com.example.genesisclub.genesisClub.Modelo.Entidad.EmpleadoEntity;


public interface EmpleadoService {

    List<EmpleadoEntity> getAllEmpleado();
    EmpleadoDTO getEmpleadoProId(Long id);
    
    
}
