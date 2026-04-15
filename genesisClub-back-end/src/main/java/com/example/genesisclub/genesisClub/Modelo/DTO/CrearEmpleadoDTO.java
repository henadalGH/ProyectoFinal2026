package com.example.genesisclub.genesisClub.Modelo.DTO;

import java.time.LocalDate;

import com.example.genesisclub.genesisClub.Modelo.Enums.CargosEnum;

import lombok.Data;

@Data
public class CrearEmpleadoDTO {

    // Datos del usuario asociado
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String codigoArea;
    private String numero;

    // Datos propios del empleado
    private String dni;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;

    // Cargo del empleado
    private CargosEnum cargo;
}
