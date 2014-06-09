package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class VendedorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String email;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idVend;
	private String operCreador;
	private String operModifica;
	private Long idPers_Persona;
	private String idPers_Persona2;
    private Long idSucu_Sucursal;
    private String idSucu_Sucursal2;
    private Long idVend_Vendedor;
    private String idVend_Vendedor2;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Long getIdVend() {
		return idVend;
	}

	public void setIdVend(Long idVend) {
		this.idVend = idVend;
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

	public Long getIdPers_Persona() {
		return idPers_Persona;
	}

	public void setIdPers_Persona(Long idPers_Persona) {
		this.idPers_Persona = idPers_Persona;
	}

	public Long getIdSucu_Sucursal() {
		return idSucu_Sucursal;
	}

	public void setIdSucu_Sucursal(Long idSucu_Sucursal) {
		this.idSucu_Sucursal = idSucu_Sucursal;
	}

	public Long getIdVend_Vendedor() {
		return idVend_Vendedor;
	}

	public void setIdVend_Vendedor(Long idVend_Vendedor) {
		this.idVend_Vendedor = idVend_Vendedor;
	}

	public String getIdPers_Persona2() {
		return idPers_Persona2;
	}

	public void setIdPers_Persona2(String idPers_Persona2) {
		this.idPers_Persona2 = idPers_Persona2;
	}

	public String getIdSucu_Sucursal2() {
		return idSucu_Sucursal2;
	}

	public void setIdSucu_Sucursal2(String idSucu_Sucursal2) {
		this.idSucu_Sucursal2 = idSucu_Sucursal2;
	}

	public String getIdVend_Vendedor2() {
		return idVend_Vendedor2;
	}

	public void setIdVend_Vendedor2(String idVend_Vendedor2) {
		this.idVend_Vendedor2 = idVend_Vendedor2;
	}
}
