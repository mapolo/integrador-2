package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.OrdenesDeCompra;
import co.edu.usbcali.modelo.dto.OrdenesDeCompraDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IOrdenesDeCompraLogic {
	public List<OrdenesDeCompra> getOrdenesDeCompra() throws Exception;

	/**
	 * Save an new OrdenesDeCompra entity
	 */
	public void saveOrdenesDeCompra(OrdenesDeCompra entity) throws Exception;

	/**
	 * Delete an existing OrdenesDeCompra entity
	 * 
	 */
	public void deleteOrdenesDeCompra(OrdenesDeCompra entity) throws Exception;

	/**
	 * Update an existing OrdenesDeCompra entity
	 * 
	 */
	public void updateOrdenesDeCompra(OrdenesDeCompra entity) throws Exception;

	/**
	 * Load an existing OrdenesDeCompra entity
	 * 
	 */
	public OrdenesDeCompra getOrdenesDeCompra(Long idOrdc) throws Exception;

	public List<OrdenesDeCompra> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<OrdenesDeCompra> findPageOrdenesDeCompra(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberOrdenesDeCompra() throws Exception;

	public List<OrdenesDeCompraDTO> getDataOrdenesDeCompra() throws Exception;
}
