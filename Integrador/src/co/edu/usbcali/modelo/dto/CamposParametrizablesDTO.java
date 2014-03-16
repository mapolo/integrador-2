package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class CamposParametrizablesDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idCapa;
	private String nombre;
	private String operCreador;
	private String operModifica;
	private Long idTabl_Tabla;

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

	public Long getIdCapa() {
		return idCapa;
	}

	public void setIdCapa(Long idCapa) {
		this.idCapa = idCapa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public Long getIdTabl_Tabla() {
		return idTabl_Tabla;
	}

	public void setIdTabl_Tabla(Long idTabl_Tabla) {
		this.idTabl_Tabla = idTabl_Tabla;
	}
}
