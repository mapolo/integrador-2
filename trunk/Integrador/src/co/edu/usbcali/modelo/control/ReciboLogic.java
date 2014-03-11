package co.edu.usbcali.modelo.control;

import co.edu.usbcali.dataaccess.dao.*;
import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.ReciboDTO;
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
@Service("ReciboLogic")
public class ReciboLogic implements IReciboLogic {
	/**
	 * DAO injected by Spring that manages Recibo entities
	 * 
	 */
	@Autowired
	private IReciboDAO reciboDAO;

	/**
	 * DAO injected by Spring that manages RboDetalleDocumentos entities
	 * 
	 */
	@Autowired
	private IRboDetalleDocumentosDAO rboDetalleDocumentosDAO;

	/**
	 * DAO injected by Spring that manages RboDetalleFormasPago entities
	 * 
	 */
	@Autowired
	private IRboDetalleFormasPagoDAO rboDetalleFormasPagoDAO;

	/**
	 * Logic injected by Spring that manages Documento entities
	 * 
	 */
	@Autowired
	IDocumentoLogic logicDocumento1;

	/**
	 * Logic injected by Spring that manages UnidadVenta entities
	 * 
	 */
	@Autowired
	IUnidadVentaLogic logicUnidadVenta2;

	@Transactional(readOnly = true)
	public List<Recibo> getRecibo() throws Exception {
		List<Recibo> list = new ArrayList<Recibo>();

		try {
			list = reciboDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "Recibo");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveRecibo(Recibo entity) throws Exception {
		try {
			if (entity.getDocumento() == null) {
				throw new ZMessManager().new ForeignException("documento");
			}

			if (entity.getUnidadVenta() == null) {
				throw new ZMessManager().new ForeignException("unidadVenta");
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

			if (entity.getIdRcbo() == null) {
				throw new ZMessManager().new EmptyFieldException("idRcbo");
			}

			if ((entity.getIdRcbo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdRcbo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idRcbo");
			}

			if ((entity.getNumeroRboProvisional() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroRboProvisional(), 20, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroRboProvisional");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"observacion");
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

			if (entity.getDocumento().getIdDocu() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idDocu_Documento");
			}

			if ((entity.getDocumento().getIdDocu() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDocumento().getIdDocu(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idDocu_Documento");
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

			if (getRecibo(entity.getIdRcbo()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			reciboDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteRecibo(Recibo entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Recibo");
		}

		if (entity.getIdRcbo() == null) {
			throw new ZMessManager().new EmptyFieldException("idRcbo");
		}

		List<RboDetalleDocumentos> rboDetalleDocumentoses = null;
		List<RboDetalleFormasPago> rboDetalleFormasPagos = null;

		try {
			rboDetalleDocumentoses = rboDetalleDocumentosDAO.findByProperty(
					"recibo.idRcbo", entity.getIdRcbo());

			if (Utilities.validationsList(rboDetalleDocumentoses) == true) {
				throw new ZMessManager().new DeletingException(
						"rboDetalleDocumentoses");
			}

			rboDetalleFormasPagos = rboDetalleFormasPagoDAO.findByProperty(
					"recibo.idRcbo", entity.getIdRcbo());

			if (Utilities.validationsList(rboDetalleFormasPagos) == true) {
				throw new ZMessManager().new DeletingException(
						"rboDetalleFormasPagos");
			}

			reciboDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateRecibo(Recibo entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Recibo");
			}

			if (entity.getDocumento() == null) {
				throw new ZMessManager().new ForeignException("documento");
			}

			if (entity.getUnidadVenta() == null) {
				throw new ZMessManager().new ForeignException("unidadVenta");
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

			if (entity.getIdRcbo() == null) {
				throw new ZMessManager().new EmptyFieldException("idRcbo");
			}

			if ((entity.getIdRcbo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdRcbo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idRcbo");
			}

			if ((entity.getNumeroRboProvisional() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroRboProvisional(), 20, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroRboProvisional");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getObservacion(), 1000) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"observacion");
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

			if (entity.getDocumento().getIdDocu() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idDocu_Documento");
			}

			if ((entity.getDocumento().getIdDocu() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDocumento().getIdDocu(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idDocu_Documento");
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

			reciboDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<ReciboDTO> getDataRecibo() throws Exception {
		try {
			List<Recibo> recibo = reciboDAO.findAll();

			List<ReciboDTO> reciboDTO = new ArrayList<ReciboDTO>();

			for (Recibo reciboTmp : recibo) {
				ReciboDTO reciboDTO2 = new ReciboDTO();

				reciboDTO2.setIdRcbo(reciboTmp.getIdRcbo());
				reciboDTO2
						.setEstadoRegistro((reciboTmp.getEstadoRegistro() != null) ? reciboTmp
								.getEstadoRegistro() : null);
				reciboDTO2.setFechaCreacion(reciboTmp.getFechaCreacion());
				reciboDTO2.setFechaModificacion(reciboTmp
						.getFechaModificacion());
				reciboDTO2.setFechaTransaccion(reciboTmp.getFechaTransaccion());
				reciboDTO2.setNumeroRboProvisional((reciboTmp
						.getNumeroRboProvisional() != null) ? reciboTmp
						.getNumeroRboProvisional() : null);
				reciboDTO2
						.setObservacion((reciboTmp.getObservacion() != null) ? reciboTmp
								.getObservacion() : null);
				reciboDTO2
						.setOperCreador((reciboTmp.getOperCreador() != null) ? reciboTmp
								.getOperCreador() : null);
				reciboDTO2
						.setOperModifica((reciboTmp.getOperModifica() != null) ? reciboTmp
								.getOperModifica() : null);
				reciboDTO2.setIdDocu_Documento((reciboTmp.getDocumento()
						.getIdDocu() != null) ? reciboTmp.getDocumento()
						.getIdDocu() : null);
				reciboDTO2.setIdUnve_UnidadVenta((reciboTmp.getUnidadVenta()
						.getIdUnve() != null) ? reciboTmp.getUnidadVenta()
						.getIdUnve() : null);
				reciboDTO.add(reciboDTO2);
			}

			return reciboDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Recibo getRecibo(Long idRcbo) throws Exception {
		Recibo entity = null;

		try {
			entity = reciboDAO.findById(idRcbo);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Recibo");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Recibo> findPageRecibo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Recibo> entity = null;

		try {
			entity = reciboDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Recibo Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberRecibo() throws Exception {
		Long entity = null;

		try {
			entity = reciboDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Recibo Count");
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
	public List<Recibo> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Recibo> list = new ArrayList<Recibo>();
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
			list = reciboDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
