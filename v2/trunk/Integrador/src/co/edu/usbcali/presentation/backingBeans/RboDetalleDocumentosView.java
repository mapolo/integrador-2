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
import co.edu.usbcali.modelo.RboDetalleDocumentos;
import co.edu.usbcali.modelo.dto.RboDetalleDocumentosDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class RboDetalleDocumentosView {
	private InputText txtDebitoCredito;
	private InputText txtEstadoRegistro;
	private InputText txtLineaFamilia;
	private InputText txtMontoAbonado;
	private InputText txtNumeroAbono;
	private InputText txtNumeroRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtValorDescuento;
	private InputText txtIdCart_Cartera;
	private InputText txtIdCpto_ConceptoRecibo;
	private InputText txtIdDica_DistribucionCartera;
	private InputText txtIdDocu_Documento;
	private InputText txtIdRcbo_Recibo;
	private InputText txtIdSucu_Sucursal;
	private InputText txtIdUnve_UnidadVenta;
	private InputText txtIdRddo;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<RboDetalleDocumentosDTO> data;
	private RboDetalleDocumentosDTO selectedRboDetalleDocumentos;
	private RboDetalleDocumentos entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public RboDetalleDocumentosView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			RboDetalleDocumentosDTO rboDetalleDocumentosDTO = (RboDetalleDocumentosDTO) e
					.getObject();

			if (txtDebitoCredito == null) {
				txtDebitoCredito = new InputText();
			}

			txtDebitoCredito.setValue(rboDetalleDocumentosDTO
					.getDebitoCredito());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(rboDetalleDocumentosDTO
					.getEstadoRegistro());

			if (txtLineaFamilia == null) {
				txtLineaFamilia = new InputText();
			}

			txtLineaFamilia.setValue(rboDetalleDocumentosDTO.getLineaFamilia());

			if (txtMontoAbonado == null) {
				txtMontoAbonado = new InputText();
			}

			txtMontoAbonado.setValue(rboDetalleDocumentosDTO.getMontoAbonado());

			if (txtNumeroAbono == null) {
				txtNumeroAbono = new InputText();
			}

			txtNumeroAbono.setValue(rboDetalleDocumentosDTO.getNumeroAbono());

			if (txtNumeroRegistro == null) {
				txtNumeroRegistro = new InputText();
			}

			txtNumeroRegistro.setValue(rboDetalleDocumentosDTO
					.getNumeroRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(rboDetalleDocumentosDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(rboDetalleDocumentosDTO.getOperModifica());

			if (txtValorDescuento == null) {
				txtValorDescuento = new InputText();
			}

			txtValorDescuento.setValue(rboDetalleDocumentosDTO
					.getValorDescuento());

			if (txtIdCart_Cartera == null) {
				txtIdCart_Cartera = new InputText();
			}

			txtIdCart_Cartera.setValue(rboDetalleDocumentosDTO
					.getIdCart_Cartera());

			if (txtIdCpto_ConceptoRecibo == null) {
				txtIdCpto_ConceptoRecibo = new InputText();
			}

			txtIdCpto_ConceptoRecibo.setValue(rboDetalleDocumentosDTO
					.getIdCpto_ConceptoRecibo());

			if (txtIdDica_DistribucionCartera == null) {
				txtIdDica_DistribucionCartera = new InputText();
			}

			txtIdDica_DistribucionCartera.setValue(rboDetalleDocumentosDTO
					.getIdDica_DistribucionCartera());

			if (txtIdDocu_Documento == null) {
				txtIdDocu_Documento = new InputText();
			}

			txtIdDocu_Documento.setValue(rboDetalleDocumentosDTO
					.getIdDocu_Documento());

			if (txtIdRcbo_Recibo == null) {
				txtIdRcbo_Recibo = new InputText();
			}

			txtIdRcbo_Recibo.setValue(rboDetalleDocumentosDTO
					.getIdRcbo_Recibo());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new InputText();
			}

			txtIdSucu_Sucursal.setValue(rboDetalleDocumentosDTO
					.getIdSucu_Sucursal());

			if (txtIdUnve_UnidadVenta == null) {
				txtIdUnve_UnidadVenta = new InputText();
			}

			txtIdUnve_UnidadVenta.setValue(rboDetalleDocumentosDTO
					.getIdUnve_UnidadVenta());

			if (txtIdRddo == null) {
				txtIdRddo = new InputText();
			}

			txtIdRddo.setValue(rboDetalleDocumentosDTO.getIdRddo());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(rboDetalleDocumentosDTO
					.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(rboDetalleDocumentosDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedRboDetalleDocumentos = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedRboDetalleDocumentos = null;

		if (txtDebitoCredito != null) {
			txtDebitoCredito.setValue(null);
			txtDebitoCredito.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtLineaFamilia != null) {
			txtLineaFamilia.setValue(null);
			txtLineaFamilia.setDisabled(true);
		}

		if (txtMontoAbonado != null) {
			txtMontoAbonado.setValue(null);
			txtMontoAbonado.setDisabled(true);
		}

		if (txtNumeroAbono != null) {
			txtNumeroAbono.setValue(null);
			txtNumeroAbono.setDisabled(true);
		}

		if (txtNumeroRegistro != null) {
			txtNumeroRegistro.setValue(null);
			txtNumeroRegistro.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtValorDescuento != null) {
			txtValorDescuento.setValue(null);
			txtValorDescuento.setDisabled(true);
		}

		if (txtIdCart_Cartera != null) {
			txtIdCart_Cartera.setValue(null);
			txtIdCart_Cartera.setDisabled(true);
		}

		if (txtIdCpto_ConceptoRecibo != null) {
			txtIdCpto_ConceptoRecibo.setValue(null);
			txtIdCpto_ConceptoRecibo.setDisabled(true);
		}

		if (txtIdDica_DistribucionCartera != null) {
			txtIdDica_DistribucionCartera.setValue(null);
			txtIdDica_DistribucionCartera.setDisabled(true);
		}

		if (txtIdDocu_Documento != null) {
			txtIdDocu_Documento.setValue(null);
			txtIdDocu_Documento.setDisabled(true);
		}

		if (txtIdRcbo_Recibo != null) {
			txtIdRcbo_Recibo.setValue(null);
			txtIdRcbo_Recibo.setDisabled(true);
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

		if (txtIdRddo != null) {
			txtIdRddo.setValue(null);
			txtIdRddo.setDisabled(false);
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
			Long idRddo = new Long(txtIdRddo.getValue().toString());
			entity = businessDelegatorView.getRboDetalleDocumentos(idRddo);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtDebitoCredito.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtLineaFamilia.setDisabled(false);
			txtMontoAbonado.setDisabled(false);
			txtNumeroAbono.setDisabled(false);
			txtNumeroRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtValorDescuento.setDisabled(false);
			txtIdCart_Cartera.setDisabled(false);
			txtIdCpto_ConceptoRecibo.setDisabled(false);
			txtIdDica_DistribucionCartera.setDisabled(false);
			txtIdDocu_Documento.setDisabled(false);
			txtIdRcbo_Recibo.setDisabled(false);
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdUnve_UnidadVenta.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdRddo.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtDebitoCredito.setValue(entity.getDebitoCredito());
			txtDebitoCredito.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtLineaFamilia.setValue(entity.getLineaFamilia());
			txtLineaFamilia.setDisabled(false);
			txtMontoAbonado.setValue(entity.getMontoAbonado());
			txtMontoAbonado.setDisabled(false);
			txtNumeroAbono.setValue(entity.getNumeroAbono());
			txtNumeroAbono.setDisabled(false);
			txtNumeroRegistro.setValue(entity.getNumeroRegistro());
			txtNumeroRegistro.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtValorDescuento.setValue(entity.getValorDescuento());
			txtValorDescuento.setDisabled(false);
			txtIdCart_Cartera.setValue(entity.getCartera().getIdCart());
			txtIdCart_Cartera.setDisabled(false);
			txtIdCpto_ConceptoRecibo.setValue(entity.getConceptoRecibo()
					.getIdCpto());
			txtIdCpto_ConceptoRecibo.setDisabled(false);
			txtIdDica_DistribucionCartera.setValue(entity
					.getDistribucionCartera().getIdDica());
			txtIdDica_DistribucionCartera.setDisabled(false);
			txtIdDocu_Documento.setValue(entity.getDocumento().getIdDocu());
			txtIdDocu_Documento.setDisabled(false);
			txtIdRcbo_Recibo.setValue(entity.getRecibo().getIdRcbo());
			txtIdRcbo_Recibo.setDisabled(false);
			txtIdSucu_Sucursal.setValue(entity.getSucursal().getIdSucu());
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdUnve_UnidadVenta.setValue(entity.getUnidadVenta().getIdUnve());
			txtIdUnve_UnidadVenta.setDisabled(false);
			txtIdRddo.setValue(entity.getIdRddo());
			txtIdRddo.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedRboDetalleDocumentos = (RboDetalleDocumentosDTO) (evt
				.getComponent().getAttributes()
				.get("selectedRboDetalleDocumentos"));
		txtDebitoCredito.setValue(selectedRboDetalleDocumentos
				.getDebitoCredito());
		txtDebitoCredito.setDisabled(false);
		txtEstadoRegistro.setValue(selectedRboDetalleDocumentos
				.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedRboDetalleDocumentos
				.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedRboDetalleDocumentos
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtLineaFamilia
				.setValue(selectedRboDetalleDocumentos.getLineaFamilia());
		txtLineaFamilia.setDisabled(false);
		txtMontoAbonado
				.setValue(selectedRboDetalleDocumentos.getMontoAbonado());
		txtMontoAbonado.setDisabled(false);
		txtNumeroAbono.setValue(selectedRboDetalleDocumentos.getNumeroAbono());
		txtNumeroAbono.setDisabled(false);
		txtNumeroRegistro.setValue(selectedRboDetalleDocumentos
				.getNumeroRegistro());
		txtNumeroRegistro.setDisabled(false);
		txtOperCreador.setValue(selectedRboDetalleDocumentos.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica
				.setValue(selectedRboDetalleDocumentos.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtValorDescuento.setValue(selectedRboDetalleDocumentos
				.getValorDescuento());
		txtValorDescuento.setDisabled(false);
		txtIdCart_Cartera.setValue(selectedRboDetalleDocumentos
				.getIdCart_Cartera());
		txtIdCart_Cartera.setDisabled(false);
		txtIdCpto_ConceptoRecibo.setValue(selectedRboDetalleDocumentos
				.getIdCpto_ConceptoRecibo());
		txtIdCpto_ConceptoRecibo.setDisabled(false);
		txtIdDica_DistribucionCartera.setValue(selectedRboDetalleDocumentos
				.getIdDica_DistribucionCartera());
		txtIdDica_DistribucionCartera.setDisabled(false);
		txtIdDocu_Documento.setValue(selectedRboDetalleDocumentos
				.getIdDocu_Documento());
		txtIdDocu_Documento.setDisabled(false);
		txtIdRcbo_Recibo.setValue(selectedRboDetalleDocumentos
				.getIdRcbo_Recibo());
		txtIdRcbo_Recibo.setDisabled(false);
		txtIdSucu_Sucursal.setValue(selectedRboDetalleDocumentos
				.getIdSucu_Sucursal());
		txtIdSucu_Sucursal.setDisabled(false);
		txtIdUnve_UnidadVenta.setValue(selectedRboDetalleDocumentos
				.getIdUnve_UnidadVenta());
		txtIdUnve_UnidadVenta.setDisabled(false);
		txtIdRddo.setValue(selectedRboDetalleDocumentos.getIdRddo());
		txtIdRddo.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedRboDetalleDocumentos == null) && (entity == null)) {
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
			entity = new RboDetalleDocumentos();

			Long idRddo = new Long(txtIdRddo.getValue().toString());

			entity.setDebitoCredito(FacesUtils.checkString(txtDebitoCredito));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdRddo(idRddo);
			entity.setLineaFamilia(FacesUtils.checkString(txtLineaFamilia));
			entity.setMontoAbonado(FacesUtils.checkDouble(txtMontoAbonado));
			entity.setNumeroAbono(FacesUtils.checkLong(txtNumeroAbono));
			entity.setNumeroRegistro(FacesUtils.checkLong(txtNumeroRegistro));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setValorDescuento(FacesUtils.checkDouble(txtValorDescuento));
			entity.setCartera(businessDelegatorView.getCartera(FacesUtils
					.checkLong(txtIdCart_Cartera)));
			entity.setConceptoRecibo(businessDelegatorView
					.getConceptoRecibo(FacesUtils
							.checkLong(txtIdCpto_ConceptoRecibo)));
			entity.setDistribucionCartera(businessDelegatorView
					.getDistribucionCartera(FacesUtils
							.checkLong(txtIdDica_DistribucionCartera)));
			entity.setDocumento(businessDelegatorView.getDocumento(FacesUtils
					.checkLong(txtIdDocu_Documento)));
			entity.setRecibo(businessDelegatorView.getRecibo(FacesUtils
					.checkLong(txtIdRcbo_Recibo)));
			entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			entity.setUnidadVenta(businessDelegatorView
					.getUnidadVenta(FacesUtils.checkLong(txtIdUnve_UnidadVenta)));
			businessDelegatorView.saveRboDetalleDocumentos(entity);
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
				Long idRddo = new Long(selectedRboDetalleDocumentos.getIdRddo());
				entity = businessDelegatorView.getRboDetalleDocumentos(idRddo);
			}

			entity.setDebitoCredito(FacesUtils.checkString(txtDebitoCredito));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setLineaFamilia(FacesUtils.checkString(txtLineaFamilia));
			entity.setMontoAbonado(FacesUtils.checkDouble(txtMontoAbonado));
			entity.setNumeroAbono(FacesUtils.checkLong(txtNumeroAbono));
			entity.setNumeroRegistro(FacesUtils.checkLong(txtNumeroRegistro));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setValorDescuento(FacesUtils.checkDouble(txtValorDescuento));
			entity.setCartera(businessDelegatorView.getCartera(FacesUtils
					.checkLong(txtIdCart_Cartera)));
			entity.setConceptoRecibo(businessDelegatorView
					.getConceptoRecibo(FacesUtils
							.checkLong(txtIdCpto_ConceptoRecibo)));
			entity.setDistribucionCartera(businessDelegatorView
					.getDistribucionCartera(FacesUtils
							.checkLong(txtIdDica_DistribucionCartera)));
			entity.setDocumento(businessDelegatorView.getDocumento(FacesUtils
					.checkLong(txtIdDocu_Documento)));
			entity.setRecibo(businessDelegatorView.getRecibo(FacesUtils
					.checkLong(txtIdRcbo_Recibo)));
			entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			entity.setUnidadVenta(businessDelegatorView
					.getUnidadVenta(FacesUtils.checkLong(txtIdUnve_UnidadVenta)));
			businessDelegatorView.updateRboDetalleDocumentos(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedRboDetalleDocumentos = (RboDetalleDocumentosDTO) (evt
					.getComponent().getAttributes()
					.get("selectedRboDetalleDocumentos"));

			Long idRddo = new Long(selectedRboDetalleDocumentos.getIdRddo());
			entity = businessDelegatorView.getRboDetalleDocumentos(idRddo);
			businessDelegatorView.deleteRboDetalleDocumentos(entity);
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
			selectedRboDetalleDocumentos = (RboDetalleDocumentosDTO) (evt
					.getComponent().getAttributes()
					.get("selectedRboDetalleDocumentos"));

			Long idRddo = new Long(selectedRboDetalleDocumentos.getIdRddo());
			entity = businessDelegatorView.getRboDetalleDocumentos(idRddo);
			businessDelegatorView.deleteRboDetalleDocumentos(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedRboDetalleDocumentos);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String debitoCredito,
			String estadoRegistro, Date fechaCreacion, Date fechaModificacion,
			Long idRddo, String lineaFamilia, Double montoAbonado,
			Long numeroAbono, Long numeroRegistro, String operCreador,
			String operModifica, Double valorDescuento, Long idCart_Cartera,
			Long idCpto_ConceptoRecibo, Long idDica_DistribucionCartera,
			Long idDocu_Documento, Long idRcbo_Recibo, Long idSucu_Sucursal,
			Long idUnve_UnidadVenta) throws Exception {
		try {
			entity.setDebitoCredito(FacesUtils.checkString(debitoCredito));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setLineaFamilia(FacesUtils.checkString(lineaFamilia));
			entity.setMontoAbonado(FacesUtils.checkDouble(montoAbonado));
			entity.setNumeroAbono(FacesUtils.checkLong(numeroAbono));
			entity.setNumeroRegistro(FacesUtils.checkLong(numeroRegistro));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setValorDescuento(FacesUtils.checkDouble(valorDescuento));
			businessDelegatorView.updateRboDetalleDocumentos(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("RboDetalleDocumentosView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtDebitoCredito() {
		return txtDebitoCredito;
	}

	public void setTxtDebitoCredito(InputText txtDebitoCredito) {
		this.txtDebitoCredito = txtDebitoCredito;
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}

	public InputText getTxtLineaFamilia() {
		return txtLineaFamilia;
	}

	public void setTxtLineaFamilia(InputText txtLineaFamilia) {
		this.txtLineaFamilia = txtLineaFamilia;
	}

	public InputText getTxtMontoAbonado() {
		return txtMontoAbonado;
	}

	public void setTxtMontoAbonado(InputText txtMontoAbonado) {
		this.txtMontoAbonado = txtMontoAbonado;
	}

	public InputText getTxtNumeroAbono() {
		return txtNumeroAbono;
	}

	public void setTxtNumeroAbono(InputText txtNumeroAbono) {
		this.txtNumeroAbono = txtNumeroAbono;
	}

	public InputText getTxtNumeroRegistro() {
		return txtNumeroRegistro;
	}

	public void setTxtNumeroRegistro(InputText txtNumeroRegistro) {
		this.txtNumeroRegistro = txtNumeroRegistro;
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

	public InputText getTxtValorDescuento() {
		return txtValorDescuento;
	}

	public void setTxtValorDescuento(InputText txtValorDescuento) {
		this.txtValorDescuento = txtValorDescuento;
	}

	public InputText getTxtIdCart_Cartera() {
		return txtIdCart_Cartera;
	}

	public void setTxtIdCart_Cartera(InputText txtIdCart_Cartera) {
		this.txtIdCart_Cartera = txtIdCart_Cartera;
	}

	public InputText getTxtIdCpto_ConceptoRecibo() {
		return txtIdCpto_ConceptoRecibo;
	}

	public void setTxtIdCpto_ConceptoRecibo(InputText txtIdCpto_ConceptoRecibo) {
		this.txtIdCpto_ConceptoRecibo = txtIdCpto_ConceptoRecibo;
	}

	public InputText getTxtIdDica_DistribucionCartera() {
		return txtIdDica_DistribucionCartera;
	}

	public void setTxtIdDica_DistribucionCartera(
			InputText txtIdDica_DistribucionCartera) {
		this.txtIdDica_DistribucionCartera = txtIdDica_DistribucionCartera;
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

	public InputText getTxtIdRddo() {
		return txtIdRddo;
	}

	public void setTxtIdRddo(InputText txtIdRddo) {
		this.txtIdRddo = txtIdRddo;
	}

	public List<RboDetalleDocumentosDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataRboDetalleDocumentos();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<RboDetalleDocumentosDTO> rboDetalleDocumentosDTO) {
		this.data = rboDetalleDocumentosDTO;
	}

	public RboDetalleDocumentosDTO getSelectedRboDetalleDocumentos() {
		return selectedRboDetalleDocumentos;
	}

	public void setSelectedRboDetalleDocumentos(
			RboDetalleDocumentosDTO rboDetalleDocumentos) {
		this.selectedRboDetalleDocumentos = rboDetalleDocumentos;
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
