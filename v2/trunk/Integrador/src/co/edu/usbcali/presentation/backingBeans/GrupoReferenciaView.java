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
import co.edu.usbcali.modelo.GrupoReferencia;
import co.edu.usbcali.modelo.dto.GrupoReferenciaDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class GrupoReferenciaView {
	private InputText txtActivo;
	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdGrpo_Grupo;
	private InputText txtIdRefe_Referencia;
	private InputText txtIdGrre;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaInactivo;
	private Calendar txtFechaModificacion;

	private String activo;
	private String estadoRegistro;
	private String operCreador;
	private String operModifica;
	private String idGrpo_Grupo;
	private String idRefe_Referencia;
	private String idGrre;
	private String fechaCreacion;
	private String fechaInactivo;
	private String fechaModificacion;

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<GrupoReferenciaDTO> data;
	private GrupoReferenciaDTO selectedGrupoReferencia;
	private GrupoReferencia entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public GrupoReferenciaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			GrupoReferenciaDTO grupoReferenciaDTO = (GrupoReferenciaDTO) e
					.getObject();

			if (txtActivo == null) {
				txtActivo = new InputText();
			}

			txtActivo.setValue(grupoReferenciaDTO.getActivo());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(grupoReferenciaDTO.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(grupoReferenciaDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(grupoReferenciaDTO.getOperModifica());

			if (txtIdGrpo_Grupo == null) {
				txtIdGrpo_Grupo = new InputText();
			}

			txtIdGrpo_Grupo.setValue(grupoReferenciaDTO.getIdGrpo_Grupo());

			if (txtIdRefe_Referencia == null) {
				txtIdRefe_Referencia = new InputText();
			}

			txtIdRefe_Referencia.setValue(grupoReferenciaDTO
					.getIdRefe_Referencia());

			if (txtIdGrre == null) {
				txtIdGrre = new InputText();
			}

			txtIdGrre.setValue(grupoReferenciaDTO.getIdGrre());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(grupoReferenciaDTO.getFechaCreacion());

			if (txtFechaInactivo == null) {
				txtFechaInactivo = new Calendar();
			}

			txtFechaInactivo.setValue(grupoReferenciaDTO.getFechaInactivo());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(grupoReferenciaDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedGrupoReferencia = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedGrupoReferencia = null;

		if (txtActivo != null) {
			txtActivo.setValue(null);
			txtActivo.setDisabled(true);
		}

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

		if (txtIdGrpo_Grupo != null) {
			txtIdGrpo_Grupo.setValue(null);
			txtIdGrpo_Grupo.setDisabled(true);
		}

		if (txtIdRefe_Referencia != null) {
			txtIdRefe_Referencia.setValue(null);
			txtIdRefe_Referencia.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaInactivo != null) {
			txtFechaInactivo.setValue(null);
			txtFechaInactivo.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdGrre != null) {
			txtIdGrre.setValue(null);
			txtIdGrre.setDisabled(false);
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

	public void listener_txtFechaInactivo() {
		Date inputDate = (Date) txtFechaInactivo.getValue();
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
			Long idGrre = new Long(txtIdGrre.getValue().toString());
			entity = businessDelegatorView.getGrupoReferencia(idGrre);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtActivo.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdGrpo_Grupo.setDisabled(false);
			txtIdRefe_Referencia.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaInactivo.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdGrre.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtActivo.setValue(entity.getActivo());
			txtActivo.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaInactivo.setValue(entity.getFechaInactivo());
			txtFechaInactivo.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdGrpo_Grupo.setValue(entity.getGrupo().getIdGrpo());
			txtIdGrpo_Grupo.setDisabled(false);
			txtIdRefe_Referencia.setValue(entity.getReferencia().getIdRefe());
			txtIdRefe_Referencia.setDisabled(false);
			txtIdGrre.setValue(entity.getIdGrre());
			txtIdGrre.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedGrupoReferencia = (GrupoReferenciaDTO) (evt.getComponent()
				.getAttributes().get("selectedGrupoReferencia"));
		txtActivo.setValue(selectedGrupoReferencia.getActivo());
		txtActivo.setDisabled(false);
		txtEstadoRegistro.setValue(selectedGrupoReferencia.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedGrupoReferencia.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaInactivo.setValue(selectedGrupoReferencia.getFechaInactivo());
		txtFechaInactivo.setDisabled(false);
		txtFechaModificacion.setValue(selectedGrupoReferencia
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedGrupoReferencia.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedGrupoReferencia.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdGrpo_Grupo.setValue(selectedGrupoReferencia.getIdGrpo_Grupo());
		txtIdGrpo_Grupo.setDisabled(false);
		txtIdRefe_Referencia.setValue(selectedGrupoReferencia
				.getIdRefe_Referencia());
		txtIdRefe_Referencia.setDisabled(false);
		txtIdGrre.setValue(selectedGrupoReferencia.getIdGrre());
		txtIdGrre.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedGrupoReferencia == null) && (entity == null)) {
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
			entity = new GrupoReferencia();

			Long idGrre = new Long(txtIdGrre.getValue().toString());

			entity.setActivo(FacesUtils.checkString(txtActivo));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaInactivo(FacesUtils.checkDate(txtFechaInactivo));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdGrre(idGrre);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setGrupo(businessDelegatorView.getGrupo(FacesUtils
					.checkLong(txtIdGrpo_Grupo)));
			entity.setReferencia(businessDelegatorView.getReferencia(FacesUtils
					.checkLong(txtIdRefe_Referencia)));
			businessDelegatorView.saveGrupoReferencia(entity);
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
				Long idGrre = new Long(selectedGrupoReferencia.getIdGrre());
				entity = businessDelegatorView.getGrupoReferencia(idGrre);
			}

			entity.setActivo(FacesUtils.checkString(txtActivo));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaInactivo(FacesUtils.checkDate(txtFechaInactivo));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setGrupo(businessDelegatorView.getGrupo(FacesUtils
					.checkLong(txtIdGrpo_Grupo)));
			entity.setReferencia(businessDelegatorView.getReferencia(FacesUtils
					.checkLong(txtIdRefe_Referencia)));
			businessDelegatorView.updateGrupoReferencia(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedGrupoReferencia = (GrupoReferenciaDTO) (evt.getComponent()
					.getAttributes().get("selectedGrupoReferencia"));

			Long idGrre = new Long(selectedGrupoReferencia.getIdGrre());
			entity = businessDelegatorView.getGrupoReferencia(idGrre);
			businessDelegatorView.deleteGrupoReferencia(entity);
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
			selectedGrupoReferencia = (GrupoReferenciaDTO) (evt.getComponent()
					.getAttributes().get("selectedGrupoReferencia"));

			Long idGrre = new Long(selectedGrupoReferencia.getIdGrre());
			entity = businessDelegatorView.getGrupoReferencia(idGrre);
			businessDelegatorView.deleteGrupoReferencia(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedGrupoReferencia);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String activo, String estadoRegistro,
			Date fechaCreacion, Date fechaInactivo, Date fechaModificacion,
			Long idGrre, String operCreador, String operModifica,
			Long idGrpo_Grupo, Long idRefe_Referencia) throws Exception {
		try {
			entity.setActivo(FacesUtils.checkString(activo));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaInactivo(FacesUtils.checkDate(fechaInactivo));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateGrupoReferencia(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("GrupoReferenciaView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtActivo() {
		return txtActivo;
	}

	public void setTxtActivo(InputText txtActivo) {
		this.txtActivo = txtActivo;
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

	public InputText getTxtIdGrpo_Grupo() {
		return txtIdGrpo_Grupo;
	}

	public void setTxtIdGrpo_Grupo(InputText txtIdGrpo_Grupo) {
		this.txtIdGrpo_Grupo = txtIdGrpo_Grupo;
	}

	public InputText getTxtIdRefe_Referencia() {
		return txtIdRefe_Referencia;
	}

	public void setTxtIdRefe_Referencia(InputText txtIdRefe_Referencia) {
		this.txtIdRefe_Referencia = txtIdRefe_Referencia;
	}

	public Calendar getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaInactivo() {
		return txtFechaInactivo;
	}

	public void setTxtFechaInactivo(Calendar txtFechaInactivo) {
		this.txtFechaInactivo = txtFechaInactivo;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public InputText getTxtIdGrre() {
		return txtIdGrre;
	}

	public void setTxtIdGrre(InputText txtIdGrre) {
		this.txtIdGrre = txtIdGrre;
	}

	public List<GrupoReferenciaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataGrupoReferencia();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<GrupoReferenciaDTO> grupoReferenciaDTO) {
		this.data = grupoReferenciaDTO;
	}

	public GrupoReferenciaDTO getSelectedGrupoReferencia() {
		return selectedGrupoReferencia;
	}

	public void setSelectedGrupoReferencia(GrupoReferenciaDTO grupoReferencia) {
		this.selectedGrupoReferencia = grupoReferencia;
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

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
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

	public String getIdGrpo_Grupo() {
		return idGrpo_Grupo;
	}

	public void setIdGrpo_Grupo(String idGrpo_Grupo) {
		this.idGrpo_Grupo = idGrpo_Grupo;
	}

	public String getIdRefe_Referencia() {
		return idRefe_Referencia;
	}

	public void setIdRefe_Referencia(String idRefe_Referencia) {
		this.idRefe_Referencia = idRefe_Referencia;
	}

	public String getIdGrre() {
		return idGrre;
	}

	public void setIdGrre(String idGrre) {
		this.idGrre = idGrre;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getFechaInactivo() {
		return fechaInactivo;
	}

	public void setFechaInactivo(String fechaInactivo) {
		this.fechaInactivo = fechaInactivo;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

}
