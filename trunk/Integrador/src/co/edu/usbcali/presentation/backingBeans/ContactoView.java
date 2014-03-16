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
import co.edu.usbcali.modelo.Contacto;
import co.edu.usbcali.modelo.dto.ContactoDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class ContactoView {
	private InputText txtEmail;
	private InputText txtEstadoRegistro;
	private InputText txtNombreCompleto;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtTelefono1;
	private InputText txtTelefono2;
	private InputText txtIdAtve_AtencionVendedor;
	private InputText txtIdSucu_Sucursal;
	private InputText txtIdTico_TipoContacto;
	private InputText txtIdCont;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ContactoDTO> data;
	private ContactoDTO selectedContacto;
	private Contacto entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ContactoView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ContactoDTO contactoDTO = (ContactoDTO) e.getObject();

			if (txtEmail == null) {
				txtEmail = new InputText();
			}

			txtEmail.setValue(contactoDTO.getEmail());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(contactoDTO.getEstadoRegistro());

			if (txtNombreCompleto == null) {
				txtNombreCompleto = new InputText();
			}

			txtNombreCompleto.setValue(contactoDTO.getNombreCompleto());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(contactoDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(contactoDTO.getOperModifica());

			if (txtTelefono1 == null) {
				txtTelefono1 = new InputText();
			}

			txtTelefono1.setValue(contactoDTO.getTelefono1());

			if (txtTelefono2 == null) {
				txtTelefono2 = new InputText();
			}

			txtTelefono2.setValue(contactoDTO.getTelefono2());

			if (txtIdAtve_AtencionVendedor == null) {
				txtIdAtve_AtencionVendedor = new InputText();
			}

			txtIdAtve_AtencionVendedor.setValue(contactoDTO
					.getIdAtve_AtencionVendedor());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new InputText();
			}

			txtIdSucu_Sucursal.setValue(contactoDTO.getIdSucu_Sucursal());

			if (txtIdTico_TipoContacto == null) {
				txtIdTico_TipoContacto = new InputText();
			}

			txtIdTico_TipoContacto.setValue(contactoDTO
					.getIdTico_TipoContacto());

			if (txtIdCont == null) {
				txtIdCont = new InputText();
			}

			txtIdCont.setValue(contactoDTO.getIdCont());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(contactoDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(contactoDTO.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedContacto = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedContacto = null;

		if (txtEmail != null) {
			txtEmail.setValue(null);
			txtEmail.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtNombreCompleto != null) {
			txtNombreCompleto.setValue(null);
			txtNombreCompleto.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtTelefono1 != null) {
			txtTelefono1.setValue(null);
			txtTelefono1.setDisabled(true);
		}

		if (txtTelefono2 != null) {
			txtTelefono2.setValue(null);
			txtTelefono2.setDisabled(true);
		}

		if (txtIdAtve_AtencionVendedor != null) {
			txtIdAtve_AtencionVendedor.setValue(null);
			txtIdAtve_AtencionVendedor.setDisabled(true);
		}

		if (txtIdSucu_Sucursal != null) {
			txtIdSucu_Sucursal.setValue(null);
			txtIdSucu_Sucursal.setDisabled(true);
		}

		if (txtIdTico_TipoContacto != null) {
			txtIdTico_TipoContacto.setValue(null);
			txtIdTico_TipoContacto.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdCont != null) {
			txtIdCont.setValue(null);
			txtIdCont.setDisabled(false);
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
			Long idCont = new Long(txtIdCont.getValue().toString());
			entity = businessDelegatorView.getContacto(idCont);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEmail.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtNombreCompleto.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtTelefono1.setDisabled(false);
			txtTelefono2.setDisabled(false);
			txtIdAtve_AtencionVendedor.setDisabled(false);
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdTico_TipoContacto.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdCont.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtEmail.setValue(entity.getEmail());
			txtEmail.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtNombreCompleto.setValue(entity.getNombreCompleto());
			txtNombreCompleto.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtTelefono1.setValue(entity.getTelefono1());
			txtTelefono1.setDisabled(false);
			txtTelefono2.setValue(entity.getTelefono2());
			txtTelefono2.setDisabled(false);
			txtIdAtve_AtencionVendedor.setValue(entity.getAtencionVendedor()
					.getIdAtve());
			txtIdAtve_AtencionVendedor.setDisabled(false);
			txtIdSucu_Sucursal.setValue(entity.getSucursal().getIdSucu());
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdTico_TipoContacto.setValue(entity.getTipoContacto()
					.getIdTico());
			txtIdTico_TipoContacto.setDisabled(false);
			txtIdCont.setValue(entity.getIdCont());
			txtIdCont.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedContacto = (ContactoDTO) (evt.getComponent().getAttributes()
				.get("selectedContacto"));
		txtEmail.setValue(selectedContacto.getEmail());
		txtEmail.setDisabled(false);
		txtEstadoRegistro.setValue(selectedContacto.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedContacto.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedContacto.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtNombreCompleto.setValue(selectedContacto.getNombreCompleto());
		txtNombreCompleto.setDisabled(false);
		txtOperCreador.setValue(selectedContacto.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedContacto.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtTelefono1.setValue(selectedContacto.getTelefono1());
		txtTelefono1.setDisabled(false);
		txtTelefono2.setValue(selectedContacto.getTelefono2());
		txtTelefono2.setDisabled(false);
		txtIdAtve_AtencionVendedor.setValue(selectedContacto
				.getIdAtve_AtencionVendedor());
		txtIdAtve_AtencionVendedor.setDisabled(false);
		txtIdSucu_Sucursal.setValue(selectedContacto.getIdSucu_Sucursal());
		txtIdSucu_Sucursal.setDisabled(false);
		txtIdTico_TipoContacto.setValue(selectedContacto
				.getIdTico_TipoContacto());
		txtIdTico_TipoContacto.setDisabled(false);
		txtIdCont.setValue(selectedContacto.getIdCont());
		txtIdCont.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedContacto == null) && (entity == null)) {
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
			entity = new Contacto();

			Long idCont = new Long(txtIdCont.getValue().toString());

			entity.setEmail(FacesUtils.checkString(txtEmail));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdCont(idCont);
			entity.setNombreCompleto(FacesUtils.checkString(txtNombreCompleto));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setTelefono1(FacesUtils.checkString(txtTelefono1));
			entity.setTelefono2(FacesUtils.checkString(txtTelefono2));
			entity.setAtencionVendedor(businessDelegatorView
					.getAtencionVendedor(FacesUtils
							.checkLong(txtIdAtve_AtencionVendedor)));
			entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			entity.setTipoContacto(businessDelegatorView
					.getTipoContacto(FacesUtils
							.checkLong(txtIdTico_TipoContacto)));
			businessDelegatorView.saveContacto(entity);
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
				Long idCont = new Long(selectedContacto.getIdCont());
				entity = businessDelegatorView.getContacto(idCont);
			}

			entity.setEmail(FacesUtils.checkString(txtEmail));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setNombreCompleto(FacesUtils.checkString(txtNombreCompleto));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setTelefono1(FacesUtils.checkString(txtTelefono1));
			entity.setTelefono2(FacesUtils.checkString(txtTelefono2));
			entity.setAtencionVendedor(businessDelegatorView
					.getAtencionVendedor(FacesUtils
							.checkLong(txtIdAtve_AtencionVendedor)));
			entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			entity.setTipoContacto(businessDelegatorView
					.getTipoContacto(FacesUtils
							.checkLong(txtIdTico_TipoContacto)));
			businessDelegatorView.updateContacto(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedContacto = (ContactoDTO) (evt.getComponent()
					.getAttributes().get("selectedContacto"));

			Long idCont = new Long(selectedContacto.getIdCont());
			entity = businessDelegatorView.getContacto(idCont);
			businessDelegatorView.deleteContacto(entity);
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
			selectedContacto = (ContactoDTO) (evt.getComponent()
					.getAttributes().get("selectedContacto"));

			Long idCont = new Long(selectedContacto.getIdCont());
			entity = businessDelegatorView.getContacto(idCont);
			businessDelegatorView.deleteContacto(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedContacto);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String email, String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idCont,
			String nombreCompleto, String operCreador, String operModifica,
			String telefono1, String telefono2, Long idAtve_AtencionVendedor,
			Long idSucu_Sucursal, Long idTico_TipoContacto) throws Exception {
		try {
			entity.setEmail(FacesUtils.checkString(email));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setNombreCompleto(FacesUtils.checkString(nombreCompleto));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setTelefono1(FacesUtils.checkString(telefono1));
			entity.setTelefono2(FacesUtils.checkString(telefono2));
			businessDelegatorView.updateContacto(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ContactoView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(InputText txtEmail) {
		this.txtEmail = txtEmail;
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}

	public InputText getTxtNombreCompleto() {
		return txtNombreCompleto;
	}

	public void setTxtNombreCompleto(InputText txtNombreCompleto) {
		this.txtNombreCompleto = txtNombreCompleto;
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

	public InputText getTxtTelefono1() {
		return txtTelefono1;
	}

	public void setTxtTelefono1(InputText txtTelefono1) {
		this.txtTelefono1 = txtTelefono1;
	}

	public InputText getTxtTelefono2() {
		return txtTelefono2;
	}

	public void setTxtTelefono2(InputText txtTelefono2) {
		this.txtTelefono2 = txtTelefono2;
	}

	public InputText getTxtIdAtve_AtencionVendedor() {
		return txtIdAtve_AtencionVendedor;
	}

	public void setTxtIdAtve_AtencionVendedor(
			InputText txtIdAtve_AtencionVendedor) {
		this.txtIdAtve_AtencionVendedor = txtIdAtve_AtencionVendedor;
	}

	public InputText getTxtIdSucu_Sucursal() {
		return txtIdSucu_Sucursal;
	}

	public void setTxtIdSucu_Sucursal(InputText txtIdSucu_Sucursal) {
		this.txtIdSucu_Sucursal = txtIdSucu_Sucursal;
	}

	public InputText getTxtIdTico_TipoContacto() {
		return txtIdTico_TipoContacto;
	}

	public void setTxtIdTico_TipoContacto(InputText txtIdTico_TipoContacto) {
		this.txtIdTico_TipoContacto = txtIdTico_TipoContacto;
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

	public InputText getTxtIdCont() {
		return txtIdCont;
	}

	public void setTxtIdCont(InputText txtIdCont) {
		this.txtIdCont = txtIdCont;
	}

	public List<ContactoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataContacto();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ContactoDTO> contactoDTO) {
		this.data = contactoDTO;
	}

	public ContactoDTO getSelectedContacto() {
		return selectedContacto;
	}

	public void setSelectedContacto(ContactoDTO contacto) {
		this.selectedContacto = contacto;
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
