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
import co.edu.usbcali.modelo.TipoGarantia;
import co.edu.usbcali.modelo.dto.TipoGarantiaDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class TipoGarantiaView {
	private InputText txtCodigo;
	private InputTextarea txtDescripcion;
	private SelectOneMenu estado;
	// private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdTiga;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;

	private String codigo;
	private String descripcion;
	private String estadoRegistro;
	private String operCreador;
	private String operModifica;
	private String idTiga;
	private String fechaCreacion;
	private String fechaModificacion;

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<TipoGarantiaDTO> data;
	private TipoGarantiaDTO selectedTipoGarantia;
	private TipoGarantia entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectItem[] manufacturerOptions;

	String manufacturers[] = { "A", "R" };

	public TipoGarantiaView() {
		super();

		manufacturerOptions = createFilterOptions(manufacturers);
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
					.getTipoGarantia(((TipoGarantiaDTO) event.getObject())
							.getIdTiga());

			descripcion = ((TipoGarantiaDTO) event.getObject())
					.getDescripcion();
			entity.setDescripcion(descripcion);
			codigo = ((TipoGarantiaDTO) event.getObject()).getCodigo();
			entity.setCodigo(codigo);
			entity.setEstadoRegistro(estadoRegistro);


			String usuario =(String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);


			businessDelegatorView.updateTipoGarantia(entity);
			data = businessDelegatorView.getDataTipoGarantia();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Cancelled",
				((TipoGarantiaDTO) event.getObject()).getIdTiga() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((TipoGarantiaDTO) event.getObject()).getIdTiga());
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			TipoGarantiaDTO tipoGarantiaDTO = (TipoGarantiaDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(tipoGarantiaDTO.getCodigo());

			if (txtDescripcion == null) {
				txtDescripcion = new InputTextarea();
			}

			txtDescripcion.setValue(tipoGarantiaDTO.getDescripcion());

			/*
			 * if (txtEstadoRegistro == null) { txtEstadoRegistro = new
			 * InputText(); }
			 * 
			 * txtEstadoRegistro.setValue(tipoGarantiaDTO.getEstadoRegistro());
			 */

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(tipoGarantiaDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(tipoGarantiaDTO.getOperModifica());

			if (txtIdTiga == null) {
				txtIdTiga = new InputText();
			}

			txtIdTiga.setValue(tipoGarantiaDTO.getIdTiga());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(tipoGarantiaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(tipoGarantiaDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedTipoGarantia = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedTipoGarantia = null;

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

		if (txtIdTiga != null) {
			txtIdTiga.setValue(null);
			// txtIdTiga.setDisabled(false);
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
			Long idTiga = new Long(txtIdTiga.getValue().toString());
			entity = businessDelegatorView.getTipoGarantia(idTiga);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtDescripcion.setDisabled(false);
			// txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdTiga.setDisabled(false);
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
			txtIdTiga.setValue(entity.getIdTiga());
			txtIdTiga.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedTipoGarantia = (TipoGarantiaDTO) (evt.getComponent()
				.getAttributes().get("selectedTipoGarantia"));
		txtCodigo.setValue(selectedTipoGarantia.getCodigo());
		txtCodigo.setDisabled(false);
		txtDescripcion.setValue(selectedTipoGarantia.getDescripcion());
		txtDescripcion.setDisabled(false);
		// txtEstadoRegistro.setValue(selectedTipoGarantia.getEstadoRegistro());
		// txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedTipoGarantia.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedTipoGarantia
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedTipoGarantia.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedTipoGarantia.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdTiga.setValue(selectedTipoGarantia.getIdTiga());
		txtIdTiga.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedTipoGarantia == null) && (entity == null)) {
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
			entity = new TipoGarantia();

			HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
					.getExternalContext().getSession(false);
			
			String usuario =(String) session.getAttribute("Usuario");
			
			//Long idTiga = new Long(txtIdTiga.getValue().toString());

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			entity.setEstadoRegistro(estadoRegistro);
			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			//entity.setIdTiga(idTiga);
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			
			//txtOperCreador.setValue(usuario);
			//txtOperModifica.setValue(usuario);
			//entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			//entity.setOperModifica(FacesUtils.checkString(txtOperModifica));

			businessDelegatorView.saveTipoGarantia(entity);
			data = businessDelegatorView.getDataTipoGarantia();
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
				Long idTiga = new Long(selectedTipoGarantia.getIdTiga());
				entity = businessDelegatorView.getTipoGarantia(idTiga);
			}

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			businessDelegatorView.updateTipoGarantia(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedTipoGarantia = (TipoGarantiaDTO) (evt.getComponent()
					.getAttributes().get("selectedTipoGarantia"));

			Long idTiga = new Long(selectedTipoGarantia.getIdTiga());
			entity = businessDelegatorView.getTipoGarantia(idTiga);
			businessDelegatorView.deleteTipoGarantia(entity);
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
			selectedTipoGarantia = (TipoGarantiaDTO) (evt.getComponent()
					.getAttributes().get("selectedTipoGarantia"));

			Long idTiga = new Long(selectedTipoGarantia.getIdTiga());
			entity = businessDelegatorView.getTipoGarantia(idTiga);
			businessDelegatorView.deleteTipoGarantia(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedTipoGarantia);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, String descripcion,
			String estadoRegistro, Date fechaCreacion, Date fechaModificacion,
			Long idTiga, String operCreador, String operModifica)
			throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setDescripcion(FacesUtils.checkString(descripcion));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateTipoGarantia(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("TipoGarantiaView").requestRender();
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

	public InputText getTxtIdTiga() {
		return txtIdTiga;
	}

	public void setTxtIdTiga(InputText txtIdTiga) {
		this.txtIdTiga = txtIdTiga;
	}

	public List<TipoGarantiaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataTipoGarantia();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<TipoGarantiaDTO> tipoGarantiaDTO) {
		this.data = tipoGarantiaDTO;
	}

	public TipoGarantiaDTO getSelectedTipoGarantia() {
		return selectedTipoGarantia;
	}

	public void setSelectedTipoGarantia(TipoGarantiaDTO tipoGarantia) {
		this.selectedTipoGarantia = tipoGarantia;
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

	public String getIdTiga() {
		return idTiga;
	}

	public void setIdTiga(String idTiga) {
		this.idTiga = idTiga;
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

}
