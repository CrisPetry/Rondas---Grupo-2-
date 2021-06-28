package br.upf.ads.paoo.rondas.grupo2.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Base64;

import javax.persistence.*;

@Entity

public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private String nome;
	private String loginApp;
	private String senha;

	@Lob
	private byte[] foto;

	public Pessoa(Long id, String nome, String loginApp, String senha, byte[] foto) {
		super();
		this.id = id;
		this.nome = nome;
		this.loginApp = loginApp;
		this.foto = foto;
	}

	public Pessoa(Long id, String nome, String loginApp, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.loginApp = loginApp;
		this.senha = senha;
	}

	public Pessoa() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLoginApp() {
		return this.loginApp;
	}

	public void setLoginApp(String loginApp) {
		this.loginApp = loginApp;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getFotoBase64() {
		if (foto != null)
			return new String(Base64.getEncoder().encode(foto));
		else
			return "";
	}

}
