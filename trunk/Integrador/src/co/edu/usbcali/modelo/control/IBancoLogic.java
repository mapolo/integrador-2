package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.Banco;
import co.edu.usbcali.modelo.dto.BancoDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IBancoLogic {
	public List<Banco> getBanco() throws Exception;

	/**
	 * Save an new Banco entity
	 */
	public void saveBanco(Banco entity) throws Exception;

	/**
	 * Delete an existing Banco entity
	 * 
	 */
	public void deleteBanco(Banco entity) throws Exception;

	/**
	 * Update an existing Banco entity
	 * 
	 */
	public void updateBanco(Banco entity) throws Exception;

	/**
	 * Load an existing Banco entity
	 * 
	 */
	public Banco getBanco(Long idBanc) throws Exception;

	public List<Banco> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Banco> findPageBanco(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberBanco() throws Exception;

	public List<BancoDTO> getDataBanco() throws Exception;
}
