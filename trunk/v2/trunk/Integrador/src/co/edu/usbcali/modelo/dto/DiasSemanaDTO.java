package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class DiasSemanaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idDise;
	private String nombre;
	private String operCreador;
	private String operModifica;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public Long getIdDise() {
		return idDise;
	}

	public void setIdDise(Long idDise) {
		this.idDise = idDise;
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
}
