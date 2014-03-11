package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.MovimientoInventario;
import co.edu.usbcali.modelo.dto.MovimientoInventarioDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IMovimientoInventarioLogic {
	public List<MovimientoInventario> getMovimientoInventario()
			throws Exception;

	/**
	 * Save an new MovimientoInventario entity
	 */
	public void saveMovimientoInventario(MovimientoInventario entity)
			throws Exception;

	/**
	 * Delete an existing MovimientoInventario entity
	 * 
	 */
	public void deleteMovimientoInventario(MovimientoInventario entity)
			throws Exception;

	/**
	 * Update an existing MovimientoInventario entity
	 * 
	 */
	public void updateMovimientoInventario(MovimientoInventario entity)
			throws Exception;

	/**
	 * Load an existing MovimientoInventario entity
	 * 
	 */
	public MovimientoInventario getMovimientoInventario(Long idMoin)
			throws Exception;

	public List<MovimientoInventario> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<MovimientoInventario> findPageMovimientoInventario(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberMovimientoInventario() throws Exception;

	public List<MovimientoInventarioDTO> getDataMovimientoInventario()
			throws Exception;
}
