package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.ChequePosfechadoDTO;
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
public class ChequePosfechadoView {
	private InputText txtBancoCambiado;
	private InputText txtEstado;
	private InputText txtEstadoRegistro;
	private InputText txtInaplicado;
	private InputText txtNumChqCambiado;
	private InputText txtNumeroCheque;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtOtroValor;
	private InputText txtRecaudador;
	private InputText txtTelefono;
	private InputText txtValor;
	private InputText txtIdChps;
	private Calendar txtFechaActualizacion;
	private Calendar txtFechaAplazada;
	private Calendar txtFechaConsignacion;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ChequePosfechadoDTO> data;
	private ChequePosfechadoDTO selectedChequePosfechado;
	private ChequePosfechado entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ChequePosfechadoView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ChequePosfechadoDTO chequePosfechadoDTO = (ChequePosfechadoDTO) e
					.getObject();

			if (txtBancoCambiado == null) {
				txtBancoCambiado = new InputText();
			}

			txtBancoCambiado.setValue(chequePosfechadoDTO.getBancoCambiado());

			if (txtEstado == null) {
				txtEstado = new InputText();
			}

			txtEstado.setValue(chequePosfechadoDTO.getEstado());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(chequePosfechadoDTO.getEstadoRegistro());

			if (txtInaplicado == null) {
				txtInaplicado = new InputText();
			}

			txtInaplicado.setValue(chequePosfechadoDTO.getInaplicado());

			if (txtNumChqCambiado == null) {
				txtNumChqCambiado = new InputText();
			}

			txtNumChqCambiado.setValue(chequePosfechadoDTO.getNumChqCambiado());

			if (txtNumeroCheque == null) {
				txtNumeroCheque = new InputText();
			}

