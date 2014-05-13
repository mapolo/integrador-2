package co.edu.usbcali.presentation.backingBeans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.AtencionVendedor;
import co.edu.usbcali.modelo.Contacto;
import co.edu.usbcali.modelo.Sucursal;
import co.edu.usbcali.modelo.TipoContacto;
import co.edu.usbcali.modelo.dto.AtencionVendedorDTO;
import co.edu.usbcali.modelo.dto.ContactoDTO;
import co.edu.usbcali.modelo.dto.SucursalDTO;
import co.edu.usbcali.modelo.dto.TipoContactoDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class ContactoView {
	private InputTextarea txtEmail;
	private SelectOneMenu txtEstadoRegistro;
	private InputTextarea txtNombreCompleto;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtTelefono1;
	private InputText txtTelefono2;
	private SelectOneMenu txtIdAtve_AtencionVendedor;
	private SelectOneMenu txtIdSucu_Sucursal;
	private SelectOneMenu txtIdTico_TipoContacto;
	private InputText txtIdCont;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;

	private String email;
	private String estadoRegistro;
	private String nombreCompleto;
	private String operCreador;
	private String operModifica;
	private String telefono1;
	private String telefono2;
	private String idAtve_AtencionVendedor;
	private String idSucu_Sucursal;
	private String idTico_TipoContacto;
	private String idCont;
	private String fechaCreacion;
	private String fechaModificacion;

	private Map<String, String> atencionVende = new HashMap<String, String>();
	private Map<String, String> sucursal = new HashMap<String, String>();
	private Map<String, String> tipoCont = new HashMap<String, String>();

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ContactoDTO> data;
	private ContactoDTO selectedContacto;
	private Contacto entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private SelectItem[] manufacturerOptions;

	String manufacturers[] = { "A", "R" };

	public ContactoView() {
		super();

		setManufacturerOptions(createFilterOptions(manufacturers));
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
			entity = businessDelegatorView.getContacto(((ContactoDTO) event
					.getObject()).getIdCont());

			entity.setEstadoRegistro(estadoRegistro);
			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);
			entity.setFechaModificacion(new Date());

			entity.setNombreCompleto(((ContactoDTO) event.getObject())
					.getNombreCompleto());
			entity.setTelefono1(((ContactoDTO) event.getObject())
					.getTelefono1());
			entity.setTelefono2(((ContactoDTO) event.getObject())
					.getTelefono2());
			entity.setEmail(((ContactoDTO) event.getObject()).getEmail());

			// Llaves foraneas

			AtencionVendedor entity1 = businessDelegatorView
					.getAtencionVendedor(Long
							.parseLong(idAtve_AtencionVendedor));
			if (entity1 == null) {
				entity.setAtencionVendedor(null);
			} else {
				entity.setAtencionVendedor(entity1);
			}

			Sucursal entity2 = businessDelegatorView.getSucursal(Long
					.parseLong(idSucu_Sucursal));
			if (entity2 == null) {
				entity.setSucursal(null);
			} else {
				entity.setSucursal(entity2);
			}

			TipoContacto entity3 = businessDelegatorView.getTipoContacto(Long
					.parseLong(idTico_TipoContacto));
			if (entity3 == null) {
				entity.setTipoContacto(null);
			} else {
				entity.setTipoContacto(entity3);
			}

			businessDelegatorView.updateContacto(entity);
			data = businessDelegatorView.getDataContacto();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("TipoEstado Cancelled",
				((ContactoDTO) event.getObject()).getIdCont() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((ContactoDTO) event.getObject()).getIdCont());
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ContactoDTO contactoDTO = (ContactoDTO) e.getObject();

			if (txtEmail == null) {
				txtEmail = new InputTextarea();
			}

			txtEmail.setValue(contactoDTO.getEmail());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new SelectOneMenu();
			}

			txtEstadoRegistro.setValue(contactoDTO.getEstadoRegistro());

			if (txtNombreCompleto == null) {
				txtNombreCompleto = new InputTextarea();
			}

			txtNombreCompleto.setValue(contactoDTO.getNombreCompleto());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(contactoDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(contactoDTO.getOperModifica());

			if (txtTelefono1 == null) {
				txtTelefono1 = new InputText();
			}

			txtTelefono1.setValue(contactoDTO.getTelefono1());

			if (txtTelefono2 == null) {
				txtTelefono2 = new InputText();
			}

			txtTelefono2.setValue(contactoDTO.getTelefono2());

			if (txtIdAtve_AtencionVendedor == null) {
				txtIdAtve_AtencionVendedor = new SelectOneMenu();
			}

			txtIdAtve_AtencionVendedor.setValue(contactoDTO
					.getIdAtve_AtencionVendedor());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new SelectOneMenu();
			}

			txtIdSucu_Sucursal.setValue(contactoDTO.getIdSucu_Sucursal());

			if (txtIdTico_TipoContacto == null) {
				txtIdTico_TipoContacto = new SelectOneMenu();
			}

			txtIdTico_TipoContacto.setValue(contactoDTO
					.getIdTico_TipoContacto());

			if (txtIdCont == null) {
				txtIdCont = new InputText();
			}

			txtIdCont.setValue(contactoDTO.getIdCont());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(contactoDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(contactoDTO.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedContacto = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedContacto = null;

		if (txtEmail != null) {
			txtEmail.setValue(null);
			// txtEmail.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			// txtEstadoRegistro.setDisabled(true);
		}

		if (txtNombreCompleto != null) {
			txtNombreCompleto.setValue(null);
			// txtNombreCompleto.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			// txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			// txtOperModifica.setDisabled(true);
		}

		if (txtTelefono1 != null) {
			txtTelefono1.setValue(null);
			// txtTelefono1.setDisabled(true);
		}

		if (txtTelefono2 != null) {
			txtTelefono2.setValue(null);
			// txtTelefono2.setDisabled(true);
		}

		if (txtIdAtve_AtencionVendedor != null) {
			txtIdAtve_AtencionVendedor.setValue(null);
			// txtIdAtve_AtencionVendedor.setDisabled(true);
		}

		if (txtIdSucu_Sucursal != null) {
			txtIdSucu_Sucursal.setValue(null);
			// txtIdSucu_Sucursal.setDisabled(true);
		}

		if (txtIdTico_TipoContacto != null) {
			txtIdTico_TipoContacto.setValue(null);
			// txtIdTico_TipoContacto.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			// txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			// txtFechaModificacion.setDisabled(true);
		}

		if (txtIdCont != null) {
			txtIdCont.setValue(null);
			// txtIdCont.setDisabled(false);
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
			Long idCont = new Long(txtIdCont.getValue().toString());
			entity = businessDelegatorView.getContacto(idCont);
		} catch (Exception e) {

		}

		if (entity == null) {
			txtEmail.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtNombreCompleto.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtTelefono1.setDisabled(false);
			txtTelefono2.setDisabled(false);
			txtIdAtve_AtencionVendedor.setDisabled(false);
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdTico_TipoContacto.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdCont.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtEmail.setValue(entity.getEmail());
			txtEmail.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtNombreCompleto.setValue(entity.getNombreCompleto());
			txtNombreCompleto.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtTelefono1.setValue(entity.getTelefono1());
			txtTelefono1.setDisabled(false);
			txtTelefono2.setValue(entity.getTelefono2());
			txtTelefono2.setDisabled(false);
			txtIdAtve_AtencionVendedor.setValue(entity.getAtencionVendedor()
					.getIdAtve());
			txtIdAtve_AtencionVendedor.setDisabled(false);
			txtIdSucu_Sucursal.setValue(entity.getSucursal().getIdSucu());
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdTico_TipoContacto.setValue(entity.getTipoContacto()
					.getIdTico());
			txtIdTico_TipoContacto.setDisabled(false);
			txtIdCont.setValue(entity.getIdCont());
			txtIdCont.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedContacto = (ContactoDTO) (evt.getComponent().getAttributes()
				.get("selectedContacto"));
		txtEmail.setValue(selectedContacto.getEmail());
		txtEmail.setDisabled(false);
		txtEstadoRegistro.setValue(selectedContacto.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedContacto.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedContacto.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtNombreCompleto.setValue(selectedContacto.getNombreCompleto());
		txtNombreCompleto.setDisabled(false);
		txtOperCreador.setValue(selectedContacto.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedContacto.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtTelefono1.setValue(selectedContacto.getTelefono1());
		txtTelefono1.setDisabled(false);
		txtTelefono2.setValue(selectedContacto.getTelefono2());
		txtTelefono2.setDisabled(false);
		txtIdAtve_AtencionVendedor.setValue(selectedContacto
				.getIdAtve_AtencionVendedor());
		txtIdAtve_AtencionVendedor.setDisabled(false);
		txtIdSucu_Sucursal.setValue(selectedContacto.getIdSucu_Sucursal());
		txtIdSucu_Sucursal.setDisabled(false);
		txtIdTico_TipoContacto.setValue(selectedContacto
				.getIdTico_TipoContacto());
		txtIdTico_TipoContacto.setDisabled(false);
		txtIdCont.setValue(selectedContacto.getIdCont());
		txtIdCont.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedContacto == null) && (entity == null)) {
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
			entity = new Contacto();

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			// Long idCont = new Long(txtIdCont.getValue().toString());

			entity.setEmail(FacesUtils.checkString(txtEmail));
			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			// entity.setIdCont(idCont);

			entity.setNombreCompleto(FacesUtils.checkString(txtNombreCompleto));
			entity.setTelefono1(FacesUtils.checkString(txtTelefono1));
			entity.setTelefono2(FacesUtils.checkString(txtTelefono2));

			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			entity.setEstadoRegistro(estadoRegistro);

			if (txtIdAtve_AtencionVendedor.getValue() == "") {
				// System.out.println("Entro null atencion vendedor");
				// entity.setAtencionVendedor(null);
			} else {
				entity.setAtencionVendedor(businessDelegatorView
						.getAtencionVendedor(FacesUtils
								.checkLong(txtIdAtve_AtencionVendedor)));
			}

			if (txtIdSucu_Sucursal.getValue() == "") {

			} else {
				entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
						.checkLong(txtIdSucu_Sucursal)));
			}

			if (txtIdTico_TipoContacto.getValue() == "") {

			} else {
				entity.setTipoContacto(businessDelegatorView
						.getTipoContacto(FacesUtils
								.checkLong(txtIdTico_TipoContacto)));
			}

			businessDelegatorView.saveContacto(entity);
			data = businessDelegatorView.getDataContacto();
			RequestContext.getCurrentInstance().update("form:tablaPrincipal");
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
				Long idCont = new Long(selectedContacto.getIdCont());
				entity = businessDelegatorView.getContacto(idCont);
			}

			entity.setEmail(FacesUtils.checkString(txtEmail));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setNombreCompleto(FacesUtils.checkString(txtNombreCompleto));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setTelefono1(FacesUtils.checkString(txtTelefono1));
			entity.setTelefono2(FacesUtils.checkString(txtTelefono2));
			entity.setAtencionVendedor(businessDelegatorView
					.getAtencionVendedor(FacesUtils
							.checkLong(txtIdAtve_AtencionVendedor)));
			entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			entity.setTipoContacto(businessDelegatorView
					.getTipoContacto(FacesUtils
							.checkLong(txtIdTico_TipoContacto)));
			businessDelegatorView.updateContacto(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedContacto = (ContactoDTO) (evt.getComponent()
					.getAttributes().get("selectedContacto"));

			Long idCont = new Long(selectedContacto.getIdCont());
			entity = businessDelegatorView.getContacto(idCont);
			businessDelegatorView.deleteContacto(entity);
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
			selectedContacto = (ContactoDTO) (evt.getComponent()
					.getAttributes().get("selectedContacto"));

			Long idCont = new Long(selectedContacto.getIdCont());
			entity = businessDelegatorView.getContacto(idCont);
			businessDelegatorView.deleteContacto(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedContacto);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String email, String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idCont,
			String nombreCompleto, String operCreador, String operModifica,
			String telefono1, String telefono2, Long idAtve_AtencionVendedor,
			Long idSucu_Sucursal, Long idTico_TipoContacto) throws Exception {
		try {
			entity.setEmail(FacesUtils.checkString(email));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setNombreCompleto(FacesUtils.checkString(nombreCompleto));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setTelefono1(FacesUtils.checkString(telefono1));
			entity.setTelefono2(FacesUtils.checkString(telefono2));
			businessDelegatorView.updateContacto(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ContactoView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputTextarea getTxtEmail() {
		return txtEmail;
	}

	public void setTxtEmail(InputTextarea txtEmail) {
		this.txtEmail = txtEmail;
	}

	public SelectOneMenu getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(SelectOneMenu txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}

	public InputTextarea getTxtNombreCompleto() {
		return txtNombreCompleto;
	}

	public void setTxtNombreCompleto(InputTextarea txtNombreCompleto) {
		this.txtNombreCompleto = txtNombreCompleto;
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

	public InputText getTxtTelefono1() {
		return txtTelefono1;
	}

	public void setTxtTelefono1(InputText txtTelefono1) {
		this.txtTelefono1 = txtTelefono1;
	}

	public InputText getTxtTelefono2() {
		return txtTelefono2;
	}

	public void setTxtTelefono2(InputText txtTelefono2) {
		this.txtTelefono2 = txtTelefono2;
	}

	public SelectOneMenu getTxtIdAtve_AtencionVendedor() {
		return txtIdAtve_AtencionVendedor;
	}

	public void setTxtIdAtve_AtencionVendedor(
			SelectOneMenu txtIdAtve_AtencionVendedor) {
		this.txtIdAtve_AtencionVendedor = txtIdAtve_AtencionVendedor;
	}

	public SelectOneMenu getTxtIdSucu_Sucursal() {
		return txtIdSucu_Sucursal;
	}

	public void setTxtIdSucu_Sucursal(SelectOneMenu txtIdSucu_Sucursal) {
		this.txtIdSucu_Sucursal = txtIdSucu_Sucursal;
	}

	public SelectOneMenu getTxtIdTico_TipoContacto() {
		return txtIdTico_TipoContacto;
	}

	public void setTxtIdTico_TipoContacto(SelectOneMenu txtIdTico_TipoContacto) {
		this.txtIdTico_TipoContacto = txtIdTico_TipoContacto;
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

	public InputText getTxtIdCont() {
		return txtIdCont;
	}

	public void setTxtIdCont(InputText txtIdCont) {
		this.txtIdCont = txtIdCont;
	}

	public List<ContactoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataContacto();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ContactoDTO> contactoDTO) {
		this.data = contactoDTO;
	}

	public ContactoDTO getSelectedContacto() {
		return selectedContacto;
	}

	public void setSelectedContacto(ContactoDTO contacto) {
		this.selectedContacto = contacto;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
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

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getIdAtve_AtencionVendedor() {
		return idAtve_AtencionVendedor;
	}

	public void setIdAtve_AtencionVendedor(String idAtve_AtencionVendedor) {
		this.idAtve_AtencionVendedor = idAtve_AtencionVendedor;
	}

	public String getIdSucu_Sucursal() {
		return idSucu_Sucursal;
	}

	public void setIdSucu_Sucursal(String idSucu_Sucursal) {
		this.idSucu_Sucursal = idSucu_Sucursal;
	}

	public String getIdTico_TipoContacto() {
		return idTico_TipoContacto;
	}

	public void setIdTico_TipoContacto(String idTico_TipoContacto) {
		this.idTico_TipoContacto = idTico_TipoContacto;
	}

	public String getIdCont() {
		return idCont;
	}

	public void setIdCont(String idCont) {
		this.idCont = idCont;
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

	public Map<String, String> getAtencionVende() {
		try {
			List<AtencionVendedorDTO> data2 = businessDelegatorView
					.getDataAtencionVendedor();

			for (int i = 0; i < data2.size(); i++) {
				atencionVende.put(data2.get(i).getIdAtve() + "", data2.get(i)
						.getIdAtve() + "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return atencionVende;
	}

	public void setAtencionVende(Map<String, String> atencionVende) {
		this.atencionVende = atencionVende;
	}

	public Map<String, String> getSucursal() {
		try {
			List<SucursalDTO> data3 = businessDelegatorView.getDataSucursal();

			for (int i = 0; i < data3.size(); i++) {
				sucursal.put(data3.get(i).getNombre(), data3.get(i).getIdSucu()
						+ "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sucursal;
	}

	public void setSucursal(Map<String, String> sucursal) {
		this.sucursal = sucursal;
	}

	public Map<String, String> getTipoCont() {
		try {
			List<TipoContactoDTO> data4 = businessDelegatorView
					.getDataTipoContacto();

			for (int i = 0; i < data4.size(); i++) {
				tipoCont.put(data4.get(i).getIdTico() + "", data4.get(i)
						.getIdTico() + "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tipoCont;
	}

	public void setTipoCont(Map<String, String> tipoCont) {
		this.tipoCont = tipoCont;
	}

}
