package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.ReferenciaSucursal;
import co.edu.usbcali.modelo.dto.ReferenciaSucursalDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IReferenciaSucursalLogic {
	public List<ReferenciaSucursal> getReferenciaSucursal() throws Exception;

	/**
	 * Save an new ReferenciaSucursal entity
	 */
	public void saveReferenciaSucursal(ReferenciaSucursal entity)
			throws Exception;

	/**
	 * Delete an existing ReferenciaSucursal entity
	 * 
	 */
	public void deleteReferenciaSucursal(ReferenciaSucursal entity)
			throws Exception;

	/**
	 * Update an existing ReferenciaSucursal entity
	 * 
	 */
	public void updateReferenciaSucursal(ReferenciaSucursal entity)
			throws Exception;

	/**
	 * Load an existing ReferenciaSucursal entity
	 * 
	 */
	public ReferenciaSucursal getReferenciaSucursal(Long idResu)
			throws Exception;

	public List<ReferenciaSucursal> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<ReferenciaSucursal> findPageReferenciaSucursal(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberReferenciaSucursal() throws Exception;

	public List<ReferenciaSucursalDTO> getDataReferenciaSucursal()
			throws Exception;
}
