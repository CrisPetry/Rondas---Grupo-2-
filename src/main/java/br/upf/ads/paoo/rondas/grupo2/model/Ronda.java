package br.upf.ads.paoo.rondas.grupo2.model;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Long;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ronda
 *
 */
@Entity

public class Ronda implements Serializable {

	   
	@Id
	private Long id;
	private Date dataHoraInicio;
	private Date dataHoraFim;
	private Float latUltima;
	private Float lonUltima;
	private Date dataHoraUltima;
	private static final long serialVersionUID = 1L;

	public Ronda() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Date getDataHoraInicio() {
		return this.dataHoraInicio;
	}

	public void setDataHoraInicio(Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}   
	public Date getDataHoraFim() {
		return this.dataHoraFim;
	}

	public void setDataHoraFim(Date dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}   
	public Float getLatUltima() {
		return this.latUltima;
	}

	public void setLatUltima(Float latUltima) {
		this.latUltima = latUltima;
	}   
	public Float getLonUltima() {
		return this.lonUltima;
	}

	public void setLonUltima(Float lonUltima) {
		this.lonUltima = lonUltima;
	}   
	public Date getDataHoraUltima() {
		return this.dataHoraUltima;
	}

	public void setDataHoraUltima(Date dataHoraUltima) {
		this.dataHoraUltima = dataHoraUltima;
	}
   
}
