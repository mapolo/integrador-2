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
import co.edu.usbcali.modelo.MovimientoVendedor;
import co.edu.usbcali.modelo.dto.MovimientoVendedorDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class MovimientoVendedorView {
	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdMoin_MovimientoInventario;
	private InputText txtIdUnve_UnidadVenta;
	private InputText txtIdMven;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<MovimientoVendedorDTO> data;
	private MovimientoVendedorDTO selectedMovimientoVendedor;
	private MovimientoVendedor entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public MovimientoVendedorView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			MovimientoVendedorDTO movimientoVendedorDTO = (MovimientoVendedorDTO) e
					.getObject();

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(movimientoVendedorDTO
					.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(movimientoVendedorDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(movimientoVendedorDTO.getOperModifica());

			if (txtIdMoin_MovimientoInventario == null) {
				txtIdMoin_MovimientoInventario = new InputText();
			}

			txtIdMoin_MovimientoInventario.setValue(movimientoVendedorDTO
					.getIdMoin_MovimientoInventario());

			if (txtIdUnve_UnidadVenta == null) {
				txtIdUnve_UnidadVenta = new InputText();
			}

			txtIdUnve_UnidadVenta.setValue(movimientoVendedorDTO
					.getIdUnve_UnidadVenta());

			if (txtIdMven == null) {
				txtIdMven = new InputText();
			}

			txtIdMven.setValue(movimientoVendedorDTO.getIdMven());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(movimientoVendedorDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(movimientoVendedorDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedMovimientoVendedor = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedMovimientoVendedor = null;

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtIdMoin_MovimientoInventario != null) {
			txtIdMoin_MovimientoInventario.setValue(null);
			txtIdMoin_MovimientoInventario.setDisabled(true);
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

		if (txtIdMven != null) {
			txtIdMven.setValue(null);
			txtIdMven.setDisabled(false);
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
			Long idMven = new Long(txtIdMven.getValue().toString());
			entity = businessDelegatorView.getMovimientoVendedor(idMven);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdMoin_MovimientoInventario.setDisabled(false);
			txtIdUnve_UnidadVenta.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdMven.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdMoin_MovimientoInventario.setValue(entity
					.getMovimientoInventario().getIdMoin());
			txtIdMoin_MovimientoInventario.setDisabled(false);
			txtIdUnve_UnidadVenta.setValue(entity.getUnidadVenta().getIdUnve());
			txtIdUnve_UnidadVenta.setDisabled(false);
			txtIdMven.setValue(entity.getIdMven());
			txtIdMven.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedMovimientoVendedor = (MovimientoVendedorDTO) (evt
				.getComponent().getAttributes()
				.get("selectedMovimientoVendedor"));
		txtEstadoRegistro.setValue(selectedMovimientoVendedor
				.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion
				.setValue(selectedMovimientoVendedor.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedMovimientoVendedor
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedMovimientoVendedor.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedMovimientoVendedor.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdMoin_MovimientoInventario.setValue(selectedMovimientoVendedor
				.getIdMoin_MovimientoInventario());
		txtIdMoin_MovimientoInventario.setDisabled(false);
		txtIdUnve_UnidadVenta.setValue(selectedMovimientoVendedor
				.getIdUnve_UnidadVenta());
		txtIdUnve_UnidadVenta.setDisabled(false);
		txtIdMven.setValue(selectedMovimientoVendedor.getIdMven());
		txtIdMven.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedMovimientoVendedor == null) && (entity == null)) {
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
			entity = new MovimientoVendedor();

			Long idMven = new Long(txtIdMven.getValue().toString());

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdMven(idMven);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setMovimientoInventario(businessDelegatorView
					.getMovimientoInventario(FacesUtils
							.checkLong(txtIdMoin_MovimientoInventario)));
			entity.setUnidadVenta(businessDelegatorView
					.getUnidadVenta(FacesUtils.checkLong(txtIdUnve_UnidadVenta)));
			businessDelegatorView.saveMovimientoVendedor(entity);
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
				Long idMven = new Long(selectedMovimientoVendedor.getIdMven());
				entity = businessDelegatorView.getMovimientoVendedor(idMven);
			}

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setMovimientoInventario(businessDelegatorView
					.getMovimientoInventario(FacesUtils
							.checkLong(txtIdMoin_MovimientoInventario)));
			entity.setUnidadVenta(businessDelegatorView
					.getUnidadVenta(FacesUtils.checkLong(txtIdUnve_UnidadVenta)));
			businessDelegatorView.updateMovimientoVendedor(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedMovimientoVendedor = (MovimientoVendedorDTO) (evt
					.getComponent().getAttributes()
					.get("selectedMovimientoVendedor"));

			Long idMven = new Long(selectedMovimientoVendedor.getIdMven());
			entity = businessDelegatorView.getMovimientoVendedor(idMven);
			businessDelegatorView.deleteMovimientoVendedor(entity);
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
			selectedMovimientoVendedor = (MovimientoVendedorDTO) (evt
					.getComponent().getAttributes()
					.get("selectedMovimientoVendedor"));

			Long idMven = new Long(selectedMovimientoVendedor.getIdMven());
			entity = businessDelegatorView.getMovimientoVendedor(idMven);
			businessDelegatorView.deleteMovimientoVendedor(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedMovimientoVendedor);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idMven,
			String operCreador, String operModifica,
			Long idMoin_MovimientoInventario, Long idUnve_UnidadVenta)
			throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateMovimientoVendedor(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("MovimientoVendedorView").requestRender();
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

	public InputText getTxtIdMoin_MovimientoInventario() {
		return txtIdMoin_MovimientoInventario;
	}

	public void setTxtIdMoin_MovimientoInventario(
			InputText txtIdMoin_MovimientoInventario) {
		this.txtIdMoin_MovimientoInventario = txtIdMoin_MovimientoInventario;
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

	public InputText getTxtIdMven() {
		return txtIdMven;
	}

	public void setTxtIdMven(InputText txtIdMven) {
		this.txtIdMven = txtIdMven;
	}

	public List<MovimientoVendedorDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataMovimientoVendedor();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<MovimientoVendedorDTO> movimientoVendedorDTO) {
		this.data = movimientoVendedorDTO;
	}

	public MovimientoVendedorDTO getSelectedMovimientoVendedor() {
		return selectedMovimientoVendedor;
	}

	public void setSelectedMovimientoVendedor(
			MovimientoVendedorDTO movimientoVendedor) {
		this.selectedMovimientoVendedor = movimientoVendedor;
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
