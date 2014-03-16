package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.ClaveFabricacion;
import co.edu.usbcali.modelo.dto.ClaveFabricacionDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IClaveFabricacionLogic {
	public List<ClaveFabricacion> getClaveFabricacion() throws Exception;

	/**
	 * Save an new ClaveFabricacion entity
	 */
	public void saveClaveFabricacion(ClaveFabricacion entity) throws Exception;

	/**
	 * Delete an existing ClaveFabricacion entity
	 * 
	 */
	public void deleteClaveFabricacion(ClaveFabricacion entity)
			throws Exception;

	/**
	 * Update an existing ClaveFabricacion entity
	 * 
	 */
	public void updateClaveFabricacion(ClaveFabricacion entity)
			throws Exception;

	/**
	 * Load an existing ClaveFabricacion entity
	 * 
	 */
	public ClaveFabricacion getClaveFabricacion(Long idClfa) throws Exception;

	public List<ClaveFabricacion> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<ClaveFabricacion> findPageClaveFabricacion(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberClaveFabricacion() throws Exception;

	public List<ClaveFabricacionDTO> getDataClaveFabricacion() throws Exception;
}
