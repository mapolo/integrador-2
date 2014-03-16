package co.edu.usbcali.presentation.backingBeans;

import java.text.DateFormat;
import java.text.Format;
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
import co.edu.usbcali.modelo.TipoSucursal;
import co.edu.usbcali.modelo.dto.TipoSucursalDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * 
 * 
 */
@ManagedBean
@ViewScoped
public class TipoSucursalView {
	private InputText txtCodigo;
	private InputTextarea txtDescripcion;
	// private InputText txtEstadoRegistro;
	private SelectOneMenu estado;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdTisu;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;

	private String codigo;
	private String descripcion;
	private String estadoRegistro;
	private String operCreador;
	private String operModifica;
	private String idTisu;
	private String fechaCreacion;
	private String fechaModificacion;

	private CommandButton btnCrear;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<TipoSucursalDTO> data;
	private TipoSucursalDTO selectedTipoSucursal;
	private TipoSucursal entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private SelectItem[] manufacturerOptions;

	String manufacturers[] = { "A", "R" };

	public TipoSucursalView() {
		super();
		manufacturerOptions = createFilterOptions(manufacturers);
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			TipoSucursalDTO tipoSucursalDTO = (TipoSucursalDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(tipoSucursalDTO.getCodigo());

			if (txtDescripcion == null) {
				txtDescripcion = new InputTextarea();
			}

			/*
			 * txtDescripcion.setValue(tipoSucursalDTO.getDescripcion());
			 * 
			 * if (txtEstadoRegistro == null) { txtEstadoRegistro = new
			 * InputText(); }
			 * 
			 * txtEstadoRegistro.setValue(tipoSucursalDTO.getEstadoRegistro());
			 */

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(tipoSucursalDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(tipoSucursalDTO.getOperModifica());

			if (txtIdTisu == null) {
				txtIdTisu = new InputText();
			}

			txtIdTisu.setValue(tipoSucursalDTO.getIdTisu());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(tipoSucursalDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(tipoSucursalDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String principalPagina() {
		return "tipoSucursal.xhtml";
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
					.getTipoSucursal(((TipoSucursalDTO) event.getObject())
							.getIdTisu());

			codigo = ((TipoSucursalDTO) event.getObject()).getCodigo();
			entity.setCodigo(codigo);

			descripcion = ((TipoSucursalDTO) event.getObject())
					.getDescripcion();
			entity.setDescripcion(descripcion);

			String usuario =(String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);
			
			entity.setEstadoRegistro(estadoRegistro);
			// entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			// entity.setOperModifica(FacesUtils.checkString(txtOperModifica));

			businessDelegatorView.updateTipoSucursal(entity);
			data = businessDelegatorView.getDataTipoSucursal();
			RequestContext.getCurrentInstance().reset("form:listaTS");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * try {
		 * 
		 * 
		 * System.out.println("entro modificar");
		 * entity.setEstadoRegistro(estadoRegistro);
		 * //entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
		 * //entity
		 * .setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
		 * //entity.setFechaModificacion(new Date());
		 * //entity.setNombre(FacesUtils.checkString(txtNombre));
		 * //entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
		 * //entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
		 * 
		 * businessDelegatorView.updateTipoDivision(entity); data =
		 * businessDelegatorView.getDataTipoDivision();
		 * RequestContext.getCurrentInstance().reset("form:listaTD");
		 * FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED); }
		 * catch (Exception e) { data = null;
		 * FacesUtils.addErrorMessage(e.getMessage()); }
		 */

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("TipoEstado Cancelled",
				((TipoSucursalDTO) event.getObject()).getIdTisu() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((TipoSucursalDTO) event.getObject()).getIdTisu());
	}

	public String actualizar() {
		return "tipoSucursal.xhtml?faces-redirect=true";
	}

	public String action_new() {
		action_clear();
		selectedTipoSucursal = null;
		setShowDialog(true);

		return "";
	}

	public String action_buscar() {
		try {

			entity = businessDelegatorView.getTipoSucursal(selectedTipoSucursal
					.getIdTisu());

			idTisu = entity.getIdTisu() + "";
			codigo = entity.getCodigo();
			descripcion = entity.getDescripcion();

			Format formatter = new SimpleDateFormat("dd-MM-yyyy");
			String s = formatter.format(entity.getFechaCreacion());
			fechaCreacion = s;
			operCreador = entity.getOperCreador();
			s = formatter.format(entity.getFechaModificacion());
			fechaModificacion = s;
			operModifica = entity.getOperModifica();
			estadoRegistro = entity.getEstadoRegistro();

			btnModify.setDisabled(false);

			RequestContext.getCurrentInstance().update("form:panel");
			RequestContext.getCurrentInstance().update("form:dialog");
			RequestContext.getCurrentInstance().update("form:ts");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String action_clear() {
		entity = null;
		selectedTipoSucursal = null;

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
		 * txtEstadoRegistro.setDisabled(true); }
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

		if (txtIdTisu != null) {
			txtIdTisu.setValue(null);
			// txtIdTisu.setDisabled(false);
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
			Long idTisu = new Long(txtIdTisu.getValue().toString());
			entity = businessDelegatorView.getTipoSucursal(idTisu);
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
			txtIdTisu.setDisabled(false);
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
			txtIdTisu.setValue(entity.getIdTisu());
			txtIdTisu.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedTipoSucursal = (TipoSucursalDTO) (evt.getComponent()
				.getAttributes().get("selectedTipoSucursal"));
		txtCodigo.setValue(selectedTipoSucursal.getCodigo());
		txtCodigo.setDisabled(false);
		txtDescripcion.setValue(selectedTipoSucursal.getDescripcion());
		txtDescripcion.setDisabled(false);
		// txtEstadoRegistro.setValue(selectedTipoSucursal.getEstadoRegistro());
		// txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedTipoSucursal.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedTipoSucursal
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedTipoSucursal.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedTipoSucursal.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdTisu.setValue(selectedTipoSucursal.getIdTisu());
		txtIdTisu.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedTipoSucursal == null) && (entity == null)) {
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
			entity = new TipoSucursal();

			HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
					.getExternalContext().getSession(false);
			
			String usuario =(String) session.getAttribute("Usuario");
			
			//Long idTisu = new Long(txtIdTisu.getValue().toString());

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setEstadoRegistro(estadoRegistro);
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));

			// entity.setFechaModificacion(FacesUtils.checkDate(txtFechaModificacion));
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			//entity.setIdTisu(idTisu);
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			//txtOperCreador.setValue(usuario);
			//txtOperModifica.setValue(usuario);
			//entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			//entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			businessDelegatorView.saveTipoSucursal(entity);
			data = businessDelegatorView.getDataTipoSucursal();
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
			action_clear();
			//actualizar();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_crear() {
		action_clear();
		txtIdTisu.setDisabled(false);
		txtCodigo.setDisabled(false);
		txtDescripcion.setDisabled(false);
		// txtEstadoRegistro.setDisabled(false);
		estado.setDisabled(false);
		txtOperCreador.setDisabled(false);
		txtOperModifica.setDisabled(false);

		// txtFechaCreacion.setDisabled(true);
		// txtFechaCreacion.setValue(new Date());
		// txtFechaModificacion.setDisabled(true);
		// txtFechaModificacion.setValue(new Date());

		btnCrear.setDisabled(false);
		btnSave.setDisabled(false);
		btnModify.setDisabled(true);

		return "";
	}

	public String action_modificar() {

		txtIdTisu.setDisabled(true);
		txtCodigo.setDisabled(false);
		txtDescripcion.setDisabled(false);
		// txtEstadoRegistro.setDisabled(false);
		estado.setDisabled(false);
		// txtFechaCreacion.setDisabled(true);
		// txtFechaModificacion.setDisabled(true);
		txtOperCreador.setDisabled(false);
		txtOperModifica.setDisabled(false);

		// btnCrear.setDisabled(true);
		btnSave.setDisabled(false);

		return "";
	}

	public String action_modify() {
		try {

			if (!btnCrear.isDisabled() && btnModify.isDisabled()) {
				action_create();
				data = businessDelegatorView.getDataTipoSucursal();
				RequestContext.getCurrentInstance().update(
						"form:tablaPrincipal");
				return "";
			}

			if (entity == null) {
				Long idTisu = new Long(selectedTipoSucursal.getIdTisu());
				entity = businessDelegatorView.getTipoSucursal(idTisu);
			}

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			entity.setEstadoRegistro(estadoRegistro);
			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));

			entity.setFechaModificacion(new Date());
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			businessDelegatorView.updateTipoSucursal(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

			btnSave.setDisabled(false);

			data = businessDelegatorView.getDataTipoSucursal();
			RequestContext.getCurrentInstance().update("form:tablaPrincipal");
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedTipoSucursal = (TipoSucursalDTO) (evt.getComponent()
					.getAttributes().get("selectedTipoSucursal"));

			Long idTisu = new Long(selectedTipoSucursal.getIdTisu());
			entity = businessDelegatorView.getTipoSucursal(idTisu);
			businessDelegatorView.deleteTipoSucursal(entity);
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
			selectedTipoSucursal = (TipoSucursalDTO) (evt.getComponent()
					.getAttributes().get("selectedTipoSucursal"));

			Long idTisu = new Long(selectedTipoSucursal.getIdTisu());
			entity = businessDelegatorView.getTipoSucursal(idTisu);
			businessDelegatorView.deleteTipoSucursal(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedTipoSucursal);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, String descripcion,
			String estadoRegistro, Date fechaCreacion, Date fechaModificacion,
			Long idTisu, String operCreador, String operModifica)
			throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setDescripcion(FacesUtils.checkString(descripcion));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateTipoSucursal(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("TipoSucursalView").requestRender();
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

	public InputText getTxtIdTisu() {
		return txtIdTisu;
	}

	public void setTxtIdTisu(InputText txtIdTisu) {
		this.txtIdTisu = txtIdTisu;
	}

	public List<TipoSucursalDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataTipoSucursal();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<TipoSucursalDTO> tipoSucursalDTO) {
		this.data = tipoSucursalDTO;
	}

	public TipoSucursalDTO getSelectedTipoSucursal() {
		return selectedTipoSucursal;
	}

	public void setSelectedTipoSucursal(TipoSucursalDTO tipoSucursal) {
		this.selectedTipoSucursal = tipoSucursal;
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

	public String getIdTisu() {
		return idTisu;
	}

	public void setIdTisu(String idTisu) {
		this.idTisu = idTisu;
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

	public SelectItem[] getManufacturerOptions() {
		return manufacturerOptions;
	}

	public void setManufacturerOptions(SelectItem[] manufacturerOptions) {
		this.manufacturerOptions = manufacturerOptions;
	}

}
