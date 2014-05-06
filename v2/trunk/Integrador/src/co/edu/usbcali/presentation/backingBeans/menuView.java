package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import co.edu.usbcali.modelo.dto.TipoDivisionDTO;

@ManagedBean
@ViewScoped
public class menuView {

	private List<TipoDivisionDTO> data;

	public String pgTiDi() {

		return "tipoDivision.xhtml";
	}

	public String menu() {

		return "menu.xhtml";
	}

	public List<TipoDivisionDTO> getData() {
		return data;
	}

	public void setData(List<TipoDivisionDTO> data) {
		this.data = data;
	}
}