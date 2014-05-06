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
import co.edu.usbcali.modelo.PronosticoVenta;
import co.edu.usbcali.modelo.dto.PronosticoVentaDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class PronosticoVentaView {
	private InputText txtAno;
	private InputText txtCantidadAPedir;
	private InputText txtCantidadAntAPedir;
	private InputText txtCantidadPromedio;
	private InputText txtEstadoAutorizacion;
	private InputText txtEstadoRegistro;
	private InputText txtMes;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdRefe_Referencia;
	private InputText txtIdSucu_Sucursal;
	private InputText txtIdUnve_UnidadVenta;
	private InputText txtIdPtcv;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<PronosticoVentaDTO> data;
	private PronosticoVentaDTO selectedPronosticoVenta;
	private PronosticoVenta entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public PronosticoVentaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			PronosticoVentaDTO pronosticoVentaDTO = (PronosticoVentaDTO) e
					.getObject();

			if (txtAno == null) {
				txtAno = new InputText();
			}

			txtAno.setValue(pronosticoVentaDTO.getAno());

			if (txtCantidadAPedir == null) {
				txtCantidadAPedir = new InputText();
			}

			txtCantidadAPedir.setValue(pronosticoVentaDTO.getCantidadAPedir());

			if (txtCantidadAntAPedir == null) {
				txtCantidadAntAPedir = new InputText();
			}

			txtCantidadAntAPedir.setValue(pronosticoVentaDTO
					.getCantidadAntAPedir());

			if (txtCantidadPromedio == null) {
				txtCantidadPromedio = new InputText();
			}

			txtCantidadPromedio.setValue(pronosticoVentaDTO
					.getCantidadPromedio());

			if (txtEstadoAutorizacion == null) {
				txtEstadoAutorizacion = new InputText();
			}

			txtEstadoAutorizacion.setValue(pronosticoVentaDTO
					.getEstadoAutorizacion());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(pronosticoVentaDTO.getEstadoRegistro());

			if (txtMes == null) {
				txtMes = new InputText();
			}

			txtMes.setValue(pronosticoVentaDTO.getMes());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(pronosticoVentaDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(pronosticoVentaDTO.getOperModifica());

			if (txtIdRefe_Referencia == null) {
				txtIdRefe_Referencia = new InputText();
			}

			txtIdRefe_Referencia.setValue(pronosticoVentaDTO
					.getIdRefe_Referencia());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new InputText();
			}

			txtIdSucu_Sucursal
					.setValue(pronosticoVentaDTO.getIdSucu_Sucursal());

			if (txtIdUnve_UnidadVenta == null) {
				txtIdUnve_UnidadVenta = new InputText();
			}

			txtIdUnve_UnidadVenta.setValue(pronosticoVentaDTO
					.getIdUnve_UnidadVenta());

			if (txtIdPtcv == null) {
				txtIdPtcv = new InputText();
			}

			txtIdPtcv.setValue(pronosticoVentaDTO.getIdPtcv());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(pronosticoVentaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(pronosticoVentaDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedPronosticoVenta = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedPronosticoVenta = null;

		if (txtAno != null) {
			txtAno.setValue(null);
			txtAno.setDisabled(true);
		}

		if (txtCantidadAPedir != null) {
			txtCantidadAPedir.setValue(null);
			txtCantidadAPedir.setDisabled(true);
		}

		if (txtCantidadAntAPedir != null) {
			txtCantidadAntAPedir.setValue(null);
			txtCantidadAntAPedir.setDisabled(true);
		}

		if (txtCantidadPromedio != null) {
			txtCantidadPromedio.setValue(null);
			txtCantidadPromedio.setDisabled(true);
		}

		if (txtEstadoAutorizacion != null) {
			txtEstadoAutorizacion.setValue(null);
			txtEstadoAutorizacion.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtMes != null) {
			txtMes.setValue(null);
			txtMes.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtIdRefe_Referencia != null) {
			txtIdRefe_Referencia.setValue(null);
			txtIdRefe_Referencia.setDisabled(true);
		}

		if (txtIdSucu_Sucursal != null) {
			txtIdSucu_Sucursal.setValue(null);
			txtIdSucu_Sucursal.setDisabled(true);
		}

		if (txtIdUnve_UnidadVenta != null) {
			txtIdUnve_UnidadVenta.setValue(null);
			txtIdUnve_UnidadVenta.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdPtcv != null) {
			txtIdPtcv.setValue(null);
			txtIdPtcv.setDisabled(false);
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
			Long idPtcv = new Long(txtIdPtcv.getValue().toString());
			entity = businessDelegatorView.getPronosticoVenta(idPtcv);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtAno.setDisabled(false);
			txtCantidadAPedir.setDisabled(false);
			txtCantidadAntAPedir.setDisabled(false);
			txtCantidadPromedio.setDisabled(false);
			txtEstadoAutorizacion.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtMes.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdRefe_Referencia.setDisabled(false);
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdUnve_UnidadVenta.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdPtcv.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtAno.setValue(entity.getAno());
			txtAno.setDisabled(false);
			txtCantidadAPedir.setValue(entity.getCantidadAPedir());
			txtCantidadAPedir.setDisabled(false);
			txtCantidadAntAPedir.setValue(entity.getCantidadAntAPedir());
			txtCantidadAntAPedir.setDisabled(false);
			txtCantidadPromedio.setValue(entity.getCantidadPromedio());
			txtCantidadPromedio.setDisabled(false);
			txtEstadoAutorizacion.setValue(entity.getEstadoAutorizacion());
			txtEstadoAutorizacion.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtMes.setValue(entity.getMes());
			txtMes.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdRefe_Referencia.setValue(entity.getReferencia().getIdRefe());
			txtIdRefe_Referencia.setDisabled(false);
			txtIdSucu_Sucursal.setValue(entity.getSucursal().getIdSucu());
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdUnve_UnidadVenta.setValue(entity.getUnidadVenta().getIdUnve());
			txtIdUnve_UnidadVenta.setDisabled(false);
			txtIdPtcv.setValue(entity.getIdPtcv());
			txtIdPtcv.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedPronosticoVenta = (PronosticoVentaDTO) (evt.getComponent()
				.getAttributes().get("selectedPronosticoVenta"));
		txtAno.setValue(selectedPronosticoVenta.getAno());
		txtAno.setDisabled(false);
		txtCantidadAPedir.setValue(selectedPronosticoVenta.getCantidadAPedir());
		txtCantidadAPedir.setDisabled(false);
		txtCantidadAntAPedir.setValue(selectedPronosticoVenta
				.getCantidadAntAPedir());
		txtCantidadAntAPedir.setDisabled(false);
		txtCantidadPromedio.setValue(selectedPronosticoVenta
				.getCantidadPromedio());
		txtCantidadPromedio.setDisabled(false);
		txtEstadoAutorizacion.setValue(selectedPronosticoVenta
				.getEstadoAutorizacion());
		txtEstadoAutorizacion.setDisabled(false);
		txtEstadoRegistro.setValue(selectedPronosticoVenta.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedPronosticoVenta.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedPronosticoVenta
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtMes.setValue(selectedPronosticoVenta.getMes());
		txtMes.setDisabled(false);
		txtOperCreador.setValue(selectedPronosticoVenta.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedPronosticoVenta.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdRefe_Referencia.setValue(selectedPronosticoVenta
				.getIdRefe_Referencia());
		txtIdRefe_Referencia.setDisabled(false);
		txtIdSucu_Sucursal.setValue(selectedPronosticoVenta
				.getIdSucu_Sucursal());
		txtIdSucu_Sucursal.setDisabled(false);
		txtIdUnve_UnidadVenta.setValue(selectedPronosticoVenta
				.getIdUnve_UnidadVenta());
		txtIdUnve_UnidadVenta.setDisabled(false);
		txtIdPtcv.setValue(selectedPronosticoVenta.getIdPtcv());
		txtIdPtcv.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedPronosticoVenta == null) && (entity == null)) {
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
			entity = new PronosticoVenta();

			Long idPtcv = new Long(txtIdPtcv.getValue().toString());

			entity.setAno(FacesUtils.checkLong(txtAno));
			entity.setCantidadAPedir(FacesUtils.checkDouble(txtCantidadAPedir));
			entity.setCantidadAntAPedir(FacesUtils
					.checkDouble(txtCantidadAntAPedir));
			entity.setCantidadPromedio(FacesUtils
					.checkDouble(txtCantidadPromedio));
			entity.setEstadoAutorizacion(FacesUtils
					.checkString(txtEstadoAutorizacion));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdPtcv(idPtcv);
			entity.setMes(FacesUtils.checkLong(txtMes));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setReferencia(businessDelegatorView.getReferencia(FacesUtils
					.checkLong(txtIdRefe_Referencia)));
			entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			entity.setUnidadVenta(businessDelegatorView
					.getUnidadVenta(FacesUtils.checkLong(txtIdUnve_UnidadVenta)));
			businessDelegatorView.savePronosticoVenta(entity);
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
				Long idPtcv = new Long(selectedPronosticoVenta.getIdPtcv());
				entity = businessDelegatorView.getPronosticoVenta(idPtcv);
			}

			entity.setAno(FacesUtils.checkLong(txtAno));
			entity.setCantidadAPedir(FacesUtils.checkDouble(txtCantidadAPedir));
			entity.setCantidadAntAPedir(FacesUtils
					.checkDouble(txtCantidadAntAPedir));
			entity.setCantidadPromedio(FacesUtils
					.checkDouble(txtCantidadPromedio));
			entity.setEstadoAutorizacion(FacesUtils
					.checkString(txtEstadoAutorizacion));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setMes(FacesUtils.checkLong(txtMes));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setReferencia(businessDelegatorView.getReferencia(FacesUtils
					.checkLong(txtIdRefe_Referencia)));
			entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			entity.setUnidadVenta(businessDelegatorView
					.getUnidadVenta(FacesUtils.checkLong(txtIdUnve_UnidadVenta)));
			businessDelegatorView.updatePronosticoVenta(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedPronosticoVenta = (PronosticoVentaDTO) (evt.getComponent()
					.getAttributes().get("selectedPronosticoVenta"));

			Long idPtcv = new Long(selectedPronosticoVenta.getIdPtcv());
			entity = businessDelegatorView.getPronosticoVenta(idPtcv);
			businessDelegatorView.deletePronosticoVenta(entity);
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
			selectedPronosticoVenta = (PronosticoVentaDTO) (evt.getComponent()
					.getAttributes().get("selectedPronosticoVenta"));

			Long idPtcv = new Long(selectedPronosticoVenta.getIdPtcv());
			entity = businessDelegatorView.getPronosticoVenta(idPtcv);
			businessDelegatorView.deletePronosticoVenta(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedPronosticoVenta);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long ano, Double cantidadAPedir,
			Double cantidadAntAPedir, Double cantidadPromedio,
			String estadoAutorizacion, String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idPtcv, Long mes,
			String operCreador, String operModifica, Long idRefe_Referencia,
			Long idSucu_Sucursal, Long idUnve_UnidadVenta) throws Exception {
		try {
			entity.setAno(FacesUtils.checkLong(ano));
			entity.setCantidadAPedir(FacesUtils.checkDouble(cantidadAPedir));
			entity.setCantidadAntAPedir(FacesUtils
					.checkDouble(cantidadAntAPedir));
			entity.setCantidadPromedio(FacesUtils.checkDouble(cantidadPromedio));
			entity.setEstadoAutorizacion(FacesUtils
					.checkString(estadoAutorizacion));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setMes(FacesUtils.checkLong(mes));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updatePronosticoVenta(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("PronosticoVentaView").requestRender();
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

	public InputText getTxtCantidadAPedir() {
		return txtCantidadAPedir;
	}

	public void setTxtCantidadAPedir(InputText txtCantidadAPedir) {
		this.txtCantidadAPedir = txtCantidadAPedir;
	}

	public InputText getTxtCantidadAntAPedir() {
		return txtCantidadAntAPedir;
	}

	public void setTxtCantidadAntAPedir(InputText txtCantidadAntAPedir) {
		this.txtCantidadAntAPedir = txtCantidadAntAPedir;
	}

	public InputText getTxtCantidadPromedio() {
		return txtCantidadPromedio;
	}

	public void setTxtCantidadPromedio(InputText txtCantidadPromedio) {
		this.txtCantidadPromedio = txtCantidadPromedio;
	}

	public InputText getTxtEstadoAutorizacion() {
		return txtEstadoAutorizacion;
	}

	public void setTxtEstadoAutorizacion(InputText txtEstadoAutorizacion) {
		this.txtEstadoAutorizacion = txtEstadoAutorizacion;
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}

	public InputText getTxtMes() {
		return txtMes;
	}

	public void setTxtMes(InputText txtMes) {
		this.txtMes = txtMes;
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

	public InputText getTxtIdRefe_Referencia() {
		return txtIdRefe_Referencia;
	}

	public void setTxtIdRefe_Referencia(InputText txtIdRefe_Referencia) {
		this.txtIdRefe_Referencia = txtIdRefe_Referencia;
	}

	public InputText getTxtIdSucu_Sucursal() {
		return txtIdSucu_Sucursal;
	}

	public void setTxtIdSucu_Sucursal(InputText txtIdSucu_Sucursal) {
		this.txtIdSucu_Sucursal = txtIdSucu_Sucursal;
	}

	public InputText getTxtIdUnve_UnidadVenta() {
		return txtIdUnve_UnidadVenta;
	}

	public void setTxtIdUnve_UnidadVenta(InputText txtIdUnve_UnidadVenta) {
		this.txtIdUnve_UnidadVenta = txtIdUnve_UnidadVenta;
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

	public InputText getTxtIdPtcv() {
		return txtIdPtcv;
	}

	public void setTxtIdPtcv(InputText txtIdPtcv) {
		this.txtIdPtcv = txtIdPtcv;
	}

	public List<PronosticoVentaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataPronosticoVenta();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<PronosticoVentaDTO> pronosticoVentaDTO) {
		this.data = pronosticoVentaDTO;
	}

	public PronosticoVentaDTO getSelectedPronosticoVenta() {
		return selectedPronosticoVenta;
	}

	public void setSelectedPronosticoVenta(PronosticoVentaDTO pronosticoVenta) {
		this.selectedPronosticoVenta = pronosticoVenta;
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
