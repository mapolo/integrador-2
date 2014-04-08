package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.IGarantiaDAO;
import co.edu.usbcali.dataaccess.dao.IGrupoReferenciaDAO;
import co.edu.usbcali.dataaccess.dao.IItemLogisticaReversivaDAO;
import co.edu.usbcali.dataaccess.dao.IItemRotacionDAO;
import co.edu.usbcali.dataaccess.dao.IListaPreciosDAO;
import co.edu.usbcali.dataaccess.dao.IListaPreciosEspecialesDAO;
import co.edu.usbcali.dataaccess.dao.IOrdenesDeCompraDAO;
import co.edu.usbcali.dataaccess.dao.IPedidoDAO;
import co.edu.usbcali.dataaccess.dao.IPronosticoVentaDAO;
import co.edu.usbcali.dataaccess.dao.IReferenciaDAO;
import co.edu.usbcali.dataaccess.dao.IReferenciaSucursalDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.Garantia;
import co.edu.usbcali.modelo.GrupoReferencia;
import co.edu.usbcali.modelo.ItemLogisticaReversiva;
import co.edu.usbcali.modelo.ItemRotacion;
import co.edu.usbcali.modelo.ListaPrecios;
import co.edu.usbcali.modelo.ListaPreciosEspeciales;
import co.edu.usbcali.modelo.OrdenesDeCompra;
import co.edu.usbcali.modelo.Pedido;
import co.edu.usbcali.modelo.PronosticoVenta;
import co.edu.usbcali.modelo.Referencia;
import co.edu.usbcali.modelo.ReferenciaSucursal;
import co.edu.usbcali.modelo.dto.ReferenciaDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("ReferenciaLogic")
public class ReferenciaLogic implements IReferenciaLogic {
	/**
	 * DAO injected by Spring that manages Referencia entities
	 * 
	 */
	@Autowired
	private IReferenciaDAO referenciaDAO;

	/**
	 * DAO injected by Spring that manages Garantia entities
	 * 
	 */
	@Autowired
	private IGarantiaDAO garantiaDAO;

	/**
	 * DAO injected by Spring that manages GrupoReferencia entities
	 * 
	 */
	@Autowired
	private IGrupoReferenciaDAO grupoReferenciaDAO;

	/**
	 * DAO injected by Spring that manages ItemLogisticaReversiva entities
	 * 
	 */
	@Autowired
	private IItemLogisticaReversivaDAO itemLogisticaReversivaDAO;

	/**
	 * DAO injected by Spring that manages ItemRotacion entities
	 * 
	 */
	@Autowired
	private IItemRotacionDAO itemRotacionDAO;

	/**
	 * DAO injected by Spring that manages ItemRotacion entities
	 * 
	 */

	/**
	 * DAO injected by Spring that manages ListaPreciosEspeciales entities
	 * 
	 */
	@Autowired
	private IListaPreciosEspecialesDAO listaPreciosEspecialesDAO;

	/**
	 * DAO injected by Spring that manages ListaPrecios entities
	 * 
	 */
	@Autowired
	private IListaPreciosDAO listaPreciosDAO;

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
	 * DAO injected by Spring that manages PronosticoVenta entities
	 * 
	 */
	@Autowired
	private IPronosticoVentaDAO pronosticoVentaDAO;

	/**
	 * DAO injected by Spring that manages ReferenciaSucursal entities
	 * 
	 */
	@Autowired
	private IReferenciaSucursalDAO referenciaSucursalDAO;

	@Transactional(readOnly = true)
	public List<Referencia> getReferencia() throws Exception {
		List<Referencia> list = new ArrayList<Referencia>();

		try {
			list = referenciaDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "Referencia");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveReferencia(Referencia entity) throws Exception {
		try {
			if ((entity.getQPorCaja() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getQPorCaja(), 3, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("QPorCaja");
			}

			if ((entity.getAplicacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getAplicacion(), 40) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"aplicacion");
			}

			if (entity.getCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("codigo");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCodigo(), 18) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCodigoBarras() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCodigoBarras(), 25) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"codigoBarras");
			}

			/*
			 * if ((entity.getCosto() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getCosto(), 14, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("costo"); }
			 */

