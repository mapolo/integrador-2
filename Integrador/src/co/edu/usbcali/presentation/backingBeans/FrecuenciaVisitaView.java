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
import co.edu.usbcali.modelo.FrecuenciaVisita;
import co.edu.usbcali.modelo.dto.FrecuenciaVisitaDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class FrecuenciaVisitaView {
	private InputText txtCodigo;
	private InputText txtDescripcion;
	private InputText txtEstadoRegistro;
	private InputText txtFrecuencia;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdFrvi;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<FrecuenciaVisitaDTO> data;
	private FrecuenciaVisitaDTO selectedFrecuenciaVisita;
	private FrecuenciaVisita entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public FrecuenciaVisitaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			FrecuenciaVisitaDTO frecuenciaVisitaDTO = (FrecuenciaVisitaDTO) e
					.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(frecuenciaVisitaDTO.getCodigo());

			if (txtDescripcion == null) {
				txtDescripcion = new InputText();
			}

			txtDescripcion.setValue(frecuenciaVisitaDTO.getDescripcion());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(frecuenciaVisitaDTO.getEstadoRegistro());

			if (txtFrecuencia == null) {
				txtFrecuencia = new InputText();
			}

			txtFrecuencia.setValue(frecuenciaVisitaDTO.getFrecuencia());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(frecuenciaVisitaDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(frecuenciaVisitaDTO.getOperModifica());

			if (txtIdFrvi == null) {
				txtIdFrvi = new InputText();
			}

			txtIdFrvi.setValue(frecuenciaVisitaDTO.getIdFrvi());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(frecuenciaVisitaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(frecuenciaVisitaDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedFrecuenciaVisita = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedFrecuenciaVisita = null;

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(true);
		}

		if (txtDescripcion != null) {
			txtDescripcion.setValue(null);
			txtDescripcion.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtFrecuencia != null) {
			txtFrecuencia.setValue(null);
			txtFrecuencia.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdFrvi != null) {
			txtIdFrvi.setValue(null);
			txtIdFrvi.setDisabled(false);
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
			Long idFrvi = new Long(txtIdFrvi.getValue().toString());
			entity = businessDelegatorView.getFrecuenciaVisita(idFrvi);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtDescripcion.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtFrecuencia.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdFrvi.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtDescripcion.setValue(entity.getDescripcion());
			txtDescripcion.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtFrecuencia.setValue(entity.getFrecuencia());
			txtFrecuencia.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdFrvi.setValue(entity.getIdFrvi());
			txtIdFrvi.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedFrecuenciaVisita = (FrecuenciaVisitaDTO) (evt.getComponent()
				.getAttributes().get("selectedFrecuenciaVisita"));
		txtCodigo.setValue(selectedFrecuenciaVisita.getCodigo());
		txtCodigo.setDisabled(false);
		txtDescripcion.setValue(selectedFrecuenciaVisita.getDescripcion());
		txtDescripcion.setDisabled(false);
		txtEstadoRegistro
				.setValue(selectedFrecuenciaVisita.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedFrecuenciaVisita.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedFrecuenciaVisita
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtFrecuencia.setValue(selectedFrecuenciaVisita.getFrecuencia());
		txtFrecuencia.setDisabled(false);
		txtOperCreador.setValue(selectedFrecuenciaVisita.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedFrecuenciaVisita.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdFrvi.setValue(selectedFrecuenciaVisita.getIdFrvi());
		txtIdFrvi.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedFrecuenciaVisita == null) && (entity == null)) {
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
			entity = new FrecuenciaVisita();

			Long idFrvi = new Long(txtIdFrvi.getValue().toString());

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFrecuencia(FacesUtils.checkLong(txtFrecuencia));
			entity.setIdFrvi(idFrvi);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			businessDelegatorView.saveFrecuenciaVisita(entity);
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
				Long idFrvi = new Long(selectedFrecuenciaVisita.getIdFrvi());
				entity = businessDelegatorView.getFrecuenciaVisita(idFrvi);
			}

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFrecuencia(FacesUtils.checkLong(txtFrecuencia));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			businessDelegatorView.updateFrecuenciaVisita(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedFrecuenciaVisita = (FrecuenciaVisitaDTO) (evt
					.getComponent().getAttributes()
					.get("selectedFrecuenciaVisita"));

			Long idFrvi = new Long(selectedFrecuenciaVisita.getIdFrvi());
			entity = businessDelegatorView.getFrecuenciaVisita(idFrvi);
			businessDelegatorView.deleteFrecuenciaVisita(entity);
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
			selectedFrecuenciaVisita = (FrecuenciaVisitaDTO) (evt
					.getComponent().getAttributes()
					.get("selectedFrecuenciaVisita"));

			Long idFrvi = new Long(selectedFrecuenciaVisita.getIdFrvi());
			entity = businessDelegatorView.getFrecuenciaVisita(idFrvi);
			businessDelegatorView.deleteFrecuenciaVisita(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedFrecuenciaVisita);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, String descripcion,
			String estadoRegistro, Date fechaCreacion, Date fechaModificacion,
			Long frecuencia, Long idFrvi, String operCreador,
			String operModifica) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setDescripcion(FacesUtils.checkString(descripcion));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFrecuencia(FacesUtils.checkLong(frecuencia));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateFrecuenciaVisita(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("FrecuenciaVisitaView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(InputText txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public InputText getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(InputText txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}

	public InputText getTxtFrecuencia() {
		return txtFrecuencia;
	}

	public void setTxtFrecuencia(InputText txtFrecuencia) {
		this.txtFrecuencia = txtFrecuencia;
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

	public InputText getTxtIdFrvi() {
		return txtIdFrvi;
	}

	public void setTxtIdFrvi(InputText txtIdFrvi) {
		this.txtIdFrvi = txtIdFrvi;
	}

	public List<FrecuenciaVisitaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataFrecuenciaVisita();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<FrecuenciaVisitaDTO> frecuenciaVisitaDTO) {
		this.data = frecuenciaVisitaDTO;
	}

	public FrecuenciaVisitaDTO getSelectedFrecuenciaVisita() {
		return selectedFrecuenciaVisita;
	}

	public void setSelectedFrecuenciaVisita(FrecuenciaVisitaDTO frecuenciaVisita) {
		this.selectedFrecuenciaVisita = frecuenciaVisita;
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
