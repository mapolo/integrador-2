package co.edu.usbcali.modelo.control;

import co.edu.usbcali.dataaccess.dao.*;
import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.DistribucionCarteraDTO;
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
@Service("DistribucionCarteraLogic")
public class DistribucionCarteraLogic implements IDistribucionCarteraLogic {
	/**
	 * DAO injected by Spring that manages DistribucionCartera entities
	 * 
	 */
	@Autowired
	private IDistribucionCarteraDAO distribucionCarteraDAO;

	/**
	 * DAO injected by Spring that manages RboDetalleDocumentos entities
	 * 
	 */
	@Autowired
	private IRboDetalleDocumentosDAO rboDetalleDocumentosDAO;

	/**
	 * Logic injected by Spring that manages Cartera entities
	 * 
	 */
	@Autowired
	ICarteraLogic logicCartera1;

	@Transactional(readOnly = true)
	public List<DistribucionCartera> getDistribucionCartera() throws Exception {
		List<DistribucionCartera> list = new ArrayList<DistribucionCartera>();

		try {
			list = distribucionCarteraDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "DistribucionCartera");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDistribucionCartera(DistribucionCartera entity)
			throws Exception {
		try {
			if (entity.getCartera() == null) {
				throw new ZMessManager().new ForeignException("cartera");
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

			if (entity.getFechaVencimiento() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaVencimiento");
			}

			if (entity.getIdDica() == null) {
				throw new ZMessManager().new EmptyFieldException("idDica");
			}

			if ((entity.getIdDica() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdDica(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idDica");
			}

			if (entity.getNumeroCuota() == null) {
				throw new ZMessManager().new EmptyFieldException("numeroCuota");
			}

			if ((entity.getNumeroCuota() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroCuota(), 2, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroCuota");
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

			if (entity.getValor() == null) {
				throw new ZMessManager().new EmptyFieldException("valor");
			}

			if ((entity.getValor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getValor(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("valor");
			}

			if (entity.getCartera().getIdCart() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idCart_Cartera");
			}

			if ((entity.getCartera().getIdCart() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCartera().getIdCart(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idCart_Cartera");
			}

			if (getDistribucionCartera(entity.getIdDica()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			distribucionCarteraDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDistribucionCartera(DistribucionCartera entity)
			throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion(
					"DistribucionCartera");
		}

		if (entity.getIdDica() == null) {
			throw new ZMessManager().new EmptyFieldException("idDica");
		}

		List<RboDetalleDocumentos> rboDetalleDocumentoses = null;

		try {
			rboDetalleDocumentoses = rboDetalleDocumentosDAO.findByProperty(
					"distribucionCartera.idDica", entity.getIdDica());

			if (Utilities.validationsList(rboDetalleDocumentoses) == true) {
				throw new ZMessManager().new DeletingException(
						"rboDetalleDocumentoses");
			}

			distribucionCarteraDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDistribucionCartera(DistribucionCartera entity)
			throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"DistribucionCartera");
			}

			if (entity.getCartera() == null) {
				throw new ZMessManager().new ForeignException("cartera");
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

			if (entity.getFechaVencimiento() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaVencimiento");
			}

			if (entity.getIdDica() == null) {
				throw new ZMessManager().new EmptyFieldException("idDica");
			}

			if ((entity.getIdDica() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdDica(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idDica");
			}

			if (entity.getNumeroCuota() == null) {
				throw new ZMessManager().new EmptyFieldException("numeroCuota");
			}

			if ((entity.getNumeroCuota() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroCuota(), 2, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroCuota");
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

			if (entity.getValor() == null) {
				throw new ZMessManager().new EmptyFieldException("valor");
			}

			if ((entity.getValor() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getValor(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("valor");
			}

			if (entity.getCartera().getIdCart() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idCart_Cartera");
			}

			if ((entity.getCartera().getIdCart() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCartera().getIdCart(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idCart_Cartera");
			}

			distribucionCarteraDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<DistribucionCarteraDTO> getDataDistribucionCartera()
			throws Exception {
		try {
			List<DistribucionCartera> distribucionCartera = distribucionCarteraDAO
					.findAll();

			List<DistribucionCarteraDTO> distribucionCarteraDTO = new ArrayList<DistribucionCarteraDTO>();

			for (DistribucionCartera distribucionCarteraTmp : distribucionCartera) {
				DistribucionCarteraDTO distribucionCarteraDTO2 = new DistribucionCarteraDTO();

				distribucionCarteraDTO2.setIdDica(distribucionCarteraTmp
						.getIdDica());
				distribucionCarteraDTO2
						.setEstadoRegistro((distribucionCarteraTmp
								.getEstadoRegistro() != null) ? distribucionCarteraTmp
								.getEstadoRegistro() : null);
				distribucionCarteraDTO2.setFechaCreacion(distribucionCarteraTmp
						.getFechaCreacion());
				distribucionCarteraDTO2
						.setFechaModificacion(distribucionCarteraTmp
								.getFechaModificacion());
				distribucionCarteraDTO2
						.setFechaVencimiento(distribucionCarteraTmp
								.getFechaVencimiento());
				distribucionCarteraDTO2.setNumeroCuota((distribucionCarteraTmp
						.getNumeroCuota() != null) ? distribucionCarteraTmp
						.getNumeroCuota() : null);
				distribucionCarteraDTO2.setOperCreador((distribucionCarteraTmp
						.getOperCreador() != null) ? distribucionCarteraTmp
						.getOperCreador() : null);
				distribucionCarteraDTO2.setOperModifica((distribucionCarteraTmp
						.getOperModifica() != null) ? distribucionCarteraTmp
						.getOperModifica() : null);
				distribucionCarteraDTO2.setValor((distribucionCarteraTmp
						.getValor() != null) ? distribucionCarteraTmp
						.getValor() : null);
				distribucionCarteraDTO2
						.setIdCart_Cartera((distribucionCarteraTmp.getCartera()
								.getIdCart() != null) ? distribucionCarteraTmp
								.getCartera().getIdCart() : null);
				distribucionCarteraDTO.add(distribucionCarteraDTO2);
			}

			return distribucionCarteraDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public DistribucionCartera getDistribucionCartera(Long idDica)
			throws Exception {
		DistribucionCartera entity = null;

		try {
			entity = distribucionCarteraDAO.findById(idDica);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DistribucionCartera");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<DistribucionCartera> findPageDistribucionCartera(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<DistribucionCartera> entity = null;

		try {
			entity = distribucionCarteraDAO.findPage(sortColumnName,
					sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"DistribucionCartera Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberDistribucionCartera() throws Exception {
		Long entity = null;

		try {
			entity = distribucionCarteraDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"DistribucionCartera Count");
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
	public List<DistribucionCartera> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<DistribucionCartera> list = new ArrayList<DistribucionCartera>();
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
			list = distribucionCarteraDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
