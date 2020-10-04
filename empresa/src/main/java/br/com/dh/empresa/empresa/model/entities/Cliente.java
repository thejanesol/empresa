package br.com.dh.empresa.empresa.model.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String cpf;
	private String rg;
	private String email;
	
	public Cliente () {}
	
	@OneToMany(mappedBy = "cliente")
	private Set<Telefone> telefones;
	
	@OneToMany(mappedBy = "cliente")
	private Set<Endereco> enderecos;
	
	@OneToMany(mappedBy = "cliente")
	private Set<Pedido> pedidos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Set<Telefone> getTelefones(){
		return telefones;
	}
	
	public Set<Endereco> getEnderecos(){
		return enderecos;
	}
	
	public Set<Pedido> getPedidos(){
		return pedidos;
	}
	
}
