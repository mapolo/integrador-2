package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class GrupoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String asociado;
	private String division;
	private String especial;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String grupo_1;
	private Long idGrpo;
	private String manejaOrdenCompra;
	private Double margenMinimoBodega;
	private Double margenMinimoEnergiteca;
	private String modificaReferencia;
	private String nombre;
	private String operCreador;
	private String operModifica;
	private String pideGalones;
	private String sugeridoPedido;
	private String tipoNivel;
	private Long idFlia_Familia;
	private Long idGrpo_Grupo;

	public String getAsociado() {
		return asociado;
	}

	public void setAsociado(String asociado) {
		this.asociado = asociado;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getEspecial() {
		return especial;
	}

	public void setEspecial(String especial) {
		this.especial = especial;
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

	public String getGrupo_1() {
		return grupo_1;
	}

	public void setGrupo_1(String grupo_1) {
		this.grupo_1 = grupo_1;
	}

	public Long getIdGrpo() {
		return idGrpo;
	}

	public void setIdGrpo(Long idGrpo) {
		this.idGrpo = idGrpo;
	}

	public String getManejaOrdenCompra() {
		return manejaOrdenCompra;
	}

	public void setManejaOrdenCompra(String manejaOrdenCompra) {
		this.manejaOrdenCompra = manejaOrdenCompra;
	}

	public Double getMargenMinimoBodega() {
		return margenMinimoBodega;
	}

	public void setMargenMinimoBodega(Double margenMinimoBodega) {
		this.margenMinimoBodega = margenMinimoBodega;
	}

	public Double getMargenMinimoEnergiteca() {
		return margenMinimoEnergiteca;
	}

	public void setMargenMinimoEnergiteca(Double margenMinimoEnergiteca) {
		this.margenMinimoEnergiteca = margenMinimoEnergiteca;
	}

	public String getModificaReferencia() {
		return modificaReferencia;
	}

	public void setModificaReferencia(String modificaReferencia) {
		this.modificaReferencia = modificaReferencia;
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

	public String getPideGalones() {
		return pideGalones;
	}

	public void setPideGalones(String pideGalones) {
		this.pideGalones = pideGalones;
	}

	public String getSugeridoPedido() {
		return sugeridoPedido;
	}

	public void setSugeridoPedido(String sugeridoPedido) {
		this.sugeridoPedido = sugeridoPedido;
	}

	public String getTipoNivel() {
		return tipoNivel;
	}

	public void setTipoNivel(String tipoNivel) {
		this.tipoNivel = tipoNivel;
	}

	public Long getIdFlia_Familia() {
		return idFlia_Familia;
	}

	public void setIdFlia_Familia(Long idFlia_Familia) {
		this.idFlia_Familia = idFlia_Familia;
	}

	public Long getIdGrpo_Grupo() {
		return idGrpo_Grupo;
	}

	public void setIdGrpo_Grupo(Long idGrpo_Grupo) {
		this.idGrpo_Grupo = idGrpo_Grupo;
	}
}
