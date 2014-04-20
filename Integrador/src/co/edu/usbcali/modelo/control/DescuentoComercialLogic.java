package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.IDescuentoComercialDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.DescuentoComercial;
import co.edu.usbcali.modelo.dto.DescuentoComercialDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("DescuentoComercialLogic")
public class DescuentoComercialLogic implements IDescuentoComercialLogic {
	/**
	 * DAO injected by Spring that manages DescuentoComercial entities
	 * 
	 */
	@Autowired
	private IDescuentoComercialDAO descuentoComercialDAO;

	/**
	 * Logic injected by Spring that manages Empresa entities
	 * 
	 */
	@Autowired
	IEmpresaLogic logicEmpresa1;

	/**
	 * Logic injected by Spring that manages Grupo entities
	 * 
	 */
	@Autowired
	IGrupoLogic logicGrupo2;

	/**
	 * Logic injected by Spring that manages Persona entities
	 * 
	 */
	@Autowired
	IPersonaLogic logicPersona3;

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
	public List<DescuentoComercial> getDescuentoComercial() throws Exception {
		List<DescuentoComercial> list = new ArrayList<DescuentoComercial>();

		try {
			list = descuentoComercialDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "DescuentoComercial");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveDescuentoComercial(DescuentoComercial entity)
			throws Exception {
		try {
			/*if (entity.getEmpresa() == null) {
				throw new ZMessManager().new ForeignException("empresa");
			}

			if (entity.getGrupo() == null) {
				throw new ZMessManager().new ForeignException("grupo");
			}

			if (entity.getPersona() == null) {
				throw new ZMessManager().new ForeignException("persona");
			}

			if (entity.getSucursalByIdSucu() == null) {
				throw new ZMessManager().new ForeignException(
						"sucursalByIdSucu");
			}

			if (entity.getSucursalBySucursal() == null) {
				throw new ZMessManager().new ForeignException(
						"sucursalBySucursal");
			}*/

			if ((entity.getAsocGrupoItem() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getAsocGrupoItem(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"asocGrupoItem");
			}

			if ((entity.getCreadoAutomatico() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCreadoAutomatico(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"creadoAutomatico");
			}

			if ((entity.getEspacios() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEspacios(), 80) == false)) {
				throw new ZMessManager().new NotValidFormatException("espacios");
			}

			if ((entity.getEstadoPlano() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getEstadoPlano(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"estadoPlano");
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

			if (entity.getFechaFinal() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaFinal");
			}

			if (entity.getFechaInicial() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaInicial");
			}

			if (entity.getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaModificacion");
			}

			/*if (entity.getIdDeco() == null) {
				throw new ZMessManager().new EmptyFieldException("idDeco");
			}*/

			/*if ((entity.getIdDeco() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdDeco(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idDeco");
			}*/

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

			if ((entity.getPorcDescItem() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPorcDescItem(), 3, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"porcDescItem");
			}

			if ((entity.getPorcDescMaxItem() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPorcDescMaxItem(), 3, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"porcDescMaxItem");
			}

			if ((entity.getPorcDescMinItem() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPorcDescMinItem(), 3, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"porcDescMinItem");
			}

			if ((entity.getTipoAsocGrupoItem() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getTipoAsocGrupoItem(), 3, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"tipoAsocGrupoItem");
			}

			if ((entity.getTodasSucursales() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getTodasSucursales(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"todasSucursales");
			}

			/*if (entity.getEmpresa().getIdEmpr() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idEmpr_Empresa");
			}

			if ((entity.getEmpresa().getIdEmpr() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getEmpresa().getIdEmpr(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idEmpr_Empresa");
			}*/

			/*if (entity.getGrupo().getIdGrpo() == null) {
				throw new ZMessManager().new EmptyFieldException("idGrpo_Grupo");
			}

			if ((entity.getGrupo().getIdGrpo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getGrupo().getIdGrpo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idGrpo_Grupo");
			}*/

			/*if (entity.getPersona().getIdPers() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idPers_Persona");
			}

			if ((entity.getPersona().getIdPers() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPersona().getIdPers(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idPers_Persona");
			}*/

			/*if (getDescuentoComercial(entity.getIdDeco()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}*/

			descuentoComercialDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteDescuentoComercial(DescuentoComercial entity)
			throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion(
					"DescuentoComercial");
		}

		if (entity.getIdDeco() == null) {
			throw new ZMessManager().new EmptyFieldException("idDeco");
		}

		try {
			descuentoComercialDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateDescuentoComercial(DescuentoComercial entity)
			throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"DescuentoComercial");
			}

			/*if (entity.getEmpresa() == null) {
				throw new ZMessManager().new ForeignException("empresa");
			}

			if (entity.getGrupo() == null) {
				throw new ZMessManager().new ForeignException("grupo");
			}

			if (entity.getPersona() == null) {
				throw new ZMessManager().new ForeignException("persona");
			}

			if (entity.getSucursalByIdSucu() == null) {
				throw new ZMessManager().new ForeignException(
						"sucursalByIdSucu");
			}

			if (entity.getSucursalBySucursal() == null) {
				throw new ZMessManager().new ForeignException(
						"sucursalBySucursal");
			}*/

			if ((entity.getAsocGrupoItem() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getAsocGrupoItem(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"asocGrupoItem");
			}

			if ((entity.getCreadoAutomatico() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCreadoAutomatico(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"creadoAutomatico");
			}

			if ((entity.getEspacios() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEspacios(), 80) == false)) {
				throw new ZMessManager().new NotValidFormatException("espacios");
			}

			if ((entity.getEstadoPlano() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getEstadoPlano(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"estadoPlano");
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

			if (entity.getFechaFinal() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaFinal");
			}

			if (entity.getFechaInicial() == null) {
				throw new ZMessManager().new EmptyFieldException("fechaInicial");
			}

			if (entity.getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaModificacion");
			}

			/*if (entity.getIdDeco() == null) {
				throw new ZMessManager().new EmptyFieldException("idDeco");
			}

			if ((entity.getIdDeco() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdDeco(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idDeco");
			}*/

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

			if ((entity.getPorcDescItem() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPorcDescItem(), 3, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"porcDescItem");
			}

			if ((entity.getPorcDescMaxItem() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPorcDescMaxItem(), 3, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"porcDescMaxItem");
			}

			if ((entity.getPorcDescMinItem() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPorcDescMinItem(), 3, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"porcDescMinItem");
			}

			if ((entity.getTipoAsocGrupoItem() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getTipoAsocGrupoItem(), 3, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"tipoAsocGrupoItem");
			}

			if ((entity.getTodasSucursales() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getTodasSucursales(), 1, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"todasSucursales");
			}

			/*if (entity.getEmpresa().getIdEmpr() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idEmpr_Empresa");
			}

			if ((entity.getEmpresa().getIdEmpr() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getEmpresa().getIdEmpr(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idEmpr_Empresa");
			}*/

			/*if (entity.getGrupo().getIdGrpo() == null) {
				throw new ZMessManager().new EmptyFieldException("idGrpo_Grupo");
			}

			if ((entity.getGrupo().getIdGrpo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getGrupo().getIdGrpo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idGrpo_Grupo");
			}*/

			/*if (entity.getPersona().getIdPers() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idPers_Persona");
			}*/

			/*if ((entity.getPersona().getIdPers() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPersona().getIdPers(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idPers_Persona");
			}*/

			descuentoComercialDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<DescuentoComercialDTO> getDataDescuentoComercial()
			throws Exception {
		try {
			List<DescuentoComercial> descuentoComercial = descuentoComercialDAO
					.findAll();

			List<DescuentoComercialDTO> descuentoComercialDTO = new ArrayList<DescuentoComercialDTO>();

			for (DescuentoComercial descuentoComercialTmp : descuentoComercial) {
				DescuentoComercialDTO descuentoComercialDTO2 = new DescuentoComercialDTO();

				descuentoComercialDTO2.setIdDeco(descuentoComercialTmp
						.getIdDeco());
				descuentoComercialDTO2.setAsocGrupoItem((descuentoComercialTmp
						.getAsocGrupoItem() != null) ? descuentoComercialTmp
						.getAsocGrupoItem() : null);
				descuentoComercialDTO2
						.setCreadoAutomatico((descuentoComercialTmp
								.getCreadoAutomatico() != null) ? descuentoComercialTmp
								.getCreadoAutomatico() : null);
				descuentoComercialDTO2.setEspacios((descuentoComercialTmp
						.getEspacios() != null) ? descuentoComercialTmp
						.getEspacios() : null);
				descuentoComercialDTO2.setEstadoPlano((descuentoComercialTmp
						.getEstadoPlano() != null) ? descuentoComercialTmp
						.getEstadoPlano() : null);
				descuentoComercialDTO2.setEstadoRegistro((descuentoComercialTmp
						.getEstadoRegistro() != null) ? descuentoComercialTmp
						.getEstadoRegistro() : null);
				descuentoComercialDTO2.setFechaCreacion(descuentoComercialTmp
						.getFechaCreacion());
				descuentoComercialDTO2.setFechaFinal(descuentoComercialTmp
						.getFechaFinal());
				descuentoComercialDTO2.setFechaInicial(descuentoComercialTmp
						.getFechaInicial());
				descuentoComercialDTO2
						.setFechaModificacion(descuentoComercialTmp
								.getFechaModificacion());
				descuentoComercialDTO2.setOperCreador((descuentoComercialTmp
						.getOperCreador() != null) ? descuentoComercialTmp
						.getOperCreador() : null);
				descuentoComercialDTO2.setOperModifica((descuentoComercialTmp
						.getOperModifica() != null) ? descuentoComercialTmp
						.getOperModifica() : null);
				descuentoComercialDTO2.setPorcDescItem((descuentoComercialTmp
						.getPorcDescItem() != null) ? descuentoComercialTmp
						.getPorcDescItem() : null);
				descuentoComercialDTO2
						.setPorcDescMaxItem((descuentoComercialTmp
								.getPorcDescMaxItem() != null) ? descuentoComercialTmp
								.getPorcDescMaxItem() : null);
				descuentoComercialDTO2
						.setPorcDescMinItem((descuentoComercialTmp
								.getPorcDescMinItem() != null) ? descuentoComercialTmp
								.getPorcDescMinItem() : null);
				descuentoComercialDTO2
						.setTipoAsocGrupoItem((descuentoComercialTmp
								.getTipoAsocGrupoItem() != null) ? descuentoComercialTmp
								.getTipoAsocGrupoItem() : null);
				descuentoComercialDTO2
						.setTodasSucursales((descuentoComercialTmp
								.getTodasSucursales() != null) ? descuentoComercialTmp
								.getTodasSucursales() : null);

				if (descuentoComercialTmp.getEmpresa() != null) {
					descuentoComercialDTO2
							.setIdEmpr_Empresa(descuentoComercialTmp
									.getEmpresa().getIdEmpr());
				} else {
					descuentoComercialDTO2.setIdEmpr_Empresa(null);
				}
				
				// fks null
				

				descuentoComercialDTO2
						.setIdGrpo_Grupo((descuentoComercialTmp.getGrupo()
								.getIdGrpo() != null) ? descuentoComercialTmp
								.getGrupo().getIdGrpo() : null);
				
				descuentoComercialDTO2
				.setIdSucu_Sucursal((descuentoComercialTmp.getSucursalBySucursal()
						.getIdSucu() != null) ? descuentoComercialTmp
						.getSucursalBySucursal().getIdSucu() : null);
				
				

				if (descuentoComercialTmp.getPersona() != null) {
					descuentoComercialDTO2
							.setIdPers_Persona(descuentoComercialTmp
									.getPersona().getIdPers());
					
				} else {
					descuentoComercialDTO2.setIdPers_Persona(null);
				}

				
				
				if (descuentoComercialTmp.getEmpresa() != null) {
					descuentoComercialDTO2
							.setIdEmpr_Empresa(descuentoComercialTmp
									.getEmpresa().getIdEmpr());
					
				} else {
					descuentoComercialDTO2.setIdEmpr_Empresa(null);
				}
				
				
				if (descuentoComercialTmp.getSucursalByIdSucu() != null) {
					descuentoComercialDTO2
							.setIdIdSucu_Sucursal(descuentoComercialTmp
									.getSucursalByIdSucu().getIdSucu());
					
				} else {
					descuentoComercialDTO2.setIdIdSucu_Sucursal(null);
				}
				
				
				descuentoComercialDTO.add(descuentoComercialDTO2);
			}

			return descuentoComercialDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public DescuentoComercial getDescuentoComercial(Long idDeco)
			throws Exception {
		DescuentoComercial entity = null;

		try {
			entity = descuentoComercialDAO.findById(idDeco);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("DescuentoComercial");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<DescuentoComercial> findPageDescuentoComercial(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<DescuentoComercial> entity = null;

		try {
			entity = descuentoComercialDAO.findPage(sortColumnName,
					sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"DescuentoComercial Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberDescuentoComercial() throws Exception {
		Long entity = null;

		try {
			entity = descuentoComercialDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"DescuentoComercial Count");
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
	public List<DescuentoComercial> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<DescuentoComercial> list = new ArrayList<DescuentoComercial>();
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
			list = descuentoComercialDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
