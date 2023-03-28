package com.receitas.sistemasreceitas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.receitas.sistemasreceitas.model.CategoriaReceita;
import com.receitas.sistemasreceitas.repository.CategoriaReceitaRepository;

@Service
public class CategoriaReceitaService {
@Autowired
private CategoriaReceitaRepository categoriareceitaRepository;

public List<CategoriaReceita> findAll() {
	return (List<CategoriaReceita>) categoriareceitaRepository.findAll();
}

public Optional<CategoriaReceita> findById(Integer id) {
	return categoriareceitaRepository.findById(id);
}

public void save(CategoriaReceita categoriareceita) {
	categoriareceitaRepository.save(categoriareceita);
}

public void delete(Integer id) {
	categoriareceitaRepository.deleteById(id);
}



}
