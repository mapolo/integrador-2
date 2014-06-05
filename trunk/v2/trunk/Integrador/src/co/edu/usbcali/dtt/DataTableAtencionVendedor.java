package co.edu.usbcali.dtt;

public class DataTableAtencionVendedor implements java.io.Serializable{
	
	private Long idAtve;
	private Long idVend;
	private String primerNombre;
	private Long identificacion;
	private Long idReco;
	private Long idEmpr;
	private String nombre;
    private Long identificacionEmpresa;
	
    public Long getIdAtve() {
		return idAtve;
	}
	public void setIdAtve(Long idAtve) {
		this.idAtve = idAtve;
	}
	public Long getIdVend() {
		return idVend;
	}
	public void setIdVend(Long idVend) {
		this.idVend = idVend;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public Long getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}
	public Long getIdReco() {
		return idReco;
	}
	public void setIdReco(Long idReco) {
		this.idReco = idReco;
	}
	public Long getIdEmpr() {
		return idEmpr;
	}
	public void setIdEmpr(Long idEmpr) {
		this.idEmpr = idEmpr;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getIdentificacionEmpresa() {
		return identificacionEmpresa;
	}
	public void setIdentificacionEmpresa(Long identificacionEmpresa) {
		this.identificacionEmpresa = identificacionEmpresa;
	}
}
