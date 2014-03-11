package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.RelacionComercialDTO;
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
public class RelacionComercialView {
	private InputText txtEstadoRegistro;
	private InputText txtLimiteCredito;
	private InputText txtLiquidaIva;
	private InputText txtObservacion;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdEmpr_Empresa;
	private InputText txtIdPers_Persona;
	private InputText txtIdSucu_Sucursal;
	private InputText txtIdReco;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<RelacionComercialDTO> data;
	private RelacionComercialDTO selectedRelacionComercial;
	private RelacionComercial entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public RelacionComercialView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			RelacionComercialDTO relacionComercialDTO = (RelacionComercialDTO) e
					.getObject();

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro
					.setValue(relacionComercialDTO.getEstadoRegistro());

			if (txtLimiteCredito == null) {
				txtLimiteCredito = new InputText();
			}

			txtLimiteCredito.setValue(relacionComercialDTO.getLimiteCredito());

			if (txtLiquidaIva == null) {
				txtLiquidaIva = new InputText();
			}

			txtLiquidaIva.setValue(relacionComercialDTO.getLiquidaIva());

			if (txtObservacion == null) {
				txtObservacion = new InputText();
			}

			txtObservacion.setValue(relacionComercialDTO.getObservacion());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(relacionComercialDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(relacionComercialDTO.getOperModifica());

			if (txtIdEmpr_Empresa == null) {
				txtIdEmpr_Empresa = new InputText();
			}

			txtIdEmpr_Empresa
					.setValue(relacionComercialDTO.getIdEmpr_Empresa());

			if (txtIdPers_Persona == null) {
				txtIdPers_Persona = new InputText();
			}

			txtIdPers_Persona
					.setValue(relacionComercialDTO.getIdPers_Persona());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new InputText();
			}

			if (txtIdReco == null) {
				txtIdReco = new InputText();
			}

