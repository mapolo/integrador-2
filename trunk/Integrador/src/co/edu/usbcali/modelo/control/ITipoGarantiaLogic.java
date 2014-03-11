package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.TipoGarantia;
import co.edu.usbcali.modelo.dto.TipoGarantiaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface ITipoGarantiaLogic {
	public List<TipoGarantia> getTipoGarantia() throws Exception;

	/**
	 * Save an new TipoGarantia entity
	 */
	public void saveTipoGarantia(TipoGarantia entity) throws Exception;

	/**
	 * Delete an existing TipoGarantia entity
	 * 
	 */
	public void deleteTipoGarantia(TipoGarantia entity) throws Exception;

	/**
	 * Update an existing TipoGarantia entity
	 * 
	 */
	public void updateTipoGarantia(TipoGarantia entity) throws Exception;

	/**
	 * Load an existing TipoGarantia entity
	 * 
	 */
	public TipoGarantia getTipoGarantia(Long idTiga) throws Exception;

	public List<TipoGarantia> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<TipoGarantia> findPageTipoGarantia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipoGarantia() throws Exception;

	public List<TipoGarantiaDTO> getDataTipoGarantia() throws Exception;
}
