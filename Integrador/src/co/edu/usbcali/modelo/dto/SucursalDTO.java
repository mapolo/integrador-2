package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.Sucursal;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class SucursalDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String direccion;
	private String email;
	private String estadoRegistro;
	private String estadoSucursal;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idSucu;
	private String nombre;
	private String operCreador;
	private String operModifica;
	private String telefono;
	private String zipCode;
	private Long idDipo_DivisionPolitica;
	private Long idEmpr_Empresa;
	private Long idPers_Persona;
	private Long idRege_RegionalGeografica;
	private Long idSucu_Sucursal;
	private Long idTisu_TipoSucursal;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public String getEstadoSucursal() {
		return estadoSucursal;
	}

	public void setEstadoSucursal(String estadoSucursal) {
		this.estadoSucursal = estadoSucursal;
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

	public Long getIdSucu() {
		return idSucu;
	}

	public void setIdSucu(Long idSucu) {
		this.idSucu = idSucu;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Long getIdDipo_DivisionPolitica() {
		return idDipo_DivisionPolitica;
	}

	public void setIdDipo_DivisionPolitica(Long idDipo_DivisionPolitica) {
		this.idDipo_DivisionPolitica = idDipo_DivisionPolitica;
	}

	public Long getIdEmpr_Empresa() {
		return idEmpr_Empresa;
	}

	public void setIdEmpr_Empresa(Long idEmpr_Empresa) {
		this.idEmpr_Empresa = idEmpr_Empresa;
	}

	public Long getIdPers_Persona() {
		return idPers_Persona;
	}

	public void setIdPers_Persona(Long idPers_Persona) {
		this.idPers_Persona = idPers_Persona;
	}

	public Long getIdRege_RegionalGeografica() {
		return idRege_RegionalGeografica;
	}

	public void setIdRege_RegionalGeografica(Long idRege_RegionalGeografica) {
		this.idRege_RegionalGeografica = idRege_RegionalGeografica;
	}

	public Long getIdSucu_Sucursal() {
		return idSucu_Sucursal;
	}

	public void setIdSucu_Sucursal(Long idSucu_Sucursal) {
		this.idSucu_Sucursal = idSucu_Sucursal;
	}

	public Long getIdTisu_TipoSucursal() {
		return idTisu_TipoSucursal;
	}

	public void setIdTisu_TipoSucursal(Long idTisu_TipoSucursal) {
		this.idTisu_TipoSucursal = idTisu_TipoSucursal;
	}
}
