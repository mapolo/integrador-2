package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.FrecuenciaSemana;
import co.edu.usbcali.modelo.dto.FrecuenciaSemanaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IFrecuenciaSemanaLogic {
	public List<FrecuenciaSemana> getFrecuenciaSemana() throws Exception;

	/**
	 * Save an new FrecuenciaSemana entity
	 */
	public void saveFrecuenciaSemana(FrecuenciaSemana entity) throws Exception;

	/**
	 * Delete an existing FrecuenciaSemana entity
	 * 
	 */
	public void deleteFrecuenciaSemana(FrecuenciaSemana entity)
			throws Exception;

	/**
	 * Update an existing FrecuenciaSemana entity
	 * 
	 */
	public void updateFrecuenciaSemana(FrecuenciaSemana entity)
			throws Exception;

	/**
	 * Load an existing FrecuenciaSemana entity
	 * 
	 */
	public FrecuenciaSemana getFrecuenciaSemana(Long idFrcr) throws Exception;

	public List<FrecuenciaSemana> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<FrecuenciaSemana> findPageFrecuenciaSemana(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberFrecuenciaSemana() throws Exception;

	public List<FrecuenciaSemanaDTO> getDataFrecuenciaSemana() throws Exception;
}
