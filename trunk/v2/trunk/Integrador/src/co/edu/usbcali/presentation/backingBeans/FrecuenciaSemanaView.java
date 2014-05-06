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
import co.edu.usbcali.modelo.FrecuenciaSemana;
import co.edu.usbcali.modelo.dto.FrecuenciaSemanaDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class FrecuenciaSemanaView {
	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdFrvi_FrecuenciaVisita;
	private InputText txtIdSema_Semana;
	private InputText txtIdFrcr;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<FrecuenciaSemanaDTO> data;
	private FrecuenciaSemanaDTO selectedFrecuenciaSemana;
	private FrecuenciaSemana entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public FrecuenciaSemanaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			FrecuenciaSemanaDTO frecuenciaSemanaDTO = (FrecuenciaSemanaDTO) e
					.getObject();

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(frecuenciaSemanaDTO.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(frecuenciaSemanaDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(frecuenciaSemanaDTO.getOperModifica());

			if (txtIdFrvi_FrecuenciaVisita == null) {
				txtIdFrvi_FrecuenciaVisita = new InputText();
			}

			txtIdFrvi_FrecuenciaVisita.setValue(frecuenciaSemanaDTO
					.getIdFrvi_FrecuenciaVisita());

			if (txtIdSema_Semana == null) {
				txtIdSema_Semana = new InputText();
			}

			txtIdSema_Semana.setValue(frecuenciaSemanaDTO.getIdSema_Semana());

			if (txtIdFrcr == null) {
				txtIdFrcr = new InputText();
			}

			txtIdFrcr.setValue(frecuenciaSemanaDTO.getIdFrcr());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(frecuenciaSemanaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(frecuenciaSemanaDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedFrecuenciaSemana = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedFrecuenciaSemana = null;

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

		if (txtIdFrvi_FrecuenciaVisita != null) {
			txtIdFrvi_FrecuenciaVisita.setValue(null);
			txtIdFrvi_FrecuenciaVisita.setDisabled(true);
		}

		if (txtIdSema_Semana != null) {
			txtIdSema_Semana.setValue(null);
			txtIdSema_Semana.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdFrcr != null) {
			txtIdFrcr.setValue(null);
			txtIdFrcr.setDisabled(false);
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
			Long idFrcr = new Long(txtIdFrcr.getValue().toString());
			entity = businessDelegatorView.getFrecuenciaSemana(idFrcr);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdFrvi_FrecuenciaVisita.setDisabled(false);
			txtIdSema_Semana.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdFrcr.setDisabled(false);
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
			txtIdFrvi_FrecuenciaVisita.setValue(entity.getFrecuenciaVisita()
					.getIdFrvi());
			txtIdFrvi_FrecuenciaVisita.setDisabled(false);
			txtIdSema_Semana.setValue(entity.getSemana().getIdSema());
			txtIdSema_Semana.setDisabled(false);
			txtIdFrcr.setValue(entity.getIdFrcr());
			txtIdFrcr.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedFrecuenciaSemana = (FrecuenciaSemanaDTO) (evt.getComponent()
				.getAttributes().get("selectedFrecuenciaSemana"));
		txtEstadoRegistro
				.setValue(selectedFrecuenciaSemana.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedFrecuenciaSemana.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedFrecuenciaSemana
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedFrecuenciaSemana.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedFrecuenciaSemana.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdFrvi_FrecuenciaVisita.setValue(selectedFrecuenciaSemana
				.getIdFrvi_FrecuenciaVisita());
		txtIdFrvi_FrecuenciaVisita.setDisabled(false);
		txtIdSema_Semana.setValue(selectedFrecuenciaSemana.getIdSema_Semana());
		txtIdSema_Semana.setDisabled(false);
		txtIdFrcr.setValue(selectedFrecuenciaSemana.getIdFrcr());
		txtIdFrcr.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedFrecuenciaSemana == null) && (entity == null)) {
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
			entity = new FrecuenciaSemana();

			Long idFrcr = new Long(txtIdFrcr.getValue().toString());

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdFrcr(idFrcr);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setFrecuenciaVisita(businessDelegatorView
					.getFrecuenciaVisita(FacesUtils
							.checkLong(txtIdFrvi_FrecuenciaVisita)));
			entity.setSemana(businessDelegatorView.getSemana(FacesUtils
					.checkLong(txtIdSema_Semana)));
			businessDelegatorView.saveFrecuenciaSemana(entity);
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
				Long idFrcr = new Long(selectedFrecuenciaSemana.getIdFrcr());
				entity = businessDelegatorView.getFrecuenciaSemana(idFrcr);
			}

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setFrecuenciaVisita(businessDelegatorView
					.getFrecuenciaVisita(FacesUtils
							.checkLong(txtIdFrvi_FrecuenciaVisita)));
			entity.setSemana(businessDelegatorView.getSemana(FacesUtils
					.checkLong(txtIdSema_Semana)));
			businessDelegatorView.updateFrecuenciaSemana(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedFrecuenciaSemana = (FrecuenciaSemanaDTO) (evt
					.getComponent().getAttributes()
					.get("selectedFrecuenciaSemana"));

			Long idFrcr = new Long(selectedFrecuenciaSemana.getIdFrcr());
			entity = businessDelegatorView.getFrecuenciaSemana(idFrcr);
			businessDelegatorView.deleteFrecuenciaSemana(entity);
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
			selectedFrecuenciaSemana = (FrecuenciaSemanaDTO) (evt
					.getComponent().getAttributes()
					.get("selectedFrecuenciaSemana"));

			Long idFrcr = new Long(selectedFrecuenciaSemana.getIdFrcr());
			entity = businessDelegatorView.getFrecuenciaSemana(idFrcr);
			businessDelegatorView.deleteFrecuenciaSemana(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedFrecuenciaSemana);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idFrcr,
			String operCreador, String operModifica,
			Long idFrvi_FrecuenciaVisita, Long idSema_Semana) throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateFrecuenciaSemana(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("FrecuenciaSemanaView").requestRender();
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

	public InputText getTxtIdFrvi_FrecuenciaVisita() {
		return txtIdFrvi_FrecuenciaVisita;
	}

	public void setTxtIdFrvi_FrecuenciaVisita(
			InputText txtIdFrvi_FrecuenciaVisita) {
		this.txtIdFrvi_FrecuenciaVisita = txtIdFrvi_FrecuenciaVisita;
	}

	public InputText getTxtIdSema_Semana() {
		return txtIdSema_Semana;
	}

	public void setTxtIdSema_Semana(InputText txtIdSema_Semana) {
		this.txtIdSema_Semana = txtIdSema_Semana;
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

	public InputText getTxtIdFrcr() {
		return txtIdFrcr;
	}

	public void setTxtIdFrcr(InputText txtIdFrcr) {
		this.txtIdFrcr = txtIdFrcr;
	}

	public List<FrecuenciaSemanaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataFrecuenciaSemana();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<FrecuenciaSemanaDTO> frecuenciaSemanaDTO) {
		this.data = frecuenciaSemanaDTO;
	}

	public FrecuenciaSemanaDTO getSelectedFrecuenciaSemana() {
		return selectedFrecuenciaSemana;
	}

	public void setSelectedFrecuenciaSemana(FrecuenciaSemanaDTO frecuenciaSemana) {
		this.selectedFrecuenciaSemana = frecuenciaSemana;
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
