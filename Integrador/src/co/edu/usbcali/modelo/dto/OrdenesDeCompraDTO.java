package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.OrdenesDeCompra;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class OrdenesDeCompraDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long cantidadPedida;
	private Long cantidadRecibido;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaEntrega;
	private Date fechaModificacion;
	private Date fechaPedido;
	private Date fechaRecibido;
	private Long idOrdc;
	private Double iva;
	private String numeroFactura;
	private Long numeroPedido;
	private String operCreador;
	private String operModifica;
	private Double porcentajeDescuento;
	private Double precioUnitarioPedido;
	private Double precioUnitarioRecibdo;
	private Long idDocu_Documento;
	private Long idEmpr_Empresa;
	private Long idPers_Persona;
	private Long idRefe_Referencia;
	private Long idSucu_Sucursal;

	public Long getCantidadPedida() {
		return cantidadPedida;
	}

	public void setCantidadPedida(Long cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}

	public Long getCantidadRecibido() {
		return cantidadRecibido;
	}

	public void setCantidadRecibido(Long cantidadRecibido) {
		this.cantidadRecibido = cantidadRecibido;
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

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
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

	public Date getFechaRecibido() {
		return fechaRecibido;
	}

	public void setFechaRecibido(Date fechaRecibido) {
		this.fechaRecibido = fechaRecibido;
	}

	public Long getIdOrdc() {
		return idOrdc;
	}

	public void setIdOrdc(Long idOrdc) {
		this.idOrdc = idOrdc;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Long getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Long numeroPedido) {
		this.numeroPedido = numeroPedido;
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

	public Double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(Double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public Double getPrecioUnitarioPedido() {
		return precioUnitarioPedido;
	}

	public void setPrecioUnitarioPedido(Double precioUnitarioPedido) {
		this.precioUnitarioPedido = precioUnitarioPedido;
	}

	public Double getPrecioUnitarioRecibdo() {
		return precioUnitarioRecibdo;
	}

	public void setPrecioUnitarioRecibdo(Double precioUnitarioRecibdo) {
		this.precioUnitarioRecibdo = precioUnitarioRecibdo;
	}

	public Long getIdDocu_Documento() {
		return idDocu_Documento;
	}

	public void setIdDocu_Documento(Long idDocu_Documento) {
		this.idDocu_Documento = idDocu_Documento;
	}

	public Long getIdEmpr_Empresa() {
		return idEmpr_Empresa;
	}

	public void setIdEmpr_Empresa(Long idEmpr_Empresa) {
		this.idEmpr_Empresa = idEmpr_Empresa;
	}

	public Long getIdPers_Persona() {
		return idPers_Persona;
	}

	public void setIdPers_Persona(Long idPers_Persona) {
		this.idPers_Persona = idPers_Persona;
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
}
