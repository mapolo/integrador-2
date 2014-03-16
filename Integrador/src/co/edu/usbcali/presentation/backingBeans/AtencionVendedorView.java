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
import co.edu.usbcali.modelo.AtencionVendedor;
import co.edu.usbcali.modelo.dto.AtencionVendedorDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class AtencionVendedorView {
	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdReco_RelacionComercial;
	private InputText txtIdVend_Vendedor;
	private InputText txtIdAtve;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<AtencionVendedorDTO> data;
	private AtencionVendedorDTO selectedAtencionVendedor;
	private AtencionVendedor entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public AtencionVendedorView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			AtencionVendedorDTO atencionVendedorDTO = (AtencionVendedorDTO) e
					.getObject();

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(atencionVendedorDTO.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(atencionVendedorDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(atencionVendedorDTO.getOperModifica());

			if (txtIdReco_RelacionComercial == null) {
				txtIdReco_RelacionComercial = new InputText();
			}

			txtIdReco_RelacionComercial.setValue(atencionVendedorDTO
					.getIdReco_RelacionComercial());

			if (txtIdVend_Vendedor == null) {
				txtIdVend_Vendedor = new InputText();
			}

			txtIdVend_Vendedor.setValue(atencionVendedorDTO
					.getIdVend_Vendedor());

			if (txtIdAtve == null) {
				txtIdAtve = new InputText();
			}

			txtIdAtve.setValue(atencionVendedorDTO.getIdAtve());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(atencionVendedorDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(atencionVendedorDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedAtencionVendedor = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedAtencionVendedor = null;

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

		if (txtIdReco_RelacionComercial != null) {
			txtIdReco_RelacionComercial.setValue(null);
			txtIdReco_RelacionComercial.setDisabled(true);
		}

		if (txtIdVend_Vendedor != null) {
			txtIdVend_Vendedor.setValue(null);
			txtIdVend_Vendedor.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdAtve != null) {
			txtIdAtve.setValue(null);
			txtIdAtve.setDisabled(false);
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
			Long idAtve = new Long(txtIdAtve.getValue().toString());
			entity = businessDelegatorView.getAtencionVendedor(idAtve);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdReco_RelacionComercial.setDisabled(false);
			txtIdVend_Vendedor.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdAtve.setDisabled(false);
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
			txtIdReco_RelacionComercial.setValue(entity.getRelacionComercial()
					.getIdReco());
			txtIdReco_RelacionComercial.setDisabled(false);
			txtIdVend_Vendedor.setValue(entity.getVendedor().getIdVend());
			txtIdVend_Vendedor.setDisabled(false);
			txtIdAtve.setValue(entity.getIdAtve());
			txtIdAtve.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedAtencionVendedor = (AtencionVendedorDTO) (evt.getComponent()
				.getAttributes().get("selectedAtencionVendedor"));
		txtEstadoRegistro
				.setValue(selectedAtencionVendedor.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedAtencionVendedor.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedAtencionVendedor
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedAtencionVendedor.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedAtencionVendedor.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdReco_RelacionComercial.setValue(selectedAtencionVendedor
				.getIdReco_RelacionComercial());
		txtIdReco_RelacionComercial.setDisabled(false);
		txtIdVend_Vendedor.setValue(selectedAtencionVendedor
				.getIdVend_Vendedor());
		txtIdVend_Vendedor.setDisabled(false);
		txtIdAtve.setValue(selectedAtencionVendedor.getIdAtve());
		txtIdAtve.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedAtencionVendedor == null) && (entity == null)) {
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
			entity = new AtencionVendedor();

			Long idAtve = new Long(txtIdAtve.getValue().toString());

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdAtve(idAtve);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setRelacionComercial(businessDelegatorView
					.getRelacionComercial(FacesUtils
							.checkLong(txtIdReco_RelacionComercial)));
			entity.setVendedor(businessDelegatorView.getVendedor(FacesUtils
					.checkLong(txtIdVend_Vendedor)));
			businessDelegatorView.saveAtencionVendedor(entity);
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
				Long idAtve = new Long(selectedAtencionVendedor.getIdAtve());
				entity = businessDelegatorView.getAtencionVendedor(idAtve);
			}

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setRelacionComercial(businessDelegatorView
					.getRelacionComercial(FacesUtils
							.checkLong(txtIdReco_RelacionComercial)));
			entity.setVendedor(businessDelegatorView.getVendedor(FacesUtils
					.checkLong(txtIdVend_Vendedor)));
			businessDelegatorView.updateAtencionVendedor(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedAtencionVendedor = (AtencionVendedorDTO) (evt
					.getComponent().getAttributes()
					.get("selectedAtencionVendedor"));

			Long idAtve = new Long(selectedAtencionVendedor.getIdAtve());
			entity = businessDelegatorView.getAtencionVendedor(idAtve);
			businessDelegatorView.deleteAtencionVendedor(entity);
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
			selectedAtencionVendedor = (AtencionVendedorDTO) (evt
					.getComponent().getAttributes()
					.get("selectedAtencionVendedor"));

			Long idAtve = new Long(selectedAtencionVendedor.getIdAtve());
			entity = businessDelegatorView.getAtencionVendedor(idAtve);
			businessDelegatorView.deleteAtencionVendedor(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedAtencionVendedor);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idAtve,
			String operCreador, String operModifica,
			Long idReco_RelacionComercial, Long idVend_Vendedor)
			throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateAtencionVendedor(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("AtencionVendedorView").requestRender();
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

	public InputText getTxtIdReco_RelacionComercial() {
		return txtIdReco_RelacionComercial;
	}

	public void setTxtIdReco_RelacionComercial(
			InputText txtIdReco_RelacionComercial) {
		this.txtIdReco_RelacionComercial = txtIdReco_RelacionComercial;
	}

	public InputText getTxtIdVend_Vendedor() {
		return txtIdVend_Vendedor;
	}

	public void setTxtIdVend_Vendedor(InputText txtIdVend_Vendedor) {
		this.txtIdVend_Vendedor = txtIdVend_Vendedor;
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

	public InputText getTxtIdAtve() {
		return txtIdAtve;
	}

	public void setTxtIdAtve(InputText txtIdAtve) {
		this.txtIdAtve = txtIdAtve;
	}

	public List<AtencionVendedorDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataAtencionVendedor();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<AtencionVendedorDTO> atencionVendedorDTO) {
		this.data = atencionVendedorDTO;
	}

	public AtencionVendedorDTO getSelectedAtencionVendedor() {
		return selectedAtencionVendedor;
	}

	public void setSelectedAtencionVendedor(AtencionVendedorDTO atencionVendedor) {
		this.selectedAtencionVendedor = atencionVendedor;
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
