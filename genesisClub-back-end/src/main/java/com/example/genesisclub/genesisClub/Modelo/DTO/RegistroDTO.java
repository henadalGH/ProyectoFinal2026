package com.example.genesisclub.genesisClub.Modelo.DTO;

import java.time.LocalDate;

import com.example.genesisclub.genesisClub.Modelo.Enums.CargosEnum;
import com.example.genesisclub.genesisClub.Modelo.Enums.RolesEnum;

import lombok.Data;

@Data
public class RegistroDTO {
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String codigoArea;
    private String numero;
    private LocalDate fechaCreacion;
    
    //para el cliente
    private String direccion;


    //para el empleado
    private String dni;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;
    private CargosEnum cargo;
    
    private RolesEnum rol;

}
