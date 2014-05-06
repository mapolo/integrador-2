package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class UnidadVentaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String activo;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaInactivo;
	private Date fechaModificacion;
	private Long idUnve;
	private String operCreador;
	private String operModifica;
	private Long idUnne_UnidadNegocio;
	private Long idVend_Vendedor;

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
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

	public Date getFechaInactivo() {
		return fechaInactivo;
	}

	public void setFechaInactivo(Date fechaInactivo) {
		this.fechaInactivo = fechaInactivo;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Long getIdUnve() {
		return idUnve;
	}

	public void setIdUnve(Long idUnve) {
		this.idUnve = idUnve;
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

	public Long getIdUnne_UnidadNegocio() {
		return idUnne_UnidadNegocio;
	}

	public void setIdUnne_UnidadNegocio(Long idUnne_UnidadNegocio) {
		this.idUnne_UnidadNegocio = idUnne_UnidadNegocio;
	}

	public Long getIdVend_Vendedor() {
		return idVend_Vendedor;
	}

	public void setIdVend_Vendedor(Long idVend_Vendedor) {
		this.idVend_Vendedor = idVend_Vendedor;
	}
}
