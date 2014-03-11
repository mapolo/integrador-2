package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.ClavesParaRotar;
import co.edu.usbcali.modelo.dto.ClavesParaRotarDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IClavesParaRotarLogic {
	public List<ClavesParaRotar> getClavesParaRotar() throws Exception;

	/**
	 * Save an new ClavesParaRotar entity
	 */
	public void saveClavesParaRotar(ClavesParaRotar entity) throws Exception;

	/**
	 * Delete an existing ClavesParaRotar entity
	 * 
	 */
	public void deleteClavesParaRotar(ClavesParaRotar entity) throws Exception;

	/**
	 * Update an existing ClavesParaRotar entity
	 * 
	 */
	public void updateClavesParaRotar(ClavesParaRotar entity) throws Exception;

	/**
	 * Load an existing ClavesParaRotar entity
	 * 
	 */
	public ClavesParaRotar getClavesParaRotar(Long idClpr) throws Exception;

	public List<ClavesParaRotar> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<ClavesParaRotar> findPageClavesParaRotar(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberClavesParaRotar() throws Exception;

	public List<ClavesParaRotarDTO> getDataClavesParaRotar() throws Exception;
}
