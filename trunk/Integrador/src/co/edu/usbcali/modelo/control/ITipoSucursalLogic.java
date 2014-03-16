package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.TipoSucursal;
import co.edu.usbcali.modelo.dto.TipoSucursalDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface ITipoSucursalLogic {
	public List<TipoSucursal> getTipoSucursal() throws Exception;

	/**
	 * Save an new TipoSucursal entity
	 */
	public void saveTipoSucursal(TipoSucursal entity) throws Exception;

	/**
	 * Delete an existing TipoSucursal entity
	 * 
	 */
	public void deleteTipoSucursal(TipoSucursal entity) throws Exception;

	/**
	 * Update an existing TipoSucursal entity
	 * 
	 */
	public void updateTipoSucursal(TipoSucursal entity) throws Exception;

	/**
	 * Load an existing TipoSucursal entity
	 * 
	 */
	public TipoSucursal getTipoSucursal(Long idTisu) throws Exception;

	public List<TipoSucursal> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<TipoSucursal> findPageTipoSucursal(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipoSucursal() throws Exception;

	public List<TipoSucursalDTO> getDataTipoSucursal() throws Exception;
}
