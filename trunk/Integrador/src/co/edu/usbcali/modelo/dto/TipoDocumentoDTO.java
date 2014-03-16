package co.edu.usbcali.modelo.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public class TipoDocumentoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String afectaCartea;
	private String afectaInventario;
	private String codigo;
	private String descripcion;
	private String estadoRegistro;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private Long idTido;
	private String operCreador;
	private String operModifica;
	private String signoCartera;
	private String signoInventario;

	public String getAfectaCartea() {
		return afectaCartea;
	}

	public void setAfectaCartea(String afectaCartea) {
		this.afectaCartea = afectaCartea;
	}

	public String getAfectaInventario() {
		return afectaInventario;
	}

	public void setAfectaInventario(String afectaInventario) {
		this.afectaInventario = afectaInventario;
	}

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

	public Long getIdTido() {
		return idTido;
	}

	public void setIdTido(Long idTido) {
		this.idTido = idTido;
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

	public String getSignoCartera() {
		return signoCartera;
	}

	public void setSignoCartera(String signoCartera) {
		this.signoCartera = signoCartera;
	}

	public String getSignoInventario() {
		return signoInventario;
	}

	public void setSignoInventario(String signoInventario) {
		this.signoInventario = signoInventario;
	}
}
