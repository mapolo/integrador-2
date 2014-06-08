package co.edu.usbcali.presentation.backingBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;

import co.edu.usbcali.modelo.Grupo;
import co.edu.usbcali.modelo.GrupoReferencia;
import co.edu.usbcali.modelo.Referencia;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.dtt.DataTableRefGrupo;

@ManagedBean
@ViewScoped
public class AsignacionView {

	private List<DataTableRefGrupo> tablaGrupoReferencias;
	private List<SelectItem> items;
	private List<Grupo> grupos;
	
	private String sorActivo;
	private String grupo;
	
	private InputText txtReferencia;
	
	private SelectOneMenu cmbGrupos;

	private DataTableRefGrupo rowDataTableRefGrupo;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public AsignacionView() {
		super();

	}

	@PostConstruct
	public void asignacionView() {

		try {

			sorActivo = "S";

			items = new ArrayList<SelectItem>();
			grupos = new ArrayList<Grupo>();

			grupos = businessDelegatorView.getGrupo();

			for (int i = 0; i < grupos.size(); i++) {
				SelectItem item = new SelectItem(grupos.get(i).getIdGrpo(),
						grupos.get(i).getNombre());
				items.add(item);
			}

			llenarGrupoReferencia();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void activarReferencia() {
		try {

			List<GrupoReferencia> grupoReferenciasEnGrupo = businessDelegatorView
					.consultarPorGrupo("referencia.idRefe", new Long(
							rowDataTableRefGrupo.getIdRefe()));

			for (int i = 0; i < grupoReferenciasEnGrupo.size(); i++) {
				GrupoReferencia grupoReferencia = new GrupoReferencia();
				grupoReferencia = grupoReferenciasEnGrupo.get(i);
				if (grupoReferencia.getEstadoRegistro().equals("A")) {
					grupoReferencia.setEstadoRegistro("R");
					
					businessDelegatorView
							.updateGrupoReferencia(grupoReferencia);
				}

			}

			List<GrupoReferencia> grupoReferencias = businessDelegatorView
					.consultarPorGrupo("grupo.idGrpo",
							rowDataTableRefGrupo.getIdGrpo());

			for (int i = 0; i < grupoReferencias.size(); i++) {

				GrupoReferencia grupoReferencia = new GrupoReferencia();
				grupoReferencia = grupoReferencias.get(i);
				grupoReferencia.setEstadoRegistro("A");
				businessDelegatorView.updateGrupoReferencia(grupoReferencia);
			}

			GrupoReferencia grupoReferencia = businessDelegatorView
					.getGrupoReferencia(rowDataTableRefGrupo.getIdGrre());
		//	grupoReferencia.setEstadoRegistro("A");
			grupoReferencia.setActivo("S");

			businessDelegatorView.updateGrupoReferencia(grupoReferencia);
			llenarGrupoReferencia();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void llenarGrupoReferencia() {
		try {

			tablaGrupoReferencias = new ArrayList<DataTableRefGrupo>();
			List<GrupoReferencia> grupoReferencias = businessDelegatorView
					.getGrupoReferencia();

			for (int i = 0; i < grupoReferencias.size(); i++) {

				DataTableRefGrupo dataGrupoReferencia = new DataTableRefGrupo();
				Referencia referencia = businessDelegatorView
						.getReferencia(grupoReferencias.get(i).getReferencia()
								.getIdRefe());

				Grupo grupo = businessDelegatorView.getGrupo(grupoReferencias
						.get(i).getGrupo().getIdGrpo());

				dataGrupoReferencia.setIdGrre(grupoReferencias.get(i)
						.getIdGrre());
				dataGrupoReferencia.setIdRefe(grupoReferencias.get(i)
						.getReferencia().getIdRefe());
				dataGrupoReferencia.setDescripcion(referencia.getDescripcion());
				dataGrupoReferencia.setMarca(referencia.getMarca());
				dataGrupoReferencia.setNombre(grupo.getNombre());
				dataGrupoReferencia.setIdGrpo(grupoReferencias.get(i)
						.getGrupo().getIdGrpo());
				dataGrupoReferencia.setActivo(grupoReferencias.get(i)
						.getActivo());

				tablaGrupoReferencias.add(dataGrupoReferencia);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String guardarRef() {
		try {

			Referencia referencia = businessDelegatorView
					.getReferencia(new Long(txtReferencia.getValue().toString()));

			if (referencia == null) {
				return "";
			}

			Grupo grupo = businessDelegatorView.getGrupo(new Long(this.grupo));
			if (grupo == null) {
				return "";
			}

			List<GrupoReferencia> grupoReferencias = new ArrayList<GrupoReferencia>();
			grupoReferencias = businessDelegatorView.consultarPorGrupo(
					"grupo.idGrpo", new Long(this.grupo));

			Long idReferencia = new Long(txtReferencia.getValue().toString());
			for (int i = 0; i < grupoReferencias.size(); i++) {
				Long refEncont = grupoReferencias.get(i).getReferencia()
						.getIdRefe();
				if (refEncont.toString().equals(idReferencia.toString())) {
					return "";
				}
			}

			if (sorActivo.equals("S")) {
				for (int i = 0; i < grupoReferencias.size(); i++) {
					GrupoReferencia grupoReferencia = businessDelegatorView
							.getGrupoReferencia(grupoReferencias.get(i)
									.getIdGrre());
					grupoReferencia.setActivo("S");
					businessDelegatorView
							.updateGrupoReferencia(grupoReferencia);
				}
				List<GrupoReferencia> grupoReferenciasEnGrupo = businessDelegatorView
						.consultarPorGrupo("referencia.idRefe", new Long(
								txtReferencia.getValue().toString()));
				for (int i = 0; i < grupoReferenciasEnGrupo.size(); i++) {
					GrupoReferencia grupoReferencia = businessDelegatorView
							.getGrupoReferencia(grupoReferenciasEnGrupo.get(i)
									.getIdGrre());
					if (grupoReferencia.getEstadoRegistro().equals("R")) {
						grupoReferencia.setActivo("S");
						businessDelegatorView
								.updateGrupoReferencia(grupoReferencia);
					}

				}

			}

			GrupoReferencia grupoReferencia = new GrupoReferencia();

			grupoReferencia.setActivo(sorActivo);
			grupoReferencia.setEstadoRegistro("A");
			grupoReferencia.setFechaCreacion(new Date());
			grupoReferencia.setFechaInactivo(new Date());
			grupoReferencia.setFechaModificacion(new Date());
			grupoReferencia.setGrupo(grupo);
			grupoReferencia.setOperCreador("jsvargas");
			grupoReferencia.setOperModifica("jsvargas");
			grupoReferencia.setReferencia(referencia);

			businessDelegatorView.saveGrupoReferencia(grupoReferencia);

			llenarGrupoReferencia();
		} catch (Exception e) {

		}
		return "";
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

	public SelectOneMenu getCmbGrupos() {
		return cmbGrupos;
	}

	public void setCmbGrupos(SelectOneMenu cmbGrupos) {
		this.cmbGrupos = cmbGrupos;
	}

	public DataTableRefGrupo getRowDataTableRefGrupo() {
		return rowDataTableRefGrupo;
	}

	public void setRowDataTableRefGrupo(DataTableRefGrupo rowDataTableRefGrupo) {
		this.rowDataTableRefGrupo = rowDataTableRefGrupo;
	}

	public List<DataTableRefGrupo> getTablaGrupoReferencias() {
		return tablaGrupoReferencias;
	}

	public void setTablaGrupoReferencias(
			List<DataTableRefGrupo> tablaGrupoReferencias) {
		this.tablaGrupoReferencias = tablaGrupoReferencias;
	}

}
