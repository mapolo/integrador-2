package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class ItemLogisticaReversivaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Double cantidadRecibida;
	private Double cantidadSolicitada;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idItlr;
	private String observacion;
	private String operCreador;
	private String operModifica;
	private Double valor;
	private Long idLore_LogisticaReversiva;
	private Long idRefe_Referencia;

	public Double getCantidadRecibida() {
		return cantidadRecibida;
	}

	public void setCantidadRecibida(Double cantidadRecibida) {
		this.cantidadRecibida = cantidadRecibida;
	}

	public Double getCantidadSolicitada() {
		return cantidadSolicitada;
	}

	public void setCantidadSolicitada(Double cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
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

	public Long getIdItlr() {
		return idItlr;
	}

	public void setIdItlr(Long idItlr) {
		this.idItlr = idItlr;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Long getIdLore_LogisticaReversiva() {
		return idLore_LogisticaReversiva;
	}

	public void setIdLore_LogisticaReversiva(Long idLore_LogisticaReversiva) {
		this.idLore_LogisticaReversiva = idLore_LogisticaReversiva;
	}

	public Long getIdRefe_Referencia() {
		return idRefe_Referencia;
	}

	public void setIdRefe_Referencia(Long idRefe_Referencia) {
		this.idRefe_Referencia = idRefe_Referencia;
	}
}
