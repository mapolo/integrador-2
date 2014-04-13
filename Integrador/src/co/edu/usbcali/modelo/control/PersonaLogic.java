package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.IClienteDAO;
import co.edu.usbcali.dataaccess.dao.IDescuentoComercialDAO;
import co.edu.usbcali.dataaccess.dao.IEmpresaDAO;
import co.edu.usbcali.dataaccess.dao.IListaPreciosEspecialesDAO;
import co.edu.usbcali.dataaccess.dao.IOrdenesDeCompraDAO;
import co.edu.usbcali.dataaccess.dao.IPersonaDAO;
import co.edu.usbcali.dataaccess.dao.IProveedorDAO;
import co.edu.usbcali.dataaccess.dao.IRelacionComercialDAO;
import co.edu.usbcali.dataaccess.dao.ISucursalDAO;
import co.edu.usbcali.dataaccess.dao.IVendedorDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.Cliente;
import co.edu.usbcali.modelo.DescuentoComercial;
import co.edu.usbcali.modelo.Empresa;
import co.edu.usbcali.modelo.ListaPreciosEspeciales;
import co.edu.usbcali.modelo.OrdenesDeCompra;
import co.edu.usbcali.modelo.Persona;
import co.edu.usbcali.modelo.Proveedor;
import co.edu.usbcali.modelo.RelacionComercial;
import co.edu.usbcali.modelo.Sucursal;
import co.edu.usbcali.modelo.Vendedor;
import co.edu.usbcali.modelo.dto.EmpresaDTO;
import co.edu.usbcali.modelo.dto.PersonaDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("PersonaLogic")
public class PersonaLogic implements IPersonaLogic {
	/**
	 * DAO injected by Spring that manages Persona entities
	 * 
	 */
	@Autowired
	private IPersonaDAO personaDAO;

	/**
	 * DAO injected by Spring that manages Cliente entities
	 * 
	 */
	@Autowired
	private IClienteDAO clienteDAO;

	/**
	 * DAO injected by Spring that manages DescuentoComercial entities
	 * 
	 */
	@Autowired
	private IDescuentoComercialDAO descuentoComercialDAO;

	/**
	 * DAO injected by Spring that manages Empresa entities
	 * 
	 */
	@Autowired
	private IEmpresaDAO empresaDAO;

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
	 * DAO injected by Spring that manages Vendedor entities
	 * 
	 */
	@Autowired
	private IVendedorDAO vendedorDAO;

	/**
	 * Logic injected by Spring that manages DivisionPolitica entities
	 * 
	 */
	@Autowired
	IDivisionPoliticaLogic logicDivisionPolitica1;

	/**
	 * Logic injected by Spring that manages TipoIdentificacion entities
	 * 
	 */
	@Autowired
	ITipoIdentificacionLogic logicTipoIdentificacion2;

