package co.edu.usbcali.modelo;

// Generated 21-feb-2014 23:07:19 by Zathura powered by Hibernate Tools 3.2.4.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SaldoInicialInventario generated by Zathura powered by
 * Hibernate-tools(hbm2java)
 */
public class SaldoInicialInventario implements java.io.Serializable {

	private Long idSini;
	private ReferenciaSucursal referenciaSucursal;
	private Long ano;
	private Double saldoInicial;
	private Double costoInicial;
	private Date fechaCreacion;
	private String operCreador;
	private Date fechaModificacion;
	private String operModifica;
	private String estadoRegistro;
	private Set<StockInventarioMensual> stockInventarioMensuals = new HashSet<StockInventarioMensual>(
			0);

	public SaldoInicialInventario() {
	}

	public SaldoInicialInventario(Long idSini,
			ReferenciaSucursal referenciaSucursal, Long ano,
			Double saldoInicial, Double costoInicial, Date fechaCreacion,
			String operCreador, Date fechaModificacion, String operModifica,
			String estadoRegistro) {
		this.idSini = idSini;
		this.referenciaSucursal = referenciaSucursal;
		this.ano = ano;
		this.saldoInicial = saldoInicial;
		this.costoInicial = costoInicial;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
	}

	public SaldoInicialInventario(Long idSini,
			ReferenciaSucursal referenciaSucursal, Long ano,
			Double saldoInicial, Double costoInicial, Date fechaCreacion,
			String operCreador, Date fechaModificacion, String operModifica,
			String estadoRegistro,
			Set<StockInventarioMensual> stockInventarioMensuals) {
		this.idSini = idSini;
		this.referenciaSucursal = referenciaSucursal;
		this.ano = ano;
		this.saldoInicial = saldoInicial;
		this.costoInicial = costoInicial;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
		this.stockInventarioMensuals = stockInventarioMensuals;
	}

	public Long getIdSini() {
		return this.idSini;
	}

	public void setIdSini(Long idSini) {
		this.idSini = idSini;
	}

	public ReferenciaSucursal getReferenciaSucursal() {
		return this.referenciaSucursal;
	}

	public void setReferenciaSucursal(ReferenciaSucursal referenciaSucursal) {
		this.referenciaSucursal = referenciaSucursal;
	}

	public Long getAno() {
		return this.ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	public Double getSaldoInicial() {
		return this.saldoInicial;
	}

	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public Double getCostoInicial() {
		return this.costoInicial;
	}

	public void setCostoInicial(Double costoInicial) {
		this.costoInicial = costoInicial;
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

	public Set<StockInventarioMensual> getStockInventarioMensuals() {
		return this.stockInventarioMensuals;
	}

	public void setStockInventarioMensuals(
			Set<StockInventarioMensual> stockInventarioMensuals) {
		this.stockInventarioMensuals = stockInventarioMensuals;
	}

}
