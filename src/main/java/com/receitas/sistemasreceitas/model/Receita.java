	package com.receitas.sistemasreceitas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

import java.util.List;
import java.util.Optional;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Receita {
	@Id
	@SequenceGenerator(name = "pk_receita", sequenceName= "receita_id_seq" , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_receita")
	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	@Column(name= "tempo_preparo")
	private Integer tempoPreparo;
	
	@Column(name= "tempo_cozimento")
	private Integer tempoCozimento;
	
	private Integer porcoes;
	
	@Column(name= "nivel_dificuldade")
	private String nivelDificuldade;

	}

	
