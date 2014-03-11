package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.DescuentoComercialDTO;
import co.edu.usbcali.presentation.businessDelegate.*;
import co.edu.usbcali.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import java.text.DateFormat;
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

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
@ManagedBean
@ViewScoped
public class DescuentoComercialView {
	private InputText txtAsocGrupoItem;
	private InputText txtCreadoAutomatico;
	private InputText txtEspacios;
	private InputText txtEstadoPlano;
	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtPorcDescItem;
	private InputText txtPorcDescMaxItem;
	private InputText txtPorcDescMinItem;
	private InputText txtTipoAsocGrupoItem;
	private InputText txtTodasSucursales;
	private InputText txtIdEmpr_Empresa;
	private InputText txtIdGrpo_Grupo;
	private InputText txtIdPers_Persona;
	private InputText txtIdSucu_Sucursal;
	private InputText txtIdDeco;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaFinal;
	private Calendar txtFechaInicial;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<DescuentoComercialDTO> data;
	private DescuentoComercialDTO selectedDescuentoComercial;
	private DescuentoComercial entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public DescuentoComercialView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			DescuentoComercialDTO descuentoComercialDTO = (DescuentoComercialDTO) e
					.getObject();

			if (txtAsocGrupoItem == null) {
				txtAsocGrupoItem = new InputText();
			}

			txtAsocGrupoItem.setValue(descuentoComercialDTO.getAsocGrupoItem());

			if (txtCreadoAutomatico == null) {
				txtCreadoAutomatico = new InputText();
			}

			txtCreadoAutomatico.setValue(descuentoComercialDTO
					.getCreadoAutomatico());

			if (txtEspacios == null) {
				txtEspacios = new InputText();
			}

			txtEspacios.setValue(descuentoComercialDTO.getEspacios());

			if (txtEstadoPlano == null) {
				txtEstadoPlano = new InputText();
			}

