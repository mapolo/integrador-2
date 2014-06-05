package co.edu.usbcali.dtt;

import java.io.Serializable;


public class DataTableRefGrupo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long idRefe;    
    private String descripcion;
    private String marca;
    
    private Long idGrpo;
    private String nombre;
  
    private Long idGrre;
    private String estadoRegistro;
    
	public DataTableRefGrupo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DataTableRefGrupo(Long idRefe, String descripcion, String marca,
			Long idGrpo, String nombre, Long idGrre, String estadoRegistro) {
		super();
		this.idRefe = idRefe;
		this.descripcion = descripcion;
		this.marca = marca;
		this.idGrpo = idGrpo;
		this.nombre = nombre;
		this.idGrre = idGrre;
		this.estadoRegistro = estadoRegistro;
	}
	public Long getIdRefe() {
		return idRefe;
	}
	public void setIdRefe(Long idRefe) {
		this.idRefe = idRefe;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Long getIdGrpo() {
		return idGrpo;
	}
	public void setIdGrpo(Long idGrpo) {
		this.idGrpo = idGrpo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getIdGrre() {
		return idGrre;
	}
	public void setIdGrre(Long idGrre) {
		this.idGrre = idGrre;
	}
	public String getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
}
