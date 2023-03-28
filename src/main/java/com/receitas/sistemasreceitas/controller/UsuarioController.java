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

import com.receitas.sistemasreceitas.model.Usuario;
import com.receitas.sistemasreceitas.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping()
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> result = usuarioService.findAll();
		if (result == null || result.isEmpty())
			return new ResponseEntity<List<Usuario>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Usuario>>(result, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Usuario>> findById(@PathVariable Integer id) {
		Optional<Usuario> result = usuarioService.findById(id);
		if (result == null)
			return new ResponseEntity<Optional<Usuario>>(result, HttpStatus.NO_CONTENT);

		return new ResponseEntity<Optional<Usuario>>(result, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
		//Usuario novoUsuario = new Usuario();
		
		//Estado estado = estadoService.findBySigla(avaliacao.getEstado()).get();
		//novaCidade.setEstado(estado);
		
		usuarioService.save(usuario);

		return ResponseEntity.ok(usuario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Usuario> update(@PathVariable Integer id, @RequestBody Usuario usuario) {
		Usuario usuarioAtualizado = usuarioService.findById(id).get();
		usuarioAtualizado.setNome(usuario.getNome());
		usuarioAtualizado.setEmail(usuario.getEmail());
		usuarioAtualizado.setSenha(usuario.getSenha());
		//Estado estado = estadoService.findBySigla(cidade.getEstado()).get();
		//cidadeAtualizada.setEstado(estado);
		usuarioService.save(usuarioAtualizado);

		return ResponseEntity.ok(usuarioAtualizado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		usuarioService.delete(id);

		return ResponseEntity.ok("Deletado");
	}


}
