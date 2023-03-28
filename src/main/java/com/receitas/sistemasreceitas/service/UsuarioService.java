package com.receitas.sistemasreceitas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.receitas.sistemasreceitas.model.Usuario;
import com.receitas.sistemasreceitas.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	public Optional<Usuario> findById(Integer id) {
		return usuarioRepository.findById(id);
	}

	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public void delete(Integer id) {
		usuarioRepository.deleteById(id);
	}


}
