package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.OrdenesDeCompraDTO;
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
public class OrdenesDeCompraView {
	private InputText txtCantidadPedida;
	private InputText txtCantidadRecibido;
	private InputText txtEstadoRegistro;
	private InputText txtIva;
	private InputText txtNumeroFactura;
	private InputText txtNumeroPedido;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtPorcentajeDescuento;
	private InputText txtPrecioUnitarioPedido;
	private InputText txtPrecioUnitarioRecibdo;
	private InputText txtIdDocu_Documento;
	private InputText txtIdEmpr_Empresa;
	private InputText txtIdPers_Persona;
	private InputText txtIdRefe_Referencia;
	private InputText txtIdSucu_Sucursal;
	private InputText txtIdOrdc;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaEntrega;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaPedido;
	private Calendar txtFechaRecibido;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<OrdenesDeCompraDTO> data;
	private OrdenesDeCompraDTO selectedOrdenesDeCompra;
	private OrdenesDeCompra entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public OrdenesDeCompraView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			OrdenesDeCompraDTO ordenesDeCompraDTO = (OrdenesDeCompraDTO) e
					.getObject();

			if (txtCantidadPedida == null) {
				txtCantidadPedida = new InputText();
			}

			txtCantidadPedida.setValue(ordenesDeCompraDTO.getCantidadPedida());

			if (txtCantidadRecibido == null) {
				txtCantidadRecibido = new InputText();
			}

			txtCantidadRecibido.setValue(ordenesDeCompraDTO
					.getCantidadRecibido());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(ordenesDeCompraDTO.getEstadoRegistro());

			if (txtIva == null) {
				txtIva = new InputText();
			}

			txtIva.setValue(ordenesDeCompraDTO.getIva());

			if (txtNumeroFactura == null) {
				txtNumeroFactura = new InputText();
			}

			txtNumeroFactura.setValue(ordenesDeCompraDTO.getNumeroFactura());

			if (txtNumeroPedido == null) {
				txtNumeroPedido = new InputText();
			}

			txtNumeroPedido.setValue(ordenesDeCompraDTO.getNumeroPedido());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(ordenesDeCompraDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(ordenesDeCompraDTO.getOperModifica());

			if (txtPorcentajeDescuento == null) {
				txtPorcentajeDescuento = new InputText();
			}

			txtPorcentajeDescuento.setValue(ordenesDeCompraDTO
					.getPorcentajeDescuento());

			if (txtPrecioUnitarioPedido == null) {
				txtPrecioUnitarioPedido = new InputText();
			}

			txtPrecioUnitarioPedido.setValue(ordenesDeCompraDTO
					.getPrecioUnitarioPedido());

			if (txtPrecioUnitarioRecibdo == null) {
				txtPrecioUnitarioRecibdo = new InputText();
			}

			txtPrecioUnitarioRecibdo.setValue(ordenesDeCompraDTO
					.getPrecioUnitarioRecibdo());

			if (txtIdDocu_Documento == null) {
				txtIdDocu_Documento = new InputText();
			}

			txtIdDocu_Documento.setValue(ordenesDeCompraDTO
					.getIdDocu_Documento());

			if (txtIdEmpr_Empresa == null) {
				txtIdEmpr_Empresa = new InputText();
			}

			txtIdEmpr_Empresa.setValue(ordenesDeCompraDTO.getIdEmpr_Empresa());

			if (txtIdPers_Persona == null) {
				txtIdPers_Persona = new InputText();
			}

			txtIdPers_Persona.setValue(ordenesDeCompraDTO.getIdPers_Persona());

			if (txtIdRefe_Referencia == null) {
				txtIdRefe_Referencia = new InputText();
			}

			txtIdRefe_Referencia.setValue(ordenesDeCompraDTO
					.getIdRefe_Referencia());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new InputText();
			}

			txtIdSucu_Sucursal
					.setValue(ordenesDeCompraDTO.getIdSucu_Sucursal());

			if (txtIdOrdc == null) {
				txtIdOrdc = new InputText();
			}

