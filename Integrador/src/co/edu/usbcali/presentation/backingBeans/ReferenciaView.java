package co.edu.usbcali.presentation.backingBeans;

import co.edu.usbcali.exceptions.*;
import co.edu.usbcali.modelo.*;
import co.edu.usbcali.modelo.dto.ReferenciaDTO;
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
public class ReferenciaView {
	private InputText txtQPorCaja;
	private InputText txtAplicacion;
	private InputText txtCodigo;
	private InputText txtCodigoBarras;
	private InputText txtCosto;
	private InputText txtDescripcion;
	private InputText txtDescripcionCorta;
	private InputText txtDescripcionTecnica;
	private InputText txtEquivalente1;
	private InputText txtEquivalente2;
	private InputText txtEsGarantia;
	private InputText txtEstadoRegistro;
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
	private InputText txtPideCantidad;
	private InputText txtPideValor;
	private InputText txtPorcentajeIva;
	private InputText txtProductoConsumo;
	private InputText txtProductoEspecial;
	private InputText txtUnidadMedida;
	private InputText txtUnidadMedidaProvisional;
	private InputText txtVolumen;
	private InputText txtIdRefe;
	private Calendar txtFechaCreacion;
	private Calendar txtFechaModificacion;
	private Calendar txtFechaVigentePBodega;
	private Calendar txtFechaVigentePEne;
	private CommandButton btnSave;
	private CommandButton btnModify;
	private CommandButton btnDelete;
	private CommandButton btnClear;
	private List<ReferenciaDTO> data;
	private ReferenciaDTO selectedReferencia;
	private Referencia entity;
	private boolean showDialog;
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public ReferenciaView() {
		super();
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
				txtDescripcion = new InputText();
			}

			txtDescripcion.setValue(referenciaDTO.getDescripcion());

			if (txtDescripcionCorta == null) {
				txtDescripcionCorta = new InputText();
			}

			txtDescripcionCorta.setValue(referenciaDTO.getDescripcionCorta());

			if (txtDescripcionTecnica == null) {
				txtDescripcionTecnica = new InputText();
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
				txtEsGarantia = new InputText();
			}

			txtEsGarantia.setValue(referenciaDTO.getEsGarantia());

			if (txtEstadoRegistro == null) {
				txtEstadoRegistro = new InputText();
			}

