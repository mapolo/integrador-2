package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.EstadoDocumento;
import co.edu.usbcali.modelo.dto.EstadoDocumentoDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IEstadoDocumentoLogic {
	public List<EstadoDocumento> getEstadoDocumento() throws Exception;

	/**
	 * Save an new EstadoDocumento entity
	 */
	public void saveEstadoDocumento(EstadoDocumento entity) throws Exception;

	/**
	 * Delete an existing EstadoDocumento entity
	 * 
	 */
	public void deleteEstadoDocumento(EstadoDocumento entity) throws Exception;

	/**
	 * Update an existing EstadoDocumento entity
	 * 
	 */
	public void updateEstadoDocumento(EstadoDocumento entity) throws Exception;

	/**
	 * Load an existing EstadoDocumento entity
	 * 
	 */
	public EstadoDocumento getEstadoDocumento(Long idEsdo) throws Exception;

	public List<EstadoDocumento> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<EstadoDocumento> findPageEstadoDocumento(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberEstadoDocumento() throws Exception;

	public List<EstadoDocumentoDTO> getDataEstadoDocumento() throws Exception;
}
