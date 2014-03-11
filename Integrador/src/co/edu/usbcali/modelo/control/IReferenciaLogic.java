package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.Referencia;
import co.edu.usbcali.modelo.dto.ReferenciaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IReferenciaLogic {
	public List<Referencia> getReferencia() throws Exception;

	/**
	 * Save an new Referencia entity
	 */
	public void saveReferencia(Referencia entity) throws Exception;

	/**
	 * Delete an existing Referencia entity
	 * 
	 */
	public void deleteReferencia(Referencia entity) throws Exception;

	/**
	 * Update an existing Referencia entity
	 * 
	 */
	public void updateReferencia(Referencia entity) throws Exception;

	/**
	 * Load an existing Referencia entity
	 * 
	 */
	public Referencia getReferencia(Long idRefe) throws Exception;

	public List<Referencia> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<Referencia> findPageReferencia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberReferencia() throws Exception;

	public List<ReferenciaDTO> getDataReferencia() throws Exception;
}
