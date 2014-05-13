package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.TipoSucursalDTO;

public class TipoSucursalDataModel extends ListDataModel<TipoSucursalDTO>
		implements SelectableDataModel<TipoSucursalDTO> {

	public TipoSucursalDataModel() {
	}

	public TipoSucursalDataModel(List<TipoSucursalDTO> data) {
		super(data);
	}

	@Override
	public TipoSucursalDTO getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		List<TipoSucursalDTO> uNegocio = (List<TipoSucursalDTO>) getWrappedData();

		for (TipoSucursalDTO td : uNegocio) {
			if (td.getIdTisu().toString().equals(rowKey))
				return td;
		}

		return null;
	}

	@Override
	public Object getRowKey(TipoSucursalDTO td) {
		return td.getIdTisu();
	}

}