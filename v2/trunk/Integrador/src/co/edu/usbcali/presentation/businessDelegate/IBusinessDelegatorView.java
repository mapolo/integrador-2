package co.edu.usbcali.presentation.businessDelegate;

import java.util.List;

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
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IBusinessDelegatorView {
	public List<AtencionVendedor> getAtencionVendedor() throws Exception;

	public void saveAtencionVendedor(AtencionVendedor entity) throws Exception;

	public void deleteAtencionVendedor(AtencionVendedor entity)
			throws Exception;

	public void updateAtencionVendedor(AtencionVendedor entity)
			throws Exception;

	public AtencionVendedor getAtencionVendedor(Long idAtve) throws Exception;

	public List<AtencionVendedor> findByCriteriaInAtencionVendedor(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<AtencionVendedor> findPageAtencionVendedor(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberAtencionVendedor() throws Exception;

	public List<AtencionVendedorDTO> getDataAtencionVendedor() throws Exception;

	public List<Banco> getBanco() throws Exception;

	public void saveBanco(Banco entity) throws Exception;

	public void deleteBanco(Banco entity) throws Exception;

	public void updateBanco(Banco entity) throws Exception;

	public Banco getBanco(Long idBanc) throws Exception;

	public List<Banco> findByCriteriaInBanco(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Banco> findPageBanco(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberBanco() throws Exception;

	public List<BancoDTO> getDataBanco() throws Exception;

	public List<Bateriologo> getBateriologo() throws Exception;

	public void saveBateriologo(Bateriologo entity) throws Exception;

	public void deleteBateriologo(Bateriologo entity) throws Exception;

	public void updateBateriologo(Bateriologo entity) throws Exception;

	public Bateriologo getBateriologo(Long idBate) throws Exception;

	public List<Bateriologo> findByCriteriaInBateriologo(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Bateriologo> findPageBateriologo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberBateriologo() throws Exception;

	public List<BateriologoDTO> getDataBateriologo() throws Exception;

	public List<CamposParametrizables> getCamposParametrizables()
			throws Exception;

	public void saveCamposParametrizables(CamposParametrizables entity)
			throws Exception;

	public void deleteCamposParametrizables(CamposParametrizables entity)
			throws Exception;

	public void updateCamposParametrizables(CamposParametrizables entity)
			throws Exception;

	public CamposParametrizables getCamposParametrizables(Long idCapa)
			throws Exception;

	public List<CamposParametrizables> findByCriteriaInCamposParametrizables(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<CamposParametrizables> findPageCamposParametrizables(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberCamposParametrizables() throws Exception;

	public List<CamposParametrizablesDTO> getDataCamposParametrizables()
			throws Exception;

	public List<Cartera> getCartera() throws Exception;

	public void saveCartera(Cartera entity) throws Exception;

	public void deleteCartera(Cartera entity) throws Exception;

	public void updateCartera(Cartera entity) throws Exception;

	public Cartera getCartera(Long idCart) throws Exception;

	public List<Cartera> findByCriteriaInCartera(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Cartera> findPageCartera(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberCartera() throws Exception;

	public List<CarteraDTO> getDataCartera() throws Exception;

	public List<Causal> getCausal() throws Exception;

	public void saveCausal(Causal entity) throws Exception;

	public void deleteCausal(Causal entity) throws Exception;

	public void updateCausal(Causal entity) throws Exception;

	public Causal getCausal(Long idCusa) throws Exception;

	public List<Causal> findByCriteriaInCausal(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Causal> findPageCausal(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberCausal() throws Exception;

	public List<CausalDTO> getDataCausal() throws Exception;

	public List<ChequePosfechado> getChequePosfechado() throws Exception;

	public void saveChequePosfechado(ChequePosfechado entity) throws Exception;

	public void deleteChequePosfechado(ChequePosfechado entity)
			throws Exception;

	public void updateChequePosfechado(ChequePosfechado entity)
			throws Exception;

	public ChequePosfechado getChequePosfechado(Long idChps) throws Exception;

	public List<ChequePosfechado> findByCriteriaInChequePosfechado(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ChequePosfechado> findPageChequePosfechado(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberChequePosfechado() throws Exception;

	public List<ChequePosfechadoDTO> getDataChequePosfechado() throws Exception;

	public List<ClaveFabricacion> getClaveFabricacion() throws Exception;

	public void saveClaveFabricacion(ClaveFabricacion entity) throws Exception;

	public void deleteClaveFabricacion(ClaveFabricacion entity)
			throws Exception;

	public void updateClaveFabricacion(ClaveFabricacion entity)
			throws Exception;

	public ClaveFabricacion getClaveFabricacion(Long idClfa) throws Exception;

	public List<ClaveFabricacion> findByCriteriaInClaveFabricacion(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ClaveFabricacion> findPageClaveFabricacion(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberClaveFabricacion() throws Exception;

	public List<ClaveFabricacionDTO> getDataClaveFabricacion() throws Exception;

	public List<ClavesParaRotar> getClavesParaRotar() throws Exception;

	public void saveClavesParaRotar(ClavesParaRotar entity) throws Exception;

	public void deleteClavesParaRotar(ClavesParaRotar entity) throws Exception;

	public void updateClavesParaRotar(ClavesParaRotar entity) throws Exception;

	public ClavesParaRotar getClavesParaRotar(Long idClpr) throws Exception;

	public List<ClavesParaRotar> findByCriteriaInClavesParaRotar(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ClavesParaRotar> findPageClavesParaRotar(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberClavesParaRotar() throws Exception;

	public List<ClavesParaRotarDTO> getDataClavesParaRotar() throws Exception;

	public List<Cliente> getCliente() throws Exception;

	public void saveCliente(Cliente entity) throws Exception;

	public void deleteCliente(Cliente entity) throws Exception;

	public void updateCliente(Cliente entity) throws Exception;

	public Cliente getCliente(Long idClie) throws Exception;

	public List<Cliente> findByCriteriaInCliente(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Cliente> findPageCliente(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberCliente() throws Exception;

	public List<ClienteDTO> getDataCliente() throws Exception;

	public List<Compania> getCompania() throws Exception;

	public void saveCompania(Compania entity) throws Exception;

	public void deleteCompania(Compania entity) throws Exception;

	public void updateCompania(Compania entity) throws Exception;

	public Compania getCompania(Long idCia) throws Exception;

	public List<Compania> findByCriteriaInCompania(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Compania> findPageCompania(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberCompania() throws Exception;

	public List<CompaniaDTO> getDataCompania() throws Exception;

	public List<ConceptoRecibo> getConceptoRecibo() throws Exception;

	public void saveConceptoRecibo(ConceptoRecibo entity) throws Exception;

	public void deleteConceptoRecibo(ConceptoRecibo entity) throws Exception;

	public void updateConceptoRecibo(ConceptoRecibo entity) throws Exception;

	public ConceptoRecibo getConceptoRecibo(Long idCpto) throws Exception;

	public List<ConceptoRecibo> findByCriteriaInConceptoRecibo(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ConceptoRecibo> findPageConceptoRecibo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberConceptoRecibo() throws Exception;

	public List<ConceptoReciboDTO> getDataConceptoRecibo() throws Exception;

	public List<ConfSemanasAno> getConfSemanasAno() throws Exception;

	public void saveConfSemanasAno(ConfSemanasAno entity) throws Exception;

	public void deleteConfSemanasAno(ConfSemanasAno entity) throws Exception;

	public void updateConfSemanasAno(ConfSemanasAno entity) throws Exception;

	public ConfSemanasAno getConfSemanasAno(Long idCfsa) throws Exception;

	public List<ConfSemanasAno> findByCriteriaInConfSemanasAno(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ConfSemanasAno> findPageConfSemanasAno(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberConfSemanasAno() throws Exception;

	public List<ConfSemanasAnoDTO> getDataConfSemanasAno() throws Exception;

	public List<ConsecutivoDocumento> getConsecutivoDocumento()
			throws Exception;

	public void saveConsecutivoDocumento(ConsecutivoDocumento entity)
			throws Exception;

	public void deleteConsecutivoDocumento(ConsecutivoDocumento entity)
			throws Exception;

	public void updateConsecutivoDocumento(ConsecutivoDocumento entity)
			throws Exception;

	public ConsecutivoDocumento getConsecutivoDocumento(Long idCodo)
			throws Exception;

	public List<ConsecutivoDocumento> findByCriteriaInConsecutivoDocumento(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ConsecutivoDocumento> findPageConsecutivoDocumento(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberConsecutivoDocumento() throws Exception;

	public List<ConsecutivoDocumentoDTO> getDataConsecutivoDocumento()
			throws Exception;

	public List<Contacto> getContacto() throws Exception;

	public void saveContacto(Contacto entity) throws Exception;

	public void deleteContacto(Contacto entity) throws Exception;

	public void updateContacto(Contacto entity) throws Exception;

	public Contacto getContacto(Long idCont) throws Exception;

	public List<Contacto> findByCriteriaInContacto(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Contacto> findPageContacto(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberContacto() throws Exception;

	public List<ContactoDTO> getDataContacto() throws Exception;

	public List<Cruce> getCruce() throws Exception;

	public void saveCruce(Cruce entity) throws Exception;

	public void deleteCruce(Cruce entity) throws Exception;

	public void updateCruce(Cruce entity) throws Exception;

	public Cruce getCruce(Long idCrce) throws Exception;

	public List<Cruce> findByCriteriaInCruce(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Cruce> findPageCruce(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberCruce() throws Exception;

	public List<CruceDTO> getDataCruce() throws Exception;

	public List<DescuentoComercial> getDescuentoComercial() throws Exception;

	public void saveDescuentoComercial(DescuentoComercial entity)
			throws Exception;

	public void deleteDescuentoComercial(DescuentoComercial entity)
			throws Exception;

	public void updateDescuentoComercial(DescuentoComercial entity)
			throws Exception;

	public DescuentoComercial getDescuentoComercial(Long idDeco)
			throws Exception;

	public List<DescuentoComercial> findByCriteriaInDescuentoComercial(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DescuentoComercial> findPageDescuentoComercial(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDescuentoComercial() throws Exception;

	public List<DescuentoComercialDTO> getDataDescuentoComercial()
			throws Exception;

	public List<DescuentoFinanciero> getDescuentoFinanciero() throws Exception;

	public void saveDescuentoFinanciero(DescuentoFinanciero entity)
			throws Exception;

	public void deleteDescuentoFinanciero(DescuentoFinanciero entity)
			throws Exception;

	public void updateDescuentoFinanciero(DescuentoFinanciero entity)
			throws Exception;

	public DescuentoFinanciero getDescuentoFinanciero(Long idDefi)
			throws Exception;

	public List<DescuentoFinanciero> findByCriteriaInDescuentoFinanciero(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DescuentoFinanciero> findPageDescuentoFinanciero(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDescuentoFinanciero() throws Exception;

	public List<DescuentoFinancieroDTO> getDataDescuentoFinanciero()
			throws Exception;

	public List<DetalleVisita> getDetalleVisita() throws Exception;

	public void saveDetalleVisita(DetalleVisita entity) throws Exception;

	public void deleteDetalleVisita(DetalleVisita entity) throws Exception;

	public void updateDetalleVisita(DetalleVisita entity) throws Exception;

	public DetalleVisita getDetalleVisita(Long idDevi) throws Exception;

	public List<DetalleVisita> findByCriteriaInDetalleVisita(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DetalleVisita> findPageDetalleVisita(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberDetalleVisita() throws Exception;

	public List<DetalleVisitaDTO> getDataDetalleVisita() throws Exception;

	public List<DiasSemana> getDiasSemana() throws Exception;

	public void saveDiasSemana(DiasSemana entity) throws Exception;

	public void deleteDiasSemana(DiasSemana entity) throws Exception;

	public void updateDiasSemana(DiasSemana entity) throws Exception;

	public DiasSemana getDiasSemana(Long idDise) throws Exception;

	public List<DiasSemana> findByCriteriaInDiasSemana(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<DiasSemana> findPageDiasSemana(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberDiasSemana() throws Exception;

	public List<DiasSemanaDTO> getDataDiasSemana() throws Exception;

	public List<DistribucionCartera> getDistribucionCartera() throws Exception;

	public void saveDistribucionCartera(DistribucionCartera entity)
			throws Exception;

	public void deleteDistribucionCartera(DistribucionCartera entity)
			throws Exception;

	public void updateDistribucionCartera(DistribucionCartera entity)
			throws Exception;

	public DistribucionCartera getDistribucionCartera(Long idDica)
			throws Exception;

	public List<DistribucionCartera> findByCriteriaInDistribucionCartera(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DistribucionCartera> findPageDistribucionCartera(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDistribucionCartera() throws Exception;

	public List<DistribucionCarteraDTO> getDataDistribucionCartera()
			throws Exception;

	public List<DivisionPolitica> getDivisionPolitica() throws Exception;

	public void saveDivisionPolitica(DivisionPolitica entity) throws Exception;

	public void deleteDivisionPolitica(DivisionPolitica entity)
			throws Exception;

	public void updateDivisionPolitica(DivisionPolitica entity)
			throws Exception;

	public DivisionPolitica getDivisionPolitica(Long idDipo) throws Exception;

	public List<DivisionPolitica> findByCriteriaInDivisionPolitica(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<DivisionPolitica> findPageDivisionPolitica(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDivisionPolitica() throws Exception;

	public List<DivisionPoliticaDTO> getDataDivisionPolitica() throws Exception;

	public List<Documento> getDocumento() throws Exception;

	public void saveDocumento(Documento entity) throws Exception;

	public void deleteDocumento(Documento entity) throws Exception;

	public void updateDocumento(Documento entity) throws Exception;

	public Documento getDocumento(Long idDocu) throws Exception;

	public List<Documento> findByCriteriaInDocumento(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Documento> findPageDocumento(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberDocumento() throws Exception;

	public List<DocumentoDTO> getDataDocumento() throws Exception;

	public List<Empresa> getEmpresa() throws Exception;

	public void saveEmpresa(Empresa entity) throws Exception;

	public void deleteEmpresa(Empresa entity) throws Exception;

	public void updateEmpresa(Empresa entity) throws Exception;

	public Empresa getEmpresa(Long idEmpr) throws Exception;

	public List<Empresa> findByCriteriaInEmpresa(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Empresa> findPageEmpresa(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberEmpresa() throws Exception;

	public List<EmpresaDTO> getDataEmpresa() throws Exception;

	public List<EstadoDocumento> getEstadoDocumento() throws Exception;

	public void saveEstadoDocumento(EstadoDocumento entity) throws Exception;

	public void deleteEstadoDocumento(EstadoDocumento entity) throws Exception;

	public void updateEstadoDocumento(EstadoDocumento entity) throws Exception;

	public EstadoDocumento getEstadoDocumento(Long idEsdo) throws Exception;

	public List<EstadoDocumento> findByCriteriaInEstadoDocumento(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<EstadoDocumento> findPageEstadoDocumento(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberEstadoDocumento() throws Exception;

	public List<EstadoDocumentoDTO> getDataEstadoDocumento() throws Exception;

	public List<Fallas> getFallas() throws Exception;

	public void saveFallas(Fallas entity) throws Exception;

	public void deleteFallas(Fallas entity) throws Exception;

	public void updateFallas(Fallas entity) throws Exception;

	public Fallas getFallas(Long idCfal) throws Exception;

	public List<Fallas> findByCriteriaInFallas(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Fallas> findPageFallas(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberFallas() throws Exception;

	public List<FallasDTO> getDataFallas() throws Exception;

	public List<Familia> getFamilia() throws Exception;

	public void saveFamilia(Familia entity) throws Exception;

	public void deleteFamilia(Familia entity) throws Exception;

	public void updateFamilia(Familia entity) throws Exception;

	public Familia getFamilia(Long idFlia) throws Exception;

	public List<Familia> findByCriteriaInFamilia(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Familia> findPageFamilia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberFamilia() throws Exception;

	public List<FamiliaDTO> getDataFamilia() throws Exception;

	public List<FrecuenciaSemana> getFrecuenciaSemana() throws Exception;

	public void saveFrecuenciaSemana(FrecuenciaSemana entity) throws Exception;

	public void deleteFrecuenciaSemana(FrecuenciaSemana entity)
			throws Exception;

	public void updateFrecuenciaSemana(FrecuenciaSemana entity)
			throws Exception;

	public FrecuenciaSemana getFrecuenciaSemana(Long idFrcr) throws Exception;

	public List<FrecuenciaSemana> findByCriteriaInFrecuenciaSemana(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<FrecuenciaSemana> findPageFrecuenciaSemana(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberFrecuenciaSemana() throws Exception;

	public List<FrecuenciaSemanaDTO> getDataFrecuenciaSemana() throws Exception;

	public List<FrecuenciaVisita> getFrecuenciaVisita() throws Exception;

	public void saveFrecuenciaVisita(FrecuenciaVisita entity) throws Exception;

	public void deleteFrecuenciaVisita(FrecuenciaVisita entity)
			throws Exception;

	public void updateFrecuenciaVisita(FrecuenciaVisita entity)
			throws Exception;

	public FrecuenciaVisita getFrecuenciaVisita(Long idFrvi) throws Exception;

	public List<FrecuenciaVisita> findByCriteriaInFrecuenciaVisita(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<FrecuenciaVisita> findPageFrecuenciaVisita(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberFrecuenciaVisita() throws Exception;

	public List<FrecuenciaVisitaDTO> getDataFrecuenciaVisita() throws Exception;

	public List<Garantia> getGarantia() throws Exception;

	public void saveGarantia(Garantia entity) throws Exception;

	public void deleteGarantia(Garantia entity) throws Exception;

	public void updateGarantia(Garantia entity) throws Exception;

	public Garantia getGarantia(Long idGar) throws Exception;

	public List<Garantia> findByCriteriaInGarantia(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Garantia> findPageGarantia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberGarantia() throws Exception;

	public List<GarantiaDTO> getDataGarantia() throws Exception;

	public List<Grupo> getGrupo() throws Exception;

	public void saveGrupo(Grupo entity) throws Exception;

	public void deleteGrupo(Grupo entity) throws Exception;

	public void updateGrupo(Grupo entity) throws Exception;

	public Grupo getGrupo(Long idGrpo) throws Exception;

	public List<Grupo> findByCriteriaInGrupo(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Grupo> findPageGrupo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberGrupo() throws Exception;

	public List<GrupoDTO> getDataGrupo() throws Exception;

	public List<GrupoReferencia> getGrupoReferencia() throws Exception;

	public void saveGrupoReferencia(GrupoReferencia entity) throws Exception;

	public void deleteGrupoReferencia(GrupoReferencia entity) throws Exception;

	public void updateGrupoReferencia(GrupoReferencia entity) throws Exception;

	public GrupoReferencia getGrupoReferencia(Long idGrre) throws Exception;

	public List<GrupoReferencia> findByCriteriaInGrupoReferencia(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<GrupoReferencia> findPageGrupoReferencia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberGrupoReferencia() throws Exception;

	public List<GrupoReferenciaDTO> getDataGrupoReferencia() throws Exception;

	public List<ItemLogisticaReversiva> getItemLogisticaReversiva()
			throws Exception;

	public void saveItemLogisticaReversiva(ItemLogisticaReversiva entity)
			throws Exception;

	public void deleteItemLogisticaReversiva(ItemLogisticaReversiva entity)
			throws Exception;

	public void updateItemLogisticaReversiva(ItemLogisticaReversiva entity)
			throws Exception;

	public ItemLogisticaReversiva getItemLogisticaReversiva(Long idItlr)
			throws Exception;

	public List<ItemLogisticaReversiva> findByCriteriaInItemLogisticaReversiva(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ItemLogisticaReversiva> findPageItemLogisticaReversiva(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberItemLogisticaReversiva() throws Exception;

	public List<ItemLogisticaReversivaDTO> getDataItemLogisticaReversiva()
			throws Exception;

	public List<ItemRotacion> getItemRotacion() throws Exception;

	public void saveItemRotacion(ItemRotacion entity) throws Exception;

	public void deleteItemRotacion(ItemRotacion entity) throws Exception;

	public void updateItemRotacion(ItemRotacion entity) throws Exception;

	public ItemRotacion getItemRotacion(Long idItro) throws Exception;

	public List<ItemRotacion> findByCriteriaInItemRotacion(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<ItemRotacion> findPageItemRotacion(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberItemRotacion() throws Exception;

	public List<ItemRotacionDTO> getDataItemRotacion() throws Exception;

	public List<ListaPrecios> getListaPrecios() throws Exception;

	public void saveListaPrecios(ListaPrecios entity) throws Exception;

	public void deleteListaPrecios(ListaPrecios entity) throws Exception;

	public void updateListaPrecios(ListaPrecios entity) throws Exception;

	public ListaPrecios getListaPrecios(Long idLipr) throws Exception;

	public List<ListaPrecios> findByCriteriaInListaPrecios(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<ListaPrecios> findPageListaPrecios(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberListaPrecios() throws Exception;

	public List<ListaPreciosDTO> getDataListaPrecios() throws Exception;

	public List<ListaPreciosEspeciales> getListaPreciosEspeciales()
			throws Exception;

	public void saveListaPreciosEspeciales(ListaPreciosEspeciales entity)
			throws Exception;

	public void deleteListaPreciosEspeciales(ListaPreciosEspeciales entity)
			throws Exception;

	public void updateListaPreciosEspeciales(ListaPreciosEspeciales entity)
			throws Exception;

	public ListaPreciosEspeciales getListaPreciosEspeciales(Long idLipe)
			throws Exception;

	public List<ListaPreciosEspeciales> findByCriteriaInListaPreciosEspeciales(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ListaPreciosEspeciales> findPageListaPreciosEspeciales(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberListaPreciosEspeciales() throws Exception;

	public List<ListaPreciosEspecialesDTO> getDataListaPreciosEspeciales()
			throws Exception;

	public List<LogisticaReversiva> getLogisticaReversiva() throws Exception;

	public void saveLogisticaReversiva(LogisticaReversiva entity)
			throws Exception;

	public void deleteLogisticaReversiva(LogisticaReversiva entity)
			throws Exception;

	public void updateLogisticaReversiva(LogisticaReversiva entity)
			throws Exception;

	public LogisticaReversiva getLogisticaReversiva(Long idLore)
			throws Exception;

	public List<LogisticaReversiva> findByCriteriaInLogisticaReversiva(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<LogisticaReversiva> findPageLogisticaReversiva(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberLogisticaReversiva() throws Exception;

	public List<LogisticaReversivaDTO> getDataLogisticaReversiva()
			throws Exception;

	public List<MovimientoInventario> getMovimientoInventario()
			throws Exception;

	public void saveMovimientoInventario(MovimientoInventario entity)
			throws Exception;

	public void deleteMovimientoInventario(MovimientoInventario entity)
			throws Exception;

	public void updateMovimientoInventario(MovimientoInventario entity)
			throws Exception;

	public MovimientoInventario getMovimientoInventario(Long idMoin)
			throws Exception;

	public List<MovimientoInventario> findByCriteriaInMovimientoInventario(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<MovimientoInventario> findPageMovimientoInventario(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberMovimientoInventario() throws Exception;

	public List<MovimientoInventarioDTO> getDataMovimientoInventario()
			throws Exception;

	public List<MovimientoVendedor> getMovimientoVendedor() throws Exception;

	public void saveMovimientoVendedor(MovimientoVendedor entity)
			throws Exception;

	public void deleteMovimientoVendedor(MovimientoVendedor entity)
			throws Exception;

	public void updateMovimientoVendedor(MovimientoVendedor entity)
			throws Exception;

	public MovimientoVendedor getMovimientoVendedor(Long idMven)
			throws Exception;

	public List<MovimientoVendedor> findByCriteriaInMovimientoVendedor(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<MovimientoVendedor> findPageMovimientoVendedor(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberMovimientoVendedor() throws Exception;

	public List<MovimientoVendedorDTO> getDataMovimientoVendedor()
			throws Exception;

	public List<Multifamilia> getMultifamilia() throws Exception;

	public void saveMultifamilia(Multifamilia entity) throws Exception;

	public void deleteMultifamilia(Multifamilia entity) throws Exception;

	public void updateMultifamilia(Multifamilia entity) throws Exception;

	public Multifamilia getMultifamilia(Long idMufa) throws Exception;

	public List<Multifamilia> findByCriteriaInMultifamilia(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Multifamilia> findPageMultifamilia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberMultifamilia() throws Exception;

	public List<MultifamiliaDTO> getDataMultifamilia() throws Exception;

	public List<OrdenesDeCompra> getOrdenesDeCompra() throws Exception;

	public void saveOrdenesDeCompra(OrdenesDeCompra entity) throws Exception;

	public void deleteOrdenesDeCompra(OrdenesDeCompra entity) throws Exception;

	public void updateOrdenesDeCompra(OrdenesDeCompra entity) throws Exception;

	public OrdenesDeCompra getOrdenesDeCompra(Long idOrdc) throws Exception;

	public List<OrdenesDeCompra> findByCriteriaInOrdenesDeCompra(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<OrdenesDeCompra> findPageOrdenesDeCompra(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberOrdenesDeCompra() throws Exception;

	public List<OrdenesDeCompraDTO> getDataOrdenesDeCompra() throws Exception;

	public List<Pedido> getPedido() throws Exception;

	public void savePedido(Pedido entity) throws Exception;

	public void deletePedido(Pedido entity) throws Exception;

	public void updatePedido(Pedido entity) throws Exception;

	public Pedido getPedido(Long idPddo) throws Exception;

	public List<Pedido> findByCriteriaInPedido(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Pedido> findPagePedido(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberPedido() throws Exception;

	public List<PedidoDTO> getDataPedido() throws Exception;

	public List<PeriodoGarantia> getPeriodoGarantia() throws Exception;

	public void savePeriodoGarantia(PeriodoGarantia entity) throws Exception;

	public void deletePeriodoGarantia(PeriodoGarantia entity) throws Exception;

	public void updatePeriodoGarantia(PeriodoGarantia entity) throws Exception;

	public PeriodoGarantia getPeriodoGarantia(Long idPega) throws Exception;

	public List<PeriodoGarantia> findByCriteriaInPeriodoGarantia(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<PeriodoGarantia> findPagePeriodoGarantia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberPeriodoGarantia() throws Exception;

	public List<PeriodoGarantiaDTO> getDataPeriodoGarantia() throws Exception;

	public List<Persona> getPersona() throws Exception;

	public void savePersona(Persona entity) throws Exception;

	public void deletePersona(Persona entity) throws Exception;

	public void updatePersona(Persona entity) throws Exception;

	public Persona getPersona(Long idPers) throws Exception;

	public List<Persona> findByCriteriaInPersona(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Persona> findPagePersona(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberPersona() throws Exception;

	public List<PersonaDTO> getDataPersona() throws Exception;

	public List<PresupuestoCartera> getPresupuestoCartera() throws Exception;

	public void savePresupuestoCartera(PresupuestoCartera entity)
			throws Exception;

	public void deletePresupuestoCartera(PresupuestoCartera entity)
			throws Exception;

	public void updatePresupuestoCartera(PresupuestoCartera entity)
			throws Exception;

	public PresupuestoCartera getPresupuestoCartera(Long idPrca)
			throws Exception;

	public List<PresupuestoCartera> findByCriteriaInPresupuestoCartera(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<PresupuestoCartera> findPagePresupuestoCartera(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberPresupuestoCartera() throws Exception;

	public List<PresupuestoCarteraDTO> getDataPresupuestoCartera()
			throws Exception;

	public List<PresupuestoVentas> getPresupuestoVentas() throws Exception;

	public void savePresupuestoVentas(PresupuestoVentas entity)
			throws Exception;

	public void deletePresupuestoVentas(PresupuestoVentas entity)
			throws Exception;

	public void updatePresupuestoVentas(PresupuestoVentas entity)
			throws Exception;

	public PresupuestoVentas getPresupuestoVentas(Long idPven) throws Exception;

	public List<PresupuestoVentas> findByCriteriaInPresupuestoVentas(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<PresupuestoVentas> findPagePresupuestoVentas(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberPresupuestoVentas() throws Exception;

	public List<PresupuestoVentasDTO> getDataPresupuestoVentas()
			throws Exception;

	public List<ProgramacionAdicional> getProgramacionAdicional()
			throws Exception;

	public void saveProgramacionAdicional(ProgramacionAdicional entity)
			throws Exception;

	public void deleteProgramacionAdicional(ProgramacionAdicional entity)
			throws Exception;

	public void updateProgramacionAdicional(ProgramacionAdicional entity)
			throws Exception;

	public ProgramacionAdicional getProgramacionAdicional(Long idPrad)
			throws Exception;

	public List<ProgramacionAdicional> findByCriteriaInProgramacionAdicional(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ProgramacionAdicional> findPageProgramacionAdicional(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberProgramacionAdicional() throws Exception;

	public List<ProgramacionAdicionalDTO> getDataProgramacionAdicional()
			throws Exception;

	public List<ProgramacionVisitas> getProgramacionVisitas() throws Exception;

	public void saveProgramacionVisitas(ProgramacionVisitas entity)
			throws Exception;

	public void deleteProgramacionVisitas(ProgramacionVisitas entity)
			throws Exception;

	public void updateProgramacionVisitas(ProgramacionVisitas entity)
			throws Exception;

	public ProgramacionVisitas getProgramacionVisitas(Long idPrvi)
			throws Exception;

	public List<ProgramacionVisitas> findByCriteriaInProgramacionVisitas(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ProgramacionVisitas> findPageProgramacionVisitas(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberProgramacionVisitas() throws Exception;

	public List<ProgramacionVisitasDTO> getDataProgramacionVisitas()
			throws Exception;

	public List<PronosticoVenta> getPronosticoVenta() throws Exception;

	public void savePronosticoVenta(PronosticoVenta entity) throws Exception;

	public void deletePronosticoVenta(PronosticoVenta entity) throws Exception;

	public void updatePronosticoVenta(PronosticoVenta entity) throws Exception;

	public PronosticoVenta getPronosticoVenta(Long idPtcv) throws Exception;

	public List<PronosticoVenta> findByCriteriaInPronosticoVenta(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<PronosticoVenta> findPagePronosticoVenta(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberPronosticoVenta() throws Exception;

	public List<PronosticoVentaDTO> getDataPronosticoVenta() throws Exception;

	public List<Proveedor> getProveedor() throws Exception;

	public void saveProveedor(Proveedor entity) throws Exception;

	public void deleteProveedor(Proveedor entity) throws Exception;

	public void updateProveedor(Proveedor entity) throws Exception;

	public Proveedor getProveedor(Long idProv) throws Exception;

	public List<Proveedor> findByCriteriaInProveedor(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Proveedor> findPageProveedor(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberProveedor() throws Exception;

	public List<ProveedorDTO> getDataProveedor() throws Exception;

	public List<RboDetalleDocumentos> getRboDetalleDocumentos()
			throws Exception;

	public void saveRboDetalleDocumentos(RboDetalleDocumentos entity)
			throws Exception;

	public void deleteRboDetalleDocumentos(RboDetalleDocumentos entity)
			throws Exception;

	public void updateRboDetalleDocumentos(RboDetalleDocumentos entity)
			throws Exception;

	public RboDetalleDocumentos getRboDetalleDocumentos(Long idRddo)
			throws Exception;

	public List<RboDetalleDocumentos> findByCriteriaInRboDetalleDocumentos(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<RboDetalleDocumentos> findPageRboDetalleDocumentos(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberRboDetalleDocumentos() throws Exception;

	public List<RboDetalleDocumentosDTO> getDataRboDetalleDocumentos()
			throws Exception;

	public List<RboDetalleFormasPago> getRboDetalleFormasPago()
			throws Exception;

	public void saveRboDetalleFormasPago(RboDetalleFormasPago entity)
			throws Exception;

	public void deleteRboDetalleFormasPago(RboDetalleFormasPago entity)
			throws Exception;

	public void updateRboDetalleFormasPago(RboDetalleFormasPago entity)
			throws Exception;

	public RboDetalleFormasPago getRboDetalleFormasPago(Long idRdfp)
			throws Exception;

	public List<RboDetalleFormasPago> findByCriteriaInRboDetalleFormasPago(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<RboDetalleFormasPago> findPageRboDetalleFormasPago(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberRboDetalleFormasPago() throws Exception;

	public List<RboDetalleFormasPagoDTO> getDataRboDetalleFormasPago()
			throws Exception;

	public List<Recibo> getRecibo() throws Exception;

	public void saveRecibo(Recibo entity) throws Exception;

	public void deleteRecibo(Recibo entity) throws Exception;

	public void updateRecibo(Recibo entity) throws Exception;

	public Recibo getRecibo(Long idRcbo) throws Exception;

	public List<Recibo> findByCriteriaInRecibo(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Recibo> findPageRecibo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberRecibo() throws Exception;

	public List<ReciboDTO> getDataRecibo() throws Exception;

	public List<Referencia> getReferencia() throws Exception;

	public void saveReferencia(Referencia entity) throws Exception;

	public void deleteReferencia(Referencia entity) throws Exception;

	public void updateReferencia(Referencia entity) throws Exception;

	public Referencia getReferencia(Long idRefe) throws Exception;

	public List<Referencia> findByCriteriaInReferencia(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Referencia> findPageReferencia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberReferencia() throws Exception;

	public List<ReferenciaDTO> getDataReferencia() throws Exception;

	public List<ReferenciaSucursal> getReferenciaSucursal() throws Exception;

	public void saveReferenciaSucursal(ReferenciaSucursal entity)
			throws Exception;

	public void deleteReferenciaSucursal(ReferenciaSucursal entity)
			throws Exception;

	public void updateReferenciaSucursal(ReferenciaSucursal entity)
			throws Exception;

	public ReferenciaSucursal getReferenciaSucursal(Long idResu)
			throws Exception;

	public List<ReferenciaSucursal> findByCriteriaInReferenciaSucursal(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<ReferenciaSucursal> findPageReferenciaSucursal(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberReferenciaSucursal() throws Exception;

	public List<ReferenciaSucursalDTO> getDataReferenciaSucursal()
			throws Exception;

	public List<RegionalGeografica> getRegionalGeografica() throws Exception;

	public void saveRegionalGeografica(RegionalGeografica entity)
			throws Exception;

	public void deleteRegionalGeografica(RegionalGeografica entity)
			throws Exception;

	public void updateRegionalGeografica(RegionalGeografica entity)
			throws Exception;

	public RegionalGeografica getRegionalGeografica(Long idRege)
			throws Exception;

	public List<RegionalGeografica> findByCriteriaInRegionalGeografica(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<RegionalGeografica> findPageRegionalGeografica(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberRegionalGeografica() throws Exception;

	public List<RegionalGeograficaDTO> getDataRegionalGeografica()
			throws Exception;

	public List<RelacionComercial> getRelacionComercial() throws Exception;

	public void saveRelacionComercial(RelacionComercial entity)
			throws Exception;

	public void deleteRelacionComercial(RelacionComercial entity)
			throws Exception;

	public void updateRelacionComercial(RelacionComercial entity)
			throws Exception;

	public RelacionComercial getRelacionComercial(Long idReco) throws Exception;

	public List<RelacionComercial> findByCriteriaInRelacionComercial(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<RelacionComercial> findPageRelacionComercial(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberRelacionComercial() throws Exception;

	public List<RelacionComercialDTO> getDataRelacionComercial()
			throws Exception;

	public List<RutaDistribucion> getRutaDistribucion() throws Exception;

	public void saveRutaDistribucion(RutaDistribucion entity) throws Exception;

	public void deleteRutaDistribucion(RutaDistribucion entity)
			throws Exception;

	public void updateRutaDistribucion(RutaDistribucion entity)
			throws Exception;

	public RutaDistribucion getRutaDistribucion(Long idRudi) throws Exception;

	public List<RutaDistribucion> findByCriteriaInRutaDistribucion(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<RutaDistribucion> findPageRutaDistribucion(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberRutaDistribucion() throws Exception;

	public List<RutaDistribucionDTO> getDataRutaDistribucion() throws Exception;

	public List<RutaRelacionComercial> getRutaRelacionComercial()
			throws Exception;

	public void saveRutaRelacionComercial(RutaRelacionComercial entity)
			throws Exception;

	public void deleteRutaRelacionComercial(RutaRelacionComercial entity)
			throws Exception;

	public void updateRutaRelacionComercial(RutaRelacionComercial entity)
			throws Exception;

	public RutaRelacionComercial getRutaRelacionComercial(Long idRrec)
			throws Exception;

	public List<RutaRelacionComercial> findByCriteriaInRutaRelacionComercial(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<RutaRelacionComercial> findPageRutaRelacionComercial(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberRutaRelacionComercial() throws Exception;

	public List<RutaRelacionComercialDTO> getDataRutaRelacionComercial()
			throws Exception;

	public List<SaldoInicialInventario> getSaldoInicialInventario()
			throws Exception;

	public void saveSaldoInicialInventario(SaldoInicialInventario entity)
			throws Exception;

	public void deleteSaldoInicialInventario(SaldoInicialInventario entity)
			throws Exception;

	public void updateSaldoInicialInventario(SaldoInicialInventario entity)
			throws Exception;

	public SaldoInicialInventario getSaldoInicialInventario(Long idSini)
			throws Exception;

	public List<SaldoInicialInventario> findByCriteriaInSaldoInicialInventario(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<SaldoInicialInventario> findPageSaldoInicialInventario(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberSaldoInicialInventario() throws Exception;

	public List<SaldoInicialInventarioDTO> getDataSaldoInicialInventario()
			throws Exception;

	public List<Semana> getSemana() throws Exception;

	public void saveSemana(Semana entity) throws Exception;

	public void deleteSemana(Semana entity) throws Exception;

	public void updateSemana(Semana entity) throws Exception;

	public Semana getSemana(Long idSema) throws Exception;

	public List<Semana> findByCriteriaInSemana(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Semana> findPageSemana(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberSemana() throws Exception;

	public List<SemanaDTO> getDataSemana() throws Exception;

	public List<SolicitudCambio> getSolicitudCambio() throws Exception;

	public void saveSolicitudCambio(SolicitudCambio entity) throws Exception;

	public void deleteSolicitudCambio(SolicitudCambio entity) throws Exception;

	public void updateSolicitudCambio(SolicitudCambio entity) throws Exception;

	public SolicitudCambio getSolicitudCambio(Long idSocb) throws Exception;

	public List<SolicitudCambio> findByCriteriaInSolicitudCambio(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<SolicitudCambio> findPageSolicitudCambio(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberSolicitudCambio() throws Exception;

	public List<SolicitudCambioDTO> getDataSolicitudCambio() throws Exception;

	public List<SolicitudCampo> getSolicitudCampo() throws Exception;

	public void saveSolicitudCampo(SolicitudCampo entity) throws Exception;

	public void deleteSolicitudCampo(SolicitudCampo entity) throws Exception;

	public void updateSolicitudCampo(SolicitudCampo entity) throws Exception;

	public SolicitudCampo getSolicitudCampo(Long idSoca) throws Exception;

	public List<SolicitudCampo> findByCriteriaInSolicitudCampo(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<SolicitudCampo> findPageSolicitudCampo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberSolicitudCampo() throws Exception;

	public List<SolicitudCampoDTO> getDataSolicitudCampo() throws Exception;

	public List<StockInventarioMensual> getStockInventarioMensual()
			throws Exception;

	public void saveStockInventarioMensual(StockInventarioMensual entity)
			throws Exception;

	public void deleteStockInventarioMensual(StockInventarioMensual entity)
			throws Exception;

	public void updateStockInventarioMensual(StockInventarioMensual entity)
			throws Exception;

	public StockInventarioMensual getStockInventarioMensual(Long idStin)
			throws Exception;

	public List<StockInventarioMensual> findByCriteriaInStockInventarioMensual(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<StockInventarioMensual> findPageStockInventarioMensual(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberStockInventarioMensual() throws Exception;

	public List<StockInventarioMensualDTO> getDataStockInventarioMensual()
			throws Exception;

	public List<Sucursal> getSucursal() throws Exception;

	public void saveSucursal(Sucursal entity) throws Exception;

	public void deleteSucursal(Sucursal entity) throws Exception;

	public void updateSucursal(Sucursal entity) throws Exception;

	public Sucursal getSucursal(Long idSucu) throws Exception;

	public List<Sucursal> findByCriteriaInSucursal(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Sucursal> findPageSucursal(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberSucursal() throws Exception;

	public List<SucursalDTO> getDataSucursal() throws Exception;

	public List<Tabla> getTabla() throws Exception;

	public void saveTabla(Tabla entity) throws Exception;

	public void deleteTabla(Tabla entity) throws Exception;

	public void updateTabla(Tabla entity) throws Exception;

	public Tabla getTabla(Long idTabl) throws Exception;

	public List<Tabla> findByCriteriaInTabla(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Tabla> findPageTabla(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTabla() throws Exception;

	public List<TablaDTO> getDataTabla() throws Exception;

	public List<TipoCartera> getTipoCartera() throws Exception;

	public void saveTipoCartera(TipoCartera entity) throws Exception;

	public void deleteTipoCartera(TipoCartera entity) throws Exception;

	public void updateTipoCartera(TipoCartera entity) throws Exception;

	public TipoCartera getTipoCartera(Long idTica) throws Exception;

	public List<TipoCartera> findByCriteriaInTipoCartera(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<TipoCartera> findPageTipoCartera(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipoCartera() throws Exception;

	public List<TipoCarteraDTO> getDataTipoCartera() throws Exception;

	public List<TipoCausal> getTipoCausal() throws Exception;

	public void saveTipoCausal(TipoCausal entity) throws Exception;

	public void deleteTipoCausal(TipoCausal entity) throws Exception;

	public void updateTipoCausal(TipoCausal entity) throws Exception;

	public TipoCausal getTipoCausal(Long idTcau) throws Exception;

	public List<TipoCausal> findByCriteriaInTipoCausal(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<TipoCausal> findPageTipoCausal(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipoCausal() throws Exception;

	public List<TipoCausalDTO> getDataTipoCausal() throws Exception;

	public List<TipoContacto> getTipoContacto() throws Exception;

	public void saveTipoContacto(TipoContacto entity) throws Exception;

	public void deleteTipoContacto(TipoContacto entity) throws Exception;

	public void updateTipoContacto(TipoContacto entity) throws Exception;

	public TipoContacto getTipoContacto(Long idTico) throws Exception;

	public List<TipoContacto> findByCriteriaInTipoContacto(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<TipoContacto> findPageTipoContacto(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipoContacto() throws Exception;

	public List<TipoContactoDTO> getDataTipoContacto() throws Exception;

	public List<TipoDivision> getTipoDivision() throws Exception;

	public void saveTipoDivision(TipoDivision entity) throws Exception;

	public void deleteTipoDivision(TipoDivision entity) throws Exception;

	public void updateTipoDivision(TipoDivision entity) throws Exception;

	public TipoDivision getTipoDivision(Long idTidi) throws Exception;

	public List<TipoDivision> findByCriteriaInTipoDivision(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<TipoDivision> findPageTipoDivision(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipoDivision() throws Exception;

	public List<TipoDivisionDTO> getDataTipoDivision() throws Exception;

	public List<TipoDocumento> getTipoDocumento() throws Exception;

	public void saveTipoDocumento(TipoDocumento entity) throws Exception;

	public void deleteTipoDocumento(TipoDocumento entity) throws Exception;

	public void updateTipoDocumento(TipoDocumento entity) throws Exception;

	public TipoDocumento getTipoDocumento(Long idTido) throws Exception;

	public List<TipoDocumento> findByCriteriaInTipoDocumento(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoDocumento> findPageTipoDocumento(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipoDocumento() throws Exception;

	public List<TipoDocumentoDTO> getDataTipoDocumento() throws Exception;

	public List<TipoFormaPago> getTipoFormaPago() throws Exception;

	public void saveTipoFormaPago(TipoFormaPago entity) throws Exception;

	public void deleteTipoFormaPago(TipoFormaPago entity) throws Exception;

	public void updateTipoFormaPago(TipoFormaPago entity) throws Exception;

	public TipoFormaPago getTipoFormaPago(Long idTfpa) throws Exception;

	public List<TipoFormaPago> findByCriteriaInTipoFormaPago(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoFormaPago> findPageTipoFormaPago(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipoFormaPago() throws Exception;

	public List<TipoFormaPagoDTO> getDataTipoFormaPago() throws Exception;

	public List<TipoGarantia> getTipoGarantia() throws Exception;

	public void saveTipoGarantia(TipoGarantia entity) throws Exception;

	public void deleteTipoGarantia(TipoGarantia entity) throws Exception;

	public void updateTipoGarantia(TipoGarantia entity) throws Exception;

	public TipoGarantia getTipoGarantia(Long idTiga) throws Exception;

	public List<TipoGarantia> findByCriteriaInTipoGarantia(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<TipoGarantia> findPageTipoGarantia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipoGarantia() throws Exception;

	public List<TipoGarantiaDTO> getDataTipoGarantia() throws Exception;

	public List<TipoIdentificacion> getTipoIdentificacion() throws Exception;

	public void saveTipoIdentificacion(TipoIdentificacion entity)
			throws Exception;

	public void deleteTipoIdentificacion(TipoIdentificacion entity)
			throws Exception;

	public void updateTipoIdentificacion(TipoIdentificacion entity)
			throws Exception;

	public TipoIdentificacion getTipoIdentificacion(Long idTiid)
			throws Exception;

	public List<TipoIdentificacion> findByCriteriaInTipoIdentificacion(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<TipoIdentificacion> findPageTipoIdentificacion(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberTipoIdentificacion() throws Exception;

	public List<TipoIdentificacionDTO> getDataTipoIdentificacion()
			throws Exception;

	public List<TipoLista> getTipoLista() throws Exception;

	public void saveTipoLista(TipoLista entity) throws Exception;

	public void deleteTipoLista(TipoLista entity) throws Exception;

	public void updateTipoLista(TipoLista entity) throws Exception;

	public TipoLista getTipoLista(Long idTili) throws Exception;

	public List<TipoLista> findByCriteriaInTipoLista(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<TipoLista> findPageTipoLista(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipoLista() throws Exception;

	public List<TipoListaDTO> getDataTipoLista() throws Exception;

	public List<TipoSucursal> getTipoSucursal() throws Exception;

	public void saveTipoSucursal(TipoSucursal entity) throws Exception;

	public void deleteTipoSucursal(TipoSucursal entity) throws Exception;

	public void updateTipoSucursal(TipoSucursal entity) throws Exception;

	public TipoSucursal getTipoSucursal(Long idTisu) throws Exception;

	public List<TipoSucursal> findByCriteriaInTipoSucursal(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<TipoSucursal> findPageTipoSucursal(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipoSucursal() throws Exception;

	public List<TipoSucursalDTO> getDataTipoSucursal() throws Exception;

	public List<UnidadNegocio> getUnidadNegocio() throws Exception;

	public void saveUnidadNegocio(UnidadNegocio entity) throws Exception;

	public void deleteUnidadNegocio(UnidadNegocio entity) throws Exception;

	public void updateUnidadNegocio(UnidadNegocio entity) throws Exception;

	public UnidadNegocio getUnidadNegocio(Long idUnne) throws Exception;

	public List<UnidadNegocio> findByCriteriaInUnidadNegocio(
			Object[] variables, Object[] variablesBetween,
			Object[] variablesBetweenDates) throws Exception;

	public List<UnidadNegocio> findPageUnidadNegocio(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberUnidadNegocio() throws Exception;

	public List<UnidadNegocioDTO> getDataUnidadNegocio() throws Exception;

	public List<UnidadVenta> getUnidadVenta() throws Exception;

	public void saveUnidadVenta(UnidadVenta entity) throws Exception;

	public void deleteUnidadVenta(UnidadVenta entity) throws Exception;

	public void updateUnidadVenta(UnidadVenta entity) throws Exception;

	public UnidadVenta getUnidadVenta(Long idUnve) throws Exception;

	public List<UnidadVenta> findByCriteriaInUnidadVenta(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<UnidadVenta> findPageUnidadVenta(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberUnidadVenta() throws Exception;

	public List<UnidadVentaDTO> getDataUnidadVenta() throws Exception;

	public List<Vendedor> getVendedor() throws Exception;

	public void saveVendedor(Vendedor entity) throws Exception;

	public void deleteVendedor(Vendedor entity) throws Exception;

	public void updateVendedor(Vendedor entity) throws Exception;

	public Vendedor getVendedor(Long idVend) throws Exception;

	public List<Vendedor> findByCriteriaInVendedor(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Vendedor> findPageVendedor(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberVendedor() throws Exception;

	public List<VendedorDTO> getDataVendedor() throws Exception;

	public List<Visita> getVisita() throws Exception;

	public void saveVisita(Visita entity) throws Exception;

	public void deleteVisita(Visita entity) throws Exception;

	public void updateVisita(Visita entity) throws Exception;

	public Visita getVisita(Long idVisi) throws Exception;

	public List<Visita> findByCriteriaInVisita(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Visita> findPageVisita(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberVisita() throws Exception;

	public List<VisitaDTO> getDataVisita() throws Exception;

	public List<GrupoReferencia> consultarPorGrupo(String propertyName,
			Object value) throws Exception;

	public List<Empresa> consultarEmpresa() throws Exception;

	public List<Sucursal> consultarPorIdEmpr(String propertyName, Object value)
			throws Exception;

	public List<RelacionComercial> consultarRelacionPropiedad(
			String propertyName, Object value) throws Exception;
}
