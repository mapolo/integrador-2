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
import co.edu.usbcali.modelo.Garantia;
import co.edu.usbcali.modelo.dto.GarantiaDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class GarantiaView {
	private InputText txtAlineacionTrazabilidad;
	private InputText txtAnoTrazabilidad;
	private InputText txtDiaTrazabilidad;
	private InputText txtEstado;
	private InputText txtEstadoRegistro;
	private InputText txtLineaTrazabilidad;
	private InputText txtMesTrazabilidad;
	private InputText txtNumeroGarantia;
	private InputText txtObservacion;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtPlacaTrazabilidad;
	private InputText txtTurnoTrazabilidad;
	private InputText txtIdBate_Bateriologo;
	private InputText txtIdClfa_ClaveFabricacion;
	private InputText txtIdDocu_Documento;
	private InputText txtIdCfal_Fallas;
	private InputText txtIdRefe_Referencia;
	private InputText txtIdTiga_TipoGarantia;
	private InputText txtIdGar;
	private Calendar txtFechaCambio;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaVenta;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<GarantiaDTO> data;
	private GarantiaDTO selectedGarantia;
	private Garantia entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public GarantiaView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			GarantiaDTO garantiaDTO = (GarantiaDTO) e.getObject();

			if (txtAlineacionTrazabilidad == null) {
				txtAlineacionTrazabilidad = new InputText();
			}

			txtAlineacionTrazabilidad.setValue(garantiaDTO
					.getAlineacionTrazabilidad());

			if (txtAnoTrazabilidad == null) {
				txtAnoTrazabilidad = new InputText();
			}

			txtAnoTrazabilidad.setValue(garantiaDTO.getAnoTrazabilidad());

			if (txtDiaTrazabilidad == null) {
				txtDiaTrazabilidad = new InputText();
			}

			txtDiaTrazabilidad.setValue(garantiaDTO.getDiaTrazabilidad());

			if (txtEstado == null) {
				txtEstado = new InputText();
			}

			txtEstado.setValue(garantiaDTO.getEstado());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(garantiaDTO.getEstadoRegistro());

			if (txtLineaTrazabilidad == null) {
				txtLineaTrazabilidad = new InputText();
			}

			txtLineaTrazabilidad.setValue(garantiaDTO.getLineaTrazabilidad());

			if (txtMesTrazabilidad == null) {
				txtMesTrazabilidad = new InputText();
			}

			txtMesTrazabilidad.setValue(garantiaDTO.getMesTrazabilidad());

			if (txtNumeroGarantia == null) {
				txtNumeroGarantia = new InputText();
			}

			txtNumeroGarantia.setValue(garantiaDTO.getNumeroGarantia());

			if (txtObservacion == null) {
				txtObservacion = new InputText();
			}

			txtObservacion.setValue(garantiaDTO.getObservacion());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(garantiaDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(garantiaDTO.getOperModifica());

			if (txtPlacaTrazabilidad == null) {
				txtPlacaTrazabilidad = new InputText();
			}

			txtPlacaTrazabilidad.setValue(garantiaDTO.getPlacaTrazabilidad());

			if (txtTurnoTrazabilidad == null) {
				txtTurnoTrazabilidad = new InputText();
			}

			txtTurnoTrazabilidad.setValue(garantiaDTO.getTurnoTrazabilidad());

			if (txtIdBate_Bateriologo == null) {
				txtIdBate_Bateriologo = new InputText();
			}

			txtIdBate_Bateriologo.setValue(garantiaDTO.getIdBate_Bateriologo());

			if (txtIdClfa_ClaveFabricacion == null) {
				txtIdClfa_ClaveFabricacion = new InputText();
			}

			txtIdClfa_ClaveFabricacion.setValue(garantiaDTO
					.getIdClfa_ClaveFabricacion());

			if (txtIdDocu_Documento == null) {
				txtIdDocu_Documento = new InputText();
			}

			txtIdDocu_Documento.setValue(garantiaDTO.getIdDocu_Documento());

			if (txtIdCfal_Fallas == null) {
				txtIdCfal_Fallas = new InputText();
			}

			txtIdCfal_Fallas.setValue(garantiaDTO.getIdCfal_Fallas());

			if (txtIdRefe_Referencia == null) {
				txtIdRefe_Referencia = new InputText();
			}

			txtIdRefe_Referencia.setValue(garantiaDTO.getIdRefe_Referencia());

			if (txtIdTiga_TipoGarantia == null) {
				txtIdTiga_TipoGarantia = new InputText();
			}

			txtIdTiga_TipoGarantia.setValue(garantiaDTO
					.getIdTiga_TipoGarantia());

			if (txtIdGar == null) {
				txtIdGar = new InputText();
			}

			txtIdGar.setValue(garantiaDTO.getIdGar());

			if (txtFechaCambio == null) {
				txtFechaCambio = new Calendar();
			}

			txtFechaCambio.setValue(garantiaDTO.getFechaCambio());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(garantiaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(garantiaDTO.getFechaModificacion());

			if (txtFechaVenta == null) {
				txtFechaVenta = new Calendar();
			}

			txtFechaVenta.setValue(garantiaDTO.getFechaVenta());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedGarantia = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedGarantia = null;

		if (txtAlineacionTrazabilidad != null) {
			txtAlineacionTrazabilidad.setValue(null);
			txtAlineacionTrazabilidad.setDisabled(true);
		}

		if (txtAnoTrazabilidad != null) {
			txtAnoTrazabilidad.setValue(null);
			txtAnoTrazabilidad.setDisabled(true);
		}

		if (txtDiaTrazabilidad != null) {
			txtDiaTrazabilidad.setValue(null);
			txtDiaTrazabilidad.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue(null);
			txtEstado.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtLineaTrazabilidad != null) {
			txtLineaTrazabilidad.setValue(null);
			txtLineaTrazabilidad.setDisabled(true);
		}

		if (txtMesTrazabilidad != null) {
			txtMesTrazabilidad.setValue(null);
			txtMesTrazabilidad.setDisabled(true);
		}

		if (txtNumeroGarantia != null) {
			txtNumeroGarantia.setValue(null);
			txtNumeroGarantia.setDisabled(true);
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

		if (txtPlacaTrazabilidad != null) {
			txtPlacaTrazabilidad.setValue(null);
			txtPlacaTrazabilidad.setDisabled(true);
		}

		if (txtTurnoTrazabilidad != null) {
			txtTurnoTrazabilidad.setValue(null);
			txtTurnoTrazabilidad.setDisabled(true);
		}

		if (txtIdBate_Bateriologo != null) {
			txtIdBate_Bateriologo.setValue(null);
			txtIdBate_Bateriologo.setDisabled(true);
		}

		if (txtIdClfa_ClaveFabricacion != null) {
			txtIdClfa_ClaveFabricacion.setValue(null);
			txtIdClfa_ClaveFabricacion.setDisabled(true);
		}

		if (txtIdDocu_Documento != null) {
			txtIdDocu_Documento.setValue(null);
			txtIdDocu_Documento.setDisabled(true);
		}

		if (txtIdCfal_Fallas != null) {
			txtIdCfal_Fallas.setValue(null);
			txtIdCfal_Fallas.setDisabled(true);
		}

		if (txtIdRefe_Referencia != null) {
			txtIdRefe_Referencia.setValue(null);
			txtIdRefe_Referencia.setDisabled(true);
		}

		if (txtIdTiga_TipoGarantia != null) {
			txtIdTiga_TipoGarantia.setValue(null);
			txtIdTiga_TipoGarantia.setDisabled(true);
		}

		if (txtFechaCambio != null) {
			txtFechaCambio.setValue(null);
			txtFechaCambio.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtFechaVenta != null) {
			txtFechaVenta.setValue(null);
			txtFechaVenta.setDisabled(true);
		}

		if (txtIdGar != null) {
			txtIdGar.setValue(null);
			txtIdGar.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		return "";
	}

	public void listener_txtFechaCambio() {
		Date inputDate = (Date) txtFechaCambio.getValue();
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

	public void listener_txtFechaVenta() {
		Date inputDate = (Date) txtFechaVenta.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Long idGar = new Long(txtIdGar.getValue().toString());
			entity = businessDelegatorView.getGarantia(idGar);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtAlineacionTrazabilidad.setDisabled(false);
			txtAnoTrazabilidad.setDisabled(false);
			txtDiaTrazabilidad.setDisabled(false);
			txtEstado.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtLineaTrazabilidad.setDisabled(false);
			txtMesTrazabilidad.setDisabled(false);
			txtNumeroGarantia.setDisabled(false);
			txtObservacion.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtPlacaTrazabilidad.setDisabled(false);
			txtTurnoTrazabilidad.setDisabled(false);
			txtIdBate_Bateriologo.setDisabled(false);
			txtIdClfa_ClaveFabricacion.setDisabled(false);
			txtIdDocu_Documento.setDisabled(false);
			txtIdCfal_Fallas.setDisabled(false);
			txtIdRefe_Referencia.setDisabled(false);
			txtIdTiga_TipoGarantia.setDisabled(false);
			txtFechaCambio.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtFechaVenta.setDisabled(false);
			txtIdGar.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtAlineacionTrazabilidad.setValue(entity
					.getAlineacionTrazabilidad());
			txtAlineacionTrazabilidad.setDisabled(false);
			txtAnoTrazabilidad.setValue(entity.getAnoTrazabilidad());
			txtAnoTrazabilidad.setDisabled(false);
			txtDiaTrazabilidad.setValue(entity.getDiaTrazabilidad());
			txtDiaTrazabilidad.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCambio.setValue(entity.getFechaCambio());
			txtFechaCambio.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtFechaVenta.setValue(entity.getFechaVenta());
			txtFechaVenta.setDisabled(false);
			txtLineaTrazabilidad.setValue(entity.getLineaTrazabilidad());
			txtLineaTrazabilidad.setDisabled(false);
			txtMesTrazabilidad.setValue(entity.getMesTrazabilidad());
			txtMesTrazabilidad.setDisabled(false);
			txtNumeroGarantia.setValue(entity.getNumeroGarantia());
			txtNumeroGarantia.setDisabled(false);
			txtObservacion.setValue(entity.getObservacion());
			txtObservacion.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtPlacaTrazabilidad.setValue(entity.getPlacaTrazabilidad());
			txtPlacaTrazabilidad.setDisabled(false);
			txtTurnoTrazabilidad.setValue(entity.getTurnoTrazabilidad());
			txtTurnoTrazabilidad.setDisabled(false);
			txtIdBate_Bateriologo.setValue(entity.getBateriologo().getIdBate());
			txtIdBate_Bateriologo.setDisabled(false);
			txtIdClfa_ClaveFabricacion.setValue(entity.getClaveFabricacion()
					.getIdClfa());
			txtIdClfa_ClaveFabricacion.setDisabled(false);
			txtIdDocu_Documento.setValue(entity.getDocumento().getIdDocu());
			txtIdDocu_Documento.setDisabled(false);
			txtIdCfal_Fallas.setValue(entity.getFallas().getIdCfal());
			txtIdCfal_Fallas.setDisabled(false);
			txtIdRefe_Referencia.setValue(entity.getReferencia().getIdRefe());
			txtIdRefe_Referencia.setDisabled(false);
			txtIdTiga_TipoGarantia.setValue(entity.getTipoGarantia()
					.getIdTiga());
			txtIdTiga_TipoGarantia.setDisabled(false);
			txtIdGar.setValue(entity.getIdGar());
			txtIdGar.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedGarantia = (GarantiaDTO) (evt.getComponent().getAttributes()
				.get("selectedGarantia"));
		txtAlineacionTrazabilidad.setValue(selectedGarantia
				.getAlineacionTrazabilidad());
		txtAlineacionTrazabilidad.setDisabled(false);
		txtAnoTrazabilidad.setValue(selectedGarantia.getAnoTrazabilidad());
		txtAnoTrazabilidad.setDisabled(false);
		txtDiaTrazabilidad.setValue(selectedGarantia.getDiaTrazabilidad());
		txtDiaTrazabilidad.setDisabled(false);
		txtEstado.setValue(selectedGarantia.getEstado());
		txtEstado.setDisabled(false);
		txtEstadoRegistro.setValue(selectedGarantia.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCambio.setValue(selectedGarantia.getFechaCambio());
		txtFechaCambio.setDisabled(false);
		txtFechaCreacion.setValue(selectedGarantia.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedGarantia.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtFechaVenta.setValue(selectedGarantia.getFechaVenta());
		txtFechaVenta.setDisabled(false);
		txtLineaTrazabilidad.setValue(selectedGarantia.getLineaTrazabilidad());
		txtLineaTrazabilidad.setDisabled(false);
		txtMesTrazabilidad.setValue(selectedGarantia.getMesTrazabilidad());
		txtMesTrazabilidad.setDisabled(false);
		txtNumeroGarantia.setValue(selectedGarantia.getNumeroGarantia());
		txtNumeroGarantia.setDisabled(false);
		txtObservacion.setValue(selectedGarantia.getObservacion());
		txtObservacion.setDisabled(false);
		txtOperCreador.setValue(selectedGarantia.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedGarantia.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtPlacaTrazabilidad.setValue(selectedGarantia.getPlacaTrazabilidad());
		txtPlacaTrazabilidad.setDisabled(false);
		txtTurnoTrazabilidad.setValue(selectedGarantia.getTurnoTrazabilidad());
		txtTurnoTrazabilidad.setDisabled(false);
		txtIdBate_Bateriologo
				.setValue(selectedGarantia.getIdBate_Bateriologo());
		txtIdBate_Bateriologo.setDisabled(false);
		txtIdClfa_ClaveFabricacion.setValue(selectedGarantia
				.getIdClfa_ClaveFabricacion());
		txtIdClfa_ClaveFabricacion.setDisabled(false);
		txtIdDocu_Documento.setValue(selectedGarantia.getIdDocu_Documento());
		txtIdDocu_Documento.setDisabled(false);
		txtIdCfal_Fallas.setValue(selectedGarantia.getIdCfal_Fallas());
		txtIdCfal_Fallas.setDisabled(false);
		txtIdRefe_Referencia.setValue(selectedGarantia.getIdRefe_Referencia());
		txtIdRefe_Referencia.setDisabled(false);
		txtIdTiga_TipoGarantia.setValue(selectedGarantia
				.getIdTiga_TipoGarantia());
		txtIdTiga_TipoGarantia.setDisabled(false);
		txtIdGar.setValue(selectedGarantia.getIdGar());
		txtIdGar.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedGarantia == null) && (entity == null)) {
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
			entity = new Garantia();

			Long idGar = new Long(txtIdGar.getValue().toString());

			entity.setAlineacionTrazabilidad(FacesUtils
					.checkString(txtAlineacionTrazabilidad));
			entity.setAnoTrazabilidad(FacesUtils.checkLong(txtAnoTrazabilidad));
			entity.setDiaTrazabilidad(FacesUtils.checkLong(txtDiaTrazabilidad));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCambio(FacesUtils.checkDate(txtFechaCambio));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaVenta(FacesUtils.checkDate(txtFechaVenta));
			entity.setIdGar(idGar);
			entity.setLineaTrazabilidad(FacesUtils
					.checkString(txtLineaTrazabilidad));
			entity.setMesTrazabilidad(FacesUtils
					.checkString(txtMesTrazabilidad));
			entity.setNumeroGarantia(FacesUtils.checkString(txtNumeroGarantia));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setPlacaTrazabilidad(FacesUtils
					.checkString(txtPlacaTrazabilidad));
			entity.setTurnoTrazabilidad(FacesUtils
					.checkString(txtTurnoTrazabilidad));
			entity.setBateriologo(businessDelegatorView
					.getBateriologo(FacesUtils.checkLong(txtIdBate_Bateriologo)));
			entity.setClaveFabricacion(businessDelegatorView
					.getClaveFabricacion(FacesUtils
							.checkLong(txtIdClfa_ClaveFabricacion)));
			entity.setDocumento(businessDelegatorView.getDocumento(FacesUtils
					.checkLong(txtIdDocu_Documento)));
			entity.setFallas(businessDelegatorView.getFallas(FacesUtils
					.checkLong(txtIdCfal_Fallas)));
			entity.setReferencia(businessDelegatorView.getReferencia(FacesUtils
					.checkLong(txtIdRefe_Referencia)));
			entity.setTipoGarantia(businessDelegatorView
					.getTipoGarantia(FacesUtils
							.checkLong(txtIdTiga_TipoGarantia)));
			businessDelegatorView.saveGarantia(entity);
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
				Long idGar = new Long(selectedGarantia.getIdGar());
				entity = businessDelegatorView.getGarantia(idGar);
			}

			entity.setAlineacionTrazabilidad(FacesUtils
					.checkString(txtAlineacionTrazabilidad));
			entity.setAnoTrazabilidad(FacesUtils.checkLong(txtAnoTrazabilidad));
			entity.setDiaTrazabilidad(FacesUtils.checkLong(txtDiaTrazabilidad));
			entity.setEstado(FacesUtils.checkString(txtEstado));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCambio(FacesUtils.checkDate(txtFechaCambio));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaVenta(FacesUtils.checkDate(txtFechaVenta));
			entity.setLineaTrazabilidad(FacesUtils
					.checkString(txtLineaTrazabilidad));
			entity.setMesTrazabilidad(FacesUtils
					.checkString(txtMesTrazabilidad));
			entity.setNumeroGarantia(FacesUtils.checkString(txtNumeroGarantia));
			entity.setObservacion(FacesUtils.checkString(txtObservacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setPlacaTrazabilidad(FacesUtils
					.checkString(txtPlacaTrazabilidad));
			entity.setTurnoTrazabilidad(FacesUtils
					.checkString(txtTurnoTrazabilidad));
			entity.setBateriologo(businessDelegatorView
					.getBateriologo(FacesUtils.checkLong(txtIdBate_Bateriologo)));
			entity.setClaveFabricacion(businessDelegatorView
					.getClaveFabricacion(FacesUtils
							.checkLong(txtIdClfa_ClaveFabricacion)));
			entity.setDocumento(businessDelegatorView.getDocumento(FacesUtils
					.checkLong(txtIdDocu_Documento)));
			entity.setFallas(businessDelegatorView.getFallas(FacesUtils
					.checkLong(txtIdCfal_Fallas)));
			entity.setReferencia(businessDelegatorView.getReferencia(FacesUtils
					.checkLong(txtIdRefe_Referencia)));
			entity.setTipoGarantia(businessDelegatorView
					.getTipoGarantia(FacesUtils
							.checkLong(txtIdTiga_TipoGarantia)));
			businessDelegatorView.updateGarantia(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedGarantia = (GarantiaDTO) (evt.getComponent()
					.getAttributes().get("selectedGarantia"));

			Long idGar = new Long(selectedGarantia.getIdGar());
			entity = businessDelegatorView.getGarantia(idGar);
			businessDelegatorView.deleteGarantia(entity);
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
			selectedGarantia = (GarantiaDTO) (evt.getComponent()
					.getAttributes().get("selectedGarantia"));

			Long idGar = new Long(selectedGarantia.getIdGar());
			entity = businessDelegatorView.getGarantia(idGar);
			businessDelegatorView.deleteGarantia(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedGarantia);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String alineacionTrazabilidad,
			Long anoTrazabilidad, Long diaTrazabilidad, String estado,
			String estadoRegistro, Date fechaCambio, Date fechaCreacion,
			Date fechaModificacion, Date fechaVenta, Long idGar,
			String lineaTrazabilidad, String mesTrazabilidad,
			String numeroGarantia, String observacion, String operCreador,
			String operModifica, String placaTrazabilidad,
			String turnoTrazabilidad, Long idBate_Bateriologo,
			Long idClfa_ClaveFabricacion, Long idDocu_Documento,
			Long idCfal_Fallas, Long idRefe_Referencia, Long idTiga_TipoGarantia)
			throws Exception {
		try {
			entity.setAlineacionTrazabilidad(FacesUtils
					.checkString(alineacionTrazabilidad));
			entity.setAnoTrazabilidad(FacesUtils.checkLong(anoTrazabilidad));
			entity.setDiaTrazabilidad(FacesUtils.checkLong(diaTrazabilidad));
			entity.setEstado(FacesUtils.checkString(estado));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCambio(FacesUtils.checkDate(fechaCambio));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaVenta(FacesUtils.checkDate(fechaVenta));
			entity.setLineaTrazabilidad(FacesUtils
					.checkString(lineaTrazabilidad));
			entity.setMesTrazabilidad(FacesUtils.checkString(mesTrazabilidad));
			entity.setNumeroGarantia(FacesUtils.checkString(numeroGarantia));
			entity.setObservacion(FacesUtils.checkString(observacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setPlacaTrazabilidad(FacesUtils
					.checkString(placaTrazabilidad));
			entity.setTurnoTrazabilidad(FacesUtils
					.checkString(turnoTrazabilidad));
			businessDelegatorView.updateGarantia(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("GarantiaView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtAlineacionTrazabilidad() {
		return txtAlineacionTrazabilidad;
	}

	public void setTxtAlineacionTrazabilidad(InputText txtAlineacionTrazabilidad) {
		this.txtAlineacionTrazabilidad = txtAlineacionTrazabilidad;
	}

	public InputText getTxtAnoTrazabilidad() {
		return txtAnoTrazabilidad;
	}

	public void setTxtAnoTrazabilidad(InputText txtAnoTrazabilidad) {
		this.txtAnoTrazabilidad = txtAnoTrazabilidad;
	}

	public InputText getTxtDiaTrazabilidad() {
		return txtDiaTrazabilidad;
	}

	public void setTxtDiaTrazabilidad(InputText txtDiaTrazabilidad) {
		this.txtDiaTrazabilidad = txtDiaTrazabilidad;
	}

	public InputText getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(InputText txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}

	public InputText getTxtLineaTrazabilidad() {
		return txtLineaTrazabilidad;
	}

	public void setTxtLineaTrazabilidad(InputText txtLineaTrazabilidad) {
		this.txtLineaTrazabilidad = txtLineaTrazabilidad;
	}

	public InputText getTxtMesTrazabilidad() {
		return txtMesTrazabilidad;
	}

	public void setTxtMesTrazabilidad(InputText txtMesTrazabilidad) {
		this.txtMesTrazabilidad = txtMesTrazabilidad;
	}

	public InputText getTxtNumeroGarantia() {
		return txtNumeroGarantia;
	}

	public void setTxtNumeroGarantia(InputText txtNumeroGarantia) {
		this.txtNumeroGarantia = txtNumeroGarantia;
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

	public InputText getTxtPlacaTrazabilidad() {
		return txtPlacaTrazabilidad;
	}

	public void setTxtPlacaTrazabilidad(InputText txtPlacaTrazabilidad) {
		this.txtPlacaTrazabilidad = txtPlacaTrazabilidad;
	}

	public InputText getTxtTurnoTrazabilidad() {
		return txtTurnoTrazabilidad;
	}

	public void setTxtTurnoTrazabilidad(InputText txtTurnoTrazabilidad) {
		this.txtTurnoTrazabilidad = txtTurnoTrazabilidad;
	}

	public InputText getTxtIdBate_Bateriologo() {
		return txtIdBate_Bateriologo;
	}

	public void setTxtIdBate_Bateriologo(InputText txtIdBate_Bateriologo) {
		this.txtIdBate_Bateriologo = txtIdBate_Bateriologo;
	}

	public InputText getTxtIdClfa_ClaveFabricacion() {
		return txtIdClfa_ClaveFabricacion;
	}

	public void setTxtIdClfa_ClaveFabricacion(
			InputText txtIdClfa_ClaveFabricacion) {
		this.txtIdClfa_ClaveFabricacion = txtIdClfa_ClaveFabricacion;
	}

	public InputText getTxtIdDocu_Documento() {
		return txtIdDocu_Documento;
	}

	public void setTxtIdDocu_Documento(InputText txtIdDocu_Documento) {
		this.txtIdDocu_Documento = txtIdDocu_Documento;
	}

	public InputText getTxtIdCfal_Fallas() {
		return txtIdCfal_Fallas;
	}

	public void setTxtIdCfal_Fallas(InputText txtIdCfal_Fallas) {
		this.txtIdCfal_Fallas = txtIdCfal_Fallas;
	}

	public InputText getTxtIdRefe_Referencia() {
		return txtIdRefe_Referencia;
	}

	public void setTxtIdRefe_Referencia(InputText txtIdRefe_Referencia) {
		this.txtIdRefe_Referencia = txtIdRefe_Referencia;
	}

	public InputText getTxtIdTiga_TipoGarantia() {
		return txtIdTiga_TipoGarantia;
	}

	public void setTxtIdTiga_TipoGarantia(InputText txtIdTiga_TipoGarantia) {
		this.txtIdTiga_TipoGarantia = txtIdTiga_TipoGarantia;
	}

	public Calendar getTxtFechaCambio() {
		return txtFechaCambio;
	}

	public void setTxtFechaCambio(Calendar txtFechaCambio) {
		this.txtFechaCambio = txtFechaCambio;
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

	public Calendar getTxtFechaVenta() {
		return txtFechaVenta;
	}

	public void setTxtFechaVenta(Calendar txtFechaVenta) {
		this.txtFechaVenta = txtFechaVenta;
	}

	public InputText getTxtIdGar() {
		return txtIdGar;
	}

	public void setTxtIdGar(InputText txtIdGar) {
		this.txtIdGar = txtIdGar;
	}

	public List<GarantiaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataGarantia();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<GarantiaDTO> garantiaDTO) {
		this.data = garantiaDTO;
	}

	public GarantiaDTO getSelectedGarantia() {
		return selectedGarantia;
	}

	public void setSelectedGarantia(GarantiaDTO garantia) {
		this.selectedGarantia = garantia;
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
