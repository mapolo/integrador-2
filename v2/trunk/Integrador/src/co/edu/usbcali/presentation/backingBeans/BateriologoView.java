package co.edu.usbcali.presentation.backingBeans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.Bateriologo;
import co.edu.usbcali.modelo.Sucursal;
import co.edu.usbcali.modelo.dto.BateriologoDTO;
import co.edu.usbcali.modelo.dto.CompaniaDTO;
import co.edu.usbcali.modelo.dto.EmpresaDTO;
import co.edu.usbcali.modelo.dto.SucursalDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class BateriologoView {
	private InputText txtCodigo;
	private SelectOneMenu estado;
	private InputTextarea txtNombreCompleto;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private SelectOneMenu txtIdSucu_Sucursal;
	private InputText txtIdBate;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;

	private String codigo;
	private String estadoRegistro;
	private String nombreCompleto;
	private String operCreador;
	private String operModifica;
	private Long idSucu_Sucursal;
	private String idBate;
	private String fechaCreacion;
	private String fechaModificacion;

	private Map<String, String> sucursal = new HashMap<String, String>();

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnModify2;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<BateriologoDTO> data;
	private BateriologoDTO selectedBateriologo;
	private BateriologoDataModel bateriologoModel;
	private SucursalDTO selectedSucursal;
	private SucursalDataModel sucusalPadreModel;
	private Bateriologo entity;
	List<SucursalDTO> data5 = new ArrayList<SucursalDTO>();
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectItem[] manufacturerOptions;

	String manufacturers[] = { "A", "R" };

	public BateriologoView() {
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

	public String selectSucu() {
		selectedSucursal = null;

		return "";
	}

	public void onEdit(org.primefaces.event.RowEditEvent event) {

		try {

			entity = null;
			entity = businessDelegatorView
					.getBateriologo(((BateriologoDTO) event.getObject())
							.getIdBate());

			entity.setFechaModificacion(new Date());
			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);

			entity.setCodigo(((BateriologoDTO) event.getObject()).getCodigo());
			nombreCompleto = ((BateriologoDTO) event.getObject())
					.getNombreCompleto();
			entity.setNombreCompleto(nombreCompleto);
			entity.setEstadoRegistro(estadoRegistro);

			Sucursal entity2 = businessDelegatorView
					.getSucursal(getIdSucu_Sucursal());
			entity.setSucursal(entity2);

			businessDelegatorView.updateBateriologo(entity);
			data = businessDelegatorView.getDataBateriologo();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Cancelled",
				((BateriologoDTO) event.getObject()).getIdBate() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((BateriologoDTO) event.getObject()).getIdBate());
	}

	public String quitSelect() {
		selectedSucursal = null;

		return "";
	}

	public String action_modify2() {
		try {

			btnSave.setDisabled(true);
			btnModify.setDisabled(false);

			try {
				txtCodigo.setValue(selectedBateriologo.getCodigo());

			} catch (Exception e) {
				txtCodigo.setValue("");
			}

			try {
				txtNombreCompleto.setValue(selectedBateriologo
						.getNombreCompleto());
			} catch (Exception e) {
				txtNombreCompleto.setValue("");
			}

			try {
				estado.setValue(selectedBateriologo.getEstadoRegistro());
			} catch (Exception e) {
				estado.setValue("");
			}

			try {
				List<SucursalDTO> data3 = businessDelegatorView
						.getDataSucursal();

				for (int i = 0; i < data3.size(); i++) {
					if (data3.get(i).getIdSucu() == selectedBateriologo
							.getIdSucu_Sucursal()) {
						selectedSucursal = data3.get(i);

						System.out.println("if" + data3.get(i));
						break;
					}
				}

			} catch (Exception e) {

			}

			txtIdBate.setValue(selectedBateriologo.getIdBate());

		} catch (Exception e) {
			if (selectedBateriologo == null) {
				FacesUtils
						.addErrorMessage("Seleccione Bateriologo a Modificar");
			}
		}
		return "";

	}

	public String action_VCrear() {

		btnModify.setDisabled(true);
		btnSave.setDisabled(false);

		try {
			txtCodigo.setValue(null);

		} catch (Exception e) {
			txtCodigo.setValue(null);
		}

		try {
			txtNombreCompleto.setValue(null);
		} catch (Exception e) {
			txtNombreCompleto.setValue("");
		}

		selectedBateriologo = null;
		selectedSucursal = null;

		return "";
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			BateriologoDTO bateriologoDTO = (BateriologoDTO) e.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(bateriologoDTO.getCodigo());

			/*
			 * if (txtEstadoRegistro == null) { txtEstadoRegistro = new
			 * InputText(); }
			 * 
			 * txtEstadoRegistro.setValue(bateriologoDTO.getEstadoRegistro());
			 */

			if (txtNombreCompleto == null) {
				txtNombreCompleto = new InputTextarea();
			}

			txtNombreCompleto.setValue(bateriologoDTO.getNombreCompleto());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(bateriologoDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(bateriologoDTO.getOperModifica());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new SelectOneMenu();
			}

			txtIdSucu_Sucursal.setValue(bateriologoDTO.getIdSucu_Sucursal());

			if (txtIdBate == null) {
				txtIdBate = new InputText();
			}

			txtIdBate.setValue(bateriologoDTO.getIdBate());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(bateriologoDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion
					.setValue(bateriologoDTO.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedBateriologo = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedBateriologo = null;

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			// txtCodigo.setDisabled(true);
		}

		/*
		 * if (txtEstadoRegistro != null) { txtEstadoRegistro.setValue(null);
		 * txtEstadoRegistro.setDisabled(true); }
		 */

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

		if (txtIdSucu_Sucursal != null) {
			txtIdSucu_Sucursal.setValue(null);
			// txtIdSucu_Sucursal.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			// txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			// txtFechaModificacion.setDisabled(true);
		}

		if (txtIdBate != null) {
			txtIdBate.setValue(null);
			// txtIdBate.setDisabled(false);
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
			Long idBate = new Long(txtIdBate.getValue().toString());
			entity = businessDelegatorView.getBateriologo(idBate);
		} catch (Exception e) {

		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtNombreCompleto.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdSucu_Sucursal.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdBate.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
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
			txtIdSucu_Sucursal.setValue(entity.getSucursal().getIdSucu());
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdBate.setValue(entity.getIdBate());
			txtIdBate.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedBateriologo = (BateriologoDTO) (evt.getComponent()
				.getAttributes().get("selectedBateriologo"));
		txtCodigo.setValue(selectedBateriologo.getCodigo());
		txtCodigo.setDisabled(false);
		// txtEstadoRegistro.setValue(selectedBateriologo.getEstadoRegistro());
		// txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedBateriologo.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedBateriologo
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtNombreCompleto.setValue(selectedBateriologo.getNombreCompleto());
		txtNombreCompleto.setDisabled(false);
		txtOperCreador.setValue(selectedBateriologo.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedBateriologo.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdSucu_Sucursal.setValue(selectedBateriologo.getIdSucu_Sucursal());
		txtIdSucu_Sucursal.setDisabled(false);
		txtIdBate.setValue(selectedBateriologo.getIdBate());
		txtIdBate.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedBateriologo == null) && (entity == null)) {
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
			entity = new Bateriologo();

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			// Long idBate = new Long(txtIdBate.getValue().toString());

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setEstadoRegistro(estadoRegistro);

			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);

			// entity.setIdBate(idBate);
			entity.setNombreCompleto(FacesUtils.checkString(txtNombreCompleto));
			// entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			// entity.setOperModifica(FacesUtils.checkString(txtOperModifica));

			/*
			 * entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
			 * .checkLong(txtIdSucu_Sucursal)));
			 */

			/*
			 * Sucursal entity2 = businessDelegatorView
			 * .getSucursal(getIdSucu_Sucursal());
			 * 
			 * entity.setSucursal(entity2);
			 */

			if (selectedSucursal != null) {
				entity.setSucursal(businessDelegatorView
						.getSucursal(selectedSucursal.getIdSucu()));
			}

			businessDelegatorView.saveBateriologo(entity);
			data = businessDelegatorView.getDataBateriologo();
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
			action_clear();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public Long idForanea() {

		try {
			List<SucursalDTO> data2 = businessDelegatorView.getDataSucursal();

			for (int i = 0; i < data2.size(); i++) {
				if (txtIdSucu_Sucursal.getValue().equals(
						data2.get(i).getNombre())) {
					return data2.get(i).getIdSucu();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0L;
	}

	public String action_modify() {
		try {
			if (entity == null) {
				Long idBate = new Long(selectedBateriologo.getIdBate());
				entity = businessDelegatorView.getBateriologo(idBate);
			}

			Long idBate = new Long(selectedBateriologo.getIdBate());
			entity = businessDelegatorView.getBateriologo(idBate);

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setEstadoRegistro(estadoRegistro);

			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);

			entity.setNombreCompleto(FacesUtils.checkString(txtNombreCompleto));

			/*
			 * Sucursal entity2 = businessDelegatorView
			 * .getSucursal(getIdSucu_Sucursal());
			 * 
			 * entity.setSucursal(entity2);
			 */

			if (selectedSucursal != null) {
				entity.setSucursal(businessDelegatorView
						.getSucursal(selectedSucursal.getIdSucu()));
			} else {
				entity.setSucursal(null);
			}

			businessDelegatorView.updateBateriologo(entity);
			data = businessDelegatorView.getDataBateriologo();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedBateriologo = (BateriologoDTO) (evt.getComponent()
					.getAttributes().get("selectedBateriologo"));

			Long idBate = new Long(selectedBateriologo.getIdBate());
			entity = businessDelegatorView.getBateriologo(idBate);
			businessDelegatorView.deleteBateriologo(entity);
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
			selectedBateriologo = (BateriologoDTO) (evt.getComponent()
					.getAttributes().get("selectedBateriologo"));

			Long idBate = new Long(selectedBateriologo.getIdBate());
			entity = businessDelegatorView.getBateriologo(idBate);
			businessDelegatorView.deleteBateriologo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedBateriologo);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idBate,
			String nombreCompleto, String operCreador, String operModifica,
			Long idSucu_Sucursal) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setNombreCompleto(FacesUtils.checkString(nombreCompleto));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateBateriologo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("BateriologoView").requestRender();
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

	/*
	 * public InputText getTxtEstadoRegistro() { return txtEstadoRegistro; }
	 * 
	 * public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
	 * this.txtEstadoRegistro = txtEstadoRegistro; }
	 */

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

	public SelectOneMenu getTxtIdSucu_Sucursal() {
		return txtIdSucu_Sucursal;
	}

	public void setTxtIdSucu_Sucursal(SelectOneMenu txtIdSucu_Sucursal) {
		this.txtIdSucu_Sucursal = txtIdSucu_Sucursal;
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

	public InputText getTxtIdBate() {
		return txtIdBate;
	}

	public void setTxtIdBate(InputText txtIdBate) {
		this.txtIdBate = txtIdBate;
	}

	public List<BateriologoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataBateriologo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<BateriologoDTO> bateriologoDTO) {
		this.data = bateriologoDTO;
	}

	public BateriologoDTO getSelectedBateriologo() {
		return selectedBateriologo;
	}

	public void setSelectedBateriologo(BateriologoDTO bateriologo) {
		this.selectedBateriologo = bateriologo;
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

	public Long getIdSucu_Sucursal() {
		return idSucu_Sucursal;
	}

	public void setIdSucu_Sucursal(Long idSucu_Sucursal) {
		this.idSucu_Sucursal = idSucu_Sucursal;
	}

	public String getIdBate() {
		return idBate;
	}

	public void setIdBate(String idBate) {
		this.idBate = idBate;
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

	public Map<String, String> getSucursal() {
		try {
			List<SucursalDTO> data2 = businessDelegatorView.getDataSucursal();

			for (int i = 0; i < data2.size(); i++) {
				sucursal.put(data2.get(i).getNombre(), data2.get(i).getIdSucu()
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public CommandButton getBtnModify2() {
		return btnModify2;
	}

	public void setBtnModify2(CommandButton btnModify2) {
		this.btnModify2 = btnModify2;
	}

	public SucursalDTO getSelectedSucursal() {
		return selectedSucursal;
	}

	public void setSelectedSucursal(SucursalDTO selectedSucursal) {
		this.selectedSucursal = selectedSucursal;
	}

	public BateriologoDataModel getBateriologoModel() {
		return bateriologoModel;
	}

	public void setBateriologoModel(BateriologoDataModel bateriologoModel) {
		this.bateriologoModel = bateriologoModel;
	}

	public SucursalDataModel getSucusalPadreModel() {

		if (data5.isEmpty()) {

			try {

				System.out.println("entro try");

				List<EmpresaDTO> data2 = businessDelegatorView.getDataEmpresa();
				List<CompaniaDTO> data3 = businessDelegatorView
						.getDataCompania();

				List<EmpresaDTO> empresaCompania = new ArrayList<EmpresaDTO>();
				for (int i = 0; i < data3.size(); i++) {
					for (int j = 0; j < data2.size(); j++) {
						if (data3.get(i).getIdEmpr_Empresa() == data2.get(j)
								.getIdEmpr()) {
							empresaCompania.add(data2.get(j));
							break;
						}
					}
				}
				List<SucursalDTO> data4 = businessDelegatorView
						.getDataSucursal();

				for (int i = 0; i < empresaCompania.size(); i++) {
					for (int j = 0; j < data4.size(); j++) {
						try {
							if (data4.get(j).getIdEmpr_Empresa() == empresaCompania
									.get(i).getIdEmpr()) {
								data5.add(data4.get(j));
								break;
							}
						} catch (Exception e) {
						}

					}
				}
				sucusalPadreModel = new SucursalDataModel(data5);

			} catch (Exception e) {

				System.out.println("catch modelo");
			}
		}

		return sucusalPadreModel;
	}

	public void setSucusalPadreModel(SucursalDataModel sucusalPadreModel) {
		this.sucusalPadreModel = sucusalPadreModel;
	}

}
