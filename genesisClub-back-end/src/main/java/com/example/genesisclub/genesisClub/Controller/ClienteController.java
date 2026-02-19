package com.example.genesisclub.genesisClub.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.genesisclub.genesisClub.Modelo.DTO.ClienteDTO;
import com.example.genesisclub.genesisClub.Modelo.Entidad.ClienteEntity;
import com.example.genesisclub.genesisClub.Servicio.ClienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/cliente")
public class ClienteController {
 
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/todos")
    public ResponseEntity<List<ClienteEntity>> obtenerClientes() {
        return new ResponseEntity<>(clienteService.obtenerClientes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtenerClientePorID(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.obtenerClientePorId(id));
    }
    
    
}
