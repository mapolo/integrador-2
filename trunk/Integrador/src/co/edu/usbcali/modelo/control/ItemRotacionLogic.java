package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.IItemRotacionDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.ItemRotacion;
import co.edu.usbcali.modelo.dto.ItemRotacionDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("ItemRotacionLogic")
public class ItemRotacionLogic implements IItemRotacionLogic {
	/**
	 * DAO injected by Spring that manages ItemRotacion entities
	 * 
	 */
	@Autowired
	private IItemRotacionDAO itemRotacionDAO;

	/**
	 * Logic injected by Spring that manages ClaveFabricacion entities
	 * 
	 */
	@Autowired
	IClaveFabricacionLogic logicClaveFabricacion1;

	/**
	 * Logic injected by Spring that manages Documento entities
	 * 
	 */
	@Autowired
	IDocumentoLogic logicDocumento2;

	/**
	 * Logic injected by Spring that manages Referencia entities
	 * 
	 */
	@Autowired
	IReferenciaLogic logicReferencia3;

	/**
	 * Logic injected by Spring that manages Referencia entities
	 * 
	 */
	@Autowired
	IReferenciaLogic logicReferencia4;

	@Transactional(readOnly = true)
	public List<ItemRotacion> getItemRotacion() throws Exception {
		List<ItemRotacion> list = new ArrayList<ItemRotacion>();

		try {
			list = itemRotacionDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "ItemRotacion");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveItemRotacion(ItemRotacion entity) throws Exception {
		try {
			if (entity.getClaveFabricacion() == null) {
				throw new ZMessManager().new ForeignException(
						"claveFabricacion");
			}

			if (entity.getDocumento() == null) {
				throw new ZMessManager().new ForeignException("documento");
			}

			if (entity.getReferenciaByReferenciaEntregada() == null) {
				throw new ZMessManager().new ForeignException(
						"referenciaByReferenciaEntregada");
			}

			if (entity.getReferenciaByReferenciaRecibida() == null) {
				throw new ZMessManager().new ForeignException(
						"referenciaByReferenciaRecibida");
			}

			if ((entity.getAutorizado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getAutorizado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"autorizado");
			}

			if ((entity.getCantidadCambio() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadCambio(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadCambio");
			}

			if ((entity.getCantidadOrdenada() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadOrdenada(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadOrdenada");
			}

			if ((entity.getCantidadPedida() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadPedida(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadPedida");
			}

			if ((entity.getCausalNoCambio() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCausalNoCambio(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"causalNoCambio");
			}

			if (entity.getEstado() == null) {
				throw new ZMessManager().new EmptyFieldException("estado");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
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

			if (entity.getIdItro() == null) {
				throw new ZMessManager().new EmptyFieldException("idItro");
			}

			if ((entity.getIdItro() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdItro(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idItro");
			}

			if ((entity.getNumeroDespacho() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroDespacho(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroDespacho");
			}

			if ((entity.getNumeroGarantia() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNumeroGarantia(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroGarantia");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"observacion");
			}

			if ((entity.getObservacionCambio() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getObservacionCambio(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"observacionCambio");
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

			if (entity.getClaveFabricacion().getIdClfa() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idClfa_ClaveFabricacion");
			}

			if ((entity.getClaveFabricacion().getIdClfa() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getClaveFabricacion().getIdClfa(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idClfa_ClaveFabricacion");
			}

			if (entity.getDocumento().getIdDocu() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idDocu_Documento");
			}

			if ((entity.getDocumento().getIdDocu() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDocumento().getIdDocu(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idDocu_Documento");
			}

			if (getItemRotacion(entity.getIdItro()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			itemRotacionDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteItemRotacion(ItemRotacion entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("ItemRotacion");
		}

		if (entity.getIdItro() == null) {
			throw new ZMessManager().new EmptyFieldException("idItro");
		}

		try {
			itemRotacionDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateItemRotacion(ItemRotacion entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("ItemRotacion");
			}

			if (entity.getClaveFabricacion() == null) {
				throw new ZMessManager().new ForeignException(
						"claveFabricacion");
			}

			if (entity.getDocumento() == null) {
				throw new ZMessManager().new ForeignException("documento");
			}

			if (entity.getReferenciaByReferenciaEntregada() == null) {
				throw new ZMessManager().new ForeignException(
						"referenciaByReferenciaEntregada");
			}

			if (entity.getReferenciaByReferenciaRecibida() == null) {
				throw new ZMessManager().new ForeignException(
						"referenciaByReferenciaRecibida");
			}

			if ((entity.getAutorizado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getAutorizado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"autorizado");
			}

			if ((entity.getCantidadCambio() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadCambio(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadCambio");
			}

			if ((entity.getCantidadOrdenada() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadOrdenada(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadOrdenada");
			}

			if ((entity.getCantidadPedida() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadPedida(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadPedida");
			}

			if ((entity.getCausalNoCambio() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCausalNoCambio(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"causalNoCambio");
			}

			if (entity.getEstado() == null) {
				throw new ZMessManager().new EmptyFieldException("estado");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
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

			if (entity.getIdItro() == null) {
				throw new ZMessManager().new EmptyFieldException("idItro");
			}

			if ((entity.getIdItro() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdItro(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idItro");
			}

			if ((entity.getNumeroDespacho() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroDespacho(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroDespacho");
			}

			if ((entity.getNumeroGarantia() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNumeroGarantia(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroGarantia");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"observacion");
			}

			if ((entity.getObservacionCambio() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getObservacionCambio(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"observacionCambio");
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

			if (entity.getClaveFabricacion().getIdClfa() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idClfa_ClaveFabricacion");
			}

			if ((entity.getClaveFabricacion().getIdClfa() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getClaveFabricacion().getIdClfa(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idClfa_ClaveFabricacion");
			}

			if (entity.getDocumento().getIdDocu() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idDocu_Documento");
			}

			if ((entity.getDocumento().getIdDocu() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDocumento().getIdDocu(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idDocu_Documento");
			}

			itemRotacionDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<ItemRotacionDTO> getDataItemRotacion() throws Exception {
		try {
			List<ItemRotacion> itemRotacion = itemRotacionDAO.findAll();

			List<ItemRotacionDTO> itemRotacionDTO = new ArrayList<ItemRotacionDTO>();

			for (ItemRotacion itemRotacionTmp : itemRotacion) {
				ItemRotacionDTO itemRotacionDTO2 = new ItemRotacionDTO();

				itemRotacionDTO2.setIdItro(itemRotacionTmp.getIdItro());
				itemRotacionDTO2
						.setAutorizado((itemRotacionTmp.getAutorizado() != null) ? itemRotacionTmp
								.getAutorizado() : null);
				itemRotacionDTO2.setCantidadCambio((itemRotacionTmp
						.getCantidadCambio() != null) ? itemRotacionTmp
						.getCantidadCambio() : null);
				itemRotacionDTO2.setCantidadOrdenada((itemRotacionTmp
						.getCantidadOrdenada() != null) ? itemRotacionTmp
						.getCantidadOrdenada() : null);
				itemRotacionDTO2.setCantidadPedida((itemRotacionTmp
						.getCantidadPedida() != null) ? itemRotacionTmp
						.getCantidadPedida() : null);
				itemRotacionDTO2.setCausalNoCambio((itemRotacionTmp
						.getCausalNoCambio() != null) ? itemRotacionTmp
						.getCausalNoCambio() : null);
				itemRotacionDTO2
						.setEstado((itemRotacionTmp.getEstado() != null) ? itemRotacionTmp
								.getEstado() : null);
				itemRotacionDTO2.setEstadoRegistro((itemRotacionTmp
						.getEstadoRegistro() != null) ? itemRotacionTmp
						.getEstadoRegistro() : null);
				itemRotacionDTO2.setFechaAutorizacion(itemRotacionTmp
						.getFechaAutorizacion());
				itemRotacionDTO2.setFechaCambio(itemRotacionTmp
						.getFechaCambio());
				itemRotacionDTO2.setFechaCausal(itemRotacionTmp
						.getFechaCausal());
				itemRotacionDTO2.setFechaCreacion(itemRotacionTmp
						.getFechaCreacion());
				itemRotacionDTO2.setFechaModificacion(itemRotacionTmp
						.getFechaModificacion());
				itemRotacionDTO2.setFechaMovimiento(itemRotacionTmp
						.getFechaMovimiento());
				itemRotacionDTO2.setFechaOrdenada(itemRotacionTmp
						.getFechaOrdenada());
				itemRotacionDTO2.setNumeroDespacho((itemRotacionTmp
						.getNumeroDespacho() != null) ? itemRotacionTmp
						.getNumeroDespacho() : null);
				itemRotacionDTO2.setNumeroGarantia((itemRotacionTmp
						.getNumeroGarantia() != null) ? itemRotacionTmp
						.getNumeroGarantia() : null);
				itemRotacionDTO2.setObservacion((itemRotacionTmp
						.getObservacion() != null) ? itemRotacionTmp
						.getObservacion() : null);
				itemRotacionDTO2.setObservacionCambio((itemRotacionTmp
						.getObservacionCambio() != null) ? itemRotacionTmp
						.getObservacionCambio() : null);
				itemRotacionDTO2.setOperCreador((itemRotacionTmp
						.getOperCreador() != null) ? itemRotacionTmp
						.getOperCreador() : null);
				itemRotacionDTO2.setOperModifica((itemRotacionTmp
						.getOperModifica() != null) ? itemRotacionTmp
						.getOperModifica() : null);
				itemRotacionDTO2
						.setIdClfa_ClaveFabricacion((itemRotacionTmp
								.getClaveFabricacion().getIdClfa() != null) ? itemRotacionTmp
								.getClaveFabricacion().getIdClfa() : null);
				itemRotacionDTO2.setIdDocu_Documento((itemRotacionTmp
						.getDocumento().getIdDocu() != null) ? itemRotacionTmp
						.getDocumento().getIdDocu() : null);

				itemRotacionDTO.add(itemRotacionDTO2);
			}

			return itemRotacionDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public ItemRotacion getItemRotacion(Long idItro) throws Exception {
		ItemRotacion entity = null;

		try {
			entity = itemRotacionDAO.findById(idItro);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ItemRotacion");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<ItemRotacion> findPageItemRotacion(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<ItemRotacion> entity = null;

		try {
			entity = itemRotacionDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ItemRotacion Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberItemRotacion() throws Exception {
		Long entity = null;

		try {
			entity = itemRotacionDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ItemRotacion Count");
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
	public List<ItemRotacion> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<ItemRotacion> list = new ArrayList<ItemRotacion>();
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
			list = itemRotacionDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
