package br.com.dh.empresa.empresa.model.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nfe;
	
	private Date data_emissao;
	private double valor_total;
	private String status_pedido;
	private Integer fk_cliente;
	
	public Pedido () {}
	
	@ManyToOne
	@JoinColumn(name = "fk_cliente", insertable=false ,updatable=false)
	private Cliente cliente;

	public int getNfe() {
		return nfe;
	}

	public void setNfe(int nfe) {
		this.nfe = nfe;
	}

	public Date getData_emissao() {
		return data_emissao;
	}

	public void setData_emissao(Date data_emissao) {
		this.data_emissao = data_emissao;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public String getStatus_pedido() {
		return status_pedido;
	}

	public void setStatus_pedido(String status_pedido) {
		this.status_pedido = status_pedido;
	}

	public Integer getFk_cliente() {
		return fk_cliente;
	}

	public void setFk_cliente(Integer fk_cliente) {
		this.fk_cliente = fk_cliente;
	}	
	
}