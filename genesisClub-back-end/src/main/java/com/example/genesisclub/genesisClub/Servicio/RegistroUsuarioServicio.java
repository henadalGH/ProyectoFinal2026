package com.example.genesisclub.genesisClub.Servicio;

import com.example.genesisclub.genesisClub.Modelo.DTO.RegistroDTO;
import com.example.genesisclub.genesisClub.Modelo.DTO.ResponceDTO;

public interface RegistroUsuarioServicio {

    public ResponceDTO registrarUsuario(RegistroDTO usuarioDTO) throws Exception;

}
