package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Classe referente a tabela de restaurante
 * @author Bruno Noronha Fragomeni
 *
 */
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_rstr")
public class Restaurante {
	
	@EqualsAndHashCode.Include
	@Id
	@Column(name = "id_rstr")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nm_rstr")
	private String nome;
	
	@Column(name = "tx_fret")
	private BigDecimal taxaFrete;
	
	
}
