package co.edu.usbcali.modelo.control;

import co.edu.usbcali.dataaccess.dao.*;
import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.GrupoDTO;
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
@Service("GrupoLogic")
public class GrupoLogic implements IGrupoLogic {
	/**
	 * DAO injected by Spring that manages Grupo entities
	 * 
	 */

	/**
	 * DAO injected by Spring that manages Cartera entities
	 * 
	 */
	@Autowired
	private ICarteraDAO carteraDAO;

	/**
	 * DAO injected by Spring that manages DescuentoComercial entities
	 * 
	 */
	@Autowired
	private IDescuentoComercialDAO descuentoComercialDAO;

	/**
	 * DAO injected by Spring that manages DescuentoFinanciero entities
	 * 
	 */
	@Autowired
	private IDescuentoFinancieroDAO descuentoFinancieroDAO;

	/**
	 * DAO injected by Spring that manages GrupoReferencia entities
	 * 
	 */
	@Autowired
	private IGrupoReferenciaDAO grupoReferenciaDAO;

	/**
	 * DAO injected by Spring that manages Grupo entities
	 * 
	 */
	@Autowired
	private IGrupoDAO grupoDAO;

	/**
	 * DAO injected by Spring that manages PeriodoGarantia entities
	 * 
	 */
	@Autowired
	private IPeriodoGarantiaDAO periodoGarantiaDAO;

	/**
	 * Logic injected by Spring that manages Familia entities
	 * 
	 */
	@Autowired
	IFamiliaLogic logicFamilia1;

	/**
	 * Logic injected by Spring that manages Grupo entities
	 * 
	 */
	@Autowired
	IGrupoLogic logicGrupo2;

