package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.Multifamilia;
import co.edu.usbcali.modelo.dto.MultifamiliaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IMultifamiliaLogic {
	public List<Multifamilia> getMultifamilia() throws Exception;

	/**
	 * Save an new Multifamilia entity
	 */
	public void saveMultifamilia(Multifamilia entity) throws Exception;

	/**
	 * Delete an existing Multifamilia entity
	 * 
	 */
	public void deleteMultifamilia(Multifamilia entity) throws Exception;

	/**
	 * Update an existing Multifamilia entity
	 * 
	 */
	public void updateMultifamilia(Multifamilia entity) throws Exception;

	/**
	 * Load an existing Multifamilia entity
	 * 
	 */
	public Multifamilia getMultifamilia(Long idMufa) throws Exception;

	public List<Multifamilia> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Multifamilia> findPageMultifamilia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberMultifamilia() throws Exception;

	public List<MultifamiliaDTO> getDataMultifamilia() throws Exception;
}
