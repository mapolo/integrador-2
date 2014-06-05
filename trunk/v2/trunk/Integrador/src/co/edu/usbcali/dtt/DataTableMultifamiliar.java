package co.edu.usbcali.dtt;

public class DataTableMultifamiliar implements java.io.Serializable{

	private Long idMufa;
	private Long identificacionHijo;
	private Long identificacionPadre;
	private String primerNombre;
	private String nombreEmpresa;
	
	public Long getIdMufa() {
		return idMufa;
	}
	public void setIdMufa(Long idMufa) {
		this.idMufa = idMufa;
	}
	public Long getIdentificacionHijo() {
		return identificacionHijo;
	}
	public void setIdentificacionHijo(Long identificacionHijo) {
		this.identificacionHijo = identificacionHijo;
	}
	public Long getIdentificacionPadre() {
		return identificacionPadre;
	}
	public void setIdentificacionPadre(Long identificacionPadre) {
		this.identificacionPadre = identificacionPadre;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

}
