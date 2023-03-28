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

import com.receitas.sistemasreceitas.model.Categoria;
import com.receitas.sistemasreceitas.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping()
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> result = categoriaService.findAll();
		if (result == null || result.isEmpty())
			return new ResponseEntity<List<Categoria>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Categoria>>(result, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Categoria>> findById(@PathVariable Integer id) {
		Optional<Categoria> result = categoriaService.findById(id);
		if (result == null)
			return new ResponseEntity<Optional<Categoria>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<Optional<Categoria>>(result, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {
		//Usuario novoUsuario = new Usuario();
		
		//Estado estado = estadoService.findBySigla(avaliacao.getEstado()).get();
		//novaCidade.setEstado(estado);
		
		categoriaService.save(categoria);

		return ResponseEntity.ok(categoria);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Categoria> update(@PathVariable Integer id, @RequestBody Categoria categoria) {
		Categoria categoriaAtualizada = categoriaService.findById(id).get();
		categoriaAtualizada.setDescricao(categoria.getDescricao());
		categoriaAtualizada.setNome(categoria.getNome());
		//Estado estado = estadoService.findBySigla(cidade.getEstado()).get();
		//cidadeAtualizada.setEstado(estado);
		categoriaService.save(categoriaAtualizada);

		return ResponseEntity.ok(categoriaAtualizada);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		categoriaService.delete(id);

		return ResponseEntity.ok("Deletado");
	}


}
