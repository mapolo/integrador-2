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
import co.edu.usbcali.modelo.Cartera;
import co.edu.usbcali.modelo.dto.CarteraDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class CarteraView {
	private InputText txtEstadoRegistro;
	private InputText txtInteres;
	private InputText txtNumeroCuotas;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtSaldo;
	private InputText txtValorBase;
	private InputText txtValorTotal;
	private InputText txtIdDocu_Documento;
	private InputText txtIdGrpo_Grupo;
	private InputText txtIdCart;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaPago;
	private Calendar txtFechaVencimiento;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<CarteraDTO> data;
	private CarteraDTO selectedCartera;
	private Cartera entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public CarteraView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			CarteraDTO carteraDTO = (CarteraDTO) e.getObject();

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(carteraDTO.getEstadoRegistro());

			if (txtInteres == null) {
				txtInteres = new InputText();
			}

			txtInteres.setValue(carteraDTO.getInteres());

			if (txtNumeroCuotas == null) {
				txtNumeroCuotas = new InputText();
			}

			txtNumeroCuotas.setValue(carteraDTO.getNumeroCuotas());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(carteraDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(carteraDTO.getOperModifica());

			if (txtSaldo == null) {
				txtSaldo = new InputText();
			}

			txtSaldo.setValue(carteraDTO.getSaldo());

			if (txtValorBase == null) {
				txtValorBase = new InputText();
			}

			txtValorBase.setValue(carteraDTO.getValorBase());

			if (txtValorTotal == null) {
				txtValorTotal = new InputText();
			}

			txtValorTotal.setValue(carteraDTO.getValorTotal());

			if (txtIdDocu_Documento == null) {
				txtIdDocu_Documento = new InputText();
			}

			txtIdDocu_Documento.setValue(carteraDTO.getIdDocu_Documento());

			if (txtIdGrpo_Grupo == null) {
				txtIdGrpo_Grupo = new InputText();
			}

			txtIdGrpo_Grupo.setValue(carteraDTO.getIdGrpo_Grupo());

			if (txtIdCart == null) {
				txtIdCart = new InputText();
			}

			txtIdCart.setValue(carteraDTO.getIdCart());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(carteraDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(carteraDTO.getFechaModificacion());

			if (txtFechaPago == null) {
				txtFechaPago = new Calendar();
			}

			txtFechaPago.setValue(carteraDTO.getFechaPago());

			if (txtFechaVencimiento == null) {
				txtFechaVencimiento = new Calendar();
			}

			txtFechaVencimiento.setValue(carteraDTO.getFechaVencimiento());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedCartera = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedCartera = null;

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtInteres != null) {
			txtInteres.setValue(null);
			txtInteres.setDisabled(true);
		}

		if (txtNumeroCuotas != null) {
			txtNumeroCuotas.setValue(null);
			txtNumeroCuotas.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtSaldo != null) {
			txtSaldo.setValue(null);
			txtSaldo.setDisabled(true);
		}

		if (txtValorBase != null) {
			txtValorBase.setValue(null);
			txtValorBase.setDisabled(true);
		}

		if (txtValorTotal != null) {
			txtValorTotal.setValue(null);
			txtValorTotal.setDisabled(true);
		}

		if (txtIdDocu_Documento != null) {
			txtIdDocu_Documento.setValue(null);
			txtIdDocu_Documento.setDisabled(true);
		}

		if (txtIdGrpo_Grupo != null) {
			txtIdGrpo_Grupo.setValue(null);
			txtIdGrpo_Grupo.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtFechaPago != null) {
			txtFechaPago.setValue(null);
			txtFechaPago.setDisabled(true);
		}

		if (txtFechaVencimiento != null) {
			txtFechaVencimiento.setValue(null);
			txtFechaVencimiento.setDisabled(true);
		}

		if (txtIdCart != null) {
			txtIdCart.setValue(null);
			txtIdCart.setDisabled(false);
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

	public void listener_txtFechaPago() {
		Date inputDate = (Date) txtFechaPago.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaVencimiento() {
		Date inputDate = (Date) txtFechaVencimiento.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Long idCart = new Long(txtIdCart.getValue().toString());
			entity = businessDelegatorView.getCartera(idCart);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEstadoRegistro.setDisabled(false);
			txtInteres.setDisabled(false);
			txtNumeroCuotas.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtSaldo.setDisabled(false);
			txtValorBase.setDisabled(false);
			txtValorTotal.setDisabled(false);
			txtIdDocu_Documento.setDisabled(false);
			txtIdGrpo_Grupo.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtFechaPago.setDisabled(false);
			txtFechaVencimiento.setDisabled(false);
			txtIdCart.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtFechaPago.setValue(entity.getFechaPago());
			txtFechaPago.setDisabled(false);
			txtFechaVencimiento.setValue(entity.getFechaVencimiento());
			txtFechaVencimiento.setDisabled(false);
			txtInteres.setValue(entity.getInteres());
			txtInteres.setDisabled(false);
			txtNumeroCuotas.setValue(entity.getNumeroCuotas());
			txtNumeroCuotas.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtSaldo.setValue(entity.getSaldo());
			txtSaldo.setDisabled(false);
			txtValorBase.setValue(entity.getValorBase());
			txtValorBase.setDisabled(false);
			txtValorTotal.setValue(entity.getValorTotal());
			txtValorTotal.setDisabled(false);
			txtIdDocu_Documento.setValue(entity.getDocumento().getIdDocu());
			txtIdDocu_Documento.setDisabled(false);
			txtIdGrpo_Grupo.setValue(entity.getGrupo().getIdGrpo());
			txtIdGrpo_Grupo.setDisabled(false);
			txtIdCart.setValue(entity.getIdCart());
			txtIdCart.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedCartera = (CarteraDTO) (evt.getComponent().getAttributes()
				.get("selectedCartera"));
		txtEstadoRegistro.setValue(selectedCartera.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedCartera.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedCartera.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtFechaPago.setValue(selectedCartera.getFechaPago());
		txtFechaPago.setDisabled(false);
		txtFechaVencimiento.setValue(selectedCartera.getFechaVencimiento());
		txtFechaVencimiento.setDisabled(false);
		txtInteres.setValue(selectedCartera.getInteres());
		txtInteres.setDisabled(false);
		txtNumeroCuotas.setValue(selectedCartera.getNumeroCuotas());
		txtNumeroCuotas.setDisabled(false);
		txtOperCreador.setValue(selectedCartera.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedCartera.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtSaldo.setValue(selectedCartera.getSaldo());
		txtSaldo.setDisabled(false);
		txtValorBase.setValue(selectedCartera.getValorBase());
		txtValorBase.setDisabled(false);
		txtValorTotal.setValue(selectedCartera.getValorTotal());
		txtValorTotal.setDisabled(false);
		txtIdDocu_Documento.setValue(selectedCartera.getIdDocu_Documento());
		txtIdDocu_Documento.setDisabled(false);
		txtIdGrpo_Grupo.setValue(selectedCartera.getIdGrpo_Grupo());
		txtIdGrpo_Grupo.setDisabled(false);
		txtIdCart.setValue(selectedCartera.getIdCart());
		txtIdCart.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedCartera == null) && (entity == null)) {
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
			entity = new Cartera();

			Long idCart = new Long(txtIdCart.getValue().toString());

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaPago(FacesUtils.checkDate(txtFechaPago));
			entity.setFechaVencimiento(FacesUtils
					.checkDate(txtFechaVencimiento));
			entity.setIdCart(idCart);
			entity.setInteres(FacesUtils.checkDouble(txtInteres));
			entity.setNumeroCuotas(FacesUtils.checkLong(txtNumeroCuotas));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setSaldo(FacesUtils.checkDouble(txtSaldo));
			entity.setValorBase(FacesUtils.checkDouble(txtValorBase));
			entity.setValorTotal(FacesUtils.checkDouble(txtValorTotal));
			entity.setDocumento(businessDelegatorView.getDocumento(FacesUtils
					.checkLong(txtIdDocu_Documento)));
			entity.setGrupo(businessDelegatorView.getGrupo(FacesUtils
					.checkLong(txtIdGrpo_Grupo)));
			businessDelegatorView.saveCartera(entity);
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
				Long idCart = new Long(selectedCartera.getIdCart());
				entity = businessDelegatorView.getCartera(idCart);
			}

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaPago(FacesUtils.checkDate(txtFechaPago));
			entity.setFechaVencimiento(FacesUtils
					.checkDate(txtFechaVencimiento));
			entity.setInteres(FacesUtils.checkDouble(txtInteres));
			entity.setNumeroCuotas(FacesUtils.checkLong(txtNumeroCuotas));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setSaldo(FacesUtils.checkDouble(txtSaldo));
			entity.setValorBase(FacesUtils.checkDouble(txtValorBase));
			entity.setValorTotal(FacesUtils.checkDouble(txtValorTotal));
			entity.setDocumento(businessDelegatorView.getDocumento(FacesUtils
					.checkLong(txtIdDocu_Documento)));
			entity.setGrupo(businessDelegatorView.getGrupo(FacesUtils
					.checkLong(txtIdGrpo_Grupo)));
			businessDelegatorView.updateCartera(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedCartera = (CarteraDTO) (evt.getComponent().getAttributes()
					.get("selectedCartera"));

			Long idCart = new Long(selectedCartera.getIdCart());
			entity = businessDelegatorView.getCartera(idCart);
			businessDelegatorView.deleteCartera(entity);
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
			selectedCartera = (CarteraDTO) (evt.getComponent().getAttributes()
					.get("selectedCartera"));

			Long idCart = new Long(selectedCartera.getIdCart());
			entity = businessDelegatorView.getCartera(idCart);
			businessDelegatorView.deleteCartera(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedCartera);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Date fechaPago,
			Date fechaVencimiento, Long idCart, Double interes,
			Long numeroCuotas, String operCreador, String operModifica,
			Double saldo, Double valorBase, Double valorTotal,
			Long idDocu_Documento, Long idGrpo_Grupo) throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaPago(FacesUtils.checkDate(fechaPago));
			entity.setFechaVencimiento(FacesUtils.checkDate(fechaVencimiento));
			entity.setInteres(FacesUtils.checkDouble(interes));
			entity.setNumeroCuotas(FacesUtils.checkLong(numeroCuotas));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setSaldo(FacesUtils.checkDouble(saldo));
			entity.setValorBase(FacesUtils.checkDouble(valorBase));
			entity.setValorTotal(FacesUtils.checkDouble(valorTotal));
			businessDelegatorView.updateCartera(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("CarteraView").requestRender();
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

	public InputText getTxtInteres() {
		return txtInteres;
	}

	public void setTxtInteres(InputText txtInteres) {
		this.txtInteres = txtInteres;
	}

	public InputText getTxtNumeroCuotas() {
		return txtNumeroCuotas;
	}

	public void setTxtNumeroCuotas(InputText txtNumeroCuotas) {
		this.txtNumeroCuotas = txtNumeroCuotas;
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

	public InputText getTxtSaldo() {
		return txtSaldo;
	}

	public void setTxtSaldo(InputText txtSaldo) {
		this.txtSaldo = txtSaldo;
	}

	public InputText getTxtValorBase() {
		return txtValorBase;
	}

	public void setTxtValorBase(InputText txtValorBase) {
		this.txtValorBase = txtValorBase;
	}

	public InputText getTxtValorTotal() {
		return txtValorTotal;
	}

	public void setTxtValorTotal(InputText txtValorTotal) {
		this.txtValorTotal = txtValorTotal;
	}

	public InputText getTxtIdDocu_Documento() {
		return txtIdDocu_Documento;
	}

	public void setTxtIdDocu_Documento(InputText txtIdDocu_Documento) {
		this.txtIdDocu_Documento = txtIdDocu_Documento;
	}

	public InputText getTxtIdGrpo_Grupo() {
		return txtIdGrpo_Grupo;
	}

	public void setTxtIdGrpo_Grupo(InputText txtIdGrpo_Grupo) {
		this.txtIdGrpo_Grupo = txtIdGrpo_Grupo;
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

	public Calendar getTxtFechaPago() {
		return txtFechaPago;
	}

	public void setTxtFechaPago(Calendar txtFechaPago) {
		this.txtFechaPago = txtFechaPago;
	}

	public Calendar getTxtFechaVencimiento() {
		return txtFechaVencimiento;
	}

	public void setTxtFechaVencimiento(Calendar txtFechaVencimiento) {
		this.txtFechaVencimiento = txtFechaVencimiento;
	}

	public InputText getTxtIdCart() {
		return txtIdCart;
	}

	public void setTxtIdCart(InputText txtIdCart) {
		this.txtIdCart = txtIdCart;
	}

	public List<CarteraDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataCartera();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<CarteraDTO> carteraDTO) {
		this.data = carteraDTO;
	}

	public CarteraDTO getSelectedCartera() {
		return selectedCartera;
	}

	public void setSelectedCartera(CarteraDTO cartera) {
		this.selectedCartera = cartera;
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
