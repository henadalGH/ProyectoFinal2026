package com.example.genesisclub.genesisClub.Servicio;

import java.util.List;

import com.example.genesisclub.genesisClub.Modelo.DTO.CrearEmpleadoDTO;
import com.example.genesisclub.genesisClub.Modelo.DTO.EmpleadoDTO;

public interface EmpleadoServicio {

    // Listar todos los empleados activos
    List<EmpleadoDTO> obtenerEmpleados();

    // Obtener un empleado por ID
    EmpleadoDTO obtenerEmpleadoPorId(Long id);

    // Crear un nuevo empleado junto con su usuario
    EmpleadoDTO crearEmpleado(CrearEmpleadoDTO dto);

    // Modificar datos de un empleado existente
    EmpleadoDTO modificarEmpleado(Long id, CrearEmpleadoDTO dto);

    // Dar de baja (eliminación lógica) a un empleado
    void darDeBajaEmpleado(Long id);

    // Eliminar un empleado de forma permanente
    void eliminarEmpleado(Long id);
}
