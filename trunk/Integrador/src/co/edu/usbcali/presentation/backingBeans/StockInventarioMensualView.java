package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.StockInventarioMensualDTO;
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
public class StockInventarioMensualView {
	private InputText txtAno;
	private InputText txtCantidadEntrada;
	private InputText txtCantidadSalidas;
	private InputText txtCostoEntradas;
	private InputText txtCostoSalidas;
	private InputText txtEstadoRegistro;
	private InputText txtMaximoDistribucion;
	private InputText txtMaximoPedido;
	private InputText txtMes;
	private InputText txtMinimoDistribucion;
	private InputText txtMinimoPedido;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdSini_SaldoInicialInventario;
	private InputText txtIdStin;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<StockInventarioMensualDTO> data;
	private StockInventarioMensualDTO selectedStockInventarioMensual;
	private StockInventarioMensual entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public StockInventarioMensualView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			StockInventarioMensualDTO stockInventarioMensualDTO = (StockInventarioMensualDTO) e
					.getObject();

			if (txtAno == null) {
				txtAno = new InputText();
			}

			txtAno.setValue(stockInventarioMensualDTO.getAno());

			if (txtCantidadEntrada == null) {
				txtCantidadEntrada = new InputText();
			}

			txtCantidadEntrada.setValue(stockInventarioMensualDTO
					.getCantidadEntrada());

			if (txtCantidadSalidas == null) {
				txtCantidadSalidas = new InputText();
			}

			txtCantidadSalidas.setValue(stockInventarioMensualDTO
					.getCantidadSalidas());

			if (txtCostoEntradas == null) {
				txtCostoEntradas = new InputText();
			}

			txtCostoEntradas.setValue(stockInventarioMensualDTO
					.getCostoEntradas());

			if (txtCostoSalidas == null) {
				txtCostoSalidas = new InputText();
			}

			txtCostoSalidas.setValue(stockInventarioMensualDTO
					.getCostoSalidas());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(stockInventarioMensualDTO
					.getEstadoRegistro());

			if (txtMaximoDistribucion == null) {
				txtMaximoDistribucion = new InputText();
			}

			txtMaximoDistribucion.setValue(stockInventarioMensualDTO
					.getMaximoDistribucion());

			if (txtMaximoPedido == null) {
				txtMaximoPedido = new InputText();
			}

			txtMaximoPedido.setValue(stockInventarioMensualDTO
					.getMaximoPedido());

			if (txtMes == null) {
				txtMes = new InputText();
			}

			txtMes.setValue(stockInventarioMensualDTO.getMes());

			if (txtMinimoDistribucion == null) {
				txtMinimoDistribucion = new InputText();
			}

			txtMinimoDistribucion.setValue(stockInventarioMensualDTO
					.getMinimoDistribucion());

			if (txtMinimoPedido == null) {
				txtMinimoPedido = new InputText();
			}

