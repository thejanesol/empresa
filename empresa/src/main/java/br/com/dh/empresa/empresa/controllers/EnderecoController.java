package br.com.dh.empresa.empresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.empresa.empresa.model.entities.Endereco;
import br.com.dh.empresa.empresa.model.repositories.EnderecoRepository;

@RestController
@RequestMapping(path = "endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	@GetMapping()
	public Iterable<Endereco> getEnderecos(){
		return enderecoRepository.findAll();
	}
	
	//Pesquisar endereço com estado Espirito Santo
	// http://localhost:8080/endereco/estadolike?estado=espirito+santo
	@GetMapping("/estadolike")
	public List<Endereco> getByEstadoLike(String estado){
		return enderecoRepository.findByEstadoContaining(estado);
	}
	
	//Adicionando endereco p/ clientes ou funcionarios (atualmente todos tem acesso)
	@PostMapping() 
	public Endereco addEndereco(@RequestBody Endereco endereco) {
		enderecoRepository.save(endereco);
		return endereco;
	}
}
