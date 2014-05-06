package co.edu.usbcali.modelo;

// Generated 21-feb-2014 23:07:19 by Zathura powered by Hibernate Tools 3.2.4.GA

import java.util.Date;

/**
 * Multifamilia generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class Multifamilia implements java.io.Serializable {

	private Long idMufa;
	private Sucursal sucursal;
	private Cliente clienteByClientePadre;
	private Cliente clienteByClienteHijo;
	private Date fechaCreacion;
	private String operCreador;
	private Date fechaModificacion;
	private String operModifica;
	private String estadoRegistro;

	public Multifamilia() {
	}

	public Multifamilia(Long idMufa, Cliente clienteByClientePadre,
			Date fechaCreacion, String operCreador, Date fechaModificacion,
			String operModifica, String estadoRegistro) {
		this.idMufa = idMufa;
		this.clienteByClientePadre = clienteByClientePadre;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
	}

	public Multifamilia(Long idMufa, Sucursal sucursal,
			Cliente clienteByClientePadre, Cliente clienteByClienteHijo,
			Date fechaCreacion, String operCreador, Date fechaModificacion,
			String operModifica, String estadoRegistro) {
		this.idMufa = idMufa;
		this.sucursal = sucursal;
		this.clienteByClientePadre = clienteByClientePadre;
		this.clienteByClienteHijo = clienteByClienteHijo;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
	}

	public Long getIdMufa() {
		return this.idMufa;
	}

	public void setIdMufa(Long idMufa) {
		this.idMufa = idMufa;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Cliente getClienteByClientePadre() {
		return this.clienteByClientePadre;
	}

	public void setClienteByClientePadre(Cliente clienteByClientePadre) {
		this.clienteByClientePadre = clienteByClientePadre;
	}

	public Cliente getClienteByClienteHijo() {
		return this.clienteByClienteHijo;
	}

	public void setClienteByClienteHijo(Cliente clienteByClienteHijo) {
		this.clienteByClienteHijo = clienteByClienteHijo;
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
