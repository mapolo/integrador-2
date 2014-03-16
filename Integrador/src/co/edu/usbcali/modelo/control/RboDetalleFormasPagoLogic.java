package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.ICruceDAO;
import co.edu.usbcali.dataaccess.dao.IRboDetalleFormasPagoDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.Cruce;
import co.edu.usbcali.modelo.RboDetalleFormasPago;
import co.edu.usbcali.modelo.dto.RboDetalleFormasPagoDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("RboDetalleFormasPagoLogic")
public class RboDetalleFormasPagoLogic implements IRboDetalleFormasPagoLogic {
	/**
	 * DAO injected by Spring that manages RboDetalleFormasPago entities
	 * 
	 */
	@Autowired
	private IRboDetalleFormasPagoDAO rboDetalleFormasPagoDAO;

	/**
	 * DAO injected by Spring that manages Cruce entities
	 * 
	 */
	@Autowired
	private ICruceDAO cruceDAO;

	/**
	 * Logic injected by Spring that manages Banco entities
	 * 
	 */
	@Autowired
	IBancoLogic logicBanco1;

	/**
	 * Logic injected by Spring that manages ChequePosfechado entities
	 * 
	 */
	@Autowired
	IChequePosfechadoLogic logicChequePosfechado2;

	/**
	 * Logic injected by Spring that manages Documento entities
	 * 
	 */
	@Autowired
	IDocumentoLogic logicDocumento3;

	/**
	 * Logic injected by Spring that manages Recibo entities
	 * 
	 */
	@Autowired
	IReciboLogic logicRecibo4;

	/**
	 * Logic injected by Spring that manages TipoFormaPago entities
	 * 
	 */
	@Autowired
	ITipoFormaPagoLogic logicTipoFormaPago5;

