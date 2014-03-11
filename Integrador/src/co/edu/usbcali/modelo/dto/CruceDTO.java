package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.Cruce;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class CruceDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Double descuento;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idCrce;
	private String operCreador;
	private String operModifica;
	private Long idDefi_DescuentoFinanciero;
	private Long idRddo_RboDetalleDocumentos;
	private Long idRdfp_RboDetalleFormasPago;

	public Double getDescuento() {
		return descuento;
	}

	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
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

	public Long getIdCrce() {
		return idCrce;
	}

	public void setIdCrce(Long idCrce) {
		this.idCrce = idCrce;
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

	public Long getIdDefi_DescuentoFinanciero() {
		return idDefi_DescuentoFinanciero;
	}

	public void setIdDefi_DescuentoFinanciero(Long idDefi_DescuentoFinanciero) {
		this.idDefi_DescuentoFinanciero = idDefi_DescuentoFinanciero;
	}

	public Long getIdRddo_RboDetalleDocumentos() {
		return idRddo_RboDetalleDocumentos;
	}

	public void setIdRddo_RboDetalleDocumentos(Long idRddo_RboDetalleDocumentos) {
		this.idRddo_RboDetalleDocumentos = idRddo_RboDetalleDocumentos;
	}

	public Long getIdRdfp_RboDetalleFormasPago() {
		return idRdfp_RboDetalleFormasPago;
	}

	public void setIdRdfp_RboDetalleFormasPago(Long idRdfp_RboDetalleFormasPago) {
		this.idRdfp_RboDetalleFormasPago = idRdfp_RboDetalleFormasPago;
	}
}
