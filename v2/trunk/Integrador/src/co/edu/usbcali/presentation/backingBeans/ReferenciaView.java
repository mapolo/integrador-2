package co.edu.usbcali.presentation.backingBeans;

import java.text.DateFormat;
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

import org.primefaces.component.calendar.Calendar;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import co.edu.usbcali.exceptions.ZMessManager;
import co.edu.usbcali.modelo.Referencia;
import co.edu.usbcali.modelo.dto.ReferenciaDTO;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class ReferenciaView {
	private InputText txtQPorCaja;
	private InputText txtAplicacion;
	private InputText txtCodigo;
	private InputText txtCodigoBarras;
	private InputText txtCosto;
	private InputTextarea txtDescripcion;
	private InputTextarea txtDescripcionCorta;
	private InputTextarea txtDescripcionTecnica;
	private InputText txtEquivalente1;
	private InputText txtEquivalente2;
	private SelectOneMenu txtEsGarantia;
	private SelectOneMenu estado;
	private InputText txtGalones;
	private InputText txtManejaDecimales;
	private InputText txtManejaLote;
	private InputText txtMarca;
	private InputText txtMargenMinimoGBodega;
	private InputText txtMargenMinimoGEne;
	private InputText txtMargenMinimoPBodega;
	private InputText txtMargenMinimoPEne;
	private InputText txtMargenMinimoRefBodega;
	private InputText txtMargenMinimoRefEne;
	private InputText txtOperCreador;
	private InputText txtOperModifica;
	private InputText txtPeso;
	private SelectOneMenu txtPideCantidad;
	private SelectOneMenu txtPideValor;
	private InputText txtPorcentajeIva;
	private InputText txtProductoConsumo;
	private InputText txtProductoEspecial;
	private InputText txtUnidadMedida;
	private InputText txtUnidadMedidaProvisional;
	private InputText txtVolumen;
	private InputText txtIdRefe;
	private InputText txtFechaCreacion;
	private InputText txtFechaModificacion;
	private Calendar txtFechaVigentePBodega;
	private Calendar txtFechaVigentePEne;

	private String QPorCaja;
	private String aplicacion;
	private String codigo;
	private String codigoBarras;
	private String costo;
	private String descripcion;
	private String descripcionCorta;
	private String descripcionTecnica;
	private String equivalente1;
	private String equivalente2;
	private String esGarantia;
	private String estadoRegistro;
	private String galones;
	private String manejaDecimales;
	private String manejaLote;
	private String marca;
	private String margenMinimoGBodega;
	private String margenMinimoGEne;
	private String margenMinimoPBodega;
	private String margenMinimoPEne;
	private String margenMinimoRefBodega;
	private String margenMinimoRefEne;
	private String operCreador;
	private String operModifica;
	private String peso;
	private String pideCantidad;
	private String pideValor;
	private String porcentajeIva;
	private String productoConsumo;
	private String productoEspecial;
	private String unidadMedida;
	private String unidadMedidaProvisional;
	private String volumen;
	private String idRefe;
	private String fechaCreacion;
	private String fechaModificacion;
	private String fechaVigentePBodega;
	private String fechaVigentePEne;

	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnModify2;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ReferenciaDTO> data;
	private ReferenciaDTO selectedReferencia;
	private Referencia entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	private SelectItem[] manufacturerOptions;
	private SelectItem[] manufacturerOptions2;
	private SelectItem[] manufacturerOptions3;

	String manufacturers[] = { "A", "R" };
	String manufacturers2[] = { "S", "N" };
	String manufacturers3[] = { "+", "-" };

	public ReferenciaView() {
		super();
		setManufacturerOptions(createFilterOptions(manufacturers));
		setManufacturerOptions2(createFilterOptions(manufacturers2));
		setManufacturerOptions3(createFilterOptions(manufacturers3));
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
			entity = businessDelegatorView.getReferencia(((ReferenciaDTO) event
					.getObject()).getIdRefe());

			aplicacion = ((ReferenciaDTO) event.getObject()).getAplicacion();
			entity.setAplicacion(aplicacion);
			codigo = ((ReferenciaDTO) event.getObject()).getCodigo();
			entity.setCodigo(codigo);
			codigoBarras = ((ReferenciaDTO) event.getObject())
					.getCodigoBarras();
			entity.setCodigoBarras(codigoBarras);
			descripcion = ((ReferenciaDTO) event.getObject()).getDescripcion();
			entity.setDescripcion(descripcion);
			descripcionCorta = ((ReferenciaDTO) event.getObject())
					.getDescripcionCorta();
			entity.setDescripcionCorta(descripcionCorta);
			descripcionTecnica = ((ReferenciaDTO) event.getObject())
					.getDescripcionTecnica();
			entity.setDescripcionTecnica(descripcionTecnica);
			equivalente1 = ((ReferenciaDTO) event.getObject())
					.getEquivalente1();
			entity.setEquivalente1(equivalente1);
			equivalente2 = ((ReferenciaDTO) event.getObject())
					.getEquivalente2();
			entity.setEquivalente2(equivalente2);
			marca = ((ReferenciaDTO) event.getObject()).getMarca();
			entity.setMarca(marca);
			unidadMedida = ((ReferenciaDTO) event.getObject())
					.getUnidadMedida();
			entity.setUnidadMedida(unidadMedida);
			unidadMedidaProvisional = ((ReferenciaDTO) event.getObject())
					.getUnidadMedidaProvisional();
			entity.setUnidadMedidaProvisional(unidadMedidaProvisional);

			Double volumen = new Double(
					((ReferenciaDTO) event.getObject()).getVolumen());
			entity.setVolumen(volumen);

			Double galones = new Double(
					((ReferenciaDTO) event.getObject()).getGalones());
			entity.setGalones(galones);

			Double porcentajeIva = new Double(
					((ReferenciaDTO) event.getObject()).getPorcentajeIva());
			entity.setPorcentajeIva(porcentajeIva);

			Double costo = new Double(
					((ReferenciaDTO) event.getObject()).getCosto());
			entity.setCosto(costo);

			Double peso = new Double(
					((ReferenciaDTO) event.getObject()).getPeso());
			entity.setPeso(peso);

			Long QPorCaja = new Long(
					((ReferenciaDTO) event.getObject()).getQPorCaja());
			entity.setQPorCaja(QPorCaja);

			Long margenMinimoGBodega = new Long(
					((ReferenciaDTO) event.getObject())
							.getMargenMinimoGBodega());
			entity.setMargenMinimoGBodega(margenMinimoGBodega);

			Long margenMinimoGEne = new Long(
					((ReferenciaDTO) event.getObject()).getMargenMinimoGEne());
			entity.setMargenMinimoGEne(margenMinimoGEne);

			Long margenMinimoPBodega = new Long(
					((ReferenciaDTO) event.getObject())
							.getMargenMinimoPBodega());
			entity.setMargenMinimoPBodega(margenMinimoPBodega);

			Long margenMinimoPEne = new Long(
					((ReferenciaDTO) event.getObject()).getMargenMinimoPEne());
			entity.setMargenMinimoPEne(margenMinimoPEne);

			Long margenMinimoRefBodega = new Long(
					((ReferenciaDTO) event.getObject())
							.getMargenMinimoRefBodega());
			entity.setMargenMinimoRefBodega(margenMinimoRefBodega);

			Long margenMinimoRefEne = new Long(
					((ReferenciaDTO) event.getObject()).getMargenMinimoRefEne());
			entity.setMargenMinimoRefEne(margenMinimoRefEne);

			Long productoConsumo = new Long(
					((ReferenciaDTO) event.getObject()).getProductoConsumo());
			entity.setProductoConsumo(productoConsumo);

			Long productoEspecial = new Long(
					((ReferenciaDTO) event.getObject()).getProductoEspecial());
			entity.setProductoEspecial(productoEspecial);

			Long manejaDecimales = new Long(
					((ReferenciaDTO) event.getObject()).getManejaDecimales());
			entity.setManejaDecimales(manejaDecimales);

			Long manejaLote = new Long(
					((ReferenciaDTO) event.getObject()).getManejaLote());
			entity.setManejaLote(manejaLote);

			String usuario = (String) FacesUtils.getfromSession("Usuario");
			entity.setOperModifica(usuario);
			entity.setEstadoRegistro(estadoRegistro);
			entity.setEsGarantia(esGarantia);
			entity.setPideCantidad(pideCantidad);
			entity.setPideValor(pideValor);

			Date fechaVigentePBodega = ((ReferenciaDTO) event.getObject())
					.getFechaVigentePBodega();
			entity.setFechaVigentePBodega(fechaVigentePBodega);

			Date fechaVigentePEne = ((ReferenciaDTO) event.getObject())
					.getFechaVigentePEne();
			entity.setFechaVigentePEne(fechaVigentePEne);

			businessDelegatorView.updateReferencia(entity);
			data = businessDelegatorView.getDataReferencia();
			RequestContext.getCurrentInstance().reset("form:refe");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onCancel(org.primefaces.event.RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Cancelled",
				((ReferenciaDTO) event.getObject()).getIdRefe() + "");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		System.out.println("Cancelado"
				+ ((ReferenciaDTO) event.getObject()).getIdRefe());
	}

	public String action_modify2() {
		try {

			btnSave.setDisabled(true);
			btnModify.setDisabled(false);

			try {
				txtQPorCaja.setValue(selectedReferencia.getQPorCaja());

			} catch (Exception e) {
				txtQPorCaja.setValue("");
			}

			try {
				txtAplicacion.setValue(selectedReferencia.getAplicacion());

			} catch (Exception e) {
				txtAplicacion.setValue("");
			}

			try {
				txtCodigo.setValue(selectedReferencia.getCodigo());

			} catch (Exception e) {
				txtCodigo.setValue("");
			}

			try {
				txtCodigoBarras.setValue(selectedReferencia.getCodigoBarras());
			} catch (Exception e) {
				txtCodigoBarras.setValue("");
			}

			try {
				txtCosto.setValue(selectedReferencia.getCosto());
			} catch (Exception e) {
				txtCosto.setValue("");
			}

			try {
				txtDescripcion.setValue(selectedReferencia.getDescripcion());
			} catch (Exception e) {
				txtDescripcion.setValue("");
			}

			try {
				txtDescripcionCorta.setValue(selectedReferencia
						.getDescripcionCorta());
			} catch (Exception e) {
				txtDescripcionCorta.setValue("");
			}

			try {
				txtDescripcionTecnica.setValue(selectedReferencia
						.getDescripcionTecnica());
			} catch (Exception e) {
				txtDescripcionTecnica.setValue("");
			}

			try {
				txtEquivalente1.setValue(selectedReferencia.getEquivalente1());
			} catch (Exception e) {
				txtEquivalente1.setValue("");
			}

			try {
				txtEquivalente2.setValue(selectedReferencia.getEquivalente2());
			} catch (Exception e) {
				txtEquivalente2.setValue("");
			}

			try {
				txtEsGarantia.setValue(selectedReferencia.getEsGarantia());
			} catch (Exception e) {
				txtEsGarantia.setValue("");
			}

			try {
				txtGalones.setValue(selectedReferencia.getGalones());
			} catch (Exception e) {
				txtGalones.setValue("");
			}

			try {
				txtManejaDecimales.setValue(selectedReferencia
						.getManejaDecimales());
			} catch (Exception e) {
				txtManejaDecimales.setValue("");
			}

			try {
				txtManejaLote.setValue(selectedReferencia.getManejaLote());
			} catch (Exception e) {
				txtManejaLote.setValue("");
			}

			try {
				txtMarca.setValue(selectedReferencia.getMarca());
			} catch (Exception e) {
				txtMarca.setValue("");
			}

			try {
				
				txtMargenMinimoGBodega.setValue(selectedReferencia
						.getMargenMinimoGBodega());
			} catch (Exception e) {
				System.out.println("dafuq");				
			}

			try {
				txtMargenMinimoGEne.setValue(selectedReferencia
						.getMargenMinimoGEne());
			} catch (Exception e) {
				txtMargenMinimoGEne.setValue("");
			}

			try {
				txtMargenMinimoPBodega.setValue(selectedReferencia
						.getMargenMinimoPBodega());
			} catch (Exception e) {
				txtMargenMinimoPBodega.setValue("");
			}

			try {
				txtMargenMinimoPEne.setValue(selectedReferencia
						.getMargenMinimoPEne());
			} catch (Exception e) {
				txtMargenMinimoPEne.setValue("");
			}

			try {
				txtMargenMinimoRefBodega.setValue(selectedReferencia
						.getMargenMinimoRefBodega());
			} catch (Exception e) {
				txtMargenMinimoRefBodega.setValue("");
			}

			try {
				txtMargenMinimoRefEne.setValue(selectedReferencia
						.getMargenMinimoRefEne());
			} catch (Exception e) {
				txtMargenMinimoRefEne.setValue("");
			}

			try {
				txtPeso.setValue(selectedReferencia.getPeso());
			} catch (Exception e) {
				txtPeso.setValue("");
			}

			try {
				txtPideCantidad.setValue(selectedReferencia.getPideCantidad());
			} catch (Exception e) {
				txtPideCantidad.setValue("");
			}

			try {
				txtPideValor.setValue(selectedReferencia.getPideValor());
			} catch (Exception e) {
				txtPideValor.setValue("");
			}

			try {
				txtPorcentajeIva
						.setValue(selectedReferencia.getPorcentajeIva());
			} catch (Exception e) {
				txtPorcentajeIva.setValue("");
			}

			try {
				txtProductoConsumo.setValue(selectedReferencia
						.getProductoConsumo());
			} catch (Exception e) {
				txtProductoConsumo.setValue("");
			}

			try {
				txtProductoEspecial.setValue(selectedReferencia
						.getProductoEspecial());
			} catch (Exception e) {
				txtProductoEspecial.setValue("");
			}

			try {
				txtUnidadMedida.setValue(selectedReferencia.getUnidadMedida());
			} catch (Exception e) {
				txtUnidadMedida.setValue("");
			}

			try {
				txtUnidadMedidaProvisional.setValue(selectedReferencia
						.getUnidadMedidaProvisional());
			} catch (Exception e) {
				txtUnidadMedidaProvisional.setValue("");
			}

			try {
				txtVolumen.setValue(selectedReferencia.getVolumen());
			} catch (Exception e) {
				txtVolumen.setValue("");
			}

			try {
				estado.setValue(selectedReferencia.getEstadoRegistro());
			} catch (Exception e) {
				estado.setValue("");
			}

			txtFechaVigentePBodega.setValue(selectedReferencia
					.getFechaVigentePBodega());
			txtFechaVigentePEne.setValue(selectedReferencia
					.getFechaVigentePEne());

			txtIdRefe.setValue(selectedReferencia.getIdRefe());

		} catch (Exception e) {
			if (selectedReferencia == null) {
				FacesUtils.addErrorMessage("Seleccione la Referencia a Modificar");
			}
		}
		return "";

	}

	public String action_VCrear() {

		btnModify.setDisabled(true);
		btnSave.setDisabled(false);

		try {
			txtQPorCaja.setValue(null);

		} catch (Exception e) {
			txtQPorCaja.setValue("");
		}

		try {
			txtAplicacion.setValue(null);

		} catch (Exception e) {
			txtAplicacion.setValue("");
		}

		try {
			txtCodigo.setValue(null);

		} catch (Exception e) {
			txtCodigo.setValue("");
		}

		try {
			txtCodigoBarras.setValue(null);
		} catch (Exception e) {
			txtCodigoBarras.setValue("");
		}

		try {
			txtCosto.setValue(null);
		} catch (Exception e) {
			txtCosto.setValue("");
		}

		try {
			txtDescripcion.setValue(null);
		} catch (Exception e) {
			txtDescripcion.setValue("");
		}

		try {
			txtDescripcionCorta.setValue(null);
		} catch (Exception e) {
			txtDescripcionCorta.setValue("");
		}

		try {
			txtDescripcionTecnica.setValue(null);
		} catch (Exception e) {
			txtDescripcionTecnica.setValue("");
		}

		try {
			txtEquivalente1.setValue(null);
		} catch (Exception e) {
			txtEquivalente1.setValue("");
		}

		try {
			txtEquivalente2.setValue(null);
		} catch (Exception e) {
			txtEquivalente2.setValue("");
		}

		try {
			txtEsGarantia.setValue(null);
		} catch (Exception e) {
			txtEsGarantia.setValue("");
		}

		try {
			txtGalones.setValue(null);
		} catch (Exception e) {
			txtGalones.setValue("");
		}

		try {
			txtManejaDecimales.setValue(null);
		} catch (Exception e) {
			txtManejaDecimales.setValue("");
		}

		try {
			txtManejaLote.setValue(null);
		} catch (Exception e) {
			txtManejaLote.setValue("");
		}

		try {
			txtMarca.setValue(null);
		} catch (Exception e) {
			txtMarca.setValue("");
		}

		try {
			txtMargenMinimoGBodega.setValue(null);
		} catch (Exception e) {
			txtMargenMinimoGBodega.setValue("");
		}

		try {
			txtMargenMinimoGEne.setValue(null);
		} catch (Exception e) {
			txtMargenMinimoGEne.setValue("");
		}

		try {
			txtMargenMinimoPBodega.setValue(null);
		} catch (Exception e) {
			txtMargenMinimoPBodega.setValue("");
		}

		try {
			txtMargenMinimoPEne.setValue(null);
		} catch (Exception e) {
			txtMargenMinimoPEne.setValue("");
		}

		try {
			txtMargenMinimoRefBodega.setValue(null);
		} catch (Exception e) {
			txtMargenMinimoRefBodega.setValue("");
		}

		try {
			txtMargenMinimoRefEne.setValue(null);
		} catch (Exception e) {
			txtMargenMinimoRefEne.setValue("");
		}

		try {
			txtPeso.setValue(null);
		} catch (Exception e) {
			txtPeso.setValue("");
		}

		try {
			txtPideCantidad.setValue(null);
		} catch (Exception e) {
			txtPideCantidad.setValue("");
		}

		try {
			txtPideValor.setValue(null);
		} catch (Exception e) {
			txtPideValor.setValue("");
		}

		try {
			txtPorcentajeIva.setValue(null);
		} catch (Exception e) {
			txtPorcentajeIva.setValue("");
		}

		try {
			txtProductoConsumo.setValue(null);
		} catch (Exception e) {
			txtProductoConsumo.setValue("");
		}

		try {
			txtProductoEspecial.setValue(null);
		} catch (Exception e) {
			txtProductoEspecial.setValue("");
		}

		try {
			txtUnidadMedida.setValue(null);
		} catch (Exception e) {
			txtUnidadMedida.setValue("");
		}

		try {
			txtUnidadMedidaProvisional.setValue(null);
		} catch (Exception e) {
			txtUnidadMedidaProvisional.setValue("");
		}

		try {
			txtVolumen.setValue(null);
		} catch (Exception e) {
			txtVolumen.setValue("");
		}

		try {
			txtFechaVigentePBodega.setValue(null);
		} catch (Exception e) {
			txtFechaVigentePBodega.setValue("");
		}

		try {
			txtFechaVigentePEne.setValue(null);
		} catch (Exception e) {
			txtFechaVigentePEne.setValue("");
		}

		try {
			estado.setValue(null);
		} catch (Exception e) {
			estado.setValue("");
		}

		return "";
	}

	public void rowEventListener(RowEditEvent e) {
		try {
			ReferenciaDTO referenciaDTO = (ReferenciaDTO) e.getObject();

			if (txtQPorCaja == null) {
				txtQPorCaja = new InputText();
			}

			txtQPorCaja.setValue(referenciaDTO.getQPorCaja());

			if (txtAplicacion == null) {
				txtAplicacion = new InputText();
			}

			txtAplicacion.setValue(referenciaDTO.getAplicacion());

			if (txtCodigo == null) {
				txtCodigo = new InputText();
			}

			txtCodigo.setValue(referenciaDTO.getCodigo());

			if (txtCodigoBarras == null) {
				txtCodigoBarras = new InputText();
			}

			txtCodigoBarras.setValue(referenciaDTO.getCodigoBarras());

			if (txtCosto == null) {
				txtCosto = new InputText();
			}

			txtCosto.setValue(referenciaDTO.getCosto());

			if (txtDescripcion == null) {
				txtDescripcion = new InputTextarea();
			}

			txtDescripcion.setValue(referenciaDTO.getDescripcion());

			if (txtDescripcionCorta == null) {
				txtDescripcionCorta = new InputTextarea();
			}

			txtDescripcionCorta.setValue(referenciaDTO.getDescripcionCorta());

			if (txtDescripcionTecnica == null) {
				txtDescripcionTecnica = new InputTextarea();
			}

			txtDescripcionTecnica.setValue(referenciaDTO
					.getDescripcionTecnica());

			if (txtEquivalente1 == null) {
				txtEquivalente1 = new InputText();
			}

			txtEquivalente1.setValue(referenciaDTO.getEquivalente1());

			if (txtEquivalente2 == null) {
				txtEquivalente2 = new InputText();
			}

			txtEquivalente2.setValue(referenciaDTO.getEquivalente2());

			if (txtEsGarantia == null) {
				txtEsGarantia = new SelectOneMenu();
			}

			txtEsGarantia.setValue(referenciaDTO.getEsGarantia());

			if (txtGalones == null) {
				txtGalones = new InputText();
			}

			txtGalones.setValue(referenciaDTO.getGalones());

			if (txtManejaDecimales == null) {
				txtManejaDecimales = new InputText();
			}

			txtManejaDecimales.setValue(referenciaDTO.getManejaDecimales());

			if (txtManejaLote == null) {
				txtManejaLote = new InputText();
			}

			txtManejaLote.setValue(referenciaDTO.getManejaLote());

			if (txtMarca == null) {
				txtMarca = new InputText();
			}

			txtMarca.setValue(referenciaDTO.getMarca());

			if (txtMargenMinimoGBodega == null) {
				txtMargenMinimoGBodega = new InputText();
			}

			txtMargenMinimoGBodega.setValue(referenciaDTO
					.getMargenMinimoGBodega());

			if (txtMargenMinimoGEne == null) {
				txtMargenMinimoGEne = new InputText();
			}

			txtMargenMinimoGEne.setValue(referenciaDTO.getMargenMinimoGEne());

			if (txtMargenMinimoPBodega == null) {
				txtMargenMinimoPBodega = new InputText();
			}

			txtMargenMinimoPBodega.setValue(referenciaDTO
					.getMargenMinimoPBodega());

			if (txtMargenMinimoPEne == null) {
				txtMargenMinimoPEne = new InputText();
			}

			txtMargenMinimoPEne.setValue(referenciaDTO.getMargenMinimoPEne());

			if (txtMargenMinimoRefBodega == null) {
				txtMargenMinimoRefBodega = new InputText();
			}

			txtMargenMinimoRefBodega.setValue(referenciaDTO
					.getMargenMinimoRefBodega());

			if (txtMargenMinimoRefEne == null) {
				txtMargenMinimoRefEne = new InputText();
			}

			txtMargenMinimoRefEne.setValue(referenciaDTO
					.getMargenMinimoRefEne());

			if (txtOperCreador == null) {
				txtOperCreador = new InputText();
			}

			txtOperCreador.setValue(referenciaDTO.getOperCreador());

			if (txtOperModifica == null) {
				txtOperModifica = new InputText();
			}

			txtOperModifica.setValue(referenciaDTO.getOperModifica());

			if (txtPeso == null) {
				txtPeso = new InputText();
			}

			txtPeso.setValue(referenciaDTO.getPeso());

			if (txtPideCantidad == null) {
				txtPideCantidad = new SelectOneMenu();
			}

			txtPideCantidad.setValue(referenciaDTO.getPideCantidad());

			if (txtPideValor == null) {
				txtPideValor = new SelectOneMenu();
			}

			txtPideValor.setValue(referenciaDTO.getPideValor());

			if (txtPorcentajeIva == null) {
				txtPorcentajeIva = new InputText();
			}

			txtPorcentajeIva.setValue(referenciaDTO.getPorcentajeIva());

			if (txtProductoConsumo == null) {
				txtProductoConsumo = new InputText();
			}

			txtProductoConsumo.setValue(referenciaDTO.getProductoConsumo());

			if (txtProductoEspecial == null) {
				txtProductoEspecial = new InputText();
			}

			txtProductoEspecial.setValue(referenciaDTO.getProductoEspecial());

			if (txtUnidadMedida == null) {
				txtUnidadMedida = new InputText();
			}

			txtUnidadMedida.setValue(referenciaDTO.getUnidadMedida());

			if (txtUnidadMedidaProvisional == null) {
				txtUnidadMedidaProvisional = new InputText();
			}

			txtUnidadMedidaProvisional.setValue(referenciaDTO
					.getUnidadMedidaProvisional());

			if (txtVolumen == null) {
				txtVolumen = new InputText();
			}

			txtVolumen.setValue(referenciaDTO.getVolumen());

			if (txtIdRefe == null) {
				txtIdRefe = new InputText();
			}

			txtIdRefe.setValue(referenciaDTO.getIdRefe());

			if (txtFechaCreacion == null) {
				txtFechaCreacion = new InputText();
			}

			txtFechaCreacion.setValue(referenciaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new InputText();
			}

			txtFechaModificacion.setValue(referenciaDTO.getFechaModificacion());

			if (txtFechaVigentePBodega == null) {
				txtFechaVigentePBodega = new Calendar();
			}

			txtFechaVigentePBodega.setValue(referenciaDTO
					.getFechaVigentePBodega());

			if (txtFechaVigentePEne == null) {
				txtFechaVigentePEne = new Calendar();
			}

			txtFechaVigentePEne.setValue(referenciaDTO.getFechaVigentePEne());

			action_modify();
		} catch (Exception ex) {
		}
	}

	public String action_new() {
		action_clear();
		selectedReferencia = null;
		setShowDialog(true);

		return "";
	}

	public String action_clear() {
		entity = null;
		selectedReferencia = null;

		if (txtQPorCaja != null) {
			txtQPorCaja.setValue(null);
			// txtQPorCaja.setDisabled(true);
		}

		if (txtAplicacion != null) {
			txtAplicacion.setValue(null);
			// txtAplicacion.setDisabled(true);
		}

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			// txtCodigo.setDisabled(true);
		}

		if (txtCodigoBarras != null) {
			txtCodigoBarras.setValue(null);
			// txtCodigoBarras.setDisabled(true);
		}

		if (txtCosto != null) {
			txtCosto.setValue(null);
			// txtCosto.setDisabled(true);
		}

		if (txtDescripcion != null) {
			txtDescripcion.setValue(null);
			// txtDescripcion.setDisabled(true);
		}

		if (txtDescripcionCorta != null) {
			txtDescripcionCorta.setValue(null);
			// txtDescripcionCorta.setDisabled(true);
		}

		if (txtDescripcionTecnica != null) {
			txtDescripcionTecnica.setValue(null);
			// txtDescripcionTecnica.setDisabled(true);
		}

		if (txtEquivalente1 != null) {
			txtEquivalente1.setValue(null);
			// txtEquivalente1.setDisabled(true);
		}

		if (txtEquivalente2 != null) {
			txtEquivalente2.setValue(null);
			// txtEquivalente2.setDisabled(true);
		}

		if (txtEsGarantia != null) {
			txtEsGarantia.setValue(null);
			// txtEsGarantia.setDisabled(true);
		}

		if (txtGalones != null) {
			txtGalones.setValue(null);
			// txtGalones.setDisabled(true);
		}

		if (txtManejaDecimales != null) {
			txtManejaDecimales.setValue(null);
			// txtManejaDecimales.setDisabled(true);
		}

		if (txtManejaLote != null) {
			txtManejaLote.setValue(null);
			// txtManejaLote.setDisabled(true);
		}

		if (txtMarca != null) {
			txtMarca.setValue(null);
			// txtMarca.setDisabled(true);
		}

		if (txtMargenMinimoGBodega != null) {
			txtMargenMinimoGBodega.setValue(null);
			// txtMargenMinimoGBodega.setDisabled(true);
		}

		if (txtMargenMinimoGEne != null) {
			txtMargenMinimoGEne.setValue(null);
			// txtMargenMinimoGEne.setDisabled(true);
		}

		if (txtMargenMinimoPBodega != null) {
			txtMargenMinimoPBodega.setValue(null);
			// txtMargenMinimoPBodega.setDisabled(true);
		}

		if (txtMargenMinimoPEne != null) {
			txtMargenMinimoPEne.setValue(null);
			// txtMargenMinimoPEne.setDisabled(true);
		}

		if (txtMargenMinimoRefBodega != null) {
			txtMargenMinimoRefBodega.setValue(null);
			// txtMargenMinimoRefBodega.setDisabled(true);
		}

		if (txtMargenMinimoRefEne != null) {
			txtMargenMinimoRefEne.setValue(null);
			// txtMargenMinimoRefEne.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			// txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			// txtOperModifica.setDisabled(true);
		}

		if (txtPeso != null) {
			txtPeso.setValue(null);
			// txtPeso.setDisabled(true);
		}

		if (txtPideCantidad != null) {
			txtPideCantidad.setValue(null);
			// txtPideCantidad.setDisabled(true);
		}

		if (txtPideValor != null) {
			txtPideValor.setValue(null);
			// txtPideValor.setDisabled(true);
		}

		if (txtPorcentajeIva != null) {
			txtPorcentajeIva.setValue(null);
			// txtPorcentajeIva.setDisabled(true);
		}

		if (txtProductoConsumo != null) {
			txtProductoConsumo.setValue(null);
			// txtProductoConsumo.setDisabled(true);
		}

		if (txtProductoEspecial != null) {
			txtProductoEspecial.setValue(null);
			// txtProductoEspecial.setDisabled(true);
		}

		if (txtUnidadMedida != null) {
			txtUnidadMedida.setValue(null);
			// txtUnidadMedida.setDisabled(true);
		}

		if (txtUnidadMedidaProvisional != null) {
			txtUnidadMedidaProvisional.setValue(null);
			// txtUnidadMedidaProvisional.setDisabled(true);
		}

		if (txtVolumen != null) {
			txtVolumen.setValue(null);
			// txtVolumen.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			// txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			// txtFechaModificacion.setDisabled(true);
		}

		if (txtFechaVigentePBodega != null) {
			txtFechaVigentePBodega.setValue(null);
			// txtFechaVigentePBodega.setDisabled(true);
		}

		if (txtFechaVigentePEne != null) {
			txtFechaVigentePEne.setValue(null);
			// txtFechaVigentePEne.setDisabled(true);
		}

		if (txtIdRefe != null) {
			txtIdRefe.setValue(null);
			// txtIdRefe.setDisabled(false);
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

	public void listener_txtFechaVigentePBodega() {
		Date inputDate = (Date) txtFechaVigentePBodega.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtFechaVigentePEne() {
		Date inputDate = (Date) txtFechaVigentePEne.getValue();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		FacesContext.getCurrentInstance().addMessage(
				"",
				new FacesMessage("Selected Date "
						+ dateFormat.format(inputDate)));
	}

	public void listener_txtId() {
		try {
			Long idRefe = new Long(txtIdRefe.getValue().toString());
			entity = businessDelegatorView.getReferencia(idRefe);
		} catch (Exception e) {

		}

		if (entity == null) {
			txtQPorCaja.setDisabled(false);
			txtAplicacion.setDisabled(false);
			txtCodigo.setDisabled(false);
			txtCodigoBarras.setDisabled(false);
			txtCosto.setDisabled(false);
			txtDescripcion.setDisabled(false);
			txtDescripcionCorta.setDisabled(false);
			txtDescripcionTecnica.setDisabled(false);
			txtEquivalente1.setDisabled(false);
			txtEquivalente2.setDisabled(false);
			txtEsGarantia.setDisabled(false);
			// txtEstadoRegistro.setDisabled(false);
			txtGalones.setDisabled(false);
			txtManejaDecimales.setDisabled(false);
			txtManejaLote.setDisabled(false);
			txtMarca.setDisabled(false);
			txtMargenMinimoGBodega.setDisabled(false);
			txtMargenMinimoGEne.setDisabled(false);
			txtMargenMinimoPBodega.setDisabled(false);
			txtMargenMinimoPEne.setDisabled(false);
			txtMargenMinimoRefBodega.setDisabled(false);
			txtMargenMinimoRefEne.setDisabled(false);
			txtOperCreador.setDisabled(false);
			txtOperModifica.setDisabled(false);
			txtPeso.setDisabled(false);
			txtPideCantidad.setDisabled(false);
			txtPideValor.setDisabled(false);
			txtPorcentajeIva.setDisabled(false);
			txtProductoConsumo.setDisabled(false);
			txtProductoEspecial.setDisabled(false);
			txtUnidadMedida.setDisabled(false);
			txtUnidadMedidaProvisional.setDisabled(false);
			txtVolumen.setDisabled(false);
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setDisabled(false);
			txtFechaVigentePBodega.setDisabled(false);
			txtFechaVigentePEne.setDisabled(false);
			txtIdRefe.setDisabled(false);
			btnSave.setDisabled(false);
		} else {
			txtQPorCaja.setValue(entity.getQPorCaja());
			txtQPorCaja.setDisabled(false);
			txtAplicacion.setValue(entity.getAplicacion());
			txtAplicacion.setDisabled(false);
			txtCodigo.setValue(entity.getCodigo());
			txtCodigo.setDisabled(false);
			txtCodigoBarras.setValue(entity.getCodigoBarras());
			txtCodigoBarras.setDisabled(false);
			txtCosto.setValue(entity.getCosto());
			txtCosto.setDisabled(false);
			txtDescripcion.setValue(entity.getDescripcion());
			txtDescripcion.setDisabled(false);
			txtDescripcionCorta.setValue(entity.getDescripcionCorta());
			txtDescripcionCorta.setDisabled(false);
			txtDescripcionTecnica.setValue(entity.getDescripcionTecnica());
			txtDescripcionTecnica.setDisabled(false);
			txtEquivalente1.setValue(entity.getEquivalente1());
			txtEquivalente1.setDisabled(false);
			txtEquivalente2.setValue(entity.getEquivalente2());
			txtEquivalente2.setDisabled(false);
			txtEsGarantia.setValue(entity.getEsGarantia());
			txtEsGarantia.setDisabled(false);
			// txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			// txtEstadoRegistro.setDisabled(false);
			txtFechaCreacion.setValue(entity.getFechaCreacion());
			txtFechaCreacion.setDisabled(false);
			txtFechaModificacion.setValue(entity.getFechaModificacion());
			txtFechaModificacion.setDisabled(false);
			txtFechaVigentePBodega.setValue(entity.getFechaVigentePBodega());
			txtFechaVigentePBodega.setDisabled(false);
			txtFechaVigentePEne.setValue(entity.getFechaVigentePEne());
			txtFechaVigentePEne.setDisabled(false);
			txtGalones.setValue(entity.getGalones());
			txtGalones.setDisabled(false);
			txtManejaDecimales.setValue(entity.getManejaDecimales());
			txtManejaDecimales.setDisabled(false);
			txtManejaLote.setValue(entity.getManejaLote());
			txtManejaLote.setDisabled(false);
			txtMarca.setValue(entity.getMarca());
			txtMarca.setDisabled(false);
			txtMargenMinimoGBodega.setValue(entity.getMargenMinimoGBodega());
			txtMargenMinimoGBodega.setDisabled(false);
			txtMargenMinimoGEne.setValue(entity.getMargenMinimoGEne());
			txtMargenMinimoGEne.setDisabled(false);
			txtMargenMinimoPBodega.setValue(entity.getMargenMinimoPBodega());
			txtMargenMinimoPBodega.setDisabled(false);
			txtMargenMinimoPEne.setValue(entity.getMargenMinimoPEne());
			txtMargenMinimoPEne.setDisabled(false);
			txtMargenMinimoRefBodega
					.setValue(entity.getMargenMinimoRefBodega());
			txtMargenMinimoRefBodega.setDisabled(false);
			txtMargenMinimoRefEne.setValue(entity.getMargenMinimoRefEne());
			txtMargenMinimoRefEne.setDisabled(false);
			txtOperCreador.setValue(entity.getOperCreador());
			txtOperCreador.setDisabled(false);
			txtOperModifica.setValue(entity.getOperModifica());
			txtOperModifica.setDisabled(false);
			txtPeso.setValue(entity.getPeso());
			txtPeso.setDisabled(false);
			txtPideCantidad.setValue(entity.getPideCantidad());
			txtPideCantidad.setDisabled(false);
			txtPideValor.setValue(entity.getPideValor());
			txtPideValor.setDisabled(false);
			txtPorcentajeIva.setValue(entity.getPorcentajeIva());
			txtPorcentajeIva.setDisabled(false);
			txtProductoConsumo.setValue(entity.getProductoConsumo());
			txtProductoConsumo.setDisabled(false);
			txtProductoEspecial.setValue(entity.getProductoEspecial());
			txtProductoEspecial.setDisabled(false);
			txtUnidadMedida.setValue(entity.getUnidadMedida());
			txtUnidadMedida.setDisabled(false);
			txtUnidadMedidaProvisional.setValue(entity
					.getUnidadMedidaProvisional());
			txtUnidadMedidaProvisional.setDisabled(false);
			txtVolumen.setValue(entity.getVolumen());
			txtVolumen.setDisabled(false);
			txtIdRefe.setValue(entity.getIdRefe());
			txtIdRefe.setDisabled(true);
			btnSave.setDisabled(false);
		}
	}

	public String action_edit(ActionEvent evt) {
		selectedReferencia = (ReferenciaDTO) (evt.getComponent()
				.getAttributes().get("selectedReferencia"));
		txtQPorCaja.setValue(selectedReferencia.getQPorCaja());
		txtQPorCaja.setDisabled(false);
		txtAplicacion.setValue(selectedReferencia.getAplicacion());
		txtAplicacion.setDisabled(false);
		txtCodigo.setValue(selectedReferencia.getCodigo());
		txtCodigo.setDisabled(false);
		txtCodigoBarras.setValue(selectedReferencia.getCodigoBarras());
		txtCodigoBarras.setDisabled(false);
		txtCosto.setValue(selectedReferencia.getCosto());
		txtCosto.setDisabled(false);
		txtDescripcion.setValue(selectedReferencia.getDescripcion());
		txtDescripcion.setDisabled(false);
		txtDescripcionCorta.setValue(selectedReferencia.getDescripcionCorta());
		txtDescripcionCorta.setDisabled(false);
		txtDescripcionTecnica.setValue(selectedReferencia
				.getDescripcionTecnica());
		txtDescripcionTecnica.setDisabled(false);
		txtEquivalente1.setValue(selectedReferencia.getEquivalente1());
		txtEquivalente1.setDisabled(false);
		txtEquivalente2.setValue(selectedReferencia.getEquivalente2());
		txtEquivalente2.setDisabled(false);
		txtEsGarantia.setValue(selectedReferencia.getEsGarantia());
		txtEsGarantia.setDisabled(false);
		// txtEstadoRegistro.setValue(selectedReferencia.getEstadoRegistro());
		// txtEstadoRegistro.setDisabled(false);
		txtFechaCreacion.setValue(selectedReferencia.getFechaCreacion());
		txtFechaCreacion.setDisabled(false);
		txtFechaModificacion
				.setValue(selectedReferencia.getFechaModificacion());
		txtFechaModificacion.setDisabled(false);
		txtFechaVigentePBodega.setValue(selectedReferencia
				.getFechaVigentePBodega());
		txtFechaVigentePBodega.setDisabled(false);
		txtFechaVigentePEne.setValue(selectedReferencia.getFechaVigentePEne());
		txtFechaVigentePEne.setDisabled(false);
		txtGalones.setValue(selectedReferencia.getGalones());
		txtGalones.setDisabled(false);
		txtManejaDecimales.setValue(selectedReferencia.getManejaDecimales());
		txtManejaDecimales.setDisabled(false);
		txtManejaLote.setValue(selectedReferencia.getManejaLote());
		txtManejaLote.setDisabled(false);
		txtMarca.setValue(selectedReferencia.getMarca());
		txtMarca.setDisabled(false);
		txtMargenMinimoGBodega.setValue(selectedReferencia
				.getMargenMinimoGBodega());
		txtMargenMinimoGBodega.setDisabled(false);
		txtMargenMinimoGEne.setValue(selectedReferencia.getMargenMinimoGEne());
		txtMargenMinimoGEne.setDisabled(false);
		txtMargenMinimoPBodega.setValue(selectedReferencia
				.getMargenMinimoPBodega());
		txtMargenMinimoPBodega.setDisabled(false);
		txtMargenMinimoPEne.setValue(selectedReferencia.getMargenMinimoPEne());
		txtMargenMinimoPEne.setDisabled(false);
		txtMargenMinimoRefBodega.setValue(selectedReferencia
				.getMargenMinimoRefBodega());
		txtMargenMinimoRefBodega.setDisabled(false);
		txtMargenMinimoRefEne.setValue(selectedReferencia
				.getMargenMinimoRefEne());
		txtMargenMinimoRefEne.setDisabled(false);
		txtOperCreador.setValue(selectedReferencia.getOperCreador());
		txtOperCreador.setDisabled(false);
		txtOperModifica.setValue(selectedReferencia.getOperModifica());
		txtOperModifica.setDisabled(false);
		txtPeso.setValue(selectedReferencia.getPeso());
		txtPeso.setDisabled(false);
		txtPideCantidad.setValue(selectedReferencia.getPideCantidad());
		txtPideCantidad.setDisabled(false);
		txtPideValor.setValue(selectedReferencia.getPideValor());
		txtPideValor.setDisabled(false);
		txtPorcentajeIva.setValue(selectedReferencia.getPorcentajeIva());
		txtPorcentajeIva.setDisabled(false);
		txtProductoConsumo.setValue(selectedReferencia.getProductoConsumo());
		txtProductoConsumo.setDisabled(false);
		txtProductoEspecial.setValue(selectedReferencia.getProductoEspecial());
		txtProductoEspecial.setDisabled(false);
		txtUnidadMedida.setValue(selectedReferencia.getUnidadMedida());
		txtUnidadMedida.setDisabled(false);
		txtUnidadMedidaProvisional.setValue(selectedReferencia
				.getUnidadMedidaProvisional());
		txtUnidadMedidaProvisional.setDisabled(false);
		txtVolumen.setValue(selectedReferencia.getVolumen());
		txtVolumen.setDisabled(false);
		txtIdRefe.setValue(selectedReferencia.getIdRefe());
		txtIdRefe.setDisabled(true);
		btnSave.setDisabled(false);
		setShowDialog(true);

		return "";
	}

	public String action_save() {
		try {
			if ((selectedReferencia == null) && (entity == null)) {
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
			entity = new Referencia();

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			entity.setAplicacion(FacesUtils.checkString(txtAplicacion));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCodigoBarras(FacesUtils.checkString(txtCodigoBarras));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			entity.setDescripcionCorta(FacesUtils
					.checkString(txtDescripcionCorta));
			entity.setDescripcionTecnica(FacesUtils
					.checkString(txtDescripcionTecnica));
			entity.setEquivalente1(FacesUtils.checkString(txtEquivalente1));
			entity.setEquivalente2(FacesUtils.checkString(txtEquivalente2));
			entity.setEsGarantia(esGarantia);
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaVigentePBodega(FacesUtils
					.checkDate(txtFechaVigentePBodega));
			entity.setFechaVigentePEne(FacesUtils
					.checkDate(txtFechaVigentePEne));
			entity.setMarca(FacesUtils.checkString(txtMarca));
			entity.setPideCantidad(pideCantidad);
			entity.setPideValor(pideValor);
			entity.setUnidadMedida(FacesUtils.checkString(txtUnidadMedida));
			entity.setUnidadMedidaProvisional(FacesUtils
					.checkString(txtUnidadMedidaProvisional));
			entity.setVolumen(FacesUtils.checkDouble(txtVolumen));
			entity.setGalones(FacesUtils.checkDouble(txtGalones));
			entity.setPorcentajeIva(FacesUtils.checkDouble(txtPorcentajeIva));
			entity.setCosto(FacesUtils.checkDouble(txtCosto));
			entity.setPeso(FacesUtils.checkDouble(txtPeso));
			Long QPorCaja = new Long(txtQPorCaja.getValue().toString());
			entity.setQPorCaja(QPorCaja);
			Long margenMinimoGBodega = new Long(txtMargenMinimoGBodega
					.getValue().toString());
			entity.setMargenMinimoGBodega(margenMinimoGBodega);
			Long margenMinimoGEne = new Long(txtMargenMinimoGEne.getValue()
					.toString());
			entity.setMargenMinimoGEne(margenMinimoGEne);

			Long margenMinimoPBodega = new Long(txtMargenMinimoPBodega
					.getValue().toString());
			entity.setMargenMinimoPBodega(margenMinimoPBodega);
			Long margenMinimoPEne = new Long(txtMargenMinimoPEne.getValue()
					.toString());
			entity.setMargenMinimoPEne(margenMinimoPEne);
			Long margenMinimoRefBodega = new Long(txtMargenMinimoRefBodega
					.getValue().toString());
			entity.setMargenMinimoRefBodega(margenMinimoRefBodega);
			Long margenMinimoRefEne = new Long(txtMargenMinimoRefEne.getValue()
					.toString());
			entity.setMargenMinimoRefEne(margenMinimoRefEne);
			Long productoConsumo = new Long(txtProductoConsumo.getValue()
					.toString());
			entity.setProductoConsumo(productoConsumo);
			Long productoEspecial = new Long(txtProductoEspecial.getValue()
					.toString());
			entity.setProductoEspecial(productoEspecial);
			Long manejaDecimales = new Long(txtManejaDecimales.getValue()
					.toString());
			entity.setManejaDecimales(manejaDecimales);
			Long manejaLote = new Long(txtManejaLote.getValue().toString());
			entity.setManejaLote(manejaLote);

			entity.setEstadoRegistro(estadoRegistro);
			entity.setFechaCreacion(new Date());
			entity.setFechaModificacion(new Date());
			entity.setOperCreador(usuario);
			entity.setOperModifica(usuario);

			businessDelegatorView.saveReferencia(entity);
			data = businessDelegatorView.getDataReferencia();
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
				Long idRefe = new Long(selectedReferencia.getIdRefe());
				entity = businessDelegatorView.getReferencia(idRefe);
			}

			Long idRefe = new Long(selectedReferencia.getIdRefe());
			entity = businessDelegatorView.getReferencia(idRefe);

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext()
					.getSession(false);

			String usuario = (String) session.getAttribute("Usuario");

			entity.setAplicacion(FacesUtils.checkString(txtAplicacion));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCodigoBarras(FacesUtils.checkString(txtCodigoBarras));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			entity.setDescripcionCorta(FacesUtils
					.checkString(txtDescripcionCorta));
			
			System.out.println("Descripcion corta: " + FacesUtils.checkString(txtDescripcionCorta));
			entity.setDescripcionTecnica(FacesUtils
					.checkString(txtDescripcionTecnica));
			
			System.out.println("entro descripcion: " + FacesUtils
					.checkString(txtDescripcionTecnica));
			
			entity.setEquivalente1(FacesUtils.checkString(txtEquivalente1));
			entity.setEquivalente2(FacesUtils.checkString(txtEquivalente2));
			entity.setEsGarantia(esGarantia);
			
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaVigentePBodega(FacesUtils
					.checkDate(txtFechaVigentePBodega));
			entity.setFechaVigentePEne(FacesUtils
					.checkDate(txtFechaVigentePEne));
			entity.setMarca(FacesUtils.checkString(txtMarca));
			entity.setPideCantidad(pideCantidad);
			entity.setPideValor(pideValor);
			entity.setUnidadMedida(FacesUtils.checkString(txtUnidadMedida));
			entity.setUnidadMedidaProvisional(FacesUtils
					.checkString(txtUnidadMedidaProvisional));
			entity.setVolumen(FacesUtils.checkDouble(txtVolumen));
			entity.setGalones(FacesUtils.checkDouble(txtGalones));
			entity.setPorcentajeIva(FacesUtils.checkDouble(txtPorcentajeIva));
			entity.setCosto(FacesUtils.checkDouble(txtCosto));
			entity.setPeso(FacesUtils.checkDouble(txtPeso));
			
			
			Long QPorCaja = new Long(txtQPorCaja.getValue().toString());
			entity.setQPorCaja(QPorCaja);
			System.out.println("prueba= " + QPorCaja);
			
			Long margenMinimoGBodega = new Long(txtMargenMinimoGBodega
					.getValue().toString());
			entity.setMargenMinimoGBodega(margenMinimoGBodega);
			System.out.println("prueba2= " + margenMinimoGBodega);
			
			Long margenMinimoGEne = new Long(txtMargenMinimoGEne.getValue()
					.toString());
			entity.setMargenMinimoGEne(margenMinimoGEne);
			System.out.println("prueba3= " + margenMinimoGEne);
			
			Long margenMinimoPBodega = new Long(txtMargenMinimoPBodega
					.getValue().toString());
			entity.setMargenMinimoPBodega(margenMinimoPBodega);
			System.out.println("prueba4= " + margenMinimoPBodega);
			
			
			Long margenMinimoPEne = new Long(txtMargenMinimoPEne.getValue()
					.toString());
			entity.setMargenMinimoPEne(margenMinimoPEne);
			
			
			Long margenMinimoRefBodega = new Long(txtMargenMinimoRefBodega
					.getValue().toString());
			entity.setMargenMinimoRefBodega(margenMinimoRefBodega);
			
			
			Long margenMinimoRefEne = new Long(txtMargenMinimoRefEne.getValue()
					.toString());
			entity.setMargenMinimoRefEne(margenMinimoRefEne);
			
			
			Long productoConsumo = new Long(txtProductoConsumo.getValue()
					.toString());
			entity.setProductoConsumo(productoConsumo);
			
			
			Long productoEspecial = new Long(txtProductoEspecial.getValue()
					.toString());
			entity.setProductoEspecial(productoEspecial);
			
			
			Long manejaDecimales = new Long(txtManejaDecimales.getValue()
					.toString());
			entity.setManejaDecimales(manejaDecimales);
			
			
			Long manejaLote = new Long(txtManejaLote.getValue().toString());
			entity.setManejaLote(manejaLote);

			
			
			entity.setEstadoRegistro(estadoRegistro);
			entity.setFechaModificacion(new Date());
			entity.setOperModifica(usuario);
			
			System.out.println("mmmm");
			businessDelegatorView.updateReferencia(entity);
			data = businessDelegatorView.getDataReferencia();
			RequestContext.getCurrentInstance().reset("form:refe");
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
			System.out.println("Excepcion");
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_delete(ActionEvent evt) {
		try {
			selectedReferencia = (ReferenciaDTO) (evt.getComponent()
					.getAttributes().get("selectedReferencia"));

			Long idRefe = new Long(selectedReferencia.getIdRefe());
			entity = businessDelegatorView.getReferencia(idRefe);
			businessDelegatorView.deleteReferencia(entity);
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
			selectedReferencia = (ReferenciaDTO) (evt.getComponent()
					.getAttributes().get("selectedReferencia"));

			Long idRefe = new Long(selectedReferencia.getIdRefe());
			entity = businessDelegatorView.getReferencia(idRefe);
			businessDelegatorView.deleteReferencia(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
			action_clear();
			data.remove(selectedReferencia);
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}

		return "";
	}

	public String action_modifyWitDTO(Long QPorCaja, String aplicacion,
			String codigo, String codigoBarras, Double costo,
			String descripcion, String descripcionCorta,
			String descripcionTecnica, String equivalente1,
			String equivalente2, String esGarantia, String estadoRegistro,
			Date fechaCreacion, Date fechaModificacion,
			Date fechaVigentePBodega, Date fechaVigentePEne, Double galones,
			Long idRefe, Long manejaDecimales, Long manejaLote, String marca,
			Long margenMinimoGBodega, Long margenMinimoGEne,
			Long margenMinimoPBodega, Long margenMinimoPEne,
			Long margenMinimoRefBodega, Long margenMinimoRefEne,
			String operCreador, String operModifica, Double peso,
			String pideCantidad, String pideValor, Double porcentajeIva,
			Long productoConsumo, Long productoEspecial, String unidadMedida,
			String unidadMedidaProvisional, Double volumen) throws Exception {
		try {
			entity.setQPorCaja(FacesUtils.checkLong(QPorCaja));
			entity.setAplicacion(FacesUtils.checkString(aplicacion));
			entity.setCodigo(FacesUtils.checkString(codigo));
			entity.setCodigoBarras(FacesUtils.checkString(codigoBarras));
			entity.setCosto(FacesUtils.checkDouble(costo));
			entity.setDescripcion(FacesUtils.checkString(descripcion));
			entity.setDescripcionCorta(FacesUtils.checkString(descripcionCorta));
			entity.setDescripcionTecnica(FacesUtils
					.checkString(descripcionTecnica));
			entity.setEquivalente1(FacesUtils.checkString(equivalente1));
			entity.setEquivalente2(FacesUtils.checkString(equivalente2));
			entity.setEsGarantia(FacesUtils.checkString(esGarantia));
			entity.setEstadoRegistro(FacesUtils.checkString(estadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(fechaCreacion));
			entity.setFechaModificacion(FacesUtils.checkDate(fechaModificacion));
			entity.setFechaVigentePBodega(FacesUtils
					.checkDate(fechaVigentePBodega));
			entity.setFechaVigentePEne(FacesUtils.checkDate(fechaVigentePEne));
			entity.setGalones(FacesUtils.checkDouble(galones));
			entity.setManejaDecimales(FacesUtils.checkLong(manejaDecimales));
			entity.setManejaLote(FacesUtils.checkLong(manejaLote));
			entity.setMarca(FacesUtils.checkString(marca));
			entity.setMargenMinimoGBodega(FacesUtils
					.checkLong(margenMinimoGBodega));
			entity.setMargenMinimoGEne(FacesUtils.checkLong(margenMinimoGEne));
			entity.setMargenMinimoPBodega(FacesUtils
					.checkLong(margenMinimoPBodega));
			entity.setMargenMinimoPEne(FacesUtils.checkLong(margenMinimoPEne));
			entity.setMargenMinimoRefBodega(FacesUtils
					.checkLong(margenMinimoRefBodega));
			entity.setMargenMinimoRefEne(FacesUtils
					.checkLong(margenMinimoRefEne));
			entity.setOperCreador(FacesUtils.checkString(operCreador));
			entity.setOperModifica(FacesUtils.checkString(operModifica));
			entity.setPeso(FacesUtils.checkDouble(peso));
			entity.setPideCantidad(FacesUtils.checkString(pideCantidad));
			entity.setPideValor(FacesUtils.checkString(pideValor));
			entity.setPorcentajeIva(FacesUtils.checkDouble(porcentajeIva));
			entity.setProductoConsumo(FacesUtils.checkLong(productoConsumo));
			entity.setProductoEspecial(FacesUtils.checkLong(productoEspecial));
			entity.setUnidadMedida(FacesUtils.checkString(unidadMedida));
			entity.setUnidadMedidaProvisional(FacesUtils
					.checkString(unidadMedidaProvisional));
			entity.setVolumen(FacesUtils.checkDouble(volumen));
			businessDelegatorView.updateReferencia(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			// renderManager.getOnDemandRenderer("ReferenciaView").requestRender();
			FacesUtils.addErrorMessage(e.getMessage());
			throw e;
		}

		return "";
	}

	public InputText getTxtQPorCaja() {
		return txtQPorCaja;
	}

	public void setTxtQPorCaja(InputText txtQPorCaja) {
		this.txtQPorCaja = txtQPorCaja;
	}

	public InputText getTxtAplicacion() {
		return txtAplicacion;
	}

	public void setTxtAplicacion(InputText txtAplicacion) {
		this.txtAplicacion = txtAplicacion;
	}

	public InputText getTxtCodigo() {
		return txtCodigo;
	}

	public void setTxtCodigo(InputText txtCodigo) {
		this.txtCodigo = txtCodigo;
	}

	public InputText getTxtCodigoBarras() {
		return txtCodigoBarras;
	}

	public void setTxtCodigoBarras(InputText txtCodigoBarras) {
		this.txtCodigoBarras = txtCodigoBarras;
	}

	public InputText getTxtCosto() {
		return txtCosto;
	}

	public void setTxtCosto(InputText txtCosto) {
		this.txtCosto = txtCosto;
	}

	public InputTextarea getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(InputTextarea txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public InputTextarea getTxtDescripcionCorta() {
		return txtDescripcionCorta;
	}

	public void setTxtDescripcionCorta(InputTextarea txtDescripcionCorta) {
		this.txtDescripcionCorta = txtDescripcionCorta;
	}

	public InputTextarea getTxtDescripcionTecnica() {
		return txtDescripcionTecnica;
	}

	public void setTxtDescripcionTecnica(InputTextarea txtDescripcionTecnica) {
		this.txtDescripcionTecnica = txtDescripcionTecnica;
	}

	public InputText getTxtEquivalente1() {
		return txtEquivalente1;
	}

	public void setTxtEquivalente1(InputText txtEquivalente1) {
		this.txtEquivalente1 = txtEquivalente1;
	}

	public InputText getTxtEquivalente2() {
		return txtEquivalente2;
	}

	public void setTxtEquivalente2(InputText txtEquivalente2) {
		this.txtEquivalente2 = txtEquivalente2;
	}

	public SelectOneMenu getTxtEsGarantia() {
		return txtEsGarantia;
	}

	public void setTxtEsGarantia(SelectOneMenu txtEsGarantia) {
		this.txtEsGarantia = txtEsGarantia;
	}

	public InputText getTxtGalones() {
		return txtGalones;
	}

	public void setTxtGalones(InputText txtGalones) {
		this.txtGalones = txtGalones;
	}

	public InputText getTxtManejaDecimales() {
		return txtManejaDecimales;
	}

	public void setTxtManejaDecimales(InputText txtManejaDecimales) {
		this.txtManejaDecimales = txtManejaDecimales;
	}

	public InputText getTxtManejaLote() {
		return txtManejaLote;
	}

	public void setTxtManejaLote(InputText txtManejaLote) {
		this.txtManejaLote = txtManejaLote;
	}

	public InputText getTxtMarca() {
		return txtMarca;
	}

	public void setTxtMarca(InputText txtMarca) {
		this.txtMarca = txtMarca;
	}

	public InputText getTxtMargenMinimoGBodega() {
		return txtMargenMinimoGBodega;
	}

	public void setTxtMargenMinimoGBodega(InputText txtMargenMinimoGBodega) {
		this.txtMargenMinimoGBodega = txtMargenMinimoGBodega;
	}

	public InputText getTxtMargenMinimoGEne() {
		return txtMargenMinimoGEne;
	}

	public void setTxtMargenMinimoGEne(InputText txtMargenMinimoGEne) {
		this.txtMargenMinimoGEne = txtMargenMinimoGEne;
	}

	public InputText getTxtMargenMinimoPBodega() {
		return txtMargenMinimoPBodega;
	}

	public void setTxtMargenMinimoPBodega(InputText txtMargenMinimoPBodega) {
		this.txtMargenMinimoPBodega = txtMargenMinimoPBodega;
	}

	public InputText getTxtMargenMinimoPEne() {
		return txtMargenMinimoPEne;
	}

	public void setTxtMargenMinimoPEne(InputText txtMargenMinimoPEne) {
		this.txtMargenMinimoPEne = txtMargenMinimoPEne;
	}

	public InputText getTxtMargenMinimoRefBodega() {
		return txtMargenMinimoRefBodega;
	}

	public void setTxtMargenMinimoRefBodega(InputText txtMargenMinimoRefBodega) {
		this.txtMargenMinimoRefBodega = txtMargenMinimoRefBodega;
	}

	public InputText getTxtMargenMinimoRefEne() {
		return txtMargenMinimoRefEne;
	}

	public void setTxtMargenMinimoRefEne(InputText txtMargenMinimoRefEne) {
		this.txtMargenMinimoRefEne = txtMargenMinimoRefEne;
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

	public InputText getTxtPeso() {
		return txtPeso;
	}

	public void setTxtPeso(InputText txtPeso) {
		this.txtPeso = txtPeso;
	}

	public SelectOneMenu getTxtPideCantidad() {
		return txtPideCantidad;
	}

	public void setTxtPideCantidad(SelectOneMenu txtPideCantidad) {
		this.txtPideCantidad = txtPideCantidad;
	}

	public SelectOneMenu getTxtPideValor() {
		return txtPideValor;
	}

	public void setTxtPideValor(SelectOneMenu txtPideValor) {
		this.txtPideValor = txtPideValor;
	}

	public InputText getTxtPorcentajeIva() {
		return txtPorcentajeIva;
	}

	public void setTxtPorcentajeIva(InputText txtPorcentajeIva) {
		this.txtPorcentajeIva = txtPorcentajeIva;
	}

	public InputText getTxtProductoConsumo() {
		return txtProductoConsumo;
	}

	public void setTxtProductoConsumo(InputText txtProductoConsumo) {
		this.txtProductoConsumo = txtProductoConsumo;
	}

	public InputText getTxtProductoEspecial() {
		return txtProductoEspecial;
	}

	public void setTxtProductoEspecial(InputText txtProductoEspecial) {
		this.txtProductoEspecial = txtProductoEspecial;
	}

	public InputText getTxtUnidadMedida() {
		return txtUnidadMedida;
	}

	public void setTxtUnidadMedida(InputText txtUnidadMedida) {
		this.txtUnidadMedida = txtUnidadMedida;
	}

	public InputText getTxtUnidadMedidaProvisional() {
		return txtUnidadMedidaProvisional;
	}

	public void setTxtUnidadMedidaProvisional(
			InputText txtUnidadMedidaProvisional) {
		this.txtUnidadMedidaProvisional = txtUnidadMedidaProvisional;
	}

	public InputText getTxtVolumen() {
		return txtVolumen;
	}

	public void setTxtVolumen(InputText txtVolumen) {
		this.txtVolumen = txtVolumen;
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

	public Calendar getTxtFechaVigentePBodega() {
		return txtFechaVigentePBodega;
	}

	public void setTxtFechaVigentePBodega(Calendar txtFechaVigentePBodega) {
		this.txtFechaVigentePBodega = txtFechaVigentePBodega;
	}

	public Calendar getTxtFechaVigentePEne() {
		return txtFechaVigentePEne;
	}

	public void setTxtFechaVigentePEne(Calendar txtFechaVigentePEne) {
		this.txtFechaVigentePEne = txtFechaVigentePEne;
	}

	public InputText getTxtIdRefe() {
		return txtIdRefe;
	}

	public void setTxtIdRefe(InputText txtIdRefe) {
		this.txtIdRefe = txtIdRefe;
	}

	public List<ReferenciaDTO> getData() {
		try {
			if (data == null) {
				data = businessDelegatorView.getDataReferencia();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public void setData(List<ReferenciaDTO> referenciaDTO) {
		this.data = referenciaDTO;
	}

	public ReferenciaDTO getSelectedReferencia() {
		return selectedReferencia;
	}

	public void setSelectedReferencia(ReferenciaDTO referencia) {
		this.selectedReferencia = referencia;
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

	public SelectOneMenu getEstado() {
		return estado;
	}

	public void setEstado(SelectOneMenu estado) {
		this.estado = estado;
	}

	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcionCorta() {
		return descripcionCorta;
	}

	public void setDescripcionCorta(String descripcionCorta) {
		this.descripcionCorta = descripcionCorta;
	}

	public String getDescripcionTecnica() {
		return descripcionTecnica;
	}

	public void setDescripcionTecnica(String descripcionTecnica) {
		this.descripcionTecnica = descripcionTecnica;
	}

	public String getEquivalente1() {
		return equivalente1;
	}

	public void setEquivalente1(String equivalente1) {
		this.equivalente1 = equivalente1;
	}

	public String getEquivalente2() {
		return equivalente2;
	}

	public void setEquivalente2(String equivalente2) {
		this.equivalente2 = equivalente2;
	}

	public String getEsGarantia() {
		return esGarantia;
	}

	public void setEsGarantia(String esGarantia) {
		this.esGarantia = esGarantia;
	}

	public String getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(String estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public String getGalones() {
		return galones;
	}

	public void setGalones(String galones) {
		this.galones = galones;
	}

	public String getManejaDecimales() {
		return manejaDecimales;
	}

	public void setManejaDecimales(String manejaDecimales) {
		this.manejaDecimales = manejaDecimales;
	}

	public String getManejaLote() {
		return manejaLote;
	}

	public void setManejaLote(String manejaLote) {
		this.manejaLote = manejaLote;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMargenMinimoGBodega() {
		return margenMinimoGBodega;
	}

	public void setMargenMinimoGBodega(String margenMinimoGBodega) {
		this.margenMinimoGBodega = margenMinimoGBodega;
	}

	public String getMargenMinimoGEne() {
		return margenMinimoGEne;
	}

	public void setMargenMinimoGEne(String margenMinimoGEne) {
		this.margenMinimoGEne = margenMinimoGEne;
	}

	public String getMargenMinimoPBodega() {
		return margenMinimoPBodega;
	}

	public void setMargenMinimoPBodega(String margenMinimoPBodega) {
		this.margenMinimoPBodega = margenMinimoPBodega;
	}

	public String getMargenMinimoPEne() {
		return margenMinimoPEne;
	}

	public void setMargenMinimoPEne(String margenMinimoPEne) {
		this.margenMinimoPEne = margenMinimoPEne;
	}

	public String getMargenMinimoRefBodega() {
		return margenMinimoRefBodega;
	}

	public void setMargenMinimoRefBodega(String margenMinimoRefBodega) {
		this.margenMinimoRefBodega = margenMinimoRefBodega;
	}

	public String getMargenMinimoRefEne() {
		return margenMinimoRefEne;
	}

	public void setMargenMinimoRefEne(String margenMinimoRefEne) {
		this.margenMinimoRefEne = margenMinimoRefEne;
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

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getPideCantidad() {
		return pideCantidad;
	}

	public void setPideCantidad(String pideCantidad) {
		this.pideCantidad = pideCantidad;
	}

	public String getPideValor() {
		return pideValor;
	}

	public void setPideValor(String pideValor) {
		this.pideValor = pideValor;
	}

	public String getPorcentajeIva() {
		return porcentajeIva;
	}

	public void setPorcentajeIva(String porcentajeIva) {
		this.porcentajeIva = porcentajeIva;
	}

	public String getProductoConsumo() {
		return productoConsumo;
	}

	public void setProductoConsumo(String productoConsumo) {
		this.productoConsumo = productoConsumo;
	}

	public String getProductoEspecial() {
		return productoEspecial;
	}

	public void setProductoEspecial(String productoEspecial) {
		this.productoEspecial = productoEspecial;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public String getUnidadMedidaProvisional() {
		return unidadMedidaProvisional;
	}

	public void setUnidadMedidaProvisional(String unidadMedidaProvisional) {
		this.unidadMedidaProvisional = unidadMedidaProvisional;
	}

	public String getVolumen() {
		return volumen;
	}

	public void setVolumen(String volumen) {
		this.volumen = volumen;
	}

	public String getIdRefe() {
		return idRefe;
	}

	public void setIdRefe(String idRefe) {
		this.idRefe = idRefe;
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

	public String getFechaVigentePBodega() {
		return fechaVigentePBodega;
	}

	public void setFechaVigentePBodega(String fechaVigentePBodega) {
		this.fechaVigentePBodega = fechaVigentePBodega;
	}

	public String getFechaVigentePEne() {
		return fechaVigentePEne;
	}

	public void setFechaVigentePEne(String fechaVigentePEne) {
		this.fechaVigentePEne = fechaVigentePEne;
	}

	public SelectItem[] getManufacturerOptions() {
		return manufacturerOptions;
	}

	public void setManufacturerOptions(SelectItem[] manufacturerOptions) {
		this.manufacturerOptions = manufacturerOptions;
	}

	public String getQPorCaja() {
		return QPorCaja;
	}

	public void setQPorCaja(String qPorCaja) {
		QPorCaja = qPorCaja;
	}

	public SelectItem[] getManufacturerOptions2() {
		return manufacturerOptions2;
	}

	public void setManufacturerOptions2(SelectItem[] manufacturerOptions2) {
		this.manufacturerOptions2 = manufacturerOptions2;
	}

	public SelectItem[] getManufacturerOptions3() {
		return manufacturerOptions3;
	}

	public void setManufacturerOptions3(SelectItem[] manufacturerOptions3) {
		this.manufacturerOptions3 = manufacturerOptions3;
	}

	public CommandButton getBtnModify2() {
		return btnModify2;
	}

	public void setBtnModify2(CommandButton btnModify2) {
		this.btnModify2 = btnModify2;
	}
}