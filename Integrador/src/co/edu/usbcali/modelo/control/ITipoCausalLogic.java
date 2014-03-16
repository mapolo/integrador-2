package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.TipoCausal;
import co.edu.usbcali.modelo.dto.TipoCausalDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface ITipoCausalLogic {
	public List<TipoCausal> getTipoCausal() throws Exception;

	/**
	 * Save an new TipoCausal entity
	 */
	public void saveTipoCausal(TipoCausal entity) throws Exception;

	/**
	 * Delete an existing TipoCausal entity
	 * 
	 */
	public void deleteTipoCausal(TipoCausal entity) throws Exception;

	/**
	 * Update an existing TipoCausal entity
	 * 
	 */
	public void updateTipoCausal(TipoCausal entity) throws Exception;

	/**
	 * Load an existing TipoCausal entity
	 * 
	 */
	public TipoCausal getTipoCausal(Long idTcau) throws Exception;

	public List<TipoCausal> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<TipoCausal> findPageTipoCausal(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipoCausal() throws Exception;

	public List<TipoCausalDTO> getDataTipoCausal() throws Exception;
}
