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

import com.receitas.sistemasreceitas.model.Receita;
import com.receitas.sistemasreceitas.service.ReceitaService;

@RestController
@RequestMapping("/receita")
public class ReceitaController {
	@Autowired
	private ReceitaService receitaService;

	@GetMapping()
	public ResponseEntity<List<Receita>> findAll() {
		List<Receita> result = receitaService.findAll();
		if (result == null || result.isEmpty())
			return new ResponseEntity<List<Receita>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Receita>>(result, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Receita>> findById(@PathVariable Integer id) {
		Optional<Receita> result = receitaService.findById(id);
		if (result == null)
			return new ResponseEntity<Optional<Receita>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<Optional<Receita>>(result, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Receita> save(@RequestBody Receita receita) {
		//Usuario novoUsuario = new Usuario();
		
		//Estado estado = estadoService.findBySigla(avaliacao.getEstado()).get();
		//novaCidade.setEstado(estado);
		
		receitaService.save(receita);

		return ResponseEntity.ok(receita);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Receita> update(@PathVariable Integer id, @RequestBody Receita receita) {
		Receita receitaAtualizada = receitaService.findById(id).get();
		receitaAtualizada.setNome(receita.getNome());
		receitaAtualizada.setDescricao(receita.getDescricao());
		receitaAtualizada.setTempoPreparo(receita.getTempoPreparo());
		receitaAtualizada.setTempoCozimento(receita.getTempoCozimento());
		receitaAtualizada.setPorcoes(receita.getPorcoes());
		receitaAtualizada.setNivelDificuldade(receita.getNivelDificuldade());
		//Estado estado = estadoService.findBySigla(cidade.getEstado()).get();
		//cidadeAtualizada.setEstado(estado);
		receitaService.save(receitaAtualizada);

		return ResponseEntity.ok(receitaAtualizada);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		receitaService.delete(id);

		return ResponseEntity.ok("Deletado");
	}


}
