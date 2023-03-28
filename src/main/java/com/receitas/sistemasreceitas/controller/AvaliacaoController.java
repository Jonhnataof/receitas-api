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

import com.receitas.sistemasreceitas.model.Avaliacao;
import com.receitas.sistemasreceitas.service.AvaliacaoService;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {
	@Autowired
	private AvaliacaoService avaliacaoService;

	@GetMapping()
	public ResponseEntity<List<Avaliacao>> findAll() {
		List<Avaliacao> result = avaliacaoService.findAll();
		if (result == null || result.isEmpty())
			return new ResponseEntity<List<Avaliacao>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Avaliacao>>(result, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Avaliacao>> findById(@PathVariable Integer id) {
		Optional<Avaliacao> result = avaliacaoService.findById(id);
		if (result == null)
			return new ResponseEntity<Optional<Avaliacao>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<Optional<Avaliacao>>(result, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Avaliacao> save(@RequestBody Avaliacao avaliacao) {
		Avaliacao novaAvaliacao = new Avaliacao();
		
		//Estado estado = estadoService.findBySigla(avaliacao.getEstado()).get();
		//novaCidade.setEstado(estado);
		
		avaliacaoService.save(novaAvaliacao);

		return ResponseEntity.ok(novaAvaliacao);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Avaliacao> update(@PathVariable Integer id, @RequestBody Avaliacao avaliacao) {
		Avaliacao avaliacaoAtualizada = avaliacaoService.findById(id).get();
		//avaliacaoAtualizada.setNome(avaliacao.getNome());
		//Estado estado = estadoService.findBySigla(cidade.getEstado()).get();
		//cidadeAtualizada.setEstado(estado);
		avaliacaoService.save(avaliacaoAtualizada);

		return ResponseEntity.ok(avaliacaoAtualizada);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		avaliacaoService.delete(id);

		return ResponseEntity.ok("Deletado");
	}


}
