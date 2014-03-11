package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.PronosticoVenta;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class PronosticoVentaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long ano;
	private Double cantidadAPedir;
	private Double cantidadAntAPedir;
	private Double cantidadPromedio;
	private String estadoAutorizacion;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idPtcv;
	private Long mes;
	private String operCreador;
	private String operModifica;
	private Long idRefe_Referencia;
	private Long idSucu_Sucursal;
	private Long idUnve_UnidadVenta;

	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	public Double getCantidadAPedir() {
		return cantidadAPedir;
	}

	public void setCantidadAPedir(Double cantidadAPedir) {
		this.cantidadAPedir = cantidadAPedir;
	}

	public Double getCantidadAntAPedir() {
		return cantidadAntAPedir;
	}

	public void setCantidadAntAPedir(Double cantidadAntAPedir) {
		this.cantidadAntAPedir = cantidadAntAPedir;
	}

	public Double getCantidadPromedio() {
		return cantidadPromedio;
	}

	public void setCantidadPromedio(Double cantidadPromedio) {
		this.cantidadPromedio = cantidadPromedio;
	}

	public String getEstadoAutorizacion() {
		return estadoAutorizacion;
	}

	public void setEstadoAutorizacion(String estadoAutorizacion) {
		this.estadoAutorizacion = estadoAutorizacion;
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

	public Long getIdPtcv() {
		return idPtcv;
	}

	public void setIdPtcv(Long idPtcv) {
		this.idPtcv = idPtcv;
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

	public Long getIdRefe_Referencia() {
		return idRefe_Referencia;
	}

	public void setIdRefe_Referencia(Long idRefe_Referencia) {
		this.idRefe_Referencia = idRefe_Referencia;
	}

	public Long getIdSucu_Sucursal() {
		return idSucu_Sucursal;
	}

	public void setIdSucu_Sucursal(Long idSucu_Sucursal) {
		this.idSucu_Sucursal = idSucu_Sucursal;
	}

	public Long getIdUnve_UnidadVenta() {
		return idUnve_UnidadVenta;
	}

	public void setIdUnve_UnidadVenta(Long idUnve_UnidadVenta) {
		this.idUnve_UnidadVenta = idUnve_UnidadVenta;
	}
}
