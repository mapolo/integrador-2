package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.SucursalDTO;

public class SucursalDataModel extends ListDataModel<SucursalDTO> implements
		SelectableDataModel<SucursalDTO> {

	public SucursalDataModel() {
	}

	public SucursalDataModel(List<SucursalDTO> data) {
		super(data);
	}

	@Override
	public SucursalDTO getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		List<SucursalDTO> uNegocio = (List<SucursalDTO>) getWrappedData();

		for (SucursalDTO td : uNegocio) {
			if (td.getIdSucu().toString().equals(rowKey))
				return td;
		}

		return null;
	}

	@Override
	public Object getRowKey(SucursalDTO td) {
		return td.getIdSucu();
	}

}