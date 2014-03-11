package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.Familia;
import co.edu.usbcali.modelo.dto.FamiliaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IFamiliaLogic {
	public List<Familia> getFamilia() throws Exception;

	/**
	 * Save an new Familia entity
	 */
	public void saveFamilia(Familia entity) throws Exception;

	/**
	 * Delete an existing Familia entity
	 * 
	 */
	public void deleteFamilia(Familia entity) throws Exception;

	/**
	 * Update an existing Familia entity
	 * 
	 */
	public void updateFamilia(Familia entity) throws Exception;

	/**
	 * Load an existing Familia entity
	 * 
	 */
	public Familia getFamilia(Long idFlia) throws Exception;

	public List<Familia> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Familia> findPageFamilia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberFamilia() throws Exception;

	public List<FamiliaDTO> getDataFamilia() throws Exception;
}
