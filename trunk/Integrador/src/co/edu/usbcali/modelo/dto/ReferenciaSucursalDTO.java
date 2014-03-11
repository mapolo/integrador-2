package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.ReferenciaSucursal;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class ReferenciaSucursalDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idResu;
	private String operCreador;
	private String operModifica;
	private Long idRefe_Referencia;
	private Long idSucu_Sucursal;

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

	public Long getIdResu() {
		return idResu;
	}

	public void setIdResu(Long idResu) {
		this.idResu = idResu;
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

	public Long getIdRefe_Referencia() {
		return idRefe_Referencia;
	}

	public void setIdRefe_Referencia(Long idRefe_Referencia) {
		this.idRefe_Referencia = idRefe_Referencia;
	}

	public Long getIdSucu_Sucursal() {
		return idSucu_Sucursal;
	}

	public void setIdSucu_Sucursal(Long idSucu_Sucursal) {
		this.idSucu_Sucursal = idSucu_Sucursal;
	}
}
