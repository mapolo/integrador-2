package co.edu.usbcali.modelo.control;

import co.edu.usbcali.dataaccess.dao.*;
import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.ChequePosfechadoDTO;
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
@Service("ChequePosfechadoLogic")
public class ChequePosfechadoLogic implements IChequePosfechadoLogic {
	/**
	 * DAO injected by Spring that manages ChequePosfechado entities
	 * 
	 */
	@Autowired
	private IChequePosfechadoDAO chequePosfechadoDAO;

	/**
	 * DAO injected by Spring that manages RboDetalleFormasPago entities
	 * 
	 */
	@Autowired
	private IRboDetalleFormasPagoDAO rboDetalleFormasPagoDAO;

	@Transactional(readOnly = true)
	public List<ChequePosfechado> getChequePosfechado() throws Exception {
		List<ChequePosfechado> list = new ArrayList<ChequePosfechado>();

		try {
			list = chequePosfechadoDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "ChequePosfechado");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveChequePosfechado(ChequePosfechado entity) throws Exception {
		try {
			if ((entity.getBancoCambiado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getBancoCambiado(), 2) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"bancoCambiado");
			}

			if (entity.getEstado() == null) {
				throw new ZMessManager().new EmptyFieldException("estado");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getEstado(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
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

			if (entity.getIdChps() == null) {
				throw new ZMessManager().new EmptyFieldException("idChps");
			}

			if ((entity.getIdChps() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdChps(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idChps");
			}

			if ((entity.getInaplicado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getInaplicado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"inaplicado");
			}

			if ((entity.getNumChqCambiado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNumChqCambiado(), 12) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numChqCambiado");
			}

			if (entity.getNumeroCheque() == null) {
				throw new ZMessManager().new EmptyFieldException("numeroCheque");
			}

			if ((entity.getNumeroCheque() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNumeroCheque(), 12) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroCheque");
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

			if ((entity.getOtroValor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getOtroValor(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"otroValor");
			}

			if ((entity.getRecaudador() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getRecaudador(), 2) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"recaudador");
			}

			if ((entity.getTelefono() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getTelefono(), 18) == false)) {
				throw new ZMessManager().new NotValidFormatException("telefono");
			}

			if (entity.getValor() == null) {
				throw new ZMessManager().new EmptyFieldException("valor");
			}

			if ((entity.getValor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getValor(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("valor");
			}

			if (getChequePosfechado(entity.getIdChps()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			chequePosfechadoDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteChequePosfechado(ChequePosfechado entity)
			throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("ChequePosfechado");
		}

		if (entity.getIdChps() == null) {
			throw new ZMessManager().new EmptyFieldException("idChps");
		}

		List<RboDetalleFormasPago> rboDetalleFormasPagos = null;

		try {
			rboDetalleFormasPagos = rboDetalleFormasPagoDAO.findByProperty(
					"chequePosfechado.idChps", entity.getIdChps());

			if (Utilities.validationsList(rboDetalleFormasPagos) == true) {
				throw new ZMessManager().new DeletingException(
						"rboDetalleFormasPagos");
			}

			chequePosfechadoDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateChequePosfechado(ChequePosfechado entity)
			throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"ChequePosfechado");
			}

			if ((entity.getBancoCambiado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getBancoCambiado(), 2) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"bancoCambiado");
			}

			if (entity.getEstado() == null) {
				throw new ZMessManager().new EmptyFieldException("estado");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getEstado(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
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

			if (entity.getIdChps() == null) {
				throw new ZMessManager().new EmptyFieldException("idChps");
			}

			if ((entity.getIdChps() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdChps(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idChps");
			}

			if ((entity.getInaplicado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getInaplicado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"inaplicado");
			}

			if ((entity.getNumChqCambiado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNumChqCambiado(), 12) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numChqCambiado");
			}

			if (entity.getNumeroCheque() == null) {
				throw new ZMessManager().new EmptyFieldException("numeroCheque");
			}

			if ((entity.getNumeroCheque() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNumeroCheque(), 12) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroCheque");
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

			if ((entity.getOtroValor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getOtroValor(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"otroValor");
			}

			if ((entity.getRecaudador() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getRecaudador(), 2) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"recaudador");
			}

			if ((entity.getTelefono() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getTelefono(), 18) == false)) {
				throw new ZMessManager().new NotValidFormatException("telefono");
			}

			if (entity.getValor() == null) {
				throw new ZMessManager().new EmptyFieldException("valor");
			}

			if ((entity.getValor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getValor(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("valor");
			}

			chequePosfechadoDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<ChequePosfechadoDTO> getDataChequePosfechado() throws Exception {
		try {
			List<ChequePosfechado> chequePosfechado = chequePosfechadoDAO
					.findAll();

			List<ChequePosfechadoDTO> chequePosfechadoDTO = new ArrayList<ChequePosfechadoDTO>();

			for (ChequePosfechado chequePosfechadoTmp : chequePosfechado) {
				ChequePosfechadoDTO chequePosfechadoDTO2 = new ChequePosfechadoDTO();

				chequePosfechadoDTO2.setIdChps(chequePosfechadoTmp.getIdChps());
				chequePosfechadoDTO2.setBancoCambiado((chequePosfechadoTmp
						.getBancoCambiado() != null) ? chequePosfechadoTmp
						.getBancoCambiado() : null);
				chequePosfechadoDTO2
						.setEstado((chequePosfechadoTmp.getEstado() != null) ? chequePosfechadoTmp
								.getEstado() : null);
				chequePosfechadoDTO2.setEstadoRegistro((chequePosfechadoTmp
						.getEstadoRegistro() != null) ? chequePosfechadoTmp
						.getEstadoRegistro() : null);
				chequePosfechadoDTO2.setFechaActualizacion(chequePosfechadoTmp
						.getFechaActualizacion());
				chequePosfechadoDTO2.setFechaAplazada(chequePosfechadoTmp
						.getFechaAplazada());
				chequePosfechadoDTO2.setFechaConsignacion(chequePosfechadoTmp
						.getFechaConsignacion());
				chequePosfechadoDTO2.setFechaCreacion(chequePosfechadoTmp
						.getFechaCreacion());
				chequePosfechadoDTO2.setFechaModificacion(chequePosfechadoTmp
						.getFechaModificacion());
				chequePosfechadoDTO2.setInaplicado((chequePosfechadoTmp
						.getInaplicado() != null) ? chequePosfechadoTmp
						.getInaplicado() : null);
				chequePosfechadoDTO2.setNumChqCambiado((chequePosfechadoTmp
						.getNumChqCambiado() != null) ? chequePosfechadoTmp
						.getNumChqCambiado() : null);
				chequePosfechadoDTO2.setNumeroCheque((chequePosfechadoTmp
						.getNumeroCheque() != null) ? chequePosfechadoTmp
						.getNumeroCheque() : null);
				chequePosfechadoDTO2.setOperCreador((chequePosfechadoTmp
						.getOperCreador() != null) ? chequePosfechadoTmp
						.getOperCreador() : null);
				chequePosfechadoDTO2.setOperModifica((chequePosfechadoTmp
						.getOperModifica() != null) ? chequePosfechadoTmp
						.getOperModifica() : null);
				chequePosfechadoDTO2.setOtroValor((chequePosfechadoTmp
						.getOtroValor() != null) ? chequePosfechadoTmp
						.getOtroValor() : null);
				chequePosfechadoDTO2.setRecaudador((chequePosfechadoTmp
						.getRecaudador() != null) ? chequePosfechadoTmp
						.getRecaudador() : null);
				chequePosfechadoDTO2.setTelefono((chequePosfechadoTmp
						.getTelefono() != null) ? chequePosfechadoTmp
						.getTelefono() : null);
				chequePosfechadoDTO2
						.setValor((chequePosfechadoTmp.getValor() != null) ? chequePosfechadoTmp
								.getValor() : null);
				chequePosfechadoDTO.add(chequePosfechadoDTO2);
			}

			return chequePosfechadoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public ChequePosfechado getChequePosfechado(Long idChps) throws Exception {
		ChequePosfechado entity = null;

		try {
			entity = chequePosfechadoDAO.findById(idChps);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ChequePosfechado");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<ChequePosfechado> findPageChequePosfechado(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<ChequePosfechado> entity = null;

		try {
			entity = chequePosfechadoDAO.findPage(sortColumnName,
					sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"ChequePosfechado Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberChequePosfechado() throws Exception {
		Long entity = null;

		try {
			entity = chequePosfechadoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"ChequePosfechado Count");
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
	public List<ChequePosfechado> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<ChequePosfechado> list = new ArrayList<ChequePosfechado>();
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
			list = chequePosfechadoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
