package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.ConsecutivoDocumentoDTO;
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
public class ConsecutivoDocumentoView {
	private InputText txtCodigoTerminal;
	private InputText txtConsecutivoActual;
	private InputText txtConsecutivoFinal;
	private InputText txtConsecutivoInicial;
	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdSucu_Sucursal;
	private InputText txtIdTido_TipoDocumento;
	private InputText txtIdVend_Vendedor;
	private InputText txtIdCodo;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ConsecutivoDocumentoDTO> data;
	private ConsecutivoDocumentoDTO selectedConsecutivoDocumento;
	private ConsecutivoDocumento entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ConsecutivoDocumentoView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ConsecutivoDocumentoDTO consecutivoDocumentoDTO = (ConsecutivoDocumentoDTO) e
					.getObject();

			if (txtCodigoTerminal == null) {
				txtCodigoTerminal = new InputText();
			}

			txtCodigoTerminal.setValue(consecutivoDocumentoDTO
					.getCodigoTerminal());

			if (txtConsecutivoActual == null) {
				txtConsecutivoActual = new InputText();
			}

			txtConsecutivoActual.setValue(consecutivoDocumentoDTO
					.getConsecutivoActual());

			if (txtConsecutivoFinal == null) {
				txtConsecutivoFinal = new InputText();
			}

			txtConsecutivoFinal.setValue(consecutivoDocumentoDTO
					.getConsecutivoFinal());

			if (txtConsecutivoInicial == null) {
				txtConsecutivoInicial = new InputText();
			}

