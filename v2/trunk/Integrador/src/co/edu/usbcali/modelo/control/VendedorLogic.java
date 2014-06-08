package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.IAtencionVendedorDAO;
import co.edu.usbcali.dataaccess.dao.IConsecutivoDocumentoDAO;
import co.edu.usbcali.dataaccess.dao.IUnidadVentaDAO;
import co.edu.usbcali.dataaccess.dao.IVendedorDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.AtencionVendedor;
import co.edu.usbcali.modelo.ConsecutivoDocumento;
import co.edu.usbcali.modelo.UnidadVenta;
import co.edu.usbcali.modelo.Vendedor;
import co.edu.usbcali.modelo.dto.VendedorDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("VendedorLogic")
public class VendedorLogic implements IVendedorLogic {
	/**
	 * DAO injected by Spring that manages Vendedor entities
	 * 
	 */

	/**
	 * DAO injected by Spring that manages AtencionVendedor entities
	 * 
	 */
	@Autowired
	private IAtencionVendedorDAO atencionVendedorDAO;

	/**
	 * DAO injected by Spring that manages ConsecutivoDocumento entities
	 * 
	 */
	@Autowired
	private IConsecutivoDocumentoDAO consecutivoDocumentoDAO;

	/**
	 * DAO injected by Spring that manages UnidadVenta entities
	 * 
	 */
	@Autowired
	private IUnidadVentaDAO unidadVentaDAO;

	/**
	 * DAO injected by Spring that manages Vendedor entities
	 * 
	 */
	@Autowired
	private IVendedorDAO vendedorDAO;

	/**
	 * Logic injected by Spring that manages Persona entities
	 * 
	 */
	@Autowired
	IPersonaLogic logicPersona1;

	/**
	 * Logic injected by Spring that manages Sucursal entities
	 * 
	 */
	@Autowired
	ISucursalLogic logicSucursal2;

	/**
	 * Logic injected by Spring that manages Vendedor entities
	 * 
	 */
	@Autowired
	IVendedorLogic logicVendedor3;

