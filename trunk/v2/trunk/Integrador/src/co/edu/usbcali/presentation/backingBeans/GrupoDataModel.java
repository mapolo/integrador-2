package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.GrupoDTO;

public class GrupoDataModel extends ListDataModel<GrupoDTO> implements
		SelectableDataModel<GrupoDTO> {

	public GrupoDataModel() {
	}

	public GrupoDataModel(List<GrupoDTO> data) {
		super(data);
	}

	@Override
	public GrupoDTO getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		List<GrupoDTO> uNegocio = (List<GrupoDTO>) getWrappedData();

		for (GrupoDTO td : uNegocio) {
			if (td.getIdGrpo().toString().equals(rowKey))
				return td;
		}

		return null;
	}

	@Override
	public Object getRowKey(GrupoDTO td) {
		return td.getIdGrpo();
	}

}