			txtNumeroCheque.setValue(chequePosfechadoDTO.getNumeroCheque());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(chequePosfechadoDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(chequePosfechadoDTO.getOperModifica());

			if (txtOtroValor == null) {
				txtOtroValor = new InputText();
			}

			txtOtroValor.setValue(chequePosfechadoDTO.getOtroValor());

			if (txtRecaudador == null) {
				txtRecaudador = new InputText();
			}

			txtRecaudador.setValue(chequePosfechadoDTO.getRecaudador());

			if (txtTelefono == null) {
				txtTelefono = new InputText();
			}

			txtTelefono.setValue(chequePosfechadoDTO.getTelefono());

			if (txtValor == null) {
				txtValor = new InputText();
			}

			txtValor.setValue(chequePosfechadoDTO.getValor());

			if (txtIdChps == null) {
				txtIdChps = new InputText();
			}

			txtIdChps.setValue(chequePosfechadoDTO.getIdChps());

			if (txtFechaActualizacion == null) {
				txtFechaActualizacion = new Calendar();
			}

			txtFechaActualizacion.setValue(chequePosfechadoDTO
					.getFechaActualizacion());

			if (txtFechaAplazada == null) {
				txtFechaAplazada = new Calendar();
			}

			txtFechaAplazada.setValue(chequePosfechadoDTO.getFechaAplazada());

			if (txtFechaConsignacion == null) {
				txtFechaConsignacion = new Calendar();
			}

			txtFechaConsignacion.setValue(chequePosfechadoDTO
					.getFechaConsignacion());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(chequePosfechadoDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(chequePosfechadoDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedChequePosfechado = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedChequePosfechado = null;

		if (txtBancoCambiado != null) {
			txtBancoCambiado.setValue(null);
			txtBancoCambiado.setDisabled(true);
		}

		if (txtEstado != null) {
			txtEstado.setValue(null);
			txtEstado.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtInaplicado != null) {
			txtInaplicado.setValue(null);
			txtInaplicado.setDisabled(true);
		}

		if (txtNumChqCambiado != null) {
			txtNumChqCambiado.setValue(null);
			txtNumChqCambiado.setDisabled(true);
		}

		if (txtNumeroCheque != null) {
			txtNumeroCheque.setValue(null);
			txtNumeroCheque.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtOtroValor != null) {
			txtOtroValor.setValue(null);
			txtOtroValor.setDisabled(true);
		}

		if (txtRecaudador != null) {
			txtRecaudador.setValue(null);
			txtRecaudador.setDisabled(true);
		}

		if (txtTelefono != null) {
			txtTelefono.setValue(null);
			txtTelefono.setDisabled(true);
		}

		if (txtValor != null) {
			txtValor.setValue(null);
			txtValor.setDisabled(true);
		}

		if (txtFechaActualizacion != null) {
			txtFechaActualizacion.setValue(null);
			txtFechaActualizacion.setDisabled(true);
		}

		if (txtFechaAplazada != null) {
			txtFechaAplazada.setValue(null);
			txtFechaAplazada.setDisabled(true);
		}

		if (txtFechaConsignacion != null) {
			txtFechaConsignacion.setValue(null);
			txtFechaConsignacion.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdChps != null) {
			txtIdChps.setValue(null);
			txtIdChps.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		return "";
	}

	public void listener_txtFechaActualizacion() {
		Date inputDate = (Date) txtFechaActualizacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaAplazada() {
		Date inputDate = (Date) txtFechaAplazada.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaConsignacion() {
		Date inputDate = (Date) txtFechaConsignacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
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
			Long idChps = new Long(txtIdChps.getValue().toString());
			entity = businessDelegatorView.getChequePosfechado(idChps);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtBancoCambiado.setDisabled(false);
			txtEstado.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtInaplicado.setDisabled(false);
			txtNumChqCambiado.setDisabled(false);
			txtNumeroCheque.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtOtroValor.setDisabled(false);
			txtRecaudador.setDisabled(false);
			txtTelefono.setDisabled(false);
			txtValor.setDisabled(false);
			txtFechaActualizacion.setDisabled(false);
			txtFechaAplazada.setDisabled(false);
			txtFechaConsignacion.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdChps.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtBancoCambiado.setValue(entity.getBancoCambiado());
			txtBancoCambiado.setDisabled(false);
			txtEstado.setValue(entity.getEstado());
			txtEstado.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaActualizacion.setValue(entity.getFechaActualizacion());
			txtFechaActualizacion.setDisabled(false);
			txtFechaAplazada.setValue(entity.getFechaAplazada());
			txtFechaAplazada.setDisabled(false);
			txtFechaConsignacion.setValue(entity.getFechaConsignacion());
			txtFechaConsignacion.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtInaplicado.setValue(entity.getInaplicado());
			txtInaplicado.setDisabled(false);
			txtNumChqCambiado.setValue(entity.getNumChqCambiado());
			txtNumChqCambiado.setDisabled(false);
			txtNumeroCheque.setValue(entity.getNumeroCheque());
			txtNumeroCheque.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtOtroValor.setValue(entity.getOtroValor());
			txtOtroValor.setDisabled(false);
			txtRecaudador.setValue(entity.getRecaudador());
			txtRecaudador.setDisabled(false);
			txtTelefono.setValue(entity.getTelefono());
			txtTelefono.setDisabled(false);
			txtValor.setValue(entity.getValor());
			txtValor.setDisabled(false);
			txtIdChps.setValue(entity.getIdChps());
			txtIdChps.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedChequePosfechado = (ChequePosfechadoDTO) (evt.getComponent()
				.getAttributes().get("selectedChequePosfechado"));
		txtBancoCambiado.setValue(selectedChequePosfechado.getBancoCambiado());
		txtBancoCambiado.setDisabled(false);
		txtEstado.setValue(selectedChequePosfechado.getEstado());
		txtEstado.setDisabled(false);
		txtEstadoRegistro
				.setValue(selectedChequePosfechado.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaActualizacion.setValue(selectedChequePosfechado
				.getFechaActualizacion());
		txtFechaActualizacion.setDisabled(false);
		txtFechaAplazada.setValue(selectedChequePosfechado.getFechaAplazada());
		txtFechaAplazada.setDisabled(false);
		txtFechaConsignacion.setValue(selectedChequePosfechado
				.getFechaConsignacion());
		txtFechaConsignacion.setDisabled(false);
		txtFechaCreacion.setValue(selectedChequePosfechado.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedChequePosfechado
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtInaplicado.setValue(selectedChequePosfechado.getInaplicado());
		txtInaplicado.setDisabled(false);
		txtNumChqCambiado
				.setValue(selectedChequePosfechado.getNumChqCambiado());
		txtNumChqCambiado.setDisabled(false);
		txtNumeroCheque.setValue(selectedChequePosfechado.getNumeroCheque());
		txtNumeroCheque.setDisabled(false);
		txtOperCreador.setValue(selectedChequePosfechado.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedChequePosfechado.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtOtroValor.setValue(selectedChequePosfechado.getOtroValor());
		txtOtroValor.setDisabled(false);
		txtRecaudador.setValue(selectedChequePosfechado.getRecaudador());
		txtRecaudador.setDisabled(false);
		txtTelefono.setValue(selectedChequePosfechado.getTelefono());
		txtTelefono.setDisabled(false);
		txtValor.setValue(selectedChequePosfechado.getValor());
		txtValor.setDisabled(false);
		txtIdChps.setValue(selectedChequePosfechado.getIdChps());
		txtIdChps.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedChequePosfechado == null) && (entity == null)) {
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
			entity = new ChequePosfechado();

			Long idChps = new Long(txtIdChps.getValue().toString());

			entity.setBancoCambiado(FacesUtils.checkString(txtBancoCambiado));
			entity.setEstado(FacesUtils.checkLong(txtEstado));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaActualizacion(FacesUtils
					.checkDate(txtFechaActualizacion));
			entity.setFechaAplazada(FacesUtils.checkDate(txtFechaAplazada));
			entity.setFechaConsignacion(FacesUtils
					.checkDate(txtFechaConsignacion));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdChps(idChps);
			entity.setInaplicado(FacesUtils.checkString(txtInaplicado));
			entity.setNumChqCambiado(FacesUtils.checkString(txtNumChqCambiado));
			entity.setNumeroCheque(FacesUtils.checkString(txtNumeroCheque));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setOtroValor(FacesUtils.checkDouble(txtOtroValor));
			entity.setRecaudador(FacesUtils.checkString(txtRecaudador));
			entity.setTelefono(FacesUtils.checkString(txtTelefono));
			entity.setValor(FacesUtils.checkDouble(txtValor));
			businessDelegatorView.saveChequePosfechado(entity);
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
				Long idChps = new Long(selectedChequePosfechado.getIdChps());
				entity = businessDelegatorView.getChequePosfechado(idChps);
			}

			entity.setBancoCambiado(FacesUtils.checkString(txtBancoCambiado));
			entity.setEstado(FacesUtils.checkLong(txtEstado));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaActualizacion(FacesUtils
					.checkDate(txtFechaActualizacion));
			entity.setFechaAplazada(FacesUtils.checkDate(txtFechaAplazada));
			entity.setFechaConsignacion(FacesUtils
					.checkDate(txtFechaConsignacion));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setInaplicado(FacesUtils.checkString(txtInaplicado));
			entity.setNumChqCambiado(FacesUtils.checkString(txtNumChqCambiado));
			entity.setNumeroCheque(FacesUtils.checkString(txtNumeroCheque));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setOtroValor(FacesUtils.checkDouble(txtOtroValor));
			entity.setRecaudador(FacesUtils.checkString(txtRecaudador));
			entity.setTelefono(FacesUtils.checkString(txtTelefono));
			entity.setValor(FacesUtils.checkDouble(txtValor));
			businessDelegatorView.updateChequePosfechado(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedChequePosfechado = (ChequePosfechadoDTO) (evt
					.getComponent().getAttributes()
					.get("selectedChequePosfechado"));

			Long idChps = new Long(selectedChequePosfechado.getIdChps());
			entity = businessDelegatorView.getChequePosfechado(idChps);
			businessDelegatorView.deleteChequePosfechado(entity);
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
			selectedChequePosfechado = (ChequePosfechadoDTO) (evt
					.getComponent().getAttributes()
					.get("selectedChequePosfechado"));

			Long idChps = new Long(selectedChequePosfechado.getIdChps());
			entity = businessDelegatorView.getChequePosfechado(idChps);
			businessDelegatorView.deleteChequePosfechado(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedChequePosfechado);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String bancoCambiado, Long estado,
			String estadoRegistro, Date fechaActualizacion, Date fechaAplazada,
			Date fechaConsignacion, Date fechaCreacion, Date fechaModificacion,
			Long idChps, String inaplicado, String numChqCambiado,
			String numeroCheque, String operCreador, String operModifica,
			Double otroValor, String recaudador, String telefono, Double valor)
			throws Exception {
		try {
			entity.setBancoCambiado(FacesUtils.checkString(bancoCambiado));
			entity.setEstado(FacesUtils.checkLong(estado));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaActualizacion(FacesUtils
					.checkDate(fechaActualizacion));
			entity.setFechaAplazada(FacesUtils.checkDate(fechaAplazada));
			entity.setFechaConsignacion(FacesUtils.checkDate(fechaConsignacion));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setInaplicado(FacesUtils.checkString(inaplicado));
			entity.setNumChqCambiado(FacesUtils.checkString(numChqCambiado));
			entity.setNumeroCheque(FacesUtils.checkString(numeroCheque));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setOtroValor(FacesUtils.checkDouble(otroValor));
			entity.setRecaudador(FacesUtils.checkString(recaudador));
			entity.setTelefono(FacesUtils.checkString(telefono));
			entity.setValor(FacesUtils.checkDouble(valor));
			businessDelegatorView.updateChequePosfechado(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ChequePosfechadoView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtBancoCambiado() {
		return txtBancoCambiado;
	}

	public void setTxtBancoCambiado(InputText txtBancoCambiado) {
		this.txtBancoCambiado = txtBancoCambiado;
	}

	public InputText getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(InputText txtEstado) {
		this.txtEstado = txtEstado;
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}

	public InputText getTxtInaplicado() {
		return txtInaplicado;
	}

	public void setTxtInaplicado(InputText txtInaplicado) {
		this.txtInaplicado = txtInaplicado;
	}

	public InputText getTxtNumChqCambiado() {
		return txtNumChqCambiado;
	}

	public void setTxtNumChqCambiado(InputText txtNumChqCambiado) {
		this.txtNumChqCambiado = txtNumChqCambiado;
	}

	public InputText getTxtNumeroCheque() {
		return txtNumeroCheque;
	}

	public void setTxtNumeroCheque(InputText txtNumeroCheque) {
		this.txtNumeroCheque = txtNumeroCheque;
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

	public InputText getTxtOtroValor() {
		return txtOtroValor;
	}

	public void setTxtOtroValor(InputText txtOtroValor) {
		this.txtOtroValor = txtOtroValor;
	}

	public InputText getTxtRecaudador() {
		return txtRecaudador;
	}

	public void setTxtRecaudador(InputText txtRecaudador) {
		this.txtRecaudador = txtRecaudador;
	}

	public InputText getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(InputText txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public InputText getTxtValor() {
		return txtValor;
	}

	public void setTxtValor(InputText txtValor) {
		this.txtValor = txtValor;
	}

	public Calendar getTxtFechaActualizacion() {
		return txtFechaActualizacion;
	}

	public void setTxtFechaActualizacion(Calendar txtFechaActualizacion) {
		this.txtFechaActualizacion = txtFechaActualizacion;
	}

	public Calendar getTxtFechaAplazada() {
		return txtFechaAplazada;
	}

	public void setTxtFechaAplazada(Calendar txtFechaAplazada) {
		this.txtFechaAplazada = txtFechaAplazada;
	}

	public Calendar getTxtFechaConsignacion() {
		return txtFechaConsignacion;
	}

	public void setTxtFechaConsignacion(Calendar txtFechaConsignacion) {
		this.txtFechaConsignacion = txtFechaConsignacion;
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

	public InputText getTxtIdChps() {
		return txtIdChps;
	}

	public void setTxtIdChps(InputText txtIdChps) {
		this.txtIdChps = txtIdChps;
	}

	public List<ChequePosfechadoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataChequePosfechado();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ChequePosfechadoDTO> chequePosfechadoDTO) {
		this.data = chequePosfechadoDTO;
	}

	public ChequePosfechadoDTO getSelectedChequePosfechado() {
		return selectedChequePosfechado;
	}

	public void setSelectedChequePosfechado(ChequePosfechadoDTO chequePosfechado) {
		this.selectedChequePosfechado = chequePosfechado;
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
