package co.edu.usbcali.modelo.control;

import co.edu.usbcali.dataaccess.dao.*;
import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.EmpresaDTO;
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
@Service("EmpresaLogic")
public class EmpresaLogic implements IEmpresaLogic {
	/**
	 * DAO injected by Spring that manages Empresa entities
	 * 
	 */
	@Autowired
	private IEmpresaDAO empresaDAO;

	/**
	 * DAO injected by Spring that manages Cliente entities
	 * 
	 */
	@Autowired
	private IClienteDAO clienteDAO;

	/**
	 * DAO injected by Spring that manages Compania entities
	 * 
	 */
	@Autowired
	private ICompaniaDAO companiaDAO;

	/**
	 * DAO injected by Spring that manages DescuentoComercial entities
	 * 
	 */
	@Autowired
	private IDescuentoComercialDAO descuentoComercialDAO;

	/**
	 * DAO injected by Spring that manages ListaPreciosEspeciales entities
	 * 
	 */
	@Autowired
	private IListaPreciosEspecialesDAO listaPreciosEspecialesDAO;

	/**
	 * DAO injected by Spring that manages OrdenesDeCompra entities
	 * 
	 */
	@Autowired
	private IOrdenesDeCompraDAO ordenesDeCompraDAO;

	/**
	 * DAO injected by Spring that manages Proveedor entities
	 * 
	 */
	@Autowired
	private IProveedorDAO proveedorDAO;

	/**
	 * DAO injected by Spring that manages RelacionComercial entities
	 * 
	 */
	@Autowired
	private IRelacionComercialDAO relacionComercialDAO;

	/**
	 * DAO injected by Spring that manages Sucursal entities
	 * 
	 */
	@Autowired
	private ISucursalDAO sucursalDAO;

	/**
	 * Logic injected by Spring that manages DivisionPolitica entities
	 * 
	 */
	@Autowired
	IDivisionPoliticaLogic logicDivisionPolitica1;

	/**
	 * Logic injected by Spring that manages Persona entities
	 * 
	 */
	@Autowired
	IPersonaLogic logicPersona2;

	/**
	 * Logic injected by Spring that manages TipoIdentificacion entities
	 * 
	 */
	@Autowired
	ITipoIdentificacionLogic logicTipoIdentificacion3;

