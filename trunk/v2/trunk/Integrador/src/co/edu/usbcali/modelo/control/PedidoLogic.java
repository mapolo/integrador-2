package co.edu.usbcali.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.dataaccess.dao.IPedidoDAO;
import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.Pedido;
import co.edu.usbcali.modelo.dto.PedidoDTO;
import co.edu.usbcali.utilities.Utilities;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@Scope("singleton")
@Service("PedidoLogic")
public class PedidoLogic implements IPedidoLogic {
	/**
	 * DAO injected by Spring that manages Pedido entities
	 * 
	 */
	@Autowired
	private IPedidoDAO pedidoDAO;

	/**
	 * Logic injected by Spring that manages Documento entities
	 * 
	 */
	@Autowired
	IDocumentoLogic logicDocumento1;

	/**
	 * Logic injected by Spring that manages Referencia entities
	 * 
	 */
	@Autowired
	IReferenciaLogic logicReferencia2;

	@Transactional(readOnly = true)
	public List<Pedido> getPedido() throws Exception {
		List<Pedido> list = new ArrayList<Pedido>();

		try {
			list = pedidoDAO.findAll();
		} catch (Exception e) {
			throw new ZMessManager().new GettingException(ZMessManager.ALL
					+ "Pedido");
		} finally {
		}

		return list;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void savePedido(Pedido entity) throws Exception {
		try {
			if (entity.getDocumento() == null) {
				throw new ZMessManager().new ForeignException("documento");
			}

			if (entity.getReferencia() == null) {
				throw new ZMessManager().new ForeignException("referencia");
			}

			if ((entity.getCantidadAdicionadas() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadAdicionadas(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadAdicionadas");
			}

			if ((entity.getCantidadCanceladas() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadCanceladas(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadCanceladas");
			}

			if ((entity.getCantidadComprometida() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadComprometida(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadComprometida");
			}

			if ((entity.getCantidadDespRecibir() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadDespRecibir(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadDespRecibir");
			}

			if ((entity.getCantidadOrdenada() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadOrdenada(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadOrdenada");
			}

			if ((entity.getCantidadPedidas() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadPedidas(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadPedidas");
			}

			if ((entity.getClasePedido() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getClasePedido(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"clasePedido");
			}

			if ((entity.getComprometida() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getComprometida(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"comprometida");
			}

			if ((entity.getCondicionPago() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCondicionPago(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"condicionPago");
			}

			if ((entity.getCostoVenta() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCostoVenta(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"costoVenta");
			}

			if ((entity.getEspacios() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEspacios(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("espacios");
			}

			if ((entity.getEstadoPedido() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEstadoPedido(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"estadoPedido");
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

			if ((entity.getEstadoSysgol() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEstadoSysgol(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"estadoSysgol");
			}

			if ((entity.getExistenciaAnterior() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getExistenciaAnterior(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"existenciaAnterior");
			}

			if (entity.getFechaCreacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaCreacion");
			}

			if (entity.getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaModificacion");
			}

			if ((entity.getHoraPedido() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getHoraPedido(), 5) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"horaPedido");
			}

			if (entity.getIdPddo() == null) {
				throw new ZMessManager().new EmptyFieldException("idPddo");
			}

			if ((entity.getIdPddo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdPddo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idPddo");
			}

			if ((entity.getNumeroFactura() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroFactura(), 20, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroFactura");
			}

			if ((entity.getNumeroPedido() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroPedido(), 20, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroPedido");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getObservacion(), 1000) == false)) {
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

			if ((entity.getOrdenDespacho() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getOrdenDespacho(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"ordenDespacho");
			}

			if ((entity.getPorcentajeDescuento() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPorcentajeDescuento(), 3, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"porcentajeDescuento");
			}

			if ((entity.getPrecioEspecial() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getPrecioEspecial(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"precioEspecial");
			}

			if ((entity.getPrecioVenta() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPrecioVenta(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"precioVenta");
			}

			if ((entity.getUrgencia() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getUrgencia(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("urgencia");
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

			if (getPedido(entity.getIdPddo()) != null) {
				throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
			}

			pedidoDAO.save(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void deletePedido(Pedido entity) throws Exception {
		if (entity == null) {
			throw new ZMessManager().new NullEntityExcepcion("Pedido");
		}

		if (entity.getIdPddo() == null) {
			throw new ZMessManager().new EmptyFieldException("idPddo");
		}

		try {
			pedidoDAO.delete(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void updatePedido(Pedido entity) throws Exception {
		try {
			if (entity == null) {
				throw new ZMessManager().new NullEntityExcepcion("Pedido");
			}

			if (entity.getDocumento() == null) {
				throw new ZMessManager().new ForeignException("documento");
			}

			if (entity.getReferencia() == null) {
				throw new ZMessManager().new ForeignException("referencia");
			}

			if ((entity.getCantidadAdicionadas() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadAdicionadas(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadAdicionadas");
			}

			if ((entity.getCantidadCanceladas() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadCanceladas(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadCanceladas");
			}

			if ((entity.getCantidadComprometida() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadComprometida(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadComprometida");
			}

			if ((entity.getCantidadDespRecibir() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadDespRecibir(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadDespRecibir");
			}

			if ((entity.getCantidadOrdenada() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadOrdenada(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadOrdenada");
			}

			if ((entity.getCantidadPedidas() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCantidadPedidas(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"cantidadPedidas");
			}

			if ((entity.getClasePedido() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getClasePedido(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"clasePedido");
			}

			if ((entity.getComprometida() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getComprometida(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"comprometida");
			}

			if ((entity.getCondicionPago() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getCondicionPago(), 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"condicionPago");
			}

			if ((entity.getCostoVenta() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getCostoVenta(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"costoVenta");
			}

			if ((entity.getEspacios() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEspacios(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("espacios");
			}

			if ((entity.getEstadoPedido() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEstadoPedido(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"estadoPedido");
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

			if ((entity.getEstadoSysgol() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getEstadoSysgol(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"estadoSysgol");
			}

			if ((entity.getExistenciaAnterior() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getExistenciaAnterior(), 12, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"existenciaAnterior");
			}

			if (entity.getFechaCreacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaCreacion");
			}

			if (entity.getFechaModificacion() == null) {
				throw new ZMessManager().new EmptyFieldException(
						"fechaModificacion");
			}

			if ((entity.getHoraPedido() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getHoraPedido(), 5) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"horaPedido");
			}

			if (entity.getIdPddo() == null) {
				throw new ZMessManager().new EmptyFieldException("idPddo");
			}

			if ((entity.getIdPddo() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getIdPddo(), 10, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException("idPddo");
			}

			if ((entity.getNumeroFactura() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroFactura(), 20, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroFactura");
			}

			if ((entity.getNumeroPedido() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getNumeroPedido(), 20, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"numeroPedido");
			}

			if ((entity.getObservacion() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getObservacion(), 1000) == false)) {
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

			if ((entity.getOrdenDespacho() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getOrdenDespacho(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"ordenDespacho");
			}

			if ((entity.getPorcentajeDescuento() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPorcentajeDescuento(), 3, 3) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"porcentajeDescuento");
			}

			if ((entity.getPrecioEspecial() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getPrecioEspecial(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"precioEspecial");
			}

			if ((entity.getPrecioVenta() != null)
					&& (Utilities.checkNumberAndCheckWithPrecisionAndScale(""
							+ entity.getPrecioVenta(), 14, 0) == false)) {
				throw new ZMessManager().new NotValidFormatException(
						"precioVenta");
			}

			if ((entity.getUrgencia() != null)
					&& (Utilities.checkWordAndCheckWithlength(
							entity.getUrgencia(), 1) == false)) {
				throw new ZMessManager().new NotValidFormatException("urgencia");
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

			pedidoDAO.update(entity);
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	@Transactional(readOnly = true)
	public List<PedidoDTO> getDataPedido() throws Exception {
		try {
			List<Pedido> pedido = pedidoDAO.findAll();

			List<PedidoDTO> pedidoDTO = new ArrayList<PedidoDTO>();

			for (Pedido pedidoTmp : pedido) {
				PedidoDTO pedidoDTO2 = new PedidoDTO();

				pedidoDTO2.setIdPddo(pedidoTmp.getIdPddo());
				pedidoDTO2.setCantidadAdicionadas((pedidoTmp
						.getCantidadAdicionadas() != null) ? pedidoTmp
						.getCantidadAdicionadas() : null);
				pedidoDTO2.setCantidadCanceladas((pedidoTmp
						.getCantidadCanceladas() != null) ? pedidoTmp
						.getCantidadCanceladas() : null);
				pedidoDTO2.setCantidadComprometida((pedidoTmp
						.getCantidadComprometida() != null) ? pedidoTmp
						.getCantidadComprometida() : null);
				pedidoDTO2.setCantidadDespRecibir((pedidoTmp
						.getCantidadDespRecibir() != null) ? pedidoTmp
						.getCantidadDespRecibir() : null);
				pedidoDTO2
						.setCantidadOrdenada((pedidoTmp.getCantidadOrdenada() != null) ? pedidoTmp
								.getCantidadOrdenada() : null);
				pedidoDTO2
						.setCantidadPedidas((pedidoTmp.getCantidadPedidas() != null) ? pedidoTmp
								.getCantidadPedidas() : null);
				pedidoDTO2
						.setClasePedido((pedidoTmp.getClasePedido() != null) ? pedidoTmp
								.getClasePedido() : null);
				pedidoDTO2
						.setComprometida((pedidoTmp.getComprometida() != null) ? pedidoTmp
								.getComprometida() : null);
				pedidoDTO2
						.setCondicionPago((pedidoTmp.getCondicionPago() != null) ? pedidoTmp
								.getCondicionPago() : null);
				pedidoDTO2
						.setCostoVenta((pedidoTmp.getCostoVenta() != null) ? pedidoTmp
								.getCostoVenta() : null);
				pedidoDTO2
						.setEspacios((pedidoTmp.getEspacios() != null) ? pedidoTmp
								.getEspacios() : null);
				pedidoDTO2
						.setEstadoPedido((pedidoTmp.getEstadoPedido() != null) ? pedidoTmp
								.getEstadoPedido() : null);
				pedidoDTO2
						.setEstadoRegistro((pedidoTmp.getEstadoRegistro() != null) ? pedidoTmp
								.getEstadoRegistro() : null);
				pedidoDTO2
						.setEstadoSysgol((pedidoTmp.getEstadoSysgol() != null) ? pedidoTmp
								.getEstadoSysgol() : null);
				pedidoDTO2.setExistenciaAnterior((pedidoTmp
						.getExistenciaAnterior() != null) ? pedidoTmp
						.getExistenciaAnterior() : null);
				pedidoDTO2.setFechaCreacion(pedidoTmp.getFechaCreacion());
				pedidoDTO2.setFechaDeseada(pedidoTmp.getFechaDeseada());
				pedidoDTO2.setFechaFactura(pedidoTmp.getFechaFactura());
				pedidoDTO2.setFechaModificacion(pedidoTmp
						.getFechaModificacion());
				pedidoDTO2.setFechaPedido(pedidoTmp.getFechaPedido());
				pedidoDTO2
						.setHoraPedido((pedidoTmp.getHoraPedido() != null) ? pedidoTmp
								.getHoraPedido() : null);
				pedidoDTO2
						.setNumeroFactura((pedidoTmp.getNumeroFactura() != null) ? pedidoTmp
								.getNumeroFactura() : null);
				pedidoDTO2
						.setNumeroPedido((pedidoTmp.getNumeroPedido() != null) ? pedidoTmp
								.getNumeroPedido() : null);
				pedidoDTO2
						.setObservacion((pedidoTmp.getObservacion() != null) ? pedidoTmp
								.getObservacion() : null);
				pedidoDTO2
						.setOperCreador((pedidoTmp.getOperCreador() != null) ? pedidoTmp
								.getOperCreador() : null);
				pedidoDTO2
						.setOperModifica((pedidoTmp.getOperModifica() != null) ? pedidoTmp
								.getOperModifica() : null);
				pedidoDTO2
						.setOrdenDespacho((pedidoTmp.getOrdenDespacho() != null) ? pedidoTmp
								.getOrdenDespacho() : null);
				pedidoDTO2.setPorcentajeDescuento((pedidoTmp
						.getPorcentajeDescuento() != null) ? pedidoTmp
						.getPorcentajeDescuento() : null);
				pedidoDTO2
						.setPrecioEspecial((pedidoTmp.getPrecioEspecial() != null) ? pedidoTmp
								.getPrecioEspecial() : null);
				pedidoDTO2
						.setPrecioVenta((pedidoTmp.getPrecioVenta() != null) ? pedidoTmp
								.getPrecioVenta() : null);
				pedidoDTO2
						.setUrgencia((pedidoTmp.getUrgencia() != null) ? pedidoTmp
								.getUrgencia() : null);
				pedidoDTO2.setIdDocu_Documento((pedidoTmp.getDocumento()
						.getIdDocu() != null) ? pedidoTmp.getDocumento()
						.getIdDocu() : null);
				pedidoDTO2.setIdRefe_Referencia((pedidoTmp.getReferencia()
						.getIdRefe() != null) ? pedidoTmp.getReferencia()
						.getIdRefe() : null);
				pedidoDTO.add(pedidoDTO2);
			}

			return pedidoDTO;
		} catch (Exception e) {
			throw e;
		}
	}

	@Transactional(readOnly = true)
	public Pedido getPedido(Long idPddo) throws Exception {
		Pedido entity = null;

		try {
			entity = pedidoDAO.findById(idPddo);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Pedido");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public List<Pedido> findPagePedido(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception {
		List<Pedido> entity = null;

		try {
			entity = pedidoDAO.findPage(sortColumnName, sortAscending,
					startRow, maxResults);
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Pedido Count");
		} finally {
		}

		return entity;
	}

	@Transactional(readOnly = true)
	public Long findTotalNumberPedido() throws Exception {
		Long entity = null;

		try {
			entity = pedidoDAO.count();
		} catch (Exception e) {
			throw new ZMessManager().new FindingException("Pedido Count");
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
	public List<Pedido> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception {
		List<Pedido> list = new ArrayList<Pedido>();
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
			list = pedidoDAO.findByCriteria(where);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
		}

		return list;
	}
}
