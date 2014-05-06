package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.Causal;
import co.edu.usbcali.modelo.dto.CausalDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface ICausalLogic {
	public List<Causal> getCausal() throws Exception;

	/**
	 * Save an new Causal entity
	 */
	public void saveCausal(Causal entity) throws Exception;

	/**
	 * Delete an existing Causal entity
	 * 
	 */
	public void deleteCausal(Causal entity) throws Exception;

	/**
	 * Update an existing Causal entity
	 * 
	 */
	public void updateCausal(Causal entity) throws Exception;

	/**
	 * Load an existing Causal entity
	 * 
	 */
	public Causal getCausal(Long idCusa) throws Exception;

	public List<Causal> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Causal> findPageCausal(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberCausal() throws Exception;

	public List<CausalDTO> getDataCausal() throws Exception;
}
