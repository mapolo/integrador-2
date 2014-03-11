package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.SaldoInicialInventario;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class SaldoInicialInventarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long ano;
	private Double costoInicial;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idSini;
	private String operCreador;
	private String operModifica;
	private Double saldoInicial;
	private Long idResu_ReferenciaSucursal;

	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	public Double getCostoInicial() {
		return costoInicial;
	}

	public void setCostoInicial(Double costoInicial) {
		this.costoInicial = costoInicial;
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

	public Long getIdSini() {
		return idSini;
	}

	public void setIdSini(Long idSini) {
		this.idSini = idSini;
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

	public Double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public Long getIdResu_ReferenciaSucursal() {
		return idResu_ReferenciaSucursal;
	}

	public void setIdResu_ReferenciaSucursal(Long idResu_ReferenciaSucursal) {
		this.idResu_ReferenciaSucursal = idResu_ReferenciaSucursal;
	}
}
