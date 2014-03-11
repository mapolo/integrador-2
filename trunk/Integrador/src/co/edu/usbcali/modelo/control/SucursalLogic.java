package co.edu.usbcali.modelo.control;

import co.edu.usbcali.dataaccess.dao.*;
import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.SucursalDTO;
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
@Service("SucursalLogic")
public class SucursalLogic implements ISucursalLogic {
	/**
	 * DAO injected by Spring that manages Sucursal entities
	 * 
	 */

	/**
	 * DAO injected by Spring that manages Bateriologo entities
	 * 
	 */
	@Autowired
	private IBateriologoDAO bateriologoDAO;

	/**
	 * DAO injected by Spring that manages ClavesParaRotar entities
	 * 
	 */
	@Autowired
	private IClavesParaRotarDAO clavesParaRotarDAO;

	/**
	 * DAO injected by Spring that manages ConsecutivoDocumento entities
	 * 
	 */
	@Autowired
	private IConsecutivoDocumentoDAO consecutivoDocumentoDAO;

	/**
	 * DAO injected by Spring that manages Contacto entities
	 * 
	 */
	@Autowired
	private IContactoDAO contactoDAO;

	/**
	 * DAO injected by Spring that manages DescuentoComercial entities
	 * 
	 */
	@Autowired
	private IDescuentoComercialDAO descuentoComercialDAO;

	/**
	 * DAO injected by Spring that manages DescuentoComercial entities
	 * 
	 */

	/**
	 * DAO injected by Spring that manages Documento entities
	 * 
	 */
	@Autowired
	private IDocumentoDAO documentoDAO;

	/**
	 * DAO injected by Spring that manages ListaPreciosEspeciales entities
	 * 
	 */

	/**
	 * DAO injected by Spring that manages ListaPreciosEspeciales entities
	 * 
	 */
	@Autowired
	private IListaPreciosEspecialesDAO listaPreciosEspecialesDAO;

	/**
	 * DAO injected by Spring that manages ListaPrecios entities
	 * 
	 */
	@Autowired
	private IListaPreciosDAO listaPreciosDAO;

	/**
	 * DAO injected by Spring that manages MovimientoInventario entities
	 * 
	 */

	/**
	 * DAO injected by Spring that manages MovimientoInventario entities
	 * 
	 */
	@Autowired
	private IMovimientoInventarioDAO movimientoInventarioDAO;

	/**
	 * DAO injected by Spring that manages Multifamilia entities
	 * 
	 */
	@Autowired
	private IMultifamiliaDAO multifamiliaDAO;

	/**
	 * DAO injected by Spring that manages OrdenesDeCompra entities
	 * 
	 */
	@Autowired
	private IOrdenesDeCompraDAO ordenesDeCompraDAO;

	/**
	 * DAO injected by Spring that manages PronosticoVenta entities
	 * 
	 */
	@Autowired
	private IPronosticoVentaDAO pronosticoVentaDAO;

	/**
	 * DAO injected by Spring that manages RboDetalleDocumentos entities
	 * 
	 */
	@Autowired
	private IRboDetalleDocumentosDAO rboDetalleDocumentosDAO;

	/**
	 * DAO injected by Spring that manages ReferenciaSucursal entities
	 * 
	 */
	@Autowired
	private IReferenciaSucursalDAO referenciaSucursalDAO;

	/**
	 * DAO injected by Spring that manages RelacionComercial entities
	 * 
	 */
	@Autowired
	private IRelacionComercialDAO relacionComercialDAO;

	/**
	 * DAO injected by Spring that manages RelacionComercial entities
	 * 
	 */

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
	 * Logic injected by Spring that manages RegionalGeografica entities
	 * 
	 */
	@Autowired
	IRegionalGeograficaLogic logicRegionalGeografica4;

	/**
	 * Logic injected by Spring that manages Sucursal entities
	 * 
	 */
	@Autowired
	ISucursalLogic logicSucursal5;

	/**
	 * Logic injected by Spring that manages TipoSucursal entities
	 * 
	 */
	@Autowired
	ITipoSucursalLogic logicTipoSucursal6;

