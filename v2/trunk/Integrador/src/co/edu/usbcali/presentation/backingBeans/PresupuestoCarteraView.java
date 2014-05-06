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
import co.edu.usbcali.modelo.PresupuestoCartera;
import co.edu.usbcali.modelo.dto.PresupuestoCarteraDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class PresupuestoCarteraView {
	private InputText txtAno;
	private InputText txtEstadoRegistro;
	private InputText txtMes;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtValorPresupuesto;
	private InputText txtIdUnve_UnidadVenta;
	private InputText txtIdPrca;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<PresupuestoCarteraDTO> data;
	private PresupuestoCarteraDTO selectedPresupuestoCartera;
	private PresupuestoCartera entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public PresupuestoCarteraView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			PresupuestoCarteraDTO presupuestoCarteraDTO = (PresupuestoCarteraDTO) e
					.getObject();

			if (txtAno == null) {
				txtAno = new InputText();
			}

			txtAno.setValue(presupuestoCarteraDTO.getAno());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(presupuestoCarteraDTO
					.getEstadoRegistro());

			if (txtMes == null) {
				txtMes = new InputText();
			}

			txtMes.setValue(presupuestoCarteraDTO.getMes());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(presupuestoCarteraDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(presupuestoCarteraDTO.getOperModifica());

			if (txtValorPresupuesto == null) {
				txtValorPresupuesto = new InputText();
			}

			txtValorPresupuesto.setValue(presupuestoCarteraDTO
					.getValorPresupuesto());

			if (txtIdUnve_UnidadVenta == null) {
				txtIdUnve_UnidadVenta = new InputText();
			}

			txtIdUnve_UnidadVenta.setValue(presupuestoCarteraDTO
					.getIdUnve_UnidadVenta());

			if (txtIdPrca == null) {
				txtIdPrca = new InputText();
			}

			txtIdPrca.setValue(presupuestoCarteraDTO.getIdPrca());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(presupuestoCarteraDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(presupuestoCarteraDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedPresupuestoCartera = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedPresupuestoCartera = null;

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

		if (txtValorPresupuesto != null) {
			txtValorPresupuesto.setValue(null);
			txtValorPresupuesto.setDisabled(true);
		}

		if (txtIdUnve_UnidadVenta != null) {
			txtIdUnve_UnidadVenta.setValue(null);
			txtIdUnve_UnidadVenta.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdPrca != null) {
			txtIdPrca.setValue(null);
			txtIdPrca.setDisabled(false);
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
			Long idPrca = new Long(txtIdPrca.getValue().toString());
			entity = businessDelegatorView.getPresupuestoCartera(idPrca);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtAno.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtMes.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtValorPresupuesto.setDisabled(false);
			txtIdUnve_UnidadVenta.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdPrca.setDisabled(false);
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
			txtValorPresupuesto.setValue(entity.getValorPresupuesto());
			txtValorPresupuesto.setDisabled(false);
			txtIdUnve_UnidadVenta.setValue(entity.getUnidadVenta().getIdUnve());
			txtIdUnve_UnidadVenta.setDisabled(false);
			txtIdPrca.setValue(entity.getIdPrca());
			txtIdPrca.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedPresupuestoCartera = (PresupuestoCarteraDTO) (evt
				.getComponent().getAttributes()
				.get("selectedPresupuestoCartera"));
		txtAno.setValue(selectedPresupuestoCartera.getAno());
		txtAno.setDisabled(false);
		txtEstadoRegistro.setValue(selectedPresupuestoCartera
				.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion
				.setValue(selectedPresupuestoCartera.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedPresupuestoCartera
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtMes.setValue(selectedPresupuestoCartera.getMes());
		txtMes.setDisabled(false);
		txtOperCreador.setValue(selectedPresupuestoCartera.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedPresupuestoCartera.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtValorPresupuesto.setValue(selectedPresupuestoCartera
				.getValorPresupuesto());
		txtValorPresupuesto.setDisabled(false);
		txtIdUnve_UnidadVenta.setValue(selectedPresupuestoCartera
				.getIdUnve_UnidadVenta());
		txtIdUnve_UnidadVenta.setDisabled(false);
		txtIdPrca.setValue(selectedPresupuestoCartera.getIdPrca());
		txtIdPrca.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedPresupuestoCartera == null) && (entity == null)) {
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
			entity = new PresupuestoCartera();

			Long idPrca = new Long(txtIdPrca.getValue().toString());

			entity.setAno(FacesUtils.checkLong(txtAno));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdPrca(idPrca);
			entity.setMes(FacesUtils.checkLong(txtMes));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setValorPresupuesto(FacesUtils
					.checkDouble(txtValorPresupuesto));
			entity.setUnidadVenta(businessDelegatorView
					.getUnidadVenta(FacesUtils.checkLong(txtIdUnve_UnidadVenta)));
			businessDelegatorView.savePresupuestoCartera(entity);
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
				Long idPrca = new Long(selectedPresupuestoCartera.getIdPrca());
				entity = businessDelegatorView.getPresupuestoCartera(idPrca);
			}

			entity.setAno(FacesUtils.checkLong(txtAno));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setMes(FacesUtils.checkLong(txtMes));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setValorPresupuesto(FacesUtils
					.checkDouble(txtValorPresupuesto));
			entity.setUnidadVenta(businessDelegatorView
					.getUnidadVenta(FacesUtils.checkLong(txtIdUnve_UnidadVenta)));
			businessDelegatorView.updatePresupuestoCartera(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedPresupuestoCartera = (PresupuestoCarteraDTO) (evt
					.getComponent().getAttributes()
					.get("selectedPresupuestoCartera"));

			Long idPrca = new Long(selectedPresupuestoCartera.getIdPrca());
			entity = businessDelegatorView.getPresupuestoCartera(idPrca);
			businessDelegatorView.deletePresupuestoCartera(entity);
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
			selectedPresupuestoCartera = (PresupuestoCarteraDTO) (evt
					.getComponent().getAttributes()
					.get("selectedPresupuestoCartera"));

			Long idPrca = new Long(selectedPresupuestoCartera.getIdPrca());
			entity = businessDelegatorView.getPresupuestoCartera(idPrca);
			businessDelegatorView.deletePresupuestoCartera(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedPresupuestoCartera);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long ano, String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idPrca, Long mes,
			String operCreador, String operModifica, Double valorPresupuesto,
			Long idUnve_UnidadVenta) throws Exception {
		try {
			entity.setAno(FacesUtils.checkLong(ano));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setMes(FacesUtils.checkLong(mes));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setValorPresupuesto(FacesUtils.checkDouble(valorPresupuesto));
			businessDelegatorView.updatePresupuestoCartera(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("PresupuestoCarteraView").requestRender();
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

	public InputText getTxtValorPresupuesto() {
		return txtValorPresupuesto;
	}

	public void setTxtValorPresupuesto(InputText txtValorPresupuesto) {
		this.txtValorPresupuesto = txtValorPresupuesto;
	}

	public InputText getTxtIdUnve_UnidadVenta() {
		return txtIdUnve_UnidadVenta;
	}

	public void setTxtIdUnve_UnidadVenta(InputText txtIdUnve_UnidadVenta) {
		this.txtIdUnve_UnidadVenta = txtIdUnve_UnidadVenta;
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

	public InputText getTxtIdPrca() {
		return txtIdPrca;
	}

	public void setTxtIdPrca(InputText txtIdPrca) {
		this.txtIdPrca = txtIdPrca;
	}

	public List<PresupuestoCarteraDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataPresupuestoCartera();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<PresupuestoCarteraDTO> presupuestoCarteraDTO) {
		this.data = presupuestoCarteraDTO;
	}

	public PresupuestoCarteraDTO getSelectedPresupuestoCartera() {
		return selectedPresupuestoCartera;
	}

	public void setSelectedPresupuestoCartera(
			PresupuestoCarteraDTO presupuestoCartera) {
		this.selectedPresupuestoCartera = presupuestoCartera;
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
