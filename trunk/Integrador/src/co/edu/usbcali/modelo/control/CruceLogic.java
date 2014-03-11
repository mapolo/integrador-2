package co.edu.usbcali.modelo.control;

import co.edu.usbcali.dataaccess.dao.*;
import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.CruceDTO;
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
@Service("CruceLogic")
public class CruceLogic implements ICruceLogic {
	/**
	 * DAO injected by Spring that manages Cruce entities
	 * 
	 */
	@Autowired
	private ICruceDAO cruceDAO;

	/**
	 * Logic injected by Spring that manages DescuentoFinanciero entities
	 * 
	 */
	@Autowired
	IDescuentoFinancieroLogic logicDescuentoFinanciero1;

	/**
	 * Logic injected by Spring that manages RboDetalleDocumentos entities
	 * 
	 */
	@Autowired
	IRboDetalleDocumentosLogic logicRboDetalleDocumentos2;

	/**
	 * Logic injected by Spring that manages RboDetalleFormasPago entities
	 * 
	 */
	@Autowired
	IRboDetalleFormasPagoLogic logicRboDetalleFormasPago3;

	@Transactional(readOnly = true)
	public List<Cruce> getCruce() throws Exception {
		List<Cruce> list = new ArrayList<Cruce>();

		try {
			list = cruceDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "Cruce");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveCruce(Cruce entity) throws Exception {
		try {
			if (entity.getDescuentoFinanciero() == null) {
				throw new ZMessManager().new ForeignException(
						"descuentoFinanciero");
			}

			if (entity.getRboDetalleDocumentos() == null) {
				throw new ZMessManager().new ForeignException(
						"rboDetalleDocumentos");
			}

			if (entity.getRboDetalleFormasPago() == null) {
				throw new ZMessManager().new ForeignException(
						"rboDetalleFormasPago");
			}

			if ((entity.getDescuento() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDescuento(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"descuento");
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

			if (entity.getIdCrce() == null) {
				throw new ZMessManager().new EmptyFieldException("idCrce");
			}

			if ((entity.getIdCrce() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdCrce(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idCrce");
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

			if (entity.getDescuentoFinanciero().getIdDefi() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idDefi_DescuentoFinanciero");
			}

			if ((entity.getDescuentoFinanciero().getIdDefi() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDescuentoFinanciero().getIdDefi(), 10,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idDefi_DescuentoFinanciero");
			}

			if (entity.getRboDetalleDocumentos().getIdRddo() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idRddo_RboDetalleDocumentos");
			}

			if ((entity.getRboDetalleDocumentos().getIdRddo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getRboDetalleDocumentos().getIdRddo(), 10,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idRddo_RboDetalleDocumentos");
			}

			if (entity.getRboDetalleFormasPago().getIdRdfp() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idRdfp_RboDetalleFormasPago");
			}

			if ((entity.getRboDetalleFormasPago().getIdRdfp() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getRboDetalleFormasPago().getIdRdfp(), 10,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idRdfp_RboDetalleFormasPago");
			}

			if (getCruce(entity.getIdCrce()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			cruceDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteCruce(Cruce entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Cruce");
		}

		if (entity.getIdCrce() == null) {
			throw new ZMessManager().new EmptyFieldException("idCrce");
		}

		try {
			cruceDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateCruce(Cruce entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Cruce");
			}

			if (entity.getDescuentoFinanciero() == null) {
				throw new ZMessManager().new ForeignException(
						"descuentoFinanciero");
			}

			if (entity.getRboDetalleDocumentos() == null) {
				throw new ZMessManager().new ForeignException(
						"rboDetalleDocumentos");
			}

			if (entity.getRboDetalleFormasPago() == null) {
				throw new ZMessManager().new ForeignException(
						"rboDetalleFormasPago");
			}

			if ((entity.getDescuento() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDescuento(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"descuento");
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

			if (entity.getIdCrce() == null) {
				throw new ZMessManager().new EmptyFieldException("idCrce");
			}

			if ((entity.getIdCrce() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdCrce(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idCrce");
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

			if (entity.getDescuentoFinanciero().getIdDefi() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idDefi_DescuentoFinanciero");
			}

			if ((entity.getDescuentoFinanciero().getIdDefi() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDescuentoFinanciero().getIdDefi(), 10,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idDefi_DescuentoFinanciero");
			}

			if (entity.getRboDetalleDocumentos().getIdRddo() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idRddo_RboDetalleDocumentos");
			}

			if ((entity.getRboDetalleDocumentos().getIdRddo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getRboDetalleDocumentos().getIdRddo(), 10,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idRddo_RboDetalleDocumentos");
			}

			if (entity.getRboDetalleFormasPago().getIdRdfp() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idRdfp_RboDetalleFormasPago");
			}

			if ((entity.getRboDetalleFormasPago().getIdRdfp() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getRboDetalleFormasPago().getIdRdfp(), 10,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idRdfp_RboDetalleFormasPago");
			}

			cruceDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<CruceDTO> getDataCruce() throws Exception {
		try {
			List<Cruce> cruce = cruceDAO.findAll();

			List<CruceDTO> cruceDTO = new ArrayList<CruceDTO>();

			for (Cruce cruceTmp : cruce) {
				CruceDTO cruceDTO2 = new CruceDTO();

				cruceDTO2.setIdCrce(cruceTmp.getIdCrce());
				cruceDTO2
						.setDescuento((cruceTmp.getDescuento() != null) ? cruceTmp
								.getDescuento() : null);
				cruceDTO2
						.setEstadoRegistro((cruceTmp.getEstadoRegistro() != null) ? cruceTmp
								.getEstadoRegistro() : null);
				cruceDTO2.setFechaCreacion(cruceTmp.getFechaCreacion());
				cruceDTO2.setFechaModificacion(cruceTmp.getFechaModificacion());
				cruceDTO2
						.setOperCreador((cruceTmp.getOperCreador() != null) ? cruceTmp
								.getOperCreador() : null);
				cruceDTO2
						.setOperModifica((cruceTmp.getOperModifica() != null) ? cruceTmp
								.getOperModifica() : null);
				cruceDTO2
						.setIdDefi_DescuentoFinanciero((cruceTmp
								.getDescuentoFinanciero().getIdDefi() != null) ? cruceTmp
								.getDescuentoFinanciero().getIdDefi() : null);
				cruceDTO2
						.setIdRddo_RboDetalleDocumentos((cruceTmp
								.getRboDetalleDocumentos().getIdRddo() != null) ? cruceTmp
								.getRboDetalleDocumentos().getIdRddo() : null);
				cruceDTO2
						.setIdRdfp_RboDetalleFormasPago((cruceTmp
								.getRboDetalleFormasPago().getIdRdfp() != null) ? cruceTmp
								.getRboDetalleFormasPago().getIdRdfp() : null);
				cruceDTO.add(cruceDTO2);
			}

			return cruceDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Cruce getCruce(Long idCrce) throws Exception {
		Cruce entity = null;

		try {
			entity = cruceDAO.findById(idCrce);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Cruce");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Cruce> findPageCruce(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Cruce> entity = null;

		try {
			entity = cruceDAO.findPage(sortColumnName, sortAscending, startRow,
					maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Cruce Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberCruce() throws Exception {
		Long entity = null;

		try {
			entity = cruceDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Cruce Count");
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
	public List<Cruce> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Cruce> list = new ArrayList<Cruce>();
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
			list = cruceDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
