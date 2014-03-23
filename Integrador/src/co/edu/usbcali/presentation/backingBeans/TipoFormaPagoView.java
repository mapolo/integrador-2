package co.edu.usbcali.presentation.backingBeans;

import java.text.DateFormat;
import java.text.Format;
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
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.TipoFormaPago;
import co.edu.usbcali.modelo.dto.TipoFormaPagoDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

/**
 * 
 * 
 */
@ManagedBean
@ViewScoped
public class TipoFormaPagoView {
	private InputText txtCodigo;
	private InputTextarea txtDescripcion;
	private SelectOneMenu estado;
	private SelectOneMenu manejaCh;
	private SelectOneMenu manejaTc;
	private SelectOneMenu exige;
	private SelectOneMenu es;
	private SelectOneMenu importa;
	private SelectOneMenu descuento;
	private InputText txtDsctoFechaDoc;
	private InputText txtEsPosfechado;
	// private InputText txtEstadoRegistro;
	private InputText txtExijeNumeroDocumento;
	private InputText txtImportaPda;
	private InputText txtManejaCheque;
	private InputText txtManejaTarjeta;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdTfpa;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;

	private String codigo;
	private String descripcion;
	private String dsctoFechaDoc;
	private String esPosfechado;
	private String estadoRegistro;
	private String exijeNumeroDocumento;
	private String importaPda;
	private String manejaCheque;
	private String manejaTarjeta;
	private String operCreador;
	private String operModifica;
	private String idTfpa;
	private String fechaCreacion;
	private String fechaModificacion;

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private CommandButton btnCrear;
	private List<TipoFormaPagoDTO> data;
	private TipoFormaPagoDTO selectedTipoFormaPago;
	private TipoFormaPago entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private SelectItem[] manufacturerOptions;
	private SelectItem[] manufacturerOptions2;

	String manufacturers[] = { "A", "R" };
	String manufacturers2[] = { "1", "0" };

	public String getDsctoFechaDoc() {
		return dsctoFechaDoc;
	}

	public void setDsctoFechaDoc(String dsctoFechaDoc) {
		this.dsctoFechaDoc = dsctoFechaDoc;
	}

	public String getEsPosfechado() {
		return esPosfechado;
	}

	public void setEsPosfechado(String esPosfechado) {
		this.esPosfechado = esPosfechado;
	}

	public String getExijeNumeroDocumento() {
		return exijeNumeroDocumento;
	}

	public void setExijeNumeroDocumento(String exijeNumeroDocumento) {
		this.exijeNumeroDocumento = exijeNumeroDocumento;
	}

	public String getImportaPda() {
		return importaPda;
	}

	public void setImportaPda(String importaPda) {
		this.importaPda = importaPda;
	}

	public String getManejaCheque() {
		return manejaCheque;
	}

	public void setManejaCheque(String manejaCheque) {
		this.manejaCheque = manejaCheque;
	}

	public String getManejaTarjeta() {
		return manejaTarjeta;
	}

	public void setManejaTarjeta(String manejaTarjeta) {
		this.manejaTarjeta = manejaTarjeta;
	}

