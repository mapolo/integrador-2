package co.edu.usbcali.presentation.backingBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;

import co.edu.usbcali.modelo.Grupo;
import co.edu.usbcali.modelo.GrupoReferencia;
import co.edu.usbcali.modelo.Referencia;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.dtt.DataTableRefGrupo;

@ManagedBean
@ViewScoped
public class AsignacionView implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<DataTableRefGrupo> tablaGrupoReferencias;
	private List<GrupoReferencia> grupoReferencias;
	private List<Grupo> grupos;
	private DataTable dttGrupoReferncia;
	private String sorActivo;
	private InputText txtReferencia;
	private SelectOneMenu cmbGrupos;

	private String grupo;

	private List<SelectItem> items;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;


	public AsignacionView() {
		super();
		
	}

	@PostConstruct
	public void asignacionView(){
		
		try {
			
			sorActivo = "A";
			
			items             =  new ArrayList<SelectItem>();
			grupos            =  new ArrayList<Grupo>();

			grupos            =  businessDelegatorView.getGrupo();

			
			for (int i = 0; i < grupos.size(); i++) {
				SelectItem item  =  new SelectItem(grupos.get(i).getIdGrpo(), grupos.get(i).getNombre());
				items.add(item);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void activarReferencia(){
		try {

			DataTableRefGrupo dataTableRefGrupo = (DataTableRefGrupo) dttGrupoReferncia.getRowData();
			List<GrupoReferencia> grupoReferenciasEnGrupo = businessDelegatorView.consultarPorGrupo("referencia.idRefe", new Long(dataTableRefGrupo.getIdRefe()));
			
			for (int i = 0; i <grupoReferenciasEnGrupo.size(); i++) {
				if (grupoReferenciasEnGrupo.get(i).getEstadoRegistro().equals("A")) {
					grupoReferenciasEnGrupo.get(i).setEstadoRegistro("R");
					businessDelegatorView.updateGrupoReferencia(grupoReferenciasEnGrupo.get(i));
				}

			}
			
			grupoReferencias  = businessDelegatorView.consultarPorGrupo("grupo.idGrpo", dataTableRefGrupo.getIdGrpo());
			
			for (int i = 0; i < grupoReferencias.size(); i++) {
				grupoReferencias.get(i).setEstadoRegistro("R");
				businessDelegatorView.updateGrupoReferencia(grupoReferencias.get(i));
			}
			
			GrupoReferencia grupoReferencia  =  businessDelegatorView.getGrupoReferencia(dataTableRefGrupo.getIdGrre());
			grupoReferencia.setEstadoRegistro("A");

			businessDelegatorView.updateGrupoReferencia(grupoReferencia);

			consultarReferencia();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void consultarReferencia() {
		try {

			

		} catch (Exception e) {
			// TODO: handle exception
		}	
	}

	public String guardarRef() {
		try {

			Referencia referencia  =  businessDelegatorView.getReferencia(new Long(txtReferencia.getValue().toString()));

			if (referencia == null) {
				return "";
			}

			Grupo grupo = businessDelegatorView.getGrupo(new Long(this.grupo));
			if (grupo == null) {
				return "";
			}

			List<GrupoReferencia> grupoReferencias  =  new ArrayList<GrupoReferencia>();
			grupoReferencias  = businessDelegatorView.consultarPorGrupo("grupo.idGrpo", new Long(this.grupo));	

			for (int i = 0; i < grupoReferencias.size(); i++) {
				if (grupoReferencias.get(i).getReferencia().equals(txtReferencia.getValue().toString())) {
					return "";
				}
			}



			if (sorActivo.equals("A")) {
				for (int i = 0; i < grupoReferencias.size(); i++) {
					grupoReferencias.get(i).setEstadoRegistro("R");
					businessDelegatorView.updateGrupoReferencia(grupoReferencias.get(i));
				}
				List<GrupoReferencia> grupoReferenciasEnGrupo = businessDelegatorView.consultarPorGrupo("referencia.idRefe", new Long(txtReferencia.getValue().toString()));
				for (int i = 0; i <grupoReferenciasEnGrupo.size(); i++) {
					if (grupoReferenciasEnGrupo.get(i).getEstadoRegistro().equals("A")) {
						grupoReferenciasEnGrupo.get(i).setEstadoRegistro("R");
						businessDelegatorView.updateGrupoReferencia(grupoReferenciasEnGrupo.get(i));
					}

				}

			}


			GrupoReferencia grupoReferencia = new GrupoReferencia();
			GrupoReferencia grupoReferenciaEjemplo = businessDelegatorView.getGrupoReferencia(1l);

			grupoReferencia.setActivo(grupoReferenciaEjemplo.getActivo());
			grupoReferencia.setEstadoRegistro(sorActivo);
			grupoReferencia.setFechaCreacion(grupoReferenciaEjemplo.getFechaCreacion());
			grupoReferencia.setFechaInactivo(grupoReferenciaEjemplo.getFechaInactivo());
			grupoReferencia.setFechaModificacion(grupoReferenciaEjemplo.getFechaModificacion());
			grupoReferencia.setGrupo(grupo);
			grupoReferencia.setOperCreador(grupoReferenciaEjemplo.getOperCreador());
			grupoReferencia.setOperModifica(grupoReferenciaEjemplo.getOperModifica());
			grupoReferencia.setReferencia(referencia);

			businessDelegatorView.saveGrupoReferencia(grupoReferencia);

			consultarReferencia();
		} catch (Exception e) {

		}
		return"";
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(
			IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public List<SelectItem> getItems() {
		return items;
	}

	public void setItems(List<SelectItem> items) {
		this.items = items;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public List<DataTableRefGrupo> getTablaGrupoReferencias() {
		try {
			
		
		
		tablaGrupoReferencias  =  new ArrayList<DataTableRefGrupo>();
		
		tablaGrupoReferencias.clear();	
		
		grupoReferencias       =  new ArrayList<GrupoReferencia>();
		grupoReferencias       =  businessDelegatorView.getGrupoReferencia();

		
		for (int i = 0; i < grupoReferencias.size(); i++) {

			DataTableRefGrupo dataGrupoReferencia  =  new DataTableRefGrupo();

			dataGrupoReferencia.setIdGrre(grupoReferencias.get(i).getIdGrre());
			dataGrupoReferencia.setIdRefe(grupoReferencias.get(i).getReferencia().getIdRefe());
			dataGrupoReferencia.setDescripcion(businessDelegatorView.getReferencia(grupoReferencias.get(i).getReferencia().getIdRefe()).getDescripcion());
			dataGrupoReferencia.setMarca(businessDelegatorView.getReferencia(grupoReferencias.get(i).getReferencia().getIdRefe()).getMarca());
			dataGrupoReferencia.setNombre(businessDelegatorView.getGrupo(grupoReferencias.get(i).getGrupo().getIdGrpo()).getNombre());
			dataGrupoReferencia.setIdGrpo(grupoReferencias.get(i).getGrupo().getIdGrpo());
			dataGrupoReferencia.setEstadoRegistro(grupoReferencias.get(i).getEstadoRegistro());

			tablaGrupoReferencias.add(dataGrupoReferencia);

		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tablaGrupoReferencias;
	}

	public void setTablaGrupoReferencias(
			List<DataTableRefGrupo> tablaGrupoReferencias) {
		this.tablaGrupoReferencias = tablaGrupoReferencias;
	}

	public List<GrupoReferencia> getGrupoReferencias() {
		return grupoReferencias;
	}

	public void setGrupoReferencias(List<GrupoReferencia> grupoReferencias) {
		this.grupoReferencias = grupoReferencias;
	}

	public String getSorActivo() {
		return sorActivo;
	}

	public void setSorActivo(String sorActivo) {
		this.sorActivo = sorActivo;
	}

	public InputText getTxtReferencia() {
		return txtReferencia;
	}

	public void setTxtReferencia(InputText txtReferencia) {
		this.txtReferencia = txtReferencia;
	}

	public DataTable getDttGrupoReferncia() {		
		return dttGrupoReferncia;
	}

	public void setDttGrupoReferncia(DataTable dttGrupoReferncia) {
		this.dttGrupoReferncia = dttGrupoReferncia;
	}

	public SelectOneMenu getCmbGrupos() {
		return cmbGrupos;
	}

	public void setCmbGrupos(SelectOneMenu cmbGrupos) {
		this.cmbGrupos = cmbGrupos;
	}

	
}
