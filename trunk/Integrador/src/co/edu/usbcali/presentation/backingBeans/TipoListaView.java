package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.TipoListaDTO;
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
public class TipoListaView {
	private InputText txtCodigo;
	private InputText txtDescripcion;
	private InputText txtEsCombinacion;
	private InputText txtEspacios;
	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdTisu_TipoSucursal;
	private InputText txtIdTili;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<TipoListaDTO> data;
	private TipoListaDTO selectedTipoLista;
	private TipoLista entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public TipoListaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			TipoListaDTO tipoListaDTO = (TipoListaDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(tipoListaDTO.getCodigo());

			if (txtDescripcion == null) {
				txtDescripcion = new InputText();
			}

			txtDescripcion.setValue(tipoListaDTO.getDescripcion());

			if (txtEsCombinacion == null) {
				txtEsCombinacion = new InputText();
			}

			txtEsCombinacion.setValue(tipoListaDTO.getEsCombinacion());

			if (txtEspacios == null) {
				txtEspacios = new InputText();
			}

			txtEspacios.setValue(tipoListaDTO.getEspacios());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(tipoListaDTO.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(tipoListaDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(tipoListaDTO.getOperModifica());

			if (txtIdTisu_TipoSucursal == null) {
				txtIdTisu_TipoSucursal = new InputText();
			}

			txtIdTisu_TipoSucursal.setValue(tipoListaDTO
					.getIdTisu_TipoSucursal());

			if (txtIdTili == null) {
				txtIdTili = new InputText();
			}

			txtIdTili.setValue(tipoListaDTO.getIdTili());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(tipoListaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(tipoListaDTO.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedTipoLista = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedTipoLista = null;

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(true);
		}

		if (txtDescripcion != null) {
			txtDescripcion.setValue(null);
			txtDescripcion.setDisabled(true);
		}

		if (txtEsCombinacion != null) {
			txtEsCombinacion.setValue(null);
			txtEsCombinacion.setDisabled(true);
		}

		if (txtEspacios != null) {
			txtEspacios.setValue(null);
			txtEspacios.setDisabled(true);
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

		if (txtIdTisu_TipoSucursal != null) {
			txtIdTisu_TipoSucursal.setValue(null);
			txtIdTisu_TipoSucursal.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdTili != null) {
			txtIdTili.setValue(null);
			txtIdTili.setDisabled(false);
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
			Long idTili = new Long(txtIdTili.getValue().toString());
			entity = businessDelegatorView.getTipoLista(idTili);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtDescripcion.setDisabled(false);
			txtEsCombinacion.setDisabled(false);
			txtEspacios.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdTisu_TipoSucursal.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdTili.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtDescripcion.setValue(entity.getDescripcion());
			txtDescripcion.setDisabled(false);
			txtEsCombinacion.setValue(entity.getEsCombinacion());
			txtEsCombinacion.setDisabled(false);
			txtEspacios.setValue(entity.getEspacios());
			txtEspacios.setDisabled(false);
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
			txtIdTisu_TipoSucursal.setValue(entity.getTipoSucursal()
					.getIdTisu());
			txtIdTisu_TipoSucursal.setDisabled(false);
			txtIdTili.setValue(entity.getIdTili());
			txtIdTili.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedTipoLista = (TipoListaDTO) (evt.getComponent().getAttributes()
				.get("selectedTipoLista"));
		txtCodigo.setValue(selectedTipoLista.getCodigo());
		txtCodigo.setDisabled(false);
		txtDescripcion.setValue(selectedTipoLista.getDescripcion());
		txtDescripcion.setDisabled(false);
		txtEsCombinacion.setValue(selectedTipoLista.getEsCombinacion());
		txtEsCombinacion.setDisabled(false);
		txtEspacios.setValue(selectedTipoLista.getEspacios());
		txtEspacios.setDisabled(false);
		txtEstadoRegistro.setValue(selectedTipoLista.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedTipoLista.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedTipoLista.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedTipoLista.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedTipoLista.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdTisu_TipoSucursal.setValue(selectedTipoLista
				.getIdTisu_TipoSucursal());
		txtIdTisu_TipoSucursal.setDisabled(false);
		txtIdTili.setValue(selectedTipoLista.getIdTili());
		txtIdTili.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedTipoLista == null) && (entity == null)) {
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
			entity = new TipoLista();

			Long idTili = new Long(txtIdTili.getValue().toString());

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			entity.setEsCombinacion(FacesUtils.checkLong(txtEsCombinacion));
			entity.setEspacios(FacesUtils.checkString(txtEspacios));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdTili(idTili);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setTipoSucursal(businessDelegatorView
					.getTipoSucursal(FacesUtils
							.checkLong(txtIdTisu_TipoSucursal)));
			businessDelegatorView.saveTipoLista(entity);
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
				Long idTili = new Long(selectedTipoLista.getIdTili());
				entity = businessDelegatorView.getTipoLista(idTili);
			}

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			entity.setEsCombinacion(FacesUtils.checkLong(txtEsCombinacion));
			entity.setEspacios(FacesUtils.checkString(txtEspacios));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setTipoSucursal(businessDelegatorView
					.getTipoSucursal(FacesUtils
							.checkLong(txtIdTisu_TipoSucursal)));
			businessDelegatorView.updateTipoLista(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedTipoLista = (TipoListaDTO) (evt.getComponent()
					.getAttributes().get("selectedTipoLista"));

			Long idTili = new Long(selectedTipoLista.getIdTili());
			entity = businessDelegatorView.getTipoLista(idTili);
			businessDelegatorView.deleteTipoLista(entity);
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
			selectedTipoLista = (TipoListaDTO) (evt.getComponent()
					.getAttributes().get("selectedTipoLista"));

			Long idTili = new Long(selectedTipoLista.getIdTili());
			entity = businessDelegatorView.getTipoLista(idTili);
			businessDelegatorView.deleteTipoLista(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedTipoLista);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, String descripcion,
			Long esCombinacion, String espacios, String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idTili,
			String operCreador, String operModifica, Long idTisu_TipoSucursal)
			throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setDescripcion(FacesUtils.checkString(descripcion));
			entity.setEsCombinacion(FacesUtils.checkLong(esCombinacion));
			entity.setEspacios(FacesUtils.checkString(espacios));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateTipoLista(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("TipoListaView").requestRender();
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

	public InputText getTxtEsCombinacion() {
		return txtEsCombinacion;
	}

	public void setTxtEsCombinacion(InputText txtEsCombinacion) {
		this.txtEsCombinacion = txtEsCombinacion;
	}

	public InputText getTxtEspacios() {
		return txtEspacios;
	}

	public void setTxtEspacios(InputText txtEspacios) {
		this.txtEspacios = txtEspacios;
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

	public InputText getTxtIdTisu_TipoSucursal() {
		return txtIdTisu_TipoSucursal;
	}

	public void setTxtIdTisu_TipoSucursal(InputText txtIdTisu_TipoSucursal) {
		this.txtIdTisu_TipoSucursal = txtIdTisu_TipoSucursal;
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

	public InputText getTxtIdTili() {
		return txtIdTili;
	}

	public void setTxtIdTili(InputText txtIdTili) {
		this.txtIdTili = txtIdTili;
	}

	public List<TipoListaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataTipoLista();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<TipoListaDTO> tipoListaDTO) {
		this.data = tipoListaDTO;
	}

	public TipoListaDTO getSelectedTipoLista() {
		return selectedTipoLista;
	}

	public void setSelectedTipoLista(TipoListaDTO tipoLista) {
		this.selectedTipoLista = tipoLista;
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
