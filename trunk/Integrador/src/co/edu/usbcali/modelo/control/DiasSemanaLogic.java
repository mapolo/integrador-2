package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.IDiasSemanaDAO;
import co.edu.usbcali.dataaccess.dao.IProgramacionVisitasDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.DiasSemana;
import co.edu.usbcali.modelo.ProgramacionVisitas;
import co.edu.usbcali.modelo.dto.DiasSemanaDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("DiasSemanaLogic")
public class DiasSemanaLogic implements IDiasSemanaLogic {
	/**
	 * DAO injected by Spring that manages DiasSemana entities
	 * 
	 */
	@Autowired
	private IDiasSemanaDAO diasSemanaDAO;

	/**
	 * DAO injected by Spring that manages ProgramacionVisitas entities
	 * 
	 */
	@Autowired
	private IProgramacionVisitasDAO programacionVisitasDAO;

	@Transactional(readOnly = true)
	public List<DiasSemana> getDiasSemana() throws Exception {
		List<DiasSemana> list = new ArrayList<DiasSemana>();

		try {
			list = diasSemanaDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "DiasSemana");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDiasSemana(DiasSemana entity) throws Exception {
		try {
			if (entity.getCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("codigo");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCodigo(), 15) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
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

			if (entity.getIdDise() == null) {
				throw new ZMessManager().new EmptyFieldException("idDise");
			}

			if ((entity.getIdDise() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdDise(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idDise");
			}

			if (entity.getNombre() == null) {
				throw new ZMessManager().new EmptyFieldException("nombre");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNombre(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
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

			if (getDiasSemana(entity.getIdDise()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			diasSemanaDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDiasSemana(DiasSemana entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("DiasSemana");
		}

		if (entity.getIdDise() == null) {
			throw new ZMessManager().new EmptyFieldException("idDise");
		}

		List<ProgramacionVisitas> programacionVisitases = null;

		try {
			programacionVisitases = programacionVisitasDAO.findByProperty(
					"diasSemana.idDise", entity.getIdDise());

			if (Utilities.validationsList(programacionVisitases) == true) {
				throw new ZMessManager().new DeletingException(
						"programacionVisitases");
			}

			diasSemanaDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDiasSemana(DiasSemana entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("DiasSemana");
			}

			if (entity.getCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("codigo");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCodigo(), 15) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
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

			if (entity.getIdDise() == null) {
				throw new ZMessManager().new EmptyFieldException("idDise");
			}

			if ((entity.getIdDise() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdDise(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idDise");
			}

			if (entity.getNombre() == null) {
				throw new ZMessManager().new EmptyFieldException("nombre");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNombre(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
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

			diasSemanaDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<DiasSemanaDTO> getDataDiasSemana() throws Exception {
		try {
			List<DiasSemana> diasSemana = diasSemanaDAO.findAll();

			List<DiasSemanaDTO> diasSemanaDTO = new ArrayList<DiasSemanaDTO>();

			for (DiasSemana diasSemanaTmp : diasSemana) {
				DiasSemanaDTO diasSemanaDTO2 = new DiasSemanaDTO();

				diasSemanaDTO2.setIdDise(diasSemanaTmp.getIdDise());
				diasSemanaDTO2
						.setCodigo((diasSemanaTmp.getCodigo() != null) ? diasSemanaTmp
								.getCodigo() : null);
				diasSemanaDTO2.setEstadoRegistro((diasSemanaTmp
						.getEstadoRegistro() != null) ? diasSemanaTmp
						.getEstadoRegistro() : null);
				diasSemanaDTO2.setFechaCreacion(diasSemanaTmp
						.getFechaCreacion());
				diasSemanaDTO2.setFechaModificacion(diasSemanaTmp
						.getFechaModificacion());
				diasSemanaDTO2
						.setNombre((diasSemanaTmp.getNombre() != null) ? diasSemanaTmp
								.getNombre() : null);
				diasSemanaDTO2
						.setOperCreador((diasSemanaTmp.getOperCreador() != null) ? diasSemanaTmp
								.getOperCreador() : null);
				diasSemanaDTO2
						.setOperModifica((diasSemanaTmp.getOperModifica() != null) ? diasSemanaTmp
								.getOperModifica() : null);
				diasSemanaDTO.add(diasSemanaDTO2);
			}

			return diasSemanaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public DiasSemana getDiasSemana(Long idDise) throws Exception {
		DiasSemana entity = null;

		try {
			entity = diasSemanaDAO.findById(idDise);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DiasSemana");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<DiasSemana> findPageDiasSemana(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<DiasSemana> entity = null;

		try {
			entity = diasSemanaDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DiasSemana Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberDiasSemana() throws Exception {
		Long entity = null;

		try {
			entity = diasSemanaDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DiasSemana Count");
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
	public List<DiasSemana> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<DiasSemana> list = new ArrayList<DiasSemana>();
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
			list = diasSemanaDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
