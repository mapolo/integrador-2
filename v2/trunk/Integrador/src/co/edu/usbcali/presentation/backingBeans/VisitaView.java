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
import co.edu.usbcali.modelo.Visita;
import co.edu.usbcali.modelo.dto.VisitaDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class VisitaView {
	private InputText txtEstadoRegistro;
	private InputText txtEstadoVisita;
	private InputText txtObservacion;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdCusa_Causal;
	private InputText txtIdPrad_ProgramacionAdicional;
	private InputText txtIdPrvi_ProgramacionVisitas;
	private InputText txtIdVisi;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<VisitaDTO> data;
	private VisitaDTO selectedVisita;
	private Visita entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public VisitaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			VisitaDTO visitaDTO = (VisitaDTO) e.getObject();

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(visitaDTO.getEstadoRegistro());

			if (txtEstadoVisita == null) {
				txtEstadoVisita = new InputText();
			}

			txtEstadoVisita.setValue(visitaDTO.getEstadoVisita());

			if (txtObservacion == null) {
				txtObservacion = new InputText();
			}

			txtObservacion.setValue(visitaDTO.getObservacion());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(visitaDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(visitaDTO.getOperModifica());

			if (txtIdCusa_Causal == null) {
				txtIdCusa_Causal = new InputText();
			}

			txtIdCusa_Causal.setValue(visitaDTO.getIdCusa_Causal());

			if (txtIdPrad_ProgramacionAdicional == null) {
				txtIdPrad_ProgramacionAdicional = new InputText();
			}

			txtIdPrad_ProgramacionAdicional.setValue(visitaDTO
					.getIdPrad_ProgramacionAdicional());

			if (txtIdPrvi_ProgramacionVisitas == null) {
				txtIdPrvi_ProgramacionVisitas = new InputText();
			}

			txtIdPrvi_ProgramacionVisitas.setValue(visitaDTO
					.getIdPrvi_ProgramacionVisitas());

			if (txtIdVisi == null) {
				txtIdVisi = new InputText();
			}

			txtIdVisi.setValue(visitaDTO.getIdVisi());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(visitaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(visitaDTO.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedVisita = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedVisita = null;

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtEstadoVisita != null) {
			txtEstadoVisita.setValue(null);
			txtEstadoVisita.setDisabled(true);
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

		if (txtIdCusa_Causal != null) {
			txtIdCusa_Causal.setValue(null);
			txtIdCusa_Causal.setDisabled(true);
		}

		if (txtIdPrad_ProgramacionAdicional != null) {
			txtIdPrad_ProgramacionAdicional.setValue(null);
			txtIdPrad_ProgramacionAdicional.setDisabled(true);
		}

		if (txtIdPrvi_ProgramacionVisitas != null) {
			txtIdPrvi_ProgramacionVisitas.setValue(null);
			txtIdPrvi_ProgramacionVisitas.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdVisi != null) {
			txtIdVisi.setValue(null);
			txtIdVisi.setDisabled(false);
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
			Long idVisi = new Long(txtIdVisi.getValue().toString());
			entity = businessDelegatorView.getVisita(idVisi);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEstadoRegistro.setDisabled(false);
			txtEstadoVisita.setDisabled(false);
			txtObservacion.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdCusa_Causal.setDisabled(false);
			txtIdPrad_ProgramacionAdicional.setDisabled(false);
			txtIdPrvi_ProgramacionVisitas.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdVisi.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtEstadoVisita.setValue(entity.getEstadoVisita());
			txtEstadoVisita.setDisabled(false);
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
			txtIdCusa_Causal.setValue(entity.getCausal().getIdCusa());
			txtIdCusa_Causal.setDisabled(false);
			txtIdPrad_ProgramacionAdicional.setValue(entity
					.getProgramacionAdicional().getIdPrad());
			txtIdPrad_ProgramacionAdicional.setDisabled(false);
			txtIdPrvi_ProgramacionVisitas.setValue(entity
					.getProgramacionVisitas().getIdPrvi());
			txtIdPrvi_ProgramacionVisitas.setDisabled(false);
			txtIdVisi.setValue(entity.getIdVisi());
			txtIdVisi.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedVisita = (VisitaDTO) (evt.getComponent().getAttributes()
				.get("selectedVisita"));
		txtEstadoRegistro.setValue(selectedVisita.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtEstadoVisita.setValue(selectedVisita.getEstadoVisita());
		txtEstadoVisita.setDisabled(false);
		txtFechaCreacion.setValue(selectedVisita.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedVisita.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtObservacion.setValue(selectedVisita.getObservacion());
		txtObservacion.setDisabled(false);
		txtOperCreador.setValue(selectedVisita.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedVisita.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdCusa_Causal.setValue(selectedVisita.getIdCusa_Causal());
		txtIdCusa_Causal.setDisabled(false);
		txtIdPrad_ProgramacionAdicional.setValue(selectedVisita
				.getIdPrad_ProgramacionAdicional());
		txtIdPrad_ProgramacionAdicional.setDisabled(false);
		txtIdPrvi_ProgramacionVisitas.setValue(selectedVisita
				.getIdPrvi_ProgramacionVisitas());
		txtIdPrvi_ProgramacionVisitas.setDisabled(false);
		txtIdVisi.setValue(selectedVisita.getIdVisi());
		txtIdVisi.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedVisita == null) && (entity == null)) {
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
			entity = new Visita();

			Long idVisi = new Long(txtIdVisi.getValue().toString());

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setEstadoVisita(FacesUtils.checkString(txtEstadoVisita));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdVisi(idVisi);
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setCausal(businessDelegatorView.getCausal(FacesUtils
					.checkLong(txtIdCusa_Causal)));
			entity.setProgramacionAdicional(businessDelegatorView
					.getProgramacionAdicional(FacesUtils
							.checkLong(txtIdPrad_ProgramacionAdicional)));
			entity.setProgramacionVisitas(businessDelegatorView
					.getProgramacionVisitas(FacesUtils
							.checkLong(txtIdPrvi_ProgramacionVisitas)));
			businessDelegatorView.saveVisita(entity);
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
				Long idVisi = new Long(selectedVisita.getIdVisi());
				entity = businessDelegatorView.getVisita(idVisi);
			}

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setEstadoVisita(FacesUtils.checkString(txtEstadoVisita));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setCausal(businessDelegatorView.getCausal(FacesUtils
					.checkLong(txtIdCusa_Causal)));
			entity.setProgramacionAdicional(businessDelegatorView
					.getProgramacionAdicional(FacesUtils
							.checkLong(txtIdPrad_ProgramacionAdicional)));
			entity.setProgramacionVisitas(businessDelegatorView
					.getProgramacionVisitas(FacesUtils
							.checkLong(txtIdPrvi_ProgramacionVisitas)));
			businessDelegatorView.updateVisita(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedVisita = (VisitaDTO) (evt.getComponent().getAttributes()
					.get("selectedVisita"));

			Long idVisi = new Long(selectedVisita.getIdVisi());
			entity = businessDelegatorView.getVisita(idVisi);
			businessDelegatorView.deleteVisita(entity);
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
			selectedVisita = (VisitaDTO) (evt.getComponent().getAttributes()
					.get("selectedVisita"));

			Long idVisi = new Long(selectedVisita.getIdVisi());
			entity = businessDelegatorView.getVisita(idVisi);
			businessDelegatorView.deleteVisita(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedVisita);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			String estadoVisita, Date fechaCreacion, Date fechaModificacion,
			Long idVisi, String observacion, String operCreador,
			String operModifica, Long idCusa_Causal,
			Long idPrad_ProgramacionAdicional, Long idPrvi_ProgramacionVisitas)
			throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setEstadoVisita(FacesUtils.checkString(estadoVisita));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateVisita(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("VisitaView").requestRender();
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

	public InputText getTxtEstadoVisita() {
		return txtEstadoVisita;
	}

	public void setTxtEstadoVisita(InputText txtEstadoVisita) {
		this.txtEstadoVisita = txtEstadoVisita;
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

	public InputText getTxtIdCusa_Causal() {
		return txtIdCusa_Causal;
	}

	public void setTxtIdCusa_Causal(InputText txtIdCusa_Causal) {
		this.txtIdCusa_Causal = txtIdCusa_Causal;
	}

	public InputText getTxtIdPrad_ProgramacionAdicional() {
		return txtIdPrad_ProgramacionAdicional;
	}

	public void setTxtIdPrad_ProgramacionAdicional(
			InputText txtIdPrad_ProgramacionAdicional) {
		this.txtIdPrad_ProgramacionAdicional = txtIdPrad_ProgramacionAdicional;
	}

	public InputText getTxtIdPrvi_ProgramacionVisitas() {
		return txtIdPrvi_ProgramacionVisitas;
	}

	public void setTxtIdPrvi_ProgramacionVisitas(
			InputText txtIdPrvi_ProgramacionVisitas) {
		this.txtIdPrvi_ProgramacionVisitas = txtIdPrvi_ProgramacionVisitas;
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

	public InputText getTxtIdVisi() {
		return txtIdVisi;
	}

	public void setTxtIdVisi(InputText txtIdVisi) {
		this.txtIdVisi = txtIdVisi;
	}

	public List<VisitaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataVisita();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<VisitaDTO> visitaDTO) {
		this.data = visitaDTO;
	}

	public VisitaDTO getSelectedVisita() {
		return selectedVisita;
	}

	public void setSelectedVisita(VisitaDTO visita) {
		this.selectedVisita = visita;
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
