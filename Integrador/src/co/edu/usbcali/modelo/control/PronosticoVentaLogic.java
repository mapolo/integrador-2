package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.IPronosticoVentaDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.PronosticoVenta;
import co.edu.usbcali.modelo.dto.PronosticoVentaDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("PronosticoVentaLogic")
public class PronosticoVentaLogic implements IPronosticoVentaLogic {
	/**
	 * DAO injected by Spring that manages PronosticoVenta entities
	 * 
	 */
	@Autowired
	private IPronosticoVentaDAO pronosticoVentaDAO;

	/**
	 * Logic injected by Spring that manages Referencia entities
	 * 
	 */
	@Autowired
	IReferenciaLogic logicReferencia1;

	/**
	 * Logic injected by Spring that manages Sucursal entities
	 * 
	 */
	@Autowired
	ISucursalLogic logicSucursal2;

	/**
	 * Logic injected by Spring that manages UnidadVenta entities
	 * 
	 */
	@Autowired
	IUnidadVentaLogic logicUnidadVenta3;

	@Transactional(readOnly = true)
	public List<PronosticoVenta> getPronosticoVenta() throws Exception {
		List<PronosticoVenta> list = new ArrayList<PronosticoVenta>();

		try {
			list = pronosticoVentaDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "PronosticoVenta");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void savePronosticoVenta(PronosticoVenta entity) throws Exception {
		try {
			if (entity.getReferencia() == null) {
				throw new ZMessManager().new ForeignException("referencia");
			}

			if (entity.getSucursal() == null) {
				throw new ZMessManager().new ForeignException("sucursal");
			}

			if (entity.getUnidadVenta() == null) {
				throw new ZMessManager().new ForeignException("unidadVenta");
			}

			if ((entity.getAno() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getAno(), 5, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ano");
			}

			if ((entity.getCantidadAPedir() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadAPedir(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadAPedir");
			}

			if ((entity.getCantidadAntAPedir() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadAntAPedir(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadAntAPedir");
			}

			if ((entity.getCantidadPromedio() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadPromedio(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadPromedio");
			}

			if ((entity.getEstadoAutorizacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEstadoAutorizacion(), 2) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"estadoAutorizacion");
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

			if (entity.getIdPtcv() == null) {
				throw new ZMessManager().new EmptyFieldException("idPtcv");
			}

			if ((entity.getIdPtcv() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdPtcv(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idPtcv");
			}

			if ((entity.getMes() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMes(), 2, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("mes");
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

			if (entity.getUnidadVenta().getIdUnve() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idUnve_UnidadVenta");
			}

			if ((entity.getUnidadVenta().getIdUnve() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getUnidadVenta().getIdUnve(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idUnve_UnidadVenta");
			}

			if (getPronosticoVenta(entity.getIdPtcv()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			pronosticoVentaDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deletePronosticoVenta(PronosticoVenta entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("PronosticoVenta");
		}

		if (entity.getIdPtcv() == null) {
			throw new ZMessManager().new EmptyFieldException("idPtcv");
		}

		try {
			pronosticoVentaDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updatePronosticoVenta(PronosticoVenta entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"PronosticoVenta");
			}

			if (entity.getReferencia() == null) {
				throw new ZMessManager().new ForeignException("referencia");
			}

			if (entity.getSucursal() == null) {
				throw new ZMessManager().new ForeignException("sucursal");
			}

			if (entity.getUnidadVenta() == null) {
				throw new ZMessManager().new ForeignException("unidadVenta");
			}

			if ((entity.getAno() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getAno(), 5, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("ano");
			}

			if ((entity.getCantidadAPedir() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadAPedir(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadAPedir");
			}

			if ((entity.getCantidadAntAPedir() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadAntAPedir(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadAntAPedir");
			}

			if ((entity.getCantidadPromedio() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadPromedio(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadPromedio");
			}

			if ((entity.getEstadoAutorizacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEstadoAutorizacion(), 2) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"estadoAutorizacion");
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

			if (entity.getIdPtcv() == null) {
				throw new ZMessManager().new EmptyFieldException("idPtcv");
			}

			if ((entity.getIdPtcv() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdPtcv(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idPtcv");
			}

			if ((entity.getMes() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMes(), 2, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("mes");
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

			if (entity.getUnidadVenta().getIdUnve() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idUnve_UnidadVenta");
			}

			if ((entity.getUnidadVenta().getIdUnve() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getUnidadVenta().getIdUnve(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idUnve_UnidadVenta");
			}

			pronosticoVentaDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<PronosticoVentaDTO> getDataPronosticoVenta() throws Exception {
		try {
			List<PronosticoVenta> pronosticoVenta = pronosticoVentaDAO
					.findAll();

			List<PronosticoVentaDTO> pronosticoVentaDTO = new ArrayList<PronosticoVentaDTO>();

			for (PronosticoVenta pronosticoVentaTmp : pronosticoVenta) {
				PronosticoVentaDTO pronosticoVentaDTO2 = new PronosticoVentaDTO();

				pronosticoVentaDTO2.setIdPtcv(pronosticoVentaTmp.getIdPtcv());
				pronosticoVentaDTO2
						.setAno((pronosticoVentaTmp.getAno() != null) ? pronosticoVentaTmp
								.getAno() : null);
				pronosticoVentaDTO2.setCantidadAPedir((pronosticoVentaTmp
						.getCantidadAPedir() != null) ? pronosticoVentaTmp
						.getCantidadAPedir() : null);
				pronosticoVentaDTO2.setCantidadAntAPedir((pronosticoVentaTmp
						.getCantidadAntAPedir() != null) ? pronosticoVentaTmp
						.getCantidadAntAPedir() : null);
				pronosticoVentaDTO2.setCantidadPromedio((pronosticoVentaTmp
						.getCantidadPromedio() != null) ? pronosticoVentaTmp
						.getCantidadPromedio() : null);
				pronosticoVentaDTO2.setEstadoAutorizacion((pronosticoVentaTmp
						.getEstadoAutorizacion() != null) ? pronosticoVentaTmp
						.getEstadoAutorizacion() : null);
				pronosticoVentaDTO2.setEstadoRegistro((pronosticoVentaTmp
						.getEstadoRegistro() != null) ? pronosticoVentaTmp
						.getEstadoRegistro() : null);
				pronosticoVentaDTO2.setFechaCreacion(pronosticoVentaTmp
						.getFechaCreacion());
				pronosticoVentaDTO2.setFechaModificacion(pronosticoVentaTmp
						.getFechaModificacion());
				pronosticoVentaDTO2
						.setMes((pronosticoVentaTmp.getMes() != null) ? pronosticoVentaTmp
								.getMes() : null);
				pronosticoVentaDTO2.setOperCreador((pronosticoVentaTmp
						.getOperCreador() != null) ? pronosticoVentaTmp
						.getOperCreador() : null);
				pronosticoVentaDTO2.setOperModifica((pronosticoVentaTmp
						.getOperModifica() != null) ? pronosticoVentaTmp
						.getOperModifica() : null);
				pronosticoVentaDTO2
						.setIdRefe_Referencia((pronosticoVentaTmp
								.getReferencia().getIdRefe() != null) ? pronosticoVentaTmp
								.getReferencia().getIdRefe() : null);
				pronosticoVentaDTO2
						.setIdSucu_Sucursal((pronosticoVentaTmp.getSucursal()
								.getIdSucu() != null) ? pronosticoVentaTmp
								.getSucursal().getIdSucu() : null);
				pronosticoVentaDTO2
						.setIdUnve_UnidadVenta((pronosticoVentaTmp
								.getUnidadVenta().getIdUnve() != null) ? pronosticoVentaTmp
								.getUnidadVenta().getIdUnve() : null);
				pronosticoVentaDTO.add(pronosticoVentaDTO2);
			}

			return pronosticoVentaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public PronosticoVenta getPronosticoVenta(Long idPtcv) throws Exception {
		PronosticoVenta entity = null;

		try {
			entity = pronosticoVentaDAO.findById(idPtcv);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("PronosticoVenta");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<PronosticoVenta> findPagePronosticoVenta(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<PronosticoVenta> entity = null;

		try {
			entity = pronosticoVentaDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"PronosticoVenta Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberPronosticoVenta() throws Exception {
		Long entity = null;

		try {
			entity = pronosticoVentaDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"PronosticoVenta Count");
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
	public List<PronosticoVenta> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<PronosticoVenta> list = new ArrayList<PronosticoVenta>();
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
			list = pronosticoVentaDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
