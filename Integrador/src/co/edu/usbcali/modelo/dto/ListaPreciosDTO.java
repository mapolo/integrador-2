package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.ListaPrecios;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class ListaPreciosDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String espacios;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaFinal;
	private Date fechaInicial;
	private Date fechaModificacion;
	private Long idLipr;
	private Double margen;
	private String operCreador;
	private String operModifica;
	private Double valor;
	private Long idRefe_Referencia;
	private Long idSucu_Sucursal;
	private Long idTili_TipoLista;

	public String getEspacios() {
		return espacios;
	}

	public void setEspacios(String espacios) {
		this.espacios = espacios;
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

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Long getIdLipr() {
		return idLipr;
	}

	public void setIdLipr(Long idLipr) {
		this.idLipr = idLipr;
	}

	public Double getMargen() {
		return margen;
	}

	public void setMargen(Double margen) {
		this.margen = margen;
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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

	public Long getIdTili_TipoLista() {
		return idTili_TipoLista;
	}

	public void setIdTili_TipoLista(Long idTili_TipoLista) {
		this.idTili_TipoLista = idTili_TipoLista;
	}
}
