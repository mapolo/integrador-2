package co.edu.usbcali.modelo;

// Generated 21-feb-2014 23:07:19 by Zathura powered by Hibernate Tools 3.2.4.GA

import java.util.Date;

/**
 * Cruce generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class Cruce implements java.io.Serializable {

	private Long idCrce;
	private DescuentoFinanciero descuentoFinanciero;
	private RboDetalleFormasPago rboDetalleFormasPago;
	private RboDetalleDocumentos rboDetalleDocumentos;
	private Double descuento;
	private Date fechaCreacion;
	private String operCreador;
	private Date fechaModificacion;
	private String operModifica;
	private String estadoRegistro;

	public Cruce() {
	}

	public Cruce(Long idCrce, RboDetalleFormasPago rboDetalleFormasPago,
			RboDetalleDocumentos rboDetalleDocumentos, Date fechaCreacion,
			String operCreador, Date fechaModificacion, String operModifica,
			String estadoRegistro) {
		this.idCrce = idCrce;
		this.rboDetalleFormasPago = rboDetalleFormasPago;
		this.rboDetalleDocumentos = rboDetalleDocumentos;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
	}

	public Cruce(Long idCrce, DescuentoFinanciero descuentoFinanciero,
			RboDetalleFormasPago rboDetalleFormasPago,
			RboDetalleDocumentos rboDetalleDocumentos, Double descuento,
			Date fechaCreacion, String operCreador, Date fechaModificacion,
			String operModifica, String estadoRegistro) {
		this.idCrce = idCrce;
		this.descuentoFinanciero = descuentoFinanciero;
		this.rboDetalleFormasPago = rboDetalleFormasPago;
		this.rboDetalleDocumentos = rboDetalleDocumentos;
		this.descuento = descuento;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
	}

	public Long getIdCrce() {
		return this.idCrce;
	}

	public void setIdCrce(Long idCrce) {
		this.idCrce = idCrce;
	}

	public DescuentoFinanciero getDescuentoFinanciero() {
		return this.descuentoFinanciero;
	}

	public void setDescuentoFinanciero(DescuentoFinanciero descuentoFinanciero) {
		this.descuentoFinanciero = descuentoFinanciero;
	}

	public RboDetalleFormasPago getRboDetalleFormasPago() {
		return this.rboDetalleFormasPago;
	}

	public void setRboDetalleFormasPago(
			RboDetalleFormasPago rboDetalleFormasPago) {
		this.rboDetalleFormasPago = rboDetalleFormasPago;
	}

	public RboDetalleDocumentos getRboDetalleDocumentos() {
		return this.rboDetalleDocumentos;
	}

	public void setRboDetalleDocumentos(
			RboDetalleDocumentos rboDetalleDocumentos) {
		this.rboDetalleDocumentos = rboDetalleDocumentos;
	}

	public Double getDescuento() {
		return this.descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
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