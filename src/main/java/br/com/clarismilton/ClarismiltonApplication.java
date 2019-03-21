package br.com.clarismilton;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import br.com.clarismilton.utils.SenhaUtils;

@SpringBootApplication
@EnableCaching
public class ClarismiltonApplication {
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	public static void main(String[] args) {
		SpringApplication.run(ClarismiltonApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			
			System.out.println("### Quantidade de elementos por página = " + this.qtdPorPagina);
			
			String senhaEncoded = SenhaUtils.gerarBCrypt("100Senha");
			System.out.println("Senha Criptografada: " + senhaEncoded);
			
			senhaEncoded = SenhaUtils.gerarBCrypt("100Senha");
			System.out.println("Senha Criptografada Novamente: " + senhaEncoded);
			
			System.out.println("Senha válida: " + SenhaUtils.senhaValida("100Senha", senhaEncoded));
		};
	}
}