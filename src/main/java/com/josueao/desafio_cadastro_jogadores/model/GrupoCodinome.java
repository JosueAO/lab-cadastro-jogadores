package com.josueao.desafio_cadastro_jogadores.model;

public enum GrupoCodinome {
    VINGADORES("Vingadores",
            "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json"),
    LIGA_DA_JUSTICA("Liga da Justiça",
            "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml");

    private GrupoCodinome(String nome, String url) {
        this.nome = nome;
        this.url = url;
    }

    private final String nome;
    private final String url;

    public String getNome() {
        return nome;
    }

    public String getUrl() {
        return url;
    }

}
