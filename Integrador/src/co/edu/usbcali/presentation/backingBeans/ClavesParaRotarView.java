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
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.ClaveFabricacion;
import co.edu.usbcali.modelo.ClavesParaRotar;
import co.edu.usbcali.modelo.Sucursal;
import co.edu.usbcali.modelo.dto.ClaveFabricacionDTO;
import co.edu.usbcali.modelo.dto.ClavesParaRotarDTO;
import co.edu.usbcali.modelo.dto.SucursalDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class ClavesParaRotarView {
	private SelectOneMenu txtAno;
	private SelectOneMenu estado;
	private SelectOneMenu txtMes;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private SelectOneMenu txtIdClfa_ClaveFabricacion;
	private SelectOneMenu txtIdSucu_Sucursal;
	private InputText txtIdClpr;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;

	private Long ano;
	private String estadoRegistro;
	private Long mes;
	private String operCreador;
	private String operModifica;
	private Long idClfa_ClaveFabricacion;
	private String idSucu_Sucursal;
	private String idClpr;
	private String fechaCreacion;
	private String fechaModificacion;

	private Map<String, String> claveFabricacion = new HashMap<String, String>();
	private Map<String, String> sucursal = new HashMap<String, String>();

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ClavesParaRotarDTO> data;
	private ClavesParaRotarDTO selectedClavesParaRotar;
	private ClavesParaRotar entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private SelectItem[] manufacturerOptions;
	private SelectItem[] manufacturerOptions2;
	private SelectItem[] manufacturerOptions3;

	String manufacturers[] = { "A", "R" };
	String manufacturers2[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "11", "12" };
	String manufacturers3[] = { "2000", "2001", "2002", "2003", "2004", "2005",
			"2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013",
			"2014" };

	public ClavesParaRotarView() {
		super();

		setManufacturerOptions(createFilterOptions(manufacturers));
		setManufacturerOptions2(createFilterOptions(manufacturers2));
		setManufacturerOptions3(createFilterOptions(manufacturers3));
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
					.getClavesParaRotar(((ClavesParaRotarDTO) event.getObject())
							.getIdClpr());

			//Long ano = new Long(txtAno.getValue().toString());
			System.out.println("Año: " + ano + "txtAño: " + txtAno);
			entity.setAno(ano);

			//Long mes = new Long(txtMes.getValue().toString());
			System.out.println("Mes: " + mes + "txtM: " + txtMes);
			entity.setMes(mes);

			entity.setEstadoRegistro(estadoRegistro);
			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);
			entity.setFechaModificacion(new Date());

			entity.setClaveFabricacion(businessDelegatorView
					.getClaveFabricacion(getIdClfa_ClaveFabricacion()));

			Sucursal entity2 = businessDelegatorView.getSucursal(Long.parseLong(idSucu_Sucursal));
			
			
			if (txtIdSucu_Sucursal.getValue() == "999") {
				System.out.println("entro if");
				entity.setSucursal(null);
				
			} else {
				System.out.println("entro else");
				
				entity.setSucursal(entity2);

				/*entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
						.checkLong(txtIdSucu_Sucursal)));*/
			}

			/*
			 * Sucursal entity3 = businessDelegatorView
			 * .getSucursal(getIdSucu_Sucursal()); entity.setSucursal(entity3);
			 */

			businessDelegatorView.updateClavesParaRotar(entity);
			data = businessDelegatorView.getDataClavesParaRotar();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("TipoEstado Cancelled",
				((ClavesParaRotarDTO) event.getObject()).getIdClpr() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((ClavesParaRotarDTO) event.getObject()).getIdClpr());
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ClavesParaRotarDTO clavesParaRotarDTO = (ClavesParaRotarDTO) e
					.getObject();

			if (txtAno == null) {
				txtAno = new SelectOneMenu();
			}

			txtAno.setValue(clavesParaRotarDTO.getAno());

			/*
			 * if (txtEstadoRegistro == null) { txtEstadoRegistro = new
			 * InputText(); }
			 * 
			 * txtEstadoRegistro.setValue(clavesParaRotarDTO.getEstadoRegistro())
			 * ;
			 */

			if (txtMes == null) {
				txtMes = new SelectOneMenu();
			}

			txtMes.setValue(clavesParaRotarDTO.getMes());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(clavesParaRotarDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(clavesParaRotarDTO.getOperModifica());

			if (txtIdClfa_ClaveFabricacion == null) {
				txtIdClfa_ClaveFabricacion = new SelectOneMenu();
			}

			txtIdClfa_ClaveFabricacion.setValue(clavesParaRotarDTO
					.getIdClfa_ClaveFabricacion());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new SelectOneMenu();
			}

			txtIdSucu_Sucursal
					.setValue(clavesParaRotarDTO.getIdSucu_Sucursal());

			if (txtIdClpr == null) {
				txtIdClpr = new InputText();
			}

			txtIdClpr.setValue(clavesParaRotarDTO.getIdClpr());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(clavesParaRotarDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(clavesParaRotarDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedClavesParaRotar = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedClavesParaRotar = null;

		if (txtAno != null) {
			txtAno.setValue(null);
			// txtAno.setDisabled(true);
		}

		/*
		 * if (txtEstadoRegistro != null) { txtEstadoRegistro.setValue(null);
		 * txtEstadoRegistro.setDisabled(true); }
		 */

		if (txtMes != null) {
			txtMes.setValue(null);
			// txtMes.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			// txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			// txtOperModifica.setDisabled(true);
		}

		if (txtIdClfa_ClaveFabricacion != null) {
			txtIdClfa_ClaveFabricacion.setValue(null);
			// txtIdClfa_ClaveFabricacion.setDisabled(true);
		}

		if (txtIdSucu_Sucursal != null) {
			txtIdSucu_Sucursal.setValue(null);
			// txtIdSucu_Sucursal.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			// txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			// txtFechaModificacion.setDisabled(true);
		}

		if (txtIdClpr != null) {
			txtIdClpr.setValue(null);
			// txtIdClpr.setDisabled(false);
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
			Long idClpr = new Long(txtIdClpr.getValue().toString());
			entity = businessDelegatorView.getClavesParaRotar(idClpr);
		} catch (Exception e) {
			//
		}

		if (entity == null) {
			txtAno.setDisabled(false);
			txtMes.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdClfa_ClaveFabricacion.setDisabled(false);
			txtIdSucu_Sucursal.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdClpr.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtAno.setValue(entity.getAno());
			txtAno.setDisabled(false);
			// txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			// txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtMes.setValue(entity.getMes());
			txtMes.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdClfa_ClaveFabricacion.setValue(entity.getClaveFabricacion()
					.getIdClfa());
			txtIdClfa_ClaveFabricacion.setDisabled(false);
			txtIdSucu_Sucursal.setValue(entity.getSucursal().getIdSucu());
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdClpr.setValue(entity.getIdClpr());
			txtIdClpr.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedClavesParaRotar = (ClavesParaRotarDTO) (evt.getComponent()
				.getAttributes().get("selectedClavesParaRotar"));
		txtAno.setValue(selectedClavesParaRotar.getAno());
		txtAno.setDisabled(false);
		// txtEstadoRegistro.setValue(selectedClavesParaRotar.getEstadoRegistro());
		// txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedClavesParaRotar.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedClavesParaRotar
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtMes.setValue(selectedClavesParaRotar.getMes());
		txtMes.setDisabled(false);
		txtOperCreador.setValue(selectedClavesParaRotar.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedClavesParaRotar.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdClfa_ClaveFabricacion.setValue(selectedClavesParaRotar
				.getIdClfa_ClaveFabricacion());
		txtIdClfa_ClaveFabricacion.setDisabled(false);
		txtIdSucu_Sucursal.setValue(selectedClavesParaRotar
				.getIdSucu_Sucursal());
		txtIdSucu_Sucursal.setDisabled(false);
		txtIdClpr.setValue(selectedClavesParaRotar.getIdClpr());
		txtIdClpr.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedClavesParaRotar == null) && (entity == null)) {
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
			entity = new ClavesParaRotar();

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			Long ano = new Long(txtAno.getValue().toString());
			entity.setAno(ano);

			Long mes = new Long(txtMes.getValue().toString());
			entity.setMes(mes);

			entity.setEstadoRegistro(estadoRegistro);
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);

			ClaveFabricacion entity2 = businessDelegatorView
					.getClaveFabricacion(getIdClfa_ClaveFabricacion());
			entity.setClaveFabricacion(entity2);

			if (txtIdSucu_Sucursal.getValue() == "") {

			} else {
				entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
						.checkLong(txtIdSucu_Sucursal)));
			}

			businessDelegatorView.saveClavesParaRotar(entity);
			data = businessDelegatorView.getDataClavesParaRotar();
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
				Long idClpr = new Long(selectedClavesParaRotar.getIdClpr());
				entity = businessDelegatorView.getClavesParaRotar(idClpr);
			}

			entity.setAno(FacesUtils.checkLong(txtAno));
			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setMes(FacesUtils.checkLong(txtMes));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setClaveFabricacion(businessDelegatorView
					.getClaveFabricacion(FacesUtils
							.checkLong(txtIdClfa_ClaveFabricacion)));
			entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			businessDelegatorView.updateClavesParaRotar(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedClavesParaRotar = (ClavesParaRotarDTO) (evt.getComponent()
					.getAttributes().get("selectedClavesParaRotar"));

			Long idClpr = new Long(selectedClavesParaRotar.getIdClpr());
			entity = businessDelegatorView.getClavesParaRotar(idClpr);
			businessDelegatorView.deleteClavesParaRotar(entity);
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
			selectedClavesParaRotar = (ClavesParaRotarDTO) (evt.getComponent()
					.getAttributes().get("selectedClavesParaRotar"));

			Long idClpr = new Long(selectedClavesParaRotar.getIdClpr());
			entity = businessDelegatorView.getClavesParaRotar(idClpr);
			businessDelegatorView.deleteClavesParaRotar(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedClavesParaRotar);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long ano, String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idClpr, Long mes,
			String operCreador, String operModifica,
			Long idClfa_ClaveFabricacion, Long idSucu_Sucursal)
			throws Exception {
		try {
			entity.setAno(FacesUtils.checkLong(ano));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setMes(FacesUtils.checkLong(mes));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateClavesParaRotar(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ClavesParaRotarView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public SelectOneMenu getTxtAno() {
		return txtAno;
	}

	public void setTxtAno(SelectOneMenu txtAno) {
		this.txtAno = txtAno;
	}

	/*
	 * public InputText getTxtEstadoRegistro() { return txtEstadoRegistro; }
	 * 
	 * public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
	 * this.txtEstadoRegistro = txtEstadoRegistro; }
	 */

	public SelectOneMenu getTxtMes() {
		return txtMes;
	}

	public void setTxtMes(SelectOneMenu txtMes) {
		this.txtMes = txtMes;
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

	public SelectOneMenu getTxtIdClfa_ClaveFabricacion() {
		return txtIdClfa_ClaveFabricacion;
	}

	public void setTxtIdClfa_ClaveFabricacion(
			SelectOneMenu txtIdClfa_ClaveFabricacion) {
		this.txtIdClfa_ClaveFabricacion = txtIdClfa_ClaveFabricacion;
	}

	public SelectOneMenu getTxtIdSucu_Sucursal() {
		return txtIdSucu_Sucursal;
	}

	public void setTxtIdSucu_Sucursal(SelectOneMenu txtIdSucu_Sucursal) {
		this.txtIdSucu_Sucursal = txtIdSucu_Sucursal;
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

	public InputText getTxtIdClpr() {
		return txtIdClpr;
	}

	public void setTxtIdClpr(InputText txtIdClpr) {
		this.txtIdClpr = txtIdClpr;
	}

	public List<ClavesParaRotarDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataClavesParaRotar();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ClavesParaRotarDTO> clavesParaRotarDTO) {
		this.data = clavesParaRotarDTO;
	}

	public ClavesParaRotarDTO getSelectedClavesParaRotar() {
		return selectedClavesParaRotar;
	}

	public void setSelectedClavesParaRotar(ClavesParaRotarDTO clavesParaRotar) {
		this.selectedClavesParaRotar = clavesParaRotar;
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

	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public Long getMes() {
		return mes;
	}

	public void setMes(Long mes) {
		this.mes = mes;
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

	public Long getIdClfa_ClaveFabricacion() {
		return idClfa_ClaveFabricacion;
	}

	public void setIdClfa_ClaveFabricacion(Long idClfa_ClaveFabricacion) {
		this.idClfa_ClaveFabricacion = idClfa_ClaveFabricacion;
	}

	public String getIdSucu_Sucursal() {
		return idSucu_Sucursal;
	}

	public void setIdSucu_Sucursal(String idSucu_Sucursal) {
		this.idSucu_Sucursal = idSucu_Sucursal;
	}

	public String getIdClpr() {
		return idClpr;
	}

	public void setIdClpr(String idClpr) {
		this.idClpr = idClpr;
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

	public Map<String, String> getClaveFabricacion() {
		try {
			List<ClaveFabricacionDTO> data2 = businessDelegatorView
					.getDataClaveFabricacion();

			for (int i = 0; i < data2.size(); i++) {
				claveFabricacion.put(data2.get(i).getCodigo(), data2.get(i)
						.getIdClfa() + "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return claveFabricacion;
	}

	public void setClaveFabricacion(Map<String, String> claveFabricacion) {
		this.claveFabricacion = claveFabricacion;
	}

	public Map<String, String> getSucursal() {
		try {
			List<SucursalDTO> data3 = businessDelegatorView.getDataSucursal();

			for (int i = 0; i < data3.size(); i++) {
				sucursal.put(data3.get(i).getNombre(), data3.get(i).getIdSucu()
						+ "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sucursal;
	}

	public void setSucursal(Map<String, String> sucursal) {
		this.sucursal = sucursal;
	}

	public SelectItem[] getManufacturerOptions2() {
		return manufacturerOptions2;
	}

	public void setManufacturerOptions2(SelectItem[] manufacturerOptions2) {
		this.manufacturerOptions2 = manufacturerOptions2;
	}

	public SelectItem[] getManufacturerOptions3() {
		return manufacturerOptions3;
	}

	public void setManufacturerOptions3(SelectItem[] manufacturerOptions3) {
		this.manufacturerOptions3 = manufacturerOptions3;
	}

}
