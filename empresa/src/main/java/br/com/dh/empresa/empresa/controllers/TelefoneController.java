package br.com.dh.empresa.empresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.empresa.empresa.model.entities.Telefone;
import br.com.dh.empresa.empresa.model.repositories.TelefoneRepository;

@RestController
@RequestMapping(path = "telefone")
public class TelefoneController {
	
	@Autowired 
	private TelefoneRepository telefoneRepository;
	
	@GetMapping()
	public Iterable<Telefone> findAllTelefones(){
		return telefoneRepository.findAll();
	}	
	
	//Pesquisar telefones que tenham o ddd 16
	// http://localhost:8080/telefone/dddlike?ddd=16
	@GetMapping("/dddlike")
	public List<Telefone> getDddlike(@RequestParam String ddd){
		return telefoneRepository.findByDddContaining(ddd);
	}
	
	//Adicionando telefone p/ clientes ou funcionarios (atualmente todos tem acesso)
	@PostMapping() 
	public Telefone addTelefone(@RequestBody Telefone telefone) {
		telefoneRepository.save(telefone);
		return telefone;
	}
	
	
}