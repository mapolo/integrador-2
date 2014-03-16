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
import co.edu.usbcali.modelo.MovimientoInventario;
import co.edu.usbcali.modelo.dto.MovimientoInventarioDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class MovimientoInventarioView {
	private InputText txtCantidad;
	private InputText txtClaseVenta;
	private InputText txtCostoUnitario;
	private InputText txtEstadoRegistro;
	private InputText txtNumeroRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtPlacaVehiculo;
	private InputText txtPorcentajeIva;
	private InputText txtReferencia;
	private InputText txtValorTotal;
	private InputText txtIdCusa_Causal;
	private InputText txtIdDocu_Documento;
	private InputText txtIdResu_ReferenciaSucursal;
	private InputText txtIdSucu_Sucursal;
	private InputText txtIdMoin;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaMovimiento;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<MovimientoInventarioDTO> data;
	private MovimientoInventarioDTO selectedMovimientoInventario;
	private MovimientoInventario entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public MovimientoInventarioView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			MovimientoInventarioDTO movimientoInventarioDTO = (MovimientoInventarioDTO) e
					.getObject();

			if (txtCantidad == null) {
				txtCantidad = new InputText();
			}

			txtCantidad.setValue(movimientoInventarioDTO.getCantidad());

			if (txtClaseVenta == null) {
				txtClaseVenta = new InputText();
			}

			txtClaseVenta.setValue(movimientoInventarioDTO.getClaseVenta());

			if (txtCostoUnitario == null) {
				txtCostoUnitario = new InputText();
			}

			txtCostoUnitario.setValue(movimientoInventarioDTO
					.getCostoUnitario());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(movimientoInventarioDTO
					.getEstadoRegistro());

			if (txtNumeroRegistro == null) {
				txtNumeroRegistro = new InputText();
			}

			txtNumeroRegistro.setValue(movimientoInventarioDTO
					.getNumeroRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(movimientoInventarioDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(movimientoInventarioDTO.getOperModifica());

			if (txtPlacaVehiculo == null) {
				txtPlacaVehiculo = new InputText();
			}

			txtPlacaVehiculo.setValue(movimientoInventarioDTO
					.getPlacaVehiculo());

			if (txtPorcentajeIva == null) {
				txtPorcentajeIva = new InputText();
			}

			txtPorcentajeIva.setValue(movimientoInventarioDTO
					.getPorcentajeIva());

			if (txtReferencia == null) {
				txtReferencia = new InputText();
			}

			txtReferencia.setValue(movimientoInventarioDTO.getReferencia());

			if (txtValorTotal == null) {
				txtValorTotal = new InputText();
			}

			txtValorTotal.setValue(movimientoInventarioDTO.getValorTotal());

			if (txtIdCusa_Causal == null) {
				txtIdCusa_Causal = new InputText();
			}

			txtIdCusa_Causal.setValue(movimientoInventarioDTO
					.getIdCusa_Causal());

			if (txtIdDocu_Documento == null) {
				txtIdDocu_Documento = new InputText();
			}

			txtIdDocu_Documento.setValue(movimientoInventarioDTO
					.getIdDocu_Documento());

			if (txtIdResu_ReferenciaSucursal == null) {
				txtIdResu_ReferenciaSucursal = new InputText();
			}

			txtIdResu_ReferenciaSucursal.setValue(movimientoInventarioDTO
					.getIdResu_ReferenciaSucursal());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new InputText();
			}

			if (txtIdMoin == null) {
				txtIdMoin = new InputText();
			}

			txtIdMoin.setValue(movimientoInventarioDTO.getIdMoin());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(movimientoInventarioDTO
					.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(movimientoInventarioDTO
					.getFechaModificacion());

			if (txtFechaMovimiento == null) {
				txtFechaMovimiento = new Calendar();
			}

			txtFechaMovimiento.setValue(movimientoInventarioDTO
					.getFechaMovimiento());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedMovimientoInventario = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedMovimientoInventario = null;

		if (txtCantidad != null) {
			txtCantidad.setValue(null);
			txtCantidad.setDisabled(true);
		}

		if (txtClaseVenta != null) {
			txtClaseVenta.setValue(null);
			txtClaseVenta.setDisabled(true);
		}

		if (txtCostoUnitario != null) {
			txtCostoUnitario.setValue(null);
			txtCostoUnitario.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
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

		if (txtPlacaVehiculo != null) {
			txtPlacaVehiculo.setValue(null);
			txtPlacaVehiculo.setDisabled(true);
		}

		if (txtPorcentajeIva != null) {
			txtPorcentajeIva.setValue(null);
			txtPorcentajeIva.setDisabled(true);
		}

		if (txtReferencia != null) {
			txtReferencia.setValue(null);
			txtReferencia.setDisabled(true);
		}

		if (txtValorTotal != null) {
			txtValorTotal.setValue(null);
			txtValorTotal.setDisabled(true);
		}

		if (txtIdCusa_Causal != null) {
			txtIdCusa_Causal.setValue(null);
			txtIdCusa_Causal.setDisabled(true);
		}

		if (txtIdDocu_Documento != null) {
			txtIdDocu_Documento.setValue(null);
			txtIdDocu_Documento.setDisabled(true);
		}

		if (txtIdResu_ReferenciaSucursal != null) {
			txtIdResu_ReferenciaSucursal.setValue(null);
			txtIdResu_ReferenciaSucursal.setDisabled(true);
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

		if (txtFechaMovimiento != null) {
			txtFechaMovimiento.setValue(null);
			txtFechaMovimiento.setDisabled(true);
		}

		if (txtIdMoin != null) {
			txtIdMoin.setValue(null);
			txtIdMoin.setDisabled(false);
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

	public void listener_txtFechaMovimiento() {
		Date inputDate = (Date) txtFechaMovimiento.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Long idMoin = new Long(txtIdMoin.getValue().toString());
			entity = businessDelegatorView.getMovimientoInventario(idMoin);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtCantidad.setDisabled(false);
			txtClaseVenta.setDisabled(false);
			txtCostoUnitario.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtNumeroRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtPlacaVehiculo.setDisabled(false);
			txtPorcentajeIva.setDisabled(false);
			txtReferencia.setDisabled(false);
			txtValorTotal.setDisabled(false);
			txtIdCusa_Causal.setDisabled(false);
			txtIdDocu_Documento.setDisabled(false);
			txtIdResu_ReferenciaSucursal.setDisabled(false);
			txtIdSucu_Sucursal.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtFechaMovimiento.setDisabled(false);
			txtIdMoin.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCantidad.setValue(entity.getCantidad());
			txtCantidad.setDisabled(false);
			txtClaseVenta.setValue(entity.getClaseVenta());
			txtClaseVenta.setDisabled(false);
			txtCostoUnitario.setValue(entity.getCostoUnitario());
			txtCostoUnitario.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtFechaMovimiento.setValue(entity.getFechaMovimiento());
			txtFechaMovimiento.setDisabled(false);
			txtNumeroRegistro.setValue(entity.getNumeroRegistro());
			txtNumeroRegistro.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtPlacaVehiculo.setValue(entity.getPlacaVehiculo());
			txtPlacaVehiculo.setDisabled(false);
			txtPorcentajeIva.setValue(entity.getPorcentajeIva());
			txtPorcentajeIva.setDisabled(false);
			txtReferencia.setValue(entity.getReferencia());
			txtReferencia.setDisabled(false);
			txtValorTotal.setValue(entity.getValorTotal());
			txtValorTotal.setDisabled(false);
			txtIdCusa_Causal.setValue(entity.getCausal().getIdCusa());
			txtIdCusa_Causal.setDisabled(false);
			txtIdDocu_Documento.setValue(entity.getDocumento().getIdDocu());
			txtIdDocu_Documento.setDisabled(false);
			txtIdResu_ReferenciaSucursal.setValue(entity
					.getReferenciaSucursal().getIdResu());
			txtIdResu_ReferenciaSucursal.setDisabled(false);

			txtIdSucu_Sucursal.setDisabled(false);
			txtIdMoin.setValue(entity.getIdMoin());
			txtIdMoin.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedMovimientoInventario = (MovimientoInventarioDTO) (evt
				.getComponent().getAttributes()
				.get("selectedMovimientoInventario"));
		txtCantidad.setValue(selectedMovimientoInventario.getCantidad());
		txtCantidad.setDisabled(false);
		txtClaseVenta.setValue(selectedMovimientoInventario.getClaseVenta());
		txtClaseVenta.setDisabled(false);
		txtCostoUnitario.setValue(selectedMovimientoInventario
				.getCostoUnitario());
		txtCostoUnitario.setDisabled(false);
		txtEstadoRegistro.setValue(selectedMovimientoInventario
				.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedMovimientoInventario
				.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedMovimientoInventario
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtFechaMovimiento.setValue(selectedMovimientoInventario
				.getFechaMovimiento());
		txtFechaMovimiento.setDisabled(false);
		txtNumeroRegistro.setValue(selectedMovimientoInventario
				.getNumeroRegistro());
		txtNumeroRegistro.setDisabled(false);
		txtOperCreador.setValue(selectedMovimientoInventario.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica
				.setValue(selectedMovimientoInventario.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtPlacaVehiculo.setValue(selectedMovimientoInventario
				.getPlacaVehiculo());
		txtPlacaVehiculo.setDisabled(false);
		txtPorcentajeIva.setValue(selectedMovimientoInventario
				.getPorcentajeIva());
		txtPorcentajeIva.setDisabled(false);
		txtReferencia.setValue(selectedMovimientoInventario.getReferencia());
		txtReferencia.setDisabled(false);
		txtValorTotal.setValue(selectedMovimientoInventario.getValorTotal());
		txtValorTotal.setDisabled(false);
		txtIdCusa_Causal.setValue(selectedMovimientoInventario
				.getIdCusa_Causal());
		txtIdCusa_Causal.setDisabled(false);
		txtIdDocu_Documento.setValue(selectedMovimientoInventario
				.getIdDocu_Documento());
		txtIdDocu_Documento.setDisabled(false);
		txtIdResu_ReferenciaSucursal.setValue(selectedMovimientoInventario
				.getIdResu_ReferenciaSucursal());
		txtIdResu_ReferenciaSucursal.setDisabled(false);

		txtIdSucu_Sucursal.setDisabled(false);
		txtIdMoin.setValue(selectedMovimientoInventario.getIdMoin());
		txtIdMoin.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedMovimientoInventario == null) && (entity == null)) {
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
			entity = new MovimientoInventario();

			Long idMoin = new Long(txtIdMoin.getValue().toString());

			entity.setCantidad(FacesUtils.checkDouble(txtCantidad));
			entity.setClaseVenta(FacesUtils.checkString(txtClaseVenta));
			entity.setCostoUnitario(FacesUtils.checkDouble(txtCostoUnitario));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaMovimiento(FacesUtils.checkDate(txtFechaMovimiento));
			entity.setIdMoin(idMoin);
			entity.setNumeroRegistro(FacesUtils.checkLong(txtNumeroRegistro));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setPlacaVehiculo(FacesUtils.checkString(txtPlacaVehiculo));
			entity.setPorcentajeIva(FacesUtils.checkDouble(txtPorcentajeIva));
			entity.setReferencia(FacesUtils.checkString(txtReferencia));
			entity.setValorTotal(FacesUtils.checkDouble(txtValorTotal));
			entity.setCausal(businessDelegatorView.getCausal(FacesUtils
					.checkLong(txtIdCusa_Causal)));
			entity.setDocumento(businessDelegatorView.getDocumento(FacesUtils
					.checkLong(txtIdDocu_Documento)));
			entity.setReferenciaSucursal(businessDelegatorView
					.getReferenciaSucursal(FacesUtils
							.checkLong(txtIdResu_ReferenciaSucursal)));
			businessDelegatorView.saveMovimientoInventario(entity);
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
				Long idMoin = new Long(selectedMovimientoInventario.getIdMoin());
				entity = businessDelegatorView.getMovimientoInventario(idMoin);
			}

			entity.setCantidad(FacesUtils.checkDouble(txtCantidad));
			entity.setClaseVenta(FacesUtils.checkString(txtClaseVenta));
			entity.setCostoUnitario(FacesUtils.checkDouble(txtCostoUnitario));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaMovimiento(FacesUtils.checkDate(txtFechaMovimiento));
			entity.setNumeroRegistro(FacesUtils.checkLong(txtNumeroRegistro));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setPlacaVehiculo(FacesUtils.checkString(txtPlacaVehiculo));
			entity.setPorcentajeIva(FacesUtils.checkDouble(txtPorcentajeIva));
			entity.setReferencia(FacesUtils.checkString(txtReferencia));
			entity.setValorTotal(FacesUtils.checkDouble(txtValorTotal));
			entity.setCausal(businessDelegatorView.getCausal(FacesUtils
					.checkLong(txtIdCusa_Causal)));
			entity.setDocumento(businessDelegatorView.getDocumento(FacesUtils
					.checkLong(txtIdDocu_Documento)));
			entity.setReferenciaSucursal(businessDelegatorView
					.getReferenciaSucursal(FacesUtils
							.checkLong(txtIdResu_ReferenciaSucursal)));

			businessDelegatorView.updateMovimientoInventario(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedMovimientoInventario = (MovimientoInventarioDTO) (evt
					.getComponent().getAttributes()
					.get("selectedMovimientoInventario"));

			Long idMoin = new Long(selectedMovimientoInventario.getIdMoin());
			entity = businessDelegatorView.getMovimientoInventario(idMoin);
			businessDelegatorView.deleteMovimientoInventario(entity);
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
			selectedMovimientoInventario = (MovimientoInventarioDTO) (evt
					.getComponent().getAttributes()
					.get("selectedMovimientoInventario"));

			Long idMoin = new Long(selectedMovimientoInventario.getIdMoin());
			entity = businessDelegatorView.getMovimientoInventario(idMoin);
			businessDelegatorView.deleteMovimientoInventario(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedMovimientoInventario);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Double cantidad, String claseVenta,
			Double costoUnitario, String estadoRegistro, Date fechaCreacion,
			Date fechaModificacion, Date fechaMovimiento, Long idMoin,
			Long numeroRegistro, String operCreador, String operModifica,
			String placaVehiculo, Double porcentajeIva, String referencia,
			Double valorTotal, Long idCusa_Causal, Long idDocu_Documento,
			Long idResu_ReferenciaSucursal, Long idSucu_Sucursal,
			Long idSucu_Sucursal0) throws Exception {
		try {
			entity.setCantidad(FacesUtils.checkDouble(cantidad));
			entity.setClaseVenta(FacesUtils.checkString(claseVenta));
			entity.setCostoUnitario(FacesUtils.checkDouble(costoUnitario));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaMovimiento(FacesUtils.checkDate(fechaMovimiento));
			entity.setNumeroRegistro(FacesUtils.checkLong(numeroRegistro));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setPlacaVehiculo(FacesUtils.checkString(placaVehiculo));
			entity.setPorcentajeIva(FacesUtils.checkDouble(porcentajeIva));
			entity.setReferencia(FacesUtils.checkString(referencia));
			entity.setValorTotal(FacesUtils.checkDouble(valorTotal));
			businessDelegatorView.updateMovimientoInventario(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("MovimientoInventarioView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCantidad() {
		return txtCantidad;
	}

	public void setTxtCantidad(InputText txtCantidad) {
		this.txtCantidad = txtCantidad;
	}

	public InputText getTxtClaseVenta() {
		return txtClaseVenta;
	}

	public void setTxtClaseVenta(InputText txtClaseVenta) {
		this.txtClaseVenta = txtClaseVenta;
	}

	public InputText getTxtCostoUnitario() {
		return txtCostoUnitario;
	}

	public void setTxtCostoUnitario(InputText txtCostoUnitario) {
		this.txtCostoUnitario = txtCostoUnitario;
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
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

	public InputText getTxtPlacaVehiculo() {
		return txtPlacaVehiculo;
	}

	public void setTxtPlacaVehiculo(InputText txtPlacaVehiculo) {
		this.txtPlacaVehiculo = txtPlacaVehiculo;
	}

	public InputText getTxtPorcentajeIva() {
		return txtPorcentajeIva;
	}

	public void setTxtPorcentajeIva(InputText txtPorcentajeIva) {
		this.txtPorcentajeIva = txtPorcentajeIva;
	}

	public InputText getTxtReferencia() {
		return txtReferencia;
	}

	public void setTxtReferencia(InputText txtReferencia) {
		this.txtReferencia = txtReferencia;
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

	public InputText getTxtIdDocu_Documento() {
		return txtIdDocu_Documento;
	}

	public void setTxtIdDocu_Documento(InputText txtIdDocu_Documento) {
		this.txtIdDocu_Documento = txtIdDocu_Documento;
	}

	public InputText getTxtIdResu_ReferenciaSucursal() {
		return txtIdResu_ReferenciaSucursal;
	}

	public void setTxtIdResu_ReferenciaSucursal(
			InputText txtIdResu_ReferenciaSucursal) {
		this.txtIdResu_ReferenciaSucursal = txtIdResu_ReferenciaSucursal;
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

	public Calendar getTxtFechaMovimiento() {
		return txtFechaMovimiento;
	}

	public void setTxtFechaMovimiento(Calendar txtFechaMovimiento) {
		this.txtFechaMovimiento = txtFechaMovimiento;
	}

	public InputText getTxtIdMoin() {
		return txtIdMoin;
	}

	public void setTxtIdMoin(InputText txtIdMoin) {
		this.txtIdMoin = txtIdMoin;
	}

	public List<MovimientoInventarioDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataMovimientoInventario();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<MovimientoInventarioDTO> movimientoInventarioDTO) {
		this.data = movimientoInventarioDTO;
	}

	public MovimientoInventarioDTO getSelectedMovimientoInventario() {
		return selectedMovimientoInventario;
	}

	public void setSelectedMovimientoInventario(
			MovimientoInventarioDTO movimientoInventario) {
		this.selectedMovimientoInventario = movimientoInventario;
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
