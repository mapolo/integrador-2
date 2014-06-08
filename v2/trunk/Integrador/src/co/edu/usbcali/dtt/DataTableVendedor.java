package co.edu.usbcali.dtt;

public class DataTableVendedor implements java.io.Serializable{
	
	private Long idVend;
	private Long identificacion;
	private String primerNombre;
	private String email;
	
	public Long getIdVend() {
		return idVend;
	}
	public void setIdVend(Long idVend) {
		this.idVend = idVend;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
