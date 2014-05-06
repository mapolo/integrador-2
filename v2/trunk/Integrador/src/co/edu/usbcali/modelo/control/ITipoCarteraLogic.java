package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.TipoCartera;
import co.edu.usbcali.modelo.dto.TipoCarteraDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface ITipoCarteraLogic {
	public List<TipoCartera> getTipoCartera() throws Exception;

	/**
	 * Save an new TipoCartera entity
	 */
	public void saveTipoCartera(TipoCartera entity) throws Exception;

	/**
	 * Delete an existing TipoCartera entity
	 * 
	 */
	public void deleteTipoCartera(TipoCartera entity) throws Exception;

	/**
	 * Update an existing TipoCartera entity
	 * 
	 */
	public void updateTipoCartera(TipoCartera entity) throws Exception;

	/**
	 * Load an existing TipoCartera entity
	 * 
	 */
	public TipoCartera getTipoCartera(Long idTica) throws Exception;

	public List<TipoCartera> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<TipoCartera> findPageTipoCartera(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipoCartera() throws Exception;

	public List<TipoCarteraDTO> getDataTipoCartera() throws Exception;
}
