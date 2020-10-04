package br.com.dh.empresa.empresa.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.empresa.empresa.model.entities.Autorizacao;
import br.com.dh.empresa.empresa.model.repositories.AutorizacaoRepository;

@RestController
@RequestMapping(path = "autorizacao")
public class AutorizacaoController {
	
	@Autowired
	AutorizacaoRepository autorizacaoRepository;
	
	@GetMapping
	public Iterable<Autorizacao> getAutorizacao() {
		return autorizacaoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Autorizacao> getById(@PathVariable int id) {
		return autorizacaoRepository.findById(id);
	}
	
	@PostMapping() //Habilitar autoridade a funcionário/gerente
	public Autorizacao addAutorizacao(@RequestBody Autorizacao autorizacao) {
		autorizacaoRepository.save(autorizacao);
		return autorizacao;
	}
	
	@PutMapping("/{id}") //Editar autoridade { "authority": "ROLE_"}
	public Autorizacao updateAutorizacao(@PathVariable int id, 
			@RequestBody Autorizacao dadosAutorizacao) throws Exception {
		Autorizacao autorizacao = autorizacaoRepository.findById(id).orElseThrow(()
				-> new IllegalAccessException());
		
		if(!dadosAutorizacao.getAuthority().isEmpty()) autorizacao.setAuthority(dadosAutorizacao.getAuthority());
		
		autorizacaoRepository.save(autorizacao);
		
		return autorizacao;
	}
}
