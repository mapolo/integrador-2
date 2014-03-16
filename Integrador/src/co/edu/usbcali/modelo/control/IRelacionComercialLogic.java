package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.RelacionComercial;
import co.edu.usbcali.modelo.dto.RelacionComercialDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IRelacionComercialLogic {
	public List<RelacionComercial> getRelacionComercial() throws Exception;

	/**
	 * Save an new RelacionComercial entity
	 */
	public void saveRelacionComercial(RelacionComercial entity)
			throws Exception;

	/**
	 * Delete an existing RelacionComercial entity
	 * 
	 */
	public void deleteRelacionComercial(RelacionComercial entity)
			throws Exception;

	/**
	 * Update an existing RelacionComercial entity
	 * 
	 */
	public void updateRelacionComercial(RelacionComercial entity)
			throws Exception;

	/**
	 * Load an existing RelacionComercial entity
	 * 
	 */
	public RelacionComercial getRelacionComercial(Long idReco) throws Exception;

	public List<RelacionComercial> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<RelacionComercial> findPageRelacionComercial(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberRelacionComercial() throws Exception;

	public List<RelacionComercialDTO> getDataRelacionComercial()
			throws Exception;
}
