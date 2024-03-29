package co.edu.usbcali.modelo;

// Generated 21-feb-2014 23:07:19 by Zathura powered by Hibernate Tools 3.2.4.GA

import java.util.Date;

/**
 * ListaPreciosEspeciales generated by Zathura powered by
 * Hibernate-tools(hbm2java)
 */
public class ListaPreciosEspeciales implements java.io.Serializable {

	private Long idLipe;
	private Persona persona;
	private Empresa empresa;
	private Referencia referencia;
	private Sucursal sucursalBySucursal;
	private Sucursal sucursalByIdSucu;
	private Date fechaInicial;
	private Date fechaVencimiento;
	private Double precio;
	private String tipoGrabado;
	private String concepto;
	private String espacios;
	private Date fechaCreacion;
	private String operCreador;
	private Date fechaModificacion;
	private String operModifica;
	private String estadoRegistro;

	public ListaPreciosEspeciales() {
	}

	public ListaPreciosEspeciales(Long idLipe, Referencia referencia,
			Sucursal sucursalBySucursal, Date fechaInicial,
			Date fechaVencimiento, Double precio, Date fechaCreacion,
			String operCreador, Date fechaModificacion, String operModifica,
			String estadoRegistro) {
		this.idLipe = idLipe;
		this.referencia = referencia;
		this.sucursalBySucursal = sucursalBySucursal;
		this.fechaInicial = fechaInicial;
		this.fechaVencimiento = fechaVencimiento;
		this.precio = precio;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
	}

	public ListaPreciosEspeciales(Long idLipe, Persona persona,
			Empresa empresa, Referencia referencia,
			Sucursal sucursalBySucursal, Sucursal sucursalByIdSucu,
			Date fechaInicial, Date fechaVencimiento, Double precio,
			String tipoGrabado, String concepto, String espacios,
			Date fechaCreacion, String operCreador, Date fechaModificacion,
			String operModifica, String estadoRegistro) {
		this.idLipe = idLipe;
		this.persona = persona;
		this.empresa = empresa;
		this.referencia = referencia;
		this.sucursalBySucursal = sucursalBySucursal;
		this.sucursalByIdSucu = sucursalByIdSucu;
		this.fechaInicial = fechaInicial;
		this.fechaVencimiento = fechaVencimiento;
		this.precio = precio;
		this.tipoGrabado = tipoGrabado;
		this.concepto = concepto;
		this.espacios = espacios;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
	}

	public Long getIdLipe() {
		return this.idLipe;
	}

	public void setIdLipe(Long idLipe) {
		this.idLipe = idLipe;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Referencia getReferencia() {
		return this.referencia;
	}

	public void setReferencia(Referencia referencia) {
		this.referencia = referencia;
	}

	public Sucursal getSucursalBySucursal() {
		return this.sucursalBySucursal;
	}

	public void setSucursalBySucursal(Sucursal sucursalBySucursal) {
		this.sucursalBySucursal = sucursalBySucursal;
	}

	public Sucursal getSucursalByIdSucu() {
		return this.sucursalByIdSucu;
	}

	public void setSucursalByIdSucu(Sucursal sucursalByIdSucu) {
		this.sucursalByIdSucu = sucursalByIdSucu;
	}

	public Date getFechaInicial() {
		return this.fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getTipoGrabado() {
		return this.tipoGrabado;
	}

	public void setTipoGrabado(String tipoGrabado) {
		this.tipoGrabado = tipoGrabado;
	}

	public String getConcepto() {
		return this.concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getEspacios() {
		return this.espacios;
	}

	public void setEspacios(String espacios) {
		this.espacios = espacios;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getOperCreador() {
		return this.operCreador;
	}

	public void setOperCreador(String operCreador) {
		this.operCreador = operCreador;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getOperModifica() {
		return this.operModifica;
	}

	public void setOperModifica(String operModifica) {
		this.operModifica = operModifica;
	}

	public String getEstadoRegistro() {
		return this.estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

}
