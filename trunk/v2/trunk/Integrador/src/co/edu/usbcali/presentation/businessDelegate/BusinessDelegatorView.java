package co.edu.usbcali.presentation.businessDelegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.usbcali.modelo.AtencionVendedor;
import co.edu.usbcali.modelo.Banco;
import co.edu.usbcali.modelo.Bateriologo;
import co.edu.usbcali.modelo.CamposParametrizables;
import co.edu.usbcali.modelo.Cartera;
import co.edu.usbcali.modelo.Causal;
import co.edu.usbcali.modelo.ChequePosfechado;
import co.edu.usbcali.modelo.ClaveFabricacion;
import co.edu.usbcali.modelo.ClavesParaRotar;
import co.edu.usbcali.modelo.Cliente;
import co.edu.usbcali.modelo.Compania;
import co.edu.usbcali.modelo.ConceptoRecibo;
import co.edu.usbcali.modelo.ConfSemanasAno;
import co.edu.usbcali.modelo.ConsecutivoDocumento;
import co.edu.usbcali.modelo.Contacto;
import co.edu.usbcali.modelo.Cruce;
import co.edu.usbcali.modelo.DescuentoComercial;
import co.edu.usbcali.modelo.DescuentoFinanciero;
import co.edu.usbcali.modelo.DetalleVisita;
import co.edu.usbcali.modelo.DiasSemana;
import co.edu.usbcali.modelo.DistribucionCartera;
import co.edu.usbcali.modelo.DivisionPolitica;
import co.edu.usbcali.modelo.Documento;
import co.edu.usbcali.modelo.Empresa;
import co.edu.usbcali.modelo.EstadoDocumento;
import co.edu.usbcali.modelo.Fallas;
import co.edu.usbcali.modelo.Familia;
import co.edu.usbcali.modelo.FrecuenciaSemana;
import co.edu.usbcali.modelo.FrecuenciaVisita;
import co.edu.usbcali.modelo.Garantia;
import co.edu.usbcali.modelo.Grupo;
import co.edu.usbcali.modelo.GrupoReferencia;
import co.edu.usbcali.modelo.ItemLogisticaReversiva;
import co.edu.usbcali.modelo.ItemRotacion;
import co.edu.usbcali.modelo.ListaPrecios;
import co.edu.usbcali.modelo.ListaPreciosEspeciales;
import co.edu.usbcali.modelo.LogisticaReversiva;
import co.edu.usbcali.modelo.MovimientoInventario;
import co.edu.usbcali.modelo.MovimientoVendedor;
import co.edu.usbcali.modelo.Multifamilia;
import co.edu.usbcali.modelo.OrdenesDeCompra;
import co.edu.usbcali.modelo.Pedido;
import co.edu.usbcali.modelo.PeriodoGarantia;
import co.edu.usbcali.modelo.Persona;
import co.edu.usbcali.modelo.PresupuestoCartera;
import co.edu.usbcali.modelo.PresupuestoVentas;
import co.edu.usbcali.modelo.ProgramacionAdicional;
import co.edu.usbcali.modelo.ProgramacionVisitas;
import co.edu.usbcali.modelo.PronosticoVenta;
import co.edu.usbcali.modelo.Proveedor;
import co.edu.usbcali.modelo.RboDetalleDocumentos;
import co.edu.usbcali.modelo.RboDetalleFormasPago;
import co.edu.usbcali.modelo.Recibo;
import co.edu.usbcali.modelo.Referencia;
import co.edu.usbcali.modelo.ReferenciaSucursal;
import co.edu.usbcali.modelo.RegionalGeografica;
import co.edu.usbcali.modelo.RelacionComercial;
import co.edu.usbcali.modelo.RutaDistribucion;
import co.edu.usbcali.modelo.RutaRelacionComercial;
import co.edu.usbcali.modelo.SaldoInicialInventario;
import co.edu.usbcali.modelo.Semana;
import co.edu.usbcali.modelo.SolicitudCambio;
import co.edu.usbcali.modelo.SolicitudCampo;
import co.edu.usbcali.modelo.StockInventarioMensual;
import co.edu.usbcali.modelo.Sucursal;
import co.edu.usbcali.modelo.Tabla;
import co.edu.usbcali.modelo.TipoCartera;
import co.edu.usbcali.modelo.TipoCausal;
import co.edu.usbcali.modelo.TipoContacto;
import co.edu.usbcali.modelo.TipoDivision;
import co.edu.usbcali.modelo.TipoDocumento;
import co.edu.usbcali.modelo.TipoFormaPago;
import co.edu.usbcali.modelo.TipoGarantia;
import co.edu.usbcali.modelo.TipoIdentificacion;
import co.edu.usbcali.modelo.TipoLista;
import co.edu.usbcali.modelo.TipoSucursal;
import co.edu.usbcali.modelo.UnidadNegocio;
import co.edu.usbcali.modelo.UnidadVenta;
import co.edu.usbcali.modelo.Vendedor;
import co.edu.usbcali.modelo.Visita;
import co.edu.usbcali.modelo.control.IAtencionVendedorLogic;
import co.edu.usbcali.modelo.control.IBancoLogic;
import co.edu.usbcali.modelo.control.IBateriologoLogic;
import co.edu.usbcali.modelo.control.ICamposParametrizablesLogic;
import co.edu.usbcali.modelo.control.ICarteraLogic;
import co.edu.usbcali.modelo.control.ICausalLogic;
import co.edu.usbcali.modelo.control.IChequePosfechadoLogic;
import co.edu.usbcali.modelo.control.IClaveFabricacionLogic;
import co.edu.usbcali.modelo.control.IClavesParaRotarLogic;
import co.edu.usbcali.modelo.control.IClienteLogic;
import co.edu.usbcali.modelo.control.ICompaniaLogic;
import co.edu.usbcali.modelo.control.IConceptoReciboLogic;
import co.edu.usbcali.modelo.control.IConfSemanasAnoLogic;
import co.edu.usbcali.modelo.control.IConsecutivoDocumentoLogic;
import co.edu.usbcali.modelo.control.IContactoLogic;
import co.edu.usbcali.modelo.control.ICruceLogic;
import co.edu.usbcali.modelo.control.IDescuentoComercialLogic;
import co.edu.usbcali.modelo.control.IDescuentoFinancieroLogic;
import co.edu.usbcali.modelo.control.IDetalleVisitaLogic;
import co.edu.usbcali.modelo.control.IDiasSemanaLogic;
import co.edu.usbcali.modelo.control.IDistribucionCarteraLogic;
import co.edu.usbcali.modelo.control.IDivisionPoliticaLogic;
import co.edu.usbcali.modelo.control.IDocumentoLogic;
import co.edu.usbcali.modelo.control.IEmpresaLogic;
import co.edu.usbcali.modelo.control.IEstadoDocumentoLogic;
import co.edu.usbcali.modelo.control.IFallasLogic;
import co.edu.usbcali.modelo.control.IFamiliaLogic;
import co.edu.usbcali.modelo.control.IFrecuenciaSemanaLogic;
import co.edu.usbcali.modelo.control.IFrecuenciaVisitaLogic;
import co.edu.usbcali.modelo.control.IGarantiaLogic;
import co.edu.usbcali.modelo.control.IGrupoLogic;
import co.edu.usbcali.modelo.control.IGrupoReferenciaLogic;
import co.edu.usbcali.modelo.control.IItemLogisticaReversivaLogic;
import co.edu.usbcali.modelo.control.IItemRotacionLogic;
import co.edu.usbcali.modelo.control.IListaPreciosEspecialesLogic;
import co.edu.usbcali.modelo.control.IListaPreciosLogic;
import co.edu.usbcali.modelo.control.ILogisticaReversivaLogic;
import co.edu.usbcali.modelo.control.IMovimientoInventarioLogic;
import co.edu.usbcali.modelo.control.IMovimientoVendedorLogic;
import co.edu.usbcali.modelo.control.IMultifamiliaLogic;
import co.edu.usbcali.modelo.control.IOrdenesDeCompraLogic;
import co.edu.usbcali.modelo.control.IPedidoLogic;
import co.edu.usbcali.modelo.control.IPeriodoGarantiaLogic;
import co.edu.usbcali.modelo.control.IPersonaLogic;
import co.edu.usbcali.modelo.control.IPresupuestoCarteraLogic;
import co.edu.usbcali.modelo.control.IPresupuestoVentasLogic;
import co.edu.usbcali.modelo.control.IProgramacionAdicionalLogic;
import co.edu.usbcali.modelo.control.IProgramacionVisitasLogic;
import co.edu.usbcali.modelo.control.IPronosticoVentaLogic;
import co.edu.usbcali.modelo.control.IProveedorLogic;
import co.edu.usbcali.modelo.control.IRboDetalleDocumentosLogic;
import co.edu.usbcali.modelo.control.IRboDetalleFormasPagoLogic;
import co.edu.usbcali.modelo.control.IReciboLogic;
import co.edu.usbcali.modelo.control.IReferenciaLogic;
import co.edu.usbcali.modelo.control.IReferenciaSucursalLogic;
import co.edu.usbcali.modelo.control.IRegionalGeograficaLogic;
import co.edu.usbcali.modelo.control.IRelacionComercialLogic;
import co.edu.usbcali.modelo.control.IRutaDistribucionLogic;
import co.edu.usbcali.modelo.control.IRutaRelacionComercialLogic;
import co.edu.usbcali.modelo.control.ISaldoInicialInventarioLogic;
import co.edu.usbcali.modelo.control.ISemanaLogic;
import co.edu.usbcali.modelo.control.ISolicitudCambioLogic;
import co.edu.usbcali.modelo.control.ISolicitudCampoLogic;
import co.edu.usbcali.modelo.control.IStockInventarioMensualLogic;
import co.edu.usbcali.modelo.control.ISucursalLogic;
import co.edu.usbcali.modelo.control.ITablaLogic;
import co.edu.usbcali.modelo.control.ITipoCarteraLogic;
import co.edu.usbcali.modelo.control.ITipoCausalLogic;
import co.edu.usbcali.modelo.control.ITipoContactoLogic;
import co.edu.usbcali.modelo.control.ITipoDivisionLogic;
import co.edu.usbcali.modelo.control.ITipoDocumentoLogic;
import co.edu.usbcali.modelo.control.ITipoFormaPagoLogic;
import co.edu.usbcali.modelo.control.ITipoGarantiaLogic;
import co.edu.usbcali.modelo.control.ITipoIdentificacionLogic;
import co.edu.usbcali.modelo.control.ITipoListaLogic;
import co.edu.usbcali.modelo.control.ITipoSucursalLogic;
import co.edu.usbcali.modelo.control.IUnidadNegocioLogic;
import co.edu.usbcali.modelo.control.IUnidadVentaLogic;
import co.edu.usbcali.modelo.control.IVendedorLogic;
import co.edu.usbcali.modelo.control.IVisitaLogic;
import co.edu.usbcali.modelo.dto.AtencionVendedorDTO;
import co.edu.usbcali.modelo.dto.BancoDTO;
import co.edu.usbcali.modelo.dto.BateriologoDTO;
import co.edu.usbcali.modelo.dto.CamposParametrizablesDTO;
import co.edu.usbcali.modelo.dto.CarteraDTO;
import co.edu.usbcali.modelo.dto.CausalDTO;
import co.edu.usbcali.modelo.dto.ChequePosfechadoDTO;
import co.edu.usbcali.modelo.dto.ClaveFabricacionDTO;
import co.edu.usbcali.modelo.dto.ClavesParaRotarDTO;
import co.edu.usbcali.modelo.dto.ClienteDTO;
import co.edu.usbcali.modelo.dto.CompaniaDTO;
import co.edu.usbcali.modelo.dto.ConceptoReciboDTO;
import co.edu.usbcali.modelo.dto.ConfSemanasAnoDTO;
import co.edu.usbcali.modelo.dto.ConsecutivoDocumentoDTO;
import co.edu.usbcali.modelo.dto.ContactoDTO;
import co.edu.usbcali.modelo.dto.CruceDTO;
import co.edu.usbcali.modelo.dto.DescuentoComercialDTO;
import co.edu.usbcali.modelo.dto.DescuentoFinancieroDTO;
import co.edu.usbcali.modelo.dto.DetalleVisitaDTO;
import co.edu.usbcali.modelo.dto.DiasSemanaDTO;
import co.edu.usbcali.modelo.dto.DistribucionCarteraDTO;
import co.edu.usbcali.modelo.dto.DivisionPoliticaDTO;
import co.edu.usbcali.modelo.dto.DocumentoDTO;
import co.edu.usbcali.modelo.dto.EmpresaDTO;
import co.edu.usbcali.modelo.dto.EstadoDocumentoDTO;
import co.edu.usbcali.modelo.dto.FallasDTO;
import co.edu.usbcali.modelo.dto.FamiliaDTO;
import co.edu.usbcali.modelo.dto.FrecuenciaSemanaDTO;
import co.edu.usbcali.modelo.dto.FrecuenciaVisitaDTO;
import co.edu.usbcali.modelo.dto.GarantiaDTO;
import co.edu.usbcali.modelo.dto.GrupoDTO;
import co.edu.usbcali.modelo.dto.GrupoReferenciaDTO;
import co.edu.usbcali.modelo.dto.ItemLogisticaReversivaDTO;
import co.edu.usbcali.modelo.dto.ItemRotacionDTO;
import co.edu.usbcali.modelo.dto.ListaPreciosDTO;
import co.edu.usbcali.modelo.dto.ListaPreciosEspecialesDTO;
import co.edu.usbcali.modelo.dto.LogisticaReversivaDTO;
import co.edu.usbcali.modelo.dto.MovimientoInventarioDTO;
import co.edu.usbcali.modelo.dto.MovimientoVendedorDTO;
import co.edu.usbcali.modelo.dto.MultifamiliaDTO;
import co.edu.usbcali.modelo.dto.OrdenesDeCompraDTO;
import co.edu.usbcali.modelo.dto.PedidoDTO;
import co.edu.usbcali.modelo.dto.PeriodoGarantiaDTO;
import co.edu.usbcali.modelo.dto.PersonaDTO;
import co.edu.usbcali.modelo.dto.PresupuestoCarteraDTO;
import co.edu.usbcali.modelo.dto.PresupuestoVentasDTO;
import co.edu.usbcali.modelo.dto.ProgramacionAdicionalDTO;
import co.edu.usbcali.modelo.dto.ProgramacionVisitasDTO;
import co.edu.usbcali.modelo.dto.PronosticoVentaDTO;
import co.edu.usbcali.modelo.dto.ProveedorDTO;
import co.edu.usbcali.modelo.dto.RboDetalleDocumentosDTO;
import co.edu.usbcali.modelo.dto.RboDetalleFormasPagoDTO;
import co.edu.usbcali.modelo.dto.ReciboDTO;
import co.edu.usbcali.modelo.dto.ReferenciaDTO;
import co.edu.usbcali.modelo.dto.ReferenciaSucursalDTO;
import co.edu.usbcali.modelo.dto.RegionalGeograficaDTO;
import co.edu.usbcali.modelo.dto.RelacionComercialDTO;
import co.edu.usbcali.modelo.dto.RutaDistribucionDTO;
import co.edu.usbcali.modelo.dto.RutaRelacionComercialDTO;
import co.edu.usbcali.modelo.dto.SaldoInicialInventarioDTO;
import co.edu.usbcali.modelo.dto.SemanaDTO;
import co.edu.usbcali.modelo.dto.SolicitudCambioDTO;
import co.edu.usbcali.modelo.dto.SolicitudCampoDTO;
import co.edu.usbcali.modelo.dto.StockInventarioMensualDTO;
import co.edu.usbcali.modelo.dto.SucursalDTO;
import co.edu.usbcali.modelo.dto.TablaDTO;
import co.edu.usbcali.modelo.dto.TipoCarteraDTO;
import co.edu.usbcali.modelo.dto.TipoCausalDTO;
import co.edu.usbcali.modelo.dto.TipoContactoDTO;
import co.edu.usbcali.modelo.dto.TipoDivisionDTO;
import co.edu.usbcali.modelo.dto.TipoDocumentoDTO;
import co.edu.usbcali.modelo.dto.TipoFormaPagoDTO;
import co.edu.usbcali.modelo.dto.TipoGarantiaDTO;
import co.edu.usbcali.modelo.dto.TipoIdentificacionDTO;
import co.edu.usbcali.modelo.dto.TipoListaDTO;
import co.edu.usbcali.modelo.dto.TipoSucursalDTO;
import co.edu.usbcali.modelo.dto.UnidadNegocioDTO;
import co.edu.usbcali.modelo.dto.UnidadVentaDTO;
import co.edu.usbcali.modelo.dto.VendedorDTO;
import co.edu.usbcali.modelo.dto.VisitaDTO;

