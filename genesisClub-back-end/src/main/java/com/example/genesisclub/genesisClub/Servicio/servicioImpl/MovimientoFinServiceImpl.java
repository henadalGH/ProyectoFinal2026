package com.example.genesisclub.genesisClub.Servicio.servicioImpl;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.genesisclub.genesisClub.Modelo.DTO.MovimientoDTO;
import com.example.genesisclub.genesisClub.Modelo.DTO.ResponceDTO;
import com.example.genesisclub.genesisClub.Modelo.Entidad.MovimientoFinancieroEntity;
import com.example.genesisclub.genesisClub.Modelo.Enums.MovimientosEnum;
import com.example.genesisclub.genesisClub.Repositorio.MovimientoFinancieroRepository;
import com.example.genesisclub.genesisClub.Servicio.MovimientoFinService;

@Service
public class MovimientoFinServiceImpl implements MovimientoFinService {

    @Autowired
    private MovimientoFinancieroRepository movimientoFinancieroRepository;

    @Override
    public List<MovimientoFinancieroEntity> getAllMovimiento() {
        
        return movimientoFinancieroRepository.findAll();
    }


    @Override
    public ResponceDTO crearMovimiento(MovimientoDTO movimiento, MovimientosEnum movimientosEnum) throws Exception {
        

        try {

            ResponceDTO responce = new ResponceDTO();

            MovimientoFinancieroEntity movimientos = new MovimientoFinancieroEntity();
            movimientos.setTipo_movimiento(movimientosEnum);
            movimientos.setCategoria(movimiento.getCategoria());
            movimientos.setConcepto(movimiento.getConcepto());
            movimientos.setImporte(movimiento.getImporte());
            movimientos.setFechaRegistro(LocalDate.now());
            
            movimientoFinancieroRepository.save(movimientos);

            responce.setMensage("Ya se registro el: " + movimientos.getTipo_movimiento());

            return responce;

        } catch (Exception e) {
            throw new Exception(e.toString());
        }
        
    }


    @Override
    public List<MovimientoFinancieroEntity> obtenerPorFecha(LocalDate fechDate) {
        return movimientoFinancieroRepository.findByFechaRegistro(fechDate);
    }


    @Override
    public List<MovimientoFinancieroEntity> obterEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return movimientoFinancieroRepository.findByFechaRegistroBetween(fechaInicio, fechaFin);
    }


    @Override
    public List<MovimientoFinancieroEntity> obtenrPorMes(int mes, int anio) {
        
        LocalDate inicio = LocalDate.of(anio, mes, 1);
        LocalDate fin = inicio.withDayOfMonth(inicio.lengthOfMonth());

        return movimientoFinancieroRepository.findByFechaRegistroBetween(inicio, fin);
        
    }


}
