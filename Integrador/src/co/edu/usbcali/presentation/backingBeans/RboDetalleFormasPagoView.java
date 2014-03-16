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
import co.edu.usbcali.modelo.RboDetalleFormasPago;
import co.edu.usbcali.modelo.dto.RboDetalleFormasPagoDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class RboDetalleFormasPagoView {
	private InputText txtEstadoRegistro;
	private InputText txtMontoCancelado;
	private InputText txtNumeroDocumeto;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtTransaccion;
	private InputText txtIdBanc_Banco;
	private InputText txtIdChps_ChequePosfechado;
	private InputText txtIdDocu_Documento;
	private InputText txtIdRcbo_Recibo;
	private InputText txtIdTfpa_TipoFormaPago;
	private InputText txtIdRdfp;
	private Calendar txtFechaConsignacion;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<RboDetalleFormasPagoDTO> data;
	private RboDetalleFormasPagoDTO selectedRboDetalleFormasPago;
	private RboDetalleFormasPago entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public RboDetalleFormasPagoView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			RboDetalleFormasPagoDTO rboDetalleFormasPagoDTO = (RboDetalleFormasPagoDTO) e
					.getObject();

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(rboDetalleFormasPagoDTO
					.getEstadoRegistro());

			if (txtMontoCancelado == null) {
				txtMontoCancelado = new InputText();
			}

			txtMontoCancelado.setValue(rboDetalleFormasPagoDTO
					.getMontoCancelado());

			if (txtNumeroDocumeto == null) {
				txtNumeroDocumeto = new InputText();
			}

			txtNumeroDocumeto.setValue(rboDetalleFormasPagoDTO
					.getNumeroDocumeto());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(rboDetalleFormasPagoDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(rboDetalleFormasPagoDTO.getOperModifica());

			if (txtTransaccion == null) {
				txtTransaccion = new InputText();
			}

			txtTransaccion.setValue(rboDetalleFormasPagoDTO.getTransaccion());

			if (txtIdBanc_Banco == null) {
				txtIdBanc_Banco = new InputText();
			}

			txtIdBanc_Banco.setValue(rboDetalleFormasPagoDTO.getIdBanc_Banco());

			if (txtIdChps_ChequePosfechado == null) {
				txtIdChps_ChequePosfechado = new InputText();
			}

			txtIdChps_ChequePosfechado.setValue(rboDetalleFormasPagoDTO
					.getIdChps_ChequePosfechado());

			if (txtIdDocu_Documento == null) {
				txtIdDocu_Documento = new InputText();
			}

			txtIdDocu_Documento.setValue(rboDetalleFormasPagoDTO
					.getIdDocu_Documento());

			if (txtIdRcbo_Recibo == null) {
				txtIdRcbo_Recibo = new InputText();
			}

			txtIdRcbo_Recibo.setValue(rboDetalleFormasPagoDTO
					.getIdRcbo_Recibo());

			if (txtIdTfpa_TipoFormaPago == null) {
				txtIdTfpa_TipoFormaPago = new InputText();
			}

			txtIdTfpa_TipoFormaPago.setValue(rboDetalleFormasPagoDTO
					.getIdTfpa_TipoFormaPago());

			if (txtIdRdfp == null) {
				txtIdRdfp = new InputText();
			}

			txtIdRdfp.setValue(rboDetalleFormasPagoDTO.getIdRdfp());

			if (txtFechaConsignacion == null) {
				txtFechaConsignacion = new Calendar();
			}

			txtFechaConsignacion.setValue(rboDetalleFormasPagoDTO
					.getFechaConsignacion());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(rboDetalleFormasPagoDTO
					.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(rboDetalleFormasPagoDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedRboDetalleFormasPago = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedRboDetalleFormasPago = null;

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtMontoCancelado != null) {
			txtMontoCancelado.setValue(null);
			txtMontoCancelado.setDisabled(true);
		}

		if (txtNumeroDocumeto != null) {
			txtNumeroDocumeto.setValue(null);
			txtNumeroDocumeto.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtTransaccion != null) {
			txtTransaccion.setValue(null);
			txtTransaccion.setDisabled(true);
		}

		if (txtIdBanc_Banco != null) {
			txtIdBanc_Banco.setValue(null);
			txtIdBanc_Banco.setDisabled(true);
		}

		if (txtIdChps_ChequePosfechado != null) {
			txtIdChps_ChequePosfechado.setValue(null);
			txtIdChps_ChequePosfechado.setDisabled(true);
		}

		if (txtIdDocu_Documento != null) {
			txtIdDocu_Documento.setValue(null);
			txtIdDocu_Documento.setDisabled(true);
		}

		if (txtIdRcbo_Recibo != null) {
			txtIdRcbo_Recibo.setValue(null);
			txtIdRcbo_Recibo.setDisabled(true);
		}

		if (txtIdTfpa_TipoFormaPago != null) {
			txtIdTfpa_TipoFormaPago.setValue(null);
			txtIdTfpa_TipoFormaPago.setDisabled(true);
		}

		if (txtFechaConsignacion != null) {
			txtFechaConsignacion.setValue(null);
			txtFechaConsignacion.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdRdfp != null) {
			txtIdRdfp.setValue(null);
			txtIdRdfp.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		return "";
	}

	public void listener_txtFechaConsignacion() {
		Date inputDate = (Date) txtFechaConsignacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
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
			Long idRdfp = new Long(txtIdRdfp.getValue().toString());
			entity = businessDelegatorView.getRboDetalleFormasPago(idRdfp);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEstadoRegistro.setDisabled(false);
			txtMontoCancelado.setDisabled(false);
			txtNumeroDocumeto.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtTransaccion.setDisabled(false);
			txtIdBanc_Banco.setDisabled(false);
			txtIdChps_ChequePosfechado.setDisabled(false);
			txtIdDocu_Documento.setDisabled(false);
			txtIdRcbo_Recibo.setDisabled(false);
			txtIdTfpa_TipoFormaPago.setDisabled(false);
			txtFechaConsignacion.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdRdfp.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaConsignacion.setValue(entity.getFechaConsignacion());
			txtFechaConsignacion.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtMontoCancelado.setValue(entity.getMontoCancelado());
			txtMontoCancelado.setDisabled(false);
			txtNumeroDocumeto.setValue(entity.getNumeroDocumeto());
			txtNumeroDocumeto.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtTransaccion.setValue(entity.getTransaccion());
			txtTransaccion.setDisabled(false);
			txtIdBanc_Banco.setValue(entity.getBanco().getIdBanc());
			txtIdBanc_Banco.setDisabled(false);
			txtIdChps_ChequePosfechado.setValue(entity.getChequePosfechado()
					.getIdChps());
			txtIdChps_ChequePosfechado.setDisabled(false);
			txtIdDocu_Documento.setValue(entity.getDocumento().getIdDocu());
			txtIdDocu_Documento.setDisabled(false);
			txtIdRcbo_Recibo.setValue(entity.getRecibo().getIdRcbo());
			txtIdRcbo_Recibo.setDisabled(false);
			txtIdTfpa_TipoFormaPago.setValue(entity.getTipoFormaPago()
					.getIdTfpa());
			txtIdTfpa_TipoFormaPago.setDisabled(false);
			txtIdRdfp.setValue(entity.getIdRdfp());
			txtIdRdfp.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedRboDetalleFormasPago = (RboDetalleFormasPagoDTO) (evt
				.getComponent().getAttributes()
				.get("selectedRboDetalleFormasPago"));
		txtEstadoRegistro.setValue(selectedRboDetalleFormasPago
				.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaConsignacion.setValue(selectedRboDetalleFormasPago
				.getFechaConsignacion());
		txtFechaConsignacion.setDisabled(false);
		txtFechaCreacion.setValue(selectedRboDetalleFormasPago
				.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedRboDetalleFormasPago
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtMontoCancelado.setValue(selectedRboDetalleFormasPago
				.getMontoCancelado());
		txtMontoCancelado.setDisabled(false);
		txtNumeroDocumeto.setValue(selectedRboDetalleFormasPago
				.getNumeroDocumeto());
		txtNumeroDocumeto.setDisabled(false);
		txtOperCreador.setValue(selectedRboDetalleFormasPago.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica
				.setValue(selectedRboDetalleFormasPago.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtTransaccion.setValue(selectedRboDetalleFormasPago.getTransaccion());
		txtTransaccion.setDisabled(false);
		txtIdBanc_Banco
				.setValue(selectedRboDetalleFormasPago.getIdBanc_Banco());
		txtIdBanc_Banco.setDisabled(false);
		txtIdChps_ChequePosfechado.setValue(selectedRboDetalleFormasPago
				.getIdChps_ChequePosfechado());
		txtIdChps_ChequePosfechado.setDisabled(false);
		txtIdDocu_Documento.setValue(selectedRboDetalleFormasPago
				.getIdDocu_Documento());
		txtIdDocu_Documento.setDisabled(false);
		txtIdRcbo_Recibo.setValue(selectedRboDetalleFormasPago
				.getIdRcbo_Recibo());
		txtIdRcbo_Recibo.setDisabled(false);
		txtIdTfpa_TipoFormaPago.setValue(selectedRboDetalleFormasPago
				.getIdTfpa_TipoFormaPago());
		txtIdTfpa_TipoFormaPago.setDisabled(false);
		txtIdRdfp.setValue(selectedRboDetalleFormasPago.getIdRdfp());
		txtIdRdfp.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedRboDetalleFormasPago == null) && (entity == null)) {
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
			entity = new RboDetalleFormasPago();

			Long idRdfp = new Long(txtIdRdfp.getValue().toString());

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaConsignacion(FacesUtils
					.checkDate(txtFechaConsignacion));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdRdfp(idRdfp);
			entity.setMontoCancelado(FacesUtils.checkDouble(txtMontoCancelado));
			entity.setNumeroDocumeto(FacesUtils.checkString(txtNumeroDocumeto));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setTransaccion(FacesUtils.checkString(txtTransaccion));
			entity.setBanco(businessDelegatorView.getBanco(FacesUtils
					.checkLong(txtIdBanc_Banco)));
			entity.setChequePosfechado(businessDelegatorView
					.getChequePosfechado(FacesUtils
							.checkLong(txtIdChps_ChequePosfechado)));
			entity.setDocumento(businessDelegatorView.getDocumento(FacesUtils
					.checkLong(txtIdDocu_Documento)));
			entity.setRecibo(businessDelegatorView.getRecibo(FacesUtils
					.checkLong(txtIdRcbo_Recibo)));
			entity.setTipoFormaPago(businessDelegatorView
					.getTipoFormaPago(FacesUtils
							.checkLong(txtIdTfpa_TipoFormaPago)));
			businessDelegatorView.saveRboDetalleFormasPago(entity);
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
				Long idRdfp = new Long(selectedRboDetalleFormasPago.getIdRdfp());
				entity = businessDelegatorView.getRboDetalleFormasPago(idRdfp);
			}

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaConsignacion(FacesUtils
					.checkDate(txtFechaConsignacion));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setMontoCancelado(FacesUtils.checkDouble(txtMontoCancelado));
			entity.setNumeroDocumeto(FacesUtils.checkString(txtNumeroDocumeto));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setTransaccion(FacesUtils.checkString(txtTransaccion));
			entity.setBanco(businessDelegatorView.getBanco(FacesUtils
					.checkLong(txtIdBanc_Banco)));
			entity.setChequePosfechado(businessDelegatorView
					.getChequePosfechado(FacesUtils
							.checkLong(txtIdChps_ChequePosfechado)));
			entity.setDocumento(businessDelegatorView.getDocumento(FacesUtils
					.checkLong(txtIdDocu_Documento)));
			entity.setRecibo(businessDelegatorView.getRecibo(FacesUtils
					.checkLong(txtIdRcbo_Recibo)));
			entity.setTipoFormaPago(businessDelegatorView
					.getTipoFormaPago(FacesUtils
							.checkLong(txtIdTfpa_TipoFormaPago)));
			businessDelegatorView.updateRboDetalleFormasPago(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedRboDetalleFormasPago = (RboDetalleFormasPagoDTO) (evt
					.getComponent().getAttributes()
					.get("selectedRboDetalleFormasPago"));

			Long idRdfp = new Long(selectedRboDetalleFormasPago.getIdRdfp());
			entity = businessDelegatorView.getRboDetalleFormasPago(idRdfp);
			businessDelegatorView.deleteRboDetalleFormasPago(entity);
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
			selectedRboDetalleFormasPago = (RboDetalleFormasPagoDTO) (evt
					.getComponent().getAttributes()
					.get("selectedRboDetalleFormasPago"));

			Long idRdfp = new Long(selectedRboDetalleFormasPago.getIdRdfp());
			entity = businessDelegatorView.getRboDetalleFormasPago(idRdfp);
			businessDelegatorView.deleteRboDetalleFormasPago(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedRboDetalleFormasPago);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaConsignacion, Date fechaCreacion, Date fechaModificacion,
			Long idRdfp, Double montoCancelado, String numeroDocumeto,
			String operCreador, String operModifica, String transaccion,
			Long idBanc_Banco, Long idChps_ChequePosfechado,
			Long idDocu_Documento, Long idRcbo_Recibo, Long idTfpa_TipoFormaPago)
			throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaConsignacion(FacesUtils.checkDate(fechaConsignacion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setMontoCancelado(FacesUtils.checkDouble(montoCancelado));
			entity.setNumeroDocumeto(FacesUtils.checkString(numeroDocumeto));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setTransaccion(FacesUtils.checkString(transaccion));
			businessDelegatorView.updateRboDetalleFormasPago(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("RboDetalleFormasPagoView").requestRender();
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

	public InputText getTxtMontoCancelado() {
		return txtMontoCancelado;
	}

	public void setTxtMontoCancelado(InputText txtMontoCancelado) {
		this.txtMontoCancelado = txtMontoCancelado;
	}

	public InputText getTxtNumeroDocumeto() {
		return txtNumeroDocumeto;
	}

	public void setTxtNumeroDocumeto(InputText txtNumeroDocumeto) {
		this.txtNumeroDocumeto = txtNumeroDocumeto;
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

	public InputText getTxtTransaccion() {
		return txtTransaccion;
	}

	public void setTxtTransaccion(InputText txtTransaccion) {
		this.txtTransaccion = txtTransaccion;
	}

	public InputText getTxtIdBanc_Banco() {
		return txtIdBanc_Banco;
	}

	public void setTxtIdBanc_Banco(InputText txtIdBanc_Banco) {
		this.txtIdBanc_Banco = txtIdBanc_Banco;
	}

	public InputText getTxtIdChps_ChequePosfechado() {
		return txtIdChps_ChequePosfechado;
	}

	public void setTxtIdChps_ChequePosfechado(
			InputText txtIdChps_ChequePosfechado) {
		this.txtIdChps_ChequePosfechado = txtIdChps_ChequePosfechado;
	}

	public InputText getTxtIdDocu_Documento() {
		return txtIdDocu_Documento;
	}

	public void setTxtIdDocu_Documento(InputText txtIdDocu_Documento) {
		this.txtIdDocu_Documento = txtIdDocu_Documento;
	}

	public InputText getTxtIdRcbo_Recibo() {
		return txtIdRcbo_Recibo;
	}

	public void setTxtIdRcbo_Recibo(InputText txtIdRcbo_Recibo) {
		this.txtIdRcbo_Recibo = txtIdRcbo_Recibo;
	}

	public InputText getTxtIdTfpa_TipoFormaPago() {
		return txtIdTfpa_TipoFormaPago;
	}

	public void setTxtIdTfpa_TipoFormaPago(InputText txtIdTfpa_TipoFormaPago) {
		this.txtIdTfpa_TipoFormaPago = txtIdTfpa_TipoFormaPago;
	}

	public Calendar getTxtFechaConsignacion() {
		return txtFechaConsignacion;
	}

	public void setTxtFechaConsignacion(Calendar txtFechaConsignacion) {
		this.txtFechaConsignacion = txtFechaConsignacion;
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

	public InputText getTxtIdRdfp() {
		return txtIdRdfp;
	}

	public void setTxtIdRdfp(InputText txtIdRdfp) {
		this.txtIdRdfp = txtIdRdfp;
	}

	public List<RboDetalleFormasPagoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataRboDetalleFormasPago();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<RboDetalleFormasPagoDTO> rboDetalleFormasPagoDTO) {
		this.data = rboDetalleFormasPagoDTO;
	}

	public RboDetalleFormasPagoDTO getSelectedRboDetalleFormasPago() {
		return selectedRboDetalleFormasPago;
	}

	public void setSelectedRboDetalleFormasPago(
			RboDetalleFormasPagoDTO rboDetalleFormasPago) {
		this.selectedRboDetalleFormasPago = rboDetalleFormasPago;
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
