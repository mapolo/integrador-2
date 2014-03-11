package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.Familia;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class FamiliaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String descripcion;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idFlia;
	private String manejaGalones;
	private String manejaPesos;
	private String manejaUnidades;
	private String operCreador;
	private String operModifica;

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

	public Long getIdFlia() {
		return idFlia;
	}

	public void setIdFlia(Long idFlia) {
		this.idFlia = idFlia;
	}

	public String getManejaGalones() {
		return manejaGalones;
	}

	public void setManejaGalones(String manejaGalones) {
		this.manejaGalones = manejaGalones;
	}

	public String getManejaPesos() {
		return manejaPesos;
	}

	public void setManejaPesos(String manejaPesos) {
		this.manejaPesos = manejaPesos;
	}

	public String getManejaUnidades() {
		return manejaUnidades;
	}

	public void setManejaUnidades(String manejaUnidades) {
		this.manejaUnidades = manejaUnidades;
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
