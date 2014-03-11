package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.DetalleVisita;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class DetalleVisitaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idDevi;
	private String operCreador;
	private String operModifica;
	private Long idDocu_Documento;
	private Long idVisi_Visita;

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

	public Long getIdDevi() {
		return idDevi;
	}

	public void setIdDevi(Long idDevi) {
		this.idDevi = idDevi;
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

	public Long getIdDocu_Documento() {
		return idDocu_Documento;
	}

	public void setIdDocu_Documento(Long idDocu_Documento) {
		this.idDocu_Documento = idDocu_Documento;
	}

	public Long getIdVisi_Visita() {
		return idVisi_Visita;
	}

	public void setIdVisi_Visita(Long idVisi_Visita) {
		this.idVisi_Visita = idVisi_Visita;
	}
}
