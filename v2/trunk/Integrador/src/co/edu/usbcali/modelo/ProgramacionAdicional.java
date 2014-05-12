package co.edu.usbcali.modelo;

// Generated 21-feb-2014 23:07:19 by Zathura powered by Hibernate Tools 3.2.4.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ProgramacionAdicional generated by Zathura powered by
 * Hibernate-tools(hbm2java)
 */
public class ProgramacionAdicional implements java.io.Serializable {

	private Long idPrad;
	private Causal causal;
	private AtencionVendedor atencionVendedor;
	private Date fechaProgAdicional;
	private Date fechaCreacion;
	private String operCreador;
	private Date fechaModificacion;
	private String operModifica;
	private String estadoRegistro;
	private Set<Visita> visitas = new HashSet<Visita>(0);

	public ProgramacionAdicional() {
	}

	public ProgramacionAdicional(Long idPrad,
			AtencionVendedor atencionVendedor, Date fechaProgAdicional,
			Date fechaCreacion, String operCreador, Date fechaModificacion,
			String operModifica, String estadoRegistro) {
		this.idPrad = idPrad;
		this.atencionVendedor = atencionVendedor;
		this.fechaProgAdicional = fechaProgAdicional;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
	}

	public ProgramacionAdicional(Long idPrad, Causal causal,
			AtencionVendedor atencionVendedor, Date fechaProgAdicional,
			Date fechaCreacion, String operCreador, Date fechaModificacion,
			String operModifica, String estadoRegistro, Set<Visita> visitas) {
		this.idPrad = idPrad;
		this.causal = causal;
		this.atencionVendedor = atencionVendedor;
		this.fechaProgAdicional = fechaProgAdicional;
		this.fechaCreacion = fechaCreacion;
		this.operCreador = operCreador;
		this.fechaModificacion = fechaModificacion;
		this.operModifica = operModifica;
		this.estadoRegistro = estadoRegistro;
		this.visitas = visitas;
	}

	public Long getIdPrad() {
		return this.idPrad;
	}

	public void setIdPrad(Long idPrad) {
		this.idPrad = idPrad;
	}

	public Causal getCausal() {
		return this.causal;
	}

	public void setCausal(Causal causal) {
		this.causal = causal;
	}

	public AtencionVendedor getAtencionVendedor() {
		return this.atencionVendedor;
	}

	public void setAtencionVendedor(AtencionVendedor atencionVendedor) {
		this.atencionVendedor = atencionVendedor;
	}

	public Date getFechaProgAdicional() {
		return this.fechaProgAdicional;
	}

	public void setFechaProgAdicional(Date fechaProgAdicional) {
		this.fechaProgAdicional = fechaProgAdicional;
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

	public Set<Visita> getVisitas() {
		return this.visitas;
	}

	public void setVisitas(Set<Visita> visitas) {
		this.visitas = visitas;
	}

}