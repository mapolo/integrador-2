package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.ICarteraDAO;
import co.edu.usbcali.dataaccess.dao.IDetalleVisitaDAO;
import co.edu.usbcali.dataaccess.dao.IDocumentoDAO;
import co.edu.usbcali.dataaccess.dao.IGarantiaDAO;
import co.edu.usbcali.dataaccess.dao.IItemRotacionDAO;
import co.edu.usbcali.dataaccess.dao.ILogisticaReversivaDAO;
import co.edu.usbcali.dataaccess.dao.IMovimientoInventarioDAO;
import co.edu.usbcali.dataaccess.dao.IOrdenesDeCompraDAO;
import co.edu.usbcali.dataaccess.dao.IPedidoDAO;
import co.edu.usbcali.dataaccess.dao.IRboDetalleDocumentosDAO;
import co.edu.usbcali.dataaccess.dao.IRboDetalleFormasPagoDAO;
import co.edu.usbcali.dataaccess.dao.IReciboDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.Cartera;
import co.edu.usbcali.modelo.DetalleVisita;
import co.edu.usbcali.modelo.Documento;
import co.edu.usbcali.modelo.Garantia;
import co.edu.usbcali.modelo.ItemRotacion;
import co.edu.usbcali.modelo.LogisticaReversiva;
import co.edu.usbcali.modelo.MovimientoInventario;
import co.edu.usbcali.modelo.OrdenesDeCompra;
import co.edu.usbcali.modelo.Pedido;
import co.edu.usbcali.modelo.RboDetalleDocumentos;
import co.edu.usbcali.modelo.RboDetalleFormasPago;
import co.edu.usbcali.modelo.Recibo;
import co.edu.usbcali.modelo.dto.DocumentoDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("DocumentoLogic")
public class DocumentoLogic implements IDocumentoLogic {
	/**
	 * DAO injected by Spring that manages Documento entities
	 * 
	 */
	@Autowired
	private IDocumentoDAO documentoDAO;

	/**
	 * DAO injected by Spring that manages Cartera entities
	 * 
	 */
	@Autowired
	private ICarteraDAO carteraDAO;

	/**
	 * DAO injected by Spring that manages DetalleVisita entities
	 * 
	 */
	@Autowired
	private IDetalleVisitaDAO detalleVisitaDAO;

	/**
	 * DAO injected by Spring that manages Garantia entities
	 * 
	 */
	@Autowired
	private IGarantiaDAO garantiaDAO;

	/**
	 * DAO injected by Spring that manages ItemRotacion entities
	 * 
	 */
	@Autowired
	private IItemRotacionDAO itemRotacionDAO;

	/**
	 * DAO injected by Spring that manages LogisticaReversiva entities
	 * 
	 */
	@Autowired
	private ILogisticaReversivaDAO logisticaReversivaDAO;

	/**
	 * DAO injected by Spring that manages LogisticaReversiva entities
	 * 
	 */

	/**
	 * DAO injected by Spring that manages LogisticaReversiva entities
	 * 
	 */

	/**
	 * DAO injected by Spring that manages MovimientoInventario entities
	 * 
	 */
	@Autowired
	private IMovimientoInventarioDAO movimientoInventarioDAO;

	/**
	 * DAO injected by Spring that manages OrdenesDeCompra entities
	 * 
	 */
	@Autowired
	private IOrdenesDeCompraDAO ordenesDeCompraDAO;

	/**
	 * DAO injected by Spring that manages Pedido entities
	 * 
	 */
	@Autowired
	private IPedidoDAO pedidoDAO;

	/**
	 * DAO injected by Spring that manages RboDetalleDocumentos entities
	 * 
	 */
	@Autowired
	private IRboDetalleDocumentosDAO rboDetalleDocumentosDAO;

	/**
	 * DAO injected by Spring that manages RboDetalleFormasPago entities
	 * 
	 */
	@Autowired
	private IRboDetalleFormasPagoDAO rboDetalleFormasPagoDAO;

