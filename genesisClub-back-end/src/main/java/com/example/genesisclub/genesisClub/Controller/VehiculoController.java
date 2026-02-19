package com.example.genesisclub.genesisClub.Controller;


import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.genesisclub.genesisClub.Modelo.DTO.ResponceDTO;
import com.example.genesisclub.genesisClub.Modelo.DTO.VehiculoDTO;
import com.example.genesisclub.genesisClub.Modelo.Entidad.VehiculoEntity;
import com.example.genesisclub.genesisClub.Servicio.VehiculoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping("/agregar")
    public ResponseEntity<VehiculoEntity> postMethodName(@RequestBody VehiculoDTO vehiculoDTO) {
        VehiculoEntity vehiculo = vehiculoService.agregarVehiculo(vehiculoDTO);
        return ResponseEntity.ok(vehiculo);
    }
    

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ResponceDTO> obtener(@PathVariable @NotNull Long id) {
    return ResponseEntity.ok(vehiculoService.obtenerVehiculoPorID(id));
}
}
