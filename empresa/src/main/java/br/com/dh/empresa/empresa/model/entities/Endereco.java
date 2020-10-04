package br.com.dh.empresa.empresa.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int numero;
	private String rua;
	private String bairro;
	private String complemento;
	private String cidade;
	private String estado;
	private Integer fk_cliente;
	private Integer fk_funcionario;
	
	
	public Endereco () {}
	
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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
