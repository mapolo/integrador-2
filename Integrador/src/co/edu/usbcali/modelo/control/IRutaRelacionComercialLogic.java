package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.RutaRelacionComercial;
import co.edu.usbcali.modelo.dto.RutaRelacionComercialDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IRutaRelacionComercialLogic {
	public List<RutaRelacionComercial> getRutaRelacionComercial()
			throws Exception;

	/**
	 * Save an new RutaRelacionComercial entity
	 */
	public void saveRutaRelacionComercial(RutaRelacionComercial entity)
			throws Exception;

	/**
	 * Delete an existing RutaRelacionComercial entity
	 * 
	 */
	public void deleteRutaRelacionComercial(RutaRelacionComercial entity)
			throws Exception;

	/**
	 * Update an existing RutaRelacionComercial entity
	 * 
	 */
	public void updateRutaRelacionComercial(RutaRelacionComercial entity)
			throws Exception;

	/**
	 * Load an existing RutaRelacionComercial entity
	 * 
	 */
	public RutaRelacionComercial getRutaRelacionComercial(Long idRrec)
			throws Exception;

	public List<RutaRelacionComercial> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<RutaRelacionComercial> findPageRutaRelacionComercial(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberRutaRelacionComercial() throws Exception;

	public List<RutaRelacionComercialDTO> getDataRutaRelacionComercial()
			throws Exception;
}
