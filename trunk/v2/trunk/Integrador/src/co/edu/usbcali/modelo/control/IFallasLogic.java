package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.Fallas;
import co.edu.usbcali.modelo.dto.FallasDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IFallasLogic {
	public List<Fallas> getFallas() throws Exception;

	/**
	 * Save an new Fallas entity
	 */
	public void saveFallas(Fallas entity) throws Exception;

	/**
	 * Delete an existing Fallas entity
	 * 
	 */
	public void deleteFallas(Fallas entity) throws Exception;

	/**
	 * Update an existing Fallas entity
	 * 
	 */
	public void updateFallas(Fallas entity) throws Exception;

	/**
	 * Load an existing Fallas entity
	 * 
	 */
	public Fallas getFallas(Long idCfal) throws Exception;

	public List<Fallas> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Fallas> findPageFallas(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberFallas() throws Exception;

	public List<FallasDTO> getDataFallas() throws Exception;
}
