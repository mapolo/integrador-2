package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.RboDetalleFormasPago;
import co.edu.usbcali.modelo.dto.RboDetalleFormasPagoDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IRboDetalleFormasPagoLogic {
	public List<RboDetalleFormasPago> getRboDetalleFormasPago()
			throws Exception;

	/**
	 * Save an new RboDetalleFormasPago entity
	 */
	public void saveRboDetalleFormasPago(RboDetalleFormasPago entity)
			throws Exception;

	/**
	 * Delete an existing RboDetalleFormasPago entity
	 * 
	 */
	public void deleteRboDetalleFormasPago(RboDetalleFormasPago entity)
			throws Exception;

	/**
	 * Update an existing RboDetalleFormasPago entity
	 * 
	 */
	public void updateRboDetalleFormasPago(RboDetalleFormasPago entity)
			throws Exception;

	/**
	 * Load an existing RboDetalleFormasPago entity
	 * 
	 */
	public RboDetalleFormasPago getRboDetalleFormasPago(Long idRdfp)
			throws Exception;

	public List<RboDetalleFormasPago> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<RboDetalleFormasPago> findPageRboDetalleFormasPago(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberRboDetalleFormasPago() throws Exception;

	public List<RboDetalleFormasPagoDTO> getDataRboDetalleFormasPago()
			throws Exception;
}
