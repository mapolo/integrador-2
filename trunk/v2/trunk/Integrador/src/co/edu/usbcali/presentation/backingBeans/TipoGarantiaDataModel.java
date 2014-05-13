package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.TipoGarantiaDTO;

public class TipoGarantiaDataModel extends ListDataModel<TipoGarantiaDTO>
		implements SelectableDataModel<TipoGarantiaDTO> {

	public TipoGarantiaDataModel() {
	}

	public TipoGarantiaDataModel(List<TipoGarantiaDTO> data) {
		super(data);
	}

	@Override
	public TipoGarantiaDTO getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		List<TipoGarantiaDTO> uNegocio = (List<TipoGarantiaDTO>) getWrappedData();

		for (TipoGarantiaDTO td : uNegocio) {
			if (td.getIdTiga().toString().equals(rowKey))
				return td;
		}

		return null;
	}

	@Override
	public Object getRowKey(TipoGarantiaDTO td) {
		return td.getIdTiga();
	}

}