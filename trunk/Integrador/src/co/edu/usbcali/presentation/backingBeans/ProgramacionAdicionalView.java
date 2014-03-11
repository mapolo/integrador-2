package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.ProgramacionAdicionalDTO;
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
public class ProgramacionAdicionalView {
	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdAtve_AtencionVendedor;
	private InputText txtIdCusa_Causal;
	private InputText txtIdPrad;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaProgAdicional;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ProgramacionAdicionalDTO> data;
	private ProgramacionAdicionalDTO selectedProgramacionAdicional;
	private ProgramacionAdicional entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ProgramacionAdicionalView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ProgramacionAdicionalDTO programacionAdicionalDTO = (ProgramacionAdicionalDTO) e
					.getObject();

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(programacionAdicionalDTO
					.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(programacionAdicionalDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica
					.setValue(programacionAdicionalDTO.getOperModifica());

			if (txtIdAtve_AtencionVendedor == null) {
				txtIdAtve_AtencionVendedor = new InputText();
			}

			txtIdAtve_AtencionVendedor.setValue(programacionAdicionalDTO
					.getIdAtve_AtencionVendedor());

			if (txtIdCusa_Causal == null) {
				txtIdCusa_Causal = new InputText();
			}

			txtIdCusa_Causal.setValue(programacionAdicionalDTO
					.getIdCusa_Causal());

			if (txtIdPrad == null) {
				txtIdPrad = new InputText();
			}

			txtIdPrad.setValue(programacionAdicionalDTO.getIdPrad());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(programacionAdicionalDTO
					.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(programacionAdicionalDTO
					.getFechaModificacion());

			if (txtFechaProgAdicional == null) {
				txtFechaProgAdicional = new Calendar();
			}

			txtFechaProgAdicional.setValue(programacionAdicionalDTO
					.getFechaProgAdicional());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedProgramacionAdicional = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedProgramacionAdicional = null;

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

		if (txtIdCusa_Causal != null) {
			txtIdCusa_Causal.setValue(null);
			txtIdCusa_Causal.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtFechaProgAdicional != null) {
			txtFechaProgAdicional.setValue(null);
			txtFechaProgAdicional.setDisabled(true);
		}

		if (txtIdPrad != null) {
			txtIdPrad.setValue(null);
			txtIdPrad.setDisabled(false);
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

	public void listener_txtFechaProgAdicional() {
		Date inputDate = (Date) txtFechaProgAdicional.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Long idPrad = new Long(txtIdPrad.getValue().toString());
			entity = businessDelegatorView.getProgramacionAdicional(idPrad);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdAtve_AtencionVendedor.setDisabled(false);
			txtIdCusa_Causal.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtFechaProgAdicional.setDisabled(false);
			txtIdPrad.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtFechaProgAdicional.setValue(entity.getFechaProgAdicional());
			txtFechaProgAdicional.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdAtve_AtencionVendedor.setValue(entity.getAtencionVendedor()
					.getIdAtve());
			txtIdAtve_AtencionVendedor.setDisabled(false);
			txtIdCusa_Causal.setValue(entity.getCausal().getIdCusa());
			txtIdCusa_Causal.setDisabled(false);
			txtIdPrad.setValue(entity.getIdPrad());
			txtIdPrad.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedProgramacionAdicional = (ProgramacionAdicionalDTO) (evt
				.getComponent().getAttributes()
				.get("selectedProgramacionAdicional"));
		txtEstadoRegistro.setValue(selectedProgramacionAdicional
				.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedProgramacionAdicional
				.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedProgramacionAdicional
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtFechaProgAdicional.setValue(selectedProgramacionAdicional
				.getFechaProgAdicional());
		txtFechaProgAdicional.setDisabled(false);
		txtOperCreador.setValue(selectedProgramacionAdicional.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedProgramacionAdicional
				.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdAtve_AtencionVendedor.setValue(selectedProgramacionAdicional
				.getIdAtve_AtencionVendedor());
		txtIdAtve_AtencionVendedor.setDisabled(false);
		txtIdCusa_Causal.setValue(selectedProgramacionAdicional
				.getIdCusa_Causal());
		txtIdCusa_Causal.setDisabled(false);
		txtIdPrad.setValue(selectedProgramacionAdicional.getIdPrad());
		txtIdPrad.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedProgramacionAdicional == null) && (entity == null)) {
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
			entity = new ProgramacionAdicional();

			Long idPrad = new Long(txtIdPrad.getValue().toString());

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaProgAdicional(FacesUtils
					.checkDate(txtFechaProgAdicional));
			entity.setIdPrad(idPrad);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setAtencionVendedor(businessDelegatorView
					.getAtencionVendedor(FacesUtils
							.checkLong(txtIdAtve_AtencionVendedor)));
			entity.setCausal(businessDelegatorView.getCausal(FacesUtils
					.checkLong(txtIdCusa_Causal)));
			businessDelegatorView.saveProgramacionAdicional(entity);
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
				Long idPrad = new Long(
						selectedProgramacionAdicional.getIdPrad());
				entity = businessDelegatorView.getProgramacionAdicional(idPrad);
			}

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaProgAdicional(FacesUtils
					.checkDate(txtFechaProgAdicional));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setAtencionVendedor(businessDelegatorView
					.getAtencionVendedor(FacesUtils
							.checkLong(txtIdAtve_AtencionVendedor)));
			entity.setCausal(businessDelegatorView.getCausal(FacesUtils
					.checkLong(txtIdCusa_Causal)));
			businessDelegatorView.updateProgramacionAdicional(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedProgramacionAdicional = (ProgramacionAdicionalDTO) (evt
					.getComponent().getAttributes()
					.get("selectedProgramacionAdicional"));

			Long idPrad = new Long(selectedProgramacionAdicional.getIdPrad());
			entity = businessDelegatorView.getProgramacionAdicional(idPrad);
			businessDelegatorView.deleteProgramacionAdicional(entity);
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
			selectedProgramacionAdicional = (ProgramacionAdicionalDTO) (evt
					.getComponent().getAttributes()
					.get("selectedProgramacionAdicional"));

			Long idPrad = new Long(selectedProgramacionAdicional.getIdPrad());
			entity = businessDelegatorView.getProgramacionAdicional(idPrad);
			businessDelegatorView.deleteProgramacionAdicional(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedProgramacionAdicional);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion,
			Date fechaProgAdicional, Long idPrad, String operCreador,
			String operModifica, Long idAtve_AtencionVendedor,
			Long idCusa_Causal) throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaProgAdicional(FacesUtils
					.checkDate(fechaProgAdicional));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateProgramacionAdicional(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ProgramacionAdicionalView").requestRender();
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

	public InputText getTxtIdCusa_Causal() {
		return txtIdCusa_Causal;
	}

	public void setTxtIdCusa_Causal(InputText txtIdCusa_Causal) {
		this.txtIdCusa_Causal = txtIdCusa_Causal;
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

	public Calendar getTxtFechaProgAdicional() {
		return txtFechaProgAdicional;
	}

	public void setTxtFechaProgAdicional(Calendar txtFechaProgAdicional) {
		this.txtFechaProgAdicional = txtFechaProgAdicional;
	}

	public InputText getTxtIdPrad() {
		return txtIdPrad;
	}

	public void setTxtIdPrad(InputText txtIdPrad) {
		this.txtIdPrad = txtIdPrad;
	}

	public List<ProgramacionAdicionalDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataProgramacionAdicional();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ProgramacionAdicionalDTO> programacionAdicionalDTO) {
		this.data = programacionAdicionalDTO;
	}

	public ProgramacionAdicionalDTO getSelectedProgramacionAdicional() {
		return selectedProgramacionAdicional;
	}

	public void setSelectedProgramacionAdicional(
			ProgramacionAdicionalDTO programacionAdicional) {
		this.selectedProgramacionAdicional = programacionAdicional;
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
