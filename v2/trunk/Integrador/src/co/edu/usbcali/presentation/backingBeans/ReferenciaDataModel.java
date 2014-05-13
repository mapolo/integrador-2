package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.ReferenciaDTO;

public class ReferenciaDataModel extends ListDataModel<ReferenciaDTO> implements
		SelectableDataModel<ReferenciaDTO> {

	public ReferenciaDataModel() {
	}

	public ReferenciaDataModel(List<ReferenciaDTO> data) {
		super(data);
	}

	@Override
	public ReferenciaDTO getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		List<ReferenciaDTO> uNegocio = (List<ReferenciaDTO>) getWrappedData();

		for (ReferenciaDTO td : uNegocio) {
			if (td.getIdRefe().toString().equals(rowKey))
				return td;
		}

		return null;
	}

	@Override
	public Object getRowKey(ReferenciaDTO td) {
		return td.getIdRefe();
	}

}