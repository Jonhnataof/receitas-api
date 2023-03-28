package com.receitas.sistemasreceitas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Ingrediente {
	@Id
	@SequenceGenerator(name = "pk_ingrediente", sequenceName= "ingrediente_id_seq" ,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "pk_ingrediente")
	Integer id;
	
	String nome;
	
	Integer quantidade;
	
	String unidadeMedida;
	

}
