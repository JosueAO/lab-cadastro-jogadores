package com.josueao.desafio_cadastro_jogadores.service;

import java.util.List;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.josueao.desafio_cadastro_jogadores.model.Jogador;
import com.josueao.desafio_cadastro_jogadores.model.GrupoCodinome;
import com.josueao.desafio_cadastro_jogadores.repository.JogadorRepository;

@Service
@EnableCaching
public class JogadorService {

    private final JogadorRepository jogadorRepository;
    private final CodinomeService codinomeService;

    public JogadorService(JogadorRepository jogadorRepository, CodinomeService codinomeService) {
        this.jogadorRepository = jogadorRepository;
        this.codinomeService = codinomeService;
    }

    public Jogador registrarJogador(Jogador jogador) throws Exception {
        var codinomesEmUso = listarCodinomesEmUso(jogador.grupoCodinome());
        var novoCodinome = codinomeService.gerarCodinome(jogador.grupoCodinome(), codinomesEmUso);
        var novoJogador = new Jogador(jogador.nome(), jogador.email(), jogador.telefone(), novoCodinome, jogador.grupoCodinome());

        return jogadorRepository.salvar(novoJogador);
    }

    public List<Jogador> listarJogadores() {
        return jogadorRepository.listarJogadores();
    }

    private List<String> listarCodinomesEmUso(GrupoCodinome grupoCodinome) {
        var codinomesEmUso = jogadorRepository.listarCodinomesEmUso(grupoCodinome);

        return codinomesEmUso;
    }

}
