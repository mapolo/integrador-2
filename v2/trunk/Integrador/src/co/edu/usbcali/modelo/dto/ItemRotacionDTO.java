package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class ItemRotacionDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String autorizado;
	private Long cantidadCambio;
	private Long cantidadOrdenada;
	private Long cantidadPedida;
	private String causalNoCambio;
	private String estado;
	private String estadoRegistro;
	private Date fechaAutorizacion;
	private Date fechaCambio;
	private Date fechaCausal;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaMovimiento;
	private Date fechaOrdenada;
	private Long idItro;
	private Long numeroDespacho;
	private String numeroGarantia;
	private String observacion;
	private String observacionCambio;
	private String operCreador;
	private String operModifica;
	private Long idClfa_ClaveFabricacion;
	private Long idDocu_Documento;

	public String getAutorizado() {
		return autorizado;
	}

	public void setAutorizado(String autorizado) {
		this.autorizado = autorizado;
	}

	public Long getCantidadCambio() {
		return cantidadCambio;
	}

	public void setCantidadCambio(Long cantidadCambio) {
		this.cantidadCambio = cantidadCambio;
	}

	public Long getCantidadOrdenada() {
		return cantidadOrdenada;
	}

	public void setCantidadOrdenada(Long cantidadOrdenada) {
		this.cantidadOrdenada = cantidadOrdenada;
	}

	public Long getCantidadPedida() {
		return cantidadPedida;
	}

	public void setCantidadPedida(Long cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}

	public String getCausalNoCambio() {
		return causalNoCambio;
	}

	public void setCausalNoCambio(String causalNoCambio) {
		this.causalNoCambio = causalNoCambio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public Date getFechaAutorizacion() {
		return fechaAutorizacion;
	}

	public void setFechaAutorizacion(Date fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}

	public Date getFechaCambio() {
		return fechaCambio;
	}

	public void setFechaCambio(Date fechaCambio) {
		this.fechaCambio = fechaCambio;
	}

	public Date getFechaCausal() {
		return fechaCausal;
	}

	public void setFechaCausal(Date fechaCausal) {
		this.fechaCausal = fechaCausal;
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

	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	public Date getFechaOrdenada() {
		return fechaOrdenada;
	}

	public void setFechaOrdenada(Date fechaOrdenada) {
		this.fechaOrdenada = fechaOrdenada;
	}

	public Long getIdItro() {
		return idItro;
	}

	public void setIdItro(Long idItro) {
		this.idItro = idItro;
	}

	public Long getNumeroDespacho() {
		return numeroDespacho;
	}

	public void setNumeroDespacho(Long numeroDespacho) {
		this.numeroDespacho = numeroDespacho;
	}

	public String getNumeroGarantia() {
		return numeroGarantia;
	}

	public void setNumeroGarantia(String numeroGarantia) {
		this.numeroGarantia = numeroGarantia;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getObservacionCambio() {
		return observacionCambio;
	}

	public void setObservacionCambio(String observacionCambio) {
		this.observacionCambio = observacionCambio;
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

	public Long getIdClfa_ClaveFabricacion() {
		return idClfa_ClaveFabricacion;
	}

	public void setIdClfa_ClaveFabricacion(Long idClfa_ClaveFabricacion) {
		this.idClfa_ClaveFabricacion = idClfa_ClaveFabricacion;
	}

	public Long getIdDocu_Documento() {
		return idDocu_Documento;
	}

	public void setIdDocu_Documento(Long idDocu_Documento) {
		this.idDocu_Documento = idDocu_Documento;
	}

}
