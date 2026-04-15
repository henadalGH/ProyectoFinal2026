package com.example.genesisclub.genesisClub.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.genesisclub.genesisClub.Modelo.Entidad.EmpleadoEntity;

@Repository
public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long> {

    // Solo empleados cuyo usuario está activo (no dados de baja)
    List<EmpleadoEntity> findAllByUsuarioActivo(boolean activo);

    // Buscar un empleado por ID solo si está activo
    Optional<EmpleadoEntity> findByIdAndUsuarioActivo(Long id, boolean activo);
}



