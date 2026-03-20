package com.example.genesisclub.genesisClub.Servicio.servicioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.genesisclub.genesisClub.Modelo.DTO.RepuestoDTO;
import com.example.genesisclub.genesisClub.Modelo.Entidad.RepuestosEntity;
import com.example.genesisclub.genesisClub.Repositorio.RepuestoRepository;
import com.example.genesisclub.genesisClub.Servicio.RepuestoService;



@Service
public class RepuestoServiceImpl implements RepuestoService {

    @Autowired
    private RepuestoRepository repuestoRepository;

    @Override
    public List<RepuestosEntity> getAllRepuesto() {
        
        return repuestoRepository.findAll();
    }

    @Override
    public RepuestoDTO getRepuestoPorId(Long id) {

        if (id == null) {
        throw new IllegalArgumentException("El id no puede ser null");
    }
        RepuestosEntity repuesto = repuestoRepository.getReferenceById(id);

        RepuestoDTO repuestoDTO = new RepuestoDTO();
        repuestoDTO.setId(repuesto.getId());
        repuestoDTO.setNombre(repuesto.getNombre());
        repuestoDTO.setMarca(repuesto.getMarca());
        repuestoDTO.setCodigo(repuesto.getCodigo());


        return repuestoDTO;
    }

}
