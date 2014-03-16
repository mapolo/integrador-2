package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.RegionalGeografica;
import co.edu.usbcali.modelo.dto.RegionalGeograficaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IRegionalGeograficaLogic {
	public List<RegionalGeografica> getRegionalGeografica() throws Exception;

	/**
	 * Save an new RegionalGeografica entity
	 */
	public void saveRegionalGeografica(RegionalGeografica entity)
			throws Exception;

	/**
	 * Delete an existing RegionalGeografica entity
	 * 
	 */
	public void deleteRegionalGeografica(RegionalGeografica entity)
			throws Exception;

	/**
	 * Update an existing RegionalGeografica entity
	 * 
	 */
	public void updateRegionalGeografica(RegionalGeografica entity)
			throws Exception;

	/**
	 * Load an existing RegionalGeografica entity
	 * 
	 */
	public RegionalGeografica getRegionalGeografica(Long idRege)
			throws Exception;

	public List<RegionalGeografica> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<RegionalGeografica> findPageRegionalGeografica(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberRegionalGeografica() throws Exception;

	public List<RegionalGeograficaDTO> getDataRegionalGeografica()
			throws Exception;
}
