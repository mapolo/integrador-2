package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.TipoDivisionDTO;
import co.edu.usbcali.modelo.dto.TipoIdentificacionDTO;
import co.edu.usbcali.presentation.businessDelegate.*;
import co.edu.usbcali.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import java.text.DateFormat;
import java.text.Format;
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
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

/**
 * 
 * 
 */
@ManagedBean
@ViewScoped
public class TipoIdentificacionView {
	private InputText txtCodigo;
	private InputTextarea txtDescripcion;
	// private InputText txtEstadoRegistro;
	private SelectOneMenu estado;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdTiid;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;

	private String codigo;
	private String descripcion;
	private String estadoRegistro;
	private String operCreador;
	private String operModifica;
	private String idTiid;
	private String fechaCreacion;
	private String fechaModificacion;

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private CommandButton btnCrear;
	private List<TipoIdentificacionDTO> data;
	private TipoIdentificacionDTO selectedTipoIdentificacion;
	private TipoIdentificacion entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectItem[] manufacturerOptions;

	String manufacturers[] = { "A", "R" };

	public TipoIdentificacionView() {
		super();

		manufacturerOptions = createFilterOptions(manufacturers);
	}

	private SelectItem[] createFilterOptions(String[] data) {
		SelectItem[] options = new SelectItem[data.length + 1];

		options[0] = new SelectItem("", "Seleccionar");
		for (int i = 0; i < data.length; i++) {
			options[i + 1] = new SelectItem(data[i], data[i]);
		}

		return options;
	}

	public String actualizar() {
		return "tipoIdentificacion.xhtml?faces-redirect=true";
	}

