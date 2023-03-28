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

import com.receitas.sistemasreceitas.model.Ingrediente;
import com.receitas.sistemasreceitas.service.IngredienteService;

@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {
	@Autowired
	private IngredienteService ingredienteService;
	
	@GetMapping()
	public ResponseEntity<List<Ingrediente>> findAll() {
		List<Ingrediente> result = ingredienteService.findAll();
		if (result == null || result.isEmpty())
			return new ResponseEntity<List<Ingrediente>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Ingrediente>>(result, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Ingrediente>> findById(@PathVariable Integer id) {
		Optional<Ingrediente> result = ingredienteService.findById(id);
		if (result == null)
			return new ResponseEntity<Optional<Ingrediente>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<Optional<Ingrediente>>(result, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Ingrediente> save(@RequestBody Ingrediente ingrediente) {
		//Usuario novoUsuario = new Usuario();
		
		//Estado estado = estadoService.findBySigla(avaliacao.getEstado()).get();
		//novaCidade.setEstado(estado);
		
		ingredienteService.save(ingrediente);

		return ResponseEntity.ok(ingrediente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Ingrediente> update(@PathVariable Integer id, @RequestBody Ingrediente ingrediente) {
		Ingrediente ingredienteAtualizado = ingredienteService.findById(id).get();
		ingredienteAtualizado.setNome(ingrediente.getNome());
		ingredienteAtualizado.setQuantidade(ingrediente.getQuantidade());
		ingredienteAtualizado.setUnidadeMedida(ingrediente.getUnidadeMedida());
		//Estado estado = estadoService.findBySigla(cidade.getEstado()).get();
		//cidadeAtualizada.setEstado(estado);
		ingredienteService.save(ingredienteAtualizado);

		return ResponseEntity.ok(ingredienteAtualizado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		ingredienteService.delete(id);

		return ResponseEntity.ok("Deletado");
	}


}
