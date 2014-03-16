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

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.ClaveFabricacion;
import co.edu.usbcali.modelo.dto.ClaveFabricacionDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class ClaveFabricacionView {
	private InputText txtCodigo;
	// private InputText txtEstadoRegistro;
	private SelectOneMenu estado;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdClfa;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;
	private Calendar txtFechaFinal;
	private Calendar txtFechaInicial;

	private String codigo;
	private String estadoRegistro;
	private String operCreador;
	private String operModifica;
	private String idClfa;
	private String fechaCreacion;
	private String fechaModificacion;
	private String fechaFinal;
	private String fechaInicial;

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ClaveFabricacionDTO> data;
	private ClaveFabricacionDTO selectedClaveFabricacion;
	private ClaveFabricacion entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectItem[] manufacturerOptions;

	String manufacturers[] = { "A", "R" };

	public ClaveFabricacionView() {
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
					.getClaveFabricacion(((ClaveFabricacionDTO) event
							.getObject()).getIdClfa());

			codigo = ((ClaveFabricacionDTO) event.getObject()).getCodigo();
			entity.setCodigo(codigo);

			entity.setEstadoRegistro(estadoRegistro);
			
			String usuario =(String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);

			businessDelegatorView.updateClaveFabricacion(entity);
			data = businessDelegatorView.getDataClaveFabricacion();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Cancelled",
				((ClaveFabricacionDTO) event.getObject()).getIdClfa() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((ClaveFabricacionDTO) event.getObject()).getIdClfa());
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ClaveFabricacionDTO claveFabricacionDTO = (ClaveFabricacionDTO) e
					.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(claveFabricacionDTO.getCodigo());
			/*
			 * if (txtEstadoRegistro == null) { txtEstadoRegistro = new
			 * InputText(); }
			 * 
			 * txtEstadoRegistro.setValue(claveFabricacionDTO.getEstadoRegistro()
			 * );
			 */

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(claveFabricacionDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(claveFabricacionDTO.getOperModifica());

			if (txtIdClfa == null) {
				txtIdClfa = new InputText();
			}

			txtIdClfa.setValue(claveFabricacionDTO.getIdClfa());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(claveFabricacionDTO.getFechaCreacion());

			if (txtFechaFinal == null) {
				txtFechaFinal = new Calendar();
			}

			txtFechaFinal.setValue(claveFabricacionDTO.getFechaFinal());

			if (txtFechaInicial == null) {
				txtFechaInicial = new Calendar();
			}

			txtFechaInicial.setValue(claveFabricacionDTO.getFechaInicial());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(claveFabricacionDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedClaveFabricacion = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedClaveFabricacion = null;

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			// txtCodigo.setDisabled(true);
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

		if (txtIdClfa != null) {
			txtIdClfa.setValue(null);
			// txtIdClfa.setDisabled(false);
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
			Long idClfa = new Long(txtIdClfa.getValue().toString());
			entity = businessDelegatorView.getClaveFabricacion(idClfa);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			// txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdClfa.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
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
			txtIdClfa.setValue(entity.getIdClfa());
			txtIdClfa.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedClaveFabricacion = (ClaveFabricacionDTO) (evt.getComponent()
				.getAttributes().get("selectedClaveFabricacion"));
		txtCodigo.setValue(selectedClaveFabricacion.getCodigo());
		txtCodigo.setDisabled(false);
		/*
		 * txtEstadoRegistro
		 * .setValue(selectedClaveFabricacion.getEstadoRegistro());
		 */
		// txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedClaveFabricacion.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaFinal.setValue(selectedClaveFabricacion.getFechaFinal());
		txtFechaFinal.setDisabled(false);
		txtFechaInicial.setValue(selectedClaveFabricacion.getFechaInicial());
		txtFechaInicial.setDisabled(false);
		txtFechaModificacion.setValue(selectedClaveFabricacion
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedClaveFabricacion.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedClaveFabricacion.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdClfa.setValue(selectedClaveFabricacion.getIdClfa());
		txtIdClfa.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedClaveFabricacion == null) && (entity == null)) {
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
			entity = new ClaveFabricacion();
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
					.getExternalContext().getSession(false);
			
			String usuario =(String) session.getAttribute("Usuario");
			
			//Long idClfa = new Long(txtIdClfa.getValue().toString());

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setEstadoRegistro(estadoRegistro);
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			//entity.setIdClfa(idClfa);
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			
			//txtOperCreador.setValue(usuario);
			//txtOperModifica.setValue(usuario);
			//entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			//entity.setOperModifica(FacesUtils.checkString(txtOperModifica));

			businessDelegatorView.saveClaveFabricacion(entity);
			data = businessDelegatorView.getDataClaveFabricacion();
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
				Long idClfa = new Long(selectedClaveFabricacion.getIdClfa());
				entity = businessDelegatorView.getClaveFabricacion(idClfa);
			}

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			businessDelegatorView.updateClaveFabricacion(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedClaveFabricacion = (ClaveFabricacionDTO) (evt
					.getComponent().getAttributes()
					.get("selectedClaveFabricacion"));

			Long idClfa = new Long(selectedClaveFabricacion.getIdClfa());
			entity = businessDelegatorView.getClaveFabricacion(idClfa);
			businessDelegatorView.deleteClaveFabricacion(entity);
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
			selectedClaveFabricacion = (ClaveFabricacionDTO) (evt
					.getComponent().getAttributes()
					.get("selectedClaveFabricacion"));

			Long idClfa = new Long(selectedClaveFabricacion.getIdClfa());
			entity = businessDelegatorView.getClaveFabricacion(idClfa);
			businessDelegatorView.deleteClaveFabricacion(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedClaveFabricacion);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, String estadoRegistro,
			Date fechaCreacion, Date fechaFinal, Date fechaInicial,
			Date fechaModificacion, Long idClfa, String operCreador,
			String operModifica) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(fechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(fechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateClaveFabricacion(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ClaveFabricacionView").requestRender();
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

	public InputText getTxtIdClfa() {
		return txtIdClfa;
	}

	public void setTxtIdClfa(InputText txtIdClfa) {
		this.txtIdClfa = txtIdClfa;
	}

	public List<ClaveFabricacionDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataClaveFabricacion();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ClaveFabricacionDTO> claveFabricacionDTO) {
		this.data = claveFabricacionDTO;
	}

	public ClaveFabricacionDTO getSelectedClaveFabricacion() {
		return selectedClaveFabricacion;
	}

	public void setSelectedClaveFabricacion(ClaveFabricacionDTO claveFabricacion) {
		this.selectedClaveFabricacion = claveFabricacion;
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

	public String getIdClfa() {
		return idClfa;
	}

	public void setIdClfa(String idClfa) {
		this.idClfa = idClfa;
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

}
