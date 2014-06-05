package co.edu.usbcali.dtt;

public class DataTableCliente implements java.io.Serializable{

	private Long idClie;
	private Long identificacion;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    
    
    private String nombre;
    private Long identificacionEmpresa;
    
	public Long getIdClie() {
		return idClie;
	}
	public void setIdClie(Long idClie) {
		this.idClie = idClie;
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
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
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
