package br.com.dh.empresa.empresa.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;


@Entity
public class Autorizacao implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7355492847495601596L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String autoridade;
	private String fk_email;
	
	public Autorizacao() {}
	
	@ManyToOne
	@JoinColumn(name = "id", insertable=false ,updatable=false)
	private Funcionario funcionario;
	
	@Override
	public String getAuthority() {
		return this.autoridade;
	}
	
	public void setAuthority(String autoridade) {
		this.autoridade = autoridade;
	}

	public String getFk_email() {
		return fk_email;
	}

	public void setFk_email(String fk_email) {
		this.fk_email = fk_email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
