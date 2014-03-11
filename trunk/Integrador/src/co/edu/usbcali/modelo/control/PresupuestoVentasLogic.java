package co.edu.usbcali.modelo.control;

import co.edu.usbcali.dataaccess.dao.*;
import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.PresupuestoVentasDTO;
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
@Service("PresupuestoVentasLogic")
public class PresupuestoVentasLogic implements IPresupuestoVentasLogic {
	/**
	 * DAO injected by Spring that manages PresupuestoVentas entities
	 * 
	 */
	@Autowired
	private IPresupuestoVentasDAO presupuestoVentasDAO;

	/**
	 * Logic injected by Spring that manages Familia entities
	 * 
	 */
	@Autowired
	IFamiliaLogic logicFamilia1;

	/**
	 * Logic injected by Spring that manages UnidadVenta entities
	 * 
	 */
	@Autowired
	IUnidadVentaLogic logicUnidadVenta2;

	@Transactional(readOnly = true)
	public List<PresupuestoVentas> getPresupuestoVentas() throws Exception {
		List<PresupuestoVentas> list = new ArrayList<PresupuestoVentas>();

		try {
			list = presupuestoVentasDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "PresupuestoVentas");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void savePresupuestoVentas(PresupuestoVentas entity)
			throws Exception {
		try {
			if (entity.getFamilia() == null) {
				throw new ZMessManager().new ForeignException("familia");
			}

			if (entity.getUnidadVenta() == null) {
				throw new ZMessManager().new ForeignException("unidadVenta");
			}

			if ((entity.getAno() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getAno(), 5, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ano");
			}

			if ((entity.getCanal() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCanal(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException("canal");
			}

			if ((entity.getCantidadPresupuesto() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadPresupuesto(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadPresupuesto");
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

			if (entity.getIdPven() == null) {
				throw new ZMessManager().new EmptyFieldException("idPven");
			}

			if ((entity.getIdPven() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdPven(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idPven");
			}

			if ((entity.getMes() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMes(), 3, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("mes");
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

			if ((entity.getValorPresupuesto() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getValorPresupuesto(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"valorPresupuesto");
			}

			if (entity.getFamilia().getIdFlia() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idFlia_Familia");
			}

			if ((entity.getFamilia().getIdFlia() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getFamilia().getIdFlia(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idFlia_Familia");
			}

			if (entity.getUnidadVenta().getIdUnve() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idUnve_UnidadVenta");
			}

			if ((entity.getUnidadVenta().getIdUnve() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getUnidadVenta().getIdUnve(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idUnve_UnidadVenta");
			}

			if (getPresupuestoVentas(entity.getIdPven()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			presupuestoVentasDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deletePresupuestoVentas(PresupuestoVentas entity)
			throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion(
					"PresupuestoVentas");
		}

		if (entity.getIdPven() == null) {
			throw new ZMessManager().new EmptyFieldException("idPven");
		}

		try {
			presupuestoVentasDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updatePresupuestoVentas(PresupuestoVentas entity)
			throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"PresupuestoVentas");
			}

			if (entity.getFamilia() == null) {
				throw new ZMessManager().new ForeignException("familia");
			}

			if (entity.getUnidadVenta() == null) {
				throw new ZMessManager().new ForeignException("unidadVenta");
			}

			if ((entity.getAno() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getAno(), 5, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ano");
			}

			if ((entity.getCanal() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCanal(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException("canal");
			}

			if ((entity.getCantidadPresupuesto() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadPresupuesto(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadPresupuesto");
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

			if (entity.getIdPven() == null) {
				throw new ZMessManager().new EmptyFieldException("idPven");
			}

			if ((entity.getIdPven() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdPven(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idPven");
			}

			if ((entity.getMes() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMes(), 3, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("mes");
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

			if ((entity.getValorPresupuesto() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getValorPresupuesto(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"valorPresupuesto");
			}

			if (entity.getFamilia().getIdFlia() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idFlia_Familia");
			}

			if ((entity.getFamilia().getIdFlia() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getFamilia().getIdFlia(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idFlia_Familia");
			}

			if (entity.getUnidadVenta().getIdUnve() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idUnve_UnidadVenta");
			}

			if ((entity.getUnidadVenta().getIdUnve() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getUnidadVenta().getIdUnve(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idUnve_UnidadVenta");
			}

			presupuestoVentasDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<PresupuestoVentasDTO> getDataPresupuestoVentas()
			throws Exception {
		try {
			List<PresupuestoVentas> presupuestoVentas = presupuestoVentasDAO
					.findAll();

			List<PresupuestoVentasDTO> presupuestoVentasDTO = new ArrayList<PresupuestoVentasDTO>();

			for (PresupuestoVentas presupuestoVentasTmp : presupuestoVentas) {
				PresupuestoVentasDTO presupuestoVentasDTO2 = new PresupuestoVentasDTO();

				presupuestoVentasDTO2.setIdPven(presupuestoVentasTmp
						.getIdPven());
				presupuestoVentasDTO2
						.setAno((presupuestoVentasTmp.getAno() != null) ? presupuestoVentasTmp
								.getAno() : null);
				presupuestoVentasDTO2
						.setCanal((presupuestoVentasTmp.getCanal() != null) ? presupuestoVentasTmp
								.getCanal() : null);
				presupuestoVentasDTO2
						.setCantidadPresupuesto((presupuestoVentasTmp
								.getCantidadPresupuesto() != null) ? presupuestoVentasTmp
								.getCantidadPresupuesto() : null);
				presupuestoVentasDTO2.setEstadoRegistro((presupuestoVentasTmp
						.getEstadoRegistro() != null) ? presupuestoVentasTmp
						.getEstadoRegistro() : null);
				presupuestoVentasDTO2.setFechaCreacion(presupuestoVentasTmp
						.getFechaCreacion());
				presupuestoVentasDTO2.setFechaModificacion(presupuestoVentasTmp
						.getFechaModificacion());
				presupuestoVentasDTO2
						.setMes((presupuestoVentasTmp.getMes() != null) ? presupuestoVentasTmp
								.getMes() : null);
				presupuestoVentasDTO2.setOperCreador((presupuestoVentasTmp
						.getOperCreador() != null) ? presupuestoVentasTmp
						.getOperCreador() : null);
				presupuestoVentasDTO2.setOperModifica((presupuestoVentasTmp
						.getOperModifica() != null) ? presupuestoVentasTmp
						.getOperModifica() : null);
				presupuestoVentasDTO2.setValorPresupuesto((presupuestoVentasTmp
						.getValorPresupuesto() != null) ? presupuestoVentasTmp
						.getValorPresupuesto() : null);
				presupuestoVentasDTO2
						.setIdFlia_Familia((presupuestoVentasTmp.getFamilia()
								.getIdFlia() != null) ? presupuestoVentasTmp
								.getFamilia().getIdFlia() : null);
				presupuestoVentasDTO2
						.setIdUnve_UnidadVenta((presupuestoVentasTmp
								.getUnidadVenta().getIdUnve() != null) ? presupuestoVentasTmp
								.getUnidadVenta().getIdUnve() : null);
				presupuestoVentasDTO.add(presupuestoVentasDTO2);
			}

			return presupuestoVentasDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public PresupuestoVentas getPresupuestoVentas(Long idPven) throws Exception {
		PresupuestoVentas entity = null;

		try {
			entity = presupuestoVentasDAO.findById(idPven);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("PresupuestoVentas");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<PresupuestoVentas> findPagePresupuestoVentas(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<PresupuestoVentas> entity = null;

		try {
			entity = presupuestoVentasDAO.findPage(sortColumnName,
					sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"PresupuestoVentas Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberPresupuestoVentas() throws Exception {
		Long entity = null;

		try {
			entity = presupuestoVentasDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"PresupuestoVentas Count");
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
	public List<PresupuestoVentas> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<PresupuestoVentas> list = new ArrayList<PresupuestoVentas>();
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
			list = presupuestoVentasDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
