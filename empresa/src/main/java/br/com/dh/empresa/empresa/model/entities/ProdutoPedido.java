package br.com.dh.empresa.empresa.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProdutoPedido {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int fk_produto;
	private int fk_pedido;
	private int quantidade_produto;
	
	public ProdutoPedido() {}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getFk_produto() {
		return fk_produto;
	}

	public void setFk_produto(int fk_produto) {
		this.fk_produto = fk_produto;
	}

	public int getFk_pedido() {
		return fk_pedido;
	}

	public void setFk_pedido(int fk_pedido) {
		this.fk_pedido = fk_pedido;
	}

	public int getQuantidade_produto() {
		return quantidade_produto;
	}

	public void setQuantidade_produto(int quantidade_produto) {
		this.quantidade_produto = quantidade_produto;
	};


}
