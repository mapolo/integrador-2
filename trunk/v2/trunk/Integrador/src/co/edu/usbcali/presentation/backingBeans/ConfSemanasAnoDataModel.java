package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.ConfSemanasAnoDTO;

public class ConfSemanasAnoDataModel extends ListDataModel<ConfSemanasAnoDTO>
		implements SelectableDataModel<ConfSemanasAnoDTO> {

	public ConfSemanasAnoDataModel() {
	}

	public ConfSemanasAnoDataModel(List<ConfSemanasAnoDTO> data) {
		super(data);
	}

	@Override
	public ConfSemanasAnoDTO getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		List<ConfSemanasAnoDTO> uNegocio = (List<ConfSemanasAnoDTO>) getWrappedData();

		for (ConfSemanasAnoDTO td : uNegocio) {
			if (td.getIdCfsa().toString().equals(rowKey))
				return td;
		}

		return null;
	}

	@Override
	public Object getRowKey(ConfSemanasAnoDTO td) {
		return td.getIdCfsa();
	}

}