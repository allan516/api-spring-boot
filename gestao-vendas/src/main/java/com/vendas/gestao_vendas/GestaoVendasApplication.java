package com.vendas.gestao_vendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = {"com.vendas.gestao_vendas.entidades"})
@EnableJpaRepositories(basePackages = {"com.vendas.gestao_vendas.repositorio"})
@ComponentScan(basePackages = {"com.vendas.gestao_vendas.servico", "com.vendas.gestao_vendas.controlador", "com.vendas.gestao_vendas.excecao"})
@SpringBootApplication
public class GestaoVendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoVendasApplication.class, args);
	}

}