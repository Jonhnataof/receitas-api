package com.receitas.sistemasreceitas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.receitas.sistemasreceitas.service.CategoriaService;
import com.receitas.sistemasreceitas.model.Categoria;
import com.receitas.sistemasreceitas.service.CategoriaReceitaService;
import com.receitas.sistemasreceitas.model.CategoriaReceita;
import com.receitas.sistemasreceitas.model.Receita;
import com.receitas.sistemasreceitas.service.ReceitaService;



@RestController
@RequestMapping("/categoria_receita")
public class CategoriaReceitaController {
	@Autowired
	private CategoriaReceitaService categoriareceitaService;
	
	@Autowired
	private ReceitaService receitaService;
	
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping()
	public ResponseEntity<List<CategoriaReceita>> findAll() {
		List<CategoriaReceita> result = categoriareceitaService.findAll();
		if (result == null || result.isEmpty())
			return new ResponseEntity<List<CategoriaReceita>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<CategoriaReceita>>(result, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<CategoriaReceita>> findById(@PathVariable Integer id) {
		Optional<CategoriaReceita> result = categoriareceitaService.findById(id);
		if (result == null)
			return new ResponseEntity<Optional<CategoriaReceita>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<Optional<CategoriaReceita>>(result, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<CategoriaReceita> save(@RequestBody CategoriaReceita categoriareceita) {
		CategoriaReceita novaCategoriaReceita = new CategoriaReceita();
		
		Categoria categoria = categoriaService.findById(categoriareceita.getCategoria().getId()).get();
		novaCategoriaReceita.setCategoria(categoria);
		
		Receita receita = receitaService.findById(categoriareceita.getReceita().getId()).get();
		novaCategoriaReceita.setReceita(receita);
		
		categoriareceitaService.save(categoriareceita);

		return ResponseEntity.ok(categoriareceita);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoriaReceita> update(@PathVariable Integer id, @RequestBody CategoriaReceita categoriareceita) {
		CategoriaReceita categoriareceitaAtualizado = categoriareceitaService.findById(id).get();
		
		categoriareceitaAtualizado.setCategoria(categoriareceita.getCategoria());
		categoriareceitaAtualizado.setReceita(categoriareceita.getReceita());
		
		Categoria categoria = categoriaService.findById(categoriareceita.getCategoria().getId()).get();
		categoriareceitaAtualizado.setCategoria(categoria);
		
		Receita receita = receitaService.findById(categoriareceita.getReceita().getId()).get();
		categoriareceitaAtualizado.setReceita(receita);
		//Estado estado = estadoService.findBySigla(cidade.getEstado()).get();
		//cidadeAtualizada.setEstado(estado);
		categoriareceitaService.save(categoriareceitaAtualizado);

		return ResponseEntity.ok(categoriareceitaAtualizado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		categoriareceitaService.delete(id);

		return ResponseEntity.ok("Deletado");
	}


}
