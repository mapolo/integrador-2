package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class ChequePosfechadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String bancoCambiado;
	private Long estado;
	private String estadoRegistro;
	private Date fechaActualizacion;
	private Date fechaAplazada;
	private Date fechaConsignacion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idChps;
	private String inaplicado;
	private String numChqCambiado;
	private String numeroCheque;
	private String operCreador;
	private String operModifica;
	private Double otroValor;
	private String recaudador;
	private String telefono;
	private Double valor;

	public String getBancoCambiado() {
		return bancoCambiado;
	}

	public void setBancoCambiado(String bancoCambiado) {
		this.bancoCambiado = bancoCambiado;
	}

	public Long getEstado() {
		return estado;
	}

	public void setEstado(Long estado) {
		this.estado = estado;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public Date getFechaAplazada() {
		return fechaAplazada;
	}

	public void setFechaAplazada(Date fechaAplazada) {
		this.fechaAplazada = fechaAplazada;
	}

	public Date getFechaConsignacion() {
		return fechaConsignacion;
	}

	public void setFechaConsignacion(Date fechaConsignacion) {
		this.fechaConsignacion = fechaConsignacion;
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

	public Long getIdChps() {
		return idChps;
	}

	public void setIdChps(Long idChps) {
		this.idChps = idChps;
	}

	public String getInaplicado() {
		return inaplicado;
	}

	public void setInaplicado(String inaplicado) {
		this.inaplicado = inaplicado;
	}

	public String getNumChqCambiado() {
		return numChqCambiado;
	}

	public void setNumChqCambiado(String numChqCambiado) {
		this.numChqCambiado = numChqCambiado;
	}

	public String getNumeroCheque() {
		return numeroCheque;
	}

	public void setNumeroCheque(String numeroCheque) {
		this.numeroCheque = numeroCheque;
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

	public Double getOtroValor() {
		return otroValor;
	}

	public void setOtroValor(Double otroValor) {
		this.otroValor = otroValor;
	}

	public String getRecaudador() {
		return recaudador;
	}

	public void setRecaudador(String recaudador) {
		this.recaudador = recaudador;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
