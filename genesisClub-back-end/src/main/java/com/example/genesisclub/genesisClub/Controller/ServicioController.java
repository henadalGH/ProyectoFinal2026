package com.example.genesisclub.genesisClub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.genesisclub.genesisClub.Modelo.DTO.ServiciosDTO;
import com.example.genesisclub.genesisClub.Modelo.Entidad.ServicioEntity;
import com.example.genesisclub.genesisClub.Servicio.ServicioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/servicio")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    @GetMapping("/todos")
    public ResponseEntity<List<ServicioEntity>> getSercicios() {
        return new ResponseEntity<>(servicioService.ontenerTodosLosServicio(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiciosDTO> getServicioId(@PathVariable Long id) {
        return new ResponseEntity<>(servicioService.ontenerSercicioPorId(id), HttpStatus.OK);
    }
    
    

}
