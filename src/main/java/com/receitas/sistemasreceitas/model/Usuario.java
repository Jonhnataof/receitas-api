package com.receitas.sistemasreceitas.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario {
	@Id
	@SequenceGenerator(name = "pk_usuario", sequenceName= "usuario_id_seq" , allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_usuario")
	private Integer id;
	
	private String nome;
	
	private String email;
	
	private String senha;

}
