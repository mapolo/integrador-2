package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.ConsecutivoDocumento;
import co.edu.usbcali.modelo.dto.ConsecutivoDocumentoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IConsecutivoDocumentoLogic {
	public List<ConsecutivoDocumento> getConsecutivoDocumento()
			throws Exception;

	/**
	 * Save an new ConsecutivoDocumento entity
	 */
	public void saveConsecutivoDocumento(ConsecutivoDocumento entity)
			throws Exception;

	/**
	 * Delete an existing ConsecutivoDocumento entity
	 * 
	 */
	public void deleteConsecutivoDocumento(ConsecutivoDocumento entity)
			throws Exception;

	/**
	 * Update an existing ConsecutivoDocumento entity
	 * 
	 */
	public void updateConsecutivoDocumento(ConsecutivoDocumento entity)
			throws Exception;

	/**
	 * Load an existing ConsecutivoDocumento entity
	 * 
	 */
	public ConsecutivoDocumento getConsecutivoDocumento(Long idCodo)
			throws Exception;

	public List<ConsecutivoDocumento> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<ConsecutivoDocumento> findPageConsecutivoDocumento(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberConsecutivoDocumento() throws Exception;

	public List<ConsecutivoDocumentoDTO> getDataConsecutivoDocumento()
			throws Exception;
}
