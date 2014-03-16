package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.ConfSemanasAno;
import co.edu.usbcali.modelo.dto.ConfSemanasAnoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IConfSemanasAnoLogic {
	public List<ConfSemanasAno> getConfSemanasAno() throws Exception;

	/**
	 * Save an new ConfSemanasAno entity
	 */
	public void saveConfSemanasAno(ConfSemanasAno entity) throws Exception;

	/**
	 * Delete an existing ConfSemanasAno entity
	 * 
	 */
	public void deleteConfSemanasAno(ConfSemanasAno entity) throws Exception;

	/**
	 * Update an existing ConfSemanasAno entity
	 * 
	 */
	public void updateConfSemanasAno(ConfSemanasAno entity) throws Exception;

	/**
	 * Load an existing ConfSemanasAno entity
	 * 
	 */
	public ConfSemanasAno getConfSemanasAno(Long idCfsa) throws Exception;

	public List<ConfSemanasAno> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<ConfSemanasAno> findPageConfSemanasAno(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberConfSemanasAno() throws Exception;

	public List<ConfSemanasAnoDTO> getDataConfSemanasAno() throws Exception;
}
