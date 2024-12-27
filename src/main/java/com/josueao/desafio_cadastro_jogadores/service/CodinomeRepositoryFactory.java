package com.josueao.desafio_cadastro_jogadores.service;

import org.springframework.stereotype.Component;

import com.josueao.desafio_cadastro_jogadores.model.GrupoCodinome;
import com.josueao.desafio_cadastro_jogadores.repository.CodinomeRepository;
import com.josueao.desafio_cadastro_jogadores.repository.LigaDaJusticaRepository;
import com.josueao.desafio_cadastro_jogadores.repository.VingadoresRepository;

@Component
public class CodinomeRepositoryFactory {

    private final LigaDaJusticaRepository ligaDaJusticaRepository;
    private final VingadoresRepository vingadoresRepository;

    public CodinomeRepositoryFactory(LigaDaJusticaRepository ligaDaJusticaRepository,
            VingadoresRepository vingadoresRepository) {
        this.ligaDaJusticaRepository = ligaDaJusticaRepository;
        this.vingadoresRepository = vingadoresRepository;
    }

    public CodinomeRepository create(GrupoCodinome grupoCodinome) {
        return switch (grupoCodinome) {
            case LIGA_DA_JUSTICA ->
                ligaDaJusticaRepository;
            case VINGADORES ->
                vingadoresRepository;
        };
    }
}
