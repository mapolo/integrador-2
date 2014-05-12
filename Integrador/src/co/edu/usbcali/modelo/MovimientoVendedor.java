package co.edu.usbcali.modelo;

// Generated 21-feb-2014 23:07:19 by Zathura powered by Hibernate Tools 3.2.4.GA

import java.util.Date;

/**
 * MovimientoVendedor generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class MovimientoVendedor implements java.io.Serializable {

	private Long idMven;
	private UnidadVenta unidadVenta;
	private MovimientoInventario movimientoInventario;
	private Date fechaCreacion;
	private String operCreador;
	private Date fechaModificacion;
	private String operModifica;
	private String estadoRegistro;

	public MovimientoVendedor() {
	}

	public MovimientoVendedor(Long idMven, UnidadVenta unidadVenta,
			MovimientoInventario movimientoInventario, Date fechaCreacion,
			String operCreador, Date fechaModificacion, String operModifica,
			String estadoRegistro) {
		this.idMven = idMven;
		this.unidadVenta = unidadVenta;
		this.movimientoInventario = movimientoInventario;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
	}

	public Long getIdMven() {
		return this.idMven;
	}

	public void setIdMven(Long idMven) {
		this.idMven = idMven;
	}

	public UnidadVenta getUnidadVenta() {
		return this.unidadVenta;
	}

	public void setUnidadVenta(UnidadVenta unidadVenta) {
		this.unidadVenta = unidadVenta;
	}

	public MovimientoInventario getMovimientoInventario() {
		return this.movimientoInventario;
	}

	public void setMovimientoInventario(
			MovimientoInventario movimientoInventario) {
		this.movimientoInventario = movimientoInventario;
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

}