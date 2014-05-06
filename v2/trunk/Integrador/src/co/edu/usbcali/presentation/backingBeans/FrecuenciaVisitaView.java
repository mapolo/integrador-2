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
import co.edu.usbcali.modelo.FrecuenciaVisita;
import co.edu.usbcali.modelo.dto.FrecuenciaVisitaDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class FrecuenciaVisitaView {
	private InputText txtCodigo;
	private InputTextarea txtDescripcion;
	private SelectOneMenu estado;
	private InputText txtFrecuencia;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdFrvi;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;

	private String codigo;
	private String descripcion;
	private String estadoRegistro;
	private String frecuencia;
	private String operCreador;
	private String operModifica;
	private String idFrvi;
	private String fechaCreacion;
	private String gechaModificacion;

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<FrecuenciaVisitaDTO> data;
	private FrecuenciaVisitaDTO selectedFrecuenciaVisita;
	private FrecuenciaVisita entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectItem[] manufacturerOptions;

	String manufacturers[] = { "A", "R" };

	public FrecuenciaVisitaView() {
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
			entity = businessDelegatorView
					.getFrecuenciaVisita(((FrecuenciaVisitaDTO) event
							.getObject()).getIdFrvi());

			// entity.setCodigo(Long.parseLong(txtCodigo.getValue()+""));

			entity.setCodigo(((FrecuenciaVisitaDTO) event.getObject())
					.getCodigo());
			entity.setFrecuencia(((FrecuenciaVisitaDTO) event.getObject())
					.getFrecuencia());

			entity.setEstadoRegistro(estadoRegistro);

			entity.setFechaModificacion(new Date());

			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);

			descripcion = ((FrecuenciaVisitaDTO) event.getObject())
					.getDescripcion();
			entity.setDescripcion(descripcion);

			businessDelegatorView.updateFrecuenciaVisita(entity);
			data = businessDelegatorView.getDataFrecuenciaVisita();
			RequestContext.getCurrentInstance().reset("form:listaFV");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Cancelled",
				((FrecuenciaVisitaDTO) event.getObject()).getIdFrvi() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((FrecuenciaVisitaDTO) event.getObject()).getIdFrvi());
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			FrecuenciaVisitaDTO frecuenciaVisitaDTO = (FrecuenciaVisitaDTO) e
					.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(frecuenciaVisitaDTO.getCodigo());

			if (txtDescripcion == null) {
				txtDescripcion = new InputTextarea();
			}

			txtDescripcion.setValue(frecuenciaVisitaDTO.getDescripcion());

			/*
			 * if (txtEstadoRegistro == null) { txtEstadoRegistro = new
			 * InputText(); }
			 * 
			 * txtEstadoRegistro.setValue(frecuenciaVisitaDTO.getEstadoRegistro()
			 * );
			 */

			if (txtFrecuencia == null) {
				txtFrecuencia = new InputText();
			}

			txtFrecuencia.setValue(frecuenciaVisitaDTO.getFrecuencia());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(frecuenciaVisitaDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(frecuenciaVisitaDTO.getOperModifica());

			if (txtIdFrvi == null) {
				txtIdFrvi = new InputText();
			}

			txtIdFrvi.setValue(frecuenciaVisitaDTO.getIdFrvi());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(frecuenciaVisitaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(frecuenciaVisitaDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedFrecuenciaVisita = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedFrecuenciaVisita = null;

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

		if (txtFrecuencia != null) {
			txtFrecuencia.setValue(null);
			// txtFrecuencia.setDisabled(true);
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

		if (txtIdFrvi != null) {
			txtIdFrvi.setValue(null);
			// txtIdFrvi.setDisabled(false);
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
			Long idFrvi = new Long(txtIdFrvi.getValue().toString());
			entity = businessDelegatorView.getFrecuenciaVisita(idFrvi);
		} catch (Exception e) {

		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtDescripcion.setDisabled(false);
			txtFrecuencia.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdFrvi.setDisabled(false);
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
			txtFrecuencia.setValue(entity.getFrecuencia());
			txtFrecuencia.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdFrvi.setValue(entity.getIdFrvi());
			txtIdFrvi.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedFrecuenciaVisita = (FrecuenciaVisitaDTO) (evt.getComponent()
				.getAttributes().get("selectedFrecuenciaVisita"));
		txtCodigo.setValue(selectedFrecuenciaVisita.getCodigo());
		txtCodigo.setDisabled(false);
		txtDescripcion.setValue(selectedFrecuenciaVisita.getDescripcion());
		txtDescripcion.setDisabled(false);
		/*
		 * txtEstadoRegistro
		 * .setValue(selectedFrecuenciaVisita.getEstadoRegistro());
		 */
		// txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedFrecuenciaVisita.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedFrecuenciaVisita
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtFrecuencia.setValue(selectedFrecuenciaVisita.getFrecuencia());
		txtFrecuencia.setDisabled(false);
		txtOperCreador.setValue(selectedFrecuenciaVisita.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedFrecuenciaVisita.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdFrvi.setValue(selectedFrecuenciaVisita.getIdFrvi());
		txtIdFrvi.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedFrecuenciaVisita == null) && (entity == null)) {
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
			entity = new FrecuenciaVisita();

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			// Long idFrvi = new Long(txtIdFrvi.getValue().toString());

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setEstadoRegistro(estadoRegistro);

			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());

			entity.setFrecuencia(FacesUtils.checkLong(txtFrecuencia));
			// entity.setIdFrvi(idFrvi);

			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			// entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			// entity.setOperModifica(FacesUtils.checkString(txtOperModifica));

			businessDelegatorView.saveFrecuenciaVisita(entity);
			data = businessDelegatorView.getDataFrecuenciaVisita();
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
				Long idFrvi = new Long(selectedFrecuenciaVisita.getIdFrvi());
				entity = businessDelegatorView.getFrecuenciaVisita(idFrvi);
			}

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFrecuencia(FacesUtils.checkLong(txtFrecuencia));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			businessDelegatorView.updateFrecuenciaVisita(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedFrecuenciaVisita = (FrecuenciaVisitaDTO) (evt
					.getComponent().getAttributes()
					.get("selectedFrecuenciaVisita"));

			Long idFrvi = new Long(selectedFrecuenciaVisita.getIdFrvi());
			entity = businessDelegatorView.getFrecuenciaVisita(idFrvi);
			businessDelegatorView.deleteFrecuenciaVisita(entity);
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
			selectedFrecuenciaVisita = (FrecuenciaVisitaDTO) (evt
					.getComponent().getAttributes()
					.get("selectedFrecuenciaVisita"));

			Long idFrvi = new Long(selectedFrecuenciaVisita.getIdFrvi());
			entity = businessDelegatorView.getFrecuenciaVisita(idFrvi);
			businessDelegatorView.deleteFrecuenciaVisita(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedFrecuenciaVisita);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, String descripcion,
			String estadoRegistro, Date fechaCreacion, Date fechaModificacion,
			Long frecuencia, Long idFrvi, String operCreador,
			String operModifica) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setDescripcion(FacesUtils.checkString(descripcion));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFrecuencia(FacesUtils.checkLong(frecuencia));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateFrecuenciaVisita(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("FrecuenciaVisitaView").requestRender();
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

	public InputText getTxtFrecuencia() {
		return txtFrecuencia;
	}

	public void setTxtFrecuencia(InputText txtFrecuencia) {
		this.txtFrecuencia = txtFrecuencia;
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

	public InputText getTxtIdFrvi() {
		return txtIdFrvi;
	}

	public void setTxtIdFrvi(InputText txtIdFrvi) {
		this.txtIdFrvi = txtIdFrvi;
	}

	public List<FrecuenciaVisitaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataFrecuenciaVisita();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<FrecuenciaVisitaDTO> frecuenciaVisitaDTO) {
		this.data = frecuenciaVisitaDTO;
	}

	public FrecuenciaVisitaDTO getSelectedFrecuenciaVisita() {
		return selectedFrecuenciaVisita;
	}

	public void setSelectedFrecuenciaVisita(FrecuenciaVisitaDTO frecuenciaVisita) {
		this.selectedFrecuenciaVisita = frecuenciaVisita;
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

	public String getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
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

	public String getIdFrvi() {
		return idFrvi;
	}

	public void setIdFrvi(String idFrvi) {
		this.idFrvi = idFrvi;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getGechaModificacion() {
		return gechaModificacion;
	}

	public void setGechaModificacion(String gechaModificacion) {
		this.gechaModificacion = gechaModificacion;
	}

	public SelectItem[] getManufacturerOptions() {
		return manufacturerOptions;
	}

	public void setManufacturerOptions(SelectItem[] manufacturerOptions) {
		this.manufacturerOptions = manufacturerOptions;
	}

}
