package com.example.genesisclub.genesisClub.Modelo.DTO;

import lombok.Data;

@Data
public class ClienteDTO {

    private Long id;
    private String direccion;

    //Datos del usuario
    private String nombre;
    private String apellido;
    private String email;
    private String codigoArea;
    private String numeroCel;
    
}
