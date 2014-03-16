package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.IGarantiaDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.Garantia;
import co.edu.usbcali.modelo.dto.GarantiaDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("GarantiaLogic")
public class GarantiaLogic implements IGarantiaLogic {
	/**
	 * DAO injected by Spring that manages Garantia entities
	 * 
	 */
	@Autowired
	private IGarantiaDAO garantiaDAO;

	/**
	 * Logic injected by Spring that manages Bateriologo entities
	 * 
	 */
	@Autowired
	IBateriologoLogic logicBateriologo1;

	/**
	 * Logic injected by Spring that manages ClaveFabricacion entities
	 * 
	 */
	@Autowired
	IClaveFabricacionLogic logicClaveFabricacion2;

	/**
	 * Logic injected by Spring that manages Documento entities
	 * 
	 */
	@Autowired
	IDocumentoLogic logicDocumento3;

	/**
	 * Logic injected by Spring that manages Fallas entities
	 * 
	 */
	@Autowired
	IFallasLogic logicFallas4;

	/**
	 * Logic injected by Spring that manages Referencia entities
	 * 
	 */
	@Autowired
	IReferenciaLogic logicReferencia5;

	/**
	 * Logic injected by Spring that manages TipoGarantia entities
	 * 
	 */
	@Autowired
	ITipoGarantiaLogic logicTipoGarantia6;

