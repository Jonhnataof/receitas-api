package com.receitas.sistemasreceitas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.receitas.sistemasreceitas.model.ReceitaIngrediente;
import com.receitas.sistemasreceitas.repository.ReceitaIngredienteRepository;

@Service
public class ReceitaIngredienteService {
	@Autowired
	private ReceitaIngredienteRepository receitaingredienteRepository;

	public List<ReceitaIngrediente> findAll() {
		return (List<ReceitaIngrediente>) receitaingredienteRepository.findAll();
	}

	public Optional<ReceitaIngrediente> findById(Integer id) {
		return receitaingredienteRepository.findById(id);
	}

	public void save(ReceitaIngrediente receitaingrediente) {
		receitaingredienteRepository.save(receitaingrediente);
	}

	public void delete(Integer id) {
		receitaingredienteRepository.deleteById(id);
	}


}
