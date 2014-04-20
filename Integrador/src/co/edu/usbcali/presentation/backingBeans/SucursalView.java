package co.edu.usbcali.presentation.backingBeans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.Sucursal;
import co.edu.usbcali.modelo.dto.DivisionPoliticaDTO;
import co.edu.usbcali.modelo.dto.EmpresaDTO;
import co.edu.usbcali.modelo.dto.PersonaDTO;
import co.edu.usbcali.modelo.dto.RegionalGeograficaDTO;
import co.edu.usbcali.modelo.dto.SucursalDTO;
import co.edu.usbcali.modelo.dto.TipoSucursalDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class SucursalView {
	private InputText txtCodigo;
	private InputText txtDireccion;
	private InputText txtEmail;
	private SelectOneMenu estado;
	private SelectOneMenu txtEstadoSucursal;
	private InputText txtNombre;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtTelefono;
	private InputText txtZipCode;
	private SelectOneMenu txtIdDipo_DivisionPolitica;
	private SelectOneMenu txtIdEmpr_Empresa;
	private SelectOneMenu txtIdPers_Persona;
	private SelectOneMenu txtIdRege_RegionalGeografica;
	private SelectOneMenu txtIdSucu_Sucursal;
	private SelectOneMenu txtIdTisu_TipoSucursal;
	private InputText txtIdSucu;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;

	private String codigo;
	private String direccion;
	private String email;
	private String estadoRegistro;
	private String estadoSucursal;
	private String nombre;
	private String operCreador;
	private String operModifica;
	private String telefono;
	private String zipCode;
	private Long idDipo_DivisionPolitica;
	private Long idEmpr_Empresa;
	private Long idPers_Persona;
	private Long idRege_RegionalGeografica;
	private Long idSucu_Sucursal;
	private Long idTisu_TipoSucursal;
	private String idSucu;
	private String fechaCreacion;
	private String fechaModificacion;

	private Map<String, String> divisionPolitica = new HashMap<String, String>();
	private Map<String, String> empresa = new HashMap<String, String>();
	private Map<String, String> persona = new HashMap<String, String>();
	private Map<String, String> regionalGeografica = new HashMap<String, String>();
	private Map<String, String> sucursal = new HashMap<String, String>();
	private Map<String, String> tipoSucursal = new HashMap<String, String>();

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

	private SelectItem[] manufacturerOptions;
	private SelectItem[] manufacturerOptions2;

	String manufacturers[] = { "A", "R" };
	String manufacturers2[] = { "S", "N" };

	public SucursalView() {
		super();
		setManufacturerOptions(createFilterOptions(manufacturers));
		setManufacturerOptions2(createFilterOptions(manufacturers2));
	}

	private SelectItem[] createFilterOptions(String[] data) {
		SelectItem[] options = new SelectItem[data.length + 1];

		options[0] = new SelectItem("", "Seleccionar");
		for (int i = 0; i < data.length; i++) {
			options[i + 1] = new SelectItem(data[i], data[i]);
		}

		return options;
	}

	public void onEdit(org.primefaces.event.RowEditEvent event) {
		try {

			entity = null;
			entity = businessDelegatorView.getSucursal(((SucursalDTO) event
					.getObject()).getIdSucu());

			entity.setFechaModificacion(new Date());
			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);
			entity.setEstadoRegistro(estadoRegistro);
			entity.setEstadoSucursal(estadoSucursal);

			entity.setCodigo(((SucursalDTO) event.getObject()).getCodigo());
			entity.setDireccion(((SucursalDTO) event.getObject())
					.getDireccion());
			entity.setEmail(((SucursalDTO) event.getObject()).getEmail());
			entity.setNombre(((SucursalDTO) event.getObject()).getNombre());
			entity.setTelefono(((SucursalDTO) event.getObject()).getTelefono());
			entity.setZipCode(((SucursalDTO) event.getObject()).getZipCode());

			entity.setDivisionPolitica(businessDelegatorView
					.getDivisionPolitica(getIdDipo_DivisionPolitica()));
			entity.setEmpresa(businessDelegatorView
					.getEmpresa(getIdEmpr_Empresa()));
			entity.setPersona(businessDelegatorView
					.getPersona(getIdPers_Persona()));
			entity.setRegionalGeografica(businessDelegatorView
					.getRegionalGeografica(getIdRege_RegionalGeografica()));
			entity.setSucursal(businessDelegatorView
					.getSucursal(getIdSucu_Sucursal()));
			entity.setTipoSucursal(businessDelegatorView
					.getTipoSucursal(getIdTisu_TipoSucursal()));

			businessDelegatorView.updateSucursal(entity);
			data = businessDelegatorView.getDataSucursal();
			RequestContext.getCurrentInstance().update("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Cancelled",
				((SucursalDTO) event.getObject()).getIdSucu() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((SucursalDTO) event.getObject()).getIdSucu());
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
				txtIdDipo_DivisionPolitica = new SelectOneMenu();
			}

			txtIdDipo_DivisionPolitica.setValue(sucursalDTO
					.getIdDipo_DivisionPolitica());

			if (txtIdEmpr_Empresa == null) {
				txtIdEmpr_Empresa = new SelectOneMenu();
			}

			txtIdEmpr_Empresa.setValue(sucursalDTO.getIdEmpr_Empresa());

			if (txtIdPers_Persona == null) {
				txtIdPers_Persona = new SelectOneMenu();
			}

			txtIdPers_Persona.setValue(sucursalDTO.getIdPers_Persona());

			if (txtIdRege_RegionalGeografica == null) {
				txtIdRege_RegionalGeografica = new SelectOneMenu();
			}

			txtIdRege_RegionalGeografica.setValue(sucursalDTO
					.getIdRege_RegionalGeografica());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new SelectOneMenu();
			}

			txtIdSucu_Sucursal.setValue(sucursalDTO.getIdSucu_Sucursal());

			if (txtIdTisu_TipoSucursal == null) {
				txtIdTisu_TipoSucursal = new SelectOneMenu();
			}

			txtIdTisu_TipoSucursal.setValue(sucursalDTO
					.getIdTisu_TipoSucursal());

			if (txtIdSucu == null) {
				txtIdSucu = new InputText();
			}

			txtIdSucu.setValue(sucursalDTO.getIdSucu());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(sucursalDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
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
			// txtCodigo.setDisabled(true);
		}

		if (txtDireccion != null) {
			txtDireccion.setValue(null);
			// txtDireccion.setDisabled(true);
		}

		if (txtEmail != null) {
			txtEmail.setValue(null);
			// txtEmail.setDisabled(true);
		}

		if (txtEstadoSucursal != null) {
			txtEstadoSucursal.setValue(null);
			// txtEstadoSucursal.setDisabled(true);
		}

		if (txtNombre != null) {
			txtNombre.setValue(null);
			// txtNombre.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			// txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			// txtOperModifica.setDisabled(true);
		}

		if (txtTelefono != null) {
			txtTelefono.setValue(null);
			// txtTelefono.setDisabled(true);
		}

		if (txtZipCode != null) {
			txtZipCode.setValue(null);
			// txtZipCode.setDisabled(true);
		}

		if (txtIdDipo_DivisionPolitica != null) {
			txtIdDipo_DivisionPolitica.setValue(null);
			// txtIdDipo_DivisionPolitica.setDisabled(true);
		}

		if (txtIdEmpr_Empresa != null) {
			txtIdEmpr_Empresa.setValue(null);
			// txtIdEmpr_Empresa.setDisabled(true);
		}

		if (txtIdPers_Persona != null) {
			txtIdPers_Persona.setValue(null);
			// txtIdPers_Persona.setDisabled(true);
		}

		if (txtIdRege_RegionalGeografica != null) {
			txtIdRege_RegionalGeografica.setValue(null);
			// txtIdRege_RegionalGeografica.setDisabled(true);
		}

		if (txtIdSucu_Sucursal != null) {
			txtIdSucu_Sucursal.setValue(null);
			// txtIdSucu_Sucursal.setDisabled(true);
		}

		if (txtIdTisu_TipoSucursal != null) {
			txtIdTisu_TipoSucursal.setValue(null);
			// txtIdTisu_TipoSucursal.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			// txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			// txtFechaModificacion.setDisabled(true);
		}

		if (txtIdSucu != null) {
			txtIdSucu.setValue(null);
			// txtIdSucu.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
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

		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtDireccion.setDisabled(false);
			txtEmail.setDisabled(false);
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

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			entity.setEstadoRegistro(estadoRegistro);
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			entity.setEstadoSucursal(estadoSucursal);

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			entity.setEmail(FacesUtils.checkString(txtEmail));
			entity.setNombre(FacesUtils.checkString(txtNombre));
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
			data = businessDelegatorView.getDataSucursal();
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

	public SelectOneMenu getTxtEstadoSucursal() {
		return txtEstadoSucursal;
	}

	public void setTxtEstadoSucursal(SelectOneMenu txtEstadoSucursal) {
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

	public SelectOneMenu getTxtIdDipo_DivisionPolitica() {
		return txtIdDipo_DivisionPolitica;
	}

	public void setTxtIdDipo_DivisionPolitica(
			SelectOneMenu txtIdDipo_DivisionPolitica) {
		this.txtIdDipo_DivisionPolitica = txtIdDipo_DivisionPolitica;
	}

	public SelectOneMenu getTxtIdEmpr_Empresa() {
		return txtIdEmpr_Empresa;
	}

	public void setTxtIdEmpr_Empresa(SelectOneMenu txtIdEmpr_Empresa) {
		this.txtIdEmpr_Empresa = txtIdEmpr_Empresa;
	}

	public SelectOneMenu getTxtIdPers_Persona() {
		return txtIdPers_Persona;
	}

	public void setTxtIdPers_Persona(SelectOneMenu txtIdPers_Persona) {
		this.txtIdPers_Persona = txtIdPers_Persona;
	}

	public SelectOneMenu getTxtIdRege_RegionalGeografica() {
		return txtIdRege_RegionalGeografica;
	}

	public void setTxtIdRege_RegionalGeografica(
			SelectOneMenu txtIdRege_RegionalGeografica) {
		this.txtIdRege_RegionalGeografica = txtIdRege_RegionalGeografica;
	}

	public SelectOneMenu getTxtIdSucu_Sucursal() {
		return txtIdSucu_Sucursal;
	}

	public void setTxtIdSucu_Sucursal(SelectOneMenu txtIdSucu_Sucursal) {
		this.txtIdSucu_Sucursal = txtIdSucu_Sucursal;
	}

	public SelectOneMenu getTxtIdTisu_TipoSucursal() {
		return txtIdTisu_TipoSucursal;
	}

	public void setTxtIdTisu_TipoSucursal(SelectOneMenu txtIdTisu_TipoSucursal) {
		this.txtIdTisu_TipoSucursal = txtIdTisu_TipoSucursal;
	}

	public InputText getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(InputText txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public InputText getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(InputText txtFechaModificacion) {
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

	public SelectOneMenu getEstado() {
		return estado;
	}

	public void setEstado(SelectOneMenu estado) {
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getEstadoSucursal() {
		return estadoSucursal;
	}

	public void setEstadoSucursal(String estadoSucursal) {
		this.estadoSucursal = estadoSucursal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOperCreador() {
		return operCreador;
	}

	public void setOperCreador(String operCreador) {
		this.operCreador = operCreador;
	}

	public String getOperModifica() {
		return operModifica;
	}

	public void setOperModifica(String operModifica) {
		this.operModifica = operModifica;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Long getIdDipo_DivisionPolitica() {
		return idDipo_DivisionPolitica;
	}

	public void setIdDipo_DivisionPolitica(Long idDipo_DivisionPolitica) {
		this.idDipo_DivisionPolitica = idDipo_DivisionPolitica;
	}

	public Long getIdEmpr_Empresa() {
		return idEmpr_Empresa;
	}

	public void setIdEmpr_Empresa(Long idEmpr_Empresa) {
		this.idEmpr_Empresa = idEmpr_Empresa;
	}

	public Long getIdPers_Persona() {
		return idPers_Persona;
	}

	public void setIdPers_Persona(Long idPers_Persona) {
		this.idPers_Persona = idPers_Persona;
	}

	public Long getIdRege_RegionalGeografica() {
		return idRege_RegionalGeografica;
	}

	public void setIdRege_RegionalGeografica(Long idRege_RegionalGeografica) {
		this.idRege_RegionalGeografica = idRege_RegionalGeografica;
	}

	public Long getIdSucu_Sucursal() {
		return idSucu_Sucursal;
	}

	public void setIdSucu_Sucursal(Long idSucu_Sucursal) {
		this.idSucu_Sucursal = idSucu_Sucursal;
	}

	public Long getIdTisu_TipoSucursal() {
		return idTisu_TipoSucursal;
	}

	public void setIdTisu_TipoSucursal(Long idTisu_TipoSucursal) {
		this.idTisu_TipoSucursal = idTisu_TipoSucursal;
	}

	public String getIdSucu() {
		return idSucu;
	}

	public void setIdSucu(String idSucu) {
		this.idSucu = idSucu;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Map<String, String> getDivisionPolitica() {
		try {
			List<DivisionPoliticaDTO> data1 = businessDelegatorView
					.getDataDivisionPolitica();

			for (int i = 0; i < data1.size(); i++) {
				divisionPolitica.put(data1.get(i).getNombre(), data1.get(i)
						.getIdDipo() + "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return divisionPolitica;
	}

	public void setDivisionPolitica(Map<String, String> divisionPolitica) {
		this.divisionPolitica = divisionPolitica;
	}

	public Map<String, String> getEmpresa() {
		try {
			List<EmpresaDTO> data2 = businessDelegatorView.getDataEmpresa();

			for (int i = 0; i < data2.size(); i++) {
				empresa.put(data2.get(i).getNombre(), data2.get(i).getIdEmpr()
						+ "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empresa;
	}

	public void setEmpresa(Map<String, String> empresa) {
		this.empresa = empresa;
	}

	public Map<String, String> getPersona() {
		try {
			List<PersonaDTO> data3 = businessDelegatorView.getDataPersona();

			for (int i = 0; i < data3.size(); i++) {
				persona.put(data3.get(i).getPrimerNombre(), data3.get(i)
						.getIdPers() + "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return persona;
	}

	public void setPersona(Map<String, String> persona) {
		this.persona = persona;
	}

	public Map<String, String> getRegionalGeografica() {
		try {
			List<RegionalGeograficaDTO> data4 = businessDelegatorView
					.getDataRegionalGeografica();

			for (int i = 0; i < data4.size(); i++) {
				regionalGeografica.put(data4.get(i).getDescripcion(), data4
						.get(i).getIdRege() + "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return regionalGeografica;
	}

	public void setRegionalGeografica(Map<String, String> regionalGeografica) {
		this.regionalGeografica = regionalGeografica;
	}

	public Map<String, String> getSucursal() {
		try {
			List<SucursalDTO> data5 = businessDelegatorView.getDataSucursal();

			for (int i = 0; i < data5.size(); i++) {
				sucursal.put(data5.get(i).getNombre(), data5.get(i).getIdSucu()
						+ "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sucursal;
	}

	public void setSucursal(Map<String, String> sucursal) {
		this.sucursal = sucursal;
	}

	public Map<String, String> getTipoSucursal() {
		try {
			List<TipoSucursalDTO> data6 = businessDelegatorView
					.getDataTipoSucursal();

			for (int i = 0; i < data6.size(); i++) {
				tipoSucursal.put(data6.get(i).getDescripcion(), data6.get(i)
						.getIdTisu() + "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipoSucursal;
	}

	public void setTipoSucursal(Map<String, String> tipoSucursal) {
		this.tipoSucursal = tipoSucursal;
	}

	public SelectItem[] getManufacturerOptions() {
		return manufacturerOptions;
	}

	public void setManufacturerOptions(SelectItem[] manufacturerOptions) {
		this.manufacturerOptions = manufacturerOptions;
	}

	public SelectItem[] getManufacturerOptions2() {
		return manufacturerOptions2;
	}

	public void setManufacturerOptions2(SelectItem[] manufacturerOptions2) {
		this.manufacturerOptions2 = manufacturerOptions2;
	}

	public String[] getManufacturers() {
		return manufacturers;
	}

	public void setManufacturers(String[] manufacturers) {
		this.manufacturers = manufacturers;
	}

	public String[] getManufacturers2() {
		return manufacturers2;
	}

	public void setManufacturers2(String[] manufacturers2) {
		this.manufacturers2 = manufacturers2;
	}
}
