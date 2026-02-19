package com.example.genesisclub.genesisClub.Servicio;

import com.example.genesisclub.genesisClub.Modelo.DTO.ResponceDTO;
import com.example.genesisclub.genesisClub.Modelo.DTO.VehiculoDTO;
import com.example.genesisclub.genesisClub.Modelo.Entidad.VehiculoEntity;

public interface VehiculoService {

    public VehiculoEntity agregarVehiculo(VehiculoDTO vehiculoDTO);
    
    ResponceDTO obtenerVehiculoPorID(Long id);
}
