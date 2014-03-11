package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.RboDetalleFormasPago;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class RboDetalleFormasPagoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String estadoRegistro;
	private Date fechaConsignacion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idRdfp;
	private Double montoCancelado;
	private String numeroDocumeto;
	private String operCreador;
	private String operModifica;
	private String transaccion;
	private Long idBanc_Banco;
	private Long idChps_ChequePosfechado;
	private Long idDocu_Documento;
	private Long idRcbo_Recibo;
	private Long idTfpa_TipoFormaPago;

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
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

	public Long getIdRdfp() {
		return idRdfp;
	}

	public void setIdRdfp(Long idRdfp) {
		this.idRdfp = idRdfp;
	}

	public Double getMontoCancelado() {
		return montoCancelado;
	}

	public void setMontoCancelado(Double montoCancelado) {
		this.montoCancelado = montoCancelado;
	}

	public String getNumeroDocumeto() {
		return numeroDocumeto;
	}

	public void setNumeroDocumeto(String numeroDocumeto) {
		this.numeroDocumeto = numeroDocumeto;
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

	public String getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(String transaccion) {
		this.transaccion = transaccion;
	}

	public Long getIdBanc_Banco() {
		return idBanc_Banco;
	}

	public void setIdBanc_Banco(Long idBanc_Banco) {
		this.idBanc_Banco = idBanc_Banco;
	}

	public Long getIdChps_ChequePosfechado() {
		return idChps_ChequePosfechado;
	}

	public void setIdChps_ChequePosfechado(Long idChps_ChequePosfechado) {
		this.idChps_ChequePosfechado = idChps_ChequePosfechado;
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

	public Long getIdTfpa_TipoFormaPago() {
		return idTfpa_TipoFormaPago;
	}

	public void setIdTfpa_TipoFormaPago(Long idTfpa_TipoFormaPago) {
		this.idTfpa_TipoFormaPago = idTfpa_TipoFormaPago;
	}
}
