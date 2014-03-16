package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.DescuentoComercial;
import co.edu.usbcali.modelo.dto.DescuentoComercialDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IDescuentoComercialLogic {
	public List<DescuentoComercial> getDescuentoComercial() throws Exception;

	/**
	 * Save an new DescuentoComercial entity
	 */
	public void saveDescuentoComercial(DescuentoComercial entity)
			throws Exception;

	/**
	 * Delete an existing DescuentoComercial entity
	 * 
	 */
	public void deleteDescuentoComercial(DescuentoComercial entity)
			throws Exception;

	/**
	 * Update an existing DescuentoComercial entity
	 * 
	 */
	public void updateDescuentoComercial(DescuentoComercial entity)
			throws Exception;

	/**
	 * Load an existing DescuentoComercial entity
	 * 
	 */
	public DescuentoComercial getDescuentoComercial(Long idDeco)
			throws Exception;

	public List<DescuentoComercial> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<DescuentoComercial> findPageDescuentoComercial(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDescuentoComercial() throws Exception;

	public List<DescuentoComercialDTO> getDataDescuentoComercial()
			throws Exception;
}
