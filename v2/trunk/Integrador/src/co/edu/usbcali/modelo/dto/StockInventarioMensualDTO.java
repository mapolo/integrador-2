package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class StockInventarioMensualDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long ano;
	private Double cantidadEntrada;
	private Double cantidadSalidas;
	private Double costoEntradas;
	private Double costoSalidas;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idStin;
	private Double maximoDistribucion;
	private Double maximoPedido;
	private Long mes;
	private Double minimoDistribucion;
	private Double minimoPedido;
	private String operCreador;
	private String operModifica;
	private Long idSini_SaldoInicialInventario;

	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	public Double getCantidadEntrada() {
		return cantidadEntrada;
	}

	public void setCantidadEntrada(Double cantidadEntrada) {
		this.cantidadEntrada = cantidadEntrada;
	}

	public Double getCantidadSalidas() {
		return cantidadSalidas;
	}

	public void setCantidadSalidas(Double cantidadSalidas) {
		this.cantidadSalidas = cantidadSalidas;
	}

	public Double getCostoEntradas() {
		return costoEntradas;
	}

	public void setCostoEntradas(Double costoEntradas) {
		this.costoEntradas = costoEntradas;
	}

	public Double getCostoSalidas() {
		return costoSalidas;
	}

	public void setCostoSalidas(Double costoSalidas) {
		this.costoSalidas = costoSalidas;
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

	public Long getIdStin() {
		return idStin;
	}

	public void setIdStin(Long idStin) {
		this.idStin = idStin;
	}

	public Double getMaximoDistribucion() {
		return maximoDistribucion;
	}

	public void setMaximoDistribucion(Double maximoDistribucion) {
		this.maximoDistribucion = maximoDistribucion;
	}

	public Double getMaximoPedido() {
		return maximoPedido;
	}

	public void setMaximoPedido(Double maximoPedido) {
		this.maximoPedido = maximoPedido;
	}

	public Long getMes() {
		return mes;
	}

	public void setMes(Long mes) {
		this.mes = mes;
	}

	public Double getMinimoDistribucion() {
		return minimoDistribucion;
	}

	public void setMinimoDistribucion(Double minimoDistribucion) {
		this.minimoDistribucion = minimoDistribucion;
	}

	public Double getMinimoPedido() {
		return minimoPedido;
	}

	public void setMinimoPedido(Double minimoPedido) {
		this.minimoPedido = minimoPedido;
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

	public Long getIdSini_SaldoInicialInventario() {
		return idSini_SaldoInicialInventario;
	}

	public void setIdSini_SaldoInicialInventario(
			Long idSini_SaldoInicialInventario) {
		this.idSini_SaldoInicialInventario = idSini_SaldoInicialInventario;
	}
}
