package co.edu.usbcali.modelo;

// Generated 21-feb-2014 23:07:19 by Zathura powered by Hibernate Tools 3.2.4.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Cartera generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class Cartera implements java.io.Serializable {

	private Long idCart;
	private Documento documento;
	private Grupo grupo;
	private Double valorTotal;
	private Double valorBase;
	private Double saldo;
	private Double interes;
	private Long numeroCuotas;
	private Date fechaVencimiento;
	private Date fechaPago;
	private Date fechaCreacion;
	private String operCreador;
	private Date fechaModificacion;
	private String operModifica;
	private String estadoRegistro;
	private Set<DistribucionCartera> distribucionCarteras = new HashSet<DistribucionCartera>(
			0);
	private Set<RboDetalleDocumentos> rboDetalleDocumentoses = new HashSet<RboDetalleDocumentos>(
			0);

	public Cartera() {
	}

	public Cartera(Long idCart, Documento documento, Double valorTotal,
			Date fechaCreacion, String operCreador, Date fechaModificacion,
			String operModifica, String estadoRegistro) {
		this.idCart = idCart;
		this.documento = documento;
		this.valorTotal = valorTotal;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
	}

	public Cartera(Long idCart, Documento documento, Grupo grupo,
			Double valorTotal, Double valorBase, Double saldo, Double interes,
			Long numeroCuotas, Date fechaVencimiento, Date fechaPago,
			Date fechaCreacion, String operCreador, Date fechaModificacion,
			String operModifica, String estadoRegistro,
			Set<DistribucionCartera> distribucionCarteras,
			Set<RboDetalleDocumentos> rboDetalleDocumentoses) {
		this.idCart = idCart;
		this.documento = documento;
		this.grupo = grupo;
		this.valorTotal = valorTotal;
		this.valorBase = valorBase;
		this.saldo = saldo;
		this.interes = interes;
		this.numeroCuotas = numeroCuotas;
		this.fechaVencimiento = fechaVencimiento;
		this.fechaPago = fechaPago;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
		this.distribucionCarteras = distribucionCarteras;
		this.rboDetalleDocumentoses = rboDetalleDocumentoses;
	}

	public Long getIdCart() {
		return this.idCart;
	}

	public void setIdCart(Long idCart) {
		this.idCart = idCart;
	}

	public Documento getDocumento() {
		return this.documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Double getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Double getValorBase() {
		return this.valorBase;
	}

	public void setValorBase(Double valorBase) {
		this.valorBase = valorBase;
	}

	public Double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getInteres() {
		return this.interes;
	}

	public void setInteres(Double interes) {
		this.interes = interes;
	}

	public Long getNumeroCuotas() {
		return this.numeroCuotas;
	}

	public void setNumeroCuotas(Long numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
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

	public Set<DistribucionCartera> getDistribucionCarteras() {
		return this.distribucionCarteras;
	}

	public void setDistribucionCarteras(
			Set<DistribucionCartera> distribucionCarteras) {
		this.distribucionCarteras = distribucionCarteras;
	}

	public Set<RboDetalleDocumentos> getRboDetalleDocumentoses() {
		return this.rboDetalleDocumentoses;
	}

	public void setRboDetalleDocumentoses(
			Set<RboDetalleDocumentos> rboDetalleDocumentoses) {
		this.rboDetalleDocumentoses = rboDetalleDocumentoses;
	}

}
