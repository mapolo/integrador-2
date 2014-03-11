package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.DivisionPolitica;
import co.edu.usbcali.modelo.dto.DivisionPoliticaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IDivisionPoliticaLogic {
	public List<DivisionPolitica> getDivisionPolitica() throws Exception;

	/**
	 * Save an new DivisionPolitica entity
	 */
	public void saveDivisionPolitica(DivisionPolitica entity) throws Exception;

	/**
	 * Delete an existing DivisionPolitica entity
	 * 
	 */
	public void deleteDivisionPolitica(DivisionPolitica entity)
			throws Exception;

	/**
	 * Update an existing DivisionPolitica entity
	 * 
	 */
	public void updateDivisionPolitica(DivisionPolitica entity)
			throws Exception;

	/**
	 * Load an existing DivisionPolitica entity
	 * 
	 */
	public DivisionPolitica getDivisionPolitica(Long idDipo) throws Exception;

	public List<DivisionPolitica> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<DivisionPolitica> findPageDivisionPolitica(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberDivisionPolitica() throws Exception;

	public List<DivisionPoliticaDTO> getDataDivisionPolitica() throws Exception;
}