	/**
	 * DAO injected by Spring that manages Recibo entities
	 * 
	 */
	@Autowired
	private IReciboDAO reciboDAO;

	/**
	 * Logic injected by Spring that manages Causal entities
	 * 
	 */
	@Autowired
	ICausalLogic logicCausal1;

	/**
	 * Logic injected by Spring that manages ConsecutivoDocumento entities
	 * 
	 */
	@Autowired
	IConsecutivoDocumentoLogic logicConsecutivoDocumento2;

	/**
	 * Logic injected by Spring that manages EstadoDocumento entities
	 * 
	 */
	@Autowired
	IEstadoDocumentoLogic logicEstadoDocumento3;

	/**
	 * Logic injected by Spring that manages RelacionComercial entities
	 * 
	 */
	@Autowired
	IRelacionComercialLogic logicRelacionComercial4;

	/**
	 * Logic injected by Spring that manages Sucursal entities
	 * 
	 */
	@Autowired
	ISucursalLogic logicSucursal5;

	/**
	 * Logic injected by Spring that manages TipoDocumento entities
	 * 
	 */
	@Autowired
	ITipoDocumentoLogic logicTipoDocumento6;

	/**
	 * Logic injected by Spring that manages UnidadVenta entities
	 * 
	 */
	@Autowired
	IUnidadVentaLogic logicUnidadVenta7;

	/**
	 * Logic injected by Spring that manages UnidadVenta entities
	 * 
	 */
	@Autowired
	IUnidadVentaLogic logicUnidadVenta8;

