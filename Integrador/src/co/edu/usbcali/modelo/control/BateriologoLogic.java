package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.IBateriologoDAO;
import co.edu.usbcali.dataaccess.dao.IGarantiaDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.Bateriologo;
import co.edu.usbcali.modelo.Garantia;
import co.edu.usbcali.modelo.dto.BateriologoDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("BateriologoLogic")
public class BateriologoLogic implements IBateriologoLogic {
	/**
	 * DAO injected by Spring that manages Bateriologo entities
	 * 
	 */
	@Autowired
	private IBateriologoDAO bateriologoDAO;

	/**
	 * DAO injected by Spring that manages Garantia entities
	 * 
	 */
	@Autowired
	private IGarantiaDAO garantiaDAO;

	/**
	 * Logic injected by Spring that manages Sucursal entities
	 * 
	 */
	@Autowired
	ISucursalLogic logicSucursal1;

	@Transactional(readOnly = true)
	public List<Bateriologo> getBateriologo() throws Exception {
		List<Bateriologo> list = new ArrayList<Bateriologo>();

		try {
			list = bateriologoDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "Bateriologo");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveBateriologo(Bateriologo entity) throws Exception {
		try {
			if (entity.getSucursal() == null) {
				throw new ZMessManager().new ForeignException("sucursal");
			}

			if (entity.getCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("codigo");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCodigo(), 5) == false)) {
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

			if (entity.getIdBate() == null) {
				throw new ZMessManager().new EmptyFieldException("idBate");
			}

			if ((entity.getIdBate() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdBate(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idBate");
			}

			if ((entity.getNombreCompleto() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNombreCompleto(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"nombreCompleto");
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

			if (entity.getSucursal().getIdSucu() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idSucu_Sucursal");
			}

			if ((entity.getSucursal().getIdSucu() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getSucursal().getIdSucu(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idSucu_Sucursal");
			}

			if (getBateriologo(entity.getIdBate()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			bateriologoDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteBateriologo(Bateriologo entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Bateriologo");
		}

		if (entity.getIdBate() == null) {
			throw new ZMessManager().new EmptyFieldException("idBate");
		}

		List<Garantia> garantias = null;

		try {
			garantias = garantiaDAO.findByProperty("bateriologo.idBate",
					entity.getIdBate());

			if (Utilities.validationsList(garantias) == true) {
				throw new ZMessManager().new DeletingException("garantias");
			}

			bateriologoDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateBateriologo(Bateriologo entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Bateriologo");
			}

			if (entity.getSucursal() == null) {
				throw new ZMessManager().new ForeignException("sucursal");
			}

			if (entity.getCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("codigo");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCodigo(), 5) == false)) {
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

			if (entity.getIdBate() == null) {
				throw new ZMessManager().new EmptyFieldException("idBate");
			}

			if ((entity.getIdBate() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdBate(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idBate");
			}

			if ((entity.getNombreCompleto() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNombreCompleto(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"nombreCompleto");
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

			if (entity.getSucursal().getIdSucu() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idSucu_Sucursal");
			}

			if ((entity.getSucursal().getIdSucu() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getSucursal().getIdSucu(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idSucu_Sucursal");
			}

			bateriologoDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<BateriologoDTO> getDataBateriologo() throws Exception {
		try {
			List<Bateriologo> bateriologo = bateriologoDAO.findAll();

			List<BateriologoDTO> bateriologoDTO = new ArrayList<BateriologoDTO>();

			for (Bateriologo bateriologoTmp : bateriologo) {
				BateriologoDTO bateriologoDTO2 = new BateriologoDTO();

				bateriologoDTO2.setIdBate(bateriologoTmp.getIdBate());
				bateriologoDTO2
						.setCodigo((bateriologoTmp.getCodigo() != null) ? bateriologoTmp
								.getCodigo() : null);
				bateriologoDTO2.setEstadoRegistro((bateriologoTmp
						.getEstadoRegistro() != null) ? bateriologoTmp
						.getEstadoRegistro() : null);
				bateriologoDTO2.setFechaCreacion(bateriologoTmp
						.getFechaCreacion());
				bateriologoDTO2.setFechaModificacion(bateriologoTmp
						.getFechaModificacion());
				bateriologoDTO2.setNombreCompleto((bateriologoTmp
						.getNombreCompleto() != null) ? bateriologoTmp
						.getNombreCompleto() : null);
				bateriologoDTO2
						.setOperCreador((bateriologoTmp.getOperCreador() != null) ? bateriologoTmp
								.getOperCreador() : null);
				bateriologoDTO2.setOperModifica((bateriologoTmp
						.getOperModifica() != null) ? bateriologoTmp
						.getOperModifica() : null);
				bateriologoDTO2.setIdSucu_Sucursal((bateriologoTmp
						.getSucursal().getIdSucu() != null) ? bateriologoTmp
						.getSucursal().getIdSucu() : null);
				bateriologoDTO.add(bateriologoDTO2);
			}

			return bateriologoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Bateriologo getBateriologo(Long idBate) throws Exception {
		Bateriologo entity = null;

		try {
			entity = bateriologoDAO.findById(idBate);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Bateriologo");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Bateriologo> findPageBateriologo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Bateriologo> entity = null;

		try {
			entity = bateriologoDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Bateriologo Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberBateriologo() throws Exception {
		Long entity = null;

		try {
			entity = bateriologoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Bateriologo Count");
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
	public List<Bateriologo> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Bateriologo> list = new ArrayList<Bateriologo>();
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
			list = bateriologoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
