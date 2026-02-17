package com.example.genesisclub.genesisClub.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.genesisclub.genesisClub.Modelo.Entidad.MotivoCancelacionEntity;


@Repository
public interface MotivoCancelacionRepository extends JpaRepository<MotivoCancelacionEntity, Long> {

}
