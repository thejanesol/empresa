package br.com.dh.empresa.empresa.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.dh.empresa.empresa.model.entities.Telefone;

public interface TelefoneRepository extends CrudRepository<Telefone, Integer>{
	List<Telefone> findByDddContaining(String ddd);
}
