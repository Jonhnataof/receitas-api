package com.receitas.sistemasreceitas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.receitas.sistemasreceitas.model.Categoria;
import com.receitas.sistemasreceitas.repository.CategoriaRepository;


@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> findAll() {
		return (List<Categoria>) categoriaRepository.findAll();
	}

	public Optional<Categoria> findById(Integer id) {
		return categoriaRepository.findById(id);
	}

	public void save(Categoria categoria) {
		categoriaRepository.save(categoria);
	}

	public void delete(Integer id) {
		categoriaRepository.deleteById(id);
	}





}
