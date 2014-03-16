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
import co.edu.usbcali.modelo.Proveedor;
import co.edu.usbcali.modelo.dto.ProveedorDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class ProveedorView {
	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdEmpr_Empresa;
	private InputText txtIdPers_Persona;
	private InputText txtIdProv;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ProveedorDTO> data;
	private ProveedorDTO selectedProveedor;
	private Proveedor entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ProveedorView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ProveedorDTO proveedorDTO = (ProveedorDTO) e.getObject();

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(proveedorDTO.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(proveedorDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(proveedorDTO.getOperModifica());

			if (txtIdEmpr_Empresa == null) {
				txtIdEmpr_Empresa = new InputText();
			}

			txtIdEmpr_Empresa.setValue(proveedorDTO.getIdEmpr_Empresa());

			if (txtIdPers_Persona == null) {
				txtIdPers_Persona = new InputText();
			}

			txtIdPers_Persona.setValue(proveedorDTO.getIdPers_Persona());

			if (txtIdProv == null) {
				txtIdProv = new InputText();
			}

			txtIdProv.setValue(proveedorDTO.getIdProv());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(proveedorDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(proveedorDTO.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedProveedor = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedProveedor = null;

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

		if (txtIdEmpr_Empresa != null) {
			txtIdEmpr_Empresa.setValue(null);
			txtIdEmpr_Empresa.setDisabled(true);
		}

		if (txtIdPers_Persona != null) {
			txtIdPers_Persona.setValue(null);
			txtIdPers_Persona.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdProv != null) {
			txtIdProv.setValue(null);
			txtIdProv.setDisabled(false);
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
			Long idProv = new Long(txtIdProv.getValue().toString());
			entity = businessDelegatorView.getProveedor(idProv);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdEmpr_Empresa.setDisabled(false);
			txtIdPers_Persona.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdProv.setDisabled(false);
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
			txtIdEmpr_Empresa.setValue(entity.getEmpresa().getIdEmpr());
			txtIdEmpr_Empresa.setDisabled(false);
			txtIdPers_Persona.setValue(entity.getPersona().getIdPers());
			txtIdPers_Persona.setDisabled(false);
			txtIdProv.setValue(entity.getIdProv());
			txtIdProv.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedProveedor = (ProveedorDTO) (evt.getComponent().getAttributes()
				.get("selectedProveedor"));
		txtEstadoRegistro.setValue(selectedProveedor.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedProveedor.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedProveedor.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedProveedor.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedProveedor.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdEmpr_Empresa.setValue(selectedProveedor.getIdEmpr_Empresa());
		txtIdEmpr_Empresa.setDisabled(false);
		txtIdPers_Persona.setValue(selectedProveedor.getIdPers_Persona());
		txtIdPers_Persona.setDisabled(false);
		txtIdProv.setValue(selectedProveedor.getIdProv());
		txtIdProv.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedProveedor == null) && (entity == null)) {
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
			entity = new Proveedor();

			Long idProv = new Long(txtIdProv.getValue().toString());

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdProv(idProv);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
					.checkLong(txtIdEmpr_Empresa)));
			entity.setPersona(businessDelegatorView.getPersona(FacesUtils
					.checkLong(txtIdPers_Persona)));
			businessDelegatorView.saveProveedor(entity);
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
				Long idProv = new Long(selectedProveedor.getIdProv());
				entity = businessDelegatorView.getProveedor(idProv);
			}

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
					.checkLong(txtIdEmpr_Empresa)));
			entity.setPersona(businessDelegatorView.getPersona(FacesUtils
					.checkLong(txtIdPers_Persona)));
			businessDelegatorView.updateProveedor(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedProveedor = (ProveedorDTO) (evt.getComponent()
					.getAttributes().get("selectedProveedor"));

			Long idProv = new Long(selectedProveedor.getIdProv());
			entity = businessDelegatorView.getProveedor(idProv);
			businessDelegatorView.deleteProveedor(entity);
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
			selectedProveedor = (ProveedorDTO) (evt.getComponent()
					.getAttributes().get("selectedProveedor"));

			Long idProv = new Long(selectedProveedor.getIdProv());
			entity = businessDelegatorView.getProveedor(idProv);
			businessDelegatorView.deleteProveedor(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedProveedor);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idProv,
			String operCreador, String operModifica, Long idEmpr_Empresa,
			Long idPers_Persona) throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateProveedor(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ProveedorView").requestRender();
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

	public InputText getTxtIdEmpr_Empresa() {
		return txtIdEmpr_Empresa;
	}

	public void setTxtIdEmpr_Empresa(InputText txtIdEmpr_Empresa) {
		this.txtIdEmpr_Empresa = txtIdEmpr_Empresa;
	}

	public InputText getTxtIdPers_Persona() {
		return txtIdPers_Persona;
	}

	public void setTxtIdPers_Persona(InputText txtIdPers_Persona) {
		this.txtIdPers_Persona = txtIdPers_Persona;
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

	public InputText getTxtIdProv() {
		return txtIdProv;
	}

	public void setTxtIdProv(InputText txtIdProv) {
		this.txtIdProv = txtIdProv;
	}

	public List<ProveedorDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataProveedor();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ProveedorDTO> proveedorDTO) {
		this.data = proveedorDTO;
	}

	public ProveedorDTO getSelectedProveedor() {
		return selectedProveedor;
	}

	public void setSelectedProveedor(ProveedorDTO proveedor) {
		this.selectedProveedor = proveedor;
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
