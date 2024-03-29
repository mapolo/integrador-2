package co.edu.usbcali.modelo;

// Generated 21-feb-2014 23:07:19 by Zathura powered by Hibernate Tools 3.2.4.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Cliente generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class Cliente implements java.io.Serializable {

	private Long idClie;
	private Persona persona;
	private Empresa empresa;
	private TipoCartera tipoCartera;
	private Date fechaCreacion;
	private String operCreador;
	private Date fechaModificacion;
	private String operModifica;
	private String estadoRegistro;
	private Set<Multifamilia> multifamiliasForClienteHijo = new HashSet<Multifamilia>(
			0);
	private Set<Multifamilia> multifamiliasForClientePadre = new HashSet<Multifamilia>(
			0);

	public Cliente() {
	}

	public Cliente(Long idClie, TipoCartera tipoCartera, Date fechaCreacion,
			String operCreador, Date fechaModificacion, String operModifica,
			String estadoRegistro) {
		this.idClie = idClie;
		this.tipoCartera = tipoCartera;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
	}

	public Cliente(Long idClie, Persona persona, Empresa empresa,
			TipoCartera tipoCartera, Date fechaCreacion, String operCreador,
			Date fechaModificacion, String operModifica, String estadoRegistro,
			Set<Multifamilia> multifamiliasForClienteHijo,
			Set<Multifamilia> multifamiliasForClientePadre) {
		this.idClie = idClie;
		this.persona = persona;
		this.empresa = empresa;
		this.tipoCartera = tipoCartera;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
		this.multifamiliasForClienteHijo = multifamiliasForClienteHijo;
		this.multifamiliasForClientePadre = multifamiliasForClientePadre;
	}

	public Long getIdClie() {
		return this.idClie;
	}

	public void setIdClie(Long idClie) {
		this.idClie = idClie;
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

	public TipoCartera getTipoCartera() {
		return this.tipoCartera;
	}

	public void setTipoCartera(TipoCartera tipoCartera) {
		this.tipoCartera = tipoCartera;
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

	public Set<Multifamilia> getMultifamiliasForClienteHijo() {
		return this.multifamiliasForClienteHijo;
	}

	public void setMultifamiliasForClienteHijo(
			Set<Multifamilia> multifamiliasForClienteHijo) {
		this.multifamiliasForClienteHijo = multifamiliasForClienteHijo;
	}

	public Set<Multifamilia> getMultifamiliasForClientePadre() {
		return this.multifamiliasForClientePadre;
	}

	public void setMultifamiliasForClientePadre(
			Set<Multifamilia> multifamiliasForClientePadre) {
		this.multifamiliasForClientePadre = multifamiliasForClientePadre;
	}

}
