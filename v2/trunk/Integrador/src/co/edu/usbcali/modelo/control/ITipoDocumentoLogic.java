package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.TipoDocumento;
import co.edu.usbcali.modelo.dto.TipoDocumentoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface ITipoDocumentoLogic {
	public List<TipoDocumento> getTipoDocumento() throws Exception;

	/**
	 * Save an new TipoDocumento entity
	 */
	public void saveTipoDocumento(TipoDocumento entity) throws Exception;

	/**
	 * Delete an existing TipoDocumento entity
	 * 
	 */
	public void deleteTipoDocumento(TipoDocumento entity) throws Exception;

	/**
	 * Update an existing TipoDocumento entity
	 * 
	 */
	public void updateTipoDocumento(TipoDocumento entity) throws Exception;

	/**
	 * Load an existing TipoDocumento entity
	 * 
	 */
	public TipoDocumento getTipoDocumento(Long idTido) throws Exception;

	public List<TipoDocumento> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<TipoDocumento> findPageTipoDocumento(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipoDocumento() throws Exception;

	public List<TipoDocumentoDTO> getDataTipoDocumento() throws Exception;
}
