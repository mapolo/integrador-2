package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.IOrdenesDeCompraDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.OrdenesDeCompra;
import co.edu.usbcali.modelo.dto.OrdenesDeCompraDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("OrdenesDeCompraLogic")
public class OrdenesDeCompraLogic implements IOrdenesDeCompraLogic {
	/**
	 * DAO injected by Spring that manages OrdenesDeCompra entities
	 * 
	 */
	@Autowired
	private IOrdenesDeCompraDAO ordenesDeCompraDAO;

	/**
	 * Logic injected by Spring that manages Documento entities
	 * 
	 */
	@Autowired
	IDocumentoLogic logicDocumento1;

	/**
	 * Logic injected by Spring that manages Empresa entities
	 * 
	 */
	@Autowired
	IEmpresaLogic logicEmpresa2;

	/**
	 * Logic injected by Spring that manages Persona entities
	 * 
	 */
	@Autowired
	IPersonaLogic logicPersona3;

	/**
	 * Logic injected by Spring that manages Referencia entities
	 * 
	 */
	@Autowired
	IReferenciaLogic logicReferencia4;

	/**
	 * Logic injected by Spring that manages Sucursal entities
	 * 
	 */
	@Autowired
	ISucursalLogic logicSucursal5;

	@Transactional(readOnly = true)
	public List<OrdenesDeCompra> getOrdenesDeCompra() throws Exception {
		List<OrdenesDeCompra> list = new ArrayList<OrdenesDeCompra>();

		try {
			list = ordenesDeCompraDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "OrdenesDeCompra");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveOrdenesDeCompra(OrdenesDeCompra entity) throws Exception {
		try {
			if (entity.getDocumento() == null) {
				throw new ZMessManager().new ForeignException("documento");
			}

			if (entity.getEmpresa() == null) {
				throw new ZMessManager().new ForeignException("empresa");
			}

			if (entity.getPersona() == null) {
				throw new ZMessManager().new ForeignException("persona");
			}

			if (entity.getReferencia() == null) {
				throw new ZMessManager().new ForeignException("referencia");
			}

			if (entity.getSucursal() == null) {
				throw new ZMessManager().new ForeignException("sucursal");
			}

			if ((entity.getCantidadPedida() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadPedida(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadPedida");
			}

			if ((entity.getCantidadRecibido() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadRecibido(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadRecibido");
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

			if (entity.getIdOrdc() == null) {
				throw new ZMessManager().new EmptyFieldException("idOrdc");
			}

			if ((entity.getIdOrdc() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdOrdc(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idOrdc");
			}

			if ((entity.getIva() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIva(), 5, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("iva");
			}

			if ((entity.getNumeroFactura() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNumeroFactura(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroFactura");
			}

			if ((entity.getNumeroPedido() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroPedido(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroPedido");
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

			if ((entity.getPorcentajeDescuento() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPorcentajeDescuento(), 5, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"porcentajeDescuento");
			}

			if ((entity.getPrecioUnitarioPedido() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPrecioUnitarioPedido(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"precioUnitarioPedido");
			}

			if ((entity.getPrecioUnitarioRecibdo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPrecioUnitarioRecibdo(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"precioUnitarioRecibdo");
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

			if (entity.getReferencia().getIdRefe() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idRefe_Referencia");
			}

			if ((entity.getReferencia().getIdRefe() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getReferencia().getIdRefe(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idRefe_Referencia");
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

			if (getOrdenesDeCompra(entity.getIdOrdc()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			ordenesDeCompraDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteOrdenesDeCompra(OrdenesDeCompra entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("OrdenesDeCompra");
		}

		if (entity.getIdOrdc() == null) {
			throw new ZMessManager().new EmptyFieldException("idOrdc");
		}

		try {
			ordenesDeCompraDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateOrdenesDeCompra(OrdenesDeCompra entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"OrdenesDeCompra");
			}

			if (entity.getDocumento() == null) {
				throw new ZMessManager().new ForeignException("documento");
			}

			if (entity.getEmpresa() == null) {
				throw new ZMessManager().new ForeignException("empresa");
			}

			if (entity.getPersona() == null) {
				throw new ZMessManager().new ForeignException("persona");
			}

			if (entity.getReferencia() == null) {
				throw new ZMessManager().new ForeignException("referencia");
			}

			if (entity.getSucursal() == null) {
				throw new ZMessManager().new ForeignException("sucursal");
			}

			if ((entity.getCantidadPedida() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadPedida(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadPedida");
			}

			if ((entity.getCantidadRecibido() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadRecibido(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadRecibido");
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

			if (entity.getIdOrdc() == null) {
				throw new ZMessManager().new EmptyFieldException("idOrdc");
			}

			if ((entity.getIdOrdc() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdOrdc(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idOrdc");
			}

			if ((entity.getIva() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIva(), 5, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("iva");
			}

			if ((entity.getNumeroFactura() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNumeroFactura(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroFactura");
			}

			if ((entity.getNumeroPedido() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroPedido(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroPedido");
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

			if ((entity.getPorcentajeDescuento() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPorcentajeDescuento(), 5, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"porcentajeDescuento");
			}

			if ((entity.getPrecioUnitarioPedido() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPrecioUnitarioPedido(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"precioUnitarioPedido");
			}

			if ((entity.getPrecioUnitarioRecibdo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPrecioUnitarioRecibdo(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"precioUnitarioRecibdo");
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

			if (entity.getReferencia().getIdRefe() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idRefe_Referencia");
			}

			if ((entity.getReferencia().getIdRefe() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getReferencia().getIdRefe(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idRefe_Referencia");
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

			ordenesDeCompraDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<OrdenesDeCompraDTO> getDataOrdenesDeCompra() throws Exception {
		try {
			List<OrdenesDeCompra> ordenesDeCompra = ordenesDeCompraDAO
					.findAll();

			List<OrdenesDeCompraDTO> ordenesDeCompraDTO = new ArrayList<OrdenesDeCompraDTO>();

			for (OrdenesDeCompra ordenesDeCompraTmp : ordenesDeCompra) {
				OrdenesDeCompraDTO ordenesDeCompraDTO2 = new OrdenesDeCompraDTO();

				ordenesDeCompraDTO2.setIdOrdc(ordenesDeCompraTmp.getIdOrdc());
				ordenesDeCompraDTO2.setCantidadPedida((ordenesDeCompraTmp
						.getCantidadPedida() != null) ? ordenesDeCompraTmp
						.getCantidadPedida() : null);
				ordenesDeCompraDTO2.setCantidadRecibido((ordenesDeCompraTmp
						.getCantidadRecibido() != null) ? ordenesDeCompraTmp
						.getCantidadRecibido() : null);
				ordenesDeCompraDTO2.setEstadoRegistro((ordenesDeCompraTmp
						.getEstadoRegistro() != null) ? ordenesDeCompraTmp
						.getEstadoRegistro() : null);
				ordenesDeCompraDTO2.setFechaCreacion(ordenesDeCompraTmp
						.getFechaCreacion());
				ordenesDeCompraDTO2.setFechaEntrega(ordenesDeCompraTmp
						.getFechaEntrega());
				ordenesDeCompraDTO2.setFechaModificacion(ordenesDeCompraTmp
						.getFechaModificacion());
				ordenesDeCompraDTO2.setFechaPedido(ordenesDeCompraTmp
						.getFechaPedido());
				ordenesDeCompraDTO2.setFechaRecibido(ordenesDeCompraTmp
						.getFechaRecibido());
				ordenesDeCompraDTO2
						.setIva((ordenesDeCompraTmp.getIva() != null) ? ordenesDeCompraTmp
								.getIva() : null);
				ordenesDeCompraDTO2.setNumeroFactura((ordenesDeCompraTmp
						.getNumeroFactura() != null) ? ordenesDeCompraTmp
						.getNumeroFactura() : null);
				ordenesDeCompraDTO2.setNumeroPedido((ordenesDeCompraTmp
						.getNumeroPedido() != null) ? ordenesDeCompraTmp
						.getNumeroPedido() : null);
				ordenesDeCompraDTO2.setOperCreador((ordenesDeCompraTmp
						.getOperCreador() != null) ? ordenesDeCompraTmp
						.getOperCreador() : null);
				ordenesDeCompraDTO2.setOperModifica((ordenesDeCompraTmp
						.getOperModifica() != null) ? ordenesDeCompraTmp
						.getOperModifica() : null);
				ordenesDeCompraDTO2.setPorcentajeDescuento((ordenesDeCompraTmp
						.getPorcentajeDescuento() != null) ? ordenesDeCompraTmp
						.getPorcentajeDescuento() : null);
				ordenesDeCompraDTO2
						.setPrecioUnitarioPedido((ordenesDeCompraTmp
								.getPrecioUnitarioPedido() != null) ? ordenesDeCompraTmp
								.getPrecioUnitarioPedido() : null);
				ordenesDeCompraDTO2
						.setPrecioUnitarioRecibdo((ordenesDeCompraTmp
								.getPrecioUnitarioRecibdo() != null) ? ordenesDeCompraTmp
								.getPrecioUnitarioRecibdo() : null);
				ordenesDeCompraDTO2
						.setIdDocu_Documento((ordenesDeCompraTmp.getDocumento()
								.getIdDocu() != null) ? ordenesDeCompraTmp
								.getDocumento().getIdDocu() : null);

				if (ordenesDeCompraTmp.getEmpresa() != null) {
					ordenesDeCompraDTO2.setIdEmpr_Empresa(ordenesDeCompraTmp
							.getEmpresa().getIdEmpr());
				} else {
					ordenesDeCompraDTO2.setIdEmpr_Empresa(null);
				}

				if (ordenesDeCompraTmp.getPersona() != null) {
					ordenesDeCompraDTO2.setIdPers_Persona(ordenesDeCompraTmp
							.getPersona().getIdPers());
				} else {
					ordenesDeCompraDTO2.setIdPers_Persona(null);
				}

				ordenesDeCompraDTO2
						.setIdRefe_Referencia((ordenesDeCompraTmp
								.getReferencia().getIdRefe() != null) ? ordenesDeCompraTmp
								.getReferencia().getIdRefe() : null);

				if (ordenesDeCompraTmp.getSucursal() != null) {
					ordenesDeCompraDTO2.setIdSucu_Sucursal(ordenesDeCompraTmp
							.getSucursal().getIdSucu());
				} else {
					ordenesDeCompraDTO2.setIdSucu_Sucursal(null);
				}

				ordenesDeCompraDTO.add(ordenesDeCompraDTO2);
			}

			return ordenesDeCompraDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public OrdenesDeCompra getOrdenesDeCompra(Long idOrdc) throws Exception {
		OrdenesDeCompra entity = null;

		try {
			entity = ordenesDeCompraDAO.findById(idOrdc);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("OrdenesDeCompra");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<OrdenesDeCompra> findPageOrdenesDeCompra(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<OrdenesDeCompra> entity = null;

		try {
			entity = ordenesDeCompraDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"OrdenesDeCompra Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberOrdenesDeCompra() throws Exception {
		Long entity = null;

		try {
			entity = ordenesDeCompraDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"OrdenesDeCompra Count");
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
	public List<OrdenesDeCompra> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<OrdenesDeCompra> list = new ArrayList<OrdenesDeCompra>();
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
			list = ordenesDeCompraDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
