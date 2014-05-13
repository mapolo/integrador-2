package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.ClavesParaRotarDTO;

public class ClavesParaRotarDataModel extends ListDataModel<ClavesParaRotarDTO>
		implements SelectableDataModel<ClavesParaRotarDTO> {

	public ClavesParaRotarDataModel() {
	}

	public ClavesParaRotarDataModel(List<ClavesParaRotarDTO> data) {
		super(data);
	}

	@Override
	public ClavesParaRotarDTO getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		List<ClavesParaRotarDTO> uNegocio = (List<ClavesParaRotarDTO>) getWrappedData();

		for (ClavesParaRotarDTO td : uNegocio) {
			if (td.getIdClpr().toString().equals(rowKey))
				return td;
		}

		return null;
	}

	@Override
	public Object getRowKey(ClavesParaRotarDTO td) {
		return td.getIdClpr();
	}

}