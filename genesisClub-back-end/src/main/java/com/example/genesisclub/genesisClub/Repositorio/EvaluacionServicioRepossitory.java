package com.example.genesisclub.genesisClub.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.genesisclub.genesisClub.Modelo.Entidad.EvalucionServicioEntity;


@Repository
public interface EvaluacionServicioRepossitory extends JpaRepository<EvalucionServicioEntity, Long> {

}
