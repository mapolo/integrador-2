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
import co.edu.usbcali.modelo.TipoCausal;
import co.edu.usbcali.modelo.dto.TipoCausalDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class TipoCausalView {
	// private InputText txtEstadoRegistro;
	private SelectOneMenu estado;
	private InputText txtNombre;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdTcau;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;

	private String estadoRegistro;
	private String nombre;
	private String operCreador;
	private String operModifica;
	private String idTcau;
	private String fechaCreacion;
	private String fechaModificacion;

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<TipoCausalDTO> data;
	private TipoCausalDTO selectedTipoCausal;
	private TipoCausal entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectItem[] manufacturerOptions;

	String manufacturers[] = { "A", "R" };

	public TipoCausalView() {
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
			entity = businessDelegatorView.getTipoCausal(((TipoCausalDTO) event
					.getObject()).getIdTcau());

			entity.setEstadoRegistro(estadoRegistro);
			
			nombre = ((TipoCausalDTO) event.getObject()).getNombre();
			entity.setNombre(nombre);

			String usuario =(String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);

			
			businessDelegatorView.updateTipoCausal(entity);
			data = businessDelegatorView.getDataTipoCausal();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Cancelled",
				((TipoCausalDTO) event.getObject()).getIdTcau() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((TipoCausalDTO) event.getObject()).getIdTcau());
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			TipoCausalDTO tipoCausalDTO = (TipoCausalDTO) e.getObject();

			/*
			 * if (txtEstadoRegistro == null) { txtEstadoRegistro = new
			 * InputText(); }
			 * 
			 * txtEstadoRegistro.setValue(tipoCausalDTO.getEstadoRegistro());
			 */
			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(tipoCausalDTO.getNombre());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(tipoCausalDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(tipoCausalDTO.getOperModifica());

			if (txtIdTcau == null) {
				txtIdTcau = new InputText();
			}

			txtIdTcau.setValue(tipoCausalDTO.getIdTcau());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(tipoCausalDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(tipoCausalDTO.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedTipoCausal = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedTipoCausal = null;

		/*
		 * if (txtEstadoRegistro != null) { txtEstadoRegistro.setValue(null);
		 * txtEstadoRegistro.setDisabled(true); }
		 */

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

		if (txtIdTcau != null) {
			txtIdTcau.setValue(null);
			// txtIdTcau.setDisabled(false);
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
			Long idTcau = new Long(txtIdTcau.getValue().toString());
			entity = businessDelegatorView.getTipoCausal(idTcau);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			// txtEstadoRegistro.setDisabled(false);
			txtNombre.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdTcau.setDisabled(false);
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
			txtIdTcau.setValue(entity.getIdTcau());
			txtIdTcau.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedTipoCausal = (TipoCausalDTO) (evt.getComponent()
				.getAttributes().get("selectedTipoCausal"));
		// txtEstadoRegistro.setValue(selectedTipoCausal.getEstadoRegistro());
		// txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedTipoCausal.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion
				.setValue(selectedTipoCausal.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtNombre.setValue(selectedTipoCausal.getNombre());
		txtNombre.setDisabled(false);
		txtOperCreador.setValue(selectedTipoCausal.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedTipoCausal.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdTcau.setValue(selectedTipoCausal.getIdTcau());
		txtIdTcau.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedTipoCausal == null) && (entity == null)) {
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
			entity = new TipoCausal();
			
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
					.getExternalContext().getSession(false);
			
			String usuario =(String) session.getAttribute("Usuario");

			//Long idTcau = new Long(txtIdTcau.getValue().toString());

			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setEstadoRegistro(estadoRegistro);
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			//entity.setIdTcau(idTcau);
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			
			//txtOperCreador.setValue(usuario);
			//txtOperModifica.setValue(usuario);
			//entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			//entity.setOperModifica(FacesUtils.checkString(txtOperModifica));

			businessDelegatorView.saveTipoCausal(entity);
			data = businessDelegatorView.getDataTipoCausal();
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
				Long idTcau = new Long(selectedTipoCausal.getIdTcau());
				entity = businessDelegatorView.getTipoCausal(idTcau);
			}

			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			businessDelegatorView.updateTipoCausal(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedTipoCausal = (TipoCausalDTO) (evt.getComponent()
					.getAttributes().get("selectedTipoCausal"));

			Long idTcau = new Long(selectedTipoCausal.getIdTcau());
			entity = businessDelegatorView.getTipoCausal(idTcau);
			businessDelegatorView.deleteTipoCausal(entity);
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
			selectedTipoCausal = (TipoCausalDTO) (evt.getComponent()
					.getAttributes().get("selectedTipoCausal"));

			Long idTcau = new Long(selectedTipoCausal.getIdTcau());
			entity = businessDelegatorView.getTipoCausal(idTcau);
			businessDelegatorView.deleteTipoCausal(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedTipoCausal);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idTcau,
			String nombre, String operCreador, String operModifica)
			throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateTipoCausal(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("TipoCausalView").requestRender();
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

	public InputText getTxtIdTcau() {
		return txtIdTcau;
	}

	public void setTxtIdTcau(InputText txtIdTcau) {
		this.txtIdTcau = txtIdTcau;
	}

	public List<TipoCausalDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataTipoCausal();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<TipoCausalDTO> tipoCausalDTO) {
		this.data = tipoCausalDTO;
	}

	public TipoCausalDTO getSelectedTipoCausal() {
		return selectedTipoCausal;
	}

	public void setSelectedTipoCausal(TipoCausalDTO tipoCausal) {
		this.selectedTipoCausal = tipoCausal;
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

	public String getIdTcau() {
		return idTcau;
	}

	public void setIdTcau(String idTcau) {
		this.idTcau = idTcau;
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
