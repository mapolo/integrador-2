package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.ListaPreciosEspecialesDTO;
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
public class ListaPreciosEspecialesView {
	private InputText txtConcepto;
	private InputText txtEspacios;
	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtPrecio;
	private InputText txtTipoGrabado;
	private InputText txtIdEmpr_Empresa;
	private InputText txtIdPers_Persona;
	private InputText txtIdRefe_Referencia;
	private InputText txtIdSucu_Sucursal;
	private InputText txtIdLipe;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaInicial;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaVencimiento;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ListaPreciosEspecialesDTO> data;
	private ListaPreciosEspecialesDTO selectedListaPreciosEspeciales;
	private ListaPreciosEspeciales entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ListaPreciosEspecialesView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ListaPreciosEspecialesDTO listaPreciosEspecialesDTO = (ListaPreciosEspecialesDTO) e
					.getObject();

			if (txtConcepto == null) {
				txtConcepto = new InputText();
			}

			txtConcepto.setValue(listaPreciosEspecialesDTO.getConcepto());

			if (txtEspacios == null) {
				txtEspacios = new InputText();
			}

			txtEspacios.setValue(listaPreciosEspecialesDTO.getEspacios());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(listaPreciosEspecialesDTO
					.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(listaPreciosEspecialesDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(listaPreciosEspecialesDTO
					.getOperModifica());

			if (txtPrecio == null) {
				txtPrecio = new InputText();
			}

			txtPrecio.setValue(listaPreciosEspecialesDTO.getPrecio());

			if (txtTipoGrabado == null) {
				txtTipoGrabado = new InputText();
			}

			txtTipoGrabado.setValue(listaPreciosEspecialesDTO.getTipoGrabado());

			if (txtIdEmpr_Empresa == null) {
				txtIdEmpr_Empresa = new InputText();
			}

			txtIdEmpr_Empresa.setValue(listaPreciosEspecialesDTO
					.getIdEmpr_Empresa());

			if (txtIdPers_Persona == null) {
				txtIdPers_Persona = new InputText();
			}

			txtIdPers_Persona.setValue(listaPreciosEspecialesDTO
					.getIdPers_Persona());

			if (txtIdRefe_Referencia == null) {
				txtIdRefe_Referencia = new InputText();
			}

			txtIdRefe_Referencia.setValue(listaPreciosEspecialesDTO
					.getIdRefe_Referencia());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new InputText();
			}

			if (txtIdLipe == null) {
				txtIdLipe = new InputText();
			}

			txtIdLipe.setValue(listaPreciosEspecialesDTO.getIdLipe());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(listaPreciosEspecialesDTO
					.getFechaCreacion());

			if (txtFechaInicial == null) {
				txtFechaInicial = new Calendar();
			}

			txtFechaInicial.setValue(listaPreciosEspecialesDTO
					.getFechaInicial());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(listaPreciosEspecialesDTO
					.getFechaModificacion());

			if (txtFechaVencimiento == null) {
				txtFechaVencimiento = new Calendar();
			}

			txtFechaVencimiento.setValue(listaPreciosEspecialesDTO
					.getFechaVencimiento());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedListaPreciosEspeciales = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedListaPreciosEspeciales = null;

		if (txtConcepto != null) {
			txtConcepto.setValue(null);
			txtConcepto.setDisabled(true);
		}

		if (txtEspacios != null) {
			txtEspacios.setValue(null);
			txtEspacios.setDisabled(true);
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

		if (txtPrecio != null) {
			txtPrecio.setValue(null);
			txtPrecio.setDisabled(true);
		}

		if (txtTipoGrabado != null) {
			txtTipoGrabado.setValue(null);
			txtTipoGrabado.setDisabled(true);
		}

		if (txtIdEmpr_Empresa != null) {
			txtIdEmpr_Empresa.setValue(null);
			txtIdEmpr_Empresa.setDisabled(true);
		}

		if (txtIdPers_Persona != null) {
			txtIdPers_Persona.setValue(null);
			txtIdPers_Persona.setDisabled(true);
		}

		if (txtIdRefe_Referencia != null) {
			txtIdRefe_Referencia.setValue(null);
			txtIdRefe_Referencia.setDisabled(true);
		}

		if (txtIdSucu_Sucursal != null) {
			txtIdSucu_Sucursal.setValue(null);
			txtIdSucu_Sucursal.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaInicial != null) {
			txtFechaInicial.setValue(null);
			txtFechaInicial.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtFechaVencimiento != null) {
			txtFechaVencimiento.setValue(null);
			txtFechaVencimiento.setDisabled(true);
		}

		if (txtIdLipe != null) {
			txtIdLipe.setValue(null);
			txtIdLipe.setDisabled(false);
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

	public void listener_txtFechaVencimiento() {
		Date inputDate = (Date) txtFechaVencimiento.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Long idLipe = new Long(txtIdLipe.getValue().toString());
			entity = businessDelegatorView.getListaPreciosEspeciales(idLipe);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtConcepto.setDisabled(false);
			txtEspacios.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtPrecio.setDisabled(false);
			txtTipoGrabado.setDisabled(false);
			txtIdEmpr_Empresa.setDisabled(false);
			txtIdPers_Persona.setDisabled(false);
			txtIdRefe_Referencia.setDisabled(false);
			txtIdSucu_Sucursal.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtFechaVencimiento.setDisabled(false);
			txtIdLipe.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtConcepto.setValue(entity.getConcepto());
			txtConcepto.setDisabled(false);
			txtEspacios.setValue(entity.getEspacios());
			txtEspacios.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaInicial.setValue(entity.getFechaInicial());
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtFechaVencimiento.setValue(entity.getFechaVencimiento());
			txtFechaVencimiento.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtPrecio.setValue(entity.getPrecio());
			txtPrecio.setDisabled(false);
			txtTipoGrabado.setValue(entity.getTipoGrabado());
			txtTipoGrabado.setDisabled(false);
			txtIdEmpr_Empresa.setValue(entity.getEmpresa().getIdEmpr());
			txtIdEmpr_Empresa.setDisabled(false);
			txtIdPers_Persona.setValue(entity.getPersona().getIdPers());
			txtIdPers_Persona.setDisabled(false);
			txtIdRefe_Referencia.setValue(entity.getReferencia().getIdRefe());
			txtIdRefe_Referencia.setDisabled(false);

			txtIdSucu_Sucursal.setDisabled(false);
			txtIdLipe.setValue(entity.getIdLipe());
			txtIdLipe.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedListaPreciosEspeciales = (ListaPreciosEspecialesDTO) (evt
				.getComponent().getAttributes()
				.get("selectedListaPreciosEspeciales"));
		txtConcepto.setValue(selectedListaPreciosEspeciales.getConcepto());
		txtConcepto.setDisabled(false);
		txtEspacios.setValue(selectedListaPreciosEspeciales.getEspacios());
		txtEspacios.setDisabled(false);
		txtEstadoRegistro.setValue(selectedListaPreciosEspeciales
				.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedListaPreciosEspeciales
				.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaInicial.setValue(selectedListaPreciosEspeciales
				.getFechaInicial());
		txtFechaInicial.setDisabled(false);
		txtFechaModificacion.setValue(selectedListaPreciosEspeciales
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtFechaVencimiento.setValue(selectedListaPreciosEspeciales
				.getFechaVencimiento());
		txtFechaVencimiento.setDisabled(false);
		txtOperCreador
				.setValue(selectedListaPreciosEspeciales.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedListaPreciosEspeciales
				.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtPrecio.setValue(selectedListaPreciosEspeciales.getPrecio());
		txtPrecio.setDisabled(false);
		txtTipoGrabado
				.setValue(selectedListaPreciosEspeciales.getTipoGrabado());
		txtTipoGrabado.setDisabled(false);
		txtIdEmpr_Empresa.setValue(selectedListaPreciosEspeciales
				.getIdEmpr_Empresa());
		txtIdEmpr_Empresa.setDisabled(false);
		txtIdPers_Persona.setValue(selectedListaPreciosEspeciales
				.getIdPers_Persona());
		txtIdPers_Persona.setDisabled(false);
		txtIdRefe_Referencia.setValue(selectedListaPreciosEspeciales
				.getIdRefe_Referencia());
		txtIdRefe_Referencia.setDisabled(false);

		txtIdSucu_Sucursal.setDisabled(false);
		txtIdLipe.setValue(selectedListaPreciosEspeciales.getIdLipe());
		txtIdLipe.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedListaPreciosEspeciales == null) && (entity == null)) {
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
			entity = new ListaPreciosEspeciales();

			Long idLipe = new Long(txtIdLipe.getValue().toString());

			entity.setConcepto(FacesUtils.checkString(txtConcepto));
			entity.setEspacios(FacesUtils.checkString(txtEspacios));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaVencimiento(FacesUtils
					.checkDate(txtFechaVencimiento));
			entity.setIdLipe(idLipe);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setPrecio(FacesUtils.checkDouble(txtPrecio));
			entity.setTipoGrabado(FacesUtils.checkString(txtTipoGrabado));
			entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
					.checkLong(txtIdEmpr_Empresa)));
			entity.setPersona(businessDelegatorView.getPersona(FacesUtils
					.checkLong(txtIdPers_Persona)));
			entity.setReferencia(businessDelegatorView.getReferencia(FacesUtils
					.checkLong(txtIdRefe_Referencia)));

			businessDelegatorView.saveListaPreciosEspeciales(entity);
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
				Long idLipe = new Long(
						selectedListaPreciosEspeciales.getIdLipe());
				entity = businessDelegatorView
						.getListaPreciosEspeciales(idLipe);
			}

			entity.setConcepto(FacesUtils.checkString(txtConcepto));
			entity.setEspacios(FacesUtils.checkString(txtEspacios));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaVencimiento(FacesUtils
					.checkDate(txtFechaVencimiento));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setPrecio(FacesUtils.checkDouble(txtPrecio));
			entity.setTipoGrabado(FacesUtils.checkString(txtTipoGrabado));
			entity.setEmpresa(businessDelegatorView.getEmpresa(FacesUtils
					.checkLong(txtIdEmpr_Empresa)));
			entity.setPersona(businessDelegatorView.getPersona(FacesUtils
					.checkLong(txtIdPers_Persona)));
			entity.setReferencia(businessDelegatorView.getReferencia(FacesUtils
					.checkLong(txtIdRefe_Referencia)));

			businessDelegatorView.updateListaPreciosEspeciales(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedListaPreciosEspeciales = (ListaPreciosEspecialesDTO) (evt
					.getComponent().getAttributes()
					.get("selectedListaPreciosEspeciales"));

			Long idLipe = new Long(selectedListaPreciosEspeciales.getIdLipe());
			entity = businessDelegatorView.getListaPreciosEspeciales(idLipe);
			businessDelegatorView.deleteListaPreciosEspeciales(entity);
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
			selectedListaPreciosEspeciales = (ListaPreciosEspecialesDTO) (evt
					.getComponent().getAttributes()
					.get("selectedListaPreciosEspeciales"));

			Long idLipe = new Long(selectedListaPreciosEspeciales.getIdLipe());
			entity = businessDelegatorView.getListaPreciosEspeciales(idLipe);
			businessDelegatorView.deleteListaPreciosEspeciales(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedListaPreciosEspeciales);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String concepto, String espacios,
			String estadoRegistro, Date fechaCreacion, Date fechaInicial,
			Date fechaModificacion, Date fechaVencimiento, Long idLipe,
			String operCreador, String operModifica, Double precio,
			String tipoGrabado, Long idEmpr_Empresa, Long idPers_Persona,
			Long idRefe_Referencia, Long idSucu_Sucursal, Long idSucu_Sucursal0)
			throws Exception {
		try {
			entity.setConcepto(FacesUtils.checkString(concepto));
			entity.setEspacios(FacesUtils.checkString(espacios));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaInicial(FacesUtils.checkDate(fechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaVencimiento(FacesUtils.checkDate(fechaVencimiento));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setPrecio(FacesUtils.checkDouble(precio));
			entity.setTipoGrabado(FacesUtils.checkString(tipoGrabado));
			businessDelegatorView.updateListaPreciosEspeciales(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ListaPreciosEspecialesView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtConcepto() {
		return txtConcepto;
	}

	public void setTxtConcepto(InputText txtConcepto) {
		this.txtConcepto = txtConcepto;
	}

	public InputText getTxtEspacios() {
		return txtEspacios;
	}

	public void setTxtEspacios(InputText txtEspacios) {
		this.txtEspacios = txtEspacios;
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

	public InputText getTxtPrecio() {
		return txtPrecio;
	}

	public void setTxtPrecio(InputText txtPrecio) {
		this.txtPrecio = txtPrecio;
	}

	public InputText getTxtTipoGrabado() {
		return txtTipoGrabado;
	}

	public void setTxtTipoGrabado(InputText txtTipoGrabado) {
		this.txtTipoGrabado = txtTipoGrabado;
	}

	public InputText getTxtIdEmpr_Empresa() {
		return txtIdEmpr_Empresa;
	}

	public void setTxtIdEmpr_Empresa(InputText txtIdEmpr_Empresa) {
		this.txtIdEmpr_Empresa = txtIdEmpr_Empresa;
	}

	public InputText getTxtIdPers_Persona() {
		return txtIdPers_Persona;
	}

	public void setTxtIdPers_Persona(InputText txtIdPers_Persona) {
		this.txtIdPers_Persona = txtIdPers_Persona;
	}

	public InputText getTxtIdRefe_Referencia() {
		return txtIdRefe_Referencia;
	}

	public void setTxtIdRefe_Referencia(InputText txtIdRefe_Referencia) {
		this.txtIdRefe_Referencia = txtIdRefe_Referencia;
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

	public Calendar getTxtFechaVencimiento() {
		return txtFechaVencimiento;
	}

	public void setTxtFechaVencimiento(Calendar txtFechaVencimiento) {
		this.txtFechaVencimiento = txtFechaVencimiento;
	}

	public InputText getTxtIdLipe() {
		return txtIdLipe;
	}

	public void setTxtIdLipe(InputText txtIdLipe) {
		this.txtIdLipe = txtIdLipe;
	}

	public List<ListaPreciosEspecialesDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataListaPreciosEspeciales();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(
			List<ListaPreciosEspecialesDTO> listaPreciosEspecialesDTO) {
		this.data = listaPreciosEspecialesDTO;
	}

	public ListaPreciosEspecialesDTO getSelectedListaPreciosEspeciales() {
		return selectedListaPreciosEspeciales;
	}

	public void setSelectedListaPreciosEspeciales(
			ListaPreciosEspecialesDTO listaPreciosEspeciales) {
		this.selectedListaPreciosEspeciales = listaPreciosEspeciales;
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
