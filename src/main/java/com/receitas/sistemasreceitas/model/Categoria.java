package com.receitas.sistemasreceitas.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Categoria {
	@Id
	@SequenceGenerator(name = "pk_categoria", sequenceName = "categoria_id_seq" , allocationSize =1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_categoria")
	private Integer id;
	
	private String nome;
	
	private String descricao;

}
