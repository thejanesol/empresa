package br.com.dh.empresa.empresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.empresa.empresa.model.entities.Produto;
import br.com.dh.empresa.empresa.model.repositories.ProdutoRepository;

@RestController
@RequestMapping(path = "produto")
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	//Busca todos
	@GetMapping
	public Iterable<Produto> getProdutos(){
		return produtoRepository.findAll();
	}
	
	//Pesquisa por nome: nome deve ser completo e os espaços substituidos por +
	//Ex. http://localhost:8080/produto/nome?nome=1996+Moto+Guzzi+1100i
	@GetMapping("/nome")
	public Produto getbyName(@RequestParam String nome) {
		return produtoRepository.findOneByNome(nome);
	}
	
	//Pesquisa por decada e por ano(que está especificado no nome)
	//Ex. de consulta http://localhost:8080/produto/nomelike?nome=199
	//Ex. de consulta http://localhost:8080/produto/nomelike?nome=1996
	@GetMapping("/nomelike")
	public List<Produto> getNameLike(@RequestParam String nome){
		return produtoRepository.findByNomeContaining(nome);
	}
	
	//Pesquisa por quantidade no estoque
	@GetMapping("/estoque")
	public List<Produto> getEstoque(@RequestParam int estoque) {
		return produtoRepository.findByEstoque(estoque);
	}

}