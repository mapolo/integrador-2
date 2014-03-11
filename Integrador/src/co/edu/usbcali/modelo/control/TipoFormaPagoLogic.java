package co.edu.usbcali.modelo.control;

import co.edu.usbcali.dataaccess.dao.*;
import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.exceptions.ZMessManager.NotValidFormatException;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.TipoFormaPagoDTO;
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
@Service("TipoFormaPagoLogic")
public class TipoFormaPagoLogic implements ITipoFormaPagoLogic {
	/**
	 * DAO injected by Spring that manages TipoFormaPago entities
	 * 
	 */
	@Autowired
	private ITipoFormaPagoDAO tipoFormaPagoDAO;

	/**
	 * DAO injected by Spring that manages DescuentoFinanciero entities
	 * 
	 */
	@Autowired
	private IDescuentoFinancieroDAO descuentoFinancieroDAO;

	/**
	 * DAO injected by Spring that manages RboDetalleFormasPago entities
	 * 
	 */
	@Autowired
	private IRboDetalleFormasPagoDAO rboDetalleFormasPagoDAO;

	@Transactional(readOnly = true)
	public List<TipoFormaPago> getTipoFormaPago() throws Exception {
		List<TipoFormaPago> list = new ArrayList<TipoFormaPago>();

		try {
			list = tipoFormaPagoDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "TipoFormaPago");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveTipoFormaPago(TipoFormaPago entity) throws Exception {
		try {
			if (entity.getCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("codigo");
			}

			// Validacion de Estado Registro
			if (entity.getEstadoRegistro().equals("A")
					|| entity.getEstadoRegistro().equals("R")) {

			} else {
				throw new ZMessManager().new NotValidFormatException(
						"Estado registro solo recibe A o R");
			}

			// Validacion de Maneja Cheque
			if (entity.getManejaCheque() == 0 || entity.getManejaCheque() == 1) {

			} else {
				throw new ZMessManager().new NotValidFormatException(
						"Maneja Cheque solo recibe 0 o 1");
			}

			// Validacion de Maneja Tarjeta
			if (entity.getManejaTarjeta() == 0
					|| entity.getManejaTarjeta() == 1) {

			} else {
				throw new ZMessManager().new NotValidFormatException(
						"Maneja Tarjeta solo recibe 0 o 1");
			}

			// Validacion de Exije numero documento
			if (entity.getExijeNumeroDocumento() == 0
					|| entity.getExijeNumeroDocumento() == 1) {

			} else {
				throw new ZMessManager().new NotValidFormatException(
						"Exije numero documento solo recibe 0 o 1");
			}

			// Validacion de Es posfechado
			if (entity.getEsPosfechado() == 0 || entity.getEsPosfechado() == 1) {

			} else {
				throw new ZMessManager().new NotValidFormatException(
						"Es posfechado solo recibe 0 o 1");
			}

			// Validacion de Importa pda
			if (entity.getImportaPda() == 0 || entity.getImportaPda() == 1) {

			} else {
				throw new ZMessManager().new NotValidFormatException(
						"Importa pda solo recibe 0 o 1");
			}

			// Validacion de DSCTI fecha doc
			if (entity.getDsctoFechaDoc() == 0
					|| entity.getDsctoFechaDoc() == 1) {

			} else {
				throw new ZMessManager().new NotValidFormatException(
						"DSCTI fecha doc solo recibe 0 o 1");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCodigo(), 5) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if (entity.getDescripcion() == null) {
				throw new ZMessManager().new EmptyFieldException("descripcion");
			}

			if ((entity.getDescripcion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getDescripcion(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"descripcion");
			}

			if ((entity.getDsctoFechaDoc() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDsctoFechaDoc(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"dsctoFechaDoc");
			}

			if ((entity.getEsPosfechado() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getEsPosfechado(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"esPosfechado");
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

			if ((entity.getExijeNumeroDocumento() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getExijeNumeroDocumento(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"exijeNumeroDocumento");
			}

			if (entity.getFechaCreacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaCreacion");
			}

			if (entity.getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaModificacion");
			}

			

			if ((entity.getImportaPda() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getImportaPda(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"importaPda");
			}

			if ((entity.getManejaCheque() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getManejaCheque(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"manejaCheque");
			}

			if ((entity.getManejaTarjeta() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getManejaTarjeta(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"manejaTarjeta");
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

			

			tipoFormaPagoDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteTipoFormaPago(TipoFormaPago entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("TipoFormaPago");
		}

		if (entity.getIdTfpa() == null) {
			throw new ZMessManager().new EmptyFieldException("idTfpa");
		}

		List<DescuentoFinanciero> descuentoFinancieros = null;
		List<RboDetalleFormasPago> rboDetalleFormasPagos = null;

		try {
			descuentoFinancieros = descuentoFinancieroDAO.findByProperty(
					"tipoFormaPago.idTfpa", entity.getIdTfpa());

			if (Utilities.validationsList(descuentoFinancieros) == true) {
				throw new ZMessManager().new DeletingException(
						"descuentoFinancieros");
			}

			rboDetalleFormasPagos = rboDetalleFormasPagoDAO.findByProperty(
					"tipoFormaPago.idTfpa", entity.getIdTfpa());

			if (Utilities.validationsList(rboDetalleFormasPagos) == true) {
				throw new ZMessManager().new DeletingException(
						"rboDetalleFormasPagos");
			}

			tipoFormaPagoDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateTipoFormaPago(TipoFormaPago entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"TipoFormaPago");
			}

			// Validacion de Estado Registro
			if (entity.getEstadoRegistro().equals("A")
					|| entity.getEstadoRegistro().equals("R")) {

			} else {
				throw new ZMessManager().new NotValidFormatException(
						"Estado registro solo recibe A o R");
			}

			// Validacion de Maneja Cheque
			if (entity.getManejaCheque() == 0 || entity.getManejaCheque() == 1) {

			} else {
				throw new ZMessManager().new NotValidFormatException(
						"Maneja Cheque solo recibe 0 o 1");
			}

			// Validacion de Maneja Tarjeta
			if (entity.getManejaTarjeta() == 0
					|| entity.getManejaTarjeta() == 1) {

			} else {
				throw new ZMessManager().new NotValidFormatException(
						"Maneja Tarjeta solo recibe 0 o 1");
			}

			// Validacion de Exije numero documento
			if (entity.getExijeNumeroDocumento() == 0
					|| entity.getExijeNumeroDocumento() == 1) {

			} else {
				throw new ZMessManager().new NotValidFormatException(
						"Exije numero documento solo recibe 0 o 1");
			}

			// Validacion de Es posfechado
			if (entity.getEsPosfechado() == 0 || entity.getEsPosfechado() == 1) {

			} else {
				throw new ZMessManager().new NotValidFormatException(
						"Es posfechado solo recibe 0 o 1");
			}

			// Validacion de Importa pda
			if (entity.getImportaPda() == 0 || entity.getImportaPda() == 1) {

			} else {
				throw new ZMessManager().new NotValidFormatException(
						"Importa pda solo recibe 0 o 1");
			}

			// Validacion de DSCTI fecha doc
			if (entity.getDsctoFechaDoc() == 0
					|| entity.getDsctoFechaDoc() == 1) {

			} else {
				throw new ZMessManager().new NotValidFormatException(
						"DSCTI fecha doc solo recibe 0 o 1");
			}

			if (entity.getCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("codigo");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCodigo(), 5) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if (entity.getDescripcion() == null) {
				throw new ZMessManager().new EmptyFieldException("descripcion");
			}

			if ((entity.getDescripcion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getDescripcion(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"descripcion");
			}

			if ((entity.getDsctoFechaDoc() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDsctoFechaDoc(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"dsctoFechaDoc");
			}

			if ((entity.getEsPosfechado() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getEsPosfechado(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"esPosfechado");
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

			if ((entity.getExijeNumeroDocumento() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getExijeNumeroDocumento(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"exijeNumeroDocumento");
			}

			if (entity.getFechaCreacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaCreacion");
			}

			if (entity.getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaModificacion");
			}

			if (entity.getIdTfpa() == null) {
				throw new ZMessManager().new EmptyFieldException("idTfpa");
			}

			if ((entity.getIdTfpa() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdTfpa(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idTfpa");
			}

			if ((entity.getImportaPda() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getImportaPda(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"importaPda");
			}

			if ((entity.getManejaCheque() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getManejaCheque(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"manejaCheque");
			}

			if ((entity.getManejaTarjeta() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getManejaTarjeta(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"manejaTarjeta");
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

			tipoFormaPagoDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<TipoFormaPagoDTO> getDataTipoFormaPago() throws Exception {
		try {
			List<TipoFormaPago> tipoFormaPago = tipoFormaPagoDAO.findAll();

			List<TipoFormaPagoDTO> tipoFormaPagoDTO = new ArrayList<TipoFormaPagoDTO>();

			for (TipoFormaPago tipoFormaPagoTmp : tipoFormaPago) {
				TipoFormaPagoDTO tipoFormaPagoDTO2 = new TipoFormaPagoDTO();

				tipoFormaPagoDTO2.setIdTfpa(tipoFormaPagoTmp.getIdTfpa());
				tipoFormaPagoDTO2
						.setCodigo((tipoFormaPagoTmp.getCodigo() != null) ? tipoFormaPagoTmp
								.getCodigo() : null);
				tipoFormaPagoDTO2.setDescripcion((tipoFormaPagoTmp
						.getDescripcion() != null) ? tipoFormaPagoTmp
						.getDescripcion() : null);
				tipoFormaPagoDTO2.setDsctoFechaDoc((tipoFormaPagoTmp
						.getDsctoFechaDoc() != null) ? tipoFormaPagoTmp
						.getDsctoFechaDoc() : null);
				tipoFormaPagoDTO2.setEsPosfechado((tipoFormaPagoTmp
						.getEsPosfechado() != null) ? tipoFormaPagoTmp
						.getEsPosfechado() : null);
				tipoFormaPagoDTO2.setEstadoRegistro((tipoFormaPagoTmp
						.getEstadoRegistro() != null) ? tipoFormaPagoTmp
						.getEstadoRegistro() : null);
				tipoFormaPagoDTO2.setExijeNumeroDocumento((tipoFormaPagoTmp
						.getExijeNumeroDocumento() != null) ? tipoFormaPagoTmp
						.getExijeNumeroDocumento() : null);
				tipoFormaPagoDTO2.setFechaCreacion(tipoFormaPagoTmp
						.getFechaCreacion());
				tipoFormaPagoDTO2.setFechaModificacion(tipoFormaPagoTmp
						.getFechaModificacion());
				tipoFormaPagoDTO2.setImportaPda((tipoFormaPagoTmp
						.getImportaPda() != null) ? tipoFormaPagoTmp
						.getImportaPda() : null);
				tipoFormaPagoDTO2.setManejaCheque((tipoFormaPagoTmp
						.getManejaCheque() != null) ? tipoFormaPagoTmp
						.getManejaCheque() : null);
				tipoFormaPagoDTO2.setManejaTarjeta((tipoFormaPagoTmp
						.getManejaTarjeta() != null) ? tipoFormaPagoTmp
						.getManejaTarjeta() : null);
				tipoFormaPagoDTO2.setOperCreador((tipoFormaPagoTmp
						.getOperCreador() != null) ? tipoFormaPagoTmp
						.getOperCreador() : null);
				tipoFormaPagoDTO2.setOperModifica((tipoFormaPagoTmp
						.getOperModifica() != null) ? tipoFormaPagoTmp
						.getOperModifica() : null);
				tipoFormaPagoDTO.add(tipoFormaPagoDTO2);
			}

			return tipoFormaPagoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public TipoFormaPago getTipoFormaPago(Long idTfpa) throws Exception {
		TipoFormaPago entity = null;

		try {
			entity = tipoFormaPagoDAO.findById(idTfpa);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TipoFormaPago");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<TipoFormaPago> findPageTipoFormaPago(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<TipoFormaPago> entity = null;

		try {
			entity = tipoFormaPagoDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TipoFormaPago Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberTipoFormaPago() throws Exception {
		Long entity = null;

		try {
			entity = tipoFormaPagoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("TipoFormaPago Count");
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
	public List<TipoFormaPago> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<TipoFormaPago> list = new ArrayList<TipoFormaPago>();
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
			list = tipoFormaPagoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
