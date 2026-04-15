package com.example.genesisclub.genesisClub.Modelo.DTO;

import java.time.LocalDate;

import com.example.genesisclub.genesisClub.Modelo.Enums.CargosEnum;

import lombok.Data;

@Data
public class EmpleadoDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String codigoArea;
    private String numero;
    private String dni;
    private LocalDate fechaIngreso;
    private LocalDate fechaNacimiento;
    private CargosEnum cargo;
    private Double Saldo;

}