	public void onEdit(org.primefaces.event.RowEditEvent event) {
		/*
		 * System.out.println("Nombre1" + ((TipoIdentificacionDTO)
		 * event.getObject()).getNombre());
		 */
		try {

			entity = null;
			entity = businessDelegatorView
					.getTipoIdentificacion(((TipoIdentificacionDTO) event
							.getObject()).getIdTiid());

			entity.setEstadoRegistro(estadoRegistro);

			codigo = ((TipoIdentificacionDTO) event.getObject()).getCodigo();
			entity.setCodigo(codigo);

			descripcion = ((TipoIdentificacionDTO) event.getObject())
					.getDescripcion();
			entity.setDescripcion(descripcion);
			
			String usuario =(String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);

			// entity.setCodigo(FacesUtils.checkString(txtCodigo));
			// entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			// entity.setOperModifica(FacesUtils.checkString(txtOperModifica));

			businessDelegatorView.updateTipoIdentificacion(entity);
			data = businessDelegatorView.getDataTipoIdentificacion();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("TipoEstado Cancelled",
				((TipoIdentificacionDTO) event.getObject()).getIdTiid() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((TipoIdentificacionDTO) event.getObject()).getIdTiid());
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			TipoIdentificacionDTO tipoIdentificacionDTO = (TipoIdentificacionDTO) e
					.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(tipoIdentificacionDTO.getCodigo());

			if (txtDescripcion == null) {
				txtDescripcion = new InputTextarea();
			}

			txtDescripcion.setValue(tipoIdentificacionDTO.getDescripcion());

			/*
			 * if (txtEstadoRegistro == null) { txtEstadoRegistro = new
			 * InputText(); }
			 * 
			 * txtEstadoRegistro.setValue(tipoIdentificacionDTO.getEstadoRegistro
			 * ());
			 */

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(tipoIdentificacionDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(tipoIdentificacionDTO.getOperModifica());

			if (txtIdTiid == null) {
				txtIdTiid = new InputText();
			}

			txtIdTiid.setValue(tipoIdentificacionDTO.getIdTiid());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(tipoIdentificacionDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(tipoIdentificacionDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedTipoIdentificacion = null;
		setShowDialog(true);

		return "";
	}

	public String action_buscar() {
		try {

			entity = businessDelegatorView
					.getTipoIdentificacion(selectedTipoIdentificacion
							.getIdTiid());

			idTiid = entity.getIdTiid() + "";
			codigo = entity.getCodigo();
			descripcion = entity.getDescripcion();
			Format formatter = new SimpleDateFormat("dd-MM-yyyy");
			String s = formatter.format(entity.getFechaCreacion());
			fechaCreacion = s;
			operCreador = entity.getOperCreador();
			s = formatter.format(entity.getFechaModificacion());
			fechaModificacion = s;
			operModifica = entity.getOperModifica();
			estadoRegistro = entity.getEstadoRegistro();

			btnModify.setDisabled(false);

			RequestContext.getCurrentInstance().update("form:panel");
			RequestContext.getCurrentInstance().update("form:dialog");
			RequestContext.getCurrentInstance().update("form:ti");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String action_clear() {
		entity = null;
		selectedTipoIdentificacion = null;

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

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			// txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			// txtFechaModificacion.setDisabled(true);
		}

		if (txtIdTiid != null) {
			txtIdTiid.setValue(null);
			// txtIdTiid.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(false);
		}

		return "";
	}

	public String principalPagina() {
		return "tipoIdentificacion.xhtml";
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
			Long idTiid = new Long(txtIdTiid.getValue().toString());
			entity = businessDelegatorView.getTipoIdentificacion(idTiid);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtDescripcion.setDisabled(false);
			// txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdTiid.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
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
			txtIdTiid.setValue(entity.getIdTiid());
			txtIdTiid.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedTipoIdentificacion = (TipoIdentificacionDTO) (evt
				.getComponent().getAttributes()
				.get("selectedTipoIdentificacion"));
		txtCodigo.setValue(selectedTipoIdentificacion.getCodigo());
		txtCodigo.setDisabled(false);
		txtDescripcion.setValue(selectedTipoIdentificacion.getDescripcion());
		txtDescripcion.setDisabled(false);
		// txtEstadoRegistro.setValue(selectedTipoIdentificacion.getEstadoRegistro());
		// txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion
				.setValue(selectedTipoIdentificacion.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedTipoIdentificacion
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedTipoIdentificacion.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedTipoIdentificacion.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdTiid.setValue(selectedTipoIdentificacion.getIdTiid());
		txtIdTiid.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedTipoIdentificacion == null) && (entity == null)) {
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
			entity = new TipoIdentificacion();
			

			HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
					.getExternalContext().getSession(false);
			
			String usuario =(String) session.getAttribute("Usuario");

			//Long idTiid = new Long(txtIdTiid.getValue().toString());

			entity.setEstadoRegistro(estadoRegistro);
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			entity.setEstadoRegistro(estadoRegistro);
			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));

			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			//entity.setIdTiid(idTiid);
			
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			//txtOperCreador.setValue(usuario);
			//txtOperModifica.setValue(usuario);
			//entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			//entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			businessDelegatorView.saveTipoIdentificacion(entity);
			data = businessDelegatorView.getDataTipoIdentificacion();
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
			action_clear();
			actualizar();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_crear() {
		action_clear();
		txtIdTiid.setDisabled(false);
		txtCodigo.setDisabled(false);
		txtDescripcion.setDisabled(false);
		txtOperCreador.setDisabled(false);
		txtOperModifica.setDisabled(false);
		estado.setDisabled(false);
		// txtEstadoRegistro.setDisabled(false);

		// txtFechaCreacion.setDisabled(true);
		// txtFechaCreacion.setValue(new Date());
		// txtFechaModificacion.setDisabled(true);
		// txtFechaModificacion.setValue(new Date());

		btnCrear.setDisabled(false);
		btnSave.setDisabled(false);
		btnModify.setDisabled(true);

		return "";
	}

	public String action_modificar() {

		txtIdTiid.setDisabled(true);
		txtCodigo.setDisabled(false);
		txtDescripcion.setDisabled(false);
		estado.setDisabled(false);
		// txtEstadoRegistro.setDisabled(false);

		// txtFechaCreacion.setDisabled(true);
		// txtFechaModificacion.setDisabled(true);
		txtOperCreador.setDisabled(false);
		txtOperModifica.setDisabled(false);

		// btnCrear.setDisabled(true);
		btnSave.setDisabled(false);

		return "";
	}

	public String action_modify() {
		try {
			if (!btnCrear.isDisabled() && btnModify.isDisabled()) {
				action_create();
				data = businessDelegatorView.getDataTipoIdentificacion();
				RequestContext.getCurrentInstance().update(
						"form:tablaPrincipal");
				return "";
			}

			if (entity == null) {
				// Long idTiid = new
				// Long(selectedTipoIdentificacion.getIdTiid());
				// entity = businessDelegatorView.getTipoIdentificacion(idTiid);
				entity = businessDelegatorView.getTipoIdentificacion(Long
						.parseLong(idTiid));
			}

			entity.setEstadoRegistro(estadoRegistro);
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));

			entity.setFechaModificacion(new Date());
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			businessDelegatorView.updateTipoIdentificacion(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

			btnSave.setDisabled(false);
			data = businessDelegatorView.getDataTipoIdentificacion();
			RequestContext.getCurrentInstance().update("form:tablaPrincipal");
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedTipoIdentificacion = (TipoIdentificacionDTO) (evt
					.getComponent().getAttributes()
					.get("selectedTipoIdentificacion"));

			Long idTiid = new Long(selectedTipoIdentificacion.getIdTiid());
			entity = businessDelegatorView.getTipoIdentificacion(idTiid);
			businessDelegatorView.deleteTipoIdentificacion(entity);
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
			selectedTipoIdentificacion = (TipoIdentificacionDTO) (evt
					.getComponent().getAttributes()
					.get("selectedTipoIdentificacion"));

			Long idTiid = new Long(selectedTipoIdentificacion.getIdTiid());
			entity = businessDelegatorView.getTipoIdentificacion(idTiid);
			businessDelegatorView.deleteTipoIdentificacion(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedTipoIdentificacion);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, String descripcion,
			String estadoRegistro, Date fechaCreacion, Date fechaModificacion,
			Long idTiid, String operCreador, String operModifica)
			throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setDescripcion(FacesUtils.checkString(descripcion));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateTipoIdentificacion(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("TipoIdentificacionView").requestRender();
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

	public InputText getTxtIdTiid() {
		return txtIdTiid;
	}

	public void setTxtIdTiid(InputText txtIdTiid) {
		this.txtIdTiid = txtIdTiid;
	}

	public List<TipoIdentificacionDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataTipoIdentificacion();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<TipoIdentificacionDTO> tipoIdentificacionDTO) {
		this.data = tipoIdentificacionDTO;
	}

	public TipoIdentificacionDTO getSelectedTipoIdentificacion() {
		return selectedTipoIdentificacion;
	}

	public void setSelectedTipoIdentificacion(
			TipoIdentificacionDTO tipoIdentificacion) {
		this.selectedTipoIdentificacion = tipoIdentificacion;
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

	public String getIdTiid() {
		return idTiid;
	}

	public void setIdTiid(String idTiid) {
		this.idTiid = idTiid;
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

}
