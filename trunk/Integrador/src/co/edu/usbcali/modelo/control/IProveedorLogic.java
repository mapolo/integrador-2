package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.Proveedor;
import co.edu.usbcali.modelo.dto.ProveedorDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IProveedorLogic {
	public List<Proveedor> getProveedor() throws Exception;

	/**
	 * Save an new Proveedor entity
	 */
	public void saveProveedor(Proveedor entity) throws Exception;

	/**
	 * Delete an existing Proveedor entity
	 * 
	 */
	public void deleteProveedor(Proveedor entity) throws Exception;

	/**
	 * Update an existing Proveedor entity
	 * 
	 */
	public void updateProveedor(Proveedor entity) throws Exception;

	/**
	 * Load an existing Proveedor entity
	 * 
	 */
	public Proveedor getProveedor(Long idProv) throws Exception;

	public List<Proveedor> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Proveedor> findPageProveedor(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberProveedor() throws Exception;

	public List<ProveedorDTO> getDataProveedor() throws Exception;
}
