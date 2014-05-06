package co.edu.usbcali.modelo;

// Generated 21-feb-2014 23:07:19 by Zathura powered by Hibernate Tools 3.2.4.GA

import java.util.Date;

/**
 * FrecuenciaSemana generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class FrecuenciaSemana implements java.io.Serializable {

	private Long idFrcr;
	private Semana semana;
	private FrecuenciaVisita frecuenciaVisita;
	private Date fechaCreacion;
	private String operCreador;
	private Date fechaModificacion;
	private String operModifica;
	private String estadoRegistro;

	public FrecuenciaSemana() {
	}

	public FrecuenciaSemana(Long idFrcr, Semana semana,
			FrecuenciaVisita frecuenciaVisita, Date fechaCreacion,
			String operCreador, Date fechaModificacion, String operModifica,
			String estadoRegistro) {
		this.idFrcr = idFrcr;
		this.semana = semana;
		this.frecuenciaVisita = frecuenciaVisita;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
	}

	public Long getIdFrcr() {
		return this.idFrcr;
	}

	public void setIdFrcr(Long idFrcr) {
		this.idFrcr = idFrcr;
	}

	public Semana getSemana() {
		return this.semana;
	}

	public void setSemana(Semana semana) {
		this.semana = semana;
	}

	public FrecuenciaVisita getFrecuenciaVisita() {
		return this.frecuenciaVisita;
	}

	public void setFrecuenciaVisita(FrecuenciaVisita frecuenciaVisita) {
		this.frecuenciaVisita = frecuenciaVisita;
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

}
