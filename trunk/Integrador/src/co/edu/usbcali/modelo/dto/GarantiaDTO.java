package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.Garantia;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class GarantiaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String alineacionTrazabilidad;
	private Long anoTrazabilidad;
	private Long diaTrazabilidad;
	private String estado;
	private String estadoRegistro;
	private Date fechaCambio;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Date fechaVenta;
	private Long idGar;
	private String lineaTrazabilidad;
	private String mesTrazabilidad;
	private String numeroGarantia;
	private String observacion;
	private String operCreador;
	private String operModifica;
	private String placaTrazabilidad;
	private String turnoTrazabilidad;
	private Long idBate_Bateriologo;
	private Long idClfa_ClaveFabricacion;
	private Long idDocu_Documento;
	private Long idCfal_Fallas;
	private Long idRefe_Referencia;
	private Long idTiga_TipoGarantia;

	public String getAlineacionTrazabilidad() {
		return alineacionTrazabilidad;
	}

	public void setAlineacionTrazabilidad(String alineacionTrazabilidad) {
		this.alineacionTrazabilidad = alineacionTrazabilidad;
	}

	public Long getAnoTrazabilidad() {
		return anoTrazabilidad;
	}

	public void setAnoTrazabilidad(Long anoTrazabilidad) {
		this.anoTrazabilidad = anoTrazabilidad;
	}

	public Long getDiaTrazabilidad() {
		return diaTrazabilidad;
	}

	public void setDiaTrazabilidad(Long diaTrazabilidad) {
		this.diaTrazabilidad = diaTrazabilidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public Date getFechaCambio() {
		return fechaCambio;
	}

	public void setFechaCambio(Date fechaCambio) {
		this.fechaCambio = fechaCambio;
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

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public Long getIdGar() {
		return idGar;
	}

	public void setIdGar(Long idGar) {
		this.idGar = idGar;
	}

	public String getLineaTrazabilidad() {
		return lineaTrazabilidad;
	}

	public void setLineaTrazabilidad(String lineaTrazabilidad) {
		this.lineaTrazabilidad = lineaTrazabilidad;
	}

	public String getMesTrazabilidad() {
		return mesTrazabilidad;
	}

	public void setMesTrazabilidad(String mesTrazabilidad) {
		this.mesTrazabilidad = mesTrazabilidad;
	}

	public String getNumeroGarantia() {
		return numeroGarantia;
	}

	public void setNumeroGarantia(String numeroGarantia) {
		this.numeroGarantia = numeroGarantia;
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

	public String getPlacaTrazabilidad() {
		return placaTrazabilidad;
	}

	public void setPlacaTrazabilidad(String placaTrazabilidad) {
		this.placaTrazabilidad = placaTrazabilidad;
	}

	public String getTurnoTrazabilidad() {
		return turnoTrazabilidad;
	}

	public void setTurnoTrazabilidad(String turnoTrazabilidad) {
		this.turnoTrazabilidad = turnoTrazabilidad;
	}

	public Long getIdBate_Bateriologo() {
		return idBate_Bateriologo;
	}

	public void setIdBate_Bateriologo(Long idBate_Bateriologo) {
		this.idBate_Bateriologo = idBate_Bateriologo;
	}

	public Long getIdClfa_ClaveFabricacion() {
		return idClfa_ClaveFabricacion;
	}

	public void setIdClfa_ClaveFabricacion(Long idClfa_ClaveFabricacion) {
		this.idClfa_ClaveFabricacion = idClfa_ClaveFabricacion;
	}

	public Long getIdDocu_Documento() {
		return idDocu_Documento;
	}

	public void setIdDocu_Documento(Long idDocu_Documento) {
		this.idDocu_Documento = idDocu_Documento;
	}

	public Long getIdCfal_Fallas() {
		return idCfal_Fallas;
	}

	public void setIdCfal_Fallas(Long idCfal_Fallas) {
		this.idCfal_Fallas = idCfal_Fallas;
	}

	public Long getIdRefe_Referencia() {
		return idRefe_Referencia;
	}

	public void setIdRefe_Referencia(Long idRefe_Referencia) {
		this.idRefe_Referencia = idRefe_Referencia;
	}

	public Long getIdTiga_TipoGarantia() {
		return idTiga_TipoGarantia;
	}

	public void setIdTiga_TipoGarantia(Long idTiga_TipoGarantia) {
		this.idTiga_TipoGarantia = idTiga_TipoGarantia;
	}
}
