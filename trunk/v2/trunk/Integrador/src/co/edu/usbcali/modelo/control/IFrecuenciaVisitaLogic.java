package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.FrecuenciaVisita;
import co.edu.usbcali.modelo.dto.FrecuenciaVisitaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IFrecuenciaVisitaLogic {
	public List<FrecuenciaVisita> getFrecuenciaVisita() throws Exception;

	/**
	 * Save an new FrecuenciaVisita entity
	 */
	public void saveFrecuenciaVisita(FrecuenciaVisita entity) throws Exception;

	/**
	 * Delete an existing FrecuenciaVisita entity
	 * 
	 */
	public void deleteFrecuenciaVisita(FrecuenciaVisita entity)
			throws Exception;

	/**
	 * Update an existing FrecuenciaVisita entity
	 * 
	 */
	public void updateFrecuenciaVisita(FrecuenciaVisita entity)
			throws Exception;

	/**
	 * Load an existing FrecuenciaVisita entity
	 * 
	 */
	public FrecuenciaVisita getFrecuenciaVisita(Long idFrvi) throws Exception;

	public List<FrecuenciaVisita> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<FrecuenciaVisita> findPageFrecuenciaVisita(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberFrecuenciaVisita() throws Exception;

	public List<FrecuenciaVisitaDTO> getDataFrecuenciaVisita() throws Exception;
}
