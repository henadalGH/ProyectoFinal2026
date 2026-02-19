package com.example.genesisclub.genesisClub.Servicio.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.genesisclub.genesisClub.Modelo.DTO.ServiciosDTO;
import com.example.genesisclub.genesisClub.Modelo.Entidad.ServicioEntity;
import com.example.genesisclub.genesisClub.Repositorio.ServicioRepository;
import com.example.genesisclub.genesisClub.Servicio.ServicioService;



@Service
public class ServicioServiceImpl implements ServicioService {


    @Autowired
    private ServicioRepository servicioRepository;



    @Override
    public List<ServicioEntity> ontenerTodosLosServicio() {
        return servicioRepository.findAll();
    }

    @Override
    public ServiciosDTO ontenerSercicioPorId(Long id) {
        
        ServicioEntity servicio = servicioRepository.getReferenceById(id);

        ServiciosDTO dto = new ServiciosDTO();

        dto.setId(servicio.getId());
        dto.setNombre(servicio.getNombre());
        dto.setDescripcion(servicio.getDescripcion());
        dto.setDuracion(servicio.getDuracionEstimada());
        dto.setPrecioBase(servicio.getPrecion_base());



        return dto;
    }

}
