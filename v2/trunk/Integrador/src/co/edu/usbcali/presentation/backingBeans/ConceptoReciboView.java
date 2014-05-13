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
import co.edu.usbcali.modelo.ConceptoRecibo;
import co.edu.usbcali.modelo.dto.ConceptoReciboDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class ConceptoReciboView {
	private InputText txtAplicaCartera;
	private InputText txtCodigo;
	private InputTextarea txtDescripcion;
	private SelectOneMenu estado;
	private SelectOneMenu aaplicaCartea;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdCpto;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;

	private String aplicaCartera;
	private String codigo;
	private String descripcion;
	private String estadoRegistro;
	private String operCreador;
	private String operModifica;
	private String idCpto;
	private String fechaCreacion;
	private String fechaModificacion;

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnModify2;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ConceptoReciboDTO> data;
	private ConceptoReciboDTO selectedConceptoRecibo;
	private ConceptoRecibo entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectItem[] manufacturerOptions;
	private SelectItem[] manufacturerOptions2;

	String manufacturers[] = { "A", "R" };
	String manufacturers2[] = { "S", "N" };

	public ConceptoReciboView() {
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
					.getConceptoRecibo(((ConceptoReciboDTO) event.getObject())
							.getIdCpto());

			descripcion = ((ConceptoReciboDTO) event.getObject())
					.getDescripcion();
			entity.setDescripcion(descripcion);
			codigo = ((ConceptoReciboDTO) event.getObject()).getCodigo();
			entity.setCodigo(codigo);

			entity.setEstadoRegistro(estadoRegistro);
			entity.setAplicaCartera(aplicaCartera);

			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);

			businessDelegatorView.updateConceptoRecibo(entity);
			data = businessDelegatorView.getDataConceptoRecibo();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Cancelled",
				((ConceptoReciboDTO) event.getObject()).getIdCpto() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((ConceptoReciboDTO) event.getObject()).getIdCpto());
	}

	public String action_modify2() {
		try {

			btnSave.setDisabled(true);
			btnModify.setDisabled(false);

			try {
				txtDescripcion
						.setValue(selectedConceptoRecibo.getDescripcion());

			} catch (Exception e) {
				txtDescripcion.setValue("");
			}

			try {
				aaplicaCartea.setValue(selectedConceptoRecibo
						.getAplicaCartera());

			} catch (Exception e) {
				aaplicaCartea.setValue("");
			}

			try {
				txtCodigo.setValue(selectedConceptoRecibo.getCodigo());

			} catch (Exception e) {
				txtCodigo.setValue("");
			}

			try {
				estado.setValue(selectedConceptoRecibo.getEstadoRegistro());
			} catch (Exception e) {
				estado.setValue("");
			}

			txtIdCpto.setValue(selectedConceptoRecibo.getIdCpto());

		} catch (Exception e) {
			if (selectedConceptoRecibo == null) {
				FacesUtils
						.addErrorMessage("Seleccione el Concepto del Recibo a Modificar");
			}
		}
		return "";

	}

	public String action_VCrear() {

		btnModify.setDisabled(true);
		btnSave.setDisabled(false);

		try {
			txtDescripcion.setValue(null);

		} catch (Exception e) {
			txtDescripcion.setValue("");
		}

		try {
			aaplicaCartea.setValue(null);

		} catch (Exception e) {
			aaplicaCartea.setValue("");
		}

		try {
			txtCodigo.setValue(null);

		} catch (Exception e) {
			txtCodigo.setValue("");
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
			ConceptoReciboDTO conceptoReciboDTO = (ConceptoReciboDTO) e
					.getObject();

			if (txtAplicaCartera == null) {
				txtAplicaCartera = new InputText();
			}

			txtAplicaCartera.setValue(conceptoReciboDTO.getAplicaCartera());

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(conceptoReciboDTO.getCodigo());

			if (txtDescripcion == null) {
				txtDescripcion = new InputTextarea();
			}

			txtDescripcion.setValue(conceptoReciboDTO.getDescripcion());

			/*
			 * if (txtEstadoRegistro == null) { txtEstadoRegistro = new
			 * InputText(); }
			 * 
			 * txtEstadoRegistro.setValue(conceptoReciboDTO.getEstadoRegistro());
			 */

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(conceptoReciboDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(conceptoReciboDTO.getOperModifica());

			if (txtIdCpto == null) {
				txtIdCpto = new InputText();
			}

			txtIdCpto.setValue(conceptoReciboDTO.getIdCpto());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(conceptoReciboDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(conceptoReciboDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedConceptoRecibo = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedConceptoRecibo = null;

		if (txtAplicaCartera != null) {
			txtAplicaCartera.setValue(null);
			// txtAplicaCartera.setDisabled(true);
		}

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

		if (txtIdCpto != null) {
			txtIdCpto.setValue(null);
			// txtIdCpto.setDisabled(false);
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
			Long idCpto = new Long(txtIdCpto.getValue().toString());
			entity = businessDelegatorView.getConceptoRecibo(idCpto);
		} catch (Exception e) {

		}

		if (entity == null) {
			txtAplicaCartera.setDisabled(false);
			txtCodigo.setDisabled(false);
			txtDescripcion.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdCpto.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtAplicaCartera.setValue(entity.getAplicaCartera());
			txtAplicaCartera.setDisabled(false);
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
			txtIdCpto.setValue(entity.getIdCpto());
			txtIdCpto.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedConceptoRecibo = (ConceptoReciboDTO) (evt.getComponent()
				.getAttributes().get("selectedConceptoRecibo"));
		txtAplicaCartera.setValue(selectedConceptoRecibo.getAplicaCartera());
		txtAplicaCartera.setDisabled(false);
		txtCodigo.setValue(selectedConceptoRecibo.getCodigo());
		txtCodigo.setDisabled(false);
		txtDescripcion.setValue(selectedConceptoRecibo.getDescripcion());
		txtDescripcion.setDisabled(false);
		// txtEstadoRegistro.setValue(selectedConceptoRecibo.getEstadoRegistro());
		// txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedConceptoRecibo.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedConceptoRecibo
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedConceptoRecibo.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedConceptoRecibo.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdCpto.setValue(selectedConceptoRecibo.getIdCpto());
		txtIdCpto.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedConceptoRecibo == null) && (entity == null)) {
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
			entity = new ConceptoRecibo();

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			// Long idCpto = new Long(txtIdCpto.getValue().toString());

			// entity.setAplicaCartera(FacesUtils.checkString(txtAplicaCartera));
			entity.setAplicaCartera(aplicaCartera);
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setEstadoRegistro(estadoRegistro);
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			// entity.setIdCpto(idCpto);
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);

			// txtOperCreador.setValue(usuario);
			// txtOperModifica.setValue(usuario);
			// entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			// entity.setOperModifica(FacesUtils.checkString(txtOperModifica));

			businessDelegatorView.saveConceptoRecibo(entity);
			data = businessDelegatorView.getDataConceptoRecibo();
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
				Long idCpto = new Long(selectedConceptoRecibo.getIdCpto());
				entity = businessDelegatorView.getConceptoRecibo(idCpto);
			}

			Long idCpto = new Long(selectedConceptoRecibo.getIdCpto());
			entity = businessDelegatorView.getConceptoRecibo(idCpto);

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			entity.setAplicaCartera(aplicaCartera);
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));

			entity.setEstadoRegistro(estadoRegistro);
			entity.setFechaModificacion(new Date());
			entity.setOperModifica(usuario);

			businessDelegatorView.updateConceptoRecibo(entity);
			data = businessDelegatorView.getDataConceptoRecibo();
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
			selectedConceptoRecibo = (ConceptoReciboDTO) (evt.getComponent()
					.getAttributes().get("selectedConceptoRecibo"));

			Long idCpto = new Long(selectedConceptoRecibo.getIdCpto());
			entity = businessDelegatorView.getConceptoRecibo(idCpto);
			businessDelegatorView.deleteConceptoRecibo(entity);
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
			selectedConceptoRecibo = (ConceptoReciboDTO) (evt.getComponent()
					.getAttributes().get("selectedConceptoRecibo"));

			Long idCpto = new Long(selectedConceptoRecibo.getIdCpto());
			entity = businessDelegatorView.getConceptoRecibo(idCpto);
			businessDelegatorView.deleteConceptoRecibo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedConceptoRecibo);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String aplicaCartera, String codigo,
			String descripcion, String estadoRegistro, Date fechaCreacion,
			Date fechaModificacion, Long idCpto, String operCreador,
			String operModifica) throws Exception {
		try {
			entity.setAplicaCartera(FacesUtils.checkString(aplicaCartera));
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setDescripcion(FacesUtils.checkString(descripcion));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateConceptoRecibo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ConceptoReciboView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtAplicaCartera() {
		return txtAplicaCartera;
	}

	public void setTxtAplicaCartera(InputText txtAplicaCartera) {
		this.txtAplicaCartera = txtAplicaCartera;
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

	public InputText getTxtIdCpto() {
		return txtIdCpto;
	}

	public void setTxtIdCpto(InputText txtIdCpto) {
		this.txtIdCpto = txtIdCpto;
	}

	public List<ConceptoReciboDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataConceptoRecibo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ConceptoReciboDTO> conceptoReciboDTO) {
		this.data = conceptoReciboDTO;
	}

	public ConceptoReciboDTO getSelectedConceptoRecibo() {
		return selectedConceptoRecibo;
	}

	public void setSelectedConceptoRecibo(ConceptoReciboDTO conceptoRecibo) {
		this.selectedConceptoRecibo = conceptoRecibo;
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

	public String getAplicaCartera() {
		return aplicaCartera;
	}

	public void setAplicaCartera(String aplicaCartera) {
		this.aplicaCartera = aplicaCartera;
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

	public String getIdCpto() {
		return idCpto;
	}

	public void setIdCpto(String idCpto) {
		this.idCpto = idCpto;
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

	public SelectItem[] getManufacturerOptions2() {
		return manufacturerOptions2;
	}

	public void setManufacturerOptions2(SelectItem[] manufacturerOptions2) {
		this.manufacturerOptions2 = manufacturerOptions2;
	}

	public SelectOneMenu getAaplicaCartea() {
		return aaplicaCartea;
	}

	public void setAaplicaCartea(SelectOneMenu aaplicaCartea) {
		this.aaplicaCartea = aaplicaCartea;
	}

	public CommandButton getBtnModify2() {
		return btnModify2;
	}

	public void setBtnModify2(CommandButton btnModify2) {
		this.btnModify2 = btnModify2;
	}

}
