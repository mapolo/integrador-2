package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.Contacto;
import co.edu.usbcali.modelo.dto.ContactoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IContactoLogic {
	public List<Contacto> getContacto() throws Exception;

	/**
	 * Save an new Contacto entity
	 */
	public void saveContacto(Contacto entity) throws Exception;

	/**
	 * Delete an existing Contacto entity
	 * 
	 */
	public void deleteContacto(Contacto entity) throws Exception;

	/**
	 * Update an existing Contacto entity
	 * 
	 */
	public void updateContacto(Contacto entity) throws Exception;

	/**
	 * Load an existing Contacto entity
	 * 
	 */
	public Contacto getContacto(Long idCont) throws Exception;

	public List<Contacto> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Contacto> findPageContacto(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberContacto() throws Exception;

	public List<ContactoDTO> getDataContacto() throws Exception;
}
