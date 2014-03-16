package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.TipoLista;
import co.edu.usbcali.modelo.dto.TipoListaDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface ITipoListaLogic {
	public List<TipoLista> getTipoLista() throws Exception;

	/**
	 * Save an new TipoLista entity
	 */
	public void saveTipoLista(TipoLista entity) throws Exception;

	/**
	 * Delete an existing TipoLista entity
	 * 
	 */
	public void deleteTipoLista(TipoLista entity) throws Exception;

	/**
	 * Update an existing TipoLista entity
	 * 
	 */
	public void updateTipoLista(TipoLista entity) throws Exception;

	/**
	 * Load an existing TipoLista entity
	 * 
	 */
	public TipoLista getTipoLista(Long idTili) throws Exception;

	public List<TipoLista> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<TipoLista> findPageTipoLista(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberTipoLista() throws Exception;

	public List<TipoListaDTO> getDataTipoLista() throws Exception;
}
