package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.PresupuestoVentasDTO;
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
public class PresupuestoVentasView {
	private InputText txtAno;
	private InputText txtCanal;
	private InputText txtCantidadPresupuesto;
	private InputText txtEstadoRegistro;
	private InputText txtMes;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtValorPresupuesto;
	private InputText txtIdFlia_Familia;
	private InputText txtIdUnve_UnidadVenta;
	private InputText txtIdPven;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<PresupuestoVentasDTO> data;
	private PresupuestoVentasDTO selectedPresupuestoVentas;
	private PresupuestoVentas entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public PresupuestoVentasView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			PresupuestoVentasDTO presupuestoVentasDTO = (PresupuestoVentasDTO) e
					.getObject();

			if (txtAno == null) {
				txtAno = new InputText();
			}

			txtAno.setValue(presupuestoVentasDTO.getAno());

			if (txtCanal == null) {
				txtCanal = new InputText();
			}

			txtCanal.setValue(presupuestoVentasDTO.getCanal());

			if (txtCantidadPresupuesto == null) {
				txtCantidadPresupuesto = new InputText();
			}

			txtCantidadPresupuesto.setValue(presupuestoVentasDTO
					.getCantidadPresupuesto());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro
					.setValue(presupuestoVentasDTO.getEstadoRegistro());

			if (txtMes == null) {
				txtMes = new InputText();
			}

