package com.tiago.netflix.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosFilme(
    @JsonAlias("title") String titulo,
    @JsonAlias("overview") String visaoGeral,
    @JsonAlias("vote_average") String mediaAvaliacoes) {

}