			txtIdOrdc.setValue(ordenesDeCompraDTO.getIdOrdc());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(ordenesDeCompraDTO.getFechaCreacion());

			if (txtFechaEntrega == null) {
				txtFechaEntrega = new Calendar();
			}

			txtFechaEntrega.setValue(ordenesDeCompraDTO.getFechaEntrega());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(ordenesDeCompraDTO
					.getFechaModificacion());

			if (txtFechaPedido == null) {
				txtFechaPedido = new Calendar();
			}

			txtFechaPedido.setValue(ordenesDeCompraDTO.getFechaPedido());

			if (txtFechaRecibido == null) {
				txtFechaRecibido = new Calendar();
			}

			txtFechaRecibido.setValue(ordenesDeCompraDTO.getFechaRecibido());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedOrdenesDeCompra = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedOrdenesDeCompra = null;

		if (txtCantidadPedida != null) {
			txtCantidadPedida.setValue(null);
			txtCantidadPedida.setDisabled(true);
		}

		if (txtCantidadRecibido != null) {
			txtCantidadRecibido.setValue(null);
			txtCantidadRecibido.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtIva != null) {
			txtIva.setValue(null);
			txtIva.setDisabled(true);
		}

		if (txtNumeroFactura != null) {
			txtNumeroFactura.setValue(null);
			txtNumeroFactura.setDisabled(true);
		}

		if (txtNumeroPedido != null) {
			txtNumeroPedido.setValue(null);
			txtNumeroPedido.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtPorcentajeDescuento != null) {
			txtPorcentajeDescuento.setValue(null);
			txtPorcentajeDescuento.setDisabled(true);
		}

		if (txtPrecioUnitarioPedido != null) {
			txtPrecioUnitarioPedido.setValue(null);
			txtPrecioUnitarioPedido.setDisabled(true);
		}

		if (txtPrecioUnitarioRecibdo != null) {
			txtPrecioUnitarioRecibdo.setValue(null);
			txtPrecioUnitarioRecibdo.setDisabled(true);
		}

		if (txtIdDocu_Documento != null) {
			txtIdDocu_Documento.setValue(null);
			txtIdDocu_Documento.setDisabled(true);
		}

		if (txtIdEmpr_Empresa != null) {
			txtIdEmpr_Empresa.setValue(null);
			txtIdEmpr_Empresa.setDisabled(true);
		}

		if (txtIdPers_Persona != null) {
			txtIdPers_Persona.setValue(null);
			txtIdPers_Persona.setDisabled(true);
		}

		if (txtIdRefe_Referencia != null) {
			txtIdRefe_Referencia.setValue(null);
			txtIdRefe_Referencia.setDisabled(true);
		}

		if (txtIdSucu_Sucursal != null) {
			txtIdSucu_Sucursal.setValue(null);
			txtIdSucu_Sucursal.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaEntrega != null) {
			txtFechaEntrega.setValue(null);
			txtFechaEntrega.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtFechaPedido != null) {
			txtFechaPedido.setValue(null);
			txtFechaPedido.setDisabled(true);
		}

		if (txtFechaRecibido != null) {
			txtFechaRecibido.setValue(null);
			txtFechaRecibido.setDisabled(true);
		}

