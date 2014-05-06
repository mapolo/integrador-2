package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class TipoFormaPagoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String codigo;
	private String descripcion;
	private Long dsctoFechaDoc;
	private Long esPosfechado;
	private String estadoRegistro;
	private Long exijeNumeroDocumento;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idTfpa;
	private Long importaPda;
	private Long manejaCheque;
	private Long manejaTarjeta;
	private String operCreador;
	private String operModifica;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getDsctoFechaDoc() {
		return dsctoFechaDoc;
	}

	public void setDsctoFechaDoc(Long dsctoFechaDoc) {
		this.dsctoFechaDoc = dsctoFechaDoc;
	}

	public Long getEsPosfechado() {
		return esPosfechado;
	}

	public void setEsPosfechado(Long esPosfechado) {
		this.esPosfechado = esPosfechado;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public Long getExijeNumeroDocumento() {
		return exijeNumeroDocumento;
	}

	public void setExijeNumeroDocumento(Long exijeNumeroDocumento) {
		this.exijeNumeroDocumento = exijeNumeroDocumento;
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

	public Long getIdTfpa() {
		return idTfpa;
	}

	public void setIdTfpa(Long idTfpa) {
		this.idTfpa = idTfpa;
	}

	public Long getImportaPda() {
		return importaPda;
	}

	public void setImportaPda(Long importaPda) {
		this.importaPda = importaPda;
	}

	public Long getManejaCheque() {
		return manejaCheque;
	}

	public void setManejaCheque(Long manejaCheque) {
		this.manejaCheque = manejaCheque;
	}

	public Long getManejaTarjeta() {
		return manejaTarjeta;
	}

	public void setManejaTarjeta(Long manejaTarjeta) {
		this.manejaTarjeta = manejaTarjeta;
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
