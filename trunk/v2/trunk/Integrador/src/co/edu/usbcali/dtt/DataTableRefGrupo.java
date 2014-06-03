package co.edu.usbcali.dtt;

import java.util.Date;

import co.edu.usbcali.modelo.Familia;
import co.edu.usbcali.modelo.Grupo;

public class DataTableRefGrupo {

	private Long idRefe;
	private String codigo;
	private String descripcion;
	private String descripcionCorta;
	private String unidadMedida;
	private String unidadMedidaProvisional;
	private String marca;
	private String equivalente1;
	private String equivalente2;
	private Double volumen;
	private Double galones;
	private Double porcentajeIva;
	private String pideCantidad;
	private String pideValor;
	private Double costo;
	private String aplicacion;
	private String descripcionTecnica;
	private String esGarantia;
	private Double peso;
	private Long QPorCaja;
	private Date fechaVigentePBodega;
	private Long margenMinimoPBodega;
	private Long margenMinimoGBodega;
	private Long margenMinimoRefBodega;
	private Date fechaVigentePEne;
	private Long margenMinimoPEne;
	private Long margenMinimoRefEne;
	private Long margenMinimoGEne;
	private Long productoEspecial;
	private Long productoConsumo;
	private Long manejaLote;
	private Long manejaDecimales;
	private String codigoBarras;
	private Date fechaCreacion;
	private String operCreador;
	private Date fechaModificacion;
	private String operModifica;
	private String estadoRegistro;

	private Long idGrpo;
	private Familia familia;
	private Grupo grupo;
	private String grupo_1;
	private String nombre;
	private Double margenMinimoBodega;
	private Double margenMinimoEnergiteca;
	private String division;
	private String tipoNivel;
	private String especial;
	private String modificaReferencia;
	private String pideGalones;
	private String manejaOrdenCompra;
	private String sugeridoPedido;
	private String asociado;
	private Date fechaCreacionGrupo;
	private String operCreadorGrupo;
	private Date fechaModificacionGrupo;
	private String operModificaGrupo;
	private String estadoRegistroGrupo;

	private Long idGrre;
	private Grupo grupoRef;
	private Date fechaInactivo;
	private Date fechaCreacionGrupoRef;
	private String operCreadorGrupoRef;
	private Date fechaModificacionGrupoRef;
	private String operModificaGrupoRef;
	private String estadoRegistroGrupoRef;

	public Long getIdRefe() {
		return idRefe;
	}

