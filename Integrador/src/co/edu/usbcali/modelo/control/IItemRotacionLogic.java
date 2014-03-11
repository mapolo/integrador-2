package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.ItemRotacion;
import co.edu.usbcali.modelo.dto.ItemRotacionDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IItemRotacionLogic {
	public List<ItemRotacion> getItemRotacion() throws Exception;

	/**
	 * Save an new ItemRotacion entity
	 */
	public void saveItemRotacion(ItemRotacion entity) throws Exception;

	/**
	 * Delete an existing ItemRotacion entity
	 * 
	 */
	public void deleteItemRotacion(ItemRotacion entity) throws Exception;

	/**
	 * Update an existing ItemRotacion entity
	 * 
	 */
	public void updateItemRotacion(ItemRotacion entity) throws Exception;

	/**
	 * Load an existing ItemRotacion entity
	 * 
	 */
	public ItemRotacion getItemRotacion(Long idItro) throws Exception;

	public List<ItemRotacion> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<ItemRotacion> findPageItemRotacion(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberItemRotacion() throws Exception;

	public List<ItemRotacionDTO> getDataItemRotacion() throws Exception;
}
