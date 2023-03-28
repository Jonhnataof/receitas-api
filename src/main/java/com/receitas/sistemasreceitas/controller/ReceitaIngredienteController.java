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

import com.receitas.sistemasreceitas.model.ReceitaIngrediente;
import com.receitas.sistemasreceitas.service.ReceitaIngredienteService;
import com.receitas.sistemasreceitas.model.Receita;
import com.receitas.sistemasreceitas.service.ReceitaService;
import com.receitas.sistemasreceitas.model.Ingrediente;
import com.receitas.sistemasreceitas.service.IngredienteService;

@RestController
@RequestMapping("/receita_ingrediente")
public class ReceitaIngredienteController {
	@Autowired
	private ReceitaIngredienteService receitaingredienteService;
	
	@Autowired
	private ReceitaService receitaService;
	
	@Autowired
	private IngredienteService ingredienteService;

	@GetMapping()
	public ResponseEntity<List<ReceitaIngrediente>> findAll() {
		List<ReceitaIngrediente> result = receitaingredienteService.findAll();
		if (result == null || result.isEmpty())
			return new ResponseEntity<List<ReceitaIngrediente>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<ReceitaIngrediente>>(result, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<ReceitaIngrediente>> findById(@PathVariable Integer id) {
		Optional<ReceitaIngrediente> result = receitaingredienteService.findById(id);
		if (result == null)
			return new ResponseEntity<Optional<ReceitaIngrediente>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<Optional<ReceitaIngrediente>>(result, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ReceitaIngrediente> save(@RequestBody ReceitaIngrediente receitaingrediente) {
		ReceitaIngrediente novaReceitaIngrediente = new ReceitaIngrediente();

		Receita receita = receitaService.findById(receitaingrediente.getReceita().getId()).get();
		novaReceitaIngrediente.setReceita(receita);	
		
		Ingrediente ingrediente = ingredienteService.findById(receitaingrediente.getIngrediente().getId()).get();
		novaReceitaIngrediente.setIngrediente(ingrediente);
		
		//Estado estado = estadoService.findBySigla(avaliacao.getEstado()).get();
		//novaCidade.setEstado(estado);
		
		receitaingredienteService.save(receitaingrediente);

		return ResponseEntity.ok(receitaingrediente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ReceitaIngrediente> update(@PathVariable Integer id, @RequestBody ReceitaIngrediente receitaingrediente) {
		ReceitaIngrediente receitaingredienteAtualizado = receitaingredienteService.findById(id).get();
		
		receitaingredienteAtualizado.setReceita(receitaingrediente.getReceita());
		receitaingredienteAtualizado.setIngrediente(receitaingrediente.getIngrediente());
		
		receitaingredienteAtualizado.setQuantidade(receitaingrediente.getQuantidade());
		receitaingredienteAtualizado.setUnidadeMedida(receitaingrediente.getUnidadeMedida());
		
		//Estado estado = estadoService.findBySigla(cidade.getEstado()).get();
		//cidadeAtualizada.setEstado(estado);
		
		receitaingredienteService.save(receitaingredienteAtualizado);

		return ResponseEntity.ok(receitaingredienteAtualizado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		receitaingredienteService.delete(id);

		return ResponseEntity.ok("Deletado");
	}


}
