package com.receitas.sistemasreceitas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.receitas.sistemasreceitas.model.Avaliacao;
import com.receitas.sistemasreceitas.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {
	@Autowired
	private AvaliacaoRepository avaliacaoRepository;

	public List<Avaliacao> findAll() {
		return (List<Avaliacao>) avaliacaoRepository.findAll();
	}

	public Optional<Avaliacao> findById(Integer id) {
		return avaliacaoRepository.findById(id);
	}

	public void save(Avaliacao avaliacao) {
		int nota = avaliacao.getNota();
		
		String textoAvaliacao = avaliacao.getTextoAvaliacao();
		
		if (nota >= 0 || nota <=5 && textoAvaliacao.length() >0 ) {
			avaliacaoRepository.save(avaliacao);
		}
		
		
		
	}

	public void delete(Integer id) {
		avaliacaoRepository.deleteById(id);
	}


}
