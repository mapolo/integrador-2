package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.ListaPreciosDTO;
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
public class ListaPreciosView {
	private InputText txtEspacios;
	private InputText txtEstadoRegistro;
	private InputText txtMargen;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtValor;
	private InputText txtIdRefe_Referencia;
	private InputText txtIdSucu_Sucursal;
	private InputText txtIdTili_TipoLista;
	private InputText txtIdLipr;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaFinal;
	private Calendar txtFechaInicial;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ListaPreciosDTO> data;
	private ListaPreciosDTO selectedListaPrecios;
	private ListaPrecios entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ListaPreciosView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ListaPreciosDTO listaPreciosDTO = (ListaPreciosDTO) e.getObject();

			if (txtEspacios == null) {
				txtEspacios = new InputText();
			}

			txtEspacios.setValue(listaPreciosDTO.getEspacios());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(listaPreciosDTO.getEstadoRegistro());

			if (txtMargen == null) {
				txtMargen = new InputText();
			}

			txtMargen.setValue(listaPreciosDTO.getMargen());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(listaPreciosDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(listaPreciosDTO.getOperModifica());

			if (txtValor == null) {
				txtValor = new InputText();
			}

			txtValor.setValue(listaPreciosDTO.getValor());

			if (txtIdRefe_Referencia == null) {
				txtIdRefe_Referencia = new InputText();
			}

			txtIdRefe_Referencia.setValue(listaPreciosDTO
					.getIdRefe_Referencia());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new InputText();
			}

			txtIdSucu_Sucursal.setValue(listaPreciosDTO.getIdSucu_Sucursal());

			if (txtIdTili_TipoLista == null) {
				txtIdTili_TipoLista = new InputText();
			}

			txtIdTili_TipoLista.setValue(listaPreciosDTO.getIdTili_TipoLista());

			if (txtIdLipr == null) {
				txtIdLipr = new InputText();
			}

			txtIdLipr.setValue(listaPreciosDTO.getIdLipr());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(listaPreciosDTO.getFechaCreacion());

			if (txtFechaFinal == null) {
				txtFechaFinal = new Calendar();
			}

			txtFechaFinal.setValue(listaPreciosDTO.getFechaFinal());

			if (txtFechaInicial == null) {
				txtFechaInicial = new Calendar();
			}