	@Transactional(readOnly = true)
	public List<Garantia> getGarantia() throws Exception {
		List<Garantia> list = new ArrayList<Garantia>();

		try {
			list = garantiaDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "Garantia");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveGarantia(Garantia entity) throws Exception {
		try {
			if (entity.getBateriologo() == null) {
				throw new ZMessManager().new ForeignException("bateriologo");
			}

			if (entity.getClaveFabricacion() == null) {
				throw new ZMessManager().new ForeignException(
						"claveFabricacion");
			}

			if (entity.getDocumento() == null) {
				throw new ZMessManager().new ForeignException("documento");
			}

			if (entity.getFallas() == null) {
				throw new ZMessManager().new ForeignException("fallas");
			}

			if (entity.getReferencia() == null) {
				throw new ZMessManager().new ForeignException("referencia");
			}

			if (entity.getTipoGarantia() == null) {
				throw new ZMessManager().new ForeignException("tipoGarantia");
			}

			if ((entity.getAlineacionTrazabilidad() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getAlineacionTrazabilidad(), 5) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"alineacionTrazabilidad");
			}

			if ((entity.getAnoTrazabilidad() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getAnoTrazabilidad(), 5, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"anoTrazabilidad");
			}

			if ((entity.getDiaTrazabilidad() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDiaTrazabilidad(), 3, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"diaTrazabilidad");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
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

			if (entity.getIdGar() == null) {
				throw new ZMessManager().new EmptyFieldException("idGar");
			}

			if ((entity.getIdGar() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdGar(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idGar");
			}

			if ((entity.getLineaTrazabilidad() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getLineaTrazabilidad(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"lineaTrazabilidad");
			}

			if ((entity.getMesTrazabilidad() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getMesTrazabilidad(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"mesTrazabilidad");
			}

			if ((entity.getNumeroGarantia() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNumeroGarantia(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroGarantia");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getObservacion(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"observacion");
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

			if ((entity.getPlacaTrazabilidad() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getPlacaTrazabilidad(), 5) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"placaTrazabilidad");
			}

			if ((entity.getTurnoTrazabilidad() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getTurnoTrazabilidad(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"turnoTrazabilidad");
			}

			if (entity.getBateriologo().getIdBate() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idBate_Bateriologo");
			}

			if ((entity.getBateriologo().getIdBate() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getBateriologo().getIdBate(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idBate_Bateriologo");
			}

			if (entity.getClaveFabricacion().getIdClfa() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idClfa_ClaveFabricacion");
			}

			if ((entity.getClaveFabricacion().getIdClfa() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getClaveFabricacion().getIdClfa(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idClfa_ClaveFabricacion");
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

			if (entity.getFallas().getIdCfal() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idCfal_Fallas");
			}

			if ((entity.getFallas().getIdCfal() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getFallas().getIdCfal(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idCfal_Fallas");
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

			if (entity.getTipoGarantia().getIdTiga() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idTiga_TipoGarantia");
			}

			if ((entity.getTipoGarantia().getIdTiga() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getTipoGarantia().getIdTiga(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idTiga_TipoGarantia");
			}

			if (getGarantia(entity.getIdGar()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			garantiaDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteGarantia(Garantia entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Garantia");
		}

		if (entity.getIdGar() == null) {
			throw new ZMessManager().new EmptyFieldException("idGar");
		}

		try {
			garantiaDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateGarantia(Garantia entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Garantia");
			}

			if (entity.getBateriologo() == null) {
				throw new ZMessManager().new ForeignException("bateriologo");
			}

			if (entity.getClaveFabricacion() == null) {
				throw new ZMessManager().new ForeignException(
						"claveFabricacion");
			}

			if (entity.getDocumento() == null) {
				throw new ZMessManager().new ForeignException("documento");
			}

			if (entity.getFallas() == null) {
				throw new ZMessManager().new ForeignException("fallas");
			}

			if (entity.getReferencia() == null) {
				throw new ZMessManager().new ForeignException("referencia");
			}

			if (entity.getTipoGarantia() == null) {
				throw new ZMessManager().new ForeignException("tipoGarantia");
			}

			if ((entity.getAlineacionTrazabilidad() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getAlineacionTrazabilidad(), 5) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"alineacionTrazabilidad");
			}

			if ((entity.getAnoTrazabilidad() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getAnoTrazabilidad(), 5, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"anoTrazabilidad");
			}

			if ((entity.getDiaTrazabilidad() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDiaTrazabilidad(), 3, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"diaTrazabilidad");
			}

			if ((entity.getEstado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEstado(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("estado");
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

			if (entity.getIdGar() == null) {
				throw new ZMessManager().new EmptyFieldException("idGar");
			}

			if ((entity.getIdGar() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdGar(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idGar");
			}

			if ((entity.getLineaTrazabilidad() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getLineaTrazabilidad(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"lineaTrazabilidad");
			}

			if ((entity.getMesTrazabilidad() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getMesTrazabilidad(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"mesTrazabilidad");
			}

			if ((entity.getNumeroGarantia() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getNumeroGarantia(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroGarantia");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getObservacion(), 100) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"observacion");
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

			if ((entity.getPlacaTrazabilidad() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getPlacaTrazabilidad(), 5) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"placaTrazabilidad");
			}

			if ((entity.getTurnoTrazabilidad() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getTurnoTrazabilidad(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"turnoTrazabilidad");
			}

			if (entity.getBateriologo().getIdBate() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idBate_Bateriologo");
			}

			if ((entity.getBateriologo().getIdBate() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getBateriologo().getIdBate(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idBate_Bateriologo");
			}

			if (entity.getClaveFabricacion().getIdClfa() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idClfa_ClaveFabricacion");
			}

			if ((entity.getClaveFabricacion().getIdClfa() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getClaveFabricacion().getIdClfa(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idClfa_ClaveFabricacion");
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

			if (entity.getFallas().getIdCfal() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idCfal_Fallas");
			}

			if ((entity.getFallas().getIdCfal() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getFallas().getIdCfal(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idCfal_Fallas");
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

			if (entity.getTipoGarantia().getIdTiga() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idTiga_TipoGarantia");
			}

			if ((entity.getTipoGarantia().getIdTiga() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getTipoGarantia().getIdTiga(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idTiga_TipoGarantia");
			}

			garantiaDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<GarantiaDTO> getDataGarantia() throws Exception {
		try {
			List<Garantia> garantia = garantiaDAO.findAll();

			List<GarantiaDTO> garantiaDTO = new ArrayList<GarantiaDTO>();

			for (Garantia garantiaTmp : garantia) {
				GarantiaDTO garantiaDTO2 = new GarantiaDTO();

				garantiaDTO2.setIdGar(garantiaTmp.getIdGar());
				garantiaDTO2.setAlineacionTrazabilidad((garantiaTmp
						.getAlineacionTrazabilidad() != null) ? garantiaTmp
						.getAlineacionTrazabilidad() : null);
				garantiaDTO2.setAnoTrazabilidad((garantiaTmp
						.getAnoTrazabilidad() != null) ? garantiaTmp
						.getAnoTrazabilidad() : null);
				garantiaDTO2.setDiaTrazabilidad((garantiaTmp
						.getDiaTrazabilidad() != null) ? garantiaTmp
						.getDiaTrazabilidad() : null);
				garantiaDTO2
						.setEstado((garantiaTmp.getEstado() != null) ? garantiaTmp
								.getEstado() : null);
				garantiaDTO2
						.setEstadoRegistro((garantiaTmp.getEstadoRegistro() != null) ? garantiaTmp
								.getEstadoRegistro() : null);
				garantiaDTO2.setFechaCambio(garantiaTmp.getFechaCambio());
				garantiaDTO2.setFechaCreacion(garantiaTmp.getFechaCreacion());
				garantiaDTO2.setFechaModificacion(garantiaTmp
						.getFechaModificacion());
				garantiaDTO2.setFechaVenta(garantiaTmp.getFechaVenta());
				garantiaDTO2.setLineaTrazabilidad((garantiaTmp
						.getLineaTrazabilidad() != null) ? garantiaTmp
						.getLineaTrazabilidad() : null);
				garantiaDTO2.setMesTrazabilidad((garantiaTmp
						.getMesTrazabilidad() != null) ? garantiaTmp
						.getMesTrazabilidad() : null);
				garantiaDTO2
						.setNumeroGarantia((garantiaTmp.getNumeroGarantia() != null) ? garantiaTmp
								.getNumeroGarantia() : null);
				garantiaDTO2
						.setObservacion((garantiaTmp.getObservacion() != null) ? garantiaTmp
								.getObservacion() : null);
				garantiaDTO2
						.setOperCreador((garantiaTmp.getOperCreador() != null) ? garantiaTmp
								.getOperCreador() : null);
				garantiaDTO2
						.setOperModifica((garantiaTmp.getOperModifica() != null) ? garantiaTmp
								.getOperModifica() : null);
				garantiaDTO2.setPlacaTrazabilidad((garantiaTmp
						.getPlacaTrazabilidad() != null) ? garantiaTmp
						.getPlacaTrazabilidad() : null);
				garantiaDTO2.setTurnoTrazabilidad((garantiaTmp
						.getTurnoTrazabilidad() != null) ? garantiaTmp
						.getTurnoTrazabilidad() : null);

				if (garantiaTmp.getBateriologo() != null) {
					garantiaDTO2.setIdBate_Bateriologo(garantiaTmp
							.getBateriologo().getIdBate());
				} else {
					garantiaDTO2.setIdBate_Bateriologo(null);
				}

				garantiaDTO2
						.setIdClfa_ClaveFabricacion((garantiaTmp
								.getClaveFabricacion().getIdClfa() != null) ? garantiaTmp
								.getClaveFabricacion().getIdClfa() : null);
				garantiaDTO2.setIdDocu_Documento((garantiaTmp.getDocumento()
						.getIdDocu() != null) ? garantiaTmp.getDocumento()
						.getIdDocu() : null);

				if (garantiaTmp.getFallas() != null) {
					garantiaDTO2.setIdCfal_Fallas(garantiaTmp.getFallas()
							.getIdCfal());
				} else {
					garantiaDTO2.setIdCfal_Fallas(null);
				}

				garantiaDTO2.setIdRefe_Referencia((garantiaTmp.getReferencia()
						.getIdRefe() != null) ? garantiaTmp.getReferencia()
						.getIdRefe() : null);
				garantiaDTO2.setIdTiga_TipoGarantia((garantiaTmp
						.getTipoGarantia().getIdTiga() != null) ? garantiaTmp
						.getTipoGarantia().getIdTiga() : null);
				garantiaDTO.add(garantiaDTO2);
			}

			return garantiaDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Garantia getGarantia(Long idGar) throws Exception {
		Garantia entity = null;

		try {
			entity = garantiaDAO.findById(idGar);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Garantia");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Garantia> findPageGarantia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Garantia> entity = null;

		try {
			entity = garantiaDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Garantia Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberGarantia() throws Exception {
		Long entity = null;

		try {
			entity = garantiaDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Garantia Count");
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
	public List<Garantia> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Garantia> list = new ArrayList<Garantia>();
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
			list = garantiaDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