	@Transactional(readOnly = true)
	public List<Empresa> getEmpresa() throws Exception {
		List<Empresa> list = new ArrayList<Empresa>();

		try {
			list = empresaDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "Empresa");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveEmpresa(Empresa entity) throws Exception {
		try {
			if (entity.getDivisionPolitica() == null) {
				throw new ZMessManager().new ForeignException(
						"divisionPolitica");
			}

			if (entity.getPersona() == null) {
				throw new ZMessManager().new ForeignException("persona");
			}

			if (entity.getTipoIdentificacion() == null) {
				throw new ZMessManager().new ForeignException(
						"tipoIdentificacion");
			}

			if ((entity.getApartadoAereo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getApartadoAereo(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"apartadoAereo");
			}

			if ((entity.getDireccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getDireccion(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"direccion");
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

			if ((entity.getFax() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getFax(),
							30) == false)) {
				throw new ZMessManager().new NotValidFormatException("fax");
			}

			if (entity.getFechaCreacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaCreacion");
			}

			if (entity.getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaModificacion");
			}

			if (entity.getIdEmpr() == null) {
				throw new ZMessManager().new EmptyFieldException("idEmpr");
			}

			if ((entity.getIdEmpr() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdEmpr(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idEmpr");
			}

			if (entity.getIdentificacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"identificacion");
			}

			if ((entity.getIdentificacion() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdentificacion(), 15, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"identificacion");
			}

			if (entity.getNombre() == null) {
				throw new ZMessManager().new EmptyFieldException("nombre");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNombre(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
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

			if ((entity.getTelefono1() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getTelefono1(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"telefono1");
			}

			if ((entity.getTelefono2() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getTelefono2(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"telefono2");
			}

			if (entity.getDivisionPolitica().getIdDipo() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idDipo_DivisionPolitica");
			}

			if ((entity.getDivisionPolitica().getIdDipo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDivisionPolitica().getIdDipo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idDipo_DivisionPolitica");
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

			if (entity.getTipoIdentificacion().getIdTiid() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idTiid_TipoIdentificacion");
			}

			if ((entity.getTipoIdentificacion().getIdTiid() != null)
					&& (Utilities
							.checkNumberAndCheckWithPrecisionAndScale(""
									+ entity.getTipoIdentificacion()
											.getIdTiid(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idTiid_TipoIdentificacion");
			}

			if (getEmpresa(entity.getIdEmpr()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			empresaDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteEmpresa(Empresa entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Empresa");
		}

		if (entity.getIdEmpr() == null) {
			throw new ZMessManager().new EmptyFieldException("idEmpr");
		}

		List<Cliente> clientes = null;
		List<Compania> companias = null;
		List<DescuentoComercial> descuentoComercials = null;
		List<ListaPreciosEspeciales> listaPreciosEspecialeses = null;
		List<OrdenesDeCompra> ordenesDeCompras = null;
		List<Proveedor> proveedors = null;
		List<RelacionComercial> relacionComercials = null;
		List<Sucursal> sucursals = null;

		try {
			clientes = clienteDAO.findByProperty("empresa.idEmpr",
					entity.getIdEmpr());

			if (Utilities.validationsList(clientes) == true) {
				throw new ZMessManager().new DeletingException("clientes");
			}

			companias = companiaDAO.findByProperty("empresa.idEmpr",
					entity.getIdEmpr());

			if (Utilities.validationsList(companias) == true) {
				throw new ZMessManager().new DeletingException("companias");
			}

			descuentoComercials = descuentoComercialDAO.findByProperty(
					"empresa.idEmpr", entity.getIdEmpr());

			if (Utilities.validationsList(descuentoComercials) == true) {
				throw new ZMessManager().new DeletingException(
						"descuentoComercials");
			}

			listaPreciosEspecialeses = listaPreciosEspecialesDAO
					.findByProperty("empresa.idEmpr", entity.getIdEmpr());

			if (Utilities.validationsList(listaPreciosEspecialeses) == true) {
				throw new ZMessManager().new DeletingException(
						"listaPreciosEspecialeses");
			}

			ordenesDeCompras = ordenesDeCompraDAO.findByProperty(
					"empresa.idEmpr", entity.getIdEmpr());

			if (Utilities.validationsList(ordenesDeCompras) == true) {
				throw new ZMessManager().new DeletingException(
						"ordenesDeCompras");
			}

			proveedors = proveedorDAO.findByProperty("empresa.idEmpr",
					entity.getIdEmpr());

			if (Utilities.validationsList(proveedors) == true) {
				throw new ZMessManager().new DeletingException("proveedors");
			}

			relacionComercials = relacionComercialDAO.findByProperty(
					"empresa.idEmpr", entity.getIdEmpr());

			if (Utilities.validationsList(relacionComercials) == true) {
				throw new ZMessManager().new DeletingException(
						"relacionComercials");
			}

			sucursals = sucursalDAO.findByProperty("empresa.idEmpr",
					entity.getIdEmpr());

			if (Utilities.validationsList(sucursals) == true) {
				throw new ZMessManager().new DeletingException("sucursals");
			}

			empresaDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateEmpresa(Empresa entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Empresa");
			}

			if (entity.getDivisionPolitica() == null) {
				throw new ZMessManager().new ForeignException(
						"divisionPolitica");
			}

			if (entity.getPersona() == null) {
				throw new ZMessManager().new ForeignException("persona");
			}

			if (entity.getTipoIdentificacion() == null) {
				throw new ZMessManager().new ForeignException(
						"tipoIdentificacion");
			}

			if ((entity.getApartadoAereo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getApartadoAereo(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"apartadoAereo");
			}

			if ((entity.getDireccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getDireccion(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"direccion");
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

			if ((entity.getFax() != null)
					&& (Utilities.checkWordAndCheckWithlength(entity.getFax(),
							30) == false)) {
				throw new ZMessManager().new NotValidFormatException("fax");
			}

			if (entity.getFechaCreacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaCreacion");
			}

			if (entity.getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaModificacion");
			}

			if (entity.getIdEmpr() == null) {
				throw new ZMessManager().new EmptyFieldException("idEmpr");
			}

			if ((entity.getIdEmpr() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdEmpr(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idEmpr");
			}

			if (entity.getIdentificacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"identificacion");
			}

			if ((entity.getIdentificacion() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdentificacion(), 15, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"identificacion");
			}

			if (entity.getNombre() == null) {
				throw new ZMessManager().new EmptyFieldException("nombre");
			}

			if ((entity.getNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNombre(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException("nombre");
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

			if ((entity.getTelefono1() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getTelefono1(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"telefono1");
			}

			if ((entity.getTelefono2() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getTelefono2(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"telefono2");
			}

			if (entity.getDivisionPolitica().getIdDipo() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idDipo_DivisionPolitica");
			}

			if ((entity.getDivisionPolitica().getIdDipo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDivisionPolitica().getIdDipo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idDipo_DivisionPolitica");
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

			if (entity.getTipoIdentificacion().getIdTiid() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idTiid_TipoIdentificacion");
			}

			if ((entity.getTipoIdentificacion().getIdTiid() != null)
					&& (Utilities
							.checkNumberAndCheckWithPrecisionAndScale(""
									+ entity.getTipoIdentificacion()
											.getIdTiid(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idTiid_TipoIdentificacion");
			}

			empresaDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<EmpresaDTO> getDataEmpresa() throws Exception {
		try {
			List<Empresa> empresa = empresaDAO.findAll();

			List<EmpresaDTO> empresaDTO = new ArrayList<EmpresaDTO>();

			for (Empresa empresaTmp : empresa) {
				EmpresaDTO empresaDTO2 = new EmpresaDTO();

				empresaDTO2.setIdEmpr(empresaTmp.getIdEmpr());
				empresaDTO2
						.setApartadoAereo((empresaTmp.getApartadoAereo() != null) ? empresaTmp
								.getApartadoAereo() : null);
				empresaDTO2
						.setDireccion((empresaTmp.getDireccion() != null) ? empresaTmp
								.getDireccion() : null);
				empresaDTO2
						.setEmail((empresaTmp.getEmail() != null) ? empresaTmp
								.getEmail() : null);
				empresaDTO2
						.setEstadoRegistro((empresaTmp.getEstadoRegistro() != null) ? empresaTmp
								.getEstadoRegistro() : null);
				empresaDTO2.setFax((empresaTmp.getFax() != null) ? empresaTmp
						.getFax() : null);
				empresaDTO2.setFechaCreacion(empresaTmp.getFechaCreacion());
				empresaDTO2.setFechaModificacion(empresaTmp
						.getFechaModificacion());
				empresaDTO2
						.setIdentificacion((empresaTmp.getIdentificacion() != null) ? empresaTmp
								.getIdentificacion() : null);
				empresaDTO2
						.setNombre((empresaTmp.getNombre() != null) ? empresaTmp
								.getNombre() : null);
				empresaDTO2
						.setOperCreador((empresaTmp.getOperCreador() != null) ? empresaTmp
								.getOperCreador() : null);
				empresaDTO2
						.setOperModifica((empresaTmp.getOperModifica() != null) ? empresaTmp
								.getOperModifica() : null);
				empresaDTO2
						.setTelefono1((empresaTmp.getTelefono1() != null) ? empresaTmp
								.getTelefono1() : null);
				empresaDTO2
						.setTelefono2((empresaTmp.getTelefono2() != null) ? empresaTmp
								.getTelefono2() : null);
				empresaDTO2
						.setIdDipo_DivisionPolitica((empresaTmp
								.getDivisionPolitica().getIdDipo() != null) ? empresaTmp
								.getDivisionPolitica().getIdDipo() : null);

				if (empresaTmp.getPersona() != null) {
					empresaDTO2.setIdPers_Persona(empresaTmp.getPersona()
							.getIdPers());
				} else {
					empresaDTO2.setIdPers_Persona(null);
				}

				empresaDTO2
						.setIdTiid_TipoIdentificacion((empresaTmp
								.getTipoIdentificacion().getIdTiid() != null) ? empresaTmp
								.getTipoIdentificacion().getIdTiid() : null);
				empresaDTO.add(empresaDTO2);
			}

			return empresaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Empresa getEmpresa(Long idEmpr) throws Exception {
		Empresa entity = null;

		try {
			entity = empresaDAO.findById(idEmpr);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Empresa");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Empresa> findPageEmpresa(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Empresa> entity = null;

		try {
			entity = empresaDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Empresa Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberEmpresa() throws Exception {
		Long entity = null;

		try {
			entity = empresaDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Empresa Count");
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
	public List<Empresa> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Empresa> list = new ArrayList<Empresa>();
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
			list = empresaDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
