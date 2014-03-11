package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.Cliente;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class ClienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idClie;
	private String operCreador;
	private String operModifica;
	private Long idEmpr_Empresa;
	private Long idPers_Persona;
	private Long idTica_TipoCartera;

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

	public Long getIdClie() {
		return idClie;
	}

	public void setIdClie(Long idClie) {
		this.idClie = idClie;
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

	public Long getIdEmpr_Empresa() {
		return idEmpr_Empresa;
	}

	public void setIdEmpr_Empresa(Long idEmpr_Empresa) {
		this.idEmpr_Empresa = idEmpr_Empresa;
	}

	public Long getIdPers_Persona() {
		return idPers_Persona;
	}

	public void setIdPers_Persona(Long idPers_Persona) {
		this.idPers_Persona = idPers_Persona;
	}

	public Long getIdTica_TipoCartera() {
		return idTica_TipoCartera;
	}

	public void setIdTica_TipoCartera(Long idTica_TipoCartera) {
		this.idTica_TipoCartera = idTica_TipoCartera;
	}
}
