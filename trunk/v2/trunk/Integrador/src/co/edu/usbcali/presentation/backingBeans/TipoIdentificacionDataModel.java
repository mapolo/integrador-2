package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.TipoIdentificacionDTO;

public class TipoIdentificacionDataModel extends
		ListDataModel<TipoIdentificacionDTO> implements
		SelectableDataModel<TipoIdentificacionDTO> {

	public TipoIdentificacionDataModel() {
	}

	public TipoIdentificacionDataModel(List<TipoIdentificacionDTO> data) {
		super(data);
	}

	@Override
	public TipoIdentificacionDTO getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		List<TipoIdentificacionDTO> uNegocio = (List<TipoIdentificacionDTO>) getWrappedData();

		for (TipoIdentificacionDTO td : uNegocio) {
			if (td.getIdTiid().toString().equals(rowKey))
				return td;
		}

		return null;
	}

	@Override
	public Object getRowKey(TipoIdentificacionDTO td) {
		return td.getIdTiid();
	}

}