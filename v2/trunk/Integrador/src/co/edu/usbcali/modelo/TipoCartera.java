package co.edu.usbcali.modelo;

// Generated 21-feb-2014 23:07:19 by Zathura powered by Hibernate Tools 3.2.4.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TipoCartera generated by Zathura powered by Hibernate-tools(hbm2java)
 */
public class TipoCartera implements java.io.Serializable {

	private Long idTica;
	private String codigo;
	private String descripcion;
	private Date fechaCreacion;
	private String operCreador;
	private Date fechaModificacion;
	private String operModifica;
	private String estadoRegistro;
	private Set<Cliente> clientes = new HashSet<Cliente>(0);

	public TipoCartera() {
	}

	public TipoCartera(Long idTica, String codigo, Date fechaCreacion,
			String operCreador, Date fechaModificacion, String operModifica,
			String estadoRegistro) {
		this.idTica = idTica;
		this.codigo = codigo;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
	}

	public TipoCartera(Long idTica, String codigo, String descripcion,
			Date fechaCreacion, String operCreador, Date fechaModificacion,
			String operModifica, String estadoRegistro, Set<Cliente> clientes) {
		this.idTica = idTica;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
		this.clientes = clientes;
	}

	public Long getIdTica() {
		return this.idTica;
	}

	public void setIdTica(Long idTica) {
		this.idTica = idTica;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getOperCreador() {
		return this.operCreador;
	}

	public void setOperCreador(String operCreador) {
		this.operCreador = operCreador;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getOperModifica() {
		return this.operModifica;
	}

	public void setOperModifica(String operModifica) {
		this.operModifica = operModifica;
	}

	public String getEstadoRegistro() {
		return this.estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public Set<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

}
