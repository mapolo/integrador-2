package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.ICarteraDAO;
import co.edu.usbcali.dataaccess.dao.IDistribucionCarteraDAO;
import co.edu.usbcali.dataaccess.dao.IRboDetalleDocumentosDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.Cartera;
import co.edu.usbcali.modelo.DistribucionCartera;
import co.edu.usbcali.modelo.RboDetalleDocumentos;
import co.edu.usbcali.modelo.dto.CarteraDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("CarteraLogic")
public class CarteraLogic implements ICarteraLogic {
	/**
	 * DAO injected by Spring that manages Cartera entities
	 * 
	 */
	@Autowired
	private ICarteraDAO carteraDAO;

	/**
	 * DAO injected by Spring that manages DistribucionCartera entities
	 * 
	 */
	@Autowired
	private IDistribucionCarteraDAO distribucionCarteraDAO;

	/**
	 * DAO injected by Spring that manages RboDetalleDocumentos entities
	 * 
	 */
	@Autowired
	private IRboDetalleDocumentosDAO rboDetalleDocumentosDAO;

	/**
	 * Logic injected by Spring that manages Documento entities
	 * 
	 */
	@Autowired
	IDocumentoLogic logicDocumento1;

	/**
	 * Logic injected by Spring that manages Grupo entities
	 * 
	 */
	@Autowired
	IGrupoLogic logicGrupo2;

