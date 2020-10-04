package br.com.dh.empresa.empresa.model.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Telefone {
	
	@Id
	private Integer id;
	
	private String ddd;
	private String numero;
	private Integer fk_cliente;
	private Integer fk_funcionario;
	
	public Telefone() {}
	
	@ManyToOne
	@JoinColumn(name = "fk_cliente", insertable=false ,updatable=false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "fk_funcionario", insertable=false ,updatable=false)
	private Funcionario funcionario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getFk_cliente() {
		return fk_cliente;
	}

	public void setFk_cliente(Integer fk_cliente) {
		this.fk_cliente = fk_cliente;
	}

	public Integer getFk_funcionario() {
		return fk_funcionario;
	}

	public void setFk_funcionario(Integer fk_funcionario) {
		this.fk_funcionario = fk_funcionario;
	}
	

}
