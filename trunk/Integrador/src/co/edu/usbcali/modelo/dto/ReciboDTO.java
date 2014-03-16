package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class ReciboDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaTransaccion;
	private Long idRcbo;
	private Long numeroRboProvisional;
	private String observacion;
	private String operCreador;
	private String operModifica;
	private Long idDocu_Documento;
	private Long idUnve_UnidadVenta;

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

	public Date getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(Date fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public Long getIdRcbo() {
		return idRcbo;
	}

	public void setIdRcbo(Long idRcbo) {
		this.idRcbo = idRcbo;
	}

	public Long getNumeroRboProvisional() {
		return numeroRboProvisional;
	}

	public void setNumeroRboProvisional(Long numeroRboProvisional) {
		this.numeroRboProvisional = numeroRboProvisional;
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

	public Long getIdDocu_Documento() {
		return idDocu_Documento;
	}

	public void setIdDocu_Documento(Long idDocu_Documento) {
		this.idDocu_Documento = idDocu_Documento;
	}

	public Long getIdUnve_UnidadVenta() {
		return idUnve_UnidadVenta;
	}

	public void setIdUnve_UnidadVenta(Long idUnve_UnidadVenta) {
		this.idUnve_UnidadVenta = idUnve_UnidadVenta;
	}
}
