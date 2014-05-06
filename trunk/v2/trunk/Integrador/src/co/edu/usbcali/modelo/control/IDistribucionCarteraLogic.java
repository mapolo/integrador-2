package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.DistribucionCartera;
import co.edu.usbcali.modelo.dto.DistribucionCarteraDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IDistribucionCarteraLogic {
	public List<DistribucionCartera> getDistribucionCartera() throws Exception;

	/**
	 * Save an new DistribucionCartera entity
	 */
	public void saveDistribucionCartera(DistribucionCartera entity)
			throws Exception;

	/**
	 * Delete an existing DistribucionCartera entity
	 * 
	 */
	public void deleteDistribucionCartera(DistribucionCartera entity)
			throws Exception;

	/**
	 * Update an existing DistribucionCartera entity
	 * 
	 */
	public void updateDistribucionCartera(DistribucionCartera entity)
			throws Exception;

	/**
	 * Load an existing DistribucionCartera entity
	 * 
	 */
	public DistribucionCartera getDistribucionCartera(Long idDica)
			throws Exception;

	public List<DistribucionCartera> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<DistribucionCartera> findPageDistribucionCartera(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDistribucionCartera() throws Exception;

	public List<DistribucionCarteraDTO> getDataDistribucionCartera()
			throws Exception;
}
