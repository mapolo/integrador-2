package co.edu.usbcali.modelo.control;

import co.edu.usbcali.dataaccess.dao.*;
import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.MovimientoInventarioDTO;
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
@Service("MovimientoInventarioLogic")
public class MovimientoInventarioLogic implements IMovimientoInventarioLogic {
	/**
	 * DAO injected by Spring that manages MovimientoInventario entities
	 * 
	 */
	@Autowired
	private IMovimientoInventarioDAO movimientoInventarioDAO;

	/**
	 * DAO injected by Spring that manages MovimientoVendedor entities
	 * 
	 */
	@Autowired
	private IMovimientoVendedorDAO movimientoVendedorDAO;

	/**
	 * Logic injected by Spring that manages Causal entities
	 * 
	 */
	@Autowired
	ICausalLogic logicCausal1;

	/**
	 * Logic injected by Spring that manages Documento entities
	 * 
	 */
	@Autowired
	IDocumentoLogic logicDocumento2;

	/**
	 * Logic injected by Spring that manages ReferenciaSucursal entities
	 * 
	 */
	@Autowired
	IReferenciaSucursalLogic logicReferenciaSucursal3;

	/**
	 * Logic injected by Spring that manages Sucursal entities
	 * 
	 */
	@Autowired
	ISucursalLogic logicSucursal4;

	/**
	 * Logic injected by Spring that manages Sucursal entities
	 * 
	 */
	@Autowired
	ISucursalLogic logicSucursal5;