			txtEstadoPlano.setValue(descuentoComercialDTO.getEstadoPlano());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(descuentoComercialDTO
					.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(descuentoComercialDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(descuentoComercialDTO.getOperModifica());

			if (txtPorcDescItem == null) {
				txtPorcDescItem = new InputText();
			}

			txtPorcDescItem.setValue(descuentoComercialDTO.getPorcDescItem());

			if (txtPorcDescMaxItem == null) {
				txtPorcDescMaxItem = new InputText();
			}

			txtPorcDescMaxItem.setValue(descuentoComercialDTO
					.getPorcDescMaxItem());

			if (txtPorcDescMinItem == null) {
				txtPorcDescMinItem = new InputText();
			}

			txtPorcDescMinItem.setValue(descuentoComercialDTO
					.getPorcDescMinItem());

			if (txtTipoAsocGrupoItem == null) {
				txtTipoAsocGrupoItem = new InputText();
			}

			txtTipoAsocGrupoItem.setValue(descuentoComercialDTO
					.getTipoAsocGrupoItem());

			if (txtTodasSucursales == null) {
				txtTodasSucursales = new InputText();
			}

			txtTodasSucursales.setValue(descuentoComercialDTO
					.getTodasSucursales());

			if (txtIdEmpr_Empresa == null) {
				txtIdEmpr_Empresa = new InputText();
			}

			txtIdEmpr_Empresa.setValue(descuentoComercialDTO
					.getIdEmpr_Empresa());

			if (txtIdGrpo_Grupo == null) {
				txtIdGrpo_Grupo = new InputText();
			}

			txtIdGrpo_Grupo.setValue(descuentoComercialDTO.getIdGrpo_Grupo());

			if (txtIdPers_Persona == null) {
				txtIdPers_Persona = new InputText();
			}

			txtIdPers_Persona.setValue(descuentoComercialDTO
					.getIdPers_Persona());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new InputText();
			}

			if (txtIdDeco == null) {
				txtIdDeco = new InputText();
			}

			txtIdDeco.setValue(descuentoComercialDTO.getIdDeco());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(descuentoComercialDTO.getFechaCreacion());

			if (txtFechaFinal == null) {
				txtFechaFinal = new Calendar();
			}

			txtFechaFinal.setValue(descuentoComercialDTO.getFechaFinal());

			if (txtFechaInicial == null) {
				txtFechaInicial = new Calendar();
			}

			txtFechaInicial.setValue(descuentoComercialDTO.getFechaInicial());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(descuentoComercialDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedDescuentoComercial = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedDescuentoComercial = null;

		if (txtAsocGrupoItem != null) {
			txtAsocGrupoItem.setValue(null);
			txtAsocGrupoItem.setDisabled(true);
		}

		if (txtCreadoAutomatico != null) {
			txtCreadoAutomatico.setValue(null);
			txtCreadoAutomatico.setDisabled(true);
		}

		if (txtEspacios != null) {
			txtEspacios.setValue(null);
			txtEspacios.setDisabled(true);
		}

		if (txtEstadoPlano != null) {
			txtEstadoPlano.setValue(null);
			txtEstadoPlano.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtPorcDescItem != null) {
			txtPorcDescItem.setValue(null);
			txtPorcDescItem.setDisabled(true);
		}

		if (txtPorcDescMaxItem != null) {
			txtPorcDescMaxItem.setValue(null);
			txtPorcDescMaxItem.setDisabled(true);
		}

		if (txtPorcDescMinItem != null) {
			txtPorcDescMinItem.setValue(null);
			txtPorcDescMinItem.setDisabled(true);
		}

		if (txtTipoAsocGrupoItem != null) {
			txtTipoAsocGrupoItem.setValue(null);
			txtTipoAsocGrupoItem.setDisabled(true);
		}

		if (txtTodasSucursales != null) {
			txtTodasSucursales.setValue(null);
			txtTodasSucursales.setDisabled(true);
		}

		if (txtIdEmpr_Empresa != null) {
			txtIdEmpr_Empresa.setValue(null);
			txtIdEmpr_Empresa.setDisabled(true);
		}

		if (txtIdGrpo_Grupo != null) {
			txtIdGrpo_Grupo.setValue(null);
			txtIdGrpo_Grupo.setDisabled(true);
		}

		if (txtIdPers_Persona != null) {
			txtIdPers_Persona.setValue(null);
			txtIdPers_Persona.setDisabled(true);
		}

		if (txtIdSucu_Sucursal != null) {
			txtIdSucu_Sucursal.setValue(null);
			txtIdSucu_Sucursal.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaFinal != null) {
			txtFechaFinal.setValue(null);
			txtFechaFinal.setDisabled(true);
		}

		if (txtFechaInicial != null) {
			txtFechaInicial.setValue(null);
			txtFechaInicial.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdDeco != null) {
			txtIdDeco.setValue(null);
			txtIdDeco.setDisabled(false);
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

	public void listener_txtFechaFinal() {
		Date inputDate = (Date) txtFechaFinal.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaInicial() {
		Date inputDate = (Date) txtFechaInicial.getValue();
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
			Long idDeco = new Long(txtIdDeco.getValue().toString());
			entity = businessDelegatorView.getDescuentoComercial(idDeco);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtAsocGrupoItem.setDisabled(false);
			txtCreadoAutomatico.setDisabled(false);
			txtEspacios.setDisabled(false);
			txtEstadoPlano.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtPorcDescItem.setDisabled(false);
			txtPorcDescMaxItem.setDisabled(false);
			txtPorcDescMinItem.setDisabled(false);
			txtTipoAsocGrupoItem.setDisabled(false);
			txtTodasSucursales.setDisabled(false);
			txtIdEmpr_Empresa.setDisabled(false);
			txtIdGrpo_Grupo.setDisabled(false);
			txtIdPers_Persona.setDisabled(false);
			txtIdSucu_Sucursal.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdDeco.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtAsocGrupoItem.setValue(entity.getAsocGrupoItem());
			txtAsocGrupoItem.setDisabled(false);
			txtCreadoAutomatico.setValue(entity.getCreadoAutomatico());
			txtCreadoAutomatico.setDisabled(false);
			txtEspacios.setValue(entity.getEspacios());
			txtEspacios.setDisabled(false);
			txtEstadoPlano.setValue(entity.getEstadoPlano());
			txtEstadoPlano.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setValue(entity.getFechaFinal());
			txtFechaFinal.setDisabled(false);
			txtFechaInicial.setValue(entity.getFechaInicial());
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtPorcDescItem.setValue(entity.getPorcDescItem());
			txtPorcDescItem.setDisabled(false);
			txtPorcDescMaxItem.setValue(entity.getPorcDescMaxItem());
			txtPorcDescMaxItem.setDisabled(false);
			txtPorcDescMinItem.setValue(entity.getPorcDescMinItem());
			txtPorcDescMinItem.setDisabled(false);
			txtTipoAsocGrupoItem.setValue(entity.getTipoAsocGrupoItem());
			txtTipoAsocGrupoItem.setDisabled(false);
			txtTodasSucursales.setValue(entity.getTodasSucursales());
			txtTodasSucursales.setDisabled(false);
			txtIdEmpr_Empresa.setValue(entity.getEmpresa().getIdEmpr());
			txtIdEmpr_Empresa.setDisabled(false);
			txtIdGrpo_Grupo.setValue(entity.getGrupo().getIdGrpo());
			txtIdGrpo_Grupo.setDisabled(false);
			txtIdPers_Persona.setValue(entity.getPersona().getIdPers());
			txtIdPers_Persona.setDisabled(false);

			txtIdSucu_Sucursal.setDisabled(false);
			txtIdDeco.setValue(entity.getIdDeco());
			txtIdDeco.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedDescuentoComercial = (DescuentoComercialDTO) (evt
				.getComponent().getAttributes()
				.get("selectedDescuentoComercial"));
		txtAsocGrupoItem
				.setValue(selectedDescuentoComercial.getAsocGrupoItem());
		txtAsocGrupoItem.setDisabled(false);
		txtCreadoAutomatico.setValue(selectedDescuentoComercial
				.getCreadoAutomatico());
		txtCreadoAutomatico.setDisabled(false);
		txtEspacios.setValue(selectedDescuentoComercial.getEspacios());
		txtEspacios.setDisabled(false);
		txtEstadoPlano.setValue(selectedDescuentoComercial.getEstadoPlano());
		txtEstadoPlano.setDisabled(false);
		txtEstadoRegistro.setValue(selectedDescuentoComercial
				.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion
				.setValue(selectedDescuentoComercial.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaFinal.setValue(selectedDescuentoComercial.getFechaFinal());
		txtFechaFinal.setDisabled(false);
		txtFechaInicial.setValue(selectedDescuentoComercial.getFechaInicial());
		txtFechaInicial.setDisabled(false);
		txtFechaModificacion.setValue(selectedDescuentoComercial
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedDescuentoComercial.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedDescuentoComercial.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtPorcDescItem.setValue(selectedDescuentoComercial.getPorcDescItem());
		txtPorcDescItem.setDisabled(false);
		txtPorcDescMaxItem.setValue(selectedDescuentoComercial
				.getPorcDescMaxItem());
		txtPorcDescMaxItem.setDisabled(false);
		txtPorcDescMinItem.setValue(selectedDescuentoComercial
				.getPorcDescMinItem());
		txtPorcDescMinItem.setDisabled(false);
		txtTipoAsocGrupoItem.setValue(selectedDescuentoComercial
				.getTipoAsocGrupoItem());
		txtTipoAsocGrupoItem.setDisabled(false);
		txtTodasSucursales.setValue(selectedDescuentoComercial
				.getTodasSucursales());
		txtTodasSucursales.setDisabled(false);
		txtIdEmpr_Empresa.setValue(selectedDescuentoComercial
				.getIdEmpr_Empresa());
		txtIdEmpr_Empresa.setDisabled(false);
		txtIdGrpo_Grupo.setValue(selectedDescuentoComercial.getIdGrpo_Grupo());
		txtIdGrpo_Grupo.setDisabled(false);
		txtIdPers_Persona.setValue(selectedDescuentoComercial
				.getIdPers_Persona());
		txtIdPers_Persona.setDisabled(false);

		txtIdSucu_Sucursal.setDisabled(false);
		txtIdDeco.setValue(selectedDescuentoComercial.getIdDeco());
		txtIdDeco.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedDescuentoComercial == null) && (entity == null)) {
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
			entity = new DescuentoComercial();

			Long idDeco = new Long(txtIdDeco.getValue().toString());

			entity.setAsocGrupoItem(FacesUtils.checkString(txtAsocGrupoItem));
			entity.setCreadoAutomatico(FacesUtils
					.checkLong(txtCreadoAutomatico));
			entity.setEspacios(FacesUtils.checkString(txtEspacios));
			entity.setEstadoPlano(FacesUtils.checkLong(txtEstadoPlano));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdDeco(idDeco);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setPorcDescItem(FacesUtils.checkDouble(txtPorcDescItem));
			entity.setPorcDescMaxItem(FacesUtils
					.checkDouble(txtPorcDescMaxItem));
			entity.setPorcDescMinItem(FacesUtils
					.checkDouble(txtPorcDescMinItem));
			entity.setTipoAsocGrupoItem(FacesUtils
					.checkLong(txtTipoAsocGrupoItem));
			entity.setTodasSucursales(FacesUtils.checkLong(txtTodasSucursales));
			entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
					.checkLong(txtIdEmpr_Empresa)));
			entity.setGrupo(businessDelegatorView.getGrupo(FacesUtils
					.checkLong(txtIdGrpo_Grupo)));
			entity.setPersona(businessDelegatorView.getPersona(FacesUtils
					.checkLong(txtIdPers_Persona)));

			businessDelegatorView.saveDescuentoComercial(entity);
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
				Long idDeco = new Long(selectedDescuentoComercial.getIdDeco());
				entity = businessDelegatorView.getDescuentoComercial(idDeco);
			}

			entity.setAsocGrupoItem(FacesUtils.checkString(txtAsocGrupoItem));
			entity.setCreadoAutomatico(FacesUtils
					.checkLong(txtCreadoAutomatico));
			entity.setEspacios(FacesUtils.checkString(txtEspacios));
			entity.setEstadoPlano(FacesUtils.checkLong(txtEstadoPlano));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setPorcDescItem(FacesUtils.checkDouble(txtPorcDescItem));
			entity.setPorcDescMaxItem(FacesUtils
					.checkDouble(txtPorcDescMaxItem));
			entity.setPorcDescMinItem(FacesUtils
					.checkDouble(txtPorcDescMinItem));
			entity.setTipoAsocGrupoItem(FacesUtils
					.checkLong(txtTipoAsocGrupoItem));
			entity.setTodasSucursales(FacesUtils.checkLong(txtTodasSucursales));
			entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
					.checkLong(txtIdEmpr_Empresa)));
			entity.setGrupo(businessDelegatorView.getGrupo(FacesUtils
					.checkLong(txtIdGrpo_Grupo)));
			entity.setPersona(businessDelegatorView.getPersona(FacesUtils
					.checkLong(txtIdPers_Persona)));

			businessDelegatorView.updateDescuentoComercial(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedDescuentoComercial = (DescuentoComercialDTO) (evt
					.getComponent().getAttributes()
					.get("selectedDescuentoComercial"));

			Long idDeco = new Long(selectedDescuentoComercial.getIdDeco());
			entity = businessDelegatorView.getDescuentoComercial(idDeco);
			businessDelegatorView.deleteDescuentoComercial(entity);
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
			selectedDescuentoComercial = (DescuentoComercialDTO) (evt
					.getComponent().getAttributes()
					.get("selectedDescuentoComercial"));

			Long idDeco = new Long(selectedDescuentoComercial.getIdDeco());
			entity = businessDelegatorView.getDescuentoComercial(idDeco);
			businessDelegatorView.deleteDescuentoComercial(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedDescuentoComercial);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String asocGrupoItem,
			Long creadoAutomatico, String espacios, Long estadoPlano,
			String estadoRegistro, Date fechaCreacion, Date fechaFinal,
			Date fechaInicial, Date fechaModificacion, Long idDeco,
			String operCreador, String operModifica, Double porcDescItem,
			Double porcDescMaxItem, Double porcDescMinItem,
			Long tipoAsocGrupoItem, Long todasSucursales, Long idEmpr_Empresa,
			Long idGrpo_Grupo, Long idPers_Persona, Long idSucu_Sucursal,
			Long idSucu_Sucursal0) throws Exception {
		try {
			entity.setAsocGrupoItem(FacesUtils.checkString(asocGrupoItem));
			entity.setCreadoAutomatico(FacesUtils.checkLong(creadoAutomatico));
			entity.setEspacios(FacesUtils.checkString(espacios));
			entity.setEstadoPlano(FacesUtils.checkLong(estadoPlano));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(fechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(fechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setPorcDescItem(FacesUtils.checkDouble(porcDescItem));
			entity.setPorcDescMaxItem(FacesUtils.checkDouble(porcDescMaxItem));
			entity.setPorcDescMinItem(FacesUtils.checkDouble(porcDescMinItem));
			entity.setTipoAsocGrupoItem(FacesUtils.checkLong(tipoAsocGrupoItem));
			entity.setTodasSucursales(FacesUtils.checkLong(todasSucursales));
			businessDelegatorView.updateDescuentoComercial(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("DescuentoComercialView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtAsocGrupoItem() {
		return txtAsocGrupoItem;
	}

	public void setTxtAsocGrupoItem(InputText txtAsocGrupoItem) {
		this.txtAsocGrupoItem = txtAsocGrupoItem;
	}

	public InputText getTxtCreadoAutomatico() {
		return txtCreadoAutomatico;
	}

	public void setTxtCreadoAutomatico(InputText txtCreadoAutomatico) {
		this.txtCreadoAutomatico = txtCreadoAutomatico;
	}

	public InputText getTxtEspacios() {
		return txtEspacios;
	}

	public void setTxtEspacios(InputText txtEspacios) {
		this.txtEspacios = txtEspacios;
	}

	public InputText getTxtEstadoPlano() {
		return txtEstadoPlano;
	}

	public void setTxtEstadoPlano(InputText txtEstadoPlano) {
		this.txtEstadoPlano = txtEstadoPlano;
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
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

	public InputText getTxtPorcDescItem() {
		return txtPorcDescItem;
	}

	public void setTxtPorcDescItem(InputText txtPorcDescItem) {
		this.txtPorcDescItem = txtPorcDescItem;
	}

	public InputText getTxtPorcDescMaxItem() {
		return txtPorcDescMaxItem;
	}

	public void setTxtPorcDescMaxItem(InputText txtPorcDescMaxItem) {
		this.txtPorcDescMaxItem = txtPorcDescMaxItem;
	}

	public InputText getTxtPorcDescMinItem() {
		return txtPorcDescMinItem;
	}

	public void setTxtPorcDescMinItem(InputText txtPorcDescMinItem) {
		this.txtPorcDescMinItem = txtPorcDescMinItem;
	}

	public InputText getTxtTipoAsocGrupoItem() {
		return txtTipoAsocGrupoItem;
	}

	public void setTxtTipoAsocGrupoItem(InputText txtTipoAsocGrupoItem) {
		this.txtTipoAsocGrupoItem = txtTipoAsocGrupoItem;
	}

	public InputText getTxtTodasSucursales() {
		return txtTodasSucursales;
	}

	public void setTxtTodasSucursales(InputText txtTodasSucursales) {
		this.txtTodasSucursales = txtTodasSucursales;
	}

	public InputText getTxtIdEmpr_Empresa() {
		return txtIdEmpr_Empresa;
	}

	public void setTxtIdEmpr_Empresa(InputText txtIdEmpr_Empresa) {
		this.txtIdEmpr_Empresa = txtIdEmpr_Empresa;
	}

	public InputText getTxtIdGrpo_Grupo() {
		return txtIdGrpo_Grupo;
	}

	public void setTxtIdGrpo_Grupo(InputText txtIdGrpo_Grupo) {
		this.txtIdGrpo_Grupo = txtIdGrpo_Grupo;
	}

	public InputText getTxtIdPers_Persona() {
		return txtIdPers_Persona;
	}

	public void setTxtIdPers_Persona(InputText txtIdPers_Persona) {
		this.txtIdPers_Persona = txtIdPers_Persona;
	}

	public InputText getTxtIdSucu_Sucursal() {
		return txtIdSucu_Sucursal;
	}

	public void setTxtIdSucu_Sucursal(InputText txtIdSucu_Sucursal) {
		this.txtIdSucu_Sucursal = txtIdSucu_Sucursal;
	}

	public Calendar getTxtFechaCreacion() {
		return txtFechaCreacion;
	}

	public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
		this.txtFechaCreacion = txtFechaCreacion;
	}

	public Calendar getTxtFechaFinal() {
		return txtFechaFinal;
	}

	public void setTxtFechaFinal(Calendar txtFechaFinal) {
		this.txtFechaFinal = txtFechaFinal;
	}

	public Calendar getTxtFechaInicial() {
		return txtFechaInicial;
	}

	public void setTxtFechaInicial(Calendar txtFechaInicial) {
		this.txtFechaInicial = txtFechaInicial;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public InputText getTxtIdDeco() {
		return txtIdDeco;
	}

	public void setTxtIdDeco(InputText txtIdDeco) {
		this.txtIdDeco = txtIdDeco;
	}

	public List<DescuentoComercialDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataDescuentoComercial();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<DescuentoComercialDTO> descuentoComercialDTO) {
		this.data = descuentoComercialDTO;
	}

	public DescuentoComercialDTO getSelectedDescuentoComercial() {
		return selectedDescuentoComercial;
	}

	public void setSelectedDescuentoComercial(
			DescuentoComercialDTO descuentoComercial) {
		this.selectedDescuentoComercial = descuentoComercial;
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
