package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.UnidadVenta;
import co.edu.usbcali.modelo.dto.UnidadVentaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IUnidadVentaLogic {
	public List<UnidadVenta> getUnidadVenta() throws Exception;

	/**
	 * Save an new UnidadVenta entity
	 */
	public void saveUnidadVenta(UnidadVenta entity) throws Exception;

	/**
	 * Delete an existing UnidadVenta entity
	 * 
	 */
	public void deleteUnidadVenta(UnidadVenta entity) throws Exception;

	/**
	 * Update an existing UnidadVenta entity
	 * 
	 */
	public void updateUnidadVenta(UnidadVenta entity) throws Exception;

	/**
	 * Load an existing UnidadVenta entity
	 * 
	 */
	public UnidadVenta getUnidadVenta(Long idUnve) throws Exception;

	public List<UnidadVenta> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<UnidadVenta> findPageUnidadVenta(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberUnidadVenta() throws Exception;

	public List<UnidadVentaDTO> getDataUnidadVenta() throws Exception;
}
