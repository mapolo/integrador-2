package co.edu.usbcali.modelo.control;

import co.edu.usbcali.dataaccess.dao.*;
import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.ProgramacionVisitasDTO;
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
@Service("ProgramacionVisitasLogic")
public class ProgramacionVisitasLogic implements IProgramacionVisitasLogic {
	/**
	 * DAO injected by Spring that manages ProgramacionVisitas entities
	 * 
	 */
	@Autowired
	private IProgramacionVisitasDAO programacionVisitasDAO;

	/**
	 * DAO injected by Spring that manages SolicitudCambio entities
	 * 
	 */
	@Autowired
	private ISolicitudCambioDAO solicitudCambioDAO;

	/**
	 * DAO injected by Spring that manages Visita entities
	 * 
	 */
	@Autowired
	private IVisitaDAO visitaDAO;

	/**
	 * Logic injected by Spring that manages AtencionVendedor entities
	 * 
	 */
	@Autowired
	IAtencionVendedorLogic logicAtencionVendedor1;

	/**
	 * Logic injected by Spring that manages DiasSemana entities
	 * 
	 */
	@Autowired
	IDiasSemanaLogic logicDiasSemana2;

	/**
	 * Logic injected by Spring that manages FrecuenciaVisita entities
	 * 
	 */
	@Autowired
	IFrecuenciaVisitaLogic logicFrecuenciaVisita3;

