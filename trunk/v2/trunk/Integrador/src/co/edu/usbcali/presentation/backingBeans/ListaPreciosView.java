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
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.ListaPrecios;
import co.edu.usbcali.modelo.Sucursal;
import co.edu.usbcali.modelo.dto.ListaPreciosDTO;
import co.edu.usbcali.modelo.dto.ReferenciaDTO;
import co.edu.usbcali.modelo.dto.SucursalDTO;
import co.edu.usbcali.modelo.dto.TipoListaDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class ListaPreciosView {
	private InputText txtEspacios;
	private SelectOneMenu estado;
	private InputText txtMargen;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtValor;
	private SelectOneMenu txtIdRefe_Referencia;
	private SelectOneMenu txtIdSucu_Sucursal;
	private SelectOneMenu txtIdTili_TipoLista;
	private InputText txtIdLipr;
	private InputText txtFechaCreacion;
	private Calendar txtFechaFinal;
	private Calendar txtFechaInicial;
	private InputText txtFechaModificacion;

	private String espacios;
	private String estadoRegistro;
	private String margen;
	private String operCreador;
	private String operModifica;
	private String valor;
	private Long idRefe_Referencia;
	private String idSucu_Sucursal;
	private Long idTili_TipoLista;
	private String idLipr;
	private String fFechaCreacion;
	private String fechaFinal;
	private String fechaInicial;
	private String fechaModificacion;

	private Map<String, String> referencia = new HashMap<String, String>();
	private Map<String, String> tipoLista = new HashMap<String, String>();
	private Map<String, String> sucursal = new HashMap<String, String>();

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnModify2;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ListaPreciosDTO> data;
	private ListaPreciosDTO selectedListaPrecios;
	private ListaPrecios entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private SelectItem[] manufacturerOptions;

	String manufacturers[] = { "A", "R" };

	public ListaPreciosView() {
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
			entity = businessDelegatorView
					.getListaPrecios(((ListaPreciosDTO) event.getObject())
							.getIdLipr());

			entity.setEstadoRegistro(estadoRegistro);
			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);
			entity.setFechaModificacion(new Date());

			entity.setValor(((ListaPreciosDTO) event.getObject()).getValor());
			entity.setMargen(((ListaPreciosDTO) event.getObject()).getMargen());
			entity.setEspacios(((ListaPreciosDTO) event.getObject())
					.getEspacios());

			Date fechaInicial = ((ListaPreciosDTO) event.getObject())
					.getFechaInicial();
			entity.setFechaInicial(fechaInicial);
			Date fechaFinal = ((ListaPreciosDTO) event.getObject())
					.getFechaFinal();
			entity.setFechaFinal(fechaFinal);

			entity.setTipoLista(businessDelegatorView
					.getTipoLista(getIdTili_TipoLista()));

			entity.setReferencia(businessDelegatorView
					.getReferencia(getIdRefe_Referencia()));
			
			
			Sucursal entity2 = businessDelegatorView.getSucursal(Long.parseLong(idSucu_Sucursal));
			System.out.println("antes: " + entity2 + "; " + txtIdSucu_Sucursal.getValue());
			
			if (entity2 == null) {
				System.out.println("Entro null");
				entity.setSucursal(null);
			} else {
				System.out.println("Entro con: " + entity2 + "; " + txtIdSucu_Sucursal.getValue());
				
				
				
				entity.setSucursal(entity2);
			}

			businessDelegatorView.updateListaPrecios(entity);
			data = businessDelegatorView.getDataListaPrecios();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("TipoEstado Cancelled",
				((ListaPreciosDTO) event.getObject()).getIdLipr() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((ListaPreciosDTO) event.getObject()).getIdLipr());
	}
	
	public String action_modify2() {
		try {
			
			btnSave.setDisabled(true);
			btnModify.setDisabled(false);
		
			try {
				txtValor.setValue(selectedListaPrecios.getValor());				

			} catch (Exception e) {
				txtValor.setValue("");
			}
			
			try {
				txtMargen.setValue(selectedListaPrecios.getMargen());				

			} catch (Exception e) {
				txtMargen.setValue("");
			}
			
			
			
			try {
				txtEspacios.setValue(selectedListaPrecios.getEspacios());				

			} catch (Exception e) {
				txtEspacios.setValue("");
			}

			try {
				txtIdTili_TipoLista.setValue(selectedListaPrecios.getIdTili_TipoLista());
			} catch (Exception e) {
				txtIdTili_TipoLista.setValue("");
			}

			try {
				txtIdRefe_Referencia.setValue(selectedListaPrecios.getIdRefe_Referencia());
			} catch (Exception e) {
				txtIdRefe_Referencia.setValue("");
			}

			try {
				txtIdSucu_Sucursal.setValue(selectedListaPrecios.getIdSucu_Sucursal());
			} catch (Exception e) {
				txtIdSucu_Sucursal.setValue("");
			}

			
			
			try {
				estado.setValue(selectedListaPrecios.getEstadoRegistro());
			} catch (Exception e) {
				estado.setValue("");
			}
			
			txtFechaInicial.setValue(selectedListaPrecios.getFechaInicial());
			txtFechaFinal.setValue(selectedListaPrecios.getFechaFinal());
			
			txtIdLipr.setValue(selectedListaPrecios.getIdLipr());

		} catch (Exception e) {
			if (selectedListaPrecios == null) {				
				FacesUtils
						.addErrorMessage("Seleccione lista de precio a modificar");
			}
		}
		return "";

	}
	
	
	public String action_VCrear(){
		
		btnModify.setDisabled(true);
		btnSave.setDisabled(false);
		
		try {
			txtValor.setValue(null);				

		} catch (Exception e) {
			txtValor.setValue("");
		}
		
		try {
			txtMargen.setValue(null);				

		} catch (Exception e) {
			txtMargen.setValue("");
		}
		
		
		
		try {
			txtEspacios.setValue(null);				

		} catch (Exception e) {
			txtEspacios.setValue("");
		}

		try {
			txtIdTili_TipoLista.setValue(null);
		} catch (Exception e) {
			txtIdTili_TipoLista.setValue("");
		}

		try {
			txtIdRefe_Referencia.setValue(null);
		} catch (Exception e) {
			txtIdRefe_Referencia.setValue("");
		}

		try {
			txtIdSucu_Sucursal.setValue(null);
		} catch (Exception e) {
			txtIdSucu_Sucursal.setValue("");
		}
		
		try {
			txtFechaInicial.setValue(null);
		} catch (Exception e) {
			txtFechaInicial.setValue("");
		}
		
		try {
			txtFechaFinal.setValue(null);
		} catch (Exception e) {
			txtFechaFinal.setValue("");
		}
		
		try {
			estado.setValue(null);
		} catch (Exception e) {
			estado.setValue("");
		}
		
		return "";
	}
	

	public void rowEventListener(RowEditEvent e) {
		try {
			ListaPreciosDTO listaPreciosDTO = (ListaPreciosDTO) e.getObject();

			if (txtEspacios == null) {
				txtEspacios = new InputText();
			}

			txtEspacios.setValue(listaPreciosDTO.getEspacios());

			/*
			 * if (txtEstadoRegistro == null) { txtEstadoRegistro = new
			 * InputText(); }
			 * 
			 * txtEstadoRegistro.setValue(listaPreciosDTO.getEstadoRegistro());
			 */

			if (txtMargen == null) {
				txtMargen = new InputText();
			}

			txtMargen.setValue(listaPreciosDTO.getMargen());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(listaPreciosDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(listaPreciosDTO.getOperModifica());

			if (txtValor == null) {
				txtValor = new InputText();
			}

			txtValor.setValue(listaPreciosDTO.getValor());

			if (txtIdRefe_Referencia == null) {
				txtIdRefe_Referencia = new SelectOneMenu();
			}

			txtIdRefe_Referencia.setValue(listaPreciosDTO
					.getIdRefe_Referencia());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new SelectOneMenu();
			}

			txtIdSucu_Sucursal.setValue(listaPreciosDTO.getIdSucu_Sucursal());

			if (txtIdTili_TipoLista == null) {
				txtIdTili_TipoLista = new SelectOneMenu();
			}

			txtIdTili_TipoLista.setValue(listaPreciosDTO.getIdTili_TipoLista());

			if (txtIdLipr == null) {
				txtIdLipr = new InputText();
			}

			txtIdLipr.setValue(listaPreciosDTO.getIdLipr());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(listaPreciosDTO.getFechaCreacion());

			if (txtFechaFinal == null) {
				txtFechaFinal = new Calendar();
			}

			txtFechaFinal.setValue(listaPreciosDTO.getFechaFinal());

			if (txtFechaInicial == null) {
				txtFechaInicial = new Calendar();
			}

			txtFechaInicial.setValue(listaPreciosDTO.getFechaInicial());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(listaPreciosDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedListaPrecios = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedListaPrecios = null;

		if (txtEspacios != null) {
			txtEspacios.setValue(null);
			// txtEspacios.setDisabled(true);
		}

		/*
		 * if (txtEstadoRegistro != null) { txtEstadoRegistro.setValue(null);
		 * txtEstadoRegistro.setDisabled(true); }
		 */

		if (txtMargen != null) {
			txtMargen.setValue(null);
			// txtMargen.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			// txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			// txtOperModifica.setDisabled(true);
		}

		if (txtValor != null) {
			txtValor.setValue(null);
			// txtValor.setDisabled(true);
		}

		if (txtIdRefe_Referencia != null) {
			txtIdRefe_Referencia.setValue(null);
			// txtIdRefe_Referencia.setDisabled(true);
		}

		if (txtIdSucu_Sucursal != null) {
			txtIdSucu_Sucursal.setValue(null);
			// txtIdSucu_Sucursal.setDisabled(true);
		}

		if (txtIdTili_TipoLista != null) {
			txtIdTili_TipoLista.setValue(null);
			// txtIdTili_TipoLista.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			// txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaFinal != null) {
			txtFechaFinal.setValue(null);
			// txtFechaFinal.setDisabled(true);
		}

		if (txtFechaInicial != null) {
			txtFechaInicial.setValue(null);
			// txtFechaInicial.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			// txtFechaModificacion.setDisabled(true);
		}

		if (txtIdLipr != null) {
			txtIdLipr.setValue(null);
			// txtIdLipr.setDisabled(false);
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

	public void listener_txtFechaFinal() {
		Date inputDate = (Date) txtFechaFinal.getValue();
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

	public void listener_txtId() {
		try {
			Long idLipr = new Long(txtIdLipr.getValue().toString());
			entity = businessDelegatorView.getListaPrecios(idLipr);
		} catch (Exception e) {

		}

		if (entity == null) {
			txtEspacios.setDisabled(false);
			txtMargen.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtValor.setDisabled(false);
			txtIdRefe_Referencia.setDisabled(false);
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdTili_TipoLista.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdLipr.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtEspacios.setValue(entity.getEspacios());
			txtEspacios.setDisabled(false);
			// txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			// txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setValue(entity.getFechaFinal());
			txtFechaFinal.setDisabled(false);
			txtFechaInicial.setValue(entity.getFechaInicial());
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtMargen.setValue(entity.getMargen());
			txtMargen.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtValor.setValue(entity.getValor());
			txtValor.setDisabled(false);
			txtIdRefe_Referencia.setValue(entity.getReferencia().getIdRefe());
			txtIdRefe_Referencia.setDisabled(false);
			txtIdSucu_Sucursal.setValue(entity.getSucursal().getIdSucu());
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdTili_TipoLista.setValue(entity.getTipoLista().getIdTili());
			txtIdTili_TipoLista.setDisabled(false);
			txtIdLipr.setValue(entity.getIdLipr());
			txtIdLipr.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedListaPrecios = (ListaPreciosDTO) (evt.getComponent()
				.getAttributes().get("selectedListaPrecios"));
		txtEspacios.setValue(selectedListaPrecios.getEspacios());
		txtEspacios.setDisabled(false);
		// txtEstadoRegistro.setValue(selectedListaPrecios.getEstadoRegistro());
		// txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedListaPrecios.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaFinal.setValue(selectedListaPrecios.getFechaFinal());
		txtFechaFinal.setDisabled(false);
		txtFechaInicial.setValue(selectedListaPrecios.getFechaInicial());
		txtFechaInicial.setDisabled(false);
		txtFechaModificacion.setValue(selectedListaPrecios
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtMargen.setValue(selectedListaPrecios.getMargen());
		txtMargen.setDisabled(false);
		txtOperCreador.setValue(selectedListaPrecios.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedListaPrecios.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtValor.setValue(selectedListaPrecios.getValor());
		txtValor.setDisabled(false);
		txtIdRefe_Referencia.setValue(selectedListaPrecios
				.getIdRefe_Referencia());
		txtIdRefe_Referencia.setDisabled(false);
		txtIdSucu_Sucursal.setValue(selectedListaPrecios.getIdSucu_Sucursal());
		txtIdSucu_Sucursal.setDisabled(false);
		txtIdTili_TipoLista
				.setValue(selectedListaPrecios.getIdTili_TipoLista());
		txtIdTili_TipoLista.setDisabled(false);
		txtIdLipr.setValue(selectedListaPrecios.getIdLipr());
		txtIdLipr.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedListaPrecios == null) && (entity == null)) {
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
			entity = new ListaPrecios();

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			// Long idLipr = new Long(txtIdLipr.getValue().toString());

			entity.setEspacios(FacesUtils.checkString(txtEspacios));

			entity.setEstadoRegistro(estadoRegistro);
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setMargen(FacesUtils.checkDouble(txtMargen));
			entity.setValor(FacesUtils.checkDouble(txtValor));
			// entity.setIdLipr(idLipr);

			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			

			entity.setReferencia(businessDelegatorView.getReferencia(FacesUtils
					.checkLong(txtIdRefe_Referencia)));

			entity.setTipoLista(businessDelegatorView.getTipoLista(FacesUtils
					.checkLong(txtIdTili_TipoLista)));

			if (txtIdSucu_Sucursal.getValue() == "") {

			} else {
				entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
						.checkLong(txtIdSucu_Sucursal)));
			}

			businessDelegatorView.saveListaPrecios(entity);
			data = businessDelegatorView.getDataListaPrecios();
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
				Long idLipr = new Long(selectedListaPrecios.getIdLipr());
				entity = businessDelegatorView.getListaPrecios(idLipr);
			}
			
			Long idLipr = new Long(selectedListaPrecios.getIdLipr());
			entity = businessDelegatorView.getListaPrecios(idLipr);

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");


			entity.setEspacios(FacesUtils.checkString(txtEspacios));

			entity.setEstadoRegistro(estadoRegistro);
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setMargen(FacesUtils.checkDouble(txtMargen));
			entity.setValor(FacesUtils.checkDouble(txtValor));

			entity.setFechaModificacion(new Date());
			entity.setOperModifica(usuario);
			

			entity.setReferencia(businessDelegatorView.getReferencia(FacesUtils
					.checkLong(txtIdRefe_Referencia)));

			entity.setTipoLista(businessDelegatorView.getTipoLista(FacesUtils
					.checkLong(txtIdTili_TipoLista)));

			if (txtIdSucu_Sucursal.getValue() == "") {

			} else {
				entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
						.checkLong(txtIdSucu_Sucursal)));
			}
			
			
			
			businessDelegatorView.updateListaPrecios(entity);
			data = businessDelegatorView.getDataListaPrecios();
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
			selectedListaPrecios = (ListaPreciosDTO) (evt.getComponent()
					.getAttributes().get("selectedListaPrecios"));

			Long idLipr = new Long(selectedListaPrecios.getIdLipr());
			entity = businessDelegatorView.getListaPrecios(idLipr);
			businessDelegatorView.deleteListaPrecios(entity);
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
			selectedListaPrecios = (ListaPreciosDTO) (evt.getComponent()
					.getAttributes().get("selectedListaPrecios"));

			Long idLipr = new Long(selectedListaPrecios.getIdLipr());
			entity = businessDelegatorView.getListaPrecios(idLipr);
			businessDelegatorView.deleteListaPrecios(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedListaPrecios);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String espacios, String estadoRegistro,
			Date fechaCreacion, Date fechaFinal, Date fechaInicial,
			Date fechaModificacion, Long idLipr, Double margen,
			String operCreador, String operModifica, Double valor,
			Long idRefe_Referencia, Long idSucu_Sucursal, Long idTili_TipoLista)
			throws Exception {
		try {
			entity.setEspacios(FacesUtils.checkString(espacios));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(fechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(fechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setMargen(FacesUtils.checkDouble(margen));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setValor(FacesUtils.checkDouble(valor));
			businessDelegatorView.updateListaPrecios(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ListaPreciosView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtEspacios() {
		return txtEspacios;
	}

	public void setTxtEspacios(InputText txtEspacios) {
		this.txtEspacios = txtEspacios;
	}

	/*
	 * public InputText getTxtEstadoRegistro() { return txtEstadoRegistro; }
	 * 
	 * public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
	 * this.txtEstadoRegistro = txtEstadoRegistro; }
	 */

	public InputText getTxtMargen() {
		return txtMargen;
	}

	public void setTxtMargen(InputText txtMargen) {
		this.txtMargen = txtMargen;
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

	public InputText getTxtValor() {
		return txtValor;
	}

	public void setTxtValor(InputText txtValor) {
		this.txtValor = txtValor;
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

	public SelectOneMenu getTxtIdTili_TipoLista() {
		return txtIdTili_TipoLista;
	}

	public void setTxtIdTili_TipoLista(SelectOneMenu txtIdTili_TipoLista) {
		this.txtIdTili_TipoLista = txtIdTili_TipoLista;
	}

	public InputText getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(InputText txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaFinal() {
		return txtFechaFinal;
	}

	public void setTxtFechaFinal(Calendar txtFechaFinal) {
		this.txtFechaFinal = txtFechaFinal;
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

	public InputText getTxtIdLipr() {
		return txtIdLipr;
	}

	public void setTxtIdLipr(InputText txtIdLipr) {
		this.txtIdLipr = txtIdLipr;
	}

	public List<ListaPreciosDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataListaPrecios();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ListaPreciosDTO> listaPreciosDTO) {
		this.data = listaPreciosDTO;
	}

	public ListaPreciosDTO getSelectedListaPrecios() {
		return selectedListaPrecios;
	}

	public void setSelectedListaPrecios(ListaPreciosDTO listaPrecios) {
		this.selectedListaPrecios = listaPrecios;
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

	public String getMargen() {
		return margen;
	}

	public void setMargen(String margen) {
		this.margen = margen;
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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Long getIdRefe_Referencia() {
		return idRefe_Referencia;
	}

	public void setIdRefe_Referencia(Long idRefe_Referencia) {
		this.idRefe_Referencia = idRefe_Referencia;
	}

	public String getIdSucu_Sucursal() {
		return idSucu_Sucursal;
	}

	public void setIdSucu_Sucursal(String idSucu_Sucursal) {
		this.idSucu_Sucursal = idSucu_Sucursal;
	}

	public Long getIdTili_TipoLista() {
		return idTili_TipoLista;
	}

	public void setIdTili_TipoLista(Long idTili_TipoLista) {
		this.idTili_TipoLista = idTili_TipoLista;
	}

	public String getIdLipr() {
		return idLipr;
	}

	public void setIdLipr(String idLipr) {
		this.idLipr = idLipr;
	}

	public String getfFechaCreacion() {
		return fFechaCreacion;
	}

	public void setfFechaCreacion(String fFechaCreacion) {
		this.fFechaCreacion = fFechaCreacion;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
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

	public SelectOneMenu getEstado() {
		return estado;
	}

	public void setEstado(SelectOneMenu estado) {
		this.estado = estado;
	}

	public SelectItem[] getManufacturerOptions() {
		return manufacturerOptions;
	}

	public void setManufacturerOptions(SelectItem[] manufacturerOptions) {
		this.manufacturerOptions = manufacturerOptions;
	}

	public Map<String, String> getReferencia() {
		try {
			List<ReferenciaDTO> data2 = businessDelegatorView
					.getDataReferencia();

			for (int i = 0; i < data2.size(); i++) {
				referencia.put(data2.get(i).getCodigo(), data2.get(i)
						.getIdRefe() + "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return referencia;
	}

	public void setReferencia(Map<String, String> referencia) {
		this.referencia = referencia;
	}

	public Map<String, String> getTipoLista() {
		try {
			List<TipoListaDTO> data3 = businessDelegatorView.getDataTipoLista();

			for (int i = 0; i < data3.size(); i++) {
				tipoLista.put(data3.get(i).getCodigo(), data3.get(i)
						.getIdTili() + "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tipoLista;
	}

	public void setTipoLista(Map<String, String> tipoLista) {
		this.tipoLista = tipoLista;
	}

	public Map<String, String> getSucursal() {
		try {
			List<SucursalDTO> data4 = businessDelegatorView.getDataSucursal();

			for (int i = 0; i < data4.size(); i++) {
				sucursal.put(data4.get(i).getNombre(), data4.get(i).getIdSucu()
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

	public CommandButton getBtnModify2() {
		return btnModify2;
	}

	public void setBtnModify2(CommandButton btnModify2) {
		this.btnModify2 = btnModify2;
	}

}
