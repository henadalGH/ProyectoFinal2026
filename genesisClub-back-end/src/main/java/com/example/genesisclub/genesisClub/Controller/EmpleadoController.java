package com.example.genesisclub.genesisClub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.genesisclub.genesisClub.Modelo.DTO.CrearEmpleadoDTO;
import com.example.genesisclub.genesisClub.Modelo.DTO.EmpleadoDTO;
import com.example.genesisclub.genesisClub.Servicio.EmpleadoServicio;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoServicio empleadoServicio;

    /**
     * GET /empleado
     * Retorna la lista de todos los empleados activos.
     */
    @GetMapping
    public ResponseEntity<List<EmpleadoDTO>> obtenerEmpleados() {
        List<EmpleadoDTO> empleados = empleadoServicio.obtenerEmpleados();
        return ResponseEntity.ok(empleados);
    }

    /**
     * GET /empleado/{id}
     * Retorna el detalle de un empleado activo por su ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> obtenerEmpleadoPorId(@PathVariable Long id) {
        EmpleadoDTO empleado = empleadoServicio.obtenerEmpleadoPorId(id);
        return ResponseEntity.ok(empleado);
    }

    /**
     * POST /empleado
     * Crea un nuevo empleado junto con el usuario asociado.
     */
    @PostMapping
    public ResponseEntity<EmpleadoDTO> crearEmpleado(@RequestBody CrearEmpleadoDTO dto) {
        EmpleadoDTO nuevo = empleadoServicio.crearEmpleado(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    /**
     * PUT /empleado/{id}
     * Modifica los datos de un empleado existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> modificarEmpleado(
            @PathVariable Long id,
            @RequestBody CrearEmpleadoDTO dto) {
        EmpleadoDTO actualizado = empleadoServicio.modificarEmpleado(id, dto);
        return ResponseEntity.ok(actualizado);
    }

    /**
     * PATCH /empleado/{id}/baja
     * Da de baja lógica al empleado (desactiva su usuario, no borra el registro).
     */
    @PatchMapping("/{id}/baja")
    public ResponseEntity<String> darDeBajaEmpleado(@PathVariable Long id) {
        empleadoServicio.darDeBajaEmpleado(id);
        return ResponseEntity.ok("Empleado con id " + id + " dado de baja correctamente.");
    }

    /**
     * DELETE /empleado/{id}
     * Elimina de forma permanente el empleado y su usuario de la base de datos.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEmpleado(@PathVariable Long id) {
        empleadoServicio.eliminarEmpleado(id);
        return ResponseEntity.ok("Empleado con id " + id + " eliminado correctamente.");
    }
}
