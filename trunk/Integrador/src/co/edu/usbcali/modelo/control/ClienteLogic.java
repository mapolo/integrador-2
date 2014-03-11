package co.edu.usbcali.modelo.control;

import co.edu.usbcali.dataaccess.dao.*;
import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.ClienteDTO;
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
@Service("ClienteLogic")
public class ClienteLogic implements IClienteLogic {
	/**
	 * DAO injected by Spring that manages Cliente entities
	 * 
	 */
	@Autowired
	private IClienteDAO clienteDAO;

	/**
	 * DAO injected by Spring that manages Multifamilia entities
	 * 
	 */
	@Autowired
	private IMultifamiliaDAO multifamiliaDAO;

	/**
	 * DAO injected by Spring that manages Multifamilia entities
	 * 
	 */

	/**
	 * Logic injected by Spring that manages Empresa entities
	 * 
	 */
	@Autowired
	IEmpresaLogic logicEmpresa1;

	/**
	 * Logic injected by Spring that manages Persona entities
	 * 
	 */
	@Autowired
	IPersonaLogic logicPersona2;

	/**
	 * Logic injected by Spring that manages TipoCartera entities
	 * 
	 */
	@Autowired
	ITipoCarteraLogic logicTipoCartera3;

	@Transactional(readOnly = true)
	public List<Cliente> getCliente() throws Exception {
		List<Cliente> list = new ArrayList<Cliente>();

		try {
			list = clienteDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "Cliente");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveCliente(Cliente entity) throws Exception {
		try {
			if (entity.getEmpresa() == null) {
				throw new ZMessManager().new ForeignException("empresa");
			}

			if (entity.getPersona() == null) {
				throw new ZMessManager().new ForeignException("persona");
			}

			if (entity.getTipoCartera() == null) {
				throw new ZMessManager().new ForeignException("tipoCartera");
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

			if (entity.getIdClie() == null) {
				throw new ZMessManager().new EmptyFieldException("idClie");
			}

			if ((entity.getIdClie() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdClie(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idClie");
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

			if (entity.getEmpresa().getIdEmpr() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idEmpr_Empresa");
			}

			if ((entity.getEmpresa().getIdEmpr() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getEmpresa().getIdEmpr(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idEmpr_Empresa");
			}

			if (entity.getPersona().getIdPers() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idPers_Persona");
			}

			if ((entity.getPersona().getIdPers() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPersona().getIdPers(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idPers_Persona");
			}

			if (entity.getTipoCartera().getIdTica() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idTica_TipoCartera");
			}

			if ((entity.getTipoCartera().getIdTica() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getTipoCartera().getIdTica(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idTica_TipoCartera");
			}

			if (getCliente(entity.getIdClie()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			clienteDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteCliente(Cliente entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Cliente");
		}

		if (entity.getIdClie() == null) {
			throw new ZMessManager().new EmptyFieldException("idClie");
		}

		List<Multifamilia> multifamiliasForClienteHijo = null;
		List<Multifamilia> multifamiliasForClientePadre = null;

		try {
			multifamiliasForClienteHijo = multifamiliaDAO.findByProperty(
					"cliente.idClie", entity.getIdClie());

			if (Utilities.validationsList(multifamiliasForClienteHijo) == true) {
				throw new ZMessManager().new DeletingException(
						"multifamiliasForClienteHijo");
			}

			multifamiliasForClientePadre = multifamiliaDAO.findByProperty(
					"cliente.idClie", entity.getIdClie());

			if (Utilities.validationsList(multifamiliasForClientePadre) == true) {
				throw new ZMessManager().new DeletingException(
						"multifamiliasForClientePadre");
			}

			clienteDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateCliente(Cliente entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Cliente");
			}

			if (entity.getEmpresa() == null) {
				throw new ZMessManager().new ForeignException("empresa");
			}

			if (entity.getPersona() == null) {
				throw new ZMessManager().new ForeignException("persona");
			}

			if (entity.getTipoCartera() == null) {
				throw new ZMessManager().new ForeignException("tipoCartera");
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

			if (entity.getIdClie() == null) {
				throw new ZMessManager().new EmptyFieldException("idClie");
			}

			if ((entity.getIdClie() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdClie(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idClie");
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

			if (entity.getEmpresa().getIdEmpr() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idEmpr_Empresa");
			}

			if ((entity.getEmpresa().getIdEmpr() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getEmpresa().getIdEmpr(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idEmpr_Empresa");
			}

			if (entity.getPersona().getIdPers() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idPers_Persona");
			}

			if ((entity.getPersona().getIdPers() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPersona().getIdPers(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idPers_Persona");
			}

			if (entity.getTipoCartera().getIdTica() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idTica_TipoCartera");
			}

			if ((entity.getTipoCartera().getIdTica() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getTipoCartera().getIdTica(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idTica_TipoCartera");
			}

			clienteDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<ClienteDTO> getDataCliente() throws Exception {
		try {
			List<Cliente> cliente = clienteDAO.findAll();

			List<ClienteDTO> clienteDTO = new ArrayList<ClienteDTO>();

			for (Cliente clienteTmp : cliente) {
				ClienteDTO clienteDTO2 = new ClienteDTO();

				clienteDTO2.setIdClie(clienteTmp.getIdClie());
				clienteDTO2
						.setEstadoRegistro((clienteTmp.getEstadoRegistro() != null) ? clienteTmp
								.getEstadoRegistro() : null);
				clienteDTO2.setFechaCreacion(clienteTmp.getFechaCreacion());
				clienteDTO2.setFechaModificacion(clienteTmp
						.getFechaModificacion());
				clienteDTO2
						.setOperCreador((clienteTmp.getOperCreador() != null) ? clienteTmp
								.getOperCreador() : null);
				clienteDTO2
						.setOperModifica((clienteTmp.getOperModifica() != null) ? clienteTmp
								.getOperModifica() : null);

				if (clienteTmp.getEmpresa() != null) {
					clienteDTO2.setIdEmpr_Empresa(clienteTmp.getEmpresa()
							.getIdEmpr());
				} else {
					clienteDTO2.setIdEmpr_Empresa(null);
				}

				if (clienteTmp.getPersona() != null) {
					clienteDTO2.setIdPers_Persona(clienteTmp.getPersona()
							.getIdPers());
				} else {
					clienteDTO2.setIdPers_Persona(null);
				}

				clienteDTO2.setIdTica_TipoCartera((clienteTmp.getTipoCartera()
						.getIdTica() != null) ? clienteTmp.getTipoCartera()
						.getIdTica() : null);
				clienteDTO.add(clienteDTO2);
			}

			return clienteDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Cliente getCliente(Long idClie) throws Exception {
		Cliente entity = null;

		try {
			entity = clienteDAO.findById(idClie);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Cliente");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Cliente> findPageCliente(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Cliente> entity = null;

		try {
			entity = clienteDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Cliente Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberCliente() throws Exception {
		Long entity = null;

		try {
			entity = clienteDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Cliente Count");
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
	public List<Cliente> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Cliente> list = new ArrayList<Cliente>();
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
			list = clienteDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
