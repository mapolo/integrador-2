package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.AtencionVendedorDTO;
import co.edu.usbcali.presentation.businessDelegate.*;
import co.edu.usbcali.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.dtt.DataTableAtencionVendedor;
import co.edu.usbcali.dtt.DataTableRelacionComercial;
import co.edu.usbcali.dtt.DataTableRutaRelacion;
import co.edu.usbcali.dtt.DataTableVendedor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class AtencionVendedorView {

	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdReco_RelacionComercial;
	private InputText txtIdVend_Vendedor;
	private InputText txtIdAtve;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private DataTableRelacionComercial rowDataTableRelacionComercial;
	private List<AtencionVendedorDTO> data;
	private List<Empresa> empresas;
	private List<SelectItem> items;
	private List<DataTableRelacionComercial> comercials;
	private List<RutaDistribucion> distribucions;
	private RutaDistribucion rowDistribucion;
	private List<AtencionVendedor> atencionVendedors;
	private List<AtencionVendedor> rutaAtencionVendedors;
	private DataTableAtencionVendedor rowdaDataTableRutaAtencionVen;
	private DataTableAtencionVendedor rowAtencionVendedor2;
	private List<DataTableAtencionVendedor> atencionVendedors2;
	private List<DataTableAtencionVendedor> rutaAtencionVendedor;
	private List<DataTableVendedor> dataTableVendedors;

	private List<DataTableRutaRelacion> dataTableRutaRelacions;

	private DataTableVendedor rowAtencionVendedor;
	private DataTable dttRelacionComercial;
	private DataTableRelacionComercial dataTableRelacionComercial;
	private String empresa;
	private AtencionVendedorDTO selectedAtencionVendedor;
	private AtencionVendedor entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public AtencionVendedorView() {
		super();
	}

	@PostConstruct
	public void constructor() {
		try {
			empresas = new ArrayList<Empresa>();
			empresas = businessDelegatorView.consultarEmpresa();

			distribucions = businessDelegatorView.getRutaDistribucion();

			items = new ArrayList<SelectItem>();

			for (int i = 0; i < empresas.size(); i++) {
				List<Sucursal> sucursal = businessDelegatorView
						.consultarPorIdEmpr("empresa.idEmpr", empresas.get(i)
								.getIdEmpr());

				if (sucursal != null) {
					if (sucursal.size() != 0) {
						SelectItem item = new SelectItem(empresas.get(i)
								.getIdEmpr(), empresas.get(i).getNombre());
						items.add(item);
					}
				}

			}

			llenarAtencionVendedor();
			llenarRutaRelacionComercial();
			llenarRelacionComercial();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void llenarRutaRelacionComercial() {

		try {

			List<RutaRelacionComercial> rutas = businessDelegatorView
					.getRutaRelacionComercial();
			dataTableRutaRelacions = new ArrayList<DataTableRutaRelacion>();

			for (int i = 0; i < rutas.size(); i++) {
				RutaDistribucion distribucion = businessDelegatorView
						.getRutaDistribucion(rutas.get(i).getRutaDistribucion()
								.getIdRudi());
				AtencionVendedor atencionVendedor = businessDelegatorView
						.getAtencionVendedor(rutas.get(i).getAtencionVendedor()
								.getIdAtve());

				Vendedor vendedor = businessDelegatorView
						.getVendedor(atencionVendedor.getVendedor().getIdVend());
				RelacionComercial relacionComercial = businessDelegatorView
						.getRelacionComercial(atencionVendedor
								.getRelacionComercial().getIdReco());

				Empresa empresa = businessDelegatorView
						.getEmpresa(relacionComercial.getEmpresa().getIdEmpr());
				Persona persona = businessDelegatorView.getPersona(vendedor
						.getPersona().getIdPers());

				DataTableRutaRelacion dataTableRutaRelacion = new DataTableRutaRelacion();

				dataTableRutaRelacion.setIdRrec(rutas.get(i).getIdRrec());
				dataTableRutaRelacion.setIdRudi(distribucion.getIdRudi());
				dataTableRutaRelacion.setDescripcion(distribucion
						.getDescripcion());
				dataTableRutaRelacion.setTiempoEntrega(distribucion
						.getTiempoEntrega());
				dataTableRutaRelacion.setTiempoTransporte(distribucion
						.getTiempoTransporte());
				dataTableRutaRelacion.setIdAtve(atencionVendedor.getIdAtve());
				dataTableRutaRelacion.setIdVend(vendedor.getIdVend());
				dataTableRutaRelacion.setIdentificacion(persona
						.getIdentificacion());
				dataTableRutaRelacion
						.setPrimerNombre(persona.getPrimerNombre());
				dataTableRutaRelacion.setIdReco(relacionComercial.getIdReco());
				dataTableRutaRelacion.setNombre(empresa.getNombre());
				dataTableRutaRelacion.setIdentificacionEmpresa(empresa
						.getIdentificacion());

				dataTableRutaRelacions.add(dataTableRutaRelacion);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void adiccionarCodigoRelacionComercial() {
		try {
			List<Vendedor> vendedors = businessDelegatorView.getVendedor();
			dataTableVendedors = new ArrayList<DataTableVendedor>();
			for (int i = 0; i < vendedors.size(); i++) {
				DataTableVendedor vendedor = new DataTableVendedor();
				Persona persona = businessDelegatorView.getPersona(vendedors
						.get(i).getPersona().getIdPers());
				vendedor.setEmail(persona.getEmail());
				vendedor.setIdentificacion(persona.getIdentificacion());
				vendedor.setPrimerNombre(persona.getPrimerNombre());
				vendedor.setIdVend(vendedors.get(i).getIdVend());

				dataTableVendedors.add(vendedor);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void adiccionarVendedorRelacioncomercial() {

		try {
			AtencionVendedor atencionVendedor = new AtencionVendedor();

			RelacionComercial relacionComercial = businessDelegatorView
					.getRelacionComercial(rowDataTableRelacionComercial
							.getIdReco());

			Vendedor vendedor = businessDelegatorView
					.getVendedor(rowAtencionVendedor.getIdVend());

			atencionVendedor.setRelacionComercial(relacionComercial);
			atencionVendedor.setVendedor(vendedor);
			atencionVendedor.setFechaCreacion(new Date());
			atencionVendedor.setFechaModificacion(new Date());
			atencionVendedor.setOperCreador("default");
			atencionVendedor.setOperModifica("defautl");
			atencionVendedor.setEstadoRegistro("A");

			businessDelegatorView.saveAtencionVendedor(atencionVendedor);

			llenarAtencionVendedor();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void llenarAtencionVendedor() {
		try {
			atencionVendedors = businessDelegatorView.getAtencionVendedor();
			atencionVendedors2 = new ArrayList<DataTableAtencionVendedor>();

			for (int i = 0; i < atencionVendedors.size(); i++) {
				DataTableAtencionVendedor atencionVendedor = new DataTableAtencionVendedor();

				Vendedor vendedor = businessDelegatorView
						.getVendedor(atencionVendedors.get(i).getVendedor()
								.getIdVend());
				RelacionComercial relacionComercial = businessDelegatorView
						.getRelacionComercial(atencionVendedors.get(i)
								.getRelacionComercial().getIdReco());

				Persona persona = businessDelegatorView.getPersona(vendedor
						.getPersona().getIdPers());
				Empresa empresa = businessDelegatorView
						.getEmpresa(relacionComercial.getEmpresa().getIdEmpr());

				atencionVendedor
						.setIdAtve(atencionVendedors.get(i).getIdAtve());
				atencionVendedor.setIdEmpr(empresa.getIdEmpr());
				atencionVendedor.setIdentificacion(persona.getIdentificacion());
				atencionVendedor.setIdentificacionEmpresa(empresa
						.getIdentificacion());
				atencionVendedor.setIdReco(relacionComercial.getIdReco());
				atencionVendedor.setIdVend(vendedor.getIdVend());
				atencionVendedor.setNombre(empresa.getNombre());
				atencionVendedor.setPrimerNombre(persona.getPrimerNombre());

				atencionVendedors2.add(atencionVendedor);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void llenarRelacionComercial() {
		try {
			List<RelacionComercial> comercialsDatos = businessDelegatorView
					.consultarRelacionPropiedad("empresa.idEmpr", new Long(
							empresa));
			comercials = new ArrayList<DataTableRelacionComercial>();

			for (int i = 0; i < comercialsDatos.size(); i++) {
				DataTableRelacionComercial comercial = new DataTableRelacionComercial();

				Empresa empresa = businessDelegatorView
						.getEmpresa(comercialsDatos.get(i).getEmpresa()
								.getIdEmpr());

				comercial.setDireccion(empresa.getDireccion());
				comercial.setIdentificacion(empresa.getIdentificacion());
				comercial.setIdReco(comercialsDatos.get(i).getIdReco());
				comercial.setNombre(empresa.getNombre());
				comercial.setTelefono1(empresa.getTelefono1());

				comercials.add(comercial);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void guardarRutaAtencion() {

		try {

			AtencionVendedor atencionVendedor = businessDelegatorView
					.getAtencionVendedor(rowdaDataTableRutaAtencionVen
							.getIdAtve());
			RutaDistribucion distribucion = businessDelegatorView
					.getRutaDistribucion(rowDistribucion.getIdRudi());

			RutaRelacionComercial comercial = new RutaRelacionComercial();

			comercial.setAtencionVendedor(atencionVendedor);
			comercial.setEstadoRegistro("A");
			comercial.setFechaCreacion(new Date());
			comercial.setFechaModificacion(new Date());
			comercial.setOperCreador("jsvargas");
			comercial.setOperModifica("jsvargas");
			comercial.setRutaDistribucion(distribucion);

			businessDelegatorView.saveRutaRelacionComercial(comercial);

			llenarRutaRelacionComercial();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void rutallenarAtencioVendedor() {

		try {
			rutaAtencionVendedors = businessDelegatorView
					.consultarAtencionVendedor(rowDataTableRelacionComercial
							.getIdReco());
			rutaAtencionVendedor = new ArrayList<DataTableAtencionVendedor>();

			for (int i = 0; i < atencionVendedors.size(); i++) {
				DataTableAtencionVendedor atencionVendedor = new DataTableAtencionVendedor();

				Vendedor vendedor = businessDelegatorView
						.getVendedor(atencionVendedors.get(i).getVendedor()
								.getIdVend());
				RelacionComercial relacionComercial = businessDelegatorView
						.getRelacionComercial(atencionVendedors.get(i)
								.getRelacionComercial().getIdReco());

				Persona persona = businessDelegatorView.getPersona(vendedor
						.getPersona().getIdPers());
				Empresa empresa = businessDelegatorView
						.getEmpresa(relacionComercial.getEmpresa().getIdEmpr());

				atencionVendedor
						.setIdAtve(atencionVendedors.get(i).getIdAtve());
				atencionVendedor.setIdEmpr(empresa.getIdEmpr());
				atencionVendedor.setIdentificacion(persona.getIdentificacion());
				atencionVendedor.setIdentificacionEmpresa(empresa
						.getIdentificacion());
				atencionVendedor.setIdReco(relacionComercial.getIdReco());
				atencionVendedor.setIdVend(vendedor.getIdVend());
				atencionVendedor.setNombre(empresa.getNombre());
				atencionVendedor.setPrimerNombre(persona.getPrimerNombre());

				rutaAtencionVendedor.add(atencionVendedor);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			AtencionVendedorDTO atencionVendedorDTO = (AtencionVendedorDTO) e
					.getObject();

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(atencionVendedorDTO.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(atencionVendedorDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(atencionVendedorDTO.getOperModifica());

			if (txtIdReco_RelacionComercial == null) {
				txtIdReco_RelacionComercial = new InputText();
			}

			txtIdReco_RelacionComercial.setValue(atencionVendedorDTO
					.getIdReco_RelacionComercial());

			if (txtIdVend_Vendedor == null) {
				txtIdVend_Vendedor = new InputText();
			}

			txtIdVend_Vendedor.setValue(atencionVendedorDTO
					.getIdVend_Vendedor());

			if (txtIdAtve == null) {
				txtIdAtve = new InputText();
			}

			txtIdAtve.setValue(atencionVendedorDTO.getIdAtve());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(atencionVendedorDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(atencionVendedorDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedAtencionVendedor = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedAtencionVendedor = null;

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtIdReco_RelacionComercial != null) {
			txtIdReco_RelacionComercial.setValue(null);
			txtIdReco_RelacionComercial.setDisabled(true);
		}

		if (txtIdVend_Vendedor != null) {
			txtIdVend_Vendedor.setValue(null);
			txtIdVend_Vendedor.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdAtve != null) {
			txtIdAtve.setValue(null);
			txtIdAtve.setDisabled(false);
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
			Long idAtve = new Long(txtIdAtve.getValue().toString());
			entity = businessDelegatorView.getAtencionVendedor(idAtve);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdReco_RelacionComercial.setDisabled(false);
			txtIdVend_Vendedor.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdAtve.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdReco_RelacionComercial.setValue(entity.getRelacionComercial()
					.getIdReco());
			txtIdReco_RelacionComercial.setDisabled(false);
			txtIdVend_Vendedor.setValue(entity.getVendedor().getIdVend());
			txtIdVend_Vendedor.setDisabled(false);
			txtIdAtve.setValue(entity.getIdAtve());
			txtIdAtve.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedAtencionVendedor = (AtencionVendedorDTO) (evt.getComponent()
				.getAttributes().get("selectedAtencionVendedor"));
		txtEstadoRegistro
				.setValue(selectedAtencionVendedor.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedAtencionVendedor.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedAtencionVendedor
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedAtencionVendedor.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedAtencionVendedor.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdReco_RelacionComercial.setValue(selectedAtencionVendedor
				.getIdReco_RelacionComercial());
		txtIdReco_RelacionComercial.setDisabled(false);
		txtIdVend_Vendedor.setValue(selectedAtencionVendedor
				.getIdVend_Vendedor());
		txtIdVend_Vendedor.setDisabled(false);
		txtIdAtve.setValue(selectedAtencionVendedor.getIdAtve());
		txtIdAtve.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedAtencionVendedor == null) && (entity == null)) {
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
			entity = new AtencionVendedor();

			Long idAtve = new Long(txtIdAtve.getValue().toString());

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdAtve(idAtve);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setRelacionComercial(businessDelegatorView
					.getRelacionComercial(FacesUtils
							.checkLong(txtIdReco_RelacionComercial)));
			entity.setVendedor(businessDelegatorView.getVendedor(FacesUtils
					.checkLong(txtIdVend_Vendedor)));
			businessDelegatorView.saveAtencionVendedor(entity);
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
				Long idAtve = new Long(selectedAtencionVendedor.getIdAtve());
				entity = businessDelegatorView.getAtencionVendedor(idAtve);
			}

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setRelacionComercial(businessDelegatorView
					.getRelacionComercial(FacesUtils
							.checkLong(txtIdReco_RelacionComercial)));
			entity.setVendedor(businessDelegatorView.getVendedor(FacesUtils
					.checkLong(txtIdVend_Vendedor)));
			businessDelegatorView.updateAtencionVendedor(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedAtencionVendedor = (AtencionVendedorDTO) (evt
					.getComponent().getAttributes()
					.get("selectedAtencionVendedor"));

			Long idAtve = new Long(selectedAtencionVendedor.getIdAtve());
			entity = businessDelegatorView.getAtencionVendedor(idAtve);
			businessDelegatorView.deleteAtencionVendedor(entity);
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
			selectedAtencionVendedor = (AtencionVendedorDTO) (evt
					.getComponent().getAttributes()
					.get("selectedAtencionVendedor"));

			Long idAtve = new Long(selectedAtencionVendedor.getIdAtve());
			entity = businessDelegatorView.getAtencionVendedor(idAtve);
			businessDelegatorView.deleteAtencionVendedor(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedAtencionVendedor);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idAtve,
			String operCreador, String operModifica,
			Long idReco_RelacionComercial, Long idVend_Vendedor)
			throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateAtencionVendedor(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("AtencionVendedorView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
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

	public InputText getTxtIdReco_RelacionComercial() {
		return txtIdReco_RelacionComercial;
	}

	public void setTxtIdReco_RelacionComercial(
			InputText txtIdReco_RelacionComercial) {
		this.txtIdReco_RelacionComercial = txtIdReco_RelacionComercial;
	}

	public InputText getTxtIdVend_Vendedor() {
		return txtIdVend_Vendedor;
	}

	public void setTxtIdVend_Vendedor(InputText txtIdVend_Vendedor) {
		this.txtIdVend_Vendedor = txtIdVend_Vendedor;
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

	public InputText getTxtIdAtve() {
		return txtIdAtve;
	}

	public void setTxtIdAtve(InputText txtIdAtve) {
		this.txtIdAtve = txtIdAtve;
	}

	public List<AtencionVendedorDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataAtencionVendedor();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<AtencionVendedorDTO> atencionVendedorDTO) {
		this.data = atencionVendedorDTO;
	}

	public AtencionVendedorDTO getSelectedAtencionVendedor() {
		return selectedAtencionVendedor;
	}

	public void setSelectedAtencionVendedor(AtencionVendedorDTO atencionVendedor) {
		this.selectedAtencionVendedor = atencionVendedor;
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

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public List<SelectItem> getItems() {
		if (dataTableRelacionComercial != null) {
			System.out.println(dataTableRelacionComercial.getNombre());
		}

		return items;
	}

	public void setItems(List<SelectItem> items) {
		this.items = items;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public List<DataTableRelacionComercial> getComercials() {
		return comercials;
	}

	public void setComercials(List<DataTableRelacionComercial> comercials) {
		this.comercials = comercials;
	}

	public List<AtencionVendedor> getAtencionVendedors() {
		return atencionVendedors;
	}

	public void setAtencionVendedors(List<AtencionVendedor> atencionVendedors) {
		this.atencionVendedors = atencionVendedors;
	}

	public List<DataTableAtencionVendedor> getAtencionVendedors2() {
		return atencionVendedors2;
	}

	public void setAtencionVendedors2(
			List<DataTableAtencionVendedor> atencionVendedors2) {
		this.atencionVendedors2 = atencionVendedors2;
	}

	public DataTable getDttRelacionComercial() {
		return dttRelacionComercial;
	}

	public void setDttRelacionComercial(DataTable dttRelacionComercial) {
		this.dttRelacionComercial = dttRelacionComercial;
	}

	public DataTableRelacionComercial getDataTableRelacionComercial() {
		return dataTableRelacionComercial;
	}

	public void setDataTableRelacionComercial(
			DataTableRelacionComercial dataTableRelacionComercial) {
		this.dataTableRelacionComercial = dataTableRelacionComercial;
	}

	public DataTableRelacionComercial getRowDataTableRelacionComercial() {
		return rowDataTableRelacionComercial;
	}

	public void setRowDataTableRelacionComercial(
			DataTableRelacionComercial rowDataTableRelacionComercial) {
		this.rowDataTableRelacionComercial = rowDataTableRelacionComercial;
	}

	public List<DataTableVendedor> getDataTableVendedors() {
		return dataTableVendedors;
	}

	public void setDataTableVendedors(List<DataTableVendedor> dataTableVendedors) {
		this.dataTableVendedors = dataTableVendedors;
	}

	public DataTableVendedor getRowAtencionVendedor() {
		return rowAtencionVendedor;
	}

	public void setRowAtencionVendedor(DataTableVendedor rowAtencionVendedor) {
		this.rowAtencionVendedor = rowAtencionVendedor;
	}

	public List<DataTableRutaRelacion> getDataTableRutaRelacions() {
		return dataTableRutaRelacions;
	}

	public void setDataTableRutaRelacions(
			List<DataTableRutaRelacion> dataTableRutaRelacions) {
		this.dataTableRutaRelacions = dataTableRutaRelacions;
	}

	public DataTableAtencionVendedor getRowAtencionVendedor2() {
		return rowAtencionVendedor2;
	}

	public void setRowAtencionVendedor2(
			DataTableAtencionVendedor rowAtencionVendedor2) {
		this.rowAtencionVendedor2 = rowAtencionVendedor2;
	}

	public List<DataTableAtencionVendedor> getRutaAtencionVendedor() {
		return rutaAtencionVendedor;
	}

	public void setRutaAtencionVendedor(
			List<DataTableAtencionVendedor> rutaAtencionVendedor) {
		this.rutaAtencionVendedor = rutaAtencionVendedor;
	}

	public List<AtencionVendedor> getRutaAtencionVendedors() {
		return rutaAtencionVendedors;
	}

	public void setRutaAtencionVendedors(
			List<AtencionVendedor> rutaAtencionVendedors) {
		this.rutaAtencionVendedors = rutaAtencionVendedors;
	}

	public DataTableAtencionVendedor getRowdaDataTableRutaAtencionVen() {
		return rowdaDataTableRutaAtencionVen;
	}

	public void setRowdaDataTableRutaAtencionVen(
			DataTableAtencionVendedor rowdaDataTableRutaAtencionVen) {
		this.rowdaDataTableRutaAtencionVen = rowdaDataTableRutaAtencionVen;
	}

	public List<RutaDistribucion> getDistribucions() {
		return distribucions;
	}

	public void setDistribucions(List<RutaDistribucion> distribucions) {
		this.distribucions = distribucions;
	}

	public RutaDistribucion getRowDistribucion() {
		return rowDistribucion;
	}

	public void setRowDistribucion(RutaDistribucion rowDistribucion) {
		this.rowDistribucion = rowDistribucion;
	}

}
