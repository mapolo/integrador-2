package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.LogisticaReversivaDTO;
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
public class LogisticaReversivaView {
	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdDocu_Documento;
	private InputText txtIdRrec_RutaRelacionComercial;
	private InputText txtIdLore;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaOrdenada;
	private Calendar txtFechaRecibida;
	private Calendar txtFechaSolicitud;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<LogisticaReversivaDTO> data;
	private LogisticaReversivaDTO selectedLogisticaReversiva;
	private LogisticaReversiva entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public LogisticaReversivaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			LogisticaReversivaDTO logisticaReversivaDTO = (LogisticaReversivaDTO) e
					.getObject();

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(logisticaReversivaDTO
					.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(logisticaReversivaDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(logisticaReversivaDTO.getOperModifica());

			if (txtIdDocu_Documento == null) {
				txtIdDocu_Documento = new InputText();
			}

			if (txtIdRrec_RutaRelacionComercial == null) {
				txtIdRrec_RutaRelacionComercial = new InputText();
			}

			txtIdRrec_RutaRelacionComercial.setValue(logisticaReversivaDTO
					.getIdRrec_RutaRelacionComercial());

			if (txtIdLore == null) {
				txtIdLore = new InputText();
			}

			txtIdLore.setValue(logisticaReversivaDTO.getIdLore());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(logisticaReversivaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(logisticaReversivaDTO
					.getFechaModificacion());

			if (txtFechaOrdenada == null) {
				txtFechaOrdenada = new Calendar();
			}

			txtFechaOrdenada.setValue(logisticaReversivaDTO.getFechaOrdenada());

			if (txtFechaRecibida == null) {
				txtFechaRecibida = new Calendar();
			}

			txtFechaRecibida.setValue(logisticaReversivaDTO.getFechaRecibida());

			if (txtFechaSolicitud == null) {
				txtFechaSolicitud = new Calendar();
			}

			txtFechaSolicitud.setValue(logisticaReversivaDTO
					.getFechaSolicitud());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedLogisticaReversiva = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedLogisticaReversiva = null;

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

		if (txtIdDocu_Documento != null) {
			txtIdDocu_Documento.setValue(null);
			txtIdDocu_Documento.setDisabled(true);
		}

		if (txtIdRrec_RutaRelacionComercial != null) {
			txtIdRrec_RutaRelacionComercial.setValue(null);
			txtIdRrec_RutaRelacionComercial.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtFechaOrdenada != null) {
			txtFechaOrdenada.setValue(null);
			txtFechaOrdenada.setDisabled(true);
		}

		if (txtFechaRecibida != null) {
			txtFechaRecibida.setValue(null);
			txtFechaRecibida.setDisabled(true);
		}

		if (txtFechaSolicitud != null) {
			txtFechaSolicitud.setValue(null);
			txtFechaSolicitud.setDisabled(true);
		}

		if (txtIdLore != null) {
			txtIdLore.setValue(null);
			txtIdLore.setDisabled(false);
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

	public void listener_txtFechaOrdenada() {
		Date inputDate = (Date) txtFechaOrdenada.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaRecibida() {
		Date inputDate = (Date) txtFechaRecibida.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaSolicitud() {
		Date inputDate = (Date) txtFechaSolicitud.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Long idLore = new Long(txtIdLore.getValue().toString());
			entity = businessDelegatorView.getLogisticaReversiva(idLore);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdDocu_Documento.setDisabled(false);
			txtIdRrec_RutaRelacionComercial.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtFechaOrdenada.setDisabled(false);
			txtFechaRecibida.setDisabled(false);
			txtFechaSolicitud.setDisabled(false);
			txtIdLore.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtFechaOrdenada.setValue(entity.getFechaOrdenada());
			txtFechaOrdenada.setDisabled(false);
			txtFechaRecibida.setValue(entity.getFechaRecibida());
			txtFechaRecibida.setDisabled(false);
			txtFechaSolicitud.setValue(entity.getFechaSolicitud());
			txtFechaSolicitud.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);

			txtIdDocu_Documento.setDisabled(false);
			txtIdRrec_RutaRelacionComercial.setValue(entity
					.getRutaRelacionComercial().getIdRrec());
			txtIdRrec_RutaRelacionComercial.setDisabled(false);
			txtIdLore.setValue(entity.getIdLore());
			txtIdLore.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedLogisticaReversiva = (LogisticaReversivaDTO) (evt
				.getComponent().getAttributes()
				.get("selectedLogisticaReversiva"));
		txtEstadoRegistro.setValue(selectedLogisticaReversiva
				.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion
				.setValue(selectedLogisticaReversiva.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedLogisticaReversiva
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtFechaOrdenada
				.setValue(selectedLogisticaReversiva.getFechaOrdenada());
		txtFechaOrdenada.setDisabled(false);
		txtFechaRecibida
				.setValue(selectedLogisticaReversiva.getFechaRecibida());
		txtFechaRecibida.setDisabled(false);
		txtFechaSolicitud.setValue(selectedLogisticaReversiva
				.getFechaSolicitud());
		txtFechaSolicitud.setDisabled(false);
		txtOperCreador.setValue(selectedLogisticaReversiva.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedLogisticaReversiva.getOperModifica());
		txtOperModifica.setDisabled(false);

		txtIdDocu_Documento.setDisabled(false);
		txtIdRrec_RutaRelacionComercial.setValue(selectedLogisticaReversiva
				.getIdRrec_RutaRelacionComercial());
		txtIdRrec_RutaRelacionComercial.setDisabled(false);
		txtIdLore.setValue(selectedLogisticaReversiva.getIdLore());
		txtIdLore.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedLogisticaReversiva == null) && (entity == null)) {
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
			entity = new LogisticaReversiva();

			Long idLore = new Long(txtIdLore.getValue().toString());

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaOrdenada(FacesUtils.checkDate(txtFechaOrdenada));
			entity.setFechaRecibida(FacesUtils.checkDate(txtFechaRecibida));
			entity.setFechaSolicitud(FacesUtils.checkDate(txtFechaSolicitud));
			entity.setIdLore(idLore);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));

			entity.setRutaRelacionComercial(businessDelegatorView
					.getRutaRelacionComercial(FacesUtils
							.checkLong(txtIdRrec_RutaRelacionComercial)));
			businessDelegatorView.saveLogisticaReversiva(entity);
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
				Long idLore = new Long(selectedLogisticaReversiva.getIdLore());
				entity = businessDelegatorView.getLogisticaReversiva(idLore);
			}

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaOrdenada(FacesUtils.checkDate(txtFechaOrdenada));
			entity.setFechaRecibida(FacesUtils.checkDate(txtFechaRecibida));
			entity.setFechaSolicitud(FacesUtils.checkDate(txtFechaSolicitud));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));

			entity.setRutaRelacionComercial(businessDelegatorView
					.getRutaRelacionComercial(FacesUtils
							.checkLong(txtIdRrec_RutaRelacionComercial)));
			businessDelegatorView.updateLogisticaReversiva(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedLogisticaReversiva = (LogisticaReversivaDTO) (evt
					.getComponent().getAttributes()
					.get("selectedLogisticaReversiva"));

			Long idLore = new Long(selectedLogisticaReversiva.getIdLore());
			entity = businessDelegatorView.getLogisticaReversiva(idLore);
			businessDelegatorView.deleteLogisticaReversiva(entity);
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
			selectedLogisticaReversiva = (LogisticaReversivaDTO) (evt
					.getComponent().getAttributes()
					.get("selectedLogisticaReversiva"));

			Long idLore = new Long(selectedLogisticaReversiva.getIdLore());
			entity = businessDelegatorView.getLogisticaReversiva(idLore);
			businessDelegatorView.deleteLogisticaReversiva(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedLogisticaReversiva);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Date fechaOrdenada,
			Date fechaRecibida, Date fechaSolicitud, Long idLore,
			String operCreador, String operModifica, Long idDocu_Documento,

			Long idRrec_RutaRelacionComercial) throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaOrdenada(FacesUtils.checkDate(fechaOrdenada));
			entity.setFechaRecibida(FacesUtils.checkDate(fechaRecibida));
			entity.setFechaSolicitud(FacesUtils.checkDate(fechaSolicitud));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateLogisticaReversiva(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("LogisticaReversivaView").requestRender();
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

	public InputText getTxtIdDocu_Documento() {
		return txtIdDocu_Documento;
	}

	public void setTxtIdDocu_Documento(InputText txtIdDocu_Documento) {
		this.txtIdDocu_Documento = txtIdDocu_Documento;
	}

	public InputText getTxtIdRrec_RutaRelacionComercial() {
		return txtIdRrec_RutaRelacionComercial;
	}

	public void setTxtIdRrec_RutaRelacionComercial(
			InputText txtIdRrec_RutaRelacionComercial) {
		this.txtIdRrec_RutaRelacionComercial = txtIdRrec_RutaRelacionComercial;
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

	public Calendar getTxtFechaOrdenada() {
		return txtFechaOrdenada;
	}

	public void setTxtFechaOrdenada(Calendar txtFechaOrdenada) {
		this.txtFechaOrdenada = txtFechaOrdenada;
	}

	public Calendar getTxtFechaRecibida() {
		return txtFechaRecibida;
	}

	public void setTxtFechaRecibida(Calendar txtFechaRecibida) {
		this.txtFechaRecibida = txtFechaRecibida;
	}

	public Calendar getTxtFechaSolicitud() {
		return txtFechaSolicitud;
	}

	public void setTxtFechaSolicitud(Calendar txtFechaSolicitud) {
		this.txtFechaSolicitud = txtFechaSolicitud;
	}

	public InputText getTxtIdLore() {
		return txtIdLore;
	}

	public void setTxtIdLore(InputText txtIdLore) {
		this.txtIdLore = txtIdLore;
	}

	public List<LogisticaReversivaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataLogisticaReversiva();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<LogisticaReversivaDTO> logisticaReversivaDTO) {
		this.data = logisticaReversivaDTO;
	}

	public LogisticaReversivaDTO getSelectedLogisticaReversiva() {
		return selectedLogisticaReversiva;
	}

	public void setSelectedLogisticaReversiva(
			LogisticaReversivaDTO logisticaReversiva) {
		this.selectedLogisticaReversiva = logisticaReversiva;
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
