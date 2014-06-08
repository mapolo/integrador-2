package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.Persona;
import co.edu.usbcali.modelo.dto.PersonaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IPersonaLogic {
	public List<Persona> getPersona() throws Exception;

	/**
	 * Save an new Persona entity
	 */
	public void savePersona(Persona entity) throws Exception;

	/**
	 * Delete an existing Persona entity
	 * 
	 */
	public void deletePersona(Persona entity) throws Exception;

	/**
	 * Update an existing Persona entity
	 * 
	 */
	public void updatePersona(Persona entity) throws Exception;

	/**
	 * Load an existing Persona entity
	 * 
	 */
	public Persona getPersona(Long idPers) throws Exception;

	public List<Persona> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Persona> findPagePersona(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberPersona() throws Exception;

	public List<PersonaDTO> getDataPersona() throws Exception;

	public List<Persona> consultarPersonVendedor() throws Exception;

}