			if ((entity.getDescripcion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getDescripcion(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"descripcion");
			}

			if ((entity.getDescripcionCorta() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getDescripcionCorta(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"descripcionCorta");
			}

			if ((entity.getDescripcionTecnica() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getDescripcionTecnica(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"descripcionTecnica");
			}

			if ((entity.getEquivalente1() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEquivalente1(), 18) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"equivalente1");
			}

			if ((entity.getEquivalente2() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEquivalente2(), 18) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"equivalente2");
			}

			if ((entity.getEsGarantia() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEsGarantia(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"esGarantia");
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

			if ((entity.getGalones() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getGalones(), 10, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException("galones");
			}

			if ((entity.getManejaDecimales() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getManejaDecimales(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"manejaDecimales");
			}

			if ((entity.getManejaLote() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getManejaLote(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"manejaLote");
			}

			if ((entity.getMarca() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getMarca(), 18) == false)) {
				throw new ZMessManager().new NotValidFormatException("marca");
			}

			if ((entity.getMargenMinimoGBodega() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMargenMinimoGBodega(), 2, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"margenMinimoGBodega");
			}

			if ((entity.getMargenMinimoGEne() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMargenMinimoGEne(), 2, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"margenMinimoGEne");
			}

			if ((entity.getMargenMinimoPBodega() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMargenMinimoPBodega(), 2, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"margenMinimoPBodega");
			}

			if ((entity.getMargenMinimoPEne() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMargenMinimoPEne(), 2, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"margenMinimoPEne");
			}

			if ((entity.getMargenMinimoRefBodega() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMargenMinimoRefBodega(), 2, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"margenMinimoRefBodega");
			}

			if ((entity.getMargenMinimoRefEne() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMargenMinimoRefEne(), 2, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"margenMinimoRefEne");
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

			if ((entity.getPeso() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPeso(), 10, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException("peso");
			}

			if ((entity.getPideCantidad() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getPideCantidad(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"pideCantidad");
			}

			if ((entity.getPideValor() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getPideValor(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"pideValor");
			}

			if ((entity.getPorcentajeIva() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPorcentajeIva(), 3, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"porcentajeIva");
			}

			if ((entity.getProductoConsumo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getProductoConsumo(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"productoConsumo");
			}

			if ((entity.getProductoEspecial() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getProductoEspecial(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"productoEspecial");
			}

			if ((entity.getUnidadMedida() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getUnidadMedida(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"unidadMedida");
			}

			if ((entity.getUnidadMedidaProvisional() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getUnidadMedidaProvisional(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"unidadMedidaProvisional");
			}

			if ((entity.getVolumen() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getVolumen(), 10, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException("volumen");
			}

			referenciaDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteReferencia(Referencia entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Referencia");
		}

		if (entity.getIdRefe() == null) {
			throw new ZMessManager().new EmptyFieldException("idRefe");
		}

		List<Garantia> garantias = null;
		List<GrupoReferencia> grupoReferencias = null;
		List<ItemLogisticaReversiva> itemLogisticaReversivas = null;
		List<ItemRotacion> itemRotacionsForReferenciaEntregada = null;
		List<ItemRotacion> itemRotacionsForReferenciaRecibida = null;
		List<ListaPreciosEspeciales> listaPreciosEspecialeses = null;
		List<ListaPrecios> listaPrecioses = null;
		List<OrdenesDeCompra> ordenesDeCompras = null;
		List<Pedido> pedidos = null;
		List<PronosticoVenta> pronosticoVentas = null;
		List<ReferenciaSucursal> referenciaSucursals = null;

		try {
			garantias = garantiaDAO.findByProperty("referencia.idRefe",
					entity.getIdRefe());

			if (Utilities.validationsList(garantias) == true) {
				throw new ZMessManager().new DeletingException("garantias");
			}

			grupoReferencias = grupoReferenciaDAO.findByProperty(
					"referencia.idRefe", entity.getIdRefe());

			if (Utilities.validationsList(grupoReferencias) == true) {
				throw new ZMessManager().new DeletingException(
						"grupoReferencias");
			}

			itemLogisticaReversivas = itemLogisticaReversivaDAO.findByProperty(
					"referencia.idRefe", entity.getIdRefe());

			if (Utilities.validationsList(itemLogisticaReversivas) == true) {
				throw new ZMessManager().new DeletingException(
						"itemLogisticaReversivas");
			}

			itemRotacionsForReferenciaEntregada = itemRotacionDAO
					.findByProperty("referencia.idRefe", entity.getIdRefe());

			if (Utilities.validationsList(itemRotacionsForReferenciaEntregada) == true) {
				throw new ZMessManager().new DeletingException(
						"itemRotacionsForReferenciaEntregada");
			}

			itemRotacionsForReferenciaRecibida = itemRotacionDAO
					.findByProperty("referencia.idRefe", entity.getIdRefe());

			if (Utilities.validationsList(itemRotacionsForReferenciaRecibida) == true) {
				throw new ZMessManager().new DeletingException(
						"itemRotacionsForReferenciaRecibida");
			}

			listaPreciosEspecialeses = listaPreciosEspecialesDAO
					.findByProperty("referencia.idRefe", entity.getIdRefe());

			if (Utilities.validationsList(listaPreciosEspecialeses) == true) {
				throw new ZMessManager().new DeletingException(
						"listaPreciosEspecialeses");
			}

			listaPrecioses = listaPreciosDAO.findByProperty(
					"referencia.idRefe", entity.getIdRefe());

			if (Utilities.validationsList(listaPrecioses) == true) {
				throw new ZMessManager().new DeletingException("listaPrecioses");
			}

			ordenesDeCompras = ordenesDeCompraDAO.findByProperty(
					"referencia.idRefe", entity.getIdRefe());

			if (Utilities.validationsList(ordenesDeCompras) == true) {
				throw new ZMessManager().new DeletingException(
						"ordenesDeCompras");
			}

			pedidos = pedidoDAO.findByProperty("referencia.idRefe",
					entity.getIdRefe());

			if (Utilities.validationsList(pedidos) == true) {
				throw new ZMessManager().new DeletingException("pedidos");
			}

			pronosticoVentas = pronosticoVentaDAO.findByProperty(
					"referencia.idRefe", entity.getIdRefe());

			if (Utilities.validationsList(pronosticoVentas) == true) {
				throw new ZMessManager().new DeletingException(
						"pronosticoVentas");
			}

			referenciaSucursals = referenciaSucursalDAO.findByProperty(
					"referencia.idRefe", entity.getIdRefe());

			if (Utilities.validationsList(referenciaSucursals) == true) {
				throw new ZMessManager().new DeletingException(
						"referenciaSucursals");
			}

			referenciaDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateReferencia(Referencia entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Referencia");
			}

			if ((entity.getQPorCaja() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getQPorCaja(), 3, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("QPorCaja");
			}

			if ((entity.getAplicacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getAplicacion(), 40) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"aplicacion");
			}

			if (entity.getCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("codigo");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCodigo(), 18) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getCodigoBarras() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCodigoBarras(), 25) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"codigoBarras");
			}

			/*if ((entity.getCosto() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCosto(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("costo");
			}*/

			if ((entity.getDescripcion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getDescripcion(), 60) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"descripcion");
			}

			if ((entity.getDescripcionCorta() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getDescripcionCorta(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"descripcionCorta");
			}

			if ((entity.getDescripcionTecnica() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getDescripcionTecnica(), 150) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"descripcionTecnica");
			}

			if ((entity.getEquivalente1() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEquivalente1(), 18) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"equivalente1");
			}

			if ((entity.getEquivalente2() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEquivalente2(), 18) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"equivalente2");
			}

			if ((entity.getEsGarantia() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEsGarantia(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"esGarantia");
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

			if ((entity.getGalones() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getGalones(), 10, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException("galones");
			}

			if ((entity.getManejaDecimales() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getManejaDecimales(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"manejaDecimales");
			}

			if ((entity.getManejaLote() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getManejaLote(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"manejaLote");
			}

			if ((entity.getMarca() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getMarca(), 18) == false)) {
				throw new ZMessManager().new NotValidFormatException("marca");
			}

			if ((entity.getMargenMinimoGBodega() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMargenMinimoGBodega(), 2, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"margenMinimoGBodega");
			}

			if ((entity.getMargenMinimoGEne() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMargenMinimoGEne(), 2, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"margenMinimoGEne");
			}

			if ((entity.getMargenMinimoPBodega() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMargenMinimoPBodega(), 2, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"margenMinimoPBodega");
			}

			if ((entity.getMargenMinimoPEne() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMargenMinimoPEne(), 2, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"margenMinimoPEne");
			}

			if ((entity.getMargenMinimoRefBodega() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMargenMinimoRefBodega(), 2, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"margenMinimoRefBodega");
			}

			if ((entity.getMargenMinimoRefEne() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMargenMinimoRefEne(), 2, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"margenMinimoRefEne");
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

			if ((entity.getPeso() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPeso(), 10, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException("peso");
			}

			if ((entity.getPideCantidad() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getPideCantidad(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"pideCantidad");
			}

			if ((entity.getPideValor() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getPideValor(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"pideValor");
			}

			if ((entity.getPorcentajeIva() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPorcentajeIva(), 3, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"porcentajeIva");
			}

			if ((entity.getProductoConsumo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getProductoConsumo(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"productoConsumo");
			}

			if ((entity.getProductoEspecial() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getProductoEspecial(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"productoEspecial");
			}

			if ((entity.getUnidadMedida() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getUnidadMedida(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"unidadMedida");
			}

			if ((entity.getUnidadMedidaProvisional() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getUnidadMedidaProvisional(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"unidadMedidaProvisional");
			}

			if ((entity.getVolumen() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getVolumen(), 10, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException("volumen");
			}

			referenciaDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<ReferenciaDTO> getDataReferencia() throws Exception {
		try {
			List<Referencia> referencia = referenciaDAO.findAll();

			List<ReferenciaDTO> referenciaDTO = new ArrayList<ReferenciaDTO>();

			for (Referencia referenciaTmp : referencia) {
				ReferenciaDTO referenciaDTO2 = new ReferenciaDTO();

				referenciaDTO2.setIdRefe(referenciaTmp.getIdRefe());
				referenciaDTO2
						.setQPorCaja((referenciaTmp.getQPorCaja() != null) ? referenciaTmp
								.getQPorCaja() : null);
				referenciaDTO2
						.setAplicacion((referenciaTmp.getAplicacion() != null) ? referenciaTmp
								.getAplicacion() : null);
				referenciaDTO2
						.setCodigo((referenciaTmp.getCodigo() != null) ? referenciaTmp
								.getCodigo() : null);
				referenciaDTO2
						.setCodigoBarras((referenciaTmp.getCodigoBarras() != null) ? referenciaTmp
								.getCodigoBarras() : null);
				referenciaDTO2
						.setCosto((referenciaTmp.getCosto() != null) ? referenciaTmp
								.getCosto() : null);
				referenciaDTO2
						.setDescripcion((referenciaTmp.getDescripcion() != null) ? referenciaTmp
								.getDescripcion() : null);
				referenciaDTO2.setDescripcionCorta((referenciaTmp
						.getDescripcionCorta() != null) ? referenciaTmp
						.getDescripcionCorta() : null);
				referenciaDTO2.setDescripcionTecnica((referenciaTmp
						.getDescripcionTecnica() != null) ? referenciaTmp
						.getDescripcionTecnica() : null);
				referenciaDTO2
						.setEquivalente1((referenciaTmp.getEquivalente1() != null) ? referenciaTmp
								.getEquivalente1() : null);
				referenciaDTO2
						.setEquivalente2((referenciaTmp.getEquivalente2() != null) ? referenciaTmp
								.getEquivalente2() : null);
				referenciaDTO2
						.setEsGarantia((referenciaTmp.getEsGarantia() != null) ? referenciaTmp
								.getEsGarantia() : null);
				referenciaDTO2.setEstadoRegistro((referenciaTmp
						.getEstadoRegistro() != null) ? referenciaTmp
						.getEstadoRegistro() : null);
				referenciaDTO2.setFechaCreacion(referenciaTmp
						.getFechaCreacion());
				referenciaDTO2.setFechaModificacion(referenciaTmp
						.getFechaModificacion());
				referenciaDTO2.setFechaVigentePBodega(referenciaTmp
						.getFechaVigentePBodega());
				referenciaDTO2.setFechaVigentePEne(referenciaTmp
						.getFechaVigentePEne());
				referenciaDTO2
						.setGalones((referenciaTmp.getGalones() != null) ? referenciaTmp
								.getGalones() : null);
				referenciaDTO2.setManejaDecimales((referenciaTmp
						.getManejaDecimales() != null) ? referenciaTmp
						.getManejaDecimales() : null);
				referenciaDTO2
						.setManejaLote((referenciaTmp.getManejaLote() != null) ? referenciaTmp
								.getManejaLote() : null);
				referenciaDTO2
						.setMarca((referenciaTmp.getMarca() != null) ? referenciaTmp
								.getMarca() : null);
				referenciaDTO2.setMargenMinimoGBodega((referenciaTmp
						.getMargenMinimoGBodega() != null) ? referenciaTmp
						.getMargenMinimoGBodega() : null);
				referenciaDTO2.setMargenMinimoGEne((referenciaTmp
						.getMargenMinimoGEne() != null) ? referenciaTmp
						.getMargenMinimoGEne() : null);
				referenciaDTO2.setMargenMinimoPBodega((referenciaTmp
						.getMargenMinimoPBodega() != null) ? referenciaTmp
						.getMargenMinimoPBodega() : null);
				referenciaDTO2.setMargenMinimoPEne((referenciaTmp
						.getMargenMinimoPEne() != null) ? referenciaTmp
						.getMargenMinimoPEne() : null);
				referenciaDTO2.setMargenMinimoRefBodega((referenciaTmp
						.getMargenMinimoRefBodega() != null) ? referenciaTmp
						.getMargenMinimoRefBodega() : null);
				referenciaDTO2.setMargenMinimoRefEne((referenciaTmp
						.getMargenMinimoRefEne() != null) ? referenciaTmp
						.getMargenMinimoRefEne() : null);
				referenciaDTO2
						.setOperCreador((referenciaTmp.getOperCreador() != null) ? referenciaTmp
								.getOperCreador() : null);
				referenciaDTO2
						.setOperModifica((referenciaTmp.getOperModifica() != null) ? referenciaTmp
								.getOperModifica() : null);
				referenciaDTO2
						.setPeso((referenciaTmp.getPeso() != null) ? referenciaTmp
								.getPeso() : null);
				referenciaDTO2
						.setPideCantidad((referenciaTmp.getPideCantidad() != null) ? referenciaTmp
								.getPideCantidad() : null);
				referenciaDTO2
						.setPideValor((referenciaTmp.getPideValor() != null) ? referenciaTmp
								.getPideValor() : null);
				referenciaDTO2.setPorcentajeIva((referenciaTmp
						.getPorcentajeIva() != null) ? referenciaTmp
						.getPorcentajeIva() : null);
				referenciaDTO2.setProductoConsumo((referenciaTmp
						.getProductoConsumo() != null) ? referenciaTmp
						.getProductoConsumo() : null);
				referenciaDTO2.setProductoEspecial((referenciaTmp
						.getProductoEspecial() != null) ? referenciaTmp
						.getProductoEspecial() : null);
				referenciaDTO2
						.setUnidadMedida((referenciaTmp.getUnidadMedida() != null) ? referenciaTmp
								.getUnidadMedida() : null);
				referenciaDTO2.setUnidadMedidaProvisional((referenciaTmp
						.getUnidadMedidaProvisional() != null) ? referenciaTmp
						.getUnidadMedidaProvisional() : null);
				referenciaDTO2
						.setVolumen((referenciaTmp.getVolumen() != null) ? referenciaTmp
								.getVolumen() : null);
				referenciaDTO.add(referenciaDTO2);
			}

			return referenciaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Referencia getReferencia(Long idRefe) throws Exception {
		Referencia entity = null;

		try {
			entity = referenciaDAO.findById(idRefe);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Referencia");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Referencia> findPageReferencia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Referencia> entity = null;

		try {
			entity = referenciaDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Referencia Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberReferencia() throws Exception {
		Long entity = null;

		try {
			entity = referenciaDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Referencia Count");
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
	public List<Referencia> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Referencia> list = new ArrayList<Referencia>();
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
			list = referenciaDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
