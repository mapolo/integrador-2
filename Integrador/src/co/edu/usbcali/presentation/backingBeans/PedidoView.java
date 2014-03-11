package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.PedidoDTO;
import co.edu.usbcali.presentation.businessDelegate.*;
import co.edu.usbcali.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class PedidoView {
	private InputText txtCantidadAdicionadas;
	private InputText txtCantidadCanceladas;
	private InputText txtCantidadComprometida;
	private InputText txtCantidadDespRecibir;
	private InputText txtCantidadOrdenada;
	private InputText txtCantidadPedidas;
	private InputText txtClasePedido;
	private InputText txtComprometida;
	private InputText txtCondicionPago;
	private InputText txtCostoVenta;
	private InputText txtEspacios;
	private InputText txtEstadoPedido;
	private InputText txtEstadoRegistro;
	private InputText txtEstadoSysgol;
	private InputText txtExistenciaAnterior;
	private InputText txtHoraPedido;
	private InputText txtNumeroFactura;
	private InputText txtNumeroPedido;
	private InputText txtObservacion;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtOrdenDespacho;
	private InputText txtPorcentajeDescuento;
	private InputText txtPrecioEspecial;
	private InputText txtPrecioVenta;
	private InputText txtUrgencia;
	private InputText txtIdDocu_Documento;
	private InputText txtIdRefe_Referencia;
	private InputText txtIdPddo;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaDeseada;
	private Calendar txtFechaFactura;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaPedido;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<PedidoDTO> data;
	private PedidoDTO selectedPedido;
	private Pedido entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public PedidoView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			PedidoDTO pedidoDTO = (PedidoDTO) e.getObject();

			if (txtCantidadAdicionadas == null) {
				txtCantidadAdicionadas = new InputText();
			}

			txtCantidadAdicionadas.setValue(pedidoDTO.getCantidadAdicionadas());

			if (txtCantidadCanceladas == null) {
				txtCantidadCanceladas = new InputText();
			}

			txtCantidadCanceladas.setValue(pedidoDTO.getCantidadCanceladas());

			if (txtCantidadComprometida == null) {
				txtCantidadComprometida = new InputText();
			}

			txtCantidadComprometida.setValue(pedidoDTO
					.getCantidadComprometida());

			if (txtCantidadDespRecibir == null) {
				txtCantidadDespRecibir = new InputText();
			}

			txtCantidadDespRecibir.setValue(pedidoDTO.getCantidadDespRecibir());

			if (txtCantidadOrdenada == null) {
				txtCantidadOrdenada = new InputText();
			}

			txtCantidadOrdenada.setValue(pedidoDTO.getCantidadOrdenada());

			if (txtCantidadPedidas == null) {
				txtCantidadPedidas = new InputText();
			}

			txtCantidadPedidas.setValue(pedidoDTO.getCantidadPedidas());

			if (txtClasePedido == null) {
				txtClasePedido = new InputText();
			}

			txtClasePedido.setValue(pedidoDTO.getClasePedido());

			if (txtComprometida == null) {
				txtComprometida = new InputText();
			}

			txtComprometida.setValue(pedidoDTO.getComprometida());

			if (txtCondicionPago == null) {
				txtCondicionPago = new InputText();
			}

			txtCondicionPago.setValue(pedidoDTO.getCondicionPago());

			if (txtCostoVenta == null) {
				txtCostoVenta = new InputText();
			}

			txtCostoVenta.setValue(pedidoDTO.getCostoVenta());

			if (txtEspacios == null) {
				txtEspacios = new InputText();
			}

			txtEspacios.setValue(pedidoDTO.getEspacios());

			if (txtEstadoPedido == null) {
				txtEstadoPedido = new InputText();
			}

			txtEstadoPedido.setValue(pedidoDTO.getEstadoPedido());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(pedidoDTO.getEstadoRegistro());

			if (txtEstadoSysgol == null) {
				txtEstadoSysgol = new InputText();
			}

			txtEstadoSysgol.setValue(pedidoDTO.getEstadoSysgol());

			if (txtExistenciaAnterior == null) {
				txtExistenciaAnterior = new InputText();
			}

			txtExistenciaAnterior.setValue(pedidoDTO.getExistenciaAnterior());

			if (txtHoraPedido == null) {
				txtHoraPedido = new InputText();
			}

			txtHoraPedido.setValue(pedidoDTO.getHoraPedido());

			if (txtNumeroFactura == null) {
				txtNumeroFactura = new InputText();
			}

			txtNumeroFactura.setValue(pedidoDTO.getNumeroFactura());

			if (txtNumeroPedido == null) {
				txtNumeroPedido = new InputText();
			}

			txtNumeroPedido.setValue(pedidoDTO.getNumeroPedido());

			if (txtObservacion == null) {
				txtObservacion = new InputText();
			}

			txtObservacion.setValue(pedidoDTO.getObservacion());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(pedidoDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(pedidoDTO.getOperModifica());

			if (txtOrdenDespacho == null) {
				txtOrdenDespacho = new InputText();
			}

			txtOrdenDespacho.setValue(pedidoDTO.getOrdenDespacho());

			if (txtPorcentajeDescuento == null) {
				txtPorcentajeDescuento = new InputText();
			}

			txtPorcentajeDescuento.setValue(pedidoDTO.getPorcentajeDescuento());

			if (txtPrecioEspecial == null) {
				txtPrecioEspecial = new InputText();
			}

			txtPrecioEspecial.setValue(pedidoDTO.getPrecioEspecial());

			if (txtPrecioVenta == null) {
				txtPrecioVenta = new InputText();
			}

			txtPrecioVenta.setValue(pedidoDTO.getPrecioVenta());

			if (txtUrgencia == null) {
				txtUrgencia = new InputText();
			}

			txtUrgencia.setValue(pedidoDTO.getUrgencia());

			if (txtIdDocu_Documento == null) {
				txtIdDocu_Documento = new InputText();
			}

			txtIdDocu_Documento.setValue(pedidoDTO.getIdDocu_Documento());

			if (txtIdRefe_Referencia == null) {
				txtIdRefe_Referencia = new InputText();
			}

			txtIdRefe_Referencia.setValue(pedidoDTO.getIdRefe_Referencia());

			if (txtIdPddo == null) {
				txtIdPddo = new InputText();
			}

			txtIdPddo.setValue(pedidoDTO.getIdPddo());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(pedidoDTO.getFechaCreacion());

			if (txtFechaDeseada == null) {
				txtFechaDeseada = new Calendar();
			}

			txtFechaDeseada.setValue(pedidoDTO.getFechaDeseada());

			if (txtFechaFactura == null) {
				txtFechaFactura = new Calendar();
			}

			txtFechaFactura.setValue(pedidoDTO.getFechaFactura());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(pedidoDTO.getFechaModificacion());

			if (txtFechaPedido == null) {
				txtFechaPedido = new Calendar();
			}

			txtFechaPedido.setValue(pedidoDTO.getFechaPedido());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedPedido = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedPedido = null;

		if (txtCantidadAdicionadas != null) {
			txtCantidadAdicionadas.setValue(null);
			txtCantidadAdicionadas.setDisabled(true);
		}

		if (txtCantidadCanceladas != null) {
			txtCantidadCanceladas.setValue(null);
			txtCantidadCanceladas.setDisabled(true);
		}

		if (txtCantidadComprometida != null) {
			txtCantidadComprometida.setValue(null);
			txtCantidadComprometida.setDisabled(true);
		}

		if (txtCantidadDespRecibir != null) {
			txtCantidadDespRecibir.setValue(null);
			txtCantidadDespRecibir.setDisabled(true);
		}

		if (txtCantidadOrdenada != null) {
			txtCantidadOrdenada.setValue(null);
			txtCantidadOrdenada.setDisabled(true);
		}

		if (txtCantidadPedidas != null) {
			txtCantidadPedidas.setValue(null);
			txtCantidadPedidas.setDisabled(true);
		}

		if (txtClasePedido != null) {
			txtClasePedido.setValue(null);
			txtClasePedido.setDisabled(true);
		}

		if (txtComprometida != null) {
			txtComprometida.setValue(null);
			txtComprometida.setDisabled(true);
		}

		if (txtCondicionPago != null) {
			txtCondicionPago.setValue(null);
			txtCondicionPago.setDisabled(true);
		}

		if (txtCostoVenta != null) {
			txtCostoVenta.setValue(null);
			txtCostoVenta.setDisabled(true);
		}

		if (txtEspacios != null) {
			txtEspacios.setValue(null);
			txtEspacios.setDisabled(true);
		}

		if (txtEstadoPedido != null) {
			txtEstadoPedido.setValue(null);
			txtEstadoPedido.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtEstadoSysgol != null) {
			txtEstadoSysgol.setValue(null);
			txtEstadoSysgol.setDisabled(true);
		}

		if (txtExistenciaAnterior != null) {
			txtExistenciaAnterior.setValue(null);
			txtExistenciaAnterior.setDisabled(true);
		}

		if (txtHoraPedido != null) {
			txtHoraPedido.setValue(null);
			txtHoraPedido.setDisabled(true);
		}

		if (txtNumeroFactura != null) {
			txtNumeroFactura.setValue(null);
			txtNumeroFactura.setDisabled(true);
		}

		if (txtNumeroPedido != null) {
			txtNumeroPedido.setValue(null);
			txtNumeroPedido.setDisabled(true);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtOrdenDespacho != null) {
			txtOrdenDespacho.setValue(null);
			txtOrdenDespacho.setDisabled(true);
		}

		if (txtPorcentajeDescuento != null) {
			txtPorcentajeDescuento.setValue(null);
			txtPorcentajeDescuento.setDisabled(true);
		}

		if (txtPrecioEspecial != null) {
			txtPrecioEspecial.setValue(null);
			txtPrecioEspecial.setDisabled(true);
		}

		if (txtPrecioVenta != null) {
			txtPrecioVenta.setValue(null);
			txtPrecioVenta.setDisabled(true);
		}

		if (txtUrgencia != null) {
			txtUrgencia.setValue(null);
			txtUrgencia.setDisabled(true);
		}

		if (txtIdDocu_Documento != null) {
			txtIdDocu_Documento.setValue(null);
			txtIdDocu_Documento.setDisabled(true);
		}

		if (txtIdRefe_Referencia != null) {
			txtIdRefe_Referencia.setValue(null);
			txtIdRefe_Referencia.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaDeseada != null) {
			txtFechaDeseada.setValue(null);
			txtFechaDeseada.setDisabled(true);
		}

		if (txtFechaFactura != null) {
			txtFechaFactura.setValue(null);
			txtFechaFactura.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtFechaPedido != null) {
			txtFechaPedido.setValue(null);
			txtFechaPedido.setDisabled(true);
		}

		if (txtIdPddo != null) {
			txtIdPddo.setValue(null);
			txtIdPddo.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		return "";
	}

	public void listener_txtFechaCreacion() {
		Date inputDate = (Date) txtFechaCreacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaDeseada() {
		Date inputDate = (Date) txtFechaDeseada.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaFactura() {
		Date inputDate = (Date) txtFechaFactura.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaModificacion() {
		Date inputDate = (Date) txtFechaModificacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaPedido() {
		Date inputDate = (Date) txtFechaPedido.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Long idPddo = new Long(txtIdPddo.getValue().toString());
			entity = businessDelegatorView.getPedido(idPddo);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtCantidadAdicionadas.setDisabled(false);
			txtCantidadCanceladas.setDisabled(false);
			txtCantidadComprometida.setDisabled(false);
			txtCantidadDespRecibir.setDisabled(false);
			txtCantidadOrdenada.setDisabled(false);
			txtCantidadPedidas.setDisabled(false);
			txtClasePedido.setDisabled(false);
			txtComprometida.setDisabled(false);
			txtCondicionPago.setDisabled(false);
			txtCostoVenta.setDisabled(false);
			txtEspacios.setDisabled(false);
			txtEstadoPedido.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtEstadoSysgol.setDisabled(false);
			txtExistenciaAnterior.setDisabled(false);
			txtHoraPedido.setDisabled(false);
			txtNumeroFactura.setDisabled(false);
			txtNumeroPedido.setDisabled(false);
			txtObservacion.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtOrdenDespacho.setDisabled(false);
			txtPorcentajeDescuento.setDisabled(false);
			txtPrecioEspecial.setDisabled(false);
			txtPrecioVenta.setDisabled(false);
			txtUrgencia.setDisabled(false);
			txtIdDocu_Documento.setDisabled(false);
			txtIdRefe_Referencia.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaDeseada.setDisabled(false);
			txtFechaFactura.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtFechaPedido.setDisabled(false);
			txtIdPddo.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCantidadAdicionadas.setValue(entity.getCantidadAdicionadas());
			txtCantidadAdicionadas.setDisabled(false);
			txtCantidadCanceladas.setValue(entity.getCantidadCanceladas());
			txtCantidadCanceladas.setDisabled(false);
			txtCantidadComprometida.setValue(entity.getCantidadComprometida());
			txtCantidadComprometida.setDisabled(false);
			txtCantidadDespRecibir.setValue(entity.getCantidadDespRecibir());
			txtCantidadDespRecibir.setDisabled(false);
			txtCantidadOrdenada.setValue(entity.getCantidadOrdenada());
			txtCantidadOrdenada.setDisabled(false);
			txtCantidadPedidas.setValue(entity.getCantidadPedidas());
			txtCantidadPedidas.setDisabled(false);
			txtClasePedido.setValue(entity.getClasePedido());
			txtClasePedido.setDisabled(false);
			txtComprometida.setValue(entity.getComprometida());
			txtComprometida.setDisabled(false);
			txtCondicionPago.setValue(entity.getCondicionPago());
			txtCondicionPago.setDisabled(false);
			txtCostoVenta.setValue(entity.getCostoVenta());
			txtCostoVenta.setDisabled(false);
			txtEspacios.setValue(entity.getEspacios());
			txtEspacios.setDisabled(false);
			txtEstadoPedido.setValue(entity.getEstadoPedido());
			txtEstadoPedido.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtEstadoSysgol.setValue(entity.getEstadoSysgol());
			txtEstadoSysgol.setDisabled(false);
			txtExistenciaAnterior.setValue(entity.getExistenciaAnterior());
			txtExistenciaAnterior.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaDeseada.setValue(entity.getFechaDeseada());
			txtFechaDeseada.setDisabled(false);
			txtFechaFactura.setValue(entity.getFechaFactura());
			txtFechaFactura.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtFechaPedido.setValue(entity.getFechaPedido());
			txtFechaPedido.setDisabled(false);
			txtHoraPedido.setValue(entity.getHoraPedido());
			txtHoraPedido.setDisabled(false);
			txtNumeroFactura.setValue(entity.getNumeroFactura());
			txtNumeroFactura.setDisabled(false);
			txtNumeroPedido.setValue(entity.getNumeroPedido());
			txtNumeroPedido.setDisabled(false);
			txtObservacion.setValue(entity.getObservacion());
			txtObservacion.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtOrdenDespacho.setValue(entity.getOrdenDespacho());
			txtOrdenDespacho.setDisabled(false);
			txtPorcentajeDescuento.setValue(entity.getPorcentajeDescuento());
			txtPorcentajeDescuento.setDisabled(false);
			txtPrecioEspecial.setValue(entity.getPrecioEspecial());
			txtPrecioEspecial.setDisabled(false);
			txtPrecioVenta.setValue(entity.getPrecioVenta());
			txtPrecioVenta.setDisabled(false);
			txtUrgencia.setValue(entity.getUrgencia());
			txtUrgencia.setDisabled(false);
			txtIdDocu_Documento.setValue(entity.getDocumento().getIdDocu());
			txtIdDocu_Documento.setDisabled(false);
			txtIdRefe_Referencia.setValue(entity.getReferencia().getIdRefe());
			txtIdRefe_Referencia.setDisabled(false);
			txtIdPddo.setValue(entity.getIdPddo());
			txtIdPddo.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedPedido = (PedidoDTO) (evt.getComponent().getAttributes()
				.get("selectedPedido"));
		txtCantidadAdicionadas
				.setValue(selectedPedido.getCantidadAdicionadas());
		txtCantidadAdicionadas.setDisabled(false);
		txtCantidadCanceladas.setValue(selectedPedido.getCantidadCanceladas());
		txtCantidadCanceladas.setDisabled(false);
		txtCantidadComprometida.setValue(selectedPedido
				.getCantidadComprometida());
		txtCantidadComprometida.setDisabled(false);
		txtCantidadDespRecibir
				.setValue(selectedPedido.getCantidadDespRecibir());
		txtCantidadDespRecibir.setDisabled(false);
		txtCantidadOrdenada.setValue(selectedPedido.getCantidadOrdenada());
		txtCantidadOrdenada.setDisabled(false);
		txtCantidadPedidas.setValue(selectedPedido.getCantidadPedidas());
		txtCantidadPedidas.setDisabled(false);
		txtClasePedido.setValue(selectedPedido.getClasePedido());
		txtClasePedido.setDisabled(false);
		txtComprometida.setValue(selectedPedido.getComprometida());
		txtComprometida.setDisabled(false);
		txtCondicionPago.setValue(selectedPedido.getCondicionPago());
		txtCondicionPago.setDisabled(false);
		txtCostoVenta.setValue(selectedPedido.getCostoVenta());
		txtCostoVenta.setDisabled(false);
		txtEspacios.setValue(selectedPedido.getEspacios());
		txtEspacios.setDisabled(false);
		txtEstadoPedido.setValue(selectedPedido.getEstadoPedido());
		txtEstadoPedido.setDisabled(false);
		txtEstadoRegistro.setValue(selectedPedido.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtEstadoSysgol.setValue(selectedPedido.getEstadoSysgol());
		txtEstadoSysgol.setDisabled(false);
		txtExistenciaAnterior.setValue(selectedPedido.getExistenciaAnterior());
		txtExistenciaAnterior.setDisabled(false);
		txtFechaCreacion.setValue(selectedPedido.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaDeseada.setValue(selectedPedido.getFechaDeseada());
		txtFechaDeseada.setDisabled(false);
		txtFechaFactura.setValue(selectedPedido.getFechaFactura());
		txtFechaFactura.setDisabled(false);
		txtFechaModificacion.setValue(selectedPedido.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtFechaPedido.setValue(selectedPedido.getFechaPedido());
		txtFechaPedido.setDisabled(false);
		txtHoraPedido.setValue(selectedPedido.getHoraPedido());
		txtHoraPedido.setDisabled(false);
		txtNumeroFactura.setValue(selectedPedido.getNumeroFactura());
		txtNumeroFactura.setDisabled(false);
		txtNumeroPedido.setValue(selectedPedido.getNumeroPedido());
		txtNumeroPedido.setDisabled(false);
		txtObservacion.setValue(selectedPedido.getObservacion());
		txtObservacion.setDisabled(false);
		txtOperCreador.setValue(selectedPedido.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedPedido.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtOrdenDespacho.setValue(selectedPedido.getOrdenDespacho());
		txtOrdenDespacho.setDisabled(false);
		txtPorcentajeDescuento
				.setValue(selectedPedido.getPorcentajeDescuento());
		txtPorcentajeDescuento.setDisabled(false);
		txtPrecioEspecial.setValue(selectedPedido.getPrecioEspecial());
		txtPrecioEspecial.setDisabled(false);
		txtPrecioVenta.setValue(selectedPedido.getPrecioVenta());
		txtPrecioVenta.setDisabled(false);
		txtUrgencia.setValue(selectedPedido.getUrgencia());
		txtUrgencia.setDisabled(false);
		txtIdDocu_Documento.setValue(selectedPedido.getIdDocu_Documento());
		txtIdDocu_Documento.setDisabled(false);
		txtIdRefe_Referencia.setValue(selectedPedido.getIdRefe_Referencia());
		txtIdRefe_Referencia.setDisabled(false);
		txtIdPddo.setValue(selectedPedido.getIdPddo());
		txtIdPddo.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedPedido == null) && (entity == null)) {
				action_create();
			} else {
				action_modify();
			}

			data = null;
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_create() {
		try {
			entity = new Pedido();

			Long idPddo = new Long(txtIdPddo.getValue().toString());

			entity.setCantidadAdicionadas(FacesUtils
					.checkDouble(txtCantidadAdicionadas));
			entity.setCantidadCanceladas(FacesUtils
					.checkDouble(txtCantidadCanceladas));
			entity.setCantidadComprometida(FacesUtils
					.checkDouble(txtCantidadComprometida));
			entity.setCantidadDespRecibir(FacesUtils
					.checkDouble(txtCantidadDespRecibir));
			entity.setCantidadOrdenada(FacesUtils
					.checkDouble(txtCantidadOrdenada));
			entity.setCantidadPedidas(FacesUtils
					.checkDouble(txtCantidadPedidas));
			entity.setClasePedido(FacesUtils.checkString(txtClasePedido));
			entity.setComprometida(FacesUtils.checkString(txtComprometida));
			entity.setCondicionPago(FacesUtils.checkString(txtCondicionPago));
			entity.setCostoVenta(FacesUtils.checkDouble(txtCostoVenta));
			entity.setEspacios(FacesUtils.checkString(txtEspacios));
			entity.setEstadoPedido(FacesUtils.checkString(txtEstadoPedido));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setEstadoSysgol(FacesUtils.checkString(txtEstadoSysgol));
			entity.setExistenciaAnterior(FacesUtils
					.checkDouble(txtExistenciaAnterior));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaDeseada(FacesUtils.checkDate(txtFechaDeseada));
			entity.setFechaFactura(FacesUtils.checkDate(txtFechaFactura));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaPedido(FacesUtils.checkDate(txtFechaPedido));
			entity.setHoraPedido(FacesUtils.checkString(txtHoraPedido));
			entity.setIdPddo(idPddo);
			entity.setNumeroFactura(FacesUtils.checkLong(txtNumeroFactura));
			entity.setNumeroPedido(FacesUtils.checkLong(txtNumeroPedido));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setOrdenDespacho(FacesUtils.checkString(txtOrdenDespacho));
			entity.setPorcentajeDescuento(FacesUtils
					.checkDouble(txtPorcentajeDescuento));
			entity.setPrecioEspecial(FacesUtils.checkString(txtPrecioEspecial));
			entity.setPrecioVenta(FacesUtils.checkDouble(txtPrecioVenta));
			entity.setUrgencia(FacesUtils.checkString(txtUrgencia));
			entity.setDocumento(businessDelegatorView.getDocumento(FacesUtils
					.checkLong(txtIdDocu_Documento)));
			entity.setReferencia(businessDelegatorView.getReferencia(FacesUtils
					.checkLong(txtIdRefe_Referencia)));
			businessDelegatorView.savePedido(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modify() {
		try {
			if (entity == null) {
				Long idPddo = new Long(selectedPedido.getIdPddo());
				entity = businessDelegatorView.getPedido(idPddo);
			}

			entity.setCantidadAdicionadas(FacesUtils
					.checkDouble(txtCantidadAdicionadas));
			entity.setCantidadCanceladas(FacesUtils
					.checkDouble(txtCantidadCanceladas));
			entity.setCantidadComprometida(FacesUtils
					.checkDouble(txtCantidadComprometida));
			entity.setCantidadDespRecibir(FacesUtils
					.checkDouble(txtCantidadDespRecibir));
			entity.setCantidadOrdenada(FacesUtils
					.checkDouble(txtCantidadOrdenada));
			entity.setCantidadPedidas(FacesUtils
					.checkDouble(txtCantidadPedidas));
			entity.setClasePedido(FacesUtils.checkString(txtClasePedido));
			entity.setComprometida(FacesUtils.checkString(txtComprometida));
			entity.setCondicionPago(FacesUtils.checkString(txtCondicionPago));
			entity.setCostoVenta(FacesUtils.checkDouble(txtCostoVenta));
			entity.setEspacios(FacesUtils.checkString(txtEspacios));
			entity.setEstadoPedido(FacesUtils.checkString(txtEstadoPedido));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setEstadoSysgol(FacesUtils.checkString(txtEstadoSysgol));
			entity.setExistenciaAnterior(FacesUtils
					.checkDouble(txtExistenciaAnterior));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaDeseada(FacesUtils.checkDate(txtFechaDeseada));
			entity.setFechaFactura(FacesUtils.checkDate(txtFechaFactura));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaPedido(FacesUtils.checkDate(txtFechaPedido));
			entity.setHoraPedido(FacesUtils.checkString(txtHoraPedido));
			entity.setNumeroFactura(FacesUtils.checkLong(txtNumeroFactura));
			entity.setNumeroPedido(FacesUtils.checkLong(txtNumeroPedido));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setOrdenDespacho(FacesUtils.checkString(txtOrdenDespacho));
			entity.setPorcentajeDescuento(FacesUtils
					.checkDouble(txtPorcentajeDescuento));
			entity.setPrecioEspecial(FacesUtils.checkString(txtPrecioEspecial));
			entity.setPrecioVenta(FacesUtils.checkDouble(txtPrecioVenta));
			entity.setUrgencia(FacesUtils.checkString(txtUrgencia));
			entity.setDocumento(businessDelegatorView.getDocumento(FacesUtils
					.checkLong(txtIdDocu_Documento)));
			entity.setReferencia(businessDelegatorView.getReferencia(FacesUtils
					.checkLong(txtIdRefe_Referencia)));
			businessDelegatorView.updatePedido(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedPedido = (PedidoDTO) (evt.getComponent().getAttributes()
					.get("selectedPedido"));

			Long idPddo = new Long(selectedPedido.getIdPddo());
			entity = businessDelegatorView.getPedido(idPddo);
			businessDelegatorView.deletePedido(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data = null;
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_closeDialog() {
		setShowDialog(false);
		action_clear();

		return "";
	}

	public String actionDeleteDataTableEditable(ActionEvent evt) {
		try {
			selectedPedido = (PedidoDTO) (evt.getComponent().getAttributes()
					.get("selectedPedido"));

			Long idPddo = new Long(selectedPedido.getIdPddo());
			entity = businessDelegatorView.getPedido(idPddo);
			businessDelegatorView.deletePedido(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedPedido);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Double cantidadAdicionadas,
			Double cantidadCanceladas, Double cantidadComprometida,
			Double cantidadDespRecibir, Double cantidadOrdenada,
			Double cantidadPedidas, String clasePedido, String comprometida,
			String condicionPago, Double costoVenta, String espacios,
			String estadoPedido, String estadoRegistro, String estadoSysgol,
			Double existenciaAnterior, Date fechaCreacion, Date fechaDeseada,
			Date fechaFactura, Date fechaModificacion, Date fechaPedido,
			String horaPedido, Long idPddo, Long numeroFactura,
			Long numeroPedido, String observacion, String operCreador,
			String operModifica, String ordenDespacho,
			Double porcentajeDescuento, String precioEspecial,
			Double precioVenta, String urgencia, Long idDocu_Documento,
			Long idRefe_Referencia) throws Exception {
		try {
			entity.setCantidadAdicionadas(FacesUtils
					.checkDouble(cantidadAdicionadas));
			entity.setCantidadCanceladas(FacesUtils
					.checkDouble(cantidadCanceladas));
			entity.setCantidadComprometida(FacesUtils
					.checkDouble(cantidadComprometida));
			entity.setCantidadDespRecibir(FacesUtils
					.checkDouble(cantidadDespRecibir));
			entity.setCantidadOrdenada(FacesUtils.checkDouble(cantidadOrdenada));
			entity.setCantidadPedidas(FacesUtils.checkDouble(cantidadPedidas));
			entity.setClasePedido(FacesUtils.checkString(clasePedido));
			entity.setComprometida(FacesUtils.checkString(comprometida));
			entity.setCondicionPago(FacesUtils.checkString(condicionPago));
			entity.setCostoVenta(FacesUtils.checkDouble(costoVenta));
			entity.setEspacios(FacesUtils.checkString(espacios));
			entity.setEstadoPedido(FacesUtils.checkString(estadoPedido));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setEstadoSysgol(FacesUtils.checkString(estadoSysgol));
			entity.setExistenciaAnterior(FacesUtils
					.checkDouble(existenciaAnterior));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaDeseada(FacesUtils.checkDate(fechaDeseada));
			entity.setFechaFactura(FacesUtils.checkDate(fechaFactura));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaPedido(FacesUtils.checkDate(fechaPedido));
			entity.setHoraPedido(FacesUtils.checkString(horaPedido));
			entity.setNumeroFactura(FacesUtils.checkLong(numeroFactura));
			entity.setNumeroPedido(FacesUtils.checkLong(numeroPedido));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setOrdenDespacho(FacesUtils.checkString(ordenDespacho));
			entity.setPorcentajeDescuento(FacesUtils
					.checkDouble(porcentajeDescuento));
			entity.setPrecioEspecial(FacesUtils.checkString(precioEspecial));
			entity.setPrecioVenta(FacesUtils.checkDouble(precioVenta));
			entity.setUrgencia(FacesUtils.checkString(urgencia));
			businessDelegatorView.updatePedido(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("PedidoView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCantidadAdicionadas() {
		return txtCantidadAdicionadas;
	}

	public void setTxtCantidadAdicionadas(InputText txtCantidadAdicionadas) {
		this.txtCantidadAdicionadas = txtCantidadAdicionadas;
	}

	public InputText getTxtCantidadCanceladas() {
		return txtCantidadCanceladas;
	}

	public void setTxtCantidadCanceladas(InputText txtCantidadCanceladas) {
		this.txtCantidadCanceladas = txtCantidadCanceladas;
	}

	public InputText getTxtCantidadComprometida() {
		return txtCantidadComprometida;
	}

	public void setTxtCantidadComprometida(InputText txtCantidadComprometida) {
		this.txtCantidadComprometida = txtCantidadComprometida;
	}

	public InputText getTxtCantidadDespRecibir() {
		return txtCantidadDespRecibir;
	}

	public void setTxtCantidadDespRecibir(InputText txtCantidadDespRecibir) {
		this.txtCantidadDespRecibir = txtCantidadDespRecibir;
	}

	public InputText getTxtCantidadOrdenada() {
		return txtCantidadOrdenada;
	}

	public void setTxtCantidadOrdenada(InputText txtCantidadOrdenada) {
		this.txtCantidadOrdenada = txtCantidadOrdenada;
	}

	public InputText getTxtCantidadPedidas() {
		return txtCantidadPedidas;
	}

	public void setTxtCantidadPedidas(InputText txtCantidadPedidas) {
		this.txtCantidadPedidas = txtCantidadPedidas;
	}

	public InputText getTxtClasePedido() {
		return txtClasePedido;
	}

	public void setTxtClasePedido(InputText txtClasePedido) {
		this.txtClasePedido = txtClasePedido;
	}

	public InputText getTxtComprometida() {
		return txtComprometida;
	}

	public void setTxtComprometida(InputText txtComprometida) {
		this.txtComprometida = txtComprometida;
	}

	public InputText getTxtCondicionPago() {
		return txtCondicionPago;
	}

	public void setTxtCondicionPago(InputText txtCondicionPago) {
		this.txtCondicionPago = txtCondicionPago;
	}

	public InputText getTxtCostoVenta() {
		return txtCostoVenta;
	}

	public void setTxtCostoVenta(InputText txtCostoVenta) {
		this.txtCostoVenta = txtCostoVenta;
	}

	public InputText getTxtEspacios() {
		return txtEspacios;
	}

	public void setTxtEspacios(InputText txtEspacios) {
		this.txtEspacios = txtEspacios;
	}

	public InputText getTxtEstadoPedido() {
		return txtEstadoPedido;
	}

	public void setTxtEstadoPedido(InputText txtEstadoPedido) {
		this.txtEstadoPedido = txtEstadoPedido;
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}

	public InputText getTxtEstadoSysgol() {
		return txtEstadoSysgol;
	}

	public void setTxtEstadoSysgol(InputText txtEstadoSysgol) {
		this.txtEstadoSysgol = txtEstadoSysgol;
	}

	public InputText getTxtExistenciaAnterior() {
		return txtExistenciaAnterior;
	}

	public void setTxtExistenciaAnterior(InputText txtExistenciaAnterior) {
		this.txtExistenciaAnterior = txtExistenciaAnterior;
	}

	public InputText getTxtHoraPedido() {
		return txtHoraPedido;
	}

	public void setTxtHoraPedido(InputText txtHoraPedido) {
		this.txtHoraPedido = txtHoraPedido;
	}

	public InputText getTxtNumeroFactura() {
		return txtNumeroFactura;
	}

	public void setTxtNumeroFactura(InputText txtNumeroFactura) {
		this.txtNumeroFactura = txtNumeroFactura;
	}

	public InputText getTxtNumeroPedido() {
		return txtNumeroPedido;
	}

	public void setTxtNumeroPedido(InputText txtNumeroPedido) {
		this.txtNumeroPedido = txtNumeroPedido;
	}

	public InputText getTxtObservacion() {
		return txtObservacion;
	}

	public void setTxtObservacion(InputText txtObservacion) {
		this.txtObservacion = txtObservacion;
	}

	public InputText getTxtOperCreador() {
		return txtOperCreador;
	}

	public void setTxtOperCreador(InputText txtOperCreador) {
		this.txtOperCreador = txtOperCreador;
	}

	public InputText getTxtOperModifica() {
		return txtOperModifica;
	}

	public void setTxtOperModifica(InputText txtOperModifica) {
		this.txtOperModifica = txtOperModifica;
	}

	public InputText getTxtOrdenDespacho() {
		return txtOrdenDespacho;
	}

	public void setTxtOrdenDespacho(InputText txtOrdenDespacho) {
		this.txtOrdenDespacho = txtOrdenDespacho;
	}

	public InputText getTxtPorcentajeDescuento() {
		return txtPorcentajeDescuento;
	}

	public void setTxtPorcentajeDescuento(InputText txtPorcentajeDescuento) {
		this.txtPorcentajeDescuento = txtPorcentajeDescuento;
	}

	public InputText getTxtPrecioEspecial() {
		return txtPrecioEspecial;
	}

	public void setTxtPrecioEspecial(InputText txtPrecioEspecial) {
		this.txtPrecioEspecial = txtPrecioEspecial;
	}

	public InputText getTxtPrecioVenta() {
		return txtPrecioVenta;
	}

	public void setTxtPrecioVenta(InputText txtPrecioVenta) {
		this.txtPrecioVenta = txtPrecioVenta;
	}

	public InputText getTxtUrgencia() {
		return txtUrgencia;
	}

	public void setTxtUrgencia(InputText txtUrgencia) {
		this.txtUrgencia = txtUrgencia;
	}

	public InputText getTxtIdDocu_Documento() {
		return txtIdDocu_Documento;
	}

	public void setTxtIdDocu_Documento(InputText txtIdDocu_Documento) {
		this.txtIdDocu_Documento = txtIdDocu_Documento;
	}

	public InputText getTxtIdRefe_Referencia() {
		return txtIdRefe_Referencia;
	}

	public void setTxtIdRefe_Referencia(InputText txtIdRefe_Referencia) {
		this.txtIdRefe_Referencia = txtIdRefe_Referencia;
	}

	public Calendar getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaDeseada() {
		return txtFechaDeseada;
	}

	public void setTxtFechaDeseada(Calendar txtFechaDeseada) {
		this.txtFechaDeseada = txtFechaDeseada;
	}

	public Calendar getTxtFechaFactura() {
		return txtFechaFactura;
	}

	public void setTxtFechaFactura(Calendar txtFechaFactura) {
		this.txtFechaFactura = txtFechaFactura;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public Calendar getTxtFechaPedido() {
		return txtFechaPedido;
	}

	public void setTxtFechaPedido(Calendar txtFechaPedido) {
		this.txtFechaPedido = txtFechaPedido;
	}

	public InputText getTxtIdPddo() {
		return txtIdPddo;
	}

	public void setTxtIdPddo(InputText txtIdPddo) {
		this.txtIdPddo = txtIdPddo;
	}

	public List<PedidoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataPedido();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<PedidoDTO> pedidoDTO) {
		this.data = pedidoDTO;
	}

	public PedidoDTO getSelectedPedido() {
		return selectedPedido;
	}

	public void setSelectedPedido(PedidoDTO pedido) {
		this.selectedPedido = pedido;
	}

	public CommandButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(CommandButton btnSave) {
		this.btnSave = btnSave;
	}

	public CommandButton getBtnModify() {
		return btnModify;
	}

	public void setBtnModify(CommandButton btnModify) {
		this.btnModify = btnModify;
	}

	public CommandButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(CommandButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public CommandButton getBtnClear() {
		return btnClear;
	}

	public void setBtnClear(CommandButton btnClear) {
		this.btnClear = btnClear;
	}

	public TimeZone getTimeZone() {
		return java.util.TimeZone.getDefault();
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(
			IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public boolean isShowDialog() {
		return showDialog;
	}

	public void setShowDialog(boolean showDialog) {
		this.showDialog = showDialog;
	}
}
