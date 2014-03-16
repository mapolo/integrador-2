package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.IEmpresaDAO;
import co.edu.usbcali.dataaccess.dao.IPersonaDAO;
import co.edu.usbcali.dataaccess.dao.ITipoIdentificacionDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.Empresa;
import co.edu.usbcali.modelo.Persona;
import co.edu.usbcali.modelo.TipoIdentificacion;
import co.edu.usbcali.modelo.dto.TipoIdentificacionDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("TipoIdentificacionLogic")
public class TipoIdentificacionLogic implements ITipoIdentificacionLogic {
	/**
	 * DAO injected by Spring that manages TipoIdentificacion entities
	 * 
	 */
	@Autowired
	private ITipoIdentificacionDAO tipoIdentificacionDAO;

	/**
	 * DAO injected by Spring that manages Empresa entities
	 * 
	 */
	@Autowired
	private IEmpresaDAO empresaDAO;

	/**
	 * DAO injected by Spring that manages Persona entities
	 * 
	 */
	@Autowired
	private IPersonaDAO personaDAO;

	@Transactional(readOnly = true)
	public List<TipoIdentificacion> getTipoIdentificacion() throws Exception {
		List<TipoIdentificacion> list = new ArrayList<TipoIdentificacion>();

		try {
			list = tipoIdentificacionDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "TipoIdentificacion");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveTipoIdentificacion(TipoIdentificacion entity)
			throws Exception {
		try {

			// Validacion de Estado registro
			if (entity.getEstadoRegistro().equals("A")
					|| entity.getEstadoRegistro().equals("R")) {

			} else {
				throw new ZMessManager().new NotValidFormatException(
						"Estado registro solo recibe A o R");
			}

			if (entity.getCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("codigo");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCodigo(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getDescripcion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getDescripcion(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"descripcion");
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

			

			tipoIdentificacionDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteTipoIdentificacion(TipoIdentificacion entity)
			throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion(
					"TipoIdentificacion");
		}

		if (entity.getIdTiid() == null) {
			throw new ZMessManager().new EmptyFieldException("idTiid");
		}

		List<Empresa> empresas = null;
		List<Persona> personas = null;

		try {
			empresas = empresaDAO.findByProperty("tipoIdentificacion.idTiid",
					entity.getIdTiid());

			if (Utilities.validationsList(empresas) == true) {
				throw new ZMessManager().new DeletingException("empresas");
			}

			personas = personaDAO.findByProperty("tipoIdentificacion.idTiid",
					entity.getIdTiid());

			if (Utilities.validationsList(personas) == true) {
				throw new ZMessManager().new DeletingException("personas");
			}

			tipoIdentificacionDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateTipoIdentificacion(TipoIdentificacion entity)
			throws Exception {
		try {

			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"TipoIdentificacion");
			}

			// Validacion de Estado registro
			if (entity.getEstadoRegistro().equals("A")
					|| entity.getEstadoRegistro().equals("R")) {

			} else {
				throw new ZMessManager().new NotValidFormatException(
						"Estado registro solo recibe A o R");
			}

			if (entity.getCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("codigo");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCodigo(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getDescripcion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getDescripcion(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"descripcion");
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

			if (entity.getIdTiid() == null) {
				throw new ZMessManager().new EmptyFieldException("idTiid");
			}

			if ((entity.getIdTiid() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdTiid(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idTiid");
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

			tipoIdentificacionDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<TipoIdentificacionDTO> getDataTipoIdentificacion()
			throws Exception {
		try {
			List<TipoIdentificacion> tipoIdentificacion = tipoIdentificacionDAO
					.findAll();

			List<TipoIdentificacionDTO> tipoIdentificacionDTO = new ArrayList<TipoIdentificacionDTO>();

			for (TipoIdentificacion tipoIdentificacionTmp : tipoIdentificacion) {
				TipoIdentificacionDTO tipoIdentificacionDTO2 = new TipoIdentificacionDTO();

				tipoIdentificacionDTO2.setIdTiid(tipoIdentificacionTmp
						.getIdTiid());
				tipoIdentificacionDTO2.setCodigo((tipoIdentificacionTmp
						.getCodigo() != null) ? tipoIdentificacionTmp
						.getCodigo() : null);
				tipoIdentificacionDTO2.setDescripcion((tipoIdentificacionTmp
						.getDescripcion() != null) ? tipoIdentificacionTmp
						.getDescripcion() : null);
				tipoIdentificacionDTO2.setEstadoRegistro((tipoIdentificacionTmp
						.getEstadoRegistro() != null) ? tipoIdentificacionTmp
						.getEstadoRegistro() : null);
				tipoIdentificacionDTO2.setFechaCreacion(tipoIdentificacionTmp
						.getFechaCreacion());
				tipoIdentificacionDTO2
						.setFechaModificacion(tipoIdentificacionTmp
								.getFechaModificacion());
				tipoIdentificacionDTO2.setOperCreador((tipoIdentificacionTmp
						.getOperCreador() != null) ? tipoIdentificacionTmp
						.getOperCreador() : null);
				tipoIdentificacionDTO2.setOperModifica((tipoIdentificacionTmp
						.getOperModifica() != null) ? tipoIdentificacionTmp
						.getOperModifica() : null);
				tipoIdentificacionDTO.add(tipoIdentificacionDTO2);
			}

			return tipoIdentificacionDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public TipoIdentificacion getTipoIdentificacion(Long idTiid)
			throws Exception {
		TipoIdentificacion entity = null;

		try {
			entity = tipoIdentificacionDAO.findById(idTiid);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TipoIdentificacion");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<TipoIdentificacion> findPageTipoIdentificacion(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<TipoIdentificacion> entity = null;

		try {
			entity = tipoIdentificacionDAO.findPage(sortColumnName,
					sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"TipoIdentificacion Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberTipoIdentificacion() throws Exception {
		Long entity = null;

		try {
			entity = tipoIdentificacionDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"TipoIdentificacion Count");
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
	public List<TipoIdentificacion> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<TipoIdentificacion> list = new ArrayList<TipoIdentificacion>();
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
			list = tipoIdentificacionDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
