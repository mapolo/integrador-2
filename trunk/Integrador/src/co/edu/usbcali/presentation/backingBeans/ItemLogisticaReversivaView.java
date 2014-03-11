package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.ItemLogisticaReversivaDTO;
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
public class ItemLogisticaReversivaView {
	private InputText txtCantidadRecibida;
	private InputText txtCantidadSolicitada;
	private InputText txtEstadoRegistro;
	private InputText txtObservacion;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtValor;
	private InputText txtIdLore_LogisticaReversiva;
	private InputText txtIdRefe_Referencia;
	private InputText txtIdItlr;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ItemLogisticaReversivaDTO> data;
	private ItemLogisticaReversivaDTO selectedItemLogisticaReversiva;
	private ItemLogisticaReversiva entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ItemLogisticaReversivaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ItemLogisticaReversivaDTO itemLogisticaReversivaDTO = (ItemLogisticaReversivaDTO) e
					.getObject();

			if (txtCantidadRecibida == null) {
				txtCantidadRecibida = new InputText();
			}

			txtCantidadRecibida.setValue(itemLogisticaReversivaDTO
					.getCantidadRecibida());

			if (txtCantidadSolicitada == null) {
				txtCantidadSolicitada = new InputText();
			}

			txtCantidadSolicitada.setValue(itemLogisticaReversivaDTO
					.getCantidadSolicitada());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(itemLogisticaReversivaDTO
					.getEstadoRegistro());

			if (txtObservacion == null) {
				txtObservacion = new InputText();
			}

