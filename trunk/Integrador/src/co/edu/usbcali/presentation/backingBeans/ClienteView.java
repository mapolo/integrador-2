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
import co.edu.usbcali.modelo.Cliente;
import co.edu.usbcali.modelo.dto.ClienteDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class ClienteView {
	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdEmpr_Empresa;
	private InputText txtIdPers_Persona;
	private InputText txtIdTica_TipoCartera;
	private InputText txtIdClie;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ClienteDTO> data;
	private ClienteDTO selectedCliente;
	private Cliente entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ClienteView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ClienteDTO clienteDTO = (ClienteDTO) e.getObject();

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(clienteDTO.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(clienteDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(clienteDTO.getOperModifica());

			if (txtIdEmpr_Empresa == null) {
				txtIdEmpr_Empresa = new InputText();
			}

			txtIdEmpr_Empresa.setValue(clienteDTO.getIdEmpr_Empresa());

			if (txtIdPers_Persona == null) {
				txtIdPers_Persona = new InputText();
			}

			txtIdPers_Persona.setValue(clienteDTO.getIdPers_Persona());

			if (txtIdTica_TipoCartera == null) {
				txtIdTica_TipoCartera = new InputText();
			}

			txtIdTica_TipoCartera.setValue(clienteDTO.getIdTica_TipoCartera());

			if (txtIdClie == null) {
				txtIdClie = new InputText();
			}

			txtIdClie.setValue(clienteDTO.getIdClie());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(clienteDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(clienteDTO.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedCliente = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedCliente = null;

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

		if (txtIdTica_TipoCartera != null) {
			txtIdTica_TipoCartera.setValue(null);
			txtIdTica_TipoCartera.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdClie != null) {
			txtIdClie.setValue(null);
			txtIdClie.setDisabled(false);
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
			Long idClie = new Long(txtIdClie.getValue().toString());
			entity = businessDelegatorView.getCliente(idClie);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdEmpr_Empresa.setDisabled(false);
			txtIdPers_Persona.setDisabled(false);
			txtIdTica_TipoCartera.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdClie.setDisabled(false);
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
			txtIdTica_TipoCartera.setValue(entity.getTipoCartera().getIdTica());
			txtIdTica_TipoCartera.setDisabled(false);
			txtIdClie.setValue(entity.getIdClie());
			txtIdClie.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedCliente = (ClienteDTO) (evt.getComponent().getAttributes()
				.get("selectedCliente"));
		txtEstadoRegistro.setValue(selectedCliente.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedCliente.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedCliente.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedCliente.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedCliente.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdEmpr_Empresa.setValue(selectedCliente.getIdEmpr_Empresa());
		txtIdEmpr_Empresa.setDisabled(false);
		txtIdPers_Persona.setValue(selectedCliente.getIdPers_Persona());
		txtIdPers_Persona.setDisabled(false);
		txtIdTica_TipoCartera.setValue(selectedCliente.getIdTica_TipoCartera());
		txtIdTica_TipoCartera.setDisabled(false);
		txtIdClie.setValue(selectedCliente.getIdClie());
		txtIdClie.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedCliente == null) && (entity == null)) {
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
			entity = new Cliente();

			Long idClie = new Long(txtIdClie.getValue().toString());

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdClie(idClie);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
					.checkLong(txtIdEmpr_Empresa)));
			entity.setPersona(businessDelegatorView.getPersona(FacesUtils
					.checkLong(txtIdPers_Persona)));
			entity.setTipoCartera(businessDelegatorView
					.getTipoCartera(FacesUtils.checkLong(txtIdTica_TipoCartera)));
			businessDelegatorView.saveCliente(entity);
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
				Long idClie = new Long(selectedCliente.getIdClie());
				entity = businessDelegatorView.getCliente(idClie);
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
			entity.setTipoCartera(businessDelegatorView
					.getTipoCartera(FacesUtils.checkLong(txtIdTica_TipoCartera)));
			businessDelegatorView.updateCliente(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedCliente = (ClienteDTO) (evt.getComponent().getAttributes()
					.get("selectedCliente"));

			Long idClie = new Long(selectedCliente.getIdClie());
			entity = businessDelegatorView.getCliente(idClie);
			businessDelegatorView.deleteCliente(entity);
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
			selectedCliente = (ClienteDTO) (evt.getComponent().getAttributes()
					.get("selectedCliente"));

			Long idClie = new Long(selectedCliente.getIdClie());
			entity = businessDelegatorView.getCliente(idClie);
			businessDelegatorView.deleteCliente(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedCliente);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idClie,
			String operCreador, String operModifica, Long idEmpr_Empresa,
			Long idPers_Persona, Long idTica_TipoCartera) throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateCliente(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ClienteView").requestRender();
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

	public InputText getTxtIdTica_TipoCartera() {
		return txtIdTica_TipoCartera;
	}

	public void setTxtIdTica_TipoCartera(InputText txtIdTica_TipoCartera) {
		this.txtIdTica_TipoCartera = txtIdTica_TipoCartera;
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

	public InputText getTxtIdClie() {
		return txtIdClie;
	}

	public void setTxtIdClie(InputText txtIdClie) {
		this.txtIdClie = txtIdClie;
	}

	public List<ClienteDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataCliente();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ClienteDTO> clienteDTO) {
		this.data = clienteDTO;
	}

	public ClienteDTO getSelectedCliente() {
		return selectedCliente;
	}

	public void setSelectedCliente(ClienteDTO cliente) {
		this.selectedCliente = cliente;
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
