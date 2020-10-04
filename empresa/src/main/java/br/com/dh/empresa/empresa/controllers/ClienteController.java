package br.com.dh.empresa.empresa.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.empresa.empresa.model.entities.Cliente;
import br.com.dh.empresa.empresa.model.repositories.ClienteRepository;

@RestController
@RequestMapping(path = "cliente")
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping
	public Iterable<Cliente> getCliente() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id_cliente}")
	public Optional<Cliente> getById(@PathVariable int id_cliente) {
		return clienteRepository.findById(id_cliente);
	}
	
	@GetMapping("/nome") // http://localhost:8080/cliente/nome?nome="nome+sobrenome"
	//Os espaços precisam ser substituidos por +, & para concatenar parametros
	public Cliente getByName(@RequestParam String nome) {
		return clienteRepository.findOneByNome(nome);
	}
	
	@GetMapping("/nomelike") 
	// http://localhost:8080/cliente/nomelike?nome="string"
	//Retorna todos os nomes contendo a porção contida na "string"
	public List<Cliente> getNameLike(@RequestParam String nome){
		return clienteRepository.encontrarNomeParecido(nome);
	}
	
//	@GetMapping("/nomelike")
//	// http://localhost:8080/cliente/nomelike?nome="string"
//	public List<Cliente> getNameLike(@RequestParam String nome){
//		return clienteRepository.findByNomeContaining(nome);
//	}
	
	//Pesquisar clientes que tenham o numero 7 no cpf
	@GetMapping("/cpflike")
		public List<Cliente> getCpfLike(@RequestParam String cpf){
			return clienteRepository.findByCpfContaining(cpf);
	}
	
	//Manipulando clientes - funcionarios + gerentes
	@PostMapping() 
	public Cliente addCliente(@RequestBody Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente;
	}
	
	@PutMapping("/{idCliente}") // 1 -> "1", transforma em string 
	public Cliente updateCliente(@PathVariable int idCliente, 
			@RequestBody Cliente dadosCliente) throws Exception {
		Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new IllegalAccessException());
		
		if(!dadosCliente.getNome().isEmpty()) cliente.setNome(dadosCliente.getNome());
		if(!dadosCliente.getCpf().isEmpty()) cliente.setCpf(dadosCliente.getCpf());

		clienteRepository.save(cliente);
		
		return cliente;
	}
	
	@DeleteMapping("/{id_cliente}")
	public void deleteCliente(@PathVariable int id_cliente) {
		clienteRepository.deleteById(id_cliente);
	}
}
