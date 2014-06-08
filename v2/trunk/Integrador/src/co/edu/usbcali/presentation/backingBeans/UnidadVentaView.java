package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.UnidadVentaDTO;
import co.edu.usbcali.presentation.businessDelegate.*;
import co.edu.usbcali.utilities.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.dtt.DataTableUnidadVenta;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class UnidadVentaView {
    private InputText txtActivo;
    private InputText txtEstadoRegistro;
    private InputText txtOperCreador;
    private InputText txtOperModifica;
    private InputText txtIdUnne_UnidadNegocio;
    private InputText txtIdVend_Vendedor;
    private InputText txtIdUnve;
    private Calendar txtFechaCreacion;
    private Calendar txtFechaInactivo;
    private Calendar txtFechaModificacion;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<DataTableUnidadVenta> dataTableUnidadVentas;
    private DataTableUnidadVenta rowDataTableUnidadVenta;
    private List<Persona> personas;
    private Persona rowPersona;
    private List<UnidadNegocio> unidadNegocios;
    private UnidadNegocio rowUnidadNegocio;
    private List<UnidadVentaDTO> data;
    private UnidadVentaDTO selectedUnidadVenta;
    private UnidadVenta entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{BusinessDelegatorView}")
    private IBusinessDelegatorView businessDelegatorView;

    public UnidadVentaView() {
        super();
    }

    @PostConstruct
    public void UnidadVentaViewPost(){
    	
    	try {
			
    		personas = businessDelegatorView.consultarPersonVendedor();
    		unidadNegocios = businessDelegatorView.getUnidadNegocio();
    		
    		llenarTablaUnidadVenta();
    		
    		
    		
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
    
    public void activarUnidadVenta(){
    	try {
			
    		List<UnidadVenta> unidadVentasVendedor  = businessDelegatorView.consultarUnidadVentaPorIdVen("vendedor.idVend", rowDataTableUnidadVenta.getIdVend());
        	
        	for (int i = 0; i < unidadVentasVendedor.size(); i++) {
        		UnidadVenta unidadVenta = unidadVentasVendedor.get(i);
        		unidadVenta.setActivo("N");
    			businessDelegatorView.updateUnidadVenta(unidadVenta);
    		}
        	
        	UnidadVenta unidadVenta  =  businessDelegatorView.getUnidadVenta(rowDataTableUnidadVenta.getIdUnve());
        	
        	unidadVenta.setActivo("S");
        	
        	businessDelegatorView.updateUnidadVenta(unidadVenta);
        	
        	llenarTablaUnidadVenta();
    		
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	
    }
    
    public void rowEventListener(RowEditEvent e) {
        try {
            UnidadVentaDTO unidadVentaDTO = (UnidadVentaDTO) e.getObject();

            if (txtActivo == null) {
                txtActivo = new InputText();
            }

            txtActivo.setValue(unidadVentaDTO.getActivo());

            if (txtEstadoRegistro == null) {
                txtEstadoRegistro = new InputText();
            }

            txtEstadoRegistro.setValue(unidadVentaDTO.getEstadoRegistro());

            if (txtOperCreador == null) {
                txtOperCreador = new InputText();
            }

            txtOperCreador.setValue(unidadVentaDTO.getOperCreador());

            if (txtOperModifica == null) {
                txtOperModifica = new InputText();
            }

            txtOperModifica.setValue(unidadVentaDTO.getOperModifica());

            if (txtIdUnne_UnidadNegocio == null) {
                txtIdUnne_UnidadNegocio = new InputText();
            }

            txtIdUnne_UnidadNegocio.setValue(unidadVentaDTO.getIdUnne_UnidadNegocio());

            if (txtIdVend_Vendedor == null) {
                txtIdVend_Vendedor = new InputText();
            }

            txtIdVend_Vendedor.setValue(unidadVentaDTO.getIdVend_Vendedor());

            if (txtIdUnve == null) {
                txtIdUnve = new InputText();
            }

            txtIdUnve.setValue(unidadVentaDTO.getIdUnve());

            if (txtFechaCreacion == null) {
                txtFechaCreacion = new Calendar();
            }

            txtFechaCreacion.setValue(unidadVentaDTO.getFechaCreacion());

            if (txtFechaInactivo == null) {
                txtFechaInactivo = new Calendar();
            }

            txtFechaInactivo.setValue(unidadVentaDTO.getFechaInactivo());

            if (txtFechaModificacion == null) {
                txtFechaModificacion = new Calendar();
            }

            txtFechaModificacion.setValue(unidadVentaDTO.getFechaModificacion());

            action_modify();
        } catch (Exception ex) {
        }
    }

    public void llenarTablaUnidadVenta(){
    	
    	try {
			
    		List<UnidadVenta> unidadVentas = businessDelegatorView.getUnidadVenta();
    		dataTableUnidadVentas = new ArrayList<DataTableUnidadVenta>();
    		
    		for (int i = 0; i < unidadVentas.size(); i++) {
				
    			Persona persona = businessDelegatorView.getPersona(businessDelegatorView.getVendedor(unidadVentas.get(i).getVendedor().getIdVend()).getPersona().getIdPers());
    			UnidadNegocio negocio = businessDelegatorView.getUnidadNegocio(unidadVentas.get(i).getUnidadNegocio().getIdUnne());
    			
    			DataTableUnidadVenta dataTableUnidadVenta = new DataTableUnidadVenta();
    			
    			dataTableUnidadVenta.setActivo(unidadVentas.get(i).getActivo());
    			dataTableUnidadVenta.setDescripcion(negocio.getDescripcion());
    			dataTableUnidadVenta.setIdentificacion(persona.getIdentificacion());
    			dataTableUnidadVenta.setIdVend(unidadVentas.get(i).getVendedor().getIdVend());
    			dataTableUnidadVenta.setIdPers(persona.getIdPers());
    			dataTableUnidadVenta.setIdUnne(negocio.getIdUnne());
    			dataTableUnidadVenta.setIdUnve(unidadVentas.get(i).getIdUnve());
    			dataTableUnidadVenta.setPrimerNombre(persona.getPrimerNombre());
    			dataTableUnidadVenta.setTelefono1(persona.getTelefono1());
    			
    			dataTableUnidadVentas.add(dataTableUnidadVenta);
			}
    		
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
    
    public String action_new() {
        action_clear();
        selectedUnidadVenta = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedUnidadVenta = null;

        if (txtActivo != null) {
            txtActivo.setValue(null);
            txtActivo.setDisabled(true);
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

        if (txtIdUnne_UnidadNegocio != null) {
            txtIdUnne_UnidadNegocio.setValue(null);
            txtIdUnne_UnidadNegocio.setDisabled(true);
        }

        if (txtIdVend_Vendedor != null) {
            txtIdVend_Vendedor.setValue(null);
            txtIdVend_Vendedor.setDisabled(true);
        }

        if (txtFechaCreacion != null) {
            txtFechaCreacion.setValue(null);
            txtFechaCreacion.setDisabled(true);
        }

        if (txtFechaInactivo != null) {
            txtFechaInactivo.setValue(null);
            txtFechaInactivo.setDisabled(true);
        }

        if (txtFechaModificacion != null) {
            txtFechaModificacion.setValue(null);
            txtFechaModificacion.setDisabled(true);
        }

        if (txtIdUnve != null) {
            txtIdUnve.setValue(null);
            txtIdUnve.setDisabled(false);
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

    public void listener_txtFechaInactivo() {
        Date inputDate = (Date) txtFechaInactivo.getValue();
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

    public void listener_txtId() {
        try {
            Long idUnve = new Long(txtIdUnve.getValue().toString());
            entity = businessDelegatorView.getUnidadVenta(idUnve);
        } catch (Exception e) {
            // TODO: handle exception
        }

        if (entity == null) {
            txtActivo.setDisabled(false);
            txtEstadoRegistro.setDisabled(false);
            txtOperCreador.setDisabled(false);
            txtOperModifica.setDisabled(false);
            txtIdUnne_UnidadNegocio.setDisabled(false);
            txtIdVend_Vendedor.setDisabled(false);
            txtFechaCreacion.setDisabled(false);
            txtFechaInactivo.setDisabled(false);
            txtFechaModificacion.setDisabled(false);
            txtIdUnve.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtActivo.setValue(entity.getActivo());
            txtActivo.setDisabled(false);
            txtEstadoRegistro.setValue(entity.getEstadoRegistro());
            txtEstadoRegistro.setDisabled(false);
            txtFechaCreacion.setValue(entity.getFechaCreacion());
            txtFechaCreacion.setDisabled(false);
            txtFechaInactivo.setValue(entity.getFechaInactivo());
            txtFechaInactivo.setDisabled(false);
            txtFechaModificacion.setValue(entity.getFechaModificacion());
            txtFechaModificacion.setDisabled(false);
            txtOperCreador.setValue(entity.getOperCreador());
            txtOperCreador.setDisabled(false);
            txtOperModifica.setValue(entity.getOperModifica());
            txtOperModifica.setDisabled(false);
            txtIdUnne_UnidadNegocio.setValue(entity.getUnidadNegocio()
                                                   .getIdUnne());
            txtIdUnne_UnidadNegocio.setDisabled(false);
            txtIdVend_Vendedor.setValue(entity.getVendedor().getIdVend());
            txtIdVend_Vendedor.setDisabled(false);
            txtIdUnve.setValue(entity.getIdUnve());
            txtIdUnve.setDisabled(true);
            btnSave.setDisabled(false);
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedUnidadVenta = (UnidadVentaDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedUnidadVenta"));
        txtActivo.setValue(selectedUnidadVenta.getActivo());
        txtActivo.setDisabled(false);
        txtEstadoRegistro.setValue(selectedUnidadVenta.getEstadoRegistro());
        txtEstadoRegistro.setDisabled(false);
        txtFechaCreacion.setValue(selectedUnidadVenta.getFechaCreacion());
        txtFechaCreacion.setDisabled(false);
        txtFechaInactivo.setValue(selectedUnidadVenta.getFechaInactivo());
        txtFechaInactivo.setDisabled(false);
        txtFechaModificacion.setValue(selectedUnidadVenta.getFechaModificacion());
        txtFechaModificacion.setDisabled(false);
        txtOperCreador.setValue(selectedUnidadVenta.getOperCreador());
        txtOperCreador.setDisabled(false);
        txtOperModifica.setValue(selectedUnidadVenta.getOperModifica());
        txtOperModifica.setDisabled(false);
        txtIdUnne_UnidadNegocio.setValue(selectedUnidadVenta.getIdUnne_UnidadNegocio());
        txtIdUnne_UnidadNegocio.setDisabled(false);
        txtIdVend_Vendedor.setValue(selectedUnidadVenta.getIdVend_Vendedor());
        txtIdVend_Vendedor.setDisabled(false);
        txtIdUnve.setValue(selectedUnidadVenta.getIdUnve());
        txtIdUnve.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedUnidadVenta == null) && (entity == null)) {
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
            entity = new UnidadVenta();

            Long idUnve = new Long(txtIdUnve.getValue().toString());

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaInactivo(FacesUtils.checkDate(txtFechaInactivo));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setIdUnve(idUnve);
            entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
            entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
            entity.setUnidadNegocio(businessDelegatorView.getUnidadNegocio(
                    FacesUtils.checkLong(txtIdUnne_UnidadNegocio)));
            entity.setVendedor(businessDelegatorView.getVendedor(
                    FacesUtils.checkLong(txtIdVend_Vendedor)));
            businessDelegatorView.saveUnidadVenta(entity);
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
                Long idUnve = new Long(selectedUnidadVenta.getIdUnve());
                entity = businessDelegatorView.getUnidadVenta(idUnve);
            }

            entity.setActivo(FacesUtils.checkString(txtActivo));
            entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
            entity.setFechaInactivo(FacesUtils.checkDate(txtFechaInactivo));
            entity.setFechaModificacion(FacesUtils.checkDate(
                    txtFechaModificacion));
            entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
            entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
            entity.setUnidadNegocio(businessDelegatorView.getUnidadNegocio(
                    FacesUtils.checkLong(txtIdUnne_UnidadNegocio)));
            entity.setVendedor(businessDelegatorView.getVendedor(
                    FacesUtils.checkLong(txtIdVend_Vendedor)));
            businessDelegatorView.updateUnidadVenta(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete(ActionEvent evt) {
        try {
            selectedUnidadVenta = (UnidadVentaDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedUnidadVenta"));

            Long idUnve = new Long(selectedUnidadVenta.getIdUnve());
            entity = businessDelegatorView.getUnidadVenta(idUnve);
            businessDelegatorView.deleteUnidadVenta(entity);
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
            selectedUnidadVenta = (UnidadVentaDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedUnidadVenta"));

            Long idUnve = new Long(selectedUnidadVenta.getIdUnve());
            entity = businessDelegatorView.getUnidadVenta(idUnve);
            businessDelegatorView.deleteUnidadVenta(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data.remove(selectedUnidadVenta);
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void guardarUnidadVentas() {
		
    	try {
			
    		UnidadVenta unidadVenta  = new UnidadVenta();
        	
        	Vendedor vendedor = businessDelegatorView.consultarVendedorPorIdPers("persona.idPers", rowPersona.getIdPers());
        	
        	List<UnidadVenta> unidadVentasVendedor  = businessDelegatorView.consultarUnidadVentaPorIdVen("vendedor.idVend", vendedor.getIdVend());
        	
        	for (int i = 0; i < unidadVentasVendedor.size(); i++) {
				unidadVentasVendedor.get(i).setActivo("N");
				businessDelegatorView.updateUnidadVenta(unidadVentasVendedor.get(i));
			}
        	
        	UnidadNegocio negocio = businessDelegatorView.getUnidadNegocio(rowUnidadNegocio.getIdUnne());
        	
        	unidadVenta.setActivo("S");
        	unidadVenta.setVendedor(vendedor);
        	unidadVenta.setUnidadNegocio(negocio);
        	unidadVenta.setFechaCreacion(new Date());
        	unidadVenta.setFechaInactivo(new Date());
        	unidadVenta.setFechaModificacion(new Date());
        	unidadVenta.setOperCreador("jsvargas");
        	unidadVenta.setOperModifica("jsvargas");
        	unidadVenta.setEstadoRegistro("A");
        	
        	businessDelegatorView.saveUnidadVenta(unidadVenta);
        	
        	llenarTablaUnidadVenta();
    		
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	
	}
    
    public String action_modifyWitDTO(String activo, String estadoRegistro,
        Date fechaCreacion, Date fechaInactivo, Date fechaModificacion,
        Long idUnve, String operCreador, String operModifica,
        Long idUnne_UnidadNegocio, Long idVend_Vendedor)
        throws Exception {
        try {
            entity.setActivo(FacesUtils.checkString(activo));
            entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
            entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
            entity.setFechaInactivo(FacesUtils.checkDate(fechaInactivo));
            entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
            entity.setOperCreador(FacesUtils.checkString(operCreador));
            entity.setOperModifica(FacesUtils.checkString(operModifica));
            businessDelegatorView.updateUnidadVenta(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("UnidadVentaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtActivo() {
        return txtActivo;
    }

    public void setTxtActivo(InputText txtActivo) {
        this.txtActivo = txtActivo;
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

    public InputText getTxtIdUnne_UnidadNegocio() {
        return txtIdUnne_UnidadNegocio;
    }

    public void setTxtIdUnne_UnidadNegocio(InputText txtIdUnne_UnidadNegocio) {
        this.txtIdUnne_UnidadNegocio = txtIdUnne_UnidadNegocio;
    }

    public InputText getTxtIdVend_Vendedor() {
        return txtIdVend_Vendedor;
    }

    public void setTxtIdVend_Vendedor(InputText txtIdVend_Vendedor) {
        this.txtIdVend_Vendedor = txtIdVend_Vendedor;
    }

    public Calendar getTxtFechaCreacion() {
        return txtFechaCreacion;
    }

    public void setTxtFechaCreacion(Calendar txtFechaCreacion) {
        this.txtFechaCreacion = txtFechaCreacion;
    }

    public Calendar getTxtFechaInactivo() {
        return txtFechaInactivo;
    }

    public void setTxtFechaInactivo(Calendar txtFechaInactivo) {
        this.txtFechaInactivo = txtFechaInactivo;
    }

    public Calendar getTxtFechaModificacion() {
        return txtFechaModificacion;
    }

    public void setTxtFechaModificacion(Calendar txtFechaModificacion) {
        this.txtFechaModificacion = txtFechaModificacion;
    }

    public InputText getTxtIdUnve() {
        return txtIdUnve;
    }

    public void setTxtIdUnve(InputText txtIdUnve) {
        this.txtIdUnve = txtIdUnve;
    }

    public List<UnidadVentaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataUnidadVenta();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<UnidadVentaDTO> unidadVentaDTO) {
        this.data = unidadVentaDTO;
    }

    public UnidadVentaDTO getSelectedUnidadVenta() {
        return selectedUnidadVenta;
    }

    public void setSelectedUnidadVenta(UnidadVentaDTO unidadVenta) {
        this.selectedUnidadVenta = unidadVenta;
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

	public List<DataTableUnidadVenta> getDataTableUnidadVentas() {
		return dataTableUnidadVentas;
	}

	public void setDataTableUnidadVentas(
			List<DataTableUnidadVenta> dataTableUnidadVentas) {
		this.dataTableUnidadVentas = dataTableUnidadVentas;
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public List<UnidadNegocio> getUnidadNegocios() {
		return unidadNegocios;
	}

	public void setUnidadNegocios(List<UnidadNegocio> unidadNegocios) {
		this.unidadNegocios = unidadNegocios;
	}

	public Persona getRowPersona() {
		return rowPersona;
	}

	public void setRowPersona(Persona rowPersona) {
		this.rowPersona = rowPersona;
	}

	public UnidadNegocio getRowUnidadNegocio() {
		return rowUnidadNegocio;
	}

	public void setRowUnidadNegocio(UnidadNegocio rowUnidadNegocio) {
		this.rowUnidadNegocio = rowUnidadNegocio;
	}

	public DataTableUnidadVenta getRowDataTableUnidadVenta() {
		return rowDataTableUnidadVenta;
	}

	public void setRowDataTableUnidadVenta(
			DataTableUnidadVenta rowDataTableUnidadVenta) {
		this.rowDataTableUnidadVenta = rowDataTableUnidadVenta;
	}
	
	
}
