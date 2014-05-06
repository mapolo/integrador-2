package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.RutaDistribucion;
import co.edu.usbcali.modelo.dto.RutaDistribucionDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IRutaDistribucionLogic {
	public List<RutaDistribucion> getRutaDistribucion() throws Exception;

	/**
	 * Save an new RutaDistribucion entity
	 */
	public void saveRutaDistribucion(RutaDistribucion entity) throws Exception;

	/**
	 * Delete an existing RutaDistribucion entity
	 * 
	 */
	public void deleteRutaDistribucion(RutaDistribucion entity)
			throws Exception;

	/**
	 * Update an existing RutaDistribucion entity
	 * 
	 */
	public void updateRutaDistribucion(RutaDistribucion entity)
			throws Exception;

	/**
	 * Load an existing RutaDistribucion entity
	 * 
	 */
	public RutaDistribucion getRutaDistribucion(Long idRudi) throws Exception;

	public List<RutaDistribucion> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<RutaDistribucion> findPageRutaDistribucion(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberRutaDistribucion() throws Exception;

	public List<RutaDistribucionDTO> getDataRutaDistribucion() throws Exception;
}
