package com.tiago.netflix;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tiago.netflix.service.ConsumoAPI;
import com.tiago.netflix.service.ConverteDados;
import com.tiago.netflix.service.DadosFilmeResposta;

@SpringBootApplication
public class NetflixApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NetflixApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		ConsumoAPI consumoAPI = new ConsumoAPI();
		String endereco = "https://api.themoviedb.org/3/trending/movie/day?language=en-US";
		String json = consumoAPI.obterDados(endereco);
		
		ConverteDados conversor = new ConverteDados();

		DadosFilmeResposta resposta = conversor.obterDados(json, DadosFilmeResposta.class);

		System.out.println(resposta.filmes().get(0).titulo());
		

	}

}
