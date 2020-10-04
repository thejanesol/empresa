package br.com.dh.empresa.empresa.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import br.com.dh.empresa.empresa.model.entities.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Integer>{
	Produto findOneByNome(String nome);
	
	List<Produto> findByNomeContaining(String nome);
	
	List<Produto> findByEstoque (int estoque);
}
