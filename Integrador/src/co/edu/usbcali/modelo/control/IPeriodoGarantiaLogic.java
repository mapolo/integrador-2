package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.PeriodoGarantia;
import co.edu.usbcali.modelo.dto.PeriodoGarantiaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IPeriodoGarantiaLogic {
	public List<PeriodoGarantia> getPeriodoGarantia() throws Exception;

	/**
	 * Save an new PeriodoGarantia entity
	 */
	public void savePeriodoGarantia(PeriodoGarantia entity) throws Exception;

	/**
	 * Delete an existing PeriodoGarantia entity
	 * 
	 */
	public void deletePeriodoGarantia(PeriodoGarantia entity) throws Exception;

	/**
	 * Update an existing PeriodoGarantia entity
	 * 
	 */
	public void updatePeriodoGarantia(PeriodoGarantia entity) throws Exception;

	/**
	 * Load an existing PeriodoGarantia entity
	 * 
	 */
	public PeriodoGarantia getPeriodoGarantia(Long idPega) throws Exception;

	public List<PeriodoGarantia> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<PeriodoGarantia> findPagePeriodoGarantia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberPeriodoGarantia() throws Exception;

	public List<PeriodoGarantiaDTO> getDataPeriodoGarantia() throws Exception;
}