	@Transactional(readOnly = true)
	public List<Vendedor> getVendedor() throws Exception {
		List<Vendedor> list = new ArrayList<Vendedor>();

		try {
			list = vendedorDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "Vendedor");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveVendedor(Vendedor entity) throws Exception {
		try {
			if (entity.getPersona() == null) {
				throw new ZMessManager().new ForeignException("persona");
			}

			if (entity.getSucursal() == null) {
				throw new ZMessManager().new ForeignException("sucursal");
			}

			if (entity.getVendedor() == null) {
				throw new ZMessManager().new ForeignException("vendedor");
			}

			if (entity.getCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("codigo");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCodigo(), 2) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getEmail() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEmail(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("email");
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

			if (entity.getIdVend() == null) {
				throw new ZMessManager().new EmptyFieldException("idVend");
			}

			if ((entity.getIdVend() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdVend(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idVend");
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

			if (entity.getVendedor().getIdVend() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idVend_Vendedor");
			}

			if ((entity.getVendedor().getIdVend() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getVendedor().getIdVend(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idVend_Vendedor");
			}

			if (getVendedor(entity.getIdVend()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			vendedorDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteVendedor(Vendedor entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Vendedor");
		}

		if (entity.getIdVend() == null) {
			throw new ZMessManager().new EmptyFieldException("idVend");
		}

		List<AtencionVendedor> atencionVendedors = null;
		List<ConsecutivoDocumento> consecutivoDocumentos = null;
		List<UnidadVenta> unidadVentas = null;
		List<Vendedor> vendedors = null;

		try {
			atencionVendedors = atencionVendedorDAO.findByProperty(
					"vendedor.idVend", entity.getIdVend());

			if (Utilities.validationsList(atencionVendedors) == true) {
				throw new ZMessManager().new DeletingException(
						"atencionVendedors");
			}

			consecutivoDocumentos = consecutivoDocumentoDAO.findByProperty(
					"vendedor.idVend", entity.getIdVend());

			if (Utilities.validationsList(consecutivoDocumentos) == true) {
				throw new ZMessManager().new DeletingException(
						"consecutivoDocumentos");
			}

			unidadVentas = unidadVentaDAO.findByProperty("vendedor.idVend",
					entity.getIdVend());

			if (Utilities.validationsList(unidadVentas) == true) {
				throw new ZMessManager().new DeletingException("unidadVentas");
			}

			vendedors = vendedorDAO.findByProperty("vendedor.idVend",
					entity.getIdVend());

			if (Utilities.validationsList(vendedors) == true) {
				throw new ZMessManager().new DeletingException("vendedors");
			}

			vendedorDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateVendedor(Vendedor entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Vendedor");
			}

			if (entity.getPersona() == null) {
				throw new ZMessManager().new ForeignException("persona");
			}

			if (entity.getSucursal() == null) {
				throw new ZMessManager().new ForeignException("sucursal");
			}

			if (entity.getVendedor() == null) {
				throw new ZMessManager().new ForeignException("vendedor");
			}

			if (entity.getCodigo() == null) {
				throw new ZMessManager().new EmptyFieldException("codigo");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCodigo(), 2) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
			}

			if ((entity.getEmail() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEmail(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("email");
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

			if (entity.getIdVend() == null) {
				throw new ZMessManager().new EmptyFieldException("idVend");
			}

			if ((entity.getIdVend() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdVend(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idVend");
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

			if (entity.getVendedor().getIdVend() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idVend_Vendedor");
			}

			if ((entity.getVendedor().getIdVend() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getVendedor().getIdVend(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idVend_Vendedor");
			}

			vendedorDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<VendedorDTO> getDataVendedor() throws Exception {
		try {
			List<Vendedor> vendedor = vendedorDAO.findAll();

			List<VendedorDTO> vendedorDTO = new ArrayList<VendedorDTO>();

			for (Vendedor vendedorTmp : vendedor) {
				VendedorDTO vendedorDTO2 = new VendedorDTO();

				vendedorDTO2.setIdVend(vendedorTmp.getIdVend());
				vendedorDTO2
						.setCodigo((vendedorTmp.getCodigo() != null) ? vendedorTmp
								.getCodigo() : null);
				vendedorDTO2
						.setEmail((vendedorTmp.getEmail() != null) ? vendedorTmp
								.getEmail() : null);
				vendedorDTO2
						.setEstadoRegistro((vendedorTmp.getEstadoRegistro() != null) ? vendedorTmp
								.getEstadoRegistro() : null);
				vendedorDTO2.setFechaCreacion(vendedorTmp.getFechaCreacion());
				vendedorDTO2.setFechaModificacion(vendedorTmp
						.getFechaModificacion());
				vendedorDTO2
						.setOperCreador((vendedorTmp.getOperCreador() != null) ? vendedorTmp
								.getOperCreador() : null);
				vendedorDTO2
						.setOperModifica((vendedorTmp.getOperModifica() != null) ? vendedorTmp
								.getOperModifica() : null);
				vendedorDTO2.setIdPers_Persona((vendedorTmp.getPersona()
						.getIdPers() != null) ? vendedorTmp.getPersona()
						.getIdPers() : null);
				vendedorDTO2.setIdSucu_Sucursal((vendedorTmp.getSucursal()
						.getIdSucu() != null) ? vendedorTmp.getSucursal()
						.getIdSucu() : null);

				if (vendedorTmp.getVendedor() != null) {
					vendedorDTO2.setIdVend_Vendedor(vendedorTmp.getVendedor()
							.getIdVend());
				} else {
					vendedorDTO2.setIdVend_Vendedor(null);
				}

				vendedorDTO.add(vendedorDTO2);
			}

			return vendedorDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Vendedor getVendedor(Long idVend) throws Exception {
		Vendedor entity = null;

		try {
			entity = vendedorDAO.findById(idVend);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Vendedor");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Vendedor> findPageVendedor(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Vendedor> entity = null;

		try {
			entity = vendedorDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Vendedor Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberVendedor() throws Exception {
		Long entity = null;

		try {
			entity = vendedorDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Vendedor Count");
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
	public List<Vendedor> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Vendedor> list = new ArrayList<Vendedor>();
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
			list = vendedorDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}

	@Override
	public Vendedor consultarVendedorPorIdPers(String propertyName, Object value)
			throws Exception {
		return vendedorDAO.findByPropertySingle(propertyName, value);
	}

}