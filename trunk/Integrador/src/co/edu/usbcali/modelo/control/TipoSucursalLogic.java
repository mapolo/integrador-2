package co.edu.usbcali.modelo.control;

import co.edu.usbcali.dataaccess.dao.*;
import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.exceptions.ZMessManager.NotValidFormatException;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.TipoSucursalDTO;
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
@Service("TipoSucursalLogic")
public class TipoSucursalLogic implements ITipoSucursalLogic {
	/**
	 * DAO injected by Spring that manages TipoSucursal entities
	 * 
	 */
	@Autowired
	private ITipoSucursalDAO tipoSucursalDAO;

	/**
	 * DAO injected by Spring that manages Sucursal entities
	 * 
	 */
	@Autowired
	private ISucursalDAO sucursalDAO;

	/**
	 * DAO injected by Spring that manages TipoLista entities
	 * 
	 */
	@Autowired
	private ITipoListaDAO tipoListaDAO;

	@Transactional(readOnly = true)
	public List<TipoSucursal> getTipoSucursal() throws Exception {
		List<TipoSucursal> list = new ArrayList<TipoSucursal>();

		try {
			list = tipoSucursalDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "TipoSucursal");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveTipoSucursal(TipoSucursal entity) throws Exception {
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
							entity.getCodigo(), 2) == false)) {
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

			

			tipoSucursalDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteTipoSucursal(TipoSucursal entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("TipoSucursal");
		}

		if (entity.getIdTisu() == null) {
			throw new ZMessManager().new EmptyFieldException("idTisu");
		}

		List<Sucursal> sucursals = null;
		List<TipoLista> tipoListas = null;

		try {
			sucursals = sucursalDAO.findByProperty("tipoSucursal.idTisu",
					entity.getIdTisu());

			if (Utilities.validationsList(sucursals) == true) {
				throw new ZMessManager().new DeletingException("sucursals");
			}

			tipoListas = tipoListaDAO.findByProperty("tipoSucursal.idTisu",
					entity.getIdTisu());

			if (Utilities.validationsList(tipoListas) == true) {
				throw new ZMessManager().new DeletingException("tipoListas");
			}

			tipoSucursalDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateTipoSucursal(TipoSucursal entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("TipoSucursal");
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
							entity.getCodigo(), 2) == false)) {
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

			if (entity.getIdTisu() == null) {
				throw new ZMessManager().new EmptyFieldException("idTisu");
			}

			if ((entity.getIdTisu() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdTisu(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idTisu");
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

			tipoSucursalDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<TipoSucursalDTO> getDataTipoSucursal() throws Exception {
		try {
			List<TipoSucursal> tipoSucursal = tipoSucursalDAO.findAll();

			List<TipoSucursalDTO> tipoSucursalDTO = new ArrayList<TipoSucursalDTO>();

			for (TipoSucursal tipoSucursalTmp : tipoSucursal) {
				TipoSucursalDTO tipoSucursalDTO2 = new TipoSucursalDTO();

				tipoSucursalDTO2.setIdTisu(tipoSucursalTmp.getIdTisu());
				tipoSucursalDTO2
						.setCodigo((tipoSucursalTmp.getCodigo() != null) ? tipoSucursalTmp
								.getCodigo() : null);
				tipoSucursalDTO2.setDescripcion((tipoSucursalTmp
						.getDescripcion() != null) ? tipoSucursalTmp
						.getDescripcion() : null);
				tipoSucursalDTO2.setEstadoRegistro((tipoSucursalTmp
						.getEstadoRegistro() != null) ? tipoSucursalTmp
						.getEstadoRegistro() : null);
				tipoSucursalDTO2.setFechaCreacion(tipoSucursalTmp
						.getFechaCreacion());
				tipoSucursalDTO2.setFechaModificacion(tipoSucursalTmp
						.getFechaModificacion());
				tipoSucursalDTO2.setOperCreador((tipoSucursalTmp
						.getOperCreador() != null) ? tipoSucursalTmp
						.getOperCreador() : null);
				tipoSucursalDTO2.setOperModifica((tipoSucursalTmp
						.getOperModifica() != null) ? tipoSucursalTmp
						.getOperModifica() : null);
				tipoSucursalDTO.add(tipoSucursalDTO2);
			}

			return tipoSucursalDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public TipoSucursal getTipoSucursal(Long idTisu) throws Exception {
		TipoSucursal entity = null;

		try {
			entity = tipoSucursalDAO.findById(idTisu);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TipoSucursal");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<TipoSucursal> findPageTipoSucursal(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<TipoSucursal> entity = null;

		try {
			entity = tipoSucursalDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TipoSucursal Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberTipoSucursal() throws Exception {
		Long entity = null;

		try {
			entity = tipoSucursalDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TipoSucursal Count");
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
	public List<TipoSucursal> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<TipoSucursal> list = new ArrayList<TipoSucursal>();
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
			list = tipoSucursalDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
