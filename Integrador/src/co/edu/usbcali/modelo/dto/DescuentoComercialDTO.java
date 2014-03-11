package co.edu.usbcali.modelo.dto;

import co.edu.usbcali.modelo.DescuentoComercial;

import java.io.Serializable;

import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class DescuentoComercialDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String asocGrupoItem;
	private Long creadoAutomatico;
	private String espacios;
	private Long estadoPlano;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaFinal;
	private Date fechaInicial;
	private Date fechaModificacion;
	private Long idDeco;
	private String operCreador;
	private String operModifica;
	private Double porcDescItem;
	private Double porcDescMaxItem;
	private Double porcDescMinItem;
	private Long tipoAsocGrupoItem;
	private Long todasSucursales;
	private Long idEmpr_Empresa;
	private Long idGrpo_Grupo;
	private Long idPers_Persona;
	private Long idSucu_Sucursal;

	public String getAsocGrupoItem() {
		return asocGrupoItem;
	}

	public void setAsocGrupoItem(String asocGrupoItem) {
		this.asocGrupoItem = asocGrupoItem;
	}

	public Long getCreadoAutomatico() {
		return creadoAutomatico;
	}

	public void setCreadoAutomatico(Long creadoAutomatico) {
		this.creadoAutomatico = creadoAutomatico;
	}

	public String getEspacios() {
		return espacios;
	}

	public void setEspacios(String espacios) {
		this.espacios = espacios;
	}

	public Long getEstadoPlano() {
		return estadoPlano;
	}

	public void setEstadoPlano(Long estadoPlano) {
		this.estadoPlano = estadoPlano;
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

	public Long getIdDeco() {
		return idDeco;
	}

	public void setIdDeco(Long idDeco) {
		this.idDeco = idDeco;
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

	public Double getPorcDescItem() {
		return porcDescItem;
	}

	public void setPorcDescItem(Double porcDescItem) {
		this.porcDescItem = porcDescItem;
	}

	public Double getPorcDescMaxItem() {
		return porcDescMaxItem;
	}

	public void setPorcDescMaxItem(Double porcDescMaxItem) {
		this.porcDescMaxItem = porcDescMaxItem;
	}

	public Double getPorcDescMinItem() {
		return porcDescMinItem;
	}

	public void setPorcDescMinItem(Double porcDescMinItem) {
		this.porcDescMinItem = porcDescMinItem;
	}

	public Long getTipoAsocGrupoItem() {
		return tipoAsocGrupoItem;
	}

	public void setTipoAsocGrupoItem(Long tipoAsocGrupoItem) {
		this.tipoAsocGrupoItem = tipoAsocGrupoItem;
	}

	public Long getTodasSucursales() {
		return todasSucursales;
	}

	public void setTodasSucursales(Long todasSucursales) {
		this.todasSucursales = todasSucursales;
	}

	public Long getIdEmpr_Empresa() {
		return idEmpr_Empresa;
	}

	public void setIdEmpr_Empresa(Long idEmpr_Empresa) {
		this.idEmpr_Empresa = idEmpr_Empresa;
	}

	public Long getIdGrpo_Grupo() {
		return idGrpo_Grupo;
	}

	public void setIdGrpo_Grupo(Long idGrpo_Grupo) {
		this.idGrpo_Grupo = idGrpo_Grupo;
	}

	public Long getIdPers_Persona() {
		return idPers_Persona;
	}

	public void setIdPers_Persona(Long idPers_Persona) {
		this.idPers_Persona = idPers_Persona;
	}

}
