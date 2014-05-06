package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.IDetalleVisitaDAO;
import co.edu.usbcali.dataaccess.dao.IVisitaDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.DetalleVisita;
import co.edu.usbcali.modelo.Visita;
import co.edu.usbcali.modelo.dto.VisitaDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("VisitaLogic")
public class VisitaLogic implements IVisitaLogic {
	/**
	 * DAO injected by Spring that manages Visita entities
	 * 
	 */
	@Autowired
	private IVisitaDAO visitaDAO;

	/**
	 * DAO injected by Spring that manages DetalleVisita entities
	 * 
	 */
	@Autowired
	private IDetalleVisitaDAO detalleVisitaDAO;

	/**
	 * Logic injected by Spring that manages Causal entities
	 * 
	 */
	@Autowired
	ICausalLogic logicCausal1;

	/**
	 * Logic injected by Spring that manages ProgramacionAdicional entities
	 * 
	 */
	@Autowired
	IProgramacionAdicionalLogic logicProgramacionAdicional2;

	/**
	 * Logic injected by Spring that manages ProgramacionVisitas entities
	 * 
	 */
	@Autowired
	IProgramacionVisitasLogic logicProgramacionVisitas3;

	@Transactional(readOnly = true)
	public List<Visita> getVisita() throws Exception {
		List<Visita> list = new ArrayList<Visita>();

		try {
			list = visitaDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "Visita");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveVisita(Visita entity) throws Exception {
		try {
			if (entity.getCausal() == null) {
				throw new ZMessManager().new ForeignException("causal");
			}

			if (entity.getProgramacionAdicional() == null) {
				throw new ZMessManager().new ForeignException(
						"programacionAdicional");
			}

			if (entity.getProgramacionVisitas() == null) {
				throw new ZMessManager().new ForeignException(
						"programacionVisitas");
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

			if (entity.getEstadoVisita() == null) {
				throw new ZMessManager().new EmptyFieldException("estadoVisita");
			}

			if ((entity.getEstadoVisita() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEstadoVisita(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"estadoVisita");
			}

			if (entity.getFechaCreacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaCreacion");
			}

			if (entity.getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaModificacion");
			}

			if (entity.getIdVisi() == null) {
				throw new ZMessManager().new EmptyFieldException("idVisi");
			}

			if ((entity.getIdVisi() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdVisi(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idVisi");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getObservacion(), 1000) == false)) {
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

			if (entity.getProgramacionAdicional().getIdPrad() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idPrad_ProgramacionAdicional");
			}

			if ((entity.getProgramacionAdicional().getIdPrad() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getProgramacionAdicional().getIdPrad(),
							10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idPrad_ProgramacionAdicional");
			}

			if (entity.getProgramacionVisitas().getIdPrvi() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idPrvi_ProgramacionVisitas");
			}

			if ((entity.getProgramacionVisitas().getIdPrvi() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getProgramacionVisitas().getIdPrvi(), 10,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idPrvi_ProgramacionVisitas");
			}

			if (getVisita(entity.getIdVisi()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			visitaDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteVisita(Visita entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Visita");
		}

		if (entity.getIdVisi() == null) {
			throw new ZMessManager().new EmptyFieldException("idVisi");
		}

		List<DetalleVisita> detalleVisitas = null;

		try {
			detalleVisitas = detalleVisitaDAO.findByProperty("visita.idVisi",
					entity.getIdVisi());

			if (Utilities.validationsList(detalleVisitas) == true) {
				throw new ZMessManager().new DeletingException("detalleVisitas");
			}

			visitaDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateVisita(Visita entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Visita");
			}

			if (entity.getCausal() == null) {
				throw new ZMessManager().new ForeignException("causal");
			}

			if (entity.getProgramacionAdicional() == null) {
				throw new ZMessManager().new ForeignException(
						"programacionAdicional");
			}

			if (entity.getProgramacionVisitas() == null) {
				throw new ZMessManager().new ForeignException(
						"programacionVisitas");
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

			if (entity.getEstadoVisita() == null) {
				throw new ZMessManager().new EmptyFieldException("estadoVisita");
			}

			if ((entity.getEstadoVisita() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEstadoVisita(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"estadoVisita");
			}

			if (entity.getFechaCreacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaCreacion");
			}

			if (entity.getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaModificacion");
			}

			if (entity.getIdVisi() == null) {
				throw new ZMessManager().new EmptyFieldException("idVisi");
			}

			if ((entity.getIdVisi() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdVisi(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idVisi");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getObservacion(), 1000) == false)) {
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

			if (entity.getProgramacionAdicional().getIdPrad() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idPrad_ProgramacionAdicional");
			}

			if ((entity.getProgramacionAdicional().getIdPrad() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getProgramacionAdicional().getIdPrad(),
							10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idPrad_ProgramacionAdicional");
			}

			if (entity.getProgramacionVisitas().getIdPrvi() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idPrvi_ProgramacionVisitas");
			}

			if ((entity.getProgramacionVisitas().getIdPrvi() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getProgramacionVisitas().getIdPrvi(), 10,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idPrvi_ProgramacionVisitas");
			}

			visitaDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<VisitaDTO> getDataVisita() throws Exception {
		try {
			List<Visita> visita = visitaDAO.findAll();

			List<VisitaDTO> visitaDTO = new ArrayList<VisitaDTO>();

			for (Visita visitaTmp : visita) {
				VisitaDTO visitaDTO2 = new VisitaDTO();

				visitaDTO2.setIdVisi(visitaTmp.getIdVisi());
				visitaDTO2
						.setEstadoRegistro((visitaTmp.getEstadoRegistro() != null) ? visitaTmp
								.getEstadoRegistro() : null);
				visitaDTO2
						.setEstadoVisita((visitaTmp.getEstadoVisita() != null) ? visitaTmp
								.getEstadoVisita() : null);
				visitaDTO2.setFechaCreacion(visitaTmp.getFechaCreacion());
				visitaDTO2.setFechaModificacion(visitaTmp
						.getFechaModificacion());
				visitaDTO2
						.setObservacion((visitaTmp.getObservacion() != null) ? visitaTmp
								.getObservacion() : null);
				visitaDTO2
						.setOperCreador((visitaTmp.getOperCreador() != null) ? visitaTmp
								.getOperCreador() : null);
				visitaDTO2
						.setOperModifica((visitaTmp.getOperModifica() != null) ? visitaTmp
								.getOperModifica() : null);

				if (visitaTmp.getCausal() != null) {
					visitaDTO2.setIdCusa_Causal(visitaTmp.getCausal()
							.getIdCusa());
				} else {
					visitaDTO2.setIdCusa_Causal(null);
				}

				visitaDTO2
						.setIdPrad_ProgramacionAdicional((visitaTmp
								.getProgramacionAdicional().getIdPrad() != null) ? visitaTmp
								.getProgramacionAdicional().getIdPrad() : null);
				visitaDTO2
						.setIdPrvi_ProgramacionVisitas((visitaTmp
								.getProgramacionVisitas().getIdPrvi() != null) ? visitaTmp
								.getProgramacionVisitas().getIdPrvi() : null);
				visitaDTO.add(visitaDTO2);
			}

			return visitaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Visita getVisita(Long idVisi) throws Exception {
		Visita entity = null;

		try {
			entity = visitaDAO.findById(idVisi);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Visita");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Visita> findPageVisita(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Visita> entity = null;

		try {
			entity = visitaDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Visita Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberVisita() throws Exception {
		Long entity = null;

		try {
			entity = visitaDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Visita Count");
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
	public List<Visita> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Visita> list = new ArrayList<Visita>();
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
			list = visitaDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
