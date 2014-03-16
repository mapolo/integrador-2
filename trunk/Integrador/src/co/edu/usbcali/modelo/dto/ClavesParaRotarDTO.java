package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class ClavesParaRotarDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long ano;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idClpr;
	private Long mes;
	private String operCreador;
	private String operModifica;
	private Long idClfa_ClaveFabricacion;
	private Long idSucu_Sucursal;

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

	public Long getIdClpr() {
		return idClpr;
	}

	public void setIdClpr(Long idClpr) {
		this.idClpr = idClpr;
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

	public Long getIdClfa_ClaveFabricacion() {
		return idClfa_ClaveFabricacion;
	}

	public void setIdClfa_ClaveFabricacion(Long idClfa_ClaveFabricacion) {
		this.idClfa_ClaveFabricacion = idClfa_ClaveFabricacion;
	}

	public Long getIdSucu_Sucursal() {
		return idSucu_Sucursal;
	}

	public void setIdSucu_Sucursal(Long idSucu_Sucursal) {
		this.idSucu_Sucursal = idSucu_Sucursal;
	}
}
