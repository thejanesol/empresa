package br.com.dh.empresa.empresa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dh.empresa.empresa.model.entities.ProdutoPedido;
import br.com.dh.empresa.empresa.model.repositories.ProdutoPedidoRepository;

@RestController
@RequestMapping(path = "produto_pedido")
public class ProdutoPedidoController {
	@Autowired 
	private ProdutoPedidoRepository produtoPedidoRepository;
	
	@GetMapping()
	public Iterable<ProdutoPedido> getProdutoPedidos(){
		return produtoPedidoRepository.findAll();
	}
	
}
