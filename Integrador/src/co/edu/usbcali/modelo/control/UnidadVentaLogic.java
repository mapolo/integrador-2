package co.edu.usbcali.modelo.control;

import co.edu.usbcali.dataaccess.dao.*;
import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.UnidadVentaDTO;
import co.edu.usbcali.utilities.Utilities;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("UnidadVentaLogic")
public class UnidadVentaLogic implements IUnidadVentaLogic {
	/**
	 * DAO injected by Spring that manages UnidadVenta entities
	 * 
	 */
	@Autowired
	private IUnidadVentaDAO unidadVentaDAO;

	/**
	 * DAO injected by Spring that manages Documento entities
	 * 
	 */
	@Autowired
	private IDocumentoDAO documentoDAO;

	/**
	 * DAO injected by Spring that manages Documento entities
	 * 
	 */

	/**
	 * DAO injected by Spring that manages MovimientoVendedor entities
	 * 
	 */
	@Autowired
	private IMovimientoVendedorDAO movimientoVendedorDAO;

	/**
	 * DAO injected by Spring that manages PresupuestoCartera entities
	 * 
	 */
	@Autowired
	private IPresupuestoCarteraDAO presupuestoCarteraDAO;

	/**
	 * DAO injected by Spring that manages PresupuestoVentas entities
	 * 
	 */
	@Autowired
	private IPresupuestoVentasDAO presupuestoVentasDAO;

	/**
	 * DAO injected by Spring that manages PronosticoVenta entities
	 * 
	 */
	@Autowired
	private IPronosticoVentaDAO pronosticoVentaDAO;

	/**
	 * DAO injected by Spring that manages RboDetalleDocumentos entities
	 * 
	 */
	@Autowired
	private IRboDetalleDocumentosDAO rboDetalleDocumentosDAO;

	/**
	 * DAO injected by Spring that manages Recibo entities
	 * 
	 */
	@Autowired
	private IReciboDAO reciboDAO;

	/**
	 * Logic injected by Spring that manages UnidadNegocio entities
	 * 
	 */
	@Autowired
	IUnidadNegocioLogic logicUnidadNegocio1;

	/**
	 * Logic injected by Spring that manages Vendedor entities
	 * 
	 */
	@Autowired
	IVendedorLogic logicVendedor2;

