package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.TipoCarteraDTO;

public class TipoCarteraDataModel extends ListDataModel<TipoCarteraDTO>
		implements SelectableDataModel<TipoCarteraDTO> {

	public TipoCarteraDataModel() {
	}

	public TipoCarteraDataModel(List<TipoCarteraDTO> data) {
		super(data);
	}

	@Override
	public TipoCarteraDTO getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		List<TipoCarteraDTO> uNegocio = (List<TipoCarteraDTO>) getWrappedData();

		for (TipoCarteraDTO td : uNegocio) {
			if (td.getIdTica().toString().equals(rowKey))
				return td;
		}

		return null;
	}

	@Override
	public Object getRowKey(TipoCarteraDTO td) {
		return td.getIdTica();
	}

}