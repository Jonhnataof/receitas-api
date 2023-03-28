package com.receitas.sistemasreceitas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.receitas.sistemasreceitas.model.Receita;
import com.receitas.sistemasreceitas.repository.ReceitaRepository;

@Service
public class ReceitaService {
	@Autowired
	private ReceitaRepository receitaRepository;

	public List<Receita> findAll() {
		return (List<Receita>) receitaRepository.findAll();
	}

	public Optional<Receita> findById(Integer id) {
		return receitaRepository.findById(id);
	}

	public void save(Receita receita) {
		int porcoes = receita.getPorcoes();
		String nivelDificuldade = receita.getNivelDificuldade();
		
		if (porcoes > 0 && nivelDificuldade.equals("facil") || nivelDificuldade.equals("medio") || nivelDificuldade.equals("dificil")) {
			receitaRepository.save(receita);
		}
		
		
	}

	public void delete(Integer id) {
		receitaRepository.deleteById(id);
	}


}
