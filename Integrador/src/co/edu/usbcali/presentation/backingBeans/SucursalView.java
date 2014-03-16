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
import co.edu.usbcali.modelo.Sucursal;
import co.edu.usbcali.modelo.dto.SucursalDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class SucursalView {
	private InputText txtCodigo;
	private InputText txtDireccion;
	private InputText txtEmail;
	private InputText txtEstadoRegistro;
	private InputText txtEstadoSucursal;
	private InputText txtNombre;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtTelefono;
	private InputText txtZipCode;
	private InputText txtIdDipo_DivisionPolitica;
	private InputText txtIdEmpr_Empresa;
	private InputText txtIdPers_Persona;
	private InputText txtIdRege_RegionalGeografica;
	private InputText txtIdSucu_Sucursal;
	private InputText txtIdTisu_TipoSucursal;
	private InputText txtIdSucu;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<SucursalDTO> data;
	private SucursalDTO selectedSucursal;
	private Sucursal entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public SucursalView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			SucursalDTO sucursalDTO = (SucursalDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(sucursalDTO.getCodigo());

			if (txtDireccion == null) {
				txtDireccion = new InputText();
			}

			txtDireccion.setValue(sucursalDTO.getDireccion());

			if (txtEmail == null) {
				txtEmail = new InputText();
			}

			txtEmail.setValue(sucursalDTO.getEmail());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(sucursalDTO.getEstadoRegistro());

			if (txtEstadoSucursal == null) {
				txtEstadoSucursal = new InputText();
			}

			txtEstadoSucursal.setValue(sucursalDTO.getEstadoSucursal());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(sucursalDTO.getNombre());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(sucursalDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(sucursalDTO.getOperModifica());

			if (txtTelefono == null) {
				txtTelefono = new InputText();
			}

			txtTelefono.setValue(sucursalDTO.getTelefono());

			if (txtZipCode == null) {
				txtZipCode = new InputText();
			}

			txtZipCode.setValue(sucursalDTO.getZipCode());

			if (txtIdDipo_DivisionPolitica == null) {
				txtIdDipo_DivisionPolitica = new InputText();
			}

			txtIdDipo_DivisionPolitica.setValue(sucursalDTO
					.getIdDipo_DivisionPolitica());

			if (txtIdEmpr_Empresa == null) {
				txtIdEmpr_Empresa = new InputText();
			}

			txtIdEmpr_Empresa.setValue(sucursalDTO.getIdEmpr_Empresa());

			if (txtIdPers_Persona == null) {
				txtIdPers_Persona = new InputText();
			}

			txtIdPers_Persona.setValue(sucursalDTO.getIdPers_Persona());

			if (txtIdRege_RegionalGeografica == null) {
				txtIdRege_RegionalGeografica = new InputText();
			}

			txtIdRege_RegionalGeografica.setValue(sucursalDTO
					.getIdRege_RegionalGeografica());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new InputText();
			}

			txtIdSucu_Sucursal.setValue(sucursalDTO.getIdSucu_Sucursal());

			if (txtIdTisu_TipoSucursal == null) {
				txtIdTisu_TipoSucursal = new InputText();
			}

			txtIdTisu_TipoSucursal.setValue(sucursalDTO
					.getIdTisu_TipoSucursal());

			if (txtIdSucu == null) {
				txtIdSucu = new InputText();
			}

			txtIdSucu.setValue(sucursalDTO.getIdSucu());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(sucursalDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(sucursalDTO.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedSucursal = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedSucursal = null;

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(true);
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

		if (txtEstadoSucursal != null) {
			txtEstadoSucursal.setValue(null);
			txtEstadoSucursal.setDisabled(true);
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

		if (txtTelefono != null) {
			txtTelefono.setValue(null);
			txtTelefono.setDisabled(true);
		}

		if (txtZipCode != null) {
			txtZipCode.setValue(null);
			txtZipCode.setDisabled(true);
		}

		if (txtIdDipo_DivisionPolitica != null) {
			txtIdDipo_DivisionPolitica.setValue(null);
			txtIdDipo_DivisionPolitica.setDisabled(true);
		}

		if (txtIdEmpr_Empresa != null) {
			txtIdEmpr_Empresa.setValue(null);
			txtIdEmpr_Empresa.setDisabled(true);
		}

		if (txtIdPers_Persona != null) {
			txtIdPers_Persona.setValue(null);
			txtIdPers_Persona.setDisabled(true);
		}

		if (txtIdRege_RegionalGeografica != null) {
			txtIdRege_RegionalGeografica.setValue(null);
			txtIdRege_RegionalGeografica.setDisabled(true);
		}

		if (txtIdSucu_Sucursal != null) {
			txtIdSucu_Sucursal.setValue(null);
			txtIdSucu_Sucursal.setDisabled(true);
		}

		if (txtIdTisu_TipoSucursal != null) {
			txtIdTisu_TipoSucursal.setValue(null);
			txtIdTisu_TipoSucursal.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdSucu != null) {
			txtIdSucu.setValue(null);
			txtIdSucu.setDisabled(false);
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
			Long idSucu = new Long(txtIdSucu.getValue().toString());
			entity = businessDelegatorView.getSucursal(idSucu);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtDireccion.setDisabled(false);
			txtEmail.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtEstadoSucursal.setDisabled(false);
			txtNombre.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtTelefono.setDisabled(false);
			txtZipCode.setDisabled(false);
			txtIdDipo_DivisionPolitica.setDisabled(false);
			txtIdEmpr_Empresa.setDisabled(false);
			txtIdPers_Persona.setDisabled(false);
			txtIdRege_RegionalGeografica.setDisabled(false);
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdTisu_TipoSucursal.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdSucu.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtDireccion.setValue(entity.getDireccion());
			txtDireccion.setDisabled(false);
			txtEmail.setValue(entity.getEmail());
			txtEmail.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtEstadoSucursal.setValue(entity.getEstadoSucursal());
			txtEstadoSucursal.setDisabled(false);
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
			txtTelefono.setValue(entity.getTelefono());
			txtTelefono.setDisabled(false);
			txtZipCode.setValue(entity.getZipCode());
			txtZipCode.setDisabled(false);
			txtIdDipo_DivisionPolitica.setValue(entity.getDivisionPolitica()
					.getIdDipo());
			txtIdDipo_DivisionPolitica.setDisabled(false);
			txtIdEmpr_Empresa.setValue(entity.getEmpresa().getIdEmpr());
			txtIdEmpr_Empresa.setDisabled(false);
			txtIdPers_Persona.setValue(entity.getPersona().getIdPers());
			txtIdPers_Persona.setDisabled(false);
			txtIdRege_RegionalGeografica.setValue(entity
					.getRegionalGeografica().getIdRege());
			txtIdRege_RegionalGeografica.setDisabled(false);
			txtIdSucu_Sucursal.setValue(entity.getSucursal().getIdSucu());
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdTisu_TipoSucursal.setValue(entity.getTipoSucursal()
					.getIdTisu());
			txtIdTisu_TipoSucursal.setDisabled(false);
			txtIdSucu.setValue(entity.getIdSucu());
			txtIdSucu.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedSucursal = (SucursalDTO) (evt.getComponent().getAttributes()
				.get("selectedSucursal"));
		txtCodigo.setValue(selectedSucursal.getCodigo());
		txtCodigo.setDisabled(false);
		txtDireccion.setValue(selectedSucursal.getDireccion());
		txtDireccion.setDisabled(false);
		txtEmail.setValue(selectedSucursal.getEmail());
		txtEmail.setDisabled(false);
		txtEstadoRegistro.setValue(selectedSucursal.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtEstadoSucursal.setValue(selectedSucursal.getEstadoSucursal());
		txtEstadoSucursal.setDisabled(false);
		txtFechaCreacion.setValue(selectedSucursal.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedSucursal.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtNombre.setValue(selectedSucursal.getNombre());
		txtNombre.setDisabled(false);
		txtOperCreador.setValue(selectedSucursal.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedSucursal.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtTelefono.setValue(selectedSucursal.getTelefono());
		txtTelefono.setDisabled(false);
		txtZipCode.setValue(selectedSucursal.getZipCode());
		txtZipCode.setDisabled(false);
		txtIdDipo_DivisionPolitica.setValue(selectedSucursal
				.getIdDipo_DivisionPolitica());
		txtIdDipo_DivisionPolitica.setDisabled(false);
		txtIdEmpr_Empresa.setValue(selectedSucursal.getIdEmpr_Empresa());
		txtIdEmpr_Empresa.setDisabled(false);
		txtIdPers_Persona.setValue(selectedSucursal.getIdPers_Persona());
		txtIdPers_Persona.setDisabled(false);
		txtIdRege_RegionalGeografica.setValue(selectedSucursal
				.getIdRege_RegionalGeografica());
		txtIdRege_RegionalGeografica.setDisabled(false);
		txtIdSucu_Sucursal.setValue(selectedSucursal.getIdSucu_Sucursal());
		txtIdSucu_Sucursal.setDisabled(false);
		txtIdTisu_TipoSucursal.setValue(selectedSucursal
				.getIdTisu_TipoSucursal());
		txtIdTisu_TipoSucursal.setDisabled(false);
		txtIdSucu.setValue(selectedSucursal.getIdSucu());
		txtIdSucu.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedSucursal == null) && (entity == null)) {
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
			entity = new Sucursal();

			Long idSucu = new Long(txtIdSucu.getValue().toString());

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			entity.setEmail(FacesUtils.checkString(txtEmail));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setEstadoSucursal(FacesUtils.checkString(txtEstadoSucursal));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdSucu(idSucu);
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setTelefono(FacesUtils.checkString(txtTelefono));
			entity.setZipCode(FacesUtils.checkString(txtZipCode));
			entity.setDivisionPolitica(businessDelegatorView
					.getDivisionPolitica(FacesUtils
							.checkLong(txtIdDipo_DivisionPolitica)));
			entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
					.checkLong(txtIdEmpr_Empresa)));
			entity.setPersona(businessDelegatorView.getPersona(FacesUtils
					.checkLong(txtIdPers_Persona)));
			entity.setRegionalGeografica(businessDelegatorView
					.getRegionalGeografica(FacesUtils
							.checkLong(txtIdRege_RegionalGeografica)));
			entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			entity.setTipoSucursal(businessDelegatorView
					.getTipoSucursal(FacesUtils
							.checkLong(txtIdTisu_TipoSucursal)));
			businessDelegatorView.saveSucursal(entity);
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
				Long idSucu = new Long(selectedSucursal.getIdSucu());
				entity = businessDelegatorView.getSucursal(idSucu);
			}

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			entity.setEmail(FacesUtils.checkString(txtEmail));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setEstadoSucursal(FacesUtils.checkString(txtEstadoSucursal));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setTelefono(FacesUtils.checkString(txtTelefono));
			entity.setZipCode(FacesUtils.checkString(txtZipCode));
			entity.setDivisionPolitica(businessDelegatorView
					.getDivisionPolitica(FacesUtils
							.checkLong(txtIdDipo_DivisionPolitica)));
			entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
					.checkLong(txtIdEmpr_Empresa)));
			entity.setPersona(businessDelegatorView.getPersona(FacesUtils
					.checkLong(txtIdPers_Persona)));
			entity.setRegionalGeografica(businessDelegatorView
					.getRegionalGeografica(FacesUtils
							.checkLong(txtIdRege_RegionalGeografica)));
			entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			entity.setTipoSucursal(businessDelegatorView
					.getTipoSucursal(FacesUtils
							.checkLong(txtIdTisu_TipoSucursal)));
			businessDelegatorView.updateSucursal(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedSucursal = (SucursalDTO) (evt.getComponent()
					.getAttributes().get("selectedSucursal"));

			Long idSucu = new Long(selectedSucursal.getIdSucu());
			entity = businessDelegatorView.getSucursal(idSucu);
			businessDelegatorView.deleteSucursal(entity);
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
			selectedSucursal = (SucursalDTO) (evt.getComponent()
					.getAttributes().get("selectedSucursal"));

			Long idSucu = new Long(selectedSucursal.getIdSucu());
			entity = businessDelegatorView.getSucursal(idSucu);
			businessDelegatorView.deleteSucursal(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedSucursal);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, String direccion,
			String email, String estadoRegistro, String estadoSucursal,
			Date fechaCreacion, Date fechaModificacion, Long idSucu,
			String nombre, String operCreador, String operModifica,
			String telefono, String zipCode, Long idDipo_DivisionPolitica,
			Long idEmpr_Empresa, Long idPers_Persona,
			Long idRege_RegionalGeografica, Long idSucu_Sucursal,
			Long idTisu_TipoSucursal) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setDireccion(FacesUtils.checkString(direccion));
			entity.setEmail(FacesUtils.checkString(email));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setEstadoSucursal(FacesUtils.checkString(estadoSucursal));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setTelefono(FacesUtils.checkString(telefono));
			entity.setZipCode(FacesUtils.checkString(zipCode));
			businessDelegatorView.updateSucursal(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("SucursalView").requestRender();
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

	public InputText getTxtEstadoSucursal() {
		return txtEstadoSucursal;
	}

	public void setTxtEstadoSucursal(InputText txtEstadoSucursal) {
		this.txtEstadoSucursal = txtEstadoSucursal;
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

	public InputText getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(InputText txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public InputText getTxtZipCode() {
		return txtZipCode;
	}

	public void setTxtZipCode(InputText txtZipCode) {
		this.txtZipCode = txtZipCode;
	}

	public InputText getTxtIdDipo_DivisionPolitica() {
		return txtIdDipo_DivisionPolitica;
	}

	public void setTxtIdDipo_DivisionPolitica(
			InputText txtIdDipo_DivisionPolitica) {
		this.txtIdDipo_DivisionPolitica = txtIdDipo_DivisionPolitica;
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

	public InputText getTxtIdRege_RegionalGeografica() {
		return txtIdRege_RegionalGeografica;
	}

	public void setTxtIdRege_RegionalGeografica(
			InputText txtIdRege_RegionalGeografica) {
		this.txtIdRege_RegionalGeografica = txtIdRege_RegionalGeografica;
	}

	public InputText getTxtIdSucu_Sucursal() {
		return txtIdSucu_Sucursal;
	}

	public void setTxtIdSucu_Sucursal(InputText txtIdSucu_Sucursal) {
		this.txtIdSucu_Sucursal = txtIdSucu_Sucursal;
	}

	public InputText getTxtIdTisu_TipoSucursal() {
		return txtIdTisu_TipoSucursal;
	}

	public void setTxtIdTisu_TipoSucursal(InputText txtIdTisu_TipoSucursal) {
		this.txtIdTisu_TipoSucursal = txtIdTisu_TipoSucursal;
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

	public InputText getTxtIdSucu() {
		return txtIdSucu;
	}

	public void setTxtIdSucu(InputText txtIdSucu) {
		this.txtIdSucu = txtIdSucu;
	}

	public List<SucursalDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataSucursal();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<SucursalDTO> sucursalDTO) {
		this.data = sucursalDTO;
	}

	public SucursalDTO getSelectedSucursal() {
		return selectedSucursal;
	}

	public void setSelectedSucursal(SucursalDTO sucursal) {
		this.selectedSucursal = sucursal;
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
