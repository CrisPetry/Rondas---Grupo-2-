package br.upf.ads.paoo.rondas.grupo2.model;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ocorrencia
 *
 */
@Entity

public class Ocorrencia implements Serializable {

	   
	@Id
	private Long id;
	private Date dataHora;
	private String titulo;
	private String descricao;
	private Float lat;
	private Float lon;
	private String foto;
	private static final long serialVersionUID = 1L;

	public Ocorrencia() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Date getDataHora() {
		return this.dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}   
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}   
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}   
	public Float getLat() {
		return this.lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}   
	public Float getLon() {
		return this.lon;
	}

	public void setLon(Float lon) {
		this.lon = lon;
	}   
	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
   
}