	@Transactional(readOnly = true)
	public List<Sucursal> getSucursal() throws Exception {
		List<Sucursal> list = new ArrayList<Sucursal>();

		try {
			list = sucursalDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "Sucursal");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void saveSucursal(Sucursal entity) throws Exception {
		try {
			if (entity.getDivisionPolitica() == null) {
				throw new ZMessManager().new ForeignException(
						"divisionPolitica");
			}

			if (entity.getEmpresa() == null) {
				throw new ZMessManager().new ForeignException("empresa");
			}

			if (entity.getPersona() == null) {
				throw new ZMessManager().new ForeignException("persona");
			}

			if (entity.getRegionalGeografica() == null) {
				throw new ZMessManager().new ForeignException(
						"regionalGeografica");
			}

			if (entity.getSucursal() == null) {
				throw new ZMessManager().new ForeignException("sucursal");
			}

			if (entity.getTipoSucursal() == null) {
				throw new ZMessManager().new ForeignException("tipoSucursal");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCodigo(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
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

			if (entity.getEstadoSucursal() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"estadoSucursal");
			}

			if ((entity.getEstadoSucursal() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEstadoSucursal(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"estadoSucursal");
			}

			if (entity.getFechaCreacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaCreacion");
			}

			if (entity.getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaModificacion");
			}

			if (entity.getIdSucu() == null) {
				throw new ZMessManager().new EmptyFieldException("idSucu");
			}

			if ((entity.getIdSucu() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdSucu(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idSucu");
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

			if ((entity.getTelefono() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getTelefono(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("telefono");
			}

			if ((entity.getZipCode() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getZipCode(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("zipCode");
			}

			if (entity.getDivisionPolitica().getIdDipo() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idDipo_DivisionPolitica");
			}

			if ((entity.getDivisionPolitica().getIdDipo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDivisionPolitica().getIdDipo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idDipo_DivisionPolitica");
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

			if (entity.getRegionalGeografica().getIdRege() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idRege_RegionalGeografica");
			}

			if ((entity.getRegionalGeografica().getIdRege() != null)
					&& (Utilities
							.checkNumberAndCheckWithPrecisionAndScale(""
									+ entity.getRegionalGeografica()
											.getIdRege(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idRege_RegionalGeografica");
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

			if (entity.getTipoSucursal().getIdTisu() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idTisu_TipoSucursal");
			}

			if ((entity.getTipoSucursal().getIdTisu() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getTipoSucursal().getIdTisu(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idTisu_TipoSucursal");
			}

			if (getSucursal(entity.getIdSucu()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			sucursalDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deleteSucursal(Sucursal entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Sucursal");
		}

		if (entity.getIdSucu() == null) {
			throw new ZMessManager().new EmptyFieldException("idSucu");
		}

		List<Bateriologo> bateriologos = null;
		List<ClavesParaRotar> clavesParaRotars = null;
		List<ConsecutivoDocumento> consecutivoDocumentos = null;
		List<Contacto> contactos = null;
		List<DescuentoComercial> descuentoComercialsForIdSucu = null;
		List<DescuentoComercial> descuentoComercialsForSucursal = null;
		List<Documento> documentos = null;
		List<ListaPreciosEspeciales> listaPreciosEspecialesesForIdSucu = null;
		List<ListaPreciosEspeciales> listaPreciosEspecialesesForSucursal = null;
		List<ListaPrecios> listaPrecioses = null;
		List<MovimientoInventario> movimientoInventariosForSucursalEntrega = null;
		List<MovimientoInventario> movimientoInventariosForSucursalRecibeEnvia = null;
		List<Multifamilia> multifamilias = null;
		List<OrdenesDeCompra> ordenesDeCompras = null;
		List<PronosticoVenta> pronosticoVentas = null;
		List<RboDetalleDocumentos> rboDetalleDocumentoses = null;
		List<ReferenciaSucursal> referenciaSucursals = null;
		List<RelacionComercial> relacionComercialsForSucursalHija = null;
		List<RelacionComercial> relacionComercialsForSucursalPadre = null;
		List<Sucursal> sucursals = null;
		List<Vendedor> vendedors = null;

		try {
			bateriologos = bateriologoDAO.findByProperty("sucursal.idSucu",
					entity.getIdSucu());

			if (Utilities.validationsList(bateriologos) == true) {
				throw new ZMessManager().new DeletingException("bateriologos");
			}

			clavesParaRotars = clavesParaRotarDAO.findByProperty(
					"sucursal.idSucu", entity.getIdSucu());

			if (Utilities.validationsList(clavesParaRotars) == true) {
				throw new ZMessManager().new DeletingException(
						"clavesParaRotars");
			}

			consecutivoDocumentos = consecutivoDocumentoDAO.findByProperty(
					"sucursal.idSucu", entity.getIdSucu());

			if (Utilities.validationsList(consecutivoDocumentos) == true) {
				throw new ZMessManager().new DeletingException(
						"consecutivoDocumentos");
			}

			contactos = contactoDAO.findByProperty("sucursal.idSucu",
					entity.getIdSucu());

			if (Utilities.validationsList(contactos) == true) {
				throw new ZMessManager().new DeletingException("contactos");
			}

			descuentoComercialsForIdSucu = descuentoComercialDAO
					.findByProperty("sucursal.idSucu", entity.getIdSucu());

			if (Utilities.validationsList(descuentoComercialsForIdSucu) == true) {
				throw new ZMessManager().new DeletingException(
						"descuentoComercialsForIdSucu");
			}

			descuentoComercialsForSucursal = descuentoComercialDAO
					.findByProperty("sucursal.idSucu", entity.getIdSucu());

			if (Utilities.validationsList(descuentoComercialsForSucursal) == true) {
				throw new ZMessManager().new DeletingException(
						"descuentoComercialsForSucursal");
			}

			documentos = documentoDAO.findByProperty("sucursal.idSucu",
					entity.getIdSucu());

			if (Utilities.validationsList(documentos) == true) {
				throw new ZMessManager().new DeletingException("documentos");
			}

			listaPreciosEspecialesesForIdSucu = listaPreciosEspecialesDAO
					.findByProperty("sucursal.idSucu", entity.getIdSucu());

			if (Utilities.validationsList(listaPreciosEspecialesesForIdSucu) == true) {
				throw new ZMessManager().new DeletingException(
						"listaPreciosEspecialesesForIdSucu");
			}

			listaPreciosEspecialesesForSucursal = listaPreciosEspecialesDAO
					.findByProperty("sucursal.idSucu", entity.getIdSucu());

			if (Utilities.validationsList(listaPreciosEspecialesesForSucursal) == true) {
				throw new ZMessManager().new DeletingException(
						"listaPreciosEspecialesesForSucursal");
			}

			listaPrecioses = listaPreciosDAO.findByProperty("sucursal.idSucu",
					entity.getIdSucu());

			if (Utilities.validationsList(listaPrecioses) == true) {
				throw new ZMessManager().new DeletingException("listaPrecioses");
			}

			movimientoInventariosForSucursalEntrega = movimientoInventarioDAO
					.findByProperty("sucursal.idSucu", entity.getIdSucu());

			if (Utilities
					.validationsList(movimientoInventariosForSucursalEntrega) == true) {
				throw new ZMessManager().new DeletingException(
						"movimientoInventariosForSucursalEntrega");
			}

			movimientoInventariosForSucursalRecibeEnvia = movimientoInventarioDAO
					.findByProperty("sucursal.idSucu", entity.getIdSucu());

			if (Utilities
					.validationsList(movimientoInventariosForSucursalRecibeEnvia) == true) {
				throw new ZMessManager().new DeletingException(
						"movimientoInventariosForSucursalRecibeEnvia");
			}

			multifamilias = multifamiliaDAO.findByProperty("sucursal.idSucu",
					entity.getIdSucu());

			if (Utilities.validationsList(multifamilias) == true) {
				throw new ZMessManager().new DeletingException("multifamilias");
			}

			ordenesDeCompras = ordenesDeCompraDAO.findByProperty(
					"sucursal.idSucu", entity.getIdSucu());

			if (Utilities.validationsList(ordenesDeCompras) == true) {
				throw new ZMessManager().new DeletingException(
						"ordenesDeCompras");
			}

			pronosticoVentas = pronosticoVentaDAO.findByProperty(
					"sucursal.idSucu", entity.getIdSucu());

			if (Utilities.validationsList(pronosticoVentas) == true) {
				throw new ZMessManager().new DeletingException(
						"pronosticoVentas");
			}

			rboDetalleDocumentoses = rboDetalleDocumentosDAO.findByProperty(
					"sucursal.idSucu", entity.getIdSucu());

			if (Utilities.validationsList(rboDetalleDocumentoses) == true) {
				throw new ZMessManager().new DeletingException(
						"rboDetalleDocumentoses");
			}

			referenciaSucursals = referenciaSucursalDAO.findByProperty(
					"sucursal.idSucu", entity.getIdSucu());

			if (Utilities.validationsList(referenciaSucursals) == true) {
				throw new ZMessManager().new DeletingException(
						"referenciaSucursals");
			}

			relacionComercialsForSucursalHija = relacionComercialDAO
					.findByProperty("sucursal.idSucu", entity.getIdSucu());

			if (Utilities.validationsList(relacionComercialsForSucursalHija) == true) {
				throw new ZMessManager().new DeletingException(
						"relacionComercialsForSucursalHija");
			}

			relacionComercialsForSucursalPadre = relacionComercialDAO
					.findByProperty("sucursal.idSucu", entity.getIdSucu());

			if (Utilities.validationsList(relacionComercialsForSucursalPadre) == true) {
				throw new ZMessManager().new DeletingException(
						"relacionComercialsForSucursalPadre");
			}

			sucursals = sucursalDAO.findByProperty("sucursal.idSucu",
					entity.getIdSucu());

			if (Utilities.validationsList(sucursals) == true) {
				throw new ZMessManager().new DeletingException("sucursals");
			}

			vendedors = vendedorDAO.findByProperty("sucursal.idSucu",
					entity.getIdSucu());

			if (Utilities.validationsList(vendedors) == true) {
				throw new ZMessManager().new DeletingException("vendedors");
			}

			sucursalDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updateSucursal(Sucursal entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Sucursal");
			}

			if (entity.getDivisionPolitica() == null) {
				throw new ZMessManager().new ForeignException(
						"divisionPolitica");
			}

			if (entity.getEmpresa() == null) {
				throw new ZMessManager().new ForeignException("empresa");
			}

			if (entity.getPersona() == null) {
				throw new ZMessManager().new ForeignException("persona");
			}

			if (entity.getRegionalGeografica() == null) {
				throw new ZMessManager().new ForeignException(
						"regionalGeografica");
			}

			if (entity.getSucursal() == null) {
				throw new ZMessManager().new ForeignException("sucursal");
			}

			if (entity.getTipoSucursal() == null) {
				throw new ZMessManager().new ForeignException("tipoSucursal");
			}

			if ((entity.getCodigo() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCodigo(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException("codigo");
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

			if (entity.getEstadoSucursal() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"estadoSucursal");
			}

			if ((entity.getEstadoSucursal() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEstadoSucursal(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"estadoSucursal");
			}

			if (entity.getFechaCreacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaCreacion");
			}

			if (entity.getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaModificacion");
			}

			if (entity.getIdSucu() == null) {
				throw new ZMessManager().new EmptyFieldException("idSucu");
			}

			if ((entity.getIdSucu() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdSucu(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idSucu");
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

			if ((entity.getTelefono() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getTelefono(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("telefono");
			}

			if ((entity.getZipCode() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getZipCode(), 30) == false)) {
				throw new ZMessManager().new NotValidFormatException("zipCode");
			}

			if (entity.getDivisionPolitica().getIdDipo() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idDipo_DivisionPolitica");
			}

			if ((entity.getDivisionPolitica().getIdDipo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getDivisionPolitica().getIdDipo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idDipo_DivisionPolitica");
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

			if (entity.getRegionalGeografica().getIdRege() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idRege_RegionalGeografica");
			}

			if ((entity.getRegionalGeografica().getIdRege() != null)
					&& (Utilities
							.checkNumberAndCheckWithPrecisionAndScale(""
									+ entity.getRegionalGeografica()
											.getIdRege(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idRege_RegionalGeografica");
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

			if (entity.getTipoSucursal().getIdTisu() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"idTisu_TipoSucursal");
			}

			if ((entity.getTipoSucursal().getIdTisu() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getTipoSucursal().getIdTisu(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"idTisu_TipoSucursal");
			}

			sucursalDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<SucursalDTO> getDataSucursal() throws Exception {
		try {
			List<Sucursal> sucursal = sucursalDAO.findAll();

			List<SucursalDTO> sucursalDTO = new ArrayList<SucursalDTO>();

			for (Sucursal sucursalTmp : sucursal) {
				SucursalDTO sucursalDTO2 = new SucursalDTO();

				sucursalDTO2.setIdSucu(sucursalTmp.getIdSucu());
				sucursalDTO2
						.setCodigo((sucursalTmp.getCodigo() != null) ? sucursalTmp
								.getCodigo() : null);
				sucursalDTO2
						.setDireccion((sucursalTmp.getDireccion() != null) ? sucursalTmp
								.getDireccion() : null);
				sucursalDTO2
						.setEmail((sucursalTmp.getEmail() != null) ? sucursalTmp
								.getEmail() : null);
				sucursalDTO2
						.setEstadoRegistro((sucursalTmp.getEstadoRegistro() != null) ? sucursalTmp
								.getEstadoRegistro() : null);
				sucursalDTO2
						.setEstadoSucursal((sucursalTmp.getEstadoSucursal() != null) ? sucursalTmp
								.getEstadoSucursal() : null);
				sucursalDTO2.setFechaCreacion(sucursalTmp.getFechaCreacion());
				sucursalDTO2.setFechaModificacion(sucursalTmp
						.getFechaModificacion());
				sucursalDTO2
						.setNombre((sucursalTmp.getNombre() != null) ? sucursalTmp
								.getNombre() : null);
				sucursalDTO2
						.setOperCreador((sucursalTmp.getOperCreador() != null) ? sucursalTmp
								.getOperCreador() : null);
				sucursalDTO2
						.setOperModifica((sucursalTmp.getOperModifica() != null) ? sucursalTmp
								.getOperModifica() : null);
				sucursalDTO2
						.setTelefono((sucursalTmp.getTelefono() != null) ? sucursalTmp
								.getTelefono() : null);
				sucursalDTO2
						.setZipCode((sucursalTmp.getZipCode() != null) ? sucursalTmp
								.getZipCode() : null);
				sucursalDTO2
						.setIdDipo_DivisionPolitica((sucursalTmp
								.getDivisionPolitica().getIdDipo() != null) ? sucursalTmp
								.getDivisionPolitica().getIdDipo() : null);

				if (sucursalTmp.getEmpresa() != null) {
					sucursalDTO2.setIdEmpr_Empresa(sucursalTmp.getEmpresa()
							.getIdEmpr());
				} else {
					sucursalDTO2.setIdEmpr_Empresa(null);
				}

				if (sucursalTmp.getPersona() != null) {
					sucursalDTO2.setIdPers_Persona(sucursalTmp.getPersona()
							.getIdPers());
				} else {
					sucursalDTO2.setIdPers_Persona(null);
				}

				sucursalDTO2
						.setIdRege_RegionalGeografica((sucursalTmp
								.getRegionalGeografica().getIdRege() != null) ? sucursalTmp
								.getRegionalGeografica().getIdRege() : null);

				if (sucursalTmp.getSucursal() != null) {
					sucursalDTO2.setIdSucu_Sucursal(sucursalTmp.getSucursal()
							.getIdSucu());
				} else {
					sucursalDTO2.setIdSucu_Sucursal(null);
				}

				sucursalDTO2.setIdTisu_TipoSucursal((sucursalTmp
						.getTipoSucursal().getIdTisu() != null) ? sucursalTmp
						.getTipoSucursal().getIdTisu() : null);
				sucursalDTO.add(sucursalDTO2);
			}

			return sucursalDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Sucursal getSucursal(Long idSucu) throws Exception {
		Sucursal entity = null;

		try {
			entity = sucursalDAO.findById(idSucu);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Sucursal");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Sucursal> findPageSucursal(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Sucursal> entity = null;

		try {
			entity = sucursalDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Sucursal Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberSucursal() throws Exception {
		Long entity = null;

		try {
			entity = sucursalDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Sucursal Count");
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
	public List<Sucursal> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Sucursal> list = new ArrayList<Sucursal>();
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
			list = sucursalDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
