package com.example.genesisclub.genesisClub.Servicio;

import java.time.LocalDate;
import java.util.List;

import com.example.genesisclub.genesisClub.Modelo.DTO.MovimientoDTO;
import com.example.genesisclub.genesisClub.Modelo.DTO.ResponceDTO;
import com.example.genesisclub.genesisClub.Modelo.Entidad.MovimientoFinancieroEntity;
import com.example.genesisclub.genesisClub.Modelo.Enums.MovimientosEnum;


public interface MovimientoFinService {

    List<MovimientoFinancieroEntity> getAllMovimiento();
    ResponceDTO crearMovimiento(MovimientoDTO movimiento, MovimientosEnum movimientosEnum) throws Exception;
    List<MovimientoFinancieroEntity> obtenerPorFecha(LocalDate fechDate);
    List<MovimientoFinancieroEntity> obterEntreFechas(LocalDate fechaInicio, LocalDate fechaFin);
    List<MovimientoFinancieroEntity> obtenrPorMes(int mes , int anio);
    
}
    

