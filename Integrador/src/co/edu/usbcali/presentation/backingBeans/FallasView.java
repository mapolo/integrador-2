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
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.Fallas;
import co.edu.usbcali.modelo.dto.FallasDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class FallasView {
	private InputText txtCodigo;
	private InputTextarea txtDescripcion;
	private SelectOneMenu estado;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdCfal;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;

	private String codigo;
	private String descripcion;
	private String estadoRegistro;
	private String operCreador;
	private String operModifica;
	private String idCfal;
	private String fechaCreacion;
	private String fechaModificacion;

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<FallasDTO> data;
	private FallasDTO selectedFallas;
	private Fallas entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectItem[] manufacturerOptions;

	String manufacturers[] = { "A", "R" };

	public FallasView() {
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
			entity = businessDelegatorView.getFallas(((FallasDTO) event
					.getObject()).getIdCfal());

			// nombre = ((TipoDivisionDTO) event.getObject()).getNombre();
			// entity.setNombre(nombre);

			// operCreador =((TipoDivisionDTO)
			// event.getObject()).getOperCreador();
			// entity.setOperCreador(operCreador);

			entity.setEstadoRegistro(estadoRegistro);

			codigo = ((FallasDTO) event.getObject()).getCodigo();
			entity.setCodigo(codigo);

			descripcion = ((FallasDTO) event.getObject()).getDescripcion();
			entity.setDescripcion(descripcion);

			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);

			businessDelegatorView.updateFallas(entity);
			data = businessDelegatorView.getDataFallas();
			RequestContext.getCurrentInstance().reset("form:listaFA");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("TipoEstado Cancelled",
				((FallasDTO) event.getObject()).getIdCfal() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((FallasDTO) event.getObject()).getIdCfal());
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			FallasDTO fallasDTO = (FallasDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(fallasDTO.getCodigo());

			if (txtDescripcion == null) {
				txtDescripcion = new InputTextarea();
			}

			txtDescripcion.setValue(fallasDTO.getDescripcion());
			/*
			 * if (txtEstadoRegistro == null) { txtEstadoRegistro = new
			 * InputText(); }
			 * 
			 * txtEstadoRegistro.setValue(fallasDTO.getEstadoRegistro());
			 */

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(fallasDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(fallasDTO.getOperModifica());

			if (txtIdCfal == null) {
				txtIdCfal = new InputText();
			}

			txtIdCfal.setValue(fallasDTO.getIdCfal());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(fallasDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(fallasDTO.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedFallas = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedFallas = null;

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			// txtCodigo.setDisabled(true);
		}

		if (txtDescripcion != null) {
			txtDescripcion.setValue(null);
			// txtDescripcion.setDisabled(true);
		}

		/*
		 * if (txtEstadoRegistro != null) { txtEstadoRegistro.setValue(null);
		 * //txtEstadoRegistro.setDisabled(true); }
		 */

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

		if (txtIdCfal != null) {
			txtIdCfal.setValue(null);
			// txtIdCfal.setDisabled(false);
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
			Long idCfal = new Long(txtIdCfal.getValue().toString());
			entity = businessDelegatorView.getFallas(idCfal);
		} catch (Exception e) {

		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtDescripcion.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdCfal.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtDescripcion.setValue(entity.getDescripcion());
			txtDescripcion.setDisabled(false);
			// txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			// txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdCfal.setValue(entity.getIdCfal());
			txtIdCfal.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedFallas = (FallasDTO) (evt.getComponent().getAttributes()
				.get("selectedFallas"));
		txtCodigo.setValue(selectedFallas.getCodigo());
		txtCodigo.setDisabled(false);
		txtDescripcion.setValue(selectedFallas.getDescripcion());
		txtDescripcion.setDisabled(false);
		// txtEstadoRegistro.setValue(selectedFallas.getEstadoRegistro());
		// txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedFallas.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedFallas.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedFallas.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedFallas.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdCfal.setValue(selectedFallas.getIdCfal());
		txtIdCfal.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedFallas == null) && (entity == null)) {
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
			entity = new Fallas();

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			// Long idCfal = new Long(txtIdCfal.getValue().toString());

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setEstadoRegistro(estadoRegistro);

			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());

			// entity.setIdCfal(idCfal);

			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			// entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			// entity.setOperModifica(FacesUtils.checkString(txtOperModifica));

			businessDelegatorView.saveFallas(entity);
			data = businessDelegatorView.getDataFallas();
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
				Long idCfal = new Long(selectedFallas.getIdCfal());
				entity = businessDelegatorView.getFallas(idCfal);
			}

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			businessDelegatorView.updateFallas(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedFallas = (FallasDTO) (evt.getComponent().getAttributes()
					.get("selectedFallas"));

			Long idCfal = new Long(selectedFallas.getIdCfal());
			entity = businessDelegatorView.getFallas(idCfal);
			businessDelegatorView.deleteFallas(entity);
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
			selectedFallas = (FallasDTO) (evt.getComponent().getAttributes()
					.get("selectedFallas"));

			Long idCfal = new Long(selectedFallas.getIdCfal());
			entity = businessDelegatorView.getFallas(idCfal);
			businessDelegatorView.deleteFallas(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedFallas);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, String descripcion,
			String estadoRegistro, Date fechaCreacion, Date fechaModificacion,
			Long idCfal, String operCreador, String operModifica)
			throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setDescripcion(FacesUtils.checkString(descripcion));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateFallas(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("FallasView").requestRender();
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

	public InputTextarea getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(InputTextarea txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
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

	public InputText getTxtIdCfal() {
		return txtIdCfal;
	}

	public void setTxtIdCfal(InputText txtIdCfal) {
		this.txtIdCfal = txtIdCfal;
	}

	public List<FallasDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataFallas();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<FallasDTO> fallasDTO) {
		this.data = fallasDTO;
	}

	public FallasDTO getSelectedFallas() {
		return selectedFallas;
	}

	public void setSelectedFallas(FallasDTO fallas) {
		this.selectedFallas = fallas;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public String getIdCfal() {
		return idCfal;
	}

	public void setIdCfal(String idCfal) {
		this.idCfal = idCfal;
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

}
