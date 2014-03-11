package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.Pedido;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Double cantidadAdicionadas;
	private Double cantidadCanceladas;
	private Double cantidadComprometida;
	private Double cantidadDespRecibir;
	private Double cantidadOrdenada;
	private Double cantidadPedidas;
	private String clasePedido;
	private String comprometida;
	private String condicionPago;
	private Double costoVenta;
	private String espacios;
	private String estadoPedido;
	private String estadoRegistro;
	private String estadoSysgol;
	private Double existenciaAnterior;
	private Date fechaCreacion;
	private Date fechaDeseada;
	private Date fechaFactura;
	private Date fechaModificacion;
	private Date fechaPedido;
	private String horaPedido;
	private Long idPddo;
	private Long numeroFactura;
	private Long numeroPedido;
	private String observacion;
	private String operCreador;
	private String operModifica;
	private String ordenDespacho;
	private Double porcentajeDescuento;
	private String precioEspecial;
	private Double precioVenta;
	private String urgencia;
	private Long idDocu_Documento;
	private Long idRefe_Referencia;

	public Double getCantidadAdicionadas() {
		return cantidadAdicionadas;
	}

	public void setCantidadAdicionadas(Double cantidadAdicionadas) {
		this.cantidadAdicionadas = cantidadAdicionadas;
	}

	public Double getCantidadCanceladas() {
		return cantidadCanceladas;
	}

	public void setCantidadCanceladas(Double cantidadCanceladas) {
		this.cantidadCanceladas = cantidadCanceladas;
	}

	public Double getCantidadComprometida() {
		return cantidadComprometida;
	}

	public void setCantidadComprometida(Double cantidadComprometida) {
		this.cantidadComprometida = cantidadComprometida;
	}

	public Double getCantidadDespRecibir() {
		return cantidadDespRecibir;
	}

	public void setCantidadDespRecibir(Double cantidadDespRecibir) {
		this.cantidadDespRecibir = cantidadDespRecibir;
	}

	public Double getCantidadOrdenada() {
		return cantidadOrdenada;
	}

	public void setCantidadOrdenada(Double cantidadOrdenada) {
		this.cantidadOrdenada = cantidadOrdenada;
	}

	public Double getCantidadPedidas() {
		return cantidadPedidas;
	}

	public void setCantidadPedidas(Double cantidadPedidas) {
		this.cantidadPedidas = cantidadPedidas;
	}

	public String getClasePedido() {
		return clasePedido;
	}

	public void setClasePedido(String clasePedido) {
		this.clasePedido = clasePedido;
	}

	public String getComprometida() {
		return comprometida;
	}

	public void setComprometida(String comprometida) {
		this.comprometida = comprometida;
	}

	public String getCondicionPago() {
		return condicionPago;
	}

	public void setCondicionPago(String condicionPago) {
		this.condicionPago = condicionPago;
	}

	public Double getCostoVenta() {
		return costoVenta;
	}

	public void setCostoVenta(Double costoVenta) {
		this.costoVenta = costoVenta;
	}

	public String getEspacios() {
		return espacios;
	}

	public void setEspacios(String espacios) {
		this.espacios = espacios;
	}

	public String getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getEstadoSysgol() {
		return estadoSysgol;
	}

	public void setEstadoSysgol(String estadoSysgol) {
		this.estadoSysgol = estadoSysgol;
	}

	public Double getExistenciaAnterior() {
		return existenciaAnterior;
	}

	public void setExistenciaAnterior(Double existenciaAnterior) {
		this.existenciaAnterior = existenciaAnterior;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaDeseada() {
		return fechaDeseada;
	}

	public void setFechaDeseada(Date fechaDeseada) {
		this.fechaDeseada = fechaDeseada;
	}

	public Date getFechaFactura() {
		return fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public String getHoraPedido() {
		return horaPedido;
	}

	public void setHoraPedido(String horaPedido) {
		this.horaPedido = horaPedido;
	}

	public Long getIdPddo() {
		return idPddo;
	}

	public void setIdPddo(Long idPddo) {
		this.idPddo = idPddo;
	}

	public Long getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(Long numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Long getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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

	public String getOrdenDespacho() {
		return ordenDespacho;
	}

	public void setOrdenDespacho(String ordenDespacho) {
		this.ordenDespacho = ordenDespacho;
	}

	public Double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public String getPrecioEspecial() {
		return precioEspecial;
	}

	public void setPrecioEspecial(String precioEspecial) {
		this.precioEspecial = precioEspecial;
	}

	public Double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getUrgencia() {
		return urgencia;
	}

	public void setUrgencia(String urgencia) {
		this.urgencia = urgencia;
	}

	public Long getIdDocu_Documento() {
		return idDocu_Documento;
	}

	public void setIdDocu_Documento(Long idDocu_Documento) {
		this.idDocu_Documento = idDocu_Documento;
	}

	public Long getIdRefe_Referencia() {
		return idRefe_Referencia;
	}

	public void setIdRefe_Referencia(Long idRefe_Referencia) {
		this.idRefe_Referencia = idRefe_Referencia;
	}
}
