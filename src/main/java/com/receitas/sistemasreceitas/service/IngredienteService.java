package com.receitas.sistemasreceitas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.receitas.sistemasreceitas.model.Ingrediente;
import com.receitas.sistemasreceitas.repository.IngredienteRepository;

@Service
public class IngredienteService {
	@Autowired
	private IngredienteRepository ingredienteRepository;

	public List<Ingrediente> findAll() {
		return (List<Ingrediente>) ingredienteRepository.findAll();
	}

	public Optional<Ingrediente> findById(Integer id) {
		return ingredienteRepository.findById(id);
	}

	public void save(Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);
	}

	public void delete(Integer id) {
		ingredienteRepository.deleteById(id);
	}


}