	@Transactional(readOnly = true)
	public List<Grupo> getGrupo() throws Exception {
		List<Grupo> list = new ArrayList<Grupo>();

		try {
			list = grupoDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "Grupo");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveGrupo(Grupo entity) throws Exception {
		try {
			if (entity.getFamilia() == null) {
				throw new ZMessManager().new ForeignException("familia");
			}

			if (entity.getGrupo() == null) {
				throw new ZMessManager().new ForeignException("grupo");
			}

			if ((entity.getAsociado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getAsociado(), 2) == false)) {
				throw new ZMessManager().new NotValidFormatException("asociado");
			}

			if ((entity.getDivision() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getDivision(), 2) == false)) {
				throw new ZMessManager().new NotValidFormatException("division");
			}

			if ((entity.getEspecial() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEspecial(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("especial");
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

			if (entity.getGrupo_1() == null) {
				throw new ZMessManager().new EmptyFieldException("grupo_1");
			}

			if ((entity.getGrupo_1() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getGrupo_1(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException("grupo_1");
			}

			if (entity.getIdGrpo() == null) {
				throw new ZMessManager().new EmptyFieldException("idGrpo");
			}

			if ((entity.getIdGrpo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdGrpo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idGrpo");
			}

			if ((entity.getManejaOrdenCompra() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getManejaOrdenCompra(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"manejaOrdenCompra");
			}

			if ((entity.getMargenMinimoBodega() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMargenMinimoBodega(), 3, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"margenMinimoBodega");
			}

			if ((entity.getMargenMinimoEnergiteca() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMargenMinimoEnergiteca(), 3, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"margenMinimoEnergiteca");
			}

			if ((entity.getModificaReferencia() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getModificaReferencia(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"modificaReferencia");
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

			if ((entity.getPideGalones() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getPideGalones(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"pideGalones");
			}

			if ((entity.getSugeridoPedido() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getSugeridoPedido(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"sugeridoPedido");
			}

			if ((entity.getTipoNivel() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getTipoNivel(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"tipoNivel");
			}

			if (entity.getFamilia().getIdFlia() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idFlia_Familia");
			}

			if ((entity.getFamilia().getIdFlia() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getFamilia().getIdFlia(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idFlia_Familia");
			}

			if (entity.getGrupo().getIdGrpo() == null) {
				throw new ZMessManager().new EmptyFieldException("idGrpo_Grupo");
			}

			if ((entity.getGrupo().getIdGrpo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getGrupo().getIdGrpo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idGrpo_Grupo");
			}

			if (getGrupo(entity.getIdGrpo()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			grupoDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteGrupo(Grupo entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Grupo");
		}

		if (entity.getIdGrpo() == null) {
			throw new ZMessManager().new EmptyFieldException("idGrpo");
		}

		List<Cartera> carteras = null;
		List<DescuentoComercial> descuentoComercials = null;
		List<DescuentoFinanciero> descuentoFinancieros = null;
		List<GrupoReferencia> grupoReferencias = null;
		List<Grupo> grupos = null;
		List<PeriodoGarantia> periodoGarantias = null;

		try {
			carteras = carteraDAO.findByProperty("grupo.idGrpo",
					entity.getIdGrpo());

			if (Utilities.validationsList(carteras) == true) {
				throw new ZMessManager().new DeletingException("carteras");
			}

			descuentoComercials = descuentoComercialDAO.findByProperty(
					"grupo.idGrpo", entity.getIdGrpo());

			if (Utilities.validationsList(descuentoComercials) == true) {
				throw new ZMessManager().new DeletingException(
						"descuentoComercials");
			}

			descuentoFinancieros = descuentoFinancieroDAO.findByProperty(
					"grupo.idGrpo", entity.getIdGrpo());

			if (Utilities.validationsList(descuentoFinancieros) == true) {
				throw new ZMessManager().new DeletingException(
						"descuentoFinancieros");
			}

			grupoReferencias = grupoReferenciaDAO.findByProperty(
					"grupo.idGrpo", entity.getIdGrpo());

			if (Utilities.validationsList(grupoReferencias) == true) {
				throw new ZMessManager().new DeletingException(
						"grupoReferencias");
			}

			grupos = grupoDAO
					.findByProperty("grupo.idGrpo", entity.getIdGrpo());

			if (Utilities.validationsList(grupos) == true) {
				throw new ZMessManager().new DeletingException("grupos");
			}

			periodoGarantias = periodoGarantiaDAO.findByProperty(
					"grupo.idGrpo", entity.getIdGrpo());

			if (Utilities.validationsList(periodoGarantias) == true) {
				throw new ZMessManager().new DeletingException(
						"periodoGarantias");
			}

			grupoDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateGrupo(Grupo entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Grupo");
			}

			if (entity.getFamilia() == null) {
				throw new ZMessManager().new ForeignException("familia");
			}

			if (entity.getGrupo() == null) {
				throw new ZMessManager().new ForeignException("grupo");
			}

			if ((entity.getAsociado() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getAsociado(), 2) == false)) {
				throw new ZMessManager().new NotValidFormatException("asociado");
			}

			if ((entity.getDivision() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getDivision(), 2) == false)) {
				throw new ZMessManager().new NotValidFormatException("division");
			}

			if ((entity.getEspecial() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEspecial(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("especial");
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

			if (entity.getGrupo_1() == null) {
				throw new ZMessManager().new EmptyFieldException("grupo_1");
			}

			if ((entity.getGrupo_1() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getGrupo_1(), 10) == false)) {
				throw new ZMessManager().new NotValidFormatException("grupo_1");
			}

			if (entity.getIdGrpo() == null) {
				throw new ZMessManager().new EmptyFieldException("idGrpo");
			}

			if ((entity.getIdGrpo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdGrpo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idGrpo");
			}

			if ((entity.getManejaOrdenCompra() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getManejaOrdenCompra(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"manejaOrdenCompra");
			}

			if ((entity.getMargenMinimoBodega() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMargenMinimoBodega(), 3, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"margenMinimoBodega");
			}

			if ((entity.getMargenMinimoEnergiteca() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getMargenMinimoEnergiteca(), 3, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"margenMinimoEnergiteca");
			}

			if ((entity.getModificaReferencia() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getModificaReferencia(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"modificaReferencia");
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

			if ((entity.getPideGalones() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getPideGalones(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"pideGalones");
			}

			if ((entity.getSugeridoPedido() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getSugeridoPedido(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"sugeridoPedido");
			}

			if ((entity.getTipoNivel() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getTipoNivel(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"tipoNivel");
			}

			if (entity.getFamilia().getIdFlia() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idFlia_Familia");
			}

			if ((entity.getFamilia().getIdFlia() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getFamilia().getIdFlia(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idFlia_Familia");
			}

			if (entity.getGrupo().getIdGrpo() == null) {
				throw new ZMessManager().new EmptyFieldException("idGrpo_Grupo");
			}

			if ((entity.getGrupo().getIdGrpo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getGrupo().getIdGrpo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idGrpo_Grupo");
			}

			grupoDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<GrupoDTO> getDataGrupo() throws Exception {
		try {
			List<Grupo> grupo = grupoDAO.findAll();

			List<GrupoDTO> grupoDTO = new ArrayList<GrupoDTO>();

			for (Grupo grupoTmp : grupo) {
				GrupoDTO grupoDTO2 = new GrupoDTO();

				grupoDTO2.setIdGrpo(grupoTmp.getIdGrpo());
				grupoDTO2
						.setAsociado((grupoTmp.getAsociado() != null) ? grupoTmp
								.getAsociado() : null);
				grupoDTO2
						.setDivision((grupoTmp.getDivision() != null) ? grupoTmp
								.getDivision() : null);
				grupoDTO2
						.setEspecial((grupoTmp.getEspecial() != null) ? grupoTmp
								.getEspecial() : null);
				grupoDTO2
						.setEstadoRegistro((grupoTmp.getEstadoRegistro() != null) ? grupoTmp
								.getEstadoRegistro() : null);
				grupoDTO2.setFechaCreacion(grupoTmp.getFechaCreacion());
				grupoDTO2.setFechaModificacion(grupoTmp.getFechaModificacion());
				grupoDTO2.setGrupo_1((grupoTmp.getGrupo_1() != null) ? grupoTmp
						.getGrupo_1() : null);
				grupoDTO2
						.setManejaOrdenCompra((grupoTmp.getManejaOrdenCompra() != null) ? grupoTmp
								.getManejaOrdenCompra() : null);
				grupoDTO2.setMargenMinimoBodega((grupoTmp
						.getMargenMinimoBodega() != null) ? grupoTmp
						.getMargenMinimoBodega() : null);
				grupoDTO2.setMargenMinimoEnergiteca((grupoTmp
						.getMargenMinimoEnergiteca() != null) ? grupoTmp
						.getMargenMinimoEnergiteca() : null);
				grupoDTO2.setModificaReferencia((grupoTmp
						.getModificaReferencia() != null) ? grupoTmp
						.getModificaReferencia() : null);
				grupoDTO2.setNombre((grupoTmp.getNombre() != null) ? grupoTmp
						.getNombre() : null);
				grupoDTO2
						.setOperCreador((grupoTmp.getOperCreador() != null) ? grupoTmp
								.getOperCreador() : null);
				grupoDTO2
						.setOperModifica((grupoTmp.getOperModifica() != null) ? grupoTmp
								.getOperModifica() : null);
				grupoDTO2
						.setPideGalones((grupoTmp.getPideGalones() != null) ? grupoTmp
								.getPideGalones() : null);
				grupoDTO2
						.setSugeridoPedido((grupoTmp.getSugeridoPedido() != null) ? grupoTmp
								.getSugeridoPedido() : null);
				grupoDTO2
						.setTipoNivel((grupoTmp.getTipoNivel() != null) ? grupoTmp
								.getTipoNivel() : null);

				if (grupoTmp.getFamilia() != null) {
					grupoDTO2.setIdFlia_Familia(grupoTmp.getFamilia()
							.getIdFlia());
				} else {
					grupoDTO2.setIdFlia_Familia(null);
				}

				if (grupoTmp.getGrupo() != null) {
					grupoDTO2.setIdGrpo_Grupo(grupoTmp.getGrupo().getIdGrpo());
				} else {
					grupoDTO2.setIdGrpo_Grupo(null);
				}

				grupoDTO.add(grupoDTO2);
			}

			return grupoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Grupo getGrupo(Long idGrpo) throws Exception {
		Grupo entity = null;

		try {
			entity = grupoDAO.findById(idGrpo);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Grupo");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Grupo> findPageGrupo(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Grupo> entity = null;

		try {
			entity = grupoDAO.findPage(sortColumnName, sortAscending, startRow,
					maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Grupo Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberGrupo() throws Exception {
		Long entity = null;

		try {
			entity = grupoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Grupo Count");
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
	public List<Grupo> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Grupo> list = new ArrayList<Grupo>();
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
			list = grupoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
