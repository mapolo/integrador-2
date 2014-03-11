package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.Vendedor;
import co.edu.usbcali.modelo.dto.VendedorDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IVendedorLogic {
	public List<Vendedor> getVendedor() throws Exception;

	/**
	 * Save an new Vendedor entity
	 */
	public void saveVendedor(Vendedor entity) throws Exception;

	/**
	 * Delete an existing Vendedor entity
	 * 
	 */
	public void deleteVendedor(Vendedor entity) throws Exception;

	/**
	 * Update an existing Vendedor entity
	 * 
	 */
	public void updateVendedor(Vendedor entity) throws Exception;

	/**
	 * Load an existing Vendedor entity
	 * 
	 */
	public Vendedor getVendedor(Long idVend) throws Exception;

	public List<Vendedor> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Vendedor> findPageVendedor(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberVendedor() throws Exception;

	public List<VendedorDTO> getDataVendedor() throws Exception;
}