			txtMes.setValue(presupuestoVentasDTO.getMes());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(presupuestoVentasDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(presupuestoVentasDTO.getOperModifica());

			if (txtValorPresupuesto == null) {
				txtValorPresupuesto = new InputText();
			}

			txtValorPresupuesto.setValue(presupuestoVentasDTO
					.getValorPresupuesto());

			if (txtIdFlia_Familia == null) {
				txtIdFlia_Familia = new InputText();
			}

			txtIdFlia_Familia
					.setValue(presupuestoVentasDTO.getIdFlia_Familia());

			if (txtIdUnve_UnidadVenta == null) {
				txtIdUnve_UnidadVenta = new InputText();
			}

			txtIdUnve_UnidadVenta.setValue(presupuestoVentasDTO
					.getIdUnve_UnidadVenta());

			if (txtIdPven == null) {
				txtIdPven = new InputText();
			}

			txtIdPven.setValue(presupuestoVentasDTO.getIdPven());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(presupuestoVentasDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(presupuestoVentasDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedPresupuestoVentas = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedPresupuestoVentas = null;

		if (txtAno != null) {
			txtAno.setValue(null);
			txtAno.setDisabled(true);
		}

		if (txtCanal != null) {
			txtCanal.setValue(null);
			txtCanal.setDisabled(true);
		}

		if (txtCantidadPresupuesto != null) {
			txtCantidadPresupuesto.setValue(null);
			txtCantidadPresupuesto.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtMes != null) {
			txtMes.setValue(null);
			txtMes.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtValorPresupuesto != null) {
			txtValorPresupuesto.setValue(null);
			txtValorPresupuesto.setDisabled(true);
		}

		if (txtIdFlia_Familia != null) {
			txtIdFlia_Familia.setValue(null);
			txtIdFlia_Familia.setDisabled(true);
		}

		if (txtIdUnve_UnidadVenta != null) {
			txtIdUnve_UnidadVenta.setValue(null);
			txtIdUnve_UnidadVenta.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdPven != null) {
			txtIdPven.setValue(null);
			txtIdPven.setDisabled(false);
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
			Long idPven = new Long(txtIdPven.getValue().toString());
			entity = businessDelegatorView.getPresupuestoVentas(idPven);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtAno.setDisabled(false);
			txtCanal.setDisabled(false);
			txtCantidadPresupuesto.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtMes.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtValorPresupuesto.setDisabled(false);
			txtIdFlia_Familia.setDisabled(false);
			txtIdUnve_UnidadVenta.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdPven.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtAno.setValue(entity.getAno());
			txtAno.setDisabled(false);
			txtCanal.setValue(entity.getCanal());
			txtCanal.setDisabled(false);
			txtCantidadPresupuesto.setValue(entity.getCantidadPresupuesto());
			txtCantidadPresupuesto.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtMes.setValue(entity.getMes());
			txtMes.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtValorPresupuesto.setValue(entity.getValorPresupuesto());
			txtValorPresupuesto.setDisabled(false);
			txtIdFlia_Familia.setValue(entity.getFamilia().getIdFlia());
			txtIdFlia_Familia.setDisabled(false);
			txtIdUnve_UnidadVenta.setValue(entity.getUnidadVenta().getIdUnve());
			txtIdUnve_UnidadVenta.setDisabled(false);
			txtIdPven.setValue(entity.getIdPven());
			txtIdPven.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedPresupuestoVentas = (PresupuestoVentasDTO) (evt.getComponent()
				.getAttributes().get("selectedPresupuestoVentas"));
		txtAno.setValue(selectedPresupuestoVentas.getAno());
		txtAno.setDisabled(false);
		txtCanal.setValue(selectedPresupuestoVentas.getCanal());
		txtCanal.setDisabled(false);
		txtCantidadPresupuesto.setValue(selectedPresupuestoVentas
				.getCantidadPresupuesto());
		txtCantidadPresupuesto.setDisabled(false);
		txtEstadoRegistro.setValue(selectedPresupuestoVentas
				.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedPresupuestoVentas.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedPresupuestoVentas
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtMes.setValue(selectedPresupuestoVentas.getMes());
		txtMes.setDisabled(false);
		txtOperCreador.setValue(selectedPresupuestoVentas.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedPresupuestoVentas.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtValorPresupuesto.setValue(selectedPresupuestoVentas
				.getValorPresupuesto());
		txtValorPresupuesto.setDisabled(false);
		txtIdFlia_Familia.setValue(selectedPresupuestoVentas
				.getIdFlia_Familia());
		txtIdFlia_Familia.setDisabled(false);
		txtIdUnve_UnidadVenta.setValue(selectedPresupuestoVentas
				.getIdUnve_UnidadVenta());
		txtIdUnve_UnidadVenta.setDisabled(false);
		txtIdPven.setValue(selectedPresupuestoVentas.getIdPven());
		txtIdPven.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedPresupuestoVentas == null) && (entity == null)) {
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
			entity = new PresupuestoVentas();

			Long idPven = new Long(txtIdPven.getValue().toString());

			entity.setAno(FacesUtils.checkLong(txtAno));
			entity.setCanal(FacesUtils.checkString(txtCanal));
			entity.setCantidadPresupuesto(FacesUtils
					.checkDouble(txtCantidadPresupuesto));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdPven(idPven);
			entity.setMes(FacesUtils.checkLong(txtMes));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setValorPresupuesto(FacesUtils
					.checkDouble(txtValorPresupuesto));
			entity.setFamilia(businessDelegatorView.getFamilia(FacesUtils
					.checkLong(txtIdFlia_Familia)));
			entity.setUnidadVenta(businessDelegatorView
					.getUnidadVenta(FacesUtils.checkLong(txtIdUnve_UnidadVenta)));
			businessDelegatorView.savePresupuestoVentas(entity);
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
				Long idPven = new Long(selectedPresupuestoVentas.getIdPven());
				entity = businessDelegatorView.getPresupuestoVentas(idPven);
			}

			entity.setAno(FacesUtils.checkLong(txtAno));
			entity.setCanal(FacesUtils.checkString(txtCanal));
			entity.setCantidadPresupuesto(FacesUtils
					.checkDouble(txtCantidadPresupuesto));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setMes(FacesUtils.checkLong(txtMes));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setValorPresupuesto(FacesUtils
					.checkDouble(txtValorPresupuesto));
			entity.setFamilia(businessDelegatorView.getFamilia(FacesUtils
					.checkLong(txtIdFlia_Familia)));
			entity.setUnidadVenta(businessDelegatorView
					.getUnidadVenta(FacesUtils.checkLong(txtIdUnve_UnidadVenta)));
			businessDelegatorView.updatePresupuestoVentas(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedPresupuestoVentas = (PresupuestoVentasDTO) (evt
					.getComponent().getAttributes()
					.get("selectedPresupuestoVentas"));

			Long idPven = new Long(selectedPresupuestoVentas.getIdPven());
			entity = businessDelegatorView.getPresupuestoVentas(idPven);
			businessDelegatorView.deletePresupuestoVentas(entity);
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
			selectedPresupuestoVentas = (PresupuestoVentasDTO) (evt
					.getComponent().getAttributes()
					.get("selectedPresupuestoVentas"));

			Long idPven = new Long(selectedPresupuestoVentas.getIdPven());
			entity = businessDelegatorView.getPresupuestoVentas(idPven);
			businessDelegatorView.deletePresupuestoVentas(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedPresupuestoVentas);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long ano, String canal,
			Double cantidadPresupuesto, String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idPven, Long mes,
			String operCreador, String operModifica, Double valorPresupuesto,
			Long idFlia_Familia, Long idUnve_UnidadVenta) throws Exception {
		try {
			entity.setAno(FacesUtils.checkLong(ano));
			entity.setCanal(FacesUtils.checkString(canal));
			entity.setCantidadPresupuesto(FacesUtils
					.checkDouble(cantidadPresupuesto));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setMes(FacesUtils.checkLong(mes));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setValorPresupuesto(FacesUtils.checkDouble(valorPresupuesto));
			businessDelegatorView.updatePresupuestoVentas(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("PresupuestoVentasView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtAno() {
		return txtAno;
	}

	public void setTxtAno(InputText txtAno) {
		this.txtAno = txtAno;
	}

	public InputText getTxtCanal() {
		return txtCanal;
	}

	public void setTxtCanal(InputText txtCanal) {
		this.txtCanal = txtCanal;
	}

	public InputText getTxtCantidadPresupuesto() {
		return txtCantidadPresupuesto;
	}

	public void setTxtCantidadPresupuesto(InputText txtCantidadPresupuesto) {
		this.txtCantidadPresupuesto = txtCantidadPresupuesto;
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
	}

	public InputText getTxtMes() {
		return txtMes;
	}

	public void setTxtMes(InputText txtMes) {
		this.txtMes = txtMes;
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

	public InputText getTxtValorPresupuesto() {
		return txtValorPresupuesto;
	}

	public void setTxtValorPresupuesto(InputText txtValorPresupuesto) {
		this.txtValorPresupuesto = txtValorPresupuesto;
	}

	public InputText getTxtIdFlia_Familia() {
		return txtIdFlia_Familia;
	}

	public void setTxtIdFlia_Familia(InputText txtIdFlia_Familia) {
		this.txtIdFlia_Familia = txtIdFlia_Familia;
	}

	public InputText getTxtIdUnve_UnidadVenta() {
		return txtIdUnve_UnidadVenta;
	}

	public void setTxtIdUnve_UnidadVenta(InputText txtIdUnve_UnidadVenta) {
		this.txtIdUnve_UnidadVenta = txtIdUnve_UnidadVenta;
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

	public InputText getTxtIdPven() {
		return txtIdPven;
	}

	public void setTxtIdPven(InputText txtIdPven) {
		this.txtIdPven = txtIdPven;
	}

	public List<PresupuestoVentasDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataPresupuestoVentas();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<PresupuestoVentasDTO> presupuestoVentasDTO) {
		this.data = presupuestoVentasDTO;
	}

	public PresupuestoVentasDTO getSelectedPresupuestoVentas() {
		return selectedPresupuestoVentas;
	}

	public void setSelectedPresupuestoVentas(
			PresupuestoVentasDTO presupuestoVentas) {
		this.selectedPresupuestoVentas = presupuestoVentas;
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
