package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class DivisionPoliticaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String codigoDian;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idDipo;
	private String nombre;
	private String operCreador;
	private String operModifica;
	private Long idDipo_DivisionPolitica;
	private Long idTidi_TipoDivision;

	public String getCodigoDian() {
		return codigoDian;
	}

	public void setCodigoDian(String codigoDian) {
		this.codigoDian = codigoDian;
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

	public Long getIdDipo() {
		return idDipo;
	}

	public void setIdDipo(Long idDipo) {
		this.idDipo = idDipo;
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

	public Long getIdDipo_DivisionPolitica() {
		return idDipo_DivisionPolitica;
	}

	public void setIdDipo_DivisionPolitica(Long idDipo_DivisionPolitica) {
		this.idDipo_DivisionPolitica = idDipo_DivisionPolitica;
	}

	public Long getIdTidi_TipoDivision() {
		return idTidi_TipoDivision;
	}

	public void setIdTidi_TipoDivision(Long idTidi_TipoDivision) {
		this.idTidi_TipoDivision = idTidi_TipoDivision;
	}
}
