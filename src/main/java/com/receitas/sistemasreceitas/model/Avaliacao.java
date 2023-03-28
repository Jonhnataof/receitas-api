package com.receitas.sistemasreceitas.model;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Avaliacao {
	@Id
	@SequenceGenerator(name = "pk_avaliacao", sequenceName= "avaliacao_id_seq" , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_avaliacao")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_receita")
	private Receita receita;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	private Integer nota;
	
	private String textoAvaliacao;

}
