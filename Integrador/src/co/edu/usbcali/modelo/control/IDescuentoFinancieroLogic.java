package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.DescuentoFinanciero;
import co.edu.usbcali.modelo.dto.DescuentoFinancieroDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IDescuentoFinancieroLogic {
	public List<DescuentoFinanciero> getDescuentoFinanciero() throws Exception;

	/**
	 * Save an new DescuentoFinanciero entity
	 */
	public void saveDescuentoFinanciero(DescuentoFinanciero entity)
			throws Exception;

	/**
	 * Delete an existing DescuentoFinanciero entity
	 * 
	 */
	public void deleteDescuentoFinanciero(DescuentoFinanciero entity)
			throws Exception;

	/**
	 * Update an existing DescuentoFinanciero entity
	 * 
	 */
	public void updateDescuentoFinanciero(DescuentoFinanciero entity)
			throws Exception;

	/**
	 * Load an existing DescuentoFinanciero entity
	 * 
	 */
	public DescuentoFinanciero getDescuentoFinanciero(Long idDefi)
			throws Exception;

	public List<DescuentoFinanciero> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<DescuentoFinanciero> findPageDescuentoFinanciero(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDescuentoFinanciero() throws Exception;

	public List<DescuentoFinancieroDTO> getDataDescuentoFinanciero()
			throws Exception;
}