	@Transactional(readOnly = true)
	public List<Cartera> getCartera() throws Exception {
		List<Cartera> list = new ArrayList<Cartera>();

		try {
			list = carteraDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "Cartera");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveCartera(Cartera entity) throws Exception {
		try {
			if (entity.getDocumento() == null) {
				throw new ZMessManager().new ForeignException("documento");
			}

			if (entity.getGrupo() == null) {
				throw new ZMessManager().new ForeignException("grupo");
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

			if (entity.getIdCart() == null) {
				throw new ZMessManager().new EmptyFieldException("idCart");
			}

			if ((entity.getIdCart() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdCart(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idCart");
			}

			if ((entity.getInteres() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getInteres(), 3, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException("interes");
			}

			if ((entity.getNumeroCuotas() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroCuotas(), 22, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroCuotas");
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

			if ((entity.getSaldo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getSaldo(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("saldo");
			}

			if ((entity.getValorBase() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getValorBase(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"valorBase");
			}

			if (entity.getValorTotal() == null) {
				throw new ZMessManager().new EmptyFieldException("valorTotal");
			}

			if ((entity.getValorTotal() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getValorTotal(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"valorTotal");
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

			if (entity.getGrupo().getIdGrpo() == null) {
				throw new ZMessManager().new EmptyFieldException("idGrpo_Grupo");
			}

			if ((entity.getGrupo().getIdGrpo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getGrupo().getIdGrpo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idGrpo_Grupo");
			}

			if (getCartera(entity.getIdCart()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			carteraDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteCartera(Cartera entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Cartera");
		}

		if (entity.getIdCart() == null) {
			throw new ZMessManager().new EmptyFieldException("idCart");
		}

		List<DistribucionCartera> distribucionCarteras = null;
		List<RboDetalleDocumentos> rboDetalleDocumentoses = null;

		try {
			distribucionCarteras = distribucionCarteraDAO.findByProperty(
					"cartera.idCart", entity.getIdCart());

			if (Utilities.validationsList(distribucionCarteras) == true) {
				throw new ZMessManager().new DeletingException(
						"distribucionCarteras");
			}

			rboDetalleDocumentoses = rboDetalleDocumentosDAO.findByProperty(
					"cartera.idCart", entity.getIdCart());

			if (Utilities.validationsList(rboDetalleDocumentoses) == true) {
				throw new ZMessManager().new DeletingException(
						"rboDetalleDocumentoses");
			}

			carteraDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateCartera(Cartera entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Cartera");
			}

			if (entity.getDocumento() == null) {
				throw new ZMessManager().new ForeignException("documento");
			}

			if (entity.getGrupo() == null) {
				throw new ZMessManager().new ForeignException("grupo");
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

			if (entity.getIdCart() == null) {
				throw new ZMessManager().new EmptyFieldException("idCart");
			}

			if ((entity.getIdCart() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdCart(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idCart");
			}

			if ((entity.getInteres() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getInteres(), 3, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException("interes");
			}

			if ((entity.getNumeroCuotas() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroCuotas(), 22, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroCuotas");
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

			if ((entity.getSaldo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getSaldo(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("saldo");
			}

			if ((entity.getValorBase() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getValorBase(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"valorBase");
			}

			if (entity.getValorTotal() == null) {
				throw new ZMessManager().new EmptyFieldException("valorTotal");
			}

			if ((entity.getValorTotal() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getValorTotal(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"valorTotal");
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

			if (entity.getGrupo().getIdGrpo() == null) {
				throw new ZMessManager().new EmptyFieldException("idGrpo_Grupo");
			}

			if ((entity.getGrupo().getIdGrpo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getGrupo().getIdGrpo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idGrpo_Grupo");
			}

			carteraDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<CarteraDTO> getDataCartera() throws Exception {
		try {
			List<Cartera> cartera = carteraDAO.findAll();

			List<CarteraDTO> carteraDTO = new ArrayList<CarteraDTO>();

			for (Cartera carteraTmp : cartera) {
				CarteraDTO carteraDTO2 = new CarteraDTO();

				carteraDTO2.setIdCart(carteraTmp.getIdCart());
				carteraDTO2
						.setEstadoRegistro((carteraTmp.getEstadoRegistro() != null) ? carteraTmp
								.getEstadoRegistro() : null);
				carteraDTO2.setFechaCreacion(carteraTmp.getFechaCreacion());
				carteraDTO2.setFechaModificacion(carteraTmp
						.getFechaModificacion());
				carteraDTO2.setFechaPago(carteraTmp.getFechaPago());
				carteraDTO2.setFechaVencimiento(carteraTmp
						.getFechaVencimiento());
				carteraDTO2
						.setInteres((carteraTmp.getInteres() != null) ? carteraTmp
								.getInteres() : null);
				carteraDTO2
						.setNumeroCuotas((carteraTmp.getNumeroCuotas() != null) ? carteraTmp
								.getNumeroCuotas() : null);
				carteraDTO2
						.setOperCreador((carteraTmp.getOperCreador() != null) ? carteraTmp
								.getOperCreador() : null);
				carteraDTO2
						.setOperModifica((carteraTmp.getOperModifica() != null) ? carteraTmp
								.getOperModifica() : null);
				carteraDTO2
						.setSaldo((carteraTmp.getSaldo() != null) ? carteraTmp
								.getSaldo() : null);
				carteraDTO2
						.setValorBase((carteraTmp.getValorBase() != null) ? carteraTmp
								.getValorBase() : null);
				carteraDTO2
						.setValorTotal((carteraTmp.getValorTotal() != null) ? carteraTmp
								.getValorTotal() : null);
				carteraDTO2.setIdDocu_Documento((carteraTmp.getDocumento()
						.getIdDocu() != null) ? carteraTmp.getDocumento()
						.getIdDocu() : null);

				if (carteraTmp.getGrupo() != null) {
					carteraDTO2.setIdGrpo_Grupo(carteraTmp.getGrupo()
							.getIdGrpo());
				} else {
					carteraDTO2.setIdGrpo_Grupo(null);
				}

				carteraDTO.add(carteraDTO2);
			}

			return carteraDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Cartera getCartera(Long idCart) throws Exception {
		Cartera entity = null;

		try {
			entity = carteraDAO.findById(idCart);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Cartera");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Cartera> findPageCartera(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Cartera> entity = null;

		try {
			entity = carteraDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Cartera Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberCartera() throws Exception {
		Long entity = null;

		try {
			entity = carteraDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Cartera Count");
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
	public List<Cartera> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Cartera> list = new ArrayList<Cartera>();
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
			list = carteraDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
