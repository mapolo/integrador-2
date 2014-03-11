package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.FamiliaDTO;
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
public class FamiliaView {
	private InputText txtCodigo;
	private InputText txtDescripcion;
	private InputText txtEstadoRegistro;
	private InputText txtManejaGalones;
	private InputText txtManejaPesos;
	private InputText txtManejaUnidades;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdFlia;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<FamiliaDTO> data;
	private FamiliaDTO selectedFamilia;
	private Familia entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public FamiliaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			FamiliaDTO familiaDTO = (FamiliaDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(familiaDTO.getCodigo());

			if (txtDescripcion == null) {
				txtDescripcion = new InputText();
			}

			txtDescripcion.setValue(familiaDTO.getDescripcion());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(familiaDTO.getEstadoRegistro());

			if (txtManejaGalones == null) {
				txtManejaGalones = new InputText();
			}

			txtManejaGalones.setValue(familiaDTO.getManejaGalones());

			if (txtManejaPesos == null) {
				txtManejaPesos = new InputText();
			}

			txtManejaPesos.setValue(familiaDTO.getManejaPesos());

			if (txtManejaUnidades == null) {
				txtManejaUnidades = new InputText();
			}

			txtManejaUnidades.setValue(familiaDTO.getManejaUnidades());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(familiaDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(familiaDTO.getOperModifica());

			if (txtIdFlia == null) {
				txtIdFlia = new InputText();
			}

			txtIdFlia.setValue(familiaDTO.getIdFlia());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(familiaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(familiaDTO.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedFamilia = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedFamilia = null;

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(true);
		}

		if (txtDescripcion != null) {
			txtDescripcion.setValue(null);
			txtDescripcion.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtManejaGalones != null) {
			txtManejaGalones.setValue(null);
			txtManejaGalones.setDisabled(true);
		}

		if (txtManejaPesos != null) {
			txtManejaPesos.setValue(null);
			txtManejaPesos.setDisabled(true);
		}

		if (txtManejaUnidades != null) {
			txtManejaUnidades.setValue(null);
			txtManejaUnidades.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdFlia != null) {
			txtIdFlia.setValue(null);
			txtIdFlia.setDisabled(false);
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
			Long idFlia = new Long(txtIdFlia.getValue().toString());
			entity = businessDelegatorView.getFamilia(idFlia);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtDescripcion.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtManejaGalones.setDisabled(false);
			txtManejaPesos.setDisabled(false);
			txtManejaUnidades.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdFlia.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtDescripcion.setValue(entity.getDescripcion());
			txtDescripcion.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtManejaGalones.setValue(entity.getManejaGalones());
			txtManejaGalones.setDisabled(false);
			txtManejaPesos.setValue(entity.getManejaPesos());
			txtManejaPesos.setDisabled(false);
			txtManejaUnidades.setValue(entity.getManejaUnidades());
			txtManejaUnidades.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdFlia.setValue(entity.getIdFlia());
			txtIdFlia.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedFamilia = (FamiliaDTO) (evt.getComponent().getAttributes()
				.get("selectedFamilia"));
		txtCodigo.setValue(selectedFamilia.getCodigo());
		txtCodigo.setDisabled(false);
		txtDescripcion.setValue(selectedFamilia.getDescripcion());
		txtDescripcion.setDisabled(false);
		txtEstadoRegistro.setValue(selectedFamilia.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedFamilia.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedFamilia.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtManejaGalones.setValue(selectedFamilia.getManejaGalones());
		txtManejaGalones.setDisabled(false);
		txtManejaPesos.setValue(selectedFamilia.getManejaPesos());
		txtManejaPesos.setDisabled(false);
		txtManejaUnidades.setValue(selectedFamilia.getManejaUnidades());
		txtManejaUnidades.setDisabled(false);
		txtOperCreador.setValue(selectedFamilia.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedFamilia.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdFlia.setValue(selectedFamilia.getIdFlia());
		txtIdFlia.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedFamilia == null) && (entity == null)) {
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
			entity = new Familia();

			Long idFlia = new Long(txtIdFlia.getValue().toString());

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdFlia(idFlia);
			entity.setManejaGalones(FacesUtils.checkString(txtManejaGalones));
			entity.setManejaPesos(FacesUtils.checkString(txtManejaPesos));
			entity.setManejaUnidades(FacesUtils.checkString(txtManejaUnidades));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			businessDelegatorView.saveFamilia(entity);
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
				Long idFlia = new Long(selectedFamilia.getIdFlia());
				entity = businessDelegatorView.getFamilia(idFlia);
			}

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setManejaGalones(FacesUtils.checkString(txtManejaGalones));
			entity.setManejaPesos(FacesUtils.checkString(txtManejaPesos));
			entity.setManejaUnidades(FacesUtils.checkString(txtManejaUnidades));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			businessDelegatorView.updateFamilia(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedFamilia = (FamiliaDTO) (evt.getComponent().getAttributes()
					.get("selectedFamilia"));

			Long idFlia = new Long(selectedFamilia.getIdFlia());
			entity = businessDelegatorView.getFamilia(idFlia);
			businessDelegatorView.deleteFamilia(entity);
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
			selectedFamilia = (FamiliaDTO) (evt.getComponent().getAttributes()
					.get("selectedFamilia"));

			Long idFlia = new Long(selectedFamilia.getIdFlia());
			entity = businessDelegatorView.getFamilia(idFlia);
			businessDelegatorView.deleteFamilia(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedFamilia);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, String descripcion,
			String estadoRegistro, Date fechaCreacion, Date fechaModificacion,
			Long idFlia, String manejaGalones, String manejaPesos,
			String manejaUnidades, String operCreador, String operModifica)
			throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setDescripcion(FacesUtils.checkString(descripcion));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setManejaGalones(FacesUtils.checkString(manejaGalones));
			entity.setManejaPesos(FacesUtils.checkString(manejaPesos));
			entity.setManejaUnidades(FacesUtils.checkString(manejaUnidades));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateFamilia(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("FamiliaView").requestRender();
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

	public InputText getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(InputText txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}

	public InputText getTxtManejaGalones() {
		return txtManejaGalones;
	}

	public void setTxtManejaGalones(InputText txtManejaGalones) {
		this.txtManejaGalones = txtManejaGalones;
	}

	public InputText getTxtManejaPesos() {
		return txtManejaPesos;
	}

	public void setTxtManejaPesos(InputText txtManejaPesos) {
		this.txtManejaPesos = txtManejaPesos;
	}

	public InputText getTxtManejaUnidades() {
		return txtManejaUnidades;
	}

	public void setTxtManejaUnidades(InputText txtManejaUnidades) {
		this.txtManejaUnidades = txtManejaUnidades;
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

	public InputText getTxtIdFlia() {
		return txtIdFlia;
	}

	public void setTxtIdFlia(InputText txtIdFlia) {
		this.txtIdFlia = txtIdFlia;
	}

	public List<FamiliaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataFamilia();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<FamiliaDTO> familiaDTO) {
		this.data = familiaDTO;
	}

	public FamiliaDTO getSelectedFamilia() {
		return selectedFamilia;
	}

	public void setSelectedFamilia(FamiliaDTO familia) {
		this.selectedFamilia = familia;
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
