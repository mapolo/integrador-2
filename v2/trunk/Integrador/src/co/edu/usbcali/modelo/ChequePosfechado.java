package co.edu.usbcali.modelo;

// Generated 21-feb-2014 23:07:19 by Zathura powered by Hibernate Tools 3.2.4.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ChequePosfechado generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class ChequePosfechado implements java.io.Serializable {

	private Long idChps;
	private String numeroCheque;
	private Date fechaConsignacion;
	private Date fechaActualizacion;
	private Double valor;
	private Double otroValor;
	private String telefono;
	private Date fechaAplazada;
	private String bancoCambiado;
	private String numChqCambiado;
	private Long estado;
	private String recaudador;
	private String inaplicado;
	private Date fechaCreacion;
	private String operCreador;
	private Date fechaModificacion;
	private String operModifica;
	private String estadoRegistro;
	private Set<RboDetalleFormasPago> rboDetalleFormasPagos = new HashSet<RboDetalleFormasPago>(
			0);

	public ChequePosfechado() {
	}

	public ChequePosfechado(Long idChps, String numeroCheque, Double valor,
			Long estado, Date fechaCreacion, String operCreador,
			Date fechaModificacion, String operModifica, String estadoRegistro) {
		this.idChps = idChps;
		this.numeroCheque = numeroCheque;
		this.valor = valor;
		this.estado = estado;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
	}

	public ChequePosfechado(Long idChps, String numeroCheque,
			Date fechaConsignacion, Date fechaActualizacion, Double valor,
			Double otroValor, String telefono, Date fechaAplazada,
			String bancoCambiado, String numChqCambiado, Long estado,
			String recaudador, String inaplicado, Date fechaCreacion,
			String operCreador, Date fechaModificacion, String operModifica,
			String estadoRegistro,
			Set<RboDetalleFormasPago> rboDetalleFormasPagos) {
		this.idChps = idChps;
		this.numeroCheque = numeroCheque;
		this.fechaConsignacion = fechaConsignacion;
		this.fechaActualizacion = fechaActualizacion;
		this.valor = valor;
		this.otroValor = otroValor;
		this.telefono = telefono;
		this.fechaAplazada = fechaAplazada;
		this.bancoCambiado = bancoCambiado;
		this.numChqCambiado = numChqCambiado;
		this.estado = estado;
		this.recaudador = recaudador;
		this.inaplicado = inaplicado;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
		this.rboDetalleFormasPagos = rboDetalleFormasPagos;
	}

	public Long getIdChps() {
		return this.idChps;
	}

	public void setIdChps(Long idChps) {
		this.idChps = idChps;
	}

	public String getNumeroCheque() {
		return this.numeroCheque;
	}

	public void setNumeroCheque(String numeroCheque) {
		this.numeroCheque = numeroCheque;
	}

	public Date getFechaConsignacion() {
		return this.fechaConsignacion;
	}

	public void setFechaConsignacion(Date fechaConsignacion) {
		this.fechaConsignacion = fechaConsignacion;
	}

	public Date getFechaActualizacion() {
		return this.fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getOtroValor() {
		return this.otroValor;
	}

	public void setOtroValor(Double otroValor) {
		this.otroValor = otroValor;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaAplazada() {
		return this.fechaAplazada;
	}

	public void setFechaAplazada(Date fechaAplazada) {
		this.fechaAplazada = fechaAplazada;
	}

	public String getBancoCambiado() {
		return this.bancoCambiado;
	}

	public void setBancoCambiado(String bancoCambiado) {
		this.bancoCambiado = bancoCambiado;
	}

	public String getNumChqCambiado() {
		return this.numChqCambiado;
	}

	public void setNumChqCambiado(String numChqCambiado) {
		this.numChqCambiado = numChqCambiado;
	}

	public Long getEstado() {
		return this.estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public String getRecaudador() {
		return this.recaudador;
	}

	public void setRecaudador(String recaudador) {
		this.recaudador = recaudador;
	}

	public String getInaplicado() {
		return this.inaplicado;
	}

	public void setInaplicado(String inaplicado) {
		this.inaplicado = inaplicado;
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

	public Set<RboDetalleFormasPago> getRboDetalleFormasPagos() {
		return this.rboDetalleFormasPagos;
	}

	public void setRboDetalleFormasPagos(
			Set<RboDetalleFormasPago> rboDetalleFormasPagos) {
		this.rboDetalleFormasPagos = rboDetalleFormasPagos;
	}

}
