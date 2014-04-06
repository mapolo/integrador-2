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

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.RutaDistribucion;
import co.edu.usbcali.modelo.dto.ListaPreciosDTO;
import co.edu.usbcali.modelo.dto.RutaDistribucionDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class RutaDistribucionView {
	private InputText txtCodigo;
	private InputTextarea txtDescripcion;
	//private InputText txtEstadoRegistro;
	private SelectOneMenu estado;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtTiempoEntrega;
	private InputText txtTiempoTransporte;
	private InputText txtIdRudi;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;
	
	private String codigo;
	private String descripcion;
	private String estadoRegistro;
	private String operCreador;
	private String operModifica;
	private String tiempoEntrega;
	private String tiempoTransporte;
	private String idRudi;
	private String fechaCreacion;
	private String fechaModificacion;
	
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<RutaDistribucionDTO> data;
	private RutaDistribucionDTO selectedRutaDistribucion;
	private RutaDistribucion entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private SelectItem[] manufacturerOptions;

	String manufacturers[] = { "A", "R" };

	public RutaDistribucionView() {
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
			entity = businessDelegatorView
					.getRutaDistribucion(((RutaDistribucionDTO) event.getObject())
							.getIdRudi());

			entity.setEstadoRegistro(estadoRegistro);
			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);
			entity.setFechaModificacion(new Date());

			entity.setCodigo(((RutaDistribucionDTO) event.getObject()).getCodigo());
			entity.setDescripcion(((RutaDistribucionDTO) event.getObject()).getDescripcion());
			entity.setTiempoEntrega(((RutaDistribucionDTO) event.getObject()).getTiempoEntrega());
			System.out.println("Entrega modi: " + ((RutaDistribucionDTO) event.getObject()).getTiempoEntrega() );
			
			entity.setTiempoTransporte(((RutaDistribucionDTO) event.getObject()).getTiempoTransporte());
			
		

			businessDelegatorView.updateRutaDistribucion(entity);
			data = businessDelegatorView.getDataRutaDistribucion();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("TipoEstado Cancelled",
				((RutaDistribucionDTO) event.getObject()).getIdRudi() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((RutaDistribucionDTO) event.getObject()).getIdRudi());
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			RutaDistribucionDTO rutaDistribucionDTO = (RutaDistribucionDTO) e
					.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(rutaDistribucionDTO.getCodigo());

			if (txtDescripcion == null) {
				txtDescripcion = new InputTextarea();
			}

			txtDescripcion.setValue(rutaDistribucionDTO.getDescripcion());

			/*if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(rutaDistribucionDTO.getEstadoRegistro());*/

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(rutaDistribucionDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(rutaDistribucionDTO.getOperModifica());

			if (txtTiempoEntrega == null) {
				txtTiempoEntrega = new InputText();
			}

			txtTiempoEntrega.setValue(rutaDistribucionDTO.getTiempoEntrega());

			if (txtTiempoTransporte == null) {
				txtTiempoTransporte = new InputText();
			}

			txtTiempoTransporte.setValue(rutaDistribucionDTO
					.getTiempoTransporte());

			if (txtIdRudi == null) {
				txtIdRudi = new InputText();
			}

			txtIdRudi.setValue(rutaDistribucionDTO.getIdRudi());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(rutaDistribucionDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(rutaDistribucionDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedRutaDistribucion = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedRutaDistribucion = null;

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			//txtCodigo.setDisabled(true);
		}

		if (txtDescripcion != null) {
			txtDescripcion.setValue(null);
			//txtDescripcion.setDisabled(true);
		}

		/*if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}*/

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			//txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			//txtOperModifica.setDisabled(true);
		}

		if (txtTiempoEntrega != null) {
			txtTiempoEntrega.setValue(null);
			//txtTiempoEntrega.setDisabled(true);
		}

		if (txtTiempoTransporte != null) {
			txtTiempoTransporte.setValue(null);
			//txtTiempoTransporte.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			//txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			//txtFechaModificacion.setDisabled(true);
		}

		if (txtIdRudi != null) {
			txtIdRudi.setValue(null);
			//txtIdRudi.setDisabled(false);
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
			Long idRudi = new Long(txtIdRudi.getValue().toString());
			entity = businessDelegatorView.getRutaDistribucion(idRudi);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtDescripcion.setDisabled(false);
			//txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtTiempoEntrega.setDisabled(false);
			txtTiempoTransporte.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdRudi.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtDescripcion.setValue(entity.getDescripcion());
			txtDescripcion.setDisabled(false);
			//txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			//txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtTiempoEntrega.setValue(entity.getTiempoEntrega());
			txtTiempoEntrega.setDisabled(false);
			txtTiempoTransporte.setValue(entity.getTiempoTransporte());
			txtTiempoTransporte.setDisabled(false);
			txtIdRudi.setValue(entity.getIdRudi());
			txtIdRudi.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedRutaDistribucion = (RutaDistribucionDTO) (evt.getComponent()
				.getAttributes().get("selectedRutaDistribucion"));
		txtCodigo.setValue(selectedRutaDistribucion.getCodigo());
		txtCodigo.setDisabled(false);
		txtDescripcion.setValue(selectedRutaDistribucion.getDescripcion());
		txtDescripcion.setDisabled(false);
		/*txtEstadoRegistro
				.setValue(selectedRutaDistribucion.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);*/
		txtFechaCreacion.setValue(selectedRutaDistribucion.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedRutaDistribucion
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedRutaDistribucion.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedRutaDistribucion.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtTiempoEntrega.setValue(selectedRutaDistribucion.getTiempoEntrega());
		txtTiempoEntrega.setDisabled(false);
		txtTiempoTransporte.setValue(selectedRutaDistribucion
				.getTiempoTransporte());
		txtTiempoTransporte.setDisabled(false);
		txtIdRudi.setValue(selectedRutaDistribucion.getIdRudi());
		txtIdRudi.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedRutaDistribucion == null) && (entity == null)) {
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
			entity = new RutaDistribucion();

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			//Long idRudi = new Long(txtIdRudi.getValue().toString());

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			entity.setTiempoEntrega(FacesUtils.checkDouble(txtTiempoEntrega));
			System.out.println("Tiempo entrega create " + FacesUtils.checkDouble(txtTiempoEntrega));
			entity.setTiempoTransporte(FacesUtils
					.checkDouble(txtTiempoTransporte));	
			
			entity.setEstadoRegistro(estadoRegistro);
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			
			businessDelegatorView.saveRutaDistribucion(entity);
			data = businessDelegatorView.getDataRutaDistribucion();
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
				Long idRudi = new Long(selectedRutaDistribucion.getIdRudi());
				entity = businessDelegatorView.getRutaDistribucion(idRudi);
			}

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			//entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setTiempoEntrega(FacesUtils.checkDouble(txtTiempoEntrega));
			entity.setTiempoTransporte(FacesUtils
					.checkDouble(txtTiempoTransporte));
			businessDelegatorView.updateRutaDistribucion(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedRutaDistribucion = (RutaDistribucionDTO) (evt
					.getComponent().getAttributes()
					.get("selectedRutaDistribucion"));

			Long idRudi = new Long(selectedRutaDistribucion.getIdRudi());
			entity = businessDelegatorView.getRutaDistribucion(idRudi);
			businessDelegatorView.deleteRutaDistribucion(entity);
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
			selectedRutaDistribucion = (RutaDistribucionDTO) (evt
					.getComponent().getAttributes()
					.get("selectedRutaDistribucion"));

			Long idRudi = new Long(selectedRutaDistribucion.getIdRudi());
			entity = businessDelegatorView.getRutaDistribucion(idRudi);
			businessDelegatorView.deleteRutaDistribucion(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedRutaDistribucion);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, String descripcion,
			String estadoRegistro, Date fechaCreacion, Date fechaModificacion,
			Long idRudi, String operCreador, String operModifica,
			Double tiempoEntrega, Double tiempoTransporte) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setDescripcion(FacesUtils.checkString(descripcion));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setTiempoEntrega(FacesUtils.checkDouble(tiempoEntrega));
			entity.setTiempoTransporte(FacesUtils.checkDouble(tiempoTransporte));
			businessDelegatorView.updateRutaDistribucion(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("RutaDistribucionView").requestRender();
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

	/*public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}*/

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

	public InputText getTxtTiempoEntrega() {
		return txtTiempoEntrega;
	}

	public void setTxtTiempoEntrega(InputText txtTiempoEntrega) {
		this.txtTiempoEntrega = txtTiempoEntrega;
	}

	public InputText getTxtTiempoTransporte() {
		return txtTiempoTransporte;
	}

	public void setTxtTiempoTransporte(InputText txtTiempoTransporte) {
		this.txtTiempoTransporte = txtTiempoTransporte;
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

	public InputText getTxtIdRudi() {
		return txtIdRudi;
	}

	public void setTxtIdRudi(InputText txtIdRudi) {
		this.txtIdRudi = txtIdRudi;
	}

	public List<RutaDistribucionDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataRutaDistribucion();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<RutaDistribucionDTO> rutaDistribucionDTO) {
		this.data = rutaDistribucionDTO;
	}

	public RutaDistribucionDTO getSelectedRutaDistribucion() {
		return selectedRutaDistribucion;
	}

	public void setSelectedRutaDistribucion(RutaDistribucionDTO rutaDistribucion) {
		this.selectedRutaDistribucion = rutaDistribucion;
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

	public String getTiempoEntrega() {
		return tiempoEntrega;
	}

	public void setTiempoEntrega(String tiempoEntrega) {
		this.tiempoEntrega = tiempoEntrega;
	}

	public String getTiempoTransporte() {
		return tiempoTransporte;
	}

	public void setTiempoTransporte(String tiempoTransporte) {
		this.tiempoTransporte = tiempoTransporte;
	}

	public String getIdRudi() {
		return idRudi;
	}

	public void setIdRudi(String idRudi) {
		this.idRudi = idRudi;
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