			txtIdReco.setValue(relacionComercialDTO.getIdReco());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(relacionComercialDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(relacionComercialDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedRelacionComercial = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedRelacionComercial = null;

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtLimiteCredito != null) {
			txtLimiteCredito.setValue(null);
			txtLimiteCredito.setDisabled(true);
		}

		if (txtLiquidaIva != null) {
			txtLiquidaIva.setValue(null);
			txtLiquidaIva.setDisabled(true);
		}

		if (txtObservacion != null) {
			txtObservacion.setValue(null);
			txtObservacion.setDisabled(true);
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

		if (txtIdPers_Persona != null) {
			txtIdPers_Persona.setValue(null);
			txtIdPers_Persona.setDisabled(true);
		}

		if (txtIdSucu_Sucursal != null) {
			txtIdSucu_Sucursal.setValue(null);
			txtIdSucu_Sucursal.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdReco != null) {
			txtIdReco.setValue(null);
			txtIdReco.setDisabled(false);
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
			Long idReco = new Long(txtIdReco.getValue().toString());
			entity = businessDelegatorView.getRelacionComercial(idReco);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEstadoRegistro.setDisabled(false);
			txtLimiteCredito.setDisabled(false);
			txtLiquidaIva.setDisabled(false);
			txtObservacion.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdEmpr_Empresa.setDisabled(false);
			txtIdPers_Persona.setDisabled(false);
			txtIdSucu_Sucursal.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdReco.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtLimiteCredito.setValue(entity.getLimiteCredito());
			txtLimiteCredito.setDisabled(false);
			txtLiquidaIva.setValue(entity.getLiquidaIva());
			txtLiquidaIva.setDisabled(false);
			txtObservacion.setValue(entity.getObservacion());
			txtObservacion.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdEmpr_Empresa.setValue(entity.getEmpresa().getIdEmpr());
			txtIdEmpr_Empresa.setDisabled(false);
			txtIdPers_Persona.setValue(entity.getPersona().getIdPers());
			txtIdPers_Persona.setDisabled(false);

			txtIdSucu_Sucursal.setDisabled(false);
			txtIdReco.setValue(entity.getIdReco());
			txtIdReco.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedRelacionComercial = (RelacionComercialDTO) (evt.getComponent()
				.getAttributes().get("selectedRelacionComercial"));
		txtEstadoRegistro.setValue(selectedRelacionComercial
				.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedRelacionComercial.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedRelacionComercial
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtLimiteCredito.setValue(selectedRelacionComercial.getLimiteCredito());
		txtLimiteCredito.setDisabled(false);
		txtLiquidaIva.setValue(selectedRelacionComercial.getLiquidaIva());
		txtLiquidaIva.setDisabled(false);
		txtObservacion.setValue(selectedRelacionComercial.getObservacion());
		txtObservacion.setDisabled(false);
		txtOperCreador.setValue(selectedRelacionComercial.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedRelacionComercial.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdEmpr_Empresa.setValue(selectedRelacionComercial
				.getIdEmpr_Empresa());
		txtIdEmpr_Empresa.setDisabled(false);
		txtIdPers_Persona.setValue(selectedRelacionComercial
				.getIdPers_Persona());
		txtIdPers_Persona.setDisabled(false);

		txtIdSucu_Sucursal.setDisabled(false);
		txtIdReco.setValue(selectedRelacionComercial.getIdReco());
		txtIdReco.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedRelacionComercial == null) && (entity == null)) {
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
			entity = new RelacionComercial();

			Long idReco = new Long(txtIdReco.getValue().toString());

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdReco(idReco);
			entity.setLimiteCredito(FacesUtils.checkDouble(txtLimiteCredito));
			entity.setLiquidaIva(FacesUtils.checkString(txtLiquidaIva));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
					.checkLong(txtIdEmpr_Empresa)));
			entity.setPersona(businessDelegatorView.getPersona(FacesUtils
					.checkLong(txtIdPers_Persona)));

			businessDelegatorView.saveRelacionComercial(entity);
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
				Long idReco = new Long(selectedRelacionComercial.getIdReco());
				entity = businessDelegatorView.getRelacionComercial(idReco);
			}

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setLimiteCredito(FacesUtils.checkDouble(txtLimiteCredito));
			entity.setLiquidaIva(FacesUtils.checkString(txtLiquidaIva));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
					.checkLong(txtIdEmpr_Empresa)));
			entity.setPersona(businessDelegatorView.getPersona(FacesUtils
					.checkLong(txtIdPers_Persona)));

			businessDelegatorView.updateRelacionComercial(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedRelacionComercial = (RelacionComercialDTO) (evt
					.getComponent().getAttributes()
					.get("selectedRelacionComercial"));

			Long idReco = new Long(selectedRelacionComercial.getIdReco());
			entity = businessDelegatorView.getRelacionComercial(idReco);
			businessDelegatorView.deleteRelacionComercial(entity);
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
			selectedRelacionComercial = (RelacionComercialDTO) (evt
					.getComponent().getAttributes()
					.get("selectedRelacionComercial"));

			Long idReco = new Long(selectedRelacionComercial.getIdReco());
			entity = businessDelegatorView.getRelacionComercial(idReco);
			businessDelegatorView.deleteRelacionComercial(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedRelacionComercial);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idReco,
			Double limiteCredito, String liquidaIva, String observacion,
			String operCreador, String operModifica, Long idEmpr_Empresa,
			Long idPers_Persona, Long idSucu_Sucursal, Long idSucu_Sucursal0)
			throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setLimiteCredito(FacesUtils.checkDouble(limiteCredito));
			entity.setLiquidaIva(FacesUtils.checkString(liquidaIva));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateRelacionComercial(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("RelacionComercialView").requestRender();
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

	public InputText getTxtLimiteCredito() {
		return txtLimiteCredito;
	}

	public void setTxtLimiteCredito(InputText txtLimiteCredito) {
		this.txtLimiteCredito = txtLimiteCredito;
	}

	public InputText getTxtLiquidaIva() {
		return txtLiquidaIva;
	}

	public void setTxtLiquidaIva(InputText txtLiquidaIva) {
		this.txtLiquidaIva = txtLiquidaIva;
	}

	public InputText getTxtObservacion() {
		return txtObservacion;
	}

	public void setTxtObservacion(InputText txtObservacion) {
		this.txtObservacion = txtObservacion;
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

	public InputText getTxtIdPers_Persona() {
		return txtIdPers_Persona;
	}

	public void setTxtIdPers_Persona(InputText txtIdPers_Persona) {
		this.txtIdPers_Persona = txtIdPers_Persona;
	}

	public InputText getTxtIdSucu_Sucursal() {
		return txtIdSucu_Sucursal;
	}

	public void setTxtIdSucu_Sucursal(InputText txtIdSucu_Sucursal) {
		this.txtIdSucu_Sucursal = txtIdSucu_Sucursal;
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

	public InputText getTxtIdReco() {
		return txtIdReco;
	}

	public void setTxtIdReco(InputText txtIdReco) {
		this.txtIdReco = txtIdReco;
	}

	public List<RelacionComercialDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataRelacionComercial();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<RelacionComercialDTO> relacionComercialDTO) {
		this.data = relacionComercialDTO;
	}

	public RelacionComercialDTO getSelectedRelacionComercial() {
		return selectedRelacionComercial;
	}

	public void setSelectedRelacionComercial(
			RelacionComercialDTO relacionComercial) {
		this.selectedRelacionComercial = relacionComercial;
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
