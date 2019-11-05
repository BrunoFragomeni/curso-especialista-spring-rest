package com.algaworks.algafood.jpa;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

public class OperacoesRestauranteMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		//edicao
		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);
		Restaurante restaurante = new Restaurante();
		restaurante.setId(1L);
		restaurante.setNome("Si Senor Editado");
		restaurante.setTaxaFrete(new BigDecimal("10.3"));
		
		restauranteRepository.salvar(restaurante);
		
		//busca lista
		List<Restaurante> listaRestaurante = restauranteRepository.listar();
		
		listaRestaurante.stream().forEach(restauranteTemp -> {
			System.out.println(restauranteTemp.getNome() + " " + restauranteTemp.getTaxaFrete());
		});
		
		//busca especifica
		Restaurante restauranteTemp = restauranteRepository.buscar(2L);
		System.out.println(restauranteTemp.getNome() + " " + restauranteTemp.getTaxaFrete());
		
		//remocao
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setId(2L);
		
		restauranteRepository.remover(restaurante1);
	}
}
