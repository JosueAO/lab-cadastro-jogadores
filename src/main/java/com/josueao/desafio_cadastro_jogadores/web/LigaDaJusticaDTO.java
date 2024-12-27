package com.josueao.desafio_cadastro_jogadores.web;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "liga_da_justica") // Elemento raiz do XML
public record LigaDaJusticaDTO(
        @JacksonXmlProperty(localName = "codinomes") // Elemento que contém a lista
        CodinomesDTO codinomes // A lista de codinomes agora como objeto
        ) implements CodinomeDTO {

    @Override
    public List<String> getCodinomes() {
        return codinomes.codinome();
    }
}

record CodinomesDTO(
        @JacksonXmlElementWrapper(useWrapping = false) // Não usar um wrapper adicional
        @JacksonXmlProperty(localName = "codinome") // Nome do elemento individual
        List<String> codinome // Nome da propriedade que representa a lista
        ) {

}
