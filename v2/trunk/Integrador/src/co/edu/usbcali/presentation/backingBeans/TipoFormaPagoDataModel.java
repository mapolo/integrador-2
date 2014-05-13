package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.TipoFormaPagoDTO;

public class TipoFormaPagoDataModel extends ListDataModel<TipoFormaPagoDTO>
		implements SelectableDataModel<TipoFormaPagoDTO> {

	public TipoFormaPagoDataModel() {
	}

	public TipoFormaPagoDataModel(List<TipoFormaPagoDTO> data) {
		super(data);
	}

	@Override
	public TipoFormaPagoDTO getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		List<TipoFormaPagoDTO> uNegocio = (List<TipoFormaPagoDTO>) getWrappedData();

		for (TipoFormaPagoDTO td : uNegocio) {
			if (td.getIdTfpa().toString().equals(rowKey))
				return td;
		}

		return null;
	}

	@Override
	public Object getRowKey(TipoFormaPagoDTO td) {
		return td.getIdTfpa();
	}

}