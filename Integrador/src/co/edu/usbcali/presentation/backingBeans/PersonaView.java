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

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.DivisionPolitica;
import co.edu.usbcali.modelo.Persona;
import co.edu.usbcali.modelo.Sucursal;
import co.edu.usbcali.modelo.TipoIdentificacion;
import co.edu.usbcali.modelo.dto.DivisionPoliticaDTO;
import co.edu.usbcali.modelo.dto.PersonaDTO;
import co.edu.usbcali.modelo.dto.TipoCausalDTO;
import co.edu.usbcali.modelo.dto.TipoFormaPagoDTO;
import co.edu.usbcali.modelo.dto.TipoIdentificacionDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class PersonaView {
	private InputText txtApartadoAereo;
	private InputText txtDigitoVerificacion;
	private InputTextarea txtDireccion;
	private InputText txtEmail;
	//private InputText txtEstadoPersona;
	//private InputText txtEstadoRegistro;
	private SelectOneMenu estado;
	private SelectOneMenu estadoP;
	private InputText txtIdentificacion;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtPrimerApellido;
	private InputText txtPrimerNombre;
	private InputText txtSegundoApellido;
	private InputText txtSegundoNombre;
	private InputText txtTelefono1;
	private InputText txtTelefono2;
	private SelectOneMenu txtIdDipo_DivisionPolitica;
	private SelectOneMenu txtIdTiid_TipoIdentificacion;
	private InputText txtIdPers;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;
	
	private String apartadoAereo;
	private String digitoVerificacion;
	private String direccion;
	private String email;
	private String estadoPersona;
	private String estadoRegistro;
	private String identificacion;
	private String operCreador;
	private String operModifica;
	private String primerApellido;
	private String primerNombre;
	private String segundoApellido;
	private String segundoNombre;
	private String telefono1;
	private String telefono2;
	private Long idDipo_DivisionPolitica;
	private Long idTiid_TipoIdentificacion;
	private String idPers;
	private String fechaCreacion;
	private String fechaModificacion;
	
	private Map<String,String> divisionPolitica = new HashMap<String, String>();
	private Map<String,String> tipoIdentificacion = new HashMap<String, String>();
	
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<PersonaDTO> data;
	private PersonaDTO selectedPersona;
	private Persona entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private SelectItem[] manufacturerOptions;
	private SelectItem[] manufacturerOptions2;

	String manufacturers[] = { "A", "R" };
	String manufacturers2[] = { "1", "0" };

	public PersonaView() {
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
			entity = businessDelegatorView
					.getPersona(((PersonaDTO) event.getObject())
							.getIdPers());

			entity.setIdentificacion(((PersonaDTO) event.getObject()).getIdentificacion());
			entity.setPrimerNombre(((PersonaDTO) event.getObject()).getPrimerNombre());
			entity.setSegundoNombre(((PersonaDTO) event.getObject()).getSegundoNombre());
			entity.setPrimerApellido(((PersonaDTO) event.getObject()).getPrimerApellido());
			entity.setSegundoApellido(((PersonaDTO) event.getObject()).getSegundoApellido());
			
			entity.setDireccion(((PersonaDTO) event.getObject()).getDireccion());
			entity.setTelefono1(((PersonaDTO) event.getObject()).getTelefono1());
			entity.setTelefono2(((PersonaDTO) event.getObject()).getTelefono2());
			entity.setApartadoAereo(((PersonaDTO) event.getObject()).getApartadoAereo());
			
			entity.setEmail(((PersonaDTO) event.getObject()).getEmail());
			entity.setDigitoVerificacion(((PersonaDTO) event.getObject()).getDigitoVerificacion());
			
			Long estadoPersona = new Long(estadoP.getValue().toString());
		
			entity.setEstadoPersona(estadoPersona);
				
			entity.setEstadoRegistro(estadoRegistro);	
			String usuario =(String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);
			entity.setFechaModificacion(new Date());
			
			
			DivisionPolitica entity2 = businessDelegatorView
					.getDivisionPolitica(getIdDipo_DivisionPolitica());		
			entity.setDivisionPolitica(entity2);
			
			TipoIdentificacion entity3 = businessDelegatorView
					.getTipoIdentificacion(getIdTiid_TipoIdentificacion());		
			entity.setTipoIdentificacion(entity3);
			
			
			businessDelegatorView.updatePersona(entity);
			data = businessDelegatorView.getDataPersona();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("TipoEstado Cancelled",
				((PersonaDTO) event.getObject()).getIdPers() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((PersonaDTO) event.getObject()).getIdPers());
	}
	
	
	

	public void rowEventListener(RowEditEvent e) {
		try {
			PersonaDTO personaDTO = (PersonaDTO) e.getObject();

			if (txtApartadoAereo == null) {
				txtApartadoAereo = new InputText();
			}

			txtApartadoAereo.setValue(personaDTO.getApartadoAereo());

			if (txtDigitoVerificacion == null) {
				txtDigitoVerificacion = new InputText();
			}

			txtDigitoVerificacion.setValue(personaDTO.getDigitoVerificacion());

			if (txtDireccion == null) {
				txtDireccion = new InputTextarea();
			}

			txtDireccion.setValue(personaDTO.getDireccion());

			if (txtEmail == null) {
				txtEmail = new InputText();
			}

			txtEmail.setValue(personaDTO.getEmail());

			/*if (txtEstadoPersona == null) {
				txtEstadoPersona = new InputText();
			}

			txtEstadoPersona.setValue(personaDTO.getEstadoPersona());*/

			/*if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(personaDTO.getEstadoRegistro());*/

			if (txtIdentificacion == null) {
				txtIdentificacion = new InputText();
			}

			txtIdentificacion.setValue(personaDTO.getIdentificacion());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(personaDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(personaDTO.getOperModifica());

			if (txtPrimerApellido == null) {
				txtPrimerApellido = new InputText();
			}

			txtPrimerApellido.setValue(personaDTO.getPrimerApellido());

			if (txtPrimerNombre == null) {
				txtPrimerNombre = new InputText();
			}

			txtPrimerNombre.setValue(personaDTO.getPrimerNombre());

			if (txtSegundoApellido == null) {
				txtSegundoApellido = new InputText();
			}

			txtSegundoApellido.setValue(personaDTO.getSegundoApellido());

			if (txtSegundoNombre == null) {
				txtSegundoNombre = new InputText();
			}

			txtSegundoNombre.setValue(personaDTO.getSegundoNombre());

			if (txtTelefono1 == null) {
				txtTelefono1 = new InputText();
			}

			txtTelefono1.setValue(personaDTO.getTelefono1());

			if (txtTelefono2 == null) {
				txtTelefono2 = new InputText();
			}

			txtTelefono2.setValue(personaDTO.getTelefono2());

			if (txtIdDipo_DivisionPolitica == null) {
				txtIdDipo_DivisionPolitica = new SelectOneMenu();
			}

			txtIdDipo_DivisionPolitica.setValue(personaDTO
					.getIdDipo_DivisionPolitica());

			if (txtIdTiid_TipoIdentificacion == null) {
				txtIdTiid_TipoIdentificacion = new SelectOneMenu();
			}

			txtIdTiid_TipoIdentificacion.setValue(personaDTO
					.getIdTiid_TipoIdentificacion());

			if (txtIdPers == null) {
				txtIdPers = new InputText();
			}

			txtIdPers.setValue(personaDTO.getIdPers());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(personaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(personaDTO.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedPersona = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedPersona = null;

		if (txtApartadoAereo != null) {
			txtApartadoAereo.setValue(null);
			//txtApartadoAereo.setDisabled(true);
		}

		if (txtDigitoVerificacion != null) {
			txtDigitoVerificacion.setValue(null);
			//txtDigitoVerificacion.setDisabled(true);
		}

		if (txtDireccion != null) {
			txtDireccion.setValue(null);
			//txtDireccion.setDisabled(true);
		}

		if (txtEmail != null) {
			txtEmail.setValue(null);
			//txtEmail.setDisabled(true);
		}

		/*if (txtEstadoPersona != null) {
			txtEstadoPersona.setValue(null);
			//txtEstadoPersona.setDisabled(true);
		}*/

		/*if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}
*/
		if (txtIdentificacion != null) {
			txtIdentificacion.setValue(null);
			//txtIdentificacion.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			//txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			//txtOperModifica.setDisabled(true);
		}

		if (txtPrimerApellido != null) {
			txtPrimerApellido.setValue(null);
			//txtPrimerApellido.setDisabled(true);
		}

		if (txtPrimerNombre != null) {
			txtPrimerNombre.setValue(null);
			//txtPrimerNombre.setDisabled(true);
		}

		if (txtSegundoApellido != null) {
			txtSegundoApellido.setValue(null);
			//txtSegundoApellido.setDisabled(true);
		}

		if (txtSegundoNombre != null) {
			txtSegundoNombre.setValue(null);
			//txtSegundoNombre.setDisabled(true);
		}

		if (txtTelefono1 != null) {
			txtTelefono1.setValue(null);
			//txtTelefono1.setDisabled(true);
		}

		if (txtTelefono2 != null) {
			txtTelefono2.setValue(null);
			//txtTelefono2.setDisabled(true);
		}

		if (txtIdDipo_DivisionPolitica != null) {
			txtIdDipo_DivisionPolitica.setValue(null);
			//txtIdDipo_DivisionPolitica.setDisabled(true);
		}

		if (txtIdTiid_TipoIdentificacion != null) {
			txtIdTiid_TipoIdentificacion.setValue(null);
			//txtIdTiid_TipoIdentificacion.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			//txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			//txtFechaModificacion.setDisabled(true);
		}

		if (txtIdPers != null) {
			txtIdPers.setValue(null);
			//txtIdPers.setDisabled(false);
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
			Long idPers = new Long(txtIdPers.getValue().toString());
			entity = businessDelegatorView.getPersona(idPers);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtApartadoAereo.setDisabled(false);
			txtDigitoVerificacion.setDisabled(false);
			txtDireccion.setDisabled(false);
			txtEmail.setDisabled(false);
			//txtEstadoPersona.setDisabled(false);
			//txtEstadoRegistro.setDisabled(false);
			txtIdentificacion.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtPrimerApellido.setDisabled(false);
			txtPrimerNombre.setDisabled(false);
			txtSegundoApellido.setDisabled(false);
			txtSegundoNombre.setDisabled(false);
			txtTelefono1.setDisabled(false);
			txtTelefono2.setDisabled(false);
			txtIdDipo_DivisionPolitica.setDisabled(false);
			txtIdTiid_TipoIdentificacion.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdPers.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtApartadoAereo.setValue(entity.getApartadoAereo());
			txtApartadoAereo.setDisabled(false);
			txtDigitoVerificacion.setValue(entity.getDigitoVerificacion());
			txtDigitoVerificacion.setDisabled(false);
			txtDireccion.setValue(entity.getDireccion());
			txtDireccion.setDisabled(false);
			txtEmail.setValue(entity.getEmail());
			txtEmail.setDisabled(false);
			//txtEstadoPersona.setValue(entity.getEstadoPersona());
			//txtEstadoPersona.setDisabled(false);
			//txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			//txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtIdentificacion.setValue(entity.getIdentificacion());
			txtIdentificacion.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtPrimerApellido.setValue(entity.getPrimerApellido());
			txtPrimerApellido.setDisabled(false);
			txtPrimerNombre.setValue(entity.getPrimerNombre());
			txtPrimerNombre.setDisabled(false);
			txtSegundoApellido.setValue(entity.getSegundoApellido());
			txtSegundoApellido.setDisabled(false);
			txtSegundoNombre.setValue(entity.getSegundoNombre());
			txtSegundoNombre.setDisabled(false);
			txtTelefono1.setValue(entity.getTelefono1());
			txtTelefono1.setDisabled(false);
			txtTelefono2.setValue(entity.getTelefono2());
			txtTelefono2.setDisabled(false);
			txtIdDipo_DivisionPolitica.setValue(entity.getDivisionPolitica()
					.getIdDipo());
			txtIdDipo_DivisionPolitica.setDisabled(false);
			txtIdTiid_TipoIdentificacion.setValue(entity
					.getTipoIdentificacion().getIdTiid());
			txtIdTiid_TipoIdentificacion.setDisabled(false);
			txtIdPers.setValue(entity.getIdPers());
			txtIdPers.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedPersona = (PersonaDTO) (evt.getComponent().getAttributes()
				.get("selectedPersona"));
		txtApartadoAereo.setValue(selectedPersona.getApartadoAereo());
		txtApartadoAereo.setDisabled(false);
		txtDigitoVerificacion.setValue(selectedPersona.getDigitoVerificacion());
		txtDigitoVerificacion.setDisabled(false);
		txtDireccion.setValue(selectedPersona.getDireccion());
		txtDireccion.setDisabled(false);
		txtEmail.setValue(selectedPersona.getEmail());
		txtEmail.setDisabled(false);
		//txtEstadoPersona.setValue(selectedPersona.getEstadoPersona());
		//txtEstadoPersona.setDisabled(false);
		//txtEstadoRegistro.setValue(selectedPersona.getEstadoRegistro());
		//txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedPersona.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedPersona.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtIdentificacion.setValue(selectedPersona.getIdentificacion());
		txtIdentificacion.setDisabled(false);
		txtOperCreador.setValue(selectedPersona.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedPersona.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtPrimerApellido.setValue(selectedPersona.getPrimerApellido());
		txtPrimerApellido.setDisabled(false);
		txtPrimerNombre.setValue(selectedPersona.getPrimerNombre());
		txtPrimerNombre.setDisabled(false);
		txtSegundoApellido.setValue(selectedPersona.getSegundoApellido());
		txtSegundoApellido.setDisabled(false);
		txtSegundoNombre.setValue(selectedPersona.getSegundoNombre());
		txtSegundoNombre.setDisabled(false);
		txtTelefono1.setValue(selectedPersona.getTelefono1());
		txtTelefono1.setDisabled(false);
		txtTelefono2.setValue(selectedPersona.getTelefono2());
		txtTelefono2.setDisabled(false);
		txtIdDipo_DivisionPolitica.setValue(selectedPersona
				.getIdDipo_DivisionPolitica());
		txtIdDipo_DivisionPolitica.setDisabled(false);
		txtIdTiid_TipoIdentificacion.setValue(selectedPersona
				.getIdTiid_TipoIdentificacion());
		txtIdTiid_TipoIdentificacion.setDisabled(false);
		txtIdPers.setValue(selectedPersona.getIdPers());
		txtIdPers.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedPersona == null) && (entity == null)) {
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
			entity = new Persona();
			
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
					.getExternalContext().getSession(false);
			
			String usuario =(String) session.getAttribute("Usuario");

			//Long idPers = new Long(txtIdPers.getValue().toString());

			entity.setApartadoAereo(FacesUtils.checkString(txtApartadoAereo));
			entity.setDigitoVerificacion(FacesUtils
					.checkString(txtDigitoVerificacion));
			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			entity.setEmail(FacesUtils.checkString(txtEmail));
			entity.setIdentificacion(FacesUtils.checkLong(txtIdentificacion));
			
			Long estadoPersona = new Long(estadoP.getValue().toString());
			entity.setEstadoPersona(estadoPersona);
			
			entity.setEstadoRegistro(estadoRegistro);
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			
			
			//entity.setIdPers(idPers);
			//entity.setEstadoPersona(FacesUtils.checkLong(txtEstadoPersona));
			//entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			//entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			//entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			
			entity.setPrimerApellido(FacesUtils.checkString(txtPrimerApellido));
			entity.setPrimerNombre(FacesUtils.checkString(txtPrimerNombre));
			entity.setSegundoApellido(FacesUtils
					.checkString(txtSegundoApellido));
			entity.setSegundoNombre(FacesUtils.checkString(txtSegundoNombre));
			entity.setTelefono1(FacesUtils.checkString(txtTelefono1));
			entity.setTelefono2(FacesUtils.checkString(txtTelefono2));
			
			
			/*entity.setDivisionPolitica(businessDelegatorView
					.getDivisionPolitica(FacesUtils
							.checkLong(txtIdDipo_DivisionPolitica)));*/
			/*entity.setTipoIdentificacion(businessDelegatorView
					.getTipoIdentificacion(FacesUtils
							.checkLong(txtIdTiid_TipoIdentificacion)));*/
			DivisionPolitica entity2 = businessDelegatorView
					.getDivisionPolitica(getIdDipo_DivisionPolitica());		
			entity.setDivisionPolitica(entity2);
			
			TipoIdentificacion entity3 = businessDelegatorView
					.getTipoIdentificacion(getIdTiid_TipoIdentificacion());		
			entity.setTipoIdentificacion(entity3);
			
			businessDelegatorView.savePersona(entity);
			data = businessDelegatorView.getDataPersona();
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
				Long idPers = new Long(selectedPersona.getIdPers());
				entity = businessDelegatorView.getPersona(idPers);
			}

			entity.setApartadoAereo(FacesUtils.checkString(txtApartadoAereo));
			entity.setDigitoVerificacion(FacesUtils
					.checkString(txtDigitoVerificacion));
			entity.setDireccion(FacesUtils.checkString(txtDireccion));
			entity.setEmail(FacesUtils.checkString(txtEmail));
			//entity.setEstadoPersona(FacesUtils.checkLong(txtEstadoPersona));
			//entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdentificacion(FacesUtils.checkLong(txtIdentificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setPrimerApellido(FacesUtils.checkString(txtPrimerApellido));
			entity.setPrimerNombre(FacesUtils.checkString(txtPrimerNombre));
			entity.setSegundoApellido(FacesUtils
					.checkString(txtSegundoApellido));
			entity.setSegundoNombre(FacesUtils.checkString(txtSegundoNombre));
			entity.setTelefono1(FacesUtils.checkString(txtTelefono1));
			entity.setTelefono2(FacesUtils.checkString(txtTelefono2));
			entity.setDivisionPolitica(businessDelegatorView
					.getDivisionPolitica(FacesUtils
							.checkLong(txtIdDipo_DivisionPolitica)));
			entity.setTipoIdentificacion(businessDelegatorView
					.getTipoIdentificacion(FacesUtils
							.checkLong(txtIdTiid_TipoIdentificacion)));
			businessDelegatorView.updatePersona(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedPersona = (PersonaDTO) (evt.getComponent().getAttributes()
					.get("selectedPersona"));

			Long idPers = new Long(selectedPersona.getIdPers());
			entity = businessDelegatorView.getPersona(idPers);
			businessDelegatorView.deletePersona(entity);
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
			selectedPersona = (PersonaDTO) (evt.getComponent().getAttributes()
					.get("selectedPersona"));

			Long idPers = new Long(selectedPersona.getIdPers());
			entity = businessDelegatorView.getPersona(idPers);
			businessDelegatorView.deletePersona(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedPersona);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String apartadoAereo,
			String digitoVerificacion, String direccion, String email,
			Long estadoPersona, String estadoRegistro, Date fechaCreacion,
			Date fechaModificacion, Long idPers, Long identificacion,
			String operCreador, String operModifica, String primerApellido,
			String primerNombre, String segundoApellido, String segundoNombre,
			String telefono1, String telefono2, Long idDipo_DivisionPolitica,
			Long idTiid_TipoIdentificacion) throws Exception {
		try {
			entity.setApartadoAereo(FacesUtils.checkString(apartadoAereo));
			entity.setDigitoVerificacion(FacesUtils
					.checkString(digitoVerificacion));
			entity.setDireccion(FacesUtils.checkString(direccion));
			entity.setEmail(FacesUtils.checkString(email));
			entity.setEstadoPersona(FacesUtils.checkLong(estadoPersona));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setIdentificacion(FacesUtils.checkLong(identificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setPrimerApellido(FacesUtils.checkString(primerApellido));
			entity.setPrimerNombre(FacesUtils.checkString(primerNombre));
			entity.setSegundoApellido(FacesUtils.checkString(segundoApellido));
			entity.setSegundoNombre(FacesUtils.checkString(segundoNombre));
			entity.setTelefono1(FacesUtils.checkString(telefono1));
			entity.setTelefono2(FacesUtils.checkString(telefono2));
			businessDelegatorView.updatePersona(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("PersonaView").requestRender();
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

	public InputText getTxtDigitoVerificacion() {
		return txtDigitoVerificacion;
	}

	public void setTxtDigitoVerificacion(InputText txtDigitoVerificacion) {
		this.txtDigitoVerificacion = txtDigitoVerificacion;
	}

	public InputTextarea getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(InputTextarea txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	public InputText getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(InputText txtEmail) {
		this.txtEmail = txtEmail;
	}

	/*public InputText getTxtEstadoPersona() {
		return txtEstadoPersona;
	}

	public void setTxtEstadoPersona(InputText txtEstadoPersona) {
		this.txtEstadoPersona = txtEstadoPersona;
	}*/

	/*public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}*/

	public InputText getTxtIdentificacion() {
		return txtIdentificacion;
	}

	public void setTxtIdentificacion(InputText txtIdentificacion) {
		this.txtIdentificacion = txtIdentificacion;
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

	public InputText getTxtPrimerApellido() {
		return txtPrimerApellido;
	}

	public void setTxtPrimerApellido(InputText txtPrimerApellido) {
		this.txtPrimerApellido = txtPrimerApellido;
	}

	public InputText getTxtPrimerNombre() {
		return txtPrimerNombre;
	}

	public void setTxtPrimerNombre(InputText txtPrimerNombre) {
		this.txtPrimerNombre = txtPrimerNombre;
	}

	public InputText getTxtSegundoApellido() {
		return txtSegundoApellido;
	}

	public void setTxtSegundoApellido(InputText txtSegundoApellido) {
		this.txtSegundoApellido = txtSegundoApellido;
	}

	public InputText getTxtSegundoNombre() {
		return txtSegundoNombre;
	}

	public void setTxtSegundoNombre(InputText txtSegundoNombre) {
		this.txtSegundoNombre = txtSegundoNombre;
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

	public InputText getTxtIdPers() {
		return txtIdPers;
	}

	public void setTxtIdPers(InputText txtIdPers) {
		this.txtIdPers = txtIdPers;
	}

	public List<PersonaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataPersona();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<PersonaDTO> personaDTO) {
		this.data = personaDTO;
	}

	public PersonaDTO getSelectedPersona() {
		return selectedPersona;
	}

	public void setSelectedPersona(PersonaDTO persona) {
		this.selectedPersona = persona;
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

	public String getApartadoAereo() {
		return apartadoAereo;
	}

	public void setApartadoAereo(String apartadoAereo) {
		this.apartadoAereo = apartadoAereo;
	}

	public String getDigitoVerificacion() {
		return digitoVerificacion;
	}

	public void setDigitoVerificacion(String digitoVerificacion) {
		this.digitoVerificacion = digitoVerificacion;
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

	public String getEstadoPersona() {
		return estadoPersona;
	}

	public void setEstadoPersona(String estadoPersona) {
		this.estadoPersona = estadoPersona;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
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

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
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

	public Long getIdDipo_DivisionPolitica() {
		return idDipo_DivisionPolitica;
	}

	public void setIdDipo_DivisionPolitica(Long idDipo_DivisionPolitica) {
		this.idDipo_DivisionPolitica = idDipo_DivisionPolitica;
	}

	public Long getIdTiid_TipoIdentificacion() {
		return idTiid_TipoIdentificacion;
	}

	public void setIdTiid_TipoIdentificacion(Long idTiid_TipoIdentificacion) {
		this.idTiid_TipoIdentificacion = idTiid_TipoIdentificacion;
	}

	public String getIdPers() {
		return idPers;
	}

	public void setIdPers(String idPers) {
		this.idPers = idPers;
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

	public SelectOneMenu getEstado() {
		return estado;
	}

	public void setEstado(SelectOneMenu estado) {
		this.estado = estado;
	}

	public SelectOneMenu getEstadoP() {
		return estadoP;
	}

	public void setEstadoP(SelectOneMenu estadoP) {
		this.estadoP = estadoP;
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
	

	public Map<String,String> getDivisionPolitica() {
		try {
			List<DivisionPoliticaDTO> data2 = businessDelegatorView
					.getDataDivisionPolitica();
			for (int i = 0; i < data2.size(); i++) {
				
				divisionPolitica.put(data2.get(i).getNombre(), data2.get(i).getIdDipo() + "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return divisionPolitica;
	}

	public void setDivisionPolitica(Map<String,String> divisionPolitica) {
		this.divisionPolitica = divisionPolitica;
	}
	

	public Map<String,String> getTipoIdentificacion() {
		
		try {
			List<TipoIdentificacionDTO> data3 = businessDelegatorView
					.getDataTipoIdentificacion();
			for (int i = 0; i < data3.size(); i++) {
				
				tipoIdentificacion.put(data3.get(i).getCodigo(), data3.get(i).getIdTiid() + "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(Map<String,String> tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	
	
}
