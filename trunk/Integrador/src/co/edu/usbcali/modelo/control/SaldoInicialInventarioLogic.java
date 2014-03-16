package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.ISaldoInicialInventarioDAO;
import co.edu.usbcali.dataaccess.dao.IStockInventarioMensualDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.SaldoInicialInventario;
import co.edu.usbcali.modelo.StockInventarioMensual;
import co.edu.usbcali.modelo.dto.SaldoInicialInventarioDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("SaldoInicialInventarioLogic")
public class SaldoInicialInventarioLogic implements
		ISaldoInicialInventarioLogic {
	/**
	 * DAO injected by Spring that manages SaldoInicialInventario entities
	 * 
	 */
	@Autowired
	private ISaldoInicialInventarioDAO saldoInicialInventarioDAO;

	/**
	 * DAO injected by Spring that manages StockInventarioMensual entities
	 * 
	 */
	@Autowired
	private IStockInventarioMensualDAO stockInventarioMensualDAO;

	/**
	 * Logic injected by Spring that manages ReferenciaSucursal entities
	 * 
	 */
	@Autowired
	IReferenciaSucursalLogic logicReferenciaSucursal1;

	@Transactional(readOnly = true)
	public List<SaldoInicialInventario> getSaldoInicialInventario()
			throws Exception {
		List<SaldoInicialInventario> list = new ArrayList<SaldoInicialInventario>();

		try {
			list = saldoInicialInventarioDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "SaldoInicialInventario");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveSaldoInicialInventario(SaldoInicialInventario entity)
			throws Exception {
		try {
			if (entity.getReferenciaSucursal() == null) {
				throw new ZMessManager().new ForeignException(
						"referenciaSucursal");
			}

			if (entity.getAno() == null) {
				throw new ZMessManager().new EmptyFieldException("ano");
			}

			if ((entity.getAno() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getAno(), 5, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ano");
			}

			if (entity.getCostoInicial() == null) {
				throw new ZMessManager().new EmptyFieldException("costoInicial");
			}

			if ((entity.getCostoInicial() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCostoInicial(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"costoInicial");
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

			if (entity.getIdSini() == null) {
				throw new ZMessManager().new EmptyFieldException("idSini");
			}

			if ((entity.getIdSini() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdSini(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idSini");
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

			if (entity.getSaldoInicial() == null) {
				throw new ZMessManager().new EmptyFieldException("saldoInicial");
			}

			if ((entity.getSaldoInicial() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getSaldoInicial(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"saldoInicial");
			}

			if (entity.getReferenciaSucursal().getIdResu() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idResu_ReferenciaSucursal");
			}

			if ((entity.getReferenciaSucursal().getIdResu() != null)
					&& (Utilities
							.checkNumberAndCheckWithPrecisionAndScale(""
									+ entity.getReferenciaSucursal()
											.getIdResu(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idResu_ReferenciaSucursal");
			}

			if (getSaldoInicialInventario(entity.getIdSini()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			saldoInicialInventarioDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteSaldoInicialInventario(SaldoInicialInventario entity)
			throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion(
					"SaldoInicialInventario");
		}

		if (entity.getIdSini() == null) {
			throw new ZMessManager().new EmptyFieldException("idSini");
		}

		List<StockInventarioMensual> stockInventarioMensuals = null;

		try {
			stockInventarioMensuals = stockInventarioMensualDAO.findByProperty(
					"saldoInicialInventario.idSini", entity.getIdSini());

			if (Utilities.validationsList(stockInventarioMensuals) == true) {
				throw new ZMessManager().new DeletingException(
						"stockInventarioMensuals");
			}

			saldoInicialInventarioDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateSaldoInicialInventario(SaldoInicialInventario entity)
			throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"SaldoInicialInventario");
			}

			if (entity.getReferenciaSucursal() == null) {
				throw new ZMessManager().new ForeignException(
						"referenciaSucursal");
			}

			if (entity.getAno() == null) {
				throw new ZMessManager().new EmptyFieldException("ano");
			}

			if ((entity.getAno() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getAno(), 5, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ano");
			}

			if (entity.getCostoInicial() == null) {
				throw new ZMessManager().new EmptyFieldException("costoInicial");
			}

			if ((entity.getCostoInicial() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCostoInicial(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"costoInicial");
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

			if (entity.getIdSini() == null) {
				throw new ZMessManager().new EmptyFieldException("idSini");
			}

			if ((entity.getIdSini() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdSini(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idSini");
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

			if (entity.getSaldoInicial() == null) {
				throw new ZMessManager().new EmptyFieldException("saldoInicial");
			}

			if ((entity.getSaldoInicial() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getSaldoInicial(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"saldoInicial");
			}

			if (entity.getReferenciaSucursal().getIdResu() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idResu_ReferenciaSucursal");
			}

			if ((entity.getReferenciaSucursal().getIdResu() != null)
					&& (Utilities
							.checkNumberAndCheckWithPrecisionAndScale(""
									+ entity.getReferenciaSucursal()
											.getIdResu(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idResu_ReferenciaSucursal");
			}

			saldoInicialInventarioDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<SaldoInicialInventarioDTO> getDataSaldoInicialInventario()
			throws Exception {
		try {
			List<SaldoInicialInventario> saldoInicialInventario = saldoInicialInventarioDAO
					.findAll();

			List<SaldoInicialInventarioDTO> saldoInicialInventarioDTO = new ArrayList<SaldoInicialInventarioDTO>();

			for (SaldoInicialInventario saldoInicialInventarioTmp : saldoInicialInventario) {
				SaldoInicialInventarioDTO saldoInicialInventarioDTO2 = new SaldoInicialInventarioDTO();

				saldoInicialInventarioDTO2.setIdSini(saldoInicialInventarioTmp
						.getIdSini());
				saldoInicialInventarioDTO2.setAno((saldoInicialInventarioTmp
						.getAno() != null) ? saldoInicialInventarioTmp.getAno()
						: null);
				saldoInicialInventarioDTO2
						.setCostoInicial((saldoInicialInventarioTmp
								.getCostoInicial() != null) ? saldoInicialInventarioTmp
								.getCostoInicial() : null);
				saldoInicialInventarioDTO2
						.setEstadoRegistro((saldoInicialInventarioTmp
								.getEstadoRegistro() != null) ? saldoInicialInventarioTmp
								.getEstadoRegistro() : null);
				saldoInicialInventarioDTO2
						.setFechaCreacion(saldoInicialInventarioTmp
								.getFechaCreacion());
				saldoInicialInventarioDTO2
						.setFechaModificacion(saldoInicialInventarioTmp
								.getFechaModificacion());
				saldoInicialInventarioDTO2
						.setOperCreador((saldoInicialInventarioTmp
								.getOperCreador() != null) ? saldoInicialInventarioTmp
								.getOperCreador() : null);
				saldoInicialInventarioDTO2
						.setOperModifica((saldoInicialInventarioTmp
								.getOperModifica() != null) ? saldoInicialInventarioTmp
								.getOperModifica() : null);
				saldoInicialInventarioDTO2
						.setSaldoInicial((saldoInicialInventarioTmp
								.getSaldoInicial() != null) ? saldoInicialInventarioTmp
								.getSaldoInicial() : null);
				saldoInicialInventarioDTO2
						.setIdResu_ReferenciaSucursal((saldoInicialInventarioTmp
								.getReferenciaSucursal().getIdResu() != null) ? saldoInicialInventarioTmp
								.getReferenciaSucursal().getIdResu() : null);
				saldoInicialInventarioDTO.add(saldoInicialInventarioDTO2);
			}

			return saldoInicialInventarioDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public SaldoInicialInventario getSaldoInicialInventario(Long idSini)
			throws Exception {
		SaldoInicialInventario entity = null;

		try {
			entity = saldoInicialInventarioDAO.findById(idSini);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"SaldoInicialInventario");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<SaldoInicialInventario> findPageSaldoInicialInventario(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<SaldoInicialInventario> entity = null;

		try {
			entity = saldoInicialInventarioDAO.findPage(sortColumnName,
					sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"SaldoInicialInventario Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberSaldoInicialInventario() throws Exception {
		Long entity = null;

		try {
			entity = saldoInicialInventarioDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"SaldoInicialInventario Count");
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
	public List<SaldoInicialInventario> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<SaldoInicialInventario> list = new ArrayList<SaldoInicialInventario>();
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
			list = saldoInicialInventarioDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