	@Transactional(readOnly = true)
	public List<Persona> getPersona() throws Exception {
		List<Persona> list = new ArrayList<Persona>();

		try {
			list = personaDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "Persona");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void savePersona(Persona entity) throws Exception {
		try {
			/*if (entity.getDivisionPolitica() == null) {
				throw new ZMessManager().new ForeignException(
						"divisionPolitica");
			}*/

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

			if ((entity.getDigitoVerificacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getDigitoVerificacion(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"digitoVerificacion");
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

			if ((entity.getEstadoPersona() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getEstadoPersona(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"estadoPersona");
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

			if ((entity.getPrimerApellido() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getPrimerApellido(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"primerApellido");
			}

			if (entity.getPrimerNombre() == null) {
				throw new ZMessManager().new EmptyFieldException("primerNombre");
			}

			if ((entity.getPrimerNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getPrimerNombre(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"primerNombre");
			}

			if ((entity.getSegundoApellido() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getSegundoApellido(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"segundoApellido");
			}

			if ((entity.getSegundoNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getSegundoNombre(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"segundoNombre");
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

			/*if (entity.getDivisionPolitica().getIdDipo() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idDipo_DivisionPolitica");
			}*/

			if ((entity.getDivisionPolitica() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDivisionPolitica().getIdDipo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idDipo_DivisionPolitica");
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

			
			personaDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deletePersona(Persona entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Persona");
		}

		if (entity.getIdPers() == null) {
			throw new ZMessManager().new EmptyFieldException("idPers");
		}

		List<Cliente> clientes = null;
		List<DescuentoComercial> descuentoComercials = null;
		List<Empresa> empresas = null;
		List<ListaPreciosEspeciales> listaPreciosEspecialeses = null;
		List<OrdenesDeCompra> ordenesDeCompras = null;
		List<Proveedor> proveedors = null;
		List<RelacionComercial> relacionComercials = null;
		List<Sucursal> sucursals = null;
		List<Vendedor> vendedors = null;

		try {
			clientes = clienteDAO.findByProperty("persona.idPers",
					entity.getIdPers());

			if (Utilities.validationsList(clientes) == true) {
				throw new ZMessManager().new DeletingException("clientes");
			}

			descuentoComercials = descuentoComercialDAO.findByProperty(
					"persona.idPers", entity.getIdPers());

			if (Utilities.validationsList(descuentoComercials) == true) {
				throw new ZMessManager().new DeletingException(
						"descuentoComercials");
			}

			empresas = empresaDAO.findByProperty("persona.idPers",
					entity.getIdPers());

			if (Utilities.validationsList(empresas) == true) {
				throw new ZMessManager().new DeletingException("empresas");
			}

			listaPreciosEspecialeses = listaPreciosEspecialesDAO
					.findByProperty("persona.idPers", entity.getIdPers());

			if (Utilities.validationsList(listaPreciosEspecialeses) == true) {
				throw new ZMessManager().new DeletingException(
						"listaPreciosEspecialeses");
			}

			ordenesDeCompras = ordenesDeCompraDAO.findByProperty(
					"persona.idPers", entity.getIdPers());

			if (Utilities.validationsList(ordenesDeCompras) == true) {
				throw new ZMessManager().new DeletingException(
						"ordenesDeCompras");
			}

			proveedors = proveedorDAO.findByProperty("persona.idPers",
					entity.getIdPers());

			if (Utilities.validationsList(proveedors) == true) {
				throw new ZMessManager().new DeletingException("proveedors");
			}

			relacionComercials = relacionComercialDAO.findByProperty(
					"persona.idPers", entity.getIdPers());

			if (Utilities.validationsList(relacionComercials) == true) {
				throw new ZMessManager().new DeletingException(
						"relacionComercials");
			}

			sucursals = sucursalDAO.findByProperty("persona.idPers",
					entity.getIdPers());

			if (Utilities.validationsList(sucursals) == true) {
				throw new ZMessManager().new DeletingException("sucursals");
			}

			vendedors = vendedorDAO.findByProperty("persona.idPers",
					entity.getIdPers());

			if (Utilities.validationsList(vendedors) == true) {
				throw new ZMessManager().new DeletingException("vendedors");
			}

			personaDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updatePersona(Persona entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Persona");
			}

			/*if (entity.getDivisionPolitica() == null) {
				throw new ZMessManager().new ForeignException(
						"divisionPolitica");
			}*/

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

			if ((entity.getDigitoVerificacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getDigitoVerificacion(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"digitoVerificacion");
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

			if ((entity.getEstadoPersona() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getEstadoPersona(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"estadoPersona");
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

			if (entity.getIdPers() == null) {
				throw new ZMessManager().new EmptyFieldException("idPers");
			}

			if ((entity.getIdPers() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdPers(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idPers");
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

			if ((entity.getPrimerApellido() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getPrimerApellido(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"primerApellido");
			}

			if (entity.getPrimerNombre() == null) {
				throw new ZMessManager().new EmptyFieldException("primerNombre");
			}

			if ((entity.getPrimerNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getPrimerNombre(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"primerNombre");
			}

			if ((entity.getSegundoApellido() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getSegundoApellido(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"segundoApellido");
			}

			if ((entity.getSegundoNombre() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getSegundoNombre(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"segundoNombre");
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

			/*if (entity.getDivisionPolitica().getIdDipo() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idDipo_DivisionPolitica");
			}*/

			if ((entity.getDivisionPolitica() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDivisionPolitica().getIdDipo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idDipo_DivisionPolitica");
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

			personaDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<PersonaDTO> getDataPersona() throws Exception {
		try {
			List<Persona> persona = personaDAO.findAll();

			List<PersonaDTO> personaDTO = new ArrayList<PersonaDTO>();

			for (Persona personaTmp : persona) {
				PersonaDTO personaDTO2 = new PersonaDTO();

				personaDTO2.setIdPers(personaTmp.getIdPers());
				personaDTO2
						.setApartadoAereo((personaTmp.getApartadoAereo() != null) ? personaTmp
								.getApartadoAereo() : null);
				personaDTO2.setDigitoVerificacion((personaTmp
						.getDigitoVerificacion() != null) ? personaTmp
						.getDigitoVerificacion() : null);
				personaDTO2
						.setDireccion((personaTmp.getDireccion() != null) ? personaTmp
								.getDireccion() : null);
				personaDTO2
						.setEmail((personaTmp.getEmail() != null) ? personaTmp
								.getEmail() : null);
				personaDTO2
						.setEstadoPersona((personaTmp.getEstadoPersona() != null) ? personaTmp
								.getEstadoPersona() : null);
				personaDTO2
						.setEstadoRegistro((personaTmp.getEstadoRegistro() != null) ? personaTmp
								.getEstadoRegistro() : null);
				personaDTO2.setFechaCreacion(personaTmp.getFechaCreacion());
				personaDTO2.setFechaModificacion(personaTmp
						.getFechaModificacion());
				personaDTO2
						.setIdentificacion((personaTmp.getIdentificacion() != null) ? personaTmp
								.getIdentificacion() : null);
				personaDTO2
						.setOperCreador((personaTmp.getOperCreador() != null) ? personaTmp
								.getOperCreador() : null);
				personaDTO2
						.setOperModifica((personaTmp.getOperModifica() != null) ? personaTmp
								.getOperModifica() : null);
				personaDTO2
						.setPrimerApellido((personaTmp.getPrimerApellido() != null) ? personaTmp
								.getPrimerApellido() : null);
				personaDTO2
						.setPrimerNombre((personaTmp.getPrimerNombre() != null) ? personaTmp
								.getPrimerNombre() : null);
				personaDTO2
						.setSegundoApellido((personaTmp.getSegundoApellido() != null) ? personaTmp
								.getSegundoApellido() : null);
				personaDTO2
						.setSegundoNombre((personaTmp.getSegundoNombre() != null) ? personaTmp
								.getSegundoNombre() : null);
				personaDTO2
						.setTelefono1((personaTmp.getTelefono1() != null) ? personaTmp
								.getTelefono1() : null);
				personaDTO2
						.setTelefono2((personaTmp.getTelefono2() != null) ? personaTmp
								.getTelefono2() : null);
				
				
				/*if (personaTmp.getDivisionPolitica() != null) {
					personaDTO2
					.setIdDipo_DivisionPolitica((personaTmp
							.getDivisionPolitica().getIdDipo() != null) ? personaTmp
							.getDivisionPolitica().getIdDipo() : null);
				}*/
				if (personaTmp.getDivisionPolitica() != null) {
					personaDTO2.setIdDipo_DivisionPolitica(personaTmp.getDivisionPolitica()
							.getIdDipo());
					
				}else {
					personaDTO2.setIdDipo_DivisionPolitica(null);
				}
				
				
				
				
				personaDTO2
						.setIdTiid_TipoIdentificacion((personaTmp
								.getTipoIdentificacion().getIdTiid() != null) ? personaTmp
								.getTipoIdentificacion().getIdTiid() : null);
				
				
				
				
				personaDTO.add(personaDTO2);
			}

			return personaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Persona getPersona(Long idPers) throws Exception {
		Persona entity = null;

		try {
			entity = personaDAO.findById(idPers);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Persona");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Persona> findPagePersona(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Persona> entity = null;

		try {
			entity = personaDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Persona Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberPersona() throws Exception {
		Long entity = null;

		try {
			entity = personaDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Persona Count");
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
	public List<Persona> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Persona> list = new ArrayList<Persona>();
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
			list = personaDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
