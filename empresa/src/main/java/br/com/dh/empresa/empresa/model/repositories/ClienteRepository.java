package br.com.dh.empresa.empresa.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.dh.empresa.empresa.model.entities.Cliente;

public interface ClienteRepository extends CrudRepository <Cliente, Integer>{
	Cliente findOneByNome(String nome);
	
	@Query(value = "select c from Cliente c where nome like %:nome%")
	
	List<Cliente> encontrarNomeParecido(String nome);
	
	List<Cliente> findByNomeContaining(String nome);
	
	List<Cliente> findByCpfContaining(String cpf);
}
