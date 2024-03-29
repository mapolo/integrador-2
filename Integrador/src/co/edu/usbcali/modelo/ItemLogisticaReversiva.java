package co.edu.usbcali.modelo;

// Generated 21-feb-2014 23:07:19 by Zathura powered by Hibernate Tools 3.2.4.GA

import java.util.Date;

/**
 * ItemLogisticaReversiva generated by Zathura powered by
 * Hibernate-tools(hbm2java)
 */
public class ItemLogisticaReversiva implements java.io.Serializable {

	private Long idItlr;
	private Referencia referencia;
	private LogisticaReversiva logisticaReversiva;
	private Double cantidadSolicitada;
	private Double cantidadRecibida;
	private Double valor;
	private Date fechaCreacion;
	private String operCreador;
	private Date fechaModificacion;
	private String operModifica;
	private String estadoRegistro;
	private String observacion;

	public ItemLogisticaReversiva() {
	}

	public ItemLogisticaReversiva(Long idItlr, Referencia referencia,
			LogisticaReversiva logisticaReversiva, Double cantidadSolicitada,
			Date fechaCreacion, String operCreador, Date fechaModificacion,
			String operModifica, String estadoRegistro) {
		this.idItlr = idItlr;
		this.referencia = referencia;
		this.logisticaReversiva = logisticaReversiva;
		this.cantidadSolicitada = cantidadSolicitada;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
	}

	public ItemLogisticaReversiva(Long idItlr, Referencia referencia,
			LogisticaReversiva logisticaReversiva, Double cantidadSolicitada,
			Double cantidadRecibida, Double valor, Date fechaCreacion,
			String operCreador, Date fechaModificacion, String operModifica,
			String estadoRegistro, String observacion) {
		this.idItlr = idItlr;
		this.referencia = referencia;
		this.logisticaReversiva = logisticaReversiva;
		this.cantidadSolicitada = cantidadSolicitada;
		this.cantidadRecibida = cantidadRecibida;
		this.valor = valor;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
		this.observacion = observacion;
	}

	public Long getIdItlr() {
		return this.idItlr;
	}

	public void setIdItlr(Long idItlr) {
		this.idItlr = idItlr;
	}

	public Referencia getReferencia() {
		return this.referencia;
	}

	public void setReferencia(Referencia referencia) {
		this.referencia = referencia;
	}

	public LogisticaReversiva getLogisticaReversiva() {
		return this.logisticaReversiva;
	}

	public void setLogisticaReversiva(LogisticaReversiva logisticaReversiva) {
		this.logisticaReversiva = logisticaReversiva;
	}

	public Double getCantidadSolicitada() {
		return this.cantidadSolicitada;
	}

	public void setCantidadSolicitada(Double cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}

	public Double getCantidadRecibida() {
		return this.cantidadRecibida;
	}

	public void setCantidadRecibida(Double cantidadRecibida) {
		this.cantidadRecibida = cantidadRecibida;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
