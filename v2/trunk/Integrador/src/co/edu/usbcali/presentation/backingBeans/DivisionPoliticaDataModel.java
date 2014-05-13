package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.DivisionPoliticaDTO;

public class DivisionPoliticaDataModel extends
		ListDataModel<DivisionPoliticaDTO> implements
		SelectableDataModel<DivisionPoliticaDTO> {

	public DivisionPoliticaDataModel() {
	}

	public DivisionPoliticaDataModel(List<DivisionPoliticaDTO> data) {
		super(data);
	}

	@Override
	public DivisionPoliticaDTO getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		List<DivisionPoliticaDTO> uNegocio = (List<DivisionPoliticaDTO>) getWrappedData();

		for (DivisionPoliticaDTO td : uNegocio) {
			if (td.getIdDipo().toString().equals(rowKey))
				return td;
		}

		return null;
	}

	@Override
	public Object getRowKey(DivisionPoliticaDTO td) {
		return td.getIdDipo();
	}

}