package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.UnidadNegocio;
import co.edu.usbcali.modelo.dto.UnidadNegocioDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IUnidadNegocioLogic {
	public List<UnidadNegocio> getUnidadNegocio() throws Exception;

	/**
	 * Save an new UnidadNegocio entity
	 */
	public void saveUnidadNegocio(UnidadNegocio entity) throws Exception;

	/**
	 * Delete an existing UnidadNegocio entity
	 * 
	 */
	public void deleteUnidadNegocio(UnidadNegocio entity) throws Exception;

	/**
	 * Update an existing UnidadNegocio entity
	 * 
	 */
	public void updateUnidadNegocio(UnidadNegocio entity) throws Exception;

	/**
	 * Load an existing UnidadNegocio entity
	 * 
	 */
	public UnidadNegocio getUnidadNegocio(Long idUnne) throws Exception;

	public List<UnidadNegocio> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<UnidadNegocio> findPageUnidadNegocio(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberUnidadNegocio() throws Exception;

	public List<UnidadNegocioDTO> getDataUnidadNegocio() throws Exception;
}