		if (txtIdOrdc != null) {
			txtIdOrdc.setValue(null);
			txtIdOrdc.setDisabled(false);
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

	public void listener_txtFechaEntrega() {
		Date inputDate = (Date) txtFechaEntrega.getValue();
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

	public void listener_txtFechaPedido() {
		Date inputDate = (Date) txtFechaPedido.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaRecibido() {
		Date inputDate = (Date) txtFechaRecibido.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Long idOrdc = new Long(txtIdOrdc.getValue().toString());
			entity = businessDelegatorView.getOrdenesDeCompra(idOrdc);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtCantidadPedida.setDisabled(false);
			txtCantidadRecibido.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtIva.setDisabled(false);
			txtNumeroFactura.setDisabled(false);
			txtNumeroPedido.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtPorcentajeDescuento.setDisabled(false);
			txtPrecioUnitarioPedido.setDisabled(false);
			txtPrecioUnitarioRecibdo.setDisabled(false);
			txtIdDocu_Documento.setDisabled(false);
			txtIdEmpr_Empresa.setDisabled(false);
			txtIdPers_Persona.setDisabled(false);
			txtIdRefe_Referencia.setDisabled(false);
			txtIdSucu_Sucursal.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaEntrega.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtFechaPedido.setDisabled(false);
			txtFechaRecibido.setDisabled(false);
			txtIdOrdc.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCantidadPedida.setValue(entity.getCantidadPedida());
			txtCantidadPedida.setDisabled(false);
			txtCantidadRecibido.setValue(entity.getCantidadRecibido());
			txtCantidadRecibido.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaEntrega.setValue(entity.getFechaEntrega());
			txtFechaEntrega.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtFechaPedido.setValue(entity.getFechaPedido());
			txtFechaPedido.setDisabled(false);
			txtFechaRecibido.setValue(entity.getFechaRecibido());
			txtFechaRecibido.setDisabled(false);
			txtIva.setValue(entity.getIva());
			txtIva.setDisabled(false);
			txtNumeroFactura.setValue(entity.getNumeroFactura());
			txtNumeroFactura.setDisabled(false);
			txtNumeroPedido.setValue(entity.getNumeroPedido());
			txtNumeroPedido.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtPorcentajeDescuento.setValue(entity.getPorcentajeDescuento());
			txtPorcentajeDescuento.setDisabled(false);
			txtPrecioUnitarioPedido.setValue(entity.getPrecioUnitarioPedido());
			txtPrecioUnitarioPedido.setDisabled(false);
			txtPrecioUnitarioRecibdo
					.setValue(entity.getPrecioUnitarioRecibdo());
			txtPrecioUnitarioRecibdo.setDisabled(false);
			txtIdDocu_Documento.setValue(entity.getDocumento().getIdDocu());
			txtIdDocu_Documento.setDisabled(false);
			txtIdEmpr_Empresa.setValue(entity.getEmpresa().getIdEmpr());
			txtIdEmpr_Empresa.setDisabled(false);
			txtIdPers_Persona.setValue(entity.getPersona().getIdPers());
			txtIdPers_Persona.setDisabled(false);
			txtIdRefe_Referencia.setValue(entity.getReferencia().getIdRefe());
			txtIdRefe_Referencia.setDisabled(false);
			txtIdSucu_Sucursal.setValue(entity.getSucursal().getIdSucu());
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdOrdc.setValue(entity.getIdOrdc());
			txtIdOrdc.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedOrdenesDeCompra = (OrdenesDeCompraDTO) (evt.getComponent()
				.getAttributes().get("selectedOrdenesDeCompra"));
		txtCantidadPedida.setValue(selectedOrdenesDeCompra.getCantidadPedida());
		txtCantidadPedida.setDisabled(false);
		txtCantidadRecibido.setValue(selectedOrdenesDeCompra
				.getCantidadRecibido());
		txtCantidadRecibido.setDisabled(false);
		txtEstadoRegistro.setValue(selectedOrdenesDeCompra.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedOrdenesDeCompra.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaEntrega.setValue(selectedOrdenesDeCompra.getFechaEntrega());
		txtFechaEntrega.setDisabled(false);
		txtFechaModificacion.setValue(selectedOrdenesDeCompra
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtFechaPedido.setValue(selectedOrdenesDeCompra.getFechaPedido());
		txtFechaPedido.setDisabled(false);
		txtFechaRecibido.setValue(selectedOrdenesDeCompra.getFechaRecibido());
		txtFechaRecibido.setDisabled(false);
		txtIva.setValue(selectedOrdenesDeCompra.getIva());
		txtIva.setDisabled(false);
		txtNumeroFactura.setValue(selectedOrdenesDeCompra.getNumeroFactura());
		txtNumeroFactura.setDisabled(false);
		txtNumeroPedido.setValue(selectedOrdenesDeCompra.getNumeroPedido());
		txtNumeroPedido.setDisabled(false);
		txtOperCreador.setValue(selectedOrdenesDeCompra.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedOrdenesDeCompra.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtPorcentajeDescuento.setValue(selectedOrdenesDeCompra
				.getPorcentajeDescuento());
		txtPorcentajeDescuento.setDisabled(false);
		txtPrecioUnitarioPedido.setValue(selectedOrdenesDeCompra
				.getPrecioUnitarioPedido());
		txtPrecioUnitarioPedido.setDisabled(false);
		txtPrecioUnitarioRecibdo.setValue(selectedOrdenesDeCompra
				.getPrecioUnitarioRecibdo());
		txtPrecioUnitarioRecibdo.setDisabled(false);
		txtIdDocu_Documento.setValue(selectedOrdenesDeCompra
				.getIdDocu_Documento());
		txtIdDocu_Documento.setDisabled(false);
		txtIdEmpr_Empresa.setValue(selectedOrdenesDeCompra.getIdEmpr_Empresa());
		txtIdEmpr_Empresa.setDisabled(false);
		txtIdPers_Persona.setValue(selectedOrdenesDeCompra.getIdPers_Persona());
		txtIdPers_Persona.setDisabled(false);
		txtIdRefe_Referencia.setValue(selectedOrdenesDeCompra
				.getIdRefe_Referencia());
		txtIdRefe_Referencia.setDisabled(false);
		txtIdSucu_Sucursal.setValue(selectedOrdenesDeCompra
				.getIdSucu_Sucursal());
		txtIdSucu_Sucursal.setDisabled(false);
		txtIdOrdc.setValue(selectedOrdenesDeCompra.getIdOrdc());
		txtIdOrdc.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedOrdenesDeCompra == null) && (entity == null)) {
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
			entity = new OrdenesDeCompra();

			Long idOrdc = new Long(txtIdOrdc.getValue().toString());

			entity.setCantidadPedida(FacesUtils.checkLong(txtCantidadPedida));
			entity.setCantidadRecibido(FacesUtils
					.checkLong(txtCantidadRecibido));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaEntrega(FacesUtils.checkDate(txtFechaEntrega));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaPedido(FacesUtils.checkDate(txtFechaPedido));
			entity.setFechaRecibido(FacesUtils.checkDate(txtFechaRecibido));
			entity.setIdOrdc(idOrdc);
			entity.setIva(FacesUtils.checkDouble(txtIva));
			entity.setNumeroFactura(FacesUtils.checkString(txtNumeroFactura));
			entity.setNumeroPedido(FacesUtils.checkLong(txtNumeroPedido));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setPorcentajeDescuento(FacesUtils
					.checkDouble(txtPorcentajeDescuento));
			entity.setPrecioUnitarioPedido(FacesUtils
					.checkDouble(txtPrecioUnitarioPedido));
			entity.setPrecioUnitarioRecibdo(FacesUtils
					.checkDouble(txtPrecioUnitarioRecibdo));
			entity.setDocumento(businessDelegatorView.getDocumento(FacesUtils
					.checkLong(txtIdDocu_Documento)));
			entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
					.checkLong(txtIdEmpr_Empresa)));
			entity.setPersona(businessDelegatorView.getPersona(FacesUtils
					.checkLong(txtIdPers_Persona)));
			entity.setReferencia(businessDelegatorView.getReferencia(FacesUtils
					.checkLong(txtIdRefe_Referencia)));
			entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			businessDelegatorView.saveOrdenesDeCompra(entity);
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
				Long idOrdc = new Long(selectedOrdenesDeCompra.getIdOrdc());
				entity = businessDelegatorView.getOrdenesDeCompra(idOrdc);
			}

			entity.setCantidadPedida(FacesUtils.checkLong(txtCantidadPedida));
			entity.setCantidadRecibido(FacesUtils
					.checkLong(txtCantidadRecibido));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaEntrega(FacesUtils.checkDate(txtFechaEntrega));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaPedido(FacesUtils.checkDate(txtFechaPedido));
			entity.setFechaRecibido(FacesUtils.checkDate(txtFechaRecibido));
			entity.setIva(FacesUtils.checkDouble(txtIva));
			entity.setNumeroFactura(FacesUtils.checkString(txtNumeroFactura));
			entity.setNumeroPedido(FacesUtils.checkLong(txtNumeroPedido));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setPorcentajeDescuento(FacesUtils
					.checkDouble(txtPorcentajeDescuento));
			entity.setPrecioUnitarioPedido(FacesUtils
					.checkDouble(txtPrecioUnitarioPedido));
			entity.setPrecioUnitarioRecibdo(FacesUtils
					.checkDouble(txtPrecioUnitarioRecibdo));
			entity.setDocumento(businessDelegatorView.getDocumento(FacesUtils
					.checkLong(txtIdDocu_Documento)));
			entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
					.checkLong(txtIdEmpr_Empresa)));
			entity.setPersona(businessDelegatorView.getPersona(FacesUtils
					.checkLong(txtIdPers_Persona)));
			entity.setReferencia(businessDelegatorView.getReferencia(FacesUtils
					.checkLong(txtIdRefe_Referencia)));
			entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			businessDelegatorView.updateOrdenesDeCompra(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedOrdenesDeCompra = (OrdenesDeCompraDTO) (evt.getComponent()
					.getAttributes().get("selectedOrdenesDeCompra"));

			Long idOrdc = new Long(selectedOrdenesDeCompra.getIdOrdc());
			entity = businessDelegatorView.getOrdenesDeCompra(idOrdc);
			businessDelegatorView.deleteOrdenesDeCompra(entity);
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
			selectedOrdenesDeCompra = (OrdenesDeCompraDTO) (evt.getComponent()
					.getAttributes().get("selectedOrdenesDeCompra"));

			Long idOrdc = new Long(selectedOrdenesDeCompra.getIdOrdc());
			entity = businessDelegatorView.getOrdenesDeCompra(idOrdc);
			businessDelegatorView.deleteOrdenesDeCompra(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedOrdenesDeCompra);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long cantidadPedida,
			Long cantidadRecibido, String estadoRegistro, Date fechaCreacion,
			Date fechaEntrega, Date fechaModificacion, Date fechaPedido,
			Date fechaRecibido, Long idOrdc, Double iva, String numeroFactura,
			Long numeroPedido, String operCreador, String operModifica,
			Double porcentajeDescuento, Double precioUnitarioPedido,
			Double precioUnitarioRecibdo, Long idDocu_Documento,
			Long idEmpr_Empresa, Long idPers_Persona, Long idRefe_Referencia,
			Long idSucu_Sucursal) throws Exception {
		try {
			entity.setCantidadPedida(FacesUtils.checkLong(cantidadPedida));
			entity.setCantidadRecibido(FacesUtils.checkLong(cantidadRecibido));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaEntrega(FacesUtils.checkDate(fechaEntrega));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaPedido(FacesUtils.checkDate(fechaPedido));
			entity.setFechaRecibido(FacesUtils.checkDate(fechaRecibido));
			entity.setIva(FacesUtils.checkDouble(iva));
			entity.setNumeroFactura(FacesUtils.checkString(numeroFactura));
			entity.setNumeroPedido(FacesUtils.checkLong(numeroPedido));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setPorcentajeDescuento(FacesUtils
					.checkDouble(porcentajeDescuento));
			entity.setPrecioUnitarioPedido(FacesUtils
					.checkDouble(precioUnitarioPedido));
			entity.setPrecioUnitarioRecibdo(FacesUtils
					.checkDouble(precioUnitarioRecibdo));
			businessDelegatorView.updateOrdenesDeCompra(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("OrdenesDeCompraView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCantidadPedida() {
		return txtCantidadPedida;
	}

	public void setTxtCantidadPedida(InputText txtCantidadPedida) {
		this.txtCantidadPedida = txtCantidadPedida;
	}

	public InputText getTxtCantidadRecibido() {
		return txtCantidadRecibido;
	}

	public void setTxtCantidadRecibido(InputText txtCantidadRecibido) {
		this.txtCantidadRecibido = txtCantidadRecibido;
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}

	public InputText getTxtIva() {
		return txtIva;
	}

	public void setTxtIva(InputText txtIva) {
		this.txtIva = txtIva;
	}

	public InputText getTxtNumeroFactura() {
		return txtNumeroFactura;
	}

	public void setTxtNumeroFactura(InputText txtNumeroFactura) {
		this.txtNumeroFactura = txtNumeroFactura;
	}

	public InputText getTxtNumeroPedido() {
		return txtNumeroPedido;
	}

	public void setTxtNumeroPedido(InputText txtNumeroPedido) {
		this.txtNumeroPedido = txtNumeroPedido;
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

	public InputText getTxtPorcentajeDescuento() {
		return txtPorcentajeDescuento;
	}

	public void setTxtPorcentajeDescuento(InputText txtPorcentajeDescuento) {
		this.txtPorcentajeDescuento = txtPorcentajeDescuento;
	}

	public InputText getTxtPrecioUnitarioPedido() {
		return txtPrecioUnitarioPedido;
	}

	public void setTxtPrecioUnitarioPedido(InputText txtPrecioUnitarioPedido) {
		this.txtPrecioUnitarioPedido = txtPrecioUnitarioPedido;
	}

	public InputText getTxtPrecioUnitarioRecibdo() {
		return txtPrecioUnitarioRecibdo;
	}

	public void setTxtPrecioUnitarioRecibdo(InputText txtPrecioUnitarioRecibdo) {
		this.txtPrecioUnitarioRecibdo = txtPrecioUnitarioRecibdo;
	}

	public InputText getTxtIdDocu_Documento() {
		return txtIdDocu_Documento;
	}

	public void setTxtIdDocu_Documento(InputText txtIdDocu_Documento) {
		this.txtIdDocu_Documento = txtIdDocu_Documento;
	}

	public InputText getTxtIdEmpr_Empresa() {
		return txtIdEmpr_Empresa;
	}

	public void setTxtIdEmpr_Empresa(InputText txtIdEmpr_Empresa) {
		this.txtIdEmpr_Empresa = txtIdEmpr_Empresa;
	}

	public InputText getTxtIdPers_Persona() {
		return txtIdPers_Persona;
	}

	public void setTxtIdPers_Persona(InputText txtIdPers_Persona) {
		this.txtIdPers_Persona = txtIdPers_Persona;
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

	public Calendar getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaEntrega() {
		return txtFechaEntrega;
	}

	public void setTxtFechaEntrega(Calendar txtFechaEntrega) {
		this.txtFechaEntrega = txtFechaEntrega;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public Calendar getTxtFechaPedido() {
		return txtFechaPedido;
	}

	public void setTxtFechaPedido(Calendar txtFechaPedido) {
		this.txtFechaPedido = txtFechaPedido;
	}

	public Calendar getTxtFechaRecibido() {
		return txtFechaRecibido;
	}

	public void setTxtFechaRecibido(Calendar txtFechaRecibido) {
		this.txtFechaRecibido = txtFechaRecibido;
	}

	public InputText getTxtIdOrdc() {
		return txtIdOrdc;
	}

	public void setTxtIdOrdc(InputText txtIdOrdc) {
		this.txtIdOrdc = txtIdOrdc;
	}

	public List<OrdenesDeCompraDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataOrdenesDeCompra();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<OrdenesDeCompraDTO> ordenesDeCompraDTO) {
		this.data = ordenesDeCompraDTO;
	}

	public OrdenesDeCompraDTO getSelectedOrdenesDeCompra() {
		return selectedOrdenesDeCompra;
	}

	public void setSelectedOrdenesDeCompra(OrdenesDeCompraDTO ordenesDeCompra) {
		this.selectedOrdenesDeCompra = ordenesDeCompra;
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
