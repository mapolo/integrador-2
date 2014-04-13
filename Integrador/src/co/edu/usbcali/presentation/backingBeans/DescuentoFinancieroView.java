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
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.DescuentoFinanciero;
import co.edu.usbcali.modelo.TipoFormaPago;
import co.edu.usbcali.modelo.dto.DescuentoFinancieroDTO;
import co.edu.usbcali.modelo.dto.GrupoDTO;
import co.edu.usbcali.modelo.dto.TipoFormaPagoDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class DescuentoFinancieroView {
	private InputText txtCodigo;
	private InputText txtDiaDesde;
	private InputText txtDiaHasta;
	private SelectOneMenu estado;
	private InputText txtNombre;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtPorcentajeDescuento;
	private SelectOneMenu txtIdGrpo_Grupo;
	private SelectOneMenu txtIdTfpa_TipoFormaPago;
	private InputText txtIdDefi;
	private InputText txtFechaCreacion;
	private Calendar txtFechaFinal;
	private Calendar txtFechaInicio;
	private InputText txtFechaModificacion;

	private String codigo;
	private String diaDesde;
	private String diaHasta;
	private String estadoRegistro;
	private String nombre;
	private String operCreador;
	private String operModifica;
	private String porcentajeDescuento;
	private Long idGrpo_Grupo;
	private String idTfpa_TipoFormaPago;
	private String idDefi;
	private String fechaCreacion;
	private String fechaFinal;
	private String fechaInicio;
	private String fechaModificacion;

	private Map<String, String> grupo = new HashMap<String, String>();
	private Map<String, String> tipoFormaPago = new HashMap<String, String>();

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DescuentoFinancieroDTO> data;
	private DescuentoFinancieroDTO selectedDescuentoFinanciero;
	private DescuentoFinanciero entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private SelectItem[] manufacturerOptions;

	String manufacturers[] = { "A", "R" };

	public DescuentoFinancieroView() {
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
					.getDescuentoFinanciero(((DescuentoFinancieroDTO) event
							.getObject()).getIdDefi());

			entity.setCodigo(((DescuentoFinancieroDTO) event.getObject())
					.getCodigo());
			entity.setNombre(((DescuentoFinancieroDTO) event.getObject())
					.getNombre());
			entity.setPorcentajeDescuento(((DescuentoFinancieroDTO) event
					.getObject()).getPorcentajeDescuento());
			entity.setDiaDesde(((DescuentoFinancieroDTO) event.getObject())
					.getDiaDesde());
			entity.setDiaHasta(((DescuentoFinancieroDTO) event.getObject())
					.getDiaHasta());

			Date fechaInicial = ((DescuentoFinancieroDTO) event.getObject())
					.getFechaInicio();
			entity.setFechaInicio(fechaInicial);

			Date fechaFinal = ((DescuentoFinancieroDTO) event.getObject())
					.getFechaFinal();
			entity.setFechaFinal(fechaFinal);

			entity.setEstadoRegistro(estadoRegistro);
			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);
			entity.setFechaModificacion(new Date());

			
			entity.setGrupo(businessDelegatorView.getGrupo(getIdGrpo_Grupo()));

			TipoFormaPago entity2 = businessDelegatorView.getTipoFormaPago(Long.parseLong(idTfpa_TipoFormaPago));
			System.out.println("1: " + txtIdTfpa_TipoFormaPago.getValue() +" 2: " + entity2);
			if (txtIdTfpa_TipoFormaPago.getValue() == "0") {
				System.out.println("entro if");
				entity.setTipoFormaPago(null);
			} else {
				System.out.println("Entro else");
				
				entity.setTipoFormaPago(entity2);
				
				/*entity.setTipoFormaPago(businessDelegatorView
						.getTipoFormaPago(FacesUtils
								.checkLong(txtIdTfpa_TipoFormaPago)));*/
			}

			businessDelegatorView.updateDescuentoFinanciero(entity);
			data = businessDelegatorView.getDataDescuentoFinanciero();
			RequestContext.getCurrentInstance().reset("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("TipoEstado Cancelled",
				((DescuentoFinancieroDTO) event.getObject()).getIdDefi() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((DescuentoFinancieroDTO) event.getObject()).getIdDefi());
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DescuentoFinancieroDTO descuentoFinancieroDTO = (DescuentoFinancieroDTO) e
					.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(descuentoFinancieroDTO.getCodigo());

			if (txtDiaDesde == null) {
				txtDiaDesde = new InputText();
			}

			txtDiaDesde.setValue(descuentoFinancieroDTO.getDiaDesde());

			if (txtDiaHasta == null) {
				txtDiaHasta = new InputText();
			}

			txtDiaHasta.setValue(descuentoFinancieroDTO.getDiaHasta());

			/*
			 * if (txtEstadoRegistro == null) { txtEstadoRegistro = new
			 * InputText(); }
			 * 
			 * txtEstadoRegistro.setValue(descuentoFinancieroDTO
			 * .getEstadoRegistro());
			 */

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(descuentoFinancieroDTO.getNombre());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(descuentoFinancieroDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(descuentoFinancieroDTO.getOperModifica());

			if (txtPorcentajeDescuento == null) {
				txtPorcentajeDescuento = new InputText();
			}

			txtPorcentajeDescuento.setValue(descuentoFinancieroDTO
					.getPorcentajeDescuento());

			if (txtIdGrpo_Grupo == null) {
				txtIdGrpo_Grupo = new SelectOneMenu();
			}

			txtIdGrpo_Grupo.setValue(descuentoFinancieroDTO.getIdGrpo_Grupo());

			if (txtIdTfpa_TipoFormaPago == null) {
				txtIdTfpa_TipoFormaPago = new SelectOneMenu();
			}

			txtIdTfpa_TipoFormaPago.setValue(descuentoFinancieroDTO
					.getIdTfpa_TipoFormaPago());

			if (txtIdDefi == null) {
				txtIdDefi = new InputText();
			}

			txtIdDefi.setValue(descuentoFinancieroDTO.getIdDefi());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion
					.setValue(descuentoFinancieroDTO.getFechaCreacion());

			if (txtFechaFinal == null) {
				txtFechaFinal = new Calendar();
			}

			txtFechaFinal.setValue(descuentoFinancieroDTO.getFechaFinal());

			if (txtFechaInicio == null) {
				txtFechaInicio = new Calendar();
			}

			txtFechaInicio.setValue(descuentoFinancieroDTO.getFechaInicio());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(descuentoFinancieroDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedDescuentoFinanciero = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDescuentoFinanciero = null;

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			// txtCodigo.setDisabled(true);
		}

		if (txtDiaDesde != null) {
			txtDiaDesde.setValue(null);
			// txtDiaDesde.setDisabled(true);
		}

		if (txtDiaHasta != null) {
			txtDiaHasta.setValue(null);
			// txtDiaHasta.setDisabled(true);
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

		if (txtPorcentajeDescuento != null) {
			txtPorcentajeDescuento.setValue(null);
			// txtPorcentajeDescuento.setDisabled(true);
		}

		if (txtIdGrpo_Grupo != null) {
			txtIdGrpo_Grupo.setValue(null);
			// txtIdGrpo_Grupo.setDisabled(true);
		}

		if (txtIdTfpa_TipoFormaPago != null) {
			txtIdTfpa_TipoFormaPago.setValue(null);
			// txtIdTfpa_TipoFormaPago.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			// txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaFinal != null) {
			txtFechaFinal.setValue(null);
			// txtFechaFinal.setDisabled(true);
		}

		if (txtFechaInicio != null) {
			txtFechaInicio.setValue(null);
			// txtFechaInicio.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			// txtFechaModificacion.setDisabled(true);
		}

		if (txtIdDefi != null) {
			txtIdDefi.setValue(null);
			// txtIdDefi.setDisabled(false);
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

	public void listener_txtFechaFinal() {
		Date inputDate = (Date) txtFechaFinal.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaInicio() {
		Date inputDate = (Date) txtFechaInicio.getValue();
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
			Long idDefi = new Long(txtIdDefi.getValue().toString());
			entity = businessDelegatorView.getDescuentoFinanciero(idDefi);
		} catch (Exception e) {

		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtDiaDesde.setDisabled(false);
			txtDiaHasta.setDisabled(false);
			txtNombre.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtPorcentajeDescuento.setDisabled(false);
			txtIdGrpo_Grupo.setDisabled(false);
			txtIdTfpa_TipoFormaPago.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtFechaInicio.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdDefi.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtDiaDesde.setValue(entity.getDiaDesde());
			txtDiaDesde.setDisabled(false);
			txtDiaHasta.setValue(entity.getDiaHasta());
			txtDiaHasta.setDisabled(false);
			// txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			// txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setValue(entity.getFechaFinal());
			txtFechaFinal.setDisabled(false);
			txtFechaInicio.setValue(entity.getFechaInicio());
			txtFechaInicio.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtPorcentajeDescuento.setValue(entity.getPorcentajeDescuento());
			txtPorcentajeDescuento.setDisabled(false);
			txtIdGrpo_Grupo.setValue(entity.getGrupo().getIdGrpo());
			txtIdGrpo_Grupo.setDisabled(false);
			txtIdTfpa_TipoFormaPago.setValue(entity.getTipoFormaPago()
					.getIdTfpa());
			txtIdTfpa_TipoFormaPago.setDisabled(false);
			txtIdDefi.setValue(entity.getIdDefi());
			txtIdDefi.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedDescuentoFinanciero = (DescuentoFinancieroDTO) (evt
				.getComponent().getAttributes()
				.get("selectedDescuentoFinanciero"));
		txtCodigo.setValue(selectedDescuentoFinanciero.getCodigo());
		txtCodigo.setDisabled(false);
		txtDiaDesde.setValue(selectedDescuentoFinanciero.getDiaDesde());
		txtDiaDesde.setDisabled(false);
		txtDiaHasta.setValue(selectedDescuentoFinanciero.getDiaHasta());
		txtDiaHasta.setDisabled(false);
		/*
		 * txtEstadoRegistro.setValue(selectedDescuentoFinanciero
		 * .getEstadoRegistro()); txtEstadoRegistro.setDisabled(false);
		 */
		txtFechaCreacion.setValue(selectedDescuentoFinanciero
				.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaFinal.setValue(selectedDescuentoFinanciero.getFechaFinal());
		txtFechaFinal.setDisabled(false);
		txtFechaInicio.setValue(selectedDescuentoFinanciero.getFechaInicio());
		txtFechaInicio.setDisabled(false);
		txtFechaModificacion.setValue(selectedDescuentoFinanciero
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtNombre.setValue(selectedDescuentoFinanciero.getNombre());
		txtNombre.setDisabled(false);
		txtOperCreador.setValue(selectedDescuentoFinanciero.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedDescuentoFinanciero.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtPorcentajeDescuento.setValue(selectedDescuentoFinanciero
				.getPorcentajeDescuento());
		txtPorcentajeDescuento.setDisabled(false);
		txtIdGrpo_Grupo.setValue(selectedDescuentoFinanciero.getIdGrpo_Grupo());
		txtIdGrpo_Grupo.setDisabled(false);
		txtIdTfpa_TipoFormaPago.setValue(selectedDescuentoFinanciero
				.getIdTfpa_TipoFormaPago());
		txtIdTfpa_TipoFormaPago.setDisabled(false);
		txtIdDefi.setValue(selectedDescuentoFinanciero.getIdDefi());
		txtIdDefi.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedDescuentoFinanciero == null) && (entity == null)) {
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
			System.out.println("Entro create");

			entity = new DescuentoFinanciero();

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			// Long idDefi = new Long(txtIdDefi.getValue().toString());

			entity.setCodigo(FacesUtils.checkLong(txtCodigo));
			entity.setDiaDesde(FacesUtils.checkLong(txtDiaDesde));
			entity.setDiaHasta(FacesUtils.checkLong(txtDiaHasta));
			entity.setEstadoRegistro(estadoRegistro);
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicio(FacesUtils.checkDate(txtFechaInicio));
			entity.setNombre(FacesUtils.checkString(txtNombre));

			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);

			entity.setPorcentajeDescuento(FacesUtils
					.checkDouble(txtPorcentajeDescuento));

			entity.setGrupo(businessDelegatorView.getGrupo(FacesUtils
					.checkLong(txtIdGrpo_Grupo)));

			if (txtIdTfpa_TipoFormaPago.getValue() == "") {

			} else {

				entity.setTipoFormaPago(businessDelegatorView
						.getTipoFormaPago(FacesUtils
								.checkLong(txtIdTfpa_TipoFormaPago)));
			}

			businessDelegatorView.saveDescuentoFinanciero(entity);
			data = businessDelegatorView.getDataDescuentoFinanciero();
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
				Long idDefi = new Long(selectedDescuentoFinanciero.getIdDefi());
				entity = businessDelegatorView.getDescuentoFinanciero(idDefi);
			}

			entity.setCodigo(FacesUtils.checkLong(txtCodigo));
			entity.setDiaDesde(FacesUtils.checkLong(txtDiaDesde));
			entity.setDiaHasta(FacesUtils.checkLong(txtDiaHasta));
			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicio(FacesUtils.checkDate(txtFechaInicio));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setPorcentajeDescuento(FacesUtils
					.checkDouble(txtPorcentajeDescuento));
			entity.setGrupo(businessDelegatorView.getGrupo(FacesUtils
					.checkLong(txtIdGrpo_Grupo)));
			entity.setTipoFormaPago(businessDelegatorView
					.getTipoFormaPago(FacesUtils
							.checkLong(txtIdTfpa_TipoFormaPago)));
			businessDelegatorView.updateDescuentoFinanciero(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedDescuentoFinanciero = (DescuentoFinancieroDTO) (evt
					.getComponent().getAttributes()
					.get("selectedDescuentoFinanciero"));

			Long idDefi = new Long(selectedDescuentoFinanciero.getIdDefi());
			entity = businessDelegatorView.getDescuentoFinanciero(idDefi);
			businessDelegatorView.deleteDescuentoFinanciero(entity);
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
			selectedDescuentoFinanciero = (DescuentoFinancieroDTO) (evt
					.getComponent().getAttributes()
					.get("selectedDescuentoFinanciero"));

			Long idDefi = new Long(selectedDescuentoFinanciero.getIdDefi());
			entity = businessDelegatorView.getDescuentoFinanciero(idDefi);
			businessDelegatorView.deleteDescuentoFinanciero(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedDescuentoFinanciero);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long codigo, Long diaDesde,
			Long diaHasta, String estadoRegistro, Date fechaCreacion,
			Date fechaFinal, Date fechaInicio, Date fechaModificacion,
			Long idDefi, String nombre, String operCreador,
			String operModifica, Double porcentajeDescuento, Long idGrpo_Grupo,
			Long idTfpa_TipoFormaPago) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkLong(codigo));
			entity.setDiaDesde(FacesUtils.checkLong(diaDesde));
			entity.setDiaHasta(FacesUtils.checkLong(diaHasta));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(fechaFinal));
			entity.setFechaInicio(FacesUtils.checkDate(fechaInicio));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setPorcentajeDescuento(FacesUtils
					.checkDouble(porcentajeDescuento));
			businessDelegatorView.updateDescuentoFinanciero(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DescuentoFinancieroView").requestRender();
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

	public InputText getTxtDiaDesde() {
		return txtDiaDesde;
	}

	public void setTxtDiaDesde(InputText txtDiaDesde) {
		this.txtDiaDesde = txtDiaDesde;
	}

	public InputText getTxtDiaHasta() {
		return txtDiaHasta;
	}

	public void setTxtDiaHasta(InputText txtDiaHasta) {
		this.txtDiaHasta = txtDiaHasta;
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

	public InputText getTxtPorcentajeDescuento() {
		return txtPorcentajeDescuento;
	}

	public void setTxtPorcentajeDescuento(InputText txtPorcentajeDescuento) {
		this.txtPorcentajeDescuento = txtPorcentajeDescuento;
	}

	public SelectOneMenu getTxtIdGrpo_Grupo() {
		return txtIdGrpo_Grupo;
	}

	public void setTxtIdGrpo_Grupo(SelectOneMenu txtIdGrpo_Grupo) {
		this.txtIdGrpo_Grupo = txtIdGrpo_Grupo;
	}

	public SelectOneMenu getTxtIdTfpa_TipoFormaPago() {
		return txtIdTfpa_TipoFormaPago;
	}

	public void setTxtIdTfpa_TipoFormaPago(SelectOneMenu txtIdTfpa_TipoFormaPago) {
		this.txtIdTfpa_TipoFormaPago = txtIdTfpa_TipoFormaPago;
	}

	public InputText getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(InputText txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaFinal() {
		return txtFechaFinal;
	}

	public void setTxtFechaFinal(Calendar txtFechaFinal) {
		this.txtFechaFinal = txtFechaFinal;
	}

	public Calendar getTxtFechaInicio() {
		return txtFechaInicio;
	}

	public void setTxtFechaInicio(Calendar txtFechaInicio) {
		this.txtFechaInicio = txtFechaInicio;
	}

	public InputText getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(InputText txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public InputText getTxtIdDefi() {
		return txtIdDefi;
	}

	public void setTxtIdDefi(InputText txtIdDefi) {
		this.txtIdDefi = txtIdDefi;
	}

	public List<DescuentoFinancieroDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDescuentoFinanciero();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DescuentoFinancieroDTO> descuentoFinancieroDTO) {
		this.data = descuentoFinancieroDTO;
	}

	public DescuentoFinancieroDTO getSelectedDescuentoFinanciero() {
		return selectedDescuentoFinanciero;
	}

	public void setSelectedDescuentoFinanciero(
			DescuentoFinancieroDTO descuentoFinanciero) {
		this.selectedDescuentoFinanciero = descuentoFinanciero;
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

	public String getDiaDesde() {
		return diaDesde;
	}

	public void setDiaDesde(String diaDesde) {
		this.diaDesde = diaDesde;
	}

	public String getDiaHasta() {
		return diaHasta;
	}

	public void setDiaHasta(String diaHasta) {
		this.diaHasta = diaHasta;
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

	public String getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(String porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public Long getIdGrpo_Grupo() {
		return idGrpo_Grupo;
	}

	public void setIdGrpo_Grupo(Long idGrpo_Grupo) {
		this.idGrpo_Grupo = idGrpo_Grupo;
	}

	public String getIdTfpa_TipoFormaPago() {
		return idTfpa_TipoFormaPago;
	}

	public void setIdTfpa_TipoFormaPago(String idTfpa_TipoFormaPago) {
		this.idTfpa_TipoFormaPago = idTfpa_TipoFormaPago;
	}

	public String getIdDefi() {
		return idDefi;
	}

	public void setIdDefi(String idDefi) {
		this.idDefi = idDefi;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
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

	public Map<String, String> getGrupo() {
		try {
			List<GrupoDTO> data2 = businessDelegatorView.getDataGrupo();

			for (int i = 0; i < data2.size(); i++) {
				grupo.put(data2.get(i).getNombre(), data2.get(i).getIdGrpo()
						+ "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return grupo;
	}

	public void setGrupo(Map<String, String> grupo) {
		this.grupo = grupo;
	}

	public Map<String, String> getTipoFormaPago() {
		try {
			List<TipoFormaPagoDTO> data3 = businessDelegatorView
					.getDataTipoFormaPago();

			for (int i = 0; i < data3.size(); i++) {
				tipoFormaPago.put(data3.get(i).getCodigo(), data3.get(i)
						.getIdTfpa() + "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return tipoFormaPago;
	}

	public void setTipoFormaPago(Map<String, String> tipoFormaPago) {
		this.tipoFormaPago = tipoFormaPago;
	}

}
