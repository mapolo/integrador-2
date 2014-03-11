package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.RutaRelacionComercialDTO;
import co.edu.usbcali.presentation.businessDelegate.*;
import co.edu.usbcali.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class RutaRelacionComercialView {
	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdAtve_AtencionVendedor;
	private InputText txtIdRudi_RutaDistribucion;
	private InputText txtIdRrec;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<RutaRelacionComercialDTO> data;
	private RutaRelacionComercialDTO selectedRutaRelacionComercial;
	private RutaRelacionComercial entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public RutaRelacionComercialView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			RutaRelacionComercialDTO rutaRelacionComercialDTO = (RutaRelacionComercialDTO) e
					.getObject();

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(rutaRelacionComercialDTO
					.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(rutaRelacionComercialDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica
					.setValue(rutaRelacionComercialDTO.getOperModifica());

			if (txtIdAtve_AtencionVendedor == null) {
				txtIdAtve_AtencionVendedor = new InputText();
			}

			txtIdAtve_AtencionVendedor.setValue(rutaRelacionComercialDTO
					.getIdAtve_AtencionVendedor());

			if (txtIdRudi_RutaDistribucion == null) {
				txtIdRudi_RutaDistribucion = new InputText();
			}

			txtIdRudi_RutaDistribucion.setValue(rutaRelacionComercialDTO
					.getIdRudi_RutaDistribucion());

			if (txtIdRrec == null) {
				txtIdRrec = new InputText();
			}

			txtIdRrec.setValue(rutaRelacionComercialDTO.getIdRrec());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(rutaRelacionComercialDTO
					.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(rutaRelacionComercialDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedRutaRelacionComercial = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedRutaRelacionComercial = null;

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

		if (txtIdAtve_AtencionVendedor != null) {
			txtIdAtve_AtencionVendedor.setValue(null);
			txtIdAtve_AtencionVendedor.setDisabled(true);
		}

		if (txtIdRudi_RutaDistribucion != null) {
			txtIdRudi_RutaDistribucion.setValue(null);
			txtIdRudi_RutaDistribucion.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdRrec != null) {
			txtIdRrec.setValue(null);
			txtIdRrec.setDisabled(false);
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
			Long idRrec = new Long(txtIdRrec.getValue().toString());
			entity = businessDelegatorView.getRutaRelacionComercial(idRrec);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdAtve_AtencionVendedor.setDisabled(false);
			txtIdRudi_RutaDistribucion.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdRrec.setDisabled(false);
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
			txtIdAtve_AtencionVendedor.setValue(entity.getAtencionVendedor()
					.getIdAtve());
			txtIdAtve_AtencionVendedor.setDisabled(false);
			txtIdRudi_RutaDistribucion.setValue(entity.getRutaDistribucion()
					.getIdRudi());
			txtIdRudi_RutaDistribucion.setDisabled(false);
			txtIdRrec.setValue(entity.getIdRrec());
			txtIdRrec.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedRutaRelacionComercial = (RutaRelacionComercialDTO) (evt
				.getComponent().getAttributes()
				.get("selectedRutaRelacionComercial"));
		txtEstadoRegistro.setValue(selectedRutaRelacionComercial
				.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedRutaRelacionComercial
				.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedRutaRelacionComercial
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedRutaRelacionComercial.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedRutaRelacionComercial
				.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdAtve_AtencionVendedor.setValue(selectedRutaRelacionComercial
				.getIdAtve_AtencionVendedor());
		txtIdAtve_AtencionVendedor.setDisabled(false);
		txtIdRudi_RutaDistribucion.setValue(selectedRutaRelacionComercial
				.getIdRudi_RutaDistribucion());
		txtIdRudi_RutaDistribucion.setDisabled(false);
		txtIdRrec.setValue(selectedRutaRelacionComercial.getIdRrec());
		txtIdRrec.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedRutaRelacionComercial == null) && (entity == null)) {
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
			entity = new RutaRelacionComercial();

			Long idRrec = new Long(txtIdRrec.getValue().toString());

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdRrec(idRrec);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setAtencionVendedor(businessDelegatorView
					.getAtencionVendedor(FacesUtils
							.checkLong(txtIdAtve_AtencionVendedor)));
			entity.setRutaDistribucion(businessDelegatorView
					.getRutaDistribucion(FacesUtils
							.checkLong(txtIdRudi_RutaDistribucion)));
			businessDelegatorView.saveRutaRelacionComercial(entity);
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
				Long idRrec = new Long(
						selectedRutaRelacionComercial.getIdRrec());
				entity = businessDelegatorView.getRutaRelacionComercial(idRrec);
			}

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setAtencionVendedor(businessDelegatorView
					.getAtencionVendedor(FacesUtils
							.checkLong(txtIdAtve_AtencionVendedor)));
			entity.setRutaDistribucion(businessDelegatorView
					.getRutaDistribucion(FacesUtils
							.checkLong(txtIdRudi_RutaDistribucion)));
			businessDelegatorView.updateRutaRelacionComercial(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedRutaRelacionComercial = (RutaRelacionComercialDTO) (evt
					.getComponent().getAttributes()
					.get("selectedRutaRelacionComercial"));

			Long idRrec = new Long(selectedRutaRelacionComercial.getIdRrec());
			entity = businessDelegatorView.getRutaRelacionComercial(idRrec);
			businessDelegatorView.deleteRutaRelacionComercial(entity);
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
			selectedRutaRelacionComercial = (RutaRelacionComercialDTO) (evt
					.getComponent().getAttributes()
					.get("selectedRutaRelacionComercial"));

			Long idRrec = new Long(selectedRutaRelacionComercial.getIdRrec());
			entity = businessDelegatorView.getRutaRelacionComercial(idRrec);
			businessDelegatorView.deleteRutaRelacionComercial(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedRutaRelacionComercial);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idRrec,
			String operCreador, String operModifica,
			Long idAtve_AtencionVendedor, Long idRudi_RutaDistribucion)
			throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateRutaRelacionComercial(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("RutaRelacionComercialView").requestRender();
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

	public InputText getTxtIdAtve_AtencionVendedor() {
		return txtIdAtve_AtencionVendedor;
	}

	public void setTxtIdAtve_AtencionVendedor(
			InputText txtIdAtve_AtencionVendedor) {
		this.txtIdAtve_AtencionVendedor = txtIdAtve_AtencionVendedor;
	}

	public InputText getTxtIdRudi_RutaDistribucion() {
		return txtIdRudi_RutaDistribucion;
	}

	public void setTxtIdRudi_RutaDistribucion(
			InputText txtIdRudi_RutaDistribucion) {
		this.txtIdRudi_RutaDistribucion = txtIdRudi_RutaDistribucion;
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

	public InputText getTxtIdRrec() {
		return txtIdRrec;
	}

	public void setTxtIdRrec(InputText txtIdRrec) {
		this.txtIdRrec = txtIdRrec;
	}

	public List<RutaRelacionComercialDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataRutaRelacionComercial();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<RutaRelacionComercialDTO> rutaRelacionComercialDTO) {
		this.data = rutaRelacionComercialDTO;
	}

	public RutaRelacionComercialDTO getSelectedRutaRelacionComercial() {
		return selectedRutaRelacionComercial;
	}

	public void setSelectedRutaRelacionComercial(
			RutaRelacionComercialDTO rutaRelacionComercial) {
		this.selectedRutaRelacionComercial = rutaRelacionComercial;
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
