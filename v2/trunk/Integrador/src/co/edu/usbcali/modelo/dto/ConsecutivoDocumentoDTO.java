package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class ConsecutivoDocumentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String codigoTerminal;
	private Long consecutivoActual;
	private Long consecutivoFinal;
	private Long consecutivoInicial;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idCodo;
	private String operCreador;
	private String operModifica;
	private Long idSucu_Sucursal;
	private Long idTido_TipoDocumento;
	private Long idVend_Vendedor;

	public String getCodigoTerminal() {
		return codigoTerminal;
	}

	public void setCodigoTerminal(String codigoTerminal) {
		this.codigoTerminal = codigoTerminal;
	}

	public Long getConsecutivoActual() {
		return consecutivoActual;
	}

	public void setConsecutivoActual(Long consecutivoActual) {
		this.consecutivoActual = consecutivoActual;
	}

	public Long getConsecutivoFinal() {
		return consecutivoFinal;
	}

	public void setConsecutivoFinal(Long consecutivoFinal) {
		this.consecutivoFinal = consecutivoFinal;
	}

	public Long getConsecutivoInicial() {
		return consecutivoInicial;
	}

	public void setConsecutivoInicial(Long consecutivoInicial) {
		this.consecutivoInicial = consecutivoInicial;
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

	public Long getIdCodo() {
		return idCodo;
	}

	public void setIdCodo(Long idCodo) {
		this.idCodo = idCodo;
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

	public Long getIdVend_Vendedor() {
		return idVend_Vendedor;
	}

	public void setIdVend_Vendedor(Long idVend_Vendedor) {
		this.idVend_Vendedor = idVend_Vendedor;
	}
}
