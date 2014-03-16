package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class EmpresaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String apartadoAereo;
	private String direccion;
	private String email;
	private String estadoRegistro;
	private String fax;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idEmpr;
	private Long identificacion;
	private String nombre;
	private String operCreador;
	private String operModifica;
	private String telefono1;
	private String telefono2;
	private Long idDipo_DivisionPolitica;
	private Long idPers_Persona;
	private Long idTiid_TipoIdentificacion;

	public String getApartadoAereo() {
		return apartadoAereo;
	}

	public void setApartadoAereo(String apartadoAereo) {
		this.apartadoAereo = apartadoAereo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
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

	public Long getIdEmpr() {
		return idEmpr;
	}

	public void setIdEmpr(Long idEmpr) {
		this.idEmpr = idEmpr;
	}

	public Long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
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

	public Long getIdDipo_DivisionPolitica() {
		return idDipo_DivisionPolitica;
	}

	public void setIdDipo_DivisionPolitica(Long idDipo_DivisionPolitica) {
		this.idDipo_DivisionPolitica = idDipo_DivisionPolitica;
	}

	public Long getIdPers_Persona() {
		return idPers_Persona;
	}

	public void setIdPers_Persona(Long idPers_Persona) {
		this.idPers_Persona = idPers_Persona;
	}

	public Long getIdTiid_TipoIdentificacion() {
		return idTiid_TipoIdentificacion;
	}

	public void setIdTiid_TipoIdentificacion(Long idTiid_TipoIdentificacion) {
		this.idTiid_TipoIdentificacion = idTiid_TipoIdentificacion;
	}
}
