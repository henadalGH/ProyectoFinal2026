package com.example.genesisclub.genesisClub.Servicio;

import java.util.List;

import com.example.genesisclub.genesisClub.Modelo.DTO.ServiciosDTO;
import com.example.genesisclub.genesisClub.Modelo.Entidad.ServicioEntity;


public interface ServicioService {


    List<ServicioEntity> ontenerTodosLosServicio();
    ServiciosDTO ontenerSercicioPorId(Long id);

}
