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
import co.edu.usbcali.modelo.Causal;
import co.edu.usbcali.modelo.TipoCausal;
import co.edu.usbcali.modelo.dto.CausalDTO;
import co.edu.usbcali.modelo.dto.TipoCausalDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class CausalView {
	private InputText txtCodigo;
	private InputTextarea txtDescripcion;
	private SelectOneMenu estado;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private SelectOneMenu txtIdTcau_TipoCausal;
	private InputText txtIdCusa;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;

	private String codigo;
	private String descripcion;
	private String estadoRegistro;
	private String operCreador;
	private String oOperModifica;
	private Long idTcau_TipoCausal;
	private String idCusa;
	private String fechaCreacion;
	private String fechaModificacion;
	private Map<String, String> tipoCausales = new HashMap<String, String>();

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<CausalDTO> data;
	private CausalDTO selectedCausal;
	private Causal entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectItem[] manufacturerOptions;

	String manufacturers[] = { "A", "R" };

	public CausalView() {
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
			entity = businessDelegatorView.getCausal(((CausalDTO) event
					.getObject()).getIdCusa());

			// entity.setCodigo(Long.parseLong(txtCodigo.getValue()+""));
			entity.setFechaModificacion(new Date());

			entity.setCodigo(((CausalDTO) event.getObject()).getCodigo());

			entity.setEstadoRegistro(estadoRegistro);

			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);

			descripcion = ((CausalDTO) event.getObject()).getDescripcion();
			entity.setDescripcion(descripcion);

			TipoCausal entity2 = businessDelegatorView
					.getTipoCausal(getIdTcau_TipoCausal());
			entity.setTipoCausal(entity2);

			// entity.setCodigo(FacesUtils.checkLong(txtCodigo));
			// System.out.println( idForanea() + "; " + getIdTcau_TipoCausal() +
			// "; " + getSelectedCausal() + "; " + getData() );

			// TipoCausal entity2 =
			// businessDelegatorView.getTipoCausal(getIdTcau_TipoCausal());
			// TipoCausal entity3 =
			// businessDelegatorView.getTipoCausal(idTcau_TipoCausal);

			// System.out.println("entyty2:" + entity3);
			// entity.setTipoCausal(entity3);

			businessDelegatorView.updateCausal(entity);
			data = businessDelegatorView.getDataCausal();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Cancelled",
				((CausalDTO) event.getObject()).getIdCusa() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((CausalDTO) event.getObject()).getIdCusa());
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			CausalDTO causalDTO = (CausalDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(causalDTO.getCodigo());

			if (txtDescripcion == null) {
				txtDescripcion = new InputTextarea();
			}

			txtDescripcion.setValue(causalDTO.getDescripcion());
			/*
			 * if (txtEstadoRegistro == null) { txtEstadoRegistro = new
			 * InputText(); }
			 */

			// txtEstadoRegistro.setValue(causalDTO.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(causalDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(causalDTO.getOperModifica());

			if (txtIdTcau_TipoCausal == null) {
				txtIdTcau_TipoCausal = new SelectOneMenu();
			}

			txtIdTcau_TipoCausal.setValue(causalDTO.getIdTcau_TipoCausal());

			if (txtIdCusa == null) {
				txtIdCusa = new InputText();
			}

			txtIdCusa.setValue(causalDTO.getIdCusa());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(causalDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(causalDTO.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedCausal = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedCausal = null;

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

		if (txtIdTcau_TipoCausal != null) {
			txtIdTcau_TipoCausal.setValue(null);
			// txtIdTcau_TipoCausal.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			// txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			// txtFechaModificacion.setDisabled(true);
		}

		if (txtIdCusa != null) {
			txtIdCusa.setValue(null);
			// txtIdCusa.setDisabled(false);
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
			Long idCusa = new Long(txtIdCusa.getValue().toString());
			entity = businessDelegatorView.getCausal(idCusa);
		} catch (Exception e) {

		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtDescripcion.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdTcau_TipoCausal.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdCusa.setDisabled(false);
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
			txtIdTcau_TipoCausal.setValue(entity.getTipoCausal().getIdTcau());
			txtIdTcau_TipoCausal.setDisabled(false);
			txtIdCusa.setValue(entity.getIdCusa());
			txtIdCusa.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedCausal = (CausalDTO) (evt.getComponent().getAttributes()
				.get("selectedCausal"));
		txtCodigo.setValue(selectedCausal.getCodigo());
		txtCodigo.setDisabled(false);
		txtDescripcion.setValue(selectedCausal.getDescripcion());
		txtDescripcion.setDisabled(false);
		// txtEstadoRegistro.setValue(selectedCausal.getEstadoRegistro());
		// txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedCausal.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedCausal.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedCausal.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedCausal.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdTcau_TipoCausal.setValue(selectedCausal.getIdTcau_TipoCausal());
		txtIdTcau_TipoCausal.setDisabled(false);
		txtIdCusa.setValue(selectedCausal.getIdCusa());
		txtIdCusa.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedCausal == null) && (entity == null)) {
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
			entity = new Causal();

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			// Long idCusa = new Long(txtIdCusa.getValue().toString());

			entity.setCodigo(FacesUtils.checkLong(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setEstadoRegistro(estadoRegistro);

			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			// entity.setIdCusa(idCusa);

			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			// entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			// entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			/*
			 * TipoCausal entity2 = businessDelegatorView
			 * .getTipoCausal(idForanea());
			 */

			// System.out.println(entity2 + "; " + idForanea() + "; " +
			// getIdTcau_TipoCausal() + "; " + getSelectedCausal() + "; " +
			// getData() );

			TipoCausal entity2 = businessDelegatorView
					.getTipoCausal(getIdTcau_TipoCausal());
			entity.setTipoCausal(entity2);

			businessDelegatorView.saveCausal(entity);
			data = businessDelegatorView.getDataCausal();
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
				Long idCusa = new Long(selectedCausal.getIdCusa());
				entity = businessDelegatorView.getCausal(idCusa);
			}

			entity.setCodigo(FacesUtils.checkLong(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			TipoCausal entity2 = businessDelegatorView
					.getTipoCausal(idForanea());

			entity.setTipoCausal(entity2);
			businessDelegatorView.updateCausal(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public Long idForanea() {

		try {
			List<TipoCausalDTO> data2 = businessDelegatorView
					.getDataTipoCausal();
			for (int i = 0; i < data2.size(); i++) {
				if (txtIdTcau_TipoCausal.getValue().equals(
						data2.get(i).getNombre())) {
					return data2.get(i).getIdTcau();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0L;
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedCausal = (CausalDTO) (evt.getComponent().getAttributes()
					.get("selectedCausal"));

			Long idCusa = new Long(selectedCausal.getIdCusa());
			entity = businessDelegatorView.getCausal(idCusa);
			businessDelegatorView.deleteCausal(entity);
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
			selectedCausal = (CausalDTO) (evt.getComponent().getAttributes()
					.get("selectedCausal"));

			Long idCusa = new Long(selectedCausal.getIdCusa());
			entity = businessDelegatorView.getCausal(idCusa);
			businessDelegatorView.deleteCausal(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedCausal);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long codigo, String descripcion,
			String estadoRegistro, Date fechaCreacion, Date fechaModificacion,
			Long idCusa, String operCreador, String operModifica,
			Long idTcau_TipoCausal) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkLong(codigo));
			entity.setDescripcion(FacesUtils.checkString(descripcion));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateCausal(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("CausalView").requestRender();
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

	public SelectOneMenu getTxtIdTcau_TipoCausal() {
		return txtIdTcau_TipoCausal;
	}

	public void setTxtIdTcau_TipoCausal(SelectOneMenu txtIdTcau_TipoCausal) {
		this.txtIdTcau_TipoCausal = txtIdTcau_TipoCausal;
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

	public InputText getTxtIdCusa() {
		return txtIdCusa;
	}

	public void setTxtIdCusa(InputText txtIdCusa) {
		this.txtIdCusa = txtIdCusa;
	}

	public List<CausalDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataCausal();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<CausalDTO> causalDTO) {
		this.data = causalDTO;
	}

	public CausalDTO getSelectedCausal() {
		return selectedCausal;
	}

	public void setSelectedCausal(CausalDTO causal) {
		this.selectedCausal = causal;
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

	public String getoOperModifica() {
		return oOperModifica;
	}

	public void setoOperModifica(String oOperModifica) {
		this.oOperModifica = oOperModifica;
	}

	public Long getIdTcau_TipoCausal() {
		return idTcau_TipoCausal;
	}

	public void setIdTcau_TipoCausal(Long idTcau_TipoCausal) {
		this.idTcau_TipoCausal = idTcau_TipoCausal;
	}

	public String getIdCusa() {
		return idCusa;
	}

	public void setIdCusa(String idCusa) {
		this.idCusa = idCusa;
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

	public Map<String, String> getTipoCausales() {
		try {
			List<TipoCausalDTO> data2 = businessDelegatorView
					.getDataTipoCausal();
			for (int i = 0; i < data2.size(); i++) {
				tipoCausales.put(data2.get(i).getNombre(), data2.get(i)
						.getIdTcau() + "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tipoCausales;
	}

	public void setTipoCausales(Map<String, String> tipoCausales) {
		this.tipoCausales = tipoCausales;
	}

}
