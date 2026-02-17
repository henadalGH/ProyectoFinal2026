package com.example.genesisclub.genesisClub.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.genesisclub.genesisClub.Modelo.Entidad.EstadoPresupuestoEntity;

@Repository
public interface EstadoPresupuestoReposistory extends JpaRepository<EstadoPresupuestoEntity, Long> {

}
