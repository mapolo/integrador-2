package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.ItemLogisticaReversiva;
import co.edu.usbcali.modelo.dto.ItemLogisticaReversivaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IItemLogisticaReversivaLogic {
	public List<ItemLogisticaReversiva> getItemLogisticaReversiva()
			throws Exception;

	/**
	 * Save an new ItemLogisticaReversiva entity
	 */
	public void saveItemLogisticaReversiva(ItemLogisticaReversiva entity)
			throws Exception;

	/**
	 * Delete an existing ItemLogisticaReversiva entity
	 * 
	 */
	public void deleteItemLogisticaReversiva(ItemLogisticaReversiva entity)
			throws Exception;

	/**
	 * Update an existing ItemLogisticaReversiva entity
	 * 
	 */
	public void updateItemLogisticaReversiva(ItemLogisticaReversiva entity)
			throws Exception;

	/**
	 * Load an existing ItemLogisticaReversiva entity
	 * 
	 */
	public ItemLogisticaReversiva getItemLogisticaReversiva(Long idItlr)
			throws Exception;

	public List<ItemLogisticaReversiva> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<ItemLogisticaReversiva> findPageItemLogisticaReversiva(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberItemLogisticaReversiva() throws Exception;

	public List<ItemLogisticaReversivaDTO> getDataItemLogisticaReversiva()
			throws Exception;
}
