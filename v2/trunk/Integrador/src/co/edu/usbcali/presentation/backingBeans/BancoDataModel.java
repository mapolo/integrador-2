package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import co.edu.usbcali.modelo.dto.BancoDTO;

public class BancoDataModel extends ListDataModel<BancoDTO> implements
		SelectableDataModel<BancoDTO> {

	public BancoDataModel() {
	}

	public BancoDataModel(List<BancoDTO> data) {
		super(data);
	}

	@Override
	public BancoDTO getRowData(String rowKey) {

		@SuppressWarnings("unchecked")
		List<BancoDTO> uNegocio = (List<BancoDTO>) getWrappedData();

		for (BancoDTO td : uNegocio) {
			if (td.getIdBanc().toString().equals(rowKey))
				return td;
		}

		return null;
	}

	@Override
	public Object getRowKey(BancoDTO td) {
		return td.getIdBanc();
	}

}