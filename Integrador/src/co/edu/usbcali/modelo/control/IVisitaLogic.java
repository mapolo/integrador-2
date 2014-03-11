package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.Visita;
import co.edu.usbcali.modelo.dto.VisitaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IVisitaLogic {
	public List<Visita> getVisita() throws Exception;

	/**
	 * Save an new Visita entity
	 */
	public void saveVisita(Visita entity) throws Exception;

	/**
	 * Delete an existing Visita entity
	 * 
	 */
	public void deleteVisita(Visita entity) throws Exception;

	/**
	 * Update an existing Visita entity
	 * 
	 */
	public void updateVisita(Visita entity) throws Exception;

	/**
	 * Load an existing Visita entity
	 * 
	 */
	public Visita getVisita(Long idVisi) throws Exception;

	public List<Visita> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Visita> findPageVisita(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberVisita() throws Exception;

	public List<VisitaDTO> getDataVisita() throws Exception;
}
