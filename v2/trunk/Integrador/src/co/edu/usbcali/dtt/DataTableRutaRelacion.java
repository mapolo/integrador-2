package co.edu.usbcali.dtt;

public class DataTableRutaRelacion implements java.io.Serializable {

	private Long idRrec;
	private Long idRudi;
	private String descripcion;
	private Double tiempoEntrega;
	private Double tiempoTransporte;
	private Long idAtve;
	private Long idVend;
	private Long identificacion;
    private String primerNombre;
    private Long idReco;
	private String nombre;
    private Long identificacionEmpresa;
	public Long getIdRrec() {
		return idRrec;
	}
	public void setIdRrec(Long idRrec) {
		this.idRrec = idRrec;
	}
	public Long getIdRudi() {
		return idRudi;
	}
	public void setIdRudi(Long idRudi) {
		this.idRudi = idRudi;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Double getTiempoEntrega() {
		return tiempoEntrega;
	}
	public void setTiempoEntrega(Double tiempoEntrega) {
		this.tiempoEntrega = tiempoEntrega;
	}
	public Double getTiempoTransporte() {
		return tiempoTransporte;
	}
	public void setTiempoTransporte(Double tiempoTransporte) {
		this.tiempoTransporte = tiempoTransporte;
	}
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
	public Long getIdentificacionEmpresa() {
		return identificacionEmpresa;
	}
	public void setIdentificacionEmpresa(Long identificacionEmpresa) {
		this.identificacionEmpresa = identificacionEmpresa;
	}
	
}
