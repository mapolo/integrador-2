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
import co.edu.usbcali.modelo.CamposParametrizables;
import co.edu.usbcali.modelo.dto.CamposParametrizablesDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class CamposParametrizablesView {
	private InputText txtEstadoRegistro;
	private InputText txtNombre;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdTabl_Tabla;
	private InputText txtIdCapa;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<CamposParametrizablesDTO> data;
	private CamposParametrizablesDTO selectedCamposParametrizables;
	private CamposParametrizables entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public CamposParametrizablesView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			CamposParametrizablesDTO camposParametrizablesDTO = (CamposParametrizablesDTO) e
					.getObject();

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(camposParametrizablesDTO
					.getEstadoRegistro());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(camposParametrizablesDTO.getNombre());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(camposParametrizablesDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica
					.setValue(camposParametrizablesDTO.getOperModifica());

			if (txtIdTabl_Tabla == null) {
				txtIdTabl_Tabla = new InputText();
			}

			txtIdTabl_Tabla
					.setValue(camposParametrizablesDTO.getIdTabl_Tabla());

			if (txtIdCapa == null) {
				txtIdCapa = new InputText();
			}

			txtIdCapa.setValue(camposParametrizablesDTO.getIdCapa());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(camposParametrizablesDTO
					.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(camposParametrizablesDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedCamposParametrizables = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedCamposParametrizables = null;

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtIdTabl_Tabla != null) {
			txtIdTabl_Tabla.setValue(null);
			txtIdTabl_Tabla.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdCapa != null) {
			txtIdCapa.setValue(null);
			txtIdCapa.setDisabled(false);
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
			Long idCapa = new Long(txtIdCapa.getValue().toString());
			entity = businessDelegatorView.getCamposParametrizables(idCapa);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEstadoRegistro.setDisabled(false);
			txtNombre.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdTabl_Tabla.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdCapa.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdTabl_Tabla.setValue(entity.getTabla().getIdTabl());
			txtIdTabl_Tabla.setDisabled(false);
			txtIdCapa.setValue(entity.getIdCapa());
			txtIdCapa.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedCamposParametrizables = (CamposParametrizablesDTO) (evt
				.getComponent().getAttributes()
				.get("selectedCamposParametrizables"));
		txtEstadoRegistro.setValue(selectedCamposParametrizables
				.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedCamposParametrizables
				.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedCamposParametrizables
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtNombre.setValue(selectedCamposParametrizables.getNombre());
		txtNombre.setDisabled(false);
		txtOperCreador.setValue(selectedCamposParametrizables.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedCamposParametrizables
				.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdTabl_Tabla.setValue(selectedCamposParametrizables
				.getIdTabl_Tabla());
		txtIdTabl_Tabla.setDisabled(false);
		txtIdCapa.setValue(selectedCamposParametrizables.getIdCapa());
		txtIdCapa.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedCamposParametrizables == null) && (entity == null)) {
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
			entity = new CamposParametrizables();

			Long idCapa = new Long(txtIdCapa.getValue().toString());

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdCapa(idCapa);
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setTabla(businessDelegatorView.getTabla(FacesUtils
					.checkLong(txtIdTabl_Tabla)));
			businessDelegatorView.saveCamposParametrizables(entity);
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
				Long idCapa = new Long(
						selectedCamposParametrizables.getIdCapa());
				entity = businessDelegatorView.getCamposParametrizables(idCapa);
			}

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setTabla(businessDelegatorView.getTabla(FacesUtils
					.checkLong(txtIdTabl_Tabla)));
			businessDelegatorView.updateCamposParametrizables(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedCamposParametrizables = (CamposParametrizablesDTO) (evt
					.getComponent().getAttributes()
					.get("selectedCamposParametrizables"));

			Long idCapa = new Long(selectedCamposParametrizables.getIdCapa());
			entity = businessDelegatorView.getCamposParametrizables(idCapa);
			businessDelegatorView.deleteCamposParametrizables(entity);
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
			selectedCamposParametrizables = (CamposParametrizablesDTO) (evt
					.getComponent().getAttributes()
					.get("selectedCamposParametrizables"));

			Long idCapa = new Long(selectedCamposParametrizables.getIdCapa());
			entity = businessDelegatorView.getCamposParametrizables(idCapa);
			businessDelegatorView.deleteCamposParametrizables(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedCamposParametrizables);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idCapa,
			String nombre, String operCreador, String operModifica,
			Long idTabl_Tabla) throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateCamposParametrizables(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("CamposParametrizablesView").requestRender();
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

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
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

	public InputText getTxtIdTabl_Tabla() {
		return txtIdTabl_Tabla;
	}

	public void setTxtIdTabl_Tabla(InputText txtIdTabl_Tabla) {
		this.txtIdTabl_Tabla = txtIdTabl_Tabla;
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

	public InputText getTxtIdCapa() {
		return txtIdCapa;
	}

	public void setTxtIdCapa(InputText txtIdCapa) {
		this.txtIdCapa = txtIdCapa;
	}

	public List<CamposParametrizablesDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataCamposParametrizables();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<CamposParametrizablesDTO> camposParametrizablesDTO) {
		this.data = camposParametrizablesDTO;
	}

	public CamposParametrizablesDTO getSelectedCamposParametrizables() {
		return selectedCamposParametrizables;
	}

	public void setSelectedCamposParametrizables(
			CamposParametrizablesDTO camposParametrizables) {
		this.selectedCamposParametrizables = camposParametrizables;
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
