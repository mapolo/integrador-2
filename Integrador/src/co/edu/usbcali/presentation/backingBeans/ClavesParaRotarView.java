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

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.ClavesParaRotar;
import co.edu.usbcali.modelo.dto.ClavesParaRotarDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class ClavesParaRotarView {
	private InputText txtAno;
	private InputText txtEstadoRegistro;
	private InputText txtMes;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdClfa_ClaveFabricacion;
	private InputText txtIdSucu_Sucursal;
	private InputText txtIdClpr;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
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

	public ClavesParaRotarView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ClavesParaRotarDTO clavesParaRotarDTO = (ClavesParaRotarDTO) e
					.getObject();

			if (txtAno == null) {
				txtAno = new InputText();
			}

			txtAno.setValue(clavesParaRotarDTO.getAno());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(clavesParaRotarDTO.getEstadoRegistro());

			if (txtMes == null) {
				txtMes = new InputText();
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
				txtIdClfa_ClaveFabricacion = new InputText();
			}

			txtIdClfa_ClaveFabricacion.setValue(clavesParaRotarDTO
					.getIdClfa_ClaveFabricacion());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new InputText();
			}

			txtIdSucu_Sucursal
					.setValue(clavesParaRotarDTO.getIdSucu_Sucursal());

			if (txtIdClpr == null) {
				txtIdClpr = new InputText();
			}

			txtIdClpr.setValue(clavesParaRotarDTO.getIdClpr());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(clavesParaRotarDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
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
			txtAno.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtMes != null) {
			txtMes.setValue(null);
			txtMes.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtIdClfa_ClaveFabricacion != null) {
			txtIdClfa_ClaveFabricacion.setValue(null);
			txtIdClfa_ClaveFabricacion.setDisabled(true);
		}

		if (txtIdSucu_Sucursal != null) {
			txtIdSucu_Sucursal.setValue(null);
			txtIdSucu_Sucursal.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdClpr != null) {
			txtIdClpr.setValue(null);
			txtIdClpr.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
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
			// TODO: handle exception
		}

		if (entity == null) {
			txtAno.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
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
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
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
		txtEstadoRegistro.setValue(selectedClavesParaRotar.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
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

			Long idClpr = new Long(txtIdClpr.getValue().toString());

			entity.setAno(FacesUtils.checkLong(txtAno));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdClpr(idClpr);
			entity.setMes(FacesUtils.checkLong(txtMes));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setClaveFabricacion(businessDelegatorView
					.getClaveFabricacion(FacesUtils
							.checkLong(txtIdClfa_ClaveFabricacion)));
			entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			businessDelegatorView.saveClavesParaRotar(entity);
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
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
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

	public InputText getTxtAno() {
		return txtAno;
	}

	public void setTxtAno(InputText txtAno) {
		this.txtAno = txtAno;
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}

	public InputText getTxtMes() {
		return txtMes;
	}

	public void setTxtMes(InputText txtMes) {
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

	public InputText getTxtIdClfa_ClaveFabricacion() {
		return txtIdClfa_ClaveFabricacion;
	}

	public void setTxtIdClfa_ClaveFabricacion(
			InputText txtIdClfa_ClaveFabricacion) {
		this.txtIdClfa_ClaveFabricacion = txtIdClfa_ClaveFabricacion;
	}

	public InputText getTxtIdSucu_Sucursal() {
		return txtIdSucu_Sucursal;
	}

	public void setTxtIdSucu_Sucursal(InputText txtIdSucu_Sucursal) {
		this.txtIdSucu_Sucursal = txtIdSucu_Sucursal;
	}

	public Calendar getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
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
}
