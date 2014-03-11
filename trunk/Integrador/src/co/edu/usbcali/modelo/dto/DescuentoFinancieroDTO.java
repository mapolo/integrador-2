package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.DescuentoFinanciero;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class DescuentoFinancieroDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long codigo;
	private Long diaDesde;
	private Long diaHasta;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaFinal;
	private Date fechaInicio;
	private Date fechaModificacion;
	private Long idDefi;
	private String nombre;
	private String operCreador;
	private String operModifica;
	private Double porcentajeDescuento;
	private Long idGrpo_Grupo;
	private Long idTfpa_TipoFormaPago;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getDiaDesde() {
		return diaDesde;
	}

	public void setDiaDesde(Long diaDesde) {
		this.diaDesde = diaDesde;
	}

	public Long getDiaHasta() {
		return diaHasta;
	}

	public void setDiaHasta(Long diaHasta) {
		this.diaHasta = diaHasta;
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

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Long getIdDefi() {
		return idDefi;
	}

	public void setIdDefi(Long idDefi) {
		this.idDefi = idDefi;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public Long getIdGrpo_Grupo() {
		return idGrpo_Grupo;
	}

	public void setIdGrpo_Grupo(Long idGrpo_Grupo) {
		this.idGrpo_Grupo = idGrpo_Grupo;
	}

	public Long getIdTfpa_TipoFormaPago() {
		return idTfpa_TipoFormaPago;
	}

	public void setIdTfpa_TipoFormaPago(Long idTfpa_TipoFormaPago) {
		this.idTfpa_TipoFormaPago = idTfpa_TipoFormaPago;
	}
}
