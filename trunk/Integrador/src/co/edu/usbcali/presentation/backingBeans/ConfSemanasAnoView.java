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
import co.edu.usbcali.modelo.ConfSemanasAno;
import co.edu.usbcali.modelo.dto.ConfSemanasAnoDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class ConfSemanasAnoView {
	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdSema_Semana;
	private InputText txtIdCfsa;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaFinal;
	private Calendar txtFechaInicial;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ConfSemanasAnoDTO> data;
	private ConfSemanasAnoDTO selectedConfSemanasAno;
	private ConfSemanasAno entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ConfSemanasAnoView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ConfSemanasAnoDTO confSemanasAnoDTO = (ConfSemanasAnoDTO) e
					.getObject();

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(confSemanasAnoDTO.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(confSemanasAnoDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(confSemanasAnoDTO.getOperModifica());

			if (txtIdSema_Semana == null) {
				txtIdSema_Semana = new InputText();
			}

			txtIdSema_Semana.setValue(confSemanasAnoDTO.getIdSema_Semana());

			if (txtIdCfsa == null) {
				txtIdCfsa = new InputText();
			}

			txtIdCfsa.setValue(confSemanasAnoDTO.getIdCfsa());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(confSemanasAnoDTO.getFechaCreacion());

			if (txtFechaFinal == null) {
				txtFechaFinal = new Calendar();
			}

			txtFechaFinal.setValue(confSemanasAnoDTO.getFechaFinal());

			if (txtFechaInicial == null) {
				txtFechaInicial = new Calendar();
			}

			txtFechaInicial.setValue(confSemanasAnoDTO.getFechaInicial());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(confSemanasAnoDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedConfSemanasAno = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedConfSemanasAno = null;

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

		if (txtIdSema_Semana != null) {
			txtIdSema_Semana.setValue(null);
			txtIdSema_Semana.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaFinal != null) {
			txtFechaFinal.setValue(null);
			txtFechaFinal.setDisabled(true);
		}

		if (txtFechaInicial != null) {
			txtFechaInicial.setValue(null);
			txtFechaInicial.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdCfsa != null) {
			txtIdCfsa.setValue(null);
			txtIdCfsa.setDisabled(false);
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

	public void listener_txtFechaFinal() {
		Date inputDate = (Date) txtFechaFinal.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaInicial() {
		Date inputDate = (Date) txtFechaInicial.getValue();
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
			Long idCfsa = new Long(txtIdCfsa.getValue().toString());
			entity = businessDelegatorView.getConfSemanasAno(idCfsa);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdSema_Semana.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdCfsa.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setValue(entity.getFechaFinal());
			txtFechaFinal.setDisabled(false);
			txtFechaInicial.setValue(entity.getFechaInicial());
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdSema_Semana.setValue(entity.getSemana().getIdSema());
			txtIdSema_Semana.setDisabled(false);
			txtIdCfsa.setValue(entity.getIdCfsa());
			txtIdCfsa.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedConfSemanasAno = (ConfSemanasAnoDTO) (evt.getComponent()
				.getAttributes().get("selectedConfSemanasAno"));
		txtEstadoRegistro.setValue(selectedConfSemanasAno.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedConfSemanasAno.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaFinal.setValue(selectedConfSemanasAno.getFechaFinal());
		txtFechaFinal.setDisabled(false);
		txtFechaInicial.setValue(selectedConfSemanasAno.getFechaInicial());
		txtFechaInicial.setDisabled(false);
		txtFechaModificacion.setValue(selectedConfSemanasAno
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedConfSemanasAno.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedConfSemanasAno.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdSema_Semana.setValue(selectedConfSemanasAno.getIdSema_Semana());
		txtIdSema_Semana.setDisabled(false);
		txtIdCfsa.setValue(selectedConfSemanasAno.getIdCfsa());
		txtIdCfsa.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedConfSemanasAno == null) && (entity == null)) {
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
			entity = new ConfSemanasAno();

			Long idCfsa = new Long(txtIdCfsa.getValue().toString());

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdCfsa(idCfsa);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setSemana(businessDelegatorView.getSemana(FacesUtils
					.checkLong(txtIdSema_Semana)));
			businessDelegatorView.saveConfSemanasAno(entity);
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
				Long idCfsa = new Long(selectedConfSemanasAno.getIdCfsa());
				entity = businessDelegatorView.getConfSemanasAno(idCfsa);
			}

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setSemana(businessDelegatorView.getSemana(FacesUtils
					.checkLong(txtIdSema_Semana)));
			businessDelegatorView.updateConfSemanasAno(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedConfSemanasAno = (ConfSemanasAnoDTO) (evt.getComponent()
					.getAttributes().get("selectedConfSemanasAno"));

			Long idCfsa = new Long(selectedConfSemanasAno.getIdCfsa());
			entity = businessDelegatorView.getConfSemanasAno(idCfsa);
			businessDelegatorView.deleteConfSemanasAno(entity);
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
			selectedConfSemanasAno = (ConfSemanasAnoDTO) (evt.getComponent()
					.getAttributes().get("selectedConfSemanasAno"));

			Long idCfsa = new Long(selectedConfSemanasAno.getIdCfsa());
			entity = businessDelegatorView.getConfSemanasAno(idCfsa);
			businessDelegatorView.deleteConfSemanasAno(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedConfSemanasAno);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaFinal, Date fechaInicial,
			Date fechaModificacion, Long idCfsa, String operCreador,
			String operModifica, Long idSema_Semana) throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(fechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(fechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateConfSemanasAno(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ConfSemanasAnoView").requestRender();
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

	public Calendar getTxtFechaFinal() {
		return txtFechaFinal;
	}

	public void setTxtFechaFinal(Calendar txtFechaFinal) {
		this.txtFechaFinal = txtFechaFinal;
	}

	public Calendar getTxtFechaInicial() {
		return txtFechaInicial;
	}

	public void setTxtFechaInicial(Calendar txtFechaInicial) {
		this.txtFechaInicial = txtFechaInicial;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public InputText getTxtIdCfsa() {
		return txtIdCfsa;
	}

	public void setTxtIdCfsa(InputText txtIdCfsa) {
		this.txtIdCfsa = txtIdCfsa;
	}

	public List<ConfSemanasAnoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataConfSemanasAno();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ConfSemanasAnoDTO> confSemanasAnoDTO) {
		this.data = confSemanasAnoDTO;
	}

	public ConfSemanasAnoDTO getSelectedConfSemanasAno() {
		return selectedConfSemanasAno;
	}

	public void setSelectedConfSemanasAno(ConfSemanasAnoDTO confSemanasAno) {
		this.selectedConfSemanasAno = confSemanasAno;
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
