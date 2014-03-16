package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.Cruce;
import co.edu.usbcali.modelo.dto.CruceDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface ICruceLogic {
	public List<Cruce> getCruce() throws Exception;

	/**
	 * Save an new Cruce entity
	 */
	public void saveCruce(Cruce entity) throws Exception;

	/**
	 * Delete an existing Cruce entity
	 * 
	 */
	public void deleteCruce(Cruce entity) throws Exception;

	/**
	 * Update an existing Cruce entity
	 * 
	 */
	public void updateCruce(Cruce entity) throws Exception;

	/**
	 * Load an existing Cruce entity
	 * 
	 */
	public Cruce getCruce(Long idCrce) throws Exception;

	public List<Cruce> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Cruce> findPageCruce(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberCruce() throws Exception;

	public List<CruceDTO> getDataCruce() throws Exception;
}
