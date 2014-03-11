package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.DescuentoFinancieroDTO;
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
public class DescuentoFinancieroView {
	private InputText txtCodigo;
	private InputText txtDiaDesde;
	private InputText txtDiaHasta;
	private InputText txtEstadoRegistro;
	private InputText txtNombre;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtPorcentajeDescuento;
	private InputText txtIdGrpo_Grupo;
	private InputText txtIdTfpa_TipoFormaPago;
	private InputText txtIdDefi;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaFinal;
	private Calendar txtFechaInicio;
	private Calendar txtFechaModificacion;
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

	public DescuentoFinancieroView() {
		super();
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

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(descuentoFinancieroDTO
					.getEstadoRegistro());

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
				txtIdGrpo_Grupo = new InputText();
			}

			txtIdGrpo_Grupo.setValue(descuentoFinancieroDTO.getIdGrpo_Grupo());

			if (txtIdTfpa_TipoFormaPago == null) {
				txtIdTfpa_TipoFormaPago = new InputText();
			}

			txtIdTfpa_TipoFormaPago.setValue(descuentoFinancieroDTO
					.getIdTfpa_TipoFormaPago());

			if (txtIdDefi == null) {
				txtIdDefi = new InputText();
			}

			txtIdDefi.setValue(descuentoFinancieroDTO.getIdDefi());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
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
				txtFechaModificacion = new Calendar();
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
			txtCodigo.setDisabled(true);
		}

		if (txtDiaDesde != null) {
			txtDiaDesde.setValue(null);
			txtDiaDesde.setDisabled(true);
		}

		if (txtDiaHasta != null) {
			txtDiaHasta.setValue(null);
			txtDiaHasta.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
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

		if (txtPorcentajeDescuento != null) {
			txtPorcentajeDescuento.setValue(null);
			txtPorcentajeDescuento.setDisabled(true);
		}

		if (txtIdGrpo_Grupo != null) {
			txtIdGrpo_Grupo.setValue(null);
			txtIdGrpo_Grupo.setDisabled(true);
		}

		if (txtIdTfpa_TipoFormaPago != null) {
			txtIdTfpa_TipoFormaPago.setValue(null);
			txtIdTfpa_TipoFormaPago.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaFinal != null) {
			txtFechaFinal.setValue(null);
			txtFechaFinal.setDisabled(true);
		}

		if (txtFechaInicio != null) {
			txtFechaInicio.setValue(null);
			txtFechaInicio.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdDefi != null) {
			txtIdDefi.setValue(null);
			txtIdDefi.setDisabled(false);
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
			// TODO: handle exception
		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtDiaDesde.setDisabled(false);
			txtDiaHasta.setDisabled(false);
			txtEstadoRegistro.setDisabled(false);
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
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
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
		txtEstadoRegistro.setValue(selectedDescuentoFinanciero
				.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
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
			entity = new DescuentoFinanciero();

			Long idDefi = new Long(txtIdDefi.getValue().toString());

			entity.setCodigo(FacesUtils.checkLong(txtCodigo));
			entity.setDiaDesde(FacesUtils.checkLong(txtDiaDesde));
			entity.setDiaHasta(FacesUtils.checkLong(txtDiaHasta));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaFinal(FacesUtils.checkDate(txtFechaFinal));
			entity.setFechaInicio(FacesUtils.checkDate(txtFechaInicio));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setIdDefi(idDefi);
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
			businessDelegatorView.saveDescuentoFinanciero(entity);
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
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
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

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
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

	public InputText getTxtPorcentajeDescuento() {
		return txtPorcentajeDescuento;
	}

	public void setTxtPorcentajeDescuento(InputText txtPorcentajeDescuento) {
		this.txtPorcentajeDescuento = txtPorcentajeDescuento;
	}

	public InputText getTxtIdGrpo_Grupo() {
		return txtIdGrpo_Grupo;
	}

	public void setTxtIdGrpo_Grupo(InputText txtIdGrpo_Grupo) {
		this.txtIdGrpo_Grupo = txtIdGrpo_Grupo;
	}

	public InputText getTxtIdTfpa_TipoFormaPago() {
		return txtIdTfpa_TipoFormaPago;
	}

	public void setTxtIdTfpa_TipoFormaPago(InputText txtIdTfpa_TipoFormaPago) {
		this.txtIdTfpa_TipoFormaPago = txtIdTfpa_TipoFormaPago;
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

	public Calendar getTxtFechaInicio() {
		return txtFechaInicio;
	}

	public void setTxtFechaInicio(Calendar txtFechaInicio) {
		this.txtFechaInicio = txtFechaInicio;
	}

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
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
}
