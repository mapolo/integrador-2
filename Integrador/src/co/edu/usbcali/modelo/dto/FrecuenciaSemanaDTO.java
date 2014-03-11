package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.FrecuenciaSemana;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class FrecuenciaSemanaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idFrcr;
	private String operCreador;
	private String operModifica;
	private Long idFrvi_FrecuenciaVisita;
	private Long idSema_Semana;

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Long getIdFrcr() {
		return idFrcr;
	}

	public void setIdFrcr(Long idFrcr) {
		this.idFrcr = idFrcr;
	}

	public String getOperCreador() {
		return operCreador;
	}

	public void setOperCreador(String operCreador) {
		this.operCreador = operCreador;
	}

	public String getOperModifica() {
		return operModifica;
	}

	public void setOperModifica(String operModifica) {
		this.operModifica = operModifica;
	}

	public Long getIdFrvi_FrecuenciaVisita() {
		return idFrvi_FrecuenciaVisita;
	}

	public void setIdFrvi_FrecuenciaVisita(Long idFrvi_FrecuenciaVisita) {
		this.idFrvi_FrecuenciaVisita = idFrvi_FrecuenciaVisita;
	}

	public Long getIdSema_Semana() {
		return idSema_Semana;
	}

	public void setIdSema_Semana(Long idSema_Semana) {
		this.idSema_Semana = idSema_Semana;
	}
}
