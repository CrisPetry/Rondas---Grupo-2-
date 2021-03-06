package br.upf.ads.paoo.rondas.grupo2.model;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

public class Usuario implements Serializable {

	   
	@Id
	private Long id;
	@Column(length=20, unique=true, nullable=false)
	private String email;
	@Column(length=50, unique=true, nullable=false)
	private String nome;
	@Column(length=50, nullable=false)
	private String senha;
	
	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	}   
	
	public Usuario(Long id, String email, String nome, String senha) {
		super();
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		
	}
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
   
}
