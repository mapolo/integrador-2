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
import co.edu.usbcali.modelo.Cliente;
import co.edu.usbcali.modelo.Compania;
import co.edu.usbcali.modelo.DivisionPolitica;
import co.edu.usbcali.modelo.Empresa;
import co.edu.usbcali.modelo.dto.ClienteDTO;
import co.edu.usbcali.modelo.dto.CompaniaDTO;
import co.edu.usbcali.modelo.dto.DivisionPoliticaDTO;
import co.edu.usbcali.modelo.dto.EmpresaDTO;
import co.edu.usbcali.modelo.dto.PersonaDTO;
import co.edu.usbcali.modelo.dto.TipoCarteraDTO;
import co.edu.usbcali.modelo.dto.TipoIdentificacionDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class EmpresaView {
	private InputText txtApartadoAereo;
	private InputText txtDireccion;
	private InputText txtEmail;
	private SelectOneMenu estado;
	private InputText txtFax;
	private InputText txtIdentificacion;
	private InputText txtNombre;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtTelefono1;
	private InputText txtTelefono2;
	private SelectOneMenu txtIdDipo_DivisionPolitica;
	private SelectOneMenu txtIdPers_Persona;
	private SelectOneMenu txtIdTiid_TipoIdentificacion;
	private InputText txtIdEmpr;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;

	private String apartadoAereo;
	private String direccion;
	private String email;
	private String estadoRegistro;
	private String fax;
	private String identificacion;
	private String nombre;
	private String operCreador;
	private String operModifica;
	private String telefono1;
	private String telefono2;
	private String idDipo_DivisionPolitica;
	private Long idPers_Persona;
	private String idTiid_TipoIdentificacion;
	private String selectItemEstado;
	private String idEmpr;
	private String fechaCreacion;
	private String fechaModificacion;

	private Map<String, String> division = new HashMap<String, String>();
	private Map<String, String> persona = new HashMap<String, String>();
	private Map<String, String> tipoIdentificacion = new HashMap<String, String>();

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnModify2;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<EmpresaDTO> data;
	private EmpresaDTO selectedEmpresa;
	private Empresa entity;

	private String selectItemCompania;
	private SelectOneMenu txtCompania;

	private String selectItemECompania;
	private SelectOneMenu txtECompania;

	private String selectItemEstadoC;
	private SelectOneMenu txtEstadoC;

	private String selectItemCliente;
	private SelectOneMenu txtCliente;
	private String selectItemECl;
	private String selectItemEstadoCl;

	private SelectOneMenu txtTC;
	private SelectOneMenu txtEstadoCl;

	private InputText txtCodigo;

	private Map<String, Long> tipoCartera = new HashMap<String, Long>();

	private PersonaDTO selectedPersona;
	private PersonaDataModel personaModel;
	private List<PersonaDTO> data2;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private SelectItem[] manufacturerOptions;

	String manufacturers[] = { "A", "R" };

	public EmpresaView() {
		super();
		setManufacturerOptions(createFilterOptions(manufacturers));
	}

	private SelectItem[] createFilterOptions(String[] data) {
		SelectItem[] options = new SelectItem[data.length + 1];

		options[0] = new SelectItem("", "Seleccionar");
		for (int i = 0; i < data.length; i++) {
			options[i + 1] = new SelectItem(data[i], data[i]);
		}

		return options;
	}

	public String selectRL() {
		selectedPersona = null;

		return "";
	}

	public String action_quitar() {
		selectedPersona = null;

		return "";
	}

	public void onEdit(org.primefaces.event.RowEditEvent event) {

		try {

			entity = null;
			entity = businessDelegatorView.getEmpresa(((EmpresaDTO) event
					.getObject()).getIdEmpr());

			entity.setEstadoRegistro(estadoRegistro);
			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);
			entity.setFechaModificacion(new Date());

			entity.setApartadoAereo(((EmpresaDTO) event.getObject())
					.getApartadoAereo());
			entity.setDireccion(((EmpresaDTO) event.getObject()).getDireccion());
			entity.setEmail(((EmpresaDTO) event.getObject()).getEmail());
			entity.setFax(((EmpresaDTO) event.getObject()).getFax());
			entity.setIdentificacion(((EmpresaDTO) event.getObject())
					.getIdentificacion());
			entity.setNombre(((EmpresaDTO) event.getObject()).getNombre());
			entity.setTelefono1(((EmpresaDTO) event.getObject()).getTelefono1());
			entity.setTelefono2(((EmpresaDTO) event.getObject()).getTelefono2());

			DivisionPolitica entity2 = businessDelegatorView
					.getDivisionPolitica(Long
							.parseLong(idDipo_DivisionPolitica));

			System.out.println("1: " + txtIdDipo_DivisionPolitica.getValue()
					+ " 2: " + entity2);
			if (txtIdDipo_DivisionPolitica.getValue() == "999999") {
				System.out.println("Entro vacio a 0");
				entity.setDivisionPolitica(null);
			} else {
				System.out.println("Entro con algo diferente a 0" + entity2);

				entity.setDivisionPolitica(entity2);

				/*
				 * entity.setDivisionPolitica(businessDelegatorView
				 * .getDivisionPolitica(FacesUtils
				 * .checkLong(txtIdDipo_DivisionPolitica)));
				 */
			}

			entity.setPersona(businessDelegatorView
					.getPersona(getIdPers_Persona()));

			entity.setTipoIdentificacion(businessDelegatorView
					.getTipoIdentificacion(Long
							.parseLong(getIdTiid_TipoIdentificacion())));

			businessDelegatorView.updateEmpresa(entity);
			data = businessDelegatorView.getDataEmpresa();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Cancelled",
				((EmpresaDTO) event.getObject()).getIdEmpr() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((EmpresaDTO) event.getObject()).getIdEmpr());
	}

	public String action_modify2() {
		try {

			btnSave.setDisabled(true);
			btnModify.setDisabled(false);
			List<ClienteDTO> data4 = businessDelegatorView.getDataCliente();
			List<CompaniaDTO> data3 = businessDelegatorView.getDataCompania();
			Long idCompañia = 0L;
			Long idCliente = 0L;
			selectItemCliente = "";
			selectItemCompania = "";

			for (int i = 0; i < data4.size(); i++) {
				if (selectedEmpresa.getIdEmpr() == data4.get(i)
						.getIdEmpr_Empresa()) {
					idCliente = data4.get(i).getIdClie();
					selectItemCliente = "S";
					break;
				}
			}

			for (int i = 0; i < data3.size(); i++) {
				if (selectedEmpresa.getIdEmpr() == data3.get(i)
						.getIdEmpr_Empresa()) {
					selectItemCompania = "S";
					idCompañia = data3.get(i).getIdCia();
					break;
				}
			}

			if (selectItemCliente.equals("S")) {
				selectItemECl = businessDelegatorView.getCliente(idCliente)
						.getTipoCartera().getIdTica()
						+ "";
				selectItemEstadoCl = businessDelegatorView
						.getCliente(idCliente).getEstadoRegistro();

			} else {
				selectItemCliente = "N";
				selectItemECl = "";
				selectItemEstadoCl = "";
			}

			if (selectItemCompania.equals("S")) {
				Compania entity2 = businessDelegatorView
						.getCompania(idCompañia);
				txtCodigo.setValue(entity2.getCodigo());
				selectItemECompania = entity2.getEstadoCompania();
				selectItemEstadoC = entity2.getEstadoRegistro();

			} else {
				selectItemCompania = "N";
				txtCodigo.setValue("");
				selectItemECompania = "";
				selectItemEstadoC = "";
			}

			selectItemEstado = selectedEmpresa.getEstadoRegistro();

			txtNombre.setValue(selectedEmpresa.getNombre());

			txtIdentificacion.setValue(selectedEmpresa.getIdentificacion());

			txtIdDipo_DivisionPolitica.setValue(selectedEmpresa
					.getIdDipo_DivisionPolitica());

			txtIdTiid_TipoIdentificacion.setValue(selectedEmpresa
					.getIdTiid_TipoIdentificacion());

			try {
				txtIdTiid_TipoIdentificacion.setValue(selectedEmpresa
						.getIdTiid_TipoIdentificacion());

			} catch (Exception e) {
				txtIdTiid_TipoIdentificacion.setValue("");
			}

			try {
				txtIdDipo_DivisionPolitica.setValue(selectedEmpresa
						.getIdDipo_DivisionPolitica());

			} catch (Exception e) {
				txtIdDipo_DivisionPolitica.setValue("");
			}

			/*
			 * try {
			 * txtIdPers_Persona.setValue(selectedEmpresa.getIdPers_Persona());
			 * 
			 * } catch (Exception e) { txtIdPers_Persona.setValue(""); }
			 */

			try {
				

					List<PersonaDTO> data7 = businessDelegatorView
							.getDataPersona();					

					for (int i = 0; i < data7.size(); i++) {
						if (data7.get(i).getIdPers() == selectedEmpresa
								.getIdPers_Persona()) {
							setSelectedPersona(data7.get(i));
							
							break;
						}else {
							selectedPersona = null;
							
						}
					}

					
					
				

			} catch (Exception e) {
				System.out.println("entro cacht");
			}

			try {
				txtApartadoAereo.setValue(selectedEmpresa.getApartadoAereo());

			} catch (Exception e) {
				txtApartadoAereo.setValue("");
			}

			try {
				txtDireccion.setValue(selectedEmpresa.getDireccion());

			} catch (Exception e) {
				txtDireccion.setValue("");
			}

			try {
				txtEmail.setValue(selectedEmpresa.getEmail());

			} catch (Exception e) {
				txtEmail.setValue("");
			}

			try {
				txtFax.setValue(selectedEmpresa.getFax());

			} catch (Exception e) {
				txtFax.setValue("");
			}

			try {
				txtIdentificacion.setValue(selectedEmpresa.getIdentificacion());

			} catch (Exception e) {
				txtIdentificacion.setValue("");
			}

			try {
				txtNombre.setValue(selectedEmpresa.getNombre());

			} catch (Exception e) {
				txtNombre.setValue("");
			}

			try {
				txtTelefono1.setValue(selectedEmpresa.getTelefono1());

			} catch (Exception e) {
				txtTelefono1.setValue("");
			}

			try {
				txtTelefono2.setValue(selectedEmpresa.getTelefono2());

			} catch (Exception e) {
				txtTelefono2.setValue("");
			}

			try {
				estado.setValue(selectedEmpresa.getEstadoRegistro());
			} catch (Exception e) {
				estado.setValue("");
			}

			txtIdEmpr.setValue(selectedEmpresa.getIdEmpr());

		} catch (Exception e) {
			if (selectedEmpresa == null) {
				FacesUtils.addErrorMessage("Seleccione la Empresa a Modificar");
			}
		}

		return "";
	}

	public String action_VCrear() {

		btnModify.setDisabled(true);
		btnSave.setDisabled(false);

		txtCompania.setDisabled(false);
		txtCliente.setDisabled(false);

		selectItemCompania = null;
		selectItemECompania = null;
		selectItemEstadoC = null;

		selectItemCliente = null;
		selectItemEstadoCl = null;
		selectItemECl = null;

		txtCodigo.setValue(null);

		try {
			txtIdTiid_TipoIdentificacion.setValue(null);

		} catch (Exception e) {
			txtIdTiid_TipoIdentificacion.setValue("");
		}

		try {
			txtIdDipo_DivisionPolitica.setValue(null);

		} catch (Exception e) {
			txtIdDipo_DivisionPolitica.setValue("");
		}

		/*
		 * try { txtIdPers_Persona.setValue(null);
		 * 
		 * } catch (Exception e) { txtIdPers_Persona.setValue(""); }
		 */

		selectedPersona = null;

		try {
			txtApartadoAereo.setValue(null);

		} catch (Exception e) {
			txtApartadoAereo.setValue("");
		}

		try {
			txtDireccion.setValue(null);

		} catch (Exception e) {
			txtDireccion.setValue("");
		}

		try {
			txtEmail.setValue(null);

		} catch (Exception e) {
			txtEmail.setValue("");
		}

		try {
			txtFax.setValue(null);

		} catch (Exception e) {
			txtFax.setValue("");
		}

		try {
			txtIdentificacion.setValue(null);

		} catch (Exception e) {
			txtIdentificacion.setValue("");
		}

		try {
			txtNombre.setValue(null);

		} catch (Exception e) {
			txtNombre.setValue("");
		}

		try {
			txtTelefono1.setValue(null);

		} catch (Exception e) {
			txtTelefono1.setValue("");
		}

		try {
			txtTelefono2.setValue(null);

		} catch (Exception e) {
			txtTelefono2.setValue("");
		}

		return "";
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
				txtIdDipo_DivisionPolitica = new SelectOneMenu();
			}

			txtIdDipo_DivisionPolitica.setValue(empresaDTO
					.getIdDipo_DivisionPolitica());

			if (txtIdPers_Persona == null) {
				txtIdPers_Persona = new SelectOneMenu();
			}

			txtIdPers_Persona.setValue(empresaDTO.getIdPers_Persona());

			if (txtIdTiid_TipoIdentificacion == null) {
				txtIdTiid_TipoIdentificacion = new SelectOneMenu();
			}

			txtIdTiid_TipoIdentificacion.setValue(empresaDTO
					.getIdTiid_TipoIdentificacion());

			if (txtIdEmpr == null) {
				txtIdEmpr = new InputText();
			}

			txtIdEmpr.setValue(empresaDTO.getIdEmpr());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(empresaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
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
			// txtApartadoAereo.setDisabled(true);
		}

		if (txtDireccion != null) {
			txtDireccion.setValue(null);
			// txtDireccion.setDisabled(true);
		}

		if (txtEmail != null) {
			txtEmail.setValue(null);
			// txtEmail.setDisabled(true);
		}

		if (txtFax != null) {
			txtFax.setValue(null);
			// txtFax.setDisabled(true);
		}

		if (txtIdentificacion != null) {
			txtIdentificacion.setValue(null);
			// txtIdentificacion.setDisabled(true);
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

		if (txtTelefono1 != null) {
			txtTelefono1.setValue(null);
			// txtTelefono1.setDisabled(true);
		}

		if (txtTelefono2 != null) {
			txtTelefono2.setValue(null);
			// txtTelefono2.setDisabled(true);
		}

		if (txtIdDipo_DivisionPolitica != null) {
			txtIdDipo_DivisionPolitica.setValue(null);
			// txtIdDipo_DivisionPolitica.setDisabled(true);
		}

		if (txtIdPers_Persona != null) {
			txtIdPers_Persona.setValue(null);
			// txtIdPers_Persona.setDisabled(true);
		}

		if (txtIdTiid_TipoIdentificacion != null) {
			txtIdTiid_TipoIdentificacion.setValue(null);
			// txtIdTiid_TipoIdentificacion.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			// txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			// txtFechaModificacion.setDisabled(true);
		}

		if (txtIdEmpr != null) {
			txtIdEmpr.setValue(null);
			// txtIdEmpr.setDisabled(false);
		}

		if (txtCodigo != null) {
			txtCodigo.setValue(null);

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
			Long idEmpr = new Long(txtIdEmpr.getValue().toString());
			entity = businessDelegatorView.getEmpresa(idEmpr);
		} catch (Exception e) {

		}

		if (entity == null) {
			txtApartadoAereo.setDisabled(false);
			txtDireccion.setDisabled(false);
			txtEmail.setDisabled(false);
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

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			entity.setEstadoRegistro(estadoRegistro);
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);

			entity.setApartadoAereo(FacesUtils.checkString(txtApartadoAereo));
			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			entity.setEmail(FacesUtils.checkString(txtEmail));
			entity.setFax(FacesUtils.checkString(txtFax));
			entity.setIdentificacion(FacesUtils.checkLong(txtIdentificacion));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setTelefono1(FacesUtils.checkString(txtTelefono1));
			entity.setTelefono2(FacesUtils.checkString(txtTelefono2));

			if (txtIdDipo_DivisionPolitica.getValue() == "") {

			} else {
				entity.setDivisionPolitica(businessDelegatorView
						.getDivisionPolitica(FacesUtils
								.checkLong(txtIdDipo_DivisionPolitica)));
			}

			/*
			 * entity.setDivisionPolitica(businessDelegatorView
			 * .getDivisionPolitica(FacesUtils
			 * .checkLong(txtIdDipo_DivisionPolitica)));
			 */

			/*
			 * entity.setPersona(businessDelegatorView.getPersona(FacesUtils
			 * .checkLong(txtIdPers_Persona)));
			 */

			/*
			 * if(selectedPersona==null){ entity.setPersona(null); }else{
			 * entity.
			 * setPersona(businessDelegatorView.getPersona(selectedPersona
			 * .getIdPers())); }
			 */

			if (selectedPersona != null) {
				entity.setPersona(businessDelegatorView
						.getPersona(selectedPersona.getIdPers()));
			} else {

				System.out.println("entro null");
				entity.setPersona(null);
			}

			entity.setTipoIdentificacion(businessDelegatorView
					.getTipoIdentificacion(FacesUtils
							.checkLong(txtIdTiid_TipoIdentificacion)));

			businessDelegatorView.saveEmpresa(entity);
			
			if (selectItemCompania.equals("S") && selectItemCliente.equals("S")) {
				FacesUtils.addErrorMessage("Una empresa puede ser Compañia o Cliente, pero no las dos.");
				
				return "";
			}

			if (selectItemCompania.equals("S")) {
				System.out.println("entro es compañia");

				Compania entity2 = new Compania();
				entity2.setCodigo((String) txtCodigo.getValue());
				entity2.setEstadoCompania(selectItemECompania);
				entity2.setEstadoRegistro(selectItemEstadoC);
				entity2.setFechaCreacion(new Date());
				entity2.setFechaModificacion(new Date());
				entity2.setOperCreador(usuario);
				entity2.setOperModifica(usuario);
				entity2.setEmpresa(entity);

				businessDelegatorView.saveCompania(entity2);
			}

			if (selectItemCliente.equals("S")) {
				System.out.println("entro es cliente");

				Cliente entity3 = new Cliente();

				entity3.setEstadoRegistro(selectItemEstadoCl);
				// System.out.println("estado registro " + selectItemEstadoCl);

				entity3.setTipoCartera(businessDelegatorView
						.getTipoCartera(Long.parseLong(selectItemECl)));
				// System.out.println("tipo cartera " + selectItemECl);

				entity3.setFechaCreacion(new Date());
				entity3.setFechaModificacion(new Date());
				entity3.setOperCreador(usuario);
				entity3.setOperModifica(usuario);
				entity3.setPersona(null);
				entity3.setEmpresa(entity);

				businessDelegatorView.saveCliente(entity3);
			}

			// txtIdEmpr.setValue(entity.getIdEmpr());

			// businessDelegatorView.saveEmpresa(entity);
			data = businessDelegatorView.getDataEmpresa();
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
			try {
				businessDelegatorView.deleteEmpresa(entity);
			} catch (Exception e1) {
			}
		}

		return "";
	}

	public String action_modify() {
		try {
			if (entity == null) {
				Long idEmpr = new Long(selectedEmpresa.getIdEmpr());
				entity = businessDelegatorView.getEmpresa(idEmpr);
			}

			Long idEmpr = new Long(selectedEmpresa.getIdEmpr());
			entity = businessDelegatorView.getEmpresa(idEmpr);

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			entity.setEstadoRegistro(estadoRegistro);

			entity.setFechaModificacion(new Date());
			entity.setOperModifica(usuario);

			entity.setApartadoAereo(FacesUtils.checkString(txtApartadoAereo));
			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			entity.setEmail(FacesUtils.checkString(txtEmail));
			entity.setFax(FacesUtils.checkString(txtFax));
			entity.setIdentificacion(FacesUtils.checkLong(txtIdentificacion));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setTelefono1(FacesUtils.checkString(txtTelefono1));
			entity.setTelefono2(FacesUtils.checkString(txtTelefono2));

			if (txtIdDipo_DivisionPolitica.getValue() == "") {
				entity.setDivisionPolitica(null);
			} else {
				entity.setDivisionPolitica(businessDelegatorView
						.getDivisionPolitica(FacesUtils
								.checkLong(txtIdDipo_DivisionPolitica)));
			}

			/*
			 * entity.setPersona(businessDelegatorView.getPersona(FacesUtils
			 * .checkLong(txtIdPers_Persona)));
			 */

			if (selectedPersona != null) {
				entity.setPersona(businessDelegatorView
						.getPersona(selectedPersona.getIdPers()));
			} else {

				System.out.println("entro null");
				entity.setPersona(null);
			}

			entity.setTipoIdentificacion(businessDelegatorView
					.getTipoIdentificacion(FacesUtils
							.checkLong(txtIdTiid_TipoIdentificacion)));
			
			if (selectItemCompania.equals("S") && selectItemCliente.equals("S")) {
				FacesUtils.addErrorMessage("Una empresa puede ser Compañia o Cliente, pero no las dos.");
				
				return "";
			}

			List<ClienteDTO> data4 = businessDelegatorView.getDataCliente();
			List<CompaniaDTO> data3 = businessDelegatorView.getDataCompania();

			String compania = "";
			String cliente = "";
			Long idCompañia = 0L;
			Long idCliente = 0L;

			for (int i = 0; i < data4.size(); i++) {
				if (selectedEmpresa.getIdEmpr() == data4.get(i)
						.getIdEmpr_Empresa()) {
					cliente = "S";
					idCliente = data4.get(i).getIdClie();
					break;
				}
			}

			for (int i = 0; i < data3.size(); i++) {
				if (selectedEmpresa.getIdEmpr() == data3.get(i)
						.getIdEmpr_Empresa()) {
					compania = "S";
					idCompañia = data3.get(i).getIdCia();
					break;
				}
			}

			if (selectItemCompania.equals("S") && compania.equals("")) {
				Compania entity2 = new Compania();
				entity2.setCodigo((String) txtCodigo.getValue());
				entity2.setEstadoCompania(selectItemECompania);
				entity2.setEstadoRegistro(selectItemEstadoC);
				entity2.setFechaCreacion(new Date());
				entity2.setFechaModificacion(new Date());
				entity2.setOperCreador(usuario);
				entity2.setOperModifica(usuario);
				entity2.setEmpresa(entity);

				businessDelegatorView.saveCompania(entity2);

			} else if (selectItemCompania.equals("S") && compania.equals("S")) {

				Compania entity2 = businessDelegatorView
						.getCompania(idCompañia);
				entity2.setCodigo((String) txtCodigo.getValue());
				entity2.setEstadoCompania(selectItemECompania);
				entity2.setEstadoRegistro(selectItemEstadoC);
				entity2.setFechaModificacion(new Date());
				entity2.setOperModifica(usuario);
				entity2.setEmpresa(entity);

				businessDelegatorView.updateCompania(entity2);

			}

			if (selectItemCliente.equals("S") && cliente.equals("")) {
				Cliente entity2 = new Cliente();

				if (selectItemECl.equals("")) {
					FacesUtils
							.addErrorMessage("El campo Tipo Cartera es requerido");
					return "";
				}
				entity2.setEstadoRegistro(selectItemEstadoCl);
				entity2.setTipoCartera(businessDelegatorView
						.getTipoCartera(Long.parseLong(selectItemECl)));
				entity2.setFechaCreacion(new Date());
				entity2.setFechaModificacion(new Date());
				entity2.setOperCreador(usuario);
				entity2.setOperModifica(usuario);
				entity2.setEmpresa(entity);

				businessDelegatorView.saveCliente(entity2);

			} else if (selectItemCliente.equals("S") && cliente.equals("S")) {
				Cliente entity2 = businessDelegatorView.getCliente(idCliente);

				if (selectItemECl.equals("")) {
					FacesUtils
							.addErrorMessage("El campo Tipo Cartera es requerido");
					return "";
				}
				entity2.setEstadoRegistro(selectItemEstadoCl);
				entity2.setTipoCartera(businessDelegatorView
						.getTipoCartera(Long.parseLong(selectItemECl)));
				entity2.setFechaModificacion(new Date());
				entity2.setOperModifica(usuario);
				entity2.setEmpresa(entity);

				businessDelegatorView.saveCliente(entity2);
			}

			businessDelegatorView.updateEmpresa(entity);
			data = businessDelegatorView.getDataEmpresa();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
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

	public SelectOneMenu getTxtIdDipo_DivisionPolitica() {
		return txtIdDipo_DivisionPolitica;
	}

	public void setTxtIdDipo_DivisionPolitica(
			SelectOneMenu txtIdDipo_DivisionPolitica) {
		this.txtIdDipo_DivisionPolitica = txtIdDipo_DivisionPolitica;
	}

	public SelectOneMenu getTxtIdPers_Persona() {
		return txtIdPers_Persona;
	}

	public void setTxtIdPers_Persona(SelectOneMenu txtIdPers_Persona) {
		this.txtIdPers_Persona = txtIdPers_Persona;
	}

	public SelectOneMenu getTxtIdTiid_TipoIdentificacion() {
		return txtIdTiid_TipoIdentificacion;
	}

	public void setTxtIdTiid_TipoIdentificacion(
			SelectOneMenu txtIdTiid_TipoIdentificacion) {
		this.txtIdTiid_TipoIdentificacion = txtIdTiid_TipoIdentificacion;
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

	public SelectOneMenu getEstado() {
		return estado;
	}

	public void setEstado(SelectOneMenu estado) {
		this.estado = estado;
	}

	public String getApartadoAereo() {
		return apartadoAereo;
	}

	public void setApartadoAereo(String apartadoAereo) {
		this.apartadoAereo = apartadoAereo;
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

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
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

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getIdDipo_DivisionPolitica() {
		return idDipo_DivisionPolitica;
	}

	public void setIdDipo_DivisionPolitica(String idDipo_DivisionPolitica) {
		this.idDipo_DivisionPolitica = idDipo_DivisionPolitica;
	}

	public Long getIdPers_Persona() {
		return idPers_Persona;
	}

	public void setIdPers_Persona(Long idPers_Persona) {
		this.idPers_Persona = idPers_Persona;
	}

	public String getIdTiid_TipoIdentificacion() {
		return idTiid_TipoIdentificacion;
	}

	public void setIdTiid_TipoIdentificacion(String idTiid_TipoIdentificacion) {
		this.idTiid_TipoIdentificacion = idTiid_TipoIdentificacion;
	}

	public String getIdEmpr() {
		return idEmpr;
	}

	public void setIdEmpr(String idEmpr) {
		this.idEmpr = idEmpr;
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

	public Map<String, String> getDivision() {
		try {
			List<DivisionPoliticaDTO> data1 = businessDelegatorView
					.getDataDivisionPolitica();

			for (int i = 0; i < data1.size(); i++) {
				division.put(data1.get(i).getNombre(), data1.get(i).getIdDipo()
						+ "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return division;
	}

	public void setDivision(Map<String, String> division) {
		this.division = division;
	}

	public Map<String, String> getPersona() {
		try {
			List<PersonaDTO> data2 = businessDelegatorView.getDataPersona();

			for (int i = 0; i < data2.size(); i++) {
				persona.put(data2.get(i).getPrimerNombre(), data2.get(i)
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

	public Map<String, String> getTipoIdentificacion() {
		try {
			List<TipoIdentificacionDTO> data3 = businessDelegatorView
					.getDataTipoIdentificacion();

			for (int i = 0; i < data3.size(); i++) {
				tipoIdentificacion.put(data3.get(i).getDescripcion(), data3
						.get(i).getIdTiid() + "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(Map<String, String> tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public SelectItem[] getManufacturerOptions() {
		return manufacturerOptions;
	}

	public void setManufacturerOptions(SelectItem[] manufacturerOptions) {
		this.manufacturerOptions = manufacturerOptions;
	}

	public String[] getManufacturers() {
		return manufacturers;
	}

	public void setManufacturers(String[] manufacturers) {
		this.manufacturers = manufacturers;
	}

	public CommandButton getBtnModify2() {
		return btnModify2;
	}

	public void setBtnModify2(CommandButton btnModify2) {
		this.btnModify2 = btnModify2;
	}

	public PersonaDTO getSelectedPersona() {
		return selectedPersona;
	}

	public void setSelectedPersona(PersonaDTO selectedPersona) {
		this.selectedPersona = selectedPersona;
	}

	public PersonaDataModel getPersonaModel() {
		return personaModel;
	}

	public void setPersonaModel(PersonaDataModel personaModel) {
		this.personaModel = personaModel;
	}

	public List<PersonaDTO> getData2() {
		return data2;
	}

	public void setData2(List<PersonaDTO> data2) {
		this.data2 = data2;
	}

	public String getSelectItemCompania() {
		return selectItemCompania;
	}

	public void setSelectItemCompania(String selectItemCompania) {
		this.selectItemCompania = selectItemCompania;
	}

	public SelectOneMenu getTxtCompania() {
		return txtCompania;
	}

	public void setTxtCompania(SelectOneMenu txtCompania) {
		this.txtCompania = txtCompania;
	}

	public String getSelectItemECompania() {
		return selectItemECompania;
	}

	public void setSelectItemECompania(String selectItemECompania) {
		this.selectItemECompania = selectItemECompania;
	}

	public SelectOneMenu getTxtECompania() {
		return txtECompania;
	}

	public void setTxtECompania(SelectOneMenu txtECompania) {
		this.txtECompania = txtECompania;
	}

	public String getSelectItemEstadoC() {
		return selectItemEstadoC;
	}

	public void setSelectItemEstadoC(String selectItemEstadoC) {
		this.selectItemEstadoC = selectItemEstadoC;
	}

	public SelectOneMenu getTxtEstadoC() {
		return txtEstadoC;
	}

	public void setTxtEstadoC(SelectOneMenu txtEstadoC) {
		this.txtEstadoC = txtEstadoC;
	}

	public String getSelectItemCliente() {
		return selectItemCliente;
	}

	public void setSelectItemCliente(String selectItemCliente) {
		this.selectItemCliente = selectItemCliente;
	}

	public SelectOneMenu getTxtCliente() {
		return txtCliente;
	}

	public void setTxtCliente(SelectOneMenu txtCliente) {
		this.txtCliente = txtCliente;
	}

	public String getSelectItemEstadoCl() {
		return selectItemEstadoCl;
	}

	public void setSelectItemEstadoCl(String selectItemEstadoCl) {
		this.selectItemEstadoCl = selectItemEstadoCl;
	}

	public SelectOneMenu getTxtTC() {
		return txtTC;
	}

	public void setTxtTC(SelectOneMenu txtTC) {
		this.txtTC = txtTC;
	}

	public SelectOneMenu getTxtEstadoCl() {
		return txtEstadoCl;
	}

	public void setTxtEstadoCl(SelectOneMenu txtEstadoCl) {
		this.txtEstadoCl = txtEstadoCl;
	}

	public InputText getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(InputText txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public Map<String, Long> getTipoCartera() {

		try {
			List<TipoCarteraDTO> data2 = businessDelegatorView
					.getDataTipoCartera();
			for (int i = 0; i < data2.size(); i++) {

				tipoCartera.put(data2.get(i).getCodigo() + " "
						+ data2.get(i).getDescripcion(), data2.get(i)
						.getIdTica());

			}
		} catch (Exception e) {

		}

		return tipoCartera;
	}

	public void setTipoCartera(Map<String, Long> tipoCartera) {
		this.tipoCartera = tipoCartera;
	}

	public String getSelectItemEstado() {
		return selectItemEstado;
	}

	public void setSelectItemEstado(String selectItemEstado) {
		this.selectItemEstado = selectItemEstado;
	}

	public String getSelectItemECl() {
		return selectItemECl;
	}

	public void setSelectItemECl(String selectItemECl) {
		this.selectItemECl = selectItemECl;
	}

}