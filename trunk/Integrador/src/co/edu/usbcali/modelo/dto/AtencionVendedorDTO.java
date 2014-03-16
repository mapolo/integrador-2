package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class AtencionVendedorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idAtve;
	private String operCreador;
	private String operModifica;
	private Long idReco_RelacionComercial;
	private Long idVend_Vendedor;

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

	public Long getIdAtve() {
		return idAtve;
	}

	public void setIdAtve(Long idAtve) {
		this.idAtve = idAtve;
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

	public Long getIdReco_RelacionComercial() {
		return idReco_RelacionComercial;
	}

	public void setIdReco_RelacionComercial(Long idReco_RelacionComercial) {
		this.idReco_RelacionComercial = idReco_RelacionComercial;
	}

	public Long getIdVend_Vendedor() {
		return idVend_Vendedor;
	}

	public void setIdVend_Vendedor(Long idVend_Vendedor) {
		this.idVend_Vendedor = idVend_Vendedor;
	}
}
