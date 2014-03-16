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
import co.edu.usbcali.dataaccess.dao.IRboDetalleDocumentosDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.Cruce;
import co.edu.usbcali.modelo.RboDetalleDocumentos;
import co.edu.usbcali.modelo.dto.RboDetalleDocumentosDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("RboDetalleDocumentosLogic")
public class RboDetalleDocumentosLogic implements IRboDetalleDocumentosLogic {
	/**
	 * DAO injected by Spring that manages RboDetalleDocumentos entities
	 * 
	 */
	@Autowired
	private IRboDetalleDocumentosDAO rboDetalleDocumentosDAO;

	/**
	 * DAO injected by Spring that manages Cruce entities
	 * 
	 */
	@Autowired
	private ICruceDAO cruceDAO;

	/**
	 * Logic injected by Spring that manages Cartera entities
	 * 
	 */
	@Autowired
	ICarteraLogic logicCartera1;

	/**
	 * Logic injected by Spring that manages ConceptoRecibo entities
	 * 
	 */
	@Autowired
	IConceptoReciboLogic logicConceptoRecibo2;

	/**
	 * Logic injected by Spring that manages DistribucionCartera entities
	 * 
	 */
	@Autowired
	IDistribucionCarteraLogic logicDistribucionCartera3;

	/**
	 * Logic injected by Spring that manages Documento entities
	 * 
	 */
	@Autowired
	IDocumentoLogic logicDocumento4;

	/**
	 * Logic injected by Spring that manages Recibo entities
	 * 
	 */
	@Autowired
	IReciboLogic logicRecibo5;

	/**
	 * Logic injected by Spring that manages Sucursal entities
	 * 
	 */
	@Autowired
	ISucursalLogic logicSucursal6;

	/**
	 * Logic injected by Spring that manages UnidadVenta entities
	 * 
	 */
	@Autowired
	IUnidadVentaLogic logicUnidadVenta7;

