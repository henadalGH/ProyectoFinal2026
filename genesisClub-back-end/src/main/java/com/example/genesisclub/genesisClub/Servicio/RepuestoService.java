package com.example.genesisclub.genesisClub.Servicio;

import java.util.List;

import com.example.genesisclub.genesisClub.Modelo.DTO.RepuestoDTO;
import com.example.genesisclub.genesisClub.Modelo.Entidad.RepuestosEntity;


public interface RepuestoService {

    List<RepuestosEntity> getAllRepuesto();
    RepuestoDTO getRepuestoPorId(Long id);

}
