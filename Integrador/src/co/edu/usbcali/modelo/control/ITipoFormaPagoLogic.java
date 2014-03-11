package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.TipoFormaPago;
import co.edu.usbcali.modelo.dto.TipoFormaPagoDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface ITipoFormaPagoLogic {
	public List<TipoFormaPago> getTipoFormaPago() throws Exception;

	/**
	 * Save an new TipoFormaPago entity
	 */
	public void saveTipoFormaPago(TipoFormaPago entity) throws Exception;

	/**
	 * Delete an existing TipoFormaPago entity
	 * 
	 */
	public void deleteTipoFormaPago(TipoFormaPago entity) throws Exception;

	/**
	 * Update an existing TipoFormaPago entity
	 * 
	 */
	public void updateTipoFormaPago(TipoFormaPago entity) throws Exception;

	/**
	 * Load an existing TipoFormaPago entity
	 * 
	 */
	public TipoFormaPago getTipoFormaPago(Long idTfpa) throws Exception;

	public List<TipoFormaPago> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<TipoFormaPago> findPageTipoFormaPago(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipoFormaPago() throws Exception;

	public List<TipoFormaPagoDTO> getDataTipoFormaPago() throws Exception;
}