			txtObservacion.setValue(itemLogisticaReversivaDTO.getObservacion());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(itemLogisticaReversivaDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(itemLogisticaReversivaDTO
					.getOperModifica());

			if (txtValor == null) {
				txtValor = new InputText();
			}

			txtValor.setValue(itemLogisticaReversivaDTO.getValor());

			if (txtIdLore_LogisticaReversiva == null) {
				txtIdLore_LogisticaReversiva = new InputText();
			}

			txtIdLore_LogisticaReversiva.setValue(itemLogisticaReversivaDTO
					.getIdLore_LogisticaReversiva());

			if (txtIdRefe_Referencia == null) {
				txtIdRefe_Referencia = new InputText();
			}

			txtIdRefe_Referencia.setValue(itemLogisticaReversivaDTO
					.getIdRefe_Referencia());

			if (txtIdItlr == null) {
				txtIdItlr = new InputText();
			}

			txtIdItlr.setValue(itemLogisticaReversivaDTO.getIdItlr());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(itemLogisticaReversivaDTO
					.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(itemLogisticaReversivaDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedItemLogisticaReversiva = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedItemLogisticaReversiva = null;

		if (txtCantidadRecibida != null) {
			txtCantidadRecibida.setValue(null);
			txtCantidadRecibida.setDisabled(true);
		}

		if (txtCantidadSolicitada != null) {
			txtCantidadSolicitada.setValue(null);
			txtCantidadSolicitada.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
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

		if (txtValor != null) {
			txtValor.setValue(null);
			txtValor.setDisabled(true);
		}

		if (txtIdLore_LogisticaReversiva != null) {
			txtIdLore_LogisticaReversiva.setValue(null);
			txtIdLore_LogisticaReversiva.setDisabled(true);
		}

		if (txtIdRefe_Referencia != null) {
			txtIdRefe_Referencia.setValue(null);
			txtIdRefe_Referencia.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdItlr != null) {
			txtIdItlr.setValue(null);
			txtIdItlr.setDisabled(false);
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

	public void listener_txtFechaModificacion() {
		Date inputDate = (Date) txtFechaModificacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Long idItlr = new Long(txtIdItlr.getValue().toString());
			entity = businessDelegatorView.getItemLogisticaReversiva(idItlr);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtCantidadRecibida.setDisabled(false);
			txtCantidadSolicitada.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtObservacion.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtValor.setDisabled(false);
			txtIdLore_LogisticaReversiva.setDisabled(false);
			txtIdRefe_Referencia.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdItlr.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCantidadRecibida.setValue(entity.getCantidadRecibida());
			txtCantidadRecibida.setDisabled(false);
			txtCantidadSolicitada.setValue(entity.getCantidadSolicitada());
			txtCantidadSolicitada.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtObservacion.setValue(entity.getObservacion());
			txtObservacion.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtValor.setValue(entity.getValor());
			txtValor.setDisabled(false);
			txtIdLore_LogisticaReversiva.setValue(entity
					.getLogisticaReversiva().getIdLore());
			txtIdLore_LogisticaReversiva.setDisabled(false);
			txtIdRefe_Referencia.setValue(entity.getReferencia().getIdRefe());
			txtIdRefe_Referencia.setDisabled(false);
			txtIdItlr.setValue(entity.getIdItlr());
			txtIdItlr.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedItemLogisticaReversiva = (ItemLogisticaReversivaDTO) (evt
				.getComponent().getAttributes()
				.get("selectedItemLogisticaReversiva"));
		txtCantidadRecibida.setValue(selectedItemLogisticaReversiva
				.getCantidadRecibida());
		txtCantidadRecibida.setDisabled(false);
		txtCantidadSolicitada.setValue(selectedItemLogisticaReversiva
				.getCantidadSolicitada());
		txtCantidadSolicitada.setDisabled(false);
		txtEstadoRegistro.setValue(selectedItemLogisticaReversiva
				.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedItemLogisticaReversiva
				.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedItemLogisticaReversiva
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtObservacion
				.setValue(selectedItemLogisticaReversiva.getObservacion());
		txtObservacion.setDisabled(false);
		txtOperCreador
				.setValue(selectedItemLogisticaReversiva.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedItemLogisticaReversiva
				.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtValor.setValue(selectedItemLogisticaReversiva.getValor());
		txtValor.setDisabled(false);
		txtIdLore_LogisticaReversiva.setValue(selectedItemLogisticaReversiva
				.getIdLore_LogisticaReversiva());
		txtIdLore_LogisticaReversiva.setDisabled(false);
		txtIdRefe_Referencia.setValue(selectedItemLogisticaReversiva
				.getIdRefe_Referencia());
		txtIdRefe_Referencia.setDisabled(false);
		txtIdItlr.setValue(selectedItemLogisticaReversiva.getIdItlr());
		txtIdItlr.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedItemLogisticaReversiva == null) && (entity == null)) {
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
			entity = new ItemLogisticaReversiva();

			Long idItlr = new Long(txtIdItlr.getValue().toString());

			entity.setCantidadRecibida(FacesUtils
					.checkDouble(txtCantidadRecibida));
			entity.setCantidadSolicitada(FacesUtils
					.checkDouble(txtCantidadSolicitada));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdItlr(idItlr);
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setValor(FacesUtils.checkDouble(txtValor));
			entity.setLogisticaReversiva(businessDelegatorView
					.getLogisticaReversiva(FacesUtils
							.checkLong(txtIdLore_LogisticaReversiva)));
			entity.setReferencia(businessDelegatorView.getReferencia(FacesUtils
					.checkLong(txtIdRefe_Referencia)));
			businessDelegatorView.saveItemLogisticaReversiva(entity);
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
				Long idItlr = new Long(
						selectedItemLogisticaReversiva.getIdItlr());
				entity = businessDelegatorView
						.getItemLogisticaReversiva(idItlr);
			}

			entity.setCantidadRecibida(FacesUtils
					.checkDouble(txtCantidadRecibida));
			entity.setCantidadSolicitada(FacesUtils
					.checkDouble(txtCantidadSolicitada));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setValor(FacesUtils.checkDouble(txtValor));
			entity.setLogisticaReversiva(businessDelegatorView
					.getLogisticaReversiva(FacesUtils
							.checkLong(txtIdLore_LogisticaReversiva)));
			entity.setReferencia(businessDelegatorView.getReferencia(FacesUtils
					.checkLong(txtIdRefe_Referencia)));
			businessDelegatorView.updateItemLogisticaReversiva(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedItemLogisticaReversiva = (ItemLogisticaReversivaDTO) (evt
					.getComponent().getAttributes()
					.get("selectedItemLogisticaReversiva"));

			Long idItlr = new Long(selectedItemLogisticaReversiva.getIdItlr());
			entity = businessDelegatorView.getItemLogisticaReversiva(idItlr);
			businessDelegatorView.deleteItemLogisticaReversiva(entity);
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
			selectedItemLogisticaReversiva = (ItemLogisticaReversivaDTO) (evt
					.getComponent().getAttributes()
					.get("selectedItemLogisticaReversiva"));

			Long idItlr = new Long(selectedItemLogisticaReversiva.getIdItlr());
			entity = businessDelegatorView.getItemLogisticaReversiva(idItlr);
			businessDelegatorView.deleteItemLogisticaReversiva(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedItemLogisticaReversiva);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Double cantidadRecibida,
			Double cantidadSolicitada, String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idItlr,
			String observacion, String operCreador, String operModifica,
			Double valor, Long idLore_LogisticaReversiva, Long idRefe_Referencia)
			throws Exception {
		try {
			entity.setCantidadRecibida(FacesUtils.checkDouble(cantidadRecibida));
			entity.setCantidadSolicitada(FacesUtils
					.checkDouble(cantidadSolicitada));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setValor(FacesUtils.checkDouble(valor));
			businessDelegatorView.updateItemLogisticaReversiva(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ItemLogisticaReversivaView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCantidadRecibida() {
		return txtCantidadRecibida;
	}

	public void setTxtCantidadRecibida(InputText txtCantidadRecibida) {
		this.txtCantidadRecibida = txtCantidadRecibida;
	}

	public InputText getTxtCantidadSolicitada() {
		return txtCantidadSolicitada;
	}

	public void setTxtCantidadSolicitada(InputText txtCantidadSolicitada) {
		this.txtCantidadSolicitada = txtCantidadSolicitada;
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
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

	public InputText getTxtValor() {
		return txtValor;
	}

	public void setTxtValor(InputText txtValor) {
		this.txtValor = txtValor;
	}

	public InputText getTxtIdLore_LogisticaReversiva() {
		return txtIdLore_LogisticaReversiva;
	}

	public void setTxtIdLore_LogisticaReversiva(
			InputText txtIdLore_LogisticaReversiva) {
		this.txtIdLore_LogisticaReversiva = txtIdLore_LogisticaReversiva;
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

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public InputText getTxtIdItlr() {
		return txtIdItlr;
	}

	public void setTxtIdItlr(InputText txtIdItlr) {
		this.txtIdItlr = txtIdItlr;
	}

	public List<ItemLogisticaReversivaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataItemLogisticaReversiva();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(
			List<ItemLogisticaReversivaDTO> itemLogisticaReversivaDTO) {
		this.data = itemLogisticaReversivaDTO;
	}

	public ItemLogisticaReversivaDTO getSelectedItemLogisticaReversiva() {
		return selectedItemLogisticaReversiva;
	}

	public void setSelectedItemLogisticaReversiva(
			ItemLogisticaReversivaDTO itemLogisticaReversiva) {
		this.selectedItemLogisticaReversiva = itemLogisticaReversiva;
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
