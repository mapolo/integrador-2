package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.IClaveFabricacionDAO;
import co.edu.usbcali.dataaccess.dao.IClavesParaRotarDAO;
import co.edu.usbcali.dataaccess.dao.IGarantiaDAO;
import co.edu.usbcali.dataaccess.dao.IItemRotacionDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.ClaveFabricacion;
import co.edu.usbcali.modelo.ClavesParaRotar;
import co.edu.usbcali.modelo.Garantia;
import co.edu.usbcali.modelo.ItemRotacion;
import co.edu.usbcali.modelo.dto.ClaveFabricacionDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("ClaveFabricacionLogic")
public class ClaveFabricacionLogic implements IClaveFabricacionLogic {
	/**
	 * DAO injected by Spring that manages ClaveFabricacion entities
	 * 
	 */
	@Autowired
	private IClaveFabricacionDAO claveFabricacionDAO;

	/**
	 * DAO injected by Spring that manages ClavesParaRotar entities
	 * 
	 */
	@Autowired
	private IClavesParaRotarDAO clavesParaRotarDAO;

	/**
	 * DAO injected by Spring that manages Garantia entities
	 * 
	 */
	@Autowired
	private IGarantiaDAO garantiaDAO;

	/**
	 * DAO injected by Spring that manages ItemRotacion entities
	 * 
	 */
	@Autowired
	private IItemRotacionDAO itemRotacionDAO;

	@Transactional(readOnly = true)
	public List<ClaveFabricacion> getClaveFabricacion() throws Exception {
		List<ClaveFabricacion> list = new ArrayList<ClaveFabricacion>();

		try {
			list = claveFabricacionDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "ClaveFabricacion");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveClaveFabricacion(ClaveFabricacion entity) throws Exception {
		try {	
					
			
			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCodigo(), 5) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}
			

			// Validacion de Estado registro
			if (entity.getEstadoRegistro().equals("A")
					|| entity.getEstadoRegistro().equals("R")) {

			} else {
				throw new ZMessManager().new NotValidFormatException(
						"Estado registro solo recibe A o R");
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

			if (entity.getFechaFinal() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaFinal");
			}

			if (entity.getFechaInicial() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaInicial");
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

			

			claveFabricacionDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteClaveFabricacion(ClaveFabricacion entity)
			throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("ClaveFabricacion");
		}

		if (entity.getIdClfa() == null) {
			throw new ZMessManager().new EmptyFieldException("idClfa");
		}

		List<ClavesParaRotar> clavesParaRotars = null;
		List<Garantia> garantias = null;
		List<ItemRotacion> itemRotacions = null;

		try {
			clavesParaRotars = clavesParaRotarDAO.findByProperty(
					"claveFabricacion.idClfa", entity.getIdClfa());

			if (Utilities.validationsList(clavesParaRotars) == true) {
				throw new ZMessManager().new DeletingException(
						"clavesParaRotars");
			}

			garantias = garantiaDAO.findByProperty("claveFabricacion.idClfa",
					entity.getIdClfa());

			if (Utilities.validationsList(garantias) == true) {
				throw new ZMessManager().new DeletingException("garantias");
			}

			itemRotacions = itemRotacionDAO.findByProperty(
					"claveFabricacion.idClfa", entity.getIdClfa());

			if (Utilities.validationsList(itemRotacions) == true) {
				throw new ZMessManager().new DeletingException("itemRotacions");
			}

			claveFabricacionDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateClaveFabricacion(ClaveFabricacion entity)
			throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"ClaveFabricacion");
			}
			
			// Validacion de Estado registro
			if (entity.getEstadoRegistro().equals("A")
					|| entity.getEstadoRegistro().equals("R")) {

			} else {
				throw new ZMessManager().new NotValidFormatException(
						"Estado registro solo recibe A o R");
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

			if (entity.getFechaFinal() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaFinal");
			}

			if (entity.getFechaInicial() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaInicial");
			}

			if (entity.getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaModificacion");
			}

			if (entity.getIdClfa() == null) {
				throw new ZMessManager().new EmptyFieldException("idClfa");
			}

			if ((entity.getIdClfa() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdClfa(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idClfa");
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

			claveFabricacionDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<ClaveFabricacionDTO> getDataClaveFabricacion() throws Exception {
		try {
			List<ClaveFabricacion> claveFabricacion = claveFabricacionDAO
					.findAll();

			List<ClaveFabricacionDTO> claveFabricacionDTO = new ArrayList<ClaveFabricacionDTO>();

			for (ClaveFabricacion claveFabricacionTmp : claveFabricacion) {
				ClaveFabricacionDTO claveFabricacionDTO2 = new ClaveFabricacionDTO();

				claveFabricacionDTO2.setIdClfa(claveFabricacionTmp.getIdClfa());
				claveFabricacionDTO2
						.setCodigo((claveFabricacionTmp.getCodigo() != null) ? claveFabricacionTmp
								.getCodigo() : null);
				claveFabricacionDTO2.setEstadoRegistro((claveFabricacionTmp
						.getEstadoRegistro() != null) ? claveFabricacionTmp
						.getEstadoRegistro() : null);
				claveFabricacionDTO2.setFechaCreacion(claveFabricacionTmp
						.getFechaCreacion());
				claveFabricacionDTO2.setFechaFinal(claveFabricacionTmp
						.getFechaFinal());
				claveFabricacionDTO2.setFechaInicial(claveFabricacionTmp
						.getFechaInicial());
				claveFabricacionDTO2.setFechaModificacion(claveFabricacionTmp
						.getFechaModificacion());
				claveFabricacionDTO2.setOperCreador((claveFabricacionTmp
						.getOperCreador() != null) ? claveFabricacionTmp
						.getOperCreador() : null);
				claveFabricacionDTO2.setOperModifica((claveFabricacionTmp
						.getOperModifica() != null) ? claveFabricacionTmp
						.getOperModifica() : null);
				claveFabricacionDTO.add(claveFabricacionDTO2);
			}

			return claveFabricacionDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public ClaveFabricacion getClaveFabricacion(Long idClfa) throws Exception {
		ClaveFabricacion entity = null;

		try {
			entity = claveFabricacionDAO.findById(idClfa);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("ClaveFabricacion");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<ClaveFabricacion> findPageClaveFabricacion(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<ClaveFabricacion> entity = null;

		try {
			entity = claveFabricacionDAO.findPage(sortColumnName,
					sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"ClaveFabricacion Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberClaveFabricacion() throws Exception {
		Long entity = null;

		try {
			entity = claveFabricacionDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"ClaveFabricacion Count");
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
	public List<ClaveFabricacion> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<ClaveFabricacion> list = new ArrayList<ClaveFabricacion>();
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
			list = claveFabricacionDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