	@Transactional(readOnly = true)
	public List<UnidadVenta> getUnidadVenta() throws Exception {
		List<UnidadVenta> list = new ArrayList<UnidadVenta>();

		try {
			list = unidadVentaDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "UnidadVenta");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveUnidadVenta(UnidadVenta entity) throws Exception {
		try {
			if (entity.getUnidadNegocio() == null) {
				throw new ZMessManager().new ForeignException("unidadNegocio");
			}

			if (entity.getVendedor() == null) {
				throw new ZMessManager().new ForeignException("vendedor");
			}

			if ((entity.getActivo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getActivo(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("activo");
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

			if (entity.getIdUnve() == null) {
				throw new ZMessManager().new EmptyFieldException("idUnve");
			}

			if ((entity.getIdUnve() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdUnve(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idUnve");
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

			if (entity.getUnidadNegocio().getIdUnne() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idUnne_UnidadNegocio");
			}

			if ((entity.getUnidadNegocio().getIdUnne() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getUnidadNegocio().getIdUnne(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idUnne_UnidadNegocio");
			}

			if (entity.getVendedor().getIdVend() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idVend_Vendedor");
			}

			if ((entity.getVendedor().getIdVend() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getVendedor().getIdVend(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idVend_Vendedor");
			}

			if (getUnidadVenta(entity.getIdUnve()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			unidadVentaDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteUnidadVenta(UnidadVenta entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("UnidadVenta");
		}

		if (entity.getIdUnve() == null) {
			throw new ZMessManager().new EmptyFieldException("idUnve");
		}

		List<Documento> documentosForIdTelemercaderista = null;
		List<Documento> documentosForIdUnve = null;
		List<MovimientoVendedor> movimientoVendedors = null;
		List<PresupuestoCartera> presupuestoCarteras = null;
		List<PresupuestoVentas> presupuestoVentases = null;
		List<PronosticoVenta> pronosticoVentas = null;
		List<RboDetalleDocumentos> rboDetalleDocumentoses = null;
		List<Recibo> recibos = null;

		try {
			documentosForIdTelemercaderista = documentoDAO.findByProperty(
					"unidadVenta.idUnve", entity.getIdUnve());

			if (Utilities.validationsList(documentosForIdTelemercaderista) == true) {
				throw new ZMessManager().new DeletingException(
						"documentosForIdTelemercaderista");
			}

			documentosForIdUnve = documentoDAO.findByProperty(
					"unidadVenta.idUnve", entity.getIdUnve());

			if (Utilities.validationsList(documentosForIdUnve) == true) {
				throw new ZMessManager().new DeletingException(
						"documentosForIdUnve");
			}

			movimientoVendedors = movimientoVendedorDAO.findByProperty(
					"unidadVenta.idUnve", entity.getIdUnve());

			if (Utilities.validationsList(movimientoVendedors) == true) {
				throw new ZMessManager().new DeletingException(
						"movimientoVendedors");
			}

			presupuestoCarteras = presupuestoCarteraDAO.findByProperty(
					"unidadVenta.idUnve", entity.getIdUnve());

			if (Utilities.validationsList(presupuestoCarteras) == true) {
				throw new ZMessManager().new DeletingException(
						"presupuestoCarteras");
			}

			presupuestoVentases = presupuestoVentasDAO.findByProperty(
					"unidadVenta.idUnve", entity.getIdUnve());

			if (Utilities.validationsList(presupuestoVentases) == true) {
				throw new ZMessManager().new DeletingException(
						"presupuestoVentases");
			}

			pronosticoVentas = pronosticoVentaDAO.findByProperty(
					"unidadVenta.idUnve", entity.getIdUnve());

			if (Utilities.validationsList(pronosticoVentas) == true) {
				throw new ZMessManager().new DeletingException(
						"pronosticoVentas");
			}

			rboDetalleDocumentoses = rboDetalleDocumentosDAO.findByProperty(
					"unidadVenta.idUnve", entity.getIdUnve());

			if (Utilities.validationsList(rboDetalleDocumentoses) == true) {
				throw new ZMessManager().new DeletingException(
						"rboDetalleDocumentoses");
			}

			recibos = reciboDAO.findByProperty("unidadVenta.idUnve",
					entity.getIdUnve());

			if (Utilities.validationsList(recibos) == true) {
				throw new ZMessManager().new DeletingException("recibos");
			}

			unidadVentaDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateUnidadVenta(UnidadVenta entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("UnidadVenta");
			}

			if (entity.getUnidadNegocio() == null) {
				throw new ZMessManager().new ForeignException("unidadNegocio");
			}

			if (entity.getVendedor() == null) {
				throw new ZMessManager().new ForeignException("vendedor");
			}

			if ((entity.getActivo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getActivo(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("activo");
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

			if (entity.getIdUnve() == null) {
				throw new ZMessManager().new EmptyFieldException("idUnve");
			}

			if ((entity.getIdUnve() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdUnve(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idUnve");
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

			if (entity.getUnidadNegocio().getIdUnne() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idUnne_UnidadNegocio");
			}

			if ((entity.getUnidadNegocio().getIdUnne() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getUnidadNegocio().getIdUnne(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idUnne_UnidadNegocio");
			}

			if (entity.getVendedor().getIdVend() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idVend_Vendedor");
			}

			if ((entity.getVendedor().getIdVend() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getVendedor().getIdVend(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idVend_Vendedor");
			}

			unidadVentaDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<UnidadVentaDTO> getDataUnidadVenta() throws Exception {
		try {
			List<UnidadVenta> unidadVenta = unidadVentaDAO.findAll();

			List<UnidadVentaDTO> unidadVentaDTO = new ArrayList<UnidadVentaDTO>();

			for (UnidadVenta unidadVentaTmp : unidadVenta) {
				UnidadVentaDTO unidadVentaDTO2 = new UnidadVentaDTO();

				unidadVentaDTO2.setIdUnve(unidadVentaTmp.getIdUnve());
				unidadVentaDTO2
						.setActivo((unidadVentaTmp.getActivo() != null) ? unidadVentaTmp
								.getActivo() : null);
				unidadVentaDTO2.setEstadoRegistro((unidadVentaTmp
						.getEstadoRegistro() != null) ? unidadVentaTmp
						.getEstadoRegistro() : null);
				unidadVentaDTO2.setFechaCreacion(unidadVentaTmp
						.getFechaCreacion());
				unidadVentaDTO2.setFechaInactivo(unidadVentaTmp
						.getFechaInactivo());
				unidadVentaDTO2.setFechaModificacion(unidadVentaTmp
						.getFechaModificacion());
				unidadVentaDTO2
						.setOperCreador((unidadVentaTmp.getOperCreador() != null) ? unidadVentaTmp
								.getOperCreador() : null);
				unidadVentaDTO2.setOperModifica((unidadVentaTmp
						.getOperModifica() != null) ? unidadVentaTmp
						.getOperModifica() : null);
				unidadVentaDTO2
						.setIdUnne_UnidadNegocio((unidadVentaTmp
								.getUnidadNegocio().getIdUnne() != null) ? unidadVentaTmp
								.getUnidadNegocio().getIdUnne() : null);
				unidadVentaDTO2.setIdVend_Vendedor((unidadVentaTmp
						.getVendedor().getIdVend() != null) ? unidadVentaTmp
						.getVendedor().getIdVend() : null);
				unidadVentaDTO.add(unidadVentaDTO2);
			}

			return unidadVentaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public UnidadVenta getUnidadVenta(Long idUnve) throws Exception {
		UnidadVenta entity = null;

		try {
			entity = unidadVentaDAO.findById(idUnve);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("UnidadVenta");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<UnidadVenta> findPageUnidadVenta(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<UnidadVenta> entity = null;

		try {
			entity = unidadVentaDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("UnidadVenta Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberUnidadVenta() throws Exception {
		Long entity = null;

		try {
			entity = unidadVentaDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("UnidadVenta Count");
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
	public List<UnidadVenta> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<UnidadVenta> list = new ArrayList<UnidadVenta>();
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
			list = unidadVentaDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
