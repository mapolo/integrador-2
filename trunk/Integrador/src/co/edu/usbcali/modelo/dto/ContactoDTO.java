package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.Contacto;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class ContactoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String email;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idCont;
	private String nombreCompleto;
	private String operCreador;
	private String operModifica;
	private String telefono1;
	private String telefono2;
	private Long idAtve_AtencionVendedor;
	private Long idSucu_Sucursal;
	private Long idTico_TipoContacto;

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

	public Long getIdCont() {
		return idCont;
	}

	public void setIdCont(Long idCont) {
		this.idCont = idCont;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
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

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public Long getIdAtve_AtencionVendedor() {
		return idAtve_AtencionVendedor;
	}

	public void setIdAtve_AtencionVendedor(Long idAtve_AtencionVendedor) {
		this.idAtve_AtencionVendedor = idAtve_AtencionVendedor;
	}

	public Long getIdSucu_Sucursal() {
		return idSucu_Sucursal;
	}

	public void setIdSucu_Sucursal(Long idSucu_Sucursal) {
		this.idSucu_Sucursal = idSucu_Sucursal;
	}

	public Long getIdTico_TipoContacto() {
		return idTico_TipoContacto;
	}

	public void setIdTico_TipoContacto(Long idTico_TipoContacto) {
		this.idTico_TipoContacto = idTico_TipoContacto;
	}
}
