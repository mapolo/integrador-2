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
import co.edu.usbcali.modelo.SaldoInicialInventario;
import co.edu.usbcali.modelo.dto.ReferenciaSucursalDTO;
import co.edu.usbcali.modelo.dto.SaldoInicialInventarioDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class SaldoInicialInventarioView {
	private InputText txtAno;
	private InputText txtCostoInicial;
	private SelectOneMenu estado;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtSaldoInicial;
	private SelectOneMenu txtIdResu_ReferenciaSucursal;
	private InputText txtIdSini;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;
	
	private String ano;
	private String costoInicial;
	private String estadoRegistro;
	private String operCreador;
	private String operModifica;
	private String saldoInicial;
	private Long idResu_ReferenciaSucursal;
	private String idSini;
	private String fechaCreacion;
	private String fechaModificacion;
	
	private Map<String, String> referencia = new HashMap<String, String>();
	
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<SaldoInicialInventarioDTO> data;
	private SaldoInicialInventarioDTO selectedSaldoInicialInventario;
	private SaldoInicialInventario entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	private SelectItem[] manufacturerOptions;
	
	String manufacturers[] = { "A", "R" };

	public SaldoInicialInventarioView() {
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
			entity = businessDelegatorView.getSaldoInicialInventario(((SaldoInicialInventarioDTO) event
					.getObject()).getIdSini());

			entity.setFechaModificacion(new Date());
			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);
			entity.setEstadoRegistro(estadoRegistro);
			
			entity.setAno(((SaldoInicialInventarioDTO) event.getObject()).getAno());
			entity.setCostoInicial(((SaldoInicialInventarioDTO) event.getObject()).getCostoInicial());
			entity.setSaldoInicial(((SaldoInicialInventarioDTO) event.getObject()).getSaldoInicial());
			
			entity.setReferenciaSucursal(businessDelegatorView
					.getReferenciaSucursal(getIdResu_ReferenciaSucursal()));

			businessDelegatorView.updateSaldoInicialInventario(entity);
			data = businessDelegatorView.getDataSaldoInicialInventario();
			RequestContext.getCurrentInstance().update("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Cancelled",
				((SaldoInicialInventarioDTO) event.getObject()).getIdSini() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((SaldoInicialInventarioDTO) event.getObject()).getIdSini());
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			SaldoInicialInventarioDTO saldoInicialInventarioDTO = (SaldoInicialInventarioDTO) e
					.getObject();

			if (txtAno == null) {
				txtAno = new InputText();
			}

			txtAno.setValue(saldoInicialInventarioDTO.getAno());

			if (txtCostoInicial == null) {
				txtCostoInicial = new InputText();
			}

			txtCostoInicial.setValue(saldoInicialInventarioDTO
					.getCostoInicial());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(saldoInicialInventarioDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(saldoInicialInventarioDTO
					.getOperModifica());

			if (txtSaldoInicial == null) {
				txtSaldoInicial = new InputText();
			}

			txtSaldoInicial.setValue(saldoInicialInventarioDTO
					.getSaldoInicial());

			if (txtIdResu_ReferenciaSucursal == null) {
				txtIdResu_ReferenciaSucursal = new SelectOneMenu();
			}

			txtIdResu_ReferenciaSucursal.setValue(saldoInicialInventarioDTO
					.getIdResu_ReferenciaSucursal());

			if (txtIdSini == null) {
				txtIdSini = new InputText();
			}

			txtIdSini.setValue(saldoInicialInventarioDTO.getIdSini());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(saldoInicialInventarioDTO
					.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(saldoInicialInventarioDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedSaldoInicialInventario = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedSaldoInicialInventario = null;

		if (txtAno != null) {
			txtAno.setValue(null);
			//txtAno.setDisabled(true);
		}

		if (txtCostoInicial != null) {
			txtCostoInicial.setValue(null);
			//txtCostoInicial.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			//txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			//txtOperModifica.setDisabled(true);
		}

		if (txtSaldoInicial != null) {
			txtSaldoInicial.setValue(null);
			//txtSaldoInicial.setDisabled(true);
		}

		if (txtIdResu_ReferenciaSucursal != null) {
			txtIdResu_ReferenciaSucursal.setValue(null);
			//txtIdResu_ReferenciaSucursal.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			//	txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			//txtFechaModificacion.setDisabled(true);
		}

		if (txtIdSini != null) {
			txtIdSini.setValue(null);
			//txtIdSini.setDisabled(false);
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
			Long idSini = new Long(txtIdSini.getValue().toString());
			entity = businessDelegatorView.getSaldoInicialInventario(idSini);
		} catch (Exception e) {
			
		}

		if (entity == null) {
			txtAno.setDisabled(false);
			txtCostoInicial.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtSaldoInicial.setDisabled(false);
			txtIdResu_ReferenciaSucursal.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdSini.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtAno.setValue(entity.getAno());
			txtAno.setDisabled(false);
			txtCostoInicial.setValue(entity.getCostoInicial());
			txtCostoInicial.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtSaldoInicial.setValue(entity.getSaldoInicial());
			txtSaldoInicial.setDisabled(false);
			txtIdResu_ReferenciaSucursal.setValue(entity
					.getReferenciaSucursal().getIdResu());
			txtIdResu_ReferenciaSucursal.setDisabled(false);
			txtIdSini.setValue(entity.getIdSini());
			txtIdSini.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedSaldoInicialInventario = (SaldoInicialInventarioDTO) (evt
				.getComponent().getAttributes()
				.get("selectedSaldoInicialInventario"));
		txtAno.setValue(selectedSaldoInicialInventario.getAno());
		txtAno.setDisabled(false);
		txtCostoInicial.setValue(selectedSaldoInicialInventario
				.getCostoInicial());
		txtCostoInicial.setDisabled(false);
		txtFechaCreacion.setValue(selectedSaldoInicialInventario
				.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedSaldoInicialInventario
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador
				.setValue(selectedSaldoInicialInventario.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedSaldoInicialInventario
				.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtSaldoInicial.setValue(selectedSaldoInicialInventario
				.getSaldoInicial());
		txtSaldoInicial.setDisabled(false);
		txtIdResu_ReferenciaSucursal.setValue(selectedSaldoInicialInventario
				.getIdResu_ReferenciaSucursal());
		txtIdResu_ReferenciaSucursal.setDisabled(false);
		txtIdSini.setValue(selectedSaldoInicialInventario.getIdSini());
		txtIdSini.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedSaldoInicialInventario == null) && (entity == null)) {
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
			entity = new SaldoInicialInventario();
			
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			entity.setAno(FacesUtils.checkLong(txtAno));
			entity.setCostoInicial(FacesUtils.checkDouble(txtCostoInicial));
			entity.setSaldoInicial(FacesUtils.checkDouble(txtSaldoInicial));
			
			entity.setEstadoRegistro(estadoRegistro);
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			
			entity.setReferenciaSucursal(businessDelegatorView
					.getReferenciaSucursal(FacesUtils
							.checkLong(txtIdResu_ReferenciaSucursal)));
			
			businessDelegatorView.saveSaldoInicialInventario(entity);
			data = businessDelegatorView.getDataSaldoInicialInventario();
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
				Long idSini = new Long(
						selectedSaldoInicialInventario.getIdSini());
				entity = businessDelegatorView
						.getSaldoInicialInventario(idSini);
			}

			entity.setAno(FacesUtils.checkLong(txtAno));
			entity.setCostoInicial(FacesUtils.checkDouble(txtCostoInicial));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setSaldoInicial(FacesUtils.checkDouble(txtSaldoInicial));
			entity.setReferenciaSucursal(businessDelegatorView
					.getReferenciaSucursal(FacesUtils
							.checkLong(txtIdResu_ReferenciaSucursal)));
			businessDelegatorView.updateSaldoInicialInventario(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedSaldoInicialInventario = (SaldoInicialInventarioDTO) (evt
					.getComponent().getAttributes()
					.get("selectedSaldoInicialInventario"));

			Long idSini = new Long(selectedSaldoInicialInventario.getIdSini());
			entity = businessDelegatorView.getSaldoInicialInventario(idSini);
			businessDelegatorView.deleteSaldoInicialInventario(entity);
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
			selectedSaldoInicialInventario = (SaldoInicialInventarioDTO) (evt
					.getComponent().getAttributes()
					.get("selectedSaldoInicialInventario"));

			Long idSini = new Long(selectedSaldoInicialInventario.getIdSini());
			entity = businessDelegatorView.getSaldoInicialInventario(idSini);
			businessDelegatorView.deleteSaldoInicialInventario(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedSaldoInicialInventario);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long ano, Double costoInicial,
			String estadoRegistro, Date fechaCreacion, Date fechaModificacion,
			Long idSini, String operCreador, String operModifica,
			Double saldoInicial, Long idResu_ReferenciaSucursal)
			throws Exception {
		try {
			entity.setAno(FacesUtils.checkLong(ano));
			entity.setCostoInicial(FacesUtils.checkDouble(costoInicial));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setSaldoInicial(FacesUtils.checkDouble(saldoInicial));
			businessDelegatorView.updateSaldoInicialInventario(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("SaldoInicialInventarioView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtAno() {
		return txtAno;
	}

	public void setTxtAno(InputText txtAno) {
		this.txtAno = txtAno;
	}

	public InputText getTxtCostoInicial() {
		return txtCostoInicial;
	}

	public void setTxtCostoInicial(InputText txtCostoInicial) {
		this.txtCostoInicial = txtCostoInicial;
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

	public InputText getTxtSaldoInicial() {
		return txtSaldoInicial;
	}

	public void setTxtSaldoInicial(InputText txtSaldoInicial) {
		this.txtSaldoInicial = txtSaldoInicial;
	}

	public SelectOneMenu getTxtIdResu_ReferenciaSucursal() {
		return txtIdResu_ReferenciaSucursal;
	}

	public void setTxtIdResu_ReferenciaSucursal(
			SelectOneMenu txtIdResu_ReferenciaSucursal) {
		this.txtIdResu_ReferenciaSucursal = txtIdResu_ReferenciaSucursal;
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

	public InputText getTxtIdSini() {
		return txtIdSini;
	}

	public void setTxtIdSini(InputText txtIdSini) {
		this.txtIdSini = txtIdSini;
	}

	public List<SaldoInicialInventarioDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataSaldoInicialInventario();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(
			List<SaldoInicialInventarioDTO> saldoInicialInventarioDTO) {
		this.data = saldoInicialInventarioDTO;
	}

	public SaldoInicialInventarioDTO getSelectedSaldoInicialInventario() {
		return selectedSaldoInicialInventario;
	}

	public void setSelectedSaldoInicialInventario(
			SaldoInicialInventarioDTO saldoInicialInventario) {
		this.selectedSaldoInicialInventario = saldoInicialInventario;
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

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCostoInicial() {
		return costoInicial;
	}

	public void setCostoInicial(String costoInicial) {
		this.costoInicial = costoInicial;
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

	public String getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(String saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public Long getIdResu_ReferenciaSucursal() {
		return idResu_ReferenciaSucursal;
	}

	public void setIdResu_ReferenciaSucursal(Long idResu_ReferenciaSucursal) {
		this.idResu_ReferenciaSucursal = idResu_ReferenciaSucursal;
	}

	public String getIdSini() {
		return idSini;
	}

	public void setIdSini(String idSini) {
		this.idSini = idSini;
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

	public Map<String, String> getReferencia() {
		try {
			List<ReferenciaSucursalDTO> data2 = businessDelegatorView
					.getDataReferenciaSucursal();

			for (int i = 0; i < data2.size(); i++) {
				referencia.put(data2.get(i).getIdResu() + "", data2.get(i)
						.getIdResu() + "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return referencia;
	}

	public void setReferencia(Map<String, String> referencia) {
		this.referencia = referencia;
	}

	public SelectItem[] getManufacturerOptions() {
		return manufacturerOptions;
	}

	public void setManufacturerOptions(SelectItem[] manufacturerOptions) {
		this.manufacturerOptions = manufacturerOptions;
	}
}