package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.GrupoReferencia;
import co.edu.usbcali.modelo.dto.GrupoReferenciaDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IGrupoReferenciaLogic {
	public List<GrupoReferencia> getGrupoReferencia() throws Exception;

	/**
	 * Save an new GrupoReferencia entity
	 */
	public void saveGrupoReferencia(GrupoReferencia entity) throws Exception;

	/**
	 * Delete an existing GrupoReferencia entity
	 * 
	 */
	public void deleteGrupoReferencia(GrupoReferencia entity) throws Exception;

	/**
	 * Update an existing GrupoReferencia entity
	 * 
	 */
	public void updateGrupoReferencia(GrupoReferencia entity) throws Exception;

	/**
	 * Load an existing GrupoReferencia entity
	 * 
	 */
	public GrupoReferencia getGrupoReferencia(Long idGrre) throws Exception;

	public List<GrupoReferencia> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<GrupoReferencia> findPageGrupoReferencia(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberGrupoReferencia() throws Exception;

	public List<GrupoReferenciaDTO> getDataGrupoReferencia() throws Exception;
}
