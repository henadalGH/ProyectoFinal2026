package com.example.genesisclub.genesisClub.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.genesisclub.genesisClub.Modelo.Entidad.RolEntity;
import com.example.genesisclub.genesisClub.Modelo.Enums.RolesEnum;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Long>{

    boolean existsByNombre(RolesEnum nombre);

    Optional<RolEntity> findByNombre(RolesEnum nombre);

}
