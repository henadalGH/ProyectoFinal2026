package com.example.genesisclub.genesisClub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.genesisclub.genesisClub.Modelo.DTO.RepuestoDTO;
import com.example.genesisclub.genesisClub.Modelo.Entidad.RepuestosEntity;
import com.example.genesisclub.genesisClub.Servicio.RepuestoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/repuesto") 
public class RepuestoController {

    @Autowired
    private RepuestoService repuestoService;

    @GetMapping("/todos")
    public ResponseEntity<List<RepuestosEntity>> getRepuestos() {
        return new ResponseEntity<>(repuestoService.getAllRepuesto(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepuestoDTO> getRepustoPorId(@PathVariable Long id) {
        return new ResponseEntity<>(repuestoService.getRepuestoPorId(id), HttpStatus.OK);
    }
    
    

}
