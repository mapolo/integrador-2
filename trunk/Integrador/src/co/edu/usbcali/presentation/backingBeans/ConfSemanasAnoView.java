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
import co.edu.usbcali.modelo.ConfSemanasAno;
import co.edu.usbcali.modelo.Semana;
import co.edu.usbcali.modelo.dto.ClaveFabricacionDTO;
import co.edu.usbcali.modelo.dto.ConfSemanasAnoDTO;
import co.edu.usbcali.modelo.dto.SemanaDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class ConfSemanasAnoView {
	//private InputText txtEstadoRegistro;
	private SelectOneMenu estado;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private SelectOneMenu txtIdSema_Semana;
	private InputText txtIdCfsa;
	private InputText txtFechaCreacion;
	private Calendar txtFechaFinal;
	private Calendar txtFechaInicial;
	private InputText txtFechaModificacion;
	
	private String estadoRegistr;
	private String operCreador;
	private String operModifica;
	private Long idSema_Semana;
	private String idCfsa;
	private String fechaCreacion;
	private String fechaFinal;
	private String fechaInicial;
	private String fechaModificacion;
	private Map<String,String> semana = new HashMap<String, String>();
	
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ConfSemanasAnoDTO> data;
	private ConfSemanasAnoDTO selectedConfSemanasAno;
	private ConfSemanasAno entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectItem[] manufacturerOptions;

	String manufacturers[] = { "A", "R" };

	
	
	public ConfSemanasAnoView() {
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
			entity = businessDelegatorView.getConfSemanasAno(((ConfSemanasAnoDTO) event
					.getObject()).getIdCfsa());
			
			entity.setFechaModificacion(new Date());			
			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);		
			entity.setEstadoRegistro(estadoRegistr);
			
			Semana entity2 = businessDelegatorView.getSemana(getIdSema_Semana());
			System.out.println("semana " + entity2);
			entity.setSemana(entity2);
			
			Date fechaInicial = ((ConfSemanasAnoDTO) event.getObject()).getFechaInicial();
			entity.setFechaInicial(fechaInicial);
			
			Date fechaFinal = ((ConfSemanasAnoDTO) event.getObject()).getFechaFinal();
			entity.setFechaFinal(fechaFinal);
			
			
			businessDelegatorView.updateConfSemanasAno(entity);
			data = businessDelegatorView.getDataConfSemanasAno();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Cancelled",
				((ConfSemanasAnoDTO) event.getObject()).getIdCfsa() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((ConfSemanasAnoDTO) event.getObject()).getIdCfsa());
	}

	

	public void rowEventListener(RowEditEvent e) {
		try {
			ConfSemanasAnoDTO confSemanasAnoDTO = (ConfSemanasAnoDTO) e
					.getObject();

			/*if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(confSemanasAnoDTO.getEstadoRegistro());*/

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(confSemanasAnoDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(confSemanasAnoDTO.getOperModifica());

			if (txtIdSema_Semana == null) {
				txtIdSema_Semana = new SelectOneMenu();
			}

			txtIdSema_Semana.setValue(confSemanasAnoDTO.getIdSema_Semana());

			if (txtIdCfsa == null) {
				txtIdCfsa = new InputText();
			}

			txtIdCfsa.setValue(confSemanasAnoDTO.getIdCfsa());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(confSemanasAnoDTO.getFechaCreacion());

			if (txtFechaFinal == null) {
				txtFechaFinal = new Calendar();
			}

			txtFechaFinal.setValue(confSemanasAnoDTO.getFechaFinal());

			if (txtFechaInicial == null) {
				txtFechaInicial = new Calendar();
			}

			txtFechaInicial.setValue(confSemanasAnoDTO.getFechaInicial());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(confSemanasAnoDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedConfSemanasAno = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedConfSemanasAno = null;

		/*if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}*/

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			//txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			//txtOperModifica.setDisabled(true);
		}

		if (txtIdSema_Semana != null) {
			txtIdSema_Semana.setValue(null);
			//txtIdSema_Semana.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			//txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaFinal != null) {
			txtFechaFinal.setValue(null);
			//txtFechaFinal.setDisabled(true);
		}

		if (txtFechaInicial != null) {
			txtFechaInicial.setValue(null);
			//txtFechaInicial.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			//txtFechaModificacion.setDisabled(true);
		}

		if (txtIdCfsa != null) {
			txtIdCfsa.setValue(null);
			//txtIdCfsa.setDisabled(false);
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
			Long idCfsa = new Long(txtIdCfsa.getValue().toString());
			entity = businessDelegatorView.getConfSemanasAno(idCfsa);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			//txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdSema_Semana.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdCfsa.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			//txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			//txtEstadoRegistro.setDisabled(false);
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
			txtIdSema_Semana.setValue(entity.getSemana().getIdSema());
			txtIdSema_Semana.setDisabled(false);
			txtIdCfsa.setValue(entity.getIdCfsa());
			txtIdCfsa.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedConfSemanasAno = (ConfSemanasAnoDTO) (evt.getComponent()
				.getAttributes().get("selectedConfSemanasAno"));
		//txtEstadoRegistro.setValue(selectedConfSemanasAno.getEstadoRegistro());
		//txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedConfSemanasAno.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaFinal.setValue(selectedConfSemanasAno.getFechaFinal());
		txtFechaFinal.setDisabled(false);
		txtFechaInicial.setValue(selectedConfSemanasAno.getFechaInicial());
		txtFechaInicial.setDisabled(false);
		txtFechaModificacion.setValue(selectedConfSemanasAno
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedConfSemanasAno.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedConfSemanasAno.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdSema_Semana.setValue(selectedConfSemanasAno.getIdSema_Semana());
		txtIdSema_Semana.setDisabled(false);
		txtIdCfsa.setValue(selectedConfSemanasAno.getIdCfsa());
		txtIdCfsa.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedConfSemanasAno == null) && (entity == null)) {
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
			entity = new ConfSemanasAno();
			
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			//Long idCfsa = new Long(txtIdCfsa.getValue().toString());

			//entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setEstadoRegistro(estadoRegistr);
			System.out.println("estad " + estadoRegistr + "; " + estado);
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			
			//entity.setIdCfsa(idCfsa);
			//entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			//entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			/*entity.setSemana(businessDelegatorView.getSemana(FacesUtils
					.checkLong(txtIdSema_Semana)));*/
			
			Semana entity2 = businessDelegatorView.getSemana(getIdSema_Semana());
			entity.setSemana(entity2);
			
			
			businessDelegatorView.saveConfSemanasAno(entity);
			data = businessDelegatorView.getDataConfSemanasAno();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}
	
	
	public Long idForanea() {

		try {
			List<SemanaDTO> data2 = businessDelegatorView
					.getDataSemana();
			for (int i = 0; i < data2.size(); i++) {
				if (txtIdSema_Semana.getValue().equals(
						data2.get(i).getNumeroSemana())) {
					
					return data2.get(i).getIdSema();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0L;
	}

	public String action_modify() {
		try {
			if (entity == null) {
				Long idCfsa = new Long(selectedConfSemanasAno.getIdCfsa());
				entity = businessDelegatorView.getConfSemanasAno(idCfsa);
			}

			//entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setSemana(businessDelegatorView.getSemana(FacesUtils
					.checkLong(txtIdSema_Semana)));
			businessDelegatorView.updateConfSemanasAno(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedConfSemanasAno = (ConfSemanasAnoDTO) (evt.getComponent()
					.getAttributes().get("selectedConfSemanasAno"));

			Long idCfsa = new Long(selectedConfSemanasAno.getIdCfsa());
			entity = businessDelegatorView.getConfSemanasAno(idCfsa);
			businessDelegatorView.deleteConfSemanasAno(entity);
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
			selectedConfSemanasAno = (ConfSemanasAnoDTO) (evt.getComponent()
					.getAttributes().get("selectedConfSemanasAno"));

			Long idCfsa = new Long(selectedConfSemanasAno.getIdCfsa());
			entity = businessDelegatorView.getConfSemanasAno(idCfsa);
			businessDelegatorView.deleteConfSemanasAno(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedConfSemanasAno);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaFinal, Date fechaInicial,
			Date fechaModificacion, Long idCfsa, String operCreador,
			String operModifica, Long idSema_Semana) throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(fechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(fechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateConfSemanasAno(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ConfSemanasAnoView").requestRender();
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

	public SelectOneMenu getTxtIdSema_Semana() {
		return txtIdSema_Semana;
	}

	public void setTxtIdSema_Semana(SelectOneMenu txtIdSema_Semana) {
		this.txtIdSema_Semana = txtIdSema_Semana;
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

	public InputText getTxtIdCfsa() {
		return txtIdCfsa;
	}

	public void setTxtIdCfsa(InputText txtIdCfsa) {
		this.txtIdCfsa = txtIdCfsa;
	}

	public List<ConfSemanasAnoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataConfSemanasAno();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ConfSemanasAnoDTO> confSemanasAnoDTO) {
		this.data = confSemanasAnoDTO;
	}

	public ConfSemanasAnoDTO getSelectedConfSemanasAno() {
		return selectedConfSemanasAno;
	}

	public void setSelectedConfSemanasAno(ConfSemanasAnoDTO confSemanasAno) {
		this.selectedConfSemanasAno = confSemanasAno;
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

	public Long getIdSema_Semana() {
		return idSema_Semana;
	}

	public void setIdSema_Semana(Long idSema_Semana) {
		this.idSema_Semana = idSema_Semana;
	}

	public String getIdCfsa() {
		return idCfsa;
	}

	public void setOdCfsa(String idCfsa) {
		this.idCfsa = idCfsa;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
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
	
	

	public Map<String,String> getSemana() {
		try {
			List<SemanaDTO> data2 = businessDelegatorView
					.getDataSemana();
			for (int i = 0; i < data2.size(); i++) {
				
				semana.put(data2.get(i).getNumeroSemana()+"", data2.get(i).getIdSema() + "");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return semana;
	}

	public void setSemana(Map<String,String> semana) {
		this.semana = semana;
	}

	public String getEstadoRegistr() {
		return estadoRegistr;
	}

	public void setEstadoRegistr(String estadoRegistr) {
		this.estadoRegistr = estadoRegistr;
	}
	
	
	
}
