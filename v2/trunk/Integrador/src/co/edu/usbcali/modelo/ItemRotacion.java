package co.edu.usbcali.modelo;

// Generated 21-feb-2014 23:07:19 by Zathura powered by Hibernate Tools 3.2.4.GA

import java.util.Date;

/**
 * ItemRotacion generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class ItemRotacion implements java.io.Serializable {

	private Long idItro;
	private Documento documento;
	private ClaveFabricacion claveFabricacion;
	private Referencia referenciaByReferenciaRecibida;
	private Referencia referenciaByReferenciaEntregada;
	private String numeroGarantia;
	private String estado;
	private Long cantidadPedida;
	private String observacion;
	private String autorizado;
	private Long cantidadOrdenada;
	private Date fechaOrdenada;
	private Long cantidadCambio;
	private Date fechaCambio;
	private String observacionCambio;
	private String causalNoCambio;
	private Long numeroDespacho;
	private Date fechaAutorizacion;
	private Date fechaCausal;
	private Date fechaCreacion;
	private String operCreador;
	private Date fechaModificacion;
	private String operModifica;
	private String estadoRegistro;
	private Date fechaMovimiento;

	public ItemRotacion() {
	}

	public ItemRotacion(Long idItro, Documento documento,
			ClaveFabricacion claveFabricacion,
			Referencia referenciaByReferenciaRecibida, String estado,
			Date fechaCreacion, String operCreador, Date fechaModificacion,
			String operModifica, String estadoRegistro) {
		this.idItro = idItro;
		this.documento = documento;
		this.claveFabricacion = claveFabricacion;
		this.referenciaByReferenciaRecibida = referenciaByReferenciaRecibida;
		this.estado = estado;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
	}

	public ItemRotacion(Long idItro, Documento documento,
			ClaveFabricacion claveFabricacion,
			Referencia referenciaByReferenciaRecibida,
			Referencia referenciaByReferenciaEntregada, String numeroGarantia,
			String estado, Long cantidadPedida, String observacion,
			String autorizado, Long cantidadOrdenada, Date fechaOrdenada,
			Long cantidadCambio, Date fechaCambio, String observacionCambio,
			String causalNoCambio, Long numeroDespacho, Date fechaAutorizacion,
			Date fechaCausal, Date fechaCreacion, String operCreador,
			Date fechaModificacion, String operModifica, String estadoRegistro,
			Date fechaMovimiento) {
		this.idItro = idItro;
		this.documento = documento;
		this.claveFabricacion = claveFabricacion;
		this.referenciaByReferenciaRecibida = referenciaByReferenciaRecibida;
		this.referenciaByReferenciaEntregada = referenciaByReferenciaEntregada;
		this.numeroGarantia = numeroGarantia;
		this.estado = estado;
		this.cantidadPedida = cantidadPedida;
		this.observacion = observacion;
		this.autorizado = autorizado;
		this.cantidadOrdenada = cantidadOrdenada;
		this.fechaOrdenada = fechaOrdenada;
		this.cantidadCambio = cantidadCambio;
		this.fechaCambio = fechaCambio;
		this.observacionCambio = observacionCambio;
		this.causalNoCambio = causalNoCambio;
		this.numeroDespacho = numeroDespacho;
		this.fechaAutorizacion = fechaAutorizacion;
		this.fechaCausal = fechaCausal;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
		this.fechaMovimiento = fechaMovimiento;
	}

	public Long getIdItro() {
		return this.idItro;
	}

	public void setIdItro(Long idItro) {
		this.idItro = idItro;
	}

	public Documento getDocumento() {
		return this.documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public ClaveFabricacion getClaveFabricacion() {
		return this.claveFabricacion;
	}

	public void setClaveFabricacion(ClaveFabricacion claveFabricacion) {
		this.claveFabricacion = claveFabricacion;
	}

	public Referencia getReferenciaByReferenciaRecibida() {
		return this.referenciaByReferenciaRecibida;
	}

	public void setReferenciaByReferenciaRecibida(
			Referencia referenciaByReferenciaRecibida) {
		this.referenciaByReferenciaRecibida = referenciaByReferenciaRecibida;
	}

	public Referencia getReferenciaByReferenciaEntregada() {
		return this.referenciaByReferenciaEntregada;
	}

	public void setReferenciaByReferenciaEntregada(
			Referencia referenciaByReferenciaEntregada) {
		this.referenciaByReferenciaEntregada = referenciaByReferenciaEntregada;
	}

	public String getNumeroGarantia() {
		return this.numeroGarantia;
	}

	public void setNumeroGarantia(String numeroGarantia) {
		this.numeroGarantia = numeroGarantia;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getCantidadPedida() {
		return this.cantidadPedida;
	}

	public void setCantidadPedida(Long cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getAutorizado() {
		return this.autorizado;
	}

	public void setAutorizado(String autorizado) {
		this.autorizado = autorizado;
	}

	public Long getCantidadOrdenada() {
		return this.cantidadOrdenada;
	}

	public void setCantidadOrdenada(Long cantidadOrdenada) {
		this.cantidadOrdenada = cantidadOrdenada;
	}

	public Date getFechaOrdenada() {
		return this.fechaOrdenada;
	}

	public void setFechaOrdenada(Date fechaOrdenada) {
		this.fechaOrdenada = fechaOrdenada;
	}

	public Long getCantidadCambio() {
		return this.cantidadCambio;
	}

	public void setCantidadCambio(Long cantidadCambio) {
		this.cantidadCambio = cantidadCambio;
	}

	public Date getFechaCambio() {
		return this.fechaCambio;
	}

	public void setFechaCambio(Date fechaCambio) {
		this.fechaCambio = fechaCambio;
	}

	public String getObservacionCambio() {
		return this.observacionCambio;
	}

	public void setObservacionCambio(String observacionCambio) {
		this.observacionCambio = observacionCambio;
	}

	public String getCausalNoCambio() {
		return this.causalNoCambio;
	}

	public void setCausalNoCambio(String causalNoCambio) {
		this.causalNoCambio = causalNoCambio;
	}

	public Long getNumeroDespacho() {
		return this.numeroDespacho;
	}

	public void setNumeroDespacho(Long numeroDespacho) {
		this.numeroDespacho = numeroDespacho;
	}

	public Date getFechaAutorizacion() {
		return this.fechaAutorizacion;
	}

	public void setFechaAutorizacion(Date fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}

	public Date getFechaCausal() {
		return this.fechaCausal;
	}

	public void setFechaCausal(Date fechaCausal) {
		this.fechaCausal = fechaCausal;
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

	public Date getFechaMovimiento() {
		return this.fechaMovimiento;
	}

	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

}