	@Transactional(readOnly = true)
	public List<MovimientoInventario> getMovimientoInventario()
			throws Exception {
		List<MovimientoInventario> list = new ArrayList<MovimientoInventario>();

		try {
			list = movimientoInventarioDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "MovimientoInventario");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveMovimientoInventario(MovimientoInventario entity)
			throws Exception {
		try {
			if (entity.getCausal() == null) {
				throw new ZMessManager().new ForeignException("causal");
			}

			if (entity.getDocumento() == null) {
				throw new ZMessManager().new ForeignException("documento");
			}

			if (entity.getReferenciaSucursal() == null) {
				throw new ZMessManager().new ForeignException(
						"referenciaSucursal");
			}

			if (entity.getSucursalBySucursalEntrega() == null) {
				throw new ZMessManager().new ForeignException(
						"sucursalBySucursalEntrega");
			}

			if (entity.getSucursalBySucursalRecibeEnvia() == null) {
				throw new ZMessManager().new ForeignException(
						"sucursalBySucursalRecibeEnvia");
			}

			if ((entity.getCantidad() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidad(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidad");
			}

			if ((entity.getClaseVenta() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getClaseVenta(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"claseVenta");
			}

			if ((entity.getCostoUnitario() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCostoUnitario(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"costoUnitario");
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

			if (entity.getIdMoin() == null) {
				throw new ZMessManager().new EmptyFieldException("idMoin");
			}

			if ((entity.getIdMoin() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdMoin(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idMoin");
			}

			if (entity.getNumeroRegistro() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"numeroRegistro");
			}

			if ((entity.getNumeroRegistro() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroRegistro(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroRegistro");
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

			if ((entity.getPlacaVehiculo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getPlacaVehiculo(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"placaVehiculo");
			}

			if ((entity.getPorcentajeIva() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPorcentajeIva(), 3, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"porcentajeIva");
			}

			if (entity.getReferencia() == null) {
				throw new ZMessManager().new EmptyFieldException("referencia");
			}

			if ((entity.getReferencia() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getReferencia(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"referencia");
			}

			if (entity.getValorTotal() == null) {
				throw new ZMessManager().new EmptyFieldException("valorTotal");
			}

			if ((entity.getValorTotal() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getValorTotal(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"valorTotal");
			}

			if (entity.getCausal().getIdCusa() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idCusa_Causal");
			}

			if ((entity.getCausal().getIdCusa() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCausal().getIdCusa(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idCusa_Causal");
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

			if (entity.getReferenciaSucursal().getIdResu() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idResu_ReferenciaSucursal");
			}

			if ((entity.getReferenciaSucursal().getIdResu() != null)
					&& (Utilities
							.checkNumberAndCheckWithPrecisionAndScale(""
									+ entity.getReferenciaSucursal()
											.getIdResu(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idResu_ReferenciaSucursal");
			}

			if (getMovimientoInventario(entity.getIdMoin()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			movimientoInventarioDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteMovimientoInventario(MovimientoInventario entity)
			throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion(
					"MovimientoInventario");
		}

		if (entity.getIdMoin() == null) {
			throw new ZMessManager().new EmptyFieldException("idMoin");
		}

		List<MovimientoVendedor> movimientoVendedors = null;

		try {
			movimientoVendedors = movimientoVendedorDAO.findByProperty(
					"movimientoInventario.idMoin", entity.getIdMoin());

			if (Utilities.validationsList(movimientoVendedors) == true) {
				throw new ZMessManager().new DeletingException(
						"movimientoVendedors");
			}

			movimientoInventarioDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateMovimientoInventario(MovimientoInventario entity)
			throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"MovimientoInventario");
			}

			if (entity.getCausal() == null) {
				throw new ZMessManager().new ForeignException("causal");
			}

			if (entity.getDocumento() == null) {
				throw new ZMessManager().new ForeignException("documento");
			}

			if (entity.getReferenciaSucursal() == null) {
				throw new ZMessManager().new ForeignException(
						"referenciaSucursal");
			}

			if (entity.getSucursalBySucursalEntrega() == null) {
				throw new ZMessManager().new ForeignException(
						"sucursalBySucursalEntrega");
			}

			if (entity.getSucursalBySucursalRecibeEnvia() == null) {
				throw new ZMessManager().new ForeignException(
						"sucursalBySucursalRecibeEnvia");
			}

			if ((entity.getCantidad() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidad(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("cantidad");
			}

			if ((entity.getClaseVenta() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getClaseVenta(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"claseVenta");
			}

			if ((entity.getCostoUnitario() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCostoUnitario(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"costoUnitario");
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

			if (entity.getIdMoin() == null) {
				throw new ZMessManager().new EmptyFieldException("idMoin");
			}

			if ((entity.getIdMoin() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdMoin(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idMoin");
			}

			if (entity.getNumeroRegistro() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"numeroRegistro");
			}

			if ((entity.getNumeroRegistro() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroRegistro(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroRegistro");
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

			if ((entity.getPlacaVehiculo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getPlacaVehiculo(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"placaVehiculo");
			}

			if ((entity.getPorcentajeIva() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPorcentajeIva(), 3, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"porcentajeIva");
			}

			if (entity.getReferencia() == null) {
				throw new ZMessManager().new EmptyFieldException("referencia");
			}

			if ((entity.getReferencia() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getReferencia(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"referencia");
			}

			if (entity.getValorTotal() == null) {
				throw new ZMessManager().new EmptyFieldException("valorTotal");
			}

			if ((entity.getValorTotal() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getValorTotal(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"valorTotal");
			}

			if (entity.getCausal().getIdCusa() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idCusa_Causal");
			}

			if ((entity.getCausal().getIdCusa() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCausal().getIdCusa(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idCusa_Causal");
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

			if (entity.getReferenciaSucursal().getIdResu() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idResu_ReferenciaSucursal");
			}

			if ((entity.getReferenciaSucursal().getIdResu() != null)
					&& (Utilities
							.checkNumberAndCheckWithPrecisionAndScale(""
									+ entity.getReferenciaSucursal()
											.getIdResu(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idResu_ReferenciaSucursal");
			}

			movimientoInventarioDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<MovimientoInventarioDTO> getDataMovimientoInventario()
			throws Exception {
		try {
			List<MovimientoInventario> movimientoInventario = movimientoInventarioDAO
					.findAll();

			List<MovimientoInventarioDTO> movimientoInventarioDTO = new ArrayList<MovimientoInventarioDTO>();

			for (MovimientoInventario movimientoInventarioTmp : movimientoInventario) {
				MovimientoInventarioDTO movimientoInventarioDTO2 = new MovimientoInventarioDTO();

				movimientoInventarioDTO2.setIdMoin(movimientoInventarioTmp
						.getIdMoin());
				movimientoInventarioDTO2.setCantidad((movimientoInventarioTmp
						.getCantidad() != null) ? movimientoInventarioTmp
						.getCantidad() : null);
				movimientoInventarioDTO2.setClaseVenta((movimientoInventarioTmp
						.getClaseVenta() != null) ? movimientoInventarioTmp
						.getClaseVenta() : null);
				movimientoInventarioDTO2
						.setCostoUnitario((movimientoInventarioTmp
								.getCostoUnitario() != null) ? movimientoInventarioTmp
								.getCostoUnitario() : null);
				movimientoInventarioDTO2
						.setEstadoRegistro((movimientoInventarioTmp
								.getEstadoRegistro() != null) ? movimientoInventarioTmp
								.getEstadoRegistro() : null);
				movimientoInventarioDTO2
						.setFechaCreacion(movimientoInventarioTmp
								.getFechaCreacion());
				movimientoInventarioDTO2
						.setFechaModificacion(movimientoInventarioTmp
								.getFechaModificacion());
				movimientoInventarioDTO2
						.setFechaMovimiento(movimientoInventarioTmp
								.getFechaMovimiento());
				movimientoInventarioDTO2
						.setNumeroRegistro((movimientoInventarioTmp
								.getNumeroRegistro() != null) ? movimientoInventarioTmp
								.getNumeroRegistro() : null);
				movimientoInventarioDTO2
						.setOperCreador((movimientoInventarioTmp
								.getOperCreador() != null) ? movimientoInventarioTmp
								.getOperCreador() : null);
				movimientoInventarioDTO2
						.setOperModifica((movimientoInventarioTmp
								.getOperModifica() != null) ? movimientoInventarioTmp
								.getOperModifica() : null);
				movimientoInventarioDTO2
						.setPlacaVehiculo((movimientoInventarioTmp
								.getPlacaVehiculo() != null) ? movimientoInventarioTmp
								.getPlacaVehiculo() : null);
				movimientoInventarioDTO2
						.setPorcentajeIva((movimientoInventarioTmp
								.getPorcentajeIva() != null) ? movimientoInventarioTmp
								.getPorcentajeIva() : null);
				movimientoInventarioDTO2.setReferencia((movimientoInventarioTmp
						.getReferencia() != null) ? movimientoInventarioTmp
						.getReferencia() : null);
				movimientoInventarioDTO2.setValorTotal((movimientoInventarioTmp
						.getValorTotal() != null) ? movimientoInventarioTmp
						.getValorTotal() : null);

				if (movimientoInventarioTmp.getCausal() != null) {
					movimientoInventarioDTO2
							.setIdCusa_Causal(movimientoInventarioTmp
									.getCausal().getIdCusa());
				} else {
					movimientoInventarioDTO2.setIdCusa_Causal(null);
				}

				movimientoInventarioDTO2
						.setIdDocu_Documento((movimientoInventarioTmp
								.getDocumento().getIdDocu() != null) ? movimientoInventarioTmp
								.getDocumento().getIdDocu() : null);
				movimientoInventarioDTO2
						.setIdResu_ReferenciaSucursal((movimientoInventarioTmp
								.getReferenciaSucursal().getIdResu() != null) ? movimientoInventarioTmp
								.getReferenciaSucursal().getIdResu() : null);

				movimientoInventarioDTO.add(movimientoInventarioDTO2);
			}

			return movimientoInventarioDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public MovimientoInventario getMovimientoInventario(Long idMoin)
			throws Exception {
		MovimientoInventario entity = null;

		try {
			entity = movimientoInventarioDAO.findById(idMoin);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"MovimientoInventario");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<MovimientoInventario> findPageMovimientoInventario(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<MovimientoInventario> entity = null;

		try {
			entity = movimientoInventarioDAO.findPage(sortColumnName,
					sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"MovimientoInventario Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberMovimientoInventario() throws Exception {
		Long entity = null;

		try {
			entity = movimientoInventarioDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"MovimientoInventario Count");
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
	public List<MovimientoInventario> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<MovimientoInventario> list = new ArrayList<MovimientoInventario>();
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
			list = movimientoInventarioDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
