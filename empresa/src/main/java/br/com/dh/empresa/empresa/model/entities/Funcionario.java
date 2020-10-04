package br.com.dh.empresa.empresa.model.entities;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Funcionario implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7965857552681764841L;

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer matricula;
	
	private String nome;
	private String cpf;
	private String rg;
	private Date data_nascimento;
	private double salario;
	private String email;
	private String senha;
	private Boolean habilitado;
	
	public Funcionario () {}
	
	//orphanRemoval limpa objeto dependentes
	@OneToMany(mappedBy = "funcionario", orphanRemoval = true) 
	private Set<Autorizacao> autorizacao;
	
	@OneToMany(mappedBy = "funcionario", orphanRemoval = true)
	private Set<Telefone> telefones;
	
	@OneToMany(mappedBy = "funcionario", orphanRemoval = true)
	private Set<Endereco> enderecos;
	
	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
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

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	};
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}
	
	public Set<Telefone> getTelefones(){
		return telefones;
	}
	
	public Set<Endereco> getEnderecos(){
		return enderecos;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return (Collection<? extends GrantedAuthority>) this.autorizacao;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	

}
