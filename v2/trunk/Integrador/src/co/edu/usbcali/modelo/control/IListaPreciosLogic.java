package co.edu.usbcali.modelo.control;

import java.util.List;

import co.edu.usbcali.modelo.ListaPrecios;
import co.edu.usbcali.modelo.dto.ListaPreciosDTO;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IListaPreciosLogic {
	public List<ListaPrecios> getListaPrecios() throws Exception;

	/**
	 * Save an new ListaPrecios entity
	 */
	public void saveListaPrecios(ListaPrecios entity) throws Exception;

	/**
	 * Delete an existing ListaPrecios entity
	 * 
	 */
	public void deleteListaPrecios(ListaPrecios entity) throws Exception;

	/**
	 * Update an existing ListaPrecios entity
	 * 
	 */
	public void updateListaPrecios(ListaPrecios entity) throws Exception;

	/**
	 * Load an existing ListaPrecios entity
	 * 
	 */
	public ListaPrecios getListaPrecios(Long idLipr) throws Exception;

	public List<ListaPrecios> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<ListaPrecios> findPageListaPrecios(String sortColumnName,
			boolean sortAscending, int startRow, int maxResults)
			throws Exception;

	public Long findTotalNumberListaPrecios() throws Exception;

	public List<ListaPreciosDTO> getDataListaPrecios() throws Exception;
}