	@Transactional(readOnly = true)
	public List<Documento> getDocumento() throws Exception {
		List<Documento> list = new ArrayList<Documento>();

		try {
			list = documentoDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "Documento");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDocumento(Documento entity) throws Exception {
		try {
			if (entity.getCausal() == null) {
				throw new ZMessManager().new ForeignException("causal");
			}

			if (entity.getConsecutivoDocumento() == null) {
				throw new ZMessManager().new ForeignException(
						"consecutivoDocumento");
			}

			if (entity.getEstadoDocumento() == null) {
				throw new ZMessManager().new ForeignException("estadoDocumento");
			}

			if (entity.getRelacionComercial() == null) {
				throw new ZMessManager().new ForeignException(
						"relacionComercial");
			}

			if (entity.getSucursal() == null) {
				throw new ZMessManager().new ForeignException("sucursal");
			}

			if (entity.getTipoDocumento() == null) {
				throw new ZMessManager().new ForeignException("tipoDocumento");
			}

			if (entity.getUnidadVentaByIdTelemercaderista() == null) {
				throw new ZMessManager().new ForeignException(
						"unidadVentaByIdTelemercaderista");
			}

			if (entity.getUnidadVentaByIdUnve() == null) {
				throw new ZMessManager().new ForeignException(
						"unidadVentaByIdUnve");
			}

			if (entity.getEstadoRegistro() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"estadoRegistro");
			}

			if ((entity.getEstadoRegistro() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEstadoRegistro(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"estadoRegistro");
			}

			if (entity.getFechaCreacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaCreacion");
			}

			if (entity.getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaModificacion");
			}

			if (entity.getIdDocu() == null) {
				throw new ZMessManager().new EmptyFieldException("idDocu");
			}

			if ((entity.getIdDocu() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdDocu(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idDocu");
			}

			if ((entity.getNumeroDefinitivo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNumeroDefinitivo(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroDefinitivo");
			}

			if ((entity.getNumeroDocumento() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroDocumento(), 20, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroDocumento");
			}

			if (entity.getOperCreador() == null) {
				throw new ZMessManager().new EmptyFieldException("operCreador");
			}

			if ((entity.getOperCreador() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getOperCreador(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"operCreador");
			}

			if (entity.getOperModifica() == null) {
				throw new ZMessManager().new EmptyFieldException("operModifica");
			}

			if ((entity.getOperModifica() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getOperModifica(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"operModifica");
			}

			if ((entity.getValorTotal() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getValorTotal(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"valorTotal");
			}

			if (entity.getCausal().getIdCusa() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idCusa_Causal");
			}

			if ((entity.getCausal().getIdCusa() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCausal().getIdCusa(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idCusa_Causal");
			}

			if (entity.getConsecutivoDocumento().getIdCodo() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idCodo_ConsecutivoDocumento");
			}

			if ((entity.getConsecutivoDocumento().getIdCodo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getConsecutivoDocumento().getIdCodo(), 10,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idCodo_ConsecutivoDocumento");
			}

			if (entity.getEstadoDocumento().getIdEsdo() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idEsdo_EstadoDocumento");
			}

			if ((entity.getEstadoDocumento().getIdEsdo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getEstadoDocumento().getIdEsdo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idEsdo_EstadoDocumento");
			}

			if (entity.getRelacionComercial().getIdReco() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idReco_RelacionComercial");
			}

			if ((entity.getRelacionComercial().getIdReco() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getRelacionComercial().getIdReco(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idReco_RelacionComercial");
			}

			if (entity.getSucursal().getIdSucu() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idSucu_Sucursal");
			}

			if ((entity.getSucursal().getIdSucu() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getSucursal().getIdSucu(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idSucu_Sucursal");
			}

			if (entity.getTipoDocumento().getIdTido() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idTido_TipoDocumento");
			}

			if ((entity.getTipoDocumento().getIdTido() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getTipoDocumento().getIdTido(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idTido_TipoDocumento");
			}

			if (getDocumento(entity.getIdDocu()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			documentoDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDocumento(Documento entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Documento");
		}

		if (entity.getIdDocu() == null) {
			throw new ZMessManager().new EmptyFieldException("idDocu");
		}

		List<Cartera> carteras = null;
		List<DetalleVisita> detalleVisitas = null;
		List<Garantia> garantias = null;
		List<ItemRotacion> itemRotacions = null;
		List<LogisticaReversiva> logisticaReversivasForDocumentoAutorizacion = null;
		List<LogisticaReversiva> logisticaReversivasForDocumentoRecoleccion = null;
		List<LogisticaReversiva> logisticaReversivasForDocumentoSolicitud = null;
		List<MovimientoInventario> movimientoInventarios = null;
		List<OrdenesDeCompra> ordenesDeCompras = null;
		List<Pedido> pedidos = null;
		List<RboDetalleDocumentos> rboDetalleDocumentoses = null;
		List<RboDetalleFormasPago> rboDetalleFormasPagos = null;
		List<Recibo> recibos = null;

		try {
			carteras = carteraDAO.findByProperty("documento.idDocu",
					entity.getIdDocu());

			if (Utilities.validationsList(carteras) == true) {
				throw new ZMessManager().new DeletingException("carteras");
			}

			detalleVisitas = detalleVisitaDAO.findByProperty(
					"documento.idDocu", entity.getIdDocu());

			if (Utilities.validationsList(detalleVisitas) == true) {
				throw new ZMessManager().new DeletingException("detalleVisitas");
			}

			garantias = garantiaDAO.findByProperty("documento.idDocu",
					entity.getIdDocu());

			if (Utilities.validationsList(garantias) == true) {
				throw new ZMessManager().new DeletingException("garantias");
			}

			itemRotacions = itemRotacionDAO.findByProperty("documento.idDocu",
					entity.getIdDocu());

			if (Utilities.validationsList(itemRotacions) == true) {
				throw new ZMessManager().new DeletingException("itemRotacions");
			}

			logisticaReversivasForDocumentoAutorizacion = logisticaReversivaDAO
					.findByProperty("documento.idDocu", entity.getIdDocu());

			if (Utilities
					.validationsList(logisticaReversivasForDocumentoAutorizacion) == true) {
				throw new ZMessManager().new DeletingException(
						"logisticaReversivasForDocumentoAutorizacion");
			}

			logisticaReversivasForDocumentoRecoleccion = logisticaReversivaDAO
					.findByProperty("documento.idDocu", entity.getIdDocu());

			if (Utilities
					.validationsList(logisticaReversivasForDocumentoRecoleccion) == true) {
				throw new ZMessManager().new DeletingException(
						"logisticaReversivasForDocumentoRecoleccion");
			}

			logisticaReversivasForDocumentoSolicitud = logisticaReversivaDAO
					.findByProperty("documento.idDocu", entity.getIdDocu());

			if (Utilities
					.validationsList(logisticaReversivasForDocumentoSolicitud) == true) {
				throw new ZMessManager().new DeletingException(
						"logisticaReversivasForDocumentoSolicitud");
			}

			movimientoInventarios = movimientoInventarioDAO.findByProperty(
					"documento.idDocu", entity.getIdDocu());

			if (Utilities.validationsList(movimientoInventarios) == true) {
				throw new ZMessManager().new DeletingException(
						"movimientoInventarios");
			}

			ordenesDeCompras = ordenesDeCompraDAO.findByProperty(
					"documento.idDocu", entity.getIdDocu());

			if (Utilities.validationsList(ordenesDeCompras) == true) {
				throw new ZMessManager().new DeletingException(
						"ordenesDeCompras");
			}

			pedidos = pedidoDAO.findByProperty("documento.idDocu",
					entity.getIdDocu());

			if (Utilities.validationsList(pedidos) == true) {
				throw new ZMessManager().new DeletingException("pedidos");
			}

			rboDetalleDocumentoses = rboDetalleDocumentosDAO.findByProperty(
					"documento.idDocu", entity.getIdDocu());

			if (Utilities.validationsList(rboDetalleDocumentoses) == true) {
				throw new ZMessManager().new DeletingException(
						"rboDetalleDocumentoses");
			}

			rboDetalleFormasPagos = rboDetalleFormasPagoDAO.findByProperty(
					"documento.idDocu", entity.getIdDocu());

			if (Utilities.validationsList(rboDetalleFormasPagos) == true) {
				throw new ZMessManager().new DeletingException(
						"rboDetalleFormasPagos");
			}

			recibos = reciboDAO.findByProperty("documento.idDocu",
					entity.getIdDocu());

			if (Utilities.validationsList(recibos) == true) {
				throw new ZMessManager().new DeletingException("recibos");
			}

			documentoDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDocumento(Documento entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Documento");
			}

			if (entity.getCausal() == null) {
				throw new ZMessManager().new ForeignException("causal");
			}

			if (entity.getConsecutivoDocumento() == null) {
				throw new ZMessManager().new ForeignException(
						"consecutivoDocumento");
			}

			if (entity.getEstadoDocumento() == null) {
				throw new ZMessManager().new ForeignException("estadoDocumento");
			}

			if (entity.getRelacionComercial() == null) {
				throw new ZMessManager().new ForeignException(
						"relacionComercial");
			}

			if (entity.getSucursal() == null) {
				throw new ZMessManager().new ForeignException("sucursal");
			}

			if (entity.getTipoDocumento() == null) {
				throw new ZMessManager().new ForeignException("tipoDocumento");
			}

			if (entity.getUnidadVentaByIdTelemercaderista() == null) {
				throw new ZMessManager().new ForeignException(
						"unidadVentaByIdTelemercaderista");
			}

			if (entity.getUnidadVentaByIdUnve() == null) {
				throw new ZMessManager().new ForeignException(
						"unidadVentaByIdUnve");
			}

			if (entity.getEstadoRegistro() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"estadoRegistro");
			}

			if ((entity.getEstadoRegistro() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEstadoRegistro(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"estadoRegistro");
			}

			if (entity.getFechaCreacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaCreacion");
			}

			if (entity.getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaModificacion");
			}

			if (entity.getIdDocu() == null) {
				throw new ZMessManager().new EmptyFieldException("idDocu");
			}

			if ((entity.getIdDocu() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdDocu(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idDocu");
			}

			if ((entity.getNumeroDefinitivo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNumeroDefinitivo(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroDefinitivo");
			}

			if ((entity.getNumeroDocumento() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroDocumento(), 20, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroDocumento");
			}

			if (entity.getOperCreador() == null) {
				throw new ZMessManager().new EmptyFieldException("operCreador");
			}

			if ((entity.getOperCreador() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getOperCreador(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"operCreador");
			}

			if (entity.getOperModifica() == null) {
				throw new ZMessManager().new EmptyFieldException("operModifica");
			}

			if ((entity.getOperModifica() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getOperModifica(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"operModifica");
			}

			if ((entity.getValorTotal() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getValorTotal(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"valorTotal");
			}

			if (entity.getCausal().getIdCusa() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idCusa_Causal");
			}

			if ((entity.getCausal().getIdCusa() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCausal().getIdCusa(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idCusa_Causal");
			}

			if (entity.getConsecutivoDocumento().getIdCodo() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idCodo_ConsecutivoDocumento");
			}

			if ((entity.getConsecutivoDocumento().getIdCodo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getConsecutivoDocumento().getIdCodo(), 10,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idCodo_ConsecutivoDocumento");
			}

			if (entity.getEstadoDocumento().getIdEsdo() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idEsdo_EstadoDocumento");
			}

			if ((entity.getEstadoDocumento().getIdEsdo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getEstadoDocumento().getIdEsdo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idEsdo_EstadoDocumento");
			}

			if (entity.getRelacionComercial().getIdReco() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idReco_RelacionComercial");
			}

			if ((entity.getRelacionComercial().getIdReco() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getRelacionComercial().getIdReco(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idReco_RelacionComercial");
			}

			if (entity.getSucursal().getIdSucu() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idSucu_Sucursal");
			}

			if ((entity.getSucursal().getIdSucu() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getSucursal().getIdSucu(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idSucu_Sucursal");
			}

			if (entity.getTipoDocumento().getIdTido() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idTido_TipoDocumento");
			}

			if ((entity.getTipoDocumento().getIdTido() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getTipoDocumento().getIdTido(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idTido_TipoDocumento");
			}

			documentoDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<DocumentoDTO> getDataDocumento() throws Exception {
		try {
			List<Documento> documento = documentoDAO.findAll();

			List<DocumentoDTO> documentoDTO = new ArrayList<DocumentoDTO>();

			for (Documento documentoTmp : documento) {
				DocumentoDTO documentoDTO2 = new DocumentoDTO();

				documentoDTO2.setIdDocu(documentoTmp.getIdDocu());
				documentoDTO2.setEstadoRegistro((documentoTmp
						.getEstadoRegistro() != null) ? documentoTmp
						.getEstadoRegistro() : null);
				documentoDTO2.setFechaCreacion(documentoTmp.getFechaCreacion());
				documentoDTO2.setFechaDocumento(documentoTmp
						.getFechaDocumento());
				documentoDTO2.setFechaModificacion(documentoTmp
						.getFechaModificacion());
				documentoDTO2.setNumeroDefinitivo((documentoTmp
						.getNumeroDefinitivo() != null) ? documentoTmp
						.getNumeroDefinitivo() : null);
				documentoDTO2.setNumeroDocumento((documentoTmp
						.getNumeroDocumento() != null) ? documentoTmp
						.getNumeroDocumento() : null);
				documentoDTO2
						.setOperCreador((documentoTmp.getOperCreador() != null) ? documentoTmp
								.getOperCreador() : null);
				documentoDTO2
						.setOperModifica((documentoTmp.getOperModifica() != null) ? documentoTmp
								.getOperModifica() : null);
				documentoDTO2
						.setValorTotal((documentoTmp.getValorTotal() != null) ? documentoTmp
								.getValorTotal() : null);

				if (documentoTmp.getCausal() != null) {
					documentoDTO2.setIdCusa_Causal(documentoTmp.getCausal()
							.getIdCusa());
				} else {
					documentoDTO2.setIdCusa_Causal(null);
				}

				documentoDTO2
						.setIdCodo_ConsecutivoDocumento((documentoTmp
								.getConsecutivoDocumento().getIdCodo() != null) ? documentoTmp
								.getConsecutivoDocumento().getIdCodo() : null);
				documentoDTO2
						.setIdEsdo_EstadoDocumento((documentoTmp
								.getEstadoDocumento().getIdEsdo() != null) ? documentoTmp
								.getEstadoDocumento().getIdEsdo() : null);
				documentoDTO2
						.setIdReco_RelacionComercial((documentoTmp
								.getRelacionComercial().getIdReco() != null) ? documentoTmp
								.getRelacionComercial().getIdReco() : null);
				documentoDTO2.setIdSucu_Sucursal((documentoTmp.getSucursal()
						.getIdSucu() != null) ? documentoTmp.getSucursal()
						.getIdSucu() : null);
				documentoDTO2.setIdTido_TipoDocumento((documentoTmp
						.getTipoDocumento().getIdTido() != null) ? documentoTmp
						.getTipoDocumento().getIdTido() : null);

				documentoDTO.add(documentoDTO2);
			}

			return documentoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Documento getDocumento(Long idDocu) throws Exception {
		Documento entity = null;

		try {
			entity = documentoDAO.findById(idDocu);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Documento");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Documento> findPageDocumento(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Documento> entity = null;

		try {
			entity = documentoDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Documento Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberDocumento() throws Exception {
		Long entity = null;

		try {
			entity = documentoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Documento Count");
		} finally {
		}

		return entity;
	}

	/**
	 * 
	 * @param varibles
	 *            este arreglo debera tener:
	 * 
	 *            [0] = String variable = (String) varibles[i]; representa como
	 *            se llama la variable en el pojo
	 * 
	 *            [1] = Boolean booVariable = (Boolean) varibles[i + 1];
	 *            representa si el valor necesita o no ''(comillas simples)usado
	 *            para campos de tipo string
	 * 
	 *            [2] = Object value = varibles[i + 2]; representa el valor que
	 *            se va a buscar en la BD
	 * 
	 *            [3] = String comparator = (String) varibles[i + 3]; representa
	 *            que tipo de busqueda voy a hacer.., ejemplo: where
	 *            nombre=william o where nombre<>william, en este campo iria el
	 *            tipo de comparador que quiero si es = o <>
	 * 
	 *            Se itera de 4 en 4..., entonces 4 registros del arreglo
	 *            representan 1 busqueda en un campo, si se ponen mas pues el
	 *            continuara buscando en lo que se le ingresen en los otros 4
	 * 
	 * 
	 * @param variablesBetween
	 * 
	 *            la diferencia son estas dos posiciones
	 * 
	 *            [0] = String variable = (String) varibles[j]; la variable ne
	 *            la BD que va a ser buscada en un rango
	 * 
	 *            [1] = Object value = varibles[j + 1]; valor 1 para buscar en
	 *            un rango
	 * 
	 *            [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en
	 *            un rango ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria
	 *            value2
	 * 
	 *            [3] = String comparator1 = (String) varibles[j + 3];
	 *            comparador 1 ejemplo: a comparator1 1 and a < 5
	 * 
	 *            [4] = String comparator2 = (String) varibles[j + 4];
	 *            comparador 2 ejemplo: a comparador1>1 and a comparador2<5 (el
	 *            original: a > 1 and a < 5) *
	 * @param variablesBetweenDates
	 *            (en este caso solo para mysql) [0] = String variable =
	 *            (String) varibles[k]; el nombre de la variable que hace
	 *            referencia a una fecha
	 * 
	 *            [1] = Object object1 = varibles[k + 2]; fecha 1 a
	 *            comparar(deben ser dates)
	 * 
	 *            [2] = Object object2 = varibles[k + 3]; fecha 2 a
	 *            comparar(deben ser dates)
	 * 
	 *            esto hace un between entre las dos fechas.
	 * 
	 * @return lista con los objetos que se necesiten
	 * @throws Exception
	 */
	@Transactional(readOnly = true)
	public List<Documento> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Documento> list = new ArrayList<Documento>();
		String where = new String();
		String tempWhere = new String();

		if (variables != null) {
			for (int i = 0; i < variables.length; i++) {
				if ((variables[i] != null) && (variables[i + 1] != null)
						&& (variables[i + 2] != null)
						&& (variables[i + 3] != null)) {
					String variable = (String) variables[i];
					Boolean booVariable = (Boolean) variables[i + 1];
					Object value = variables[i + 2];
					String comparator = (String) variables[i + 3];

					if (booVariable.booleanValue()) {
						tempWhere = (tempWhere.length() == 0) ? ("(model."
								+ variable + " " + comparator + " \'" + value + "\' )")
								: (tempWhere + " AND (model." + variable + " "
										+ comparator + " \'" + value + "\' )");
					} else {
						tempWhere = (tempWhere.length() == 0) ? ("(model."
								+ variable + " " + comparator + " " + value + " )")
								: (tempWhere + " AND (model." + variable + " "
										+ comparator + " " + value + " )");
					}
				}

				i = i + 3;
			}
		}

		if (variablesBetween != null) {
			for (int j = 0; j < variablesBetween.length; j++) {
				if ((variablesBetween[j] != null)
						&& (variablesBetween[j + 1] != null)
						&& (variablesBetween[j + 2] != null)
						&& (variablesBetween[j + 3] != null)
						&& (variablesBetween[j + 4] != null)) {
					String variable = (String) variablesBetween[j];
					Object value = variablesBetween[j + 1];
					Object value2 = variablesBetween[j + 2];
					String comparator1 = (String) variablesBetween[j + 3];
					String comparator2 = (String) variablesBetween[j + 4];
					tempWhere = (tempWhere.length() == 0) ? ("(" + value + " "
							+ comparator1 + " " + variable + " and " + variable
							+ " " + comparator2 + " " + value2 + " )")
							: (tempWhere + " AND (" + value + " " + comparator1
									+ " " + variable + " and " + variable + " "
									+ comparator2 + " " + value2 + " )");
				}

				j = j + 4;
			}
		}

		if (variablesBetweenDates != null) {
			for (int k = 0; k < variablesBetweenDates.length; k++) {
				if ((variablesBetweenDates[k] != null)
						&& (variablesBetweenDates[k + 1] != null)
						&& (variablesBetweenDates[k + 2] != null)) {
					String variable = (String) variablesBetweenDates[k];
					Object object1 = variablesBetweenDates[k + 1];
					Object object2 = variablesBetweenDates[k + 2];
					String value = null;
					String value2 = null;

					try {
						Date date1 = (Date) object1;
						Date date2 = (Date) object2;
						value = Utilities
								.formatDateWithoutTimeInAStringForBetweenWhere(date1);
						value2 = Utilities
								.formatDateWithoutTimeInAStringForBetweenWhere(date2);
					} catch (Exception e) {
						list = null;
						throw e;
					}

					tempWhere = (tempWhere.length() == 0) ? ("(model."
							+ variable + " between \'" + value + "\' and \'"
							+ value2 + "\')") : (tempWhere + " AND (model."
							+ variable + " between \'" + value + "\' and \'"
							+ value2 + "\')");
				}

				k = k + 2;
			}
		}

		if (tempWhere.length() == 0) {
			where = null;
		} else {
			where = "(" + tempWhere + ")";
		}

		try {
			list = documentoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
