package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.ListaPreciosEspecialesDTO;

public class ListaPreciosEspecialesDataModel extends
		ListDataModel<ListaPreciosEspecialesDTO> implements
		SelectableDataModel<ListaPreciosEspecialesDTO> {

	public ListaPreciosEspecialesDataModel() {
	}

	public ListaPreciosEspecialesDataModel(List<ListaPreciosEspecialesDTO> data) {
		super(data);
	}

	@Override
	public ListaPreciosEspecialesDTO getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		List<ListaPreciosEspecialesDTO> uNegocio = (List<ListaPreciosEspecialesDTO>) getWrappedData();

		for (ListaPreciosEspecialesDTO td : uNegocio) {
			if (td.getIdLipe().toString().equals(rowKey))
				return td;
		}

		return null;
	}

	@Override
	public Object getRowKey(ListaPreciosEspecialesDTO td) {
		return td.getIdLipe();
	}

}