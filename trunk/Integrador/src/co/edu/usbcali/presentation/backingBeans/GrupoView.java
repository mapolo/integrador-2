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
import co.edu.usbcali.modelo.Familia;
import co.edu.usbcali.modelo.Grupo;
import co.edu.usbcali.modelo.dto.FamiliaDTO;
import co.edu.usbcali.modelo.dto.GrupoDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class GrupoView {
	private InputText txtAsociado;
	private InputText txtDivision;
	private SelectOneMenu txtEspecial;
	private SelectOneMenu estado;
	private InputText txtGrupo_1;
	private SelectOneMenu txtManejaOrdenCompra;
	private InputText txtMargenMinimoBodega;
	private InputText txtMargenMinimoEnergiteca;
	private SelectOneMenu txtModificaReferencia;
	private InputText txtNombre;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private SelectOneMenu txtPideGalones;
	private SelectOneMenu txtSugeridoPedido;
	private InputText txtTipoNivel;
	private SelectOneMenu txtIdFlia_Familia;
	private SelectOneMenu txtIdGrpo_Grupo;
	private InputText txtIdGrpo;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;

	private String asociado;
	private String division;
	private String especial;
	private String estadoRegistro;
	private String grupo_1;
	private String manejaOrdenCompra;
	private String margenMinimoBodega;
	private String margenMinimoEnergiteca;
	private String modificaReferencia;
	private String nombre;
	private String operCreador;
	private String operModifica;
	private String pideGalones;
	private String sugeridoPedido;
	private String tipoNivel;
	private Long idFlia_Familia;
	private Long idGrpo_Grupo;
	private String idGrpo;
	private String fechaCreacion;
	private String fechaModificacion;

	private Map<String, String> familias = new HashMap<String, String>();
	private Map<String, String> grupos = new HashMap<String, String>();

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<GrupoDTO> data;
	private GrupoDTO selectedGrupo;
	private Grupo entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private SelectItem[] manufacturerOptions;
	private SelectItem[] manufacturerOptions2;

	String manufacturers[] = { "A", "R" };
	String manufacturers2[] = { "S", "N" };

	public GrupoView() {
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
			entity = businessDelegatorView.getGrupo(((GrupoDTO) event
					.getObject()).getIdGrpo());

			entity.setAsociado(((GrupoDTO) event.getObject()).getAsociado());
			entity.setDivision(((GrupoDTO) event.getObject()).getDivision());
			entity.setGrupo_1(((GrupoDTO) event.getObject()).getGrupo_1());
			entity.setMargenMinimoBodega(((GrupoDTO) event.getObject())
					.getMargenMinimoBodega());
			entity.setMargenMinimoEnergiteca(((GrupoDTO) event.getObject())
					.getMargenMinimoEnergiteca());
			entity.setNombre(((GrupoDTO) event.getObject()).getNombre());
			entity.setTipoNivel(((GrupoDTO) event.getObject()).getTipoNivel());

			entity.setEspecial(especial);
			entity.setModificaReferencia(modificaReferencia);
			entity.setPideGalones(pideGalones);
			entity.setManejaOrdenCompra(manejaOrdenCompra);
			entity.setSugeridoPedido(sugeridoPedido);
			entity.setFechaModificacion(new Date());
			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);
			entity.setEstadoRegistro(estadoRegistro);

			Familia entity2 = businessDelegatorView
					.getFamilia(getIdFlia_Familia());
			entity.setFamilia(entity2);

			Grupo entity3 = businessDelegatorView.getGrupo(getIdGrpo_Grupo());
			entity.setGrupo(entity3);

			businessDelegatorView.updateGrupo(entity);

			try {
				grupos = new HashMap<String, String>();
				List<GrupoDTO> data2 = businessDelegatorView.getDataGrupo();

				for (int i = 0; i < data2.size(); i++) {
					grupos.put(data2.get(i).getNombre(), data2.get(i)
							.getIdGrpo() + "");

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			data = businessDelegatorView.getDataGrupo();
			RequestContext.getCurrentInstance().update("form:tablaPrincipal");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Cancelled",
				((GrupoDTO) event.getObject()).getIdGrpo() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((GrupoDTO) event.getObject()).getIdGrpo());
	}

	public void rowEventListener(RowEditEvent e) {

		try {
			GrupoDTO grupoDTO = (GrupoDTO) e.getObject();

			if (txtAsociado == null) {
				txtAsociado = new InputText();
			}

			txtAsociado.setValue(grupoDTO.getAsociado());

			if (txtDivision == null) {
				txtDivision = new InputText();
			}

			txtDivision.setValue(grupoDTO.getDivision());

			if (txtEspecial == null) {
				txtEspecial = new SelectOneMenu();
			}

			txtEspecial.setValue(grupoDTO.getEspecial());

			if (txtGrupo_1 == null) {
				txtGrupo_1 = new InputText();
			}

			txtGrupo_1.setValue(grupoDTO.getGrupo_1());

			if (txtManejaOrdenCompra == null) {
				txtManejaOrdenCompra = new SelectOneMenu();
			}

			txtManejaOrdenCompra.setValue(grupoDTO.getManejaOrdenCompra());

			if (txtMargenMinimoBodega == null) {
				txtMargenMinimoBodega = new InputText();
			}

			txtMargenMinimoBodega.setValue(grupoDTO.getMargenMinimoBodega());

			if (txtMargenMinimoEnergiteca == null) {
				txtMargenMinimoEnergiteca = new InputText();
			}

			txtMargenMinimoEnergiteca.setValue(grupoDTO
					.getMargenMinimoEnergiteca());

			if (txtModificaReferencia == null) {
				txtModificaReferencia = new SelectOneMenu();
			}

			txtModificaReferencia.setValue(grupoDTO.getModificaReferencia());

			if (txtNombre == null) {
				txtNombre = new InputText();
			}

			txtNombre.setValue(grupoDTO.getNombre());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(grupoDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(grupoDTO.getOperModifica());

			if (txtPideGalones == null) {
				txtPideGalones = new SelectOneMenu();
			}

			txtPideGalones.setValue(grupoDTO.getPideGalones());

			if (txtSugeridoPedido == null) {
				txtSugeridoPedido = new SelectOneMenu();
			}

			txtSugeridoPedido.setValue(grupoDTO.getSugeridoPedido());

			if (txtTipoNivel == null) {
				txtTipoNivel = new InputText();
			}

			txtTipoNivel.setValue(grupoDTO.getTipoNivel());

			if (txtIdFlia_Familia == null) {
				txtIdFlia_Familia = new SelectOneMenu();
			}

			txtIdFlia_Familia.setValue(grupoDTO.getIdFlia_Familia());

			if (txtIdGrpo_Grupo == null) {
				txtIdGrpo_Grupo = new SelectOneMenu();
			}

			txtIdGrpo_Grupo.setValue(grupoDTO.getIdGrpo_Grupo());

			if (txtIdGrpo == null) {
				txtIdGrpo = new InputText();
			}

			txtIdGrpo.setValue(grupoDTO.getIdGrpo());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(grupoDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(grupoDTO.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedGrupo = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedGrupo = null;

		if (txtAsociado != null) {
			txtAsociado.setValue(null);
			// txtAsociado.setDisabled(true);
		}

		if (txtDivision != null) {
			txtDivision.setValue(null);
			// txtDivision.setDisabled(true);
		}

		if (txtEspecial != null) {
			txtEspecial.setValue(null);
			// txtEspecial.setDisabled(true);
		}

		if (txtGrupo_1 != null) {
			txtGrupo_1.setValue(null);
			// txtGrupo_1.setDisabled(true);
		}

		if (txtManejaOrdenCompra != null) {
			txtManejaOrdenCompra.setValue(null);
			// txtManejaOrdenCompra.setDisabled(true);
		}

		if (txtMargenMinimoBodega != null) {
			txtMargenMinimoBodega.setValue(null);
			// txtMargenMinimoBodega.setDisabled(true);
		}

		if (txtMargenMinimoEnergiteca != null) {
			txtMargenMinimoEnergiteca.setValue(null);
			// txtMargenMinimoEnergiteca.setDisabled(true);
		}

		if (txtModificaReferencia != null) {
			txtModificaReferencia.setValue(null);
			// txtModificaReferencia.setDisabled(true);
		}

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

		if (txtPideGalones != null) {
			txtPideGalones.setValue(null);
			// txtPideGalones.setDisabled(true);
		}

		if (txtSugeridoPedido != null) {
			txtSugeridoPedido.setValue(null);
			// txtSugeridoPedido.setDisabled(true);
		}

		if (txtTipoNivel != null) {
			txtTipoNivel.setValue(null);
			// txtTipoNivel.setDisabled(true);
		}

		if (txtIdFlia_Familia != null) {
			txtIdFlia_Familia.setValue(null);
			// txtIdFlia_Familia.setDisabled(true);
		}

		if (txtIdGrpo_Grupo != null) {
			txtIdGrpo_Grupo.setValue(null);
			// txtIdGrpo_Grupo.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			// txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			// txtFechaModificacion.setDisabled(true);
		}

		if (txtIdGrpo != null) {
			txtIdGrpo.setValue(null);
			// txtIdGrpo.setDisabled(false);
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
			Long idGrpo = new Long(txtIdGrpo.getValue().toString());
			entity = businessDelegatorView.getGrupo(idGrpo);
		} catch (Exception e) {

		}

		if (entity == null) {
			txtAsociado.setDisabled(false);
			txtDivision.setDisabled(false);
			txtEspecial.setDisabled(false);
			txtGrupo_1.setDisabled(false);
			txtManejaOrdenCompra.setDisabled(false);
			txtMargenMinimoBodega.setDisabled(false);
			txtMargenMinimoEnergiteca.setDisabled(false);
			txtModificaReferencia.setDisabled(false);
			txtNombre.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtPideGalones.setDisabled(false);
			txtSugeridoPedido.setDisabled(false);
			txtTipoNivel.setDisabled(false);
			txtIdFlia_Familia.setDisabled(false);
			txtIdGrpo_Grupo.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdGrpo.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtAsociado.setValue(entity.getAsociado());
			txtAsociado.setDisabled(false);
			txtDivision.setValue(entity.getDivision());
			txtDivision.setDisabled(false);
			txtEspecial.setValue(entity.getEspecial());
			txtEspecial.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtGrupo_1.setValue(entity.getGrupo_1());
			txtGrupo_1.setDisabled(false);
			txtManejaOrdenCompra.setValue(entity.getManejaOrdenCompra());
			txtManejaOrdenCompra.setDisabled(false);
			txtMargenMinimoBodega.setValue(entity.getMargenMinimoBodega());
			txtMargenMinimoBodega.setDisabled(false);
			txtMargenMinimoEnergiteca.setValue(entity
					.getMargenMinimoEnergiteca());
			txtMargenMinimoEnergiteca.setDisabled(false);
			txtModificaReferencia.setValue(entity.getModificaReferencia());
			txtModificaReferencia.setDisabled(false);
			txtNombre.setValue(entity.getNombre());
			txtNombre.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtPideGalones.setValue(entity.getPideGalones());
			txtPideGalones.setDisabled(false);
			txtSugeridoPedido.setValue(entity.getSugeridoPedido());
			txtSugeridoPedido.setDisabled(false);
			txtTipoNivel.setValue(entity.getTipoNivel());
			txtTipoNivel.setDisabled(false);
			txtIdFlia_Familia.setValue(entity.getFamilia().getIdFlia());
			txtIdFlia_Familia.setDisabled(false);
			txtIdGrpo_Grupo.setValue(entity.getGrupo().getIdGrpo());
			txtIdGrpo_Grupo.setDisabled(false);
			txtIdGrpo.setValue(entity.getIdGrpo());
			txtIdGrpo.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedGrupo = (GrupoDTO) (evt.getComponent().getAttributes()
				.get("selectedGrupo"));
		txtAsociado.setValue(selectedGrupo.getAsociado());
		txtAsociado.setDisabled(false);
		txtDivision.setValue(selectedGrupo.getDivision());
		txtDivision.setDisabled(false);
		txtEspecial.setValue(selectedGrupo.getEspecial());
		txtEspecial.setDisabled(false);
		txtFechaCreacion.setValue(selectedGrupo.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedGrupo.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtGrupo_1.setValue(selectedGrupo.getGrupo_1());
		txtGrupo_1.setDisabled(false);
		txtManejaOrdenCompra.setValue(selectedGrupo.getManejaOrdenCompra());
		txtManejaOrdenCompra.setDisabled(false);
		txtMargenMinimoBodega.setValue(selectedGrupo.getMargenMinimoBodega());
		txtMargenMinimoBodega.setDisabled(false);
		txtMargenMinimoEnergiteca.setValue(selectedGrupo
				.getMargenMinimoEnergiteca());
		txtMargenMinimoEnergiteca.setDisabled(false);
		txtModificaReferencia.setValue(selectedGrupo.getModificaReferencia());
		txtModificaReferencia.setDisabled(false);
		txtNombre.setValue(selectedGrupo.getNombre());
		txtNombre.setDisabled(false);
		txtOperCreador.setValue(selectedGrupo.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedGrupo.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtPideGalones.setValue(selectedGrupo.getPideGalones());
		txtPideGalones.setDisabled(false);
		txtSugeridoPedido.setValue(selectedGrupo.getSugeridoPedido());
		txtSugeridoPedido.setDisabled(false);
		txtTipoNivel.setValue(selectedGrupo.getTipoNivel());
		txtTipoNivel.setDisabled(false);
		txtIdFlia_Familia.setValue(selectedGrupo.getIdFlia_Familia());
		txtIdFlia_Familia.setDisabled(false);
		txtIdGrpo_Grupo.setValue(selectedGrupo.getIdGrpo_Grupo());
		txtIdGrpo_Grupo.setDisabled(false);
		txtIdGrpo.setValue(selectedGrupo.getIdGrpo());
		txtIdGrpo.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedGrupo == null) && (entity == null)) {
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
			entity = new Grupo();

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			entity.setAsociado(FacesUtils.checkString(txtAsociado));
			entity.setDivision(FacesUtils.checkString(txtDivision));
			entity.setGrupo_1(FacesUtils.checkString(txtGrupo_1));
			entity.setMargenMinimoBodega(FacesUtils
					.checkDouble(txtMargenMinimoBodega));
			entity.setMargenMinimoEnergiteca(FacesUtils
					.checkDouble(txtMargenMinimoEnergiteca));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setTipoNivel(FacesUtils.checkString(txtTipoNivel));

			entity.setEspecial(especial);
			entity.setModificaReferencia(modificaReferencia);
			entity.setPideGalones(pideGalones);
			entity.setManejaOrdenCompra(manejaOrdenCompra);
			entity.setSugeridoPedido(sugeridoPedido);
			entity.setEstadoRegistro(estadoRegistro);
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);

			Familia entity2 = businessDelegatorView
					.getFamilia(getIdFlia_Familia());
			entity.setFamilia(entity2);

			Grupo entity3 = businessDelegatorView.getGrupo(getIdGrpo_Grupo());
			entity.setGrupo(entity3);

			businessDelegatorView.saveGrupo(entity);
			data = businessDelegatorView.getDataGrupo();
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
				Long idGrpo = new Long(selectedGrupo.getIdGrpo());
				entity = businessDelegatorView.getGrupo(idGrpo);
			}

			entity.setAsociado(FacesUtils.checkString(txtAsociado));
			entity.setDivision(FacesUtils.checkString(txtDivision));
			entity.setEspecial(FacesUtils.checkString(txtEspecial));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setGrupo_1(FacesUtils.checkString(txtGrupo_1));
			entity.setManejaOrdenCompra(FacesUtils
					.checkString(txtManejaOrdenCompra));
			entity.setMargenMinimoBodega(FacesUtils
					.checkDouble(txtMargenMinimoBodega));
			entity.setMargenMinimoEnergiteca(FacesUtils
					.checkDouble(txtMargenMinimoEnergiteca));
			entity.setModificaReferencia(FacesUtils
					.checkString(txtModificaReferencia));
			entity.setNombre(FacesUtils.checkString(txtNombre));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setPideGalones(FacesUtils.checkString(txtPideGalones));
			entity.setSugeridoPedido(FacesUtils.checkString(txtSugeridoPedido));
			entity.setTipoNivel(FacesUtils.checkString(txtTipoNivel));
			entity.setFamilia(businessDelegatorView.getFamilia(FacesUtils
					.checkLong(txtIdFlia_Familia)));
			entity.setGrupo(businessDelegatorView.getGrupo(FacesUtils
					.checkLong(txtIdGrpo_Grupo)));
			businessDelegatorView.updateGrupo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedGrupo = (GrupoDTO) (evt.getComponent().getAttributes()
					.get("selectedGrupo"));

			Long idGrpo = new Long(selectedGrupo.getIdGrpo());
			entity = businessDelegatorView.getGrupo(idGrpo);
			businessDelegatorView.deleteGrupo(entity);
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
			selectedGrupo = (GrupoDTO) (evt.getComponent().getAttributes()
					.get("selectedGrupo"));

			Long idGrpo = new Long(selectedGrupo.getIdGrpo());
			entity = businessDelegatorView.getGrupo(idGrpo);
			businessDelegatorView.deleteGrupo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedGrupo);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String asociado, String division,
			String especial, String estadoRegistro, Date fechaCreacion,
			Date fechaModificacion, String grupo_1, Long idGrpo,
			String manejaOrdenCompra, Double margenMinimoBodega,
			Double margenMinimoEnergiteca, String modificaReferencia,
			String nombre, String operCreador, String operModifica,
			String pideGalones, String sugeridoPedido, String tipoNivel,
			Long idFlia_Familia, Long idGrpo_Grupo) throws Exception {
		try {
			entity.setAsociado(FacesUtils.checkString(asociado));
			entity.setDivision(FacesUtils.checkString(division));
			entity.setEspecial(FacesUtils.checkString(especial));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setGrupo_1(FacesUtils.checkString(grupo_1));
			entity.setManejaOrdenCompra(FacesUtils
					.checkString(manejaOrdenCompra));
			entity.setMargenMinimoBodega(FacesUtils
					.checkDouble(margenMinimoBodega));
			entity.setMargenMinimoEnergiteca(FacesUtils
					.checkDouble(margenMinimoEnergiteca));
			entity.setModificaReferencia(FacesUtils
					.checkString(modificaReferencia));
			entity.setNombre(FacesUtils.checkString(nombre));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setPideGalones(FacesUtils.checkString(pideGalones));
			entity.setSugeridoPedido(FacesUtils.checkString(sugeridoPedido));
			entity.setTipoNivel(FacesUtils.checkString(tipoNivel));
			businessDelegatorView.updateGrupo(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("GrupoView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtAsociado() {
		return txtAsociado;
	}

	public void setTxtAsociado(InputText txtAsociado) {
		this.txtAsociado = txtAsociado;
	}

	public InputText getTxtDivision() {
		return txtDivision;
	}

	public void setTxtDivision(InputText txtDivision) {
		this.txtDivision = txtDivision;
	}

	public SelectOneMenu getTxtEspecial() {
		return txtEspecial;
	}

	public void setTxtEspecial(SelectOneMenu txtEspecial) {
		this.txtEspecial = txtEspecial;
	}

	public InputText getTxtGrupo_1() {
		return txtGrupo_1;
	}

	public void setTxtGrupo_1(InputText txtGrupo_1) {
		this.txtGrupo_1 = txtGrupo_1;
	}

	public SelectOneMenu getTxtManejaOrdenCompra() {
		return txtManejaOrdenCompra;
	}

	public void setTxtManejaOrdenCompra(SelectOneMenu txtManejaOrdenCompra) {
		this.txtManejaOrdenCompra = txtManejaOrdenCompra;
	}

	public InputText getTxtMargenMinimoBodega() {
		return txtMargenMinimoBodega;
	}

	public void setTxtMargenMinimoBodega(InputText txtMargenMinimoBodega) {
		this.txtMargenMinimoBodega = txtMargenMinimoBodega;
	}

	public InputText getTxtMargenMinimoEnergiteca() {
		return txtMargenMinimoEnergiteca;
	}

	public void setTxtMargenMinimoEnergiteca(InputText txtMargenMinimoEnergiteca) {
		this.txtMargenMinimoEnergiteca = txtMargenMinimoEnergiteca;
	}

	public SelectOneMenu getTxtModificaReferencia() {
		return txtModificaReferencia;
	}

	public void setTxtModificaReferencia(SelectOneMenu txtModificaReferencia) {
		this.txtModificaReferencia = txtModificaReferencia;
	}

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

	public SelectOneMenu getTxtPideGalones() {
		return txtPideGalones;
	}

	public void setTxtPideGalones(SelectOneMenu txtPideGalones) {
		this.txtPideGalones = txtPideGalones;
	}

	public SelectOneMenu getTxtSugeridoPedido() {
		return txtSugeridoPedido;
	}

	public void setTxtSugeridoPedido(SelectOneMenu txtSugeridoPedido) {
		this.txtSugeridoPedido = txtSugeridoPedido;
	}

	public InputText getTxtTipoNivel() {
		return txtTipoNivel;
	}

	public void setTxtTipoNivel(InputText txtTipoNivel) {
		this.txtTipoNivel = txtTipoNivel;
	}

	public SelectOneMenu getTxtIdFlia_Familia() {
		return txtIdFlia_Familia;
	}

	public void setTxtIdFlia_Familia(SelectOneMenu txtIdFlia_Familia) {
		this.txtIdFlia_Familia = txtIdFlia_Familia;
	}

	public SelectOneMenu getTxtIdGrpo_Grupo() {
		return txtIdGrpo_Grupo;
	}

	public void setTxtIdGrpo_Grupo(SelectOneMenu txtIdGrpo_Grupo) {
		this.txtIdGrpo_Grupo = txtIdGrpo_Grupo;
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

	public InputText getTxtIdGrpo() {
		return txtIdGrpo;
	}

	public void setTxtIdGrpo(InputText txtIdGrpo) {
		this.txtIdGrpo = txtIdGrpo;
	}

	public List<GrupoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataGrupo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<GrupoDTO> grupoDTO) {
		this.data = grupoDTO;
	}

	public GrupoDTO getSelectedGrupo() {
		return selectedGrupo;
	}

	public void setSelectedGrupo(GrupoDTO grupo) {
		this.selectedGrupo = grupo;
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

	public SelectOneMenu getEstado() {
		return estado;
	}

	public void setEstado(SelectOneMenu estado) {
		this.estado = estado;
	}

	public String getAsociado() {
		return asociado;
	}

	public void setAsociado(String asociado) {
		this.asociado = asociado;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getEspecial() {
		return especial;
	}

	public void setEspecial(String especial) {
		this.especial = especial;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getGrupo_1() {
		return grupo_1;
	}

	public void setGrupo_1(String grupo_1) {
		this.grupo_1 = grupo_1;
	}

	public String getManejaOrdenCompra() {
		return manejaOrdenCompra;
	}

	public void setManejaOrdenCompra(String manejaOrdenCompra) {
		this.manejaOrdenCompra = manejaOrdenCompra;
	}

	public String getMargenMinimoBodega() {
		return margenMinimoBodega;
	}

	public void setMargenMinimoBodega(String margenMinimoBodega) {
		this.margenMinimoBodega = margenMinimoBodega;
	}

	public String getMargenMinimoEnergiteca() {
		return margenMinimoEnergiteca;
	}

	public void setMargenMinimoEnergiteca(String margenMinimoEnergiteca) {
		this.margenMinimoEnergiteca = margenMinimoEnergiteca;
	}

	public String getModificaReferencia() {
		return modificaReferencia;
	}

	public void setModificaReferencia(String modificaReferencia) {
		this.modificaReferencia = modificaReferencia;
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

	public String getPideGalones() {
		return pideGalones;
	}

	public void setPideGalones(String pideGalones) {
		this.pideGalones = pideGalones;
	}

	public String getSugeridoPedido() {
		return sugeridoPedido;
	}

	public void setSugeridoPedido(String sugeridoPedido) {
		this.sugeridoPedido = sugeridoPedido;
	}

	public String getTipoNivel() {
		return tipoNivel;
	}

	public void setTipoNivel(String tipoNivel) {
		this.tipoNivel = tipoNivel;
	}

	public Long getIdFlia_Familia() {
		return idFlia_Familia;
	}

	public void setIdFlia_Familia(Long idFlia_Familia) {
		this.idFlia_Familia = idFlia_Familia;
	}

	public Long getIdGrpo_Grupo() {
		return idGrpo_Grupo;
	}

	public void setIdGrpo_Grupo(Long idGrpo_Grupo) {
		this.idGrpo_Grupo = idGrpo_Grupo;
	}

	public String getIdGrpo() {
		return idGrpo;
	}

	public void setIdGrpo(String idGrpo) {
		this.idGrpo = idGrpo;
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

	public Map<String, String> getFamilias() {
		try {
			List<FamiliaDTO> data2 = businessDelegatorView.getDataFamilia();

			for (int i = 0; i < data2.size(); i++) {
				familias.put(data2.get(i).getDescripcion(), data2.get(i)
						.getIdFlia() + "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return familias;
	}

	public void setFamilias(Map<String, String> familias) {
		this.familias = familias;
	}

	public Map<String, String> getGrupos() {
		try {
			List<GrupoDTO> data2 = businessDelegatorView.getDataGrupo();

			for (int i = 0; i < data2.size(); i++) {
				grupos.put(data2.get(i).getNombre(), data2.get(i).getIdGrpo()
						+ "");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return grupos;
	}

	public void setGrupos(Map<String, String> grupos) {
		this.grupos = grupos;
	}

	public String[] getManufacturers() {
		return manufacturers;
	}

	public void setManufacturers(String[] manufacturers) {
		this.manufacturers = manufacturers;
	}

	public String[] getManufacturers2() {
		return manufacturers2;
	}

	public void setManufacturers2(String[] manufacturers2) {
		this.manufacturers2 = manufacturers2;
	}
}
