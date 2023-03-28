package com.receitas.sistemasreceitas.repository;

import org.springframework.data.repository.CrudRepository;

import com.receitas.sistemasreceitas.model.Usuario;

public interface UsuarioRepository extends CrudRepository <Usuario, Integer> {

}
