package com.example.genesisclub.genesisClub.Repositorio;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.genesisclub.genesisClub.Modelo.Entidad.MovimientoFinancieroEntity;

import java.time.LocalDate;


@Repository
public interface MovimientoFinancieroRepository extends JpaRepository<MovimientoFinancieroEntity, Long> {

    List<MovimientoFinancieroEntity> findByFechaRegistro(LocalDate fechaRegistro);
    List<MovimientoFinancieroEntity> findByFechaRegistroBetween(LocalDate fechaRegistroInicio, LocalDate fechaRegistroFin);
}
