package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class LogisticaReversivaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaOrdenada;
	private Date fechaRecibida;
	private Date fechaSolicitud;
	private Long idLore;
	private String operCreador;
	private String operModifica;

	private Long idRrec_RutaRelacionComercial;

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

	public Date getFechaOrdenada() {
		return fechaOrdenada;
	}

	public void setFechaOrdenada(Date fechaOrdenada) {
		this.fechaOrdenada = fechaOrdenada;
	}

	public Date getFechaRecibida() {
		return fechaRecibida;
	}

	public void setFechaRecibida(Date fechaRecibida) {
		this.fechaRecibida = fechaRecibida;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Long getIdLore() {
		return idLore;
	}

	public void setIdLore(Long idLore) {
		this.idLore = idLore;
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

	public Long getIdRrec_RutaRelacionComercial() {
		return idRrec_RutaRelacionComercial;
	}

	public void setIdRrec_RutaRelacionComercial(
			Long idRrec_RutaRelacionComercial) {
		this.idRrec_RutaRelacionComercial = idRrec_RutaRelacionComercial;
	}
}
