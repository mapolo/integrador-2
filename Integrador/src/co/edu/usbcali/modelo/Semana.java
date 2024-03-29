package co.edu.usbcali.modelo;

// Generated 21-feb-2014 23:07:19 by Zathura powered by Hibernate Tools 3.2.4.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Semana generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class Semana implements java.io.Serializable {

	private Long idSema;
	private Long numeroSemana;
	private Date fechaCreacion;
	private String operCreador;
	private Date fechaModificacion;
	private String operModifica;
	private String estadoRegistro;
	private Set<ConfSemanasAno> confSemanasAnos = new HashSet<ConfSemanasAno>(0);
	private Set<FrecuenciaSemana> frecuenciaSemanas = new HashSet<FrecuenciaSemana>(
			0);

	public Semana() {
	}

	public Semana(Long idSema, Date fechaCreacion, String operCreador,
			Date fechaModificacion, String operModifica, String estadoRegistro) {
		this.idSema = idSema;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
	}

	public Semana(Long idSema, Long numeroSemana, Date fechaCreacion,
			String operCreador, Date fechaModificacion, String operModifica,
			String estadoRegistro, Set<ConfSemanasAno> confSemanasAnos,
			Set<FrecuenciaSemana> frecuenciaSemanas) {
		this.idSema = idSema;
		this.numeroSemana = numeroSemana;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
		this.confSemanasAnos = confSemanasAnos;
		this.frecuenciaSemanas = frecuenciaSemanas;
	}

	public Long getIdSema() {
		return this.idSema;
	}

	public void setIdSema(Long idSema) {
		this.idSema = idSema;
	}

	public Long getNumeroSemana() {
		return this.numeroSemana;
	}

	public void setNumeroSemana(Long numeroSemana) {
		this.numeroSemana = numeroSemana;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getOperCreador() {
		return this.operCreador;
	}

	public void setOperCreador(String operCreador) {
		this.operCreador = operCreador;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getOperModifica() {
		return this.operModifica;
	}

	public void setOperModifica(String operModifica) {
		this.operModifica = operModifica;
	}

	public String getEstadoRegistro() {
		return this.estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public Set<ConfSemanasAno> getConfSemanasAnos() {
		return this.confSemanasAnos;
	}

	public void setConfSemanasAnos(Set<ConfSemanasAno> confSemanasAnos) {
		this.confSemanasAnos = confSemanasAnos;
	}

	public Set<FrecuenciaSemana> getFrecuenciaSemanas() {
		return this.frecuenciaSemanas;
	}

	public void setFrecuenciaSemanas(Set<FrecuenciaSemana> frecuenciaSemanas) {
		this.frecuenciaSemanas = frecuenciaSemanas;
	}

}
