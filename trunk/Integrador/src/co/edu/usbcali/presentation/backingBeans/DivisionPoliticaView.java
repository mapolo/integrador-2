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
import co.edu.usbcali.modelo.DivisionPolitica;
import co.edu.usbcali.modelo.dto.DivisionPoliticaDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class DivisionPoliticaView {
	private InputText txtCodigoDian;
	private InputText txtEstadoRegistro;
	private InputText txtNombre;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdDipo_DivisionPolitica;
	private InputText txtIdTidi_TipoDivision;
	private InputText txtIdDipo;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DivisionPoliticaDTO> data;
	private DivisionPoliticaDTO selectedDivisionPolitica;
	private DivisionPolitica entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public DivisionPoliticaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DivisionPoliticaDTO divisionPoliticaDTO = (DivisionPoliticaDTO) e
					.getObject();

			if (txtCodigoDian == null) {
				txtCodigoDian = new InputText();
			}

			txtCodigoDian.setValue(divisionPoliticaDTO.getCodigoDian());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(divisionPoliticaDTO.getEstadoRegistro());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(divisionPoliticaDTO.getNombre());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(divisionPoliticaDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(divisionPoliticaDTO.getOperModifica());

			if (txtIdDipo_DivisionPolitica == null) {
				txtIdDipo_DivisionPolitica = new InputText();
			}

			txtIdDipo_DivisionPolitica.setValue(divisionPoliticaDTO
					.getIdDipo_DivisionPolitica());

			if (txtIdTidi_TipoDivision == null) {
				txtIdTidi_TipoDivision = new InputText();
			}

			txtIdTidi_TipoDivision.setValue(divisionPoliticaDTO
					.getIdTidi_TipoDivision());

			if (txtIdDipo == null) {
				txtIdDipo = new InputText();
			}

			txtIdDipo.setValue(divisionPoliticaDTO.getIdDipo());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(divisionPoliticaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(divisionPoliticaDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedDivisionPolitica = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDivisionPolitica = null;

		if (txtCodigoDian != null) {
			txtCodigoDian.setValue(null);
			txtCodigoDian.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtIdDipo_DivisionPolitica != null) {
			txtIdDipo_DivisionPolitica.setValue(null);
			txtIdDipo_DivisionPolitica.setDisabled(true);
		}

		if (txtIdTidi_TipoDivision != null) {
			txtIdTidi_TipoDivision.setValue(null);
			txtIdTidi_TipoDivision.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdDipo != null) {
			txtIdDipo.setValue(null);
			txtIdDipo.setDisabled(false);
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
			Long idDipo = new Long(txtIdDipo.getValue().toString());
			entity = businessDelegatorView.getDivisionPolitica(idDipo);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtCodigoDian.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtNombre.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdDipo_DivisionPolitica.setDisabled(false);
			txtIdTidi_TipoDivision.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdDipo.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigoDian.setValue(entity.getCodigoDian());
			txtCodigoDian.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdDipo_DivisionPolitica.setValue(entity.getDivisionPolitica()
					.getIdDipo());
			txtIdDipo_DivisionPolitica.setDisabled(false);
			txtIdTidi_TipoDivision.setValue(entity.getTipoDivision()
					.getIdTidi());
			txtIdTidi_TipoDivision.setDisabled(false);
			txtIdDipo.setValue(entity.getIdDipo());
			txtIdDipo.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedDivisionPolitica = (DivisionPoliticaDTO) (evt.getComponent()
				.getAttributes().get("selectedDivisionPolitica"));
		txtCodigoDian.setValue(selectedDivisionPolitica.getCodigoDian());
		txtCodigoDian.setDisabled(false);
		txtEstadoRegistro
				.setValue(selectedDivisionPolitica.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedDivisionPolitica.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedDivisionPolitica
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtNombre.setValue(selectedDivisionPolitica.getNombre());
		txtNombre.setDisabled(false);
		txtOperCreador.setValue(selectedDivisionPolitica.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedDivisionPolitica.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdDipo_DivisionPolitica.setValue(selectedDivisionPolitica
				.getIdDipo_DivisionPolitica());
		txtIdDipo_DivisionPolitica.setDisabled(false);
		txtIdTidi_TipoDivision.setValue(selectedDivisionPolitica
				.getIdTidi_TipoDivision());
		txtIdTidi_TipoDivision.setDisabled(false);
		txtIdDipo.setValue(selectedDivisionPolitica.getIdDipo());
		txtIdDipo.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedDivisionPolitica == null) && (entity == null)) {
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
			entity = new DivisionPolitica();

			Long idDipo = new Long(txtIdDipo.getValue().toString());

			entity.setCodigoDian(FacesUtils.checkString(txtCodigoDian));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdDipo(idDipo);
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setDivisionPolitica(businessDelegatorView
					.getDivisionPolitica(FacesUtils
							.checkLong(txtIdDipo_DivisionPolitica)));
			entity.setTipoDivision(businessDelegatorView
					.getTipoDivision(FacesUtils
							.checkLong(txtIdTidi_TipoDivision)));
			businessDelegatorView.saveDivisionPolitica(entity);
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
				Long idDipo = new Long(selectedDivisionPolitica.getIdDipo());
				entity = businessDelegatorView.getDivisionPolitica(idDipo);
			}

			entity.setCodigoDian(FacesUtils.checkString(txtCodigoDian));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setDivisionPolitica(businessDelegatorView
					.getDivisionPolitica(FacesUtils
							.checkLong(txtIdDipo_DivisionPolitica)));
			entity.setTipoDivision(businessDelegatorView
					.getTipoDivision(FacesUtils
							.checkLong(txtIdTidi_TipoDivision)));
			businessDelegatorView.updateDivisionPolitica(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedDivisionPolitica = (DivisionPoliticaDTO) (evt
					.getComponent().getAttributes()
					.get("selectedDivisionPolitica"));

			Long idDipo = new Long(selectedDivisionPolitica.getIdDipo());
			entity = businessDelegatorView.getDivisionPolitica(idDipo);
			businessDelegatorView.deleteDivisionPolitica(entity);
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
			selectedDivisionPolitica = (DivisionPoliticaDTO) (evt
					.getComponent().getAttributes()
					.get("selectedDivisionPolitica"));

			Long idDipo = new Long(selectedDivisionPolitica.getIdDipo());
			entity = businessDelegatorView.getDivisionPolitica(idDipo);
			businessDelegatorView.deleteDivisionPolitica(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedDivisionPolitica);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigoDian, String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idDipo,
			String nombre, String operCreador, String operModifica,
			Long idDipo_DivisionPolitica, Long idTidi_TipoDivision)
			throws Exception {
		try {
			entity.setCodigoDian(FacesUtils.checkString(codigoDian));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateDivisionPolitica(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DivisionPoliticaView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCodigoDian() {
		return txtCodigoDian;
	}

	public void setTxtCodigoDian(InputText txtCodigoDian) {
		this.txtCodigoDian = txtCodigoDian;
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
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

	public InputText getTxtIdDipo_DivisionPolitica() {
		return txtIdDipo_DivisionPolitica;
	}

	public void setTxtIdDipo_DivisionPolitica(
			InputText txtIdDipo_DivisionPolitica) {
		this.txtIdDipo_DivisionPolitica = txtIdDipo_DivisionPolitica;
	}

	public InputText getTxtIdTidi_TipoDivision() {
		return txtIdTidi_TipoDivision;
	}

	public void setTxtIdTidi_TipoDivision(InputText txtIdTidi_TipoDivision) {
		this.txtIdTidi_TipoDivision = txtIdTidi_TipoDivision;
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

	public InputText getTxtIdDipo() {
		return txtIdDipo;
	}

	public void setTxtIdDipo(InputText txtIdDipo) {
		this.txtIdDipo = txtIdDipo;
	}

	public List<DivisionPoliticaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDivisionPolitica();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DivisionPoliticaDTO> divisionPoliticaDTO) {
		this.data = divisionPoliticaDTO;
	}

	public DivisionPoliticaDTO getSelectedDivisionPolitica() {
		return selectedDivisionPolitica;
	}

	public void setSelectedDivisionPolitica(DivisionPoliticaDTO divisionPolitica) {
		this.selectedDivisionPolitica = divisionPolitica;
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