	@Transactional(readOnly = true)
	public List<RboDetalleFormasPago> getRboDetalleFormasPago()
			throws Exception {
		List<RboDetalleFormasPago> list = new ArrayList<RboDetalleFormasPago>();

		try {
			list = rboDetalleFormasPagoDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "RboDetalleFormasPago");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveRboDetalleFormasPago(RboDetalleFormasPago entity)
			throws Exception {
		try {
			if (entity.getBanco() == null) {
				throw new ZMessManager().new ForeignException("banco");
			}

			if (entity.getChequePosfechado() == null) {
				throw new ZMessManager().new ForeignException(
						"chequePosfechado");
			}

			if (entity.getDocumento() == null) {
				throw new ZMessManager().new ForeignException("documento");
			}

			if (entity.getRecibo() == null) {
				throw new ZMessManager().new ForeignException("recibo");
			}

			if (entity.getTipoFormaPago() == null) {
				throw new ZMessManager().new ForeignException("tipoFormaPago");
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

			if (entity.getIdRdfp() == null) {
				throw new ZMessManager().new EmptyFieldException("idRdfp");
			}

			if ((entity.getIdRdfp() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdRdfp(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idRdfp");
			}

			if (entity.getMontoCancelado() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"montoCancelado");
			}

			if ((entity.getMontoCancelado() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMontoCancelado(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"montoCancelado");
			}

			if ((entity.getNumeroDocumeto() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNumeroDocumeto(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroDocumeto");
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

			if ((entity.getTransaccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getTransaccion(), 2) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"transaccion");
			}

			if (entity.getBanco().getIdBanc() == null) {
				throw new ZMessManager().new EmptyFieldException("idBanc_Banco");
			}

			if ((entity.getBanco().getIdBanc() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getBanco().getIdBanc(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idBanc_Banco");
			}

			if (entity.getChequePosfechado().getIdChps() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idChps_ChequePosfechado");
			}

			if ((entity.getChequePosfechado().getIdChps() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getChequePosfechado().getIdChps(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idChps_ChequePosfechado");
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

			if (entity.getRecibo().getIdRcbo() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idRcbo_Recibo");
			}

			if ((entity.getRecibo().getIdRcbo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getRecibo().getIdRcbo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idRcbo_Recibo");
			}

			if (entity.getTipoFormaPago().getIdTfpa() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idTfpa_TipoFormaPago");
			}

			if ((entity.getTipoFormaPago().getIdTfpa() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getTipoFormaPago().getIdTfpa(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idTfpa_TipoFormaPago");
			}

			if (getRboDetalleFormasPago(entity.getIdRdfp()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			rboDetalleFormasPagoDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteRboDetalleFormasPago(RboDetalleFormasPago entity)
			throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion(
					"RboDetalleFormasPago");
		}

		if (entity.getIdRdfp() == null) {
			throw new ZMessManager().new EmptyFieldException("idRdfp");
		}

		List<Cruce> cruces = null;

		try {
			cruces = cruceDAO.findByProperty("rboDetalleFormasPago.idRdfp",
					entity.getIdRdfp());

			if (Utilities.validationsList(cruces) == true) {
				throw new ZMessManager().new DeletingException("cruces");
			}

			rboDetalleFormasPagoDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateRboDetalleFormasPago(RboDetalleFormasPago entity)
			throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"RboDetalleFormasPago");
			}

			if (entity.getBanco() == null) {
				throw new ZMessManager().new ForeignException("banco");
			}

			if (entity.getChequePosfechado() == null) {
				throw new ZMessManager().new ForeignException(
						"chequePosfechado");
			}

			if (entity.getDocumento() == null) {
				throw new ZMessManager().new ForeignException("documento");
			}

			if (entity.getRecibo() == null) {
				throw new ZMessManager().new ForeignException("recibo");
			}

			if (entity.getTipoFormaPago() == null) {
				throw new ZMessManager().new ForeignException("tipoFormaPago");
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

			if (entity.getIdRdfp() == null) {
				throw new ZMessManager().new EmptyFieldException("idRdfp");
			}

			if ((entity.getIdRdfp() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdRdfp(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idRdfp");
			}

			if (entity.getMontoCancelado() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"montoCancelado");
			}

			if ((entity.getMontoCancelado() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMontoCancelado(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"montoCancelado");
			}

			if ((entity.getNumeroDocumeto() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNumeroDocumeto(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroDocumeto");
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

			if ((entity.getTransaccion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getTransaccion(), 2) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"transaccion");
			}

			if (entity.getBanco().getIdBanc() == null) {
				throw new ZMessManager().new EmptyFieldException("idBanc_Banco");
			}

			if ((entity.getBanco().getIdBanc() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getBanco().getIdBanc(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idBanc_Banco");
			}

			if (entity.getChequePosfechado().getIdChps() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idChps_ChequePosfechado");
			}

			if ((entity.getChequePosfechado().getIdChps() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getChequePosfechado().getIdChps(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idChps_ChequePosfechado");
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

			if (entity.getRecibo().getIdRcbo() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idRcbo_Recibo");
			}

			if ((entity.getRecibo().getIdRcbo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getRecibo().getIdRcbo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idRcbo_Recibo");
			}

			if (entity.getTipoFormaPago().getIdTfpa() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idTfpa_TipoFormaPago");
			}

			if ((entity.getTipoFormaPago().getIdTfpa() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getTipoFormaPago().getIdTfpa(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idTfpa_TipoFormaPago");
			}

			rboDetalleFormasPagoDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<RboDetalleFormasPagoDTO> getDataRboDetalleFormasPago()
			throws Exception {
		try {
			List<RboDetalleFormasPago> rboDetalleFormasPago = rboDetalleFormasPagoDAO
					.findAll();

			List<RboDetalleFormasPagoDTO> rboDetalleFormasPagoDTO = new ArrayList<RboDetalleFormasPagoDTO>();

			for (RboDetalleFormasPago rboDetalleFormasPagoTmp : rboDetalleFormasPago) {
				RboDetalleFormasPagoDTO rboDetalleFormasPagoDTO2 = new RboDetalleFormasPagoDTO();

				rboDetalleFormasPagoDTO2.setIdRdfp(rboDetalleFormasPagoTmp
						.getIdRdfp());
				rboDetalleFormasPagoDTO2
						.setEstadoRegistro((rboDetalleFormasPagoTmp
								.getEstadoRegistro() != null) ? rboDetalleFormasPagoTmp
								.getEstadoRegistro() : null);
				rboDetalleFormasPagoDTO2
						.setFechaConsignacion(rboDetalleFormasPagoTmp
								.getFechaConsignacion());
				rboDetalleFormasPagoDTO2
						.setFechaCreacion(rboDetalleFormasPagoTmp
								.getFechaCreacion());
				rboDetalleFormasPagoDTO2
						.setFechaModificacion(rboDetalleFormasPagoTmp
								.getFechaModificacion());
				rboDetalleFormasPagoDTO2
						.setMontoCancelado((rboDetalleFormasPagoTmp
								.getMontoCancelado() != null) ? rboDetalleFormasPagoTmp
								.getMontoCancelado() : null);
				rboDetalleFormasPagoDTO2
						.setNumeroDocumeto((rboDetalleFormasPagoTmp
								.getNumeroDocumeto() != null) ? rboDetalleFormasPagoTmp
								.getNumeroDocumeto() : null);
				rboDetalleFormasPagoDTO2
						.setOperCreador((rboDetalleFormasPagoTmp
								.getOperCreador() != null) ? rboDetalleFormasPagoTmp
								.getOperCreador() : null);
				rboDetalleFormasPagoDTO2
						.setOperModifica((rboDetalleFormasPagoTmp
								.getOperModifica() != null) ? rboDetalleFormasPagoTmp
								.getOperModifica() : null);
				rboDetalleFormasPagoDTO2
						.setTransaccion((rboDetalleFormasPagoTmp
								.getTransaccion() != null) ? rboDetalleFormasPagoTmp
								.getTransaccion() : null);

				if (rboDetalleFormasPagoTmp.getBanco() != null) {
					rboDetalleFormasPagoDTO2
							.setIdBanc_Banco(rboDetalleFormasPagoTmp.getBanco()
									.getIdBanc());
				} else {
					rboDetalleFormasPagoDTO2.setIdBanc_Banco(null);
				}

				rboDetalleFormasPagoDTO2
						.setIdChps_ChequePosfechado((rboDetalleFormasPagoTmp
								.getChequePosfechado().getIdChps() != null) ? rboDetalleFormasPagoTmp
								.getChequePosfechado().getIdChps() : null);

				if (rboDetalleFormasPagoTmp.getDocumento() != null) {
					rboDetalleFormasPagoDTO2
							.setIdDocu_Documento(rboDetalleFormasPagoTmp
									.getDocumento().getIdDocu());
				} else {
					rboDetalleFormasPagoDTO2.setIdDocu_Documento(null);
				}

				rboDetalleFormasPagoDTO2
						.setIdRcbo_Recibo((rboDetalleFormasPagoTmp.getRecibo()
								.getIdRcbo() != null) ? rboDetalleFormasPagoTmp
								.getRecibo().getIdRcbo() : null);
				rboDetalleFormasPagoDTO2
						.setIdTfpa_TipoFormaPago((rboDetalleFormasPagoTmp
								.getTipoFormaPago().getIdTfpa() != null) ? rboDetalleFormasPagoTmp
								.getTipoFormaPago().getIdTfpa() : null);
				rboDetalleFormasPagoDTO.add(rboDetalleFormasPagoDTO2);
			}

			return rboDetalleFormasPagoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public RboDetalleFormasPago getRboDetalleFormasPago(Long idRdfp)
			throws Exception {
		RboDetalleFormasPago entity = null;

		try {
			entity = rboDetalleFormasPagoDAO.findById(idRdfp);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"RboDetalleFormasPago");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<RboDetalleFormasPago> findPageRboDetalleFormasPago(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<RboDetalleFormasPago> entity = null;

		try {
			entity = rboDetalleFormasPagoDAO.findPage(sortColumnName,
					sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"RboDetalleFormasPago Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberRboDetalleFormasPago() throws Exception {
		Long entity = null;

		try {
			entity = rboDetalleFormasPagoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"RboDetalleFormasPago Count");
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
	public List<RboDetalleFormasPago> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<RboDetalleFormasPago> list = new ArrayList<RboDetalleFormasPago>();
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
			list = rboDetalleFormasPagoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
