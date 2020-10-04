package br.com.dh.empresa.empresa.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.empresa.empresa.model.entities.Funcionario;
import br.com.dh.empresa.empresa.model.repositories.FuncionarioRepository;

@RestController
@RequestMapping(path = "funcionario")
public class FuncionarioController {
	
	@Autowired 
	private FuncionarioRepository funcionarioRepository;
	
	//Manipulando funcionarios - somente gerentes
	@GetMapping
	public Iterable<Funcionario> findAllFuncionarios(){
		return funcionarioRepository.findAll();
	}
	
	@GetMapping("/{matricula}") //Buscando funcionario por matricula
	public Optional<Funcionario> getById(@PathVariable int matricula) {
		return funcionarioRepository.findById(matricula);
	}
	
	@PostMapping() //Cadastrar funcionarios
	public Funcionario addFuncionario(@RequestBody Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
		return funcionario;
	}
	
	@PutMapping("/{matricula}") //Ajustar salario do funcionario
	public Funcionario updateFuncionario(@PathVariable int matricula, 
			@RequestBody Funcionario dadosFuncionario) throws Exception {
		Funcionario funcionario = funcionarioRepository.findById(matricula).orElseThrow(()
				-> new IllegalAccessException());
		
		if(dadosFuncionario.getSalario() != 0) funcionario.setSalario(dadosFuncionario.getSalario());
		
		funcionarioRepository.save(funcionario);
		
		return funcionario;
	}
	
	@DeleteMapping("/{matricula}") //Demitir funconario, erro SQL solucionado com orphanRemoval
	public void deleteFuncionario(@PathVariable int matricula) {
		funcionarioRepository.deleteById(matricula);
	}
	
}