	public void setIdRefe(Long idRefe) {
		this.idRefe = idRefe;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public String getUnidadMedidaProvisional() {
		return unidadMedidaProvisional;
	}

	public void setUnidadMedidaProvisional(String unidadMedidaProvisional) {
		this.unidadMedidaProvisional = unidadMedidaProvisional;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getEquivalente1() {
		return equivalente1;
	}

	public void setEquivalente1(String equivalente1) {
		this.equivalente1 = equivalente1;
	}

	public String getEquivalente2() {
		return equivalente2;
	}

	public void setEquivalente2(String equivalente2) {
		this.equivalente2 = equivalente2;
	}

	public Double getVolumen() {
		return volumen;
	}

	public void setVolumen(Double volumen) {
		this.volumen = volumen;
	}

	public Double getGalones() {
		return galones;
	}

	public void setGalones(Double galones) {
		this.galones = galones;
	}

	public Double getPorcentajeIva() {
		return porcentajeIva;
	}

	public void setPorcentajeIva(Double porcentajeIva) {
		this.porcentajeIva = porcentajeIva;
	}

	public String getPideCantidad() {
		return pideCantidad;
	}

	public void setPideCantidad(String pideCantidad) {
		this.pideCantidad = pideCantidad;
	}

	public String getPideValor() {
		return pideValor;
	}

	public void setPideValor(String pideValor) {
		this.pideValor = pideValor;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	public String getDescripcionTecnica() {
		return descripcionTecnica;
	}

	public void setDescripcionTecnica(String descripcionTecnica) {
		this.descripcionTecnica = descripcionTecnica;
	}

	public String getEsGarantia() {
		return esGarantia;
	}

	public void setEsGarantia(String esGarantia) {
		this.esGarantia = esGarantia;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Long getQPorCaja() {
		return QPorCaja;
	}

	public void setQPorCaja(Long qPorCaja) {
		QPorCaja = qPorCaja;
	}

	public Date getFechaVigentePBodega() {
		return fechaVigentePBodega;
	}

	public void setFechaVigentePBodega(Date fechaVigentePBodega) {
		this.fechaVigentePBodega = fechaVigentePBodega;
	}

	public Long getMargenMinimoPBodega() {
		return margenMinimoPBodega;
	}

	public void setMargenMinimoPBodega(Long margenMinimoPBodega) {
		this.margenMinimoPBodega = margenMinimoPBodega;
	}

	public Long getMargenMinimoGBodega() {
		return margenMinimoGBodega;
	}

	public void setMargenMinimoGBodega(Long margenMinimoGBodega) {
		this.margenMinimoGBodega = margenMinimoGBodega;
	}

	public Long getMargenMinimoRefBodega() {
		return margenMinimoRefBodega;
	}

	public void setMargenMinimoRefBodega(Long margenMinimoRefBodega) {
		this.margenMinimoRefBodega = margenMinimoRefBodega;
	}

	public Date getFechaVigentePEne() {
		return fechaVigentePEne;
	}

	public void setFechaVigentePEne(Date fechaVigentePEne) {
		this.fechaVigentePEne = fechaVigentePEne;
	}

	public Long getMargenMinimoPEne() {
		return margenMinimoPEne;
	}

	public void setMargenMinimoPEne(Long margenMinimoPEne) {
		this.margenMinimoPEne = margenMinimoPEne;
	}

	public Long getMargenMinimoRefEne() {
		return margenMinimoRefEne;
	}

	public void setMargenMinimoRefEne(Long margenMinimoRefEne) {
		this.margenMinimoRefEne = margenMinimoRefEne;
	}

	public Long getMargenMinimoGEne() {
		return margenMinimoGEne;
	}

	public void setMargenMinimoGEne(Long margenMinimoGEne) {
		this.margenMinimoGEne = margenMinimoGEne;
	}

	public Long getProductoEspecial() {
		return productoEspecial;
	}

	public void setProductoEspecial(Long productoEspecial) {
		this.productoEspecial = productoEspecial;
	}

	public Long getProductoConsumo() {
		return productoConsumo;
	}

	public void setProductoConsumo(Long productoConsumo) {
		this.productoConsumo = productoConsumo;
	}

	public Long getManejaLote() {
		return manejaLote;
	}

	public void setManejaLote(Long manejaLote) {
		this.manejaLote = manejaLote;
	}

	public Long getManejaDecimales() {
		return manejaDecimales;
	}

	public void setManejaDecimales(Long manejaDecimales) {
		this.manejaDecimales = manejaDecimales;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getOperCreador() {
		return operCreador;
	}

	public void setOperCreador(String operCreador) {
		this.operCreador = operCreador;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getOperModifica() {
		return operModifica;
	}

	public void setOperModifica(String operModifica) {
		this.operModifica = operModifica;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public Long getIdGrpo() {
		return idGrpo;
	}

	public void setIdGrpo(Long idGrpo) {
		this.idGrpo = idGrpo;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getGrupo_1() {
		return grupo_1;
	}

	public void setGrupo_1(String grupo_1) {
		this.grupo_1 = grupo_1;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getMargenMinimoBodega() {
		return margenMinimoBodega;
	}

	public void setMargenMinimoBodega(Double margenMinimoBodega) {
		this.margenMinimoBodega = margenMinimoBodega;
	}

	public Double getMargenMinimoEnergiteca() {
		return margenMinimoEnergiteca;
	}

	public void setMargenMinimoEnergiteca(Double margenMinimoEnergiteca) {
		this.margenMinimoEnergiteca = margenMinimoEnergiteca;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getTipoNivel() {
		return tipoNivel;
	}

	public void setTipoNivel(String tipoNivel) {
		this.tipoNivel = tipoNivel;
	}

	public String getEspecial() {
		return especial;
	}

	public void setEspecial(String especial) {
		this.especial = especial;
	}

	public String getModificaReferencia() {
		return modificaReferencia;
	}

	public void setModificaReferencia(String modificaReferencia) {
		this.modificaReferencia = modificaReferencia;
	}

	public String getPideGalones() {
		return pideGalones;
	}

	public void setPideGalones(String pideGalones) {
		this.pideGalones = pideGalones;
	}

	public String getManejaOrdenCompra() {
		return manejaOrdenCompra;
	}

	public void setManejaOrdenCompra(String manejaOrdenCompra) {
		this.manejaOrdenCompra = manejaOrdenCompra;
	}

	public String getSugeridoPedido() {
		return sugeridoPedido;
	}

	public void setSugeridoPedido(String sugeridoPedido) {
		this.sugeridoPedido = sugeridoPedido;
	}

	public String getAsociado() {
		return asociado;
	}

	public void setAsociado(String asociado) {
		this.asociado = asociado;
	}

	public Date getFechaCreacionGrupo() {
		return fechaCreacionGrupo;
	}

	public void setFechaCreacionGrupo(Date fechaCreacionGrupo) {
		this.fechaCreacionGrupo = fechaCreacionGrupo;
	}

	public String getOperCreadorGrupo() {
		return operCreadorGrupo;
	}

	public void setOperCreadorGrupo(String operCreadorGrupo) {
		this.operCreadorGrupo = operCreadorGrupo;
	}

	public Date getFechaModificacionGrupo() {
		return fechaModificacionGrupo;
	}

	public void setFechaModificacionGrupo(Date fechaModificacionGrupo) {
		this.fechaModificacionGrupo = fechaModificacionGrupo;
	}

	public String getOperModificaGrupo() {
		return operModificaGrupo;
	}

	public void setOperModificaGrupo(String operModificaGrupo) {
		this.operModificaGrupo = operModificaGrupo;
	}

	public String getEstadoRegistroGrupo() {
		return estadoRegistroGrupo;
	}

	public void setEstadoRegistroGrupo(String estadoRegistroGrupo) {
		this.estadoRegistroGrupo = estadoRegistroGrupo;
	}

	public Long getIdGrre() {
		return idGrre;
	}

	public void setIdGrre(Long idGrre) {
		this.idGrre = idGrre;
	}

	public Grupo getGrupoRef() {
		return grupoRef;
	}

	public void setGrupoRef(Grupo grupoRef) {
		this.grupoRef = grupoRef;
	}

	public Date getFechaInactivo() {
		return fechaInactivo;
	}

	public void setFechaInactivo(Date fechaInactivo) {
		this.fechaInactivo = fechaInactivo;
	}

	public Date getFechaCreacionGrupoRef() {
		return fechaCreacionGrupoRef;
	}

	public void setFechaCreacionGrupoRef(Date fechaCreacionGrupoRef) {
		this.fechaCreacionGrupoRef = fechaCreacionGrupoRef;
	}

	public String getOperCreadorGrupoRef() {
		return operCreadorGrupoRef;
	}

	public void setOperCreadorGrupoRef(String operCreadorGrupoRef) {
		this.operCreadorGrupoRef = operCreadorGrupoRef;
	}

	public Date getFechaModificacionGrupoRef() {
		return fechaModificacionGrupoRef;
	}

	public void setFechaModificacionGrupoRef(Date fechaModificacionGrupoRef) {
		this.fechaModificacionGrupoRef = fechaModificacionGrupoRef;
	}

	public String getOperModificaGrupoRef() {
		return operModificaGrupoRef;
	}

	public void setOperModificaGrupoRef(String operModificaGrupoRef) {
		this.operModificaGrupoRef = operModificaGrupoRef;
	}

	public String getEstadoRegistroGrupoRef() {
		return estadoRegistroGrupoRef;
	}

	public void setEstadoRegistroGrupoRef(String estadoRegistroGrupoRef) {
		this.estadoRegistroGrupoRef = estadoRegistroGrupoRef;
	}

}
