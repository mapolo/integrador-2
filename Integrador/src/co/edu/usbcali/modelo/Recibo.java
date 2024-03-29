package co.edu.usbcali.modelo;

// Generated 21-feb-2014 23:07:19 by Zathura powered by Hibernate Tools 3.2.4.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Recibo generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class Recibo implements java.io.Serializable {

	private Long idRcbo;
	private Documento documento;
	private UnidadVenta unidadVenta;
	private String observacion;
	private Long numeroRboProvisional;
	private Date fechaCreacion;
	private String operCreador;
	private Date fechaModificacion;
	private String operModifica;
	private String estadoRegistro;
	private Date fechaTransaccion;
	private Set<RboDetalleDocumentos> rboDetalleDocumentoses = new HashSet<RboDetalleDocumentos>(
			0);
	private Set<RboDetalleFormasPago> rboDetalleFormasPagos = new HashSet<RboDetalleFormasPago>(
			0);

	public Recibo() {
	}

	public Recibo(Long idRcbo, Documento documento, Date fechaCreacion,
			String operCreador, Date fechaModificacion, String operModifica,
			String estadoRegistro) {
		this.idRcbo = idRcbo;
		this.documento = documento;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
	}

	public Recibo(Long idRcbo, Documento documento, UnidadVenta unidadVenta,
			String observacion, Long numeroRboProvisional, Date fechaCreacion,
			String operCreador, Date fechaModificacion, String operModifica,
			String estadoRegistro, Date fechaTransaccion,
			Set<RboDetalleDocumentos> rboDetalleDocumentoses,
			Set<RboDetalleFormasPago> rboDetalleFormasPagos) {
		this.idRcbo = idRcbo;
		this.documento = documento;
		this.unidadVenta = unidadVenta;
		this.observacion = observacion;
		this.numeroRboProvisional = numeroRboProvisional;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
		this.fechaTransaccion = fechaTransaccion;
		this.rboDetalleDocumentoses = rboDetalleDocumentoses;
		this.rboDetalleFormasPagos = rboDetalleFormasPagos;
	}

	public Long getIdRcbo() {
		return this.idRcbo;
	}

	public void setIdRcbo(Long idRcbo) {
		this.idRcbo = idRcbo;
	}

	public Documento getDocumento() {
		return this.documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public UnidadVenta getUnidadVenta() {
		return this.unidadVenta;
	}

	public void setUnidadVenta(UnidadVenta unidadVenta) {
		this.unidadVenta = unidadVenta;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Long getNumeroRboProvisional() {
		return this.numeroRboProvisional;
	}

	public void setNumeroRboProvisional(Long numeroRboProvisional) {
		this.numeroRboProvisional = numeroRboProvisional;
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

	public Date getFechaTransaccion() {
		return this.fechaTransaccion;
	}

	public void setFechaTransaccion(Date fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public Set<RboDetalleDocumentos> getRboDetalleDocumentoses() {
		return this.rboDetalleDocumentoses;
	}

	public void setRboDetalleDocumentoses(
			Set<RboDetalleDocumentos> rboDetalleDocumentoses) {
		this.rboDetalleDocumentoses = rboDetalleDocumentoses;
	}

	public Set<RboDetalleFormasPago> getRboDetalleFormasPagos() {
		return this.rboDetalleFormasPagos;
	}

	public void setRboDetalleFormasPagos(
			Set<RboDetalleFormasPago> rboDetalleFormasPagos) {
		this.rboDetalleFormasPagos = rboDetalleFormasPagos;
	}

}
