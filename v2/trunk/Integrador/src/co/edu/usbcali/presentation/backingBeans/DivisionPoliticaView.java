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

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.DivisionPolitica;
import co.edu.usbcali.modelo.dto.DivisionPoliticaDTO;
import co.edu.usbcali.modelo.dto.TipoDivisionDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class DivisionPoliticaView {
	private InputText txtCodigoDian;
	private SelectOneMenu estado;
	private InputText txtNombre;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private SelectOneMenu txtIdDipo_DivisionPolitica;
	private SelectOneMenu txtIdTidi_TipoDivision;
	private InputText txtIdDipo;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;

	private String codigoDian;
	private String estadoRegistro;
	private String nombre;
	private String operCreador;
	private String operModifica;
	private String idDipo_DivisionPolitica;
	private Long idTidi_TipoDivision;
	private String idDipo;
	private String fechaCreacion;
	private String fechaModificacion;

	private Map<String, String> divisionPolitica = new HashMap<String, String>();
	private Map<String, String> tipoDivision = new HashMap<String, String>();

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DivisionPoliticaDTO> data;
	private DivisionPoliticaDTO selectedDivisionPolitica;
	private DivisionPolitica entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private SelectItem[] manufacturerOptions;

	String manufacturers[] = { "A", "R" };

	public DivisionPoliticaView() {
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
					.getDivisionPolitica(((DivisionPoliticaDTO) event
							.getObject()).getIdDipo());

			entity.setNombre(((DivisionPoliticaDTO) event.getObject())
					.getNombre());
			entity.setCodigoDian(((DivisionPoliticaDTO) event.getObject())
					.getCodigoDian());

			entity.setEstadoRegistro(estadoRegistro);
			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);
			entity.setFechaModificacion(new Date());

			entity.setTipoDivision(businessDelegatorView
					.getTipoDivision(getIdTidi_TipoDivision()));
			
			DivisionPolitica entity2 = businessDelegatorView.getDivisionPolitica(Long.parseLong(idDipo_DivisionPolitica));
			
			if (txtIdDipo_DivisionPolitica.getValue() == "999") {
				
				entity.setDivisionPolitica(null);
			} else {
				System.out.println("entro else");
				
				entity.setDivisionPolitica(entity2);
			}

			businessDelegatorView.updateDivisionPolitica(entity);
			try {
				divisionPolitica = new HashMap<String, String>();
				List<DivisionPoliticaDTO> data2 = businessDelegatorView
						.getDataDivisionPolitica();

				for (int i = 0; i < data2.size(); i++) {
					divisionPolitica.put(data2.get(i).getNombre(), data2.get(i)
							.getIdDipo() + "");

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			data = businessDelegatorView.getDataDivisionPolitica();
			RequestContext.getCurrentInstance().update("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("TipoEstado Cancelled",
				((DivisionPoliticaDTO) event.getObject()).getIdDipo() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((DivisionPoliticaDTO) event.getObject()).getIdDipo());

		RequestContext.getCurrentInstance().reset("form:tablaPrincipal");

		reload();

	}

	public String reload() {
		System.out.println("Entro a reload");

		return "divisionPolitica.xhtml?faces-redirect=true";

	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DivisionPoliticaDTO divisionPoliticaDTO = (DivisionPoliticaDTO) e
					.getObject();

			if (txtCodigoDian == null) {
				txtCodigoDian = new InputText();
			}

			txtCodigoDian.setValue(divisionPoliticaDTO.getCodigoDian());

			/*
			 * if (txtEstadoRegistro == null) { txtEstadoRegistro = new
			 * InputText(); }
			 * 
			 * txtEstadoRegistro.setValue(divisionPoliticaDTO.getEstadoRegistro()
			 * );
			 */

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(divisionPoliticaDTO.getNombre());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(divisionPoliticaDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(divisionPoliticaDTO.getOperModifica());

			if (txtIdDipo_DivisionPolitica == null) {
				txtIdDipo_DivisionPolitica = new SelectOneMenu();
			}

			txtIdDipo_DivisionPolitica.setValue(divisionPoliticaDTO
					.getIdDipo_DivisionPolitica());

			if (txtIdTidi_TipoDivision == null) {
				txtIdTidi_TipoDivision = new SelectOneMenu();
			}

			txtIdTidi_TipoDivision.setValue(divisionPoliticaDTO
					.getIdTidi_TipoDivision());

			if (txtIdDipo == null) {
				txtIdDipo = new InputText();
			}

			txtIdDipo.setValue(divisionPoliticaDTO.getIdDipo());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(divisionPoliticaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(divisionPoliticaDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedDivisionPolitica = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDivisionPolitica = null;

		if (txtCodigoDian != null) {
			txtCodigoDian.setValue(null);
			// txtCodigoDian.setDisabled(true);
		}

		/*
		 * if (txtEstadoRegistro != null) { txtEstadoRegistro.setValue(null);
		 * txtEstadoRegistro.setDisabled(true); }
		 */

		if (txtNombre != null) {
			txtNombre.setValue(null);
			// txtNombre.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			// txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			// txtOperModifica.setDisabled(true);
		}

		if (txtIdDipo_DivisionPolitica != null) {
			txtIdDipo_DivisionPolitica.setValue(null);
			// txtIdDipo_DivisionPolitica.setDisabled(true);
		}

		if (txtIdTidi_TipoDivision != null) {
			txtIdTidi_TipoDivision.setValue(null);
			// txtIdTidi_TipoDivision.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			// txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			// txtFechaModificacion.setDisabled(true);
		}

		if (txtIdDipo != null) {
			txtIdDipo.setValue(null);
			// txtIdDipo.setDisabled(false);
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
			Long idDipo = new Long(txtIdDipo.getValue().toString());
			entity = businessDelegatorView.getDivisionPolitica(idDipo);
		} catch (Exception e) {

		}

		if (entity == null) {
			txtCodigoDian.setDisabled(false);
			txtNombre.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdDipo_DivisionPolitica.setDisabled(false);
			txtIdTidi_TipoDivision.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdDipo.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigoDian.setValue(entity.getCodigoDian());
			txtCodigoDian.setDisabled(false);
			// txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			// txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdDipo_DivisionPolitica.setValue(entity.getDivisionPolitica()
					.getIdDipo());
			txtIdDipo_DivisionPolitica.setDisabled(false);
			txtIdTidi_TipoDivision.setValue(entity.getTipoDivision()
					.getIdTidi());
			txtIdTidi_TipoDivision.setDisabled(false);
			txtIdDipo.setValue(entity.getIdDipo());
			txtIdDipo.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedDivisionPolitica = (DivisionPoliticaDTO) (evt.getComponent()
				.getAttributes().get("selectedDivisionPolitica"));
		txtCodigoDian.setValue(selectedDivisionPolitica.getCodigoDian());
		txtCodigoDian.setDisabled(false);
		/*
		 * txtEstadoRegistro
		 * .setValue(selectedDivisionPolitica.getEstadoRegistro());
		 */
		// txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedDivisionPolitica.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedDivisionPolitica
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtNombre.setValue(selectedDivisionPolitica.getNombre());
		txtNombre.setDisabled(false);
		txtOperCreador.setValue(selectedDivisionPolitica.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedDivisionPolitica.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdDipo_DivisionPolitica.setValue(selectedDivisionPolitica
				.getIdDipo_DivisionPolitica());
		txtIdDipo_DivisionPolitica.setDisabled(false);
		txtIdTidi_TipoDivision.setValue(selectedDivisionPolitica
				.getIdTidi_TipoDivision());
		txtIdTidi_TipoDivision.setDisabled(false);
		txtIdDipo.setValue(selectedDivisionPolitica.getIdDipo());
		txtIdDipo.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedDivisionPolitica == null) && (entity == null)) {
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
			entity = new DivisionPolitica();
			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			// Long idDipo = new Long(txtIdDipo.getValue().toString());

			entity.setCodigoDian(FacesUtils.checkString(txtCodigoDian));
			entity.setNombre(FacesUtils.checkString(txtNombre));

			entity.setEstadoRegistro(estadoRegistro);
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);

			entity.setTipoDivision(businessDelegatorView
					.getTipoDivision(FacesUtils
							.checkLong(txtIdTidi_TipoDivision)));

			if (txtIdDipo_DivisionPolitica.getValue() == "") {

			} else {

				entity.setDivisionPolitica(businessDelegatorView
						.getDivisionPolitica(FacesUtils
								.checkLong(txtIdDipo_DivisionPolitica)));
			}

			/*
			 * DivisionPolitica entity2 = businessDelegatorView
			 * .getDivisionPolitica(getIdDipo_DivisionPolitica());
			 * entity.setDivisionPolitica(entity2);
			 * 
			 * TipoDivision entity3 =
			 * businessDelegatorView.getTipoDivision(getIdTidi_TipoDivision());
			 * entity.setTipoDivision(entity3);
			 */

			businessDelegatorView.saveDivisionPolitica(entity);
			data = businessDelegatorView.getDataDivisionPolitica();
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
				Long idDipo = new Long(selectedDivisionPolitica.getIdDipo());
				entity = businessDelegatorView.getDivisionPolitica(idDipo);
			}

			entity.setCodigoDian(FacesUtils.checkString(txtCodigoDian));
			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setDivisionPolitica(businessDelegatorView
					.getDivisionPolitica(FacesUtils
							.checkLong(txtIdDipo_DivisionPolitica)));
			entity.setTipoDivision(businessDelegatorView
					.getTipoDivision(FacesUtils
							.checkLong(txtIdTidi_TipoDivision)));
			businessDelegatorView.updateDivisionPolitica(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedDivisionPolitica = (DivisionPoliticaDTO) (evt
					.getComponent().getAttributes()
					.get("selectedDivisionPolitica"));

			Long idDipo = new Long(selectedDivisionPolitica.getIdDipo());
			entity = businessDelegatorView.getDivisionPolitica(idDipo);
			businessDelegatorView.deleteDivisionPolitica(entity);
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
			selectedDivisionPolitica = (DivisionPoliticaDTO) (evt
					.getComponent().getAttributes()
					.get("selectedDivisionPolitica"));

			Long idDipo = new Long(selectedDivisionPolitica.getIdDipo());
			entity = businessDelegatorView.getDivisionPolitica(idDipo);
			businessDelegatorView.deleteDivisionPolitica(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedDivisionPolitica);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigoDian, String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idDipo,
			String nombre, String operCreador, String operModifica,
			Long idDipo_DivisionPolitica, Long idTidi_TipoDivision)
			throws Exception {
		try {
			entity.setCodigoDian(FacesUtils.checkString(codigoDian));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateDivisionPolitica(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DivisionPoliticaView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtCodigoDian() {
		return txtCodigoDian;
	}

	public void setTxtCodigoDian(InputText txtCodigoDian) {
		this.txtCodigoDian = txtCodigoDian;
	}

	/*
	 * public InputText getTxtEstadoRegistro() { return txtEstadoRegistro; }
	 * 
	 * public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
	 * this.txtEstadoRegistro = txtEstadoRegistro; }
	 */

	public InputText getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(InputText txtNombre) {
		this.txtNombre = txtNombre;
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

	public SelectOneMenu getTxtIdDipo_DivisionPolitica() {
		return txtIdDipo_DivisionPolitica;
	}

	public void setTxtIdDipo_DivisionPolitica(
			SelectOneMenu txtIdDipo_DivisionPolitica) {
		this.txtIdDipo_DivisionPolitica = txtIdDipo_DivisionPolitica;
	}

	public SelectOneMenu getTxtIdTidi_TipoDivision() {
		return txtIdTidi_TipoDivision;
	}

	public void setTxtIdTidi_TipoDivision(SelectOneMenu txtIdTidi_TipoDivision) {
		this.txtIdTidi_TipoDivision = txtIdTidi_TipoDivision;
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

	public InputText getTxtIdDipo() {
		return txtIdDipo;
	}

	public void setTxtIdDipo(InputText txtIdDipo) {
		this.txtIdDipo = txtIdDipo;
	}

	public List<DivisionPoliticaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDivisionPolitica();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DivisionPoliticaDTO> divisionPoliticaDTO) {
		this.data = divisionPoliticaDTO;
	}

	public DivisionPoliticaDTO getSelectedDivisionPolitica() {
		return selectedDivisionPolitica;
	}

	public void setSelectedDivisionPolitica(DivisionPoliticaDTO divisionPolitica) {
		this.selectedDivisionPolitica = divisionPolitica;
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

	public String getCodigoDian() {
		return codigoDian;
	}

	public void setCodigoDian(String codigoDian) {
		this.codigoDian = codigoDian;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getIdDipo_DivisionPolitica() {
		return idDipo_DivisionPolitica;
	}

	public void setIdDipo_DivisionPolitica(String idDipo_DivisionPolitica) {
		this.idDipo_DivisionPolitica = idDipo_DivisionPolitica;
	}

	public Long getIdTidi_TipoDivision() {
		return idTidi_TipoDivision;
	}

	public void setIdTidi_TipoDivision(Long idTidi_TipoDivision) {
		this.idTidi_TipoDivision = idTidi_TipoDivision;
	}

	public String getIdDipo() {
		return idDipo;
	}

	public void setIdDipo(String idDipo) {
		this.idDipo = idDipo;
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

	public Map<String, String> getDivisionPolitica() {
		try {
			List<DivisionPoliticaDTO> data2 = businessDelegatorView
					.getDataDivisionPolitica();

			for (int i = 0; i < data2.size(); i++) {
				divisionPolitica.put(data2.get(i).getNombre(), data2.get(i)
						.getIdDipo() + "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return divisionPolitica;
	}

	public void setDivisionPolitica(Map<String, String> divisionPolitica) {
		this.divisionPolitica = divisionPolitica;
	}

	public Map<String, String> getTipoDivision() {
		try {
			List<TipoDivisionDTO> data3 = businessDelegatorView
					.getDataTipoDivision();

			for (int i = 0; i < data3.size(); i++) {
				tipoDivision.put(data3.get(i).getNombre(), data3.get(i)
						.getIdTidi() + "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tipoDivision;
	}

	public void setTipoDivision(Map<String, String> tipoDivision) {
		this.tipoDivision = tipoDivision;
	}

}
