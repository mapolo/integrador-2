package co.edu.usbcali.presentation.backingBeans;

import java.text.DateFormat;
import java.text.Format;
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
import co.edu.usbcali.modelo.TipoDocumento;
import co.edu.usbcali.modelo.dto.TipoDocumentoDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class TipoDocumentoView {
	private InputText txtAfectaCartea;
	private InputText txtAfectaInventario;
	private InputText txtCodigo;
	private InputTextarea txtDescripcion;
	private SelectOneMenu estado;
	private SelectOneMenu zignoCartera;
	private SelectOneMenu aafectaCartea;
	private SelectOneMenu zignoInventario;
	private SelectOneMenu aafectaInventario;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtSignoCartera;
	private InputText txtSignoInventario;
	private InputText txtIdTido;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;
	private String afectaCartea;
	private String afectaInventario;
	private String codigo;
	private String descripcion;
	private String estadoRegistro;
	private String operCreador;
	private String operModifica;
	private String signoCartera;
	private String signoInventario;
	private String idTido;
	private String creacion;
	private String fechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private CommandButton btnCrear;
	private List<TipoDocumentoDTO> data;
	private TipoDocumentoDTO selectedTipoDocumento;
	private TipoDocumento entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private SelectItem[] manufacturerOptions;
	private SelectItem[] manufacturerOptions2;
	private SelectItem[] manufacturerOptions3;

	String manufacturers[] = { "A", "R" };
	String manufacturers2[] = { "S", "N" };
	String manufacturers3[] = { "+", "-" };

	public TipoDocumentoView() {
		super();

		setManufacturerOptions(createFilterOptions(manufacturers));
		setManufacturerOptions2(createFilterOptions(manufacturers2));
		setManufacturerOptions3(createFilterOptions(manufacturers3));
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			TipoDocumentoDTO tipoDocumentoDTO = (TipoDocumentoDTO) e
					.getObject();

			if (txtAfectaCartea == null) {
				txtAfectaCartea = new InputText();
			}

			txtAfectaCartea.setValue(tipoDocumentoDTO.getAfectaCartea());

			if (txtAfectaInventario == null) {
				txtAfectaInventario = new InputText();
			}

			txtAfectaInventario
					.setValue(tipoDocumentoDTO.getAfectaInventario());

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(tipoDocumentoDTO.getCodigo());

			if (txtDescripcion == null) {
				txtDescripcion = new InputTextarea();
			}

			txtDescripcion.setValue(tipoDocumentoDTO.getDescripcion());

			/*
			 * if (txtEstadoRegistro == null) { txtEstadoRegistro = new
			 * InputText(); }
			 * 
			 * txtEstadoRegistro.setValue(tipoDocumentoDTO.getEstadoRegistro());
			 */

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(tipoDocumentoDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(tipoDocumentoDTO.getOperModifica());

			if (txtSignoCartera == null) {
				txtSignoCartera = new InputText();
			}

			txtSignoCartera.setValue(tipoDocumentoDTO.getSignoCartera());

			if (txtSignoInventario == null) {
				txtSignoInventario = new InputText();
			}

			txtSignoInventario.setValue(tipoDocumentoDTO.getSignoInventario());

			if (txtIdTido == null) {
				txtIdTido = new InputText();
			}

			txtIdTido.setValue(tipoDocumentoDTO.getIdTido());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(tipoDocumentoDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(tipoDocumentoDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedTipoDocumento = null;
		setShowDialog(true);

		return "";
	}

	public String principalPagina() {
		return "tipoDocumento.xhtml";
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
		System.out.println("Codigo1"
				+ ((TipoDocumentoDTO) event.getObject()).getCodigo());

		try {

			entity = null;
			entity = businessDelegatorView
					.getTipoDocumento(((TipoDocumentoDTO) event.getObject())
							.getIdTido());

			descripcion = ((TipoDocumentoDTO) event.getObject())
					.getDescripcion();
			entity.setDescripcion(descripcion);

			codigo = ((TipoDocumentoDTO) event.getObject()).getCodigo();
			entity.setCodigo(codigo);

			entity.setAfectaInventario(afectaInventario);
			entity.setSignoInventario(signoInventario);

			entity.setAfectaCartea(afectaCartea);
			entity.setSignoCartera(signoCartera);

			entity.setEstadoRegistro(estadoRegistro);

			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);

			businessDelegatorView.updateTipoDocumento(entity);
			data = businessDelegatorView.getDataTipoDocumento();
			RequestContext.getCurrentInstance().reset("form:listaTDo");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("TipoEstado Cancelled",
				((TipoDocumentoDTO) event.getObject()).getIdTido() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((TipoDocumentoDTO) event.getObject()).getIdTido());
	}

	public String actualizar() {
		return "tipoDocumento.xhtml?faces-redirect=true";
	}

	public String action_buscar() {
		try {
			entity = businessDelegatorView
					.getTipoDocumento(selectedTipoDocumento.getIdTido());

			idTido = entity.getIdTido() + "";
			afectaCartea = entity.getAfectaCartea();
			afectaInventario = entity.getAfectaInventario();
			codigo = entity.getCodigo();
			descripcion = entity.getDescripcion();
			estadoRegistro = entity.getEstadoRegistro();

			Format formatter = new SimpleDateFormat("dd-MM-yyyy");
			String s = formatter.format(entity.getFechaCreacion());
			creacion = s;

			s = formatter.format(entity.getFechaModificacion());

			fechaModificacion = s;
			operCreador = entity.getOperCreador();
			operModifica = entity.getOperModifica();
			signoCartera = entity.getSignoCartera();
			signoInventario = entity.getSignoInventario();

			btnModify.setDisabled(false);

			RequestContext.getCurrentInstance().update("form:panel");
			RequestContext.getCurrentInstance().update("form:dialog");
			RequestContext.getCurrentInstance().update("form:td");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String action_clear2() {

		afectaCartea = "";
		afectaInventario = "";
		codigo = "";
		descripcion = "";
		estadoRegistro = "";
		operCreador = "";
		operModifica = "";
		signoCartera = "";
		signoInventario = "";
		idTido = "";
		creacion = "";
		fechaModificacion = "";

		txtAfectaCartea.setDisabled(true);
		txtAfectaInventario.setDisabled(true);
		txtCodigo.setDisabled(true);
		txtDescripcion.setDisabled(true);
		// txtEstadoRegistro.setDisabled(true);
		txtFechaCreacion.setDisabled(true);
		txtFechaModificacion.setDisabled(true);
		txtOperCreador.setDisabled(true);
		txtOperModifica.setDisabled(true);
		txtSignoCartera.setDisabled(true);
		txtSignoInventario.setDisabled(true);
		txtIdTido.setDisabled(false);

		btnSave.setDisabled(true);
		btnModify.setDisabled(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedTipoDocumento = null;

		if (txtAfectaCartea != null) {
			txtAfectaCartea.setValue(null);
			// txtAfectaCartea.setDisabled(true);
		}

		if (txtAfectaInventario != null) {
			txtAfectaInventario.setValue(null);
			// txtAfectaInventario.setDisabled(true);
		}

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			// txtCodigo.setDisabled(true);
		}

		if (txtDescripcion != null) {
			txtDescripcion.setValue(null);
			// txtDescripcion.setDisabled(true);
		}

		/*
		 * if (txtEstadoRegistro != null) { txtEstadoRegistro.setValue(null);
		 * txtEstadoRegistro.setDisabled(true); }
		 */

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			// txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			// txtOperModifica.setDisabled(true);
		}

		if (txtSignoCartera != null) {
			txtSignoCartera.setValue(null);
			// txtSignoCartera.setDisabled(true);
		}

		if (txtSignoInventario != null) {
			txtSignoInventario.setValue(null);
			// txtSignoInventario.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			// txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			// txtFechaModificacion.setDisabled(true);
		}

		if (txtIdTido != null) {
			txtIdTido.setValue(null);
			// txtIdTido.setDisabled(false);
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
			Long idTido = new Long(txtIdTido.getValue().toString());
			entity = businessDelegatorView.getTipoDocumento(idTido);
		} catch (Exception e) {

		}

		if (entity == null) {
			txtAfectaCartea.setDisabled(false);
			txtAfectaInventario.setDisabled(false);
			txtCodigo.setDisabled(false);
			txtDescripcion.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtSignoCartera.setDisabled(false);
			txtSignoInventario.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdTido.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtAfectaCartea.setValue(entity.getAfectaCartea());
			txtAfectaCartea.setDisabled(false);
			txtAfectaInventario.setValue(entity.getAfectaInventario());
			txtAfectaInventario.setDisabled(false);
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtDescripcion.setValue(entity.getDescripcion());
			txtDescripcion.setDisabled(false);
			// txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			// txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtSignoCartera.setValue(entity.getSignoCartera());
			txtSignoCartera.setDisabled(false);
			txtSignoInventario.setValue(entity.getSignoInventario());
			txtSignoInventario.setDisabled(false);
			txtIdTido.setValue(entity.getIdTido());
			txtIdTido.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedTipoDocumento = (TipoDocumentoDTO) (evt.getComponent()
				.getAttributes().get("selectedTipoDocumento"));
		txtAfectaCartea.setValue(selectedTipoDocumento.getAfectaCartea());
		txtAfectaCartea.setDisabled(false);
		txtAfectaInventario.setValue(selectedTipoDocumento
				.getAfectaInventario());
		txtAfectaInventario.setDisabled(false);
		txtCodigo.setValue(selectedTipoDocumento.getCodigo());
		txtCodigo.setDisabled(false);
		txtDescripcion.setValue(selectedTipoDocumento.getDescripcion());
		txtDescripcion.setDisabled(false);
		// txtEstadoRegistro.setValue(selectedTipoDocumento.getEstadoRegistro());
		// txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedTipoDocumento.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedTipoDocumento
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedTipoDocumento.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedTipoDocumento.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtSignoCartera.setValue(selectedTipoDocumento.getSignoCartera());
		txtSignoCartera.setDisabled(false);
		txtSignoInventario.setValue(selectedTipoDocumento.getSignoInventario());
		txtSignoInventario.setDisabled(false);
		txtIdTido.setValue(selectedTipoDocumento.getIdTido());
		txtIdTido.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {

		try {
			if ((selectedTipoDocumento == null) && (entity == null)) {
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

	public String action_modificar() {

		txtAfectaCartea.setDisabled(false);
		txtAfectaInventario.setDisabled(false);
		txtCodigo.setDisabled(false);
		txtDescripcion.setDisabled(false);
		estado.setDisabled(false);
		// txtEstadoRegistro.setDisabled(false);
		// txtFechaCreacion.setDisabled(true);
		// txtFechaModificacion.setDisabled(true);
		txtOperCreador.setDisabled(false);
		txtOperModifica.setDisabled(false);
		txtSignoCartera.setDisabled(false);
		txtSignoInventario.setDisabled(false);
		txtIdTido.setDisabled(true);

		btnSave.setDisabled(false);
		// btnCrear.setDisabled(true);

		return "";
	}

	public String action_crear() {
		action_clear();
		txtAfectaCartea.setDisabled(false);
		txtAfectaInventario.setDisabled(false);
		txtCodigo.setDisabled(false);
		txtDescripcion.setDisabled(false);
		estado.setDisabled(false);
		// txtEstadoRegistro.setDisabled(false);

		// txtFechaCreacion.setDisabled(true);
		// txtFechaCreacion.setValue(new Date());
		// txtFechaModificacion.setDisabled(true);
		// txtFechaModificacion.setValue(new Date());

		txtOperCreador.setDisabled(false);
		txtOperModifica.setDisabled(false);
		txtSignoCartera.setDisabled(false);
		txtSignoInventario.setDisabled(false);

		btnCrear.setDisabled(false);
		btnSave.setDisabled(false);
		btnModify.setDisabled(true);

		return "";
	}

	public String action_create() {
		try {
			entity = new TipoDocumento();

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			// Long idTido = new Long(txtIdTido.getValue().toString());

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			entity.setEstadoRegistro(estadoRegistro);
			entity.setAfectaCartea(afectaCartea);
			entity.setAfectaInventario(afectaInventario);
			entity.setSignoCartera(signoCartera);
			entity.setSignoInventario(signoInventario);
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			// entity.setIdTido(idTido);
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);

			// txtOperCreador.setValue(usuario);
			// txtOperModifica.setValue(usuario);
			// entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			// entity.setOperModifica(FacesUtils.checkString(txtOperModifica));

			businessDelegatorView.saveTipoDocumento(entity);
			data = businessDelegatorView.getDataTipoDocumento();
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
			action_clear();
			// actualizar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			FacesUtils.addErrorMessage(e.getMessage());

		}

		return "";
	}

	public String action_modify() {
		try {

			if (!btnCrear.isDisabled() && btnModify.isDisabled()) {
				action_create();
				data = businessDelegatorView.getDataTipoDocumento();
				RequestContext.getCurrentInstance().update(
						"form:tablaPrincipal");
				return "";
			}

			if (entity == null) {
				entity = businessDelegatorView.getTipoDocumento(Long
						.parseLong(idTido));
			}

			entity.setAfectaCartea(FacesUtils.checkString(txtAfectaCartea));
			entity.setAfectaInventario(FacesUtils
					.checkString(txtAfectaInventario));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			entity.setEstadoRegistro(estadoRegistro);
			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setSignoCartera(FacesUtils.checkString(txtSignoCartera));
			entity.setSignoInventario(FacesUtils
					.checkString(txtSignoInventario));
			businessDelegatorView.updateTipoDocumento(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

			btnSave.setDisabled(false);

			data = businessDelegatorView.getDataTipoDocumento();
			RequestContext.getCurrentInstance().update("form:tablaPrincipal");
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedTipoDocumento = (TipoDocumentoDTO) (evt.getComponent()
					.getAttributes().get("selectedTipoDocumento"));

			Long idTido = new Long(selectedTipoDocumento.getIdTido());
			entity = businessDelegatorView.getTipoDocumento(idTido);
			businessDelegatorView.deleteTipoDocumento(entity);
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
			selectedTipoDocumento = (TipoDocumentoDTO) (evt.getComponent()
					.getAttributes().get("selectedTipoDocumento"));

			Long idTido = new Long(selectedTipoDocumento.getIdTido());
			entity = businessDelegatorView.getTipoDocumento(idTido);
			businessDelegatorView.deleteTipoDocumento(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedTipoDocumento);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String afectaCartea,
			String afectaInventario, String codigo, String descripcion,
			String estadoRegistro, Date fechaCreacion, Date fechaModificacion,
			Long idTido, String operCreador, String operModifica,
			String signoCartera, String signoInventario) throws Exception {
		try {
			entity.setAfectaCartea(FacesUtils.checkString(afectaCartea));
			entity.setAfectaInventario(FacesUtils.checkString(afectaInventario));
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setDescripcion(FacesUtils.checkString(descripcion));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setSignoCartera(FacesUtils.checkString(signoCartera));
			entity.setSignoInventario(FacesUtils.checkString(signoInventario));
			businessDelegatorView.updateTipoDocumento(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("TipoDocumentoView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtAfectaCartea() {
		return txtAfectaCartea;
	}

	public void setTxtAfectaCartea(InputText txtAfectaCartea) {
		this.txtAfectaCartea = txtAfectaCartea;
	}

	public InputText getTxtAfectaInventario() {
		return txtAfectaInventario;
	}

	public void setTxtAfectaInventario(InputText txtAfectaInventario) {
		this.txtAfectaInventario = txtAfectaInventario;
	}

	public InputText getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(InputText txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public InputTextarea getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(InputTextarea txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	/*
	 * public InputText getTxtEstadoRegistro() { return txtEstadoRegistro; }
	 * 
	 * public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
	 * this.txtEstadoRegistro = txtEstadoRegistro; }
	 */

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

	public InputText getTxtSignoCartera() {
		return txtSignoCartera;
	}

	public void setTxtSignoCartera(InputText txtSignoCartera) {
		this.txtSignoCartera = txtSignoCartera;
	}

	public InputText getTxtSignoInventario() {
		return txtSignoInventario;
	}

	public void setTxtSignoInventario(InputText txtSignoInventario) {
		this.txtSignoInventario = txtSignoInventario;
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

	public InputText getTxtIdTido() {
		return txtIdTido;
	}

	public void setTxtIdTido(InputText txtIdTido) {
		this.txtIdTido = txtIdTido;
	}

	public List<TipoDocumentoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataTipoDocumento();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<TipoDocumentoDTO> tipoDocumentoDTO) {
		this.data = tipoDocumentoDTO;
	}

	public TipoDocumentoDTO getSelectedTipoDocumento() {
		return selectedTipoDocumento;
	}

	public void setSelectedTipoDocumento(TipoDocumentoDTO tipoDocumento) {
		this.selectedTipoDocumento = tipoDocumento;
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

	public String getAfectaCartea() {
		return afectaCartea;
	}

	public void setAfectaCartea(String afectaCartea) {
		this.afectaCartea = afectaCartea;
	}

	public String getAfectaInventario() {
		return afectaInventario;
	}

	public void setAfectaInventario(String afectaInventario) {
		this.afectaInventario = afectaInventario;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public String getSignoCartera() {
		return signoCartera;
	}

	public void setSignoCartera(String signoCartera) {
		this.signoCartera = signoCartera;
	}

	public String getSignoInventario() {
		return signoInventario;
	}

	public void setSignoInventario(String signoInventario) {
		this.signoInventario = signoInventario;
	}

	public String getIdTido() {
		return idTido;
	}

	public void setIdTido(String idTido) {
		this.idTido = idTido;
	}

	public String getCreacion() {
		return creacion;
	}

	public void setCreacion(String creacion) {
		this.creacion = creacion;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public CommandButton getBtnCrear() {
		return btnCrear;
	}

	public void setBtnCrear(CommandButton btnCrear) {
		this.btnCrear = btnCrear;
	}

	public SelectOneMenu getEstado() {
		return estado;
	}

	public void setEstado(SelectOneMenu estado) {
		this.estado = estado;
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

	public SelectItem[] getManufacturerOptions3() {
		return manufacturerOptions3;
	}

	public void setManufacturerOptions3(SelectItem[] manufacturerOptions3) {
		this.manufacturerOptions3 = manufacturerOptions3;
	}

	public SelectOneMenu getZignoCartera() {
		return zignoCartera;
	}

	public void setZignoCartera(SelectOneMenu zignoCartera) {
		this.zignoCartera = zignoCartera;
	}

	public SelectOneMenu getAafectaCartea() {
		return aafectaCartea;
	}

	public void setAafectaCartea(SelectOneMenu aafectaCartea) {
		this.aafectaCartea = aafectaCartea;
	}

	public SelectOneMenu getZignoInventario() {
		return zignoInventario;
	}

	public void setZignoInventario(SelectOneMenu zignoInventario) {
		this.zignoInventario = zignoInventario;
	}

	public SelectOneMenu getAafectaInventario() {
		return aafectaInventario;
	}

	public void setAafectaInventario(SelectOneMenu aafectaInventario) {
		this.aafectaInventario = aafectaInventario;
	}

}