	@Transactional(readOnly = true)
	public List<RboDetalleDocumentos> getRboDetalleDocumentos()
			throws Exception {
		List<RboDetalleDocumentos> list = new ArrayList<RboDetalleDocumentos>();

		try {
			list = rboDetalleDocumentosDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "RboDetalleDocumentos");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveRboDetalleDocumentos(RboDetalleDocumentos entity)
			throws Exception {
		try {
			if (entity.getCartera() == null) {
				throw new ZMessManager().new ForeignException("cartera");
			}

			if (entity.getConceptoRecibo() == null) {
				throw new ZMessManager().new ForeignException("conceptoRecibo");
			}

			if (entity.getDistribucionCartera() == null) {
				throw new ZMessManager().new ForeignException(
						"distribucionCartera");
			}

			if (entity.getDocumento() == null) {
				throw new ZMessManager().new ForeignException("documento");
			}

			if (entity.getRecibo() == null) {
				throw new ZMessManager().new ForeignException("recibo");
			}

			if (entity.getSucursal() == null) {
				throw new ZMessManager().new ForeignException("sucursal");
			}

			if (entity.getUnidadVenta() == null) {
				throw new ZMessManager().new ForeignException("unidadVenta");
			}

			if (entity.getDebitoCredito() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"debitoCredito");
			}

			if ((entity.getDebitoCredito() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getDebitoCredito(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"debitoCredito");
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

			if (entity.getIdRddo() == null) {
				throw new ZMessManager().new EmptyFieldException("idRddo");
			}

			if ((entity.getIdRddo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdRddo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idRddo");
			}

			if ((entity.getLineaFamilia() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getLineaFamilia(), 2) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"lineaFamilia");
			}

			if ((entity.getMontoAbonado() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMontoAbonado(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"montoAbonado");
			}

			if ((entity.getNumeroAbono() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroAbono(), 3, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroAbono");
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

			if ((entity.getValorDescuento() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getValorDescuento(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"valorDescuento");
			}

			if (entity.getCartera().getIdCart() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idCart_Cartera");
			}

			if ((entity.getCartera().getIdCart() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCartera().getIdCart(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idCart_Cartera");
			}

			if (entity.getConceptoRecibo().getIdCpto() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idCpto_ConceptoRecibo");
			}

			if ((entity.getConceptoRecibo().getIdCpto() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getConceptoRecibo().getIdCpto(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idCpto_ConceptoRecibo");
			}

			if (entity.getDistribucionCartera().getIdDica() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idDica_DistribucionCartera");
			}

			if ((entity.getDistribucionCartera().getIdDica() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDistribucionCartera().getIdDica(), 10,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idDica_DistribucionCartera");
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

			if (getRboDetalleDocumentos(entity.getIdRddo()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			rboDetalleDocumentosDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteRboDetalleDocumentos(RboDetalleDocumentos entity)
			throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion(
					"RboDetalleDocumentos");
		}

		if (entity.getIdRddo() == null) {
			throw new ZMessManager().new EmptyFieldException("idRddo");
		}

		List<Cruce> cruces = null;

		try {
			cruces = cruceDAO.findByProperty("rboDetalleDocumentos.idRddo",
					entity.getIdRddo());

			if (Utilities.validationsList(cruces) == true) {
				throw new ZMessManager().new DeletingException("cruces");
			}

			rboDetalleDocumentosDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateRboDetalleDocumentos(RboDetalleDocumentos entity)
			throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"RboDetalleDocumentos");
			}

			if (entity.getCartera() == null) {
				throw new ZMessManager().new ForeignException("cartera");
			}

			if (entity.getConceptoRecibo() == null) {
				throw new ZMessManager().new ForeignException("conceptoRecibo");
			}

			if (entity.getDistribucionCartera() == null) {
				throw new ZMessManager().new ForeignException(
						"distribucionCartera");
			}

			if (entity.getDocumento() == null) {
				throw new ZMessManager().new ForeignException("documento");
			}

			if (entity.getRecibo() == null) {
				throw new ZMessManager().new ForeignException("recibo");
			}

			if (entity.getSucursal() == null) {
				throw new ZMessManager().new ForeignException("sucursal");
			}

			if (entity.getUnidadVenta() == null) {
				throw new ZMessManager().new ForeignException("unidadVenta");
			}

			if (entity.getDebitoCredito() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"debitoCredito");
			}

			if ((entity.getDebitoCredito() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getDebitoCredito(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"debitoCredito");
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

			if (entity.getIdRddo() == null) {
				throw new ZMessManager().new EmptyFieldException("idRddo");
			}

			if ((entity.getIdRddo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdRddo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idRddo");
			}

			if ((entity.getLineaFamilia() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getLineaFamilia(), 2) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"lineaFamilia");
			}

			if ((entity.getMontoAbonado() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMontoAbonado(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"montoAbonado");
			}

			if ((entity.getNumeroAbono() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroAbono(), 3, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroAbono");
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

			if ((entity.getValorDescuento() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getValorDescuento(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"valorDescuento");
			}

			if (entity.getCartera().getIdCart() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idCart_Cartera");
			}

			if ((entity.getCartera().getIdCart() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCartera().getIdCart(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idCart_Cartera");
			}

			if (entity.getConceptoRecibo().getIdCpto() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idCpto_ConceptoRecibo");
			}

			if ((entity.getConceptoRecibo().getIdCpto() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getConceptoRecibo().getIdCpto(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idCpto_ConceptoRecibo");
			}

			if (entity.getDistribucionCartera().getIdDica() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idDica_DistribucionCartera");
			}

			if ((entity.getDistribucionCartera().getIdDica() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDistribucionCartera().getIdDica(), 10,
							0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idDica_DistribucionCartera");
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

			rboDetalleDocumentosDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<RboDetalleDocumentosDTO> getDataRboDetalleDocumentos()
			throws Exception {
		try {
			List<RboDetalleDocumentos> rboDetalleDocumentos = rboDetalleDocumentosDAO
					.findAll();

			List<RboDetalleDocumentosDTO> rboDetalleDocumentosDTO = new ArrayList<RboDetalleDocumentosDTO>();

			for (RboDetalleDocumentos rboDetalleDocumentosTmp : rboDetalleDocumentos) {
				RboDetalleDocumentosDTO rboDetalleDocumentosDTO2 = new RboDetalleDocumentosDTO();

				rboDetalleDocumentosDTO2.setIdRddo(rboDetalleDocumentosTmp
						.getIdRddo());
				rboDetalleDocumentosDTO2
						.setDebitoCredito((rboDetalleDocumentosTmp
								.getDebitoCredito() != null) ? rboDetalleDocumentosTmp
								.getDebitoCredito() : null);
				rboDetalleDocumentosDTO2
						.setEstadoRegistro((rboDetalleDocumentosTmp
								.getEstadoRegistro() != null) ? rboDetalleDocumentosTmp
								.getEstadoRegistro() : null);
				rboDetalleDocumentosDTO2
						.setFechaCreacion(rboDetalleDocumentosTmp
								.getFechaCreacion());
				rboDetalleDocumentosDTO2
						.setFechaModificacion(rboDetalleDocumentosTmp
								.getFechaModificacion());
				rboDetalleDocumentosDTO2
						.setLineaFamilia((rboDetalleDocumentosTmp
								.getLineaFamilia() != null) ? rboDetalleDocumentosTmp
								.getLineaFamilia() : null);
				rboDetalleDocumentosDTO2
						.setMontoAbonado((rboDetalleDocumentosTmp
								.getMontoAbonado() != null) ? rboDetalleDocumentosTmp
								.getMontoAbonado() : null);
				rboDetalleDocumentosDTO2
						.setNumeroAbono((rboDetalleDocumentosTmp
								.getNumeroAbono() != null) ? rboDetalleDocumentosTmp
								.getNumeroAbono() : null);
				rboDetalleDocumentosDTO2
						.setNumeroRegistro((rboDetalleDocumentosTmp
								.getNumeroRegistro() != null) ? rboDetalleDocumentosTmp
								.getNumeroRegistro() : null);
				rboDetalleDocumentosDTO2
						.setOperCreador((rboDetalleDocumentosTmp
								.getOperCreador() != null) ? rboDetalleDocumentosTmp
								.getOperCreador() : null);
				rboDetalleDocumentosDTO2
						.setOperModifica((rboDetalleDocumentosTmp
								.getOperModifica() != null) ? rboDetalleDocumentosTmp
								.getOperModifica() : null);
				rboDetalleDocumentosDTO2
						.setValorDescuento((rboDetalleDocumentosTmp
								.getValorDescuento() != null) ? rboDetalleDocumentosTmp
								.getValorDescuento() : null);

				if (rboDetalleDocumentosTmp.getCartera() != null) {
					rboDetalleDocumentosDTO2
							.setIdCart_Cartera(rboDetalleDocumentosTmp
									.getCartera().getIdCart());
				} else {
					rboDetalleDocumentosDTO2.setIdCart_Cartera(null);
				}

				rboDetalleDocumentosDTO2
						.setIdCpto_ConceptoRecibo((rboDetalleDocumentosTmp
								.getConceptoRecibo().getIdCpto() != null) ? rboDetalleDocumentosTmp
								.getConceptoRecibo().getIdCpto() : null);
				rboDetalleDocumentosDTO2
						.setIdDica_DistribucionCartera((rboDetalleDocumentosTmp
								.getDistribucionCartera().getIdDica() != null) ? rboDetalleDocumentosTmp
								.getDistribucionCartera().getIdDica() : null);

				if (rboDetalleDocumentosTmp.getDocumento() != null) {
					rboDetalleDocumentosDTO2
							.setIdDocu_Documento(rboDetalleDocumentosTmp
									.getDocumento().getIdDocu());
				} else {
					rboDetalleDocumentosDTO2.setIdDocu_Documento(null);
				}

				rboDetalleDocumentosDTO2
						.setIdRcbo_Recibo((rboDetalleDocumentosTmp.getRecibo()
								.getIdRcbo() != null) ? rboDetalleDocumentosTmp
								.getRecibo().getIdRcbo() : null);

				if (rboDetalleDocumentosTmp.getSucursal() != null) {
					rboDetalleDocumentosDTO2
							.setIdSucu_Sucursal(rboDetalleDocumentosTmp
									.getSucursal().getIdSucu());
				} else {
					rboDetalleDocumentosDTO2.setIdSucu_Sucursal(null);
				}

				rboDetalleDocumentosDTO2
						.setIdUnve_UnidadVenta((rboDetalleDocumentosTmp
								.getUnidadVenta().getIdUnve() != null) ? rboDetalleDocumentosTmp
								.getUnidadVenta().getIdUnve() : null);
				rboDetalleDocumentosDTO.add(rboDetalleDocumentosDTO2);
			}

			return rboDetalleDocumentosDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public RboDetalleDocumentos getRboDetalleDocumentos(Long idRddo)
			throws Exception {
		RboDetalleDocumentos entity = null;

		try {
			entity = rboDetalleDocumentosDAO.findById(idRddo);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"RboDetalleDocumentos");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<RboDetalleDocumentos> findPageRboDetalleDocumentos(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<RboDetalleDocumentos> entity = null;

		try {
			entity = rboDetalleDocumentosDAO.findPage(sortColumnName,
					sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"RboDetalleDocumentos Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberRboDetalleDocumentos() throws Exception {
		Long entity = null;

		try {
			entity = rboDetalleDocumentosDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"RboDetalleDocumentos Count");
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
	public List<RboDetalleDocumentos> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<RboDetalleDocumentos> list = new ArrayList<RboDetalleDocumentos>();
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
			list = rboDetalleDocumentosDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
