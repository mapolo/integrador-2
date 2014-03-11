package co.edu.usbcali.modelo.control;

import co.edu.usbcali.dataaccess.dao.*;
import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.ConfSemanasAnoDTO;
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
@Service("ConfSemanasAnoLogic")
public class ConfSemanasAnoLogic implements IConfSemanasAnoLogic {
	/**
	 * DAO injected by Spring that manages ConfSemanasAno entities
	 * 
	 */
	@Autowired
	private IConfSemanasAnoDAO confSemanasAnoDAO;

	/**
	 * Logic injected by Spring that manages Semana entities
	 * 
	 */
	@Autowired
	ISemanaLogic logicSemana1;

	@Transactional(readOnly = true)
	public List<ConfSemanasAno> getConfSemanasAno() throws Exception {
		List<ConfSemanasAno> list = new ArrayList<ConfSemanasAno>();

		try {
			list = confSemanasAnoDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "ConfSemanasAno");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveConfSemanasAno(ConfSemanasAno entity) throws Exception {
		try {
			if (entity.getSemana() == null) {
				throw new ZMessManager().new ForeignException("semana");
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

			if (entity.getFechaFinal() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaFinal");
			}

			if (entity.getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaModificacion");
			}

			if (entity.getIdCfsa() == null) {
				throw new ZMessManager().new EmptyFieldException("idCfsa");
			}

			if ((entity.getIdCfsa() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdCfsa(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idCfsa");
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

			if (entity.getSemana().getIdSema() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idSema_Semana");
			}

			if ((entity.getSemana().getIdSema() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getSemana().getIdSema(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idSema_Semana");
			}

			if (getConfSemanasAno(entity.getIdCfsa()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			confSemanasAnoDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteConfSemanasAno(ConfSemanasAno entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("ConfSemanasAno");
		}

		if (entity.getIdCfsa() == null) {
			throw new ZMessManager().new EmptyFieldException("idCfsa");
		}

		try {
			confSemanasAnoDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateConfSemanasAno(ConfSemanasAno entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"ConfSemanasAno");
			}

			if (entity.getSemana() == null) {
				throw new ZMessManager().new ForeignException("semana");
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

			if (entity.getFechaFinal() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaFinal");
			}

			if (entity.getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaModificacion");
			}

			if (entity.getIdCfsa() == null) {
				throw new ZMessManager().new EmptyFieldException("idCfsa");
			}

			if ((entity.getIdCfsa() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdCfsa(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idCfsa");
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

			if (entity.getSemana().getIdSema() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idSema_Semana");
			}

			if ((entity.getSemana().getIdSema() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getSemana().getIdSema(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idSema_Semana");
			}

			confSemanasAnoDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<ConfSemanasAnoDTO> getDataConfSemanasAno() throws Exception {
		try {
			List<ConfSemanasAno> confSemanasAno = confSemanasAnoDAO.findAll();

			List<ConfSemanasAnoDTO> confSemanasAnoDTO = new ArrayList<ConfSemanasAnoDTO>();

			for (ConfSemanasAno confSemanasAnoTmp : confSemanasAno) {
				ConfSemanasAnoDTO confSemanasAnoDTO2 = new ConfSemanasAnoDTO();

				confSemanasAnoDTO2.setIdCfsa(confSemanasAnoTmp.getIdCfsa());
				confSemanasAnoDTO2.setEstadoRegistro((confSemanasAnoTmp
						.getEstadoRegistro() != null) ? confSemanasAnoTmp
						.getEstadoRegistro() : null);
				confSemanasAnoDTO2.setFechaCreacion(confSemanasAnoTmp
						.getFechaCreacion());
				confSemanasAnoDTO2.setFechaFinal(confSemanasAnoTmp
						.getFechaFinal());
				confSemanasAnoDTO2.setFechaInicial(confSemanasAnoTmp
						.getFechaInicial());
				confSemanasAnoDTO2.setFechaModificacion(confSemanasAnoTmp
						.getFechaModificacion());
				confSemanasAnoDTO2.setOperCreador((confSemanasAnoTmp
						.getOperCreador() != null) ? confSemanasAnoTmp
						.getOperCreador() : null);
				confSemanasAnoDTO2.setOperModifica((confSemanasAnoTmp
						.getOperModifica() != null) ? confSemanasAnoTmp
						.getOperModifica() : null);
				confSemanasAnoDTO2.setIdSema_Semana((confSemanasAnoTmp
						.getSemana().getIdSema() != null) ? confSemanasAnoTmp
						.getSemana().getIdSema() : null);
				confSemanasAnoDTO.add(confSemanasAnoDTO2);
			}

			return confSemanasAnoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public ConfSemanasAno getConfSemanasAno(Long idCfsa) throws Exception {
		ConfSemanasAno entity = null;

		try {
			entity = confSemanasAnoDAO.findById(idCfsa);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ConfSemanasAno");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<ConfSemanasAno> findPageConfSemanasAno(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<ConfSemanasAno> entity = null;

		try {
			entity = confSemanasAnoDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"ConfSemanasAno Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberConfSemanasAno() throws Exception {
		Long entity = null;

		try {
			entity = confSemanasAnoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"ConfSemanasAno Count");
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
	public List<ConfSemanasAno> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<ConfSemanasAno> list = new ArrayList<ConfSemanasAno>();
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
			list = confSemanasAnoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
