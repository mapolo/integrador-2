package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.SolicitudCampo;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class SolicitudCampoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idSoca;
	private String operCreador;
	private String operModifica;
	private String valorCadena;
	private Long valorNumerico;
	private Long idCapa_CamposParametrizables;
	private Long idSocb_SolicitudCambio;

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

	public Long getIdSoca() {
		return idSoca;
	}

	public void setIdSoca(Long idSoca) {
		this.idSoca = idSoca;
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

	public String getValorCadena() {
		return valorCadena;
	}

	public void setValorCadena(String valorCadena) {
		this.valorCadena = valorCadena;
	}

	public Long getValorNumerico() {
		return valorNumerico;
	}

	public void setValorNumerico(Long valorNumerico) {
		this.valorNumerico = valorNumerico;
	}

	public Long getIdCapa_CamposParametrizables() {
		return idCapa_CamposParametrizables;
	}

	public void setIdCapa_CamposParametrizables(
			Long idCapa_CamposParametrizables) {
		this.idCapa_CamposParametrizables = idCapa_CamposParametrizables;
	}

	public Long getIdSocb_SolicitudCambio() {
		return idSocb_SolicitudCambio;
	}

	public void setIdSocb_SolicitudCambio(Long idSocb_SolicitudCambio) {
		this.idSocb_SolicitudCambio = idSocb_SolicitudCambio;
	}
}
