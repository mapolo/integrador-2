package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.RegionalGeograficaDTO;

public class RegionalGeograficaDataModel extends
		ListDataModel<RegionalGeograficaDTO> implements
		SelectableDataModel<RegionalGeograficaDTO> {

	public RegionalGeograficaDataModel() {
	}

	public RegionalGeograficaDataModel(List<RegionalGeograficaDTO> data) {
		super(data);
	}

	@Override
	public RegionalGeograficaDTO getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		List<RegionalGeograficaDTO> uNegocio = (List<RegionalGeograficaDTO>) getWrappedData();

		for (RegionalGeograficaDTO td : uNegocio) {
			if (td.getIdRege().toString().equals(rowKey))
				return td;
		}

		return null;
	}

	@Override
	public Object getRowKey(RegionalGeograficaDTO td) {
		return td.getIdRege();
	}

}
