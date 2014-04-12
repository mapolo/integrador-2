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
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.TipoDivision;
import co.edu.usbcali.modelo.dto.TipoDivisionDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class TipoDivisionView {
	private SelectOneMenu txtEstadoRegistro;
	private InputText txtNombre;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdTidi;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;

	private String estadoRegistro;
	private String nombre;
	private String operCreador;
	private String operModifica;
	private String idTidi;
	private String fechaCreacion;
	private String fechaModificacion;

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private CommandButton btnCrear;
	private List<TipoDivisionDTO> data;
	private TipoDivisionDTO selectedTipoDivision;
	private TipoDivision entity;
	private boolean showDialog;
	private SelectOneMenu estado;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private SelectItem[] manufacturerOptions;

	String manufacturers[] = { "A", "R" };

	public TipoDivisionView() {
		super();

		manufacturerOptions = createFilterOptions(manufacturers);

	}

	public void rowEventListener(RowEditEvent e) {
		try {
			TipoDivisionDTO tipoDivisionDTO = (TipoDivisionDTO) e.getObject();

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(tipoDivisionDTO.getNombre());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(tipoDivisionDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(tipoDivisionDTO.getOperModifica());

			if (txtIdTidi == null) {
				txtIdTidi = new InputText();
			}

			txtIdTidi.setValue(tipoDivisionDTO.getIdTidi());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(tipoDivisionDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(tipoDivisionDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedTipoDivision = null;
		setShowDialog(true);

		return "";
	}

	public String principalPagina() {
		return "tipoDivision.xhtml";
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
					.getTipoDivision(((TipoDivisionDTO) event.getObject())
							.getIdTidi());

			nombre = ((TipoDivisionDTO) event.getObject()).getNombre();
			entity.setNombre(nombre);

			// operCreador =((TipoDivisionDTO)
			// event.getObject()).getOperCreador();
			// entity.setOperCreador(operCreador);

			entity.setEstadoRegistro(estadoRegistro);
			// entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			// entity.setOperModifica(FacesUtils.checkString(txtOperModifica));

			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);

			businessDelegatorView.updateTipoDivision(entity);
			data = businessDelegatorView.getDataTipoDivision();
			RequestContext.getCurrentInstance().reset("form:listaTD");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("TipoEstado Cancelled",
				((TipoDivisionDTO) event.getObject()).getIdTidi() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((TipoDivisionDTO) event.getObject()).getIdTidi());
	}

	public String actualizar() {
		return "tipoDivision.xhtml?faces-redirect=true";
	}

	public String action_buscar() {
		try {
			idTidi = selectedTipoDivision.getIdTidi() + "";
			txtNombre.setValue(selectedTipoDivision.getNombre());
			System.out.println(txtNombre.getValue());
			operCreador = selectedTipoDivision.getOperCreador();
			operModifica = selectedTipoDivision.getOperModifica();
			estadoRegistro = selectedTipoDivision.getEstadoRegistro();
			txtEstadoRegistro
					.setValue(selectedTipoDivision.getEstadoRegistro());
			btnModify.setDisabled(false);

			RequestContext.getCurrentInstance().update("form:panel");
			RequestContext.getCurrentInstance().update("form:dialog");
			RequestContext.getCurrentInstance().update("form:panelBotones");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String action_clear() {
		// entity = null;
		// selectedTipoDivision = null;

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue("");
			// txtEstadoRegistro.setDisabled(true);
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

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			// txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			// txtFechaModificacion.setDisabled(true);
		}

		if (txtIdTidi != null) {
			txtIdTidi.setValue(null);
			// txtIdTidi.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		// btnCrear.setDisabled(false);
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
			Long idTidi = new Long(txtIdTidi.getValue().toString());
			entity = businessDelegatorView.getTipoDivision(idTidi);
		} catch (Exception e) {
		}

		if (entity == null) {
			// txtEstadoRegistro.setDisabled(false);
			txtNombre.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdTidi.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			// txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			// txtEstadoRegistro.setDisabled(false);
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
			txtIdTidi.setValue(entity.getIdTidi());
			txtIdTidi.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedTipoDivision = (TipoDivisionDTO) (evt.getComponent()
				.getAttributes().get("selectedTipoDivision"));
		// txtEstadoRegistro.setValue(selectedTipoDivision.getEstadoRegistro());
		// txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedTipoDivision.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedTipoDivision
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtNombre.setValue(selectedTipoDivision.getNombre());
		txtNombre.setDisabled(false);
		txtOperCreador.setValue(selectedTipoDivision.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedTipoDivision.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdTidi.setValue(selectedTipoDivision.getIdTidi());
		txtIdTidi.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedTipoDivision == null) && (entity == null)) {
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
			entity = new TipoDivision();

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			System.out.println("Usuario= " + usuario);

			// Long idTidi = new Long(txtIdTidi.getValue().toString());

			entity.setEstadoRegistro(estadoRegistro);
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			// entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			// entity.setIdTidi(idTidi);
			entity.setNombre(FacesUtils.checkString(txtNombre));

			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			// txtOperCreador.setValue(usuario);
			// txtOperModifica.setValue(usuario);
			// entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			// entity.setOperModifica(FacesUtils.checkString(txtOperModifica));

			System.out.println("id " + idTidi + "; estadoRegistro "
					+ estadoRegistro + ";nombre " + nombre + "");

			businessDelegatorView.saveTipoDivision(entity);
			data = businessDelegatorView.getDataTipoDivision();
			// RequestContext.getCurrentInstance().reset("form:listaTD");
			// RequestContext.getCurrentInstance().update("form:panel");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
			action_clear();
			// actualizar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modificar() {

		txtIdTidi.setDisabled(true);
		txtNombre.setDisabled(false);
		// estado.setDisabled(false);
		// txtEstadoRegistro.setDisabled(false);

		// txtFechaCreacion.setDisabled(true);
		// txtFechaModificacion.setDisabled(true);
		// txtOperCreador.setDisabled(false);
		// txtOperModifica.setDisabled(false);

		// btnCrear.setDisabled(false);
		btnSave.setDisabled(false);

		return "";
	}

	public String action_crear() {
		action_clear();
		txtIdTidi.setDisabled(false);
		txtNombre.setDisabled(false);
		txtEstadoRegistro.setDisabled(false);
		estadoRegistro = "";
		// txtEstadoRegistro.setValue(null);

		txtOperCreador.setDisabled(false);
		txtOperModifica.setDisabled(false);
		// estado.setDisabled(false);

		// txtFechaCreacion.setDisabled(true);
		// txtFechaCreacion.setValue(new Date());
		// txtFechaModificacion.setDisabled(true);
		// txtFechaModificacion.setValue(new Date());

		btnCrear.setDisabled(false);
		btnSave.setDisabled(false);
		btnModify.setDisabled(true);

		return "";
	}

	public String action_modify() {
		try {

			/*
			 * if (!btnCrear.isDisabled() && btnModify.isDisabled()) {
			 * System.out.println("Entro fif modificar"); action_create(); data
			 * = businessDelegatorView.getDataTipoDivision();
			 * RequestContext.getCurrentInstance().update(
			 * "form:tablaPrincipal"); return ""; }
			 * 
			 * if (entity == null) { entity =
			 * businessDelegatorView.getTipoDivision(Long .parseLong(idTidi)); }
			 */

			System.out.println("entro modificar");
			entity.setEstadoRegistro(estadoRegistro);
			// entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			// entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			// entity.setFechaModificacion(new Date());
			// entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));

			businessDelegatorView.updateTipoDivision(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
			btnSave.setDisabled(false);
			data = businessDelegatorView.getDataTipoDivision();
			RequestContext.getCurrentInstance().update("form:tablaPrincipal");
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedTipoDivision = (TipoDivisionDTO) (evt.getComponent()
					.getAttributes().get("selectedTipoDivision"));

			Long idTidi = new Long(selectedTipoDivision.getIdTidi());
			entity = businessDelegatorView.getTipoDivision(idTidi);
			businessDelegatorView.deleteTipoDivision(entity);
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
			selectedTipoDivision = (TipoDivisionDTO) (evt.getComponent()
					.getAttributes().get("selectedTipoDivision"));

			Long idTidi = new Long(selectedTipoDivision.getIdTidi());
			entity = businessDelegatorView.getTipoDivision(idTidi);
			businessDelegatorView.deleteTipoDivision(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedTipoDivision);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idTidi,
			String nombre, String operCreador, String operModifica)
			throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateTipoDivision(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("TipoDivisionView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	/*
	 * public InputText getTxtEstadoRegistro() { return txtEstadoRegistro; }
	 * 
	 * public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
	 * this.txtEstadoRegistro = txtEstadoRegistro; }
	 */

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

	public InputText getTxtIdTidi() {
		return txtIdTidi;
	}

	public void setTxtIdTidi(InputText txtIdTidi) {
		this.txtIdTidi = txtIdTidi;
	}

	public List<TipoDivisionDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataTipoDivision();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<TipoDivisionDTO> tipoDivisionDTO) {
		this.data = tipoDivisionDTO;
	}

	public TipoDivisionDTO getSelectedTipoDivision() {
		return selectedTipoDivision;
	}

	public void setSelectedTipoDivision(TipoDivisionDTO tipoDivision) {
		try {
			System.out.println("id tipoD " + tipoDivision.getIdTidi());
		} catch (Exception e) {
			System.out.println("vacio ");
		}

		this.selectedTipoDivision = tipoDivision;
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

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getIdTidi() {
		return idTidi;
	}

	public void setIdTidi(String idTidi) {
		this.idTidi = idTidi;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public CommandButton getBtnCrear() {
		return btnCrear;
	}

	public void setBtnCrear(CommandButton btnCrear) {
		this.btnCrear = btnCrear;
	}

	public SelectOneMenu getEstado() {
		return estado;
	}

	public void setEstado(SelectOneMenu estado) {
		this.estado = estado;
	}

	public SelectOneMenu getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(SelectOneMenu txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}

	public SelectItem[] getManufacturerOptions() {
		return manufacturerOptions;
	}

	public void setManufacturerOptions(SelectItem[] manufacturerOptions) {
		this.manufacturerOptions = manufacturerOptions;
	}

}
