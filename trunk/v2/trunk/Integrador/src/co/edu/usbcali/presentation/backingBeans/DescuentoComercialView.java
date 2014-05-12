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
import co.edu.usbcali.modelo.DescuentoComercial;
import co.edu.usbcali.modelo.Empresa;
import co.edu.usbcali.modelo.Grupo;
import co.edu.usbcali.modelo.Persona;
import co.edu.usbcali.modelo.Sucursal;
import co.edu.usbcali.modelo.dto.DescuentoComercialDTO;
import co.edu.usbcali.modelo.dto.EmpresaDTO;
import co.edu.usbcali.modelo.dto.GrupoDTO;
import co.edu.usbcali.modelo.dto.PersonaDTO;
import co.edu.usbcali.modelo.dto.SucursalDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class DescuentoComercialView {
	private InputText txtAsocGrupoItem;
	private InputText txtCreadoAutomatico;
	private InputTextarea txtEspacios;
	private SelectOneMenu txtEstadoPlano;
	private SelectOneMenu estado;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtPorcDescItem;
	private InputText txtPorcDescMaxItem;
	private InputText txtPorcDescMinItem;
	private InputText txtTipoAsocGrupoItem;
	private InputText txtTodasSucursales;
	private SelectOneMenu txtIdEmpr_Empresa;
	private SelectOneMenu txtIdGrpo_Grupo;
	private SelectOneMenu txtIdPers_Persona;
	private SelectOneMenu txtIdSucu_Sucursal;
	private SelectOneMenu txtIdSucu_SucursalH;
	private InputText txtIdDeco;
	private InputText txtFechaCreacion;
	private Calendar txtFechaFinal;
	private Calendar txtFechaInicial;
	private InputText txtFechaModificacion;

	private String asocGrupoItem;
	private String creadoAutomatico;
	private String espacios;
	private String estadoPlano;
	private String estadoRegistro;
	private String operCreador;
	private String operModifica;
	private String porcDescItem;
	private String porcDescMaxItem;
	private String porcDescMinItem;
	private String tipoAsocGrupoItem;
	private String todasSucursales;
	private String idEmpr_Empresa;
	private String idGrpo_Grupo;
	private String idPers_Persona;
	private String idSucu_Sucursal;
	private String idSucu_SucursalH;
	private String idDeco;
	private String fechaCreacion;
	private String fechaFinal;
	private String fechaInicial;
	private String fechaModificacion;

	private Map<String, String> persona = new HashMap<String, String>();
	private Map<String, String> empresa = new HashMap<String, String>();
	private Map<String, String> sucursal = new HashMap<String, String>();
	private Map<String, String> sucursal2 = new HashMap<String, String>();
	private Map<String, String> grupo = new HashMap<String, String>();

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnModify2;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DescuentoComercialDTO> data;
	private DescuentoComercialDTO selectedDescuentoComercial;
	private DescuentoComercial entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private SelectItem[] manufacturerOptions;
	private SelectItem[] manufacturerOptions2;

	String manufacturers[] = { "A", "R" };
	String manufacturers2[] = { "1", "'0" };

	public DescuentoComercialView() {
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
					.getDescuentoComercial(((DescuentoComercialDTO) event
							.getObject()).getIdDeco());

			entity.setEstadoRegistro(estadoRegistro);
			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);
			entity.setFechaModificacion(new Date());

			entity.setEstadoPlano(((DescuentoComercialDTO) event.getObject())
					.getEstadoPlano());

			Date fechaInicial = ((DescuentoComercialDTO) event.getObject())
					.getFechaInicial();
			entity.setFechaInicial(fechaInicial);
			Date fechaFinal = ((DescuentoComercialDTO) event.getObject())
					.getFechaFinal();
			entity.setFechaFinal(fechaFinal);

			entity.setEspacios(((DescuentoComercialDTO) event.getObject())
					.getEspacios());

			entity.setCreadoAutomatico(((DescuentoComercialDTO) event
					.getObject()).getCreadoAutomatico());

			entity.setTodasSucursales(((DescuentoComercialDTO) event
					.getObject()).getTodasSucursales());

			entity.setTipoAsocGrupoItem(((DescuentoComercialDTO) event
					.getObject()).getTipoAsocGrupoItem());

			entity.setAsocGrupoItem(((DescuentoComercialDTO) event.getObject())
					.getAsocGrupoItem());

			entity.setPorcDescMinItem(((DescuentoComercialDTO) event
					.getObject()).getPorcDescMinItem());

			entity.setPorcDescItem(((DescuentoComercialDTO) event.getObject())
					.getPorcDescItem());

			entity.setPorcDescMaxItem(((DescuentoComercialDTO) event
					.getObject()).getPorcDescMaxItem());

			// Llaves foraneas

			Empresa entity4 = businessDelegatorView.getEmpresa(Long
					.parseLong(idEmpr_Empresa));

			System.out.println("\nEmpresa 1: " + txtIdEmpr_Empresa.getValue());

			if (entity4 == null) {
				System.out.println("entro cero Empresa");
				entity.setEmpresa(null);

			} else {
				entity.setEmpresa(entity4);

				/*
				 * entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
				 * .checkLong(txtIdEmpr_Empresa)));
				 */
			}

			Persona entity2 = businessDelegatorView.getPersona(Long
					.parseLong(idPers_Persona));
			System.out.println("\nPersona2: " + txtIdPers_Persona.getValue());

			if (entity2 == null) {
				System.out.println("entro cero Persona");
				entity.setPersona(null);
			} else {

				entity.setPersona(entity2);
				/*
				 * entity.setPersona(businessDelegatorView.getPersona(FacesUtils
				 * .checkLong(txtIdPers_Persona)));
				 */
			}

			Sucursal entity6 = businessDelegatorView.getSucursal(Long
					.parseLong(idSucu_SucursalH));

			System.out
					.println("\nSucursalH: " + txtIdSucu_SucursalH.getValue());

			if (entity6 == null) {

				System.out.println("entro cero SucursalH");
				entity.setSucursalByIdSucu(null);
			} else {

				entity.setSucursalByIdSucu(entity6);
				/*
				 * entity.setSucursalBySucursalHija(businessDelegatorView.
				 * getSucursal(FacesUtils .checkLong(txtIdSucu_SucursalH)));
				 */
			}

			Sucursal entity3 = businessDelegatorView.getSucursal(Long
					.parseLong(idSucu_Sucursal));

			System.out.println("\nSucursalP: " + txtIdSucu_Sucursal.getValue()
					+ "; " + idSucu_Sucursal);

			if (entity3 == null) {

				System.out.println("entro cero sucuP");
				entity.setSucursalByIdSucu(null);
			} else {

				entity.setSucursalBySucursal(entity3);
			}
			/*
			 * entity.setSucursalBySucursal(businessDelegatorView.getSucursal(
			 * FacesUtils .checkLong(txtIdSucu_Sucursal)));
			 */

			Grupo entity5 = businessDelegatorView.getGrupo(Long
					.parseLong(idGrpo_Grupo));

			System.out.println("\ntxt grupo: " + txtIdGrpo_Grupo.getValue()
					+ "; " + idGrpo_Grupo);

			if (entity5 == null) {

				System.out.println("entro cero 3");
				entity.setGrupo(null);
				;
			} else {

				entity.setGrupo(entity5);

			}
			/*
			 * entity.setGrupo(businessDelegatorView.getGrupo(FacesUtils
			 * .checkLong(txtIdGrpo_Grupo)));
			 */

			businessDelegatorView.updateDescuentoComercial(entity);
			data = businessDelegatorView.getDataDescuentoComercial();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
			FacesUtils.addErrorMessage(e.getMessage());

		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("TipoEstado Cancelled",
				((DescuentoComercialDTO) event.getObject()).getIdDeco() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((DescuentoComercialDTO) event.getObject()).getIdDeco());
	}

	public String action_modify2() {

		try {

			btnSave.setDisabled(true);
			btnModify.setDisabled(false);
			
			
			try {
				txtEstadoPlano.setValue(selectedDescuentoComercial
						.getEstadoPlano());
			} catch (Exception e) {
				txtEstadoPlano.setValue("");
			}
			
			try {
				txtIdEmpr_Empresa.setValue(selectedDescuentoComercial
						.getIdEmpr_Empresa());
			} catch (Exception e) {
				txtIdEmpr_Empresa.setValue("");
			}
			
			try {
				txtIdGrpo_Grupo.setValue(selectedDescuentoComercial
						.getIdGrpo_Grupo());
			} catch (Exception e) {
				txtIdGrpo_Grupo.setValue("");
			}
			
			try {
				txtIdPers_Persona.setValue(selectedDescuentoComercial
						.getIdPers_Persona());
			} catch (Exception e) {
				txtIdPers_Persona.setValue("");
			}
			
			try {
				txtIdSucu_Sucursal.setValue(selectedDescuentoComercial
						.getIdSucu_Sucursal());
			} catch (Exception e) {
				txtIdSucu_Sucursal.setValue("");
			}
			
			try {
				txtIdSucu_SucursalH.setValue(selectedDescuentoComercial
						.getIdSucu_SucursalH());
			} catch (Exception e) {
				txtIdSucu_SucursalH.setValue("");
			}
			

			try {
				txtAsocGrupoItem.setValue(selectedDescuentoComercial
						.getAsocGrupoItem());
			} catch (Exception e) {
				txtAsocGrupoItem.setValue("");
			}

			try {
				txtCreadoAutomatico.setValue(selectedDescuentoComercial
						.getCreadoAutomatico());
			} catch (Exception e) {
				txtCreadoAutomatico.setValue("");
			}

			try {
				txtEspacios.setValue(selectedDescuentoComercial.getEspacios());
			} catch (Exception e) {
				txtEspacios.setValue("");
			}

			try {
				txtPorcDescItem.setValue(selectedDescuentoComercial
						.getPorcDescItem());
			} catch (Exception e) {
				txtPorcDescItem.setValue("");
			}

			try {
				txtPorcDescMaxItem.setValue(selectedDescuentoComercial
						.getPorcDescMaxItem());
			} catch (Exception e) {
				txtPorcDescMaxItem.setValue("");
			}

			try {
				txtPorcDescMinItem.setValue(selectedDescuentoComercial
						.getPorcDescMinItem());
			} catch (Exception e) {
				txtPorcDescMinItem.setValue("");
			}

			try {
				txtTipoAsocGrupoItem.setValue(selectedDescuentoComercial
						.getTipoAsocGrupoItem());
			} catch (Exception e) {
				txtTipoAsocGrupoItem.setValue("");
			}

			try {
				txtTodasSucursales.setValue(selectedDescuentoComercial
						.getTodasSucursales());
			} catch (Exception e) {
				txtTodasSucursales.setValue("");
			}

			try {
				estado.setValue(selectedDescuentoComercial.getEstadoRegistro());
			} catch (Exception e) {
				estado.setValue("");
			}

			txtFechaInicial.setValue(selectedDescuentoComercial
					.getFechaInicial());
			txtFechaFinal.setValue(selectedDescuentoComercial.getFechaFinal());

			txtIdDeco.setValue(selectedDescuentoComercial.getIdDeco());

		} catch (Exception e) {
			if (selectedDescuentoComercial == null) {
				// btnCrear.setDisabled(true);
				// btnModify2.setDisabled(true);
				// action_cerrar();
				FacesUtils
						.addErrorMessage("Seleccione Descuento Comercial a modificar");
			}
		}

		return "";
	}

	public String action_VCrear() {

		btnModify.setDisabled(true);
		btnSave.setDisabled(false);
		
		try {
			txtEstadoPlano.setValue(null);
		} catch (Exception e) {
			txtEstadoPlano.setValue("");
		}
		
		try {
			txtIdEmpr_Empresa.setValue(null);
		} catch (Exception e) {
			txtIdEmpr_Empresa.setValue("");
		}
		
		try {
			txtIdGrpo_Grupo.setValue(null);
		} catch (Exception e) {
			txtIdGrpo_Grupo.setValue("");
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
			txtAsocGrupoItem.setValue(null);
		} catch (Exception e) {
			txtAsocGrupoItem.setValue("");
		}

		try {
			txtCreadoAutomatico.setValue(null);
		} catch (Exception e) {
			txtCreadoAutomatico.setValue("");
		}

		try {
			txtEspacios.setValue(null);
		} catch (Exception e) {
			txtEspacios.setValue("");
		}

		try {
			txtPorcDescItem.setValue(null);
		} catch (Exception e) {
			txtPorcDescItem.setValue("");
		}

		try {
			txtPorcDescMaxItem.setValue(null);
		} catch (Exception e) {
			txtPorcDescMaxItem.setValue("");
		}

		try {
			txtPorcDescMinItem.setValue(null);
		} catch (Exception e) {
			txtPorcDescMinItem.setValue("");
		}

		try {
			txtTipoAsocGrupoItem.setValue(null);
		} catch (Exception e) {
			txtTipoAsocGrupoItem.setValue("");
		}

		try {
			txtTodasSucursales.setValue(null);
		} catch (Exception e) {
			txtTodasSucursales.setValue("");
		}
		
		txtFechaInicial.setValue(null);
		txtFechaFinal.setValue(null);

		return "";
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DescuentoComercialDTO descuentoComercialDTO = (DescuentoComercialDTO) e
					.getObject();

			if (txtAsocGrupoItem == null) {
				txtAsocGrupoItem = new InputText();
			}

			txtAsocGrupoItem.setValue(descuentoComercialDTO.getAsocGrupoItem());

			if (txtCreadoAutomatico == null) {
				txtCreadoAutomatico = new InputText();
			}

			txtCreadoAutomatico.setValue(descuentoComercialDTO
					.getCreadoAutomatico());

			if (txtEspacios == null) {
				txtEspacios = new InputTextarea();
			}

			txtEspacios.setValue(descuentoComercialDTO.getEspacios());

			if (txtEstadoPlano == null) {
				txtEstadoPlano = new SelectOneMenu();
			}

			txtEstadoPlano.setValue(descuentoComercialDTO.getEstadoPlano());

			/*
			 * if (txtEstadoRegistro == null) { txtEstadoRegistro = new
			 * InputText(); }
			 * 
			 * txtEstadoRegistro.setValue(descuentoComercialDTO
			 * .getEstadoRegistro());
			 */

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(descuentoComercialDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(descuentoComercialDTO.getOperModifica());

			if (txtPorcDescItem == null) {
				txtPorcDescItem = new InputText();
			}

			txtPorcDescItem.setValue(descuentoComercialDTO.getPorcDescItem());

			if (txtPorcDescMaxItem == null) {
				txtPorcDescMaxItem = new InputText();
			}

			txtPorcDescMaxItem.setValue(descuentoComercialDTO
					.getPorcDescMaxItem());

			if (txtPorcDescMinItem == null) {
				txtPorcDescMinItem = new InputText();
			}

			txtPorcDescMinItem.setValue(descuentoComercialDTO
					.getPorcDescMinItem());

			if (txtTipoAsocGrupoItem == null) {
				txtTipoAsocGrupoItem = new InputText();
			}

			txtTipoAsocGrupoItem.setValue(descuentoComercialDTO
					.getTipoAsocGrupoItem());

			if (txtTodasSucursales == null) {
				txtTodasSucursales = new InputText();
			}

			txtTodasSucursales.setValue(descuentoComercialDTO
					.getTodasSucursales());

			if (txtIdEmpr_Empresa == null) {
				txtIdEmpr_Empresa = new SelectOneMenu();
			}

			txtIdEmpr_Empresa.setValue(descuentoComercialDTO
					.getIdEmpr_Empresa());

			if (txtIdGrpo_Grupo == null) {
				txtIdGrpo_Grupo = new SelectOneMenu();
			}

			txtIdGrpo_Grupo.setValue(descuentoComercialDTO.getIdGrpo_Grupo());

			if (txtIdPers_Persona == null) {
				txtIdPers_Persona = new SelectOneMenu();
			}

			txtIdPers_Persona.setValue(descuentoComercialDTO
					.getIdPers_Persona());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new SelectOneMenu();
			}

			if (txtIdDeco == null) {
				txtIdDeco = new InputText();
			}

			txtIdDeco.setValue(descuentoComercialDTO.getIdDeco());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(descuentoComercialDTO.getFechaCreacion());

			if (txtFechaFinal == null) {
				txtFechaFinal = new Calendar();
			}

			txtFechaFinal.setValue(descuentoComercialDTO.getFechaFinal());

			if (txtFechaInicial == null) {
				txtFechaInicial = new Calendar();
			}

			txtFechaInicial.setValue(descuentoComercialDTO.getFechaInicial());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(descuentoComercialDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedDescuentoComercial = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDescuentoComercial = null;

		if (txtAsocGrupoItem != null) {
			txtAsocGrupoItem.setValue(null);
			// txtAsocGrupoItem.setDisabled(true);
		}

		if (txtCreadoAutomatico != null) {
			txtCreadoAutomatico.setValue(null);
			// txtCreadoAutomatico.setDisabled(true);
		}

		if (txtEspacios != null) {
			txtEspacios.setValue(null);
			// txtEspacios.setDisabled(true);
		}

		if (txtEstadoPlano != null) {
			txtEstadoPlano.setValue(null);
			// txtEstadoPlano.setDisabled(true);
		}

		/*
		 * if (txtEstadoRegistro != null) { txtEstadoRegistro.setValue(null);
		 * txtEstadoRegistro.setDisabled(true); }
		 */

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			// txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			// txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtPorcDescItem != null) {
			txtPorcDescItem.setValue(null);
			// txtPorcDescItem.setDisabled(true);
		}

		if (txtPorcDescMaxItem != null) {
			txtPorcDescMaxItem.setValue(null);
			// txtPorcDescMaxItem.setDisabled(true);
		}

		if (txtPorcDescMinItem != null) {
			txtPorcDescMinItem.setValue(null);
			// txtPorcDescMinItem.setDisabled(true);
		}

		if (txtTipoAsocGrupoItem != null) {
			txtTipoAsocGrupoItem.setValue(null);
			// txtTipoAsocGrupoItem.setDisabled(true);
		}

		if (txtTodasSucursales != null) {
			txtTodasSucursales.setValue(null);
			// txtTodasSucursales.setDisabled(true);
		}

		if (txtIdEmpr_Empresa != null) {
			txtIdEmpr_Empresa.setValue(null);
			// txtIdEmpr_Empresa.setDisabled(true);
		}

		if (txtIdGrpo_Grupo != null) {
			txtIdGrpo_Grupo.setValue(null);
			// txtIdGrpo_Grupo.setDisabled(true);
		}

		if (txtIdPers_Persona != null) {
			txtIdPers_Persona.setValue(null);
			// txtIdPers_Persona.setDisabled(true);
		}

		if (txtIdSucu_Sucursal != null) {
			txtIdSucu_Sucursal.setValue(null);
			// txtIdSucu_Sucursal.setDisabled(true);
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

		if (txtIdDeco != null) {
			txtIdDeco.setValue(null);
			// txtIdDeco.setDisabled(false);
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
			Long idDeco = new Long(txtIdDeco.getValue().toString());
			entity = businessDelegatorView.getDescuentoComercial(idDeco);
		} catch (Exception e) {

		}

		if (entity == null) {
			txtAsocGrupoItem.setDisabled(false);
			txtCreadoAutomatico.setDisabled(false);
			txtEspacios.setDisabled(false);
			txtEstadoPlano.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtPorcDescItem.setDisabled(false);
			txtPorcDescMaxItem.setDisabled(false);
			txtPorcDescMinItem.setDisabled(false);
			txtTipoAsocGrupoItem.setDisabled(false);
			txtTodasSucursales.setDisabled(false);
			txtIdEmpr_Empresa.setDisabled(false);
			txtIdGrpo_Grupo.setDisabled(false);
			txtIdPers_Persona.setDisabled(false);
			txtIdSucu_Sucursal.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdDeco.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtAsocGrupoItem.setValue(entity.getAsocGrupoItem());
			txtAsocGrupoItem.setDisabled(false);
			txtCreadoAutomatico.setValue(entity.getCreadoAutomatico());
			txtCreadoAutomatico.setDisabled(false);
			txtEspacios.setValue(entity.getEspacios());
			txtEspacios.setDisabled(false);
			txtEstadoPlano.setValue(entity.getEstadoPlano());
			txtEstadoPlano.setDisabled(false);
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
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtPorcDescItem.setValue(entity.getPorcDescItem());
			txtPorcDescItem.setDisabled(false);
			txtPorcDescMaxItem.setValue(entity.getPorcDescMaxItem());
			txtPorcDescMaxItem.setDisabled(false);
			txtPorcDescMinItem.setValue(entity.getPorcDescMinItem());
			txtPorcDescMinItem.setDisabled(false);
			txtTipoAsocGrupoItem.setValue(entity.getTipoAsocGrupoItem());
			txtTipoAsocGrupoItem.setDisabled(false);
			txtTodasSucursales.setValue(entity.getTodasSucursales());
			txtTodasSucursales.setDisabled(false);
			txtIdEmpr_Empresa.setValue(entity.getEmpresa().getIdEmpr());
			txtIdEmpr_Empresa.setDisabled(false);
			txtIdGrpo_Grupo.setValue(entity.getGrupo().getIdGrpo());
			txtIdGrpo_Grupo.setDisabled(false);
			txtIdPers_Persona.setValue(entity.getPersona().getIdPers());
			txtIdPers_Persona.setDisabled(false);

			txtIdSucu_Sucursal.setDisabled(false);
			txtIdDeco.setValue(entity.getIdDeco());
			txtIdDeco.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedDescuentoComercial = (DescuentoComercialDTO) (evt
				.getComponent().getAttributes()
				.get("selectedDescuentoComercial"));
		txtAsocGrupoItem
				.setValue(selectedDescuentoComercial.getAsocGrupoItem());
		txtAsocGrupoItem.setDisabled(false);
		txtCreadoAutomatico.setValue(selectedDescuentoComercial
				.getCreadoAutomatico());
		txtCreadoAutomatico.setDisabled(false);
		txtEspacios.setValue(selectedDescuentoComercial.getEspacios());
		txtEspacios.setDisabled(false);
		txtEstadoPlano.setValue(selectedDescuentoComercial.getEstadoPlano());
		txtEstadoPlano.setDisabled(false);
		/*
		 * txtEstadoRegistro.setValue(selectedDescuentoComercial
		 * .getEstadoRegistro()); txtEstadoRegistro.setDisabled(false);
		 */
		txtFechaCreacion
				.setValue(selectedDescuentoComercial.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaFinal.setValue(selectedDescuentoComercial.getFechaFinal());
		txtFechaFinal.setDisabled(false);
		txtFechaInicial.setValue(selectedDescuentoComercial.getFechaInicial());
		txtFechaInicial.setDisabled(false);
		txtFechaModificacion.setValue(selectedDescuentoComercial
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedDescuentoComercial.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedDescuentoComercial.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtPorcDescItem.setValue(selectedDescuentoComercial.getPorcDescItem());
		txtPorcDescItem.setDisabled(false);
		txtPorcDescMaxItem.setValue(selectedDescuentoComercial
				.getPorcDescMaxItem());
		txtPorcDescMaxItem.setDisabled(false);
		txtPorcDescMinItem.setValue(selectedDescuentoComercial
				.getPorcDescMinItem());
		txtPorcDescMinItem.setDisabled(false);
		txtTipoAsocGrupoItem.setValue(selectedDescuentoComercial
				.getTipoAsocGrupoItem());
		txtTipoAsocGrupoItem.setDisabled(false);
		txtTodasSucursales.setValue(selectedDescuentoComercial
				.getTodasSucursales());
		txtTodasSucursales.setDisabled(false);
		txtIdEmpr_Empresa.setValue(selectedDescuentoComercial
				.getIdEmpr_Empresa());
		txtIdEmpr_Empresa.setDisabled(false);
		txtIdGrpo_Grupo.setValue(selectedDescuentoComercial.getIdGrpo_Grupo());
		txtIdGrpo_Grupo.setDisabled(false);
		txtIdPers_Persona.setValue(selectedDescuentoComercial
				.getIdPers_Persona());
		txtIdPers_Persona.setDisabled(false);

		txtIdSucu_Sucursal.setDisabled(false);
		txtIdDeco.setValue(selectedDescuentoComercial.getIdDeco());
		txtIdDeco.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedDescuentoComercial == null) && (entity == null)) {
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
			entity = new DescuentoComercial();

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");
			// Long idDeco = new Long(txtIdDeco.getValue().toString());

			entity.setAsocGrupoItem(FacesUtils.checkString(txtAsocGrupoItem));
			entity.setCreadoAutomatico(FacesUtils
					.checkLong(txtCreadoAutomatico));
			entity.setEspacios(FacesUtils.checkString(txtEspacios));
			entity.setEstadoPlano(FacesUtils.checkLong(txtEstadoPlano));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setPorcDescItem(FacesUtils.checkDouble(txtPorcDescItem));
			entity.setPorcDescMaxItem(FacesUtils
					.checkDouble(txtPorcDescMaxItem));
			entity.setPorcDescMinItem(FacesUtils
					.checkDouble(txtPorcDescMinItem));
			entity.setTipoAsocGrupoItem(FacesUtils
					.checkLong(txtTipoAsocGrupoItem));
			entity.setTodasSucursales(FacesUtils.checkLong(txtTodasSucursales));

			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			entity.setEstadoRegistro(estadoRegistro);

			if (txtIdEmpr_Empresa.getValue() == "") {

			} else {
				entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
						.checkLong(txtIdEmpr_Empresa)));
			}

			if (txtIdGrpo_Grupo.getValue() == "") {

			} else {
				entity.setGrupo(businessDelegatorView.getGrupo(FacesUtils
						.checkLong(txtIdGrpo_Grupo)));
			}

			if (txtIdPers_Persona.getValue() == "") {

			} else {
				entity.setPersona(businessDelegatorView.getPersona(FacesUtils
						.checkLong(txtIdPers_Persona)));
			}

			if (txtIdSucu_SucursalH.getValue() == "") {

			} else {
				entity.setSucursalByIdSucu(businessDelegatorView
						.getSucursal(FacesUtils.checkLong(txtIdSucu_SucursalH)));

			}

			entity.setSucursalBySucursal(businessDelegatorView
					.getSucursal(FacesUtils.checkLong(txtIdSucu_Sucursal)));

			businessDelegatorView.saveDescuentoComercial(entity);
			data = businessDelegatorView.getDataDescuentoComercial();
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
				Long idDeco = new Long(selectedDescuentoComercial.getIdDeco());
				entity = businessDelegatorView.getDescuentoComercial(idDeco);
			}

			Long idDeco = new Long(selectedDescuentoComercial.getIdDeco());
			entity = businessDelegatorView.getDescuentoComercial(idDeco);
			
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");
			// Long idDeco = new Long(txtIdDeco.getValue().toString());

			entity.setAsocGrupoItem(FacesUtils.checkString(txtAsocGrupoItem));
			entity.setCreadoAutomatico(FacesUtils
					.checkLong(txtCreadoAutomatico));
			entity.setEspacios(FacesUtils.checkString(txtEspacios));
			entity.setEstadoPlano(FacesUtils.checkLong(txtEstadoPlano));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setPorcDescItem(FacesUtils.checkDouble(txtPorcDescItem));
			entity.setPorcDescMaxItem(FacesUtils
					.checkDouble(txtPorcDescMaxItem));
			entity.setPorcDescMinItem(FacesUtils
					.checkDouble(txtPorcDescMinItem));
			entity.setTipoAsocGrupoItem(FacesUtils
					.checkLong(txtTipoAsocGrupoItem));
			entity.setTodasSucursales(FacesUtils.checkLong(txtTodasSucursales));

			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			entity.setEstadoRegistro(estadoRegistro);

			if (txtIdEmpr_Empresa.getValue() == "") {
				entity.setEmpresa(null);
			} else {
				entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
						.checkLong(txtIdEmpr_Empresa)));
			}

			if (txtIdGrpo_Grupo.getValue() == "") {
				entity.setGrupo(null);
			} else {
				entity.setGrupo(businessDelegatorView.getGrupo(FacesUtils
						.checkLong(txtIdGrpo_Grupo)));
			}

			if (txtIdPers_Persona.getValue() == "") {
				entity.setPersona(null);
			} else {
				entity.setPersona(businessDelegatorView.getPersona(FacesUtils
						.checkLong(txtIdPers_Persona)));
			}

			if (txtIdSucu_SucursalH.getValue() == "") {
				entity.setSucursalByIdSucu(null);
			} else {
				entity.setSucursalByIdSucu(businessDelegatorView
						.getSucursal(FacesUtils.checkLong(txtIdSucu_SucursalH)));

			}

			entity.setSucursalBySucursal(businessDelegatorView
					.getSucursal(FacesUtils.checkLong(txtIdSucu_Sucursal)));

			businessDelegatorView.updateDescuentoComercial(entity);
			data = businessDelegatorView.getDataDescuentoComercial();
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
			selectedDescuentoComercial = (DescuentoComercialDTO) (evt
					.getComponent().getAttributes()
					.get("selectedDescuentoComercial"));

			Long idDeco = new Long(selectedDescuentoComercial.getIdDeco());
			entity = businessDelegatorView.getDescuentoComercial(idDeco);
			businessDelegatorView.deleteDescuentoComercial(entity);
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
			selectedDescuentoComercial = (DescuentoComercialDTO) (evt
					.getComponent().getAttributes()
					.get("selectedDescuentoComercial"));

			Long idDeco = new Long(selectedDescuentoComercial.getIdDeco());
			entity = businessDelegatorView.getDescuentoComercial(idDeco);
			businessDelegatorView.deleteDescuentoComercial(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedDescuentoComercial);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String asocGrupoItem,
			Long creadoAutomatico, String espacios, Long estadoPlano,
			String estadoRegistro, Date fechaCreacion, Date fechaFinal,
			Date fechaInicial, Date fechaModificacion, Long idDeco,
			String operCreador, String operModifica, Double porcDescItem,
			Double porcDescMaxItem, Double porcDescMinItem,
			Long tipoAsocGrupoItem, Long todasSucursales, Long idEmpr_Empresa,
			Long idGrpo_Grupo, Long idPers_Persona, Long idSucu_Sucursal,
			Long idSucu_Sucursal0) throws Exception {
		try {
			entity.setAsocGrupoItem(FacesUtils.checkString(asocGrupoItem));
			entity.setCreadoAutomatico(FacesUtils.checkLong(creadoAutomatico));
			entity.setEspacios(FacesUtils.checkString(espacios));
			entity.setEstadoPlano(FacesUtils.checkLong(estadoPlano));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(fechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(fechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setPorcDescItem(FacesUtils.checkDouble(porcDescItem));
			entity.setPorcDescMaxItem(FacesUtils.checkDouble(porcDescMaxItem));
			entity.setPorcDescMinItem(FacesUtils.checkDouble(porcDescMinItem));
			entity.setTipoAsocGrupoItem(FacesUtils.checkLong(tipoAsocGrupoItem));
			entity.setTodasSucursales(FacesUtils.checkLong(todasSucursales));
			businessDelegatorView.updateDescuentoComercial(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DescuentoComercialView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtAsocGrupoItem() {
		return txtAsocGrupoItem;
	}

	public void setTxtAsocGrupoItem(InputText txtAsocGrupoItem) {
		this.txtAsocGrupoItem = txtAsocGrupoItem;
	}

	public InputText getTxtCreadoAutomatico() {
		return txtCreadoAutomatico;
	}

	public void setTxtCreadoAutomatico(InputText txtCreadoAutomatico) {
		this.txtCreadoAutomatico = txtCreadoAutomatico;
	}

	public InputTextarea getTxtEspacios() {
		return txtEspacios;
	}

	public void setTxtEspacios(InputTextarea txtEspacios) {
		this.txtEspacios = txtEspacios;
	}

	public SelectOneMenu getTxtEstadoPlano() {
		return txtEstadoPlano;
	}

	public void setTxtEstadoPlano(SelectOneMenu txtEstadoPlano) {
		this.txtEstadoPlano = txtEstadoPlano;
	}

	/*
	 * public InputText getTxtEstadoRegistro() { return txtEstadoRegistro; }
	 * 
	 * public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
	 * this.txtEstadoRegistro = txtEstadoRegistro; }
	 */

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

	public InputText getTxtPorcDescItem() {
		return txtPorcDescItem;
	}

	public void setTxtPorcDescItem(InputText txtPorcDescItem) {
		this.txtPorcDescItem = txtPorcDescItem;
	}

	public InputText getTxtPorcDescMaxItem() {
		return txtPorcDescMaxItem;
	}

	public void setTxtPorcDescMaxItem(InputText txtPorcDescMaxItem) {
		this.txtPorcDescMaxItem = txtPorcDescMaxItem;
	}

	public InputText getTxtPorcDescMinItem() {
		return txtPorcDescMinItem;
	}

	public void setTxtPorcDescMinItem(InputText txtPorcDescMinItem) {
		this.txtPorcDescMinItem = txtPorcDescMinItem;
	}

	public InputText getTxtTipoAsocGrupoItem() {
		return txtTipoAsocGrupoItem;
	}

	public void setTxtTipoAsocGrupoItem(InputText txtTipoAsocGrupoItem) {
		this.txtTipoAsocGrupoItem = txtTipoAsocGrupoItem;
	}

	public InputText getTxtTodasSucursales() {
		return txtTodasSucursales;
	}

	public void setTxtTodasSucursales(InputText txtTodasSucursales) {
		this.txtTodasSucursales = txtTodasSucursales;
	}

	public SelectOneMenu getTxtIdEmpr_Empresa() {
		return txtIdEmpr_Empresa;
	}

	public void setTxtIdEmpr_Empresa(SelectOneMenu txtIdEmpr_Empresa) {
		this.txtIdEmpr_Empresa = txtIdEmpr_Empresa;
	}

	public SelectOneMenu getTxtIdGrpo_Grupo() {
		return txtIdGrpo_Grupo;
	}

	public void setTxtIdGrpo_Grupo(SelectOneMenu txtIdGrpo_Grupo) {
		this.txtIdGrpo_Grupo = txtIdGrpo_Grupo;
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

	public InputText getTxtIdDeco() {
		return txtIdDeco;
	}

	public void setTxtIdDeco(InputText txtIdDeco) {
		this.txtIdDeco = txtIdDeco;
	}

	public List<DescuentoComercialDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDescuentoComercial();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DescuentoComercialDTO> descuentoComercialDTO) {
		this.data = descuentoComercialDTO;
	}

	public DescuentoComercialDTO getSelectedDescuentoComercial() {
		return selectedDescuentoComercial;
	}

	public void setSelectedDescuentoComercial(
			DescuentoComercialDTO descuentoComercial) {
		this.selectedDescuentoComercial = descuentoComercial;
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

	public String getAsocGrupoItem() {
		return asocGrupoItem;
	}

	public void setAsocGrupoItem(String asocGrupoItem) {
		this.asocGrupoItem = asocGrupoItem;
	}

	public String getCreadoAutomatico() {
		return creadoAutomatico;
	}

	public void setCreadoAutomatico(String creadoAutomatico) {
		this.creadoAutomatico = creadoAutomatico;
	}

	public String getEspacios() {
		return espacios;
	}

	public void setEspacios(String espacios) {
		this.espacios = espacios;
	}

	public String getEstadoPlano() {
		return estadoPlano;
	}

	public void setEstadoPlano(String estadoPlano) {
		this.estadoPlano = estadoPlano;
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

	public String getPorcDescItem() {
		return porcDescItem;
	}

	public void setPorcDescItem(String porcDescItem) {
		this.porcDescItem = porcDescItem;
	}

	public String getPorcDescMaxItem() {
		return porcDescMaxItem;
	}

	public void setPorcDescMaxItem(String porcDescMaxItem) {
		this.porcDescMaxItem = porcDescMaxItem;
	}

	public String getPorcDescMinItem() {
		return porcDescMinItem;
	}

	public void setPorcDescMinItem(String porcDescMinItem) {
		this.porcDescMinItem = porcDescMinItem;
	}

	public String getTipoAsocGrupoItem() {
		return tipoAsocGrupoItem;
	}

	public void setTipoAsocGrupoItem(String tipoAsocGrupoItem) {
		this.tipoAsocGrupoItem = tipoAsocGrupoItem;
	}

	public String getTodasSucursales() {
		return todasSucursales;
	}

	public void setTodasSucursales(String todasSucursales) {
		this.todasSucursales = todasSucursales;
	}

	public String getIdEmpr_Empresa() {
		return idEmpr_Empresa;
	}

	public void setIdEmpr_Empresa(String idEmpr_Empresa) {
		this.idEmpr_Empresa = idEmpr_Empresa;
	}

	public String getIdGrpo_Grupo() {
		return idGrpo_Grupo;
	}

	public void setIdGrpo_Grupo(String idGrpo_Grupo) {
		this.idGrpo_Grupo = idGrpo_Grupo;
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

	public String getIdDeco() {
		return idDeco;
	}

	public void setIdDeco(String idDeco) {
		this.idDeco = idDeco;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
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

	public String getIdSucu_SucursalH() {
		return idSucu_SucursalH;
	}

	public void setIdSucu_SucursalH(String idSucu_SucursalH) {
		this.idSucu_SucursalH = idSucu_SucursalH;
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

	public SelectOneMenu getTxtIdSucu_SucursalH() {
		return txtIdSucu_SucursalH;
	}

	public void setTxtIdSucu_SucursalH(SelectOneMenu txtIdSucu_SucursalH) {
		this.txtIdSucu_SucursalH = txtIdSucu_SucursalH;

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

	public Map<String, String> getEmpresa() {
		try {
			List<EmpresaDTO> data4 = businessDelegatorView.getDataEmpresa();

			for (int i = 0; i < data4.size(); i++) {
				empresa.put(data4.get(i).getNombre(), data4.get(i).getIdEmpr()
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

	public Map<String, String> getSucursal() {
		try {
			List<SucursalDTO> data3 = businessDelegatorView.getDataSucursal();

			for (int i = 0; i < data3.size(); i++) {
				sucursal.put(data3.get(i).getCodigo(), data3.get(i).getIdSucu()
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

	public Map<String, String> getSucursal2() {

		try {
			List<SucursalDTO> data6 = businessDelegatorView.getDataSucursal();

			for (int i = 0; i < data6.size(); i++) {
				sucursal2.put(data6.get(i).getNombre(), data6.get(i)
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

	public Map<String, String> getGrupo() {
		try {
			List<GrupoDTO> data5 = businessDelegatorView.getDataGrupo();

			for (int i = 0; i < data5.size(); i++) {
				grupo.put(data5.get(i).getNombre(), data5.get(i).getIdGrpo()
						+ "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return grupo;
	}

	public void setGrupo(Map<String, String> grupo) {
		this.grupo = grupo;
	}

	public CommandButton getBtnModify2() {
		return btnModify2;
	}

	public void setBtnModify2(CommandButton btnModify2) {
		this.btnModify2 = btnModify2;
	}

}