	public TipoFormaPagoView() {
		super();

		setManufacturerOptions(createFilterOptions(manufacturers));
		setManufacturerOptions2(createFilterOptions(manufacturers2));
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			TipoFormaPagoDTO tipoFormaPagoDTO = (TipoFormaPagoDTO) e
					.getObject();

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(tipoFormaPagoDTO.getCodigo());

			if (txtDescripcion == null) {
				txtDescripcion = new InputTextarea();
			}

			txtDescripcion.setValue(tipoFormaPagoDTO.getDescripcion());

			if (txtDsctoFechaDoc == null) {
				txtDsctoFechaDoc = new InputText();
			}

			txtDsctoFechaDoc.setValue(tipoFormaPagoDTO.getDsctoFechaDoc());

			if (txtEsPosfechado == null) {
				txtEsPosfechado = new InputText();
			}

			txtEsPosfechado.setValue(tipoFormaPagoDTO.getEsPosfechado());

			/*
			 * if (txtEstadoRegistro == null) { txtEstadoRegistro = new
			 * InputText(); }
			 * 
			 * txtEstadoRegistro.setValue(tipoFormaPagoDTO.getEstadoRegistro());
			 */

			if (txtExijeNumeroDocumento == null) {
				txtExijeNumeroDocumento = new InputText();
			}

			txtExijeNumeroDocumento.setValue(tipoFormaPagoDTO
					.getExijeNumeroDocumento());

			if (txtImportaPda == null) {
				txtImportaPda = new InputText();
			}

			txtImportaPda.setValue(tipoFormaPagoDTO.getImportaPda());

			if (txtManejaCheque == null) {
				txtManejaCheque = new InputText();
			}

			txtManejaCheque.setValue(tipoFormaPagoDTO.getManejaCheque());

			if (txtManejaTarjeta == null) {
				txtManejaTarjeta = new InputText();
			}

			txtManejaTarjeta.setValue(tipoFormaPagoDTO.getManejaTarjeta());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(tipoFormaPagoDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(tipoFormaPagoDTO.getOperModifica());

			if (txtIdTfpa == null) {
				txtIdTfpa = new InputText();
			}

			txtIdTfpa.setValue(tipoFormaPagoDTO.getIdTfpa());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(tipoFormaPagoDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(tipoFormaPagoDTO
					.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String actualizar() {
		return "tipoFormaPago.xhtml?faces-redirect=true";
	}

	public String principalPagina() {
		return "tipoFormaPago.xhtml";
	}

	public String action_new() {
		action_clear();
		selectedTipoFormaPago = null;
		setShowDialog(true);

		return "";
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
					.getTipoFormaPago(((TipoFormaPagoDTO) event.getObject())
							.getIdTfpa());

			// operCreador =((TipoDivisionDTO)
			// event.getObject()).getOperCreador();
			// entity.setOperCreador(operCreador);
			
			
			descripcion = ((TipoFormaPagoDTO) event.getObject()).getDescripcion();
			entity.setDescripcion(descripcion);
			
			codigo = ((TipoFormaPagoDTO) event.getObject()).getCodigo();
			entity.setCodigo(codigo);

			Long manejaCheque = new Long(manejaCh.getValue().toString());
			entity.setManejaCheque(manejaCheque);
			Long manejaTarjeta = new Long(manejaTc.getValue().toString());
			entity.setManejaTarjeta(manejaTarjeta);
			Long exijeNumeroDocumento = new Long(exige.getValue().toString());
			entity.setExijeNumeroDocumento(exijeNumeroDocumento);
			Long esPosfechado = new Long(es.getValue().toString());
			entity.setEsPosfechado(esPosfechado);
			Long importaPda = new Long(importa.getValue().toString());
			entity.setImportaPda(importaPda);
			Long dsctoFechaDoc = new Long(descuento.getValue().toString());
			entity.setDsctoFechaDoc(dsctoFechaDoc);
			
			entity.setEstadoRegistro(estadoRegistro);	
			String usuario =(String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);
			entity.setFechaModificacion(new Date());
			// entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			// entity.setOperModifica(FacesUtils.checkString(txtOperModifica));

			businessDelegatorView.updateTipoFormaPago(entity);
			data = businessDelegatorView.getDataTipoFormaPago();
			RequestContext.getCurrentInstance().reset("form:tfp");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("TipoEstado Cancelled",
				((TipoFormaPagoDTO) event.getObject()).getIdTfpa() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((TipoFormaPagoDTO) event.getObject()).getIdTfpa());
	}

	public String action_buscar() {
		try {
			entity = businessDelegatorView
					.getTipoFormaPago(selectedTipoFormaPago.getIdTfpa());

			idTfpa = entity.getIdTfpa() + "";

			descripcion = entity.getDescripcion();
			txtCodigo.setValue(entity.getCodigo());
			txtExijeNumeroDocumento.setValue(entity.getExijeNumeroDocumento());
			txtDsctoFechaDoc.setValue(entity.getDsctoFechaDoc());
			txtEsPosfechado.setValue(entity.getEsPosfechado());
			// txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtImportaPda.setValue(entity.getImportaPda());
			txtManejaCheque.setValue(entity.getManejaCheque());
			txtManejaTarjeta.setValue(entity.getManejaTarjeta());
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperModifica.setValue(entity.getOperModifica());

			Format formatter = new SimpleDateFormat("dd-MM-yyyy");
			String s = formatter.format(entity.getFechaCreacion());
			fechaCreacion = s;
			s = formatter.format(entity.getFechaModificacion());
			fechaModificacion = s;

			btnModify.setDisabled(false);

			RequestContext.getCurrentInstance().update("form:panel");
			RequestContext.getCurrentInstance().update("form:dialog");
			RequestContext.getCurrentInstance().update("form:tfp");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public String action_clear() {
		entity = null;
		selectedTipoFormaPago = null;

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			// txtCodigo.setDisabled(true);
		}

		if (txtDescripcion != null) {
			txtDescripcion.setValue(null);
			// txtDescripcion.setDisabled(true);
		}

		if (txtDsctoFechaDoc != null) {
			txtDsctoFechaDoc.setValue(null);
			// txtDsctoFechaDoc.setDisabled(true);
		}

		if (txtEsPosfechado != null) {
			txtEsPosfechado.setValue(null);
			// txtEsPosfechado.setDisabled(true);
		}

		/*
		 * if (txtEstadoRegistro != null) { txtEstadoRegistro.setValue(null);
		 * txtEstadoRegistro.setDisabled(true); }
		 */

		if (txtExijeNumeroDocumento != null) {
			txtExijeNumeroDocumento.setValue(null);
			// txtExijeNumeroDocumento.setDisabled(true);
		}

		if (txtImportaPda != null) {
			txtImportaPda.setValue(null);
			// txtImportaPda.setDisabled(true);
		}

		if (txtManejaCheque != null) {
			txtManejaCheque.setValue(null);
			// txtManejaCheque.setDisabled(true);
		}

		if (txtManejaTarjeta != null) {
			txtManejaTarjeta.setValue(null);
			// txtManejaTarjeta.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			// txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			// txtOperModifica.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			// txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			// txtFechaModificacion.setDisabled(true);
		}

		if (txtIdTfpa != null) {
			txtIdTfpa.setValue(null);
			// txtIdTfpa.setDisabled(false);
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
			Long idTfpa = new Long(txtIdTfpa.getValue().toString());
			entity = businessDelegatorView.getTipoFormaPago(idTfpa);
		} catch (Exception e) {

		}

		if (entity == null) {
			txtCodigo.setDisabled(false);
			txtDescripcion.setDisabled(false);
			txtDsctoFechaDoc.setDisabled(false);
			txtEsPosfechado.setDisabled(false);
			// txtEstadoRegistro.setDisabled(false);
			txtExijeNumeroDocumento.setDisabled(false);
			txtImportaPda.setDisabled(false);
			txtManejaCheque.setDisabled(false);
			txtManejaTarjeta.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdTfpa.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtDescripcion.setValue(entity.getDescripcion());
			txtDescripcion.setDisabled(false);
			txtDsctoFechaDoc.setValue(entity.getDsctoFechaDoc());
			txtDsctoFechaDoc.setDisabled(false);
			txtEsPosfechado.setValue(entity.getEsPosfechado());
			txtEsPosfechado.setDisabled(false);
			// txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			// txtEstadoRegistro.setDisabled(false);
			txtExijeNumeroDocumento.setValue(entity.getExijeNumeroDocumento());
			txtExijeNumeroDocumento.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtImportaPda.setValue(entity.getImportaPda());
			txtImportaPda.setDisabled(false);
			txtManejaCheque.setValue(entity.getManejaCheque());
			txtManejaCheque.setDisabled(false);
			txtManejaTarjeta.setValue(entity.getManejaTarjeta());
			txtManejaTarjeta.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtIdTfpa.setValue(entity.getIdTfpa());
			txtIdTfpa.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedTipoFormaPago = (TipoFormaPagoDTO) (evt.getComponent()
				.getAttributes().get("selectedTipoFormaPago"));
		txtCodigo.setValue(selectedTipoFormaPago.getCodigo());
		txtCodigo.setDisabled(false);
		txtDescripcion.setValue(selectedTipoFormaPago.getDescripcion());
		txtDescripcion.setDisabled(false);
		txtDsctoFechaDoc.setValue(selectedTipoFormaPago.getDsctoFechaDoc());
		txtDsctoFechaDoc.setDisabled(false);
		txtEsPosfechado.setValue(selectedTipoFormaPago.getEsPosfechado());
		txtEsPosfechado.setDisabled(false);
		// txtEstadoRegistro.setValue(selectedTipoFormaPago.getEstadoRegistro());
		// txtEstadoRegistro.setDisabled(false);
		txtExijeNumeroDocumento.setValue(selectedTipoFormaPago
				.getExijeNumeroDocumento());
		txtExijeNumeroDocumento.setDisabled(false);
		txtFechaCreacion.setValue(selectedTipoFormaPago.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedTipoFormaPago
				.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtImportaPda.setValue(selectedTipoFormaPago.getImportaPda());
		txtImportaPda.setDisabled(false);
		txtManejaCheque.setValue(selectedTipoFormaPago.getManejaCheque());
		txtManejaCheque.setDisabled(false);
		txtManejaTarjeta.setValue(selectedTipoFormaPago.getManejaTarjeta());
		txtManejaTarjeta.setDisabled(false);
		txtOperCreador.setValue(selectedTipoFormaPago.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedTipoFormaPago.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtIdTfpa.setValue(selectedTipoFormaPago.getIdTfpa());
		txtIdTfpa.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedTipoFormaPago == null) && (entity == null)) {
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
			entity = new TipoFormaPago();
			

			HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
					.getExternalContext().getSession(false);
			
			String usuario =(String) session.getAttribute("Usuario");

			//Long idTfpa = new Long(txtIdTfpa.getValue().toString());
			
			
			//entity.setIdTfpa(idTfpa);
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
						
			Long manejaCheque = new Long(manejaCh.getValue().toString());
			entity.setManejaCheque(manejaCheque);
			
			Long manejaTarjeta = new Long(manejaTc.getValue().toString());
			entity.setManejaTarjeta(manejaTarjeta);
			
			Long exijeNumeroDocumento = new Long(exige.getValue().toString());
			entity.setExijeNumeroDocumento(exijeNumeroDocumento);
			
			Long esPosfechado = new Long(es.getValue().toString());
			entity.setEsPosfechado(esPosfechado);
			
			Long importaPda = new Long(importa.getValue().toString());
			entity.setImportaPda(importaPda);
			
			Long dsctoFechaDoc = new Long(descuento.getValue().toString());
			entity.setDsctoFechaDoc(dsctoFechaDoc);
			
			
			entity.setEstadoRegistro(estadoRegistro);
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);
			
			//txtOperCreador.setValue(usuario);
			//txtOperModifica.setValue(usuario);
			//entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			//entity.setOperModifica(FacesUtils.checkString(txtOperModifica));

			businessDelegatorView.saveTipoFormaPago(entity);
			data = businessDelegatorView.getDataTipoFormaPago();
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
			action_clear();
			//actualizar();
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_crear() {
		action_clear();

		txtIdTfpa.setDisabled(false);
		txtCodigo.setDisabled(false);
		txtDescripcion.setDisabled(false);
		estado.setDisabled(false);
		// txtEstadoRegistro.setDisabled(false);
		txtOperCreador.setDisabled(false);
		txtOperModifica.setDisabled(false);

		txtDsctoFechaDoc.setDisabled(false);
		txtEsPosfechado.setDisabled(false);
		txtExijeNumeroDocumento.setDisabled(false);
		txtImportaPda.setDisabled(false);
		txtManejaCheque.setDisabled(false);
		txtManejaTarjeta.setDisabled(false);

		// txtFechaCreacion.setDisabled(true);
		// txtFechaCreacion.setValue(new Date());
		// txtFechaModificacion.setDisabled(true);
		// txtFechaModificacion.setValue(new Date());

		btnCrear.setDisabled(false);
		btnSave.setDisabled(false);
		btnModify.setDisabled(true);

		return "";
	}

	public String action_modificar() {

		txtIdTfpa.setDisabled(true);
		txtCodigo.setDisabled(false);
		txtDescripcion.setDisabled(false);
		estado.setDisabled(false);
		// txtEstadoRegistro.setDisabled(false);
		txtOperCreador.setDisabled(false);
		txtOperModifica.setDisabled(false);

		txtDsctoFechaDoc.setDisabled(false);
		txtEsPosfechado.setDisabled(false);
		txtExijeNumeroDocumento.setDisabled(false);
		txtImportaPda.setDisabled(false);
		txtManejaCheque.setDisabled(false);
		txtManejaTarjeta.setDisabled(false);

		// txtFechaCreacion.setDisabled(true);
		// txtFechaCreacion.setValue(new Date());
		// txtFechaModificacion.setDisabled(true);
		// txtFechaModificacion.setValue(new Date());

		// btnCrear.setDisabled(true);
		btnSave.setDisabled(false);

		return "";
	}

	public String action_modify() {
		try {
			if (!btnCrear.isDisabled() && btnModify.isDisabled()) {
				System.out.println("entrocrear");

				action_create();
				data = businessDelegatorView.getDataTipoFormaPago();
				RequestContext.getCurrentInstance().update(
						"form:tablaPrincipal");
				return "";
			}

			if (entity == null) {
				Long idTfpa = new Long(selectedTipoFormaPago.getIdTfpa());
				entity = businessDelegatorView.getTipoFormaPago(idTfpa);
			}

			System.out.println("entro modif");
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			entity.setDsctoFechaDoc(FacesUtils.checkLong(txtDsctoFechaDoc));
			entity.setEsPosfechado(FacesUtils.checkLong(txtEsPosfechado));
			entity.setEstadoRegistro(estadoRegistro);
			// entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setExijeNumeroDocumento(FacesUtils
					.checkLong(txtExijeNumeroDocumento));

			entity.setFechaModificacion(new Date());
			entity.setImportaPda(FacesUtils.checkLong(txtImportaPda));
			entity.setManejaCheque(FacesUtils.checkLong(txtManejaCheque));
			entity.setManejaTarjeta(FacesUtils.checkLong(txtManejaTarjeta));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			businessDelegatorView.updateTipoFormaPago(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

			btnSave.setDisabled(false);

			data = businessDelegatorView.getDataTipoFormaPago();
			RequestContext.getCurrentInstance().update("form:tablaPrincipal");
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedTipoFormaPago = (TipoFormaPagoDTO) (evt.getComponent()
					.getAttributes().get("selectedTipoFormaPago"));

			Long idTfpa = new Long(selectedTipoFormaPago.getIdTfpa());
			entity = businessDelegatorView.getTipoFormaPago(idTfpa);
			businessDelegatorView.deleteTipoFormaPago(entity);
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
			selectedTipoFormaPago = (TipoFormaPagoDTO) (evt.getComponent()
					.getAttributes().get("selectedTipoFormaPago"));

			Long idTfpa = new Long(selectedTipoFormaPago.getIdTfpa());
			entity = businessDelegatorView.getTipoFormaPago(idTfpa);
			businessDelegatorView.deleteTipoFormaPago(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedTipoFormaPago);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String codigo, String descripcion,
			Long dsctoFechaDoc, Long esPosfechado, String estadoRegistro,
			Long exijeNumeroDocumento, Date fechaCreacion,
			Date fechaModificacion, Long idTfpa, Long importaPda,
			Long manejaCheque, Long manejaTarjeta, String operCreador,
			String operModifica) throws Exception {
		try {
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setDescripcion(FacesUtils.checkString(descripcion));
			entity.setDsctoFechaDoc(FacesUtils.checkLong(dsctoFechaDoc));
			entity.setEsPosfechado(FacesUtils.checkLong(esPosfechado));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setExijeNumeroDocumento(FacesUtils
					.checkLong(exijeNumeroDocumento));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setImportaPda(FacesUtils.checkLong(importaPda));
			entity.setManejaCheque(FacesUtils.checkLong(manejaCheque));
			entity.setManejaTarjeta(FacesUtils.checkLong(manejaTarjeta));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateTipoFormaPago(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("TipoFormaPagoView").requestRender();
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

	public InputTextarea getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(InputTextarea txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public InputText getTxtDsctoFechaDoc() {
		return txtDsctoFechaDoc;
	}

	public void setTxtDsctoFechaDoc(InputText txtDsctoFechaDoc) {
		this.txtDsctoFechaDoc = txtDsctoFechaDoc;
	}

	public InputText getTxtEsPosfechado() {
		return txtEsPosfechado;
	}

	public void setTxtEsPosfechado(InputText txtEsPosfechado) {
		this.txtEsPosfechado = txtEsPosfechado;
	}

	/*
	 * public InputText getTxtEstadoRegistro() { return txtEstadoRegistro; }
	 * 
	 * public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
	 * this.txtEstadoRegistro = txtEstadoRegistro; }
	 */

	public InputText getTxtExijeNumeroDocumento() {
		return txtExijeNumeroDocumento;
	}

	public void setTxtExijeNumeroDocumento(InputText txtExijeNumeroDocumento) {
		this.txtExijeNumeroDocumento = txtExijeNumeroDocumento;
	}

	public InputText getTxtImportaPda() {
		return txtImportaPda;
	}

	public void setTxtImportaPda(InputText txtImportaPda) {
		this.txtImportaPda = txtImportaPda;
	}

	public InputText getTxtManejaCheque() {
		return txtManejaCheque;
	}

	public void setTxtManejaCheque(InputText txtManejaCheque) {
		this.txtManejaCheque = txtManejaCheque;
	}

	public InputText getTxtManejaTarjeta() {
		return txtManejaTarjeta;
	}

	public void setTxtManejaTarjeta(InputText txtManejaTarjeta) {
		this.txtManejaTarjeta = txtManejaTarjeta;
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

	public InputText getTxtIdTfpa() {
		return txtIdTfpa;
	}

	public void setTxtIdTfpa(InputText txtIdTfpa) {
		this.txtIdTfpa = txtIdTfpa;
	}

	public List<TipoFormaPagoDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataTipoFormaPago();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<TipoFormaPagoDTO> tipoFormaPagoDTO) {
		this.data = tipoFormaPagoDTO;
	}

	public TipoFormaPagoDTO getSelectedTipoFormaPago() {
		return selectedTipoFormaPago;
	}

	public void setSelectedTipoFormaPago(TipoFormaPagoDTO tipoFormaPago) {
		this.selectedTipoFormaPago = tipoFormaPago;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
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

	public String getIdTfpa() {
		return idTfpa;
	}

	public void setIdTfpa(String idTfpa) {
		this.idTfpa = idTfpa;
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

	public CommandButton getBtnCrear() {
		return btnCrear;
	}

	public void setBtnCrear(CommandButton btnCrear) {
		this.btnCrear = btnCrear;
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

	public SelectItem[] getManufacturerOptions2() {
		return manufacturerOptions2;
	}

	public void setManufacturerOptions2(SelectItem[] manufacturerOptions2) {
		this.manufacturerOptions2 = manufacturerOptions2;
	}

	public SelectOneMenu getManejaCh() {
		return manejaCh;
	}

	public void setManejaCh(SelectOneMenu manejaCh) {
		this.manejaCh = manejaCh;
	}

	public SelectOneMenu getManejaTc() {
		return manejaTc;
	}

	public void setManejaTc(SelectOneMenu manejaTc) {
		this.manejaTc = manejaTc;
	}

	public SelectOneMenu getExige() {
		return exige;
	}

	public void setExige(SelectOneMenu exige) {
		this.exige = exige;
	}

	public SelectOneMenu getImporta() {
		return importa;
	}

	public void setImporta(SelectOneMenu importa) {
		this.importa = importa;
	}

	public SelectOneMenu getEs() {
		return es;
	}

	public void setEs(SelectOneMenu es) {
		this.es = es;
	}

	public SelectOneMenu getDescuento() {
		return descuento;
	}

	public void setDescuento(SelectOneMenu descuento) {
		this.descuento = descuento;
	}
}
