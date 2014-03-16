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
import co.edu.usbcali.modelo.Grupo;
import co.edu.usbcali.modelo.dto.GrupoDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class GrupoView {
	private InputText txtAsociado;
	private InputText txtDivision;
	private InputText txtEspecial;
	private InputText txtEstadoRegistro;
	private InputText txtGrupo_1;
	private InputText txtManejaOrdenCompra;
	private InputText txtMargenMinimoBodega;
	private InputText txtMargenMinimoEnergiteca;
	private InputText txtModificaReferencia;
	private InputText txtNombre;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtPideGalones;
	private InputText txtSugeridoPedido;
	private InputText txtTipoNivel;
	private InputText txtIdFlia_Familia;
	private InputText txtIdGrpo_Grupo;
	private InputText txtIdGrpo;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
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

	public GrupoView() {
		super();
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
				txtEspecial = new InputText();
			}

			txtEspecial.setValue(grupoDTO.getEspecial());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(grupoDTO.getEstadoRegistro());

			if (txtGrupo_1 == null) {
				txtGrupo_1 = new InputText();
			}

			txtGrupo_1.setValue(grupoDTO.getGrupo_1());

			if (txtManejaOrdenCompra == null) {
				txtManejaOrdenCompra = new InputText();
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
				txtModificaReferencia = new InputText();
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
				txtPideGalones = new InputText();
			}

			txtPideGalones.setValue(grupoDTO.getPideGalones());

			if (txtSugeridoPedido == null) {
				txtSugeridoPedido = new InputText();
			}

			txtSugeridoPedido.setValue(grupoDTO.getSugeridoPedido());

			if (txtTipoNivel == null) {
				txtTipoNivel = new InputText();
			}

			txtTipoNivel.setValue(grupoDTO.getTipoNivel());

			if (txtIdFlia_Familia == null) {
				txtIdFlia_Familia = new InputText();
			}

			txtIdFlia_Familia.setValue(grupoDTO.getIdFlia_Familia());

			if (txtIdGrpo_Grupo == null) {
				txtIdGrpo_Grupo = new InputText();
			}

			txtIdGrpo_Grupo.setValue(grupoDTO.getIdGrpo_Grupo());

			if (txtIdGrpo == null) {
				txtIdGrpo = new InputText();
			}

			txtIdGrpo.setValue(grupoDTO.getIdGrpo());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(grupoDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
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
			txtAsociado.setDisabled(true);
		}

		if (txtDivision != null) {
			txtDivision.setValue(null);
			txtDivision.setDisabled(true);
		}

		if (txtEspecial != null) {
			txtEspecial.setValue(null);
			txtEspecial.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtGrupo_1 != null) {
			txtGrupo_1.setValue(null);
			txtGrupo_1.setDisabled(true);
		}

		if (txtManejaOrdenCompra != null) {
			txtManejaOrdenCompra.setValue(null);
			txtManejaOrdenCompra.setDisabled(true);
		}

		if (txtMargenMinimoBodega != null) {
			txtMargenMinimoBodega.setValue(null);
			txtMargenMinimoBodega.setDisabled(true);
		}

		if (txtMargenMinimoEnergiteca != null) {
			txtMargenMinimoEnergiteca.setValue(null);
			txtMargenMinimoEnergiteca.setDisabled(true);
		}

		if (txtModificaReferencia != null) {
			txtModificaReferencia.setValue(null);
			txtModificaReferencia.setDisabled(true);
		}

		if (txtNombre != null) {
			txtNombre.setValue(null);
			txtNombre.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtPideGalones != null) {
			txtPideGalones.setValue(null);
			txtPideGalones.setDisabled(true);
		}

		if (txtSugeridoPedido != null) {
			txtSugeridoPedido.setValue(null);
			txtSugeridoPedido.setDisabled(true);
		}

		if (txtTipoNivel != null) {
			txtTipoNivel.setValue(null);
			txtTipoNivel.setDisabled(true);
		}

		if (txtIdFlia_Familia != null) {
			txtIdFlia_Familia.setValue(null);
			txtIdFlia_Familia.setDisabled(true);
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

		if (txtIdGrpo != null) {
			txtIdGrpo.setValue(null);
			txtIdGrpo.setDisabled(false);
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

	public void listener_txtId() {
		try {
			Long idGrpo = new Long(txtIdGrpo.getValue().toString());
			entity = businessDelegatorView.getGrupo(idGrpo);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtAsociado.setDisabled(false);
			txtDivision.setDisabled(false);
			txtEspecial.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
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
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
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
		txtEstadoRegistro.setValue(selectedGrupo.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
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

			Long idGrpo = new Long(txtIdGrpo.getValue().toString());

			entity.setAsociado(FacesUtils.checkString(txtAsociado));
			entity.setDivision(FacesUtils.checkString(txtDivision));
			entity.setEspecial(FacesUtils.checkString(txtEspecial));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setGrupo_1(FacesUtils.checkString(txtGrupo_1));
			entity.setIdGrpo(idGrpo);
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
			businessDelegatorView.saveGrupo(entity);
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
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
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

	public InputText getTxtEspecial() {
		return txtEspecial;
	}

	public void setTxtEspecial(InputText txtEspecial) {
		this.txtEspecial = txtEspecial;
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}

	public InputText getTxtGrupo_1() {
		return txtGrupo_1;
	}

	public void setTxtGrupo_1(InputText txtGrupo_1) {
		this.txtGrupo_1 = txtGrupo_1;
	}

	public InputText getTxtManejaOrdenCompra() {
		return txtManejaOrdenCompra;
	}

	public void setTxtManejaOrdenCompra(InputText txtManejaOrdenCompra) {
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

	public InputText getTxtModificaReferencia() {
		return txtModificaReferencia;
	}

	public void setTxtModificaReferencia(InputText txtModificaReferencia) {
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

	public InputText getTxtPideGalones() {
		return txtPideGalones;
	}

	public void setTxtPideGalones(InputText txtPideGalones) {
		this.txtPideGalones = txtPideGalones;
	}

	public InputText getTxtSugeridoPedido() {
		return txtSugeridoPedido;
	}

	public void setTxtSugeridoPedido(InputText txtSugeridoPedido) {
		this.txtSugeridoPedido = txtSugeridoPedido;
	}

	public InputText getTxtTipoNivel() {
		return txtTipoNivel;
	}

	public void setTxtTipoNivel(InputText txtTipoNivel) {
		this.txtTipoNivel = txtTipoNivel;
	}

	public InputText getTxtIdFlia_Familia() {
		return txtIdFlia_Familia;
	}

	public void setTxtIdFlia_Familia(InputText txtIdFlia_Familia) {
		this.txtIdFlia_Familia = txtIdFlia_Familia;
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
}
