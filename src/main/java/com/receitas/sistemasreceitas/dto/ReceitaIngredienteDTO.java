package com.receitas.sistemasreceitas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReceitaIngredienteDTO {
	Integer id;
	
	Integer receita;
	
	Integer ingrediente;
	
	Double quantidade;
	
	String unidadeMedida;
}
