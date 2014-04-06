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

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.PeriodoGarantia;
import co.edu.usbcali.modelo.dto.GrupoDTO;
import co.edu.usbcali.modelo.dto.ListaPreciosDTO;
import co.edu.usbcali.modelo.dto.PeriodoGarantiaDTO;
import co.edu.usbcali.modelo.dto.ReferenciaDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class PeriodoGarantiaView {
	//private InputText txtEstadoRegistro;
	private SelectOneMenu estado;
	private InputText txtMesesParticular;
	private InputText txtMesesPublico;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private SelectOneMenu txtIdGrpo_Grupo;
	private InputText txtIdPega;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;
	
	private String estadoRegistro;
	private String mesesParticular;
	private String mesesPublico;
	private String operCreador;
	private String operModifica;
	private Long idGrpo_Grupo;
	private String idPega;
	private String fechaCreacion;
	private String fechaModificacion;
	
	private Map<String, String> grupo = new HashMap<String, String>();
	
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<PeriodoGarantiaDTO> data;
	private PeriodoGarantiaDTO selectedPeriodoGarantia;
	private PeriodoGarantia entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private SelectItem[] manufacturerOptions;

	String manufacturers[] = { "A", "R" };

	public PeriodoGarantiaView() {
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
					.getPeriodoGarantia(((PeriodoGarantiaDTO) event.getObject())
							.getIdPega());

			entity.setEstadoRegistro(estadoRegistro);
			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);
			entity.setFechaModificacion(new Date());

			entity.setMesesParticular(((PeriodoGarantiaDTO) event.getObject()).getMesesParticular());
			entity.setMesesPublico(((PeriodoGarantiaDTO) event.getObject()).getMesesPublico());			
			
			entity.setGrupo(businessDelegatorView
					.getGrupo(getIdGrpo_Grupo()));
			
			businessDelegatorView.updatePeriodoGarantia(entity);
			data = businessDelegatorView.getDataPeriodoGarantia();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("TipoEstado Cancelled",
				((PeriodoGarantiaDTO) event.getObject()).getIdPega() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((PeriodoGarantiaDTO) event.getObject()).getIdPega());
	}
	

	public void rowEventListener(RowEditEvent e) {
		try {
			PeriodoGarantiaDTO periodoGarantiaDTO = (PeriodoGarantiaDTO) e
					.getObject();

			/*if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(periodoGarantiaDTO.getEstadoRegistro());*/

			if (txtMesesParticular == null) {
				txtMesesParticular = new InputText();
			}

			txtMesesParticular
					.setValue(periodoGarantiaDTO.getMesesParticular());

			if (txtMesesPublico == null) {
				txtMesesPublico = new InputText();
			}

			txtMesesPublico.setValue(periodoGarantiaDTO.getMesesPublico());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(periodoGarantiaDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(periodoGarantiaDTO.getOperModifica());

			if (txtIdGrpo_Grupo == null) {
				txtIdGrpo_Grupo = new SelectOneMenu();
			}

			txtIdGrpo_Grupo.setValue(periodoGarantiaDTO.getIdGrpo_Grupo());

			if (txtIdPega == null) {
				txtIdPega = new InputText();
			}

			txtIdPega.setValue(periodoGarantiaDTO.getIdPega());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(periodoGarantiaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(periodoGarantiaDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedPeriodoGarantia = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedPeriodoGarantia = null;

		/*if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			//txtEstadoRegistro.setDisabled(true);
		}*/

		if (txtMesesParticular != null) {
			txtMesesParticular.setValue(null);
			//txtMesesParticular.setDisabled(true);
		}

		if (txtMesesPublico != null) {
			txtMesesPublico.setValue(null);
			//txtMesesPublico.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			//txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			//txtOperModifica.setDisabled(true);
		}

		if (txtIdGrpo_Grupo != null) {
			txtIdGrpo_Grupo.setValue(null);
			//txtIdGrpo_Grupo.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			//txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			//txtFechaModificacion.setDisabled(true);
		}

		if (txtIdPega != null) {
			txtIdPega.setValue(null);
			//txtIdPega.setDisabled(false);
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
			Long idPega = new Long(txtIdPega.getValue().toString());
			entity = businessDelegatorView.getPeriodoGarantia(idPega);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			//txtEstadoRegistro.setDisabled(false);
			txtMesesParticular.setDisabled(false);
			txtMesesPublico.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdGrpo_Grupo.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdPega.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			//txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			//txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtMesesParticular.setValue(entity.getMesesParticular());
			txtMesesParticular.setDisabled(false);
			txtMesesPublico.setValue(entity.getMesesPublico());
			txtMesesPublico.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdGrpo_Grupo.setValue(entity.getGrupo().getIdGrpo());
			txtIdGrpo_Grupo.setDisabled(false);
			txtIdPega.setValue(entity.getIdPega());
			txtIdPega.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedPeriodoGarantia = (PeriodoGarantiaDTO) (evt.getComponent()
				.getAttributes().get("selectedPeriodoGarantia"));
		//txtEstadoRegistro.setValue(selectedPeriodoGarantia.getEstadoRegistro());
		//txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedPeriodoGarantia.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedPeriodoGarantia
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtMesesParticular.setValue(selectedPeriodoGarantia
				.getMesesParticular());
		txtMesesParticular.setDisabled(false);
		txtMesesPublico.setValue(selectedPeriodoGarantia.getMesesPublico());
		txtMesesPublico.setDisabled(false);
		txtOperCreador.setValue(selectedPeriodoGarantia.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedPeriodoGarantia.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdGrpo_Grupo.setValue(selectedPeriodoGarantia.getIdGrpo_Grupo());
		txtIdGrpo_Grupo.setDisabled(false);
		txtIdPega.setValue(selectedPeriodoGarantia.getIdPega());
		txtIdPega.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedPeriodoGarantia == null) && (entity == null)) {
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
			entity = new PeriodoGarantia();
			
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			//Long idPega = new Long(txtIdPega.getValue().toString());

			//entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
					
			entity.setMesesParticular(FacesUtils.checkLong(txtMesesParticular));
			entity.setMesesPublico(FacesUtils.checkLong(txtMesesPublico));
			
			entity.setEstadoRegistro(estadoRegistro);
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			
			entity.setGrupo(businessDelegatorView.getGrupo(FacesUtils
					.checkLong(txtIdGrpo_Grupo)));
			
			
			businessDelegatorView.savePeriodoGarantia(entity);
			data = businessDelegatorView.getDataPeriodoGarantia();
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
				Long idPega = new Long(selectedPeriodoGarantia.getIdPega());
				entity = businessDelegatorView.getPeriodoGarantia(idPega);
			}

			//entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setMesesParticular(FacesUtils.checkLong(txtMesesParticular));
			entity.setMesesPublico(FacesUtils.checkLong(txtMesesPublico));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setGrupo(businessDelegatorView.getGrupo(FacesUtils
					.checkLong(txtIdGrpo_Grupo)));
			businessDelegatorView.updatePeriodoGarantia(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedPeriodoGarantia = (PeriodoGarantiaDTO) (evt.getComponent()
					.getAttributes().get("selectedPeriodoGarantia"));

			Long idPega = new Long(selectedPeriodoGarantia.getIdPega());
			entity = businessDelegatorView.getPeriodoGarantia(idPega);
			businessDelegatorView.deletePeriodoGarantia(entity);
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
			selectedPeriodoGarantia = (PeriodoGarantiaDTO) (evt.getComponent()
					.getAttributes().get("selectedPeriodoGarantia"));

			Long idPega = new Long(selectedPeriodoGarantia.getIdPega());
			entity = businessDelegatorView.getPeriodoGarantia(idPega);
			businessDelegatorView.deletePeriodoGarantia(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedPeriodoGarantia);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idPega,
			Long mesesParticular, Long mesesPublico, String operCreador,
			String operModifica, Long idGrpo_Grupo) throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setMesesParticular(FacesUtils.checkLong(mesesParticular));
			entity.setMesesPublico(FacesUtils.checkLong(mesesPublico));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updatePeriodoGarantia(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("PeriodoGarantiaView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	/*public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}*/

	public InputText getTxtMesesParticular() {
		return txtMesesParticular;
	}

	public void setTxtMesesParticular(InputText txtMesesParticular) {
		this.txtMesesParticular = txtMesesParticular;
	}

	public InputText getTxtMesesPublico() {
		return txtMesesPublico;
	}

	public void setTxtMesesPublico(InputText txtMesesPublico) {
		this.txtMesesPublico = txtMesesPublico;
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

	public SelectOneMenu getTxtIdGrpo_Grupo() {
		return txtIdGrpo_Grupo;
	}

	public void setTxtIdGrpo_Grupo(SelectOneMenu txtIdGrpo_Grupo) {
		this.txtIdGrpo_Grupo = txtIdGrpo_Grupo;
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

	public InputText getTxtIdPega() {
		return txtIdPega;
	}

	public void setTxtIdPega(InputText txtIdPega) {
		this.txtIdPega = txtIdPega;
	}

	public List<PeriodoGarantiaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataPeriodoGarantia();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<PeriodoGarantiaDTO> periodoGarantiaDTO) {
		this.data = periodoGarantiaDTO;
	}

	public PeriodoGarantiaDTO getSelectedPeriodoGarantia() {
		return selectedPeriodoGarantia;
	}

	public void setSelectedPeriodoGarantia(PeriodoGarantiaDTO periodoGarantia) {
		this.selectedPeriodoGarantia = periodoGarantia;
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

	public String getMesesParticular() {
		return mesesParticular;
	}

	public void setMesesParticular(String mesesParticular) {
		this.mesesParticular = mesesParticular;
	}

	public String getMesesPublico() {
		return mesesPublico;
	}

	public void setMesesPublico(String mesesPublico) {
		this.mesesPublico = mesesPublico;
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

	public Long getIdGrpo_Grupo() {
		return idGrpo_Grupo;
	}

	public void setIdGrpo_Grupo(Long idGrpo_Grupo) {
		this.idGrpo_Grupo = idGrpo_Grupo;
	}

	public String getIdPega() {
		return idPega;
	}

	public void setIdPega(String idPega) {
		this.idPega = idPega;
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

	public Map<String, String> getGrupo() {
		try {
			List<GrupoDTO> data2 = businessDelegatorView
					.getDataGrupo();

			for (int i = 0; i < data2.size(); i++) {
				grupo.put(data2.get(i).getNombre(), data2.get(i)
						.getIdGrpo() + "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return grupo;
	}

	public void setGrupo(Map<String, String> grupo) {
		this.grupo = grupo;
	}

	public SelectOneMenu getEstado() {
		return estado;
	}

	public void setEstado(SelectOneMenu estado) {
		this.estado = estado;
	}
	
	
}
