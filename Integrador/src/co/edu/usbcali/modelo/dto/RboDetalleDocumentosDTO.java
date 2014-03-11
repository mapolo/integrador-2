package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.RboDetalleDocumentos;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class RboDetalleDocumentosDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String debitoCredito;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idRddo;
	private String lineaFamilia;
	private Double montoAbonado;
	private Long numeroAbono;
	private Long numeroRegistro;
	private String operCreador;
	private String operModifica;
	private Double valorDescuento;
	private Long idCart_Cartera;
	private Long idCpto_ConceptoRecibo;
	private Long idDica_DistribucionCartera;
	private Long idDocu_Documento;
	private Long idRcbo_Recibo;
	private Long idSucu_Sucursal;
	private Long idUnve_UnidadVenta;

	public String getDebitoCredito() {
		return debitoCredito;
	}

	public void setDebitoCredito(String debitoCredito) {
		this.debitoCredito = debitoCredito;
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

	public Long getIdRddo() {
		return idRddo;
	}

	public void setIdRddo(Long idRddo) {
		this.idRddo = idRddo;
	}

	public String getLineaFamilia() {
		return lineaFamilia;
	}

	public void setLineaFamilia(String lineaFamilia) {
		this.lineaFamilia = lineaFamilia;
	}

	public Double getMontoAbonado() {
		return montoAbonado;
	}

	public void setMontoAbonado(Double montoAbonado) {
		this.montoAbonado = montoAbonado;
	}

	public Long getNumeroAbono() {
		return numeroAbono;
	}

	public void setNumeroAbono(Long numeroAbono) {
		this.numeroAbono = numeroAbono;
	}

	public Long getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(Long numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
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

	public Double getValorDescuento() {
		return valorDescuento;
	}

	public void setValorDescuento(Double valorDescuento) {
		this.valorDescuento = valorDescuento;
	}

	public Long getIdCart_Cartera() {
		return idCart_Cartera;
	}

	public void setIdCart_Cartera(Long idCart_Cartera) {
		this.idCart_Cartera = idCart_Cartera;
	}

	public Long getIdCpto_ConceptoRecibo() {
		return idCpto_ConceptoRecibo;
	}

	public void setIdCpto_ConceptoRecibo(Long idCpto_ConceptoRecibo) {
		this.idCpto_ConceptoRecibo = idCpto_ConceptoRecibo;
	}

	public Long getIdDica_DistribucionCartera() {
		return idDica_DistribucionCartera;
	}

	public void setIdDica_DistribucionCartera(Long idDica_DistribucionCartera) {
		this.idDica_DistribucionCartera = idDica_DistribucionCartera;
	}

	public Long getIdDocu_Documento() {
		return idDocu_Documento;
	}

	public void setIdDocu_Documento(Long idDocu_Documento) {
		this.idDocu_Documento = idDocu_Documento;
	}

	public Long getIdRcbo_Recibo() {
		return idRcbo_Recibo;
	}

	public void setIdRcbo_Recibo(Long idRcbo_Recibo) {
		this.idRcbo_Recibo = idRcbo_Recibo;
	}

	public Long getIdSucu_Sucursal() {
		return idSucu_Sucursal;
	}

	public void setIdSucu_Sucursal(Long idSucu_Sucursal) {
		this.idSucu_Sucursal = idSucu_Sucursal;
	}

	public Long getIdUnve_UnidadVenta() {
		return idUnve_UnidadVenta;
	}

	public void setIdUnve_UnidadVenta(Long idUnve_UnidadVenta) {
		this.idUnve_UnidadVenta = idUnve_UnidadVenta;
	}
}
