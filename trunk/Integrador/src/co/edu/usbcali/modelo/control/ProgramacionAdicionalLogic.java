package co.edu.usbcali.modelo.control;

import co.edu.usbcali.dataaccess.dao.*;
import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.ProgramacionAdicionalDTO;
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
@Service("ProgramacionAdicionalLogic")
public class ProgramacionAdicionalLogic implements IProgramacionAdicionalLogic {
	/**
	 * DAO injected by Spring that manages ProgramacionAdicional entities
	 * 
	 */
	@Autowired
	private IProgramacionAdicionalDAO programacionAdicionalDAO;

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
	 * Logic injected by Spring that manages Causal entities
	 * 
	 */
	@Autowired
	ICausalLogic logicCausal2;

	@Transactional(readOnly = true)
	public List<ProgramacionAdicional> getProgramacionAdicional()
			throws Exception {
		List<ProgramacionAdicional> list = new ArrayList<ProgramacionAdicional>();

		try {
			list = programacionAdicionalDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "ProgramacionAdicional");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveProgramacionAdicional(ProgramacionAdicional entity)
			throws Exception {
		try {
			if (entity.getAtencionVendedor() == null) {
				throw new ZMessManager().new ForeignException(
						"atencionVendedor");
			}

			if (entity.getCausal() == null) {
				throw new ZMessManager().new ForeignException("causal");
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

			if (entity.getFechaProgAdicional() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaProgAdicional");
			}

			if (entity.getIdPrad() == null) {
				throw new ZMessManager().new EmptyFieldException("idPrad");
			}

			if ((entity.getIdPrad() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdPrad(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idPrad");
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

			if (getProgramacionAdicional(entity.getIdPrad()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			programacionAdicionalDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteProgramacionAdicional(ProgramacionAdicional entity)
			throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion(
					"ProgramacionAdicional");
		}

		if (entity.getIdPrad() == null) {
			throw new ZMessManager().new EmptyFieldException("idPrad");
		}

		List<Visita> visitas = null;

		try {
			visitas = visitaDAO.findByProperty("programacionAdicional.idPrad",
					entity.getIdPrad());

			if (Utilities.validationsList(visitas) == true) {
				throw new ZMessManager().new DeletingException("visitas");
			}

			programacionAdicionalDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateProgramacionAdicional(ProgramacionAdicional entity)
			throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"ProgramacionAdicional");
			}

			if (entity.getAtencionVendedor() == null) {
				throw new ZMessManager().new ForeignException(
						"atencionVendedor");
			}

			if (entity.getCausal() == null) {
				throw new ZMessManager().new ForeignException("causal");
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

			if (entity.getFechaProgAdicional() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaProgAdicional");
			}

			if (entity.getIdPrad() == null) {
				throw new ZMessManager().new EmptyFieldException("idPrad");
			}

			if ((entity.getIdPrad() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdPrad(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idPrad");
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

			programacionAdicionalDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<ProgramacionAdicionalDTO> getDataProgramacionAdicional()
			throws Exception {
		try {
			List<ProgramacionAdicional> programacionAdicional = programacionAdicionalDAO
					.findAll();

			List<ProgramacionAdicionalDTO> programacionAdicionalDTO = new ArrayList<ProgramacionAdicionalDTO>();

			for (ProgramacionAdicional programacionAdicionalTmp : programacionAdicional) {
				ProgramacionAdicionalDTO programacionAdicionalDTO2 = new ProgramacionAdicionalDTO();

				programacionAdicionalDTO2.setIdPrad(programacionAdicionalTmp
						.getIdPrad());
				programacionAdicionalDTO2
						.setEstadoRegistro((programacionAdicionalTmp
								.getEstadoRegistro() != null) ? programacionAdicionalTmp
								.getEstadoRegistro() : null);
				programacionAdicionalDTO2
						.setFechaCreacion(programacionAdicionalTmp
								.getFechaCreacion());
				programacionAdicionalDTO2
						.setFechaModificacion(programacionAdicionalTmp
								.getFechaModificacion());
				programacionAdicionalDTO2
						.setFechaProgAdicional(programacionAdicionalTmp
								.getFechaProgAdicional());
				programacionAdicionalDTO2
						.setOperCreador((programacionAdicionalTmp
								.getOperCreador() != null) ? programacionAdicionalTmp
								.getOperCreador() : null);
				programacionAdicionalDTO2
						.setOperModifica((programacionAdicionalTmp
								.getOperModifica() != null) ? programacionAdicionalTmp
								.getOperModifica() : null);
				programacionAdicionalDTO2
						.setIdAtve_AtencionVendedor((programacionAdicionalTmp
								.getAtencionVendedor().getIdAtve() != null) ? programacionAdicionalTmp
								.getAtencionVendedor().getIdAtve() : null);

				if (programacionAdicionalTmp.getCausal() != null) {
					programacionAdicionalDTO2
							.setIdCusa_Causal(programacionAdicionalTmp
									.getCausal().getIdCusa());
				} else {
					programacionAdicionalDTO2.setIdCusa_Causal(null);
				}

				programacionAdicionalDTO.add(programacionAdicionalDTO2);
			}

			return programacionAdicionalDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public ProgramacionAdicional getProgramacionAdicional(Long idPrad)
			throws Exception {
		ProgramacionAdicional entity = null;

		try {
			entity = programacionAdicionalDAO.findById(idPrad);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"ProgramacionAdicional");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<ProgramacionAdicional> findPageProgramacionAdicional(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<ProgramacionAdicional> entity = null;

		try {
			entity = programacionAdicionalDAO.findPage(sortColumnName,
					sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"ProgramacionAdicional Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberProgramacionAdicional() throws Exception {
		Long entity = null;

		try {
			entity = programacionAdicionalDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"ProgramacionAdicional Count");
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
	public List<ProgramacionAdicional> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<ProgramacionAdicional> list = new ArrayList<ProgramacionAdicional>();
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
			list = programacionAdicionalDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
