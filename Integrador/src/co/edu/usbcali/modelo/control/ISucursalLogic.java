package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.Sucursal;
import co.edu.usbcali.modelo.dto.SucursalDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface ISucursalLogic {
	public List<Sucursal> getSucursal() throws Exception;

	/**
	 * Save an new Sucursal entity
	 */
	public void saveSucursal(Sucursal entity) throws Exception;

	/**
	 * Delete an existing Sucursal entity
	 * 
	 */
	public void deleteSucursal(Sucursal entity) throws Exception;

	/**
	 * Update an existing Sucursal entity
	 * 
	 */
	public void updateSucursal(Sucursal entity) throws Exception;

	/**
	 * Load an existing Sucursal entity
	 * 
	 */
	public Sucursal getSucursal(Long idSucu) throws Exception;

	public List<Sucursal> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Sucursal> findPageSucursal(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberSucursal() throws Exception;

	public List<SucursalDTO> getDataSucursal() throws Exception;
}
