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
import co.edu.usbcali.modelo.SaldoInicialInventario;
import co.edu.usbcali.modelo.dto.SaldoInicialInventarioDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class SaldoInicialInventarioView {
	private InputText txtAno;
	private InputText txtCostoInicial;
	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtSaldoInicial;
	private InputText txtIdResu_ReferenciaSucursal;
	private InputText txtIdSini;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<SaldoInicialInventarioDTO> data;
	private SaldoInicialInventarioDTO selectedSaldoInicialInventario;
	private SaldoInicialInventario entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public SaldoInicialInventarioView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			SaldoInicialInventarioDTO saldoInicialInventarioDTO = (SaldoInicialInventarioDTO) e
					.getObject();

			if (txtAno == null) {
				txtAno = new InputText();
			}

			txtAno.setValue(saldoInicialInventarioDTO.getAno());

			if (txtCostoInicial == null) {
				txtCostoInicial = new InputText();
			}

			txtCostoInicial.setValue(saldoInicialInventarioDTO
					.getCostoInicial());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(saldoInicialInventarioDTO
					.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(saldoInicialInventarioDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(saldoInicialInventarioDTO
					.getOperModifica());

			if (txtSaldoInicial == null) {
				txtSaldoInicial = new InputText();
			}

			txtSaldoInicial.setValue(saldoInicialInventarioDTO
					.getSaldoInicial());

			if (txtIdResu_ReferenciaSucursal == null) {
				txtIdResu_ReferenciaSucursal = new InputText();
			}

			txtIdResu_ReferenciaSucursal.setValue(saldoInicialInventarioDTO
					.getIdResu_ReferenciaSucursal());

			if (txtIdSini == null) {
				txtIdSini = new InputText();
			}

			txtIdSini.setValue(saldoInicialInventarioDTO.getIdSini());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(saldoInicialInventarioDTO
					.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(saldoInicialInventarioDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedSaldoInicialInventario = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedSaldoInicialInventario = null;

		if (txtAno != null) {
			txtAno.setValue(null);
			txtAno.setDisabled(true);
		}

		if (txtCostoInicial != null) {
			txtCostoInicial.setValue(null);
			txtCostoInicial.setDisabled(true);
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

		if (txtSaldoInicial != null) {
			txtSaldoInicial.setValue(null);
			txtSaldoInicial.setDisabled(true);
		}

		if (txtIdResu_ReferenciaSucursal != null) {
			txtIdResu_ReferenciaSucursal.setValue(null);
			txtIdResu_ReferenciaSucursal.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdSini != null) {
			txtIdSini.setValue(null);
			txtIdSini.setDisabled(false);
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
			Long idSini = new Long(txtIdSini.getValue().toString());
			entity = businessDelegatorView.getSaldoInicialInventario(idSini);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtAno.setDisabled(false);
			txtCostoInicial.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtSaldoInicial.setDisabled(false);
			txtIdResu_ReferenciaSucursal.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdSini.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtAno.setValue(entity.getAno());
			txtAno.setDisabled(false);
			txtCostoInicial.setValue(entity.getCostoInicial());
			txtCostoInicial.setDisabled(false);
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
			txtSaldoInicial.setValue(entity.getSaldoInicial());
			txtSaldoInicial.setDisabled(false);
			txtIdResu_ReferenciaSucursal.setValue(entity
					.getReferenciaSucursal().getIdResu());
			txtIdResu_ReferenciaSucursal.setDisabled(false);
			txtIdSini.setValue(entity.getIdSini());
			txtIdSini.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedSaldoInicialInventario = (SaldoInicialInventarioDTO) (evt
				.getComponent().getAttributes()
				.get("selectedSaldoInicialInventario"));
		txtAno.setValue(selectedSaldoInicialInventario.getAno());
		txtAno.setDisabled(false);
		txtCostoInicial.setValue(selectedSaldoInicialInventario
				.getCostoInicial());
		txtCostoInicial.setDisabled(false);
		txtEstadoRegistro.setValue(selectedSaldoInicialInventario
				.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedSaldoInicialInventario
				.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedSaldoInicialInventario
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador
				.setValue(selectedSaldoInicialInventario.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedSaldoInicialInventario
				.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtSaldoInicial.setValue(selectedSaldoInicialInventario
				.getSaldoInicial());
		txtSaldoInicial.setDisabled(false);
		txtIdResu_ReferenciaSucursal.setValue(selectedSaldoInicialInventario
				.getIdResu_ReferenciaSucursal());
		txtIdResu_ReferenciaSucursal.setDisabled(false);
		txtIdSini.setValue(selectedSaldoInicialInventario.getIdSini());
		txtIdSini.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedSaldoInicialInventario == null) && (entity == null)) {
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
			entity = new SaldoInicialInventario();

			Long idSini = new Long(txtIdSini.getValue().toString());

			entity.setAno(FacesUtils.checkLong(txtAno));
			entity.setCostoInicial(FacesUtils.checkDouble(txtCostoInicial));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdSini(idSini);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setSaldoInicial(FacesUtils.checkDouble(txtSaldoInicial));
			entity.setReferenciaSucursal(businessDelegatorView
					.getReferenciaSucursal(FacesUtils
							.checkLong(txtIdResu_ReferenciaSucursal)));
			businessDelegatorView.saveSaldoInicialInventario(entity);
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
				Long idSini = new Long(
						selectedSaldoInicialInventario.getIdSini());
				entity = businessDelegatorView
						.getSaldoInicialInventario(idSini);
			}

			entity.setAno(FacesUtils.checkLong(txtAno));
			entity.setCostoInicial(FacesUtils.checkDouble(txtCostoInicial));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setSaldoInicial(FacesUtils.checkDouble(txtSaldoInicial));
			entity.setReferenciaSucursal(businessDelegatorView
					.getReferenciaSucursal(FacesUtils
							.checkLong(txtIdResu_ReferenciaSucursal)));
			businessDelegatorView.updateSaldoInicialInventario(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedSaldoInicialInventario = (SaldoInicialInventarioDTO) (evt
					.getComponent().getAttributes()
					.get("selectedSaldoInicialInventario"));

			Long idSini = new Long(selectedSaldoInicialInventario.getIdSini());
			entity = businessDelegatorView.getSaldoInicialInventario(idSini);
			businessDelegatorView.deleteSaldoInicialInventario(entity);
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
			selectedSaldoInicialInventario = (SaldoInicialInventarioDTO) (evt
					.getComponent().getAttributes()
					.get("selectedSaldoInicialInventario"));

			Long idSini = new Long(selectedSaldoInicialInventario.getIdSini());
			entity = businessDelegatorView.getSaldoInicialInventario(idSini);
			businessDelegatorView.deleteSaldoInicialInventario(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedSaldoInicialInventario);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long ano, Double costoInicial,
			String estadoRegistro, Date fechaCreacion, Date fechaModificacion,
			Long idSini, String operCreador, String operModifica,
			Double saldoInicial, Long idResu_ReferenciaSucursal)
			throws Exception {
		try {
			entity.setAno(FacesUtils.checkLong(ano));
			entity.setCostoInicial(FacesUtils.checkDouble(costoInicial));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setSaldoInicial(FacesUtils.checkDouble(saldoInicial));
			businessDelegatorView.updateSaldoInicialInventario(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("SaldoInicialInventarioView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtAno() {
		return txtAno;
	}

	public void setTxtAno(InputText txtAno) {
		this.txtAno = txtAno;
	}

	public InputText getTxtCostoInicial() {
		return txtCostoInicial;
	}

	public void setTxtCostoInicial(InputText txtCostoInicial) {
		this.txtCostoInicial = txtCostoInicial;
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

	public InputText getTxtSaldoInicial() {
		return txtSaldoInicial;
	}

	public void setTxtSaldoInicial(InputText txtSaldoInicial) {
		this.txtSaldoInicial = txtSaldoInicial;
	}

	public InputText getTxtIdResu_ReferenciaSucursal() {
		return txtIdResu_ReferenciaSucursal;
	}

	public void setTxtIdResu_ReferenciaSucursal(
			InputText txtIdResu_ReferenciaSucursal) {
		this.txtIdResu_ReferenciaSucursal = txtIdResu_ReferenciaSucursal;
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

	public InputText getTxtIdSini() {
		return txtIdSini;
	}

	public void setTxtIdSini(InputText txtIdSini) {
		this.txtIdSini = txtIdSini;
	}

	public List<SaldoInicialInventarioDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataSaldoInicialInventario();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(
			List<SaldoInicialInventarioDTO> saldoInicialInventarioDTO) {
		this.data = saldoInicialInventarioDTO;
	}

	public SaldoInicialInventarioDTO getSelectedSaldoInicialInventario() {
		return selectedSaldoInicialInventario;
	}

	public void setSelectedSaldoInicialInventario(
			SaldoInicialInventarioDTO saldoInicialInventario) {
		this.selectedSaldoInicialInventario = saldoInicialInventario;
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
