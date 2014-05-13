package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.ListaPreciosDTO;

public class ListaPreciosDataModel extends ListDataModel<ListaPreciosDTO>
		implements SelectableDataModel<ListaPreciosDTO> {

	public ListaPreciosDataModel() {
	}

	public ListaPreciosDataModel(List<ListaPreciosDTO> data) {
		super(data);
	}

	@Override
	public ListaPreciosDTO getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		List<ListaPreciosDTO> uNegocio = (List<ListaPreciosDTO>) getWrappedData();

		for (ListaPreciosDTO td : uNegocio) {
			if (td.getIdLipr().toString().equals(rowKey))
				return td;
		}

		return null;
	}

	@Override
	public Object getRowKey(ListaPreciosDTO td) {
		return td.getIdLipr();
	}

}