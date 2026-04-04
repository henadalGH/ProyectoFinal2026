package com.example.genesisclub.genesisClub.Modelo.DTO;

import java.time.LocalDate;
import com.example.genesisclub.genesisClub.Modelo.Enums.CargosEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmpleadoDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String codigoArea;
    private String numeroCel;
    private String dni;
    private LocalDate fechaIngreso;
    private LocalDate fechaNacimiento;
    private CargosEnum cargo;
    private Double sueldo;
    
}
