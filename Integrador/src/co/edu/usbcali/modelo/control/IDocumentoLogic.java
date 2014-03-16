package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.Documento;
import co.edu.usbcali.modelo.dto.DocumentoDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IDocumentoLogic {
	public List<Documento> getDocumento() throws Exception;

	/**
	 * Save an new Documento entity
	 */
	public void saveDocumento(Documento entity) throws Exception;

	/**
	 * Delete an existing Documento entity
	 * 
	 */
	public void deleteDocumento(Documento entity) throws Exception;

	/**
	 * Update an existing Documento entity
	 * 
	 */
	public void updateDocumento(Documento entity) throws Exception;

	/**
	 * Load an existing Documento entity
	 * 
	 */
	public Documento getDocumento(Long idDocu) throws Exception;

	public List<Documento> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Documento> findPageDocumento(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberDocumento() throws Exception;

	public List<DocumentoDTO> getDataDocumento() throws Exception;
}
