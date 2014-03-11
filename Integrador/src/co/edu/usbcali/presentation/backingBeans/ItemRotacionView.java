package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.ItemRotacionDTO;
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
public class ItemRotacionView {
	private InputText txtAutorizado;
	private InputText txtCantidadCambio;
	private InputText txtCantidadOrdenada;
	private InputText txtCantidadPedida;
	private InputText txtCausalNoCambio;
	private InputText txtEstado;
	private InputText txtEstadoRegistro;
	private InputText txtNumeroDespacho;
	private InputText txtNumeroGarantia;
	private InputText txtObservacion;
	private InputText txtObservacionCambio;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdClfa_ClaveFabricacion;
	private InputText txtIdDocu_Documento;
	private InputText txtIdRefe_Referencia;
	private InputText txtIdItro;
	private Calendar txtFechaAutorizacion;
	private Calendar txtFechaCambio;
	private Calendar txtFechaCausal;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaMovimiento;
	private Calendar txtFechaOrdenada;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ItemRotacionDTO> data;
	private ItemRotacionDTO selectedItemRotacion;
	private ItemRotacion entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ItemRotacionView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ItemRotacionDTO itemRotacionDTO = (ItemRotacionDTO) e.getObject();

			if (txtAutorizado == null) {
				txtAutorizado = new InputText();
			}

			txtAutorizado.setValue(itemRotacionDTO.getAutorizado());

			if (txtCantidadCambio == null) {
				txtCantidadCambio = new InputText();
			}

			txtCantidadCambio.setValue(itemRotacionDTO.getCantidadCambio());

			if (txtCantidadOrdenada == null) {
				txtCantidadOrdenada = new InputText();
			}

			txtCantidadOrdenada.setValue(itemRotacionDTO.getCantidadOrdenada());

			if (txtCantidadPedida == null) {
				txtCantidadPedida = new InputText();
			}

			txtCantidadPedida.setValue(itemRotacionDTO.getCantidadPedida());

			if (txtCausalNoCambio == null) {
				txtCausalNoCambio = new InputText();
			}

			txtCausalNoCambio.setValue(itemRotacionDTO.getCausalNoCambio());

			if (txtEstado == null) {
				txtEstado = new InputText();
			}

			txtEstado.setValue(itemRotacionDTO.getEstado());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(itemRotacionDTO.getEstadoRegistro());

			if (txtNumeroDespacho == null) {
				txtNumeroDespacho = new InputText();
			}

			txtNumeroDespacho.setValue(itemRotacionDTO.getNumeroDespacho());

			if (txtNumeroGarantia == null) {
				txtNumeroGarantia = new InputText();
			}

			txtNumeroGarantia.setValue(itemRotacionDTO.getNumeroGarantia());

			if (txtObservacion == null) {
				txtObservacion = new InputText();
			}

			txtObservacion.setValue(itemRotacionDTO.getObservacion());

			if (txtObservacionCambio == null) {
				txtObservacionCambio = new InputText();
			}