			txtEstadoRegistro.setValue(referenciaDTO.getEstadoRegistro());

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
				txtPideCantidad = new InputText();
			}

			txtPideCantidad.setValue(referenciaDTO.getPideCantidad());

			if (txtPideValor == null) {
				txtPideValor = new InputText();
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
				txtFechaCreacion = new Calendar();
			}

			txtFechaCreacion.setValue(referenciaDTO.getFechaCreacion());

			if (txtFechaModificacion == null) {
				txtFechaModificacion = new Calendar();
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
			txtQPorCaja.setDisabled(true);
		}

		if (txtAplicacion != null) {
			txtAplicacion.setValue(null);
			txtAplicacion.setDisabled(true);
		}

		if (txtCodigo != null) {
			txtCodigo.setValue(null);
			txtCodigo.setDisabled(true);
		}

		if (txtCodigoBarras != null) {
			txtCodigoBarras.setValue(null);
			txtCodigoBarras.setDisabled(true);
		}

		if (txtCosto != null) {
			txtCosto.setValue(null);
			txtCosto.setDisabled(true);
		}

		if (txtDescripcion != null) {
			txtDescripcion.setValue(null);
			txtDescripcion.setDisabled(true);
		}

		if (txtDescripcionCorta != null) {
			txtDescripcionCorta.setValue(null);
			txtDescripcionCorta.setDisabled(true);
		}

		if (txtDescripcionTecnica != null) {
			txtDescripcionTecnica.setValue(null);
			txtDescripcionTecnica.setDisabled(true);
		}

		if (txtEquivalente1 != null) {
			txtEquivalente1.setValue(null);
			txtEquivalente1.setDisabled(true);
		}

		if (txtEquivalente2 != null) {
			txtEquivalente2.setValue(null);
			txtEquivalente2.setDisabled(true);
		}

		if (txtEsGarantia != null) {
			txtEsGarantia.setValue(null);
			txtEsGarantia.setDisabled(true);
		}

		if (txtEstadoRegistro != null) {
			txtEstadoRegistro.setValue(null);
			txtEstadoRegistro.setDisabled(true);
		}

		if (txtGalones != null) {
			txtGalones.setValue(null);
			txtGalones.setDisabled(true);
		}

		if (txtManejaDecimales != null) {
			txtManejaDecimales.setValue(null);
			txtManejaDecimales.setDisabled(true);
		}

		if (txtManejaLote != null) {
			txtManejaLote.setValue(null);
			txtManejaLote.setDisabled(true);
		}

		if (txtMarca != null) {
			txtMarca.setValue(null);
			txtMarca.setDisabled(true);
		}

		if (txtMargenMinimoGBodega != null) {
			txtMargenMinimoGBodega.setValue(null);
			txtMargenMinimoGBodega.setDisabled(true);
		}

		if (txtMargenMinimoGEne != null) {
			txtMargenMinimoGEne.setValue(null);
			txtMargenMinimoGEne.setDisabled(true);
		}

		if (txtMargenMinimoPBodega != null) {
			txtMargenMinimoPBodega.setValue(null);
			txtMargenMinimoPBodega.setDisabled(true);
		}

		if (txtMargenMinimoPEne != null) {
			txtMargenMinimoPEne.setValue(null);
			txtMargenMinimoPEne.setDisabled(true);
		}

		if (txtMargenMinimoRefBodega != null) {
			txtMargenMinimoRefBodega.setValue(null);
			txtMargenMinimoRefBodega.setDisabled(true);
		}

		if (txtMargenMinimoRefEne != null) {
			txtMargenMinimoRefEne.setValue(null);
			txtMargenMinimoRefEne.setDisabled(true);
		}

		if (txtOperCreador != null) {
			txtOperCreador.setValue(null);
			txtOperCreador.setDisabled(true);
		}

		if (txtOperModifica != null) {
			txtOperModifica.setValue(null);
			txtOperModifica.setDisabled(true);
		}

		if (txtPeso != null) {
			txtPeso.setValue(null);
			txtPeso.setDisabled(true);
		}

		if (txtPideCantidad != null) {
			txtPideCantidad.setValue(null);
			txtPideCantidad.setDisabled(true);
		}

		if (txtPideValor != null) {
			txtPideValor.setValue(null);
			txtPideValor.setDisabled(true);
		}

		if (txtPorcentajeIva != null) {
			txtPorcentajeIva.setValue(null);
			txtPorcentajeIva.setDisabled(true);
		}

		if (txtProductoConsumo != null) {
			txtProductoConsumo.setValue(null);
			txtProductoConsumo.setDisabled(true);
		}

		if (txtProductoEspecial != null) {
			txtProductoEspecial.setValue(null);
			txtProductoEspecial.setDisabled(true);
		}

		if (txtUnidadMedida != null) {
			txtUnidadMedida.setValue(null);
			txtUnidadMedida.setDisabled(true);
		}

		if (txtUnidadMedidaProvisional != null) {
			txtUnidadMedidaProvisional.setValue(null);
			txtUnidadMedidaProvisional.setDisabled(true);
		}

		if (txtVolumen != null) {
			txtVolumen.setValue(null);
			txtVolumen.setDisabled(true);
		}

		if (txtFechaCreacion != null) {
			txtFechaCreacion.setValue(null);
			txtFechaCreacion.setDisabled(true);
		}

		if (txtFechaModificacion != null) {
			txtFechaModificacion.setValue(null);
			txtFechaModificacion.setDisabled(true);
		}

		if (txtFechaVigentePBodega != null) {
			txtFechaVigentePBodega.setValue(null);
			txtFechaVigentePBodega.setDisabled(true);
		}

		if (txtFechaVigentePEne != null) {
			txtFechaVigentePEne.setValue(null);
			txtFechaVigentePEne.setDisabled(true);
		}

		if (txtIdRefe != null) {
			txtIdRefe.setValue(null);
			txtIdRefe.setDisabled(false);
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
			// TODO: handle exception
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
			txtEstadoRegistro.setDisabled(false);
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
			txtEstadoRegistro.setValue(entity.getEstadoRegistro());
			txtEstadoRegistro.setDisabled(false);
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
		txtEstadoRegistro.setValue(selectedReferencia.getEstadoRegistro());
		txtEstadoRegistro.setDisabled(false);
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

			Long idRefe = new Long(txtIdRefe.getValue().toString());

			entity.setQPorCaja(FacesUtils.checkLong(txtQPorCaja));
			entity.setAplicacion(FacesUtils.checkString(txtAplicacion));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCodigoBarras(FacesUtils.checkString(txtCodigoBarras));
			entity.setCosto(FacesUtils.checkDouble(txtCosto));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			entity.setDescripcionCorta(FacesUtils
					.checkString(txtDescripcionCorta));
			entity.setDescripcionTecnica(FacesUtils
					.checkString(txtDescripcionTecnica));
			entity.setEquivalente1(FacesUtils.checkString(txtEquivalente1));
			entity.setEquivalente2(FacesUtils.checkString(txtEquivalente2));
			entity.setEsGarantia(FacesUtils.checkString(txtEsGarantia));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaVigentePBodega(FacesUtils
					.checkDate(txtFechaVigentePBodega));
			entity.setFechaVigentePEne(FacesUtils
					.checkDate(txtFechaVigentePEne));
			entity.setGalones(FacesUtils.checkDouble(txtGalones));
			entity.setIdRefe(idRefe);
			entity.setManejaDecimales(FacesUtils.checkLong(txtManejaDecimales));
			entity.setManejaLote(FacesUtils.checkLong(txtManejaLote));
			entity.setMarca(FacesUtils.checkString(txtMarca));
			entity.setMargenMinimoGBodega(FacesUtils
					.checkLong(txtMargenMinimoGBodega));
			entity.setMargenMinimoGEne(FacesUtils
					.checkLong(txtMargenMinimoGEne));
			entity.setMargenMinimoPBodega(FacesUtils
					.checkLong(txtMargenMinimoPBodega));
			entity.setMargenMinimoPEne(FacesUtils
					.checkLong(txtMargenMinimoPEne));
			entity.setMargenMinimoRefBodega(FacesUtils
					.checkLong(txtMargenMinimoRefBodega));
			entity.setMargenMinimoRefEne(FacesUtils
					.checkLong(txtMargenMinimoRefEne));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setPeso(FacesUtils.checkDouble(txtPeso));
			entity.setPideCantidad(FacesUtils.checkString(txtPideCantidad));
			entity.setPideValor(FacesUtils.checkString(txtPideValor));
			entity.setPorcentajeIva(FacesUtils.checkDouble(txtPorcentajeIva));
			entity.setProductoConsumo(FacesUtils.checkLong(txtProductoConsumo));
			entity.setProductoEspecial(FacesUtils
					.checkLong(txtProductoEspecial));
			entity.setUnidadMedida(FacesUtils.checkString(txtUnidadMedida));
			entity.setUnidadMedidaProvisional(FacesUtils
					.checkString(txtUnidadMedidaProvisional));
			entity.setVolumen(FacesUtils.checkDouble(txtVolumen));
			businessDelegatorView.saveReferencia(entity);
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

			entity.setQPorCaja(FacesUtils.checkLong(txtQPorCaja));
			entity.setAplicacion(FacesUtils.checkString(txtAplicacion));
			entity.setCodigo(FacesUtils.checkString(txtCodigo));
			entity.setCodigoBarras(FacesUtils.checkString(txtCodigoBarras));
			entity.setCosto(FacesUtils.checkDouble(txtCosto));
			entity.setDescripcion(FacesUtils.checkString(txtDescripcion));
			entity.setDescripcionCorta(FacesUtils
					.checkString(txtDescripcionCorta));
			entity.setDescripcionTecnica(FacesUtils
					.checkString(txtDescripcionTecnica));
			entity.setEquivalente1(FacesUtils.checkString(txtEquivalente1));
			entity.setEquivalente2(FacesUtils.checkString(txtEquivalente2));
			entity.setEsGarantia(FacesUtils.checkString(txtEsGarantia));
			entity.setEstadoRegistro(FacesUtils.checkString(txtEstadoRegistro));
			entity.setFechaCreacion(FacesUtils.checkDate(txtFechaCreacion));
			entity.setFechaModificacion(FacesUtils
					.checkDate(txtFechaModificacion));
			entity.setFechaVigentePBodega(FacesUtils
					.checkDate(txtFechaVigentePBodega));
			entity.setFechaVigentePEne(FacesUtils
					.checkDate(txtFechaVigentePEne));
			entity.setGalones(FacesUtils.checkDouble(txtGalones));
			entity.setManejaDecimales(FacesUtils.checkLong(txtManejaDecimales));
			entity.setManejaLote(FacesUtils.checkLong(txtManejaLote));
			entity.setMarca(FacesUtils.checkString(txtMarca));
			entity.setMargenMinimoGBodega(FacesUtils
					.checkLong(txtMargenMinimoGBodega));
			entity.setMargenMinimoGEne(FacesUtils
					.checkLong(txtMargenMinimoGEne));
			entity.setMargenMinimoPBodega(FacesUtils
					.checkLong(txtMargenMinimoPBodega));
			entity.setMargenMinimoPEne(FacesUtils
					.checkLong(txtMargenMinimoPEne));
			entity.setMargenMinimoRefBodega(FacesUtils
					.checkLong(txtMargenMinimoRefBodega));
			entity.setMargenMinimoRefEne(FacesUtils
					.checkLong(txtMargenMinimoRefEne));
			entity.setOperCreador(FacesUtils.checkString(txtOperCreador));
			entity.setOperModifica(FacesUtils.checkString(txtOperModifica));
			entity.setPeso(FacesUtils.checkDouble(txtPeso));
			entity.setPideCantidad(FacesUtils.checkString(txtPideCantidad));
			entity.setPideValor(FacesUtils.checkString(txtPideValor));
			entity.setPorcentajeIva(FacesUtils.checkDouble(txtPorcentajeIva));
			entity.setProductoConsumo(FacesUtils.checkLong(txtProductoConsumo));
			entity.setProductoEspecial(FacesUtils
					.checkLong(txtProductoEspecial));
			entity.setUnidadMedida(FacesUtils.checkString(txtUnidadMedida));
			entity.setUnidadMedidaProvisional(FacesUtils
					.checkString(txtUnidadMedidaProvisional));
			entity.setVolumen(FacesUtils.checkDouble(txtVolumen));
			businessDelegatorView.updateReferencia(entity);
			FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
		} catch (Exception e) {
			data = null;
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

	public InputText getTxtDescripcion() {
		return txtDescripcion;
	}

	public void setTxtDescripcion(InputText txtDescripcion) {
		this.txtDescripcion = txtDescripcion;
	}

	public InputText getTxtDescripcionCorta() {
		return txtDescripcionCorta;
	}

	public void setTxtDescripcionCorta(InputText txtDescripcionCorta) {
		this.txtDescripcionCorta = txtDescripcionCorta;
	}

	public InputText getTxtDescripcionTecnica() {
		return txtDescripcionTecnica;
	}

	public void setTxtDescripcionTecnica(InputText txtDescripcionTecnica) {
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

	public InputText getTxtEsGarantia() {
		return txtEsGarantia;
	}

	public void setTxtEsGarantia(InputText txtEsGarantia) {
		this.txtEsGarantia = txtEsGarantia;
	}

	public InputText getTxtEstadoRegistro() {
		return txtEstadoRegistro;
	}

	public void setTxtEstadoRegistro(InputText txtEstadoRegistro) {
		this.txtEstadoRegistro = txtEstadoRegistro;
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

	public InputText getTxtPideCantidad() {
		return txtPideCantidad;
	}

	public void setTxtPideCantidad(InputText txtPideCantidad) {
		this.txtPideCantidad = txtPideCantidad;
	}

	public InputText getTxtPideValor() {
		return txtPideValor;
	}

	public void setTxtPideValor(InputText txtPideValor) {
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
}
