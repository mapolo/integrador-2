package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class ProgramacionVisitasDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idPrvi;
	private String operCreador;
	private String operModifica;
	private Long idAtve_AtencionVendedor;
	private Long idDise_DiasSemana;
	private Long idFrvi_FrecuenciaVisita;

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

	public Long getIdPrvi() {
		return idPrvi;
	}

	public void setIdPrvi(Long idPrvi) {
		this.idPrvi = idPrvi;
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

	public Long getIdAtve_AtencionVendedor() {
		return idAtve_AtencionVendedor;
	}

	public void setIdAtve_AtencionVendedor(Long idAtve_AtencionVendedor) {
		this.idAtve_AtencionVendedor = idAtve_AtencionVendedor;
	}

	public Long getIdDise_DiasSemana() {
		return idDise_DiasSemana;
	}

	public void setIdDise_DiasSemana(Long idDise_DiasSemana) {
		this.idDise_DiasSemana = idDise_DiasSemana;
	}

	public Long getIdFrvi_FrecuenciaVisita() {
		return idFrvi_FrecuenciaVisita;
	}

	public void setIdFrvi_FrecuenciaVisita(Long idFrvi_FrecuenciaVisita) {
		this.idFrvi_FrecuenciaVisita = idFrvi_FrecuenciaVisita;
	}
}
