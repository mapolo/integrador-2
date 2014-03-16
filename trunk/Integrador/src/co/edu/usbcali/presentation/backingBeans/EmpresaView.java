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
import co.edu.usbcali.modelo.Empresa;
import co.edu.usbcali.modelo.dto.EmpresaDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class EmpresaView {
	private InputText txtApartadoAereo;
	private InputText txtDireccion;
	private InputText txtEmail;
	private InputText txtEstadoRegistro;
	private InputText txtFax;
	private InputText txtIdentificacion;
	private InputText txtNombre;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtTelefono1;
	private InputText txtTelefono2;
	private InputText txtIdDipo_DivisionPolitica;
	private InputText txtIdPers_Persona;
	private InputText txtIdTiid_TipoIdentificacion;
	private InputText txtIdEmpr;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<EmpresaDTO> data;
	private EmpresaDTO selectedEmpresa;
	private Empresa entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public EmpresaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			EmpresaDTO empresaDTO = (EmpresaDTO) e.getObject();

			if (txtApartadoAereo == null) {
				txtApartadoAereo = new InputText();
			}

			txtApartadoAereo.setValue(empresaDTO.getApartadoAereo());

			if (txtDireccion == null) {
				txtDireccion = new InputText();
			}

			txtDireccion.setValue(empresaDTO.getDireccion());

			if (txtEmail == null) {
				txtEmail = new InputText();
			}

			txtEmail.setValue(empresaDTO.getEmail());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(empresaDTO.getEstadoRegistro());

			if (txtFax == null) {
				txtFax = new InputText();
			}

			txtFax.setValue(empresaDTO.getFax());

			if (txtIdentificacion == null) {
				txtIdentificacion = new InputText();
			}

			txtIdentificacion.setValue(empresaDTO.getIdentificacion());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(empresaDTO.getNombre());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(empresaDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(empresaDTO.getOperModifica());

			if (txtTelefono1 == null) {
				txtTelefono1 = new InputText();
			}

			txtTelefono1.setValue(empresaDTO.getTelefono1());

			if (txtTelefono2 == null) {
				txtTelefono2 = new InputText();
			}

			txtTelefono2.setValue(empresaDTO.getTelefono2());

			if (txtIdDipo_DivisionPolitica == null) {
				txtIdDipo_DivisionPolitica = new InputText();
			}

			txtIdDipo_DivisionPolitica.setValue(empresaDTO
					.getIdDipo_DivisionPolitica());

			if (txtIdPers_Persona == null) {
				txtIdPers_Persona = new InputText();
			}

			txtIdPers_Persona.setValue(empresaDTO.getIdPers_Persona());

			if (txtIdTiid_TipoIdentificacion == null) {
				txtIdTiid_TipoIdentificacion = new InputText();
			}

			txtIdTiid_TipoIdentificacion.setValue(empresaDTO
					.getIdTiid_TipoIdentificacion());

			if (txtIdEmpr == null) {
				txtIdEmpr = new InputText();
			}

			txtIdEmpr.setValue(empresaDTO.getIdEmpr());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(empresaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(empresaDTO.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedEmpresa = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedEmpresa = null;

		if (txtApartadoAereo != null) {
			txtApartadoAereo.setValue(null);
			txtApartadoAereo.setDisabled(true);
		}

		if (txtDireccion != null) {
			txtDireccion.setValue(null);
			txtDireccion.setDisabled(true);
		}

		if (txtEmail != null) {
			txtEmail.setValue(null);
			txtEmail.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtFax != null) {
			txtFax.setValue(null);
			txtFax.setDisabled(true);
		}

		if (txtIdentificacion != null) {
			txtIdentificacion.setValue(null);
			txtIdentificacion.setDisabled(true);
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

		if (txtTelefono1 != null) {
			txtTelefono1.setValue(null);
			txtTelefono1.setDisabled(true);
		}

		if (txtTelefono2 != null) {
			txtTelefono2.setValue(null);
			txtTelefono2.setDisabled(true);
		}

		if (txtIdDipo_DivisionPolitica != null) {
			txtIdDipo_DivisionPolitica.setValue(null);
			txtIdDipo_DivisionPolitica.setDisabled(true);
		}

		if (txtIdPers_Persona != null) {
			txtIdPers_Persona.setValue(null);
			txtIdPers_Persona.setDisabled(true);
		}

		if (txtIdTiid_TipoIdentificacion != null) {
			txtIdTiid_TipoIdentificacion.setValue(null);
			txtIdTiid_TipoIdentificacion.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdEmpr != null) {
			txtIdEmpr.setValue(null);
			txtIdEmpr.setDisabled(false);
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
			Long idEmpr = new Long(txtIdEmpr.getValue().toString());
			entity = businessDelegatorView.getEmpresa(idEmpr);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtApartadoAereo.setDisabled(false);
			txtDireccion.setDisabled(false);
			txtEmail.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtFax.setDisabled(false);
			txtIdentificacion.setDisabled(false);
			txtNombre.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtTelefono1.setDisabled(false);
			txtTelefono2.setDisabled(false);
			txtIdDipo_DivisionPolitica.setDisabled(false);
			txtIdPers_Persona.setDisabled(false);
			txtIdTiid_TipoIdentificacion.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdEmpr.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtApartadoAereo.setValue(entity.getApartadoAereo());
			txtApartadoAereo.setDisabled(false);
			txtDireccion.setValue(entity.getDireccion());
			txtDireccion.setDisabled(false);
			txtEmail.setValue(entity.getEmail());
			txtEmail.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFax.setValue(entity.getFax());
			txtFax.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtIdentificacion.setValue(entity.getIdentificacion());
			txtIdentificacion.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtTelefono1.setValue(entity.getTelefono1());
			txtTelefono1.setDisabled(false);
			txtTelefono2.setValue(entity.getTelefono2());
			txtTelefono2.setDisabled(false);
			txtIdDipo_DivisionPolitica.setValue(entity.getDivisionPolitica()
					.getIdDipo());
			txtIdDipo_DivisionPolitica.setDisabled(false);
			txtIdPers_Persona.setValue(entity.getPersona().getIdPers());
			txtIdPers_Persona.setDisabled(false);
			txtIdTiid_TipoIdentificacion.setValue(entity
					.getTipoIdentificacion().getIdTiid());
			txtIdTiid_TipoIdentificacion.setDisabled(false);
			txtIdEmpr.setValue(entity.getIdEmpr());
			txtIdEmpr.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedEmpresa = (EmpresaDTO) (evt.getComponent().getAttributes()
				.get("selectedEmpresa"));
		txtApartadoAereo.setValue(selectedEmpresa.getApartadoAereo());
		txtApartadoAereo.setDisabled(false);
		txtDireccion.setValue(selectedEmpresa.getDireccion());
		txtDireccion.setDisabled(false);
		txtEmail.setValue(selectedEmpresa.getEmail());
		txtEmail.setDisabled(false);
		txtEstadoRegistro.setValue(selectedEmpresa.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFax.setValue(selectedEmpresa.getFax());
		txtFax.setDisabled(false);
		txtFechaCreacion.setValue(selectedEmpresa.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedEmpresa.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtIdentificacion.setValue(selectedEmpresa.getIdentificacion());
		txtIdentificacion.setDisabled(false);
		txtNombre.setValue(selectedEmpresa.getNombre());
		txtNombre.setDisabled(false);
		txtOperCreador.setValue(selectedEmpresa.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedEmpresa.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtTelefono1.setValue(selectedEmpresa.getTelefono1());
		txtTelefono1.setDisabled(false);
		txtTelefono2.setValue(selectedEmpresa.getTelefono2());
		txtTelefono2.setDisabled(false);
		txtIdDipo_DivisionPolitica.setValue(selectedEmpresa
				.getIdDipo_DivisionPolitica());
		txtIdDipo_DivisionPolitica.setDisabled(false);
		txtIdPers_Persona.setValue(selectedEmpresa.getIdPers_Persona());
		txtIdPers_Persona.setDisabled(false);
		txtIdTiid_TipoIdentificacion.setValue(selectedEmpresa
				.getIdTiid_TipoIdentificacion());
		txtIdTiid_TipoIdentificacion.setDisabled(false);
		txtIdEmpr.setValue(selectedEmpresa.getIdEmpr());
		txtIdEmpr.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedEmpresa == null) && (entity == null)) {
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
			entity = new Empresa();

			Long idEmpr = new Long(txtIdEmpr.getValue().toString());

			entity.setApartadoAereo(FacesUtils.checkString(txtApartadoAereo));
			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			entity.setEmail(FacesUtils.checkString(txtEmail));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFax(FacesUtils.checkString(txtFax));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdEmpr(idEmpr);
			entity.setIdentificacion(FacesUtils.checkLong(txtIdentificacion));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setTelefono1(FacesUtils.checkString(txtTelefono1));
			entity.setTelefono2(FacesUtils.checkString(txtTelefono2));
			entity.setDivisionPolitica(businessDelegatorView
					.getDivisionPolitica(FacesUtils
							.checkLong(txtIdDipo_DivisionPolitica)));
			entity.setPersona(businessDelegatorView.getPersona(FacesUtils
					.checkLong(txtIdPers_Persona)));
			entity.setTipoIdentificacion(businessDelegatorView
					.getTipoIdentificacion(FacesUtils
							.checkLong(txtIdTiid_TipoIdentificacion)));
			businessDelegatorView.saveEmpresa(entity);
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
				Long idEmpr = new Long(selectedEmpresa.getIdEmpr());
				entity = businessDelegatorView.getEmpresa(idEmpr);
			}

			entity.setApartadoAereo(FacesUtils.checkString(txtApartadoAereo));
			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			entity.setEmail(FacesUtils.checkString(txtEmail));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFax(FacesUtils.checkString(txtFax));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdentificacion(FacesUtils.checkLong(txtIdentificacion));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setTelefono1(FacesUtils.checkString(txtTelefono1));
			entity.setTelefono2(FacesUtils.checkString(txtTelefono2));
			entity.setDivisionPolitica(businessDelegatorView
					.getDivisionPolitica(FacesUtils
							.checkLong(txtIdDipo_DivisionPolitica)));
			entity.setPersona(businessDelegatorView.getPersona(FacesUtils
					.checkLong(txtIdPers_Persona)));
			entity.setTipoIdentificacion(businessDelegatorView
					.getTipoIdentificacion(FacesUtils
							.checkLong(txtIdTiid_TipoIdentificacion)));
			businessDelegatorView.updateEmpresa(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedEmpresa = (EmpresaDTO) (evt.getComponent().getAttributes()
					.get("selectedEmpresa"));

			Long idEmpr = new Long(selectedEmpresa.getIdEmpr());
			entity = businessDelegatorView.getEmpresa(idEmpr);
			businessDelegatorView.deleteEmpresa(entity);
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
			selectedEmpresa = (EmpresaDTO) (evt.getComponent().getAttributes()
					.get("selectedEmpresa"));

			Long idEmpr = new Long(selectedEmpresa.getIdEmpr());
			entity = businessDelegatorView.getEmpresa(idEmpr);
			businessDelegatorView.deleteEmpresa(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedEmpresa);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String apartadoAereo, String direccion,
			String email, String estadoRegistro, String fax,
			Date fechaCreacion, Date fechaModificacion, Long idEmpr,
			Long identificacion, String nombre, String operCreador,
			String operModifica, String telefono1, String telefono2,
			Long idDipo_DivisionPolitica, Long idPers_Persona,
			Long idTiid_TipoIdentificacion) throws Exception {
		try {
			entity.setApartadoAereo(FacesUtils.checkString(apartadoAereo));
			entity.setDireccion(FacesUtils.checkString(direccion));
			entity.setEmail(FacesUtils.checkString(email));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFax(FacesUtils.checkString(fax));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setIdentificacion(FacesUtils.checkLong(identificacion));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setTelefono1(FacesUtils.checkString(telefono1));
			entity.setTelefono2(FacesUtils.checkString(telefono2));
			businessDelegatorView.updateEmpresa(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("EmpresaView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtApartadoAereo() {
		return txtApartadoAereo;
	}

	public void setTxtApartadoAereo(InputText txtApartadoAereo) {
		this.txtApartadoAereo = txtApartadoAereo;
	}

	public InputText getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(InputText txtDireccion) {
		this.txtDireccion = txtDireccion;
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

	public InputText getTxtFax() {
		return txtFax;
	}

	public void setTxtFax(InputText txtFax) {
		this.txtFax = txtFax;
	}

	public InputText getTxtIdentificacion() {
		return txtIdentificacion;
	}

	public void setTxtIdentificacion(InputText txtIdentificacion) {
		this.txtIdentificacion = txtIdentificacion;
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

	public InputText getTxtIdDipo_DivisionPolitica() {
		return txtIdDipo_DivisionPolitica;
	}

	public void setTxtIdDipo_DivisionPolitica(
			InputText txtIdDipo_DivisionPolitica) {
		this.txtIdDipo_DivisionPolitica = txtIdDipo_DivisionPolitica;
	}

	public InputText getTxtIdPers_Persona() {
		return txtIdPers_Persona;
	}

	public void setTxtIdPers_Persona(InputText txtIdPers_Persona) {
		this.txtIdPers_Persona = txtIdPers_Persona;
	}

	public InputText getTxtIdTiid_TipoIdentificacion() {
		return txtIdTiid_TipoIdentificacion;
	}

	public void setTxtIdTiid_TipoIdentificacion(
			InputText txtIdTiid_TipoIdentificacion) {
		this.txtIdTiid_TipoIdentificacion = txtIdTiid_TipoIdentificacion;
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

	public InputText getTxtIdEmpr() {
		return txtIdEmpr;
	}

	public void setTxtIdEmpr(InputText txtIdEmpr) {
		this.txtIdEmpr = txtIdEmpr;
	}

	public List<EmpresaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataEmpresa();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<EmpresaDTO> empresaDTO) {
		this.data = empresaDTO;
	}

	public EmpresaDTO getSelectedEmpresa() {
		return selectedEmpresa;
	}

	public void setSelectedEmpresa(EmpresaDTO empresa) {
		this.selectedEmpresa = empresa;
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
