package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class CompaniaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String estadoCompania;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idCia;
	private String operCreador;
	private String operModifica;
	private Long idEmpr_Empresa;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEstadoCompania() {
		return estadoCompania;
	}

	public void setEstadoCompania(String estadoCompania) {
		this.estadoCompania = estadoCompania;
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

	public Long getIdCia() {
		return idCia;
	}

	public void setIdCia(Long idCia) {
		this.idCia = idCia;
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
}
