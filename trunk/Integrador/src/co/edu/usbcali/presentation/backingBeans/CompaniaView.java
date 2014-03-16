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
import co.edu.usbcali.modelo.Compania;
import co.edu.usbcali.modelo.dto.CompaniaDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class CompaniaView {
	private InputText txtCodigo;
	private InputText txtEstadoCompania;
	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdEmpr_Empresa;
	private InputText txtIdCia;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<CompaniaDTO> data;
	private CompaniaDTO selectedCompania;
	private Compania entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public CompaniaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			CompaniaDTO companiaDTO = (CompaniaDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(companiaDTO.getCodigo());

			if (txtEstadoCompania == null) {
				txtEstadoCompania = new InputText();
			}

			txtEstadoCompania.setValue(companiaDTO.getEstadoCompania());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(companiaDTO.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(companiaDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(companiaDTO.getOperModifica());

			if (txtIdEmpr_Empresa == null) {
				txtIdEmpr_Empresa = new InputText();
			}

			txtIdEmpr_Empresa.setValue(companiaDTO.getIdEmpr_Empresa());

			if (txtIdCia == null) {
				txtIdCia = new InputText();
			}

			txtIdCia.setValue(companiaDTO.getIdCia());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(companiaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(companiaDTO.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedCompania = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedCompania = null;

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(true);
		}

		if (txtEstadoCompania != null) {
			txtEstadoCompania.setValue(null);
			txtEstadoCompania.setDisabled(true);
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

		if (txtIdEmpr_Empresa != null) {
			txtIdEmpr_Empresa.setValue(null);
			txtIdEmpr_Empresa.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdCia != null) {
			txtIdCia.setValue(null);
			txtIdCia.setDisabled(false);
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
			Long idCia = new Long(txtIdCia.getValue().toString());
			entity = businessDelegatorView.getCompania(idCia);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtEstadoCompania.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdEmpr_Empresa.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdCia.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtEstadoCompania.setValue(entity.getEstadoCompania());
			txtEstadoCompania.setDisabled(false);
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
			txtIdEmpr_Empresa.setValue(entity.getEmpresa().getIdEmpr());
			txtIdEmpr_Empresa.setDisabled(false);
			txtIdCia.setValue(entity.getIdCia());
			txtIdCia.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedCompania = (CompaniaDTO) (evt.getComponent().getAttributes()
				.get("selectedCompania"));
		txtCodigo.setValue(selectedCompania.getCodigo());
		txtCodigo.setDisabled(false);
		txtEstadoCompania.setValue(selectedCompania.getEstadoCompania());
		txtEstadoCompania.setDisabled(false);
		txtEstadoRegistro.setValue(selectedCompania.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedCompania.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedCompania.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedCompania.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedCompania.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdEmpr_Empresa.setValue(selectedCompania.getIdEmpr_Empresa());
		txtIdEmpr_Empresa.setDisabled(false);
		txtIdCia.setValue(selectedCompania.getIdCia());
		txtIdCia.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedCompania == null) && (entity == null)) {
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
			entity = new Compania();

			Long idCia = new Long(txtIdCia.getValue().toString());

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setEstadoCompania(FacesUtils.checkString(txtEstadoCompania));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdCia(idCia);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
					.checkLong(txtIdEmpr_Empresa)));
			businessDelegatorView.saveCompania(entity);
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
				Long idCia = new Long(selectedCompania.getIdCia());
				entity = businessDelegatorView.getCompania(idCia);
			}

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setEstadoCompania(FacesUtils.checkString(txtEstadoCompania));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
					.checkLong(txtIdEmpr_Empresa)));
			businessDelegatorView.updateCompania(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedCompania = (CompaniaDTO) (evt.getComponent()
					.getAttributes().get("selectedCompania"));

			Long idCia = new Long(selectedCompania.getIdCia());
			entity = businessDelegatorView.getCompania(idCia);
			businessDelegatorView.deleteCompania(entity);
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
			selectedCompania = (CompaniaDTO) (evt.getComponent()
					.getAttributes().get("selectedCompania"));

			Long idCia = new Long(selectedCompania.getIdCia());
			entity = businessDelegatorView.getCompania(idCia);
			businessDelegatorView.deleteCompania(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedCompania);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, String estadoCompania,
			String estadoRegistro, Date fechaCreacion, Date fechaModificacion,
			Long idCia, String operCreador, String operModifica,
			Long idEmpr_Empresa) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setEstadoCompania(FacesUtils.checkString(estadoCompania));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateCompania(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("CompaniaView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(InputText txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public InputText getTxtEstadoCompania() {
		return txtEstadoCompania;
	}

	public void setTxtEstadoCompania(InputText txtEstadoCompania) {
		this.txtEstadoCompania = txtEstadoCompania;
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

	public InputText getTxtIdEmpr_Empresa() {
		return txtIdEmpr_Empresa;
	}

	public void setTxtIdEmpr_Empresa(InputText txtIdEmpr_Empresa) {
		this.txtIdEmpr_Empresa = txtIdEmpr_Empresa;
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

	public InputText getTxtIdCia() {
		return txtIdCia;
	}

	public void setTxtIdCia(InputText txtIdCia) {
		this.txtIdCia = txtIdCia;
	}

	public List<CompaniaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataCompania();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<CompaniaDTO> companiaDTO) {
		this.data = companiaDTO;
	}

	public CompaniaDTO getSelectedCompania() {
		return selectedCompania;
	}

	public void setSelectedCompania(CompaniaDTO compania) {
		this.selectedCompania = compania;
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
