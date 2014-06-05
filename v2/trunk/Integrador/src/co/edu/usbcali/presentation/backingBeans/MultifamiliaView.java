package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.MultifamiliaDTO;
import co.edu.usbcali.presentation.businessDelegate.*;
import co.edu.usbcali.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.dtt.DataTableCliente;
import co.edu.usbcali.dtt.DataTableMultifamiliar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
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
public class MultifamiliaView {
	private InputText txtEstadoRegistro;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtIdClie_Cliente;
	private InputText txtIdSucu_Sucursal;
	private InputText txtIdMufa;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private DataTable dttClientes;
	private DataTable dttClientes2;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private static DataTableCliente codigoReferenciaPadre;
	private List<MultifamiliaDTO> data;
	private List<DataTableCliente> clientes;
	private List<Multifamilia> multifamilias;
	private List<DataTableCliente> clientes2;
	private List<DataTableMultifamiliar> dataTableMultifamiliars;
	private MultifamiliaDTO selectedMultifamilia;
	private Multifamilia entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public MultifamiliaView() {
		super();
	}
	@PostConstruct
	public void construMultif(){
		llenarCleintes2();
		llenarClientes();
		multiFamiliar();
	}
	
	public void  adiccionarCodigoReferenciaHijo() {
		codigoReferenciaPadre  =  (DataTableCliente) dttClientes.getRowData();
	}
	
