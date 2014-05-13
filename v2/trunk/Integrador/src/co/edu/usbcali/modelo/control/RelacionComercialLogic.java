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
import co.edu.usbcali.dataaccess.dao.IDocumentoDAO;
import co.edu.usbcali.dataaccess.dao.IRelacionComercialDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.AtencionVendedor;
import co.edu.usbcali.modelo.Documento;
import co.edu.usbcali.modelo.RelacionComercial;
import co.edu.usbcali.modelo.dto.RelacionComercialDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("RelacionComercialLogic")
public class RelacionComercialLogic implements IRelacionComercialLogic {
	/**
	 * DAO injected by Spring that manages RelacionComercial entities
	 * 
	 */
	@Autowired
	private IRelacionComercialDAO relacionComercialDAO;

	/**
	 * DAO injected by Spring that manages AtencionVendedor entities
	 * 
	 */
	@Autowired
	private IAtencionVendedorDAO atencionVendedorDAO;

	/**
	 * DAO injected by Spring that manages Documento entities
	 * 
	 */
	@Autowired
	private IDocumentoDAO documentoDAO;

	/**
	 * Logic injected by Spring that manages Empresa entities
	 * 
	 */
	@Autowired
	IEmpresaLogic logicEmpresa1;

	/**
	 * Logic injected by Spring that manages Persona entities
	 * 
	 */
	@Autowired
	IPersonaLogic logicPersona2;

	/**
	 * Logic injected by Spring that manages Sucursal entities
	 * 
	 */
	@Autowired
	ISucursalLogic logicSucursal3;

	/**
	 * Logic injected by Spring that manages Sucursal entities
	 * 
	 */
	@Autowired
	ISucursalLogic logicSucursal4;