			txtObservacionCambio.setValue(itemRotacionDTO
					.getObservacionCambio());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(itemRotacionDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(itemRotacionDTO.getOperModifica());

			if (txtIdClfa_ClaveFabricacion == null) {
				txtIdClfa_ClaveFabricacion = new InputText();
			}

			txtIdClfa_ClaveFabricacion.setValue(itemRotacionDTO
					.getIdClfa_ClaveFabricacion());

			if (txtIdDocu_Documento == null) {
				txtIdDocu_Documento = new InputText();
			}

			txtIdDocu_Documento.setValue(itemRotacionDTO.getIdDocu_Documento());

			if (txtIdRefe_Referencia == null) {
				txtIdRefe_Referencia = new InputText();
			}

			if (txtIdItro == null) {
				txtIdItro = new InputText();
			}

			txtIdItro.setValue(itemRotacionDTO.getIdItro());

			if (txtFechaAutorizacion == null) {
				txtFechaAutorizacion = new Calendar();
			}

			txtFechaAutorizacion.setValue(itemRotacionDTO
					.getFechaAutorizacion());

			if (txtFechaCambio == null) {
				txtFechaCambio = new Calendar();
			}

			txtFechaCambio.setValue(itemRotacionDTO.getFechaCambio());

			if (txtFechaCausal == null) {
				txtFechaCausal = new Calendar();
			}

			txtFechaCausal.setValue(itemRotacionDTO.getFechaCausal());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(itemRotacionDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(itemRotacionDTO
					.getFechaModificacion());

			if (txtFechaMovimiento == null) {
				txtFechaMovimiento = new Calendar();
			}

			txtFechaMovimiento.setValue(itemRotacionDTO.getFechaMovimiento());

			if (txtFechaOrdenada == null) {
				txtFechaOrdenada = new Calendar();
			}

			txtFechaOrdenada.setValue(itemRotacionDTO.getFechaOrdenada());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedItemRotacion = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedItemRotacion = null;

		if (txtAutorizado != null) {
			txtAutorizado.setValue(null);
			txtAutorizado.setDisabled(true);
		}

		if (txtCantidadCambio != null) {
			txtCantidadCambio.setValue(null);
			txtCantidadCambio.setDisabled(true);
		}

		if (txtCantidadOrdenada != null) {
			txtCantidadOrdenada.setValue(null);
			txtCantidadOrdenada.setDisabled(true);
		}

		if (txtCantidadPedida != null) {
			txtCantidadPedida.setValue(null);
			txtCantidadPedida.setDisabled(true);
		}

		if (txtCausalNoCambio != null) {
			txtCausalNoCambio.setValue(null);
			txtCausalNoCambio.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue(null);
			txtEstado.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtNumeroDespacho != null) {
			txtNumeroDespacho.setValue(null);
			txtNumeroDespacho.setDisabled(true);
		}

		if (txtNumeroGarantia != null) {
			txtNumeroGarantia.setValue(null);
			txtNumeroGarantia.setDisabled(true);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(true);
		}

		if (txtObservacionCambio != null) {
			txtObservacionCambio.setValue(null);
			txtObservacionCambio.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtIdClfa_ClaveFabricacion != null) {
			txtIdClfa_ClaveFabricacion.setValue(null);
			txtIdClfa_ClaveFabricacion.setDisabled(true);
		}

		if (txtIdDocu_Documento != null) {
			txtIdDocu_Documento.setValue(null);
			txtIdDocu_Documento.setDisabled(true);
		}

		if (txtIdRefe_Referencia != null) {
			txtIdRefe_Referencia.setValue(null);
			txtIdRefe_Referencia.setDisabled(true);
		}

		if (txtFechaAutorizacion != null) {
			txtFechaAutorizacion.setValue(null);
			txtFechaAutorizacion.setDisabled(true);
		}

		if (txtFechaCambio != null) {
			txtFechaCambio.setValue(null);
			txtFechaCambio.setDisabled(true);
		}

		if (txtFechaCausal != null) {
			txtFechaCausal.setValue(null);
			txtFechaCausal.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtFechaMovimiento != null) {
			txtFechaMovimiento.setValue(null);
			txtFechaMovimiento.setDisabled(true);
		}

		if (txtFechaOrdenada != null) {
			txtFechaOrdenada.setValue(null);
			txtFechaOrdenada.setDisabled(true);
		}

		if (txtIdItro != null) {
			txtIdItro.setValue(null);
			txtIdItro.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		return "";
	}

	public void listener_txtFechaAutorizacion() {
		Date inputDate = (Date) txtFechaAutorizacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaCambio() {
		Date inputDate = (Date) txtFechaCambio.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaCausal() {
		Date inputDate = (Date) txtFechaCausal.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaCreacion() {
		Date inputDate = (Date) txtFechaCreacion.getValue();
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

	public void listener_txtFechaMovimiento() {
		Date inputDate = (Date) txtFechaMovimiento.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaOrdenada() {
		Date inputDate = (Date) txtFechaOrdenada.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Long idItro = new Long(txtIdItro.getValue().toString());
			entity = businessDelegatorView.getItemRotacion(idItro);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtAutorizado.setDisabled(false);
			txtCantidadCambio.setDisabled(false);
			txtCantidadOrdenada.setDisabled(false);
			txtCantidadPedida.setDisabled(false);
			txtCausalNoCambio.setDisabled(false);
			txtEstado.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtNumeroDespacho.setDisabled(false);
			txtNumeroGarantia.setDisabled(false);
			txtObservacion.setDisabled(false);
			txtObservacionCambio.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdClfa_ClaveFabricacion.setDisabled(false);
			txtIdDocu_Documento.setDisabled(false);
			txtIdRefe_Referencia.setDisabled(false);
			txtFechaAutorizacion.setDisabled(false);
			txtFechaCambio.setDisabled(false);
			txtFechaCausal.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtFechaMovimiento.setDisabled(false);
			txtFechaOrdenada.setDisabled(false);
			txtIdItro.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtAutorizado.setValue(entity.getAutorizado());
			txtAutorizado.setDisabled(false);
			txtCantidadCambio.setValue(entity.getCantidadCambio());
			txtCantidadCambio.setDisabled(false);
			txtCantidadOrdenada.setValue(entity.getCantidadOrdenada());
			txtCantidadOrdenada.setDisabled(false);
			txtCantidadPedida.setValue(entity.getCantidadPedida());
			txtCantidadPedida.setDisabled(false);
			txtCausalNoCambio.setValue(entity.getCausalNoCambio());
			txtCausalNoCambio.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaAutorizacion.setValue(entity.getFechaAutorizacion());
			txtFechaAutorizacion.setDisabled(false);
			txtFechaCambio.setValue(entity.getFechaCambio());
			txtFechaCambio.setDisabled(false);
			txtFechaCausal.setValue(entity.getFechaCausal());
			txtFechaCausal.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtFechaMovimiento.setValue(entity.getFechaMovimiento());
			txtFechaMovimiento.setDisabled(false);
			txtFechaOrdenada.setValue(entity.getFechaOrdenada());
			txtFechaOrdenada.setDisabled(false);
			txtNumeroDespacho.setValue(entity.getNumeroDespacho());
			txtNumeroDespacho.setDisabled(false);
			txtNumeroGarantia.setValue(entity.getNumeroGarantia());
			txtNumeroGarantia.setDisabled(false);
			txtObservacion.setValue(entity.getObservacion());
			txtObservacion.setDisabled(false);
			txtObservacionCambio.setValue(entity.getObservacionCambio());
			txtObservacionCambio.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdClfa_ClaveFabricacion.setValue(entity.getClaveFabricacion()
					.getIdClfa());
			txtIdClfa_ClaveFabricacion.setDisabled(false);
			txtIdDocu_Documento.setValue(entity.getDocumento().getIdDocu());
			txtIdDocu_Documento.setDisabled(false);

			txtIdRefe_Referencia.setDisabled(false);
			txtIdItro.setValue(entity.getIdItro());
			txtIdItro.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedItemRotacion = (ItemRotacionDTO) (evt.getComponent()
				.getAttributes().get("selectedItemRotacion"));
		txtAutorizado.setValue(selectedItemRotacion.getAutorizado());
		txtAutorizado.setDisabled(false);
		txtCantidadCambio.setValue(selectedItemRotacion.getCantidadCambio());
		txtCantidadCambio.setDisabled(false);
		txtCantidadOrdenada
				.setValue(selectedItemRotacion.getCantidadOrdenada());
		txtCantidadOrdenada.setDisabled(false);
		txtCantidadPedida.setValue(selectedItemRotacion.getCantidadPedida());
		txtCantidadPedida.setDisabled(false);
		txtCausalNoCambio.setValue(selectedItemRotacion.getCausalNoCambio());
		txtCausalNoCambio.setDisabled(false);
		txtEstado.setValue(selectedItemRotacion.getEstado());
		txtEstado.setDisabled(false);
		txtEstadoRegistro.setValue(selectedItemRotacion.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaAutorizacion.setValue(selectedItemRotacion
				.getFechaAutorizacion());
		txtFechaAutorizacion.setDisabled(false);
		txtFechaCambio.setValue(selectedItemRotacion.getFechaCambio());
		txtFechaCambio.setDisabled(false);
		txtFechaCausal.setValue(selectedItemRotacion.getFechaCausal());
		txtFechaCausal.setDisabled(false);
		txtFechaCreacion.setValue(selectedItemRotacion.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedItemRotacion
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtFechaMovimiento.setValue(selectedItemRotacion.getFechaMovimiento());
		txtFechaMovimiento.setDisabled(false);
		txtFechaOrdenada.setValue(selectedItemRotacion.getFechaOrdenada());
		txtFechaOrdenada.setDisabled(false);
		txtNumeroDespacho.setValue(selectedItemRotacion.getNumeroDespacho());
		txtNumeroDespacho.setDisabled(false);
		txtNumeroGarantia.setValue(selectedItemRotacion.getNumeroGarantia());
		txtNumeroGarantia.setDisabled(false);
		txtObservacion.setValue(selectedItemRotacion.getObservacion());
		txtObservacion.setDisabled(false);
		txtObservacionCambio.setValue(selectedItemRotacion
				.getObservacionCambio());
		txtObservacionCambio.setDisabled(false);
		txtOperCreador.setValue(selectedItemRotacion.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedItemRotacion.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdClfa_ClaveFabricacion.setValue(selectedItemRotacion
				.getIdClfa_ClaveFabricacion());
		txtIdClfa_ClaveFabricacion.setDisabled(false);
		txtIdDocu_Documento
				.setValue(selectedItemRotacion.getIdDocu_Documento());
		txtIdDocu_Documento.setDisabled(false);

		txtIdRefe_Referencia.setDisabled(false);
		txtIdItro.setValue(selectedItemRotacion.getIdItro());
		txtIdItro.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedItemRotacion == null) && (entity == null)) {
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
			entity = new ItemRotacion();

			Long idItro = new Long(txtIdItro.getValue().toString());

			entity.setAutorizado(FacesUtils.checkString(txtAutorizado));
			entity.setCantidadCambio(FacesUtils.checkLong(txtCantidadCambio));
			entity.setCantidadOrdenada(FacesUtils
					.checkLong(txtCantidadOrdenada));
			entity.setCantidadPedida(FacesUtils.checkLong(txtCantidadPedida));
			entity.setCausalNoCambio(FacesUtils.checkString(txtCausalNoCambio));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaAutorizacion(FacesUtils
					.checkDate(txtFechaAutorizacion));
			entity.setFechaCambio(FacesUtils.checkDate(txtFechaCambio));
			entity.setFechaCausal(FacesUtils.checkDate(txtFechaCausal));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaMovimiento(FacesUtils.checkDate(txtFechaMovimiento));
			entity.setFechaOrdenada(FacesUtils.checkDate(txtFechaOrdenada));
			entity.setIdItro(idItro);
			entity.setNumeroDespacho(FacesUtils.checkLong(txtNumeroDespacho));
			entity.setNumeroGarantia(FacesUtils.checkString(txtNumeroGarantia));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionCambio(FacesUtils
					.checkString(txtObservacionCambio));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setClaveFabricacion(businessDelegatorView
					.getClaveFabricacion(FacesUtils
							.checkLong(txtIdClfa_ClaveFabricacion)));
			entity.setDocumento(businessDelegatorView.getDocumento(FacesUtils
					.checkLong(txtIdDocu_Documento)));

			businessDelegatorView.saveItemRotacion(entity);
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
				Long idItro = new Long(selectedItemRotacion.getIdItro());
				entity = businessDelegatorView.getItemRotacion(idItro);
			}

			entity.setAutorizado(FacesUtils.checkString(txtAutorizado));
			entity.setCantidadCambio(FacesUtils.checkLong(txtCantidadCambio));
			entity.setCantidadOrdenada(FacesUtils
					.checkLong(txtCantidadOrdenada));
			entity.setCantidadPedida(FacesUtils.checkLong(txtCantidadPedida));
			entity.setCausalNoCambio(FacesUtils.checkString(txtCausalNoCambio));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaAutorizacion(FacesUtils
					.checkDate(txtFechaAutorizacion));
			entity.setFechaCambio(FacesUtils.checkDate(txtFechaCambio));
			entity.setFechaCausal(FacesUtils.checkDate(txtFechaCausal));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaMovimiento(FacesUtils.checkDate(txtFechaMovimiento));
			entity.setFechaOrdenada(FacesUtils.checkDate(txtFechaOrdenada));
			entity.setNumeroDespacho(FacesUtils.checkLong(txtNumeroDespacho));
			entity.setNumeroGarantia(FacesUtils.checkString(txtNumeroGarantia));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setObservacionCambio(FacesUtils
					.checkString(txtObservacionCambio));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setClaveFabricacion(businessDelegatorView
					.getClaveFabricacion(FacesUtils
							.checkLong(txtIdClfa_ClaveFabricacion)));
			entity.setDocumento(businessDelegatorView.getDocumento(FacesUtils
					.checkLong(txtIdDocu_Documento)));

			businessDelegatorView.updateItemRotacion(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedItemRotacion = (ItemRotacionDTO) (evt.getComponent()
					.getAttributes().get("selectedItemRotacion"));

			Long idItro = new Long(selectedItemRotacion.getIdItro());
			entity = businessDelegatorView.getItemRotacion(idItro);
			businessDelegatorView.deleteItemRotacion(entity);
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
			selectedItemRotacion = (ItemRotacionDTO) (evt.getComponent()
					.getAttributes().get("selectedItemRotacion"));

			Long idItro = new Long(selectedItemRotacion.getIdItro());
			entity = businessDelegatorView.getItemRotacion(idItro);
			businessDelegatorView.deleteItemRotacion(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedItemRotacion);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String autorizado, Long cantidadCambio,
			Long cantidadOrdenada, Long cantidadPedida, String causalNoCambio,
			String estado, String estadoRegistro, Date fechaAutorizacion,
			Date fechaCambio, Date fechaCausal, Date fechaCreacion,
			Date fechaModificacion, Date fechaMovimiento, Date fechaOrdenada,
			Long idItro, Long numeroDespacho, String numeroGarantia,
			String observacion, String observacionCambio, String operCreador,
			String operModifica, Long idClfa_ClaveFabricacion,
			Long idDocu_Documento, Long idRefe_Referencia,
			Long idRefe_Referencia0) throws Exception {
		try {
			entity.setAutorizado(FacesUtils.checkString(autorizado));
			entity.setCantidadCambio(FacesUtils.checkLong(cantidadCambio));
			entity.setCantidadOrdenada(FacesUtils.checkLong(cantidadOrdenada));
			entity.setCantidadPedida(FacesUtils.checkLong(cantidadPedida));
			entity.setCausalNoCambio(FacesUtils.checkString(causalNoCambio));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaAutorizacion(FacesUtils.checkDate(fechaAutorizacion));
			entity.setFechaCambio(FacesUtils.checkDate(fechaCambio));
			entity.setFechaCausal(FacesUtils.checkDate(fechaCausal));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaMovimiento(FacesUtils.checkDate(fechaMovimiento));
			entity.setFechaOrdenada(FacesUtils.checkDate(fechaOrdenada));
			entity.setNumeroDespacho(FacesUtils.checkLong(numeroDespacho));
			entity.setNumeroGarantia(FacesUtils.checkString(numeroGarantia));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setObservacionCambio(FacesUtils
					.checkString(observacionCambio));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateItemRotacion(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ItemRotacionView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtAutorizado() {
		return txtAutorizado;
	}

	public void setTxtAutorizado(InputText txtAutorizado) {
		this.txtAutorizado = txtAutorizado;
	}

	public InputText getTxtCantidadCambio() {
		return txtCantidadCambio;
	}

	public void setTxtCantidadCambio(InputText txtCantidadCambio) {
		this.txtCantidadCambio = txtCantidadCambio;
	}

	public InputText getTxtCantidadOrdenada() {
		return txtCantidadOrdenada;
	}

	public void setTxtCantidadOrdenada(InputText txtCantidadOrdenada) {
		this.txtCantidadOrdenada = txtCantidadOrdenada;
	}

	public InputText getTxtCantidadPedida() {
		return txtCantidadPedida;
	}

	public void setTxtCantidadPedida(InputText txtCantidadPedida) {
		this.txtCantidadPedida = txtCantidadPedida;
	}

	public InputText getTxtCausalNoCambio() {
		return txtCausalNoCambio;
	}

	public void setTxtCausalNoCambio(InputText txtCausalNoCambio) {
		this.txtCausalNoCambio = txtCausalNoCambio;
	}

	public InputText getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(InputText txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}

	public InputText getTxtNumeroDespacho() {
		return txtNumeroDespacho;
	}

	public void setTxtNumeroDespacho(InputText txtNumeroDespacho) {
		this.txtNumeroDespacho = txtNumeroDespacho;
	}

	public InputText getTxtNumeroGarantia() {
		return txtNumeroGarantia;
	}

	public void setTxtNumeroGarantia(InputText txtNumeroGarantia) {
		this.txtNumeroGarantia = txtNumeroGarantia;
	}

	public InputText getTxtObservacion() {
		return txtObservacion;
	}

	public void setTxtObservacion(InputText txtObservacion) {
		this.txtObservacion = txtObservacion;
	}

	public InputText getTxtObservacionCambio() {
		return txtObservacionCambio;
	}

	public void setTxtObservacionCambio(InputText txtObservacionCambio) {
		this.txtObservacionCambio = txtObservacionCambio;
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

	public InputText getTxtIdClfa_ClaveFabricacion() {
		return txtIdClfa_ClaveFabricacion;
	}

	public void setTxtIdClfa_ClaveFabricacion(
			InputText txtIdClfa_ClaveFabricacion) {
		this.txtIdClfa_ClaveFabricacion = txtIdClfa_ClaveFabricacion;
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

	public Calendar getTxtFechaAutorizacion() {
		return txtFechaAutorizacion;
	}

	public void setTxtFechaAutorizacion(Calendar txtFechaAutorizacion) {
		this.txtFechaAutorizacion = txtFechaAutorizacion;
	}

	public Calendar getTxtFechaCambio() {
		return txtFechaCambio;
	}

	public void setTxtFechaCambio(Calendar txtFechaCambio) {
		this.txtFechaCambio = txtFechaCambio;
	}

	public Calendar getTxtFechaCausal() {
		return txtFechaCausal;
	}

	public void setTxtFechaCausal(Calendar txtFechaCausal) {
		this.txtFechaCausal = txtFechaCausal;
	}

	public Calendar getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public Calendar getTxtFechaMovimiento() {
		return txtFechaMovimiento;
	}

	public void setTxtFechaMovimiento(Calendar txtFechaMovimiento) {
		this.txtFechaMovimiento = txtFechaMovimiento;
	}

	public Calendar getTxtFechaOrdenada() {
		return txtFechaOrdenada;
	}

	public void setTxtFechaOrdenada(Calendar txtFechaOrdenada) {
		this.txtFechaOrdenada = txtFechaOrdenada;
	}

	public InputText getTxtIdItro() {
		return txtIdItro;
	}

	public void setTxtIdItro(InputText txtIdItro) {
		this.txtIdItro = txtIdItro;
	}

	public List<ItemRotacionDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataItemRotacion();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ItemRotacionDTO> itemRotacionDTO) {
		this.data = itemRotacionDTO;
	}

	public ItemRotacionDTO getSelectedItemRotacion() {
		return selectedItemRotacion;
	}

	public void setSelectedItemRotacion(ItemRotacionDTO itemRotacion) {
		this.selectedItemRotacion = itemRotacion;
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
