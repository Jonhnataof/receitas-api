package com.receitas.sistemasreceitas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CategoriaReceita {
	@Id
	@SequenceGenerator(name = "pk_categoria_receita", sequenceName= "categoria_receita_id_seq" ,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "pk_categoria_receita")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_receita")
	private Receita receita;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

}