/**
 * Use a Business Delegate to reduce coupling between presentation-tier clients
 * and business services. The Business Delegate hides the underlying
 * implementation details of the business service, such as lookup and access
 * details of the EJB architecture.
 * 
 * The Business Delegate acts as a client-side business abstraction; it provides
 * an abstraction for, and thus hides, the implementation of the business
 * services. Using a Business Delegate reduces the coupling between
 * presentation-tier clients and the system's business services. Depending on
 * the implementation strategy, the Business Delegate may shield clients from
 * possible volatility in the implementation of the business service API.
 * Potentially, this reduces the number of changes that must be made to the
 * presentation-tier client code when the business service API or its underlying
 * implementation changes.
 * 
 * However, interface methods in the Business Delegate may still require
 * modification if the underlying business service API changes. Admittedly,
 * though, it is more likely that changes will be made to the business service
 * rather than to the Business Delegate.
 * 
 * Often, developers are skeptical when a design goal such as abstracting the
 * business layer causes additional upfront work in return for future gains.
 * However, using this pattern or its strategies results in only a small amount
 * of additional upfront work and provides considerable benefits. The main
 * benefit is hiding the details of the underlying service. For example, the
 * client can become transparent to naming and lookup services. The Business
 * Delegate also handles the exceptions from the business services, such as
 * java.rmi.Remote exceptions, Java Messages Service (JMS) exceptions and so on.
 * The Business Delegate may intercept such service level exceptions and
 * generate application level exceptions instead. Application level exceptions
 * are easier to handle by the clients, and may be user friendly. The Business
 * Delegate may also transparently perform any retry or recovery operations
 * necessary in the event of a service failure without exposing the client to
 * the problem until it is determined that the problem is not resolvable. These
 * gains present a compelling reason to use the pattern.
 * 
 * Another benefit is that the delegate may cache results and references to
 * remote business services. Caching can significantly improve performance,
 * because it limits unnecessary and potentially costly round trips over the
 * network.
 * 
 * A Business Delegate uses a component called the Lookup Service. The Lookup
 * Service is responsible for hiding the underlying implementation details of
 * the business service lookup code. The Lookup Service may be written as part
 * of the Delegate, but we recommend that it be implemented as a separate
 * component, as outlined in the Service Locator pattern (See "Service Locator"
 * on page 368.)
 * 
 * When the Business Delegate is used with a Session Facade, typically there is
 * a one-to-one relationship between the two. This one-to-one relationship
 * exists because logic that might have been encapsulated in a Business Delegate
 * relating to its interaction with multiple business services (creating a
 * one-to-many relationship) will often be factored back into a Session Facade.
 * 
 * Finally, it should be noted that this pattern could be used to reduce
 * coupling between other tiers, not simply the presentation and the business
 * tiers.
 * 
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
	@Autowired
	private IAtencionVendedorLogic atencionVendedorLogic;
	@Autowired
	private IBancoLogic bancoLogic;
	@Autowired
	private IBateriologoLogic bateriologoLogic;
	@Autowired
	private ICamposParametrizablesLogic camposParametrizablesLogic;
	@Autowired
	private ICarteraLogic carteraLogic;
	@Autowired
	private ICausalLogic causalLogic;
	@Autowired
	private IChequePosfechadoLogic chequePosfechadoLogic;
	@Autowired
	private IClaveFabricacionLogic claveFabricacionLogic;
	@Autowired
	private IClavesParaRotarLogic clavesParaRotarLogic;
	@Autowired
	private IClienteLogic clienteLogic;
	@Autowired
	private ICompaniaLogic companiaLogic;
	@Autowired
	private IConceptoReciboLogic conceptoReciboLogic;
	@Autowired
	private IConfSemanasAnoLogic confSemanasAnoLogic;
	@Autowired
	private IConsecutivoDocumentoLogic consecutivoDocumentoLogic;
	@Autowired
	private IContactoLogic contactoLogic;
	@Autowired
	private ICruceLogic cruceLogic;
	@Autowired
	private IDescuentoComercialLogic descuentoComercialLogic;
	@Autowired
	private IDescuentoFinancieroLogic descuentoFinancieroLogic;
	@Autowired
	private IDetalleVisitaLogic detalleVisitaLogic;
	@Autowired
	private IDiasSemanaLogic diasSemanaLogic;
	@Autowired
	private IDistribucionCarteraLogic distribucionCarteraLogic;
	@Autowired
	private IDivisionPoliticaLogic divisionPoliticaLogic;
	@Autowired
	private IDocumentoLogic documentoLogic;
	@Autowired
	private IEmpresaLogic empresaLogic;
	@Autowired
	private IEstadoDocumentoLogic estadoDocumentoLogic;
	@Autowired
	private IFallasLogic fallasLogic;
	@Autowired
	private IFamiliaLogic familiaLogic;
	@Autowired
	private IFrecuenciaSemanaLogic frecuenciaSemanaLogic;
	@Autowired
	private IFrecuenciaVisitaLogic frecuenciaVisitaLogic;
	@Autowired
	private IGarantiaLogic garantiaLogic;
	@Autowired
	private IGrupoLogic grupoLogic;
	@Autowired
	private IGrupoReferenciaLogic grupoReferenciaLogic;
	@Autowired
	private IItemLogisticaReversivaLogic itemLogisticaReversivaLogic;
	@Autowired
	private IItemRotacionLogic itemRotacionLogic;
	@Autowired
	private IListaPreciosLogic listaPreciosLogic;
	@Autowired
	private IListaPreciosEspecialesLogic listaPreciosEspecialesLogic;
	@Autowired
	private ILogisticaReversivaLogic logisticaReversivaLogic;
	@Autowired
	private IMovimientoInventarioLogic movimientoInventarioLogic;
	@Autowired
	private IMovimientoVendedorLogic movimientoVendedorLogic;
	@Autowired
	private IMultifamiliaLogic multifamiliaLogic;
	@Autowired
	private IOrdenesDeCompraLogic ordenesDeCompraLogic;
	@Autowired
	private IPedidoLogic pedidoLogic;
	@Autowired
	private IPeriodoGarantiaLogic periodoGarantiaLogic;
	@Autowired
	private IPersonaLogic personaLogic;
	@Autowired
	private IPresupuestoCarteraLogic presupuestoCarteraLogic;
	@Autowired
	private IPresupuestoVentasLogic presupuestoVentasLogic;
	@Autowired
	private IProgramacionAdicionalLogic programacionAdicionalLogic;
	@Autowired
	private IProgramacionVisitasLogic programacionVisitasLogic;
	@Autowired
	private IPronosticoVentaLogic pronosticoVentaLogic;
	@Autowired
	private IProveedorLogic proveedorLogic;
	@Autowired
	private IRboDetalleDocumentosLogic rboDetalleDocumentosLogic;
	@Autowired
	private IRboDetalleFormasPagoLogic rboDetalleFormasPagoLogic;
	@Autowired
	private IReciboLogic reciboLogic;
	@Autowired
	private IReferenciaLogic referenciaLogic;
	@Autowired
	private IReferenciaSucursalLogic referenciaSucursalLogic;
	@Autowired
	private IRegionalGeograficaLogic regionalGeograficaLogic;
	@Autowired
	private IRelacionComercialLogic relacionComercialLogic;
	@Autowired
	private IRutaDistribucionLogic rutaDistribucionLogic;
	@Autowired
	private IRutaRelacionComercialLogic rutaRelacionComercialLogic;
	@Autowired
	private ISaldoInicialInventarioLogic saldoInicialInventarioLogic;
	@Autowired
	private ISemanaLogic semanaLogic;
	@Autowired
	private ISolicitudCambioLogic solicitudCambioLogic;
	@Autowired
	private ISolicitudCampoLogic solicitudCampoLogic;
	@Autowired
	private IStockInventarioMensualLogic stockInventarioMensualLogic;
	@Autowired
	private ISucursalLogic sucursalLogic;
	@Autowired
	private ITablaLogic tablaLogic;
	@Autowired
	private ITipoCarteraLogic tipoCarteraLogic;
	@Autowired
	private ITipoCausalLogic tipoCausalLogic;
	@Autowired
	private ITipoContactoLogic tipoContactoLogic;
	@Autowired
	private ITipoDivisionLogic tipoDivisionLogic;
	@Autowired
	private ITipoDocumentoLogic tipoDocumentoLogic;
	@Autowired
	private ITipoFormaPagoLogic tipoFormaPagoLogic;
	@Autowired
	private ITipoGarantiaLogic tipoGarantiaLogic;
	@Autowired
	private ITipoIdentificacionLogic tipoIdentificacionLogic;
	@Autowired
	private ITipoListaLogic tipoListaLogic;
	@Autowired
	private ITipoSucursalLogic tipoSucursalLogic;
	@Autowired
	private IUnidadNegocioLogic unidadNegocioLogic;
	@Autowired
	private IUnidadVentaLogic unidadVentaLogic;
	@Autowired
	private IVendedorLogic vendedorLogic;
	@Autowired
	private IVisitaLogic visitaLogic;

	public List<AtencionVendedor> getAtencionVendedor() throws Exception {
		return atencionVendedorLogic.getAtencionVendedor();
	}

	public void saveAtencionVendedor(AtencionVendedor entity) throws Exception {
		atencionVendedorLogic.saveAtencionVendedor(entity);
	}

	public void deleteAtencionVendedor(AtencionVendedor entity)
			throws Exception {
		atencionVendedorLogic.deleteAtencionVendedor(entity);
	}

	public void updateAtencionVendedor(AtencionVendedor entity)
			throws Exception {
		atencionVendedorLogic.updateAtencionVendedor(entity);
	}

	public AtencionVendedor getAtencionVendedor(Long idAtve) throws Exception {
		AtencionVendedor atencionVendedor = null;

		try {
			atencionVendedor = atencionVendedorLogic
					.getAtencionVendedor(idAtve);
		} catch (Exception e) {
			throw e;
		}

		return atencionVendedor;
	}

	public List<AtencionVendedor> findByCriteriaInAtencionVendedor(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return atencionVendedorLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<AtencionVendedor> findPageAtencionVendedor(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return atencionVendedorLogic.findPageAtencionVendedor(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberAtencionVendedor() throws Exception {
		return atencionVendedorLogic.findTotalNumberAtencionVendedor();
	}

	public List<AtencionVendedorDTO> getDataAtencionVendedor() throws Exception {
		return atencionVendedorLogic.getDataAtencionVendedor();
	}

	public List<Banco> getBanco() throws Exception {
		return bancoLogic.getBanco();
	}

	public void saveBanco(Banco entity) throws Exception {
		bancoLogic.saveBanco(entity);
	}

	public void deleteBanco(Banco entity) throws Exception {
		bancoLogic.deleteBanco(entity);
	}

	public void updateBanco(Banco entity) throws Exception {
		bancoLogic.updateBanco(entity);
	}

	public Banco getBanco(Long idBanc) throws Exception {
		Banco banco = null;

		try {
			banco = bancoLogic.getBanco(idBanc);
		} catch (Exception e) {
			throw e;
		}

		return banco;
	}

	public List<Banco> findByCriteriaInBanco(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return bancoLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Banco> findPageBanco(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return bancoLogic.findPageBanco(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberBanco() throws Exception {
		return bancoLogic.findTotalNumberBanco();
	}

	public List<BancoDTO> getDataBanco() throws Exception {
		return bancoLogic.getDataBanco();
	}

	public List<Bateriologo> getBateriologo() throws Exception {
		return bateriologoLogic.getBateriologo();
	}

	public void saveBateriologo(Bateriologo entity) throws Exception {
		bateriologoLogic.saveBateriologo(entity);
	}

	public void deleteBateriologo(Bateriologo entity) throws Exception {
		bateriologoLogic.deleteBateriologo(entity);
	}

	public void updateBateriologo(Bateriologo entity) throws Exception {
		bateriologoLogic.updateBateriologo(entity);
	}

	public Bateriologo getBateriologo(Long idBate) throws Exception {
		Bateriologo bateriologo = null;

		try {
			bateriologo = bateriologoLogic.getBateriologo(idBate);
		} catch (Exception e) {
			throw e;
		}

		return bateriologo;
	}

	public List<Bateriologo> findByCriteriaInBateriologo(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return bateriologoLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Bateriologo> findPageBateriologo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return bateriologoLogic.findPageBateriologo(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberBateriologo() throws Exception {
		return bateriologoLogic.findTotalNumberBateriologo();
	}

	public List<BateriologoDTO> getDataBateriologo() throws Exception {
		return bateriologoLogic.getDataBateriologo();
	}

	public List<CamposParametrizables> getCamposParametrizables()
			throws Exception {
		return camposParametrizablesLogic.getCamposParametrizables();
	}

	public void saveCamposParametrizables(CamposParametrizables entity)
			throws Exception {
		camposParametrizablesLogic.saveCamposParametrizables(entity);
	}

	public void deleteCamposParametrizables(CamposParametrizables entity)
			throws Exception {
		camposParametrizablesLogic.deleteCamposParametrizables(entity);
	}

	public void updateCamposParametrizables(CamposParametrizables entity)
			throws Exception {
		camposParametrizablesLogic.updateCamposParametrizables(entity);
	}

	public CamposParametrizables getCamposParametrizables(Long idCapa)
			throws Exception {
		CamposParametrizables camposParametrizables = null;

		try {
			camposParametrizables = camposParametrizablesLogic
					.getCamposParametrizables(idCapa);
		} catch (Exception e) {
			throw e;
		}

		return camposParametrizables;
	}

	public List<CamposParametrizables> findByCriteriaInCamposParametrizables(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return camposParametrizablesLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<CamposParametrizables> findPageCamposParametrizables(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return camposParametrizablesLogic.findPageCamposParametrizables(
				sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberCamposParametrizables() throws Exception {
		return camposParametrizablesLogic
				.findTotalNumberCamposParametrizables();
	}

	public List<CamposParametrizablesDTO> getDataCamposParametrizables()
			throws Exception {
		return camposParametrizablesLogic.getDataCamposParametrizables();
	}

	public List<Cartera> getCartera() throws Exception {
		return carteraLogic.getCartera();
	}

	public void saveCartera(Cartera entity) throws Exception {
		carteraLogic.saveCartera(entity);
	}

	public void deleteCartera(Cartera entity) throws Exception {
		carteraLogic.deleteCartera(entity);
	}

	public void updateCartera(Cartera entity) throws Exception {
		carteraLogic.updateCartera(entity);
	}

	public Cartera getCartera(Long idCart) throws Exception {
		Cartera cartera = null;

		try {
			cartera = carteraLogic.getCartera(idCart);
		} catch (Exception e) {
			throw e;
		}

		return cartera;
	}

	public List<Cartera> findByCriteriaInCartera(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return carteraLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Cartera> findPageCartera(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return carteraLogic.findPageCartera(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberCartera() throws Exception {
		return carteraLogic.findTotalNumberCartera();
	}

	public List<CarteraDTO> getDataCartera() throws Exception {
		return carteraLogic.getDataCartera();
	}

	public List<Causal> getCausal() throws Exception {
		return causalLogic.getCausal();
	}

	public void saveCausal(Causal entity) throws Exception {
		causalLogic.saveCausal(entity);
	}

	public void deleteCausal(Causal entity) throws Exception {
		causalLogic.deleteCausal(entity);
	}

	public void updateCausal(Causal entity) throws Exception {
		causalLogic.updateCausal(entity);
	}

	public Causal getCausal(Long idCusa) throws Exception {
		Causal causal = null;

		try {
			causal = causalLogic.getCausal(idCusa);
		} catch (Exception e) {
			throw e;
		}

		return causal;
	}

	public List<Causal> findByCriteriaInCausal(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return causalLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Causal> findPageCausal(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return causalLogic.findPageCausal(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberCausal() throws Exception {
		return causalLogic.findTotalNumberCausal();
	}

	public List<CausalDTO> getDataCausal() throws Exception {
		return causalLogic.getDataCausal();
	}

	public List<ChequePosfechado> getChequePosfechado() throws Exception {
		return chequePosfechadoLogic.getChequePosfechado();
	}

	public void saveChequePosfechado(ChequePosfechado entity) throws Exception {
		chequePosfechadoLogic.saveChequePosfechado(entity);
	}

	public void deleteChequePosfechado(ChequePosfechado entity)
			throws Exception {
		chequePosfechadoLogic.deleteChequePosfechado(entity);
	}

	public void updateChequePosfechado(ChequePosfechado entity)
			throws Exception {
		chequePosfechadoLogic.updateChequePosfechado(entity);
	}

	public ChequePosfechado getChequePosfechado(Long idChps) throws Exception {
		ChequePosfechado chequePosfechado = null;

		try {
			chequePosfechado = chequePosfechadoLogic
					.getChequePosfechado(idChps);
		} catch (Exception e) {
			throw e;
		}

		return chequePosfechado;
	}

	public List<ChequePosfechado> findByCriteriaInChequePosfechado(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return chequePosfechadoLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<ChequePosfechado> findPageChequePosfechado(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return chequePosfechadoLogic.findPageChequePosfechado(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberChequePosfechado() throws Exception {
		return chequePosfechadoLogic.findTotalNumberChequePosfechado();
	}

	public List<ChequePosfechadoDTO> getDataChequePosfechado() throws Exception {
		return chequePosfechadoLogic.getDataChequePosfechado();
	}

	public List<ClaveFabricacion> getClaveFabricacion() throws Exception {
		return claveFabricacionLogic.getClaveFabricacion();
	}

	public void saveClaveFabricacion(ClaveFabricacion entity) throws Exception {
		claveFabricacionLogic.saveClaveFabricacion(entity);
	}

	public void deleteClaveFabricacion(ClaveFabricacion entity)
			throws Exception {
		claveFabricacionLogic.deleteClaveFabricacion(entity);
	}

	public void updateClaveFabricacion(ClaveFabricacion entity)
			throws Exception {
		claveFabricacionLogic.updateClaveFabricacion(entity);
	}

	public ClaveFabricacion getClaveFabricacion(Long idClfa) throws Exception {
		ClaveFabricacion claveFabricacion = null;

		try {
			claveFabricacion = claveFabricacionLogic
					.getClaveFabricacion(idClfa);
		} catch (Exception e) {
			throw e;
		}

		return claveFabricacion;
	}

	public List<ClaveFabricacion> findByCriteriaInClaveFabricacion(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return claveFabricacionLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<ClaveFabricacion> findPageClaveFabricacion(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return claveFabricacionLogic.findPageClaveFabricacion(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberClaveFabricacion() throws Exception {
		return claveFabricacionLogic.findTotalNumberClaveFabricacion();
	}

	public List<ClaveFabricacionDTO> getDataClaveFabricacion() throws Exception {
		return claveFabricacionLogic.getDataClaveFabricacion();
	}

	public List<ClavesParaRotar> getClavesParaRotar() throws Exception {
		return clavesParaRotarLogic.getClavesParaRotar();
	}

	public void saveClavesParaRotar(ClavesParaRotar entity) throws Exception {
		clavesParaRotarLogic.saveClavesParaRotar(entity);
	}

	public void deleteClavesParaRotar(ClavesParaRotar entity) throws Exception {
		clavesParaRotarLogic.deleteClavesParaRotar(entity);
	}

	public void updateClavesParaRotar(ClavesParaRotar entity) throws Exception {
		clavesParaRotarLogic.updateClavesParaRotar(entity);
	}

	public ClavesParaRotar getClavesParaRotar(Long idClpr) throws Exception {
		ClavesParaRotar clavesParaRotar = null;

		try {
			clavesParaRotar = clavesParaRotarLogic.getClavesParaRotar(idClpr);
		} catch (Exception e) {
			throw e;
		}

		return clavesParaRotar;
	}

	public List<ClavesParaRotar> findByCriteriaInClavesParaRotar(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return clavesParaRotarLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<ClavesParaRotar> findPageClavesParaRotar(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return clavesParaRotarLogic.findPageClavesParaRotar(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberClavesParaRotar() throws Exception {
		return clavesParaRotarLogic.findTotalNumberClavesParaRotar();
	}

	public List<ClavesParaRotarDTO> getDataClavesParaRotar() throws Exception {
		return clavesParaRotarLogic.getDataClavesParaRotar();
	}

	public List<Cliente> getCliente() throws Exception {
		return clienteLogic.getCliente();
	}

	public void saveCliente(Cliente entity) throws Exception {
		clienteLogic.saveCliente(entity);
	}

	public void deleteCliente(Cliente entity) throws Exception {
		clienteLogic.deleteCliente(entity);
	}

	public void updateCliente(Cliente entity) throws Exception {
		clienteLogic.updateCliente(entity);
	}

	public Cliente getCliente(Long idClie) throws Exception {
		Cliente cliente = null;

		try {
			cliente = clienteLogic.getCliente(idClie);
		} catch (Exception e) {
			throw e;
		}

		return cliente;
	}

	public List<Cliente> findByCriteriaInCliente(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return clienteLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Cliente> findPageCliente(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return clienteLogic.findPageCliente(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberCliente() throws Exception {
		return clienteLogic.findTotalNumberCliente();
	}

	public List<ClienteDTO> getDataCliente() throws Exception {
		return clienteLogic.getDataCliente();
	}

	public List<Compania> getCompania() throws Exception {
		return companiaLogic.getCompania();
	}

	public void saveCompania(Compania entity) throws Exception {
		companiaLogic.saveCompania(entity);
	}

	public void deleteCompania(Compania entity) throws Exception {
		companiaLogic.deleteCompania(entity);
	}

	public void updateCompania(Compania entity) throws Exception {
		companiaLogic.updateCompania(entity);
	}

	public Compania getCompania(Long idCia) throws Exception {
		Compania compania = null;

		try {
			compania = companiaLogic.getCompania(idCia);
		} catch (Exception e) {
			throw e;
		}

		return compania;
	}

	public List<Compania> findByCriteriaInCompania(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return companiaLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Compania> findPageCompania(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return companiaLogic.findPageCompania(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberCompania() throws Exception {
		return companiaLogic.findTotalNumberCompania();
	}

	public List<CompaniaDTO> getDataCompania() throws Exception {
		return companiaLogic.getDataCompania();
	}

	public List<ConceptoRecibo> getConceptoRecibo() throws Exception {
		return conceptoReciboLogic.getConceptoRecibo();
	}

	public void saveConceptoRecibo(ConceptoRecibo entity) throws Exception {
		conceptoReciboLogic.saveConceptoRecibo(entity);
	}

	public void deleteConceptoRecibo(ConceptoRecibo entity) throws Exception {
		conceptoReciboLogic.deleteConceptoRecibo(entity);
	}

	public void updateConceptoRecibo(ConceptoRecibo entity) throws Exception {
		conceptoReciboLogic.updateConceptoRecibo(entity);
	}

	public ConceptoRecibo getConceptoRecibo(Long idCpto) throws Exception {
		ConceptoRecibo conceptoRecibo = null;

		try {
			conceptoRecibo = conceptoReciboLogic.getConceptoRecibo(idCpto);
		} catch (Exception e) {
			throw e;
		}

		return conceptoRecibo;
	}

	public List<ConceptoRecibo> findByCriteriaInConceptoRecibo(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return conceptoReciboLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<ConceptoRecibo> findPageConceptoRecibo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return conceptoReciboLogic.findPageConceptoRecibo(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberConceptoRecibo() throws Exception {
		return conceptoReciboLogic.findTotalNumberConceptoRecibo();
	}

	public List<ConceptoReciboDTO> getDataConceptoRecibo() throws Exception {
		return conceptoReciboLogic.getDataConceptoRecibo();
	}

	public List<ConfSemanasAno> getConfSemanasAno() throws Exception {
		return confSemanasAnoLogic.getConfSemanasAno();
	}

	public void saveConfSemanasAno(ConfSemanasAno entity) throws Exception {
		confSemanasAnoLogic.saveConfSemanasAno(entity);
	}

	public void deleteConfSemanasAno(ConfSemanasAno entity) throws Exception {
		confSemanasAnoLogic.deleteConfSemanasAno(entity);
	}

	public void updateConfSemanasAno(ConfSemanasAno entity) throws Exception {
		confSemanasAnoLogic.updateConfSemanasAno(entity);
	}

	public ConfSemanasAno getConfSemanasAno(Long idCfsa) throws Exception {
		ConfSemanasAno confSemanasAno = null;

		try {
			confSemanasAno = confSemanasAnoLogic.getConfSemanasAno(idCfsa);
		} catch (Exception e) {
			throw e;
		}

		return confSemanasAno;
	}

	public List<ConfSemanasAno> findByCriteriaInConfSemanasAno(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return confSemanasAnoLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<ConfSemanasAno> findPageConfSemanasAno(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return confSemanasAnoLogic.findPageConfSemanasAno(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberConfSemanasAno() throws Exception {
		return confSemanasAnoLogic.findTotalNumberConfSemanasAno();
	}

	public List<ConfSemanasAnoDTO> getDataConfSemanasAno() throws Exception {
		return confSemanasAnoLogic.getDataConfSemanasAno();
	}

	public List<ConsecutivoDocumento> getConsecutivoDocumento()
			throws Exception {
		return consecutivoDocumentoLogic.getConsecutivoDocumento();
	}

	public void saveConsecutivoDocumento(ConsecutivoDocumento entity)
			throws Exception {
		consecutivoDocumentoLogic.saveConsecutivoDocumento(entity);
	}

	public void deleteConsecutivoDocumento(ConsecutivoDocumento entity)
			throws Exception {
		consecutivoDocumentoLogic.deleteConsecutivoDocumento(entity);
	}

	public void updateConsecutivoDocumento(ConsecutivoDocumento entity)
			throws Exception {
		consecutivoDocumentoLogic.updateConsecutivoDocumento(entity);
	}

	public ConsecutivoDocumento getConsecutivoDocumento(Long idCodo)
			throws Exception {
		ConsecutivoDocumento consecutivoDocumento = null;

		try {
			consecutivoDocumento = consecutivoDocumentoLogic
					.getConsecutivoDocumento(idCodo);
		} catch (Exception e) {
			throw e;
		}

		return consecutivoDocumento;
	}

	public List<ConsecutivoDocumento> findByCriteriaInConsecutivoDocumento(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return consecutivoDocumentoLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<ConsecutivoDocumento> findPageConsecutivoDocumento(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return consecutivoDocumentoLogic.findPageConsecutivoDocumento(
				sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberConsecutivoDocumento() throws Exception {
		return consecutivoDocumentoLogic.findTotalNumberConsecutivoDocumento();
	}

	public List<ConsecutivoDocumentoDTO> getDataConsecutivoDocumento()
			throws Exception {
		return consecutivoDocumentoLogic.getDataConsecutivoDocumento();
	}

	public List<Contacto> getContacto() throws Exception {
		return contactoLogic.getContacto();
	}

	public void saveContacto(Contacto entity) throws Exception {
		contactoLogic.saveContacto(entity);
	}

	public void deleteContacto(Contacto entity) throws Exception {
		contactoLogic.deleteContacto(entity);
	}

	public void updateContacto(Contacto entity) throws Exception {
		contactoLogic.updateContacto(entity);
	}

	public Contacto getContacto(Long idCont) throws Exception {
		Contacto contacto = null;

		try {
			contacto = contactoLogic.getContacto(idCont);
		} catch (Exception e) {
			throw e;
		}

		return contacto;
	}

	public List<Contacto> findByCriteriaInContacto(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return contactoLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Contacto> findPageContacto(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return contactoLogic.findPageContacto(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberContacto() throws Exception {
		return contactoLogic.findTotalNumberContacto();
	}

	public List<ContactoDTO> getDataContacto() throws Exception {
		return contactoLogic.getDataContacto();
	}

	public List<Cruce> getCruce() throws Exception {
		return cruceLogic.getCruce();
	}

	public void saveCruce(Cruce entity) throws Exception {
		cruceLogic.saveCruce(entity);
	}

	public void deleteCruce(Cruce entity) throws Exception {
		cruceLogic.deleteCruce(entity);
	}

	public void updateCruce(Cruce entity) throws Exception {
		cruceLogic.updateCruce(entity);
	}

	public Cruce getCruce(Long idCrce) throws Exception {
		Cruce cruce = null;

		try {
			cruce = cruceLogic.getCruce(idCrce);
		} catch (Exception e) {
			throw e;
		}

		return cruce;
	}

	public List<Cruce> findByCriteriaInCruce(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return cruceLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Cruce> findPageCruce(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return cruceLogic.findPageCruce(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberCruce() throws Exception {
		return cruceLogic.findTotalNumberCruce();
	}

	public List<CruceDTO> getDataCruce() throws Exception {
		return cruceLogic.getDataCruce();
	}

	public List<DescuentoComercial> getDescuentoComercial() throws Exception {
		return descuentoComercialLogic.getDescuentoComercial();
	}

	public void saveDescuentoComercial(DescuentoComercial entity)
			throws Exception {
		descuentoComercialLogic.saveDescuentoComercial(entity);
	}

	public void deleteDescuentoComercial(DescuentoComercial entity)
			throws Exception {
		descuentoComercialLogic.deleteDescuentoComercial(entity);
	}

	public void updateDescuentoComercial(DescuentoComercial entity)
			throws Exception {
		descuentoComercialLogic.updateDescuentoComercial(entity);
	}

	public DescuentoComercial getDescuentoComercial(Long idDeco)
			throws Exception {
		DescuentoComercial descuentoComercial = null;

		try {
			descuentoComercial = descuentoComercialLogic
					.getDescuentoComercial(idDeco);
		} catch (Exception e) {
			throw e;
		}

		return descuentoComercial;
	}

	public List<DescuentoComercial> findByCriteriaInDescuentoComercial(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return descuentoComercialLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<DescuentoComercial> findPageDescuentoComercial(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return descuentoComercialLogic.findPageDescuentoComercial(
				sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDescuentoComercial() throws Exception {
		return descuentoComercialLogic.findTotalNumberDescuentoComercial();
	}

	public List<DescuentoComercialDTO> getDataDescuentoComercial()
			throws Exception {
		return descuentoComercialLogic.getDataDescuentoComercial();
	}

	public List<DescuentoFinanciero> getDescuentoFinanciero() throws Exception {
		return descuentoFinancieroLogic.getDescuentoFinanciero();
	}

	public void saveDescuentoFinanciero(DescuentoFinanciero entity)
			throws Exception {
		descuentoFinancieroLogic.saveDescuentoFinanciero(entity);
	}

	public void deleteDescuentoFinanciero(DescuentoFinanciero entity)
			throws Exception {
		descuentoFinancieroLogic.deleteDescuentoFinanciero(entity);
	}

	public void updateDescuentoFinanciero(DescuentoFinanciero entity)
			throws Exception {
		descuentoFinancieroLogic.updateDescuentoFinanciero(entity);
	}

	public DescuentoFinanciero getDescuentoFinanciero(Long idDefi)
			throws Exception {
		DescuentoFinanciero descuentoFinanciero = null;

		try {
			descuentoFinanciero = descuentoFinancieroLogic
					.getDescuentoFinanciero(idDefi);
		} catch (Exception e) {
			throw e;
		}

		return descuentoFinanciero;
	}

	public List<DescuentoFinanciero> findByCriteriaInDescuentoFinanciero(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return descuentoFinancieroLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<DescuentoFinanciero> findPageDescuentoFinanciero(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return descuentoFinancieroLogic.findPageDescuentoFinanciero(
				sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDescuentoFinanciero() throws Exception {
		return descuentoFinancieroLogic.findTotalNumberDescuentoFinanciero();
	}

	public List<DescuentoFinancieroDTO> getDataDescuentoFinanciero()
			throws Exception {
		return descuentoFinancieroLogic.getDataDescuentoFinanciero();
	}

	public List<DetalleVisita> getDetalleVisita() throws Exception {
		return detalleVisitaLogic.getDetalleVisita();
	}

	public void saveDetalleVisita(DetalleVisita entity) throws Exception {
		detalleVisitaLogic.saveDetalleVisita(entity);
	}

	public void deleteDetalleVisita(DetalleVisita entity) throws Exception {
		detalleVisitaLogic.deleteDetalleVisita(entity);
	}

	public void updateDetalleVisita(DetalleVisita entity) throws Exception {
		detalleVisitaLogic.updateDetalleVisita(entity);
	}

	public DetalleVisita getDetalleVisita(Long idDevi) throws Exception {
		DetalleVisita detalleVisita = null;

		try {
			detalleVisita = detalleVisitaLogic.getDetalleVisita(idDevi);
		} catch (Exception e) {
			throw e;
		}

		return detalleVisita;
	}

	public List<DetalleVisita> findByCriteriaInDetalleVisita(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return detalleVisitaLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<DetalleVisita> findPageDetalleVisita(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return detalleVisitaLogic.findPageDetalleVisita(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDetalleVisita() throws Exception {
		return detalleVisitaLogic.findTotalNumberDetalleVisita();
	}

	public List<DetalleVisitaDTO> getDataDetalleVisita() throws Exception {
		return detalleVisitaLogic.getDataDetalleVisita();
	}

	public List<DiasSemana> getDiasSemana() throws Exception {
		return diasSemanaLogic.getDiasSemana();
	}

	public void saveDiasSemana(DiasSemana entity) throws Exception {
		diasSemanaLogic.saveDiasSemana(entity);
	}

	public void deleteDiasSemana(DiasSemana entity) throws Exception {
		diasSemanaLogic.deleteDiasSemana(entity);
	}

	public void updateDiasSemana(DiasSemana entity) throws Exception {
		diasSemanaLogic.updateDiasSemana(entity);
	}

	public DiasSemana getDiasSemana(Long idDise) throws Exception {
		DiasSemana diasSemana = null;

		try {
			diasSemana = diasSemanaLogic.getDiasSemana(idDise);
		} catch (Exception e) {
			throw e;
		}

		return diasSemana;
	}

	public List<DiasSemana> findByCriteriaInDiasSemana(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return diasSemanaLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<DiasSemana> findPageDiasSemana(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return diasSemanaLogic.findPageDiasSemana(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDiasSemana() throws Exception {
		return diasSemanaLogic.findTotalNumberDiasSemana();
	}

	public List<DiasSemanaDTO> getDataDiasSemana() throws Exception {
		return diasSemanaLogic.getDataDiasSemana();
	}

	public List<DistribucionCartera> getDistribucionCartera() throws Exception {
		return distribucionCarteraLogic.getDistribucionCartera();
	}

	public void saveDistribucionCartera(DistribucionCartera entity)
			throws Exception {
		distribucionCarteraLogic.saveDistribucionCartera(entity);
	}

	public void deleteDistribucionCartera(DistribucionCartera entity)
			throws Exception {
		distribucionCarteraLogic.deleteDistribucionCartera(entity);
	}

	public void updateDistribucionCartera(DistribucionCartera entity)
			throws Exception {
		distribucionCarteraLogic.updateDistribucionCartera(entity);
	}

	public DistribucionCartera getDistribucionCartera(Long idDica)
			throws Exception {
		DistribucionCartera distribucionCartera = null;

		try {
			distribucionCartera = distribucionCarteraLogic
					.getDistribucionCartera(idDica);
		} catch (Exception e) {
			throw e;
		}

		return distribucionCartera;
	}

	public List<DistribucionCartera> findByCriteriaInDistribucionCartera(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return distribucionCarteraLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<DistribucionCartera> findPageDistribucionCartera(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return distribucionCarteraLogic.findPageDistribucionCartera(
				sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDistribucionCartera() throws Exception {
		return distribucionCarteraLogic.findTotalNumberDistribucionCartera();
	}

	public List<DistribucionCarteraDTO> getDataDistribucionCartera()
			throws Exception {
		return distribucionCarteraLogic.getDataDistribucionCartera();
	}

	public List<DivisionPolitica> getDivisionPolitica() throws Exception {
		return divisionPoliticaLogic.getDivisionPolitica();
	}

	public void saveDivisionPolitica(DivisionPolitica entity) throws Exception {
		divisionPoliticaLogic.saveDivisionPolitica(entity);
	}

	public void deleteDivisionPolitica(DivisionPolitica entity)
			throws Exception {
		divisionPoliticaLogic.deleteDivisionPolitica(entity);
	}

	public void updateDivisionPolitica(DivisionPolitica entity)
			throws Exception {
		divisionPoliticaLogic.updateDivisionPolitica(entity);
	}

	public DivisionPolitica getDivisionPolitica(Long idDipo) throws Exception {
		DivisionPolitica divisionPolitica = null;

		try {
			divisionPolitica = divisionPoliticaLogic
					.getDivisionPolitica(idDipo);
		} catch (Exception e) {
			throw e;
		}

		return divisionPolitica;
	}

	public List<DivisionPolitica> findByCriteriaInDivisionPolitica(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return divisionPoliticaLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<DivisionPolitica> findPageDivisionPolitica(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return divisionPoliticaLogic.findPageDivisionPolitica(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberDivisionPolitica() throws Exception {
		return divisionPoliticaLogic.findTotalNumberDivisionPolitica();
	}

	public List<DivisionPoliticaDTO> getDataDivisionPolitica() throws Exception {
		return divisionPoliticaLogic.getDataDivisionPolitica();
	}

	public List<Documento> getDocumento() throws Exception {
		return documentoLogic.getDocumento();
	}

	public void saveDocumento(Documento entity) throws Exception {
		documentoLogic.saveDocumento(entity);
	}

	public void deleteDocumento(Documento entity) throws Exception {
		documentoLogic.deleteDocumento(entity);
	}

	public void updateDocumento(Documento entity) throws Exception {
		documentoLogic.updateDocumento(entity);
	}

	public Documento getDocumento(Long idDocu) throws Exception {
		Documento documento = null;

		try {
			documento = documentoLogic.getDocumento(idDocu);
		} catch (Exception e) {
			throw e;
		}

		return documento;
	}

	public List<Documento> findByCriteriaInDocumento(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return documentoLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Documento> findPageDocumento(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return documentoLogic.findPageDocumento(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberDocumento() throws Exception {
		return documentoLogic.findTotalNumberDocumento();
	}

	public List<DocumentoDTO> getDataDocumento() throws Exception {
		return documentoLogic.getDataDocumento();
	}

	public List<Empresa> getEmpresa() throws Exception {
		return empresaLogic.getEmpresa();
	}

	public void saveEmpresa(Empresa entity) throws Exception {
		empresaLogic.saveEmpresa(entity);
	}

	public void deleteEmpresa(Empresa entity) throws Exception {
		empresaLogic.deleteEmpresa(entity);
	}

	public void updateEmpresa(Empresa entity) throws Exception {
		empresaLogic.updateEmpresa(entity);
	}

	public Empresa getEmpresa(Long idEmpr) throws Exception {
		Empresa empresa = null;

		try {
			empresa = empresaLogic.getEmpresa(idEmpr);
		} catch (Exception e) {
			throw e;
		}

		return empresa;
	}

	public List<Empresa> findByCriteriaInEmpresa(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return empresaLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Empresa> findPageEmpresa(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return empresaLogic.findPageEmpresa(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberEmpresa() throws Exception {
		return empresaLogic.findTotalNumberEmpresa();
	}

	public List<EmpresaDTO> getDataEmpresa() throws Exception {
		return empresaLogic.getDataEmpresa();
	}

	public List<EstadoDocumento> getEstadoDocumento() throws Exception {
		return estadoDocumentoLogic.getEstadoDocumento();
	}

	public void saveEstadoDocumento(EstadoDocumento entity) throws Exception {
		estadoDocumentoLogic.saveEstadoDocumento(entity);
	}

	public void deleteEstadoDocumento(EstadoDocumento entity) throws Exception {
		estadoDocumentoLogic.deleteEstadoDocumento(entity);
	}

	public void updateEstadoDocumento(EstadoDocumento entity) throws Exception {
		estadoDocumentoLogic.updateEstadoDocumento(entity);
	}

	public EstadoDocumento getEstadoDocumento(Long idEsdo) throws Exception {
		EstadoDocumento estadoDocumento = null;

		try {
			estadoDocumento = estadoDocumentoLogic.getEstadoDocumento(idEsdo);
		} catch (Exception e) {
			throw e;
		}

		return estadoDocumento;
	}

	public List<EstadoDocumento> findByCriteriaInEstadoDocumento(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return estadoDocumentoLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<EstadoDocumento> findPageEstadoDocumento(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return estadoDocumentoLogic.findPageEstadoDocumento(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberEstadoDocumento() throws Exception {
		return estadoDocumentoLogic.findTotalNumberEstadoDocumento();
	}

	public List<EstadoDocumentoDTO> getDataEstadoDocumento() throws Exception {
		return estadoDocumentoLogic.getDataEstadoDocumento();
	}

	public List<Fallas> getFallas() throws Exception {
		return fallasLogic.getFallas();
	}

	public void saveFallas(Fallas entity) throws Exception {
		fallasLogic.saveFallas(entity);
	}

	public void deleteFallas(Fallas entity) throws Exception {
		fallasLogic.deleteFallas(entity);
	}

	public void updateFallas(Fallas entity) throws Exception {
		fallasLogic.updateFallas(entity);
	}

	public Fallas getFallas(Long idCfal) throws Exception {
		Fallas fallas = null;

		try {
			fallas = fallasLogic.getFallas(idCfal);
		} catch (Exception e) {
			throw e;
		}

		return fallas;
	}

	public List<Fallas> findByCriteriaInFallas(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return fallasLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Fallas> findPageFallas(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return fallasLogic.findPageFallas(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberFallas() throws Exception {
		return fallasLogic.findTotalNumberFallas();
	}

	public List<FallasDTO> getDataFallas() throws Exception {
		return fallasLogic.getDataFallas();
	}

	public List<Familia> getFamilia() throws Exception {
		return familiaLogic.getFamilia();
	}

	public void saveFamilia(Familia entity) throws Exception {
		familiaLogic.saveFamilia(entity);
	}

	public void deleteFamilia(Familia entity) throws Exception {
		familiaLogic.deleteFamilia(entity);
	}

	public void updateFamilia(Familia entity) throws Exception {
		familiaLogic.updateFamilia(entity);
	}

	public Familia getFamilia(Long idFlia) throws Exception {
		Familia familia = null;

		try {
			familia = familiaLogic.getFamilia(idFlia);
		} catch (Exception e) {
			throw e;
		}

		return familia;
	}

	public List<Familia> findByCriteriaInFamilia(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return familiaLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Familia> findPageFamilia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return familiaLogic.findPageFamilia(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberFamilia() throws Exception {
		return familiaLogic.findTotalNumberFamilia();
	}

	public List<FamiliaDTO> getDataFamilia() throws Exception {
		return familiaLogic.getDataFamilia();
	}

	public List<FrecuenciaSemana> getFrecuenciaSemana() throws Exception {
		return frecuenciaSemanaLogic.getFrecuenciaSemana();
	}

	public void saveFrecuenciaSemana(FrecuenciaSemana entity) throws Exception {
		frecuenciaSemanaLogic.saveFrecuenciaSemana(entity);
	}

	public void deleteFrecuenciaSemana(FrecuenciaSemana entity)
			throws Exception {
		frecuenciaSemanaLogic.deleteFrecuenciaSemana(entity);
	}

	public void updateFrecuenciaSemana(FrecuenciaSemana entity)
			throws Exception {
		frecuenciaSemanaLogic.updateFrecuenciaSemana(entity);
	}

	public FrecuenciaSemana getFrecuenciaSemana(Long idFrcr) throws Exception {
		FrecuenciaSemana frecuenciaSemana = null;

		try {
			frecuenciaSemana = frecuenciaSemanaLogic
					.getFrecuenciaSemana(idFrcr);
		} catch (Exception e) {
			throw e;
		}

		return frecuenciaSemana;
	}

	public List<FrecuenciaSemana> findByCriteriaInFrecuenciaSemana(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return frecuenciaSemanaLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<FrecuenciaSemana> findPageFrecuenciaSemana(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return frecuenciaSemanaLogic.findPageFrecuenciaSemana(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberFrecuenciaSemana() throws Exception {
		return frecuenciaSemanaLogic.findTotalNumberFrecuenciaSemana();
	}

	public List<FrecuenciaSemanaDTO> getDataFrecuenciaSemana() throws Exception {
		return frecuenciaSemanaLogic.getDataFrecuenciaSemana();
	}

	public List<FrecuenciaVisita> getFrecuenciaVisita() throws Exception {
		return frecuenciaVisitaLogic.getFrecuenciaVisita();
	}

	public void saveFrecuenciaVisita(FrecuenciaVisita entity) throws Exception {
		frecuenciaVisitaLogic.saveFrecuenciaVisita(entity);
	}

	public void deleteFrecuenciaVisita(FrecuenciaVisita entity)
			throws Exception {
		frecuenciaVisitaLogic.deleteFrecuenciaVisita(entity);
	}

	public void updateFrecuenciaVisita(FrecuenciaVisita entity)
			throws Exception {
		frecuenciaVisitaLogic.updateFrecuenciaVisita(entity);
	}

	public FrecuenciaVisita getFrecuenciaVisita(Long idFrvi) throws Exception {
		FrecuenciaVisita frecuenciaVisita = null;

		try {
			frecuenciaVisita = frecuenciaVisitaLogic
					.getFrecuenciaVisita(idFrvi);
		} catch (Exception e) {
			throw e;
		}

		return frecuenciaVisita;
	}

	public List<FrecuenciaVisita> findByCriteriaInFrecuenciaVisita(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return frecuenciaVisitaLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<FrecuenciaVisita> findPageFrecuenciaVisita(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return frecuenciaVisitaLogic.findPageFrecuenciaVisita(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberFrecuenciaVisita() throws Exception {
		return frecuenciaVisitaLogic.findTotalNumberFrecuenciaVisita();
	}

	public List<FrecuenciaVisitaDTO> getDataFrecuenciaVisita() throws Exception {
		return frecuenciaVisitaLogic.getDataFrecuenciaVisita();
	}

	public List<Garantia> getGarantia() throws Exception {
		return garantiaLogic.getGarantia();
	}

	public void saveGarantia(Garantia entity) throws Exception {
		garantiaLogic.saveGarantia(entity);
	}

	public void deleteGarantia(Garantia entity) throws Exception {
		garantiaLogic.deleteGarantia(entity);
	}

	public void updateGarantia(Garantia entity) throws Exception {
		garantiaLogic.updateGarantia(entity);
	}

	public Garantia getGarantia(Long idGar) throws Exception {
		Garantia garantia = null;

		try {
			garantia = garantiaLogic.getGarantia(idGar);
		} catch (Exception e) {
			throw e;
		}

		return garantia;
	}

	public List<Garantia> findByCriteriaInGarantia(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return garantiaLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Garantia> findPageGarantia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return garantiaLogic.findPageGarantia(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberGarantia() throws Exception {
		return garantiaLogic.findTotalNumberGarantia();
	}

	public List<GarantiaDTO> getDataGarantia() throws Exception {
		return garantiaLogic.getDataGarantia();
	}

	public List<Grupo> getGrupo() throws Exception {
		return grupoLogic.getGrupo();
	}

	public void saveGrupo(Grupo entity) throws Exception {
		grupoLogic.saveGrupo(entity);
	}

	public void deleteGrupo(Grupo entity) throws Exception {
		grupoLogic.deleteGrupo(entity);
	}

	public void updateGrupo(Grupo entity) throws Exception {
		grupoLogic.updateGrupo(entity);
	}

	public Grupo getGrupo(Long idGrpo) throws Exception {
		Grupo grupo = null;

		try {
			grupo = grupoLogic.getGrupo(idGrpo);
		} catch (Exception e) {
			throw e;
		}

		return grupo;
	}

	public List<Grupo> findByCriteriaInGrupo(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return grupoLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Grupo> findPageGrupo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return grupoLogic.findPageGrupo(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberGrupo() throws Exception {
		return grupoLogic.findTotalNumberGrupo();
	}

	public List<GrupoDTO> getDataGrupo() throws Exception {
		return grupoLogic.getDataGrupo();
	}

	public List<GrupoReferencia> getGrupoReferencia() throws Exception {
		return grupoReferenciaLogic.getGrupoReferencia();
	}

	public void saveGrupoReferencia(GrupoReferencia entity) throws Exception {
		grupoReferenciaLogic.saveGrupoReferencia(entity);
	}

	public void deleteGrupoReferencia(GrupoReferencia entity) throws Exception {
		grupoReferenciaLogic.deleteGrupoReferencia(entity);
	}

	public void updateGrupoReferencia(GrupoReferencia entity) throws Exception {
		grupoReferenciaLogic.updateGrupoReferencia(entity);
	}

	public GrupoReferencia getGrupoReferencia(Long idGrre) throws Exception {
		GrupoReferencia grupoReferencia = null;

		try {
			grupoReferencia = grupoReferenciaLogic.getGrupoReferencia(idGrre);
		} catch (Exception e) {
			throw e;
		}

		return grupoReferencia;
	}

	public List<GrupoReferencia> findByCriteriaInGrupoReferencia(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return grupoReferenciaLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<GrupoReferencia> findPageGrupoReferencia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return grupoReferenciaLogic.findPageGrupoReferencia(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberGrupoReferencia() throws Exception {
		return grupoReferenciaLogic.findTotalNumberGrupoReferencia();
	}

	public List<GrupoReferenciaDTO> getDataGrupoReferencia() throws Exception {
		return grupoReferenciaLogic.getDataGrupoReferencia();
	}

	public List<ItemLogisticaReversiva> getItemLogisticaReversiva()
			throws Exception {
		return itemLogisticaReversivaLogic.getItemLogisticaReversiva();
	}

	public void saveItemLogisticaReversiva(ItemLogisticaReversiva entity)
			throws Exception {
		itemLogisticaReversivaLogic.saveItemLogisticaReversiva(entity);
	}

	public void deleteItemLogisticaReversiva(ItemLogisticaReversiva entity)
			throws Exception {
		itemLogisticaReversivaLogic.deleteItemLogisticaReversiva(entity);
	}

	public void updateItemLogisticaReversiva(ItemLogisticaReversiva entity)
			throws Exception {
		itemLogisticaReversivaLogic.updateItemLogisticaReversiva(entity);
	}

	public ItemLogisticaReversiva getItemLogisticaReversiva(Long idItlr)
			throws Exception {
		ItemLogisticaReversiva itemLogisticaReversiva = null;

		try {
			itemLogisticaReversiva = itemLogisticaReversivaLogic
					.getItemLogisticaReversiva(idItlr);
		} catch (Exception e) {
			throw e;
		}

		return itemLogisticaReversiva;
	}

	public List<ItemLogisticaReversiva> findByCriteriaInItemLogisticaReversiva(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return itemLogisticaReversivaLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<ItemLogisticaReversiva> findPageItemLogisticaReversiva(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return itemLogisticaReversivaLogic.findPageItemLogisticaReversiva(
				sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberItemLogisticaReversiva() throws Exception {
		return itemLogisticaReversivaLogic
				.findTotalNumberItemLogisticaReversiva();
	}

	public List<ItemLogisticaReversivaDTO> getDataItemLogisticaReversiva()
			throws Exception {
		return itemLogisticaReversivaLogic.getDataItemLogisticaReversiva();
	}

	public List<ItemRotacion> getItemRotacion() throws Exception {
		return itemRotacionLogic.getItemRotacion();
	}

	public void saveItemRotacion(ItemRotacion entity) throws Exception {
		itemRotacionLogic.saveItemRotacion(entity);
	}

	public void deleteItemRotacion(ItemRotacion entity) throws Exception {
		itemRotacionLogic.deleteItemRotacion(entity);
	}

	public void updateItemRotacion(ItemRotacion entity) throws Exception {
		itemRotacionLogic.updateItemRotacion(entity);
	}

	public ItemRotacion getItemRotacion(Long idItro) throws Exception {
		ItemRotacion itemRotacion = null;

		try {
			itemRotacion = itemRotacionLogic.getItemRotacion(idItro);
		} catch (Exception e) {
			throw e;
		}

		return itemRotacion;
	}

	public List<ItemRotacion> findByCriteriaInItemRotacion(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return itemRotacionLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<ItemRotacion> findPageItemRotacion(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return itemRotacionLogic.findPageItemRotacion(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberItemRotacion() throws Exception {
		return itemRotacionLogic.findTotalNumberItemRotacion();
	}

	public List<ItemRotacionDTO> getDataItemRotacion() throws Exception {
		return itemRotacionLogic.getDataItemRotacion();
	}

	public List<ListaPrecios> getListaPrecios() throws Exception {
		return listaPreciosLogic.getListaPrecios();
	}

	public void saveListaPrecios(ListaPrecios entity) throws Exception {
		listaPreciosLogic.saveListaPrecios(entity);
	}

	public void deleteListaPrecios(ListaPrecios entity) throws Exception {
		listaPreciosLogic.deleteListaPrecios(entity);
	}

	public void updateListaPrecios(ListaPrecios entity) throws Exception {
		listaPreciosLogic.updateListaPrecios(entity);
	}

	public ListaPrecios getListaPrecios(Long idLipr) throws Exception {
		ListaPrecios listaPrecios = null;

		try {
			listaPrecios = listaPreciosLogic.getListaPrecios(idLipr);
		} catch (Exception e) {
			throw e;
		}

		return listaPrecios;
	}

	public List<ListaPrecios> findByCriteriaInListaPrecios(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return listaPreciosLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<ListaPrecios> findPageListaPrecios(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return listaPreciosLogic.findPageListaPrecios(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberListaPrecios() throws Exception {
		return listaPreciosLogic.findTotalNumberListaPrecios();
	}

	public List<ListaPreciosDTO> getDataListaPrecios() throws Exception {
		return listaPreciosLogic.getDataListaPrecios();
	}

	public List<ListaPreciosEspeciales> getListaPreciosEspeciales()
			throws Exception {
		return listaPreciosEspecialesLogic.getListaPreciosEspeciales();
	}

	public void saveListaPreciosEspeciales(ListaPreciosEspeciales entity)
			throws Exception {
		listaPreciosEspecialesLogic.saveListaPreciosEspeciales(entity);
	}

	public void deleteListaPreciosEspeciales(ListaPreciosEspeciales entity)
			throws Exception {
		listaPreciosEspecialesLogic.deleteListaPreciosEspeciales(entity);
	}

	public void updateListaPreciosEspeciales(ListaPreciosEspeciales entity)
			throws Exception {
		listaPreciosEspecialesLogic.updateListaPreciosEspeciales(entity);
	}

	public ListaPreciosEspeciales getListaPreciosEspeciales(Long idLipe)
			throws Exception {
		ListaPreciosEspeciales listaPreciosEspeciales = null;

		try {
			listaPreciosEspeciales = listaPreciosEspecialesLogic
					.getListaPreciosEspeciales(idLipe);
		} catch (Exception e) {
			throw e;
		}

		return listaPreciosEspeciales;
	}

	public List<ListaPreciosEspeciales> findByCriteriaInListaPreciosEspeciales(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return listaPreciosEspecialesLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<ListaPreciosEspeciales> findPageListaPreciosEspeciales(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return listaPreciosEspecialesLogic.findPageListaPreciosEspeciales(
				sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberListaPreciosEspeciales() throws Exception {
		return listaPreciosEspecialesLogic
				.findTotalNumberListaPreciosEspeciales();
	}

	public List<ListaPreciosEspecialesDTO> getDataListaPreciosEspeciales()
			throws Exception {
		return listaPreciosEspecialesLogic.getDataListaPreciosEspeciales();
	}

	public List<LogisticaReversiva> getLogisticaReversiva() throws Exception {
		return logisticaReversivaLogic.getLogisticaReversiva();
	}

	public void saveLogisticaReversiva(LogisticaReversiva entity)
			throws Exception {
		logisticaReversivaLogic.saveLogisticaReversiva(entity);
	}

	public void deleteLogisticaReversiva(LogisticaReversiva entity)
			throws Exception {
		logisticaReversivaLogic.deleteLogisticaReversiva(entity);
	}

	public void updateLogisticaReversiva(LogisticaReversiva entity)
			throws Exception {
		logisticaReversivaLogic.updateLogisticaReversiva(entity);
	}

	public LogisticaReversiva getLogisticaReversiva(Long idLore)
			throws Exception {
		LogisticaReversiva logisticaReversiva = null;

		try {
			logisticaReversiva = logisticaReversivaLogic
					.getLogisticaReversiva(idLore);
		} catch (Exception e) {
			throw e;
		}

		return logisticaReversiva;
	}

	public List<LogisticaReversiva> findByCriteriaInLogisticaReversiva(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return logisticaReversivaLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<LogisticaReversiva> findPageLogisticaReversiva(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return logisticaReversivaLogic.findPageLogisticaReversiva(
				sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberLogisticaReversiva() throws Exception {
		return logisticaReversivaLogic.findTotalNumberLogisticaReversiva();
	}

	public List<LogisticaReversivaDTO> getDataLogisticaReversiva()
			throws Exception {
		return logisticaReversivaLogic.getDataLogisticaReversiva();
	}

	public List<MovimientoInventario> getMovimientoInventario()
			throws Exception {
		return movimientoInventarioLogic.getMovimientoInventario();
	}

	public void saveMovimientoInventario(MovimientoInventario entity)
			throws Exception {
		movimientoInventarioLogic.saveMovimientoInventario(entity);
	}

	public void deleteMovimientoInventario(MovimientoInventario entity)
			throws Exception {
		movimientoInventarioLogic.deleteMovimientoInventario(entity);
	}

	public void updateMovimientoInventario(MovimientoInventario entity)
			throws Exception {
		movimientoInventarioLogic.updateMovimientoInventario(entity);
	}

	public MovimientoInventario getMovimientoInventario(Long idMoin)
			throws Exception {
		MovimientoInventario movimientoInventario = null;

		try {
			movimientoInventario = movimientoInventarioLogic
					.getMovimientoInventario(idMoin);
		} catch (Exception e) {
			throw e;
		}

		return movimientoInventario;
	}

	public List<MovimientoInventario> findByCriteriaInMovimientoInventario(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return movimientoInventarioLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<MovimientoInventario> findPageMovimientoInventario(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return movimientoInventarioLogic.findPageMovimientoInventario(
				sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberMovimientoInventario() throws Exception {
		return movimientoInventarioLogic.findTotalNumberMovimientoInventario();
	}

	public List<MovimientoInventarioDTO> getDataMovimientoInventario()
			throws Exception {
		return movimientoInventarioLogic.getDataMovimientoInventario();
	}

	public List<MovimientoVendedor> getMovimientoVendedor() throws Exception {
		return movimientoVendedorLogic.getMovimientoVendedor();
	}

	public void saveMovimientoVendedor(MovimientoVendedor entity)
			throws Exception {
		movimientoVendedorLogic.saveMovimientoVendedor(entity);
	}

	public void deleteMovimientoVendedor(MovimientoVendedor entity)
			throws Exception {
		movimientoVendedorLogic.deleteMovimientoVendedor(entity);
	}

	public void updateMovimientoVendedor(MovimientoVendedor entity)
			throws Exception {
		movimientoVendedorLogic.updateMovimientoVendedor(entity);
	}

	public MovimientoVendedor getMovimientoVendedor(Long idMven)
			throws Exception {
		MovimientoVendedor movimientoVendedor = null;

		try {
			movimientoVendedor = movimientoVendedorLogic
					.getMovimientoVendedor(idMven);
		} catch (Exception e) {
			throw e;
		}

		return movimientoVendedor;
	}

	public List<MovimientoVendedor> findByCriteriaInMovimientoVendedor(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return movimientoVendedorLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<MovimientoVendedor> findPageMovimientoVendedor(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return movimientoVendedorLogic.findPageMovimientoVendedor(
				sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberMovimientoVendedor() throws Exception {
		return movimientoVendedorLogic.findTotalNumberMovimientoVendedor();
	}

	public List<MovimientoVendedorDTO> getDataMovimientoVendedor()
			throws Exception {
		return movimientoVendedorLogic.getDataMovimientoVendedor();
	}

	public List<Multifamilia> getMultifamilia() throws Exception {
		return multifamiliaLogic.getMultifamilia();
	}

	public void saveMultifamilia(Multifamilia entity) throws Exception {
		multifamiliaLogic.saveMultifamilia(entity);
	}

	public void deleteMultifamilia(Multifamilia entity) throws Exception {
		multifamiliaLogic.deleteMultifamilia(entity);
	}

	public void updateMultifamilia(Multifamilia entity) throws Exception {
		multifamiliaLogic.updateMultifamilia(entity);
	}

	public Multifamilia getMultifamilia(Long idMufa) throws Exception {
		Multifamilia multifamilia = null;

		try {
			multifamilia = multifamiliaLogic.getMultifamilia(idMufa);
		} catch (Exception e) {
			throw e;
		}

		return multifamilia;
	}

	public List<Multifamilia> findByCriteriaInMultifamilia(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return multifamiliaLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Multifamilia> findPageMultifamilia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return multifamiliaLogic.findPageMultifamilia(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberMultifamilia() throws Exception {
		return multifamiliaLogic.findTotalNumberMultifamilia();
	}

	public List<MultifamiliaDTO> getDataMultifamilia() throws Exception {
		return multifamiliaLogic.getDataMultifamilia();
	}

	public List<OrdenesDeCompra> getOrdenesDeCompra() throws Exception {
		return ordenesDeCompraLogic.getOrdenesDeCompra();
	}

	public void saveOrdenesDeCompra(OrdenesDeCompra entity) throws Exception {
		ordenesDeCompraLogic.saveOrdenesDeCompra(entity);
	}

	public void deleteOrdenesDeCompra(OrdenesDeCompra entity) throws Exception {
		ordenesDeCompraLogic.deleteOrdenesDeCompra(entity);
	}

	public void updateOrdenesDeCompra(OrdenesDeCompra entity) throws Exception {
		ordenesDeCompraLogic.updateOrdenesDeCompra(entity);
	}

	public OrdenesDeCompra getOrdenesDeCompra(Long idOrdc) throws Exception {
		OrdenesDeCompra ordenesDeCompra = null;

		try {
			ordenesDeCompra = ordenesDeCompraLogic.getOrdenesDeCompra(idOrdc);
		} catch (Exception e) {
			throw e;
		}

		return ordenesDeCompra;
	}

	public List<OrdenesDeCompra> findByCriteriaInOrdenesDeCompra(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return ordenesDeCompraLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<OrdenesDeCompra> findPageOrdenesDeCompra(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return ordenesDeCompraLogic.findPageOrdenesDeCompra(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberOrdenesDeCompra() throws Exception {
		return ordenesDeCompraLogic.findTotalNumberOrdenesDeCompra();
	}

	public List<OrdenesDeCompraDTO> getDataOrdenesDeCompra() throws Exception {
		return ordenesDeCompraLogic.getDataOrdenesDeCompra();
	}

	public List<Pedido> getPedido() throws Exception {
		return pedidoLogic.getPedido();
	}

	public void savePedido(Pedido entity) throws Exception {
		pedidoLogic.savePedido(entity);
	}

	public void deletePedido(Pedido entity) throws Exception {
		pedidoLogic.deletePedido(entity);
	}

	public void updatePedido(Pedido entity) throws Exception {
		pedidoLogic.updatePedido(entity);
	}

	public Pedido getPedido(Long idPddo) throws Exception {
		Pedido pedido = null;

		try {
			pedido = pedidoLogic.getPedido(idPddo);
		} catch (Exception e) {
			throw e;
		}

		return pedido;
	}

	public List<Pedido> findByCriteriaInPedido(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return pedidoLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Pedido> findPagePedido(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return pedidoLogic.findPagePedido(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberPedido() throws Exception {
		return pedidoLogic.findTotalNumberPedido();
	}

	public List<PedidoDTO> getDataPedido() throws Exception {
		return pedidoLogic.getDataPedido();
	}

	public List<PeriodoGarantia> getPeriodoGarantia() throws Exception {
		return periodoGarantiaLogic.getPeriodoGarantia();
	}

	public void savePeriodoGarantia(PeriodoGarantia entity) throws Exception {
		periodoGarantiaLogic.savePeriodoGarantia(entity);
	}

	public void deletePeriodoGarantia(PeriodoGarantia entity) throws Exception {
		periodoGarantiaLogic.deletePeriodoGarantia(entity);
	}

	public void updatePeriodoGarantia(PeriodoGarantia entity) throws Exception {
		periodoGarantiaLogic.updatePeriodoGarantia(entity);
	}

	public PeriodoGarantia getPeriodoGarantia(Long idPega) throws Exception {
		PeriodoGarantia periodoGarantia = null;

		try {
			periodoGarantia = periodoGarantiaLogic.getPeriodoGarantia(idPega);
		} catch (Exception e) {
			throw e;
		}

		return periodoGarantia;
	}

	public List<PeriodoGarantia> findByCriteriaInPeriodoGarantia(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return periodoGarantiaLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<PeriodoGarantia> findPagePeriodoGarantia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return periodoGarantiaLogic.findPagePeriodoGarantia(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberPeriodoGarantia() throws Exception {
		return periodoGarantiaLogic.findTotalNumberPeriodoGarantia();
	}

	public List<PeriodoGarantiaDTO> getDataPeriodoGarantia() throws Exception {
		return periodoGarantiaLogic.getDataPeriodoGarantia();
	}

	public List<Persona> getPersona() throws Exception {
		return personaLogic.getPersona();
	}

	public void savePersona(Persona entity) throws Exception {
		personaLogic.savePersona(entity);
	}

	public void deletePersona(Persona entity) throws Exception {
		personaLogic.deletePersona(entity);
	}

	public void updatePersona(Persona entity) throws Exception {
		personaLogic.updatePersona(entity);
	}

	public Persona getPersona(Long idPers) throws Exception {
		Persona persona = null;

		try {
			persona = personaLogic.getPersona(idPers);
		} catch (Exception e) {
			throw e;
		}

		return persona;
	}

	public List<Persona> findByCriteriaInPersona(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return personaLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Persona> findPagePersona(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return personaLogic.findPagePersona(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberPersona() throws Exception {
		return personaLogic.findTotalNumberPersona();
	}

	public List<PersonaDTO> getDataPersona() throws Exception {
		return personaLogic.getDataPersona();
	}

	public List<PresupuestoCartera> getPresupuestoCartera() throws Exception {
		return presupuestoCarteraLogic.getPresupuestoCartera();
	}

	public void savePresupuestoCartera(PresupuestoCartera entity)
			throws Exception {
		presupuestoCarteraLogic.savePresupuestoCartera(entity);
	}

	public void deletePresupuestoCartera(PresupuestoCartera entity)
			throws Exception {
		presupuestoCarteraLogic.deletePresupuestoCartera(entity);
	}

	public void updatePresupuestoCartera(PresupuestoCartera entity)
			throws Exception {
		presupuestoCarteraLogic.updatePresupuestoCartera(entity);
	}

	public PresupuestoCartera getPresupuestoCartera(Long idPrca)
			throws Exception {
		PresupuestoCartera presupuestoCartera = null;

		try {
			presupuestoCartera = presupuestoCarteraLogic
					.getPresupuestoCartera(idPrca);
		} catch (Exception e) {
			throw e;
		}

		return presupuestoCartera;
	}

	public List<PresupuestoCartera> findByCriteriaInPresupuestoCartera(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return presupuestoCarteraLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<PresupuestoCartera> findPagePresupuestoCartera(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return presupuestoCarteraLogic.findPagePresupuestoCartera(
				sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberPresupuestoCartera() throws Exception {
		return presupuestoCarteraLogic.findTotalNumberPresupuestoCartera();
	}

	public List<PresupuestoCarteraDTO> getDataPresupuestoCartera()
			throws Exception {
		return presupuestoCarteraLogic.getDataPresupuestoCartera();
	}

	public List<PresupuestoVentas> getPresupuestoVentas() throws Exception {
		return presupuestoVentasLogic.getPresupuestoVentas();
	}

	public void savePresupuestoVentas(PresupuestoVentas entity)
			throws Exception {
		presupuestoVentasLogic.savePresupuestoVentas(entity);
	}

	public void deletePresupuestoVentas(PresupuestoVentas entity)
			throws Exception {
		presupuestoVentasLogic.deletePresupuestoVentas(entity);
	}

	public void updatePresupuestoVentas(PresupuestoVentas entity)
			throws Exception {
		presupuestoVentasLogic.updatePresupuestoVentas(entity);
	}

	public PresupuestoVentas getPresupuestoVentas(Long idPven) throws Exception {
		PresupuestoVentas presupuestoVentas = null;

		try {
			presupuestoVentas = presupuestoVentasLogic
					.getPresupuestoVentas(idPven);
		} catch (Exception e) {
			throw e;
		}

		return presupuestoVentas;
	}

	public List<PresupuestoVentas> findByCriteriaInPresupuestoVentas(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return presupuestoVentasLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<PresupuestoVentas> findPagePresupuestoVentas(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return presupuestoVentasLogic.findPagePresupuestoVentas(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberPresupuestoVentas() throws Exception {
		return presupuestoVentasLogic.findTotalNumberPresupuestoVentas();
	}

	public List<PresupuestoVentasDTO> getDataPresupuestoVentas()
			throws Exception {
		return presupuestoVentasLogic.getDataPresupuestoVentas();
	}

	public List<ProgramacionAdicional> getProgramacionAdicional()
			throws Exception {
		return programacionAdicionalLogic.getProgramacionAdicional();
	}

	public void saveProgramacionAdicional(ProgramacionAdicional entity)
			throws Exception {
		programacionAdicionalLogic.saveProgramacionAdicional(entity);
	}

	public void deleteProgramacionAdicional(ProgramacionAdicional entity)
			throws Exception {
		programacionAdicionalLogic.deleteProgramacionAdicional(entity);
	}

	public void updateProgramacionAdicional(ProgramacionAdicional entity)
			throws Exception {
		programacionAdicionalLogic.updateProgramacionAdicional(entity);
	}

	public ProgramacionAdicional getProgramacionAdicional(Long idPrad)
			throws Exception {
		ProgramacionAdicional programacionAdicional = null;

		try {
			programacionAdicional = programacionAdicionalLogic
					.getProgramacionAdicional(idPrad);
		} catch (Exception e) {
			throw e;
		}

		return programacionAdicional;
	}

	public List<ProgramacionAdicional> findByCriteriaInProgramacionAdicional(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return programacionAdicionalLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<ProgramacionAdicional> findPageProgramacionAdicional(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return programacionAdicionalLogic.findPageProgramacionAdicional(
				sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberProgramacionAdicional() throws Exception {
		return programacionAdicionalLogic
				.findTotalNumberProgramacionAdicional();
	}

	public List<ProgramacionAdicionalDTO> getDataProgramacionAdicional()
			throws Exception {
		return programacionAdicionalLogic.getDataProgramacionAdicional();
	}

	public List<ProgramacionVisitas> getProgramacionVisitas() throws Exception {
		return programacionVisitasLogic.getProgramacionVisitas();
	}

	public void saveProgramacionVisitas(ProgramacionVisitas entity)
			throws Exception {
		programacionVisitasLogic.saveProgramacionVisitas(entity);
	}

	public void deleteProgramacionVisitas(ProgramacionVisitas entity)
			throws Exception {
		programacionVisitasLogic.deleteProgramacionVisitas(entity);
	}

	public void updateProgramacionVisitas(ProgramacionVisitas entity)
			throws Exception {
		programacionVisitasLogic.updateProgramacionVisitas(entity);
	}

	public ProgramacionVisitas getProgramacionVisitas(Long idPrvi)
			throws Exception {
		ProgramacionVisitas programacionVisitas = null;

		try {
			programacionVisitas = programacionVisitasLogic
					.getProgramacionVisitas(idPrvi);
		} catch (Exception e) {
			throw e;
		}

		return programacionVisitas;
	}

	public List<ProgramacionVisitas> findByCriteriaInProgramacionVisitas(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return programacionVisitasLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<ProgramacionVisitas> findPageProgramacionVisitas(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return programacionVisitasLogic.findPageProgramacionVisitas(
				sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberProgramacionVisitas() throws Exception {
		return programacionVisitasLogic.findTotalNumberProgramacionVisitas();
	}

	public List<ProgramacionVisitasDTO> getDataProgramacionVisitas()
			throws Exception {
		return programacionVisitasLogic.getDataProgramacionVisitas();
	}

	public List<PronosticoVenta> getPronosticoVenta() throws Exception {
		return pronosticoVentaLogic.getPronosticoVenta();
	}

	public void savePronosticoVenta(PronosticoVenta entity) throws Exception {
		pronosticoVentaLogic.savePronosticoVenta(entity);
	}

	public void deletePronosticoVenta(PronosticoVenta entity) throws Exception {
		pronosticoVentaLogic.deletePronosticoVenta(entity);
	}

	public void updatePronosticoVenta(PronosticoVenta entity) throws Exception {
		pronosticoVentaLogic.updatePronosticoVenta(entity);
	}

	public PronosticoVenta getPronosticoVenta(Long idPtcv) throws Exception {
		PronosticoVenta pronosticoVenta = null;

		try {
			pronosticoVenta = pronosticoVentaLogic.getPronosticoVenta(idPtcv);
		} catch (Exception e) {
			throw e;
		}

		return pronosticoVenta;
	}

	public List<PronosticoVenta> findByCriteriaInPronosticoVenta(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return pronosticoVentaLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<PronosticoVenta> findPagePronosticoVenta(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return pronosticoVentaLogic.findPagePronosticoVenta(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberPronosticoVenta() throws Exception {
		return pronosticoVentaLogic.findTotalNumberPronosticoVenta();
	}

	public List<PronosticoVentaDTO> getDataPronosticoVenta() throws Exception {
		return pronosticoVentaLogic.getDataPronosticoVenta();
	}

	public List<Proveedor> getProveedor() throws Exception {
		return proveedorLogic.getProveedor();
	}

	public void saveProveedor(Proveedor entity) throws Exception {
		proveedorLogic.saveProveedor(entity);
	}

	public void deleteProveedor(Proveedor entity) throws Exception {
		proveedorLogic.deleteProveedor(entity);
	}

	public void updateProveedor(Proveedor entity) throws Exception {
		proveedorLogic.updateProveedor(entity);
	}

	public Proveedor getProveedor(Long idProv) throws Exception {
		Proveedor proveedor = null;

		try {
			proveedor = proveedorLogic.getProveedor(idProv);
		} catch (Exception e) {
			throw e;
		}

		return proveedor;
	}

	public List<Proveedor> findByCriteriaInProveedor(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return proveedorLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Proveedor> findPageProveedor(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return proveedorLogic.findPageProveedor(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberProveedor() throws Exception {
		return proveedorLogic.findTotalNumberProveedor();
	}

	public List<ProveedorDTO> getDataProveedor() throws Exception {
		return proveedorLogic.getDataProveedor();
	}

	public List<RboDetalleDocumentos> getRboDetalleDocumentos()
			throws Exception {
		return rboDetalleDocumentosLogic.getRboDetalleDocumentos();
	}

	public void saveRboDetalleDocumentos(RboDetalleDocumentos entity)
			throws Exception {
		rboDetalleDocumentosLogic.saveRboDetalleDocumentos(entity);
	}

	public void deleteRboDetalleDocumentos(RboDetalleDocumentos entity)
			throws Exception {
		rboDetalleDocumentosLogic.deleteRboDetalleDocumentos(entity);
	}

	public void updateRboDetalleDocumentos(RboDetalleDocumentos entity)
			throws Exception {
		rboDetalleDocumentosLogic.updateRboDetalleDocumentos(entity);
	}

	public RboDetalleDocumentos getRboDetalleDocumentos(Long idRddo)
			throws Exception {
		RboDetalleDocumentos rboDetalleDocumentos = null;

		try {
			rboDetalleDocumentos = rboDetalleDocumentosLogic
					.getRboDetalleDocumentos(idRddo);
		} catch (Exception e) {
			throw e;
		}

		return rboDetalleDocumentos;
	}

	public List<RboDetalleDocumentos> findByCriteriaInRboDetalleDocumentos(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return rboDetalleDocumentosLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<RboDetalleDocumentos> findPageRboDetalleDocumentos(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return rboDetalleDocumentosLogic.findPageRboDetalleDocumentos(
				sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberRboDetalleDocumentos() throws Exception {
		return rboDetalleDocumentosLogic.findTotalNumberRboDetalleDocumentos();
	}

	public List<RboDetalleDocumentosDTO> getDataRboDetalleDocumentos()
			throws Exception {
		return rboDetalleDocumentosLogic.getDataRboDetalleDocumentos();
	}

	public List<RboDetalleFormasPago> getRboDetalleFormasPago()
			throws Exception {
		return rboDetalleFormasPagoLogic.getRboDetalleFormasPago();
	}

	public void saveRboDetalleFormasPago(RboDetalleFormasPago entity)
			throws Exception {
		rboDetalleFormasPagoLogic.saveRboDetalleFormasPago(entity);
	}

	public void deleteRboDetalleFormasPago(RboDetalleFormasPago entity)
			throws Exception {
		rboDetalleFormasPagoLogic.deleteRboDetalleFormasPago(entity);
	}

	public void updateRboDetalleFormasPago(RboDetalleFormasPago entity)
			throws Exception {
		rboDetalleFormasPagoLogic.updateRboDetalleFormasPago(entity);
	}

	public RboDetalleFormasPago getRboDetalleFormasPago(Long idRdfp)
			throws Exception {
		RboDetalleFormasPago rboDetalleFormasPago = null;

		try {
			rboDetalleFormasPago = rboDetalleFormasPagoLogic
					.getRboDetalleFormasPago(idRdfp);
		} catch (Exception e) {
			throw e;
		}

		return rboDetalleFormasPago;
	}

	public List<RboDetalleFormasPago> findByCriteriaInRboDetalleFormasPago(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return rboDetalleFormasPagoLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<RboDetalleFormasPago> findPageRboDetalleFormasPago(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return rboDetalleFormasPagoLogic.findPageRboDetalleFormasPago(
				sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberRboDetalleFormasPago() throws Exception {
		return rboDetalleFormasPagoLogic.findTotalNumberRboDetalleFormasPago();
	}

	public List<RboDetalleFormasPagoDTO> getDataRboDetalleFormasPago()
			throws Exception {
		return rboDetalleFormasPagoLogic.getDataRboDetalleFormasPago();
	}

	public List<Recibo> getRecibo() throws Exception {
		return reciboLogic.getRecibo();
	}

	public void saveRecibo(Recibo entity) throws Exception {
		reciboLogic.saveRecibo(entity);
	}

	public void deleteRecibo(Recibo entity) throws Exception {
		reciboLogic.deleteRecibo(entity);
	}

	public void updateRecibo(Recibo entity) throws Exception {
		reciboLogic.updateRecibo(entity);
	}

	public Recibo getRecibo(Long idRcbo) throws Exception {
		Recibo recibo = null;

		try {
			recibo = reciboLogic.getRecibo(idRcbo);
		} catch (Exception e) {
			throw e;
		}

		return recibo;
	}

	public List<Recibo> findByCriteriaInRecibo(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return reciboLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Recibo> findPageRecibo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return reciboLogic.findPageRecibo(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberRecibo() throws Exception {
		return reciboLogic.findTotalNumberRecibo();
	}

	public List<ReciboDTO> getDataRecibo() throws Exception {
		return reciboLogic.getDataRecibo();
	}

	public List<Referencia> getReferencia() throws Exception {
		return referenciaLogic.getReferencia();
	}

	public void saveReferencia(Referencia entity) throws Exception {
		referenciaLogic.saveReferencia(entity);
	}

	public void deleteReferencia(Referencia entity) throws Exception {
		referenciaLogic.deleteReferencia(entity);
	}

	public void updateReferencia(Referencia entity) throws Exception {
		referenciaLogic.updateReferencia(entity);
	}

	public Referencia getReferencia(Long idRefe) throws Exception {
		Referencia referencia = null;

		try {
			referencia = referenciaLogic.getReferencia(idRefe);
		} catch (Exception e) {
			throw e;
		}

		return referencia;
	}

	public List<Referencia> findByCriteriaInReferencia(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return referenciaLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Referencia> findPageReferencia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return referenciaLogic.findPageReferencia(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberReferencia() throws Exception {
		return referenciaLogic.findTotalNumberReferencia();
	}

	public List<ReferenciaDTO> getDataReferencia() throws Exception {
		return referenciaLogic.getDataReferencia();
	}

	public List<ReferenciaSucursal> getReferenciaSucursal() throws Exception {
		return referenciaSucursalLogic.getReferenciaSucursal();
	}

	public void saveReferenciaSucursal(ReferenciaSucursal entity)
			throws Exception {
		referenciaSucursalLogic.saveReferenciaSucursal(entity);
	}

	public void deleteReferenciaSucursal(ReferenciaSucursal entity)
			throws Exception {
		referenciaSucursalLogic.deleteReferenciaSucursal(entity);
	}

	public void updateReferenciaSucursal(ReferenciaSucursal entity)
			throws Exception {
		referenciaSucursalLogic.updateReferenciaSucursal(entity);
	}

	public ReferenciaSucursal getReferenciaSucursal(Long idResu)
			throws Exception {
		ReferenciaSucursal referenciaSucursal = null;

		try {
			referenciaSucursal = referenciaSucursalLogic
					.getReferenciaSucursal(idResu);
		} catch (Exception e) {
			throw e;
		}

		return referenciaSucursal;
	}

	public List<ReferenciaSucursal> findByCriteriaInReferenciaSucursal(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return referenciaSucursalLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<ReferenciaSucursal> findPageReferenciaSucursal(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return referenciaSucursalLogic.findPageReferenciaSucursal(
				sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberReferenciaSucursal() throws Exception {
		return referenciaSucursalLogic.findTotalNumberReferenciaSucursal();
	}

	public List<ReferenciaSucursalDTO> getDataReferenciaSucursal()
			throws Exception {
		return referenciaSucursalLogic.getDataReferenciaSucursal();
	}

	public List<RegionalGeografica> getRegionalGeografica() throws Exception {
		return regionalGeograficaLogic.getRegionalGeografica();
	}

	public void saveRegionalGeografica(RegionalGeografica entity)
			throws Exception {
		regionalGeograficaLogic.saveRegionalGeografica(entity);
	}

	public void deleteRegionalGeografica(RegionalGeografica entity)
			throws Exception {
		regionalGeograficaLogic.deleteRegionalGeografica(entity);
	}

	public void updateRegionalGeografica(RegionalGeografica entity)
			throws Exception {
		regionalGeograficaLogic.updateRegionalGeografica(entity);
	}

	public RegionalGeografica getRegionalGeografica(Long idRege)
			throws Exception {
		RegionalGeografica regionalGeografica = null;

		try {
			regionalGeografica = regionalGeograficaLogic
					.getRegionalGeografica(idRege);
		} catch (Exception e) {
			throw e;
		}

		return regionalGeografica;
	}

	public List<RegionalGeografica> findByCriteriaInRegionalGeografica(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return regionalGeograficaLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<RegionalGeografica> findPageRegionalGeografica(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return regionalGeograficaLogic.findPageRegionalGeografica(
				sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberRegionalGeografica() throws Exception {
		return regionalGeograficaLogic.findTotalNumberRegionalGeografica();
	}

	public List<RegionalGeograficaDTO> getDataRegionalGeografica()
			throws Exception {
		return regionalGeograficaLogic.getDataRegionalGeografica();
	}

	public List<RelacionComercial> getRelacionComercial() throws Exception {
		return relacionComercialLogic.getRelacionComercial();
	}

	public void saveRelacionComercial(RelacionComercial entity)
			throws Exception {
		relacionComercialLogic.saveRelacionComercial(entity);
	}

	public void deleteRelacionComercial(RelacionComercial entity)
			throws Exception {
		relacionComercialLogic.deleteRelacionComercial(entity);
	}

	public void updateRelacionComercial(RelacionComercial entity)
			throws Exception {
		relacionComercialLogic.updateRelacionComercial(entity);
	}

	public RelacionComercial getRelacionComercial(Long idReco) throws Exception {
		RelacionComercial relacionComercial = null;

		try {
			relacionComercial = relacionComercialLogic
					.getRelacionComercial(idReco);
		} catch (Exception e) {
			throw e;
		}

		return relacionComercial;
	}

	public List<RelacionComercial> findByCriteriaInRelacionComercial(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return relacionComercialLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<RelacionComercial> findPageRelacionComercial(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return relacionComercialLogic.findPageRelacionComercial(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberRelacionComercial() throws Exception {
		return relacionComercialLogic.findTotalNumberRelacionComercial();
	}

	public List<RelacionComercialDTO> getDataRelacionComercial()
			throws Exception {
		return relacionComercialLogic.getDataRelacionComercial();
	}

	public List<RutaDistribucion> getRutaDistribucion() throws Exception {
		return rutaDistribucionLogic.getRutaDistribucion();
	}

	public void saveRutaDistribucion(RutaDistribucion entity) throws Exception {
		rutaDistribucionLogic.saveRutaDistribucion(entity);
	}

	public void deleteRutaDistribucion(RutaDistribucion entity)
			throws Exception {
		rutaDistribucionLogic.deleteRutaDistribucion(entity);
	}

	public void updateRutaDistribucion(RutaDistribucion entity)
			throws Exception {
		rutaDistribucionLogic.updateRutaDistribucion(entity);
	}

	public RutaDistribucion getRutaDistribucion(Long idRudi) throws Exception {
		RutaDistribucion rutaDistribucion = null;

		try {
			rutaDistribucion = rutaDistribucionLogic
					.getRutaDistribucion(idRudi);
		} catch (Exception e) {
			throw e;
		}

		return rutaDistribucion;
	}

	public List<RutaDistribucion> findByCriteriaInRutaDistribucion(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return rutaDistribucionLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<RutaDistribucion> findPageRutaDistribucion(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return rutaDistribucionLogic.findPageRutaDistribucion(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberRutaDistribucion() throws Exception {
		return rutaDistribucionLogic.findTotalNumberRutaDistribucion();
	}

	public List<RutaDistribucionDTO> getDataRutaDistribucion() throws Exception {
		return rutaDistribucionLogic.getDataRutaDistribucion();
	}

	public List<RutaRelacionComercial> getRutaRelacionComercial()
			throws Exception {
		return rutaRelacionComercialLogic.getRutaRelacionComercial();
	}

	public void saveRutaRelacionComercial(RutaRelacionComercial entity)
			throws Exception {
		rutaRelacionComercialLogic.saveRutaRelacionComercial(entity);
	}

	public void deleteRutaRelacionComercial(RutaRelacionComercial entity)
			throws Exception {
		rutaRelacionComercialLogic.deleteRutaRelacionComercial(entity);
	}

	public void updateRutaRelacionComercial(RutaRelacionComercial entity)
			throws Exception {
		rutaRelacionComercialLogic.updateRutaRelacionComercial(entity);
	}

	public RutaRelacionComercial getRutaRelacionComercial(Long idRrec)
			throws Exception {
		RutaRelacionComercial rutaRelacionComercial = null;

		try {
			rutaRelacionComercial = rutaRelacionComercialLogic
					.getRutaRelacionComercial(idRrec);
		} catch (Exception e) {
			throw e;
		}

		return rutaRelacionComercial;
	}

	public List<RutaRelacionComercial> findByCriteriaInRutaRelacionComercial(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return rutaRelacionComercialLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<RutaRelacionComercial> findPageRutaRelacionComercial(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return rutaRelacionComercialLogic.findPageRutaRelacionComercial(
				sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberRutaRelacionComercial() throws Exception {
		return rutaRelacionComercialLogic
				.findTotalNumberRutaRelacionComercial();
	}

	public List<RutaRelacionComercialDTO> getDataRutaRelacionComercial()
			throws Exception {
		return rutaRelacionComercialLogic.getDataRutaRelacionComercial();
	}

	public List<SaldoInicialInventario> getSaldoInicialInventario()
			throws Exception {
		return saldoInicialInventarioLogic.getSaldoInicialInventario();
	}

	public void saveSaldoInicialInventario(SaldoInicialInventario entity)
			throws Exception {
		saldoInicialInventarioLogic.saveSaldoInicialInventario(entity);
	}

	public void deleteSaldoInicialInventario(SaldoInicialInventario entity)
			throws Exception {
		saldoInicialInventarioLogic.deleteSaldoInicialInventario(entity);
	}

	public void updateSaldoInicialInventario(SaldoInicialInventario entity)
			throws Exception {
		saldoInicialInventarioLogic.updateSaldoInicialInventario(entity);
	}

	public SaldoInicialInventario getSaldoInicialInventario(Long idSini)
			throws Exception {
		SaldoInicialInventario saldoInicialInventario = null;

		try {
			saldoInicialInventario = saldoInicialInventarioLogic
					.getSaldoInicialInventario(idSini);
		} catch (Exception e) {
			throw e;
		}

		return saldoInicialInventario;
	}

	public List<SaldoInicialInventario> findByCriteriaInSaldoInicialInventario(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return saldoInicialInventarioLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<SaldoInicialInventario> findPageSaldoInicialInventario(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return saldoInicialInventarioLogic.findPageSaldoInicialInventario(
				sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberSaldoInicialInventario() throws Exception {
		return saldoInicialInventarioLogic
				.findTotalNumberSaldoInicialInventario();
	}

	public List<SaldoInicialInventarioDTO> getDataSaldoInicialInventario()
			throws Exception {
		return saldoInicialInventarioLogic.getDataSaldoInicialInventario();
	}

	public List<Semana> getSemana() throws Exception {
		return semanaLogic.getSemana();
	}

	public void saveSemana(Semana entity) throws Exception {
		semanaLogic.saveSemana(entity);
	}

	public void deleteSemana(Semana entity) throws Exception {
		semanaLogic.deleteSemana(entity);
	}

	public void updateSemana(Semana entity) throws Exception {
		semanaLogic.updateSemana(entity);
	}

	public Semana getSemana(Long idSema) throws Exception {
		Semana semana = null;

		try {
			semana = semanaLogic.getSemana(idSema);
		} catch (Exception e) {
			throw e;
		}

		return semana;
	}

	public List<Semana> findByCriteriaInSemana(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return semanaLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Semana> findPageSemana(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return semanaLogic.findPageSemana(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberSemana() throws Exception {
		return semanaLogic.findTotalNumberSemana();
	}

	public List<SemanaDTO> getDataSemana() throws Exception {
		return semanaLogic.getDataSemana();
	}

	public List<SolicitudCambio> getSolicitudCambio() throws Exception {
		return solicitudCambioLogic.getSolicitudCambio();
	}

	public void saveSolicitudCambio(SolicitudCambio entity) throws Exception {
		solicitudCambioLogic.saveSolicitudCambio(entity);
	}

	public void deleteSolicitudCambio(SolicitudCambio entity) throws Exception {
		solicitudCambioLogic.deleteSolicitudCambio(entity);
	}

	public void updateSolicitudCambio(SolicitudCambio entity) throws Exception {
		solicitudCambioLogic.updateSolicitudCambio(entity);
	}

	public SolicitudCambio getSolicitudCambio(Long idSocb) throws Exception {
		SolicitudCambio solicitudCambio = null;

		try {
			solicitudCambio = solicitudCambioLogic.getSolicitudCambio(idSocb);
		} catch (Exception e) {
			throw e;
		}

		return solicitudCambio;
	}

	public List<SolicitudCambio> findByCriteriaInSolicitudCambio(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return solicitudCambioLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<SolicitudCambio> findPageSolicitudCambio(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return solicitudCambioLogic.findPageSolicitudCambio(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberSolicitudCambio() throws Exception {
		return solicitudCambioLogic.findTotalNumberSolicitudCambio();
	}

	public List<SolicitudCambioDTO> getDataSolicitudCambio() throws Exception {
		return solicitudCambioLogic.getDataSolicitudCambio();
	}

	public List<SolicitudCampo> getSolicitudCampo() throws Exception {
		return solicitudCampoLogic.getSolicitudCampo();
	}

	public void saveSolicitudCampo(SolicitudCampo entity) throws Exception {
		solicitudCampoLogic.saveSolicitudCampo(entity);
	}

	public void deleteSolicitudCampo(SolicitudCampo entity) throws Exception {
		solicitudCampoLogic.deleteSolicitudCampo(entity);
	}

	public void updateSolicitudCampo(SolicitudCampo entity) throws Exception {
		solicitudCampoLogic.updateSolicitudCampo(entity);
	}

	public SolicitudCampo getSolicitudCampo(Long idSoca) throws Exception {
		SolicitudCampo solicitudCampo = null;

		try {
			solicitudCampo = solicitudCampoLogic.getSolicitudCampo(idSoca);
		} catch (Exception e) {
			throw e;
		}

		return solicitudCampo;
	}

	public List<SolicitudCampo> findByCriteriaInSolicitudCampo(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return solicitudCampoLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<SolicitudCampo> findPageSolicitudCampo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return solicitudCampoLogic.findPageSolicitudCampo(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberSolicitudCampo() throws Exception {
		return solicitudCampoLogic.findTotalNumberSolicitudCampo();
	}

	public List<SolicitudCampoDTO> getDataSolicitudCampo() throws Exception {
		return solicitudCampoLogic.getDataSolicitudCampo();
	}

	public List<StockInventarioMensual> getStockInventarioMensual()
			throws Exception {
		return stockInventarioMensualLogic.getStockInventarioMensual();
	}

	public void saveStockInventarioMensual(StockInventarioMensual entity)
			throws Exception {
		stockInventarioMensualLogic.saveStockInventarioMensual(entity);
	}

	public void deleteStockInventarioMensual(StockInventarioMensual entity)
			throws Exception {
		stockInventarioMensualLogic.deleteStockInventarioMensual(entity);
	}

	public void updateStockInventarioMensual(StockInventarioMensual entity)
			throws Exception {
		stockInventarioMensualLogic.updateStockInventarioMensual(entity);
	}

	public StockInventarioMensual getStockInventarioMensual(Long idStin)
			throws Exception {
		StockInventarioMensual stockInventarioMensual = null;

		try {
			stockInventarioMensual = stockInventarioMensualLogic
					.getStockInventarioMensual(idStin);
		} catch (Exception e) {
			throw e;
		}

		return stockInventarioMensual;
	}

	public List<StockInventarioMensual> findByCriteriaInStockInventarioMensual(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return stockInventarioMensualLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<StockInventarioMensual> findPageStockInventarioMensual(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return stockInventarioMensualLogic.findPageStockInventarioMensual(
				sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberStockInventarioMensual() throws Exception {
		return stockInventarioMensualLogic
				.findTotalNumberStockInventarioMensual();
	}

	public List<StockInventarioMensualDTO> getDataStockInventarioMensual()
			throws Exception {
		return stockInventarioMensualLogic.getDataStockInventarioMensual();
	}

	public List<Sucursal> getSucursal() throws Exception {
		return sucursalLogic.getSucursal();
	}

	public void saveSucursal(Sucursal entity) throws Exception {
		sucursalLogic.saveSucursal(entity);
	}

	public void deleteSucursal(Sucursal entity) throws Exception {
		sucursalLogic.deleteSucursal(entity);
	}

	public void updateSucursal(Sucursal entity) throws Exception {
		sucursalLogic.updateSucursal(entity);
	}

	public Sucursal getSucursal(Long idSucu) throws Exception {
		Sucursal sucursal = null;

		try {
			sucursal = sucursalLogic.getSucursal(idSucu);
		} catch (Exception e) {
			throw e;
		}

		return sucursal;
	}

	public List<Sucursal> findByCriteriaInSucursal(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return sucursalLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Sucursal> findPageSucursal(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return sucursalLogic.findPageSucursal(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberSucursal() throws Exception {
		return sucursalLogic.findTotalNumberSucursal();
	}

	public List<SucursalDTO> getDataSucursal() throws Exception {
		return sucursalLogic.getDataSucursal();
	}

	public List<Tabla> getTabla() throws Exception {
		return tablaLogic.getTabla();
	}

	public void saveTabla(Tabla entity) throws Exception {
		tablaLogic.saveTabla(entity);
	}

	public void deleteTabla(Tabla entity) throws Exception {
		tablaLogic.deleteTabla(entity);
	}

	public void updateTabla(Tabla entity) throws Exception {
		tablaLogic.updateTabla(entity);
	}

	public Tabla getTabla(Long idTabl) throws Exception {
		Tabla tabla = null;

		try {
			tabla = tablaLogic.getTabla(idTabl);
		} catch (Exception e) {
			throw e;
		}

		return tabla;
	}

	public List<Tabla> findByCriteriaInTabla(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return tablaLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Tabla> findPageTabla(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return tablaLogic.findPageTabla(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberTabla() throws Exception {
		return tablaLogic.findTotalNumberTabla();
	}

	public List<TablaDTO> getDataTabla() throws Exception {
		return tablaLogic.getDataTabla();
	}

	public List<TipoCartera> getTipoCartera() throws Exception {
		return tipoCarteraLogic.getTipoCartera();
	}

	public void saveTipoCartera(TipoCartera entity) throws Exception {
		tipoCarteraLogic.saveTipoCartera(entity);
	}

	public void deleteTipoCartera(TipoCartera entity) throws Exception {
		tipoCarteraLogic.deleteTipoCartera(entity);
	}

	public void updateTipoCartera(TipoCartera entity) throws Exception {
		tipoCarteraLogic.updateTipoCartera(entity);
	}

	public TipoCartera getTipoCartera(Long idTica) throws Exception {
		TipoCartera tipoCartera = null;

		try {
			tipoCartera = tipoCarteraLogic.getTipoCartera(idTica);
		} catch (Exception e) {
			throw e;
		}

		return tipoCartera;
	}

	public List<TipoCartera> findByCriteriaInTipoCartera(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return tipoCarteraLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<TipoCartera> findPageTipoCartera(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return tipoCarteraLogic.findPageTipoCartera(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberTipoCartera() throws Exception {
		return tipoCarteraLogic.findTotalNumberTipoCartera();
	}

	public List<TipoCarteraDTO> getDataTipoCartera() throws Exception {
		return tipoCarteraLogic.getDataTipoCartera();
	}

	public List<TipoCausal> getTipoCausal() throws Exception {
		return tipoCausalLogic.getTipoCausal();
	}

	public void saveTipoCausal(TipoCausal entity) throws Exception {
		tipoCausalLogic.saveTipoCausal(entity);
	}

	public void deleteTipoCausal(TipoCausal entity) throws Exception {
		tipoCausalLogic.deleteTipoCausal(entity);
	}

	public void updateTipoCausal(TipoCausal entity) throws Exception {
		tipoCausalLogic.updateTipoCausal(entity);
	}

	public TipoCausal getTipoCausal(Long idTcau) throws Exception {
		TipoCausal tipoCausal = null;

		try {
			tipoCausal = tipoCausalLogic.getTipoCausal(idTcau);
		} catch (Exception e) {
			throw e;
		}

		return tipoCausal;
	}

	public List<TipoCausal> findByCriteriaInTipoCausal(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return tipoCausalLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<TipoCausal> findPageTipoCausal(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return tipoCausalLogic.findPageTipoCausal(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberTipoCausal() throws Exception {
		return tipoCausalLogic.findTotalNumberTipoCausal();
	}

	public List<TipoCausalDTO> getDataTipoCausal() throws Exception {
		return tipoCausalLogic.getDataTipoCausal();
	}

	public List<TipoContacto> getTipoContacto() throws Exception {
		return tipoContactoLogic.getTipoContacto();
	}

	public void saveTipoContacto(TipoContacto entity) throws Exception {
		tipoContactoLogic.saveTipoContacto(entity);
	}

	public void deleteTipoContacto(TipoContacto entity) throws Exception {
		tipoContactoLogic.deleteTipoContacto(entity);
	}

	public void updateTipoContacto(TipoContacto entity) throws Exception {
		tipoContactoLogic.updateTipoContacto(entity);
	}

	public TipoContacto getTipoContacto(Long idTico) throws Exception {
		TipoContacto tipoContacto = null;

		try {
			tipoContacto = tipoContactoLogic.getTipoContacto(idTico);
		} catch (Exception e) {
			throw e;
		}

		return tipoContacto;
	}

	public List<TipoContacto> findByCriteriaInTipoContacto(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return tipoContactoLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<TipoContacto> findPageTipoContacto(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return tipoContactoLogic.findPageTipoContacto(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberTipoContacto() throws Exception {
		return tipoContactoLogic.findTotalNumberTipoContacto();
	}

	public List<TipoContactoDTO> getDataTipoContacto() throws Exception {
		return tipoContactoLogic.getDataTipoContacto();
	}

	public List<TipoDivision> getTipoDivision() throws Exception {
		return tipoDivisionLogic.getTipoDivision();
	}

	public void saveTipoDivision(TipoDivision entity) throws Exception {
		tipoDivisionLogic.saveTipoDivision(entity);
	}

	public void deleteTipoDivision(TipoDivision entity) throws Exception {
		tipoDivisionLogic.deleteTipoDivision(entity);
	}

	public void updateTipoDivision(TipoDivision entity) throws Exception {
		tipoDivisionLogic.updateTipoDivision(entity);
	}

	public TipoDivision getTipoDivision(Long idTidi) throws Exception {
		TipoDivision tipoDivision = null;

		try {
			tipoDivision = tipoDivisionLogic.getTipoDivision(idTidi);
		} catch (Exception e) {
			throw e;
		}

		return tipoDivision;
	}

	public List<TipoDivision> findByCriteriaInTipoDivision(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return tipoDivisionLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<TipoDivision> findPageTipoDivision(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return tipoDivisionLogic.findPageTipoDivision(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberTipoDivision() throws Exception {
		return tipoDivisionLogic.findTotalNumberTipoDivision();
	}

	public List<TipoDivisionDTO> getDataTipoDivision() throws Exception {
		return tipoDivisionLogic.getDataTipoDivision();
	}

	public List<TipoDocumento> getTipoDocumento() throws Exception {
		return tipoDocumentoLogic.getTipoDocumento();
	}

	public void saveTipoDocumento(TipoDocumento entity) throws Exception {
		tipoDocumentoLogic.saveTipoDocumento(entity);
	}

	public void deleteTipoDocumento(TipoDocumento entity) throws Exception {
		tipoDocumentoLogic.deleteTipoDocumento(entity);
	}

	public void updateTipoDocumento(TipoDocumento entity) throws Exception {
		tipoDocumentoLogic.updateTipoDocumento(entity);
	}

	public TipoDocumento getTipoDocumento(Long idTido) throws Exception {
		TipoDocumento tipoDocumento = null;

		try {
			tipoDocumento = tipoDocumentoLogic.getTipoDocumento(idTido);
		} catch (Exception e) {
			throw e;
		}

		return tipoDocumento;
	}

	public List<TipoDocumento> findByCriteriaInTipoDocumento(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tipoDocumentoLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<TipoDocumento> findPageTipoDocumento(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return tipoDocumentoLogic.findPageTipoDocumento(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberTipoDocumento() throws Exception {
		return tipoDocumentoLogic.findTotalNumberTipoDocumento();
	}

	public List<TipoDocumentoDTO> getDataTipoDocumento() throws Exception {
		return tipoDocumentoLogic.getDataTipoDocumento();
	}

	public List<TipoFormaPago> getTipoFormaPago() throws Exception {
		return tipoFormaPagoLogic.getTipoFormaPago();
	}

	public void saveTipoFormaPago(TipoFormaPago entity) throws Exception {
		tipoFormaPagoLogic.saveTipoFormaPago(entity);
	}

	public void deleteTipoFormaPago(TipoFormaPago entity) throws Exception {
		tipoFormaPagoLogic.deleteTipoFormaPago(entity);
	}

	public void updateTipoFormaPago(TipoFormaPago entity) throws Exception {
		tipoFormaPagoLogic.updateTipoFormaPago(entity);
	}

	public TipoFormaPago getTipoFormaPago(Long idTfpa) throws Exception {
		TipoFormaPago tipoFormaPago = null;

		try {
			tipoFormaPago = tipoFormaPagoLogic.getTipoFormaPago(idTfpa);
		} catch (Exception e) {
			throw e;
		}

		return tipoFormaPago;
	}

	public List<TipoFormaPago> findByCriteriaInTipoFormaPago(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tipoFormaPagoLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<TipoFormaPago> findPageTipoFormaPago(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return tipoFormaPagoLogic.findPageTipoFormaPago(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberTipoFormaPago() throws Exception {
		return tipoFormaPagoLogic.findTotalNumberTipoFormaPago();
	}

	public List<TipoFormaPagoDTO> getDataTipoFormaPago() throws Exception {
		return tipoFormaPagoLogic.getDataTipoFormaPago();
	}

	public List<TipoGarantia> getTipoGarantia() throws Exception {
		return tipoGarantiaLogic.getTipoGarantia();
	}

	public void saveTipoGarantia(TipoGarantia entity) throws Exception {
		tipoGarantiaLogic.saveTipoGarantia(entity);
	}

	public void deleteTipoGarantia(TipoGarantia entity) throws Exception {
		tipoGarantiaLogic.deleteTipoGarantia(entity);
	}

	public void updateTipoGarantia(TipoGarantia entity) throws Exception {
		tipoGarantiaLogic.updateTipoGarantia(entity);
	}

	public TipoGarantia getTipoGarantia(Long idTiga) throws Exception {
		TipoGarantia tipoGarantia = null;

		try {
			tipoGarantia = tipoGarantiaLogic.getTipoGarantia(idTiga);
		} catch (Exception e) {
			throw e;
		}

		return tipoGarantia;
	}

	public List<TipoGarantia> findByCriteriaInTipoGarantia(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return tipoGarantiaLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<TipoGarantia> findPageTipoGarantia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return tipoGarantiaLogic.findPageTipoGarantia(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberTipoGarantia() throws Exception {
		return tipoGarantiaLogic.findTotalNumberTipoGarantia();
	}

	public List<TipoGarantiaDTO> getDataTipoGarantia() throws Exception {
		return tipoGarantiaLogic.getDataTipoGarantia();
	}

	public List<TipoIdentificacion> getTipoIdentificacion() throws Exception {
		return tipoIdentificacionLogic.getTipoIdentificacion();
	}

	public void saveTipoIdentificacion(TipoIdentificacion entity)
			throws Exception {
		tipoIdentificacionLogic.saveTipoIdentificacion(entity);
	}

	public void deleteTipoIdentificacion(TipoIdentificacion entity)
			throws Exception {
		tipoIdentificacionLogic.deleteTipoIdentificacion(entity);
	}

	public void updateTipoIdentificacion(TipoIdentificacion entity)
			throws Exception {
		tipoIdentificacionLogic.updateTipoIdentificacion(entity);
	}

	public TipoIdentificacion getTipoIdentificacion(Long idTiid)
			throws Exception {
		TipoIdentificacion tipoIdentificacion = null;

		try {
			tipoIdentificacion = tipoIdentificacionLogic
					.getTipoIdentificacion(idTiid);
		} catch (Exception e) {
			throw e;
		}

		return tipoIdentificacion;
	}

	public List<TipoIdentificacion> findByCriteriaInTipoIdentificacion(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return tipoIdentificacionLogic.findByCriteria(variables,
				variablesBetween, variablesBetweenDates);
	}

	public List<TipoIdentificacion> findPageTipoIdentificacion(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		return tipoIdentificacionLogic.findPageTipoIdentificacion(
				sortColumnName, sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberTipoIdentificacion() throws Exception {
		return tipoIdentificacionLogic.findTotalNumberTipoIdentificacion();
	}

	public List<TipoIdentificacionDTO> getDataTipoIdentificacion()
			throws Exception {
		return tipoIdentificacionLogic.getDataTipoIdentificacion();
	}

	public List<TipoLista> getTipoLista() throws Exception {
		return tipoListaLogic.getTipoLista();
	}

	public void saveTipoLista(TipoLista entity) throws Exception {
		tipoListaLogic.saveTipoLista(entity);
	}

	public void deleteTipoLista(TipoLista entity) throws Exception {
		tipoListaLogic.deleteTipoLista(entity);
	}

	public void updateTipoLista(TipoLista entity) throws Exception {
		tipoListaLogic.updateTipoLista(entity);
	}

	public TipoLista getTipoLista(Long idTili) throws Exception {
		TipoLista tipoLista = null;

		try {
			tipoLista = tipoListaLogic.getTipoLista(idTili);
		} catch (Exception e) {
			throw e;
		}

		return tipoLista;
	}

	public List<TipoLista> findByCriteriaInTipoLista(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return tipoListaLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<TipoLista> findPageTipoLista(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return tipoListaLogic.findPageTipoLista(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberTipoLista() throws Exception {
		return tipoListaLogic.findTotalNumberTipoLista();
	}

	public List<TipoListaDTO> getDataTipoLista() throws Exception {
		return tipoListaLogic.getDataTipoLista();
	}

	public List<TipoSucursal> getTipoSucursal() throws Exception {
		return tipoSucursalLogic.getTipoSucursal();
	}

	public void saveTipoSucursal(TipoSucursal entity) throws Exception {
		tipoSucursalLogic.saveTipoSucursal(entity);
	}

	public void deleteTipoSucursal(TipoSucursal entity) throws Exception {
		tipoSucursalLogic.deleteTipoSucursal(entity);
	}

	public void updateTipoSucursal(TipoSucursal entity) throws Exception {
		tipoSucursalLogic.updateTipoSucursal(entity);
	}

	public TipoSucursal getTipoSucursal(Long idTisu) throws Exception {
		TipoSucursal tipoSucursal = null;

		try {
			tipoSucursal = tipoSucursalLogic.getTipoSucursal(idTisu);
		} catch (Exception e) {
			throw e;
		}

		return tipoSucursal;
	}

	public List<TipoSucursal> findByCriteriaInTipoSucursal(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return tipoSucursalLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<TipoSucursal> findPageTipoSucursal(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return tipoSucursalLogic.findPageTipoSucursal(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberTipoSucursal() throws Exception {
		return tipoSucursalLogic.findTotalNumberTipoSucursal();
	}

	public List<TipoSucursalDTO> getDataTipoSucursal() throws Exception {
		return tipoSucursalLogic.getDataTipoSucursal();
	}

	public List<UnidadNegocio> getUnidadNegocio() throws Exception {
		return unidadNegocioLogic.getUnidadNegocio();
	}

	public void saveUnidadNegocio(UnidadNegocio entity) throws Exception {
		unidadNegocioLogic.saveUnidadNegocio(entity);
	}

	public void deleteUnidadNegocio(UnidadNegocio entity) throws Exception {
		unidadNegocioLogic.deleteUnidadNegocio(entity);
	}

	public void updateUnidadNegocio(UnidadNegocio entity) throws Exception {
		unidadNegocioLogic.updateUnidadNegocio(entity);
	}

	public UnidadNegocio getUnidadNegocio(Long idUnne) throws Exception {
		UnidadNegocio unidadNegocio = null;

		try {
			unidadNegocio = unidadNegocioLogic.getUnidadNegocio(idUnne);
		} catch (Exception e) {
			throw e;
		}

		return unidadNegocio;
	}

	public List<UnidadNegocio> findByCriteriaInUnidadNegocio(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception {
		return unidadNegocioLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<UnidadNegocio> findPageUnidadNegocio(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return unidadNegocioLogic.findPageUnidadNegocio(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberUnidadNegocio() throws Exception {
		return unidadNegocioLogic.findTotalNumberUnidadNegocio();
	}

	public List<UnidadNegocioDTO> getDataUnidadNegocio() throws Exception {
		return unidadNegocioLogic.getDataUnidadNegocio();
	}

	public List<UnidadVenta> getUnidadVenta() throws Exception {
		return unidadVentaLogic.getUnidadVenta();
	}

	public void saveUnidadVenta(UnidadVenta entity) throws Exception {
		unidadVentaLogic.saveUnidadVenta(entity);
	}

	public void deleteUnidadVenta(UnidadVenta entity) throws Exception {
		unidadVentaLogic.deleteUnidadVenta(entity);
	}

	public void updateUnidadVenta(UnidadVenta entity) throws Exception {
		unidadVentaLogic.updateUnidadVenta(entity);
	}

	public UnidadVenta getUnidadVenta(Long idUnve) throws Exception {
		UnidadVenta unidadVenta = null;

		try {
			unidadVenta = unidadVentaLogic.getUnidadVenta(idUnve);
		} catch (Exception e) {
			throw e;
		}

		return unidadVenta;
	}

	public List<UnidadVenta> findByCriteriaInUnidadVenta(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return unidadVentaLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<UnidadVenta> findPageUnidadVenta(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return unidadVentaLogic.findPageUnidadVenta(sortColumnName,
				sortAscending, startRow, maxResults);
	}

	public Long findTotalNumberUnidadVenta() throws Exception {
		return unidadVentaLogic.findTotalNumberUnidadVenta();
	}

	public List<UnidadVentaDTO> getDataUnidadVenta() throws Exception {
		return unidadVentaLogic.getDataUnidadVenta();
	}

	public List<Vendedor> getVendedor() throws Exception {
		return vendedorLogic.getVendedor();
	}

	public void saveVendedor(Vendedor entity) throws Exception {
		vendedorLogic.saveVendedor(entity);
	}

	public void deleteVendedor(Vendedor entity) throws Exception {
		vendedorLogic.deleteVendedor(entity);
	}

	public void updateVendedor(Vendedor entity) throws Exception {
		vendedorLogic.updateVendedor(entity);
	}

	public Vendedor getVendedor(Long idVend) throws Exception {
		Vendedor vendedor = null;

		try {
			vendedor = vendedorLogic.getVendedor(idVend);
		} catch (Exception e) {
			throw e;
		}

		return vendedor;
	}

	public List<Vendedor> findByCriteriaInVendedor(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return vendedorLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Vendedor> findPageVendedor(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return vendedorLogic.findPageVendedor(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberVendedor() throws Exception {
		return vendedorLogic.findTotalNumberVendedor();
	}

	public List<VendedorDTO> getDataVendedor() throws Exception {
		return vendedorLogic.getDataVendedor();
	}

	public List<Visita> getVisita() throws Exception {
		return visitaLogic.getVisita();
	}

	public void saveVisita(Visita entity) throws Exception {
		visitaLogic.saveVisita(entity);
	}

	public void deleteVisita(Visita entity) throws Exception {
		visitaLogic.deleteVisita(entity);
	}

	public void updateVisita(Visita entity) throws Exception {
		visitaLogic.updateVisita(entity);
	}

	public Visita getVisita(Long idVisi) throws Exception {
		Visita visita = null;

		try {
			visita = visitaLogic.getVisita(idVisi);
		} catch (Exception e) {
			throw e;
		}

		return visita;
	}

	public List<Visita> findByCriteriaInVisita(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		return visitaLogic.findByCriteria(variables, variablesBetween,
				variablesBetweenDates);
	}

	public List<Visita> findPageVisita(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		return visitaLogic.findPageVisita(sortColumnName, sortAscending,
				startRow, maxResults);
	}

	public Long findTotalNumberVisita() throws Exception {
		return visitaLogic.findTotalNumberVisita();
	}

	public List<VisitaDTO> getDataVisita() throws Exception {
		return visitaLogic.getDataVisita();
	}

	public List<GrupoReferencia> consultarPorGrupo(String propertyName,
			Object value) throws Exception {
		return grupoReferenciaLogic.consultarPorGrupo(propertyName, value);
	}

}