			txtConsecutivoInicial.setValue(consecutivoDocumentoDTO
					.getConsecutivoInicial());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(consecutivoDocumentoDTO
					.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(consecutivoDocumentoDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(consecutivoDocumentoDTO.getOperModifica());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new InputText();
			}

			txtIdSucu_Sucursal.setValue(consecutivoDocumentoDTO
					.getIdSucu_Sucursal());

			if (txtIdTido_TipoDocumento == null) {
				txtIdTido_TipoDocumento = new InputText();
			}

			txtIdTido_TipoDocumento.setValue(consecutivoDocumentoDTO
					.getIdTido_TipoDocumento());

			if (txtIdVend_Vendedor == null) {
				txtIdVend_Vendedor = new InputText();
			}

			txtIdVend_Vendedor.setValue(consecutivoDocumentoDTO
					.getIdVend_Vendedor());

			if (txtIdCodo == null) {
				txtIdCodo = new InputText();
			}

			txtIdCodo.setValue(consecutivoDocumentoDTO.getIdCodo());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(consecutivoDocumentoDTO
					.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(consecutivoDocumentoDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedConsecutivoDocumento = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedConsecutivoDocumento = null;

		if (txtCodigoTerminal != null) {
			txtCodigoTerminal.setValue(null);
			txtCodigoTerminal.setDisabled(true);
		}

		if (txtConsecutivoActual != null) {
			txtConsecutivoActual.setValue(null);
			txtConsecutivoActual.setDisabled(true);
		}

		if (txtConsecutivoFinal != null) {
			txtConsecutivoFinal.setValue(null);
			txtConsecutivoFinal.setDisabled(true);
		}

		if (txtConsecutivoInicial != null) {
			txtConsecutivoInicial.setValue(null);
			txtConsecutivoInicial.setDisabled(true);
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

		if (txtIdSucu_Sucursal != null) {
			txtIdSucu_Sucursal.setValue(null);
			txtIdSucu_Sucursal.setDisabled(true);
		}

		if (txtIdTido_TipoDocumento != null) {
			txtIdTido_TipoDocumento.setValue(null);
			txtIdTido_TipoDocumento.setDisabled(true);
		}

		if (txtIdVend_Vendedor != null) {
			txtIdVend_Vendedor.setValue(null);
			txtIdVend_Vendedor.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdCodo != null) {
			txtIdCodo.setValue(null);
			txtIdCodo.setDisabled(false);
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
			Long idCodo = new Long(txtIdCodo.getValue().toString());
			entity = businessDelegatorView.getConsecutivoDocumento(idCodo);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtCodigoTerminal.setDisabled(false);
			txtConsecutivoActual.setDisabled(false);
			txtConsecutivoFinal.setDisabled(false);
			txtConsecutivoInicial.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdTido_TipoDocumento.setDisabled(false);
			txtIdVend_Vendedor.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdCodo.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigoTerminal.setValue(entity.getCodigoTerminal());
			txtCodigoTerminal.setDisabled(false);
			txtConsecutivoActual.setValue(entity.getConsecutivoActual());
			txtConsecutivoActual.setDisabled(false);
			txtConsecutivoFinal.setValue(entity.getConsecutivoFinal());
			txtConsecutivoFinal.setDisabled(false);
			txtConsecutivoInicial.setValue(entity.getConsecutivoInicial());
			txtConsecutivoInicial.setDisabled(false);
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
			txtIdSucu_Sucursal.setValue(entity.getSucursal().getIdSucu());
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdTido_TipoDocumento.setValue(entity.getTipoDocumento()
					.getIdTido());
			txtIdTido_TipoDocumento.setDisabled(false);
			txtIdVend_Vendedor.setValue(entity.getVendedor().getIdVend());
			txtIdVend_Vendedor.setDisabled(false);
			txtIdCodo.setValue(entity.getIdCodo());
			txtIdCodo.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedConsecutivoDocumento = (ConsecutivoDocumentoDTO) (evt
				.getComponent().getAttributes()
				.get("selectedConsecutivoDocumento"));
		txtCodigoTerminal.setValue(selectedConsecutivoDocumento
				.getCodigoTerminal());
		txtCodigoTerminal.setDisabled(false);
		txtConsecutivoActual.setValue(selectedConsecutivoDocumento
				.getConsecutivoActual());
		txtConsecutivoActual.setDisabled(false);
		txtConsecutivoFinal.setValue(selectedConsecutivoDocumento
				.getConsecutivoFinal());
		txtConsecutivoFinal.setDisabled(false);
		txtConsecutivoInicial.setValue(selectedConsecutivoDocumento
				.getConsecutivoInicial());
		txtConsecutivoInicial.setDisabled(false);
		txtEstadoRegistro.setValue(selectedConsecutivoDocumento
				.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedConsecutivoDocumento
				.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedConsecutivoDocumento
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedConsecutivoDocumento.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica
				.setValue(selectedConsecutivoDocumento.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdSucu_Sucursal.setValue(selectedConsecutivoDocumento
				.getIdSucu_Sucursal());
		txtIdSucu_Sucursal.setDisabled(false);
		txtIdTido_TipoDocumento.setValue(selectedConsecutivoDocumento
				.getIdTido_TipoDocumento());
		txtIdTido_TipoDocumento.setDisabled(false);
		txtIdVend_Vendedor.setValue(selectedConsecutivoDocumento
				.getIdVend_Vendedor());
		txtIdVend_Vendedor.setDisabled(false);
		txtIdCodo.setValue(selectedConsecutivoDocumento.getIdCodo());
		txtIdCodo.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedConsecutivoDocumento == null) && (entity == null)) {
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
			entity = new ConsecutivoDocumento();

			Long idCodo = new Long(txtIdCodo.getValue().toString());

			entity.setCodigoTerminal(FacesUtils.checkString(txtCodigoTerminal));
			entity.setConsecutivoActual(FacesUtils
					.checkLong(txtConsecutivoActual));
			entity.setConsecutivoFinal(FacesUtils
					.checkLong(txtConsecutivoFinal));
			entity.setConsecutivoInicial(FacesUtils
					.checkLong(txtConsecutivoInicial));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdCodo(idCodo);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			entity.setTipoDocumento(businessDelegatorView
					.getTipoDocumento(FacesUtils
							.checkLong(txtIdTido_TipoDocumento)));
			entity.setVendedor(businessDelegatorView.getVendedor(FacesUtils
					.checkLong(txtIdVend_Vendedor)));
			businessDelegatorView.saveConsecutivoDocumento(entity);
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
				Long idCodo = new Long(selectedConsecutivoDocumento.getIdCodo());
				entity = businessDelegatorView.getConsecutivoDocumento(idCodo);
			}

			entity.setCodigoTerminal(FacesUtils.checkString(txtCodigoTerminal));
			entity.setConsecutivoActual(FacesUtils
					.checkLong(txtConsecutivoActual));
			entity.setConsecutivoFinal(FacesUtils
					.checkLong(txtConsecutivoFinal));
			entity.setConsecutivoInicial(FacesUtils
					.checkLong(txtConsecutivoInicial));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			entity.setTipoDocumento(businessDelegatorView
					.getTipoDocumento(FacesUtils
							.checkLong(txtIdTido_TipoDocumento)));
			entity.setVendedor(businessDelegatorView.getVendedor(FacesUtils
					.checkLong(txtIdVend_Vendedor)));
			businessDelegatorView.updateConsecutivoDocumento(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedConsecutivoDocumento = (ConsecutivoDocumentoDTO) (evt
					.getComponent().getAttributes()
					.get("selectedConsecutivoDocumento"));

			Long idCodo = new Long(selectedConsecutivoDocumento.getIdCodo());
			entity = businessDelegatorView.getConsecutivoDocumento(idCodo);
			businessDelegatorView.deleteConsecutivoDocumento(entity);
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
			selectedConsecutivoDocumento = (ConsecutivoDocumentoDTO) (evt
					.getComponent().getAttributes()
					.get("selectedConsecutivoDocumento"));

			Long idCodo = new Long(selectedConsecutivoDocumento.getIdCodo());
			entity = businessDelegatorView.getConsecutivoDocumento(idCodo);
			businessDelegatorView.deleteConsecutivoDocumento(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedConsecutivoDocumento);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigoTerminal,
			Long consecutivoActual, Long consecutivoFinal,
			Long consecutivoInicial, String estadoRegistro, Date fechaCreacion,
			Date fechaModificacion, Long idCodo, String operCreador,
			String operModifica, Long idSucu_Sucursal,
			Long idTido_TipoDocumento, Long idVend_Vendedor) throws Exception {
		try {
			entity.setCodigoTerminal(FacesUtils.checkString(codigoTerminal));
			entity.setConsecutivoActual(FacesUtils.checkLong(consecutivoActual));
			entity.setConsecutivoFinal(FacesUtils.checkLong(consecutivoFinal));
			entity.setConsecutivoInicial(FacesUtils
					.checkLong(consecutivoInicial));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateConsecutivoDocumento(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ConsecutivoDocumentoView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCodigoTerminal() {
		return txtCodigoTerminal;
	}

	public void setTxtCodigoTerminal(InputText txtCodigoTerminal) {
		this.txtCodigoTerminal = txtCodigoTerminal;
	}

	public InputText getTxtConsecutivoActual() {
		return txtConsecutivoActual;
	}

	public void setTxtConsecutivoActual(InputText txtConsecutivoActual) {
		this.txtConsecutivoActual = txtConsecutivoActual;
	}

	public InputText getTxtConsecutivoFinal() {
		return txtConsecutivoFinal;
	}

	public void setTxtConsecutivoFinal(InputText txtConsecutivoFinal) {
		this.txtConsecutivoFinal = txtConsecutivoFinal;
	}

	public InputText getTxtConsecutivoInicial() {
		return txtConsecutivoInicial;
	}

	public void setTxtConsecutivoInicial(InputText txtConsecutivoInicial) {
		this.txtConsecutivoInicial = txtConsecutivoInicial;
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

	public InputText getTxtIdSucu_Sucursal() {
		return txtIdSucu_Sucursal;
	}

	public void setTxtIdSucu_Sucursal(InputText txtIdSucu_Sucursal) {
		this.txtIdSucu_Sucursal = txtIdSucu_Sucursal;
	}

	public InputText getTxtIdTido_TipoDocumento() {
		return txtIdTido_TipoDocumento;
	}

	public void setTxtIdTido_TipoDocumento(InputText txtIdTido_TipoDocumento) {
		this.txtIdTido_TipoDocumento = txtIdTido_TipoDocumento;
	}

	public InputText getTxtIdVend_Vendedor() {
		return txtIdVend_Vendedor;
	}

	public void setTxtIdVend_Vendedor(InputText txtIdVend_Vendedor) {
		this.txtIdVend_Vendedor = txtIdVend_Vendedor;
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

	public InputText getTxtIdCodo() {
		return txtIdCodo;
	}

	public void setTxtIdCodo(InputText txtIdCodo) {
		this.txtIdCodo = txtIdCodo;
	}

	public List<ConsecutivoDocumentoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataConsecutivoDocumento();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ConsecutivoDocumentoDTO> consecutivoDocumentoDTO) {
		this.data = consecutivoDocumentoDTO;
	}

	public ConsecutivoDocumentoDTO getSelectedConsecutivoDocumento() {
		return selectedConsecutivoDocumento;
	}

	public void setSelectedConsecutivoDocumento(
			ConsecutivoDocumentoDTO consecutivoDocumento) {
		this.selectedConsecutivoDocumento = consecutivoDocumento;
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
