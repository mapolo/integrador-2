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
import co.edu.usbcali.modelo.SolicitudCampo;
import co.edu.usbcali.modelo.dto.SolicitudCampoDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class SolicitudCampoView {
	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtValorCadena;
	private InputText txtValorNumerico;
	private InputText txtIdCapa_CamposParametrizables;
	private InputText txtIdSocb_SolicitudCambio;
	private InputText txtIdSoca;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<SolicitudCampoDTO> data;
	private SolicitudCampoDTO selectedSolicitudCampo;
	private SolicitudCampo entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public SolicitudCampoView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			SolicitudCampoDTO solicitudCampoDTO = (SolicitudCampoDTO) e
					.getObject();

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(solicitudCampoDTO.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(solicitudCampoDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(solicitudCampoDTO.getOperModifica());

			if (txtValorCadena == null) {
				txtValorCadena = new InputText();
			}

			txtValorCadena.setValue(solicitudCampoDTO.getValorCadena());

			if (txtValorNumerico == null) {
				txtValorNumerico = new InputText();
			}

			txtValorNumerico.setValue(solicitudCampoDTO.getValorNumerico());

			if (txtIdCapa_CamposParametrizables == null) {
				txtIdCapa_CamposParametrizables = new InputText();
			}

			txtIdCapa_CamposParametrizables.setValue(solicitudCampoDTO
					.getIdCapa_CamposParametrizables());

			if (txtIdSocb_SolicitudCambio == null) {
				txtIdSocb_SolicitudCambio = new InputText();
			}

			txtIdSocb_SolicitudCambio.setValue(solicitudCampoDTO
					.getIdSocb_SolicitudCambio());

			if (txtIdSoca == null) {
				txtIdSoca = new InputText();
			}

			txtIdSoca.setValue(solicitudCampoDTO.getIdSoca());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(solicitudCampoDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(solicitudCampoDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedSolicitudCampo = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedSolicitudCampo = null;

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

		if (txtValorCadena != null) {
			txtValorCadena.setValue(null);
			txtValorCadena.setDisabled(true);
		}

		if (txtValorNumerico != null) {
			txtValorNumerico.setValue(null);
			txtValorNumerico.setDisabled(true);
		}

		if (txtIdCapa_CamposParametrizables != null) {
			txtIdCapa_CamposParametrizables.setValue(null);
			txtIdCapa_CamposParametrizables.setDisabled(true);
		}

		if (txtIdSocb_SolicitudCambio != null) {
			txtIdSocb_SolicitudCambio.setValue(null);
			txtIdSocb_SolicitudCambio.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdSoca != null) {
			txtIdSoca.setValue(null);
			txtIdSoca.setDisabled(false);
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
			Long idSoca = new Long(txtIdSoca.getValue().toString());
			entity = businessDelegatorView.getSolicitudCampo(idSoca);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtValorCadena.setDisabled(false);
			txtValorNumerico.setDisabled(false);
			txtIdCapa_CamposParametrizables.setDisabled(false);
			txtIdSocb_SolicitudCambio.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdSoca.setDisabled(false);
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
			txtValorCadena.setValue(entity.getValorCadena());
			txtValorCadena.setDisabled(false);
			txtValorNumerico.setValue(entity.getValorNumerico());
			txtValorNumerico.setDisabled(false);
			txtIdCapa_CamposParametrizables.setValue(entity
					.getCamposParametrizables().getIdCapa());
			txtIdCapa_CamposParametrizables.setDisabled(false);
			txtIdSocb_SolicitudCambio.setValue(entity.getSolicitudCambio()
					.getIdSocb());
			txtIdSocb_SolicitudCambio.setDisabled(false);
			txtIdSoca.setValue(entity.getIdSoca());
			txtIdSoca.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedSolicitudCampo = (SolicitudCampoDTO) (evt.getComponent()
				.getAttributes().get("selectedSolicitudCampo"));
		txtEstadoRegistro.setValue(selectedSolicitudCampo.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedSolicitudCampo.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedSolicitudCampo
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedSolicitudCampo.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedSolicitudCampo.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtValorCadena.setValue(selectedSolicitudCampo.getValorCadena());
		txtValorCadena.setDisabled(false);
		txtValorNumerico.setValue(selectedSolicitudCampo.getValorNumerico());
		txtValorNumerico.setDisabled(false);
		txtIdCapa_CamposParametrizables.setValue(selectedSolicitudCampo
				.getIdCapa_CamposParametrizables());
		txtIdCapa_CamposParametrizables.setDisabled(false);
		txtIdSocb_SolicitudCambio.setValue(selectedSolicitudCampo
				.getIdSocb_SolicitudCambio());
		txtIdSocb_SolicitudCambio.setDisabled(false);
		txtIdSoca.setValue(selectedSolicitudCampo.getIdSoca());
		txtIdSoca.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedSolicitudCampo == null) && (entity == null)) {
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
			entity = new SolicitudCampo();

			Long idSoca = new Long(txtIdSoca.getValue().toString());

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdSoca(idSoca);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setValorCadena(FacesUtils.checkString(txtValorCadena));
			entity.setValorNumerico(FacesUtils.checkLong(txtValorNumerico));
			entity.setCamposParametrizables(businessDelegatorView
					.getCamposParametrizables(FacesUtils
							.checkLong(txtIdCapa_CamposParametrizables)));
			entity.setSolicitudCambio(businessDelegatorView
					.getSolicitudCambio(FacesUtils
							.checkLong(txtIdSocb_SolicitudCambio)));
			businessDelegatorView.saveSolicitudCampo(entity);
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
				Long idSoca = new Long(selectedSolicitudCampo.getIdSoca());
				entity = businessDelegatorView.getSolicitudCampo(idSoca);
			}

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setValorCadena(FacesUtils.checkString(txtValorCadena));
			entity.setValorNumerico(FacesUtils.checkLong(txtValorNumerico));
			entity.setCamposParametrizables(businessDelegatorView
					.getCamposParametrizables(FacesUtils
							.checkLong(txtIdCapa_CamposParametrizables)));
			entity.setSolicitudCambio(businessDelegatorView
					.getSolicitudCambio(FacesUtils
							.checkLong(txtIdSocb_SolicitudCambio)));
			businessDelegatorView.updateSolicitudCampo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedSolicitudCampo = (SolicitudCampoDTO) (evt.getComponent()
					.getAttributes().get("selectedSolicitudCampo"));

			Long idSoca = new Long(selectedSolicitudCampo.getIdSoca());
			entity = businessDelegatorView.getSolicitudCampo(idSoca);
			businessDelegatorView.deleteSolicitudCampo(entity);
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
			selectedSolicitudCampo = (SolicitudCampoDTO) (evt.getComponent()
					.getAttributes().get("selectedSolicitudCampo"));

			Long idSoca = new Long(selectedSolicitudCampo.getIdSoca());
			entity = businessDelegatorView.getSolicitudCampo(idSoca);
			businessDelegatorView.deleteSolicitudCampo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedSolicitudCampo);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idSoca,
			String operCreador, String operModifica, String valorCadena,
			Long valorNumerico, Long idCapa_CamposParametrizables,
			Long idSocb_SolicitudCambio) throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setValorCadena(FacesUtils.checkString(valorCadena));
			entity.setValorNumerico(FacesUtils.checkLong(valorNumerico));
			businessDelegatorView.updateSolicitudCampo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("SolicitudCampoView").requestRender();
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

	public InputText getTxtValorCadena() {
		return txtValorCadena;
	}

	public void setTxtValorCadena(InputText txtValorCadena) {
		this.txtValorCadena = txtValorCadena;
	}

	public InputText getTxtValorNumerico() {
		return txtValorNumerico;
	}

	public void setTxtValorNumerico(InputText txtValorNumerico) {
		this.txtValorNumerico = txtValorNumerico;
	}

	public InputText getTxtIdCapa_CamposParametrizables() {
		return txtIdCapa_CamposParametrizables;
	}

	public void setTxtIdCapa_CamposParametrizables(
			InputText txtIdCapa_CamposParametrizables) {
		this.txtIdCapa_CamposParametrizables = txtIdCapa_CamposParametrizables;
	}

	public InputText getTxtIdSocb_SolicitudCambio() {
		return txtIdSocb_SolicitudCambio;
	}

	public void setTxtIdSocb_SolicitudCambio(InputText txtIdSocb_SolicitudCambio) {
		this.txtIdSocb_SolicitudCambio = txtIdSocb_SolicitudCambio;
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

	public InputText getTxtIdSoca() {
		return txtIdSoca;
	}

	public void setTxtIdSoca(InputText txtIdSoca) {
		this.txtIdSoca = txtIdSoca;
	}

	public List<SolicitudCampoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataSolicitudCampo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<SolicitudCampoDTO> solicitudCampoDTO) {
		this.data = solicitudCampoDTO;
	}

	public SolicitudCampoDTO getSelectedSolicitudCampo() {
		return selectedSolicitudCampo;
	}

	public void setSelectedSolicitudCampo(SolicitudCampoDTO solicitudCampo) {
		this.selectedSolicitudCampo = solicitudCampo;
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
