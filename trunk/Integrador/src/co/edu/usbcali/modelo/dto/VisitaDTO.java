package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.Visita;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class VisitaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String estadoRegistro;
	private String estadoVisita;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idVisi;
	private String observacion;
	private String operCreador;
	private String operModifica;
	private Long idCusa_Causal;
	private Long idPrad_ProgramacionAdicional;
	private Long idPrvi_ProgramacionVisitas;

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getEstadoVisita() {
		return estadoVisita;
	}

	public void setEstadoVisita(String estadoVisita) {
		this.estadoVisita = estadoVisita;
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

	public Long getIdVisi() {
		return idVisi;
	}

	public void setIdVisi(Long idVisi) {
		this.idVisi = idVisi;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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

	public Long getIdCusa_Causal() {
		return idCusa_Causal;
	}

	public void setIdCusa_Causal(Long idCusa_Causal) {
		this.idCusa_Causal = idCusa_Causal;
	}

	public Long getIdPrad_ProgramacionAdicional() {
		return idPrad_ProgramacionAdicional;
	}

	public void setIdPrad_ProgramacionAdicional(
			Long idPrad_ProgramacionAdicional) {
		this.idPrad_ProgramacionAdicional = idPrad_ProgramacionAdicional;
	}

	public Long getIdPrvi_ProgramacionVisitas() {
		return idPrvi_ProgramacionVisitas;
	}

	public void setIdPrvi_ProgramacionVisitas(Long idPrvi_ProgramacionVisitas) {
		this.idPrvi_ProgramacionVisitas = idPrvi_ProgramacionVisitas;
	}
}
