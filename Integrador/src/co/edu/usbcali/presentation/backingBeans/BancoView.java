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
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.Banco;
import co.edu.usbcali.modelo.dto.BancoDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class BancoView {
	private InputText txtCodigo;
	private SelectOneMenu txtConfirmaCheque;
	private SelectOneMenu txtConsigna;
	private InputText txtCuentaBanco;
	private InputText txtCuentaDescuento;
	private InputTextarea txtDescripcion;
	private SelectOneMenu txtEstadoRegistro;
	private SelectOneMenu txtImportaPda;
	private SelectOneMenu txtManejaBeneficiario;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdBanc;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;

	private String codigo;
	private String confirmaCheque;
	private String consigna;
	private String cuentaBanco;
	private String cuentaDescuento;
	private String descripcion;
	private String estadoRegistro;
	private String importaPda;
	private String manejaBeneficiario;
	private String operCreador;
	private String operModifica;
	private String idBanc;
	private String fechaCreacion;
	private String fechaModificacion;

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<BancoDTO> data;
	private BancoDTO selectedBanco;
	private Banco entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private SelectItem[] manufacturerOptions;
	private SelectItem[] manufacturerOptions2;

	String manufacturers[] = { "A", "R" };
	String manufacturers2[] = { "1", "0" };

	public BancoView() {
		super();
		setManufacturerOptions(createFilterOptions(manufacturers));
		setManufacturerOptions2(createFilterOptions(manufacturers2));
	}

	private SelectItem[] createFilterOptions(String[] data) {
		SelectItem[] options = new SelectItem[data.length + 1];

		options[0] = new SelectItem("", "Seleccionar");
		for (int i = 0; i < data.length; i++) {
			options[i + 1] = new SelectItem(data[i], data[i]);
		}

		return options;
	}

	public void onEdit(org.primefaces.event.RowEditEvent event) {

		try {

			entity = null;
			entity = businessDelegatorView.getBanco(((BancoDTO) event
					.getObject()).getIdBanc());

			codigo = ((BancoDTO) event.getObject()).getCodigo();
			entity.setCodigo(codigo);
			descripcion = ((BancoDTO) event.getObject()).getDescripcion();
			entity.setDescripcion(descripcion);
			Long consigna = new Long(txtConsigna.getValue().toString());
			entity.setConsigna(consigna);
			System.out.println("consigana:_" + consigna);

			Long confirmaCheque = new Long(txtConfirmaCheque.getValue()
					.toString());
			entity.setConfirmaCheque(confirmaCheque);
			Long manejaBeneficiario = new Long(txtManejaBeneficiario.getValue()
					.toString());
			entity.setManejaBeneficiario(manejaBeneficiario);
			Long importaPda = new Long(txtImportaPda.getValue().toString());
			entity.setImportaPda(importaPda);

			entity.setFechaModificacion(new Date());

			cuentaBanco = ((BancoDTO) event.getObject()).getCuentaBanco();
			entity.setCuentaBanco(cuentaBanco);
			cuentaDescuento = ((BancoDTO) event.getObject())
					.getCuentaDescuento();
			entity.setCuentaDescuento(cuentaDescuento);

			entity.setEstadoRegistro(estadoRegistro);

			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);

			businessDelegatorView.updateBanco(entity);
			data = businessDelegatorView.getDataBanco();
			RequestContext.getCurrentInstance().reset("form:b");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("TipoEstado Cancelled",
				((BancoDTO) event.getObject()).getIdBanc() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((BancoDTO) event.getObject()).getIdBanc());
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			BancoDTO bancoDTO = (BancoDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(bancoDTO.getCodigo());

			if (txtCuentaBanco == null) {
				txtCuentaBanco = new InputText();
			}

			txtCuentaBanco.setValue(bancoDTO.getCuentaBanco());

			if (txtCuentaDescuento == null) {
				txtCuentaDescuento = new InputText();
			}

			txtCuentaDescuento.setValue(bancoDTO.getCuentaDescuento());

			if (txtDescripcion == null) {
				txtDescripcion = new InputTextarea();
			}

			txtDescripcion.setValue(bancoDTO.getDescripcion());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(bancoDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(bancoDTO.getOperModifica());

			if (txtIdBanc == null) {
				txtIdBanc = new InputText();
			}

			txtIdBanc.setValue(bancoDTO.getIdBanc());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(bancoDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(bancoDTO.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedBanco = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedBanco = null;

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			// txtCodigo.setDisabled(true);
		}

		if (txtConfirmaCheque != null) {
			txtConfirmaCheque.setValue(null);
			// txtConfirmaCheque.setDisabled(true);
		}

		if (txtConsigna != null) {
			txtConsigna.setValue(null);
			// txtConsigna.setDisabled(true);
		}

		if (txtCuentaBanco != null) {
			txtCuentaBanco.setValue(null);
			// txtCuentaBanco.setDisabled(true);
		}

		if (txtCuentaDescuento != null) {
			txtCuentaDescuento.setValue(null);
			// txtCuentaDescuento.setDisabled(true);
		}

		if (txtDescripcion != null) {
			txtDescripcion.setValue(null);
			// txtDescripcion.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			// txtEstadoRegistro.setDisabled(true);
		}

		if (txtImportaPda != null) {
			txtImportaPda.setValue(null);
			// txtImportaPda.setDisabled(true);
		}

		if (txtManejaBeneficiario != null) {
			txtManejaBeneficiario.setValue(null);
			// txtManejaBeneficiario.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			// txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			// txtOperModifica.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			// txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			// txtFechaModificacion.setDisabled(true);
		}

		if (txtIdBanc != null) {
			txtIdBanc.setValue(null);
			// txtIdBanc.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
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
			Long idBanc = new Long(txtIdBanc.getValue().toString());
			entity = businessDelegatorView.getBanco(idBanc);
		} catch (Exception e) {

		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtConfirmaCheque.setDisabled(false);
			txtConsigna.setDisabled(false);
			txtCuentaBanco.setDisabled(false);
			txtCuentaDescuento.setDisabled(false);
			txtDescripcion.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtImportaPda.setDisabled(false);
			txtManejaBeneficiario.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdBanc.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtConfirmaCheque.setValue(entity.getConfirmaCheque());
			txtConfirmaCheque.setDisabled(false);
			txtConsigna.setValue(entity.getConsigna());
			txtConsigna.setDisabled(false);
			txtCuentaBanco.setValue(entity.getCuentaBanco());
			txtCuentaBanco.setDisabled(false);
			txtCuentaDescuento.setValue(entity.getCuentaDescuento());
			txtCuentaDescuento.setDisabled(false);
			txtDescripcion.setValue(entity.getDescripcion());
			txtDescripcion.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtImportaPda.setValue(entity.getImportaPda());
			txtImportaPda.setDisabled(false);
			txtManejaBeneficiario.setValue(entity.getManejaBeneficiario());
			txtManejaBeneficiario.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdBanc.setValue(entity.getIdBanc());
			txtIdBanc.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedBanco = (BancoDTO) (evt.getComponent().getAttributes()
				.get("selectedBanco"));
		txtCodigo.setValue(selectedBanco.getCodigo());
		txtCodigo.setDisabled(false);
		txtConfirmaCheque.setValue(selectedBanco.getConfirmaCheque());
		txtConfirmaCheque.setDisabled(false);
		txtConsigna.setValue(selectedBanco.getConsigna());
		txtConsigna.setDisabled(false);
		txtCuentaBanco.setValue(selectedBanco.getCuentaBanco());
		txtCuentaBanco.setDisabled(false);
		txtCuentaDescuento.setValue(selectedBanco.getCuentaDescuento());
		txtCuentaDescuento.setDisabled(false);
		txtDescripcion.setValue(selectedBanco.getDescripcion());
		txtDescripcion.setDisabled(false);
		txtEstadoRegistro.setValue(selectedBanco.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedBanco.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedBanco.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtImportaPda.setValue(selectedBanco.getImportaPda());
		txtImportaPda.setDisabled(false);
		txtManejaBeneficiario.setValue(selectedBanco.getManejaBeneficiario());
		txtManejaBeneficiario.setDisabled(false);
		txtOperCreador.setValue(selectedBanco.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedBanco.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdBanc.setValue(selectedBanco.getIdBanc());
		txtIdBanc.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedBanco == null) && (entity == null)) {
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
			entity = new Banco();

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			entity.setCuentaBanco(FacesUtils.checkString(txtCuentaBanco));
			entity.setCuentaDescuento(FacesUtils
					.checkString(txtCuentaDescuento));

			Long consigna = new Long(txtConsigna.getValue().toString());
			entity.setConsigna(consigna);
			Long confirmaCheque = new Long(txtConfirmaCheque.getValue()
					.toString());
			entity.setConfirmaCheque(confirmaCheque);
			Long manejaBeneficiario = new Long(txtManejaBeneficiario.getValue()
					.toString());
			entity.setManejaBeneficiario(manejaBeneficiario);
			Long importaPda = new Long(txtImportaPda.getValue().toString());
			entity.setImportaPda(importaPda);

			entity.setEstadoRegistro(estadoRegistro);
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);

			businessDelegatorView.saveBanco(entity);
			data = businessDelegatorView.getDataBanco();
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
				Long idBanc = new Long(selectedBanco.getIdBanc());
				entity = businessDelegatorView.getBanco(idBanc);
			}

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setConfirmaCheque(FacesUtils.checkLong(txtConfirmaCheque));
			entity.setConsigna(FacesUtils.checkLong(txtConsigna));
			entity.setCuentaBanco(FacesUtils.checkString(txtCuentaBanco));
			entity.setCuentaDescuento(FacesUtils
					.checkString(txtCuentaDescuento));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setImportaPda(FacesUtils.checkLong(txtImportaPda));
			entity.setManejaBeneficiario(FacesUtils
					.checkLong(txtManejaBeneficiario));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			businessDelegatorView.updateBanco(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedBanco = (BancoDTO) (evt.getComponent().getAttributes()
					.get("selectedBanco"));

			Long idBanc = new Long(selectedBanco.getIdBanc());
			entity = businessDelegatorView.getBanco(idBanc);
			businessDelegatorView.deleteBanco(entity);
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
			selectedBanco = (BancoDTO) (evt.getComponent().getAttributes()
					.get("selectedBanco"));

			Long idBanc = new Long(selectedBanco.getIdBanc());
			entity = businessDelegatorView.getBanco(idBanc);
			businessDelegatorView.deleteBanco(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedBanco);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, Long confirmaCheque,
			Long consigna, String cuentaBanco, String cuentaDescuento,
			String descripcion, String estadoRegistro, Date fechaCreacion,
			Date fechaModificacion, Long idBanc, Long importaPda,
			Long manejaBeneficiario, String operCreador, String operModifica)
			throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setConfirmaCheque(FacesUtils.checkLong(confirmaCheque));
			entity.setConsigna(FacesUtils.checkLong(consigna));
			entity.setCuentaBanco(FacesUtils.checkString(cuentaBanco));
			entity.setCuentaDescuento(FacesUtils.checkString(cuentaDescuento));
			entity.setDescripcion(FacesUtils.checkString(descripcion));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setImportaPda(FacesUtils.checkLong(importaPda));
			entity.setManejaBeneficiario(FacesUtils
					.checkLong(manejaBeneficiario));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateBanco(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("BancoView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(InputText txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public InputText getTxtCuentaBanco() {
		return txtCuentaBanco;
	}

	public void setTxtCuentaBanco(InputText txtCuentaBanco) {
		this.txtCuentaBanco = txtCuentaBanco;
	}

	public InputText getTxtCuentaDescuento() {
		return txtCuentaDescuento;
	}

	public void setTxtCuentaDescuento(InputText txtCuentaDescuento) {
		this.txtCuentaDescuento = txtCuentaDescuento;
	}

	public InputTextarea getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(InputTextarea txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
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

	public InputText getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(InputText txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public InputText getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(InputText txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public InputText getTxtIdBanc() {
		return txtIdBanc;
	}

	public void setTxtIdBanc(InputText txtIdBanc) {
		this.txtIdBanc = txtIdBanc;
	}

	public List<BancoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataBanco();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<BancoDTO> bancoDTO) {
		this.data = bancoDTO;
	}

	public BancoDTO getSelectedBanco() {
		return selectedBanco;
	}

	public void setSelectedBanco(BancoDTO banco) {
		this.selectedBanco = banco;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getConfirmaCheque() {
		return confirmaCheque;
	}

	public void setConfirmaCheque(String confirmaCheque) {
		this.confirmaCheque = confirmaCheque;
	}

	public String getConsigna() {
		return consigna;
	}

	public void setConsigna(String consigna) {
		this.consigna = consigna;
	}

	public String getCuentaBanco() {
		return cuentaBanco;
	}

	public void setCuentaBanco(String cuentaBanco) {
		this.cuentaBanco = cuentaBanco;
	}

	public String getCuentaDescuento() {
		return cuentaDescuento;
	}

	public void setCuentaDescuento(String cuentaDescuento) {
		this.cuentaDescuento = cuentaDescuento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getImportaPda() {
		return importaPda;
	}

	public void setImportaPda(String importaPda) {
		this.importaPda = importaPda;
	}

	public String getManejaBeneficiario() {
		return manejaBeneficiario;
	}

	public void setManejaBeneficiario(String manejaBeneficiario) {
		this.manejaBeneficiario = manejaBeneficiario;
	}

	public String getOperCreador() {
		return operCreador;
	}

	public void setOperCreador(String operCreador) {
		this.operCreador = operCreador;
	}

	public String getOperModifica() {
		return operModifica;
	}

	public void setOperModifica(String operModifica) {
		this.operModifica = operModifica;
	}

	public String getIdBanc() {
		return idBanc;
	}

	public void setIdBanc(String idBanc) {
		this.idBanc = idBanc;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public SelectItem[] getManufacturerOptions() {
		return manufacturerOptions;
	}

	public void setManufacturerOptions(SelectItem[] manufacturerOptions) {
		this.manufacturerOptions = manufacturerOptions;
	}

	public SelectItem[] getManufacturerOptions2() {
		return manufacturerOptions2;
	}

	public void setManufacturerOptions2(SelectItem[] manufacturerOptions2) {
		this.manufacturerOptions2 = manufacturerOptions2;
	}

	public SelectOneMenu getTxtConfirmaCheque() {
		return txtConfirmaCheque;
	}

	public void setTxtConfirmaCheque(SelectOneMenu txtConfirmaCheque) {
		this.txtConfirmaCheque = txtConfirmaCheque;
	}

	public SelectOneMenu getTxtConsigna() {
		return txtConsigna;
	}

	public void setTxtConsigna(SelectOneMenu txtConsigna) {
		this.txtConsigna = txtConsigna;
	}

	public SelectOneMenu getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(SelectOneMenu txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}

	public SelectOneMenu getTxtImportaPda() {
		return txtImportaPda;
	}

	public void setTxtImportaPda(SelectOneMenu txtImportaPda) {
		this.txtImportaPda = txtImportaPda;
	}

	public SelectOneMenu getTxtManejaBeneficiario() {
		return txtManejaBeneficiario;
	}

	public void setTxtManejaBeneficiario(SelectOneMenu txtManejaBeneficiario) {
		this.txtManejaBeneficiario = txtManejaBeneficiario;
	}
}