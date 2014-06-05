package co.edu.usbcali.dtt;

public class DataTableRelacionComercial implements java.io.Serializable{
	
	private Long idReco;
	private String nombre;
    private Long identificacion;
    private String telefono1;
	
    private String direccion;
    public Long getIdReco() {
		return idReco;
	}
	public void setIdReco(Long idReco) {
		this.idReco = idReco;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(Long identificacion) {
		this.identificacion = identificacion;
	}
	public String getTelefono1() {
		return telefono1;
	}
	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
