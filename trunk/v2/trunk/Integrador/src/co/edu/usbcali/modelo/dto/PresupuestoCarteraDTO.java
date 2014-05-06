package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class PresupuestoCarteraDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long ano;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idPrca;
	private Long mes;
	private String operCreador;
	private String operModifica;
	private Double valorPresupuesto;
	private Long idUnve_UnidadVenta;

	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
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

	public Long getIdPrca() {
		return idPrca;
	}

	public void setIdPrca(Long idPrca) {
		this.idPrca = idPrca;
	}

	public Long getMes() {
		return mes;
	}

	public void setMes(Long mes) {
		this.mes = mes;
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

	public Double getValorPresupuesto() {
		return valorPresupuesto;
	}

	public void setValorPresupuesto(Double valorPresupuesto) {
		this.valorPresupuesto = valorPresupuesto;
	}

	public Long getIdUnve_UnidadVenta() {
		return idUnve_UnidadVenta;
	}

	public void setIdUnve_UnidadVenta(Long idUnve_UnidadVenta) {
		this.idUnve_UnidadVenta = idUnve_UnidadVenta;
	}
}