			txtFechaInicial.setValue(listaPreciosDTO.getFechaInicial());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(listaPreciosDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedListaPrecios = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedListaPrecios = null;

		if (txtEspacios != null) {
			txtEspacios.setValue(null);
			txtEspacios.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtMargen != null) {
			txtMargen.setValue(null);
			txtMargen.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtValor != null) {
			txtValor.setValue(null);
			txtValor.setDisabled(true);
		}

		if (txtIdRefe_Referencia != null) {
			txtIdRefe_Referencia.setValue(null);
			txtIdRefe_Referencia.setDisabled(true);
		}

		if (txtIdSucu_Sucursal != null) {
			txtIdSucu_Sucursal.setValue(null);
			txtIdSucu_Sucursal.setDisabled(true);
		}

		if (txtIdTili_TipoLista != null) {
			txtIdTili_TipoLista.setValue(null);
			txtIdTili_TipoLista.setDisabled(true);
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

		if (txtIdLipr != null) {
			txtIdLipr.setValue(null);
			txtIdLipr.setDisabled(false);
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
			Long idLipr = new Long(txtIdLipr.getValue().toString());
			entity = businessDelegatorView.getListaPrecios(idLipr);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEspacios.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtMargen.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtValor.setDisabled(false);
			txtIdRefe_Referencia.setDisabled(false);
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdTili_TipoLista.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaFinal.setDisabled(false);
			txtFechaInicial.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdLipr.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtEspacios.setValue(entity.getEspacios());
			txtEspacios.setDisabled(false);
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
			txtMargen.setValue(entity.getMargen());
			txtMargen.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtValor.setValue(entity.getValor());
			txtValor.setDisabled(false);
			txtIdRefe_Referencia.setValue(entity.getReferencia().getIdRefe());
			txtIdRefe_Referencia.setDisabled(false);
			txtIdSucu_Sucursal.setValue(entity.getSucursal().getIdSucu());
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdTili_TipoLista.setValue(entity.getTipoLista().getIdTili());
			txtIdTili_TipoLista.setDisabled(false);
			txtIdLipr.setValue(entity.getIdLipr());
			txtIdLipr.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedListaPrecios = (ListaPreciosDTO) (evt.getComponent()
				.getAttributes().get("selectedListaPrecios"));
		txtEspacios.setValue(selectedListaPrecios.getEspacios());
		txtEspacios.setDisabled(false);
		txtEstadoRegistro.setValue(selectedListaPrecios.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedListaPrecios.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaFinal.setValue(selectedListaPrecios.getFechaFinal());
		txtFechaFinal.setDisabled(false);
		txtFechaInicial.setValue(selectedListaPrecios.getFechaInicial());
		txtFechaInicial.setDisabled(false);
		txtFechaModificacion.setValue(selectedListaPrecios
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtMargen.setValue(selectedListaPrecios.getMargen());
		txtMargen.setDisabled(false);
		txtOperCreador.setValue(selectedListaPrecios.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedListaPrecios.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtValor.setValue(selectedListaPrecios.getValor());
		txtValor.setDisabled(false);
		txtIdRefe_Referencia.setValue(selectedListaPrecios
				.getIdRefe_Referencia());
		txtIdRefe_Referencia.setDisabled(false);
		txtIdSucu_Sucursal.setValue(selectedListaPrecios.getIdSucu_Sucursal());
		txtIdSucu_Sucursal.setDisabled(false);
		txtIdTili_TipoLista
				.setValue(selectedListaPrecios.getIdTili_TipoLista());
		txtIdTili_TipoLista.setDisabled(false);
		txtIdLipr.setValue(selectedListaPrecios.getIdLipr());
		txtIdLipr.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedListaPrecios == null) && (entity == null)) {
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
			entity = new ListaPrecios();

			Long idLipr = new Long(txtIdLipr.getValue().toString());

			entity.setEspacios(FacesUtils.checkString(txtEspacios));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdLipr(idLipr);
			entity.setMargen(FacesUtils.checkDouble(txtMargen));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setValor(FacesUtils.checkDouble(txtValor));
			entity.setReferencia(businessDelegatorView.getReferencia(FacesUtils
					.checkLong(txtIdRefe_Referencia)));
			entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			entity.setTipoLista(businessDelegatorView.getTipoLista(FacesUtils
					.checkLong(txtIdTili_TipoLista)));
			businessDelegatorView.saveListaPrecios(entity);
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
				Long idLipr = new Long(selectedListaPrecios.getIdLipr());
				entity = businessDelegatorView.getListaPrecios(idLipr);
			}

			entity.setEspacios(FacesUtils.checkString(txtEspacios));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(txtFechaInicial));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setMargen(FacesUtils.checkDouble(txtMargen));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setValor(FacesUtils.checkDouble(txtValor));
			entity.setReferencia(businessDelegatorView.getReferencia(FacesUtils
					.checkLong(txtIdRefe_Referencia)));
			entity.setSucursal(businessDelegatorView.getSucursal(FacesUtils
					.checkLong(txtIdSucu_Sucursal)));
			entity.setTipoLista(businessDelegatorView.getTipoLista(FacesUtils
					.checkLong(txtIdTili_TipoLista)));
			businessDelegatorView.updateListaPrecios(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedListaPrecios = (ListaPreciosDTO) (evt.getComponent()
					.getAttributes().get("selectedListaPrecios"));

			Long idLipr = new Long(selectedListaPrecios.getIdLipr());
			entity = businessDelegatorView.getListaPrecios(idLipr);
			businessDelegatorView.deleteListaPrecios(entity);
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
			selectedListaPrecios = (ListaPreciosDTO) (evt.getComponent()
					.getAttributes().get("selectedListaPrecios"));

			Long idLipr = new Long(selectedListaPrecios.getIdLipr());
			entity = businessDelegatorView.getListaPrecios(idLipr);
			businessDelegatorView.deleteListaPrecios(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedListaPrecios);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String espacios, String estadoRegistro,
			Date fechaCreacion, Date fechaFinal, Date fechaInicial,
			Date fechaModificacion, Long idLipr, Double margen,
			String operCreador, String operModifica, Double valor,
			Long idRefe_Referencia, Long idSucu_Sucursal, Long idTili_TipoLista)
			throws Exception {
		try {
			entity.setEspacios(FacesUtils.checkString(espacios));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(fechaFinal));
			entity.setFechaInicial(FacesUtils.checkDate(fechaInicial));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setMargen(FacesUtils.checkDouble(margen));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setValor(FacesUtils.checkDouble(valor));
			businessDelegatorView.updateListaPrecios(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ListaPreciosView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
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

	public InputText getTxtMargen() {
		return txtMargen;
	}

	public void setTxtMargen(InputText txtMargen) {
		this.txtMargen = txtMargen;
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

	public InputText getTxtValor() {
		return txtValor;
	}

	public void setTxtValor(InputText txtValor) {
		this.txtValor = txtValor;
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

	public InputText getTxtIdTili_TipoLista() {
		return txtIdTili_TipoLista;
	}

	public void setTxtIdTili_TipoLista(InputText txtIdTili_TipoLista) {
		this.txtIdTili_TipoLista = txtIdTili_TipoLista;
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

	public InputText getTxtIdLipr() {
		return txtIdLipr;
	}

	public void setTxtIdLipr(InputText txtIdLipr) {
		this.txtIdLipr = txtIdLipr;
	}

	public List<ListaPreciosDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataListaPrecios();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ListaPreciosDTO> listaPreciosDTO) {
		this.data = listaPreciosDTO;
	}

	public ListaPreciosDTO getSelectedListaPrecios() {
		return selectedListaPrecios;
	}

	public void setSelectedListaPrecios(ListaPreciosDTO listaPrecios) {
		this.selectedListaPrecios = listaPrecios;
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
