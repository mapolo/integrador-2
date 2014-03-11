package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.CruceDTO;
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
public class CruceView {
	private InputText txtDescuento;
	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdDefi_DescuentoFinanciero;
	private InputText txtIdRddo_RboDetalleDocumentos;
	private InputText txtIdRdfp_RboDetalleFormasPago;
	private InputText txtIdCrce;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<CruceDTO> data;
	private CruceDTO selectedCruce;
	private Cruce entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public CruceView() {
		super();
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			CruceDTO cruceDTO = (CruceDTO) e.getObject();

			if (txtDescuento == null) {
				txtDescuento = new InputText();
			}

			txtDescuento.setValue(cruceDTO.getDescuento());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(cruceDTO.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(cruceDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(cruceDTO.getOperModifica());

			if (txtIdDefi_DescuentoFinanciero == null) {
				txtIdDefi_DescuentoFinanciero = new InputText();
			}

			txtIdDefi_DescuentoFinanciero.setValue(cruceDTO
					.getIdDefi_DescuentoFinanciero());

			if (txtIdRddo_RboDetalleDocumentos == null) {
				txtIdRddo_RboDetalleDocumentos = new InputText();
			}

			txtIdRddo_RboDetalleDocumentos.setValue(cruceDTO
					.getIdRddo_RboDetalleDocumentos());

			if (txtIdRdfp_RboDetalleFormasPago == null) {
				txtIdRdfp_RboDetalleFormasPago = new InputText();
			}

			txtIdRdfp_RboDetalleFormasPago.setValue(cruceDTO
					.getIdRdfp_RboDetalleFormasPago());

			if (txtIdCrce == null) {
				txtIdCrce = new InputText();
			}

			txtIdCrce.setValue(cruceDTO.getIdCrce());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(cruceDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(cruceDTO.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedCruce = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedCruce = null;

		if (txtDescuento != null) {
			txtDescuento.setValue(null);
			txtDescuento.setDisabled(true);
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

		if (txtIdDefi_DescuentoFinanciero != null) {
			txtIdDefi_DescuentoFinanciero.setValue(null);
			txtIdDefi_DescuentoFinanciero.setDisabled(true);
		}

		if (txtIdRddo_RboDetalleDocumentos != null) {
			txtIdRddo_RboDetalleDocumentos.setValue(null);
			txtIdRddo_RboDetalleDocumentos.setDisabled(true);
		}

		if (txtIdRdfp_RboDetalleFormasPago != null) {
			txtIdRdfp_RboDetalleFormasPago.setValue(null);
			txtIdRdfp_RboDetalleFormasPago.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdCrce != null) {
			txtIdCrce.setValue(null);
			txtIdCrce.setDisabled(false);
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
			Long idCrce = new Long(txtIdCrce.getValue().toString());
			entity = businessDelegatorView.getCruce(idCrce);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtDescuento.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdDefi_DescuentoFinanciero.setDisabled(false);
			txtIdRddo_RboDetalleDocumentos.setDisabled(false);
			txtIdRdfp_RboDetalleFormasPago.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdCrce.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtDescuento.setValue(entity.getDescuento());
			txtDescuento.setDisabled(false);
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdDefi_DescuentoFinanciero.setValue(entity
					.getDescuentoFinanciero().getIdDefi());
			txtIdDefi_DescuentoFinanciero.setDisabled(false);
			txtIdRddo_RboDetalleDocumentos.setValue(entity
					.getRboDetalleDocumentos().getIdRddo());
			txtIdRddo_RboDetalleDocumentos.setDisabled(false);
			txtIdRdfp_RboDetalleFormasPago.setValue(entity
					.getRboDetalleFormasPago().getIdRdfp());
			txtIdRdfp_RboDetalleFormasPago.setDisabled(false);
			txtIdCrce.setValue(entity.getIdCrce());
			txtIdCrce.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedCruce = (CruceDTO) (evt.getComponent().getAttributes()
				.get("selectedCruce"));
		txtDescuento.setValue(selectedCruce.getDescuento());
		txtDescuento.setDisabled(false);
		txtEstadoRegistro.setValue(selectedCruce.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedCruce.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedCruce.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedCruce.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedCruce.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdDefi_DescuentoFinanciero.setValue(selectedCruce
				.getIdDefi_DescuentoFinanciero());
		txtIdDefi_DescuentoFinanciero.setDisabled(false);
		txtIdRddo_RboDetalleDocumentos.setValue(selectedCruce
				.getIdRddo_RboDetalleDocumentos());
		txtIdRddo_RboDetalleDocumentos.setDisabled(false);
		txtIdRdfp_RboDetalleFormasPago.setValue(selectedCruce
				.getIdRdfp_RboDetalleFormasPago());
		txtIdRdfp_RboDetalleFormasPago.setDisabled(false);
		txtIdCrce.setValue(selectedCruce.getIdCrce());
		txtIdCrce.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedCruce == null) && (entity == null)) {
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
			entity = new Cruce();

			Long idCrce = new Long(txtIdCrce.getValue().toString());

			entity.setDescuento(FacesUtils.checkDouble(txtDescuento));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdCrce(idCrce);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setDescuentoFinanciero(businessDelegatorView
					.getDescuentoFinanciero(FacesUtils
							.checkLong(txtIdDefi_DescuentoFinanciero)));
			entity.setRboDetalleDocumentos(businessDelegatorView
					.getRboDetalleDocumentos(FacesUtils
							.checkLong(txtIdRddo_RboDetalleDocumentos)));
			entity.setRboDetalleFormasPago(businessDelegatorView
					.getRboDetalleFormasPago(FacesUtils
							.checkLong(txtIdRdfp_RboDetalleFormasPago)));
			businessDelegatorView.saveCruce(entity);
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
				Long idCrce = new Long(selectedCruce.getIdCrce());
				entity = businessDelegatorView.getCruce(idCrce);
			}

			entity.setDescuento(FacesUtils.checkDouble(txtDescuento));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setDescuentoFinanciero(businessDelegatorView
					.getDescuentoFinanciero(FacesUtils
							.checkLong(txtIdDefi_DescuentoFinanciero)));
			entity.setRboDetalleDocumentos(businessDelegatorView
					.getRboDetalleDocumentos(FacesUtils
							.checkLong(txtIdRddo_RboDetalleDocumentos)));
			entity.setRboDetalleFormasPago(businessDelegatorView
					.getRboDetalleFormasPago(FacesUtils
							.checkLong(txtIdRdfp_RboDetalleFormasPago)));
			businessDelegatorView.updateCruce(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedCruce = (CruceDTO) (evt.getComponent().getAttributes()
					.get("selectedCruce"));

			Long idCrce = new Long(selectedCruce.getIdCrce());
			entity = businessDelegatorView.getCruce(idCrce);
			businessDelegatorView.deleteCruce(entity);
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
			selectedCruce = (CruceDTO) (evt.getComponent().getAttributes()
					.get("selectedCruce"));

			Long idCrce = new Long(selectedCruce.getIdCrce());
			entity = businessDelegatorView.getCruce(idCrce);
			businessDelegatorView.deleteCruce(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedCruce);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Double descuento, String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idCrce,
			String operCreador, String operModifica,
			Long idDefi_DescuentoFinanciero, Long idRddo_RboDetalleDocumentos,
			Long idRdfp_RboDetalleFormasPago) throws Exception {
		try {
			entity.setDescuento(FacesUtils.checkDouble(descuento));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateCruce(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("CruceView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtDescuento() {
		return txtDescuento;
	}

	public void setTxtDescuento(InputText txtDescuento) {
		this.txtDescuento = txtDescuento;
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

	public InputText getTxtIdDefi_DescuentoFinanciero() {
		return txtIdDefi_DescuentoFinanciero;
	}

	public void setTxtIdDefi_DescuentoFinanciero(
			InputText txtIdDefi_DescuentoFinanciero) {
		this.txtIdDefi_DescuentoFinanciero = txtIdDefi_DescuentoFinanciero;
	}

	public InputText getTxtIdRddo_RboDetalleDocumentos() {
		return txtIdRddo_RboDetalleDocumentos;
	}

	public void setTxtIdRddo_RboDetalleDocumentos(
			InputText txtIdRddo_RboDetalleDocumentos) {
		this.txtIdRddo_RboDetalleDocumentos = txtIdRddo_RboDetalleDocumentos;
	}

	public InputText getTxtIdRdfp_RboDetalleFormasPago() {
		return txtIdRdfp_RboDetalleFormasPago;
	}

	public void setTxtIdRdfp_RboDetalleFormasPago(
			InputText txtIdRdfp_RboDetalleFormasPago) {
		this.txtIdRdfp_RboDetalleFormasPago = txtIdRdfp_RboDetalleFormasPago;
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

	public InputText getTxtIdCrce() {
		return txtIdCrce;
	}

	public void setTxtIdCrce(InputText txtIdCrce) {
		this.txtIdCrce = txtIdCrce;
	}

	public List<CruceDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataCruce();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<CruceDTO> cruceDTO) {
		this.data = cruceDTO;
	}

	public CruceDTO getSelectedCruce() {
		return selectedCruce;
	}

	public void setSelectedCruce(CruceDTO cruce) {
		this.selectedCruce = cruce;
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
