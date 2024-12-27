package com.josueao.desafio_cadastro_jogadores.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.josueao.desafio_cadastro_jogadores.web.CodinomeDTO;

public interface CodinomeRepository {

    CodinomeDTO buscarCodinomes() throws JsonMappingException, JsonProcessingException;

}
