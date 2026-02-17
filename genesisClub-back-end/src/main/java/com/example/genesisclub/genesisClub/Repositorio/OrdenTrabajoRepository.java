package com.example.genesisclub.genesisClub.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.genesisclub.genesisClub.Modelo.Entidad.OrdenTrabajoEntity;

@Repository
public interface OrdenTrabajoRepository extends JpaRepository<OrdenTrabajoEntity, Long>{

}
