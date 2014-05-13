package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.TipoDivisionDTO;

public class TipoDivisionDataModel extends ListDataModel<TipoDivisionDTO>
		implements SelectableDataModel<TipoDivisionDTO> {

	public TipoDivisionDataModel() {
	}

	public TipoDivisionDataModel(List<TipoDivisionDTO> data) {
		super(data);
	}

	@Override
	public TipoDivisionDTO getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		List<TipoDivisionDTO> uNegocio = (List<TipoDivisionDTO>) getWrappedData();

		for (TipoDivisionDTO td : uNegocio) {
			if (td.getIdTidi().toString().equals(rowKey))
				return td;
		}

		return null;
	}

	@Override
	public Object getRowKey(TipoDivisionDTO td) {
		return td.getIdTidi();
	}

}