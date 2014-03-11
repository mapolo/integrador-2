package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.SaldoInicialInventario;
import co.edu.usbcali.modelo.dto.SaldoInicialInventarioDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface ISaldoInicialInventarioLogic {
	public List<SaldoInicialInventario> getSaldoInicialInventario()
			throws Exception;

	/**
	 * Save an new SaldoInicialInventario entity
	 */
	public void saveSaldoInicialInventario(SaldoInicialInventario entity)
			throws Exception;

	/**
	 * Delete an existing SaldoInicialInventario entity
	 * 
	 */
	public void deleteSaldoInicialInventario(SaldoInicialInventario entity)
			throws Exception;

	/**
	 * Update an existing SaldoInicialInventario entity
	 * 
	 */
	public void updateSaldoInicialInventario(SaldoInicialInventario entity)
			throws Exception;

	/**
	 * Load an existing SaldoInicialInventario entity
	 * 
	 */
	public SaldoInicialInventario getSaldoInicialInventario(Long idSini)
			throws Exception;

	public List<SaldoInicialInventario> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<SaldoInicialInventario> findPageSaldoInicialInventario(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberSaldoInicialInventario() throws Exception;

	public List<SaldoInicialInventarioDTO> getDataSaldoInicialInventario()
			throws Exception;
}
