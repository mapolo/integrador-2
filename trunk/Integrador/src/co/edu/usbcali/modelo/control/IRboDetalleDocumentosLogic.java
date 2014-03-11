package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.RboDetalleDocumentos;
import co.edu.usbcali.modelo.dto.RboDetalleDocumentosDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IRboDetalleDocumentosLogic {
	public List<RboDetalleDocumentos> getRboDetalleDocumentos()
			throws Exception;

	/**
	 * Save an new RboDetalleDocumentos entity
	 */
	public void saveRboDetalleDocumentos(RboDetalleDocumentos entity)
			throws Exception;

	/**
	 * Delete an existing RboDetalleDocumentos entity
	 * 
	 */
	public void deleteRboDetalleDocumentos(RboDetalleDocumentos entity)
			throws Exception;

	/**
	 * Update an existing RboDetalleDocumentos entity
	 * 
	 */
	public void updateRboDetalleDocumentos(RboDetalleDocumentos entity)
			throws Exception;

	/**
	 * Load an existing RboDetalleDocumentos entity
	 * 
	 */
	public RboDetalleDocumentos getRboDetalleDocumentos(Long idRddo)
			throws Exception;

	public List<RboDetalleDocumentos> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<RboDetalleDocumentos> findPageRboDetalleDocumentos(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberRboDetalleDocumentos() throws Exception;

	public List<RboDetalleDocumentosDTO> getDataRboDetalleDocumentos()
			throws Exception;
}
