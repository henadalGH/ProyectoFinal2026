package com.example.genesisclub.genesisClub.Servicio.servicioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.genesisclub.genesisClub.Modelo.DTO.ResponceDTO;
import com.example.genesisclub.genesisClub.Modelo.DTO.VehiculoDTO;
import com.example.genesisclub.genesisClub.Modelo.Entidad.VehiculoEntity;
import com.example.genesisclub.genesisClub.Repositorio.VehiculoRepository;
import com.example.genesisclub.genesisClub.Servicio.VehiculoService;

import lombok.NonNull;

@Service
public class VehiculoServiceImpl implements VehiculoService{

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public VehiculoEntity agregarVehiculo(VehiculoDTO vehiculoDTO) {
        
        if (vehiculoRepository.existsByPatente(vehiculoDTO.getPatente())) {
            throw new RuntimeException("La patente ya se encuestra registrada");
        }

        VehiculoEntity vehiculo = new VehiculoEntity();
        vehiculo.setMarca(vehiculoDTO.getMarca());
        vehiculo.setModelo(vehiculoDTO.getModelo());
        vehiculo.setAnio(vehiculoDTO.getAnio());
        vehiculo.setPatente(vehiculoDTO.getPatente());
        vehiculo.setKilometraje(vehiculoDTO.getKilometraje());


        return vehiculoRepository.save(vehiculo);
    }

    @Override
public ResponceDTO obtenerVehiculoPorID(@NonNull Long id) {

    ResponceDTO response = new ResponceDTO();

    VehiculoEntity vehiculo = vehiculoRepository.findById(id).orElse(null);

    if (vehiculo == null) {
        response.setNumOfErrors(1);
        response.setMensage("Vehículo no encontrado");
        return response;
    }

    response.setNumOfErrors(0);
    response.setMensage("Vehículo obtenido correctamente");
    

    return response;
}

    
}
