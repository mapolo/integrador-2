package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.PronosticoVenta;
import co.edu.usbcali.modelo.dto.PronosticoVentaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IPronosticoVentaLogic {
	public List<PronosticoVenta> getPronosticoVenta() throws Exception;

	/**
	 * Save an new PronosticoVenta entity
	 */
	public void savePronosticoVenta(PronosticoVenta entity) throws Exception;

	/**
	 * Delete an existing PronosticoVenta entity
	 * 
	 */
	public void deletePronosticoVenta(PronosticoVenta entity) throws Exception;

	/**
	 * Update an existing PronosticoVenta entity
	 * 
	 */
	public void updatePronosticoVenta(PronosticoVenta entity) throws Exception;

	/**
	 * Load an existing PronosticoVenta entity
	 * 
	 */
	public PronosticoVenta getPronosticoVenta(Long idPtcv) throws Exception;

	public List<PronosticoVenta> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<PronosticoVenta> findPagePronosticoVenta(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberPronosticoVenta() throws Exception;

	public List<PronosticoVentaDTO> getDataPronosticoVenta() throws Exception;
}
