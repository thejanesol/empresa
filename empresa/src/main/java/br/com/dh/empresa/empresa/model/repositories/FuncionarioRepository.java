package br.com.dh.empresa.empresa.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.empresa.empresa.model.entities.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer>{
	Funcionario findOneByEmail (String email);
}
