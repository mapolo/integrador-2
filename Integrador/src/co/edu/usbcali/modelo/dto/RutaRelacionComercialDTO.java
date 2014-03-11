package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.RutaRelacionComercial;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class RutaRelacionComercialDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idRrec;
	private String operCreador;
	private String operModifica;
	private Long idAtve_AtencionVendedor;
	private Long idRudi_RutaDistribucion;

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

	public Long getIdRrec() {
		return idRrec;
	}

	public void setIdRrec(Long idRrec) {
		this.idRrec = idRrec;
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

	public Long getIdAtve_AtencionVendedor() {
		return idAtve_AtencionVendedor;
	}

	public void setIdAtve_AtencionVendedor(Long idAtve_AtencionVendedor) {
		this.idAtve_AtencionVendedor = idAtve_AtencionVendedor;
	}

	public Long getIdRudi_RutaDistribucion() {
		return idRudi_RutaDistribucion;
	}

	public void setIdRudi_RutaDistribucion(Long idRudi_RutaDistribucion) {
		this.idRudi_RutaDistribucion = idRudi_RutaDistribucion;
	}
}
