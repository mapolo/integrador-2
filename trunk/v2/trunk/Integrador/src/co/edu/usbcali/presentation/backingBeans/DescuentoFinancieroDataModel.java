package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.DescuentoFinancieroDTO;

public class DescuentoFinancieroDataModel extends
		ListDataModel<DescuentoFinancieroDTO> implements
		SelectableDataModel<DescuentoFinancieroDTO> {

	public DescuentoFinancieroDataModel() {
	}

	public DescuentoFinancieroDataModel(List<DescuentoFinancieroDTO> data) {
		super(data);
	}

	@Override
	public DescuentoFinancieroDTO getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		List<DescuentoFinancieroDTO> uNegocio = (List<DescuentoFinancieroDTO>) getWrappedData();

		for (DescuentoFinancieroDTO td : uNegocio) {
			if (td.getIdDefi().toString().equals(rowKey))
				return td;
		}

		return null;
	}

	@Override
	public Object getRowKey(DescuentoFinancieroDTO td) {
		return td.getIdDefi();
	}

}