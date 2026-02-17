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
    private LocalDate fechaCreacion;
    private String contacto;

    //para el cliente
    private String direccion;


    //para el empleado
    private String dni;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;
    private CargosEnum cargo;
    


    private RolesEnum rol;

    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public RolesEnum getRol() {
        return rol;
    }
    public void setRol(RolesEnum rol) {
        this.rol = rol;
    }


}
