package co.edu.usbcali.presentation.backingBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.inputtext.InputText;

import co.edu.usbcali.modelo.dto.TipoDivisionDTO;

@ManagedBean
@ViewScoped
public class LoginIntroView {

	private InputText txtLogin;
	private List<TipoDivisionDTO> data;

	private String login;
	private String password;

	/*
	 * public void introLogin(org.primefaces.event.RowEditEvent event) {
	 * 
	 * System.out.println("entro login" + login);
	 * 
	 * login = ((LoginDTO)event.getObject()).getLogin();
	 * 
	 * 
	 * }
	 */

	public String pgMenu() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put("Usuario", login);
		System.out.println("Login User " + login);
		return "menu.xhtml";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public InputText getTxtLogin() {
		return txtLogin;
	}

	public void setTxtLogin(InputText txtLogin) {
		this.txtLogin = txtLogin;
	}

	public List<TipoDivisionDTO> getData() {
		return data;
	}

	public void setData(List<TipoDivisionDTO> data) {
		this.data = data;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
