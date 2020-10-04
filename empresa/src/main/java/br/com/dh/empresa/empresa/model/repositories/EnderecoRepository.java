package br.com.dh.empresa.empresa.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.empresa.empresa.model.entities.Endereco;

public interface EnderecoRepository extends CrudRepository<Endereco, Integer>{
	List<Endereco> findByEstadoContaining(String estado);
}