			txtMinimoPedido.setValue(stockInventarioMensualDTO
					.getMinimoPedido());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(stockInventarioMensualDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(stockInventarioMensualDTO
					.getOperModifica());

			if (txtIdSini_SaldoInicialInventario == null) {
				txtIdSini_SaldoInicialInventario = new InputText();
			}

			txtIdSini_SaldoInicialInventario.setValue(stockInventarioMensualDTO
					.getIdSini_SaldoInicialInventario());

			if (txtIdStin == null) {
				txtIdStin = new InputText();
			}

			txtIdStin.setValue(stockInventarioMensualDTO.getIdStin());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(stockInventarioMensualDTO
					.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(stockInventarioMensualDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedStockInventarioMensual = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedStockInventarioMensual = null;

		if (txtAno != null) {
			txtAno.setValue(null);
			txtAno.setDisabled(true);
		}

		if (txtCantidadEntrada != null) {
			txtCantidadEntrada.setValue(null);
			txtCantidadEntrada.setDisabled(true);
		}

		if (txtCantidadSalidas != null) {
			txtCantidadSalidas.setValue(null);
			txtCantidadSalidas.setDisabled(true);
		}

		if (txtCostoEntradas != null) {
			txtCostoEntradas.setValue(null);
			txtCostoEntradas.setDisabled(true);
		}

		if (txtCostoSalidas != null) {
			txtCostoSalidas.setValue(null);
			txtCostoSalidas.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtMaximoDistribucion != null) {
			txtMaximoDistribucion.setValue(null);
			txtMaximoDistribucion.setDisabled(true);
		}

		if (txtMaximoPedido != null) {
			txtMaximoPedido.setValue(null);
			txtMaximoPedido.setDisabled(true);
		}

		if (txtMes != null) {
			txtMes.setValue(null);
			txtMes.setDisabled(true);
		}

		if (txtMinimoDistribucion != null) {
			txtMinimoDistribucion.setValue(null);
			txtMinimoDistribucion.setDisabled(true);
		}

		if (txtMinimoPedido != null) {
			txtMinimoPedido.setValue(null);
			txtMinimoPedido.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtIdSini_SaldoInicialInventario != null) {
			txtIdSini_SaldoInicialInventario.setValue(null);
			txtIdSini_SaldoInicialInventario.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdStin != null) {
			txtIdStin.setValue(null);
			txtIdStin.setDisabled(false);
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
			Long idStin = new Long(txtIdStin.getValue().toString());
			entity = businessDelegatorView.getStockInventarioMensual(idStin);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtAno.setDisabled(false);
			txtCantidadEntrada.setDisabled(false);
			txtCantidadSalidas.setDisabled(false);
			txtCostoEntradas.setDisabled(false);
			txtCostoSalidas.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtMaximoDistribucion.setDisabled(false);
			txtMaximoPedido.setDisabled(false);
			txtMes.setDisabled(false);
			txtMinimoDistribucion.setDisabled(false);
			txtMinimoPedido.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdSini_SaldoInicialInventario.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdStin.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtAno.setValue(entity.getAno());
			txtAno.setDisabled(false);
			txtCantidadEntrada.setValue(entity.getCantidadEntrada());
			txtCantidadEntrada.setDisabled(false);
			txtCantidadSalidas.setValue(entity.getCantidadSalidas());
			txtCantidadSalidas.setDisabled(false);
			txtCostoEntradas.setValue(entity.getCostoEntradas());
			txtCostoEntradas.setDisabled(false);
			txtCostoSalidas.setValue(entity.getCostoSalidas());
			txtCostoSalidas.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtMaximoDistribucion.setValue(entity.getMaximoDistribucion());
			txtMaximoDistribucion.setDisabled(false);
			txtMaximoPedido.setValue(entity.getMaximoPedido());
			txtMaximoPedido.setDisabled(false);
			txtMes.setValue(entity.getMes());
			txtMes.setDisabled(false);
			txtMinimoDistribucion.setValue(entity.getMinimoDistribucion());
			txtMinimoDistribucion.setDisabled(false);
			txtMinimoPedido.setValue(entity.getMinimoPedido());
			txtMinimoPedido.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdSini_SaldoInicialInventario.setValue(entity
					.getSaldoInicialInventario().getIdSini());
			txtIdSini_SaldoInicialInventario.setDisabled(false);
			txtIdStin.setValue(entity.getIdStin());
			txtIdStin.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedStockInventarioMensual = (StockInventarioMensualDTO) (evt
				.getComponent().getAttributes()
				.get("selectedStockInventarioMensual"));
		txtAno.setValue(selectedStockInventarioMensual.getAno());
		txtAno.setDisabled(false);
		txtCantidadEntrada.setValue(selectedStockInventarioMensual
				.getCantidadEntrada());
		txtCantidadEntrada.setDisabled(false);
		txtCantidadSalidas.setValue(selectedStockInventarioMensual
				.getCantidadSalidas());
		txtCantidadSalidas.setDisabled(false);
		txtCostoEntradas.setValue(selectedStockInventarioMensual
				.getCostoEntradas());
		txtCostoEntradas.setDisabled(false);
		txtCostoSalidas.setValue(selectedStockInventarioMensual
				.getCostoSalidas());
		txtCostoSalidas.setDisabled(false);
		txtEstadoRegistro.setValue(selectedStockInventarioMensual
				.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedStockInventarioMensual
				.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedStockInventarioMensual
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtMaximoDistribucion.setValue(selectedStockInventarioMensual
				.getMaximoDistribucion());
		txtMaximoDistribucion.setDisabled(false);
		txtMaximoPedido.setValue(selectedStockInventarioMensual
				.getMaximoPedido());
		txtMaximoPedido.setDisabled(false);
		txtMes.setValue(selectedStockInventarioMensual.getMes());
		txtMes.setDisabled(false);
		txtMinimoDistribucion.setValue(selectedStockInventarioMensual
				.getMinimoDistribucion());
		txtMinimoDistribucion.setDisabled(false);
		txtMinimoPedido.setValue(selectedStockInventarioMensual
				.getMinimoPedido());
		txtMinimoPedido.setDisabled(false);
		txtOperCreador
				.setValue(selectedStockInventarioMensual.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedStockInventarioMensual
				.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdSini_SaldoInicialInventario
				.setValue(selectedStockInventarioMensual
						.getIdSini_SaldoInicialInventario());
		txtIdSini_SaldoInicialInventario.setDisabled(false);
		txtIdStin.setValue(selectedStockInventarioMensual.getIdStin());
		txtIdStin.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedStockInventarioMensual == null) && (entity == null)) {
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
			entity = new StockInventarioMensual();

			Long idStin = new Long(txtIdStin.getValue().toString());

			entity.setAno(FacesUtils.checkLong(txtAno));
			entity.setCantidadEntrada(FacesUtils
					.checkDouble(txtCantidadEntrada));
			entity.setCantidadSalidas(FacesUtils
					.checkDouble(txtCantidadSalidas));
			entity.setCostoEntradas(FacesUtils.checkDouble(txtCostoEntradas));
			entity.setCostoSalidas(FacesUtils.checkDouble(txtCostoSalidas));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdStin(idStin);
			entity.setMaximoDistribucion(FacesUtils
					.checkDouble(txtMaximoDistribucion));
			entity.setMaximoPedido(FacesUtils.checkDouble(txtMaximoPedido));
			entity.setMes(FacesUtils.checkLong(txtMes));
			entity.setMinimoDistribucion(FacesUtils
					.checkDouble(txtMinimoDistribucion));
			entity.setMinimoPedido(FacesUtils.checkDouble(txtMinimoPedido));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setSaldoInicialInventario(businessDelegatorView
					.getSaldoInicialInventario(FacesUtils
							.checkLong(txtIdSini_SaldoInicialInventario)));
			businessDelegatorView.saveStockInventarioMensual(entity);
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
				Long idStin = new Long(
						selectedStockInventarioMensual.getIdStin());
				entity = businessDelegatorView
						.getStockInventarioMensual(idStin);
			}

			entity.setAno(FacesUtils.checkLong(txtAno));
			entity.setCantidadEntrada(FacesUtils
					.checkDouble(txtCantidadEntrada));
			entity.setCantidadSalidas(FacesUtils
					.checkDouble(txtCantidadSalidas));
			entity.setCostoEntradas(FacesUtils.checkDouble(txtCostoEntradas));
			entity.setCostoSalidas(FacesUtils.checkDouble(txtCostoSalidas));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setMaximoDistribucion(FacesUtils
					.checkDouble(txtMaximoDistribucion));
			entity.setMaximoPedido(FacesUtils.checkDouble(txtMaximoPedido));
			entity.setMes(FacesUtils.checkLong(txtMes));
			entity.setMinimoDistribucion(FacesUtils
					.checkDouble(txtMinimoDistribucion));
			entity.setMinimoPedido(FacesUtils.checkDouble(txtMinimoPedido));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setSaldoInicialInventario(businessDelegatorView
					.getSaldoInicialInventario(FacesUtils
							.checkLong(txtIdSini_SaldoInicialInventario)));
			businessDelegatorView.updateStockInventarioMensual(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedStockInventarioMensual = (StockInventarioMensualDTO) (evt
					.getComponent().getAttributes()
					.get("selectedStockInventarioMensual"));

			Long idStin = new Long(selectedStockInventarioMensual.getIdStin());
			entity = businessDelegatorView.getStockInventarioMensual(idStin);
			businessDelegatorView.deleteStockInventarioMensual(entity);
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
			selectedStockInventarioMensual = (StockInventarioMensualDTO) (evt
					.getComponent().getAttributes()
					.get("selectedStockInventarioMensual"));

			Long idStin = new Long(selectedStockInventarioMensual.getIdStin());
			entity = businessDelegatorView.getStockInventarioMensual(idStin);
			businessDelegatorView.deleteStockInventarioMensual(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedStockInventarioMensual);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long ano, Double cantidadEntrada,
			Double cantidadSalidas, Double costoEntradas, Double costoSalidas,
			String estadoRegistro, Date fechaCreacion, Date fechaModificacion,
			Long idStin, Double maximoDistribucion, Double maximoPedido,
			Long mes, Double minimoDistribucion, Double minimoPedido,
			String operCreador, String operModifica,
			Long idSini_SaldoInicialInventario) throws Exception {
		try {
			entity.setAno(FacesUtils.checkLong(ano));
			entity.setCantidadEntrada(FacesUtils.checkDouble(cantidadEntrada));
			entity.setCantidadSalidas(FacesUtils.checkDouble(cantidadSalidas));
			entity.setCostoEntradas(FacesUtils.checkDouble(costoEntradas));
			entity.setCostoSalidas(FacesUtils.checkDouble(costoSalidas));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setMaximoDistribucion(FacesUtils
					.checkDouble(maximoDistribucion));
			entity.setMaximoPedido(FacesUtils.checkDouble(maximoPedido));
			entity.setMes(FacesUtils.checkLong(mes));
			entity.setMinimoDistribucion(FacesUtils
					.checkDouble(minimoDistribucion));
			entity.setMinimoPedido(FacesUtils.checkDouble(minimoPedido));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateStockInventarioMensual(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("StockInventarioMensualView").requestRender();
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

	public InputText getTxtCantidadEntrada() {
		return txtCantidadEntrada;
	}

	public void setTxtCantidadEntrada(InputText txtCantidadEntrada) {
		this.txtCantidadEntrada = txtCantidadEntrada;
	}

	public InputText getTxtCantidadSalidas() {
		return txtCantidadSalidas;
	}

	public void setTxtCantidadSalidas(InputText txtCantidadSalidas) {
		this.txtCantidadSalidas = txtCantidadSalidas;
	}

	public InputText getTxtCostoEntradas() {
		return txtCostoEntradas;
	}

	public void setTxtCostoEntradas(InputText txtCostoEntradas) {
		this.txtCostoEntradas = txtCostoEntradas;
	}

	public InputText getTxtCostoSalidas() {
		return txtCostoSalidas;
	}

	public void setTxtCostoSalidas(InputText txtCostoSalidas) {
		this.txtCostoSalidas = txtCostoSalidas;
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}

	public InputText getTxtMaximoDistribucion() {
		return txtMaximoDistribucion;
	}

	public void setTxtMaximoDistribucion(InputText txtMaximoDistribucion) {
		this.txtMaximoDistribucion = txtMaximoDistribucion;
	}

	public InputText getTxtMaximoPedido() {
		return txtMaximoPedido;
	}

	public void setTxtMaximoPedido(InputText txtMaximoPedido) {
		this.txtMaximoPedido = txtMaximoPedido;
	}

	public InputText getTxtMes() {
		return txtMes;
	}

	public void setTxtMes(InputText txtMes) {
		this.txtMes = txtMes;
	}

	public InputText getTxtMinimoDistribucion() {
		return txtMinimoDistribucion;
	}

	public void setTxtMinimoDistribucion(InputText txtMinimoDistribucion) {
		this.txtMinimoDistribucion = txtMinimoDistribucion;
	}

	public InputText getTxtMinimoPedido() {
		return txtMinimoPedido;
	}

	public void setTxtMinimoPedido(InputText txtMinimoPedido) {
		this.txtMinimoPedido = txtMinimoPedido;
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

	public InputText getTxtIdSini_SaldoInicialInventario() {
		return txtIdSini_SaldoInicialInventario;
	}

	public void setTxtIdSini_SaldoInicialInventario(
			InputText txtIdSini_SaldoInicialInventario) {
		this.txtIdSini_SaldoInicialInventario = txtIdSini_SaldoInicialInventario;
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

	public InputText getTxtIdStin() {
		return txtIdStin;
	}

	public void setTxtIdStin(InputText txtIdStin) {
		this.txtIdStin = txtIdStin;
	}

	public List<StockInventarioMensualDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataStockInventarioMensual();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(
			List<StockInventarioMensualDTO> stockInventarioMensualDTO) {
		this.data = stockInventarioMensualDTO;
	}

	public StockInventarioMensualDTO getSelectedStockInventarioMensual() {
		return selectedStockInventarioMensual;
	}

	public void setSelectedStockInventarioMensual(
			StockInventarioMensualDTO stockInventarioMensual) {
		this.selectedStockInventarioMensual = stockInventarioMensual;
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
