package com.example.genesisclub.genesisClub.Modelo.Entidad;


import com.example.genesisclub.genesisClub.Modelo.Enums.EstadoOrdenEnums;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "estado_orden", schema = "wmotorpro")
public class EstadoOrdenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden")
    private Long id;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadoOrdenEnums estadoOrden;
}
