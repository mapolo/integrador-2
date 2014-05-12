package co.edu.usbcali.modelo;

// Generated 21-feb-2014 23:07:19 by Zathura powered by Hibernate Tools 3.2.4.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DistribucionCartera generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class DistribucionCartera implements java.io.Serializable {

	private Long idDica;
	private Cartera cartera;
	private Long numeroCuota;
	private Double valor;
	private Date fechaVencimiento;
	private Date fechaCreacion;
	private String operCreador;
	private Date fechaModificacion;
	private String operModifica;
	private String estadoRegistro;
	private Set<RboDetalleDocumentos> rboDetalleDocumentoses = new HashSet<RboDetalleDocumentos>(
			0);

	public DistribucionCartera() {
	}

	public DistribucionCartera(Long idDica, Cartera cartera, Long numeroCuota,
			Double valor, Date fechaVencimiento, Date fechaCreacion,
			String operCreador, Date fechaModificacion, String operModifica,
			String estadoRegistro) {
		this.idDica = idDica;
		this.cartera = cartera;
		this.numeroCuota = numeroCuota;
		this.valor = valor;
		this.fechaVencimiento = fechaVencimiento;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
	}

	public DistribucionCartera(Long idDica, Cartera cartera, Long numeroCuota,
			Double valor, Date fechaVencimiento, Date fechaCreacion,
			String operCreador, Date fechaModificacion, String operModifica,
			String estadoRegistro,
			Set<RboDetalleDocumentos> rboDetalleDocumentoses) {
		this.idDica = idDica;
		this.cartera = cartera;
		this.numeroCuota = numeroCuota;
		this.valor = valor;
		this.fechaVencimiento = fechaVencimiento;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
		this.rboDetalleDocumentoses = rboDetalleDocumentoses;
	}

	public Long getIdDica() {
		return this.idDica;
	}

	public void setIdDica(Long idDica) {
		this.idDica = idDica;
	}

	public Cartera getCartera() {
		return this.cartera;
	}

	public void setCartera(Cartera cartera) {
		this.cartera = cartera;
	}

	public Long getNumeroCuota() {
		return this.numeroCuota;
	}

	public void setNumeroCuota(Long numeroCuota) {
		this.numeroCuota = numeroCuota;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
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

	public Set<RboDetalleDocumentos> getRboDetalleDocumentoses() {
		return this.rboDetalleDocumentoses;
	}

	public void setRboDetalleDocumentoses(
			Set<RboDetalleDocumentos> rboDetalleDocumentoses) {
		this.rboDetalleDocumentoses = rboDetalleDocumentoses;
	}

}