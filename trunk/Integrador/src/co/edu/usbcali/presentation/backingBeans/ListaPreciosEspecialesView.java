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
import co.edu.usbcali.modelo.Empresa;
import co.edu.usbcali.modelo.ListaPreciosEspeciales;
import co.edu.usbcali.modelo.Persona;
import co.edu.usbcali.modelo.Referencia;
import co.edu.usbcali.modelo.Sucursal;
import co.edu.usbcali.modelo.dto.ConfSemanasAnoDTO;
import co.edu.usbcali.modelo.dto.EmpresaDTO;
import co.edu.usbcali.modelo.dto.ListaPreciosEspecialesDTO;
import co.edu.usbcali.modelo.dto.PersonaDTO;
import co.edu.usbcali.modelo.dto.ReferenciaDTO;
import co.edu.usbcali.modelo.dto.RelacionComercialDTO;
import co.edu.usbcali.modelo.dto.SucursalDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class ListaPreciosEspecialesView {
	private InputText txtConcepto;
	private InputTextarea txtEspacios;
	//private InputText txtEstadoRegistro;
	private SelectOneMenu estado;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtPrecio;
	private InputText txtTipoGrabado;
	private SelectOneMenu txtIdEmpr_Empresa;
	private SelectOneMenu txtIdPers_Persona;
	private SelectOneMenu txtIdRefe_Referencia;
	private SelectOneMenu txtIdSucu_Sucursal;
	private SelectOneMenu txtIdSucu_Sucursal2;
	private InputText txtIdLipe;
	private InputText txtFechaCreacion;
	private Calendar txtFechaInicial;
	private InputText txtFechaModificacion;
	private Calendar txtFechaVencimiento;
	
	private String concepto;
	private String espacios;
	private String estadoRegistro;
	private String operCreador;
	private String operModifica;
	private String precio;
	private String tipoGrabado;
	private String idEmpr_Empresa;
	private String idPers_Persona;
	private String idRefe_Referencia;
	private String idSucu_Sucursal;
	private String idSucu_Sucursal2;
	private String idLipe;
	private String fechaCreacion;
	private String fechaInicial;
	private String fechaModificacion;
	private String fechaVencimiento;
	
	private Map<String, String> persona = new HashMap<String, String>();
	private Map<String, String> empresa = new HashMap<String, String>();
	private Map<String, String> sucursal = new HashMap<String, String>();
	private Map<String, String> sucursal2 = new HashMap<String, String>();
	private Map<String, String> referencia = new HashMap<String, String>();
	
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ListaPreciosEspecialesDTO> data;
	private ListaPreciosEspecialesDTO selectedListaPreciosEspeciales;
	private ListaPreciosEspeciales entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private SelectItem[] manufacturerOptions;

	String manufacturers[] = { "A", "R" };
	public ListaPreciosEspecialesView() {
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

	public void onEdit(org.primefaces.event.RowEditEvent event) {

		try {

			entity = null;
			entity = businessDelegatorView.getListaPreciosEspeciales(((ListaPreciosEspecialesDTO) event
					.getObject()).getIdLipe());

			entity.setEstadoRegistro(estadoRegistro);
			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);
			entity.setFechaModificacion(new Date());

			Date fechaInicial = ((ListaPreciosEspecialesDTO) event.getObject())
					.getFechaInicial();
			entity.setFechaInicial(fechaInicial);
			Date fechaVencimiento = ((ListaPreciosEspecialesDTO) event.getObject())
					.getFechaVencimiento();
			entity.setFechaVencimiento(fechaVencimiento);
			
			entity.setPrecio(((ListaPreciosEspecialesDTO) event.getObject())
					.getPrecio());			
			entity.setTipoGrabado(((ListaPreciosEspecialesDTO) event.getObject())
					.getTipoGrabado());			
			entity.setConcepto(((ListaPreciosEspecialesDTO) event.getObject())
					.getConcepto());			
			entity.setEspacios(((ListaPreciosEspecialesDTO) event.getObject())
					.getEspacios());
			
			
			
//							Llaves foraneas	
			Empresa entity2 =  businessDelegatorView.getEmpresa(Long.parseLong(idEmpr_Empresa));
			System.out.println("antes Empresa: " + entity2 + "; " + txtIdEmpr_Empresa.getValue());
			
			if (entity2 == null) {
				System.out.println("Entro null Empresa");
				
				entity.setEmpresa(null);
				
			}else {
				System.out.println("Entro con: " + entity2);
				
				entity.setEmpresa(entity2);
				/*entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
						.checkLong(txtIdEmpr_Empresa)));*/
			}
			
			Persona entity3 = businessDelegatorView.getPersona(Long.parseLong(idPers_Persona));
			System.out.println("\nantes Persona: " + entity3  + "; " + txtIdPers_Persona.getValue());
			
			if (entity3 == null) {
				System.out.println("Entro null Persona");
				
				entity.setPersona(null);
			}else {
				System.out.println("Entro con: " + entity3);
				
				entity.setPersona(entity3);
				/*entity.setPersona(businessDelegatorView.getPersona(FacesUtils
						.checkLong(txtIdPers_Persona)));*/
			}
			
			Referencia entity4 = businessDelegatorView.getReferencia(Long.parseLong(idRefe_Referencia));
			//System.out.println("\nantes referenci: " + entity4  + "; " + txtIdRefe_Referencia.getValue());
			
			if (entity4 == null) {
				//System.out.println("Entro null Referencia");
				
				entity.setReferencia(null);
			}else {
				//System.out.println("Entro con: " + entity4);
				
				entity.setReferencia(entity4);
				/*entity.setReferencia(businessDelegatorView.getReferencia(FacesUtils
						.checkLong(txtIdRefe_Referencia)));*/
			}
			
			Sucursal entity5 = businessDelegatorView.getSucursal(Long.parseLong(idSucu_Sucursal2));
			System.out.println("\nantes Sucursal: " + entity5  + "; " + txtIdSucu_Sucursal2.getValue());
			
			if (entity5 == null) {
				System.out.println("Entro null Sucursal");
				
				entity.setSucursalByIdSucu(null);
			}else {
				System.out.println("Entro con: " + entity5);
				
				entity.setSucursalByIdSucu(entity5);
				/*entity.setSucursalByIdSucu(businessDelegatorView.getSucursal(FacesUtils
						.checkLong(txtIdSucu_Sucursal2)));*/
			}
			
			/*System.out.println("reload");
			sucursal = new HashMap<String, String>();
			try {
				
				sucursal2 = new HashMap<String, String>();
				List<SucursalDTO> data6 = businessDelegatorView
						.getDataSucursal();

				for (int i = 0; i < data6.size(); i++) {
					sucursal2.put(data6.get(i).getNombre(), data6.get(i)
							.getIdSucu()+ "");

				}
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			
			System.out.println("\nSucursalPadre: " + businessDelegatorView.getSucursal(FacesUtils.checkLong(txtIdSucu_Sucursal)) +
					 "; " + txtIdSucu_Sucursal.getValue());
			Sucursal entity6 = businessDelegatorView.getSucursal(Long.parseLong(idSucu_Sucursal));
			System.out.println("\nSucursalPadre: " + businessDelegatorView.getSucursal(FacesUtils.checkLong(txtIdSucu_Sucursal)) +
					"; " + entity6 + "; " + txtIdSucu_Sucursal.getValue());
			/*entity.setSucursalBySucursal(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));*/
			
			
			if (entity6 == null) {
				System.out.println("Entro en null");
				
				entity.setSucursalBySucursal(businessDelegatorView.getSucursal(FacesUtils.checkLong(txtIdSucu_Sucursal)));
			}else {
				System.out.println("entro con algo");
				
				entity.setSucursalBySucursal(entity6);
				
			}
			
			businessDelegatorView.updateListaPreciosEspeciales(entity);
			data = businessDelegatorView.getDataListaPreciosEspeciales();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("TipoEstado Cancelled",
				((ListaPreciosEspecialesDTO) event.getObject()).getIdLipe() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((ListaPreciosEspecialesDTO) event.getObject()).getIdLipe());
	}
	
	

	public void rowEventListener(RowEditEvent e) {
		try {
			ListaPreciosEspecialesDTO listaPreciosEspecialesDTO = (ListaPreciosEspecialesDTO) e
					.getObject();

			if (txtConcepto == null) {
				txtConcepto = new InputText();
			}

			txtConcepto.setValue(listaPreciosEspecialesDTO.getConcepto());

			if (txtEspacios == null) {
				txtEspacios = new InputTextarea();
			}

			txtEspacios.setValue(listaPreciosEspecialesDTO.getEspacios());

			/*if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(listaPreciosEspecialesDTO
					.getEstadoRegistro());*/

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(listaPreciosEspecialesDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(listaPreciosEspecialesDTO
					.getOperModifica());

			if (txtPrecio == null) {
				txtPrecio = new InputText();
			}

			txtPrecio.setValue(listaPreciosEspecialesDTO.getPrecio());

			if (txtTipoGrabado == null) {
				txtTipoGrabado = new InputText();
			}

			txtTipoGrabado.setValue(listaPreciosEspecialesDTO.getTipoGrabado());

			if (txtIdEmpr_Empresa == null) {
				txtIdEmpr_Empresa = new SelectOneMenu();
			}

			txtIdEmpr_Empresa.setValue(listaPreciosEspecialesDTO
					.getIdEmpr_Empresa());

			if (txtIdPers_Persona == null) {
				txtIdPers_Persona = new SelectOneMenu();
			}

			txtIdPers_Persona.setValue(listaPreciosEspecialesDTO
					.getIdPers_Persona());

			if (txtIdRefe_Referencia == null) {
				txtIdRefe_Referencia = new SelectOneMenu();
			}

			txtIdRefe_Referencia.setValue(listaPreciosEspecialesDTO
					.getIdRefe_Referencia());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new SelectOneMenu();
			}

			if (txtIdLipe == null) {
				txtIdLipe = new InputText();
			}

			txtIdLipe.setValue(listaPreciosEspecialesDTO.getIdLipe());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(listaPreciosEspecialesDTO
					.getFechaCreacion());

			if (txtFechaInicial == null) {
				txtFechaInicial = new Calendar();
			}

			txtFechaInicial.setValue(listaPreciosEspecialesDTO
					.getFechaInicial());

			
			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(listaPreciosEspecialesDTO
					.getFechaModificacion());

			if (txtFechaVencimiento == null) {
				txtFechaVencimiento = new Calendar();
			}

			txtFechaVencimiento.setValue(listaPreciosEspecialesDTO
					.getFechaVencimiento());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedListaPreciosEspeciales = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedListaPreciosEspeciales = null;

		if (txtConcepto != null) {
			txtConcepto.setValue(null);
			//txtConcepto.setDisabled(true);
		}

		if (txtEspacios != null) {
			txtEspacios.setValue(null);
			//txtEspacios.setDisabled(true);
		}

		/*if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}*/

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			//txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			//txtOperModifica.setDisabled(true);
		}

		if (txtPrecio != null) {
			txtPrecio.setValue(null);
			//txtPrecio.setDisabled(true);
		}

		if (txtTipoGrabado != null) {
			txtTipoGrabado.setValue(null);
			//txtTipoGrabado.setDisabled(true);
		}

		if (txtIdEmpr_Empresa != null) {
			txtIdEmpr_Empresa.setValue(null);
			//txtIdEmpr_Empresa.setDisabled(true);
		}

		if (txtIdPers_Persona != null) {
			txtIdPers_Persona.setValue(null);
			//txtIdPers_Persona.setDisabled(true);
		}

		if (txtIdRefe_Referencia != null) {
			txtIdRefe_Referencia.setValue(null);
			//txtIdRefe_Referencia.setDisabled(true);
		}

		if (txtIdSucu_Sucursal != null) {
			txtIdSucu_Sucursal.setValue(null);
			//txtIdSucu_Sucursal.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			//txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaInicial != null) {
			txtFechaInicial.setValue(null);
			//txtFechaInicial.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			//txtFechaModificacion.setDisabled(true);
		}

		if (txtFechaVencimiento != null) {
			txtFechaVencimiento.setValue(null);
			//txtFechaVencimiento.setDisabled(true);
		}

		if (txtIdLipe != null) {
			txtIdLipe.setValue(null);
			//txtIdLipe.setDisabled(false);
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

	public void listener_txtFechaInicial() {
		Date inputDate = (Date) txtFechaInicial.getValue();
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

	public void listener_txtFechaVencimiento() {
		Date inputDate = (Date) txtFechaVencimiento.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Long idLipe = new Long(txtIdLipe.getValue().toString());
			entity = businessDelegatorView.getListaPreciosEspeciales(idLipe);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtConcepto.setDisabled(false);
			txtEspacios.setDisabled(false);
			//txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtPrecio.setDisabled(false);
			txtTipoGrabado.setDisabled(false);
			txtIdEmpr_Empresa.setDisabled(false);
			txtIdPers_Persona.setDisabled(false);
			txtIdRefe_Referencia.setDisabled(false);
			txtIdSucu_Sucursal.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtFechaVencimiento.setDisabled(false);
			txtIdLipe.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtConcepto.setValue(entity.getConcepto());
			txtConcepto.setDisabled(false);
			txtEspacios.setValue(entity.getEspacios());
			txtEspacios.setDisabled(false);
			//txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			//txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaInicial.setValue(entity.getFechaInicial());
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtFechaVencimiento.setValue(entity.getFechaVencimiento());
			txtFechaVencimiento.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtPrecio.setValue(entity.getPrecio());
			txtPrecio.setDisabled(false);
			txtTipoGrabado.setValue(entity.getTipoGrabado());
			txtTipoGrabado.setDisabled(false);
			txtIdEmpr_Empresa.setValue(entity.getEmpresa().getIdEmpr());
			txtIdEmpr_Empresa.setDisabled(false);
			txtIdPers_Persona.setValue(entity.getPersona().getIdPers());
			txtIdPers_Persona.setDisabled(false);
			txtIdRefe_Referencia.setValue(entity.getReferencia().getIdRefe());
			txtIdRefe_Referencia.setDisabled(false);

			txtIdSucu_Sucursal.setDisabled(false);
			txtIdLipe.setValue(entity.getIdLipe());
			txtIdLipe.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedListaPreciosEspeciales = (ListaPreciosEspecialesDTO) (evt
				.getComponent().getAttributes()
				.get("selectedListaPreciosEspeciales"));
		txtConcepto.setValue(selectedListaPreciosEspeciales.getConcepto());
		txtConcepto.setDisabled(false);
		txtEspacios.setValue(selectedListaPreciosEspeciales.getEspacios());
		txtEspacios.setDisabled(false);
		//txtEstadoRegistro.setValue(selectedListaPreciosEspeciales
		//		.getEstadoRegistro());
		//txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedListaPreciosEspeciales
				.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaInicial.setValue(selectedListaPreciosEspeciales
				.getFechaInicial());
		txtFechaInicial.setDisabled(false);
		txtFechaModificacion.setValue(selectedListaPreciosEspeciales
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtFechaVencimiento.setValue(selectedListaPreciosEspeciales
				.getFechaVencimiento());
		txtFechaVencimiento.setDisabled(false);
		txtOperCreador
				.setValue(selectedListaPreciosEspeciales.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedListaPreciosEspeciales
				.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtPrecio.setValue(selectedListaPreciosEspeciales.getPrecio());
		txtPrecio.setDisabled(false);
		txtTipoGrabado
				.setValue(selectedListaPreciosEspeciales.getTipoGrabado());
		txtTipoGrabado.setDisabled(false);
		txtIdEmpr_Empresa.setValue(selectedListaPreciosEspeciales
				.getIdEmpr_Empresa());
		txtIdEmpr_Empresa.setDisabled(false);
		txtIdPers_Persona.setValue(selectedListaPreciosEspeciales
				.getIdPers_Persona());
		txtIdPers_Persona.setDisabled(false);
		txtIdRefe_Referencia.setValue(selectedListaPreciosEspeciales
				.getIdRefe_Referencia());
		txtIdRefe_Referencia.setDisabled(false);

		txtIdSucu_Sucursal.setDisabled(false);
		txtIdLipe.setValue(selectedListaPreciosEspeciales.getIdLipe());
		txtIdLipe.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedListaPreciosEspeciales == null) && (entity == null)) {
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
			entity = new ListaPreciosEspeciales();
			
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			//Long idLipe = new Long(txtIdLipe.getValue().toString());

			entity.setConcepto(FacesUtils.checkString(txtConcepto));
			entity.setEspacios(FacesUtils.checkString(txtEspacios));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));			
			entity.setFechaVencimiento(FacesUtils
					.checkDate(txtFechaVencimiento));			
			//entity.setIdLipe(idLipe);
			entity.setPrecio(FacesUtils.checkDouble(txtPrecio));
			entity.setTipoGrabado(FacesUtils.checkString(txtTipoGrabado));
			
			
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			entity.setEstadoRegistro(estadoRegistro);
			
			
			if (txtIdEmpr_Empresa.getValue() == "") {
				
			}else {
				entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
						.checkLong(txtIdEmpr_Empresa)));
			}
			
			if (txtIdPers_Persona.getValue() == "") {
				
			}else {
				entity.setPersona(businessDelegatorView.getPersona(FacesUtils
						.checkLong(txtIdPers_Persona)));
			}
			
			
			if (txtIdRefe_Referencia.getValue() == "") {
				
			}else {
				entity.setReferencia(businessDelegatorView.getReferencia(FacesUtils
						.checkLong(txtIdRefe_Referencia)));
			}
			
			
			if (txtIdSucu_Sucursal2.getValue() == "") {
				
			}else {
				entity.setSucursalByIdSucu(businessDelegatorView.getSucursal(FacesUtils
						.checkLong(txtIdSucu_Sucursal2)));
			}
			
			entity.setSucursalBySucursal(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			
			

			businessDelegatorView.saveListaPreciosEspeciales(entity);
			data = businessDelegatorView.getDataListaPreciosEspeciales();
			RequestContext.getCurrentInstance().update("form:tablaPrincipal");
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
				Long idLipe = new Long(
						selectedListaPreciosEspeciales.getIdLipe());
				entity = businessDelegatorView
						.getListaPreciosEspeciales(idLipe);
			}

			entity.setConcepto(FacesUtils.checkString(txtConcepto));
			entity.setEspacios(FacesUtils.checkString(txtEspacios));
			//entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaVencimiento(FacesUtils
					.checkDate(txtFechaVencimiento));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setPrecio(FacesUtils.checkDouble(txtPrecio));
			entity.setTipoGrabado(FacesUtils.checkString(txtTipoGrabado));
			entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
					.checkLong(txtIdEmpr_Empresa)));
			entity.setPersona(businessDelegatorView.getPersona(FacesUtils
					.checkLong(txtIdPers_Persona)));
			entity.setReferencia(businessDelegatorView.getReferencia(FacesUtils
					.checkLong(txtIdRefe_Referencia)));

			businessDelegatorView.updateListaPreciosEspeciales(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedListaPreciosEspeciales = (ListaPreciosEspecialesDTO) (evt
					.getComponent().getAttributes()
					.get("selectedListaPreciosEspeciales"));

			Long idLipe = new Long(selectedListaPreciosEspeciales.getIdLipe());
			entity = businessDelegatorView.getListaPreciosEspeciales(idLipe);
			businessDelegatorView.deleteListaPreciosEspeciales(entity);
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
			selectedListaPreciosEspeciales = (ListaPreciosEspecialesDTO) (evt
					.getComponent().getAttributes()
					.get("selectedListaPreciosEspeciales"));

			Long idLipe = new Long(selectedListaPreciosEspeciales.getIdLipe());
			entity = businessDelegatorView.getListaPreciosEspeciales(idLipe);
			businessDelegatorView.deleteListaPreciosEspeciales(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedListaPreciosEspeciales);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String concepto, String espacios,
			String estadoRegistro, Date fechaCreacion, Date fechaInicial,
			Date fechaModificacion, Date fechaVencimiento, Long idLipe,
			String operCreador, String operModifica, Double precio,
			String tipoGrabado, Long idEmpr_Empresa, Long idPers_Persona,
			Long idRefe_Referencia, Long idSucu_Sucursal, Long idSucu_Sucursal0)
			throws Exception {
		try {
			entity.setConcepto(FacesUtils.checkString(concepto));
			entity.setEspacios(FacesUtils.checkString(espacios));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaInicial(FacesUtils.checkDate(fechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaVencimiento(FacesUtils.checkDate(fechaVencimiento));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setPrecio(FacesUtils.checkDouble(precio));
			entity.setTipoGrabado(FacesUtils.checkString(tipoGrabado));
			businessDelegatorView.updateListaPreciosEspeciales(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ListaPreciosEspecialesView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtConcepto() {
		return txtConcepto;
	}

	public void setTxtConcepto(InputText txtConcepto) {
		this.txtConcepto = txtConcepto;
	}

	public InputTextarea getTxtEspacios() {
		return txtEspacios;
	}

	public void setTxtEspacios(InputTextarea txtEspacios) {
		this.txtEspacios = txtEspacios;
	}

	/*public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}*/

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

	public InputText getTxtPrecio() {
		return txtPrecio;
	}

	public void setTxtPrecio(InputText txtPrecio) {
		this.txtPrecio = txtPrecio;
	}

	public InputText getTxtTipoGrabado() {
		return txtTipoGrabado;
	}

	public void setTxtTipoGrabado(InputText txtTipoGrabado) {
		this.txtTipoGrabado = txtTipoGrabado;
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

	public SelectOneMenu getTxtIdRefe_Referencia() {
		return txtIdRefe_Referencia;
	}

	public void setTxtIdRefe_Referencia(SelectOneMenu txtIdRefe_Referencia) {
		this.txtIdRefe_Referencia = txtIdRefe_Referencia;
	}

	public SelectOneMenu getTxtIdSucu_Sucursal() {
		return txtIdSucu_Sucursal;
	}

	public void setTxtIdSucu_Sucursal(SelectOneMenu txtIdSucu_Sucursal) {
		this.txtIdSucu_Sucursal = txtIdSucu_Sucursal;
	}

	public InputText getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(InputText txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaInicial() {
		return txtFechaInicial;
	}

	public void setTxtFechaInicial(Calendar txtFechaInicial) {
		this.txtFechaInicial = txtFechaInicial;
	}

	public InputText getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(InputText txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public Calendar getTxtFechaVencimiento() {
		return txtFechaVencimiento;
	}

	public void setTxtFechaVencimiento(Calendar txtFechaVencimiento) {
		this.txtFechaVencimiento = txtFechaVencimiento;
	}

	public InputText getTxtIdLipe() {
		return txtIdLipe;
	}

	public void setTxtIdLipe(InputText txtIdLipe) {
		this.txtIdLipe = txtIdLipe;
	}

	public List<ListaPreciosEspecialesDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataListaPreciosEspeciales();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(
			List<ListaPreciosEspecialesDTO> listaPreciosEspecialesDTO) {
		this.data = listaPreciosEspecialesDTO;
	}

	public ListaPreciosEspecialesDTO getSelectedListaPreciosEspeciales() {
		return selectedListaPreciosEspeciales;
	}

	public void setSelectedListaPreciosEspeciales(
			ListaPreciosEspecialesDTO listaPreciosEspeciales) {
		this.selectedListaPreciosEspeciales = listaPreciosEspeciales;
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

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getEspacios() {
		return espacios;
	}

	public void setEspacios(String espacios) {
		this.espacios = espacios;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
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

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getTipoGrabado() {
		return tipoGrabado;
	}

	public void setTipoGrabado(String tipoGrabado) {
		this.tipoGrabado = tipoGrabado;
	}

	public String getIdEmpr_Empresa() {
		return idEmpr_Empresa;
	}

	public void setIdEmpr_Empresa(String idEmpr_Empresa) {
		this.idEmpr_Empresa = idEmpr_Empresa;
	}

	public String getIdPers_Persona() {
		return idPers_Persona;
	}

	public void setIdPers_Persona(String idPers_Persona) {
		this.idPers_Persona = idPers_Persona;
	}

	public String getIdRefe_Referencia() {
		return idRefe_Referencia;
	}

	public void setIdRefe_Referencia(String idRefe_Referencia) {
		this.idRefe_Referencia = idRefe_Referencia;
	}

	public String getIdSucu_Sucursal() {
		return idSucu_Sucursal;
	}

	public void setIdSucu_Sucursal(String idSucu_Sucursal) {
		this.idSucu_Sucursal = idSucu_Sucursal;
	}

	public String getIdLipe() {
		return idLipe;
	}

	public void setIdLipe(String idLipe) {
		this.idLipe = idLipe;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public SelectItem[] getManufacturerOptions() {
		return manufacturerOptions;
	}

	public void setManufacturerOptions(SelectItem[] manufacturerOptions) {
		this.manufacturerOptions = manufacturerOptions;
	}


	public SelectOneMenu getEstado() {
		return estado;
	}


	public void setEstado(SelectOneMenu estado) {
		this.estado = estado;
	}
	
	
	


	public Map<String, String> getPersona() {
		try {
			List<PersonaDTO> data2 = businessDelegatorView
					.getDataPersona();

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

	
	
	


	public Map<String, String> getSucursal() {
		try {
			List<SucursalDTO> data3 = businessDelegatorView
					.getDataSucursal();

			for (int i = 0; i < data3.size(); i++) {
				sucursal.put(data3.get(i).getCodigo(), data3.get(i)
						.getIdSucu() + "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sucursal;
	}


	public void setSucursal(Map<String, String> sucursal) {
		this.sucursal = sucursal;
	}
	
	
	
	


	public Map<String, String> getEmpresa() {
		try {
			List<EmpresaDTO> data4 = businessDelegatorView
					.getDataEmpresa();

			for (int i = 0; i < data4.size(); i++) {
				empresa.put(data4.get(i).getNombre(), data4.get(i)
						.getIdEmpr() + "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return empresa;
	}
	

	public void setEmpresa(Map<String, String> empresa) {
		this.empresa = empresa;
	}
	
	


	public Map<String, String> getReferencia() {
		try {
			List<ReferenciaDTO> data5 = businessDelegatorView
					.getDataReferencia();

			for (int i = 0; i < data5.size(); i++) {
				referencia.put(data5.get(i).getCodigo(), data5.get(i)
						.getIdRefe()+ "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return referencia;
	}


	public void setReferencia(Map<String, String> referencia) {
		this.referencia = referencia;
	}


	public SelectOneMenu getTxtIdSucu_Sucursal2() {
		return txtIdSucu_Sucursal2;
	}


	public void setTxtIdSucu_Sucursal2(SelectOneMenu txtIdSucu_Sucursal2) {
		this.txtIdSucu_Sucursal2 = txtIdSucu_Sucursal2;
	}


	public String getIdSucu_Sucursal2() {
		return idSucu_Sucursal2;
	}


	public void setIdSucu_Sucursal2(String idSucu_Sucursal2) {
		this.idSucu_Sucursal2 = idSucu_Sucursal2;
	}


	public Map<String, String> getSucursal2() {
		
		try {
			List<SucursalDTO> data6 = businessDelegatorView
					.getDataSucursal();

			for (int i = 0; i < data6.size(); i++) {
				sucursal2.put(data6.get(i).getNombre(), data6.get(i)
						.getIdSucu()+ "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return sucursal2;
	}


	public void setSucursal2(Map<String, String> sucursal2) {
		this.sucursal2 = sucursal2;
	}
	
	
	
	
}
