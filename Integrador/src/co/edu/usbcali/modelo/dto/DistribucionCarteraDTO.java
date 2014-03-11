package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.DistribucionCartera;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class DistribucionCarteraDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaVencimiento;
	private Long idDica;
	private Long numeroCuota;
	private String operCreador;
	private String operModifica;
	private Double valor;
	private Long idCart_Cartera;

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

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Long getIdDica() {
		return idDica;
	}

	public void setIdDica(Long idDica) {
		this.idDica = idDica;
	}

	public Long getNumeroCuota() {
		return numeroCuota;
	}

	public void setNumeroCuota(Long numeroCuota) {
		this.numeroCuota = numeroCuota;
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

	public Long getIdCart_Cartera() {
		return idCart_Cartera;
	}

	public void setIdCart_Cartera(Long idCart_Cartera) {
		this.idCart_Cartera = idCart_Cartera;
	}
}
