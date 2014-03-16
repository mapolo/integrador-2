package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.DiasSemana;
import co.edu.usbcali.modelo.dto.DiasSemanaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IDiasSemanaLogic {
	public List<DiasSemana> getDiasSemana() throws Exception;

	/**
	 * Save an new DiasSemana entity
	 */
	public void saveDiasSemana(DiasSemana entity) throws Exception;

	/**
	 * Delete an existing DiasSemana entity
	 * 
	 */
	public void deleteDiasSemana(DiasSemana entity) throws Exception;

	/**
	 * Update an existing DiasSemana entity
	 * 
	 */
	public void updateDiasSemana(DiasSemana entity) throws Exception;

	/**
	 * Load an existing DiasSemana entity
	 * 
	 */
	public DiasSemana getDiasSemana(Long idDise) throws Exception;

	public List<DiasSemana> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<DiasSemana> findPageDiasSemana(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberDiasSemana() throws Exception;

	public List<DiasSemanaDTO> getDataDiasSemana() throws Exception;
}
