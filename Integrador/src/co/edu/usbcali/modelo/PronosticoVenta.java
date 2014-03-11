package co.edu.usbcali.modelo;

// Generated 21-feb-2014 23:07:19 by Zathura powered by Hibernate Tools 3.2.4.GA

import java.util.Date;

/**
 * PronosticoVenta generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class PronosticoVenta implements java.io.Serializable {

	private Long idPtcv;
	private Referencia referencia;
	private UnidadVenta unidadVenta;
	private Sucursal sucursal;
	private Long ano;
	private Long mes;
	private Double cantidadPromedio;
	private Double cantidadAPedir;
	private Double cantidadAntAPedir;
	private String estadoAutorizacion;
	private Date fechaCreacion;
	private String operCreador;
	private Date fechaModificacion;
	private String operModifica;
	private String estadoRegistro;

	public PronosticoVenta() {
	}

	public PronosticoVenta(Long idPtcv, Referencia referencia,
			Sucursal sucursal, Date fechaCreacion, String operCreador,
			Date fechaModificacion, String operModifica, String estadoRegistro) {
		this.idPtcv = idPtcv;
		this.referencia = referencia;
		this.sucursal = sucursal;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
	}

	public PronosticoVenta(Long idPtcv, Referencia referencia,
			UnidadVenta unidadVenta, Sucursal sucursal, Long ano, Long mes,
			Double cantidadPromedio, Double cantidadAPedir,
			Double cantidadAntAPedir, String estadoAutorizacion,
			Date fechaCreacion, String operCreador, Date fechaModificacion,
			String operModifica, String estadoRegistro) {
		this.idPtcv = idPtcv;
		this.referencia = referencia;
		this.unidadVenta = unidadVenta;
		this.sucursal = sucursal;
		this.ano = ano;
		this.mes = mes;
		this.cantidadPromedio = cantidadPromedio;
		this.cantidadAPedir = cantidadAPedir;
		this.cantidadAntAPedir = cantidadAntAPedir;
		this.estadoAutorizacion = estadoAutorizacion;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
	}

	public Long getIdPtcv() {
		return this.idPtcv;
	}

	public void setIdPtcv(Long idPtcv) {
		this.idPtcv = idPtcv;
	}

	public Referencia getReferencia() {
		return this.referencia;
	}

	public void setReferencia(Referencia referencia) {
		this.referencia = referencia;
	}

	public UnidadVenta getUnidadVenta() {
		return this.unidadVenta;
	}

	public void setUnidadVenta(UnidadVenta unidadVenta) {
		this.unidadVenta = unidadVenta;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Long getAno() {
		return this.ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	public Long getMes() {
		return this.mes;
	}

	public void setMes(Long mes) {
		this.mes = mes;
	}

	public Double getCantidadPromedio() {
		return this.cantidadPromedio;
	}

	public void setCantidadPromedio(Double cantidadPromedio) {
		this.cantidadPromedio = cantidadPromedio;
	}

	public Double getCantidadAPedir() {
		return this.cantidadAPedir;
	}

	public void setCantidadAPedir(Double cantidadAPedir) {
		this.cantidadAPedir = cantidadAPedir;
	}

	public Double getCantidadAntAPedir() {
		return this.cantidadAntAPedir;
	}

	public void setCantidadAntAPedir(Double cantidadAntAPedir) {
		this.cantidadAntAPedir = cantidadAntAPedir;
	}

	public String getEstadoAutorizacion() {
		return this.estadoAutorizacion;
	}

	public void setEstadoAutorizacion(String estadoAutorizacion) {
		this.estadoAutorizacion = estadoAutorizacion;
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
