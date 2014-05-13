package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.TipoDocumentoDTO;

public class TipoDocumentoDataModel extends ListDataModel<TipoDocumentoDTO>
		implements SelectableDataModel<TipoDocumentoDTO> {

	public TipoDocumentoDataModel() {
	}

	public TipoDocumentoDataModel(List<TipoDocumentoDTO> data) {
		super(data);
	}

	@Override
	public TipoDocumentoDTO getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		List<TipoDocumentoDTO> uNegocio = (List<TipoDocumentoDTO>) getWrappedData();

		for (TipoDocumentoDTO td : uNegocio) {
			if (td.getIdTido().toString().equals(rowKey))
				return td;
		}

		return null;
	}

	@Override
	public Object getRowKey(TipoDocumentoDTO td) {
		return td.getIdTido();
	}

}