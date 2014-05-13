package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.TipoCausalDTO;

public class TipoCausalDataModel extends ListDataModel<TipoCausalDTO> implements
		SelectableDataModel<TipoCausalDTO> {

	public TipoCausalDataModel() {
	}

	public TipoCausalDataModel(List<TipoCausalDTO> data) {
		super(data);
	}

	@Override
	public TipoCausalDTO getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		List<TipoCausalDTO> uNegocio = (List<TipoCausalDTO>) getWrappedData();

		for (TipoCausalDTO td : uNegocio) {
			if (td.getIdTcau().toString().equals(rowKey))
				return td;
		}

		return null;
	}

	@Override
	public Object getRowKey(TipoCausalDTO td) {
		return td.getIdTcau();
	}

}