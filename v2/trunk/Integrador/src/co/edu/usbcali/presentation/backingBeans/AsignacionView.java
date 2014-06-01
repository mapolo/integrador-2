package co.edu.usbcali.presentation.backingBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import co.edu.usbcali.modelo.Referencia;
import co.edu.usbcali.presentation.businessDelegate.IBusinessDelegatorView;

@ManagedBean
@ViewScoped
public class AsignacionView {

	private List<Referencia> referencias;

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	public AsignacionView() {

	}

	public List<Referencia> getReferencias() {

		try {
			referencias = new ArrayList<Referencia>();
			referencias = businessDelegatorView.getReferencia();
			System.out.println(referencias.get(0).getCodigo());
		} catch (Exception e) {
			// TODO: handle exception
		}

		return referencias;
	}

	public void setReferencias(List<Referencia> referencias) {
		this.referencias = referencias;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {

		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(
			IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

}
