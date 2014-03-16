package co.edu.usbcali.presentation.backingBeans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.DetalleVisita;
import co.edu.usbcali.modelo.dto.DetalleVisitaDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class DetalleVisitaView {
	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdDocu_Documento;
	private InputText txtIdVisi_Visita;
	private InputText txtIdDevi;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DetalleVisitaDTO> data;
	private DetalleVisitaDTO selectedDetalleVisita;
	private DetalleVisita entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public DetalleVisitaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DetalleVisitaDTO detalleVisitaDTO = (DetalleVisitaDTO) e
					.getObject();

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(detalleVisitaDTO.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(detalleVisitaDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(detalleVisitaDTO.getOperModifica());

			if (txtIdDocu_Documento == null) {
				txtIdDocu_Documento = new InputText();
			}

			txtIdDocu_Documento
					.setValue(detalleVisitaDTO.getIdDocu_Documento());

			if (txtIdVisi_Visita == null) {
				txtIdVisi_Visita = new InputText();
			}

			txtIdVisi_Visita.setValue(detalleVisitaDTO.getIdVisi_Visita());

			if (txtIdDevi == null) {
				txtIdDevi = new InputText();
			}

			txtIdDevi.setValue(detalleVisitaDTO.getIdDevi());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(detalleVisitaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(detalleVisitaDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedDetalleVisita = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDetalleVisita = null;

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtIdDocu_Documento != null) {
			txtIdDocu_Documento.setValue(null);
			txtIdDocu_Documento.setDisabled(true);
		}

		if (txtIdVisi_Visita != null) {
			txtIdVisi_Visita.setValue(null);
			txtIdVisi_Visita.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdDevi != null) {
			txtIdDevi.setValue(null);
			txtIdDevi.setDisabled(false);
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
			Long idDevi = new Long(txtIdDevi.getValue().toString());
			entity = businessDelegatorView.getDetalleVisita(idDevi);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdDocu_Documento.setDisabled(false);
			txtIdVisi_Visita.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdDevi.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdDocu_Documento.setValue(entity.getDocumento().getIdDocu());
			txtIdDocu_Documento.setDisabled(false);
			txtIdVisi_Visita.setValue(entity.getVisita().getIdVisi());
			txtIdVisi_Visita.setDisabled(false);
			txtIdDevi.setValue(entity.getIdDevi());
			txtIdDevi.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedDetalleVisita = (DetalleVisitaDTO) (evt.getComponent()
				.getAttributes().get("selectedDetalleVisita"));
		txtEstadoRegistro.setValue(selectedDetalleVisita.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedDetalleVisita.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedDetalleVisita
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedDetalleVisita.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedDetalleVisita.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdDocu_Documento.setValue(selectedDetalleVisita
				.getIdDocu_Documento());
		txtIdDocu_Documento.setDisabled(false);
		txtIdVisi_Visita.setValue(selectedDetalleVisita.getIdVisi_Visita());
		txtIdVisi_Visita.setDisabled(false);
		txtIdDevi.setValue(selectedDetalleVisita.getIdDevi());
		txtIdDevi.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedDetalleVisita == null) && (entity == null)) {
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
			entity = new DetalleVisita();

			Long idDevi = new Long(txtIdDevi.getValue().toString());

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdDevi(idDevi);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setDocumento(businessDelegatorView.getDocumento(FacesUtils
					.checkLong(txtIdDocu_Documento)));
			entity.setVisita(businessDelegatorView.getVisita(FacesUtils
					.checkLong(txtIdVisi_Visita)));
			businessDelegatorView.saveDetalleVisita(entity);
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
				Long idDevi = new Long(selectedDetalleVisita.getIdDevi());
				entity = businessDelegatorView.getDetalleVisita(idDevi);
			}

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setDocumento(businessDelegatorView.getDocumento(FacesUtils
					.checkLong(txtIdDocu_Documento)));
			entity.setVisita(businessDelegatorView.getVisita(FacesUtils
					.checkLong(txtIdVisi_Visita)));
			businessDelegatorView.updateDetalleVisita(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedDetalleVisita = (DetalleVisitaDTO) (evt.getComponent()
					.getAttributes().get("selectedDetalleVisita"));

			Long idDevi = new Long(selectedDetalleVisita.getIdDevi());
			entity = businessDelegatorView.getDetalleVisita(idDevi);
			businessDelegatorView.deleteDetalleVisita(entity);
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
			selectedDetalleVisita = (DetalleVisitaDTO) (evt.getComponent()
					.getAttributes().get("selectedDetalleVisita"));

			Long idDevi = new Long(selectedDetalleVisita.getIdDevi());
			entity = businessDelegatorView.getDetalleVisita(idDevi);
			businessDelegatorView.deleteDetalleVisita(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedDetalleVisita);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idDevi,
			String operCreador, String operModifica, Long idDocu_Documento,
			Long idVisi_Visita) throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateDetalleVisita(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DetalleVisitaView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
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

	public InputText getTxtIdDocu_Documento() {
		return txtIdDocu_Documento;
	}

	public void setTxtIdDocu_Documento(InputText txtIdDocu_Documento) {
		this.txtIdDocu_Documento = txtIdDocu_Documento;
	}

	public InputText getTxtIdVisi_Visita() {
		return txtIdVisi_Visita;
	}

	public void setTxtIdVisi_Visita(InputText txtIdVisi_Visita) {
		this.txtIdVisi_Visita = txtIdVisi_Visita;
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

	public InputText getTxtIdDevi() {
		return txtIdDevi;
	}

	public void setTxtIdDevi(InputText txtIdDevi) {
		this.txtIdDevi = txtIdDevi;
	}

	public List<DetalleVisitaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDetalleVisita();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DetalleVisitaDTO> detalleVisitaDTO) {
		this.data = detalleVisitaDTO;
	}

	public DetalleVisitaDTO getSelectedDetalleVisita() {
		return selectedDetalleVisita;
	}

	public void setSelectedDetalleVisita(DetalleVisitaDTO detalleVisita) {
		this.selectedDetalleVisita = detalleVisita;
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