	public void rowEventListener(RowEditEvent e) {
		try {
			MultifamiliaDTO multifamiliaDTO = (MultifamiliaDTO) e.getObject();

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(multifamiliaDTO.getEstadoRegistro());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(multifamiliaDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(multifamiliaDTO.getOperModifica());

			if (txtIdClie_Cliente == null) {
				txtIdClie_Cliente = new InputText();
			}

			//            txtIdClie_Cliente.setValue(multifamiliaDTO.getIdClie_Cliente());

			if (txtIdSucu_Sucursal == null) {
				txtIdSucu_Sucursal = new InputText();
			}

			txtIdSucu_Sucursal.setValue(multifamiliaDTO.getIdSucu_Sucursal());

			if (txtIdMufa == null) {
				txtIdMufa = new InputText();
			}

			txtIdMufa.setValue(multifamiliaDTO.getIdMufa());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(multifamiliaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
			}

			txtFechaModificacion.setValue(multifamiliaDTO.getFechaModificacion());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedMultifamilia = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedMultifamilia = null;

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

		if (txtIdClie_Cliente != null) {
			txtIdClie_Cliente.setValue(null);
			txtIdClie_Cliente.setDisabled(true);
		}

		if (txtIdSucu_Sucursal != null) {
			txtIdSucu_Sucursal.setValue(null);
			txtIdSucu_Sucursal.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtIdMufa != null) {
			txtIdMufa.setValue(null);
			txtIdMufa.setDisabled(false);
		}

		if (btnSave != null) {
			btnSave.setDisabled(true);
		}

		return "";
	}

	public void listener_txtFechaCreacion() {
		Date inputDate = (Date) txtFechaCreacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance()
		.addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void listener_txtFechaModificacion() {
		Date inputDate = (Date) txtFechaModificacion.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance()
		.addMessage("",
				new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
	}

	public void crearMultifamilia(){

		try {

			DataTableCliente clienePadre   =  codigoReferenciaPadre;
			DataTableCliente clieneHijo    =  (DataTableCliente) dttClientes2.getRowData();

			Cliente padre  =  businessDelegatorView.getCliente(clienePadre.getIdClie());
			Cliente hijo   =  businessDelegatorView.getCliente(clieneHijo.getIdClie());

			List<Multifamilia> listmMultifamilias  = businessDelegatorView.getMultifamilia();

			Multifamilia multifamiliaEjemplo  =  businessDelegatorView.getMultifamilia(listmMultifamilias.get(0).getIdMufa());

			Multifamilia multifamilia  =  new Multifamilia();

			multifamilia.setClienteByClienteHijo(hijo);
			multifamilia.setClienteByClientePadre(padre);
			multifamilia.setFechaCreacion(multifamiliaEjemplo.getFechaCreacion());
			multifamilia.setFechaModificacion(multifamiliaEjemplo.getFechaModificacion());
			multifamilia.setEstadoRegistro("A");
			multifamilia.setOperCreador(multifamiliaEjemplo.getOperCreador());
			multifamilia.setOperModifica(multifamiliaEjemplo.getOperModifica());
			multifamilia.setSucursal(multifamilia.getSucursal());

			businessDelegatorView.saveMultifamilia(multifamilia);

			multiFamiliar();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void listener_txtId() {
		try {
			Long idMufa = new Long(txtIdMufa.getValue().toString());
			entity = businessDelegatorView.getMultifamilia(idMufa);
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (entity == null) {
			txtEstadoRegistro.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtIdClie_Cliente.setDisabled(false);
			txtIdSucu_Sucursal.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtIdMufa.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
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
			//            txtIdClie_Cliente.setValue(entity.getCliente().getIdClie());
			txtIdClie_Cliente.setDisabled(false);
			txtIdSucu_Sucursal.setValue(entity.getSucursal().getIdSucu());
			txtIdSucu_Sucursal.setDisabled(false);
			txtIdMufa.setValue(entity.getIdMufa());
			txtIdMufa.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedMultifamilia = (MultifamiliaDTO) (evt.getComponent()
				.getAttributes()
				.get("selectedMultifamilia"));
		txtEstadoRegistro.setValue(selectedMultifamilia.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedMultifamilia.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion.setValue(selectedMultifamilia.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtOperCreador.setValue(selectedMultifamilia.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedMultifamilia.getOperModifica());
		txtOperModifica.setDisabled(false);
		//        txtIdClie_Cliente.setValue(selectedMultifamilia.getIdClie_Cliente());
		txtIdClie_Cliente.setDisabled(false);
		txtIdSucu_Sucursal.setValue(selectedMultifamilia.getIdSucu_Sucursal());
		txtIdSucu_Sucursal.setDisabled(false);
		txtIdMufa.setValue(selectedMultifamilia.getIdMufa());
		txtIdMufa.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedMultifamilia == null) && (entity == null)) {
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
			entity = new Multifamilia();

			Long idMufa = new Long(txtIdMufa.getValue().toString());

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(
					txtFechaModificacion));
			entity.setIdMufa(idMufa);
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			//            entity.setClienteByClienteHijo(businessDelegatorView.getClienteByClienteHijo(
			//                    FacesUtils.checkLong(txtIdClie_Cliente)));
			//            entity.setClienteByClientePadre(businessDelegatorView.getClienteByClientePadre(
			//                    FacesUtils.checkLong(txtIdClie_Cliente)));
			entity.setSucursal(businessDelegatorView.getSucursal(
					FacesUtils.checkLong(txtIdSucu_Sucursal)));
			businessDelegatorView.saveMultifamilia(entity);
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
				Long idMufa = new Long(selectedMultifamilia.getIdMufa());
				entity = businessDelegatorView.getMultifamilia(idMufa);
			}

			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(
					txtFechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			//            entity.setClienteByClienteHijo(businessDelegatorView.getClienteByClienteHijo(
			//                    FacesUtils.checkLong(txtIdClie_Cliente)));
			//            entity.setClienteByClientePadre(businessDelegatorView.getClienteByClientePadre(
			//                    FacesUtils.checkLong(txtIdClie_Cliente)));
			entity.setSucursal(businessDelegatorView.getSucursal(
					FacesUtils.checkLong(txtIdSucu_Sucursal)));
			businessDelegatorView.updateMultifamilia(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedMultifamilia = (MultifamiliaDTO) (evt.getComponent()
					.getAttributes()
					.get("selectedMultifamilia"));

			Long idMufa = new Long(selectedMultifamilia.getIdMufa());
			entity = businessDelegatorView.getMultifamilia(idMufa);
			businessDelegatorView.deleteMultifamilia(entity);
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
			selectedMultifamilia = (MultifamiliaDTO) (evt.getComponent()
					.getAttributes()
					.get("selectedMultifamilia"));

			Long idMufa = new Long(selectedMultifamilia.getIdMufa());
			entity = businessDelegatorView.getMultifamilia(idMufa);
			businessDelegatorView.deleteMultifamilia(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedMultifamilia);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion, Long idMufa,
			String operCreador, String operModifica, Long idClie_Cliente,
			Long idClie_Cliente0, Long idSucu_Sucursal) throws Exception {
		try {
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			businessDelegatorView.updateMultifamilia(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			//renderManager.getOnDemandRenderer("MultifamiliaView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public void llenarClientes(){
		try {
			List<Cliente> clientesList  =  businessDelegatorView.getCliente(); 
			clientes  =  new ArrayList<DataTableCliente>();

			if (clientesList != null) {
				for (int i = 0; i < clientesList.size(); i++) {
					DataTableCliente dataTableCliente  = new DataTableCliente();

					if (clientesList.get(i).getEmpresa() != null) {
						dataTableCliente.setIdClie(clientesList.get(i).getIdClie());
						Empresa empresa  =  businessDelegatorView.getEmpresa(clientesList.get(i).getEmpresa().getIdEmpr());
						dataTableCliente.setIdentificacionEmpresa(empresa.getIdentificacion());
						dataTableCliente.setNombre(empresa.getNombre());

					}

					if (clientesList.get(i).getPersona() != null) {
						Persona persona  =  businessDelegatorView.getPersona(clientesList.get(i).getPersona().getIdPers());

						dataTableCliente.setIdClie(clientesList.get(i).getIdClie());

						dataTableCliente.setIdentificacion(persona.getIdentificacion());
						dataTableCliente.setPrimerApellido(persona.getPrimerApellido());
						dataTableCliente.setPrimerNombre(persona.getPrimerNombre());
						dataTableCliente.setSegundoApellido(persona.getSegundoApellido());
						dataTableCliente.setSegundoNombre(persona.getSegundoNombre());
					}
					clientes.add(dataTableCliente);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void llenarCleintes2() {
		try {
			List<Cliente> clientesList  =  businessDelegatorView.getCliente(); 
			clientes2  =  new ArrayList<DataTableCliente>();

			if (clientesList != null) {
				for (int i = 0; i < clientesList.size(); i++) {
					DataTableCliente dataTableCliente  = new DataTableCliente();

					if (clientesList.get(i).getEmpresa() != null) {
						dataTableCliente.setIdClie(clientesList.get(i).getIdClie());
						Empresa empresa  =  businessDelegatorView.getEmpresa(clientesList.get(i).getEmpresa().getIdEmpr());
						dataTableCliente.setIdentificacionEmpresa(empresa.getIdentificacion());
						dataTableCliente.setNombre(empresa.getNombre());

					}

					if (clientesList.get(i).getPersona() != null) {
						Persona persona  =  businessDelegatorView.getPersona(clientesList.get(i).getPersona().getIdPers());

						dataTableCliente.setIdClie(clientesList.get(i).getIdClie());

						dataTableCliente.setIdentificacion(persona.getIdentificacion());
						dataTableCliente.setPrimerApellido(persona.getPrimerApellido());
						dataTableCliente.setPrimerNombre(persona.getPrimerNombre());
						dataTableCliente.setSegundoApellido(persona.getSegundoApellido());
						dataTableCliente.setSegundoNombre(persona.getSegundoNombre());
					}
					clientes2.add(dataTableCliente);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void multiFamiliar(){
		try {
			multifamilias = businessDelegatorView.getMultifamilia();
			dataTableMultifamiliars  =  new ArrayList<DataTableMultifamiliar>();
			for (int i = 0; i < multifamilias.size(); i++) {
				DataTableMultifamiliar dataTableMultifamiliar  =  new DataTableMultifamiliar();

				dataTableMultifamiliar.setIdMufa(multifamilias.get(i).getIdMufa());

				Cliente hijo  =  businessDelegatorView.getCliente(multifamilias.get(i).getClienteByClienteHijo().getIdClie());
				Cliente padre  =  businessDelegatorView.getCliente(multifamilias.get(i).getClienteByClientePadre().getIdClie());

				Persona personaHijo = null;

				Persona personapadre  = null;

				Empresa empresaHijo = null;

				Empresa empresaPadre = null;

				if (hijo.getPersona() != null) {
					personaHijo  = businessDelegatorView.getPersona(hijo.getPersona().getIdPers());
				}

				if (padre.getPersona() != null) {
					personapadre  = businessDelegatorView.getPersona(padre.getPersona().getIdPers());
				}

				if (hijo.getEmpresa() != null) {
					empresaHijo  =  businessDelegatorView.getEmpresa(hijo.getEmpresa().getIdEmpr());
				}

				if (padre.getEmpresa() != null) {
					empresaPadre  =  businessDelegatorView.getEmpresa(padre.getEmpresa().getIdEmpr());
				}



				if (personaHijo !=  null) {

					dataTableMultifamiliar.setIdentificacionHijo(personaHijo.getIdentificacion());
					dataTableMultifamiliar.setPrimerNombre(personaHijo.getPrimerNombre());
				}

				if (empresaHijo != null) {

					dataTableMultifamiliar.setIdentificacionHijo(empresaHijo.getIdentificacion());
					dataTableMultifamiliar.setPrimerNombre(empresaHijo.getNombre());
				}

				if (personapadre != null) {

					dataTableMultifamiliar.setIdentificacionPadre(personapadre.getIdentificacion());
					dataTableMultifamiliar.setNombreEmpresa(personapadre.getPrimerNombre());
				}

				if (empresaPadre != null) {

					dataTableMultifamiliar.setIdentificacionPadre(empresaPadre.getIdentificacion());
					dataTableMultifamiliar.setNombreEmpresa(empresaPadre.getNombre());
				}

				dataTableMultifamiliars.add(dataTableMultifamiliar);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
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

	public InputText getTxtIdClie_Cliente() {
		return txtIdClie_Cliente;
	}

	public void setTxtIdClie_Cliente(InputText txtIdClie_Cliente) {
		this.txtIdClie_Cliente = txtIdClie_Cliente;
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

	public Calendar getTxtFechaModificacion() {
		return txtFechaModificacion;
	}

	public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
		this.txtFechaModificacion = txtFechaModificacion;
	}

	public InputText getTxtIdMufa() {
		return txtIdMufa;
	}

	public void setTxtIdMufa(InputText txtIdMufa) {
		this.txtIdMufa = txtIdMufa;
	}

	public List<MultifamiliaDTO> getData() {
		try {

			if (data == null) {
				data = businessDelegatorView.getDataMultifamilia();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<MultifamiliaDTO> multifamiliaDTO) {
		this.data = multifamiliaDTO;
	}

	public MultifamiliaDTO getSelectedMultifamilia() {
		return selectedMultifamilia;
	}

	public void setSelectedMultifamilia(MultifamiliaDTO multifamilia) {
		this.selectedMultifamilia = multifamilia;
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

	public List<DataTableCliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<DataTableCliente> clientes) {
		this.clientes = clientes;
	}

	public DataTable getDttClientes() {
		return dttClientes;
	}

	public void setDttClientes(DataTable dttClientes) {
		this.dttClientes = dttClientes;
	}

	public DataTable getDttClientes2() {
		return dttClientes2;
	}

	public void setDttClientes2(DataTable dttClientes2) {
		this.dttClientes2 = dttClientes2;
	}

	public List<Multifamilia> getMultifamilias() {

		return multifamilias;
	}

	public void setMultifamilias(List<Multifamilia> multifamilias) {
		this.multifamilias = multifamilias;
	}

	public List<DataTableMultifamiliar> getDataTableMultifamiliars() {
		return dataTableMultifamiliars;
	}

	public void setDataTableMultifamiliars(
			List<DataTableMultifamiliar> dataTableMultifamiliars) {
		this.dataTableMultifamiliars = dataTableMultifamiliars;
	}

	public List<DataTableCliente> getClientes2() {
		return clientes2;
	}

	public void setClientes2(List<DataTableCliente> clientes2) {
		this.clientes2 = clientes2;
	}


}
