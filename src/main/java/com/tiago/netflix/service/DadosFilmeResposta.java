package com.tiago.netflix.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tiago.netflix.model.DadosFilme;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosFilmeResposta(@JsonAlias("results") List<DadosFilme> filmes) {
    
}
