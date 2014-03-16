package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.StockInventarioMensual;
import co.edu.usbcali.modelo.dto.StockInventarioMensualDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IStockInventarioMensualLogic {
	public List<StockInventarioMensual> getStockInventarioMensual()
			throws Exception;

	/**
	 * Save an new StockInventarioMensual entity
	 */
	public void saveStockInventarioMensual(StockInventarioMensual entity)
			throws Exception;

	/**
	 * Delete an existing StockInventarioMensual entity
	 * 
	 */
	public void deleteStockInventarioMensual(StockInventarioMensual entity)
			throws Exception;

	/**
	 * Update an existing StockInventarioMensual entity
	 * 
	 */
	public void updateStockInventarioMensual(StockInventarioMensual entity)
			throws Exception;

	/**
	 * Load an existing StockInventarioMensual entity
	 * 
	 */
	public StockInventarioMensual getStockInventarioMensual(Long idStin)
			throws Exception;

	public List<StockInventarioMensual> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<StockInventarioMensual> findPageStockInventarioMensual(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberStockInventarioMensual() throws Exception;

	public List<StockInventarioMensualDTO> getDataStockInventarioMensual()
			throws Exception;
}
