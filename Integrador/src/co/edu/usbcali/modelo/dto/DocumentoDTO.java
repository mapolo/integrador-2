package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.Documento;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class DocumentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaDocumento;
	private Date fechaModificacion;
	private Long idDocu;
	private String numeroDefinitivo;
	private Long numeroDocumento;
	private String operCreador;
	private String operModifica;
	private Double valorTotal;
	private Long idCusa_Causal;
	private Long idCodo_ConsecutivoDocumento;
	private Long idEsdo_EstadoDocumento;
	private Long idReco_RelacionComercial;
	private Long idSucu_Sucursal;
	private Long idTido_TipoDocumento;
	private Long idUnve_UnidadVenta;

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

	public Date getFechaDocumento() {
		return fechaDocumento;
	}

	public void setFechaDocumento(Date fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Long getIdDocu() {
		return idDocu;
	}

	public void setIdDocu(Long idDocu) {
		this.idDocu = idDocu;
	}

	public String getNumeroDefinitivo() {
		return numeroDefinitivo;
	}

	public void setNumeroDefinitivo(String numeroDefinitivo) {
		this.numeroDefinitivo = numeroDefinitivo;
	}

	public Long getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(Long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
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

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Long getIdCusa_Causal() {
		return idCusa_Causal;
	}

	public void setIdCusa_Causal(Long idCusa_Causal) {
		this.idCusa_Causal = idCusa_Causal;
	}

	public Long getIdCodo_ConsecutivoDocumento() {
		return idCodo_ConsecutivoDocumento;
	}

	public void setIdCodo_ConsecutivoDocumento(Long idCodo_ConsecutivoDocumento) {
		this.idCodo_ConsecutivoDocumento = idCodo_ConsecutivoDocumento;
	}

	public Long getIdEsdo_EstadoDocumento() {
		return idEsdo_EstadoDocumento;
	}

	public void setIdEsdo_EstadoDocumento(Long idEsdo_EstadoDocumento) {
		this.idEsdo_EstadoDocumento = idEsdo_EstadoDocumento;
	}

	public Long getIdReco_RelacionComercial() {
		return idReco_RelacionComercial;
	}

	public void setIdReco_RelacionComercial(Long idReco_RelacionComercial) {
		this.idReco_RelacionComercial = idReco_RelacionComercial;
	}

	public Long getIdSucu_Sucursal() {
		return idSucu_Sucursal;
	}

	public void setIdSucu_Sucursal(Long idSucu_Sucursal) {
		this.idSucu_Sucursal = idSucu_Sucursal;
	}

	public Long getIdTido_TipoDocumento() {
		return idTido_TipoDocumento;
	}

	public void setIdTido_TipoDocumento(Long idTido_TipoDocumento) {
		this.idTido_TipoDocumento = idTido_TipoDocumento;
	}

}
