package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.Banco;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class BancoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String codigo;
	private Long confirmaCheque;
	private Long consigna;
	private String cuentaBanco;
	private String cuentaDescuento;
	private String descripcion;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idBanc;
	private Long importaPda;
	private Long manejaBeneficiario;
	private String operCreador;
	private String operModifica;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getConfirmaCheque() {
		return confirmaCheque;
	}

	public void setConfirmaCheque(Long confirmaCheque) {
		this.confirmaCheque = confirmaCheque;
	}

	public Long getConsigna() {
		return consigna;
	}

	public void setConsigna(Long consigna) {
		this.consigna = consigna;
	}

	public String getCuentaBanco() {
		return cuentaBanco;
	}

	public void setCuentaBanco(String cuentaBanco) {
		this.cuentaBanco = cuentaBanco;
	}

	public String getCuentaDescuento() {
		return cuentaDescuento;
	}

	public void setCuentaDescuento(String cuentaDescuento) {
		this.cuentaDescuento = cuentaDescuento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public Long getIdBanc() {
		return idBanc;
	}

	public void setIdBanc(Long idBanc) {
		this.idBanc = idBanc;
	}

	public Long getImportaPda() {
		return importaPda;
	}

	public void setImportaPda(Long importaPda) {
		this.importaPda = importaPda;
	}

	public Long getManejaBeneficiario() {
		return manejaBeneficiario;
	}

	public void setManejaBeneficiario(Long manejaBeneficiario) {
		this.manejaBeneficiario = manejaBeneficiario;
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
}
