package co.edu.usbcali.dtt;

public class DataTableUnidadVenta implements java.io.Serializable{
	
	private Long idUnve;
	private Long idVend;
	private Long idUnne;
	private Long idPers;
    private String descripcion;
    private Long identificacion;
    private String primerNombre;
    private String telefono1;
    private String activo;
    
	public Long getIdUnve() {
		return idUnve;
	}
	public void setIdUnve(Long idUnve) {
		this.idUnve = idUnve;
	}
	public Long getIdVend() {
		return idVend;
	}
	public void setIdVend(Long idVend) {
		this.idVend = idVend;
	}
	public Long getIdUnne() {
		return idUnne;
	}
	public void setIdUnne(Long idUnne) {
		this.idUnne = idUnne;
	}
	public Long getIdPers() {
		return idPers;
	}
	public void setIdPers(Long idPers) {
		this.idPers = idPers;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Long getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getTelefono1() {
		return telefono1;
	}
	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
	
}