	@Transactional(readOnly = true)
	public List<ProgramacionVisitas> getProgramacionVisitas() throws Exception {
		List<ProgramacionVisitas> list = new ArrayList<ProgramacionVisitas>();

		try {
			list = programacionVisitasDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "ProgramacionVisitas");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveProgramacionVisitas(ProgramacionVisitas entity)
			throws Exception {
		try {
			if (entity.getAtencionVendedor() == null) {
				throw new ZMessManager().new ForeignException(
						"atencionVendedor");
			}

			if (entity.getDiasSemana() == null) {
				throw new ZMessManager().new ForeignException("diasSemana");
			}

			if (entity.getFrecuenciaVisita() == null) {
				throw new ZMessManager().new ForeignException(
						"frecuenciaVisita");
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

			if (entity.getIdPrvi() == null) {
				throw new ZMessManager().new EmptyFieldException("idPrvi");
			}

			if ((entity.getIdPrvi() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdPrvi(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idPrvi");
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

			if (entity.getAtencionVendedor().getIdAtve() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idAtve_AtencionVendedor");
			}

			if ((entity.getAtencionVendedor().getIdAtve() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getAtencionVendedor().getIdAtve(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idAtve_AtencionVendedor");
			}

			if (entity.getDiasSemana().getIdDise() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idDise_DiasSemana");
			}

			if ((entity.getDiasSemana().getIdDise() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDiasSemana().getIdDise(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idDise_DiasSemana");
			}

			if (entity.getFrecuenciaVisita().getIdFrvi() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idFrvi_FrecuenciaVisita");
			}

			if ((entity.getFrecuenciaVisita().getIdFrvi() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getFrecuenciaVisita().getIdFrvi(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idFrvi_FrecuenciaVisita");
			}

			if (getProgramacionVisitas(entity.getIdPrvi()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			programacionVisitasDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteProgramacionVisitas(ProgramacionVisitas entity)
			throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion(
					"ProgramacionVisitas");
		}

		if (entity.getIdPrvi() == null) {
			throw new ZMessManager().new EmptyFieldException("idPrvi");
		}

		List<SolicitudCambio> solicitudCambios = null;
		List<Visita> visitas = null;

		try {
			solicitudCambios = solicitudCambioDAO.findByProperty(
					"programacionVisitas.idPrvi", entity.getIdPrvi());

			if (Utilities.validationsList(solicitudCambios) == true) {
				throw new ZMessManager().new DeletingException(
						"solicitudCambios");
			}

			visitas = visitaDAO.findByProperty("programacionVisitas.idPrvi",
					entity.getIdPrvi());

			if (Utilities.validationsList(visitas) == true) {
				throw new ZMessManager().new DeletingException("visitas");
			}

			programacionVisitasDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateProgramacionVisitas(ProgramacionVisitas entity)
			throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"ProgramacionVisitas");
			}

			if (entity.getAtencionVendedor() == null) {
				throw new ZMessManager().new ForeignException(
						"atencionVendedor");
			}

			if (entity.getDiasSemana() == null) {
				throw new ZMessManager().new ForeignException("diasSemana");
			}

			if (entity.getFrecuenciaVisita() == null) {
				throw new ZMessManager().new ForeignException(
						"frecuenciaVisita");
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

			if (entity.getIdPrvi() == null) {
				throw new ZMessManager().new EmptyFieldException("idPrvi");
			}

			if ((entity.getIdPrvi() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdPrvi(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idPrvi");
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

			if (entity.getAtencionVendedor().getIdAtve() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idAtve_AtencionVendedor");
			}

			if ((entity.getAtencionVendedor().getIdAtve() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getAtencionVendedor().getIdAtve(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idAtve_AtencionVendedor");
			}

			if (entity.getDiasSemana().getIdDise() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idDise_DiasSemana");
			}

			if ((entity.getDiasSemana().getIdDise() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDiasSemana().getIdDise(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idDise_DiasSemana");
			}

			if (entity.getFrecuenciaVisita().getIdFrvi() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idFrvi_FrecuenciaVisita");
			}

			if ((entity.getFrecuenciaVisita().getIdFrvi() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getFrecuenciaVisita().getIdFrvi(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idFrvi_FrecuenciaVisita");
			}

			programacionVisitasDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<ProgramacionVisitasDTO> getDataProgramacionVisitas()
			throws Exception {
		try {
			List<ProgramacionVisitas> programacionVisitas = programacionVisitasDAO
					.findAll();

			List<ProgramacionVisitasDTO> programacionVisitasDTO = new ArrayList<ProgramacionVisitasDTO>();

			for (ProgramacionVisitas programacionVisitasTmp : programacionVisitas) {
				ProgramacionVisitasDTO programacionVisitasDTO2 = new ProgramacionVisitasDTO();

				programacionVisitasDTO2.setIdPrvi(programacionVisitasTmp
						.getIdPrvi());
				programacionVisitasDTO2
						.setEstadoRegistro((programacionVisitasTmp
								.getEstadoRegistro() != null) ? programacionVisitasTmp
								.getEstadoRegistro() : null);
				programacionVisitasDTO2.setFechaCreacion(programacionVisitasTmp
						.getFechaCreacion());
				programacionVisitasDTO2
						.setFechaModificacion(programacionVisitasTmp
								.getFechaModificacion());
				programacionVisitasDTO2.setOperCreador((programacionVisitasTmp
						.getOperCreador() != null) ? programacionVisitasTmp
						.getOperCreador() : null);
				programacionVisitasDTO2.setOperModifica((programacionVisitasTmp
						.getOperModifica() != null) ? programacionVisitasTmp
						.getOperModifica() : null);
				programacionVisitasDTO2
						.setIdAtve_AtencionVendedor((programacionVisitasTmp
								.getAtencionVendedor().getIdAtve() != null) ? programacionVisitasTmp
								.getAtencionVendedor().getIdAtve() : null);
				programacionVisitasDTO2
						.setIdDise_DiasSemana((programacionVisitasTmp
								.getDiasSemana().getIdDise() != null) ? programacionVisitasTmp
								.getDiasSemana().getIdDise() : null);
				programacionVisitasDTO2
						.setIdFrvi_FrecuenciaVisita((programacionVisitasTmp
								.getFrecuenciaVisita().getIdFrvi() != null) ? programacionVisitasTmp
								.getFrecuenciaVisita().getIdFrvi() : null);
				programacionVisitasDTO.add(programacionVisitasDTO2);
			}

			return programacionVisitasDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public ProgramacionVisitas getProgramacionVisitas(Long idPrvi)
			throws Exception {
		ProgramacionVisitas entity = null;

		try {
			entity = programacionVisitasDAO.findById(idPrvi);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ProgramacionVisitas");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<ProgramacionVisitas> findPageProgramacionVisitas(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<ProgramacionVisitas> entity = null;

		try {
			entity = programacionVisitasDAO.findPage(sortColumnName,
					sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"ProgramacionVisitas Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberProgramacionVisitas() throws Exception {
		Long entity = null;

		try {
			entity = programacionVisitasDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"ProgramacionVisitas Count");
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
	public List<ProgramacionVisitas> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<ProgramacionVisitas> list = new ArrayList<ProgramacionVisitas>();
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
			list = programacionVisitasDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
