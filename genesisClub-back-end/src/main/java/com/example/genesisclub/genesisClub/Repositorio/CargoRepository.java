package com.example.genesisclub.genesisClub.Repositorio;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.genesisclub.genesisClub.Modelo.Entidad.CargosEntity;
import com.example.genesisclub.genesisClub.Modelo.Enums.CargosEnum;

@Repository
public interface CargoRepository extends JpaRepository<CargosEntity, Long>{

    boolean existsByCargo(CargosEnum cargo);
    Optional<CargosEntity> findByCargo(CargosEnum cargo);
}
