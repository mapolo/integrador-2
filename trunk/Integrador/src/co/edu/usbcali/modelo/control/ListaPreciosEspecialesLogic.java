package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.IListaPreciosEspecialesDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.ListaPreciosEspeciales;
import co.edu.usbcali.modelo.dto.ListaPreciosEspecialesDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("ListaPreciosEspecialesLogic")
public class ListaPreciosEspecialesLogic implements
		IListaPreciosEspecialesLogic {
	/**
	 * DAO injected by Spring that manages ListaPreciosEspeciales entities
	 * 
	 */
	@Autowired
	private IListaPreciosEspecialesDAO listaPreciosEspecialesDAO;

	/**
	 * Logic injected by Spring that manages Empresa entities
	 * 
	 */
	@Autowired
	IEmpresaLogic logicEmpresa1;

	/**
	 * Logic injected by Spring that manages Persona entities
	 * 
	 */
	@Autowired
	IPersonaLogic logicPersona2;

	/**
	 * Logic injected by Spring that manages Referencia entities
	 * 
	 */
	@Autowired
	IReferenciaLogic logicReferencia3;

	/**
	 * Logic injected by Spring that manages Sucursal entities
	 * 
	 */
	@Autowired
	ISucursalLogic logicSucursal4;

	/**
	 * Logic injected by Spring that manages Sucursal entities
	 * 
	 */
	@Autowired
	ISucursalLogic logicSucursal5;

	@Transactional(readOnly = true)
	public List<ListaPreciosEspeciales> getListaPreciosEspeciales()
			throws Exception {
		List<ListaPreciosEspeciales> list = new ArrayList<ListaPreciosEspeciales>();

		try {
			list = listaPreciosEspecialesDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "ListaPreciosEspeciales");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveListaPreciosEspeciales(ListaPreciosEspeciales entity)
			throws Exception {
		try {
			if (entity.getEmpresa() == null) {
				throw new ZMessManager().new ForeignException("empresa");
			}

			if (entity.getPersona() == null) {
				throw new ZMessManager().new ForeignException("persona");
			}

			if (entity.getReferencia() == null) {
				throw new ZMessManager().new ForeignException("referencia");
			}

			if (entity.getSucursalByIdSucu() == null) {
				throw new ZMessManager().new ForeignException(
						"sucursalByIdSucu");
			}

			if (entity.getSucursalBySucursal() == null) {
				throw new ZMessManager().new ForeignException(
						"sucursalBySucursal");
			}

			if ((entity.getConcepto() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getConcepto(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException("concepto");
			}

			if ((entity.getEspacios() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEspacios(), 120) == false)) {
				throw new ZMessManager().new NotValidFormatException("espacios");
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

			if (entity.getFechaInicial() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaInicial");
			}

			if (entity.getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaModificacion");
			}

			if (entity.getFechaVencimiento() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaVencimiento");
			}

			if (entity.getIdLipe() == null) {
				throw new ZMessManager().new EmptyFieldException("idLipe");
			}

			if ((entity.getIdLipe() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdLipe(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idLipe");
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

			if (entity.getPrecio() == null) {
				throw new ZMessManager().new EmptyFieldException("precio");
			}

			if ((entity.getPrecio() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPrecio(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("precio");
			}

			if ((entity.getTipoGrabado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getTipoGrabado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"tipoGrabado");
			}

			if (entity.getEmpresa().getIdEmpr() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idEmpr_Empresa");
			}

			if ((entity.getEmpresa().getIdEmpr() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getEmpresa().getIdEmpr(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idEmpr_Empresa");
			}

			if (entity.getPersona().getIdPers() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idPers_Persona");
			}

			if ((entity.getPersona().getIdPers() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPersona().getIdPers(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idPers_Persona");
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

			if (getListaPreciosEspeciales(entity.getIdLipe()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			listaPreciosEspecialesDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteListaPreciosEspeciales(ListaPreciosEspeciales entity)
			throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion(
					"ListaPreciosEspeciales");
		}

		if (entity.getIdLipe() == null) {
			throw new ZMessManager().new EmptyFieldException("idLipe");
		}

		try {
			listaPreciosEspecialesDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateListaPreciosEspeciales(ListaPreciosEspeciales entity)
			throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"ListaPreciosEspeciales");
			}

			if (entity.getEmpresa() == null) {
				throw new ZMessManager().new ForeignException("empresa");
			}

			if (entity.getPersona() == null) {
				throw new ZMessManager().new ForeignException("persona");
			}

			if (entity.getReferencia() == null) {
				throw new ZMessManager().new ForeignException("referencia");
			}

			if (entity.getSucursalByIdSucu() == null) {
				throw new ZMessManager().new ForeignException(
						"sucursalByIdSucu");
			}

			if (entity.getSucursalBySucursal() == null) {
				throw new ZMessManager().new ForeignException(
						"sucursalBySucursal");
			}

			if ((entity.getConcepto() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getConcepto(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException("concepto");
			}

			if ((entity.getEspacios() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEspacios(), 120) == false)) {
				throw new ZMessManager().new NotValidFormatException("espacios");
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

			if (entity.getFechaInicial() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaInicial");
			}

			if (entity.getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaModificacion");
			}

			if (entity.getFechaVencimiento() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaVencimiento");
			}

			if (entity.getIdLipe() == null) {
				throw new ZMessManager().new EmptyFieldException("idLipe");
			}

			if ((entity.getIdLipe() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdLipe(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idLipe");
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

			if (entity.getPrecio() == null) {
				throw new ZMessManager().new EmptyFieldException("precio");
			}

			if ((entity.getPrecio() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPrecio(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("precio");
			}

			if ((entity.getTipoGrabado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getTipoGrabado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"tipoGrabado");
			}

			if (entity.getEmpresa().getIdEmpr() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idEmpr_Empresa");
			}

			if ((entity.getEmpresa().getIdEmpr() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getEmpresa().getIdEmpr(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idEmpr_Empresa");
			}

			if (entity.getPersona().getIdPers() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idPers_Persona");
			}

			if ((entity.getPersona().getIdPers() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPersona().getIdPers(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idPers_Persona");
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

			listaPreciosEspecialesDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<ListaPreciosEspecialesDTO> getDataListaPreciosEspeciales()
			throws Exception {
		try {
			List<ListaPreciosEspeciales> listaPreciosEspeciales = listaPreciosEspecialesDAO
					.findAll();

			List<ListaPreciosEspecialesDTO> listaPreciosEspecialesDTO = new ArrayList<ListaPreciosEspecialesDTO>();

			for (ListaPreciosEspeciales listaPreciosEspecialesTmp : listaPreciosEspeciales) {
				ListaPreciosEspecialesDTO listaPreciosEspecialesDTO2 = new ListaPreciosEspecialesDTO();

				listaPreciosEspecialesDTO2.setIdLipe(listaPreciosEspecialesTmp
						.getIdLipe());
				listaPreciosEspecialesDTO2
						.setConcepto((listaPreciosEspecialesTmp.getConcepto() != null) ? listaPreciosEspecialesTmp
								.getConcepto() : null);
				listaPreciosEspecialesDTO2
						.setEspacios((listaPreciosEspecialesTmp.getEspacios() != null) ? listaPreciosEspecialesTmp
								.getEspacios() : null);
				listaPreciosEspecialesDTO2
						.setEstadoRegistro((listaPreciosEspecialesTmp
								.getEstadoRegistro() != null) ? listaPreciosEspecialesTmp
								.getEstadoRegistro() : null);
				listaPreciosEspecialesDTO2
						.setFechaCreacion(listaPreciosEspecialesTmp
								.getFechaCreacion());
				listaPreciosEspecialesDTO2
						.setFechaInicial(listaPreciosEspecialesTmp
								.getFechaInicial());
				listaPreciosEspecialesDTO2
						.setFechaModificacion(listaPreciosEspecialesTmp
								.getFechaModificacion());
				listaPreciosEspecialesDTO2
						.setFechaVencimiento(listaPreciosEspecialesTmp
								.getFechaVencimiento());
				listaPreciosEspecialesDTO2
						.setOperCreador((listaPreciosEspecialesTmp
								.getOperCreador() != null) ? listaPreciosEspecialesTmp
								.getOperCreador() : null);
				listaPreciosEspecialesDTO2
						.setOperModifica((listaPreciosEspecialesTmp
								.getOperModifica() != null) ? listaPreciosEspecialesTmp
								.getOperModifica() : null);
				listaPreciosEspecialesDTO2.setPrecio((listaPreciosEspecialesTmp
						.getPrecio() != null) ? listaPreciosEspecialesTmp
						.getPrecio() : null);
				listaPreciosEspecialesDTO2
						.setTipoGrabado((listaPreciosEspecialesTmp
								.getTipoGrabado() != null) ? listaPreciosEspecialesTmp
								.getTipoGrabado() : null);

				if (listaPreciosEspecialesTmp.getEmpresa() != null) {
					listaPreciosEspecialesDTO2
							.setIdEmpr_Empresa(listaPreciosEspecialesTmp
									.getEmpresa().getIdEmpr());
				} else {
					listaPreciosEspecialesDTO2.setIdEmpr_Empresa(null);
				}

				if (listaPreciosEspecialesTmp.getPersona() != null) {
					listaPreciosEspecialesDTO2
							.setIdPers_Persona(listaPreciosEspecialesTmp
									.getPersona().getIdPers());
				} else {
					listaPreciosEspecialesDTO2.setIdPers_Persona(null);
				}

				listaPreciosEspecialesDTO2
						.setIdRefe_Referencia((listaPreciosEspecialesTmp
								.getReferencia().getIdRefe() != null) ? listaPreciosEspecialesTmp
								.getReferencia().getIdRefe() : null);

				listaPreciosEspecialesDTO.add(listaPreciosEspecialesDTO2);
			}

			return listaPreciosEspecialesDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public ListaPreciosEspeciales getListaPreciosEspeciales(Long idLipe)
			throws Exception {
		ListaPreciosEspeciales entity = null;

		try {
			entity = listaPreciosEspecialesDAO.findById(idLipe);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"ListaPreciosEspeciales");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<ListaPreciosEspeciales> findPageListaPreciosEspeciales(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<ListaPreciosEspeciales> entity = null;

		try {
			entity = listaPreciosEspecialesDAO.findPage(sortColumnName,
					sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"ListaPreciosEspeciales Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberListaPreciosEspeciales() throws Exception {
		Long entity = null;

		try {
			entity = listaPreciosEspecialesDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"ListaPreciosEspeciales Count");
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
	public List<ListaPreciosEspeciales> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<ListaPreciosEspeciales> list = new ArrayList<ListaPreciosEspeciales>();
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
			list = listaPreciosEspecialesDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
