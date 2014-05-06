package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.TipoDivision;
import co.edu.usbcali.modelo.dto.TipoDivisionDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface ITipoDivisionLogic {
	public List<TipoDivision> getTipoDivision() throws Exception;

	/**
	 * Save an new TipoDivision entity
	 */
	public void saveTipoDivision(TipoDivision entity) throws Exception;

	/**
	 * Delete an existing TipoDivision entity
	 * 
	 */
	public void deleteTipoDivision(TipoDivision entity) throws Exception;

	/**
	 * Update an existing TipoDivision entity
	 * 
	 */
	public void updateTipoDivision(TipoDivision entity) throws Exception;

	/**
	 * Load an existing TipoDivision entity
	 * 
	 */
	public TipoDivision getTipoDivision(Long idTidi) throws Exception;

	public List<TipoDivision> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<TipoDivision> findPageTipoDivision(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipoDivision() throws Exception;

	public List<TipoDivisionDTO> getDataTipoDivision() throws Exception;
}
