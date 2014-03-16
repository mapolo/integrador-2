package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.CamposParametrizables;
import co.edu.usbcali.modelo.dto.CamposParametrizablesDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface ICamposParametrizablesLogic {
	public List<CamposParametrizables> getCamposParametrizables()
			throws Exception;

	/**
	 * Save an new CamposParametrizables entity
	 */
	public void saveCamposParametrizables(CamposParametrizables entity)
			throws Exception;

	/**
	 * Delete an existing CamposParametrizables entity
	 * 
	 */
	public void deleteCamposParametrizables(CamposParametrizables entity)
			throws Exception;

	/**
	 * Update an existing CamposParametrizables entity
	 * 
	 */
	public void updateCamposParametrizables(CamposParametrizables entity)
			throws Exception;

	/**
	 * Load an existing CamposParametrizables entity
	 * 
	 */
	public CamposParametrizables getCamposParametrizables(Long idCapa)
			throws Exception;

	public List<CamposParametrizables> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<CamposParametrizables> findPageCamposParametrizables(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberCamposParametrizables() throws Exception;

	public List<CamposParametrizablesDTO> getDataCamposParametrizables()
			throws Exception;
}
