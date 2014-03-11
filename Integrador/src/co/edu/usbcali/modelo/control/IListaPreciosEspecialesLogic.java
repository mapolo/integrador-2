package co.edu.usbcali.modelo.control;

import co.edu.usbcali.modelo.ListaPreciosEspeciales;
import co.edu.usbcali.modelo.dto.ListaPreciosEspecialesDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Zathura Code Generator http://code.google.com/p/zathura
 * 
 */
public interface IListaPreciosEspecialesLogic {
	public List<ListaPreciosEspeciales> getListaPreciosEspeciales()
			throws Exception;

	/**
	 * Save an new ListaPreciosEspeciales entity
	 */
	public void saveListaPreciosEspeciales(ListaPreciosEspeciales entity)
			throws Exception;

	/**
	 * Delete an existing ListaPreciosEspeciales entity
	 * 
	 */
	public void deleteListaPreciosEspeciales(ListaPreciosEspeciales entity)
			throws Exception;

	/**
	 * Update an existing ListaPreciosEspeciales entity
	 * 
	 */
	public void updateListaPreciosEspeciales(ListaPreciosEspeciales entity)
			throws Exception;

	/**
	 * Load an existing ListaPreciosEspeciales entity
	 * 
	 */
	public ListaPreciosEspeciales getListaPreciosEspeciales(Long idLipe)
			throws Exception;

	public List<ListaPreciosEspeciales> findByCriteria(Object[] variables,
			Object[] variablesBetween, Object[] variablesBetweenDates)
			throws Exception;

	public List<ListaPreciosEspeciales> findPageListaPreciosEspeciales(
			String sortColumnName, boolean sortAscending, int startRow,
			int maxResults) throws Exception;

	public Long findTotalNumberListaPreciosEspeciales() throws Exception;

	public List<ListaPreciosEspecialesDTO> getDataListaPreciosEspeciales()
			throws Exception;
}
