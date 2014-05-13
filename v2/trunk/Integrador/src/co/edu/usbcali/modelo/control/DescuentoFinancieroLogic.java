package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.ICruceDAO;
import co.edu.usbcali.dataaccess.dao.IDescuentoFinancieroDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.Cruce;
import co.edu.usbcali.modelo.DescuentoFinanciero;
import co.edu.usbcali.modelo.dto.DescuentoFinancieroDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("DescuentoFinancieroLogic")
public class DescuentoFinancieroLogic implements IDescuentoFinancieroLogic {
	/**
	 * DAO injected by Spring that manages DescuentoFinanciero entities
	 * 
	 */
	@Autowired
	private IDescuentoFinancieroDAO descuentoFinancieroDAO;

	/**
	 * DAO injected by Spring that manages Cruce entities
	 * 
	 */
	@Autowired
	private ICruceDAO cruceDAO;

	/**
	 * Logic injected by Spring that manages Grupo entities
	 * 
	 */
	@Autowired
	IGrupoLogic logicGrupo1;

	/**
	 * Logic injected by Spring that manages TipoFormaPago entities
	 * 
	 */
	@Autowired
	ITipoFormaPagoLogic logicTipoFormaPago2;

	@Transactional(readOnly = true)
	public List<DescuentoFinanciero> getDescuentoFinanciero() throws Exception {
		List<DescuentoFinanciero> list = new ArrayList<DescuentoFinanciero>();

		try {
			list = descuentoFinancieroDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "DescuentoFinanciero");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDescuentoFinanciero(DescuentoFinanciero entity)
			throws Exception {
		try {
			/*
			 * if (entity.getGrupo() == null) { throw new ZMessManager().new
			 * ForeignException("grupo"); }
			 */

			if (entity.getCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("codigo");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCodigo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getDiaDesde() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDiaDesde(), 3, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("diaDesde");
			}

			if ((entity.getDiaHasta() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDiaHasta(), 3, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("diaHasta");
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

			if (entity.getPorcentajeDescuento() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"porcentajeDescuento");
			}

			if ((entity.getPorcentajeDescuento() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPorcentajeDescuento(), 3, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"porcentajeDescuento");
			}

			/*
			 * if (entity.getGrupo().getIdGrpo() == null) { throw new
			 * ZMessManager().new EmptyFieldException("idGrpo_Grupo"); }
			 * 
			 * if ((entity.getGrupo().getIdGrpo() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getGrupo().getIdGrpo(), 10, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "idGrpo_Grupo"); }
			 * 
			 * if ((entity.getTipoFormaPago() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getTipoFormaPago().getIdTfpa(), 10, 0) == false)) { throw
			 * new ZMessManager().new NotValidFormatException(
			 * "idTfpa_TipoFormaPago"); }
			 */

			descuentoFinancieroDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDescuentoFinanciero(DescuentoFinanciero entity)
			throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion(
					"DescuentoFinanciero");
		}

		if (entity.getIdDefi() == null) {
			throw new ZMessManager().new EmptyFieldException("idDefi");
		}

		List<Cruce> cruces = null;

		try {
			cruces = cruceDAO.findByProperty("descuentoFinanciero.idDefi",
					entity.getIdDefi());

			if (Utilities.validationsList(cruces) == true) {
				throw new ZMessManager().new DeletingException("cruces");
			}

			descuentoFinancieroDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDescuentoFinanciero(DescuentoFinanciero entity)
			throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"DescuentoFinanciero");
			}

			/*
			 * if (entity.getGrupo() == null) { throw new ZMessManager().new
			 * ForeignException("grupo"); }
			 */

			if (entity.getCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("codigo");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCodigo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getDiaDesde() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDiaDesde(), 3, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("diaDesde");
			}

			if ((entity.getDiaHasta() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDiaHasta(), 3, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("diaHasta");
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

			/*
			 * if (entity.getIdDefi() == null) { throw new ZMessManager().new
			 * EmptyFieldException("idDefi"); }
			 * 
			 * if ((entity.getIdDefi() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getIdDefi(), 10, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("idDefi"); }
			 */

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

			if (entity.getPorcentajeDescuento() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"porcentajeDescuento");
			}

			if ((entity.getPorcentajeDescuento() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPorcentajeDescuento(), 3, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"porcentajeDescuento");
			}

			/*
			 * if (entity.getGrupo().getIdGrpo() == null) { throw new
			 * ZMessManager().new EmptyFieldException("idGrpo_Grupo"); }
			 * 
			 * if ((entity.getGrupo().getIdGrpo() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getGrupo().getIdGrpo(), 10, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "idGrpo_Grupo"); }
			 */

			/*
			 * if ((entity.getTipoFormaPago() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getTipoFormaPago().getIdTfpa(), 10, 0) == false)) { throw
			 * new ZMessManager().new NotValidFormatException(
			 * "idTfpa_TipoFormaPago"); }
			 */

			descuentoFinancieroDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<DescuentoFinancieroDTO> getDataDescuentoFinanciero()
			throws Exception {
		try {
			List<DescuentoFinanciero> descuentoFinanciero = descuentoFinancieroDAO
					.findAll();

			List<DescuentoFinancieroDTO> descuentoFinancieroDTO = new ArrayList<DescuentoFinancieroDTO>();

			for (DescuentoFinanciero descuentoFinancieroTmp : descuentoFinanciero) {
				DescuentoFinancieroDTO descuentoFinancieroDTO2 = new DescuentoFinancieroDTO();

				descuentoFinancieroDTO2.setIdDefi(descuentoFinancieroTmp
						.getIdDefi());
				descuentoFinancieroDTO2.setCodigo((descuentoFinancieroTmp
						.getCodigo() != null) ? descuentoFinancieroTmp
						.getCodigo() : null);
				descuentoFinancieroDTO2.setDiaDesde((descuentoFinancieroTmp
						.getDiaDesde() != null) ? descuentoFinancieroTmp
						.getDiaDesde() : null);
				descuentoFinancieroDTO2.setDiaHasta((descuentoFinancieroTmp
						.getDiaHasta() != null) ? descuentoFinancieroTmp
						.getDiaHasta() : null);
				descuentoFinancieroDTO2
						.setEstadoRegistro((descuentoFinancieroTmp
								.getEstadoRegistro() != null) ? descuentoFinancieroTmp
								.getEstadoRegistro() : null);
				descuentoFinancieroDTO2.setFechaCreacion(descuentoFinancieroTmp
						.getFechaCreacion());
				descuentoFinancieroDTO2.setFechaFinal(descuentoFinancieroTmp
						.getFechaFinal());
				descuentoFinancieroDTO2.setFechaInicio(descuentoFinancieroTmp
						.getFechaInicio());
				descuentoFinancieroDTO2
						.setFechaModificacion(descuentoFinancieroTmp
								.getFechaModificacion());
				descuentoFinancieroDTO2.setNombre((descuentoFinancieroTmp
						.getNombre() != null) ? descuentoFinancieroTmp
						.getNombre() : null);
				descuentoFinancieroDTO2.setOperCreador((descuentoFinancieroTmp
						.getOperCreador() != null) ? descuentoFinancieroTmp
						.getOperCreador() : null);
				descuentoFinancieroDTO2.setOperModifica((descuentoFinancieroTmp
						.getOperModifica() != null) ? descuentoFinancieroTmp
						.getOperModifica() : null);
				descuentoFinancieroDTO2
						.setPorcentajeDescuento((descuentoFinancieroTmp
								.getPorcentajeDescuento() != null) ? descuentoFinancieroTmp
								.getPorcentajeDescuento() : null);
				descuentoFinancieroDTO2
						.setIdGrpo_Grupo((descuentoFinancieroTmp.getGrupo()
								.getIdGrpo() != null) ? descuentoFinancieroTmp
								.getGrupo().getIdGrpo() : null);

				if (descuentoFinancieroTmp.getTipoFormaPago() != null) {

					descuentoFinancieroDTO2
							.setIdTfpa_TipoFormaPago(descuentoFinancieroTmp
									.getTipoFormaPago().getIdTfpa());
				} else {
					descuentoFinancieroDTO2.setIdTfpa_TipoFormaPago(null);

				}

				/*
				 * if (descuentoFinancieroTmp.getTipoFormaPago() != null) {
				 * descuentoFinancieroDTO2
				 * .setIdTfpa_TipoFormaPago((descuentoFinancieroTmp
				 * .getTipoFormaPago().getIdTfpa() != null) ?
				 * descuentoFinancieroTmp .getTipoFormaPago().getIdTfpa() :
				 * null); }
				 */

				descuentoFinancieroDTO.add(descuentoFinancieroDTO2);
			}

			return descuentoFinancieroDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public DescuentoFinanciero getDescuentoFinanciero(Long idDefi)
			throws Exception {
		DescuentoFinanciero entity = null;

		try {
			entity = descuentoFinancieroDAO.findById(idDefi);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DescuentoFinanciero");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<DescuentoFinanciero> findPageDescuentoFinanciero(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<DescuentoFinanciero> entity = null;

		try {
			entity = descuentoFinancieroDAO.findPage(sortColumnName,
					sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"DescuentoFinanciero Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberDescuentoFinanciero() throws Exception {
		Long entity = null;

		try {
			entity = descuentoFinancieroDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"DescuentoFinanciero Count");
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
	public List<DescuentoFinanciero> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<DescuentoFinanciero> list = new ArrayList<DescuentoFinanciero>();
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
			list = descuentoFinancieroDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
