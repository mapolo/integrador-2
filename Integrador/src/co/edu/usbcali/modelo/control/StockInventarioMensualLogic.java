package co.edu.usbcali.modelo.control;

import co.edu.usbcali.dataaccess.dao.*;
import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.StockInventarioMensualDTO;
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
@Service("StockInventarioMensualLogic")
public class StockInventarioMensualLogic implements
		IStockInventarioMensualLogic {
	/**
	 * DAO injected by Spring that manages StockInventarioMensual entities
	 * 
	 */
	@Autowired
	private IStockInventarioMensualDAO stockInventarioMensualDAO;

	/**
	 * Logic injected by Spring that manages SaldoInicialInventario entities
	 * 
	 */
	@Autowired
	ISaldoInicialInventarioLogic logicSaldoInicialInventario1;

	@Transactional(readOnly = true)
	public List<StockInventarioMensual> getStockInventarioMensual()
			throws Exception {
		List<StockInventarioMensual> list = new ArrayList<StockInventarioMensual>();

		try {
			list = stockInventarioMensualDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "StockInventarioMensual");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveStockInventarioMensual(StockInventarioMensual entity)
			throws Exception {
		try {
			if (entity.getSaldoInicialInventario() == null) {
				throw new ZMessManager().new ForeignException(
						"saldoInicialInventario");
			}

			if ((entity.getAno() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getAno(), 5, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ano");
			}

			if ((entity.getCantidadEntrada() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadEntrada(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadEntrada");
			}

			if ((entity.getCantidadSalidas() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadSalidas(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadSalidas");
			}

			if ((entity.getCostoEntradas() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCostoEntradas(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"costoEntradas");
			}

			if ((entity.getCostoSalidas() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCostoSalidas(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"costoSalidas");
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

			if (entity.getIdStin() == null) {
				throw new ZMessManager().new EmptyFieldException("idStin");
			}

			if ((entity.getIdStin() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdStin(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idStin");
			}

			if ((entity.getMaximoDistribucion() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMaximoDistribucion(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"maximoDistribucion");
			}

			if ((entity.getMaximoPedido() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMaximoPedido(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"maximoPedido");
			}

			if ((entity.getMes() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMes(), 2, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("mes");
			}

			if ((entity.getMinimoDistribucion() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMinimoDistribucion(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"minimoDistribucion");
			}

			if ((entity.getMinimoPedido() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMinimoPedido(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"minimoPedido");
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

			if (entity.getSaldoInicialInventario().getIdSini() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idSini_SaldoInicialInventario");
			}

			if ((entity.getSaldoInicialInventario().getIdSini() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getSaldoInicialInventario().getIdSini(),
							10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idSini_SaldoInicialInventario");
			}

			if (getStockInventarioMensual(entity.getIdStin()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			stockInventarioMensualDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteStockInventarioMensual(StockInventarioMensual entity)
			throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion(
					"StockInventarioMensual");
		}

		if (entity.getIdStin() == null) {
			throw new ZMessManager().new EmptyFieldException("idStin");
		}

		try {
			stockInventarioMensualDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateStockInventarioMensual(StockInventarioMensual entity)
			throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"StockInventarioMensual");
			}

			if (entity.getSaldoInicialInventario() == null) {
				throw new ZMessManager().new ForeignException(
						"saldoInicialInventario");
			}

			if ((entity.getAno() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getAno(), 5, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ano");
			}

			if ((entity.getCantidadEntrada() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadEntrada(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadEntrada");
			}

			if ((entity.getCantidadSalidas() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadSalidas(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadSalidas");
			}

			if ((entity.getCostoEntradas() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCostoEntradas(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"costoEntradas");
			}

			if ((entity.getCostoSalidas() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCostoSalidas(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"costoSalidas");
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

			if (entity.getIdStin() == null) {
				throw new ZMessManager().new EmptyFieldException("idStin");
			}

			if ((entity.getIdStin() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdStin(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idStin");
			}

			if ((entity.getMaximoDistribucion() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMaximoDistribucion(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"maximoDistribucion");
			}

			if ((entity.getMaximoPedido() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMaximoPedido(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"maximoPedido");
			}

			if ((entity.getMes() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMes(), 2, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("mes");
			}

			if ((entity.getMinimoDistribucion() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMinimoDistribucion(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"minimoDistribucion");
			}

			if ((entity.getMinimoPedido() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMinimoPedido(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"minimoPedido");
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

			if (entity.getSaldoInicialInventario().getIdSini() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idSini_SaldoInicialInventario");
			}

			if ((entity.getSaldoInicialInventario().getIdSini() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getSaldoInicialInventario().getIdSini(),
							10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idSini_SaldoInicialInventario");
			}

			stockInventarioMensualDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<StockInventarioMensualDTO> getDataStockInventarioMensual()
			throws Exception {
		try {
			List<StockInventarioMensual> stockInventarioMensual = stockInventarioMensualDAO
					.findAll();

			List<StockInventarioMensualDTO> stockInventarioMensualDTO = new ArrayList<StockInventarioMensualDTO>();

			for (StockInventarioMensual stockInventarioMensualTmp : stockInventarioMensual) {
				StockInventarioMensualDTO stockInventarioMensualDTO2 = new StockInventarioMensualDTO();

				stockInventarioMensualDTO2.setIdStin(stockInventarioMensualTmp
						.getIdStin());
				stockInventarioMensualDTO2.setAno((stockInventarioMensualTmp
						.getAno() != null) ? stockInventarioMensualTmp.getAno()
						: null);
				stockInventarioMensualDTO2
						.setCantidadEntrada((stockInventarioMensualTmp
								.getCantidadEntrada() != null) ? stockInventarioMensualTmp
								.getCantidadEntrada() : null);
				stockInventarioMensualDTO2
						.setCantidadSalidas((stockInventarioMensualTmp
								.getCantidadSalidas() != null) ? stockInventarioMensualTmp
								.getCantidadSalidas() : null);
				stockInventarioMensualDTO2
						.setCostoEntradas((stockInventarioMensualTmp
								.getCostoEntradas() != null) ? stockInventarioMensualTmp
								.getCostoEntradas() : null);
				stockInventarioMensualDTO2
						.setCostoSalidas((stockInventarioMensualTmp
								.getCostoSalidas() != null) ? stockInventarioMensualTmp
								.getCostoSalidas() : null);
				stockInventarioMensualDTO2
						.setEstadoRegistro((stockInventarioMensualTmp
								.getEstadoRegistro() != null) ? stockInventarioMensualTmp
								.getEstadoRegistro() : null);
				stockInventarioMensualDTO2
						.setFechaCreacion(stockInventarioMensualTmp
								.getFechaCreacion());
				stockInventarioMensualDTO2
						.setFechaModificacion(stockInventarioMensualTmp
								.getFechaModificacion());
				stockInventarioMensualDTO2
						.setMaximoDistribucion((stockInventarioMensualTmp
								.getMaximoDistribucion() != null) ? stockInventarioMensualTmp
								.getMaximoDistribucion() : null);
				stockInventarioMensualDTO2
						.setMaximoPedido((stockInventarioMensualTmp
								.getMaximoPedido() != null) ? stockInventarioMensualTmp
								.getMaximoPedido() : null);
				stockInventarioMensualDTO2.setMes((stockInventarioMensualTmp
						.getMes() != null) ? stockInventarioMensualTmp.getMes()
						: null);
				stockInventarioMensualDTO2
						.setMinimoDistribucion((stockInventarioMensualTmp
								.getMinimoDistribucion() != null) ? stockInventarioMensualTmp
								.getMinimoDistribucion() : null);
				stockInventarioMensualDTO2
						.setMinimoPedido((stockInventarioMensualTmp
								.getMinimoPedido() != null) ? stockInventarioMensualTmp
								.getMinimoPedido() : null);
				stockInventarioMensualDTO2
						.setOperCreador((stockInventarioMensualTmp
								.getOperCreador() != null) ? stockInventarioMensualTmp
								.getOperCreador() : null);
				stockInventarioMensualDTO2
						.setOperModifica((stockInventarioMensualTmp
								.getOperModifica() != null) ? stockInventarioMensualTmp
								.getOperModifica() : null);
				stockInventarioMensualDTO2
						.setIdSini_SaldoInicialInventario((stockInventarioMensualTmp
								.getSaldoInicialInventario().getIdSini() != null) ? stockInventarioMensualTmp
								.getSaldoInicialInventario().getIdSini() : null);
				stockInventarioMensualDTO.add(stockInventarioMensualDTO2);
			}

			return stockInventarioMensualDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public StockInventarioMensual getStockInventarioMensual(Long idStin)
			throws Exception {
		StockInventarioMensual entity = null;

		try {
			entity = stockInventarioMensualDAO.findById(idStin);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"StockInventarioMensual");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<StockInventarioMensual> findPageStockInventarioMensual(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<StockInventarioMensual> entity = null;

		try {
			entity = stockInventarioMensualDAO.findPage(sortColumnName,
					sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"StockInventarioMensual Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberStockInventarioMensual() throws Exception {
		Long entity = null;

		try {
			entity = stockInventarioMensualDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"StockInventarioMensual Count");
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
	public List<StockInventarioMensual> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<StockInventarioMensual> list = new ArrayList<StockInventarioMensual>();
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
			list = stockInventarioMensualDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
