package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.LogisticaReversiva;
import co.edu.usbcali.modelo.dto.LogisticaReversivaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface ILogisticaReversivaLogic {
	public List<LogisticaReversiva> getLogisticaReversiva() throws Exception;

	/**
	 * Save an new LogisticaReversiva entity
	 */
	public void saveLogisticaReversiva(LogisticaReversiva entity)
			throws Exception;

	/**
	 * Delete an existing LogisticaReversiva entity
	 * 
	 */
	public void deleteLogisticaReversiva(LogisticaReversiva entity)
			throws Exception;

	/**
	 * Update an existing LogisticaReversiva entity
	 * 
	 */
	public void updateLogisticaReversiva(LogisticaReversiva entity)
			throws Exception;

	/**
	 * Load an existing LogisticaReversiva entity
	 * 
	 */
	public LogisticaReversiva getLogisticaReversiva(Long idLore)
			throws Exception;

	public List<LogisticaReversiva> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<LogisticaReversiva> findPageLogisticaReversiva(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberLogisticaReversiva() throws Exception;

	public List<LogisticaReversivaDTO> getDataLogisticaReversiva()
			throws Exception;
}
