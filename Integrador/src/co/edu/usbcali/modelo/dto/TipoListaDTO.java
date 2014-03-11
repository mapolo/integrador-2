package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.TipoLista;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class TipoListaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String descripcion;
	private Long esCombinacion;
	private String espacios;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idTili;
	private String operCreador;
	private String operModifica;
	private Long idTisu_TipoSucursal;

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

	public Long getEsCombinacion() {
		return esCombinacion;
	}

	public void setEsCombinacion(Long esCombinacion) {
		this.esCombinacion = esCombinacion;
	}

	public String getEspacios() {
		return espacios;
	}

	public void setEspacios(String espacios) {
		this.espacios = espacios;
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

	public Long getIdTili() {
		return idTili;
	}

	public void setIdTili(Long idTili) {
		this.idTili = idTili;
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

	public Long getIdTisu_TipoSucursal() {
		return idTisu_TipoSucursal;
	}

	public void setIdTisu_TipoSucursal(Long idTisu_TipoSucursal) {
		this.idTisu_TipoSucursal = idTisu_TipoSucursal;
	}
}
