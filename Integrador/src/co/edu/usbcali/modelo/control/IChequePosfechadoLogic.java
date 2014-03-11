package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.ChequePosfechado;
import co.edu.usbcali.modelo.dto.ChequePosfechadoDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IChequePosfechadoLogic {
	public List<ChequePosfechado> getChequePosfechado() throws Exception;

	/**
	 * Save an new ChequePosfechado entity
	 */
	public void saveChequePosfechado(ChequePosfechado entity) throws Exception;

	/**
	 * Delete an existing ChequePosfechado entity
	 * 
	 */
	public void deleteChequePosfechado(ChequePosfechado entity)
			throws Exception;

	/**
	 * Update an existing ChequePosfechado entity
	 * 
	 */
	public void updateChequePosfechado(ChequePosfechado entity)
			throws Exception;

	/**
	 * Load an existing ChequePosfechado entity
	 * 
	 */
	public ChequePosfechado getChequePosfechado(Long idChps) throws Exception;

	public List<ChequePosfechado> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<ChequePosfechado> findPageChequePosfechado(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberChequePosfechado() throws Exception;

	public List<ChequePosfechadoDTO> getDataChequePosfechado() throws Exception;
}
