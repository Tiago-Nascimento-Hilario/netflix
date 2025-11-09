package com.tiago.netflix.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiago.netflix.model.DadosFilme;
import com.tiago.netflix.service.ConsumoAPI;
import com.tiago.netflix.service.ConverteDados;
import com.tiago.netflix.service.DadosFilmeResposta;

@RestController
@CrossOrigin(origins = "*")
public class NetFlixController {

    private final ConsumoAPI consumoAPI = new ConsumoAPI();
    private final ConverteDados converteDados = new ConverteDados();


    @GetMapping("/filmes")
    public List<DadosFilme> obiterFilmes() {
        String endereco = "https://api.themoviedb.org/3/trending/movie/day?language=en-US";
        String json = consumoAPI.obterDados(endereco);

        System.out.println(json);

        DadosFilmeResposta resposta = converteDados.obterDados(json, DadosFilmeResposta.class);
        return resposta.filmes();

    }

}
