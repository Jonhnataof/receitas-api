package com.receitas.sistemasreceitas.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "receita_ingrediente")
public class ReceitaIngrediente {
	@Id
	@SequenceGenerator(name = "pk_receita_ingrediente", sequenceName= "receita_ingrediente_id_seq" ,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "pk_receita_ingrediente")
	Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_receita")
	Receita receita;
	
	@ManyToOne
	@JoinColumn(name = "id_ingrediente")
	Ingrediente ingrediente;
	
	Double quantidade;
	
	String unidadeMedida;
	

}
