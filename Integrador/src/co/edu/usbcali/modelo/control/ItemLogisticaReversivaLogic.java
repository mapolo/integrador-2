package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.IItemLogisticaReversivaDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.ItemLogisticaReversiva;
import co.edu.usbcali.modelo.dto.ItemLogisticaReversivaDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("ItemLogisticaReversivaLogic")
public class ItemLogisticaReversivaLogic implements
		IItemLogisticaReversivaLogic {
	/**
	 * DAO injected by Spring that manages ItemLogisticaReversiva entities
	 * 
	 */
	@Autowired
	private IItemLogisticaReversivaDAO itemLogisticaReversivaDAO;

	/**
	 * Logic injected by Spring that manages LogisticaReversiva entities
	 * 
	 */
	@Autowired
	ILogisticaReversivaLogic logicLogisticaReversiva1;

	/**
	 * Logic injected by Spring that manages Referencia entities
	 * 
	 */
	@Autowired
	IReferenciaLogic logicReferencia2;

	@Transactional(readOnly = true)
	public List<ItemLogisticaReversiva> getItemLogisticaReversiva()
			throws Exception {
		List<ItemLogisticaReversiva> list = new ArrayList<ItemLogisticaReversiva>();

		try {
			list = itemLogisticaReversivaDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "ItemLogisticaReversiva");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveItemLogisticaReversiva(ItemLogisticaReversiva entity)
			throws Exception {
		try {
			if (entity.getLogisticaReversiva() == null) {
				throw new ZMessManager().new ForeignException(
						"logisticaReversiva");
			}

			if (entity.getReferencia() == null) {
				throw new ZMessManager().new ForeignException("referencia");
			}

			if ((entity.getCantidadRecibida() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadRecibida(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadRecibida");
			}

			if (entity.getCantidadSolicitada() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"cantidadSolicitada");
			}

			if ((entity.getCantidadSolicitada() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadSolicitada(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadSolicitada");
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

			if (entity.getIdItlr() == null) {
				throw new ZMessManager().new EmptyFieldException("idItlr");
			}

			if ((entity.getIdItlr() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdItlr(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idItlr");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getObservacion(), 200) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"observacion");
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

			if ((entity.getValor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getValor(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("valor");
			}

			if (entity.getLogisticaReversiva().getIdLore() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idLore_LogisticaReversiva");
			}

			if ((entity.getLogisticaReversiva().getIdLore() != null)
					&& (Utilities
							.checkNumberAndCheckWithPrecisionAndScale(""
									+ entity.getLogisticaReversiva()
											.getIdLore(), 22, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idLore_LogisticaReversiva");
			}

			if (entity.getReferencia().getIdRefe() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idRefe_Referencia");
			}

			if ((entity.getReferencia().getIdRefe() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getReferencia().getIdRefe(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idRefe_Referencia");
			}

			if (getItemLogisticaReversiva(entity.getIdItlr()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			itemLogisticaReversivaDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteItemLogisticaReversiva(ItemLogisticaReversiva entity)
			throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion(
					"ItemLogisticaReversiva");
		}

		if (entity.getIdItlr() == null) {
			throw new ZMessManager().new EmptyFieldException("idItlr");
		}

		try {
			itemLogisticaReversivaDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateItemLogisticaReversiva(ItemLogisticaReversiva entity)
			throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"ItemLogisticaReversiva");
			}

			if (entity.getLogisticaReversiva() == null) {
				throw new ZMessManager().new ForeignException(
						"logisticaReversiva");
			}

			if (entity.getReferencia() == null) {
				throw new ZMessManager().new ForeignException("referencia");
			}

			if ((entity.getCantidadRecibida() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadRecibida(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadRecibida");
			}

			if (entity.getCantidadSolicitada() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"cantidadSolicitada");
			}

			if ((entity.getCantidadSolicitada() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadSolicitada(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadSolicitada");
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

			if (entity.getIdItlr() == null) {
				throw new ZMessManager().new EmptyFieldException("idItlr");
			}

			if ((entity.getIdItlr() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdItlr(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idItlr");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getObservacion(), 200) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"observacion");
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

			if ((entity.getValor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getValor(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("valor");
			}

			if (entity.getLogisticaReversiva().getIdLore() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idLore_LogisticaReversiva");
			}

			if ((entity.getLogisticaReversiva().getIdLore() != null)
					&& (Utilities
							.checkNumberAndCheckWithPrecisionAndScale(""
									+ entity.getLogisticaReversiva()
											.getIdLore(), 22, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idLore_LogisticaReversiva");
			}

			if (entity.getReferencia().getIdRefe() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idRefe_Referencia");
			}

			if ((entity.getReferencia().getIdRefe() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getReferencia().getIdRefe(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idRefe_Referencia");
			}

			itemLogisticaReversivaDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<ItemLogisticaReversivaDTO> getDataItemLogisticaReversiva()
			throws Exception {
		try {
			List<ItemLogisticaReversiva> itemLogisticaReversiva = itemLogisticaReversivaDAO
					.findAll();

			List<ItemLogisticaReversivaDTO> itemLogisticaReversivaDTO = new ArrayList<ItemLogisticaReversivaDTO>();

			for (ItemLogisticaReversiva itemLogisticaReversivaTmp : itemLogisticaReversiva) {
				ItemLogisticaReversivaDTO itemLogisticaReversivaDTO2 = new ItemLogisticaReversivaDTO();

				itemLogisticaReversivaDTO2.setIdItlr(itemLogisticaReversivaTmp
						.getIdItlr());
				itemLogisticaReversivaDTO2
						.setCantidadRecibida((itemLogisticaReversivaTmp
								.getCantidadRecibida() != null) ? itemLogisticaReversivaTmp
								.getCantidadRecibida() : null);
				itemLogisticaReversivaDTO2
						.setCantidadSolicitada((itemLogisticaReversivaTmp
								.getCantidadSolicitada() != null) ? itemLogisticaReversivaTmp
								.getCantidadSolicitada() : null);
				itemLogisticaReversivaDTO2
						.setEstadoRegistro((itemLogisticaReversivaTmp
								.getEstadoRegistro() != null) ? itemLogisticaReversivaTmp
								.getEstadoRegistro() : null);
				itemLogisticaReversivaDTO2
						.setFechaCreacion(itemLogisticaReversivaTmp
								.getFechaCreacion());
				itemLogisticaReversivaDTO2
						.setFechaModificacion(itemLogisticaReversivaTmp
								.getFechaModificacion());
				itemLogisticaReversivaDTO2
						.setObservacion((itemLogisticaReversivaTmp
								.getObservacion() != null) ? itemLogisticaReversivaTmp
								.getObservacion() : null);
				itemLogisticaReversivaDTO2
						.setOperCreador((itemLogisticaReversivaTmp
								.getOperCreador() != null) ? itemLogisticaReversivaTmp
								.getOperCreador() : null);
				itemLogisticaReversivaDTO2
						.setOperModifica((itemLogisticaReversivaTmp
								.getOperModifica() != null) ? itemLogisticaReversivaTmp
								.getOperModifica() : null);
				itemLogisticaReversivaDTO2.setValor((itemLogisticaReversivaTmp
						.getValor() != null) ? itemLogisticaReversivaTmp
						.getValor() : null);
				itemLogisticaReversivaDTO2
						.setIdLore_LogisticaReversiva((itemLogisticaReversivaTmp
								.getLogisticaReversiva().getIdLore() != null) ? itemLogisticaReversivaTmp
								.getLogisticaReversiva().getIdLore() : null);
				itemLogisticaReversivaDTO2
						.setIdRefe_Referencia((itemLogisticaReversivaTmp
								.getReferencia().getIdRefe() != null) ? itemLogisticaReversivaTmp
								.getReferencia().getIdRefe() : null);
				itemLogisticaReversivaDTO.add(itemLogisticaReversivaDTO2);
			}

			return itemLogisticaReversivaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public ItemLogisticaReversiva getItemLogisticaReversiva(Long idItlr)
			throws Exception {
		ItemLogisticaReversiva entity = null;

		try {
			entity = itemLogisticaReversivaDAO.findById(idItlr);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"ItemLogisticaReversiva");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<ItemLogisticaReversiva> findPageItemLogisticaReversiva(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<ItemLogisticaReversiva> entity = null;

		try {
			entity = itemLogisticaReversivaDAO.findPage(sortColumnName,
					sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"ItemLogisticaReversiva Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberItemLogisticaReversiva() throws Exception {
		Long entity = null;

		try {
			entity = itemLogisticaReversivaDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"ItemLogisticaReversiva Count");
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
	public List<ItemLogisticaReversiva> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<ItemLogisticaReversiva> list = new ArrayList<ItemLogisticaReversiva>();
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
			list = itemLogisticaReversivaDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