	@Transactional(readOnly = true)
	public List<RelacionComercial> getRelacionComercial() throws Exception {
		List<RelacionComercial> list = new ArrayList<RelacionComercial>();

		try {
			list = relacionComercialDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "RelacionComercial");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveRelacionComercial(RelacionComercial entity)
			throws Exception {
		try {
			/*
			 * if (entity.getEmpresa() == null) { throw new ZMessManager().new
			 * ForeignException("empresa"); }
			 */

			/*
			 * if (entity.getPersona() == null) { throw new ZMessManager().new
			 * ForeignException("persona"); }
			 */

			/*
			 * if (entity.getSucursalBySucursalHija() == null) { throw new
			 * ZMessManager().new ForeignException( "sucursalBySucursalHija"); }
			 */

			if (entity.getEmpresa() == null && entity.getPersona() == null
					&& entity.getSucursalBySucursalHija() == null) {

				throw new Exception(
						"Empresa, persona y sucursal hija no pueden ser nullos");
			}

			if (entity.getEmpresa() != null && entity.getPersona() != null

			&& entity.getSucursalBySucursalHija() != null) {

				throw new Exception(
						"Empresa, Persona y sucursal hija no pueden estar llenas");
			}

			int cont = 0;

			if (entity.getPersona() != null) {
				cont++;
			}

			if (entity.getSucursalBySucursalHija() != null) {
				cont++;
			}

			if (entity.getEmpresa() != null) {
				cont++;
			}

			if (cont == 2) {
				throw new Exception(
						"solo puede estar llena empresa, sucursal hija o persona");
			}

			if (entity.getSucursalBySucursalPadre() == null) {
				throw new ZMessManager().new ForeignException(
						"sucursalBySucursalPadre");
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

			/*
			 * if (entity.getIdReco() == null) { throw new ZMessManager().new
			 * EmptyFieldException("idReco"); }
			 */

			/*
			 * if ((entity.getIdReco() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getIdReco(), 10, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("idReco"); }
			 */

			/*
			 * if ((entity.getLimiteCredito() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getLimiteCredito(), 14, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "limiteCredito"); }
			 */

			if ((entity.getLiquidaIva() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getLiquidaIva(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"liquidaIva");
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

			/*
			 * if (entity.getEmpresa().getIdEmpr() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "idEmpr_Empresa"); }
			 */
			if ((entity.getEmpresa() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getEmpresa().getIdEmpr(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idEmpr_Empresa");
			}

			/*
			 * if (entity.getPersona().getIdPers() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "idPers_Persona"); }
			 */

			if ((entity.getPersona() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPersona().getIdPers(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idPers_Persona");
			}

			/*
			 * if (getRelacionComercial(entity.getIdReco()) != null) { throw new
			 * ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY); }
			 */

			relacionComercialDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteRelacionComercial(RelacionComercial entity)
			throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion(
					"RelacionComercial");
		}

		if (entity.getIdReco() == null) {
			throw new ZMessManager().new EmptyFieldException("idReco");
		}

		List<AtencionVendedor> atencionVendedors = null;
		List<Documento> documentos = null;

		try {
			atencionVendedors = atencionVendedorDAO.findByProperty(
					"relacionComercial.idReco", entity.getIdReco());

			if (Utilities.validationsList(atencionVendedors) == true) {
				throw new ZMessManager().new DeletingException(
						"atencionVendedors");
			}

			documentos = documentoDAO.findByProperty(
					"relacionComercial.idReco", entity.getIdReco());

			if (Utilities.validationsList(documentos) == true) {
				throw new ZMessManager().new DeletingException("documentos");
			}

			relacionComercialDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateRelacionComercial(RelacionComercial entity)
			throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion(
						"RelacionComercial");
			}

			/*
			 * if (entity.getEmpresa() == null) { throw new ZMessManager().new
			 * ForeignException("empresa"); }
			 */

			/*
			 * if (entity.getPersona() == null) { throw new ZMessManager().new
			 * ForeignException("persona"); }
			 */

			/*
			 * if (entity.getSucursalBySucursalHija() == null) { throw new
			 * ZMessManager().new ForeignException( "sucursalBySucursalHija"); }
			 */

			if (entity.getEmpresa() == null && entity.getPersona() == null
					&& entity.getSucursalBySucursalHija() == null) {

				throw new Exception(
						"Empresa, persona y sucursal hija no pueden ser nullos");
			}

			if (entity.getEmpresa() != null && entity.getPersona() != null

			&& entity.getSucursalBySucursalHija() != null) {

				throw new Exception(
						"Empresa, Persona y sucursal hija no pueden estar llenas");
			}

			int cont = 0;

			if (entity.getPersona() != null) {
				cont++;
			}

			if (entity.getSucursalBySucursalHija() != null) {
				cont++;
			}

			if (entity.getEmpresa() != null) {
				cont++;
			}

			if (cont == 2) {
				throw new Exception(
						"solo puede estar llena empresa, sucursal hija o persona");

				/*
				 * throw new ZMessManager().new ForeignException(
				 * "solo puede estar llena empresa, sucursal hija o persona");
				 */

			}

			/*
			 * if (entity.getSucursalBySucursalPadre() == null) { throw new
			 * ZMessManager().new ForeignException( "sucursalBySucursalPadre");
			 * }
			 */

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

			/*
			 * if (entity.getIdReco() == null) { throw new ZMessManager().new
			 * EmptyFieldException("idReco"); }
			 */

			/*
			 * if ((entity.getIdReco() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getIdReco(), 10, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException("idReco"); }
			 */

			/*
			 * if ((entity.getLimiteCredito() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getLimiteCredito(), 14, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "limiteCredito"); }
			 */

			/*
			 * if ((entity.getLiquidaIva() != null) &&
			 * (Utilities.checkWordAndCheckWithlength( entity.getLiquidaIva(),
			 * 1) == false)) { throw new ZMessManager().new
			 * NotValidFormatException( "liquidaIva"); }
			 */

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

			/*
			 * if (entity.getEmpresa().getIdEmpr() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "idEmpr_Empresa"); }
			 */

			/*
			 * if ((entity.getEmpresa() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getEmpresa().getIdEmpr(), 10, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "idEmpr_Empresa"); }
			 */

			/*
			 * if (entity.getPersona().getIdPers() == null) { throw new
			 * ZMessManager().new EmptyFieldException( "idPers_Persona"); }
			 */

			/*
			 * if ((entity.getPersona() != null) &&
			 * (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
			 * entity.getPersona().getIdPers(), 10, 0) == false)) { throw new
			 * ZMessManager().new NotValidFormatException( "idPers_Persona"); }
			 */

			relacionComercialDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<RelacionComercialDTO> getDataRelacionComercial()
			throws Exception {
		try {
			List<RelacionComercial> relacionComercial = relacionComercialDAO
					.findAll();

			List<RelacionComercialDTO> relacionComercialDTO = new ArrayList<RelacionComercialDTO>();

			for (RelacionComercial relacionComercialTmp : relacionComercial) {

				RelacionComercialDTO relacionComercialDTO2 = new RelacionComercialDTO();

				relacionComercialDTO2.setIdReco(relacionComercialTmp
						.getIdReco());
				relacionComercialDTO2.setEstadoRegistro((relacionComercialTmp
						.getEstadoRegistro() != null) ? relacionComercialTmp
						.getEstadoRegistro() : null);

				relacionComercialDTO2.setFechaCreacion(relacionComercialTmp
						.getFechaCreacion());

				relacionComercialDTO2.setFechaModificacion(relacionComercialTmp
						.getFechaModificacion());

				relacionComercialDTO2.setLimiteCredito((relacionComercialTmp
						.getLimiteCredito() != null) ? relacionComercialTmp
						.getLimiteCredito() : null);

				relacionComercialDTO2.setLiquidaIva((relacionComercialTmp
						.getLiquidaIva() != null) ? relacionComercialTmp
						.getLiquidaIva() : null);

				relacionComercialDTO2.setObservacion((relacionComercialTmp
						.getObservacion() != null) ? relacionComercialTmp
						.getObservacion() : null);

				relacionComercialDTO2.setOperCreador((relacionComercialTmp
						.getOperCreador() != null) ? relacionComercialTmp
						.getOperCreador() : null);

				relacionComercialDTO2.setOperModifica((relacionComercialTmp
						.getOperModifica() != null) ? relacionComercialTmp
						.getOperModifica() : null);

				if (relacionComercialTmp.getEmpresa() != null) {
					relacionComercialDTO2
							.setIdEmpr_Empresa(relacionComercialTmp
									.getEmpresa().getIdEmpr());
				} else {
					relacionComercialDTO2.setIdEmpr_Empresa(null);
				}

				if (relacionComercialTmp.getPersona() != null) {
					relacionComercialDTO2
							.setIdPers_Persona(relacionComercialTmp
									.getPersona().getIdPers());
				} else {
					relacionComercialDTO2.setIdPers_Persona(null);
				}

				// fks null

				if (relacionComercialTmp.getSucursalBySucursalPadre() != null) {
					relacionComercialDTO2
							.setIdSucu_Sucursal(relacionComercialTmp
									.getSucursalBySucursalPadre().getIdSucu());

				} else {
					relacionComercialDTO2.setIdSucu_Sucursal(null);

				}

				if (relacionComercialTmp.getSucursalBySucursalHija() != null) {
					relacionComercialDTO2
							.setIdSucu_SucursalH(relacionComercialTmp
									.getSucursalBySucursalHija().getIdSucu());
				} else {
					relacionComercialDTO2.setIdSucu_SucursalH(null);
				}

				relacionComercialDTO.add(relacionComercialDTO2);
			}

			return relacionComercialDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public RelacionComercial getRelacionComercial(Long idReco) throws Exception {
		RelacionComercial entity = null;

		try {
			entity = relacionComercialDAO.findById(idReco);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("RelacionComercial");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<RelacionComercial> findPageRelacionComercial(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception {
		List<RelacionComercial> entity = null;

		try {
			entity = relacionComercialDAO.findPage(sortColumnName,
					sortAscending, startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"RelacionComercial Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberRelacionComercial() throws Exception {
		Long entity = null;

		try {
			entity = relacionComercialDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException(
					"RelacionComercial Count");
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
	public List<RelacionComercial> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<RelacionComercial> list = new ArrayList<RelacionComercial>();
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
			list = relacionComercialDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
