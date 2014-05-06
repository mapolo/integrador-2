package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class MovimientoInventarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Double cantidad;
	private String claseVenta;
	private Double costoUnitario;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaMovimiento;
	private Long idMoin;
	private Long numeroRegistro;
	private String operCreador;
	private String operModifica;
	private String placaVehiculo;
	private Double porcentajeIva;
	private String referencia;
	private Double valorTotal;
	private Long idCusa_Causal;
	private Long idDocu_Documento;
	private Long idResu_ReferenciaSucursal;
	private Long idSucu_Sucursal;

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public String getClaseVenta() {
		return claseVenta;
	}

	public void setClaseVenta(String claseVenta) {
		this.claseVenta = claseVenta;
	}

	public Double getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(Double costoUnitario) {
		this.costoUnitario = costoUnitario;
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

	public Date getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(Date fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	public Long getIdMoin() {
		return idMoin;
	}

	public void setIdMoin(Long idMoin) {
		this.idMoin = idMoin;
	}

	public Long getNumeroRegistro() {
		return numeroRegistro;
	}

	public void setNumeroRegistro(Long numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
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

	public String getPlacaVehiculo() {
		return placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public Double getPorcentajeIva() {
		return porcentajeIva;
	}

	public void setPorcentajeIva(Double porcentajeIva) {
		this.porcentajeIva = porcentajeIva;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Long getIdCusa_Causal() {
		return idCusa_Causal;
	}

	public void setIdCusa_Causal(Long idCusa_Causal) {
		this.idCusa_Causal = idCusa_Causal;
	}

	public Long getIdDocu_Documento() {
		return idDocu_Documento;
	}

	public void setIdDocu_Documento(Long idDocu_Documento) {
		this.idDocu_Documento = idDocu_Documento;
	}

	public Long getIdResu_ReferenciaSucursal() {
		return idResu_ReferenciaSucursal;
	}

	public void setIdResu_ReferenciaSucursal(Long idResu_ReferenciaSucursal) {
		this.idResu_ReferenciaSucursal = idResu_ReferenciaSucursal;
	}

}
