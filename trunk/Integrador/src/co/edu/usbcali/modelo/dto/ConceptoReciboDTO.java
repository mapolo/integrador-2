package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.ConceptoRecibo;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class ConceptoReciboDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String aplicaCartera;
	private String codigo;
	private String descripcion;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idCpto;
	private String operCreador;
	private String operModifica;

	public String getAplicaCartera() {
		return aplicaCartera;
	}

	public void setAplicaCartera(String aplicaCartera) {
		this.aplicaCartera = aplicaCartera;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

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

	public Long getIdCpto() {
		return idCpto;
	}

	public void setIdCpto(Long idCpto) {
		this.idCpto = idCpto;
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
}
