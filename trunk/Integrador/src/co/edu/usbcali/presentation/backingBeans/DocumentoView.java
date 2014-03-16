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
import co.edu.usbcali.modelo.Documento;
import co.edu.usbcali.modelo.dto.DocumentoDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class DocumentoView {
	private InputText txtEstadoRegistro;
	private InputText txtNumeroDefinitivo;
	private InputText txtNumeroDocumento;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtValorTotal;
	private InputText txtIdCusa_Causal;
	private InputText txtIdCodo_ConsecutivoDocumento;
	private InputText txtIdEsdo_EstadoDocumento;
	private InputText txtIdReco_RelacionComercial;
	private InputText txtIdSucu_Sucursal;
	private InputText txtIdTido_TipoDocumento;
	private InputText txtIdUnve_UnidadVenta;
	private InputText txtIdDocu;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaDocumento;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DocumentoDTO> data;
	private DocumentoDTO selectedDocumento;
	private Documento entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public DocumentoView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DocumentoDTO documentoDTO = (DocumentoDTO) e.getObject();

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(documentoDTO.getEstadoRegistro());

			if (txtNumeroDefinitivo == null) {
				txtNumeroDefinitivo = new InputText();
			}

			txtNumeroDefinitivo.setValue(documentoDTO.getNumeroDefinitivo());

			if (txtNumeroDocumento == null) {
				txtNumeroDocumento = new InputText();
			}

			txtNumeroDocumento.setValue(documentoDTO.getNumeroDocumento());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(documentoDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(documentoDTO.getOperModifica());

			if (txtValorTotal == null) {
				txtValorTotal = new InputText();
			}

			txtValorTotal.setValue(documentoDTO.getValorTotal());

			if (txtIdCusa_Causal == null) {
				txtIdCusa_Causal = new InputText();
			}

			txtIdCusa_Causal.setValue(documentoDTO.getIdCusa_Causal());

			if (txtIdCodo_ConsecutivoDocumento == null) {
				txtIdCodo_ConsecutivoDocumento = new InputText();
			}

			txtIdCodo_ConsecutivoDocumento.setValue(documentoDTO
					.getIdCodo_ConsecutivoDocumento());

			if (txtIdEsdo_EstadoDocumento == null) {
				txtIdEsdo_EstadoDocumento = new InputText();
			}

			txtIdEsdo_EstadoDocumento.setValue(documentoDTO
					.getIdEsdo_EstadoDocumento());

			if (txtIdReco_RelacionComercial == null) {
				txtIdReco_RelacionComercial = new InputText();
			}

			txtIdReco_RelacionComercial.setValue(documentoDTO
					.getIdReco_RelacionComercial());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new InputText();
			}

			txtIdSucu_Sucursal.setValue(documentoDTO.getIdSucu_Sucursal());

			if (txtIdTido_TipoDocumento == null) {
				txtIdTido_TipoDocumento = new InputText();
			}

			txtIdTido_TipoDocumento.setValue(documentoDTO
					.getIdTido_TipoDocumento());

			if (txtIdUnve_UnidadVenta == null) {
				txtIdUnve_UnidadVenta = new InputText();
			}

			if (txtIdDocu == null) {
				txtIdDocu = new InputText();
			}

			txtIdDocu.setValue(documentoDTO.getIdDocu());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(documentoDTO.getFechaCreacion());

			if (txtFechaDocumento == null) {
				txtFechaDocumento = new Calendar();
			}

			txtFechaDocumento.setValue(documentoDTO.getFechaDocumento());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(documentoDTO.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedDocumento = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDocumento = null;

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtNumeroDefinitivo != null) {
			txtNumeroDefinitivo.setValue(null);
			txtNumeroDefinitivo.setDisabled(true);
		}

		if (txtNumeroDocumento != null) {
			txtNumeroDocumento.setValue(null);
			txtNumeroDocumento.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtValorTotal != null) {
			txtValorTotal.setValue(null);
			txtValorTotal.setDisabled(true);
		}

		if (txtIdCusa_Causal != null) {
			txtIdCusa_Causal.setValue(null);
			txtIdCusa_Causal.setDisabled(true);
		}

		if (txtIdCodo_ConsecutivoDocumento != null) {
			txtIdCodo_ConsecutivoDocumento.setValue(null);
			txtIdCodo_ConsecutivoDocumento.setDisabled(true);
		}

		if (txtIdEsdo_EstadoDocumento != null) {
			txtIdEsdo_EstadoDocumento.setValue(null);
			txtIdEsdo_EstadoDocumento.setDisabled(true);
		}

		if (txtIdReco_RelacionComercial != null) {
			txtIdReco_RelacionComercial.setValue(null);
			txtIdReco_RelacionComercial.setDisabled(true);
		}

		if (txtIdSucu_Sucursal != null) {
			txtIdSucu_Sucursal.setValue(null);
			txtIdSucu_Sucursal.setDisabled(true);
		}

		if (txtIdTido_TipoDocumento != null) {
			txtIdTido_TipoDocumento.setValue(null);
			txtIdTido_TipoDocumento.setDisabled(true);
		}

		if (txtIdUnve_UnidadVenta != null) {
			txtIdUnve_UnidadVenta.setValue(null);
			txtIdUnve_UnidadVenta.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaDocumento != null) {
			txtFechaDocumento.setValue(null);
			txtFechaDocumento.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdDocu != null) {
			txtIdDocu.setValue(null);
			txtIdDocu.setDisabled(false);
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

	public void listener_txtFechaDocumento() {
		Date inputDate = (Date) txtFechaDocumento.getValue();
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
			Long idDocu = new Long(txtIdDocu.getValue().toString());
			entity = businessDelegatorView.getDocumento(idDocu);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEstadoRegistro.setDisabled(false);
			txtNumeroDefinitivo.setDisabled(false);
			txtNumeroDocumento.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtValorTotal.setDisabled(false);
			txtIdCusa_Causal.setDisabled(false);
			txtIdCodo_ConsecutivoDocumento.setDisabled(false);
			txtIdEsdo_EstadoDocumento.setDisabled(false);
			txtIdReco_RelacionComercial.setDisabled(false);
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdTido_TipoDocumento.setDisabled(false);
			txtIdUnve_UnidadVenta.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaDocumento.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdDocu.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaDocumento.setValue(entity.getFechaDocumento());
			txtFechaDocumento.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtNumeroDefinitivo.setValue(entity.getNumeroDefinitivo());
			txtNumeroDefinitivo.setDisabled(false);
			txtNumeroDocumento.setValue(entity.getNumeroDocumento());
			txtNumeroDocumento.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtValorTotal.setValue(entity.getValorTotal());
			txtValorTotal.setDisabled(false);
			txtIdCusa_Causal.setValue(entity.getCausal().getIdCusa());
			txtIdCusa_Causal.setDisabled(false);
			txtIdCodo_ConsecutivoDocumento.setValue(entity
					.getConsecutivoDocumento().getIdCodo());
			txtIdCodo_ConsecutivoDocumento.setDisabled(false);
			txtIdEsdo_EstadoDocumento.setValue(entity.getEstadoDocumento()
					.getIdEsdo());
			txtIdEsdo_EstadoDocumento.setDisabled(false);
			txtIdReco_RelacionComercial.setValue(entity.getRelacionComercial()
					.getIdReco());
			txtIdReco_RelacionComercial.setDisabled(false);
			txtIdSucu_Sucursal.setValue(entity.getSucursal().getIdSucu());
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdTido_TipoDocumento.setValue(entity.getTipoDocumento()
					.getIdTido());
			txtIdTido_TipoDocumento.setDisabled(false);

			txtIdUnve_UnidadVenta.setDisabled(false);
			txtIdDocu.setValue(entity.getIdDocu());
			txtIdDocu.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedDocumento = (DocumentoDTO) (evt.getComponent().getAttributes()
				.get("selectedDocumento"));
		txtEstadoRegistro.setValue(selectedDocumento.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedDocumento.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaDocumento.setValue(selectedDocumento.getFechaDocumento());
		txtFechaDocumento.setDisabled(false);
		txtFechaModificacion.setValue(selectedDocumento.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtNumeroDefinitivo.setValue(selectedDocumento.getNumeroDefinitivo());
		txtNumeroDefinitivo.setDisabled(false);
		txtNumeroDocumento.setValue(selectedDocumento.getNumeroDocumento());
		txtNumeroDocumento.setDisabled(false);
		txtOperCreador.setValue(selectedDocumento.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedDocumento.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtValorTotal.setValue(selectedDocumento.getValorTotal());
		txtValorTotal.setDisabled(false);
		txtIdCusa_Causal.setValue(selectedDocumento.getIdCusa_Causal());
		txtIdCusa_Causal.setDisabled(false);
		txtIdCodo_ConsecutivoDocumento.setValue(selectedDocumento
				.getIdCodo_ConsecutivoDocumento());
		txtIdCodo_ConsecutivoDocumento.setDisabled(false);
		txtIdEsdo_EstadoDocumento.setValue(selectedDocumento
				.getIdEsdo_EstadoDocumento());
		txtIdEsdo_EstadoDocumento.setDisabled(false);
		txtIdReco_RelacionComercial.setValue(selectedDocumento
				.getIdReco_RelacionComercial());
		txtIdReco_RelacionComercial.setDisabled(false);
		txtIdSucu_Sucursal.setValue(selectedDocumento.getIdSucu_Sucursal());
		txtIdSucu_Sucursal.setDisabled(false);
		txtIdTido_TipoDocumento.setValue(selectedDocumento
				.getIdTido_TipoDocumento());
		txtIdTido_TipoDocumento.setDisabled(false);

		txtIdUnve_UnidadVenta.setDisabled(false);
		txtIdDocu.setValue(selectedDocumento.getIdDocu());
		txtIdDocu.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedDocumento == null) && (entity == null)) {
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
			entity = new Documento();

			Long idDocu = new Long(txtIdDocu.getValue().toString());

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaDocumento(FacesUtils.checkDate(txtFechaDocumento));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdDocu(idDocu);
			entity.setNumeroDefinitivo(FacesUtils
					.checkString(txtNumeroDefinitivo));
			entity.setNumeroDocumento(FacesUtils.checkLong(txtNumeroDocumento));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setValorTotal(FacesUtils.checkDouble(txtValorTotal));
			entity.setCausal(businessDelegatorView.getCausal(FacesUtils
					.checkLong(txtIdCusa_Causal)));
			entity.setConsecutivoDocumento(businessDelegatorView
					.getConsecutivoDocumento(FacesUtils
							.checkLong(txtIdCodo_ConsecutivoDocumento)));
			entity.setEstadoDocumento(businessDelegatorView
					.getEstadoDocumento(FacesUtils
							.checkLong(txtIdEsdo_EstadoDocumento)));
			entity.setRelacionComercial(businessDelegatorView
					.getRelacionComercial(FacesUtils
							.checkLong(txtIdReco_RelacionComercial)));
			entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			entity.setTipoDocumento(businessDelegatorView
					.getTipoDocumento(FacesUtils
							.checkLong(txtIdTido_TipoDocumento)));

			businessDelegatorView.saveDocumento(entity);
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
				Long idDocu = new Long(selectedDocumento.getIdDocu());
				entity = businessDelegatorView.getDocumento(idDocu);
			}

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaDocumento(FacesUtils.checkDate(txtFechaDocumento));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setNumeroDefinitivo(FacesUtils
					.checkString(txtNumeroDefinitivo));
			entity.setNumeroDocumento(FacesUtils.checkLong(txtNumeroDocumento));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setValorTotal(FacesUtils.checkDouble(txtValorTotal));
			entity.setCausal(businessDelegatorView.getCausal(FacesUtils
					.checkLong(txtIdCusa_Causal)));
			entity.setConsecutivoDocumento(businessDelegatorView
					.getConsecutivoDocumento(FacesUtils
							.checkLong(txtIdCodo_ConsecutivoDocumento)));
			entity.setEstadoDocumento(businessDelegatorView
					.getEstadoDocumento(FacesUtils
							.checkLong(txtIdEsdo_EstadoDocumento)));
			entity.setRelacionComercial(businessDelegatorView
					.getRelacionComercial(FacesUtils
							.checkLong(txtIdReco_RelacionComercial)));
			entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			entity.setTipoDocumento(businessDelegatorView
					.getTipoDocumento(FacesUtils
							.checkLong(txtIdTido_TipoDocumento)));

			businessDelegatorView.updateDocumento(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedDocumento = (DocumentoDTO) (evt.getComponent()
					.getAttributes().get("selectedDocumento"));

			Long idDocu = new Long(selectedDocumento.getIdDocu());
			entity = businessDelegatorView.getDocumento(idDocu);
			businessDelegatorView.deleteDocumento(entity);
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
			selectedDocumento = (DocumentoDTO) (evt.getComponent()
					.getAttributes().get("selectedDocumento"));

			Long idDocu = new Long(selectedDocumento.getIdDocu());
			entity = businessDelegatorView.getDocumento(idDocu);
			businessDelegatorView.deleteDocumento(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedDocumento);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaDocumento, Date fechaModificacion,
			Long idDocu, String numeroDefinitivo, Long numeroDocumento,
			String operCreador, String operModifica, Double valorTotal,
			Long idCusa_Causal, Long idCodo_ConsecutivoDocumento,
			Long idEsdo_EstadoDocumento, Long idReco_RelacionComercial,
			Long idSucu_Sucursal, Long idTido_TipoDocumento,
			Long idUnve_UnidadVenta, Long idUnve_UnidadVenta0) throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaDocumento(FacesUtils.checkDate(fechaDocumento));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setNumeroDefinitivo(FacesUtils.checkString(numeroDefinitivo));
			entity.setNumeroDocumento(FacesUtils.checkLong(numeroDocumento));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setValorTotal(FacesUtils.checkDouble(valorTotal));
			businessDelegatorView.updateDocumento(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DocumentoView").requestRender();
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

	public InputText getTxtNumeroDefinitivo() {
		return txtNumeroDefinitivo;
	}

	public void setTxtNumeroDefinitivo(InputText txtNumeroDefinitivo) {
		this.txtNumeroDefinitivo = txtNumeroDefinitivo;
	}

	public InputText getTxtNumeroDocumento() {
		return txtNumeroDocumento;
	}

	public void setTxtNumeroDocumento(InputText txtNumeroDocumento) {
		this.txtNumeroDocumento = txtNumeroDocumento;
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

	public InputText getTxtValorTotal() {
		return txtValorTotal;
	}

	public void setTxtValorTotal(InputText txtValorTotal) {
		this.txtValorTotal = txtValorTotal;
	}

	public InputText getTxtIdCusa_Causal() {
		return txtIdCusa_Causal;
	}

	public void setTxtIdCusa_Causal(InputText txtIdCusa_Causal) {
		this.txtIdCusa_Causal = txtIdCusa_Causal;
	}

	public InputText getTxtIdCodo_ConsecutivoDocumento() {
		return txtIdCodo_ConsecutivoDocumento;
	}

	public void setTxtIdCodo_ConsecutivoDocumento(
			InputText txtIdCodo_ConsecutivoDocumento) {
		this.txtIdCodo_ConsecutivoDocumento = txtIdCodo_ConsecutivoDocumento;
	}

	public InputText getTxtIdEsdo_EstadoDocumento() {
		return txtIdEsdo_EstadoDocumento;
	}

	public void setTxtIdEsdo_EstadoDocumento(InputText txtIdEsdo_EstadoDocumento) {
		this.txtIdEsdo_EstadoDocumento = txtIdEsdo_EstadoDocumento;
	}

	public InputText getTxtIdReco_RelacionComercial() {
		return txtIdReco_RelacionComercial;
	}

	public void setTxtIdReco_RelacionComercial(
			InputText txtIdReco_RelacionComercial) {
		this.txtIdReco_RelacionComercial = txtIdReco_RelacionComercial;
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

	public Calendar getTxtFechaDocumento() {
		return txtFechaDocumento;
	}

	public void setTxtFechaDocumento(Calendar txtFechaDocumento) {
		this.txtFechaDocumento = txtFechaDocumento;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public InputText getTxtIdDocu() {
		return txtIdDocu;
	}

	public void setTxtIdDocu(InputText txtIdDocu) {
		this.txtIdDocu = txtIdDocu;
	}

	public List<DocumentoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDocumento();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DocumentoDTO> documentoDTO) {
		this.data = documentoDTO;
	}

	public DocumentoDTO getSelectedDocumento() {
		return selectedDocumento;
	}

	public void setSelectedDocumento(DocumentoDTO documento) {
		this.selectedDocumento = documento;
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
