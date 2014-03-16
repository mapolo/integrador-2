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
import co.edu.usbcali.modelo.DistribucionCartera;
import co.edu.usbcali.modelo.dto.DistribucionCarteraDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class DistribucionCarteraView {
	private InputText txtEstadoRegistro;
	private InputText txtNumeroCuota;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtValor;
	private InputText txtIdCart_Cartera;
	private InputText txtIdDica;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaVencimiento;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DistribucionCarteraDTO> data;
	private DistribucionCarteraDTO selectedDistribucionCartera;
	private DistribucionCartera entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public DistribucionCarteraView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DistribucionCarteraDTO distribucionCarteraDTO = (DistribucionCarteraDTO) e
					.getObject();

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(distribucionCarteraDTO
					.getEstadoRegistro());

			if (txtNumeroCuota == null) {
				txtNumeroCuota = new InputText();
			}

			txtNumeroCuota.setValue(distribucionCarteraDTO.getNumeroCuota());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(distribucionCarteraDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(distribucionCarteraDTO.getOperModifica());

			if (txtValor == null) {
				txtValor = new InputText();
			}

			txtValor.setValue(distribucionCarteraDTO.getValor());

			if (txtIdCart_Cartera == null) {
				txtIdCart_Cartera = new InputText();
			}

			txtIdCart_Cartera.setValue(distribucionCarteraDTO
					.getIdCart_Cartera());

			if (txtIdDica == null) {
				txtIdDica = new InputText();
			}

			txtIdDica.setValue(distribucionCarteraDTO.getIdDica());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion
					.setValue(distribucionCarteraDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(distribucionCarteraDTO
					.getFechaModificacion());

			if (txtFechaVencimiento == null) {
				txtFechaVencimiento = new Calendar();
			}

			txtFechaVencimiento.setValue(distribucionCarteraDTO
					.getFechaVencimiento());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedDistribucionCartera = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDistribucionCartera = null;

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtNumeroCuota != null) {
			txtNumeroCuota.setValue(null);
			txtNumeroCuota.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtValor != null) {
			txtValor.setValue(null);
			txtValor.setDisabled(true);
		}

		if (txtIdCart_Cartera != null) {
			txtIdCart_Cartera.setValue(null);
			txtIdCart_Cartera.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtFechaVencimiento != null) {
			txtFechaVencimiento.setValue(null);
			txtFechaVencimiento.setDisabled(true);
		}

		if (txtIdDica != null) {
			txtIdDica.setValue(null);
			txtIdDica.setDisabled(false);
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

	public void listener_txtFechaVencimiento() {
		Date inputDate = (Date) txtFechaVencimiento.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Long idDica = new Long(txtIdDica.getValue().toString());
			entity = businessDelegatorView.getDistribucionCartera(idDica);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEstadoRegistro.setDisabled(false);
			txtNumeroCuota.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtValor.setDisabled(false);
			txtIdCart_Cartera.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtFechaVencimiento.setDisabled(false);
			txtIdDica.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtFechaVencimiento.setValue(entity.getFechaVencimiento());
			txtFechaVencimiento.setDisabled(false);
			txtNumeroCuota.setValue(entity.getNumeroCuota());
			txtNumeroCuota.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtValor.setValue(entity.getValor());
			txtValor.setDisabled(false);
			txtIdCart_Cartera.setValue(entity.getCartera().getIdCart());
			txtIdCart_Cartera.setDisabled(false);
			txtIdDica.setValue(entity.getIdDica());
			txtIdDica.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedDistribucionCartera = (DistribucionCarteraDTO) (evt
				.getComponent().getAttributes()
				.get("selectedDistribucionCartera"));
		txtEstadoRegistro.setValue(selectedDistribucionCartera
				.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedDistribucionCartera
				.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedDistribucionCartera
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtFechaVencimiento.setValue(selectedDistribucionCartera
				.getFechaVencimiento());
		txtFechaVencimiento.setDisabled(false);
		txtNumeroCuota.setValue(selectedDistribucionCartera.getNumeroCuota());
		txtNumeroCuota.setDisabled(false);
		txtOperCreador.setValue(selectedDistribucionCartera.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedDistribucionCartera.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtValor.setValue(selectedDistribucionCartera.getValor());
		txtValor.setDisabled(false);
		txtIdCart_Cartera.setValue(selectedDistribucionCartera
				.getIdCart_Cartera());
		txtIdCart_Cartera.setDisabled(false);
		txtIdDica.setValue(selectedDistribucionCartera.getIdDica());
		txtIdDica.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedDistribucionCartera == null) && (entity == null)) {
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
			entity = new DistribucionCartera();

			Long idDica = new Long(txtIdDica.getValue().toString());

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaVencimiento(FacesUtils
					.checkDate(txtFechaVencimiento));
			entity.setIdDica(idDica);
			entity.setNumeroCuota(FacesUtils.checkLong(txtNumeroCuota));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setValor(FacesUtils.checkDouble(txtValor));
			entity.setCartera(businessDelegatorView.getCartera(FacesUtils
					.checkLong(txtIdCart_Cartera)));
			businessDelegatorView.saveDistribucionCartera(entity);
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
				Long idDica = new Long(selectedDistribucionCartera.getIdDica());
				entity = businessDelegatorView.getDistribucionCartera(idDica);
			}

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaVencimiento(FacesUtils
					.checkDate(txtFechaVencimiento));
			entity.setNumeroCuota(FacesUtils.checkLong(txtNumeroCuota));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setValor(FacesUtils.checkDouble(txtValor));
			entity.setCartera(businessDelegatorView.getCartera(FacesUtils
					.checkLong(txtIdCart_Cartera)));
			businessDelegatorView.updateDistribucionCartera(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedDistribucionCartera = (DistribucionCarteraDTO) (evt
					.getComponent().getAttributes()
					.get("selectedDistribucionCartera"));

			Long idDica = new Long(selectedDistribucionCartera.getIdDica());
			entity = businessDelegatorView.getDistribucionCartera(idDica);
			businessDelegatorView.deleteDistribucionCartera(entity);
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
			selectedDistribucionCartera = (DistribucionCarteraDTO) (evt
					.getComponent().getAttributes()
					.get("selectedDistribucionCartera"));

			Long idDica = new Long(selectedDistribucionCartera.getIdDica());
			entity = businessDelegatorView.getDistribucionCartera(idDica);
			businessDelegatorView.deleteDistribucionCartera(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedDistribucionCartera);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Date fechaVencimiento,
			Long idDica, Long numeroCuota, String operCreador,
			String operModifica, Double valor, Long idCart_Cartera)
			throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaVencimiento(FacesUtils.checkDate(fechaVencimiento));
			entity.setNumeroCuota(FacesUtils.checkLong(numeroCuota));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setValor(FacesUtils.checkDouble(valor));
			businessDelegatorView.updateDistribucionCartera(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DistribucionCarteraView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}

	public InputText getTxtNumeroCuota() {
		return txtNumeroCuota;
	}

	public void setTxtNumeroCuota(InputText txtNumeroCuota) {
		this.txtNumeroCuota = txtNumeroCuota;
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

	public InputText getTxtValor() {
		return txtValor;
	}

	public void setTxtValor(InputText txtValor) {
		this.txtValor = txtValor;
	}

	public InputText getTxtIdCart_Cartera() {
		return txtIdCart_Cartera;
	}

	public void setTxtIdCart_Cartera(InputText txtIdCart_Cartera) {
		this.txtIdCart_Cartera = txtIdCart_Cartera;
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

	public Calendar getTxtFechaVencimiento() {
		return txtFechaVencimiento;
	}

	public void setTxtFechaVencimiento(Calendar txtFechaVencimiento) {
		this.txtFechaVencimiento = txtFechaVencimiento;
	}

	public InputText getTxtIdDica() {
		return txtIdDica;
	}

	public void setTxtIdDica(InputText txtIdDica) {
		this.txtIdDica = txtIdDica;
	}

	public List<DistribucionCarteraDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDistribucionCartera();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DistribucionCarteraDTO> distribucionCarteraDTO) {
		this.data = distribucionCarteraDTO;
	}

	public DistribucionCarteraDTO getSelectedDistribucionCartera() {
		return selectedDistribucionCartera;
	}

	public void setSelectedDistribucionCartera(
			DistribucionCarteraDTO distribucionCartera) {
		this.selectedDistribucionCartera = distribucionCartera;
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
