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
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.Empresa;
import co.edu.usbcali.modelo.Persona;
import co.edu.usbcali.modelo.RelacionComercial;
import co.edu.usbcali.modelo.Sucursal;
import co.edu.usbcali.modelo.dto.EmpresaDTO;
import co.edu.usbcali.modelo.dto.PersonaDTO;
import co.edu.usbcali.modelo.dto.RelacionComercialDTO;
import co.edu.usbcali.modelo.dto.SucursalDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class RelacionComercialView {
	private SelectOneMenu estado;
	private InputText txtLimiteCredito;
	private SelectOneMenu txtLiquidaIva;
	private InputTextarea txtObservacion;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private SelectOneMenu txtIdEmpr_Empresa;
	private SelectOneMenu txtIdPers_Persona;
	private SelectOneMenu txtIdSucu_Sucursal;
	private SelectOneMenu txtIdSucu_SucursalH;
	private InputText txtIdReco;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;
	
	private String estadoRegistro;
	private String limiteCredito;
	private String liquidaIva;
	private String observacion;
	private String operCreador;
	private String operModifica;
	private String idEmpr_Empresa;
	private String idPers_Persona;
	private String idSucu_Sucursal;
	private String idSucu_SucursalH;
	private String idReco;
	private String fechaCreacion;
	private String fechaModificacion;
	
	private Map<String, String> persona = new HashMap<String, String>();
	private Map<String, String> empresa = new HashMap<String, String>();
	private Map<String, String> sucursal = new HashMap<String, String>();
	private Map<String, String> sucursal2 = new HashMap<String, String>();
	
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnModify2;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<RelacionComercialDTO> data;
	private RelacionComercialDTO selectedRelacionComercial;
	private RelacionComercial entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private SelectItem[] manufacturerOptions;
	private SelectItem[] manufacturerOptions2;

	String manufacturers[] = { "A", "R" };
	String manufacturers2[] = { "S", "N" };
	

	public RelacionComercialView() {
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
			
			try {
				empresa =  new HashMap<String, String>();
				List<EmpresaDTO> data4 = businessDelegatorView
						.getDataEmpresa();

				for (int i = 0; i < data4.size(); i++) {
					empresa.put(data4.get(i).getNombre(), data4.get(i)
							.getIdEmpr() + "");

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			

			entity = null;
			entity = businessDelegatorView.getRelacionComercial(((RelacionComercialDTO) event
					.getObject()).getIdReco());

			entity.setEstadoRegistro(estadoRegistro);
			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);
			entity.setFechaModificacion(new Date());

			System.out.println("0: " + liquidaIva + " 0: " + txtLiquidaIva.getValue());
			entity.setLiquidaIva(liquidaIva);
			
			//String liquidaIva = new String(txtLiquidaIva.getValue().toString());			
			//System.out.println("liquida iva= " + liquidaIva);
			//entity.setLiquidaIva(liquidaIva);
			
			entity.setLimiteCredito(((RelacionComercialDTO) event.getObject())
					.getLimiteCredito());
			entity.setObservacion(((RelacionComercialDTO) event.getObject())
					.getObservacion());
			
//							Llaves foraneas	
			
			Empresa entity2 =  businessDelegatorView.getEmpresa(Long.parseLong(idEmpr_Empresa));
			
			System.out.println("Empresa 1: " + txtIdEmpr_Empresa.getValue() +" 2: " + entity2);
	
			if (entity2 == null) {
				System.out.println("entro cero 1");
			entity.setEmpresa(null);
				
			}else {
				entity.setEmpresa(entity2);
				
				/*entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
						.checkLong(txtIdEmpr_Empresa)));*/
			}
			
	
			
			Persona entity3 = businessDelegatorView.getPersona(Long.parseLong(idPers_Persona));
			System.out.println("Persona2: " + txtIdPers_Persona.getValue() +" 2: " + entity2);
			
			if (entity3 == null) {
				System.out.println("entro cero2");
				entity.setPersona(null);
			}else {
				
				entity.setPersona(entity3);
				/*entity.setPersona(businessDelegatorView.getPersona(FacesUtils
						.checkLong(txtIdPers_Persona)));*/
			}
			
	
			
			Sucursal entity4 = businessDelegatorView.getSucursal(Long.parseLong(idSucu_SucursalH));
			
			System.out.println("Sucursal 3: " + txtIdSucu_SucursalH.getValue() +" 2: " + entity4);
			
			if (entity4 == null) {
				
				System.out.println("entro cero 3");
				entity.setSucursalBySucursalHija(null);
			}else {
				
				entity.setSucursalBySucursalHija(entity4);
				/*entity.setSucursalBySucursalHija(businessDelegatorView.getSucursal(FacesUtils
						.checkLong(txtIdSucu_SucursalH)));*/
			}
			
	
			System.out.println("4: " + txtIdSucu_Sucursal.getValue());
			
			Sucursal entity6 = businessDelegatorView.getSucursal(Long.parseLong(idSucu_Sucursal));
			
			if (entity6 == null) {
				System.out.println("Entro en null");
				
				entity.setSucursalBySucursalPadre(businessDelegatorView.getSucursal(FacesUtils.checkLong(txtIdSucu_Sucursal)));
			}else {
				System.out.println("entro con algo");
				
				entity.setSucursalBySucursalPadre(entity6);
				
			}
			
			/*entity.setSucursalBySucursalPadre(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));*/
			
			

			
			
			
			businessDelegatorView.updateRelacionComercial(entity);
			data = businessDelegatorView.getDataRelacionComercial();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
			

		} catch (Exception e) {
			e.printStackTrace();
			FacesUtils.addErrorMessage(e.getMessage());
			
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("TipoEstado Cancelled",
				((RelacionComercialDTO) event.getObject()).getIdReco() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((RelacionComercialDTO) event.getObject()).getIdReco());
	}
	
	
	public String action_modify2() {
		try {
			
			btnSave.setDisabled(true);
			btnModify.setDisabled(false);
		
			
			try {
				txtLimiteCredito.setValue(selectedRelacionComercial.getLimiteCredito());				

			} catch (Exception e) {
				txtLimiteCredito.setValue("");
			}
			
			try {
				txtLiquidaIva.setValue(selectedRelacionComercial.getLiquidaIva());				

			} catch (Exception e) {
				txtLiquidaIva.setValue("");
			}
			
			
			
			try {
				txtObservacion.setValue(selectedRelacionComercial.getObservacion());				

			} catch (Exception e) {
				txtObservacion.setValue("");
			}

			try {
				txtIdEmpr_Empresa.setValue(selectedRelacionComercial.getIdEmpr_Empresa());
			} catch (Exception e) {
				txtIdEmpr_Empresa.setValue("");
			}

			try {
				txtIdPers_Persona.setValue(selectedRelacionComercial.getIdPers_Persona());
			} catch (Exception e) {
				txtIdPers_Persona.setValue("");
			}

			try {
				txtIdSucu_Sucursal.setValue(selectedRelacionComercial.getIdSucu_Sucursal());
			} catch (Exception e) {
				txtIdSucu_Sucursal.setValue("");
			}

			try {
				txtIdSucu_SucursalH.setValue(selectedRelacionComercial.getIdSucu_SucursalH());
			} catch (Exception e) {
				txtIdSucu_SucursalH.setValue("");
			}
			
			try {
				estado.setValue(selectedRelacionComercial.getEstadoRegistro());
			} catch (Exception e) {
				estado.setValue("");
			}
			
			
			txtIdReco.setValue(selectedRelacionComercial.getIdReco());

		} catch (Exception e) {
			if (selectedRelacionComercial == null) {				
				FacesUtils
						.addErrorMessage("Seleccione Relacion Comercial a modificar");
			}
		}
		return "";

	}
	
	
	public String action_VCrear(){
		
		btnModify.setDisabled(true);
		btnSave.setDisabled(false);
		
		try {
			txtLimiteCredito.setValue(null);				

		} catch (Exception e) {
			txtLimiteCredito.setValue("");
		}
		
		try {
			txtLiquidaIva.setValue(null);				

		} catch (Exception e) {
			txtLiquidaIva.setValue("");
		}
				
		
		try {
			txtObservacion.setValue(null);				

		} catch (Exception e) {
			txtObservacion.setValue("");
		}

		try {
			txtIdEmpr_Empresa.setValue(null);
		} catch (Exception e) {
			txtIdEmpr_Empresa.setValue("");
		}

		try {
			txtIdPers_Persona.setValue(null);
		} catch (Exception e) {
			txtIdPers_Persona.setValue("");
		}

		try {
			txtIdSucu_Sucursal.setValue(null);
		} catch (Exception e) {
			txtIdSucu_Sucursal.setValue("");
		}

		try {
			txtIdSucu_SucursalH.setValue(null);
		} catch (Exception e) {
			txtIdSucu_SucursalH.setValue("");
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
			RelacionComercialDTO relacionComercialDTO = (RelacionComercialDTO) e
					.getObject();

			/*if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro
					.setValue(relacionComercialDTO.getEstadoRegistro());*/

			if (txtLimiteCredito == null) {
				txtLimiteCredito = new InputText();
			}

			txtLimiteCredito.setValue(relacionComercialDTO.getLimiteCredito());

			if (txtLiquidaIva == null) {
				txtLiquidaIva = new SelectOneMenu();
			}

			txtLiquidaIva.setValue(relacionComercialDTO.getLiquidaIva());

			if (txtObservacion == null) {
				txtObservacion = new InputTextarea();
			}

			txtObservacion.setValue(relacionComercialDTO.getObservacion());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(relacionComercialDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(relacionComercialDTO.getOperModifica());

			if (txtIdEmpr_Empresa == null) {
				txtIdEmpr_Empresa = new SelectOneMenu();
			}

			txtIdEmpr_Empresa
					.setValue(relacionComercialDTO.getIdEmpr_Empresa());

			if (txtIdPers_Persona == null) {
				txtIdPers_Persona = new SelectOneMenu();
			}

			txtIdPers_Persona
					.setValue(relacionComercialDTO.getIdPers_Persona());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new SelectOneMenu();
			}

			if (txtIdReco == null) {
				txtIdReco = new InputText();
			}

			txtIdReco.setValue(relacionComercialDTO.getIdReco());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(relacionComercialDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(relacionComercialDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedRelacionComercial = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedRelacionComercial = null;

		/*if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}
*/
		if (txtLimiteCredito != null) {
			txtLimiteCredito.setValue(null);
			//txtLimiteCredito.setDisabled(true);
		}

		if (txtLiquidaIva != null) {
			txtLiquidaIva.setValue(null);
			//txtLiquidaIva.setDisabled(true);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			//txtObservacion.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			//txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			//txtOperModifica.setDisabled(true);
		}

		if (txtIdEmpr_Empresa != null) {
			txtIdEmpr_Empresa.setValue(null);
			//txtIdEmpr_Empresa.setDisabled(true);
		}

		if (txtIdPers_Persona != null) {
			txtIdPers_Persona.setValue(null);
			//txtIdPers_Persona.setDisabled(true);
		}

		if (txtIdSucu_Sucursal != null) {
			txtIdSucu_Sucursal.setValue(null);
			//txtIdSucu_Sucursal.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			//txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			//txtFechaModificacion.setDisabled(true);
		}

		if (txtIdReco != null) {
			txtIdReco.setValue(null);
			//txtIdReco.setDisabled(false);
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
			Long idReco = new Long(txtIdReco.getValue().toString());
			entity = businessDelegatorView.getRelacionComercial(idReco);
		} catch (Exception e) {
			
		}

		if (entity == null) {
			txtLimiteCredito.setDisabled(false);
			txtLiquidaIva.setDisabled(false);
			txtObservacion.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdEmpr_Empresa.setDisabled(false);
			txtIdPers_Persona.setDisabled(false);
			txtIdSucu_Sucursal.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdReco.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			//txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			//txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtLimiteCredito.setValue(entity.getLimiteCredito());
			txtLimiteCredito.setDisabled(false);
			txtLiquidaIva.setValue(entity.getLiquidaIva());
			txtLiquidaIva.setDisabled(false);
			txtObservacion.setValue(entity.getObservacion());
			txtObservacion.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdEmpr_Empresa.setValue(entity.getEmpresa().getIdEmpr());
			txtIdEmpr_Empresa.setDisabled(false);
			txtIdPers_Persona.setValue(entity.getPersona().getIdPers());
			txtIdPers_Persona.setDisabled(false);

			txtIdSucu_Sucursal.setDisabled(false);
			txtIdReco.setValue(entity.getIdReco());
			txtIdReco.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedRelacionComercial = (RelacionComercialDTO) (evt.getComponent()
				.getAttributes().get("selectedRelacionComercial"));
		/*txtEstadoRegistro.setValue(selectedRelacionComercial
				.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);*/
		txtFechaCreacion.setValue(selectedRelacionComercial.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedRelacionComercial
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtLimiteCredito.setValue(selectedRelacionComercial.getLimiteCredito());
		txtLimiteCredito.setDisabled(false);
		txtLiquidaIva.setValue(selectedRelacionComercial.getLiquidaIva());
		txtLiquidaIva.setDisabled(false);
		txtObservacion.setValue(selectedRelacionComercial.getObservacion());
		txtObservacion.setDisabled(false);
		txtOperCreador.setValue(selectedRelacionComercial.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedRelacionComercial.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdEmpr_Empresa.setValue(selectedRelacionComercial
				.getIdEmpr_Empresa());
		txtIdEmpr_Empresa.setDisabled(false);
		txtIdPers_Persona.setValue(selectedRelacionComercial
				.getIdPers_Persona());
		txtIdPers_Persona.setDisabled(false);

		txtIdSucu_Sucursal.setDisabled(false);
		txtIdReco.setValue(selectedRelacionComercial.getIdReco());
		txtIdReco.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedRelacionComercial == null) && (entity == null)) {
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
			entity = new RelacionComercial();

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");
			//Long idReco = new Long(txtIdReco.getValue().toString());

			//entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			entity.setEstadoRegistro(estadoRegistro);
			
			//entity.setIdReco(idReco);
			
			//entity.setLiquidaIva(FacesUtils.checkString(txtLiquidaIva));
			
			String liquidaIva = new String(txtLiquidaIva.getValue().toString());
			entity.setLiquidaIva(liquidaIva);
			
			
			entity.setLimiteCredito(FacesUtils.checkDouble(txtLimiteCredito));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));						
			
			//Llaves foraneas
			
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
			
			
			if (txtIdSucu_SucursalH.getValue() == "") {
				
			}else {
				entity.setSucursalBySucursalHija(businessDelegatorView.getSucursal(FacesUtils
						.checkLong(txtIdSucu_SucursalH)));
			}
			
			
			entity.setSucursalBySucursalPadre(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			
			
			

			businessDelegatorView.saveRelacionComercial(entity);
			data = businessDelegatorView.getDataRelacionComercial();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
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
				Long idReco = new Long(selectedRelacionComercial.getIdReco());
				entity = businessDelegatorView.getRelacionComercial(idReco);
			}
			Long idReco = new Long(selectedRelacionComercial.getIdReco());
			entity = businessDelegatorView.getRelacionComercial(idReco);
			
			
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			entity.setFechaModificacion(new Date());
			entity.setOperModifica(usuario);
			entity.setEstadoRegistro(estadoRegistro);
			
			
			String liquidaIva = new String(txtLiquidaIva.getValue().toString());
			entity.setLiquidaIva(liquidaIva);
			
			
			entity.setLimiteCredito(FacesUtils.checkDouble(txtLimiteCredito));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));						
			
			//Llaves foraneas
			
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
			
			
			if (txtIdSucu_SucursalH.getValue() == "") {
				
			}else {
				entity.setSucursalBySucursalHija(businessDelegatorView.getSucursal(FacesUtils
						.checkLong(txtIdSucu_SucursalH)));
			}
			
			
			entity.setSucursalBySucursalPadre(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			

			businessDelegatorView.updateRelacionComercial(entity);
			data = businessDelegatorView.getDataRelacionComercial();
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
			selectedRelacionComercial = (RelacionComercialDTO) (evt
					.getComponent().getAttributes()
					.get("selectedRelacionComercial"));

			Long idReco = new Long(selectedRelacionComercial.getIdReco());
			entity = businessDelegatorView.getRelacionComercial(idReco);
			businessDelegatorView.deleteRelacionComercial(entity);
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
			selectedRelacionComercial = (RelacionComercialDTO) (evt
					.getComponent().getAttributes()
					.get("selectedRelacionComercial"));

			Long idReco = new Long(selectedRelacionComercial.getIdReco());
			entity = businessDelegatorView.getRelacionComercial(idReco);
			businessDelegatorView.deleteRelacionComercial(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedRelacionComercial);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idReco,
			Double limiteCredito, String liquidaIva, String observacion,
			String operCreador, String operModifica, Long idEmpr_Empresa,
			Long idPers_Persona, Long idSucu_Sucursal, Long idSucu_Sucursal0)
			throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setLimiteCredito(FacesUtils.checkDouble(limiteCredito));
			entity.setLiquidaIva(FacesUtils.checkString(liquidaIva));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateRelacionComercial(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("RelacionComercialView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	/*public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}*/

	public InputText getTxtLimiteCredito() {
		return txtLimiteCredito;
	}

	public void setTxtLimiteCredito(InputText txtLimiteCredito) {
		this.txtLimiteCredito = txtLimiteCredito;
	}

	public SelectOneMenu getTxtLiquidaIva() {
		return txtLiquidaIva;
	}

	public void setTxtLiquidaIva(SelectOneMenu txtLiquidaIva) {
		this.txtLiquidaIva = txtLiquidaIva;
	}

	public InputTextarea getTxtObservacion() {
		return txtObservacion;
	}

	public void setTxtObservacion(InputTextarea txtObservacion) {
		this.txtObservacion = txtObservacion;
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

	public InputText getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(InputText txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public InputText getTxtIdReco() {
		return txtIdReco;
	}

	public void setTxtIdReco(InputText txtIdReco) {
		this.txtIdReco = txtIdReco;
	}

	public List<RelacionComercialDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataRelacionComercial();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<RelacionComercialDTO> relacionComercialDTO) {
		this.data = relacionComercialDTO;
	}

	public RelacionComercialDTO getSelectedRelacionComercial() {
		return selectedRelacionComercial;
	}

	public void setSelectedRelacionComercial(
			RelacionComercialDTO relacionComercial) {
		this.selectedRelacionComercial = relacionComercial;
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

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(String limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public String getLiquidaIva() {
		return liquidaIva;
	}

	public void setLiquidaIva(String liquidaIva) {
		this.liquidaIva = liquidaIva;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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

	public String getIdSucu_Sucursal() {
		return idSucu_Sucursal;
	}

	public void setIdSucu_Sucursal(String idSucu_Sucursal) {
		this.idSucu_Sucursal = idSucu_Sucursal;
	}

	public String getIdReco() {
		return idReco;
	}

	public void setIdReco(String idReco) {
		this.idReco = idReco;
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


	public String getIdSucu_SucursalH() {
		return idSucu_SucursalH;
	}


	public void setIdSucu_SucursalH(String idSucu_SucursalH) {
		this.idSucu_SucursalH = idSucu_SucursalH;
	}


	public SelectOneMenu getTxtIdSucu_SucursalH() {
		return txtIdSucu_SucursalH;
	}


	public void setTxtIdSucu_SucursalH(SelectOneMenu txtIdSucu_SucursalH) {
		this.txtIdSucu_SucursalH = txtIdSucu_SucursalH;
	}


	public Map<String, String> getSucursal2() {

		try {
			List<SucursalDTO> data5 = businessDelegatorView
					.getDataSucursal();

			for (int i = 0; i < data5.size(); i++) {
				sucursal2.put(data5.get(i).getCodigo(), data5.get(i)
						.getIdSucu() + "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return sucursal2;
	}


	public void setSucursal2(Map<String, String> sucursal2) {
		this.sucursal2 = sucursal2;
	}


	public CommandButton getBtnModify2() {
		return btnModify2;
	}


	public void setBtnModify2(CommandButton btnModify2) {
		this.btnModify2 = btnModify2;
	}
	
	
}
