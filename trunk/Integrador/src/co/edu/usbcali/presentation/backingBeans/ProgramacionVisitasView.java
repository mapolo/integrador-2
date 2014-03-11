package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.ProgramacionVisitasDTO;
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
public class ProgramacionVisitasView {
	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdAtve_AtencionVendedor;
	private InputText txtIdDise_DiasSemana;
	private InputText txtIdFrvi_FrecuenciaVisita;
	private InputText txtIdPrvi;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ProgramacionVisitasDTO> data;
	private ProgramacionVisitasDTO selectedProgramacionVisitas;
	private ProgramacionVisitas entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ProgramacionVisitasView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ProgramacionVisitasDTO programacionVisitasDTO = (ProgramacionVisitasDTO) e
					.getObject();

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(programacionVisitasDTO
					.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(programacionVisitasDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(programacionVisitasDTO.getOperModifica());

			if (txtIdAtve_AtencionVendedor == null) {
				txtIdAtve_AtencionVendedor = new InputText();
			}

			txtIdAtve_AtencionVendedor.setValue(programacionVisitasDTO
					.getIdAtve_AtencionVendedor());

			if (txtIdDise_DiasSemana == null) {
				txtIdDise_DiasSemana = new InputText();
			}

			txtIdDise_DiasSemana.setValue(programacionVisitasDTO
					.getIdDise_DiasSemana());

			if (txtIdFrvi_FrecuenciaVisita == null) {
				txtIdFrvi_FrecuenciaVisita = new InputText();
			}

			txtIdFrvi_FrecuenciaVisita.setValue(programacionVisitasDTO
					.getIdFrvi_FrecuenciaVisita());

			if (txtIdPrvi == null) {
				txtIdPrvi = new InputText();
			}

			txtIdPrvi.setValue(programacionVisitasDTO.getIdPrvi());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion
					.setValue(programacionVisitasDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(programacionVisitasDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedProgramacionVisitas = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedProgramacionVisitas = null;

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

		if (txtIdDise_DiasSemana != null) {
			txtIdDise_DiasSemana.setValue(null);
			txtIdDise_DiasSemana.setDisabled(true);
		}

		if (txtIdFrvi_FrecuenciaVisita != null) {
			txtIdFrvi_FrecuenciaVisita.setValue(null);
			txtIdFrvi_FrecuenciaVisita.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdPrvi != null) {
			txtIdPrvi.setValue(null);
			txtIdPrvi.setDisabled(false);
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
			Long idPrvi = new Long(txtIdPrvi.getValue().toString());
			entity = businessDelegatorView.getProgramacionVisitas(idPrvi);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdAtve_AtencionVendedor.setDisabled(false);
			txtIdDise_DiasSemana.setDisabled(false);
			txtIdFrvi_FrecuenciaVisita.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdPrvi.setDisabled(false);
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
			txtIdDise_DiasSemana.setValue(entity.getDiasSemana().getIdDise());
			txtIdDise_DiasSemana.setDisabled(false);
			txtIdFrvi_FrecuenciaVisita.setValue(entity.getFrecuenciaVisita()
					.getIdFrvi());
			txtIdFrvi_FrecuenciaVisita.setDisabled(false);
			txtIdPrvi.setValue(entity.getIdPrvi());
			txtIdPrvi.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedProgramacionVisitas = (ProgramacionVisitasDTO) (evt
				.getComponent().getAttributes()
				.get("selectedProgramacionVisitas"));
		txtEstadoRegistro.setValue(selectedProgramacionVisitas
				.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedProgramacionVisitas
				.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedProgramacionVisitas
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedProgramacionVisitas.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedProgramacionVisitas.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdAtve_AtencionVendedor.setValue(selectedProgramacionVisitas
				.getIdAtve_AtencionVendedor());
		txtIdAtve_AtencionVendedor.setDisabled(false);
		txtIdDise_DiasSemana.setValue(selectedProgramacionVisitas
				.getIdDise_DiasSemana());
		txtIdDise_DiasSemana.setDisabled(false);
		txtIdFrvi_FrecuenciaVisita.setValue(selectedProgramacionVisitas
				.getIdFrvi_FrecuenciaVisita());
		txtIdFrvi_FrecuenciaVisita.setDisabled(false);
		txtIdPrvi.setValue(selectedProgramacionVisitas.getIdPrvi());
		txtIdPrvi.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedProgramacionVisitas == null) && (entity == null)) {
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
			entity = new ProgramacionVisitas();

			Long idPrvi = new Long(txtIdPrvi.getValue().toString());

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdPrvi(idPrvi);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setAtencionVendedor(businessDelegatorView
					.getAtencionVendedor(FacesUtils
							.checkLong(txtIdAtve_AtencionVendedor)));
			entity.setDiasSemana(businessDelegatorView.getDiasSemana(FacesUtils
					.checkLong(txtIdDise_DiasSemana)));
			entity.setFrecuenciaVisita(businessDelegatorView
					.getFrecuenciaVisita(FacesUtils
							.checkLong(txtIdFrvi_FrecuenciaVisita)));
			businessDelegatorView.saveProgramacionVisitas(entity);
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
				Long idPrvi = new Long(selectedProgramacionVisitas.getIdPrvi());
				entity = businessDelegatorView.getProgramacionVisitas(idPrvi);
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
			entity.setDiasSemana(businessDelegatorView.getDiasSemana(FacesUtils
					.checkLong(txtIdDise_DiasSemana)));
			entity.setFrecuenciaVisita(businessDelegatorView
					.getFrecuenciaVisita(FacesUtils
							.checkLong(txtIdFrvi_FrecuenciaVisita)));
			businessDelegatorView.updateProgramacionVisitas(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedProgramacionVisitas = (ProgramacionVisitasDTO) (evt
					.getComponent().getAttributes()
					.get("selectedProgramacionVisitas"));

			Long idPrvi = new Long(selectedProgramacionVisitas.getIdPrvi());
			entity = businessDelegatorView.getProgramacionVisitas(idPrvi);
			businessDelegatorView.deleteProgramacionVisitas(entity);
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
			selectedProgramacionVisitas = (ProgramacionVisitasDTO) (evt
					.getComponent().getAttributes()
					.get("selectedProgramacionVisitas"));

			Long idPrvi = new Long(selectedProgramacionVisitas.getIdPrvi());
			entity = businessDelegatorView.getProgramacionVisitas(idPrvi);
			businessDelegatorView.deleteProgramacionVisitas(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedProgramacionVisitas);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idPrvi,
			String operCreador, String operModifica,
			Long idAtve_AtencionVendedor, Long idDise_DiasSemana,
			Long idFrvi_FrecuenciaVisita) throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateProgramacionVisitas(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ProgramacionVisitasView").requestRender();
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

	public InputText getTxtIdDise_DiasSemana() {
		return txtIdDise_DiasSemana;
	}

	public void setTxtIdDise_DiasSemana(InputText txtIdDise_DiasSemana) {
		this.txtIdDise_DiasSemana = txtIdDise_DiasSemana;
	}

	public InputText getTxtIdFrvi_FrecuenciaVisita() {
		return txtIdFrvi_FrecuenciaVisita;
	}

	public void setTxtIdFrvi_FrecuenciaVisita(
			InputText txtIdFrvi_FrecuenciaVisita) {
		this.txtIdFrvi_FrecuenciaVisita = txtIdFrvi_FrecuenciaVisita;
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

	public InputText getTxtIdPrvi() {
		return txtIdPrvi;
	}

	public void setTxtIdPrvi(InputText txtIdPrvi) {
		this.txtIdPrvi = txtIdPrvi;
	}

	public List<ProgramacionVisitasDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataProgramacionVisitas();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ProgramacionVisitasDTO> programacionVisitasDTO) {
		this.data = programacionVisitasDTO;
	}

	public ProgramacionVisitasDTO getSelectedProgramacionVisitas() {
		return selectedProgramacionVisitas;
	}

	public void setSelectedProgramacionVisitas(
			ProgramacionVisitasDTO programacionVisitas) {
		this.selectedProgramacionVisitas = programacionVisitas;
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
